import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class dda
  implements View.OnClickListener
{
  public dda(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    View localView1 = AccountManageActivity.a(this.a, paramView);
    View localView2 = AccountManageActivity.b(this.a, paramView);
    if (this.a.a == null)
    {
      this.a.a = paramView;
      this.a.a(paramView, 2130968580, 2);
      localObject = localView2.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.g(this.a) * 75.0F));
      localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (localView1 != null) {
        ((ShaderAnimLayout)localView1).a();
      }
      paramView.setContentDescription(this.a.getString(2131369333));
      return;
    }
    if (this.a.a == paramView)
    {
      this.a.a(this.a.a, 2130968579, 3);
      localObject = localView2.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.h(this.a) * 40.0F));
      localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (localView1 != null) {
        ((ShaderAnimLayout)localView1).d();
      }
      this.a.a = null;
      paramView.setContentDescription(this.a.getString(2131369334));
      return;
    }
    this.a.a(this.a.a, 2130968579, 3);
    Object localObject = AccountManageActivity.b(this.a, this.a.a);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.i(this.a) * 40.0F));
    ((View)localObject).setLayoutParams(localLayoutParams);
    this.a.a(paramView, 2130968580, 2);
    localObject = localView2.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)(AccountManageActivity.a(this.a) - AccountManageActivity.j(this.a) * 75.0F));
    localView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setContentDescription(this.a.getString(2131369333));
    this.a.a.setContentDescription(this.a.getString(2131369334));
    if (localView1 != null) {
      ((ShaderAnimLayout)localView1).a();
    }
    localView1 = AccountManageActivity.a(this.a, this.a.a);
    if (localView1 != null) {
      ((ShaderAnimLayout)localView1).d();
    }
    this.a.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dda
 * JD-Core Version:    0.7.0.1
 */