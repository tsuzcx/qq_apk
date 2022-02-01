import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;

class ery
  extends BroadcastReceiver
{
  ery(erx paramerx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "onReceive qb download report");
    }
    if ((!this.a.a.isFinishing()) && (!this.a.a.k))
    {
      paramContext = this.a.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension();
      if (paramContext != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQBrowser", 2, "report qb download");
        }
        paramContext.invokeMiscMethod("HitQBAppDownloadCounts", new Bundle());
      }
      abortBroadcast();
    }
    if (this.a.a.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.a.a.unregisterReceiver(this.a.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.a.a.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ery
 * JD-Core Version:    0.7.0.1
 */