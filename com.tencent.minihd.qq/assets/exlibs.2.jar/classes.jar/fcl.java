import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class fcl
  implements View.OnClickListener
{
  public fcl(StrangerManageActivity paramStrangerManageActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (this.a.a == null)
    {
      this.a.a = ((ActionSheet)ActionSheetHelper.a(paramView, null));
      this.a.a.a(2131369126);
      this.a.a.a(2131369123, 3);
      this.a.a.e(2131365736);
      this.a.a.a(paramView);
    }
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fcl
 * JD-Core Version:    0.7.0.1
 */