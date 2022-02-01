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

public final class d
  implements k
{
  protected b<com.google.android.exoplayer2.drm.d> aLu;
  protected Context context;
  protected Handler handler;
  protected j.a pAR;
  protected e.a pAS;
  protected com.google.android.exoplayer2.a.e pAT;
  protected com.google.android.exoplayer2.video.e pAU;
  protected int pAV = 50;
  protected int pAW = 5000;
  
  public d(Context paramContext, Handler paramHandler, j.a parama, e.a parama1, com.google.android.exoplayer2.a.e parame, com.google.android.exoplayer2.video.e parame1)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.pAR = parama;
    this.pAS = parama1;
    this.pAT = parame;
    this.pAU = parame1;
  }
  
  public final List<r> bWv()
  {
    AppMethodBeat.i(227059);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new i(com.google.android.exoplayer2.e.c.bdq, this.aLu, this.handler, this.pAT, com.google.android.exoplayer2.a.c.ab(this.context), new com.google.android.exoplayer2.a.d[0]));
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    localArrayList2.add(new com.google.android.exoplayer2.video.c(this.context, com.google.android.exoplayer2.e.c.bdq, this.pAW, this.aLu, this.handler, this.pAU, this.pAV));
    localArrayList1.addAll(localArrayList2);
    AppMethodBeat.o(227059);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d
 * JD-Core Version:    0.7.0.1
 */