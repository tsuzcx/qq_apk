package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

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
  implements d
{
  protected b<com.google.android.exoplayer2.drm.d> avq;
  protected com.google.android.exoplayer2.video.e bIA;
  protected int bIB = 50;
  protected int bIC = 5000;
  protected j.a bIx;
  protected e.a bIy;
  protected com.google.android.exoplayer2.a.e bIz;
  protected Context context;
  protected Handler handler;
  
  public a(Context paramContext, Handler paramHandler, j.a parama, e.a parama1, com.google.android.exoplayer2.a.e parame, com.google.android.exoplayer2.video.e parame1)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.bIx = parama;
    this.bIy = parama1;
    this.bIz = parame;
    this.bIA = parame1;
  }
  
  public final List<r> yc()
  {
    AppMethodBeat.i(139934);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new i(com.google.android.exoplayer2.e.c.aNt, this.avq, this.handler, this.bIz, com.google.android.exoplayer2.a.c.aa(this.context), new com.google.android.exoplayer2.a.d[0]));
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    localArrayList2.add(new com.google.android.exoplayer2.video.c(this.context, com.google.android.exoplayer2.e.c.aNt, this.bIC, this.avq, this.handler, this.bIA, this.bIB));
    localArrayList1.addAll(localArrayList2);
    AppMethodBeat.o(139934);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.a
 * JD-Core Version:    0.7.0.1
 */