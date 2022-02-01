import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import java.util.TimerTask;

public class jbp
  extends TimerTask
{
  public jbp(FileWebView paramFileWebView, Handler paramHandler) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jbp
 * JD-Core Version:    0.7.0.1
 */