import android.os.HandlerThread;
import android.os.Process;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.qbar.QbarNative;
import com.tencent.qphone.base.util.QLog;

public class cqy
  extends HandlerThread
{
  public boolean a = false;
  
  public cqy(String paramString)
  {
    super(paramString);
  }
  
  public boolean quit()
  {
    this.a = true;
    if (QLog.isColorLevel()) {
      QLog.d(ScannerView.a, 2, "decode thread quit");
    }
    try
    {
      QbarNative.Release();
      return super.quit();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(ScannerView.a, 2, localUnsatisfiedLinkError.toString());
        }
      }
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(-20);
    try
    {
      int i = QbarNative.Init(2, 0, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 0;
      int j = QbarNative.SetReaders((int[])localObject, localObject.length);
      localObject = QbarNative.GetVersion();
      if (QLog.isDevelopLevel())
      {
        QLog.d(ScannerView.a, 4, "init_result1:" + i + ",init_result2:" + j);
        QLog.d(ScannerView.a, 4, "version:" + (String)localObject);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(ScannerView.a, 2, localUnsatisfiedLinkError.toString());
        }
      }
    }
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqy
 * JD-Core Version:    0.7.0.1
 */