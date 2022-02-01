import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchActivity;
import java.util.List;

public class cgw
  extends Handler
{
  public cgw(SearchActivity paramSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)paramMessage.obj;
      this.a.a(paramMessage, true);
      return;
    }
    paramMessage = (List)paramMessage.obj;
    this.a.a(paramMessage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgw
 * JD-Core Version:    0.7.0.1
 */