package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.WeakHashMap;

public final class e
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> dnx;
  private final WeakHashMap<Drawable, Integer> dny;
  
  static
  {
    AppMethodBeat.i(209208);
    dnx = new e();
    AppMethodBeat.o(209208);
  }
  
  private e()
  {
    super(Integer.class, "drawableAlphaCompat");
    AppMethodBeat.i(209200);
    this.dny = new WeakHashMap();
    AppMethodBeat.o(209200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.a.e
 * JD-Core Version:    0.7.0.1
 */