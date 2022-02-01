import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.widget.qqmusic.business.radio.GuessYouLikeManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;
import com.tencent.mobileqq.music.QQPlayerService;

class hdo
  implements DialogInterface.OnClickListener
{
  hdo(hdn paramhdn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GuessYouLikeManager.a().a(this.a.a);
    MusicPreferences.a().a(1);
    MusicPreferences.a().e(this.a.a.getResources().getString(2131365000));
    QQPlayerService.b(QQPlayerService.a(6, ""));
    this.a.a.finish();
    paramDialogInterface.dismiss();
    QQMusicFolderSelectActivity.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdo
 * JD-Core Version:    0.7.0.1
 */