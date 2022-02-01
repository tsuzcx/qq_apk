import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;

public class dwn
  implements View.OnClickListener
{
  public dwn(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    EditActivity.a(this.a).setVisibility(4);
    EditActivity.a(this.a).setImageResource(2130841082);
    EditActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dwn
 * JD-Core Version:    0.7.0.1
 */