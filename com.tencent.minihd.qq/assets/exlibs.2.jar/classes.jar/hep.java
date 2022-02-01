import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;

public class hep
  implements View.OnClickListener
{
  public hep(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {
      return;
    }
    switch (QQMusicWidget.b(this.a))
    {
    default: 
      return;
    case 0: 
      QQMusicWidget.b(this.a);
      return;
    case 1: 
      QQMusicWidget.a(this.a, 2);
      QQMusicWidget.c(this.a);
      QQPlayerService.a(105);
      QQMusicHelper.a(105);
      ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006287", "0X8006287", 0, 0, "", "", "", "");
      return;
    case 2: 
      QQMusicWidget.a(this.a, 3);
      QQMusicWidget.c(this.a);
      QQPlayerService.a(101);
      QQMusicHelper.a(101);
      ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006287", "0X8006287", 1, 0, "", "", "", "");
      return;
    }
    QQMusicWidget.a(this.a, 1);
    QQMusicWidget.c(this.a);
    QQPlayerService.a(103);
    QQMusicHelper.a(103);
    ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006287", "0X8006287", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hep
 * JD-Core Version:    0.7.0.1
 */