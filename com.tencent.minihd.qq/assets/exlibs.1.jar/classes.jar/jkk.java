import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearpeople.TurnBrandActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jkk
  extends Handler
{
  public jkk(TurnBrandActivity paramTurnBrandActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1184275: 
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandActivity", 2, "rcv MSG_LOAD_LIST!");
      }
      if (NetworkUtil.f(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TurnBrandActivity", 2, "network connected, getLbsTurnBrandUserList: ");
        }
        if (TurnBrandActivity.a(this.a).size() > 0)
        {
          TurnBrandActivity.a(this.a).a(TurnBrandActivity.a(this.a));
          TurnBrandActivity.a(this.a, System.currentTimeMillis());
          TurnBrandActivity.a(this.a).clear();
        }
        ThreadManager.a(new jkl(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrandActivity", 2, "network not connected, reloading!");
      }
      this.a.b(2001, this.a.getString(2131369584));
      return;
    }
    this.a.a(2005, true);
    ImageView localImageView1 = (ImageView)TurnBrandActivity.a(this.a).findViewById(2131300301);
    ImageView localImageView2 = (ImageView)TurnBrandActivity.a(this.a).findViewById(2131300300);
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(8);
    if (paramMessage.arg1 == 1)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
      return;
    }
    if (paramMessage.arg1 == 2)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
      return;
    }
    this.a.a(2005, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkk
 * JD-Core Version:    0.7.0.1
 */