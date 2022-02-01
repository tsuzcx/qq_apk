import android.content.Intent;
import android.os.Handler;
import android.text.Selection;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;

class eyw
  extends ClickableSpan
{
  eyw(eyv parameyv, String paramString) {}
  
  public void onClick(View paramView)
  {
    Selection.removeSelection(SpannableString.valueOf(this.jdField_a_of_type_JavaLangString));
    if (TextUtils.isEmpty(RegisterVerifyCodeActivity.a(this.jdField_a_of_type_Eyv.a))) {}
    while (!RegisterVerifyCodeActivity.b(this.jdField_a_of_type_Eyv.a)) {
      return;
    }
    RegisterVerifyCodeActivity.b(this.jdField_a_of_type_Eyv.a, false);
    this.jdField_a_of_type_Eyv.a.b.postDelayed(new eyx(this), 1000L);
    paramView = new Intent(this.jdField_a_of_type_Eyv.a, QQBrowserActivity.class);
    paramView.putExtra("url", RegisterVerifyCodeActivity.a(this.jdField_a_of_type_Eyv.a));
    paramView.putExtra("hide_more_button", true);
    this.jdField_a_of_type_Eyv.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16734752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eyw
 * JD-Core Version:    0.7.0.1
 */