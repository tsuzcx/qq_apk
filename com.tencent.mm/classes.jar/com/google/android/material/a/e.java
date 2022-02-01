package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.WeakHashMap;

public final class e
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> but;
  private final WeakHashMap<Drawable, Integer> buu;
  
  static
  {
    AppMethodBeat.i(234210);
    but = new e();
    AppMethodBeat.o(234210);
  }
  
  private e()
  {
    super(Integer.class, "drawableAlphaCompat");
    AppMethodBeat.i(234205);
    this.buu = new WeakHashMap();
    AppMethodBeat.o(234205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.a.e
 * JD-Core Version:    0.7.0.1
 */