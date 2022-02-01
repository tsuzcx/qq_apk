import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;

public class hen
  implements View.OnClickListener
{
  public hen(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {
      return;
    }
    QQPlayerService.a(this.a.getContext());
    ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006281", "0X8006281", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hen
 * JD-Core Version:    0.7.0.1
 */