import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;

public final class hvo
  extends Drawable.ConstantState
{
  public NinePatch a;
  String a;
  public NinePatch b;
  String b;
  
  public hvo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new VipBubbleDrawable(null, this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new VipBubbleDrawable(paramResources, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hvo
 * JD-Core Version:    0.7.0.1
 */