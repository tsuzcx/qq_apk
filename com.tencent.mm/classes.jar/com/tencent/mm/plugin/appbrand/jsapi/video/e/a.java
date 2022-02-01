package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements c
{
  private final Set<b.e> kTA = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.f> kTB = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.b> kTC = Collections.newSetFromMap(new ConcurrentHashMap());
  protected int kTr = 0;
  private volatile boolean kTs;
  protected b.d kTt;
  protected b.c kTu;
  protected b.e kTv;
  protected b.b kTw;
  protected b.f kTx;
  protected b.a kTy;
  protected b.g kTz;
  
  public final void a(b.a parama)
  {
    this.kTy = parama;
  }
  
  public final void a(b.b paramb)
  {
    this.kTw = paramb;
  }
  
  public final void a(b.c paramc)
  {
    this.kTu = paramc;
  }
  
  public final void a(b.d paramd)
  {
    this.kTt = paramd;
  }
  
  public final void a(b.e parame)
  {
    this.kTv = parame;
  }
  
  public final void a(b.f paramf)
  {
    this.kTx = paramf;
  }
  
  public final void a(b.g paramg)
  {
    this.kTz = paramg;
  }
  
  public final void b(b.b paramb)
  {
    this.kTC.add(paramb);
  }
  
  public final void b(b.e parame)
  {
    this.kTA.add(parame);
  }
  
  public final void b(b.f paramf)
  {
    this.kTB.add(paramf);
  }
  
  protected final void bkA()
  {
    ac.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.kTs) {
        return;
      }
      if (this.kTw != null) {
        this.kTw.Fh();
      }
      Iterator localIterator = this.kTC.iterator();
      while (localIterator.hasNext()) {
        ((b.b)localIterator.next()).Fh();
      }
      return;
    }
    finally {}
  }
  
  protected final void bkB()
  {
    ac.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.kTs) {
        return;
      }
      if (this.kTx != null) {
        this.kTx.b(this);
      }
      Iterator localIterator = this.kTB.iterator();
      while (localIterator.hasNext()) {
        ((b.f)localIterator.next()).b(this);
      }
      return;
    }
    finally {}
  }
  
  protected final void bkz()
  {
    ac.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.kTs) {
        return;
      }
      if (this.kTv != null) {
        this.kTv.a(this);
      }
      Iterator localIterator = this.kTA.iterator();
      while (localIterator.hasNext()) {
        ((b.e)localIterator.next()).a(this);
      }
      return;
    }
    finally {}
  }
  
  public final void dU(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.kTs) {
        return;
      }
      if (this.kTz != null)
      {
        this.kTz.a(this, paramInt1, paramInt2);
        return;
      }
    }
    finally {}
  }
  
  public final boolean dV(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.kTs) {
        return false;
      }
      if ((this.kTu != null) && (this.kTu.bZ(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final boolean dW(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.kTs) {
        return false;
      }
      if ((this.kTt != null) && (this.kTt.bY(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final int getState()
  {
    return this.kTr;
  }
  
  public void release()
  {
    this.kTs = true;
  }
  
  public final void sZ(int paramInt)
  {
    try
    {
      if (this.kTs) {
        return;
      }
      if (this.kTy != null)
      {
        this.kTy.gH(paramInt);
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