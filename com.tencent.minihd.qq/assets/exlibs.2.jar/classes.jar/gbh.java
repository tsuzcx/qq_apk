import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;

public class gbh
  implements View.OnClickListener
{
  public gbh(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    PublicAccountChatPie.a(this.a).setVisibility(8);
    PublicAccountChatPie.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbh
 * JD-Core Version:    0.7.0.1
 */