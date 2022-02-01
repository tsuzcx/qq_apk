import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.eqq.IvrAlertDialogWithInput;

public class cfn
  implements View.OnClickListener
{
  public cfn(IvrAlertDialogWithInput paramIvrAlertDialogWithInput) {}
  
  public void onClick(View paramView)
  {
    IvrAlertDialogWithInput.a(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfn
 * JD-Core Version:    0.7.0.1
 */