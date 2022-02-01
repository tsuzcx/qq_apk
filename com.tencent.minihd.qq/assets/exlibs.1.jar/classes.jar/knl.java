import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.troop.widget.MediaControllerX;

public class knl
  implements View.OnClickListener
{
  public knl(MediaControllerX paramMediaControllerX) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      this.a.b = true;
      MediaControllerX.b(this.a).setBackgroundResource(2130839546);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131363502));
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.onClick(paramView);
      }
      return;
      this.a.b = false;
      MediaControllerX.b(this.a).setBackgroundResource(2130839536);
      MediaControllerX.b(this.a).setContentDescription(this.a.getResources().getString(2131363501));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     knl
 * JD-Core Version:    0.7.0.1
 */