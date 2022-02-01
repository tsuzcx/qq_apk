import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.flaotaio.FloatAioController;
import com.tencent.mobileqq.activity.flaotaio.FloatMsgBar;
import com.tencent.mobileqq.activity.flaotaio.SlipFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class glj
  implements Runnable
{
  public glj(FloatAioController paramFloatAioController) {}
  
  public void run()
  {
    if (FloatAioController.a(this.a) == null) {
      FloatAioController.a(this.a, FloatAioController.b(this.a));
    }
    ((SlipFrameLayout)FloatAioController.a(this.a).b()).a();
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if ((this.a.a()) && (FloatAioController.a(this.a).b().getParent() == null))
    {
      localWindowManager = (WindowManager)FloatAioController.a(this.a).a().getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      this.a.a = localLayoutParams;
      localLayoutParams.flags = 40;
      localLayoutParams.format = -3;
      localLayoutParams.gravity = 53;
      localLayoutParams.x = 0;
      localLayoutParams.y = ((int)(70.0F * FloatAioController.a(this.a)));
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.type = 2002;
      localLayoutParams.windowAnimations = 0;
    }
    try
    {
      localWindowManager.addView(FloatAioController.a(this.a).b(), localLayoutParams);
      label181:
      FloatAioController.a(this.a, true);
      FloatAioController.a(this.a).b().post(new glk(this));
      if (FloatAioController.a(this.a).isBackground_Stop)
      {
        ReportController.b(FloatAioController.a(this.a), "CliOper", "", "", "0X800617C", "0X800617C", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(FloatAioController.a(this.a), "CliOper", "", "", "0X800617A", "0X800617A", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      break label181;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glj
 * JD-Core Version:    0.7.0.1
 */