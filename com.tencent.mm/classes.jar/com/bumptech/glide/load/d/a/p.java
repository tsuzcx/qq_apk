package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.d;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class p
  implements j<InputStream, Bitmap>
{
  private final b aFo;
  private final h aKM;
  
  public p(h paramh, b paramb)
  {
    this.aKM = paramh;
    this.aFo = paramb;
  }
  
  private v<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, i parami)
  {
    AppMethodBeat.i(77432);
    if ((paramInputStream instanceof n)) {
      paramInputStream = (n)paramInputStream;
    }
    for (i = 0;; i = 1)
    {
      locald = d.e(paramInputStream);
      com.bumptech.glide.g.h localh = new com.bumptech.glide.g.h(locald);
      a locala = new a(paramInputStream, locald);
      try
      {
        parami = this.aKM.a(localh, paramInt1, paramInt2, parami, locala);
        return parami;
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
      paramInputStream = new n(paramInputStream, this.aFo);
    }
  }
  
  static final class a
    implements h.a
  {
    private final n aFn;
    private final d aLu;
    
    a(n paramn, d paramd)
    {
      this.aFn = paramn;
      this.aLu = paramd;
    }
    
    public final void a(e parame, Bitmap paramBitmap)
    {
      AppMethodBeat.i(77431);
      IOException localIOException = this.aLu.aNP;
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
    
    public final void pD()
    {
      AppMethodBeat.i(77430);
      this.aFn.pH();
      AppMethodBeat.o(77430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.p
 * JD-Core Version:    0.7.0.1
 */