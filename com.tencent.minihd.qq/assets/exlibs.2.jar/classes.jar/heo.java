import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;

public class heo
  implements View.OnClickListener
{
  public heo(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {
      return;
    }
    QQMusicWidget.a(this.a, QQMusicWidget.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     heo
 * JD-Core Version:    0.7.0.1
 */