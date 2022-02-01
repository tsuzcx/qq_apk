import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaPlayerControlX;

public class kng
  implements View.OnClickListener
{
  public kng(MediaControllerX paramMediaControllerX) {}
  
  public void onClick(View paramView)
  {
    int i = MediaControllerX.a(this.a).b();
    MediaControllerX.a(this.a).a(i + 15000);
    MediaControllerX.a(this.a);
    this.a.a(5000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kng
 * JD-Core Version:    0.7.0.1
 */