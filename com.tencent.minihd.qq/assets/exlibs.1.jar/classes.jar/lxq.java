import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class lxq
  implements DialogInterface.OnClickListener
{
  public lxq(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lxq
 * JD-Core Version:    0.7.0.1
 */