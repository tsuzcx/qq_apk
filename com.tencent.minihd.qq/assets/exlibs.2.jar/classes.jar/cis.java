import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cis
  implements ActionSheet.OnButtonClickListener
{
  public cis(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AccountDetailActivity.a(this.a)) {
      return;
    }
    AccountDetailActivity.a(this.a, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      AccountDetailActivity.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cis
 * JD-Core Version:    0.7.0.1
 */