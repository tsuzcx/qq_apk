package com.tencent.mobileqq.activity;

import QQService.EVIPSPEC;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import etw;
import etx;
import etz;
import eua;
import eub;
import euc;
import eue;
import eug;
import eui;
import eum;
import java.io.File;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingMe
  implements View.OnClickListener
{
  public static int a = 0;
  public static final String a = "QQSettingRedesign";
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 4;
  private static final int g = 5;
  private static final int h = 6;
  private static final int i = 7;
  private static final int j = 8;
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new etz(this);
  protected View a;
  protected ViewGroup a;
  public ImageView a;
  protected TextView a;
  private QQSettingMe.UpdateMyBusinessReceiver jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver;
  public BaseActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new eug(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new eue(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new eui(this);
  public QQAppInterface a;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new etx(this);
  private VipInfoObserver jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver = new euc(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new eub(this);
  protected RedTouch a;
  NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = new eum(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new etw(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
  protected RedDotTextView a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  protected boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2131299798, 2131300455, 2131300456, 2131300457, 2131300458, 2131300459, 2131300460, 2131300461, 2131300462 };
  protected View[] a;
  protected RedTouch[] a;
  protected View b;
  protected TextView b;
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  public TextView c;
  private final String jdField_c_of_type_JavaLangString = "https://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json";
  public boolean c;
  public boolean d = false;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public QQSettingMe(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130904012, null));
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
    }
  }
  
  private String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131369085);
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 8);
    return paramString.substring(0, 8);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2);
    int k = localCalendar.get(1);
    int m = localCalendar.get(2);
    int n = localCalendar.get(5);
    localCalendar.setTimeInMillis(paramLong1);
    int i1 = localCalendar.get(1);
    int i2 = localCalendar.get(2);
    int i3 = localCalendar.get(5);
    return (k != i1) || (m + 1 != i2 + 1) || (n != i3);
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInfo != null)
    {
      bool1 = bool2;
      if (paramAppInfo.iNewFlag != null)
      {
        bool1 = bool2;
        if (paramAppInfo.iNewFlag.get() != 0)
        {
          bool1 = bool2;
          if (paramAppInfo.type.has())
          {
            bool1 = bool2;
            if (paramAppInfo.type.get() == 3) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = "https://mc.vip.qq.com?platform=1&sid=" + paramString + "&_bid=138";; paramString = "https://mc.vip.qq.com?platform=1&_bid=138")
    {
      Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100400));
      paramString = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramString, (BusinessInfoCheckUpdate.AppInfo)localObject);
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131365921));
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, 256L, (Intent)localObject, false, -1);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100400));
      return;
    }
  }
  
  private boolean b()
  {
    if (!this.d) {}
    long l;
    int k;
    do
    {
      return true;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      l = localSharedPreferences.getLong("sp_vip_info_request_time", 0L);
      k = localSharedPreferences.getInt("sp_vip_info_update_freq", 10);
    } while (NetConnInfoCenter.getServerTime() - l > k * 60);
    return false;
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir(), "https://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json");
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(new DownloadTask("https://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json", localFile), this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, null);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    if (!this.d) {
      f();
    }
    u();
    v();
    i();
    g();
    k();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((str != null) && (str.equals(this.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    }
    this.jdField_c_of_type_Boolean = true;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.hasFragment()) && (!a()) && (SizeMeasure.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))) {
      m();
    }
  }
  
  void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(Resources paramResources, ImageView paramImageView, String paramString)
  {
    try
    {
      Object localObject = paramResources.getDrawable(2130840888);
      localObject = URLDrawable.getDrawable(paramString, (Drawable)localObject, (Drawable)localObject, false);
      if (localObject != null)
      {
        int k = (int)(paramResources.getDisplayMetrics().density * 35.0F);
        ((URLDrawable)localObject).setBounds(0, 0, k, k);
        paramImageView.setImageDrawable((Drawable)localObject);
        paramImageView.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingMe", 2, "red icon load fail, iconUrl=" + paramString);
      }
      paramImageView.setImageDrawable(paramResources.getDrawable(2130840888));
      paramImageView.setVisibility(0);
      localException.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "fillData, " + this.d);
    }
    if (this.d)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      e();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onAccountChanged(paramQQAppInterface);
      i();
      v();
      A();
    }
    for (;;)
    {
      y();
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->updateLevelAndVip!");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    Object localObject4 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1;
    Object localObject3;
    int i2;
    int i3;
    int m;
    int k;
    label104:
    boolean bool1;
    label118:
    boolean bool2;
    label132:
    float f1;
    if (localObject4 == null)
    {
      localObject1 = null;
      localObject3 = new SpannableStringBuilder();
      i2 = 0;
      i3 = 0;
      m = 0;
      if (localObject1 != null)
      {
        boolean bool3 = ((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
        boolean bool4 = ((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
        if (!bool3) {
          break label790;
        }
        k = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
        if (((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 0) {
          break label803;
        }
        bool1 = true;
        if (((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP) == 0) {
          break label809;
        }
        bool2 = true;
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "updateOpenCenterInfo:level:" + k + " isVip:" + bool4 + " isSvip:" + bool3);
        }
        if (!bool3)
        {
          i2 = bool3;
          i3 = bool4;
          m = k;
          if (!bool4) {}
        }
        else
        {
          m = k;
          if (k <= 0) {
            m = 1;
          }
          ((SpannableStringBuilder)localObject3).append(QQSettingUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, (Resources)localObject2, bool3, bool4, m, bool1, bool2));
          i3 = bool4;
          i2 = bool3;
        }
      }
      if (QQSettingUtil.jdField_a_of_type_Int <= 0)
      {
        localObject1 = ((Resources)localObject2).getDisplayMetrics();
        float f2 = ((Resources)localObject2).getDimension(2131493009);
        if (i2 == 0) {
          break label815;
        }
        f1 = ((DisplayMetrics)localObject1).density * 46.0F;
        label292:
        float f3 = ((Resources)localObject2).getDimension(2131493292);
        float f4 = ((Resources)localObject2).getDimension(2131493285);
        float f5 = ((Resources)localObject2).getDimension(2131493289);
        float f6 = ((Resources)localObject2).getDimension(2131493279);
        float f7 = ((DisplayMetrics)localObject1).widthPixels;
        if (f2 > 1.0F) {
          break label1187;
        }
        f2 = 1.0F;
        QQSettingUtil.jdField_a_of_type_Int = (int)((f7 - (f3 + f4 + f5 + f6) - f1) / f2);
        if (QLog.isDevelopLevel()) {
          QLog.i("QQSettingRedesign", 4, "MAX_LEVEL_ICON_SIZE = " + QQSettingUtil.jdField_a_of_type_Int);
        }
      }
      if (localObject4 != null) {
        break label828;
      }
      paramString = null;
      label414:
      if (paramString != null) {
        break label840;
      }
      k = 0;
      label421:
      ((SpannableStringBuilder)localObject3).append(QQSettingUtil.a((Resources)localObject2, k));
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      paramString = new File(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFilesDir(), "https://imgcache.qq.com/club/mobile/profile/template/vip_menu_conf.json");
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      localObject2 = null;
      if (!paramString.exists()) {
        break label972;
      }
    }
    int n;
    label542:
    label579:
    long l;
    try
    {
      paramString = FileUtils.a(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingRedesign", 2, "-->json:" + paramString);
      }
      localObject1 = new JSONArray(paramString);
      if (localObject1 == null) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        int i1;
        localObject1 = null;
        paramString = null;
      }
    }
    catch (Exception localException1)
    {
      label599:
      label629:
      paramString = null;
      localObject2 = localException1;
    }
    try
    {
      if (((JSONArray)localObject1).length() <= 0) {
        break label858;
      }
      n = 0;
      if (n >= ((JSONArray)localObject1).length()) {
        break label1182;
      }
      paramString = ((JSONArray)localObject1).getJSONObject(n);
      if (paramString == null) {
        break label849;
      }
      i1 = paramString.getInt("id");
      if (i1 != 1) {
        break label849;
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        String str;
        paramString = str;
      }
      paramString = null;
      break label579;
    }
    if (localObject3 != null)
    {
      l = ((SharedPreferences)localObject3).getLong("vip_center_last_update_time", -1L);
      localObject2 = paramString;
      localObject3 = localObject1;
      if (a(l, NetConnInfoCenter.getServerTimeMillis()))
      {
        z();
        localObject3 = localObject1;
        localObject2 = paramString;
      }
      paramString = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131300467);
      localObject4 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131300466);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131369085);
      if (i2 == 0) {
        break label1006;
      }
    }
    for (;;)
    {
      label710:
      label840:
      label972:
      try
      {
        ((ImageView)localObject4).setImageResource(2130840556);
        if (localObject2 == null) {
          continue;
        }
        paramString.setText(a(((JSONObject)localObject2).getString("svip")));
      }
      catch (Exception localException2)
      {
        label752:
        paramString.setText(str);
        label849:
        label858:
        continue;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setVisibility(8);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1].setContentDescription(paramString.getText().toString());
      if (i2 == 0) {
        break label1158;
      }
      paramStringBuilder.append("你是尊贵的超级会员");
      if (k > 0) {
        paramStringBuilder.append(" 等级").append(k).append("级");
      }
      return;
      localObject1 = ((FriendManager)localObject4).c(paramString);
      break;
      label790:
      k = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
      break label104;
      label803:
      bool1 = false;
      break label118;
      label809:
      bool2 = false;
      break label132;
      label815:
      f1 = ((DisplayMetrics)localObject1).density * 42.0F;
      break label292;
      label828:
      paramString = ((FriendManager)localObject4).a(paramString);
      break label414;
      k = paramString.iQQLevel;
      break label421;
      n += 1;
      break label542;
      paramString = (String)localObject2;
      if (!QLog.isColorLevel()) {
        break label579;
      }
      QLog.e("QQSettingRedesign", 2, "-->vipInfo.length=" + ((JSONArray)localObject1).length());
      paramString = (String)localObject2;
      break label579;
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingRedesign", 2, "-->" + ((Exception)localObject2).toString());
      }
      str = paramString;
      paramString = null;
      break label579;
      l = -1L;
      break label599;
      z();
      localObject2 = null;
      localObject3 = null;
      break label629;
      paramString.setText(2131369087);
      continue;
      label1006:
      if (i3 == 0) {
        break label1053;
      }
      ((ImageView)localObject4).setImageResource(2130840556);
      if (localException2 != null) {
        paramString.setText(a(localException2.getString("vip")));
      } else {
        paramString.setText(2131369086);
      }
    }
    label1053:
    ((ImageView)localObject4).setImageResource(2130840556);
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (localObject4 != null) {
      n = ((SharedPreferences)localObject4).getInt("key_selfvip_growthvalue", 0);
    }
    label1158:
    label1182:
    label1187:
    label1207:
    for (;;)
    {
      if (localException2 != null)
      {
        paramString.setText(a(localException2.getString("outdatedVip")));
        break label710;
      }
      paramString.setText(2131369088);
      break label710;
      label1125:
      if (localObject3 != null)
      {
        paramString.setText(a(localException2.getString("notVip")));
        break label710;
      }
      paramString.setText(2131369085);
      break label710;
      if (i3 == 0) {
        break label752;
      }
      paramStringBuilder.append("你是尊贵的会员");
      break label752;
      break;
      for (;;)
      {
        if (m > 0) {
          break label1207;
        }
        if (n <= 0) {
          break label1125;
        }
        break;
        n = 0;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    int k = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (k < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(this.jdField_a_of_type_ArrayOfInt[k]).isActivated()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      k += 1;
    }
  }
  
  public boolean a(View paramView)
  {
    int k = 0;
    boolean bool = false;
    if (k < this.jdField_a_of_type_ArrayOfInt.length)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(this.jdField_a_of_type_ArrayOfInt[k]);
      long l;
      if ((paramView != null) && (paramView == localObject))
      {
        localObject = new eua(this, paramView);
        if ((this.jdField_b_of_type_Boolean) && ((paramView.getId() == 2131300457) || (paramView.getId() == 2131300460)))
        {
          l = 50L;
          label79:
          paramView.postDelayed((Runnable)localObject, l);
          bool = true;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        l = 0L;
        break label79;
        ((View)localObject).setActivated(false);
      }
    }
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onPause!");
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onDestroy!");
    }
    if (this.d)
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.destroy();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      A();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
        this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.unRegisterModeCallback(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver, true);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("aciont_up_my_bus");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver, localIntentFilter);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.registerModeCallback(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "init, " + this.d);
    }
    if (true == this.d) {
      return;
    }
    this.d = true;
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe$UpdateMyBusinessReceiver = new QQSettingMe.UpdateMyBusinessReceiver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299798);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setContentDescription("进入我的资料卡");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296683));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300447));
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[8];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[8];
    int[] arrayOfInt1 = new int[8];
    int[] tmp194_192 = arrayOfInt1;
    tmp194_192[0] = 2131300455;
    int[] tmp199_194 = tmp194_192;
    tmp199_194[1] = 2131300456;
    int[] tmp204_199 = tmp199_194;
    tmp204_199[2] = 2131300457;
    int[] tmp209_204 = tmp204_199;
    tmp209_204[3] = 2131300458;
    int[] tmp214_209 = tmp209_204;
    tmp214_209[4] = 2131300459;
    int[] tmp219_214 = tmp214_209;
    tmp219_214[5] = 2131300460;
    int[] tmp224_219 = tmp219_214;
    tmp224_219[6] = 2131300461;
    int[] tmp230_224 = tmp224_219;
    tmp230_224[7] = 2131300462;
    tmp230_224;
    int[] arrayOfInt2 = new int[8];
    int[] tmp245_243 = arrayOfInt2;
    tmp245_243[0] = 2131369101;
    int[] tmp251_245 = tmp245_243;
    tmp251_245[1] = 2131369085;
    int[] tmp256_251 = tmp251_245;
    tmp256_251[2] = 2131369082;
    int[] tmp262_256 = tmp256_251;
    tmp262_256[3] = 2131369081;
    int[] tmp268_262 = tmp262_256;
    tmp268_262[4] = 2131369089;
    int[] tmp274_268 = tmp268_262;
    tmp274_268[5] = 2131369083;
    int[] tmp280_274 = tmp274_268;
    tmp280_274[6] = 2131369080;
    int[] tmp287_280 = tmp280_274;
    tmp287_280[7] = 2131369090;
    tmp287_280;
    int k = 0;
    if (k < 8)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[k] = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(arrayOfInt1[k]);
      this.jdField_a_of_type_ArrayOfAndroidViewView[k].setFocusable(true);
      if ((arrayOfInt1[k] == 2131300456) || (arrayOfInt1[k] == 2131300457) || (arrayOfInt1[k] == 2131300458)) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[k].setVisibility(8);
      }
      for (;;)
      {
        k += 1;
        break;
        this.jdField_a_of_type_ArrayOfAndroidViewView[k].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidViewView[k].setOnClickListener(this);
        ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[k].findViewById(2131300466)).setImageResource(new int[] { 2130840554, 2130840556, 2130840570, 2130840576, 2130840574, 2130840572, 2130840575, 2130840571 }[k]);
        ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[k].findViewById(2131300467)).setText(arrayOfInt2[k]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[k].setContentDescription(((Resources)localObject).getString(arrayOfInt2[k]));
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[k] = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ArrayOfAndroidViewView[k]).d(32).a(21).a();
      }
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300448);
    ((View)localObject).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)((View)localObject).findViewById(2131300449));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300450);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300452));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300451));
    e();
    i();
    v();
    g();
    k();
    u();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "init, cosume: " + (System.currentTimeMillis() - l));
      }
      y();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "initUpdateVipInfoReceiver:" + localException.toString());
        }
      }
    }
  }
  
  public void g()
  {
    o();
    p();
    s();
    w();
    t();
    x();
    q();
    h();
  }
  
  protected void h()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100180));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[6].a(localAppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void i()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (TextUtils.isEmpty(str2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    a(str2);
    String str3 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
    String str1;
    if (str3 != null)
    {
      str1 = str3;
      if (!"".equals(str3.trim())) {}
    }
    else
    {
      str1 = str2;
    }
    if (!Utils.a(str1, this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = str1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    a(str2, this.jdField_a_of_type_JavaLangStringBuilder);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.onPostThemeChanged();
    }
    y();
  }
  
  public void k()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void l()
  {
    a(null);
  }
  
  public void m()
  {
    a(this.jdField_a_of_type_AndroidViewView);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    localAllInOne.f = 1;
    localAllInOne.g = 8;
    ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAllInOne, 1009);
  }
  
  public void n()
  {
    try
    {
      QWalletHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void o()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
          break label128;
        }
        bool1 = true;
        if (!bool1) {
          break label138;
        }
        if (ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp)) {
          break label133;
        }
        bool1 = bool2;
      }
    }
    label128:
    label133:
    label138:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100190));
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    long l1;
    do
    {
      do
      {
        return;
      } while (paramView.isActivated());
      l1 = System.currentTimeMillis();
    } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(paramView);
      return;
      Object localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      ((ProfileActivity.AllInOne)localObject1).f = 1;
      ((ProfileActivity.AllInOne)localObject1).g = 8;
      ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ProfileActivity.AllInOne)localObject1, 1009);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006143", "0X8006143", 0, 0, "", "", "", "");
      com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800611B", "0X800611B", 0, 0, "", "", "", "");
      l1 = System.currentTimeMillis();
      if (!ProfileActivity.a(this.jdField_a_of_type_Long, l1)) {
        break;
      }
      this.jdField_a_of_type_Long = l1;
      this.jdField_b_of_type_Boolean = false;
      QWalletHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_wallet", "Clk_wallet", 0, 0, "", "", "", "");
      QQSettingUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100007));
      if (jdField_a_of_type_Int > 0)
      {
        com.tencent.mobileqq.activity.recent.DrawerFrame.f = 2;
      }
      else
      {
        com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006119", "0X8006119", 0, 0, "", "", "", "");
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AccountManageActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800611E", "0X800611E", 0, 0, "", "", "", "");
        QfavHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1);
        QfavReport.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800611F", "0X800611F", 0, 0, "", "", "", "");
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100180));
        l1 = 0L;
        try
        {
          long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        Object localObject4 = QZoneHelper.UserInfo.a();
        ((QZoneHelper.UserInfo)localObject4).a = String.valueOf(l1);
        ((QZoneHelper.UserInfo)localObject4).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid();
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        }
        ((QZoneHelper.UserInfo)localObject4).jdField_b_of_type_JavaLangString = ((String)localObject1);
        QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QZoneHelper.UserInfo)localObject4, Long.valueOf(l1), 0, -1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
        com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800611C", "0X800611C", 0, 0, "", "", "", "");
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100005));
        Object localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, IndividuationSetActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting_native", 0, 0, "", "", "", "");
        com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006120", "0X8006120", 0, 0, "", "", "", "");
        localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
          ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100190));
        com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
        continue;
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
        this.jdField_b_of_type_AndroidViewView.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.startNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        com.tencent.mobileqq.activity.recent.DrawerFrame.f = 0;
        if (!this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.isCurrentNightMode()) {}
        for (localObject2 = "切换夜间模式    切换按钮   打开";; localObject2 = "切换夜间模式    切换按钮    关闭 ")
        {
          this.jdField_b_of_type_AndroidViewView.setContentDescription((CharSequence)localObject2);
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800611A", "0X800611A", 0, 0, "", "", "", "");
        l1 = System.currentTimeMillis();
        if (!ProfileActivity.a(this.jdField_a_of_type_Long, l1)) {
          break;
        }
        this.jdField_a_of_type_Long = l1;
        b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
        if (jdField_a_of_type_Int > 0)
        {
          com.tencent.mobileqq.activity.recent.DrawerFrame.f = 2;
        }
        else
        {
          com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
          continue;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800611D", "0X800611D", 0, 0, "", "", "", "");
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QfileFileAssistantActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
          com.tencent.mobileqq.activity.recent.DrawerFrame.f = jdField_a_of_type_Int;
          localObject2 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
          localObject3 = ((RedTouchManager)localObject2).a(String.valueOf(100160));
          if ((localObject3 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() != 0))
          {
            ((RedTouchManager)localObject2).b(String.valueOf(100160));
            try
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("service_type", 2);
              ((JSONObject)localObject4).put("act_id", 1002);
              ((RedTouchManager)localObject2).b((BusinessInfoCheckUpdate.AppInfo)localObject3, ((JSONObject)localObject4).toString());
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  protected void p() {}
  
  protected void q() {}
  
  protected void r()
  {
    try
    {
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("favorites_new_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("favorites_click_red_point_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo.path.set(String.valueOf(100016));
      localAppInfo.num.set(0);
      localAppInfo.type.set(0);
      if ((!bool1) && (!bool2)) {
        localAppInfo.iNewFlag.set(1);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void s()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100005));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[3].a(localAppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void t()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100400));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[1].a(localAppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void u()
  {
    if (!b()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateVipInfo");
    }
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(str1);
    ((VipInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(29)).a(str2, str1);
  }
  
  public void v() {}
  
  public void w() {}
  
  protected void x()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100160));
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[4].a(localAppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */