package com.tencent.mm.ah;

import com.tencent.mm.model.bg;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public abstract class m
{
  public boolean aSd = false;
  public e edc;
  public long edd = bk.UZ();
  public int ede = -1;
  private s edf;
  f edg;
  public boolean edh;
  public q edi;
  private int limit = -99;
  int priority = 0;
  
  public boolean KA()
  {
    return Ka() == 1;
  }
  
  public final q KB()
  {
    return this.edi;
  }
  
  public final int KC()
  {
    if (this.edi == null) {
      return 0;
    }
    return this.edi.hashCode();
  }
  
  public int Ka()
  {
    return 1;
  }
  
  public boolean Kx()
  {
    return false;
  }
  
  public boolean Ky()
  {
    return this.limit <= 0;
  }
  
  public boolean Kz()
  {
    return false;
  }
  
  public abstract int a(e parame, f paramf);
  
  public int a(e parame, final q paramq, final k paramk)
  {
    c(parame);
    this.edi = paramq;
    paramk = bg.a(paramk);
    int i = bg.HT();
    if (i != 0) {
      return i;
    }
    if (this.limit == -99)
    {
      this.limit = Ka();
      y.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.limit);
    }
    if (Ka() > 1) {
      switch (2.edm[b(paramq).ordinal()])
      {
      default: 
        Assert.assertTrue("invalid security verification status", false);
      }
    }
    while (Ky())
    {
      y.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + Ka());
      a(a.edo);
      this.ede = -1;
      return this.ede;
      Assert.assertTrue("scene security verification not passed, type=" + paramq.getType() + ", uri=" + paramq.getUri() + ", CHECK NOW", false);
      continue;
      y.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + paramq.getType() + ", uri=" + paramq.getUri());
      this.limit -= 1;
      a(a.edn);
      this.ede = -1;
      return this.ede;
    }
    this.limit -= 1;
    u localu = new u(paramq);
    if ((this.edf != null) && (!Kz())) {
      this.edf.cancel();
    }
    this.edf = new s(paramq, paramk, this, this.edg, parame);
    this.ede = parame.a(localu, this.edf);
    y.i("MicroMsg.NetSceneBase", "dispatcher send, %s", new Object[] { Integer.valueOf(this.ede) });
    if (this.ede < 0)
    {
      y.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(this.ede), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramq.getType()) });
      new ah().post(new Runnable()
      {
        public final void run()
        {
          y.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(m.this.ede), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramq.getType()) });
          paramk.a(-1, 3, -1, "send to network failed", paramq, null);
          y.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(m.this.ede), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramq.getType()) });
        }
      });
      return 99999999;
    }
    parame = this.edf;
    parame.handler.postDelayed(parame.edV, 330000L);
    return this.ede;
  }
  
  public void a(a parama) {}
  
  public boolean a(m paramm)
  {
    return false;
  }
  
  public b b(q paramq)
  {
    return b.edq;
  }
  
  public boolean b(m paramm)
  {
    return false;
  }
  
  public final void c(e parame)
  {
    this.edd = bk.UZ();
    this.edc = parame;
  }
  
  public void cancel()
  {
    y.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", new Object[] { Integer.valueOf(this.ede), Integer.valueOf(hashCode()), Integer.valueOf(getType()) });
    this.aSd = true;
    if (this.edf != null) {
      this.edf.cancel();
    }
    if ((this.ede != -1) && (this.edc != null))
    {
      int i = this.ede;
      this.ede = -1;
      this.edc.cancel(i);
    }
  }
  
  public String getInfo()
  {
    return "";
  }
  
  public abstract int getType();
  
  public final void reset()
  {
    this.edd = bk.UZ();
    this.ede = -1;
    this.limit = -99;
  }
  
  protected static enum a
  {
    private a() {}
  }
  
  protected static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.m
 * JD-Core Version:    0.7.0.1
 */