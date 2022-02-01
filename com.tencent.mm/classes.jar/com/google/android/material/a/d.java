package com.google.android.material.a;

import android.util.Property;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends Property<ViewGroup, Float>
{
  public static final Property<ViewGroup, Float> bus;
  
  static
  {
    AppMethodBeat.i(234201);
    bus = new d("childrenAlpha");
    AppMethodBeat.o(234201);
  }
  
  private d(String paramString)
  {
    super(Float.class, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.material.a.d
 * JD-Core Version:    0.7.0.1
 */