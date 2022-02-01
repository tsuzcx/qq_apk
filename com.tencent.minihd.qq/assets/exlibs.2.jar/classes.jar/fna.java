import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.UserguideFaceMaskActivity;

public class fna
  implements DialogInterface.OnKeyListener
{
  public fna(UserguideFaceMaskActivity paramUserguideFaceMaskActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fna
 * JD-Core Version:    0.7.0.1
 */