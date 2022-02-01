import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class lyz
  extends RemoteCommand
{
  public lyz(DatalineRemoteManager paramDatalineRemoteManager, String paramString)
  {
    super(paramString);
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    paramBundle = DatalineRemoteManager.a(this.a, paramBundle);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lyz
 * JD-Core Version:    0.7.0.1
 */