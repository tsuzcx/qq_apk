import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;

public class her
  implements View.OnClickListener
{
  public her(QQMusicWidget paramQQMusicWidget) {}
  
  public void onClick(View paramView)
  {
    if (!QQMusicWidget.a(this.a)) {
      return;
    }
    paramView = new Intent();
    paramView.setClass(this.a.getContext(), QQMusicFolderSelectActivity.class);
    paramView.putExtra("display_like_dialog", true);
    new Bundle();
    this.a.getContext().startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     her
 * JD-Core Version:    0.7.0.1
 */