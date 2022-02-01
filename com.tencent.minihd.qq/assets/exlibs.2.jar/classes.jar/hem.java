import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;

public class hem
  implements View.OnClickListener
{
  public hem(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {}
    while (QQPlayerService.a() != QQMusicWidget.a(this.a)) {
      return;
    }
    QQPlayerService.a(this.a.getContext());
    ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006284", "0X8006284", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hem
 * JD-Core Version:    0.7.0.1
 */