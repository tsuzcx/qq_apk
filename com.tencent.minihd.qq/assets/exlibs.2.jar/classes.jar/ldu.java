import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public class ldu
  implements Runnable
{
  public ldu(BaseInterface paramBaseInterface, long paramLong, List paramList, WebView paramWebView) {}
  
  public void run()
  {
    String str = "javascript:QzoneApp.fire('batchCallback',{'guid':" + this.jdField_a_of_type_Long + ",'r':0,'data':" + this.jdField_a_of_type_JavaUtilList.toString() + "});";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(str);
      label58:
      LogUtility.b(BaseInterface.TAG, "Response<callBatch> AsyncInterface result : " + str);
      return;
      LogUtility.e(BaseInterface.TAG, "Response<callBatch> AsyncInterface result : webview is null !!!");
      return;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ldu
 * JD-Core Version:    0.7.0.1
 */