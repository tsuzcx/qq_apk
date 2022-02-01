package com.google.android.material.internal;

import android.graphics.Outline;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(237567);
    copyBounds(this.byG);
    paramOutline.setOval(this.byG);
    AppMethodBeat.o(237567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.internal.b
 * JD-Core Version:    0.7.0.1
 */