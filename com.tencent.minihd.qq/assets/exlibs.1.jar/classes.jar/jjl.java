import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class jjl
  implements TextWatcher
{
  public jjl(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    NearbyProfileEditPanel.a(this.a, NearbyProfileEditPanel.b(this.a), 40);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjl
 * JD-Core Version:    0.7.0.1
 */