import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ea
  implements View.OnClickListener
{
  public ea(RouterSessionAdapter paramRouterSessionAdapter, RouterMsgRecord paramRouterMsgRecord, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131302483 == paramView.getId())
    {
      paramView = new eb(this);
      ec localec = new ec(this);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131362060), this.jdField_a_of_type_AndroidContentContext.getString(2131362090), 2131365736, 2131362063, paramView, localec).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ea
 * JD-Core Version:    0.7.0.1
 */