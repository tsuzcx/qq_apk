package com.tencent.mm.plugin.expt.edge.a;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.expt.edge.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.apache.commons.c.i;

public abstract class a
  implements c
{
  private com.tencent.mm.plugin.expt.edge.a.b.c zyo;
  private int zyp = 0;
  
  public final void a(com.tencent.mm.plugin.expt.edge.e.a parama)
  {
    if ((parama == null) || (this.zyo == null)) {
      return;
    }
    this.zyo.a(parama);
  }
  
  public final List<com.tencent.mm.plugin.expt.edge.e.a> aqj(String paramString)
  {
    if ((i.hm(paramString)) || (this.zyo == null)) {
      return null;
    }
    return this.zyo.SV(paramString);
  }
  
  public final void clear(String paramString)
  {
    if ((i.hm(paramString)) || (this.zyo == null)) {
      return;
    }
    this.zyo.remove(paramString);
  }
  
  public final void close()
  {
    if (this.zyo != null) {
      this.zyo.close();
    }
    this.zyo = null;
  }
  
  public final long count()
  {
    if (this.zyo == null) {
      return 0L;
    }
    return this.zyo.count();
  }
  
  public final void dId()
  {
    if (this.zyo == null) {
      return;
    }
    this.zyo.dId();
  }
  
  public final void lS(long paramLong)
  {
    if (this.zyo == null) {
      return;
    }
    this.zyo.lS(paramLong);
  }
  
  public final void reset()
  {
    this.zyp = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqi, 0);
    if (this.zyo != null) {
      this.zyo.close();
    }
    this.zyo = null;
    switch (this.zyp)
    {
    }
    while (this.zyo != null)
    {
      this.zyo.reset();
      Log.i("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] reset storageMode : " + this.zyp);
      return;
      this.zyo = new com.tencent.mm.plugin.expt.edge.a.b.a(type());
      continue;
      this.zyo = new b(type());
    }
    Log.e("EdgeComputingDataCacheBase", "[EdgeComputingDataCacheBase] reset illegal storageMode : " + this.zyp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.a.a
 * JD-Core Version:    0.7.0.1
 */