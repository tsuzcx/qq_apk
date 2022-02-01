import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qwallet.plugin.proxy.BaseNFCProxyActivity;

public class man
  implements DialogInterface.OnClickListener
{
  public man(BaseNFCProxyActivity paramBaseNFCProxyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     man
 * JD-Core Version:    0.7.0.1
 */