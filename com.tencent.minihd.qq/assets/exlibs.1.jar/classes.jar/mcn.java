import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class mcn
  implements DialogInterface.OnClickListener
{
  public mcn(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, String[] paramArrayOfString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QzoneWebMusicJsPlugin.access$002(true);
    this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.playMusicList(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
    QzoneWebMusicJsPlugin.access$102(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcn
 * JD-Core Version:    0.7.0.1
 */