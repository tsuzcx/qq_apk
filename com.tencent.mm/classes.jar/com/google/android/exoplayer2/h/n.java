package com.google.android.exoplayer2.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  implements g.a
{
  private final g.a boS;
  private final w<? super g> bol;
  private final Context context;
  
  public n(Context paramContext, w<? super g> paramw, g.a parama)
  {
    AppMethodBeat.i(93067);
    this.context = paramContext.getApplicationContext();
    this.bol = paramw;
    this.boS = parama;
    AppMethodBeat.o(93067);
  }
  
  public n(Context paramContext, String paramString, w<? super g> paramw)
  {
    this(paramContext, paramw, new p(paramString, paramw));
    AppMethodBeat.i(199626);
    AppMethodBeat.o(199626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.n
 * JD-Core Version:    0.7.0.1
 */