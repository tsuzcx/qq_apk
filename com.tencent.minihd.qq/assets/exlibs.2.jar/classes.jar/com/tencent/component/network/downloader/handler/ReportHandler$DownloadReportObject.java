package com.tencent.component.network.downloader.handler;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.module.report.ExtendData;
import com.tencent.component.network.module.report.ReportObj;
import org.json.JSONObject;

public class ReportHandler$DownloadReportObject
  extends ReportObj
{
  public int a;
  public long a;
  public String a;
  public Throwable a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public long g;
  
  public ReportHandler$DownloadReportObject()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 100;
  }
  
  public ReportHandler$DownloadReportObject(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong1, long paramLong2, long paramLong3, int paramInt3, String paramString4, ExtendData paramExtendData)
  {
    super(paramInt1, paramInt2, paramString3, paramLong1, paramLong2, paramLong3, paramInt3, paramString4, paramExtendData);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 100;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void b()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.indexOf("store.qq.com/qun/") >= 0)) {
      this.jdField_a_of_type_Int = 10;
    }
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Int == 10) {
      return "mqun";
    }
    return super.a();
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = super.a();
    localJSONObject.put("url", this.jdField_a_of_type_JavaLangString);
    localJSONObject.put("dnsip", this.jdField_b_of_type_JavaLangString);
    localJSONObject.put("retry", this.jdField_b_of_type_Int);
    localJSONObject.put("clientip", this.jdField_d_of_type_JavaLangString);
    localJSONObject.put("t_wait", this.jdField_b_of_type_Long);
    localJSONObject.put("t_prepare", this.jdField_c_of_type_Long);
    localJSONObject.put("t_conn", this.jdField_d_of_type_Long);
    localJSONObject.put("t_recvrsp", this.jdField_e_of_type_Long);
    localJSONObject.put("t_recvdata", this.jdField_f_of_type_Long);
    localJSONObject.put("t_process", this.g);
    localJSONObject.put("content_type", this.jdField_e_of_type_JavaLangString);
    localJSONObject.put("concurrent", this.jdField_f_of_type_Int);
    if (this.jdField_f_of_type_JavaLangString != null) {
      localJSONObject.put("refer", this.jdField_f_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData == null) {
        this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData = new ExtendData();
      }
      this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a(10, this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("extend", this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a());
    }
    if (this.jdField_a_of_type_JavaLangThrowable != null)
    {
      if (this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData == null) {
        this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData = new ExtendData();
      }
      String str2 = Log.getStackTraceString(this.jdField_a_of_type_JavaLangThrowable);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2.replaceAll("\n\t", "--");
      }
      this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a(11, str1);
      localJSONObject.put("extend", this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a());
    }
    if (this.jdField_c_of_type_Int == 2)
    {
      localJSONObject.put("orgurl", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("directip", this.k);
      localJSONObject.put("contentlen", this.h);
      localJSONObject.put("size", this.jdField_d_of_type_Int);
      localJSONObject.put("sample", this.jdField_e_of_type_Int);
      if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0))
      {
        if (localJSONObject.has("msg")) {
          localJSONObject.remove("msg");
        }
        localJSONObject.put("errdetail", this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
    }
    return localJSONObject;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    b();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject
 * JD-Core Version:    0.7.0.1
 */