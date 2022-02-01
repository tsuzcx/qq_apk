import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.DecodeCompletionListener;
import java.lang.ref.WeakReference;

public final class kpi
  extends Handler
{
  public kpi(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        return;
      } while (paramMessage.what != FaceDecodeTask.a());
      paramMessage = (FaceDecodeTask)paramMessage.obj;
    } while ((paramMessage == null) || (FaceDecodeTask.a(paramMessage) == null) || (FaceDecodeTask.a(paramMessage) == null) || (FaceDecodeTask.a(paramMessage).get() == null));
    FaceDecodeTask.DecodeCompletionListener localDecodeCompletionListener = (FaceDecodeTask.DecodeCompletionListener)FaceDecodeTask.a(paramMessage).get();
    if (FaceDecodeTask.a(paramMessage))
    {
      FaceDecodeTask.a(paramMessage).b = 2;
      localDecodeCompletionListener.a(FaceDecodeTask.a(paramMessage), FaceDecodeTask.a(paramMessage));
      return;
    }
    localDecodeCompletionListener.a(FaceDecodeTask.a(paramMessage), FaceDecodeTask.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kpi
 * JD-Core Version:    0.7.0.1
 */