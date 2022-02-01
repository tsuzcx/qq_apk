import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dh
  implements View.OnClickListener
{
  public dh(DLRouterSessionListAdapter paramDLRouterSessionListAdapter, long paramLong, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    int i = 0;
    if (2131302494 == paramView.getId()) {
      i = 11;
    }
    for (;;)
    {
      if ((i != 0) && (i > 0))
      {
        paramView = new di(this, i);
        dj localdj = new dj(this);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131362060), this.jdField_a_of_type_AndroidContentContext.getString(2131362090), 2131365736, 2131362063, paramView, localdj).show();
      }
      return;
      if (2131302479 == paramView.getId()) {
        i = 10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dh
 * JD-Core Version:    0.7.0.1
 */