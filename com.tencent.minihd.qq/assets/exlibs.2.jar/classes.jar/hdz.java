import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.business.download.DownloadHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;

public class hdz
  implements View.OnClickListener
{
  public hdz(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {
      return;
    }
    DownloadHelper.a(this.a.getContext(), QQPlayerService.a());
    ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006286", "0X8006286", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdz
 * JD-Core Version:    0.7.0.1
 */