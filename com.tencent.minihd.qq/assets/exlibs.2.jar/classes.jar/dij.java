import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;

public class dij
  implements View.OnFocusChangeListener
{
  public dij(BaseChatPie paramBaseChatPie) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (BaseChatPie.a(this.a) != null) && (BaseChatPie.a(this.a).getVisibility() == 0)) {
      BaseChatPie.a(this.a, true);
    }
    EditText localEditText = this.a.a;
    if (paramBoolean) {}
    for (paramView = "";; paramView = this.a.a.getContext().getResources().getString(2131366104))
    {
      localEditText.setHint(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dij
 * JD-Core Version:    0.7.0.1
 */