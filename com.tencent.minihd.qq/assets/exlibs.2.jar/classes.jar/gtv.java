import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class gtv
  implements TextWatcher
{
  public gtv(TransactionActivity paramTransactionActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((TransactionActivity.a(this.a).getText().length() > 0) && ((!TransactionActivity.a(this.a).getText().toString().startsWith(".")) || (!TransactionActivity.a(this.a).getText().toString().endsWith("."))) && (TransactionActivity.a(this.a, TransactionActivity.a(this.a).getText().toString()))) {
      if (!TransactionActivity.a(this.a).isEnabled())
      {
        TransactionActivity.a(this.a).setEnabled(true);
        TransactionActivity.a(this.a).setClickable(true);
        this.a.a(TransactionActivity.a(this.a), 128, "transfer.amount.enable", "", "", 2, "");
      }
    }
    while (!TransactionActivity.a(this.a).isEnabled()) {
      return;
    }
    TransactionActivity.a(this.a).setClickable(false);
    TransactionActivity.a(this.a).setEnabled(false);
    this.a.a(TransactionActivity.a(this.a), 128, "transfer.amount.disable", "", "", 2, "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gtv
 * JD-Core Version:    0.7.0.1
 */