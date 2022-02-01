package android.support.design.a;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public final class e
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> gR = new e();
  private final WeakHashMap<Drawable, Integer> gS = new WeakHashMap();
  
  private e()
  {
    super(Integer.class, "drawableAlphaCompat");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.a.e
 * JD-Core Version:    0.7.0.1
 */