import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import java.util.ArrayList;

public class igr
  extends Handler
{
  public igr(EmotionPreviewLayout paramEmotionPreviewLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 10000: 
    case 10001: 
      do
      {
        return;
        this.a.setVisibility(8);
        return;
      } while (paramMessage.obj == null);
      paramMessage = (ArrayList)paramMessage.obj;
      this.a.a(true, paramMessage);
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igr
 * JD-Core Version:    0.7.0.1
 */