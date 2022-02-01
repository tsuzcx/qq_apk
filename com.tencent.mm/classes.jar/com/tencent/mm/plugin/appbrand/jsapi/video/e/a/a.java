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
  protected b<com.google.android.exoplayer2.drm.d> aRD;
  protected Context context;
  protected Handler handler;
  protected j.a kTM;
  protected e.a kTN;
  protected com.google.android.exoplayer2.a.e kTO;
  protected com.google.android.exoplayer2.video.e kTP;
  protected int kTQ = 50;
  protected int kTR = 5000;
  
  public a(Context paramContext, Handler paramHandler, j.a parama, e.a parama1, com.google.android.exoplayer2.a.e parame, com.google.android.exoplayer2.video.e parame1)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.kTM = parama;
    this.kTN = parama1;
    this.kTO = parame;
    this.kTP = parame1;
  }
  
  public final List<r> bkC()
  {
    AppMethodBeat.i(194454);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new i(com.google.android.exoplayer2.e.c.bjy, this.aRD, this.handler, this.kTO, com.google.android.exoplayer2.a.c.ah(this.context), new com.google.android.exoplayer2.a.d[0]));
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    localArrayList2.add(new com.google.android.exoplayer2.video.c(this.context, com.google.android.exoplayer2.e.c.bjy, this.kTR, this.aRD, this.handler, this.kTP, this.kTQ));
    localArrayList1.addAll(localArrayList2);
    AppMethodBeat.o(194454);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a
 * JD-Core Version:    0.7.0.1
 */