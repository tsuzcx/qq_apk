import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qphone.base.util.QLog;

public class lik
  implements Runnable
{
  public lik(QavChatActivity paramQavChatActivity) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavChatActivity", 4, "onWindowFocusChangedRunnable, nfonWindowFocus[" + this.a.a + "->true]");
    }
    this.a.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lik
 * JD-Core Version:    0.7.0.1
 */