import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class mce
  implements View.OnClickListener
{
  public mce(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(View paramView)
  {
    QzoneWebMusicJsPlugin.access$200(this.a, "buttonclick");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mce
 * JD-Core Version:    0.7.0.1
 */