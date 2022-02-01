package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.mm.sdk.platformtools.ae;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
  implements c
{
  protected b.h luA;
  protected b.c luB;
  private final Set<b.f> luC = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.g> luD = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<b.b> luE = Collections.newSetFromMap(new ConcurrentHashMap());
  protected int lur = 0;
  private volatile boolean lus;
  protected b.e lut;
  protected b.d luu;
  protected b.f luv;
  protected b.b luw;
  protected b.g luy;
  protected b.a luz;
  
  public final void RO(String paramString)
  {
    ae.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnDownStreamChanged, selectIndex:%s", new Object[] { paramString });
    try
    {
      if (this.lus) {
        return;
      }
      if (this.luB != null)
      {
        this.luB.RP(paramString);
        return;
      }
    }
    finally {}
  }
  
  public final void a(b.a parama)
  {
    this.luz = parama;
  }
  
  public final void a(b.b paramb)
  {
    this.luw = paramb;
  }
  
  public final void a(b.c paramc)
  {
    this.luB = paramc;
  }
  
  public final void a(b.d paramd)
  {
    this.luu = paramd;
  }
  
  public final void a(b.e parame)
  {
    this.lut = parame;
  }
  
  public final void a(b.f paramf)
  {
    this.luv = paramf;
  }
  
  public final void a(b.g paramg)
  {
    this.luy = paramg;
  }
  
  public final void a(b.h paramh)
  {
    this.luA = paramh;
  }
  
  public final void b(b.b paramb)
  {
    this.luE.add(paramb);
  }
  
  public final void b(b.f paramf)
  {
    this.luC.add(paramf);
  }
  
  public final void b(b.g paramg)
  {
    this.luD.add(paramg);
  }
  
  protected final void boU()
  {
    ae.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.lus) {
        return;
      }
      if (this.luv != null) {
        this.luv.a(this);
      }
      Iterator localIterator = this.luC.iterator();
      while (localIterator.hasNext()) {
        ((b.f)localIterator.next()).a(this);
      }
      return;
    }
    finally {}
  }
  
  protected final void boV()
  {
    ae.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.lus) {
        return;
      }
      if (this.luw != null) {
        this.luw.GH();
      }
      Iterator localIterator = this.luE.iterator();
      while (localIterator.hasNext()) {
        ((b.b)localIterator.next()).GH();
      }
      return;
    }
    finally {}
  }
  
  protected final void boW()
  {
    ae.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.lus) {
        return;
      }
      if (this.luy != null) {
        this.luy.b(this);
      }
      Iterator localIterator = this.luD.iterator();
      while (localIterator.hasNext()) {
        ((b.g)localIterator.next()).b(this);
      }
      return;
    }
    finally {}
  }
  
  public final void dW(int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.lus) {
        return;
      }
      if (this.luA != null)
      {
        this.luA.a(this, paramInt1, paramInt2);
        return;
      }
    }
    finally {}
  }
  
  protected boolean dX(int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.lus) {
        return false;
      }
      if ((this.luu != null) && (this.luu.cc(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final boolean dY(int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.lus) {
        return false;
      }
      if ((this.lut != null) && (this.lut.cb(paramInt1, paramInt2))) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public final int getState()
  {
    return this.lur;
  }
  
  public void release()
  {
    this.lus = true;
  }
  
  public final void tH(int paramInt)
  {
    try
    {
      if (this.lus) {
        return;
      }
      if (this.luz != null)
      {
        this.luz.gN(paramInt);
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