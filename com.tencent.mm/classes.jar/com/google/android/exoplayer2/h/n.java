package com.google.android.exoplayer2.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  implements g.a
{
  private final g.a bwZ;
  private final x<? super g> bws;
  private final Context context;
  
  public n(Context paramContext, x<? super g> paramx, g.a parama)
  {
    AppMethodBeat.i(93067);
    this.context = paramContext.getApplicationContext();
    this.bws = paramx;
    this.bwZ = parama;
    AppMethodBeat.o(93067);
  }
  
  public n(Context paramContext, String paramString)
  {
    this(paramContext, paramString, (byte)0);
  }
  
  private n(Context paramContext, String paramString, byte paramByte)
  {
    this(paramContext, null, new p(paramString, null));
    AppMethodBeat.i(93066);
    AppMethodBeat.o(93066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.n
 * JD-Core Version:    0.7.0.1
 */