import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.business.share.ShareHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.music.QQPlayerService;

public class heq
  implements View.OnClickListener
{
  public heq(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {
      return;
    }
    ShareHelper.a(QQPlayerService.a(), BaseActivity.sTopActivity, QQMusicWidget.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     heq
 * JD-Core Version:    0.7.0.1
 */