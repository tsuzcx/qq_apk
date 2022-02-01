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
  implements j
{
  protected b<com.google.android.exoplayer2.drm.d> bbV;
  protected Context context;
  protected Handler handler;
  protected j.a mBW;
  protected e.a mBX;
  protected com.google.android.exoplayer2.a.e mBY;
  protected com.google.android.exoplayer2.video.e mBZ;
  protected int mCa = 50;
  protected int mCb = 5000;
  
  public d(Context paramContext, Handler paramHandler, j.a parama, e.a parama1, com.google.android.exoplayer2.a.e parame, com.google.android.exoplayer2.video.e parame1)
  {
    this.context = paramContext;
    this.handler = paramHandler;
    this.mBW = parama;
    this.mBX = parama1;
    this.mBY = parame;
    this.mBZ = parame1;
  }
  
  public final List<r> bKB()
  {
    AppMethodBeat.i(234968);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new i(com.google.android.exoplayer2.e.c.btN, this.bbV, this.handler, this.mBY, com.google.android.exoplayer2.a.c.aj(this.context), new com.google.android.exoplayer2.a.d[0]));
    localArrayList1.addAll(localArrayList2);
    localArrayList2 = new ArrayList();
    localArrayList2.add(new com.google.android.exoplayer2.video.c(this.context, com.google.android.exoplayer2.e.c.btN, this.mCb, this.bbV, this.handler, this.mBZ, this.mCa));
    localArrayList1.addAll(localArrayList2);
    AppMethodBeat.o(234968);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.d
 * JD-Core Version:    0.7.0.1
 */