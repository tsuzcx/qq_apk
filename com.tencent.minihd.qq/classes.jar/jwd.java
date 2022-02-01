import android.os.Process;
import com.tencent.mobileqq.PermissionsDialog.PermissionDialogCallback;
import com.tencent.mobileqq.startup.step.SetPermission;
import mqq.app.AppActivity;

class jwd
  implements PermissionDialogCallback
{
  jwd(jwc paramjwc) {}
  
  public void a()
  {
    SetPermission.a(this.a.a).superFinish();
    Process.killProcess(Process.myPid());
  }
  
  public void b()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwd
 * JD-Core Version:    0.7.0.1
 */