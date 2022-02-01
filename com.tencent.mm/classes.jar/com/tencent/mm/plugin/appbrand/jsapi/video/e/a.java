package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements c
{
  protected int lpU = 0;
  private volatile boolean lpV;
  protected b.e lpW;
  protected b.d lpX;
  protected b.f lpY;
  protected b.b lpZ;
  protected b.g lqa;
  protected b.a lqb;
  protected b.h lqc;
  protected b.c lqd;
  private final Set<b.f> lqe = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.g> lqf = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.b> lqg = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public final void Rf(String paramString)
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnDownStreamChanged, selectIndex:%s", new Object[] { paramString });
    try
    {
      if (this.lpV) {
        return;
      }
      if (this.lqd != null)
      {
        this.lqd.Rg(paramString);
        return;
      }
    }
    finally {}
  }
  
  public final void a(b.a parama)
  {
    this.lqb = parama;
  }
  
  public final void a(b.b paramb)
  {
    this.lpZ = paramb;
  }
  
  public final void a(b.c paramc)
  {
    this.lqd = paramc;
  }
  
  public final void a(b.d paramd)
  {
    this.lpX = paramd;
  }
  
  public final void a(b.e parame)
  {
    this.lpW = parame;
  }
  
  public final void a(b.f paramf)
  {
    this.lpY = paramf;
  }
  
  public final void a(b.g paramg)
  {
    this.lqa = paramg;
  }
  
  public final void a(b.h paramh)
  {
    this.lqc = paramh;
  }
  
  public final void b(b.b paramb)
  {
    this.lqg.add(paramb);
  }
  
  public final void b(b.f paramf)
  {
    this.lqe.add(paramf);
  }
  
  public final void b(b.g paramg)
  {
    this.lqf.add(paramg);
  }
  
  protected final void bok()
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.lpV) {
        return;
      }
      if (this.lpY != null) {
        this.lpY.a(this);
      }
      Iterator localIterator = this.lqe.iterator();
      while (localIterator.hasNext()) {
        ((b.f)localIterator.next()).a(this);
      }
      return;
    }
    finally {}
  }
  
  protected final void bol()
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.lpV) {
        return;
      }
      if (this.lpZ != null) {
        this.lpZ.GB();
      }
      Iterator localIterator = this.lqg.iterator();
      while (localIterator.hasNext()) {
        ((b.b)localIterator.next()).GB();
      }
      return;
    }
    finally {}
  }
  
  protected final void bom()
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.lpV) {
        return;
      }
      if (this.lqa != null) {
        this.lqa.b(this);
      }
      Iterator localIterator = this.lqf.iterator();
      while (localIterator.hasNext()) {
        ((b.g)localIterator.next()).b(this);
      }
      return;
    }
    finally {}
  }
  
  public final void dW(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.lpV) {
        return;
      }
      if (this.lqc != null)
      {
        this.lqc.a(this, paramInt1, paramInt2);
        return;
      }
    }
    finally {}
  }
  
  public final boolean dX(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.lpV) {
        return false;
      }
      if ((this.lpX != null) && (this.lpX.cb(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final boolean dY(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.lpV) {
        return false;
      }
      if ((this.lpW != null) && (this.lpW.ca(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final int getState()
  {
    return this.lpU;
  }
  
  public void release()
  {
    this.lpV = true;
  }
  
  public final void tC(int paramInt)
  {
    try
    {
      if (this.lpV) {
        return;
      }
      if (this.lqb != null)
      {
        this.lqb.gM(paramInt);
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