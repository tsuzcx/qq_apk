package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements d
{
  protected int mAT = 0;
  private volatile boolean mAU;
  protected c.f mAV;
  protected c.e mAW;
  protected c.g mAX;
  protected c.b mAY;
  protected c.h mAZ;
  protected c.a mBa;
  protected c.i mBb;
  protected c.d mBc;
  private final Set<c.g> mBd = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<c.h> mBe = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<c.b> mBf = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public final void a(c.a parama)
  {
    this.mBa = parama;
  }
  
  public final void a(c.b paramb)
  {
    this.mAY = paramb;
  }
  
  public final void a(c.d paramd)
  {
    this.mBc = paramd;
  }
  
  public final void a(c.e parame)
  {
    this.mAW = parame;
  }
  
  public final void a(c.f paramf)
  {
    this.mAV = paramf;
  }
  
  public final void a(c.g paramg)
  {
    this.mAX = paramg;
  }
  
  public final void a(c.h paramh)
  {
    this.mAZ = paramh;
  }
  
  public final void a(c.i parami)
  {
    this.mBb = parami;
  }
  
  public void a(String paramString1, String paramString2, c.c paramc)
  {
    dU(paramString1, paramString2);
    if (paramc != null) {
      paramc.bKA();
    }
  }
  
  public final void abt(String paramString)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnDownStreamChanged, selectIndex:%s", new Object[] { paramString });
    try
    {
      if (this.mAU) {
        return;
      }
      if (this.mBc != null)
      {
        this.mBc.abu(paramString);
        return;
      }
    }
    finally {}
  }
  
  public final void b(c.b paramb)
  {
    this.mBf.add(paramb);
  }
  
  public final void b(c.g paramg)
  {
    this.mBd.add(paramg);
  }
  
  public final void b(c.h paramh)
  {
    this.mBe.add(paramh);
  }
  
  protected final void bKx()
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.mAU) {
        return;
      }
      if (this.mAX != null) {
        this.mAX.a(this);
      }
      Iterator localIterator = this.mBd.iterator();
      while (localIterator.hasNext()) {
        ((c.g)localIterator.next()).a(this);
      }
      return;
    }
    finally {}
  }
  
  protected final void bKy()
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.mAU) {
        return;
      }
      if (this.mAY != null) {
        this.mAY.QA();
      }
      Iterator localIterator = this.mBf.iterator();
      while (localIterator.hasNext()) {
        ((c.b)localIterator.next()).QA();
      }
      return;
    }
    finally {}
  }
  
  protected final void bKz()
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.mAU) {
        return;
      }
      if (this.mAZ != null) {
        this.mAZ.b(this);
      }
      Iterator localIterator = this.mBe.iterator();
      while (localIterator.hasNext()) {
        ((c.h)localIterator.next()).b(this);
      }
      return;
    }
    finally {}
  }
  
  public final void ei(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.mAU) {
        return;
      }
      if (this.mBb != null)
      {
        this.mBb.a(this, paramInt1, paramInt2);
        return;
      }
    }
    finally {}
  }
  
  protected boolean ej(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.mAU) {
        return false;
      }
      if ((this.mAW != null) && (this.mAW.cc(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final boolean ek(int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.mAU) {
        return false;
      }
      if ((this.mAV != null) && (this.mAV.cb(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final int getState()
  {
    return this.mAT;
  }
  
  public void release()
  {
    this.mAU = true;
  }
  
  public final void xF(int paramInt)
  {
    try
    {
      if (this.mAU) {
        return;
      }
      if (this.mBa != null)
      {
        this.mBa.id(paramInt);
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.a
 * JD-Core Version:    0.7.0.1
 */