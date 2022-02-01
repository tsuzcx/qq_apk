package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

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

public final class a
  implements e
{
  protected b<com.google.android.exoplayer2.drm.d> bbY;
  protected Context context;
  protected Handler handler;
  protected j.a lqJ;
  protected e.a lqK;
  protected com.google.android.exoplayer2.a.e lqL;
  protected com.google.android.exoplayer2.video.e lqM;
  protected int lqN = 50;
  protected int lqO = 5000;
  
  public a(Context paramContext, Handler paramHandler, j.a parama, e.a parama1, com.google.android.exoplayer2.a.e parame, com.google.android.exoplayer2.video.e parame1)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.lqJ = parama;
    this.lqK = parama1;
    this.lqL = parame;
    this.lqM = parame1;
  }
  
  public final List<r> bon()
  {
    AppMethodBeat.i(206266);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new i(com.google.android.exoplayer2.e.c.btS, this.bbY, this.handler, this.lqL, com.google.android.exoplayer2.a.c.ah(this.context), new com.google.android.exoplayer2.a.d[0]));
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    localArrayList2.add(new com.google.android.exoplayer2.video.c(this.context, com.google.android.exoplayer2.e.c.btS, this.lqO, this.bbY, this.handler, this.lqM, this.lqN));
    localArrayList1.addAll(localArrayList2);
    AppMethodBeat.o(206266);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a
 * JD-Core Version:    0.7.0.1
 */