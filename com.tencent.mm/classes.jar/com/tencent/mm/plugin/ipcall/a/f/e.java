package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.h;
import com.tencent.mm.plugin.ipcall.a.h.a;
import com.tencent.mm.protocal.protobuf.boh;

public final class e
  extends com.tencent.mm.plugin.ipcall.a.a.a
  implements h.a
{
  private h nPV = null;
  
  public final void a(boh paramboh)
  {
    AppMethodBeat.i(21907);
    this.nMW.a(8, paramboh, 0, 0);
    AppMethodBeat.o(21907);
  }
  
  public final void b(c paramc) {}
  
  public final int[] bJz()
  {
    return new int[0];
  }
  
  public final int getServiceType()
  {
    return 8;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(21906);
    com.tencent.mm.sdk.b.a.ymk.d(this.nPV);
    AppMethodBeat.o(21906);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public final void tW()
  {
    AppMethodBeat.i(21905);
    this.nPV = new h();
    this.nPV.nMx = this;
    com.tencent.mm.sdk.b.a.ymk.c(this.nPV);
    AppMethodBeat.o(21905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.e
 * JD-Core Version:    0.7.0.1
 */