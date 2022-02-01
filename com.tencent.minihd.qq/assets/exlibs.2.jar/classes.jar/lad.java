import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.qphone.base.util.QLog;

public class lad
  implements Runnable
{
  public lad(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    Object localObject = this.a;
    int i = ((AuthorityActivity)localObject).A;
    ((AuthorityActivity)localObject).A = (i - 1);
    if (i > 0)
    {
      localObject = (String)this.a.getResources().getText(2131368102);
      AuthorityActivity localAuthorityActivity = this.a;
      i = localAuthorityActivity.B;
      localAuthorityActivity.B = (i + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.b, 500L);
        return;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·  ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·· ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "···");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.a.g = true;
    this.a.h = false;
    if (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "AutoAuth:" + SystemClock.elapsedRealtime());
      }
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AutoAuth -- doAuthorize(): " + SystemClock.elapsedRealtime());
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lad
 * JD-Core Version:    0.7.0.1
 */