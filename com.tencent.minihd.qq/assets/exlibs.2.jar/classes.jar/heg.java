import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class heg
  implements View.OnClickListener
{
  public heg(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {
      return;
    }
    if ((QQMusicWidget.a(this.a) == 0) || (QQMusicWidget.a(this.a) == 4) || (QQMusicWidget.a(this.a) == 5) || (QQMusicWidget.a(this.a) == 7) || (QQMusicWidget.a(this.a) == 6))
    {
      if (ApnManager.b())
      {
        QQMusicWidget.a(this.a);
        return;
      }
      DialogUtil.a(this.a.getContext(), 230, this.a.getContext().getResources().getString(2131365011), this.a.getContext().getResources().getString(2131365012), this.a.getContext().getResources().getString(2131365013), this.a.getContext().getResources().getString(2131365014), new heh(this), new hei(this)).show();
      return;
    }
    switch (QQPlayerService.a())
    {
    }
    for (;;)
    {
      ReportController.b(QQMusicWidget.a(this.a), "CliOper", "", "", "0X8006281", "0X8006281", 0, 0, "", "", "", "");
      return;
      if (ApnManager.b()) {
        QQPlayerService.b(this.a.getContext());
      } else {
        DialogUtil.a(this.a.getContext(), 230, this.a.getContext().getResources().getString(2131365011), this.a.getContext().getResources().getString(2131365012), this.a.getContext().getResources().getString(2131365013), this.a.getContext().getResources().getString(2131365014), new hej(this), new hek(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     heg
 * JD-Core Version:    0.7.0.1
 */