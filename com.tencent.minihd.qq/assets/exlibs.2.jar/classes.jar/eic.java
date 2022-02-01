import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;

public class eic
  implements DialogInterface.OnClickListener
{
  public eic(LoginActivity paramLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eic
 * JD-Core Version:    0.7.0.1
 */