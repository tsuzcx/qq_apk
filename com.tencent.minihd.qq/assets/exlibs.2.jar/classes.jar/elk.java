import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class elk
  implements DialogInterface.OnDismissListener
{
  public elk(NearPeopleFilterActivity paramNearPeopleFilterActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.i == 0)
    {
      this.a.a.setRightTextColor(2);
      this.a.a.setContentDescription("年龄" + com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.a[this.a.c] + ", 触摸两次选择");
      return;
    }
    this.a.b.setRightTextColor(2);
    this.a.b.setContentDescription("星座" + com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters.b[this.a.d] + ", 触摸两次选择");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elk
 * JD-Core Version:    0.7.0.1
 */