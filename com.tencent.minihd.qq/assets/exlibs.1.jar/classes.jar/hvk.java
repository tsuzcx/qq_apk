import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.bubble.ReversedNinePatchDrawable;

public final class hvk
  extends Drawable.ConstantState
{
  public final NinePatch a;
  
  public hvk(NinePatch paramNinePatch)
  {
    this.a = paramNinePatch;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new ReversedNinePatchDrawable(null, this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ReversedNinePatchDrawable(paramResources, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hvk
 * JD-Core Version:    0.7.0.1
 */