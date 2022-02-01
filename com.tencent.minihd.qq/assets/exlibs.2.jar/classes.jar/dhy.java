import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XPanelContainer;

public class dhy
  implements View.OnTouchListener
{
  public dhy(BaseChatPie paramBaseChatPie) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0) && (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 4))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label84;
      }
      this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(this.a.a());
      this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.a.b, 0, this.a.b, 0);
    }
    label84:
    while (paramMotionEvent.getAction() != 1) {
      return false;
    }
    this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(this.a.b());
    this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setPadding(this.a.b, 0, this.a.b, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dhy
 * JD-Core Version:    0.7.0.1
 */