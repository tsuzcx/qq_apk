import android.view.View;
import com.tencent.biz.troopbar.TroopBarDetailActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cor
  implements ActionSheet.OnButtonClickListener
{
  public cor(TroopBarDetailActivity paramTroopBarDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (TroopBarDetailActivity.a(this.a)) {
      return;
    }
    TroopBarDetailActivity.a(this.a, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      TroopBarDetailActivity.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cor
 * JD-Core Version:    0.7.0.1
 */