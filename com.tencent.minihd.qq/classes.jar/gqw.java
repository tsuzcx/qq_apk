import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;

public class gqw
  implements DialogInterface.OnClickListener
{
  public gqw(DialogBaseActivity paramDialogBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setResult(1);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gqw
 * JD-Core Version:    0.7.0.1
 */