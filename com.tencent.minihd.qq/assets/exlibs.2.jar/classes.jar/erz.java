import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

public final class erz
  implements QbSdk.PreInitCallback
{
  public void onCoreInitFinished()
  {
    if (QLog.isColorLevel()) {
      QLog.i("app2", 1, "asyncInitWebview QbSdk.preInit.onCoreInitFinished");
    }
  }
  
  public void onViewInitFinished(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("app2", 1, "asyncInitWebview QbSdk.preInit.onViewInitFinished isX5Core:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     erz
 * JD-Core Version:    0.7.0.1
 */