import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.FloatGrayTipsItemBuilder;

public class glt
  extends ClickableSpan
{
  public glt(FloatGrayTipsItemBuilder paramFloatGrayTipsItemBuilder) {}
  
  public void onClick(View paramView) {}
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16732929);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glt
 * JD-Core Version:    0.7.0.1
 */