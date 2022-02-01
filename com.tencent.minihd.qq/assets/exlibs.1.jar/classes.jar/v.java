import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.ItemHolder;

public class v
  implements View.OnClickListener
{
  public v(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (ItemHolder)((ItemHolder)paramView.getTag()).clone();
    LiteActivity.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     v
 * JD-Core Version:    0.7.0.1
 */