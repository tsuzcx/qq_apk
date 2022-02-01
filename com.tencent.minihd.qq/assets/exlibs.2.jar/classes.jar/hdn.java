import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.business.radio.GuessYouLikeManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class hdn
  implements View.OnClickListener
{
  public hdn(QQMusicFolderSelectActivity paramQQMusicFolderSelectActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicFolderSelectActivity.a(this.a)) {
      return;
    }
    if (ApnManager.b())
    {
      GuessYouLikeManager.a().a(this.a);
      MusicPreferences.a().a(1);
      MusicPreferences.a().e(this.a.getResources().getString(2131365000));
      QQPlayerService.b(QQPlayerService.a(6, ""));
      this.a.finish();
      QQMusicFolderSelectActivity.a(this.a);
      return;
    }
    DialogUtil.a(this.a, 230, this.a.getResources().getString(2131365011), this.a.getResources().getString(2131365012), this.a.getResources().getString(2131365013), this.a.getResources().getString(2131365014), new hdo(this), new hdp(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdn
 * JD-Core Version:    0.7.0.1
 */