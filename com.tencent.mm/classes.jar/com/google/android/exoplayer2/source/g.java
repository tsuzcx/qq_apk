package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class g
  implements f.c, i
{
  private final w.a aRQ;
  private final com.google.android.exoplayer2.h.g.a blV;
  private final com.google.android.exoplayer2.c.h blW;
  private final int blX;
  private long blY;
  private boolean blZ;
  private i.a bll;
  private final int blo;
  private final a blp;
  private final String bls;
  private final Handler eventHandler;
  private final Uri uri;
  
  public g(Uri paramUri, com.google.android.exoplayer2.h.g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, (byte)0);
  }
  
  private g(Uri paramUri, com.google.android.exoplayer2.h.g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1, byte paramByte)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, '\000');
  }
  
  private g(Uri paramUri, com.google.android.exoplayer2.h.g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1, char paramChar)
  {
    AppMethodBeat.i(92672);
    this.uri = paramUri;
    this.blV = parama;
    this.blW = paramh;
    this.blo = -1;
    this.eventHandler = paramHandler;
    this.blp = parama1;
    this.bls = null;
    this.blX = 1048576;
    this.aRQ = new w.a();
    AppMethodBeat.o(92672);
  }
  
  private void e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92677);
    this.blY = paramLong;
    this.blZ = paramBoolean;
    this.bll.a(new n(this.blY, this.blZ), null);
    AppMethodBeat.o(92677);
  }
  
  public final h a(i.b paramb, b paramb1)
  {
    AppMethodBeat.i(92674);
    if (paramb.bmb == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new f(this.uri, this.blV.vc(), this.blW.sT(), this.blo, this.eventHandler, this.blp, this, paramb1, this.bls, this.blX);
      AppMethodBeat.o(92674);
      return paramb;
    }
  }
  
  public final void a(com.google.android.exoplayer2.f paramf, i.a parama)
  {
    AppMethodBeat.i(92673);
    this.bll = parama;
    e(-9223372036854775807L, false);
    AppMethodBeat.o(92673);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(92675);
    paramh = (f)paramh;
    boolean bool = paramh.blu.a(paramh);
    if ((paramh.aSG) && (!bool))
    {
      k[] arrayOfk = paramh.blA;
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        arrayOfk[i].uh();
        i += 1;
      }
    }
    paramh.handler.removeCallbacksAndMessages(null);
    paramh.released = true;
    AppMethodBeat.o(92675);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92676);
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.blY;
    }
    if (((this.blY == l) && (this.blZ == paramBoolean)) || ((this.blY != -9223372036854775807L) && (l == -9223372036854775807L)))
    {
      AppMethodBeat.o(92676);
      return;
    }
    e(l, paramBoolean);
    AppMethodBeat.o(92676);
  }
  
  public final void tO() {}
  
  public final void tP()
  {
    this.bll = null;
  }
  
  public static abstract interface a
  {
    public abstract void onLoadError(IOException paramIOException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.g
 * JD-Core Version:    0.7.0.1
 */