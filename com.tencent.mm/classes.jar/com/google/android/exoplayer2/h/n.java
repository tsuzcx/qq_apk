package com.google.android.exoplayer2.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  implements g.a
{
  private final Context context;
  private final g.a diI;
  private final w<? super g> did;
  
  public n(Context paramContext, w<? super g> paramw, g.a parama)
  {
    AppMethodBeat.i(93067);
    this.context = paramContext.getApplicationContext();
    this.did = paramw;
    this.diI = parama;
    AppMethodBeat.o(93067);
  }
  
  public n(Context paramContext, String paramString, w<? super g> paramw)
  {
    this(paramContext, paramw, new p(paramString, paramw));
    AppMethodBeat.i(210316);
    AppMethodBeat.o(210316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.n
 * JD-Core Version:    0.7.0.1
 */