import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.nearpeople.TurnBrandDownloader;
import com.tencent.mobileqq.nearpeople.TurnBrandDownloader.ImageRef;
import java.util.Queue;
import java.util.Stack;

public class jkw
  extends Handler
{
  public jkw(TurnBrandDownloader paramTurnBrandDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Object localObject1;
    label96:
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1052688: 
          Object localObject2 = null;
          localObject1 = localObject2;
          if (paramMessage.obj == null) {
            break label96;
          }
          localObject1 = localObject2;
          if (!(paramMessage.obj instanceof TurnBrandDownloader.ImageRef)) {
            break label96;
          }
          localObject1 = (TurnBrandDownloader.ImageRef)paramMessage.obj;
          paramMessage = ((TurnBrandDownloader.ImageRef)localObject1).a;
          localObject1 = ((TurnBrandDownloader.ImageRef)localObject1).b;
        }
      } while ((localObject1 == null) || (paramMessage == null));
      localObject1 = TurnBrandDownloader.a(this.a, paramMessage, (String)localObject1);
    } while (TurnBrandDownloader.a(this.a) == null);
    paramMessage = TurnBrandDownloader.a(this.a).obtainMessage(2105376, localObject1);
    TurnBrandDownloader.a(this.a).sendMessage(paramMessage);
    return;
    TurnBrandDownloader.a(this.a).clear();
    TurnBrandDownloader.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkw
 * JD-Core Version:    0.7.0.1
 */