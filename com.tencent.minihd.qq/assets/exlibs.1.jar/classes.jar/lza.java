import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qqdataline.DatalinePluginProxyActivity;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class lza
  implements Runnable
{
  public lza(DatalineRemoteManager paramDatalineRemoteManager, boolean paramBoolean) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(536870912);
    localIntent.putExtra("isFromStatusbar", this.jdField_a_of_type_Boolean);
    DatalinePluginProxyActivity.a(BaseActivity.sTopActivity, this.jdField_a_of_type_CooperationQqdatalineIpcDatalineRemoteManager.a.getAccount(), localIntent, "com.qqdataline.activity.LiteWifiphotoActivity", -1, null);
    BaseActivity.sTopActivity.overridePendingTransition(2130968595, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lza
 * JD-Core Version:    0.7.0.1
 */