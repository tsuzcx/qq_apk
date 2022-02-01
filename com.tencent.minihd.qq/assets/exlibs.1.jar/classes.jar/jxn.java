import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;

public class jxn
  implements View.OnLongClickListener
{
  public jxn(StructMsgItemButton paramStructMsgItemButton, OnLongClickAndTouchListener paramOnLongClickAndTouchListener) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxn
 * JD-Core Version:    0.7.0.1
 */