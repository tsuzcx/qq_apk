import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class dre
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public dre(ChatSettingForTroop paramChatSettingForTroop, TextView paramTextView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() > 2)
    {
      int i = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineVisibleEnd(1);
      String str = this.jdField_a_of_type_AndroidWidgetTextView.getText().subSequence(0, i - 1) + "...";
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dre
 * JD-Core Version:    0.7.0.1
 */