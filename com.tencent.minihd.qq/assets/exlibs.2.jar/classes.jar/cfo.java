import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.eqq.IvrAlertDialogWithInput;

public class cfo
  implements TextWatcher
{
  public cfo(IvrAlertDialogWithInput paramIvrAlertDialogWithInput) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() > 0)
    {
      IvrAlertDialogWithInput.a(this.a).setVisibility(0);
      if (!TextUtils.isEmpty(paramEditable.toString())) {
        IvrAlertDialogWithInput.a(this.a).setEnabled(true);
      }
      return;
    }
    IvrAlertDialogWithInput.a(this.a).setVisibility(8);
    IvrAlertDialogWithInput.a(this.a).setTextColor(IvrAlertDialogWithInput.b(this.a));
    IvrAlertDialogWithInput.a(this.a).setText(IvrAlertDialogWithInput.a(this.a));
    IvrAlertDialogWithInput.a(this.a).setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfo
 * JD-Core Version:    0.7.0.1
 */