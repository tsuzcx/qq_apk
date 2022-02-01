package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  implements g
{
  private final g boE;
  private final f bxE;
  
  public w(g paramg, f paramf)
  {
    AppMethodBeat.i(93102);
    this.boE = ((g)a.checkNotNull(paramg));
    this.bxE = ((f)a.checkNotNull(paramf));
    AppMethodBeat.o(93102);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(93103);
    long l = this.boE.a(paramj);
    j localj = paramj;
    if (paramj.length == -1L)
    {
      localj = paramj;
      if (l != -1L) {
        localj = new j(paramj.uri, paramj.bwz, paramj.position, l, paramj.key, paramj.flags);
      }
    }
    this.bxE.b(localj);
    AppMethodBeat.o(93103);
    return l;
  }
  
  public final void close()
  {
    AppMethodBeat.i(93106);
    try
    {
      this.boE.close();
      return;
    }
    finally
    {
      this.bxE.close();
      AppMethodBeat.o(93106);
    }
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93105);
    Uri localUri = this.boE.getUri();
    AppMethodBeat.o(93105);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93104);
    paramInt2 = this.boE.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.bxE.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(93104);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.w
 * JD-Core Version:    0.7.0.1
 */