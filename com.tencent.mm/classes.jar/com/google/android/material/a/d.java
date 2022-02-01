package com.google.android.material.a;

import android.util.Property;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends Property<ViewGroup, Float>
{
  public static final Property<ViewGroup, Float> dnw;
  
  static
  {
    AppMethodBeat.i(209203);
    dnw = new d("childrenAlpha");
    AppMethodBeat.o(209203);
  }
  
  private d(String paramString)
  {
    super(Float.class, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.a.d
 * JD-Core Version:    0.7.0.1
 */