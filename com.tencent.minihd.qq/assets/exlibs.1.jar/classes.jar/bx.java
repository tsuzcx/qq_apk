import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteMutiPicViewerActivity;

public class bx
  implements DialogInterface.OnClickListener
{
  public bx(LiteMutiPicViewerActivity paramLiteMutiPicViewerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bx
 * JD-Core Version:    0.7.0.1
 */