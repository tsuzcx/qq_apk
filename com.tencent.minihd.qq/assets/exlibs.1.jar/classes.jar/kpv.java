import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

public class kpv
  extends BitmapDrawable
{
  private final WeakReference a;
  
  public kpv(Resources paramResources, Bitmap paramBitmap, kpw paramkpw)
  {
    super(paramResources, paramBitmap);
    this.a = new WeakReference(paramkpw);
  }
  
  public kpw a()
  {
    return (kpw)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kpv
 * JD-Core Version:    0.7.0.1
 */