package com.tencent.mobileqq.portal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import jmk;
import jml;
import jmm;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;

public class PortalManager
  implements Handler.Callback, INetEngine.INetEngineListener, Manager, BusinessObserver
{
  private static final int jdField_A_of_type_Int = 6;
  static final String jdField_A_of_type_JavaLangString = "AwardWording";
  private static final int jdField_B_of_type_Int = 10;
  static final String jdField_B_of_type_JavaLangString = "AwardOverWording";
  private static final int jdField_C_of_type_Int = 100;
  static final String jdField_C_of_type_JavaLangString = "TimeWording";
  static final String D = "Title";
  static final String E = "Summary";
  static final String F = "WebLogo";
  static final String G = "WebComName";
  static final String H = "WebLogoJump";
  static final String I = "WebGreetings";
  static final String J = "WebAwardOver";
  public static final String K = "hb_icon_path";
  public static final String L = "hb_banner_path";
  public static final String M = "hb_packet_path";
  public static final String N = "hb_b_logo_path";
  public static final String O = "hb_l_logo_path";
  private static final String P = "等待也是一种美德，再试一次吧";
  private static final String Q = "$last$";
  private static final String R = File.separator + "redPacketRes/";
  private static final String S = "red_packet_config";
  private static final String T = "key_portal_ct";
  private static final float jdField_a_of_type_Float = 1048576.0F;
  public static final int a = 1;
  private static PortalManager.TimerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig;
  protected static INetEngine.IBreakDownFix a;
  public static final String a = "PortalManager";
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static Comparator jdField_a_of_type_JavaUtilComparator;
  public static final int b = 2;
  public static long b = 0L;
  static final String jdField_b_of_type_JavaLangString = "HappyFestival";
  public static final int c = 3;
  public static long c = 0L;
  static final String c = "ConfigId";
  public static final int d = 4;
  static final String jdField_d_of_type_JavaLangString = "Img";
  protected static final int e = 0;
  private static final long jdField_e_of_type_Long = 60000L;
  static final String jdField_e_of_type_JavaLangString = "Md5";
  protected static final int f = 1;
  private static long jdField_f_of_type_Long = 0L;
  static final String jdField_f_of_type_JavaLangString = "BBanner";
  protected static final int g = 2;
  static final String g = "Id";
  protected static final int h = 3;
  static final String h = "Begin";
  public static final int i = 1;
  static final String i = "End";
  public static final int j = 2;
  static final String j = "PortalJumpH5";
  public static final int k = 4;
  static final String k = "IconFile";
  public static final int l = 7;
  static final String l = "Wording";
  public static final int m = 7;
  static final String m = "HitWording";
  private static final int jdField_n_of_type_Int = 10001;
  static final String jdField_n_of_type_JavaLangString = "Running";
  private static final int jdField_o_of_type_Int = 10002;
  static final String jdField_o_of_type_JavaLangString = "Stopped";
  private static final int jdField_p_of_type_Int = 1000;
  static final String jdField_p_of_type_JavaLangString = "Activity";
  private static final int jdField_q_of_type_Int = 0;
  static final String jdField_q_of_type_JavaLangString = "AwardFile";
  private static final int jdField_r_of_type_Int = 1;
  static final String jdField_r_of_type_JavaLangString = "AwardJumpH5";
  private static final int jdField_s_of_type_Int = 0;
  static final String jdField_s_of_type_JavaLangString = "JumpH5";
  private static final int jdField_t_of_type_Int = 1;
  static final String jdField_t_of_type_JavaLangString = "DelayTime";
  private static final int jdField_u_of_type_Int = 2;
  static final String jdField_u_of_type_JavaLangString = "IconImg";
  private static final int jdField_v_of_type_Int = 3;
  static final String jdField_v_of_type_JavaLangString = "IconMd5";
  private static final int jdField_w_of_type_Int = 1;
  static final String jdField_w_of_type_JavaLangString = "LogoImg";
  private static final int jdField_x_of_type_Int = 2;
  static final String jdField_x_of_type_JavaLangString = "LogoMd5";
  private static final int jdField_y_of_type_Int = 3;
  static final String jdField_y_of_type_JavaLangString = "TipsImg";
  private static final int jdField_z_of_type_Int = 5;
  static final String jdField_z_of_type_JavaLangString = "TipsMd5";
  public volatile long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public volatile SharedPreferences a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PortalManager.BannerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  public PortalManager.RedPacketConfig a;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  jmm jdField_a_of_type_Jmm;
  private boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private PortalManager.BannerConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalManager.PortalConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  private long jdField_d_of_type_Long;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new jmk();
    jdField_a_of_type_JavaUtilComparator = new jml();
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig = new PortalManager.TimerConfig(null);
    jdField_a_of_type_JavaTextSimpleDateFormat = null;
    jdField_b_of_type_Long = 0L;
    c = 0L;
    f = 0L;
  }
  
  public PortalManager(QQAppInterface paramQQAppInterface)
  {
    this.d = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    this.jdField_a_of_type_Jmm = new jmm(this, null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(this.jdField_a_of_type_Jmm, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.msg.permission.pushnotify2", null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("PortalManager", 1, "", paramQQAppInterface);
      }
    }
  }
  
  static long a(String paramString)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l1 = -1L;
    try
    {
      long l2 = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PortalManager", 2, "", paramString);
    }
    return l1;
    return -1L;
  }
  
  public static Bitmap a(String paramString1, String paramString2)
  {
    String str2 = BaseApplicationImpl.a().getFilesDir() + R;
    Object localObject2;
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return a(paramString2, true);
      }
      str1 = "red_packet_" + paramString1;
      localObject1 = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str1);
      localObject2 = localObject1;
      if (localObject1 != null) {
        return localObject2;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        String str1;
        label103:
        Object localObject1 = null;
      }
    }
    try
    {
      paramString1 = BitmapFactory.decodeFile(str2 + paramString1);
      if (paramString1 != null)
      {
        localObject1 = paramString1;
        BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str1, paramString1);
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("PortalManager", 2, "", paramString1);
        return localObject1;
      }
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PortalManager", 2, "", paramString1);
      }
      paramString1 = null;
      break label103;
      localObject1 = paramString1;
      paramString1 = a(paramString2, true);
      return paramString1;
    }
    return localObject2;
  }
  
  private static Bitmap a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = (Bitmap)BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("red_packet_" + paramString);
        if (localBitmap != null)
        {
          localObject = localBitmap;
          return localObject;
        }
        localObject = localBitmap;
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          localObject = localBitmap;
          if (!"hb_icon_path".equals(paramString)) {
            continue;
          }
          i1 = 2130840343;
          localObject = localBitmap;
          localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i1);
          localObject = localBitmap;
          if (localBitmap == null) {
            continue;
          }
          localObject = localBitmap;
          if (!paramBoolean) {
            continue;
          }
          localObject = localBitmap;
          BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("red_packet_" + paramString, localBitmap);
          return localBitmap;
        }
        catch (Exception localException1)
        {
          paramString = (String)localObject;
        }
      }
      catch (Exception localException2)
      {
        Object localObject;
        int i1;
        boolean bool;
        paramString = null;
        continue;
      }
      localObject = paramString;
      if (QLog.isColorLevel())
      {
        QLog.e("PortalManager", 2, "", localException1);
        return paramString;
        localObject = localException1;
        if ("hb_banner_path".equals(paramString))
        {
          i1 = 2130840341;
        }
        else
        {
          localObject = localException1;
          if ("hb_packet_path".equals(paramString))
          {
            i1 = 2130837546;
          }
          else
          {
            localObject = localException1;
            if ("hb_b_logo_path".equals(paramString))
            {
              i1 = 2130837549;
            }
            else
            {
              localObject = localException1;
              bool = "hb_l_logo_path".equals(paramString);
              if (!bool) {
                continue;
              }
              i1 = 2130837576;
            }
          }
        }
      }
    }
    return null;
    return null;
  }
  
  protected static PortalManager.RedPacketConfig a(String paramString, int paramInt1, ArrayList paramArrayList1, int paramInt2, ArrayList paramArrayList2, long paramLong, int paramInt3)
  {
    Object localObject1 = Xml.newPullParser();
    PortalManager.RedPacketConfig localRedPacketConfig = new PortalManager.RedPacketConfig();
    localRedPacketConfig.version = paramInt1;
    localRedPacketConfig.wordingNo = paramInt2;
    localRedPacketConfig.openTime = (1000L * paramLong);
    localRedPacketConfig.webConfigType = paramInt3;
    Object localObject2;
    label410:
    for (;;)
    {
      try
      {
        ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        paramInt1 = ((XmlPullParser)localObject1).getEventType();
        paramString = paramArrayList1;
        if (paramInt1 == 1) {
          break label1137;
        }
        if (paramInt1 != 2) {
          break label1783;
        }
        paramArrayList1 = ((XmlPullParser)localObject1).getName();
        if (paramArrayList1.equalsIgnoreCase("ConfigId"))
        {
          localRedPacketConfig.id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
          paramInt1 = ((XmlPullParser)localObject1).next();
          continue;
        }
        if (paramArrayList1.equalsIgnoreCase("DelayTime"))
        {
          paramString = PortalUtils.a(((XmlPullParser)localObject1).nextText());
          continue;
        }
        if (!paramArrayList1.equalsIgnoreCase("BBanner")) {
          break label410;
        }
        paramArrayList1 = new PortalManager.BannerConfig(null);
        paramInt1 = ((XmlPullParser)localObject1).next();
        if (paramInt1 == 1) {
          break label1786;
        }
        localObject2 = ((XmlPullParser)localObject1).getName();
        if ((paramInt1 == 3) && (((String)localObject2).equalsIgnoreCase("BBanner")))
        {
          localRedPacketConfig.bannerConfigs.add(paramArrayList1);
          break label1786;
        }
        if (paramInt1 == 2)
        {
          if (((String)localObject2).equalsIgnoreCase("Id")) {
            paramArrayList1.id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
          }
        }
        else
        {
          paramInt1 = ((XmlPullParser)localObject1).next();
          continue;
        }
        if (((String)localObject2).equalsIgnoreCase("Begin"))
        {
          paramArrayList1.uiBegin = a(((XmlPullParser)localObject1).nextText());
          continue;
        }
        if (!((String)localObject2).equalsIgnoreCase("End")) {
          break label338;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", paramString);
        }
        return null;
      }
      paramArrayList1.uiEnd = a(((XmlPullParser)localObject1).nextText());
      continue;
      label338:
      if (((String)localObject2).equalsIgnoreCase("JumpH5"))
      {
        paramArrayList1.actionUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("Img"))
      {
        paramArrayList1.bannerUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("Md5"))
      {
        paramArrayList1.bannarMd5 = ((XmlPullParser)localObject1).nextText();
        continue;
        if (!paramArrayList1.equalsIgnoreCase("Activity")) {
          break label1783;
        }
        paramArrayList1 = new PortalManager.PortalConfig();
        paramInt1 = ((XmlPullParser)localObject1).next();
        if (paramInt1 == 1) {
          break label1783;
        }
        localObject2 = ((XmlPullParser)localObject1).getName();
        if ((paramInt1 != 3) || (!((String)localObject2).equalsIgnoreCase("Activity"))) {
          break;
        }
        if (paramArrayList1.realEnd >= paramArrayList1.realBegin)
        {
          localRedPacketConfig.portalConfigs.add(paramArrayList1);
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label1783;
          }
          QLog.d("PortalManager", 2, "parseConfig" + paramArrayList1.realBegin + ", " + paramArrayList1.realEnd);
        }
      }
    }
    if (paramInt1 == 2)
    {
      if (!((String)localObject2).equalsIgnoreCase("Id")) {
        break label583;
      }
      paramArrayList1.id = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
    }
    for (;;)
    {
      paramInt1 = ((XmlPullParser)localObject1).next();
      break;
      label583:
      long l1;
      if (((String)localObject2).equalsIgnoreCase("Begin"))
      {
        l1 = a(((XmlPullParser)localObject1).nextText());
        paramArrayList1.realBegin = l1;
        paramArrayList1.uiBegin = l1;
      }
      else if (((String)localObject2).equalsIgnoreCase("End"))
      {
        l1 = a(((XmlPullParser)localObject1).nextText());
        paramArrayList1.realEnd = l1;
        paramArrayList1.uiEnd = l1;
      }
      else if (((String)localObject2).equalsIgnoreCase("Wording"))
      {
        paramArrayList1.wording = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("PortalJumpH5"))
      {
        paramArrayList1.actionUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("HitWording"))
      {
        paramArrayList1.hitWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("Running"))
      {
        paramArrayList1.running = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("IconImg"))
      {
        paramArrayList1.iconUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("IconMd5"))
      {
        paramArrayList1.iconMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("LogoImg"))
      {
        paramArrayList1.logoUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("LogoMd5"))
      {
        paramArrayList1.logoMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("TipsImg"))
      {
        paramArrayList1.tipsIconUrl = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("TipsMd5"))
      {
        paramArrayList1.tipsIconMd5 = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("AwardWording"))
      {
        paramArrayList1.awardWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("AwardOverWording"))
      {
        paramArrayList1.awardOverWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("TimeWording"))
      {
        paramArrayList1.timeWording = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("Title"))
      {
        paramArrayList1.title = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("Summary"))
      {
        paramArrayList1.summary = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("WebLogo"))
      {
        paramArrayList1.webLogo = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("WebComName"))
      {
        paramArrayList1.webComName = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("WebLogoJump"))
      {
        paramArrayList1.webLogoJump = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("WebGreetings"))
      {
        paramArrayList1.webGreetings = ((XmlPullParser)localObject1).nextText();
      }
      else if (((String)localObject2).equalsIgnoreCase("WebAwardOver"))
      {
        paramArrayList1.webAwardOver = ((XmlPullParser)localObject1).nextText();
      }
    }
    label1137:
    int i4 = localRedPacketConfig.portalConfigs.size();
    int i1;
    label1157:
    int i2;
    label1169:
    label1267:
    int i3;
    if (paramString != null)
    {
      i1 = paramString.size();
      if (paramArrayList2 == null) {
        break label1819;
      }
      i2 = paramArrayList2.size();
      if ((i1 != 0) && (i4 > 0))
      {
        paramArrayList1 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(0);
        if (TextUtils.isEmpty(paramArrayList1.hitWording)) {
          break label1778;
        }
        paramArrayList1.uiBegin = (paramArrayList1.realBegin + ((Integer)paramString.get(0 % i1)).intValue());
        if ((i2 == 0) || (((Integer)paramArrayList2.get(0 % i2)).intValue() != 0)) {
          break label1789;
        }
        paramArrayList1.timeWording = null;
        paramArrayList1.wording = null;
        paramArrayList1.running = null;
        break label1789;
        if (i3 < i4)
        {
          localObject1 = (PortalManager.PortalConfig)localRedPacketConfig.portalConfigs.get(i3);
          if (TextUtils.isEmpty(((PortalManager.PortalConfig)localObject1).hitWording)) {
            break label1775;
          }
          ((PortalManager.PortalConfig)localObject1).uiBegin = (((PortalManager.PortalConfig)localObject1).realBegin + ((Integer)paramString.get(paramInt1 % i1)).intValue() * 1000);
          if ((i2 != 0) && (((Integer)paramArrayList2.get(paramInt1 % i2)).intValue() == 0))
          {
            ((PortalManager.PortalConfig)localObject1).timeWording = null;
            ((PortalManager.PortalConfig)localObject1).wording = null;
            ((PortalManager.PortalConfig)localObject1).running = null;
          }
          if ((paramArrayList1 == null) || (!TextUtils.isEmpty(paramArrayList1.hitWording))) {
            break label1797;
          }
          paramArrayList1.uiEnd = (paramArrayList1.realEnd + ((Integer)paramString.get(paramInt1 % i1)).intValue() * 1000);
          if ((i2 == 0) || (((Integer)paramArrayList2.get(paramInt1 % i2)).intValue() != 0)) {
            break label1797;
          }
          paramArrayList1.timeWording = null;
          paramArrayList1.wording = null;
          paramArrayList1.running = null;
          break label1797;
        }
      }
      Collections.sort(localRedPacketConfig.portalConfigs, jdField_a_of_type_JavaUtilComparator);
      if (QLog.isColorLevel()) {
        a(localRedPacketConfig, "parseConfig, " + paramArrayList2 + ", " + paramString + ", " + paramInt2 + ", " + paramInt3 + ", " + paramLong);
      }
      paramInt1 = localRedPacketConfig.bannerConfigs.size() - 1;
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        paramArrayList1 = (PortalManager.BannerConfig)localRedPacketConfig.bannerConfigs.get(paramInt1);
        localObject1 = localRedPacketConfig.portalConfigs.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (PortalManager.PortalConfig)((Iterator)localObject1).next();
          if ((paramArrayList1.uiBegin >= ((PortalManager.PortalConfig)localObject2).realBegin) && (paramArrayList1.uiBegin < ((PortalManager.PortalConfig)localObject2).realEnd))
          {
            if (((PortalManager.PortalConfig)localObject2).wording == null)
            {
              localRedPacketConfig.bannerConfigs.remove(paramInt1);
              break;
            }
            if (paramArrayList1.uiBegin != ((PortalManager.PortalConfig)localObject2).realBegin) {
              break;
            }
            paramArrayList1.uiBegin = ((PortalManager.PortalConfig)localObject2).uiBegin;
            break;
          }
        } while (((PortalManager.PortalConfig)localObject2).uiBegin <= paramArrayList1.uiBegin);
      }
      else
      {
        Collections.sort(localRedPacketConfig.bannerConfigs, jdField_a_of_type_JavaUtilComparator);
        if (QLog.isColorLevel()) {
          a(localRedPacketConfig, "parseConfig, " + paramArrayList2 + ", " + paramString + ", " + paramInt2 + ", " + paramInt3 + ", " + paramLong);
        }
        return localRedPacketConfig;
        label1775:
        break label1801;
        label1778:
        paramInt1 = 0;
        break label1791;
        label1783:
        break;
        label1786:
        break;
        label1789:
        paramInt1 = 1;
        label1791:
        i3 = 1;
        break label1267;
        label1797:
        paramInt1 += 1;
        label1801:
        i3 += 1;
        paramArrayList1 = (ArrayList)localObject1;
        break label1267;
        i1 = 0;
        break label1157;
        label1819:
        i2 = 0;
        break label1169;
      }
      paramInt1 -= 1;
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "sendBroadcastRespData, " + paramInt1 + ", " + paramInt2 + ", " + paramString);
    }
    Intent localIntent = new Intent("com.tencent.portal.resp.action");
    localIntent.putExtra("portal_type_key", paramInt1);
    Bundle localBundle = new Bundle();
    localBundle.putString("bc_data", paramString);
    localIntent.putExtras(localBundle);
    if (paramInt2 > 0) {
      localIntent.putExtra("bc_seq", paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PortalManager", 2, "downLoad, " + paramInt + ", " + paramString1 + ", " + paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + R;
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString1;
    localHttpNetReq.c = 0;
    localHttpNetReq.b = (str + paramString2);
    localHttpNetReq.l = 2;
    localHttpNetReq.a(new String[] { String.valueOf(paramInt), paramString2 });
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  private void a(long paramLong)
  {
    long l2 = paramLong;
    if (jdField_b_of_type_Long > 0L) {
      l2 = jdField_b_of_type_Long + f * (paramLong - c);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.bannerConfigs;
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig.uiBegin = l2;
    PortalManager.PortalConfig localPortalConfig = null;
    int i1 = Collections.binarySearch((List)localObject3, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, jdField_a_of_type_JavaUtilComparator);
    Object localObject1;
    if (i1 >= 0)
    {
      i1 += 1;
      if ((i1 <= 0) || (i1 > ((ArrayList)localObject3).size())) {
        break label756;
      }
      localObject1 = (PortalManager.BannerConfig)((ArrayList)localObject3).get(i1 - 1);
      if (((PortalManager.BannerConfig)localObject1).uiEnd >= l2) {
        break label753;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localPortalConfig;
      if (i1 < ((ArrayList)localObject3).size())
      {
        localObject2 = localPortalConfig;
        if (i1 >= 0) {
          localObject2 = (PortalManager.BannerConfig)((ArrayList)localObject3).get(i1);
        }
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs;
      i1 = Collections.binarySearch((List)localObject3, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, jdField_a_of_type_JavaUtilComparator);
      if (i1 >= 0)
      {
        i1 += 1;
        label176:
        if ((i1 <= 0) || (i1 > ((ArrayList)localObject3).size())) {
          break label747;
        }
        localPortalConfig = (PortalManager.PortalConfig)((ArrayList)localObject3).get(i1 - 1);
        if (localPortalConfig.uiEnd >= l2) {
          break label744;
        }
        localPortalConfig = null;
      }
      for (;;)
      {
        if ((i1 < ((ArrayList)localObject3).size()) && (i1 >= 0)) {}
        label283:
        label310:
        label702:
        label709:
        label714:
        label719:
        label724:
        for (localObject3 = (PortalManager.PortalConfig)((ArrayList)localObject3).get(i1);; localObject3 = null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject1);
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((PortalManager.BannerConfig)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = localPortalConfig;
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = ((PortalManager.PortalConfig)localObject3);
          paramLong = 9223372036854775807L;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
          {
            paramLong = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiEnd;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
              break label645;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd >= paramLong) {
              break label735;
            }
            paramLong = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd;
          }
          label468:
          label729:
          label735:
          for (;;)
          {
            long l1 = paramLong;
            if (this.jdField_a_of_type_Long != 0L)
            {
              l1 = paramLong;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.openTime > this.jdField_a_of_type_Long)
              {
                if (l2 < this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.openTime) {
                  break label675;
                }
                this.jdField_a_of_type_Long = 0L;
                a(false, 10, 1000L, null);
                l1 = paramLong;
              }
            }
            label372:
            if (l1 != 9223372036854775807L)
            {
              if (l1 <= l2) {
                break label702;
              }
              paramLong = l1 - l2;
              l1 = paramLong;
              if (paramLong > 60000L) {
                l1 = 60000L;
              }
              if (jdField_b_of_type_Long == 0L) {
                break label729;
              }
            }
            for (paramLong = 1000L;; paramLong = l1)
            {
              a(true, 100, paramLong, null);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder().append("updateCurrentTimer, ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label709;
                }
                i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i1).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label714;
                }
                i1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                label497:
                localObject1 = ((StringBuilder)localObject1).append(i1).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label719;
                }
                i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i1).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label724;
                }
              }
              for (i1 = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;; i1 = -1)
              {
                QLog.d("PortalManager", 2, i1 + ", " + l2 + ", " + this.jdField_a_of_type_Long + ", " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.openTime);
                return;
                i1 = -i1 - 1;
                break;
                i1 = -i1 - 1;
                break label176;
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label283;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiBegin;
                break label283;
                if ((this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin >= paramLong)) {
                  break label735;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin;
                break label310;
                l1 = paramLong;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.openTime >= paramLong) {
                  break label372;
                }
                l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.openTime;
                break label372;
                paramLong = 60000L;
                break label395;
                i1 = -1;
                break label468;
                i1 = -1;
                break label497;
                i1 = -1;
                break label526;
              }
            }
          }
        }
        label395:
        label526:
        label675:
        label744:
        continue;
        label645:
        label747:
        localPortalConfig = null;
      }
      label753:
      continue;
      label756:
      localObject1 = null;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showResultActivity, " + paramInt1 + ", " + paramString + ", " + paramInt2);
    }
    if (paramActivity != null) {}
    for (Object localObject = paramActivity;; localObject = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl)
    {
      localObject = new Intent((Context)localObject, HongbaoShowerActivity.class);
      ((Intent)localObject).putExtra("a_hb_type", paramInt1);
      ((Intent)localObject).putExtra("a_hg_url", paramString);
      ((Intent)localObject).putExtra("a_hb_task_id", paramInt2);
      ((Intent)localObject).putExtra("a_hb_from", paramInt3);
      ((Intent)localObject).addFlags(67108864);
      if (paramActivity == null) {
        break;
      }
      paramActivity.startActivityForResult((Intent)localObject, paramInt3);
      return;
    }
    paramActivity = BaseActivity.sTopActivity;
    if (paramActivity != null)
    {
      paramActivity.startActivityForResult((Intent)localObject, paramInt3);
      return;
    }
    paramActivity = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    ((Intent)localObject).addFlags(268435456);
    paramActivity.startActivity((Intent)localObject);
  }
  
  private void a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (FileUtils.a() < 1048576.0F) {}
    for (;;)
    {
      return;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      Object localObject = paramRedPacketConfig.bannerConfigs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PortalManager.BannerConfig localBannerConfig = (PortalManager.BannerConfig)((Iterator)localObject).next();
        if ((localBannerConfig.uiEnd > l1) && (a(localBannerConfig.bannarMd5))) {
          a(localBannerConfig.id, localBannerConfig.bannerUrl, localBannerConfig.bannarMd5);
        }
      }
      paramRedPacketConfig = paramRedPacketConfig.portalConfigs.iterator();
      while (paramRedPacketConfig.hasNext())
      {
        localObject = (PortalManager.PortalConfig)paramRedPacketConfig.next();
        if ((((PortalManager.PortalConfig)localObject).uiEnd > l1) || (((PortalManager.PortalConfig)localObject).realEnd > l1))
        {
          if (a(((PortalManager.PortalConfig)localObject).iconMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).iconUrl, ((PortalManager.PortalConfig)localObject).iconMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).logoMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).logoUrl, ((PortalManager.PortalConfig)localObject).logoMd5);
          }
          if (a(((PortalManager.PortalConfig)localObject).tipsIconMd5)) {
            a(((PortalManager.PortalConfig)localObject).id, ((PortalManager.PortalConfig)localObject).tipsIconUrl, ((PortalManager.PortalConfig)localObject).tipsIconMd5);
          }
        }
      }
    }
  }
  
  private static void a(PortalManager.RedPacketConfig paramRedPacketConfig, String paramString)
  {
    int i2 = 0;
    int i4 = paramRedPacketConfig.bannerConfigs.size();
    int i3 = paramRedPacketConfig.portalConfigs.size();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(paramString).append(", ").append(paramRedPacketConfig.id).append(", ").append(paramRedPacketConfig.version).append(", ").append(paramRedPacketConfig.openTime).append(", ").append(paramRedPacketConfig.wordingNo).append(", ");
    localStringBuilder.append('[');
    int i1 = 0;
    while (i1 < i4)
    {
      localStringBuilder.append(((PortalManager.BannerConfig)paramRedPacketConfig.bannerConfigs.get(i1)).id).append(", ");
      i1 += 1;
    }
    localStringBuilder.append(']').append(", ").append('[');
    i1 = i2;
    while (i1 < i3)
    {
      localStringBuilder.append(((PortalManager.PortalConfig)paramRedPacketConfig.portalConfigs.get(i1)).id).append(", ");
      i1 += 1;
    }
    localStringBuilder.append(']');
    QLog.d("PortalManager", 2, localStringBuilder.toString());
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((PortalManager.PortalShower)localIterator.next()).a(paramString);
      }
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  private boolean a(PortalManager.RedPacketConfig paramRedPacketConfig1, PortalManager.RedPacketConfig paramRedPacketConfig2, boolean paramBoolean)
  {
    int i2 = 0;
    int i3 = paramRedPacketConfig1.portalConfigs.size();
    int i1;
    if (paramRedPacketConfig2 != null) {
      i1 = paramRedPacketConfig2.portalConfigs.size();
    }
    HashMap localHashMap;
    Object localObject1;
    Object localObject2;
    boolean bool;
    while ((i3 > 0) && (i1 > 0))
    {
      localHashMap = new HashMap(i1);
      localObject1 = paramRedPacketConfig2.portalConfigs.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PortalManager.PortalConfig)((Iterator)localObject1).next();
          localHashMap.put(Integer.valueOf(((PortalManager.PortalConfig)localObject2).id), localObject2);
          continue;
          i1 = 0;
          break;
        }
      }
      localObject1 = paramRedPacketConfig1.portalConfigs.iterator();
      bool = false;
      PortalManager.PortalConfig localPortalConfig;
      do
      {
        paramBoolean = bool;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (PortalManager.PortalConfig)((Iterator)localObject1).next();
        localPortalConfig = (PortalManager.PortalConfig)localHashMap.get(Integer.valueOf(((PortalManager.PortalConfig)localObject2).id));
      } while (localPortalConfig == null);
      if (localPortalConfig.useFlag == ((PortalManager.PortalConfig)localObject2).useFlag) {
        break label439;
      }
      ((PortalManager.PortalConfig)localObject2).useFlag = localPortalConfig.useFlag;
    }
    label439:
    for (paramBoolean = true;; paramBoolean = bool)
    {
      bool = paramBoolean;
      break;
      paramBoolean = false;
      i3 = paramRedPacketConfig1.bannerConfigs.size();
      i1 = i2;
      if (paramRedPacketConfig2 != null) {
        i1 = paramRedPacketConfig2.bannerConfigs.size();
      }
      bool = paramBoolean;
      if (i3 > 0)
      {
        bool = paramBoolean;
        if (i1 > 0)
        {
          localHashMap = new HashMap(i1);
          paramRedPacketConfig2 = paramRedPacketConfig2.bannerConfigs.iterator();
          while (paramRedPacketConfig2.hasNext())
          {
            localObject1 = (PortalManager.BannerConfig)paramRedPacketConfig2.next();
            localHashMap.put(Integer.valueOf(((PortalManager.BannerConfig)localObject1).id), localObject1);
          }
          paramRedPacketConfig2 = paramRedPacketConfig1.bannerConfigs.iterator();
          for (;;)
          {
            bool = paramBoolean;
            if (!paramRedPacketConfig2.hasNext()) {
              break;
            }
            localObject1 = (PortalManager.BannerConfig)paramRedPacketConfig2.next();
            localObject2 = (PortalManager.BannerConfig)localHashMap.get(Integer.valueOf(((PortalManager.BannerConfig)localObject1).id));
            if ((localObject2 != null) && (((PortalManager.BannerConfig)localObject2).useFlag != ((PortalManager.BannerConfig)localObject1).useFlag))
            {
              ((PortalManager.BannerConfig)localObject1).useFlag = ((PortalManager.BannerConfig)localObject2).useFlag;
              paramBoolean = true;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "updateUsedFlag, " + bool + ", " + this.jdField_a_of_type_Long + ", " + paramRedPacketConfig1.openTime);
      }
      return bool;
    }
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {}
    String str;
    do
    {
      return false;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir() + R;
    } while ((TextUtils.isEmpty(paramString)) || (new File(str + paramString).exists()));
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    return true;
  }
  
  private String c()
  {
    String str1 = "";
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig == null) {
      str2 = str1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return str2;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
              str1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.wording;
            }
            str2 = str1;
          } while (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.wordingNo == 0);
          str2 = str1;
        } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.timeWording));
        str2 = str1;
      } while (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.wordingNo != 1);
      str2 = str1;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.timeWording));
    return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.timeWording.replace("$TIME$", PortalUtils.a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
    }
    return -1;
  }
  
  public PortalManager.PortalConfig a(long paramLong)
  {
    long l2 = paramLong;
    long l1;
    int i1;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
    {
      l1 = paramLong;
      if (paramLong == -1L)
      {
        paramLong = NetConnInfoCenter.getServerTimeMillis();
        l1 = paramLong;
        if (jdField_b_of_type_Long > 0L) {
          l1 = jdField_b_of_type_Long + f * (paramLong - c);
        }
      }
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs;
      int i2 = localArrayList.size();
      i1 = 0;
      l2 = l1;
      if (i1 < i2)
      {
        localObject2 = (PortalManager.PortalConfig)localArrayList.get(i1);
        localObject1 = localObject2;
        l2 = l1;
        if (((PortalManager.PortalConfig)localObject2).id != l1)
        {
          if ((((PortalManager.PortalConfig)localObject2).realBegin > l1) || (((PortalManager.PortalConfig)localObject2).realEnd <= l1)) {
            break label201;
          }
          l2 = l1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      label140:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("findRealPortal, ").append(l2).append(", ");
        if (localObject1 == null) {
          break label238;
        }
      }
      label201:
      label238:
      for (i1 = localObject1.id;; i1 = -1)
      {
        QLog.d("PortalManager", 2, i1);
        return localObject1;
        if ((l1 > 536870911L) && (((PortalManager.PortalConfig)localObject2).realBegin > l1))
        {
          localObject1 = null;
          l2 = l1;
          break label140;
        }
        i1 += 1;
        break;
      }
      localObject1 = null;
    }
  }
  
  /* Error */
  protected PortalManager.RedPacketConfig a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 883	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   7: ifnonnull +56 -> 63
    //   10: aload_0
    //   11: invokestatic 383	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14: new 187	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: getfield 261	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   28: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 887
    //   34: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: iconst_0
    //   41: invokevirtual 891	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   44: putfield 883	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 883	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   52: ldc 74
    //   54: lconst_0
    //   55: invokeinterface 897 4 0
    //   60: putfield 259	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_Long	J
    //   63: new 192	java/io/File
    //   66: dup
    //   67: aload_0
    //   68: getfield 268	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   71: invokevirtual 898	android/content/Context:getFilesDir	()Ljava/io/File;
    //   74: new 187	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 900
    //   84: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 261	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   91: invokevirtual 903	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   94: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 906	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   103: astore_2
    //   104: aload 7
    //   106: astore_1
    //   107: aload_2
    //   108: invokevirtual 863	java/io/File:exists	()Z
    //   111: ifeq +64 -> 175
    //   114: new 908	java/io/FileInputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 911	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore_1
    //   123: new 913	java/io/ObjectInputStream
    //   126: dup
    //   127: new 915	java/io/BufferedInputStream
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 918	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   135: invokespecial 919	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   138: astore 6
    //   140: aload_1
    //   141: astore 4
    //   143: aload 6
    //   145: astore_2
    //   146: aload 6
    //   148: invokevirtual 922	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   151: checkcast 454	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   154: astore_3
    //   155: aload 6
    //   157: ifnull +8 -> 165
    //   160: aload 6
    //   162: invokevirtual 925	java/io/ObjectInputStream:close	()V
    //   165: aload_1
    //   166: ifnull +296 -> 462
    //   169: aload_1
    //   170: invokevirtual 926	java/io/FileInputStream:close	()V
    //   173: aload_3
    //   174: astore_1
    //   175: aload_1
    //   176: astore_2
    //   177: aload_1
    //   178: ifnonnull +11 -> 189
    //   181: new 454	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   184: dup
    //   185: invokespecial 455	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:<init>	()V
    //   188: astore_2
    //   189: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +10 -> 202
    //   195: aload_2
    //   196: ldc_w 928
    //   199: invokestatic 648	com/tencent/mobileqq/portal/PortalManager:a	(Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 745	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   206: ifnonnull +11 -> 217
    //   209: aload_0
    //   210: iconst_1
    //   211: iconst_2
    //   212: lconst_0
    //   213: aload_2
    //   214: invokevirtual 761	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   217: aload_2
    //   218: areturn
    //   219: astore_2
    //   220: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq -58 -> 165
    //   226: ldc 81
    //   228: iconst_2
    //   229: ldc_w 326
    //   232: aload_2
    //   233: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: goto -71 -> 165
    //   239: astore_1
    //   240: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +13 -> 256
    //   246: ldc 81
    //   248: iconst_2
    //   249: ldc_w 326
    //   252: aload_1
    //   253: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aload_3
    //   257: astore_1
    //   258: goto -83 -> 175
    //   261: astore 5
    //   263: aconst_null
    //   264: astore_3
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_3
    //   268: astore 4
    //   270: aload_1
    //   271: astore_2
    //   272: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +19 -> 294
    //   278: aload_3
    //   279: astore 4
    //   281: aload_1
    //   282: astore_2
    //   283: ldc 81
    //   285: iconst_2
    //   286: ldc_w 326
    //   289: aload 5
    //   291: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 925	java/io/ObjectInputStream:close	()V
    //   302: aload 7
    //   304: astore_1
    //   305: aload_3
    //   306: ifnull -131 -> 175
    //   309: aload_3
    //   310: invokevirtual 926	java/io/FileInputStream:close	()V
    //   313: aload 7
    //   315: astore_1
    //   316: goto -141 -> 175
    //   319: astore_2
    //   320: aload 7
    //   322: astore_1
    //   323: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -151 -> 175
    //   329: ldc 81
    //   331: iconst_2
    //   332: ldc_w 326
    //   335: aload_2
    //   336: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: aload 7
    //   341: astore_1
    //   342: goto -167 -> 175
    //   345: astore_1
    //   346: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq -47 -> 302
    //   352: ldc 81
    //   354: iconst_2
    //   355: ldc_w 326
    //   358: aload_1
    //   359: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   362: goto -60 -> 302
    //   365: astore_3
    //   366: aconst_null
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_2
    //   370: aload_2
    //   371: ifnull +7 -> 378
    //   374: aload_2
    //   375: invokevirtual 925	java/io/ObjectInputStream:close	()V
    //   378: aload_1
    //   379: ifnull +7 -> 386
    //   382: aload_1
    //   383: invokevirtual 926	java/io/FileInputStream:close	()V
    //   386: aload_3
    //   387: athrow
    //   388: astore_2
    //   389: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq -14 -> 378
    //   395: ldc 81
    //   397: iconst_2
    //   398: ldc_w 326
    //   401: aload_2
    //   402: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   405: goto -27 -> 378
    //   408: astore_1
    //   409: invokestatic 375	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq -26 -> 386
    //   415: ldc 81
    //   417: iconst_2
    //   418: ldc_w 326
    //   421: aload_1
    //   422: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   425: goto -39 -> 386
    //   428: astore_3
    //   429: aconst_null
    //   430: astore_2
    //   431: goto -61 -> 370
    //   434: astore_3
    //   435: aload 4
    //   437: astore_1
    //   438: goto -68 -> 370
    //   441: astore 5
    //   443: aconst_null
    //   444: astore_2
    //   445: aload_1
    //   446: astore_3
    //   447: aload_2
    //   448: astore_1
    //   449: goto -182 -> 267
    //   452: astore 5
    //   454: aload_1
    //   455: astore_3
    //   456: aload 6
    //   458: astore_1
    //   459: goto -192 -> 267
    //   462: aload_3
    //   463: astore_1
    //   464: goto -289 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	PortalManager
    //   106	72	1	localObject1	Object
    //   239	14	1	localIOException1	java.io.IOException
    //   257	85	1	localObject2	Object
    //   345	14	1	localIOException2	java.io.IOException
    //   367	16	1	localObject3	Object
    //   408	14	1	localIOException3	java.io.IOException
    //   437	27	1	localObject4	Object
    //   103	115	2	localObject5	Object
    //   219	14	2	localIOException4	java.io.IOException
    //   271	12	2	localObject6	Object
    //   319	17	2	localIOException5	java.io.IOException
    //   369	6	2	localObject7	Object
    //   388	14	2	localIOException6	java.io.IOException
    //   430	18	2	localObject8	Object
    //   154	156	3	localRedPacketConfig	PortalManager.RedPacketConfig
    //   365	22	3	localObject9	Object
    //   428	1	3	localObject10	Object
    //   434	1	3	localObject11	Object
    //   446	17	3	localObject12	Object
    //   141	295	4	localObject13	Object
    //   261	29	5	localThrowable1	Throwable
    //   441	1	5	localThrowable2	Throwable
    //   452	1	5	localThrowable3	Throwable
    //   138	319	6	localObjectInputStream	java.io.ObjectInputStream
    //   1	339	7	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   160	165	219	java/io/IOException
    //   169	173	239	java/io/IOException
    //   114	123	261	java/lang/Throwable
    //   309	313	319	java/io/IOException
    //   298	302	345	java/io/IOException
    //   114	123	365	finally
    //   374	378	388	java/io/IOException
    //   382	386	408	java/io/IOException
    //   123	140	428	finally
    //   146	155	434	finally
    //   272	278	434	finally
    //   283	294	434	finally
    //   123	140	441	java/lang/Throwable
    //   146	155	452	java/lang/Throwable
  }
  
  protected PortalManager.RedPacketConfig a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    PortalManager.RedPacketConfig localRedPacketConfig1;
    if (QLog.isColorLevel())
    {
      if (paramRedPacketConfig == null) {
        QLog.d("PortalManager", 2, "handleNewConfig");
      }
    }
    else
    {
      PortalManager.RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      localRedPacketConfig1 = localRedPacketConfig2;
      if (localRedPacketConfig2 == null) {
        localRedPacketConfig1 = a();
      }
      if (paramRedPacketConfig == null) {
        break label150;
      }
      a(paramRedPacketConfig, localRedPacketConfig1, false);
      a(paramRedPacketConfig);
    }
    for (;;)
    {
      a(paramRedPacketConfig);
      return paramRedPacketConfig;
      QLog.d("PortalManager", 2, "handleNewConfig, " + paramRedPacketConfig.version + ", " + paramRedPacketConfig.bannerConfigs.size() + ", " + paramRedPacketConfig.portalConfigs.size() + ", " + paramRedPacketConfig.wordingNo + ", " + paramRedPacketConfig.openTime);
      break;
      label150:
      paramRedPacketConfig = localRedPacketConfig1;
    }
  }
  
  public PortalManager.ResultData a(int paramInt1, int paramInt2)
  {
    Object localObject2;
    if ((paramInt2 == 10001) || (paramInt2 == 10002))
    {
      localObject2 = a(-1L);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((PortalManager.PortalConfig)localObject2).hitWording)) {
          break label44;
        }
      }
    }
    for (Object localObject1 = null;; localObject1 = null)
    {
      label44:
      if (localObject1 == null) {
        localObject1 = a(paramInt2);
      }
      for (;;)
      {
        if (localObject1 == null) {
          return null;
        }
        localObject2 = new PortalManager.ResultData();
        switch (paramInt1)
        {
        default: 
          return null;
        case 0: 
          ((PortalManager.ResultData)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = a(((PortalManager.PortalConfig)localObject1).logoMd5, "hb_b_logo_path");
        }
        for (((PortalManager.ResultData)localObject2).jdField_a_of_type_JavaLangString = ((PortalManager.PortalConfig)localObject1).awardWording;; ((PortalManager.ResultData)localObject2).jdField_a_of_type_JavaLangString = ((PortalManager.PortalConfig)localObject1).awardOverWording)
        {
          return localObject2;
          ((PortalManager.ResultData)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = a(((PortalManager.PortalConfig)localObject1).logoMd5, "hb_b_logo_path");
        }
      }
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.hitWording;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "clearData");
    }
    File localFile = new File(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir(), "red_packet_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if ((localFile.delete()) && (!localFile.delete()) && (localFile.delete())) {}
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("clickBanner, ");
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.actionUrl;
        QLog.i("PortalManager", 2, str + ", " + paramBoolean);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
        break label362;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag < 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 1;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        b(null, 1);
      }
      if (paramBoolean)
      {
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        str = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.actionUrl;
        StringBuilder localStringBuilder = new StringBuilder().append(str);
        if (str.indexOf('?') != -1) {
          break label300;
        }
        str = "?";
        label191:
        ((Intent)localObject).putExtra("url", str + "f_hbadtag=" + 1);
        paramActivity.startActivity((Intent)localObject);
      }
    }
    label300:
    label362:
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;; i1 = -1)
    {
      if (paramBoolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FF1", "0X8004FF1", 0, 0, "" + i1, "", "", "");
        return;
        str = "";
        break;
        str = "&";
        break label191;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FF2", "0X8004FF2", 0, 0, "" + i1, "", "", "");
      return;
    }
  }
  
  public void a(PortalManager.PortalShower paramPortalShower)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramPortalShower);
  }
  
  public void a(PortalManager.PortalShower paramPortalShower, int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramPortalShower))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramPortalShower);
      b(paramPortalShower, paramInt);
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    boolean bool;
    HttpNetReq localHttpNetReq;
    Object localObject1;
    Object localObject2;
    HashMap localHashMap;
    int i1;
    PortalManager.PortalConfig localPortalConfig;
    if (paramNetResp.e == 0)
    {
      bool = true;
      localHttpNetReq = (HttpNetReq)paramNetResp.a;
      localObject1 = new File(localHttpNetReq.b);
      localObject2 = localHttpNetReq.a();
      localHashMap = new HashMap();
      if ((localObject2 == null) || (!(localObject2 instanceof String[]))) {
        break label467;
      }
      localObject2 = (String[])localObject2;
      i1 = Integer.valueOf(localObject2[0]).intValue();
      localObject2 = localObject2[1];
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject2)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject2);
      }
      if (bool)
      {
        if (!((String)localObject2).equals(PortalUtils.a(((File)localObject1).getAbsolutePath()))) {
          break label446;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
        localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        if ((localObject1 == null) || (((PortalManager.BannerConfig)localObject1).id != i1)) {
          break label362;
        }
        a((String)localObject2, "hb_banner_path");
        a(true, 5, 0L, Integer.valueOf(1));
      }
      label179:
      if (QLog.isColorLevel()) {
        QLog.i("PortalManager", 2, "onResp" + localHttpNetReq.jdField_a_of_type_JavaLangString + ", " + paramNetResp.e + ", " + paramNetResp.f + ", " + (String)localHashMap.get("param_checkMd5Fail"));
      }
      i1 = 0;
      if (bool) {
        break label476;
      }
      localHashMap.put("param_Url", localHttpNetReq.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.e));
      localHashMap.put("param_FailCode", String.valueOf(paramNetResp.f));
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        paramNetResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()).a(paramNetResp, "RedPacketPicDownload", bool, 0L, 0L, localHashMap, "", false);
      }
      return;
      bool = false;
      break;
      label362:
      if ((localPortalConfig == null) || (localPortalConfig.id != i1)) {
        break label179;
      }
      if (((String)localObject2).equals(localPortalConfig.iconMd5))
      {
        a((String)localObject2, "hb_icon_path");
        a(true, 5, 0L, Integer.valueOf(2));
        break label179;
      }
      if (!((String)localObject2).equals(localPortalConfig.tipsIconMd5)) {
        break label179;
      }
      a((String)localObject2, "hb_l_logo_path");
      a(true, 5, 0L, Integer.valueOf(4));
      break label179;
      label446:
      ((File)localObject1).delete();
      localHashMap.put("param_checkMd5Fail", "checkMd5Fail");
      break label179;
      label467:
      ((File)localObject1).delete();
      break label179;
      label476:
      if (new Random().nextInt(10000) == 1000)
      {
        localHashMap.put("param_Url", localHttpNetReq.jdField_a_of_type_JavaLangString);
        localHashMap.put("param_ResultCode", String.valueOf(paramNetResp.e));
        i1 = 1;
      }
    }
  }
  
  public void a(submsgtype0x78.MsgBody paramMsgBody)
  {
    boolean bool = paramMsgBody.uint32_version.has();
    int i1 = paramMsgBody.uint32_version.get();
    int i2 = c();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handlePush, " + bool + ", " + i2 + ", " + i1);
    }
    if ((i1 != i2) && (bool)) {
      RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i2);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "GetNewPackReq_DelayTime");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf((String)localObject).longValue();
        if ((l1 <= 30L) || (l1 >= 300L)) {
          break label612;
        }
      }
      catch (Exception localException)
      {
        long l2;
        QLog.e("PortalManager", 1, (String)localObject, localException);
        l1 = 30L;
        continue;
        this.d = l2;
        PortalManager.PortalConfig localPortalConfig = a(paramInt1);
        if ((localPortalConfig != null) && (!TextUtils.isEmpty(localPortalConfig.hitWording))) {
          continue;
        }
        int i1 = 7;
        if (localPortalConfig == null) {
          continue;
        }
        QLog.d("PortalManager", 1, "requestResult, " + paramInt1 + ", " + paramInt2 + ", " + localPortalConfig.hitWording + ", " + localPortalConfig.useFlag + ", " + i1);
        if (i1 == -2) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("time_out", 0);
          if (localPortalConfig == null) {
            continue;
          }
          i2 = localPortalConfig.id;
          ((JSONObject)localObject).put("activity_id", i2);
          ((JSONObject)localObject).put("err_code", i1);
          ((JSONObject)localObject).put("pack_url", "");
        }
        catch (JSONException localJSONException)
        {
          int i2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("PortalManager", 2, "", localJSONException);
          continue;
          paramInt2 = 2;
          continue;
        }
        a(1006, ((JSONObject)localObject).toString(), paramInt2);
        if (i1 != 2) {
          continue;
        }
        paramInt2 = 1;
        if (!paramBoolean) {
          continue;
        }
        if ((paramInt1 != 10001) && (paramInt1 != 10002)) {
          continue;
        }
        paramInt2 = 3;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FFC", "0X8004FFC", paramInt2, 0, "" + paramInt1, "" + paramInt3, "" + paramString, "4");
        return;
        if (localPortalConfig.useFlag != 2) {
          continue;
        }
        i1 = 3;
        continue;
        if (localPortalConfig.useFlag != 3) {
          continue;
        }
        i1 = 5;
        continue;
        RedPacketServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPortalConfig.id, paramBoolean, paramInt2, paramInt3, paramString);
        i1 = -2;
        continue;
        QLog.d("PortalManager", 1, "requestResult, " + paramInt1 + ", " + paramInt2);
        continue;
        i2 = paramInt1;
        continue;
        a("等待也是一种美德，再试一次吧");
        return;
      }
      l2 = NetConnInfoCenter.getServerTimeMillis();
      if ((this.d != 0L) && (Math.abs(l2 - this.d) < 1000L * l1))
      {
        QLog.e("PortalManager", 1, "requestResult, " + l2 + ", " + this.d + "," + l1);
        return;
      }
      label612:
      long l1 = 30L;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          if (!paramBoolean) {
            break label44;
          }
        }
        label44:
        for (Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;; localHandler = this.jdField_a_of_type_AndroidOsHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, paramObject), paramLong);
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean a(Activity paramActivity, boolean paramBoolean, int paramInt, String[] paramArrayOfString)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.actionUrl)))
    {
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag < 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 1;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
      }
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.actionUrl;
      localObject3 = new StringBuilder().append((String)localObject1);
      if (((String)localObject1).indexOf('?') == -1)
      {
        localObject1 = "?";
        ((Intent)localObject2).putExtra("url", (String)localObject1 + "f_hbadtag=" + paramInt);
        paramActivity.startActivity((Intent)localObject2);
        i1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (paramBoolean) {
        b(null, 2);
      }
      if (paramInt == 2)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FF4", "0X8004FF4", 0, 0, "" + i1, "", "", "");
        label228:
        if (QLog.isColorLevel())
        {
          paramArrayOfString = new StringBuilder().append("startPortalDetail, ");
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
            break label450;
          }
        }
      }
      label450:
      for (paramActivity = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.actionUrl;; paramActivity = "")
      {
        QLog.i("PortalManager", 2, paramActivity + ", " + paramBoolean + ", " + paramInt + ", " + bool);
        return bool;
        localObject1 = "&";
        break;
        if (paramInt != 4) {
          break label228;
        }
        localObject2 = "";
        localObject3 = "";
        localObject1 = localObject2;
        paramActivity = (Activity)localObject3;
        if (paramArrayOfString != null)
        {
          localObject1 = localObject2;
          paramActivity = (Activity)localObject3;
          if (paramArrayOfString.length >= 2)
          {
            localObject1 = paramArrayOfString[0];
            paramActivity = paramArrayOfString[1];
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FF8", "0X8004FF8", 0, 0, "" + i1, (String)localObject1, paramActivity, "");
        break label228;
      }
      i1 = -1;
    }
  }
  
  protected boolean a(PortalManager.RedPacketConfig paramRedPacketConfig)
  {
    if (paramRedPacketConfig == null) {
      return false;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramRedPacketConfig);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return FileUtils.a(new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "red_packet_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
    catch (Throwable paramRedPacketConfig)
    {
      paramRedPacketConfig.printStackTrace();
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
    }
    return -1;
  }
  
  public String b()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
      return String.valueOf(-1);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.wording)) {
      return String.valueOf(3);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.wordingNo == 1) {}
    for (;;)
    {
      return String.valueOf(i1);
      i1 = 2;
    }
  }
  
  /* Error */
  @SuppressLint({"SdCardPath"})
  public void b()
  {
    // Byte code:
    //   0: lconst_0
    //   1: putstatic 228	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_Long	J
    //   4: new 1181	java/io/BufferedReader
    //   7: dup
    //   8: new 1183	java/io/InputStreamReader
    //   11: dup
    //   12: new 908	java/io/FileInputStream
    //   15: dup
    //   16: ldc_w 1185
    //   19: invokespecial 1186	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 1187	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 1190	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual 1193	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: ifnull +73 -> 108
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: invokevirtual 1193	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: ldc_w 1195
    //   47: invokevirtual 1199	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: iconst_0
    //   55: aaload
    //   56: invokestatic 532	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;)J
    //   59: putstatic 228	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_Long	J
    //   62: aload_2
    //   63: astore_1
    //   64: aload_3
    //   65: iconst_1
    //   66: aaload
    //   67: invokestatic 1203	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   70: i2l
    //   71: putstatic 232	com/tencent/mobileqq/portal/PortalManager:f	J
    //   74: aload_2
    //   75: astore_1
    //   76: getstatic 232	com/tencent/mobileqq/portal/PortalManager:f	J
    //   79: lconst_1
    //   80: lcmp
    //   81: ifge +9 -> 90
    //   84: aload_2
    //   85: astore_1
    //   86: lconst_1
    //   87: putstatic 232	com/tencent/mobileqq/portal/PortalManager:f	J
    //   90: aload_2
    //   91: astore_1
    //   92: getstatic 228	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_Long	J
    //   95: lconst_0
    //   96: lcmp
    //   97: ifeq +11 -> 108
    //   100: aload_2
    //   101: astore_1
    //   102: invokestatic 817	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   105: putstatic 230	com/tencent/mobileqq/portal/PortalManager:c	J
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 1204	java/io/BufferedReader:close	()V
    //   116: return
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 1178	java/lang/Throwable:printStackTrace	()V
    //   122: return
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_1
    //   128: aload_3
    //   129: invokevirtual 1178	java/lang/Throwable:printStackTrace	()V
    //   132: aload_2
    //   133: ifnull -17 -> 116
    //   136: aload_2
    //   137: invokevirtual 1204	java/io/BufferedReader:close	()V
    //   140: return
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 1178	java/lang/Throwable:printStackTrace	()V
    //   146: return
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 1204	java/io/BufferedReader:close	()V
    //   158: aload_2
    //   159: athrow
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 1178	java/lang/Throwable:printStackTrace	()V
    //   165: goto -7 -> 158
    //   168: astore_2
    //   169: goto -19 -> 150
    //   172: astore_3
    //   173: goto -47 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	PortalManager
    //   30	72	1	localBufferedReader1	java.io.BufferedReader
    //   117	2	1	localThrowable1	Throwable
    //   127	1	1	localBufferedReader2	java.io.BufferedReader
    //   141	2	1	localThrowable2	Throwable
    //   149	6	1	localObject1	Object
    //   160	2	1	localThrowable3	Throwable
    //   28	109	2	localBufferedReader3	java.io.BufferedReader
    //   147	12	2	localObject2	Object
    //   168	1	2	localObject3	Object
    //   50	15	3	arrayOfString	String[]
    //   123	6	3	localThrowable4	Throwable
    //   172	1	3	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   112	116	117	java/lang/Throwable
    //   4	29	123	java/lang/Throwable
    //   136	140	141	java/lang/Throwable
    //   4	29	147	finally
    //   154	158	160	java/lang/Throwable
    //   31	38	168	finally
    //   40	51	168	finally
    //   53	62	168	finally
    //   64	74	168	finally
    //   76	84	168	finally
    //   86	90	168	finally
    //   92	100	168	finally
    //   102	108	168	finally
    //   128	132	168	finally
    //   31	38	172	java/lang/Throwable
    //   40	51	172	java/lang/Throwable
    //   53	62	172	java/lang/Throwable
    //   64	74	172	java/lang/Throwable
    //   76	84	172	java/lang/Throwable
    //   86	90	172	java/lang/Throwable
    //   92	100	172	java/lang/Throwable
    //   102	108	172	java/lang/Throwable
  }
  
  public void b(PortalManager.PortalShower paramPortalShower, int paramInt)
  {
    Object localObject4 = null;
    if ((1 == (paramInt & 0x1)) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag < 1)) {}
    for (Bitmap localBitmap = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.bannarMd5, "hb_banner_path");; localBitmap = null)
    {
      Object localObject2;
      Object localObject1;
      Object localObject5;
      Object localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
        if ((2 == (paramInt & 0x2)) && (this.jdField_a_of_type_Long == 0L))
        {
          localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.iconMd5, "hb_icon_path");
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag < 1)
          {
            localObject1 = c();
            if ((4 == (paramInt & 0x4)) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag < 2))
            {
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.running;
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.tipsIconMd5;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject4;
              localObject4 = localObject5;
            }
          }
        }
      }
      for (;;)
      {
        if (paramPortalShower != null)
        {
          if (1 == (paramInt & 0x1)) {
            paramPortalShower.a(localBitmap);
          }
          if (2 == (paramInt & 0x2)) {
            paramPortalShower.b(localObject3, (String)localObject2);
          }
          if (4 == (paramInt & 0x4)) {
            paramPortalShower.a(a((String)localObject4, "hb_l_logo_path"), (String)localObject1);
          }
        }
        for (;;)
        {
          return;
          paramPortalShower = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramPortalShower.hasNext())
          {
            localObject5 = (PortalManager.PortalShower)paramPortalShower.next();
            if (1 == (paramInt & 0x1)) {
              ((PortalManager.PortalShower)localObject5).a(localBitmap);
            }
            if (2 == (paramInt & 0x2)) {
              ((PortalManager.PortalShower)localObject5).b(localObject3, (String)localObject2);
            }
            if (4 == (paramInt & 0x4)) {
              ((PortalManager.PortalShower)localObject5).a(a((String)localObject4, "hb_l_logo_path"), (String)localObject1);
            }
          }
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = null;
        continue;
        localObject1 = null;
        break;
        localObject1 = null;
        localObject2 = null;
        break;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  public int c()
  {
    PortalManager.RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    PortalManager.RedPacketConfig localRedPacketConfig1 = localRedPacketConfig2;
    if (localRedPacketConfig2 == null) {
      localRedPacketConfig1 = a();
    }
    return localRedPacketConfig1.version;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handleMessage " + paramMessage.what + ", " + paramMessage.obj);
    }
    Object localObject;
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) || (NetConnInfoCenter.servetTimeSecondInterv == 0L));
      a();
      return false;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) {
        return true;
      }
    case 3: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      PortalManager.RedPacketConfig localRedPacketConfig = (PortalManager.RedPacketConfig)paramMessage.obj;
      bool = a(localRedPacketConfig, (PortalManager.RedPacketConfig)localObject, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig = localRedPacketConfig;
    }
    for (;;)
    {
      a(NetConnInfoCenter.getServerTimeMillis());
      if (paramMessage.what == 5) {}
      for (int i1 = ((Integer)paramMessage.obj).intValue();; i1 = 7)
      {
        b(null, i1);
        if (!bool) {
          break;
        }
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        return false;
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
        break;
      }
      a((PortalManager.RedPacketConfig)paramMessage.obj);
      return false;
      a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
      return false;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10)) {
        break;
      }
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      paramMessage = (Message)localObject;
      if (localObject == null) {
        paramMessage = BaseApplicationImpl.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "portal_swither", 0);
      }
      long l1 = this.jdField_a_of_type_Long;
      if (l1 == 0L)
      {
        paramMessage.edit().remove("key_portal_ct").commit();
        return false;
      }
      paramMessage.edit().putLong("key_portal_ct", l1).commit();
      return false;
      bool = false;
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 1139	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 280	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   11: iconst_1
    //   12: invokevirtual 743	android/os/Handler:removeMessages	(I)V
    //   15: aload_0
    //   16: getfield 287	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   19: aconst_null
    //   20: invokevirtual 1254	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   23: aload_0
    //   24: getfield 261	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: aload_0
    //   31: getfield 300	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_Jmm	Ljmm;
    //   34: invokevirtual 1258	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   37: aload_0
    //   38: getfield 261	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: aload_0
    //   42: invokevirtual 1261	com/tencent/mobileqq/app/QQAppInterface:unRegistObserver	(Lmqq/observer/BusinessObserver;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: ldc 81
    //   51: iconst_1
    //   52: ldc_w 1262
    //   55: aload_1
    //   56: invokestatic 331	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: goto -22 -> 37
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	PortalManager
    //   48	8	1	localException	Exception
    //   62	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	37	48	java/lang/Exception
    //   2	23	62	finally
    //   23	37	62	finally
    //   37	45	62	finally
    //   49	59	62	finally
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onReceive, " + paramInt + ", " + paramBoolean + ", " + paramBundle);
    }
    int i1;
    int i2;
    Object localObject1;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 3: 
      i1 = -1;
      i2 = paramBundle.getInt("key_seq");
      localObject1 = a(paramBundle.getInt("k_id", -1));
      paramInt = i1;
      if (paramBoolean)
      {
        paramInt = i1;
        switch (paramBundle.getInt("k_code", 2))
        {
        default: 
          paramInt = i1;
        }
      }
      break;
    }
    for (;;)
    {
      a(1004, Integer.toString(paramInt), i2);
      return;
      paramInt = 1;
      continue;
      i1 = 2;
      paramInt = i1;
      if (localObject1 != null)
      {
        paramInt = i1;
        if (((PortalManager.PortalConfig)localObject1).useFlag < 2)
        {
          ((PortalManager.PortalConfig)localObject1).useFlag = 2;
          a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          paramInt = 2;
          continue;
          i1 = 3;
          paramInt = i1;
          if (localObject1 != null)
          {
            paramInt = i1;
            if (((PortalManager.PortalConfig)localObject1).useFlag < 3)
            {
              ((PortalManager.PortalConfig)localObject1).useFlag = 3;
              a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
              paramInt = 3;
              continue;
              boolean bool = paramBundle.getBoolean("k_query_by_web");
              int i4 = paramBundle.getInt("key_seq");
              localObject1 = paramBundle.getString("k_url");
              int i3 = paramBundle.getInt("k_id", -1);
              int i5 = paramBundle.getInt("k_code", -1);
              i1 = paramBundle.getInt("k_type", -1);
              label414:
              Object localObject2;
              if (paramBoolean)
              {
                this.d = 0L;
                paramInt = 0;
                i2 = paramInt;
                switch (i5)
                {
                default: 
                  i2 = paramInt;
                case 4: 
                  paramBoolean = false;
                  paramInt = 0;
                  i1 = 1;
                  localObject2 = a(i3);
                  if ((localObject2 != null) && (i2 != 0) && (((PortalManager.PortalConfig)localObject2).useFlag != i2))
                  {
                    ((PortalManager.PortalConfig)localObject2).useFlag = i2;
                    a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
                  }
                  i2 = paramInt;
                }
              }
              for (;;)
              {
                if (bool)
                {
                  localObject2 = paramBundle.getString("k_msg");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "{\"time_out\":1}";
                  }
                  a(1006, (String)localObject1, i4);
                  label506:
                  if (!paramBoolean) {
                    break;
                  }
                  paramInt = 1;
                  if (bool) {
                    if ((i3 != 10001) && (i3 != 10002)) {
                      break label730;
                    }
                  }
                }
                label730:
                for (paramInt = 3;; paramInt = 2)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FFC", "0X8004FFC", paramInt, 0, "" + i3, "" + paramBundle.getInt("k_g_type"), paramBundle.getString("k_g_uin"), "" + i2);
                  return;
                  i2 = 2;
                  if (i1 == 0)
                  {
                    paramInt = 1;
                    i1 = 0;
                    break label414;
                  }
                  paramInt = 2;
                  i1 = 0;
                  break label414;
                  i2 = 2;
                  paramInt = 3;
                  i1 = 0;
                  break label414;
                  i2 = 3;
                  paramInt = 4;
                  i1 = 1;
                  break label414;
                  i2 = 2;
                  break;
                  if (paramBoolean)
                  {
                    a(null, i1, (String)localObject1, i3, -1);
                    break label506;
                  }
                  if (i5 == 3)
                  {
                    a("已参与本轮活动");
                    break label506;
                  }
                  a("等待也是一种美德，再试一次吧");
                  break label506;
                }
                paramInt = paramBundle.getInt("k_code", 2);
                if (paramInt == 3)
                {
                  handleMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, new PortalManager.RedPacketConfig()));
                  return;
                }
                if (paramInt == 4)
                {
                  paramBundle = (PortalManager.RedPacketConfig)paramBundle.getSerializable("k_cache");
                  handleMessage(this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3, paramBundle));
                  return;
                }
                if ((!paramBoolean) || (paramInt == 2)) {
                  break;
                }
                return;
                paramInt = paramBundle.getInt("key_seq");
                i1 = paramBundle.getInt("bc_type");
                if (paramBoolean)
                {
                  a(i1, paramBundle.getString("k_result"), paramInt);
                  return;
                }
                a(i1, paramBundle.getString("k_result"), paramInt);
                return;
                i2 = 0;
                i1 = 1;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager
 * JD-Core Version:    0.7.0.1
 */