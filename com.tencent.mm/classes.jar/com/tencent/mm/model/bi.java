package com.tencent.mm.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class bi
  extends m
  implements k
{
  private final a dWZ;
  private final String dXa;
  private long dXb;
  private f dmL;
  
  public bi(a parama)
  {
    this(parama, null);
  }
  
  public bi(a parama, String paramString)
  {
    y.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", new Object[] { paramString, bk.csb() });
    this.dWZ = parama;
    this.dXa = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    c(parame);
    this.dmL = paramf;
    this.dXb = bk.UZ();
    g.DS().O(new Runnable()
    {
      public final void run()
      {
        bi.this.a(0, 0, 0, null, null, null);
      }
      
      public final String toString()
      {
        return super.toString() + "|doScene";
      }
    });
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if (this.dWZ != null)
    {
      y.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", new Object[] { this.dXa, Long.valueOf(bk.cp(this.dXb)) });
      this.dWZ.a(this.edc);
    }
    this.dmL.onSceneEnd(0, 0, null, this);
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void a(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bi
 * JD-Core Version:    0.7.0.1
 */