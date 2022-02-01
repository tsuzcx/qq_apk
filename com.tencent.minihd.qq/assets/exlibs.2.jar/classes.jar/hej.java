import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.QQPlayerService;

class hej
  implements DialogInterface.OnClickListener
{
  hej(heg paramheg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQPlayerService.b(this.a.a.getContext());
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hej
 * JD-Core Version:    0.7.0.1
 */