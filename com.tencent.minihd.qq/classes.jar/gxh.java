import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager.SwitchListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class gxh
  implements InnerFrameManager.SwitchListener
{
  public gxh(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.getWindow().peekDecorView().getWindowToken(), 0);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gxh
 * JD-Core Version:    0.7.0.1
 */