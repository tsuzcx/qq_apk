import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class mch
  implements DialogInterface.OnClickListener
{
  public mch(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2) {}
  
  @TargetApi(9)
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplication.getContext().getSharedPreferences("share", 0);
    if (Build.VERSION.SDK_INT >= 9) {
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).apply();
    }
    for (;;)
    {
      QzoneWebMusicJsPlugin.access$400(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin, this.jdField_a_of_type_Int, this.b);
      return;
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mch
 * JD-Core Version:    0.7.0.1
 */