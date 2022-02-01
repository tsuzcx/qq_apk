import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.FloatTextItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

public class gmt
  extends ClickableSpan
{
  public gmt(FloatTextItemBuilder paramFloatTextItemBuilder, ChatMessage paramChatMessage, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTextItemBuilder.a();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmt
 * JD-Core Version:    0.7.0.1
 */