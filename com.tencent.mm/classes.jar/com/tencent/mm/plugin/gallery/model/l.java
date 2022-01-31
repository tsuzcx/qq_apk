package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public final class l
{
  private int gvt = 3;
  HashSet<g.a> kHm = new HashSet();
  public HashSet<g.b> kHn = new HashSet();
  g kHo;
  public int kHp = 1;
  
  private void aXD()
  {
    y.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[] { Integer.valueOf(this.kHp) });
    switch (this.kHp)
    {
    default: 
      this.kHo = new i();
      return;
    case 1: 
      this.kHo = new i();
      return;
    case 2: 
      this.kHo = new n();
      return;
    }
    this.kHo = new h();
  }
  
  public final void a(g.a parama)
  {
    this.kHm.add(parama);
  }
  
  public final int aXE()
  {
    y.i("MicroMsg.MediaQueryService", "getQuerySource, %d, %s", new Object[] { Integer.valueOf(this.gvt), bk.csb() });
    return this.gvt;
  }
  
  public final int aXF()
  {
    y.i("MicroMsg.MediaQueryService", "getQueryType, %d, %s", new Object[] { Integer.valueOf(this.kHp), bk.csb() });
    return this.kHp;
  }
  
  public final void aXG()
  {
    if (this.kHo == null)
    {
      y.f("MicroMsg.MediaQueryService", "media query not init, init again");
      aXD();
    }
    c.aXc().K(new l.1(this));
  }
  
  public final void b(g.a parama)
  {
    this.kHm.remove(parama);
  }
  
  public final void e(String paramString, int paramInt, long paramLong)
  {
    if (this.kHo == null)
    {
      y.f("MicroMsg.MediaQueryService", "media query not init, init again");
      aXD();
    }
    c.aXc().aXp().removeCallbacksAndMessages(null);
    this.kHo.aXw();
    e locale = c.aXc();
    paramString = new l.2(this, paramString, paramInt, paramLong);
    locale.aXp().post(paramString);
  }
  
  public final void rO(int paramInt)
  {
    this.kHp = paramInt;
    aXD();
  }
  
  public final void rP(int paramInt)
  {
    y.i("MicroMsg.MediaQueryService", "setQuerySource, %d, %s", new Object[] { Integer.valueOf(paramInt), bk.csb() });
    this.gvt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l
 * JD-Core Version:    0.7.0.1
 */