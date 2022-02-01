import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.PermissionsDialog.PermissionDialogCallback;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;

public class dcl
  implements DialogInterface.OnClickListener
{
  public dcl(PermissionsDialog paramPermissionsDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", PermissionsDialog.a(this.a).getPackageName(), null));
    }
    while (paramInt != 0) {
      try
      {
        PermissionsDialog.a(this.a).startActivity(paramDialogInterface);
        PermissionsDialog.a(this.a).b();
        return;
      }
      catch (Exception paramDialogInterface)
      {
        for (;;)
        {
          paramDialogInterface.printStackTrace();
        }
      }
    }
    PermissionsDialog.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dcl
 * JD-Core Version:    0.7.0.1
 */