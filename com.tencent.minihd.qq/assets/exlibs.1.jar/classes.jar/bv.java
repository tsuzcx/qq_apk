import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteAdvanceActivity;

public class bv
  implements DialogInterface.OnClickListener
{
  public bv(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bv
 * JD-Core Version:    0.7.0.1
 */