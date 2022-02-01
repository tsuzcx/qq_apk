import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import cooperation.qwallet.plugin.proxy.BaseNFCProxyActivity;

public class mam
  implements DialogInterface.OnClickListener
{
  public mam(BaseNFCProxyActivity paramBaseNFCProxyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.NFC_SETTINGS"));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mam
 * JD-Core Version:    0.7.0.1
 */