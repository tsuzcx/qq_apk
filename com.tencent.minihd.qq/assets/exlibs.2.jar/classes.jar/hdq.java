import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class hdq
  implements View.OnClickListener
{
  public hdq(QQMusicFolderSelectActivity paramQQMusicFolderSelectActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicFolderSelectActivity.a(this.a)) {
      return;
    }
    if (ApnManager.b())
    {
      MyFavSongManager.a().a(this.a);
      MusicPreferences.a().a(0);
      MusicPreferences.a().a(201L);
      MusicPreferences.a().b(0L);
      MusicPreferences.a().c(QQMusicHelper.a());
      MusicPreferences.a().e(this.a.getResources().getString(2131365001));
      QQPlayerService.b(QQPlayerService.a(6, ""));
      this.a.finish();
      QQMusicFolderSelectActivity.b(this.a);
      return;
    }
    DialogUtil.a(this.a, 230, this.a.getResources().getString(2131365011), this.a.getResources().getString(2131365012), this.a.getResources().getString(2131365013), this.a.getResources().getString(2131365014), new hdr(this), new hds(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdq
 * JD-Core Version:    0.7.0.1
 */