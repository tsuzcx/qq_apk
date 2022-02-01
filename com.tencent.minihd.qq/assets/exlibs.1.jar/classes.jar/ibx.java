import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.dating.DatingOthersActivity;

public class ibx
  implements View.OnClickListener
{
  public ibx(DatingOthersActivity paramDatingOthersActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (i == DatingOthersActivity.a(this.a)) {
      return;
    }
    if (DatingOthersActivity.a(this.a) != -1)
    {
      View localView = DatingOthersActivity.a(this.a).getChildAt(DatingOthersActivity.a(this.a));
      if (localView != null) {
        ((ImageView)localView.findViewById(2131300034)).setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131300034)).setVisibility(0);
    DatingOthersActivity.a(this.a, i);
    DatingOthersActivity.a(this.a, false);
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibx
 * JD-Core Version:    0.7.0.1
 */