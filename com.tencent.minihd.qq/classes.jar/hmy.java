import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;

public class hmy
  extends ClickableSpan
{
  Context jdField_a_of_type_AndroidContentContext;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public hmy(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramString1;
  }
  
  public void onClick(View paramView)
  {
    PrivacyPolicyHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmy
 * JD-Core Version:    0.7.0.1
 */