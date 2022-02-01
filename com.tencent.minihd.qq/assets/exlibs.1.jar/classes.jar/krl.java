import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import mqq.app.permission.PermissionCallback;

public final class krl
  implements PermissionCallback
{
  public krl(SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a, paramInt, paramArrayOfString, new krm(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     krl
 * JD-Core Version:    0.7.0.1
 */