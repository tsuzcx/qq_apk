import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cdg
  implements ActionSheet.OnButtonClickListener
{
  public cdg(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.a != null) && (!TextUtils.isEmpty(this.a.a.mBmqqMobileNum))) {
      BmqqProfileCardActivity.c(this.a, this.a.a.mBmqqMobileNum);
    }
    if ((paramInt == 1) && (this.a.a != null) && (!TextUtils.isEmpty(this.a.a.mBmqqMobileNum))) {
      BmqqProfileCardActivity.d(this.a, this.a.a.mBmqqMobileNum);
    }
    BmqqProfileCardActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdg
 * JD-Core Version:    0.7.0.1
 */