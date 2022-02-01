import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;

public class hdm
  implements View.OnClickListener
{
  public hdm(QQMusicFolderSelectActivity paramQQMusicFolderSelectActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicFolderSelectActivity.a(this.a)) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdm
 * JD-Core Version:    0.7.0.1
 */