import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import mqq.app.permission.PermissionCallback;

public class cnf
  implements PermissionCallback
{
  public cnf(ScannerActivity paramScannerActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a, paramInt, paramArrayOfString, new cng(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.startActivity(this.a.getIntent());
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cnf
 * JD-Core Version:    0.7.0.1
 */