import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.widget.QQToast;

public class dui
  extends Handler
{
  public dui(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.u == 1) || (this.a.u == 2)))
    {
      this.a.b();
      QQToast.a(this.a, 2131369486, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dui
 * JD-Core Version:    0.7.0.1
 */