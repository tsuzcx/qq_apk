package com.tencent.biz.pubaccount;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.pubaccount.util.Encrypt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.ThreeDes;

public class PublicAccountJavascriptInterface$TimedOnLocationListener
  extends SosoInterface.OnLocationListener
{
  int jdField_a_of_type_Int;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  public boolean a;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean;
  boolean d;
  
  private PublicAccountJavascriptInterface$TimedOnLocationListener(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, String paramString) {}
  
  public PublicAccountJavascriptInterface$TimedOnLocationListener(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, int paramInt, String paramString, long paramLong)
  {
    this(paramPublicAccountJavascriptInterface, paramInt, -1L, paramLong, false, false, 0, false, paramString);
  }
  
  public PublicAccountJavascriptInterface$TimedOnLocationListener(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, long paramLong)
  {
    this(paramPublicAccountJavascriptInterface, paramInt1, 10000L, paramLong, true, paramBoolean1, paramInt2, paramBoolean2, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      if (paramInt == 0)
      {
        double d1 = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a;
        double d2 = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", "{type:2, lat:" + d1 + ", lon:" + d2 + "}" });
        }
        for (;;)
        {
          paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
          return;
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.format("'%1$f,%2$f'", new Object[] { Double.valueOf(d2), Double.valueOf(d1) }) });
        }
      }
      paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
      return;
    }
    byte[] arrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null)
    {
      if (this.d) {}
      for (;;)
      {
        try
        {
          paramSosoLbsInfo = ThreeDes.a(PublicAccountJavascriptInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, arrayOfByte), "nbyvie");
          label260:
          if (TextUtils.isEmpty(paramSosoLbsInfo)) {
            break label765;
          }
          paramInt = 1;
          label269:
          if (paramInt == 0) {
            break label573;
          }
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          SosoInterface.b(this);
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", "{type:1, decrypt_padding:" + this.jdField_a_of_type_Int + ",data:\"" + paramSosoLbsInfo + "\"}" });
          paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
          if (arrayOfByte == null) {
            break;
          }
          paramSosoLbsInfo = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
          if (paramSosoLbsInfo == null) {
            break;
          }
          paramSosoLbsInfo = paramSosoLbsInfo.getUrl();
          if ((TextUtils.isEmpty(paramSosoLbsInfo)) || (!paramSosoLbsInfo.contains("_bid=108"))) {
            break;
          }
          BnrReport.a(null, 81, "", 0, 0, Base64Util.encodeToString(arrayOfByte, 2), "", "", "");
          return;
        }
        catch (Exception paramSosoLbsInfo)
        {
          paramSosoLbsInfo.printStackTrace();
          paramSosoLbsInfo = "";
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_Int == 1) {}
          for (boolean bool = true;; bool = false)
          {
            paramSosoLbsInfo = Base64Util.encodeToString(Encrypt.a(bool, Encrypt.a(arrayOfByte), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB"), 2);
            break;
          }
          paramSosoLbsInfo = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
        }
        catch (Exception localException)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime == null) {}
        }
      }
    }
    for (;;)
    {
      if (paramSosoLbsInfo != null) {
        ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, paramSosoLbsInfo.getAccount(), localException.getMessage(), "", "");
      }
      paramSosoLbsInfo = "";
      break label260;
      label573:
      if (this.jdField_b_of_type_Boolean)
      {
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        long l3 = this.jdField_b_of_type_Long - l1;
        if (l3 <= 0L) {
          break;
        }
        long l2 = this.jdField_c_of_type_Long - l1;
        l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
        SosoInterface.b(this);
        SosoInterface.a(new TimedOnLocationListener(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, 0, l3, l1, false, false, 0, true, this.jdField_a_of_type_JavaLangString));
        paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 2, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
        return;
      }
      paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSosoLbsInfo, "", "");
      return;
      label765:
      paramInt = 0;
      break label269;
      paramSosoLbsInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.TimedOnLocationListener
 * JD-Core Version:    0.7.0.1
 */