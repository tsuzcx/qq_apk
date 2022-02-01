import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class lzw
  implements DialogInterface.OnDismissListener
{
  public lzw(QQWiFiPluginInstallActivity paramQQWiFiPluginInstallActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lzw
 * JD-Core Version:    0.7.0.1
 */