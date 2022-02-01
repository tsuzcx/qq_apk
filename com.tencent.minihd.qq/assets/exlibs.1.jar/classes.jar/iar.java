import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.widget.XListView;

public class iar
  implements TextWatcher
{
  private iar(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      DatingDestinationActivity.a(this.a).setVisibility(0);
      if (DatingDestinationActivity.b(this.a)) {
        DatingDestinationActivity.a(this.a, paramEditable.toString(), DatingDestinationActivity.a(this.a));
      }
      return;
    }
    DatingDestinationActivity.c(this.a);
    DatingDestinationActivity.a(this.a).setVisibility(8);
    DatingDestinationActivity.a(this.a).setVisibility(4);
    DatingDestinationActivity.a(this.a).setVisibility(4);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iar
 * JD-Core Version:    0.7.0.1
 */