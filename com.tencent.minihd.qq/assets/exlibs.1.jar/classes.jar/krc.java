import android.content.Context;
import android.widget.TextView;
import com.tencent.widget.BubblePopupWindow;

public final class krc
  extends TextView
{
  public krc(Context paramContext, BubblePopupWindow paramBubblePopupWindow)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    this.a.b();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     krc
 * JD-Core Version:    0.7.0.1
 */