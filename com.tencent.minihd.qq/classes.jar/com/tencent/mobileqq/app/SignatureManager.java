package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateConfig.SignatureTemplateType;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import hpp;
import hpq;
import hpr;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class SignatureManager
  implements Handler.Callback, Manager
{
  public static final int a = 1;
  public static SignatureTemplateInfo.DynamicItem a;
  private static SignatureTemplateInfo jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo;
  public static final String a = "SignatureManager";
  public static boolean a = false;
  public static SignatureTemplateConfig.SignatureTemplateType[] a;
  public static final int b = 0;
  public static final String b = "sigResUpt";
  private static final int c = 1;
  public static final String c = "sigTplCfgVer";
  private static final int d = 2;
  public static final String d = "sigTplUptFlag";
  private static final int e = 1;
  public static final String e = "sigTplCfgVerTemp";
  private static final int f = 2;
  public static final String f = AppConstants.bo + "SigtplJson.txt";
  private static final int g = 3;
  public static final String g = "https://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.json";
  public static final String h = "https://i.gtimg.cn/qqshow/admindata/comdata/sigtpl_%d/android.zip";
  public static final String i = AppConstants.bo;
  public static final String j = i + "/temp";
  public static final String k = "resType";
  public static final String l = "dynamicType";
  public static final String m = "tplId";
  public static final String n = "fileName";
  public static final String o = "tlpres";
  public static final String p = "cover.png";
  public static final String q = "aio_2.png";
  public static final String r = "aio_3.png";
  public static final String s = "aio_4.png";
  public static final String t = "view.png";
  public static final String u = "icon.png";
  public static final String v = "action_off.png";
  public static final String w = "action_on.png";
  public static final String x = "dynamic_aio";
  public static String y = null;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new hpp(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new hpq(this);
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private Handler b = null;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = null;
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = null;
  }
  
  public SignatureManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramQQAppInterface.getManager(46)).a(1);
    this.b = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    a();
  }
  
  public static int a(String paramString, ListAdapter paramListAdapter)
  {
    int i1 = 0;
    while (i1 < paramListAdapter.getCount())
    {
      Object localObject = paramListAdapter.getItem(i1);
      if (((localObject instanceof RichStatus)) && (((RichStatus)localObject).f.equals(paramString))) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  @TargetApi(9)
  private Bitmap a(File paramFile)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return null;
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = 320;
      if (localResources.getDisplayMetrics().densityDpi > localOptions.inDensity) {}
      for (localOptions.inTargetDensity = 320;; localOptions.inTargetDensity = localResources.getDisplayMetrics().densityDpi) {
        try
        {
          paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
          return paramFile;
        }
        catch (OutOfMemoryError paramFile) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, "OOM");
    return null;
  }
  
  @TargetApi(4)
  public static Layout a(Resources paramResources, TextView paramTextView, StatusManager paramStatusManager, RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramRichStatus == null) {
      return null;
    }
    int i1 = Color.parseColor("black");
    Object localObject = paramRichStatus.a(null, i1, i1);
    if ((paramRichStatus != null) && (paramResources != null) && (!TextUtils.isEmpty(paramRichStatus.c)))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      if (paramStatusManager != null)
      {
        paramStatusManager = paramStatusManager.a(paramRichStatus.b, 200);
        paramResources = new StatableBitmapDrawable(paramResources, paramStatusManager, false, false);
        i1 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramResources.setBounds(0, 0, i1, i1);
        if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT >= 20)) {
          break label271;
        }
        paramResources = new OffsetableImageSpan(paramResources, 1);
        label142:
        paramResources.a(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramResources, 0, "[S]".length(), 17);
        paramResources = paramTextView.getPaint();
        i1 = Math.min(SizeMeasure.f(paramQQAppInterface.getApplication()), SizeMeasure.i(paramQQAppInterface.getApplication())) * 2 / 3;
        Utils.a(paramQQAppInterface.getApplication().getApplicationContext(), 93.0F);
        if (!paramBoolean) {
          break label284;
        }
        i1 -= Utils.a(paramQQAppInterface.getApplication().getApplicationContext(), 78.0F);
      }
      for (;;)
      {
        paramResources = new DynamicLayout((CharSequence)localObject, paramResources, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        paramResources.getLineCount();
        return paramResources;
        paramStatusManager = BitmapManager.a(paramResources, 2130841575);
        break;
        label271:
        paramResources = new OffsetableImageSpan(paramResources, 0);
        break label142;
        label284:
        i1 -= Utils.a(paramQQAppInterface.getApplication().getApplicationContext(), 93.0F);
      }
    }
    paramResources = paramTextView.getPaint();
    i1 = Math.min(SizeMeasure.f(paramQQAppInterface.getApplication()), SizeMeasure.i(paramQQAppInterface.getApplication())) * 2 / 3;
    Utils.a(paramQQAppInterface.getApplication().getApplicationContext(), 93.0F);
    if (paramBoolean) {
      i1 -= Utils.a(paramQQAppInterface.getApplication().getApplicationContext(), 78.0F);
    }
    for (;;)
    {
      paramResources = new StaticLayout((CharSequence)localObject, paramResources, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      paramResources.getLineCount();
      return paramResources;
      i1 -= Utils.a(paramQQAppInterface.getApplication().getApplicationContext(), 93.0F);
    }
  }
  
  private static String a(int paramInt, String paramString)
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://i.gtimg.cn/qqshow/admindata/comdata/");
    localStringBuilder.append("vipSignature_item");
    localStringBuilder.append("_");
    localStringBuilder.append(Integer.toString(paramInt));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @TargetApi(4)
  public static void a(Resources paramResources, TextView paramTextView, StatusManager paramStatusManager, RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramRichStatus == null)
    {
      paramTextView.setText(new SpannableString(""));
      return;
    }
    int i2 = Color.parseColor("black");
    int i1;
    if ((paramQQAppInterface != null) && (!paramBoolean))
    {
      i1 = Color.parseColor(((SignatureManager)paramQQAppInterface.getManager(56)).a(Integer.toString(paramRichStatus.d)).jdField_e_of_type_JavaLangString);
      paramQQAppInterface = paramRichStatus.a(null, i1, i2);
      if ((paramRichStatus == null) || (paramResources == null) || (TextUtils.isEmpty(paramRichStatus.c))) {
        break label264;
      }
      paramQQAppInterface = new SpannableStringBuilder(paramQQAppInterface);
      paramQQAppInterface.insert(0, "[S] ");
      if (paramStatusManager == null) {
        break label240;
      }
      paramStatusManager = paramStatusManager.a(paramRichStatus.b, 200);
      label131:
      paramResources = new StatableBitmapDrawable(paramResources, paramStatusManager, false, false);
      i2 = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramResources.setBounds(0, 0, i2, i2);
      if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT >= 20)) {
        break label251;
      }
      paramResources = new OffsetableImageSpan(paramResources, 1);
      label193:
      paramResources.a(-0.1F);
      paramQQAppInterface.setSpan(paramResources, 0, "[S]".length(), 17);
      paramTextView.setText(paramQQAppInterface);
    }
    for (;;)
    {
      paramTextView.setTextColor(i1);
      return;
      i1 = Color.parseColor("#ffa8a8a8");
      break;
      label240:
      paramStatusManager = BitmapManager.a(paramResources, 2130841575);
      break label131;
      label251:
      paramResources = new OffsetableImageSpan(paramResources, 0);
      break label193;
      label264:
      paramTextView.setText(paramQQAppInterface);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, RichStatus paramRichStatus)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      bool = false;
    }
    while (paramQQAppInterface.a().equals(paramString)) {
      return bool;
    }
    ThreadManager.b(new hpr(paramRichStatus, paramQQAppInterface, paramString));
    return true;
  }
  
  public static boolean a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if (paramSignatureTemplateInfo.jdField_e_of_type_Int == 1) {}
    do
    {
      for (;;)
      {
        return false;
        if ((!TextUtils.isEmpty(paramSignatureTemplateInfo.r)) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.q)))
        {
          Object localObject = new Date(NetConnInfoCenter.getServerTimeMillis());
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          localObject = localSimpleDateFormat.format((Date)localObject);
          try
          {
            localObject = localSimpleDateFormat.parse((String)localObject);
            Date localDate = localSimpleDateFormat.parse(paramSignatureTemplateInfo.r);
            paramSignatureTemplateInfo = localSimpleDateFormat.parse(paramSignatureTemplateInfo.q);
            if (((Date)localObject).compareTo(localDate) <= 0)
            {
              int i1 = ((Date)localObject).compareTo(paramSignatureTemplateInfo);
              if (i1 >= 0) {
                return true;
              }
            }
          }
          catch (ParseException paramSignatureTemplateInfo) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, paramSignatureTemplateInfo.toString());
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, paramString + " is not a picture");
    return false;
  }
  
  private boolean b(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    boolean bool = false;
    if ((!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[1].jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[2].jdField_a_of_type_JavaLangString))) {
      bool = true;
    }
    return bool;
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    int i2 = 0;
    int i3 = 0;
    jdField_a_of_type_Boolean = false;
    String str = Integer.toString(paramInt1);
    SignatureTemplateInfo localSignatureTemplateInfo = a(str);
    if ((localSignatureTemplateInfo != null) && (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0"))) {}
    for (int i1 = 1;; i1 = 0)
    {
      y = null;
      jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = null;
      boolean bool2;
      if (localSignatureTemplateInfo != null)
      {
        bool2 = b(localSignatureTemplateInfo);
        bool1 = bool2;
        if (bool2)
        {
          localSignatureTemplateInfo.getClass();
          jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = new SignatureTemplateInfo.DynamicItem(localSignatureTemplateInfo);
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Object localObject1;
        switch (paramInt2)
        {
        default: 
          i1 = i3;
          localObject1 = null;
        }
        for (;;)
        {
          label158:
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            localObject1 = localObject4;
          }
          for (;;)
          {
            return localObject1;
            if (i1 != 0)
            {
              i2 = 2130840898;
              label181:
              i1 = i2;
              if (localSignatureTemplateInfo == null) {
                break label1068;
              }
              if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                break label320;
              }
            }
            label320:
            for (Object localObject2 = localSignatureTemplateInfo.k;; localObject2 = localSignatureTemplateInfo.s)
            {
              i1 = i2;
              localObject1 = localObject2;
              if (!bool1) {
                break label1065;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                y = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0];
              }
              i1 = i2;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                break label1065;
              }
              i1 = i2;
              localObject1 = localObject2;
              if (b(str)) {
                break label1065;
              }
              a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
              i1 = i2;
              localObject1 = localObject2;
              break;
              i2 = 2130840897;
              break label181;
            }
            if (i1 != 0)
            {
              i2 = 2130840898;
              label339:
              i1 = i2;
              if (localSignatureTemplateInfo == null) {
                break label1068;
              }
              if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                break label478;
              }
            }
            label478:
            for (localObject2 = localSignatureTemplateInfo.g;; localObject2 = localSignatureTemplateInfo.s)
            {
              i1 = i2;
              localObject1 = localObject2;
              if (!bool1) {
                break label1065;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                y = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[1];
              }
              i1 = i2;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                break label1065;
              }
              i1 = i2;
              localObject1 = localObject2;
              if (b(str)) {
                break label1065;
              }
              a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
              i1 = i2;
              localObject1 = localObject2;
              break;
              i2 = 2130840897;
              break label339;
            }
            if (i1 != 0)
            {
              i2 = 2130840898;
              label497:
              i1 = i2;
              if (localSignatureTemplateInfo == null) {
                break label1068;
              }
              if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                break label636;
              }
            }
            label636:
            for (localObject2 = localSignatureTemplateInfo.h;; localObject2 = localSignatureTemplateInfo.s)
            {
              i1 = i2;
              localObject1 = localObject2;
              if (!bool1) {
                break label1065;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                y = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[2];
              }
              i1 = i2;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                break label1065;
              }
              i1 = i2;
              localObject1 = localObject2;
              if (b(str)) {
                break label1065;
              }
              a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
              i1 = i2;
              localObject1 = localObject2;
              break;
              i2 = 2130840897;
              break label497;
            }
            if (i1 != 0)
            {
              i2 = 2130840898;
              label655:
              i1 = i2;
              if (localSignatureTemplateInfo == null) {
                break label1068;
              }
              if (!TextUtils.isEmpty(localSignatureTemplateInfo.s)) {
                break label794;
              }
            }
            label794:
            for (localObject2 = localSignatureTemplateInfo.i;; localObject2 = localSignatureTemplateInfo.s)
            {
              i1 = i2;
              localObject1 = localObject2;
              if (!bool1) {
                break label1065;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                y = "dynamic_aio";
                jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[3];
              }
              i1 = i2;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString)) {
                break label1065;
              }
              i1 = i2;
              localObject1 = localObject2;
              if (b(str)) {
                break label1065;
              }
              a(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString, localSignatureTemplateInfo.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem[0].jdField_a_of_type_JavaLangString, 16);
              i1 = i2;
              localObject1 = localObject2;
              break;
              i2 = 2130840897;
              break label655;
            }
            if (localSignatureTemplateInfo != null)
            {
              localObject1 = localSignatureTemplateInfo.j;
              i1 = 2130840898;
              break label158;
              i2 = 2130841759;
              i1 = i2;
              if (localSignatureTemplateInfo == null) {
                break;
              }
              localObject1 = localSignatureTemplateInfo.l;
              i1 = i2;
              break label158;
              i2 = 2130841760;
              i1 = i2;
              if (localSignatureTemplateInfo == null) {
                break;
              }
              localObject1 = localSignatureTemplateInfo.m;
              i1 = i2;
              break label158;
              i1 = i3;
              if (localSignatureTemplateInfo == null) {
                break;
              }
              localObject1 = localSignatureTemplateInfo.h;
              i1 = i2;
              break label158;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getResources().getDrawable(i1);
              if (paramInt2 == 9) {
                localObject2 = new ColorDrawable(Color.parseColor("#dedede"));
              }
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                return localObject2;
              }
              try
              {
                localObject1 = new URL("sig_cover", (String)localObject1, Integer.toString(paramInt1));
                localObject2 = URLDrawable.getDrawable((URL)localObject1, (Drawable)localObject2, (Drawable)localObject2);
                ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                if (((URLDrawable)localObject2).getStatus() == 2) {
                  ((URLDrawable)localObject2).restartDownload();
                }
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  jdField_a_of_type_Boolean = true;
                  return localObject2;
                }
              }
              catch (MalformedURLException localMalformedURLException)
              {
                for (;;)
                {
                  localObject1 = localObject3;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("SignatureManager", 2, localMalformedURLException.getMessage());
                    localObject1 = localObject3;
                  }
                }
              }
            }
          }
          i1 = 2130840898;
          localObject1 = null;
          continue;
          label1065:
          continue;
          label1068:
          localObject1 = null;
        }
      }
    }
  }
  
  public RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localObject != null)
      {
        localObject = ((ExtensionInfo)localObject).getRichStatus();
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((RichStatus)localObject).f, localObject);
        }
      }
      return (RichStatus)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    finally {}
  }
  
  public SignatureTemplateInfo a(String paramString)
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType != null)
    {
      int i1 = 0;
      while (i1 < jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length)
      {
        int i2 = 0;
        while (i2 < jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].a.size())
        {
          SignatureTemplateInfo localSignatureTemplateInfo = (SignatureTemplateInfo)jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[i1].a.get(i2);
          if (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
            return localSignatureTemplateInfo;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    if (paramString.equals("0")) {
      return new SignatureTemplateInfo("0");
    }
    if (jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo == null) {
      jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = a("0");
    }
    return jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo;
  }
  
  public File a(String paramString1, String paramString2)
  {
    DownloadTask localDownloadTask = new DownloadTask(a(Integer.parseInt(paramString1), paramString2), new File(SignatureTemplateConfig.a(paramString1, paramString2)));
    localDownloadTask.k = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0))
    {
      paramString2 = new File(SignatureTemplateConfig.a(paramString1, paramString2));
      paramString1 = paramString2;
      if (paramString2.exists())
      {
        paramString1 = paramString2;
        if (!a(paramString2.getAbsolutePath())) {
          paramString2.delete();
        }
      }
    }
    else
    {
      paramString1 = new File(AppConstants.aG);
    }
    return paramString1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      boolean bool;
      do
      {
        return;
        localObject1 = new File(f);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("sigResUpt", 0);
        bool = ((SharedPreferences)localObject2).getBoolean("sigTplUptFlag", false);
        if ((((File)localObject1).exists()) && (!bool)) {
          break;
        }
      } while (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()));
      if (bool) {
        ((SharedPreferences)localObject2).edit().putBoolean("sigTplUptFlag", false).commit();
      }
      localObject1 = EmosmUtils.insertMtype("VIP_sig_cfg", "https://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.json");
    } while (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((String)localObject1) != null);
    Object localObject1 = new DownloadTask((String)localObject1, new File(f));
    ((DownloadTask)localObject1).k = false;
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("resType", 1);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject2);
    return;
    if (jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null)
    {
      this.b.sendEmptyMessage(1);
      return;
    }
    ClubContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (paramString != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = a(Integer.parseInt(paramString1), paramString2);
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((String)localObject) == null)
    {
      localObject = new DownloadTask((String)localObject, new File(SignatureTemplateConfig.a(paramString1, paramString2)));
      Bundle localBundle = new Bundle();
      localBundle.putInt("resType", 2);
      localBundle.putInt("dynamicType", paramInt);
      localBundle.putString("tplId", paramString1);
      localBundle.putString("fileName", paramString2);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RichStatus localRichStatus = (RichStatus)paramList.next();
          if (!TextUtils.isEmpty(localRichStatus.f)) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localRichStatus.f, localRichStatus);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean b(String paramString)
  {
    paramString = SignatureTemplateConfig.a(paramString, "dynamic_aio");
    File localFile = new File(paramString);
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {}
    while (FileUtils.a(paramString).size() <= 0) {
      return false;
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = SignatureTemplateConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((paramMessage != null) && (paramMessage.length > 0))
      {
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramMessage);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "parse sign tpl done...");
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = null;
    jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo = null;
    a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager
 * JD-Core Version:    0.7.0.1
 */