import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kie
  implements ActionSheet.OnButtonClickListener
{
  public kie(TroopLocationModifyActivity paramTroopLocationModifyActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TroopLocationModifyActivity.a(this.a);
    if (paramInt == 0) {
      TroopLocationModifyActivity.a(this.a, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kie
 * JD-Core Version:    0.7.0.1
 */