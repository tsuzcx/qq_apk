package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.a.i;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f
  implements o
{
  protected b<com.google.android.exoplayer2.drm.d> cFr;
  protected Context context;
  protected Handler handler;
  protected j.a sFP;
  protected e.a sFQ;
  protected com.google.android.exoplayer2.a.e sFR;
  protected com.google.android.exoplayer2.video.e sFS;
  protected int sFT = 50;
  protected int sFU = 5000;
  
  public f(Context paramContext, Handler paramHandler, j.a parama, e.a parama1, com.google.android.exoplayer2.a.e parame, com.google.android.exoplayer2.video.e parame1)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.sFP = parama;
    this.sFQ = parama1;
    this.sFR = parame;
    this.sFS = parame1;
  }
  
  public final List<r> cwH()
  {
    AppMethodBeat.i(328705);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new i(com.google.android.exoplayer2.e.c.cXk, this.cFr, this.handler, this.sFR, com.google.android.exoplayer2.a.c.aM(this.context), new com.google.android.exoplayer2.a.d[0]));
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    localArrayList2.add(new com.google.android.exoplayer2.video.c(this.context, com.google.android.exoplayer2.e.c.cXk, this.sFU, this.cFr, this.handler, this.sFS, this.sFT));
    localArrayList1.addAll(localArrayList2);
    AppMethodBeat.o(328705);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f
 * JD-Core Version:    0.7.0.1
 */