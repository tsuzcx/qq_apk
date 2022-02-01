import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.dataline.activities.RouterAdvanceActivity;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Arrays;

public class cr
  extends Handler
{
  public cr(RouterAdvanceActivity paramRouterAdvanceActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if (paramMessage.arg1 != 0) {
        RouterAdvanceActivity.a(this.a, paramMessage.arg1);
      }
    }
    else {
      return;
    }
    if (paramMessage.obj != null) {
      ((DataLineHandler)this.a.app.a(8)).b(13, true, new ArrayList(Arrays.asList((DeviceInfo[])paramMessage.obj)));
    }
    this.a.getIntent().putExtra("unbind_flag", true);
    this.a.setResult(-1, this.a.getIntent());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cr
 * JD-Core Version:    0.7.0.1
 */