import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.qav.activity.QavInviteActivity;
import mqq.app.permission.PermissionCallback;

public class lin
  implements PermissionCallback
{
  public lin(QavInviteActivity paramQavInviteActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a, paramInt, paramArrayOfString, new lio(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lin
 * JD-Core Version:    0.7.0.1
 */