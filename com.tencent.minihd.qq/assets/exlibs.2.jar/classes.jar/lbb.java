import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupConfirmActivity;

public class lbb
  implements Runnable
{
  public lbb(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbb
 * JD-Core Version:    0.7.0.1
 */