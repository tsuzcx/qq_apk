import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;
import com.tencent.mobileqq.statistics.ReportController;

public class gkv
  extends ClickableSpan
{
  public gkv(BaseFloatChatPie paramBaseFloatChatPie, int paramInt) {}
  
  public void onClick(View paramView)
  {
    BaseFloatChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.s();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioBaseFloatChatPie.a, "CliOper", "", "", "0X800617F", "0X800617F", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkv
 * JD-Core Version:    0.7.0.1
 */