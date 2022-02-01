import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.PermissionsDialog.PermissionDialogCallback;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;

public class dcn
  implements DialogInterface.OnClickListener
{
  public dcn(PermissionsDialog paramPermissionsDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      PermissionsDialog.a(this.a).b();
    }
    while (paramInt != 0) {
      return;
    }
    PermissionsDialog.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dcn
 * JD-Core Version:    0.7.0.1
 */