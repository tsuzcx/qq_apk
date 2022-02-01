package com.tencent.open.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.lang.ref.WeakReference;
import java.net.URL;

public class ServerSetting
{
  public static final String A = "https://mapp.qzone.qq.com/cgi-bin/mapp/mapp_report";
  protected static final String B = ServerSetting.class.getName();
  protected static ServerSetting a;
  public static final String a = "https://openmobile.qq.com/";
  public static final String b = "https://fusion.qq.com/cgi-bin/qzapps/mapp_getappinfo.cgi";
  public static final String c = "https://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi";
  public static final String d = "https://i.gtimg.cn/open/app_icon/%s/%s/%s/%s/%s_%d_m.png";
  public static final String e = "https://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi";
  public static final String f = "https://fusion.qq.com/cgi-bin/appstage/mapp_sendstory.cgi";
  public static final String g = "https://appic.qq.com/cgi-bin/appstage/mapp_sendbragging.cgi";
  public static final String h = "https://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi";
  public static final String i = "https://mapp.qzone.qq.com/cgi-bin/mapp/mapp_setcomment";
  public static final String j = "https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi";
  public static final String k = "https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi";
  public static final String l = "https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi";
  public static final String m = "https://q.qlogo.cn/qqapp/%s/%s/%d";
  public static final String n = "https://fusion.qq.com/cgi-bin/appstage/get_image_update";
  public static final String o = "https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi";
  public static final String p = "https://appic.qq.com/cgi-bin/appstage/mapp_sendmultimedia";
  public static final String q = "https://openmobile.qq.com/oauth2.0/m_sdkstatics";
  public static final String r = "https://analy.qq.com/cgi-bin/mapp_apptrace";
  public static final String s = "https://wspeed.qq.com/w.cgi";
  public static final String t = "https://appsupport.qq.com/cgi-bin/qzapps/mobile_statis_report";
  public static final String u = "https://appic.qq.com/cgi-bin/appstage/mapp_getrequest.cgi";
  public static final String v = "https://mapp.qzone.qq.com/cgi-bin/mapp/mapp_mng";
  public static final String w = "https://appsupport.qq.com/cgi-bin/appstage/check_update";
  public static final String x = "https://mapp.qzone.qq.com/cgi-bin/mapp/mapp_info";
  public static final String y = "https://mapp.qzone.qq.com/cgi-bin/mapp/mapp_latest_used_app_qzone";
  public static final String z = "https://mapp.qzone.qq.com/cgi-bin/mapp/mapp_cate_qzone";
  protected volatile WeakReference a;
  
  static
  {
    jdField_a_of_type_ComTencentOpenSettingsServerSetting = null;
  }
  
  public ServerSetting()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public static ServerSetting a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenSettingsServerSetting == null) {
        jdField_a_of_type_ComTencentOpenSettingsServerSetting = new ServerSetting();
      }
      ServerSetting localServerSetting = jdField_a_of_type_ComTencentOpenSettingsServerSetting;
      return localServerSetting;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public String a(String paramString, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(OpensdkPreference.a(CommonDataAdapter.a().a(), "OpenSettings"));
    }
    String str1 = paramString;
    String str2;
    SharedPreferences localSharedPreferences;
    String str3;
    try
    {
      str2 = new URL(paramString).getHost();
      if (str2 == null)
      {
        str1 = paramString;
        LogUtility.e(B, "Get host error. url=" + paramString);
        return paramString;
      }
      str1 = paramString;
      localSharedPreferences = (SharedPreferences)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      str1 = paramString;
      if (localSharedPreferences == null) {
        return str1;
      }
      str1 = paramString;
      str3 = localSharedPreferences.getString(str2, null);
      if (str3 != null)
      {
        str1 = paramString;
        if (!str2.equals(str3)) {}
      }
      else
      {
        str1 = paramString;
        LogUtility.c(B, "host=" + str2 + ", envHost=" + str3);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      LogUtility.e(B, "getEnvUrl error. url=" + str1);
      return str1;
    }
    if (paramBundle != null)
    {
      str1 = paramString;
      paramBundle.putString("env", localSharedPreferences.getString("OpenEnvironment", "formal"));
    }
    str1 = paramString;
    paramString = paramString.replace(str2, str3);
    str1 = paramString;
    LogUtility.c(B, "return environment url : " + paramString);
    str1 = paramString;
    return str1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.settings.ServerSetting
 * JD-Core Version:    0.7.0.1
 */