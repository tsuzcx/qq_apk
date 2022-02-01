import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public final class jai
  implements DialogInterface.OnClickListener
{
  public jai(FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jai
 * JD-Core Version:    0.7.0.1
 */