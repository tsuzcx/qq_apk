package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.http.utils.AsyncHttpConnection;
import com.tencent.open.adapter.CommonDataAdapter;
import dbq;
import dbr;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportInfoManager
{
  private static ReportInfoManager jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager;
  public static final String a = "profile";
  public static final String b = "download";
  public static final String c = "start";
  public static final String d = "finish";
  public static final String e = "cancel";
  private static final String f = "gamecenter_preferences";
  private static final String g = "report_info";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static ReportInfoManager a()
  {
    if (jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager == null) {
      jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager = new ReportInfoManager();
    }
    return jdField_a_of_type_ComTencentGamecenterCommonUtilReportInfoManager;
  }
  
  private void b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("gamecenter_preferences", 0).edit();
    paramContext.putString("report_info", a());
    paramContext.commit();
  }
  
  public ReportInfoManager.ReportPGActInfo a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ReportInfoManager.ReportPGActInfo localReportPGActInfo = new ReportInfoManager.ReportPGActInfo();
    localReportPGActInfo.a = paramString1;
    localReportPGActInfo.b = paramString2;
    localReportPGActInfo.f = Build.MODEL;
    localReportPGActInfo.c = "1";
    localReportPGActInfo.e = paramString3;
    localReportPGActInfo.jdField_i_of_type_Int = 108;
    localReportPGActInfo.g = paramString4;
    localReportPGActInfo.j = 16001;
    localReportPGActInfo.jdField_h_of_type_Int = 1;
    localReportPGActInfo.jdField_h_of_type_JavaLangString = paramString5;
    localReportPGActInfo.d = CommonDataAdapter.a().c();
    return localReportPGActInfo;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return "";
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        dbr localdbr = (dbr)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("appid", localdbr.a);
        localJSONObject2.put("actionname", localdbr.b);
        localJSONObject2.put("timestamp", localdbr.c);
        localJSONArray.put(localJSONObject2);
        continue;
        return localJSONObject1.toString();
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      localJSONObject1.put("items", localJSONException);
    }
  }
  
  public String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("gamecenter_preferences", 0).getString("report_info", "");
  }
  
  public String a(ReportInfoManager.ReportPGActInfo paramReportPGActInfo)
  {
    if (paramReportPGActInfo == null) {
      return "{}";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramReportPGActInfo.a);
      localJSONObject.put("entrance_status", paramReportPGActInfo.b);
      localJSONObject.put("gamecenter_src", paramReportPGActInfo.c);
      localJSONObject.put("oper_moudle", paramReportPGActInfo.jdField_h_of_type_Int);
      localJSONObject.put("module_type", paramReportPGActInfo.jdField_i_of_type_Int);
      localJSONObject.put("oper_id", paramReportPGActInfo.j);
      localJSONObject.put("sq_ver", paramReportPGActInfo.d);
      localJSONObject.put("gamecenter_ver", paramReportPGActInfo.e);
      localJSONObject.put("device_type", paramReportPGActInfo.f);
      localJSONObject.put("net_type", paramReportPGActInfo.g);
      localJSONObject.put("resolution", paramReportPGActInfo.jdField_h_of_type_JavaLangString);
      localJSONObject.put("ret_id", paramReportPGActInfo.jdField_i_of_type_JavaLangString);
      return localJSONObject.toString();
    }
    catch (JSONException paramReportPGActInfo)
    {
      for (;;)
      {
        paramReportPGActInfo.printStackTrace();
      }
    }
  }
  
  public void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("gamecenter_preferences", 0).edit();
    paramContext.putString("report_info", "");
    paramContext.commit();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    dbr localdbr = new dbr();
    localdbr.a = paramString1;
    localdbr.b = paramString2;
    localdbr.c = paramString3;
    this.jdField_a_of_type_JavaUtilArrayList.add(localdbr);
    b(paramContext);
  }
  
  public void a(ReportInfoManager.ReportPGActInfo paramReportPGActInfo, String paramString)
  {
    if (paramReportPGActInfo == null) {
      return;
    }
    paramReportPGActInfo = a(paramReportPGActInfo);
    long l = paramReportPGActInfo.getBytes().length;
    paramString = String.format("https://gamecenter.qq.com/report/pg_act?appid=%1$s&sid=%2$s&tt=1&osv=%3$s", new Object[] { Integer.valueOf(AppSetting.a), paramString, Build.VERSION.RELEASE });
    new AsyncHttpConnection(new dbq(this, l)).b(paramString, paramReportPGActInfo);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              dbr localdbr = new dbr();
              localdbr.a = localJSONObject.getString("appid");
              localdbr.b = localJSONObject.getString("actionname");
              localdbr.c = localJSONObject.getString("timestamp");
              this.jdField_a_of_type_JavaUtilArrayList.add(localdbr);
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager
 * JD-Core Version:    0.7.0.1
 */