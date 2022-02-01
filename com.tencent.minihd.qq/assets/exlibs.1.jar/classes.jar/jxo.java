import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;

public class jxo
  implements View.OnTouchListener
{
  public jxo(StructMsgItemButton paramStructMsgItemButton, OnLongClickAndTouchListener paramOnLongClickAndTouchListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onTouch(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxo
 * JD-Core Version:    0.7.0.1
 */