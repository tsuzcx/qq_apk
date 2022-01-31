package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  implements g
{
  private final g aQR;
  private final f aZE;
  
  public v(g paramg, f paramf)
  {
    AppMethodBeat.i(152015);
    this.aQR = ((g)a.checkNotNull(paramg));
    this.aZE = ((f)a.checkNotNull(paramf));
    AppMethodBeat.o(152015);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(152016);
    long l = this.aQR.a(paramj);
    j localj = paramj;
    if (paramj.aPF == -1L)
    {
      localj = paramj;
      if (l != -1L) {
        localj = new j(paramj.uri, paramj.aYy, paramj.position, l, paramj.key, paramj.flags);
      }
    }
    this.aZE.b(localj);
    AppMethodBeat.o(152016);
    return l;
  }
  
  public final void close()
  {
    AppMethodBeat.i(152019);
    try
    {
      this.aQR.close();
      return;
    }
    finally
    {
      this.aZE.close();
      AppMethodBeat.o(152019);
    }
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(152018);
    Uri localUri = this.aQR.getUri();
    AppMethodBeat.o(152018);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152017);
    paramInt2 = this.aQR.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.aZE.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(152017);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.v
 * JD-Core Version:    0.7.0.1
 */