import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gbb
  implements ActionSheet.OnButtonClickListener
{
  public gbb(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (PublicAccountChatPie.d(this.a)) {
      return;
    }
    PublicAccountChatPie.g(this.a, true);
    if ((this.a.a != null) && (paramInt < this.a.a.length) && (!PublicAccountChatPie.e(this.a)))
    {
      PublicAccountChatPie.a(this.a, 2131363614);
      paramInt = this.a.a[paramInt];
      if (paramInt == 0) {
        PublicAccountChatPie.a(this.a, true, 0);
      }
    }
    for (;;)
    {
      PublicAccountChatPie.a(this.a).dismiss();
      return;
      PublicAccountChatPie.a(this.a, false, paramInt);
      continue;
      if (PublicAccountChatPie.e(this.a))
      {
        PublicAccountChatPie.a(this.a, 2131363614);
        PublicAccountChatPie.a(this.a, false, 30);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbb
 * JD-Core Version:    0.7.0.1
 */