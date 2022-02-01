import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;

public class hdy
  implements View.OnClickListener
{
  public hdy(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {}
    do
    {
      do
      {
        return;
      } while (QQPlayerService.a() != QQMusicWidget.a(this.a));
      paramView = QQPlayerService.a();
    } while (paramView == null);
    MusicPreferences.a().d(1);
    MusicPreferences.a().e(1);
    this.a.getContext().startActivity(paramView);
    ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006280", "0X8006280", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdy
 * JD-Core Version:    0.7.0.1
 */