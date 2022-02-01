package com.tencent.component.network.module.report;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.component.network.Global;
import com.tencent.component.network.module.base.a;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.e;
import org.json.JSONObject;

public class ReportObj
{
  public static boolean a = false;
  public static final int g = 0;
  public static final String g = "mqun";
  public static final int h = 2;
  public static final int i = 4;
  public static final int j = 6;
  public static final int k = 8;
  public static final int l = 10;
  public static final int m = 0;
  public static final int n = 1;
  public ExtendData a;
  public StringBuilder a;
  public long h;
  public String h;
  public long i;
  public String i;
  public long j;
  public String j;
  public long k;
  public String k;
  public int o = 0;
  public int p = 0;
  public int q;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public ReportObj()
  {
    this.jdField_h_of_type_JavaLangString = "Android";
    this.jdField_i_of_type_JavaLangString = "0.0.1";
    this.jdField_j_of_type_JavaLangString = "unknown";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData = null;
  }
  
  public ReportObj(int paramInt1, int paramInt2, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt3, String paramString2, ExtendData paramExtendData)
  {
    this.jdField_h_of_type_JavaLangString = "Android";
    this.jdField_i_of_type_JavaLangString = "0.0.1";
    this.jdField_j_of_type_JavaLangString = "unknown";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData = null;
    this.o = paramInt1;
    this.p = paramInt2;
    this.jdField_k_of_type_JavaLangString = paramString1;
    this.jdField_h_of_type_Long = paramLong1;
    this.jdField_j_of_type_Long = paramLong2;
    this.jdField_k_of_type_Long = paramLong3;
    this.jdField_i_of_type_Long = (paramLong3 - paramLong2);
    this.q = paramInt3;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString1);
    this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData = paramExtendData;
  }
  
  private static String a(int paramInt)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2 = localStringBuffer2.append(paramInt & 0xFF).append('.');
    paramInt >>>= 8;
    localStringBuffer2.append(paramInt & 0xFF).append('.').append(paramInt >>> 8 & 0xFF);
    return localStringBuffer1.toString();
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str;
    switch (paramInt1)
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return "";
    case 0: 
      str = "http://p.store.qq.com/" + "photo";
    }
    for (;;)
    {
      str = str + "?";
      if (paramInt2 != 0) {
        break;
      }
      return str + "op=upload";
      str = "http://p.store.qq.com/" + "qzone_video";
      continue;
      str = "http://p.store.qq.com/" + "qzone_sound";
      continue;
      str = "http://p.store.qq.com/" + "qzone_head";
      continue;
      str = "http://p.store.qq.com/" + "upp";
      continue;
      str = "http://p.store.qq.com/" + "groupphoto";
    }
    if (paramInt2 == 1) {
      return str + "op=down";
    }
    return "";
  }
  
  public String a()
  {
    return this.jdField_j_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    label374:
    for (;;)
    {
      try
      {
        localJSONObject.put("size", this.jdField_h_of_type_Long);
        localJSONObject.put("delay", this.jdField_i_of_type_Long);
        localJSONObject.put("network", this.o);
        localJSONObject.put("terminal", this.jdField_h_of_type_JavaLangString);
        localJSONObject.put("terminalver", this.jdField_i_of_type_JavaLangString);
        localJSONObject.put("refer", a());
        localJSONObject.put("errcode", this.p);
        localJSONObject.put("uin", a.a());
        localJSONObject.put("time", this.jdField_k_of_type_Long / 1000L);
        localJSONObject.put("flow", this.q);
        localJSONObject.put("sip", this.jdField_k_of_type_JavaLangString);
        if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0))
        {
          localJSONObject.put("msg", this.jdField_a_of_type_JavaLangStringBuilder.toString());
          if (this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData == null) {
            this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData = new ExtendData();
          }
          Object localObject = ((WifiManager)Global.a().getSystemService("wifi")).getDhcpInfo();
          if (localObject == null) {
            break label374;
          }
          localObject = a(((DhcpInfo)localObject).dns1) + "," + a(((DhcpInfo)localObject).dns2);
          this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a(0, Build.MODEL);
          this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a(1, Build.VERSION.RELEASE);
          ExtendData localExtendData = this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData;
          if (e.a())
          {
            i1 = 1;
            localExtendData.a(2, String.valueOf(i1));
            this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a(3, e.b());
            this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a(4, e.c());
            this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a(6, (String)localObject);
            localObject = this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData;
            if (!jdField_a_of_type_Boolean) {
              continue;
            }
            i1 = 1;
            ((ExtendData)localObject).a(7, String.valueOf(i1));
            localJSONObject.put("extend", this.jdField_a_of_type_ComTencentComponentNetworkModuleReportExtendData.a());
          }
        }
        else
        {
          return localJSONObject;
        }
        int i1 = 0;
        continue;
        i1 = 0;
        continue;
        String str = "none";
      }
      catch (Throwable localThrowable)
      {
        b.d("BusinessReport", "to json error!", localThrowable);
        return localJSONObject;
      }
    }
  }
  
  public void a()
  {
    this.jdField_h_of_type_JavaLangString = a.a();
    this.jdField_i_of_type_JavaLangString = a.b();
    this.jdField_j_of_type_JavaLangString = a.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("networkType = ");
    switch (this.o)
    {
    default: 
      localStringBuilder.append("未知");
    }
    for (;;)
    {
      localStringBuilder.append(" retCode = ");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" fileSize = ");
      localStringBuilder.append(this.jdField_h_of_type_Long);
      localStringBuilder.append(" elapse = ");
      localStringBuilder.append(this.jdField_i_of_type_Long);
      localStringBuilder.append(" errMsg = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return localStringBuilder.toString();
      localStringBuilder.append("WIFI");
      continue;
      localStringBuilder.append("3G");
      continue;
      localStringBuilder.append("2G");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.ReportObj
 * JD-Core Version:    0.7.0.1
 */