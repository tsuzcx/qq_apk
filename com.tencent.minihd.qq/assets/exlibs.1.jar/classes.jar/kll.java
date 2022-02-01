import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class kll
  implements DialogInterface.OnClickListener
{
  public kll(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoPlayLogic.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kll
 * JD-Core Version:    0.7.0.1
 */