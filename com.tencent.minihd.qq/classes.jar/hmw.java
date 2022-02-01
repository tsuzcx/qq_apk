import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class hmw
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      System.exit(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmw
 * JD-Core Version:    0.7.0.1
 */