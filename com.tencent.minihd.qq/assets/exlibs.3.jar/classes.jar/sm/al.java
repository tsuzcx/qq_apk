package sm;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.securemodule.ui.TransparentActivity;

public class al
  implements DialogInterface.OnCancelListener
{
  public al(TransparentActivity paramTransparentActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.al
 * JD-Core Version:    0.7.0.1
 */