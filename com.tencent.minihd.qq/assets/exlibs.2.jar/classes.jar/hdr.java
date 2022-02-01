import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;
import com.tencent.mobileqq.music.QQPlayerService;

class hdr
  implements DialogInterface.OnClickListener
{
  hdr(hdq paramhdq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MyFavSongManager.a().a(this.a.a);
    MusicPreferences.a().a(0);
    MusicPreferences.a().a(201L);
    MusicPreferences.a().b(0L);
    MusicPreferences.a().c(QQMusicHelper.a());
    MusicPreferences.a().e(this.a.a.getResources().getString(2131365001));
    QQPlayerService.b(QQPlayerService.a(6, ""));
    this.a.a.finish();
    paramDialogInterface.dismiss();
    QQMusicFolderSelectActivity.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdr
 * JD-Core Version:    0.7.0.1
 */