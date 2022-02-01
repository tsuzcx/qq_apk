import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.mobileqq.widget.DropdownView.DropdownViewDropIconClickListner;

public class kxu
  implements View.OnClickListener
{
  public kxu(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.a.clearFocus();
    DropdownView.a(this.a).hideSoftInputFromWindow(this.a.a.getWindowToken(), 0);
    if ((((ImageView)paramView).getDrawable() == DropdownView.a(this.a)) && (!DropdownView.a(this.a)))
    {
      DropdownView.a(this.a, true);
      ((ImageView)paramView).setImageDrawable(DropdownView.b(this.a));
    }
    for (;;)
    {
      if (DropdownView.a(this.a) != null) {
        DropdownView.a(this.a).a(DropdownView.a(this.a));
      }
      return;
      ((ImageView)paramView).setImageDrawable(DropdownView.a(this.a));
      DropdownView.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kxu
 * JD-Core Version:    0.7.0.1
 */