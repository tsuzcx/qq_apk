import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MusicSharePlayActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class guc
  implements View.OnClickListener
{
  public guc(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    paramView = QQPlayerService.a();
    int i;
    if (paramView != null)
    {
      MusicPreferences.a().d(1);
      MusicPreferences.a().e(1);
      BannerManager.a(this.a).startActivity(paramView);
      paramView = paramView.getComponent().getClassName();
      if (!paramView.equals(MusicSharePlayActivity.class.getName())) {
        break label139;
      }
      i = 0;
    }
    for (;;)
    {
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "Msg_tab", "Mt_music_tips", 0, 0, "" + i, "", "", "");
      ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "0X800627C", "0X800627C", 0, 0, "", "", "", "");
      return;
      label139:
      if (paramView.equals(MusicGeneQQBrowserActivity.class.getName())) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     guc
 * JD-Core Version:    0.7.0.1
 */