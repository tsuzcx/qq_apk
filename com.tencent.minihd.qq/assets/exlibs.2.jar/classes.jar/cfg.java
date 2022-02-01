import android.view.View;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cfg
  implements ActionSheet.OnButtonClickListener
{
  public cfg(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (EnterpriseDetailActivity.a(this.a)) {
      return;
    }
    EnterpriseDetailActivity.a(this.a, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      EnterpriseDetailActivity.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfg
 * JD-Core Version:    0.7.0.1
 */