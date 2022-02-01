import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.dating.DatingFilterActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class ibs
  implements DialogInterface.OnDismissListener
{
  public ibs(DatingFilterActivity paramDatingFilterActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a == 0)
    {
      DatingFilterActivity.a(this.a).setRightTextColor(2);
      DatingFilterActivity.a(this.a).setContentDescription("年龄" + com.tencent.mobileqq.dating.DatingFilters.a[DatingFilterActivity.a(this.a).h] + ", 触摸两次选择");
      return;
    }
    if (this.a.a == 1)
    {
      DatingFilterActivity.b(this.a).setRightTextColor(2);
      DatingFilterActivity.b(this.a).setContentDescription("约会时间" + com.tencent.mobileqq.dating.DatingFilters.b[DatingFilterActivity.a(this.a).e] + ", 触摸两次选择");
      return;
    }
    DatingFilterActivity.c(this.a).setRightTextColor(2);
    DatingFilterActivity.c(this.a).setContentDescription("约会内容" + com.tencent.mobileqq.dating.DatingFilters.c[DatingFilterActivity.a(this.a).f] + ", 触摸两次选择");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibs
 * JD-Core Version:    0.7.0.1
 */