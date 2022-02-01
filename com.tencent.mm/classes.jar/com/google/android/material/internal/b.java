package com.google.android.material.internal;

import android.graphics.Outline;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends a
{
  public final void getOutline(Outline paramOutline)
  {
    AppMethodBeat.i(209299);
    copyBounds(this.rect);
    paramOutline.setOval(this.rect);
    AppMethodBeat.o(209299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.b
 * JD-Core Version:    0.7.0.1
 */