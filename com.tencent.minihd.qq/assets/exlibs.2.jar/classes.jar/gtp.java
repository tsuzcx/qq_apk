import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class gtp
  implements TextWatcher
{
  public gtp(SendHbActivity paramSendHbActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((SendHbActivity.a(this.a)) && (SendHbActivity.b(this.a)))
    {
      if (!SendHbActivity.a(this.a).isEnabled())
      {
        SendHbActivity.a(this.a).setEnabled(true);
        SendHbActivity.a(this.a).setClickable(true);
        this.a.a(SendHbActivity.a(this.a), this.a.a(), "hongbao.wrap.enable", "", "", 2, "");
      }
      if ("1".equals(SendHbActivity.b(this.a))) {
        SendHbActivity.a(this.a);
      }
      if (!TextUtils.isEmpty(SendHbActivity.a(this.a).getText().toString())) {
        break label238;
      }
      SendHbActivity.a(this.a).setGravity(19);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(SendHbActivity.b(this.a).getText().toString())) {
        break label253;
      }
      SendHbActivity.b(this.a).setGravity(19);
      return;
      if (!SendHbActivity.a(this.a).isEnabled()) {
        break;
      }
      SendHbActivity.a(this.a).setClickable(false);
      SendHbActivity.a(this.a).setEnabled(false);
      this.a.a(SendHbActivity.a(this.a), this.a.a(), "hongbao.wrap.disable", "", "", 2, "");
      break;
      label238:
      SendHbActivity.a(this.a).setGravity(21);
    }
    label253:
    SendHbActivity.b(this.a).setGravity(21);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gtp
 * JD-Core Version:    0.7.0.1
 */