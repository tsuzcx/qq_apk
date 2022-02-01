import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.qphone.base.util.QLog;

public class hgb
  implements DialogInterface.OnClickListener
{
  public hgb(AntiphingHandler paramAntiphingHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(AntiphingHandler.a(this.a), 4, "right button is clicked! ");
    }
    AntiphingHandler.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hgb
 * JD-Core Version:    0.7.0.1
 */