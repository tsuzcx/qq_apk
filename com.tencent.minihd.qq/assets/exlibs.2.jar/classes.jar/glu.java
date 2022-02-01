import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.FloatGrayTipsItemBuilder;

public class glu
  extends ClickableSpan
{
  public glu(FloatGrayTipsItemBuilder paramFloatGrayTipsItemBuilder) {}
  
  public void onClick(View paramView) {}
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glu
 * JD-Core Version:    0.7.0.1
 */