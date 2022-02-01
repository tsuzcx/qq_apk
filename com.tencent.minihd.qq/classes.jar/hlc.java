import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.MQPIntChkHandler;

public class hlc
  implements DialogInterface.OnDismissListener
{
  public hlc(MQPIntChkHandler paramMQPIntChkHandler) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MQPIntChkHandler.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hlc
 * JD-Core Version:    0.7.0.1
 */