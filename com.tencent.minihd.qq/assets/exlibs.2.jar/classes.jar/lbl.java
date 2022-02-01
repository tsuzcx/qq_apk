import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.DeviceShareFriendChooser;
import com.tencent.open.agent.OpenSdkFriendService;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.settings.ServerSetting;

public class lbl
  extends Handler
{
  public lbl(DeviceShareFriendChooser paramDeviceShareFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", CommonDataAdapter.a().d());
      paramMessage.putString("facetype", "mqqface");
      String str = ServerSetting.a().a("https://fusion.qq.com/cgi-bin/appstage/get_image_update");
      OpenSdkFriendService.a().a(str, paramMessage, new lbm(this));
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask != null) && (!this.a.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.isCancelled())) {
      this.a.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.cancel(true);
    }
    this.a.d();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", "网络连接超时!");
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbl
 * JD-Core Version:    0.7.0.1
 */