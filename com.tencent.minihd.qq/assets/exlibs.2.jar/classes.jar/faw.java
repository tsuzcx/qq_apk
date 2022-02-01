import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.SoftInputActivity;

public class faw
  implements TextWatcher
{
  public faw(SoftInputActivity paramSoftInputActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = SoftInputActivity.a(this.a).getText().toString();
    Intent localIntent = new Intent("receiver_text");
    localIntent.putExtra("text", paramEditable);
    this.a.sendBroadcast(localIntent);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     faw
 * JD-Core Version:    0.7.0.1
 */