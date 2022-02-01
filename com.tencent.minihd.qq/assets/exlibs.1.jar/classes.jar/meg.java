import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import cooperation.thirdpay.NFCPayPluginProxyActivity;

public class meg
  implements DialogInterface.OnClickListener
{
  public meg(NFCPayPluginProxyActivity paramNFCPayPluginProxyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.NFC_SETTINGS"));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     meg
 * JD-Core Version:    0.7.0.1
 */