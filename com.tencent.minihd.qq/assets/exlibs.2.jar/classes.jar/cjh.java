import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

public class cjh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  
  public cjh(TextView paramTextView, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() > this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_AndroidWidgetTextView.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      String str = this.jdField_a_of_type_JavaLangString.subSequence(0, i - 3) + "...";
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjh
 * JD-Core Version:    0.7.0.1
 */