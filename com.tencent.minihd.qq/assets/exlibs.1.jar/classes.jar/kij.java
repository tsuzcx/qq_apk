import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;

public class kij
  implements DialogInterface.OnClickListener
{
  public kij(VideoRecordActivity paramVideoRecordActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoRecordActivity.a(this.a);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("output_path", VideoRecordActivity.a(this.a));
    this.a.setResult(-1, paramDialogInterface);
    VideoRecordActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kij
 * JD-Core Version:    0.7.0.1
 */