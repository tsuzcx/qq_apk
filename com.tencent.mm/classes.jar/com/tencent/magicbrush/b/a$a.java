package com.tencent.magicbrush.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  implements a.b
{
  private a$a(a parama) {}
  
  public final Bitmap bP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115985);
    c.c.i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    AppMethodBeat.o(115985);
    return localBitmap;
  }
  
  public final void init()
  {
    AppMethodBeat.i(115984);
    c.c.i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
    AppMethodBeat.o(115984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.b.a.a
 * JD-Core Version:    0.7.0.1
 */