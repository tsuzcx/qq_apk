package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

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
  protected b<com.google.android.exoplayer2.drm.d> aQI;
  protected Context context;
  protected Handler handler;
  protected int ksA = 50;
  protected int ksB = 5000;
  protected j.a ksw;
  protected e.a ksx;
  protected com.google.android.exoplayer2.a.e ksy;
  protected com.google.android.exoplayer2.video.e ksz;
  
  public a(Context paramContext, Handler paramHandler, j.a parama, e.a parama1, com.google.android.exoplayer2.a.e parame, com.google.android.exoplayer2.video.e parame1)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.ksw = parama;
    this.ksx = parama1;
    this.ksy = parame;
    this.ksz = parame1;
  }
  
  public final List<r> bdI()
  {
    AppMethodBeat.i(194109);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new i(com.google.android.exoplayer2.e.c.biT, this.aQI, this.handler, this.ksy, com.google.android.exoplayer2.a.c.ag(this.context), new com.google.android.exoplayer2.a.d[0]));
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    localArrayList2.add(new com.google.android.exoplayer2.video.c(this.context, com.google.android.exoplayer2.e.c.biT, this.ksB, this.aQI, this.handler, this.ksz, this.ksA));
    localArrayList1.addAll(localArrayList2);
    AppMethodBeat.o(194109);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a
 * JD-Core Version:    0.7.0.1
 */