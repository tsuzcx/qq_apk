import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import java.io.UnsupportedEncodingException;

public class exi
  implements TextWatcher
{
  public exi(RegisterByNicknameAndPwdActivity paramRegisterByNicknameAndPwdActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    for (;;)
    {
      return;
      String str1 = paramEditable.toString();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = str1.substring(str1.length() - 1, str1.length());
        try
        {
          if (str2.length() < str2.getBytes("utf-8").length)
          {
            paramEditable.delete(str1.length() - 1, str1.length());
            return;
          }
        }
        catch (UnsupportedEncodingException paramEditable)
        {
          paramEditable.printStackTrace();
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     exi
 * JD-Core Version:    0.7.0.1
 */