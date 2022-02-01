import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.step.SetPermission;
import java.io.PrintStream;
import mqq.app.permission.PermissionCallback;

public class jwc
  implements PermissionCallback
{
  public jwc(SetPermission paramSetPermission) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(SetPermission.a(this.a), paramInt, paramArrayOfString, new jwd(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 100) {
      this.a.a.c();
    }
    for (;;)
    {
      System.out.println("success  +++++++++++++++++++++++++++++++");
      return;
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwc
 * JD-Core Version:    0.7.0.1
 */