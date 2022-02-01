import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.TimedOnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class cjp
  implements Runnable
{
  public cjp(PublicAccountJavascriptInterface.TimedOnLocationListener paramTimedOnLocationListener, PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface$TimedOnLocationListener.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface$TimedOnLocationListener.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface$TimedOnLocationListener.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface$TimedOnLocationListener.jdField_a_of_type_JavaLangString, new String[] { "-2", "{type:1, data:null}" });
    String str = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface$TimedOnLocationListener.jdField_a_of_type_Long);
    ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 3, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface$TimedOnLocationListener.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), str, "", "");
    SosoInterface.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface$TimedOnLocationListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjp
 * JD-Core Version:    0.7.0.1
 */