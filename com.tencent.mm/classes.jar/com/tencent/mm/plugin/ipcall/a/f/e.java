package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.h;
import com.tencent.mm.plugin.ipcall.a.h.a;
import com.tencent.mm.protocal.c.bgb;

public final class e
  extends com.tencent.mm.plugin.ipcall.a.a.a
  implements h.a
{
  private h lsA = null;
  
  public final int LW()
  {
    return 8;
  }
  
  public final void a(bgb parambgb)
  {
    this.lpA.a(8, parambgb, 0, 0);
  }
  
  public final void b(c paramc) {}
  
  public final int[] bcs()
  {
    return new int[0];
  }
  
  public final void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.lsA);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public final void pT()
  {
    this.lsA = new h();
    this.lsA.lpb = this;
    com.tencent.mm.sdk.b.a.udP.c(this.lsA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.f.e
 * JD-Core Version:    0.7.0.1
 */