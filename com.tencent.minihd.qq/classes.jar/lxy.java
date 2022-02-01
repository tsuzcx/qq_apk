import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QQProxyForQlink;

public class lxy
  implements DialogInterface.OnDismissListener
{
  public lxy(QQProxyForQlink paramQQProxyForQlink) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QQProxyForQlink.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lxy
 * JD-Core Version:    0.7.0.1
 */