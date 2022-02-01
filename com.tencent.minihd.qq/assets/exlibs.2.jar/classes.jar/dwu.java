import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.EditInfoActivity;
import java.io.UnsupportedEncodingException;

public class dwu
  implements TextWatcher
{
  public dwu(EditInfoActivity paramEditInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      this.a.b = ("0/" + this.a.c);
      this.a.a.post(new dwv(this));
      return;
    }
    try
    {
      paramInt1 = paramCharSequence.toString().getBytes("utf-8").length;
      this.a.b = (paramInt1 + "/" + this.a.c);
      this.a.a.post(new dww(this, paramInt1));
      return;
    }
    catch (UnsupportedEncodingException paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dwu
 * JD-Core Version:    0.7.0.1
 */