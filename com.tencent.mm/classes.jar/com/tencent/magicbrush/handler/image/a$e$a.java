package com.tencent.magicbrush.handler.image;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$e$a
  implements IMBImageHandler.a
{
  public final void U(Object paramObject)
  {
    AppMethodBeat.i(115968);
    if (paramObject != null) {
      ((IBitmap)paramObject).recycle();
    }
    AppMethodBeat.o(115968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a.e.a
 * JD-Core Version:    0.7.0.1
 */