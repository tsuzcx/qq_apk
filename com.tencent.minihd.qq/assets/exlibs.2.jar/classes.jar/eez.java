import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;

public class eez
  implements View.OnClickListener
{
  public eez(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("bg_replace_entrance", 8);
    PhotoUtils.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eez
 * JD-Core Version:    0.7.0.1
 */