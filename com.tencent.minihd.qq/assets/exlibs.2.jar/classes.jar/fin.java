import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fin
  implements ActionSheet.OnButtonClickListener
{
  public fin(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    TroopMemberCardActivity.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fin
 * JD-Core Version:    0.7.0.1
 */