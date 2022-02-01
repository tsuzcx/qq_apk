import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class fox
  extends TransProcessorHandler
{
  public fox(FileTransferManager paramFileTransferManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fox
 * JD-Core Version:    0.7.0.1
 */