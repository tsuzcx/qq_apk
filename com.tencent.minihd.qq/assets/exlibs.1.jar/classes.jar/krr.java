import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;

public class krr
  implements View.OnClickListener
{
  public krr(JumpAction paramJumpAction) {}
  
  public void onClick(View paramView)
  {
    if ((JumpAction.a(this.a) != null) && (JumpAction.a(this.a).isShowing())) {
      JumpAction.a(this.a).dismiss();
    }
    ((BaseActivity)JumpAction.a(this.a)).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     krr
 * JD-Core Version:    0.7.0.1
 */