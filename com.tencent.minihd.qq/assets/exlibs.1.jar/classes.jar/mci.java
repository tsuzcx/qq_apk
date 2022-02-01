import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class mci
  implements DialogInterface.OnCancelListener
{
  public mci(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.getPlayMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mci
 * JD-Core Version:    0.7.0.1
 */