package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.d;
import com.bumptech.glide.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class o
  implements k<InputStream, Bitmap>
{
  private final b aDH;
  private final h aJd;
  
  public o(h paramh, b paramb)
  {
    this.aJd = paramh;
    this.aDH = paramb;
  }
  
  private u<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(77432);
    if ((paramInputStream instanceof m)) {
      paramInputStream = (m)paramInputStream;
    }
    for (i = 0;; i = 1)
    {
      locald = d.e(paramInputStream);
      g localg = new g(locald);
      a locala = new a(paramInputStream, locald);
      try
      {
        paramj = this.aJd.a(localg, paramInt1, paramInt2, paramj, locala);
        return paramj;
      }
      finally
      {
        locald.release();
        if (i == 0) {
          break;
        }
        paramInputStream.release();
        AppMethodBeat.o(77432);
      }
      paramInputStream = new m(paramInputStream, this.aDH);
    }
  }
  
  static final class a
    implements h.a
  {
    private final m aDG;
    private final d aJL;
    
    a(m paramm, d paramd)
    {
      this.aDG = paramm;
      this.aJL = paramd;
    }
    
    public final void a(e parame, Bitmap paramBitmap)
    {
      AppMethodBeat.i(77431);
      IOException localIOException = this.aJL.aMh;
      if (localIOException != null)
      {
        if (paramBitmap != null) {
          parame.g(paramBitmap);
        }
        AppMethodBeat.o(77431);
        throw localIOException;
      }
      AppMethodBeat.o(77431);
    }
    
    public final void pg()
    {
      AppMethodBeat.i(77430);
      this.aDG.pk();
      AppMethodBeat.o(77430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.o
 * JD-Core Version:    0.7.0.1
 */