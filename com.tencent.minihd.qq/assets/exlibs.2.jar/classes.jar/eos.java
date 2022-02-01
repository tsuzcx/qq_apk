import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.OpenidToUinActivity;

public class eos
  implements DialogInterface.OnCancelListener
{
  public eos(OpenidToUinActivity paramOpenidToUinActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eos
 * JD-Core Version:    0.7.0.1
 */