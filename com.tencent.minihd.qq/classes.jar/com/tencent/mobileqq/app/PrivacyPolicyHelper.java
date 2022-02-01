package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hmw;
import hmx;
import hmy;

public class PrivacyPolicyHelper
{
  public static final int a = 0;
  private static PrivacyPolicyHelper.MyLinkMovementMethod a;
  public static final String a = "PrivacyPolicyHelper";
  public static final int b = 1;
  public static final String b = "0";
  private static final int c = -12541697;
  public static final String c = "1";
  private static final int d = 2134941951;
  public static final String d = "0";
  public static final String e = "1";
  
  public static MovementMethod a()
  {
    if (a == null) {
      a = new PrivacyPolicyHelper.MyLinkMovementMethod();
    }
    return a;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131370028));
    localSpannableString.setSpan(new hmy(paramContext, paramString, "https://ti.qq.com/agreement/index.html"), 114, 120, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 114, 120, 17);
    localSpannableString.setSpan(new hmy(paramContext, paramString, "https://ti.qq.com/doc/redirect/qqhd-privacy"), 121, 127, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 121, 127, 17);
    paramString = new hmw();
    hmx localhmx = new hmx();
    paramContext = DialogUtil.b(paramContext, 0, paramContext.getString(2131370027), localSpannableString.toString(), 2131370026, 2131370025, localhmx, paramString);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramString = (TextView)paramContext.findViewById(2131296606);
    paramString.setText(localSpannableString);
    paramString.setTextSize(1, 17.0F);
    paramString.setHighlightColor(0);
    paramString.setMovementMethod(a());
    ((TextView)paramContext.findViewById(2131297371)).setTextColor(Color.parseColor("#40A0FF"));
    paramContext.show();
    return paramContext;
  }
  
  public static String a()
  {
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void a()
  {
    a();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      if (localIntent.resolveActivity(paramContext.getPackageManager()) != null)
      {
        localIntent.resolveActivity(paramContext.getPackageManager());
        paramContext.startActivity(Intent.createChooser(localIntent, "请选择浏览器"));
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(RedTouch paramRedTouch)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_desc.set("");
    localRedTypeInfo.red_content.set("");
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    paramRedTouch.a(localRedTypeInfo);
  }
  
  public static void a(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "setPrivacyPolicyStatus, state=" + paramString);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (b().equals("1")) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "hasShowRedDotState, hasShow=" + bool);
    }
    return bool;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool3 = false;
    if (a().equals("0")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (paramInt == 0)
      {
        bool2 = bool1;
        if (bool1)
        {
          if (!a()) {
            break label102;
          }
          bool1 = bool3;
        }
      }
      label102:
      for (;;)
      {
        bool2 = bool1;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PrivacyPolicyHelper", 2, "needShowPrivacyPolicy, needShow=" + bool2 + ", from=" + paramInt);
          }
          return bool2;
          bool2 = bool1;
          if (paramInt == 1)
          {
            bool2 = bool1;
            if (bool1)
            {
              b("1");
              bool2 = bool1;
            }
          }
        }
      }
    }
  }
  
  public static String b()
  {
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void b(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "setHasShowRedDotState, state=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrivacyPolicyHelper
 * JD-Core Version:    0.7.0.1
 */