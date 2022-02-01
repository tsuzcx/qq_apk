package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements c
{
  protected int ksb = 0;
  private volatile boolean ksc;
  protected b.d ksd;
  protected b.c kse;
  protected b.e ksf;
  protected b.b ksg;
  protected b.f ksh;
  protected b.a ksi;
  protected b.g ksj;
  private final Set<b.e> ksk = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.f> ksl = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.b> ksm = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public final void a(b.a parama)
  {
    this.ksi = parama;
  }
  
  public final void a(b.b paramb)
  {
    this.ksg = paramb;
  }
  
  public final void a(b.c paramc)
  {
    this.kse = paramc;
  }
  
  public final void a(b.d paramd)
  {
    this.ksd = paramd;
  }
  
  public final void a(b.e parame)
  {
    this.ksf = parame;
  }
  
  public final void a(b.f paramf)
  {
    this.ksh = paramf;
  }
  
  public final void a(b.g paramg)
  {
    this.ksj = paramg;
  }
  
  public final void b(b.b paramb)
  {
    this.ksm.add(paramb);
  }
  
  public final void b(b.e parame)
  {
    this.ksk.add(parame);
  }
  
  public final void b(b.f paramf)
  {
    this.ksl.add(paramf);
  }
  
  protected final void bdF()
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.ksc) {
        return;
      }
      if (this.ksf != null) {
        this.ksf.a(this);
      }
      Iterator localIterator = this.ksk.iterator();
      while (localIterator.hasNext()) {
        ((b.e)localIterator.next()).a(this);
      }
      return;
    }
    finally {}
  }
  
  protected final void bdG()
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.ksc) {
        return;
      }
      if (this.ksg != null) {
        this.ksg.Fz();
      }
      Iterator localIterator = this.ksm.iterator();
      while (localIterator.hasNext()) {
        ((b.b)localIterator.next()).Fz();
      }
      return;
    }
    finally {}
  }
  
  protected final void bdH()
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.ksc) {
        return;
      }
      if (this.ksh != null) {
        this.ksh.b(this);
      }
      Iterator localIterator = this.ksl.iterator();
      while (localIterator.hasNext()) {
        ((b.f)localIterator.next()).b(this);
      }
      return;
    }
    finally {}
  }
  
  public final void dT(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.ksc) {
        return;
      }
      if (this.ksj != null)
      {
        this.ksj.a(this, paramInt1, paramInt2);
        return;
      }
    }
    finally {}
  }
  
  public final boolean dU(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.ksc) {
        return false;
      }
      if ((this.kse != null) && (this.kse.cc(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final boolean dV(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.ksc) {
        return false;
      }
      if ((this.ksd != null) && (this.ksd.cb(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final int getState()
  {
    return this.ksb;
  }
  
  public void release()
  {
    this.ksc = true;
  }
  
  public final void sj(int paramInt)
  {
    try
    {
      if (this.ksc) {
        return;
      }
      if (this.ksi != null)
      {
        this.ksi.gX(paramInt);
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a
 * JD-Core Version:    0.7.0.1
 */