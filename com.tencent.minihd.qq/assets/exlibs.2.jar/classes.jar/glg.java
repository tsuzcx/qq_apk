import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.FloatAioController;
import com.tencent.mobileqq.activity.flaotaio.RootCallBack;

public class glg
  implements RootCallBack
{
  public glg(FloatAioController paramFloatAioController) {}
  
  public void a(View paramView)
  {
    FloatAioController.a(this.a).removeMessages(21);
  }
  
  public void b(View paramView)
  {
    this.a.b();
  }
  
  public void c(View paramView)
  {
    FloatAioController.a(this.a).sendEmptyMessageDelayed(21, 2000L);
  }
  
  public void i() {}
  
  public void p() {}
  
  public void s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glg
 * JD-Core Version:    0.7.0.1
 */