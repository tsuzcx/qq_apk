import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.lang.ref.WeakReference;

public class gpc
  extends Handler
{
  private WeakReference a;
  
  public gpc(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    do
    {
      return;
      paramMessage = (View)this.a.get();
    } while (paramMessage == null);
    paramMessage.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gpc
 * JD-Core Version:    0.7.0.1
 */