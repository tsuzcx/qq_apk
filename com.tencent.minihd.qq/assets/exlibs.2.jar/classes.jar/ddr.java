import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class ddr
  implements View.OnClickListener
{
  public ddr(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.c) {
      return;
    }
    paramView = this.a;
    boolean bool;
    label102:
    int i;
    if (!this.a.b)
    {
      bool = true;
      paramView.b = bool;
      if (!this.a.b) {
        break label194;
      }
      AccountManageActivity.g(this.a).setVisibility(8);
      AccountManageActivity.h(this.a).setVisibility(0);
      AccountManageActivity.i(this.a).setText(2131367064);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427975));
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        ((ShaderAnimLayout)AccountManageActivity.a(this.a, this.a.jdField_a_of_type_AndroidViewView)).d();
        this.a.jdField_a_of_type_AndroidViewView = null;
      }
      int j = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      label153:
      if (i >= j) {
        break label301;
      }
      paramView = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((paramView != null) && (paramView.getTag() != null)) {
        break label254;
      }
    }
    for (;;)
    {
      i += 1;
      break label153;
      bool = false;
      break;
      label194:
      AccountManageActivity.j(this.a).setVisibility(0);
      AccountManageActivity.k(this.a).setVisibility(8);
      AccountManageActivity.l(this.a).setText(2131367082);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131427938));
      break label102;
      label254:
      paramView = paramView.findViewById(2131296581);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) * AccountManageActivity.b(this.a)));
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    label301:
    this.a.b();
    this.a.a(this.a.b);
    this.a.c = false;
    AccountManageActivity.a(this.a).postDelayed(new dds(this), 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddr
 * JD-Core Version:    0.7.0.1
 */