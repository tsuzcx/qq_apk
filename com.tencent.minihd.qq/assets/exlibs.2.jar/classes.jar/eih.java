import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class eih
  implements AdapterView.OnItemClickListener
{
  public eih(LoginActivity paramLoginActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LoginActivity.a(this.a);
    LoginActivity.a(this.a).removeTextChangedListener(this.a.b);
    paramAdapterView = (SimpleAccount)LoginActivity.a(this.a).get(paramInt);
    LoginActivity.a(this.a, paramAdapterView);
    LoginActivity.a(this.a).addTextChangedListener(this.a.b);
    LoginActivity.a(this.a).clearFocus();
    LoginActivity.a(this.a).clearFocus();
    LoginActivity.a(this.a).setClearButtonVisible(false);
    LoginActivity.a(this.a).a().setVisibility(8);
    LoginActivity.b(this.a);
    LoginActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eih
 * JD-Core Version:    0.7.0.1
 */