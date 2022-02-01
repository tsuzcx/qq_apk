import android.app.Dialog;
import com.tencent.mobileqq.activity.ChatHistory;

class dly
  extends Thread
{
  dly(dlx paramdlx) {}
  
  public void run()
  {
    ChatHistory.a(this.a.a, this.a.a.d, this.a.a.a);
    this.a.a.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dly
 * JD-Core Version:    0.7.0.1
 */