import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class mck
  implements DialogInterface.OnClickListener
{
  public mck(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.resumePlay();
    QzoneWebMusicJsPlugin.access$002(true);
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$502(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mck
 * JD-Core Version:    0.7.0.1
 */