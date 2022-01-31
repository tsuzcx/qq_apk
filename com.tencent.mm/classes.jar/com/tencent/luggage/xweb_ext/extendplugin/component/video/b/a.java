package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import com.tencent.mm.sdk.platformtools.ab;

public abstract class a
  implements b
{
  private volatile boolean bIe;
  protected b.d bIf;
  protected b.c bIg;
  protected b.e bIh;
  protected b.b bIi;
  protected b.f bIj;
  protected b.a bIk;
  protected b.g bIl;
  protected int mCurrentState = 0;
  
  public final void a(b.a parama)
  {
    this.bIk = parama;
  }
  
  public final void a(b.b paramb)
  {
    this.bIi = paramb;
  }
  
  public final void a(b.c paramc)
  {
    this.bIg = paramc;
  }
  
  public final void a(b.d paramd)
  {
    this.bIf = paramd;
  }
  
  public final void a(b.e parame)
  {
    this.bIh = parame;
  }
  
  public final void a(b.f paramf)
  {
    this.bIj = paramf;
  }
  
  public final void a(b.g paramg)
  {
    this.bIl = paramg;
  }
  
  public final void bM(int paramInt1, int paramInt2)
  {
    ab.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.bIe) {
        return;
      }
      if (this.bIl != null)
      {
        this.bIl.bI(paramInt1, paramInt2);
        return;
      }
    }
    finally {}
  }
  
  public final boolean bN(int paramInt1, int paramInt2)
  {
    ab.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.bIe) {
        return false;
      }
      if (this.bIg != null)
      {
        this.bIg.bK(paramInt1, paramInt2);
        return false;
      }
    }
    finally {}
    return false;
  }
  
  protected final boolean bO(int paramInt1, int paramInt2)
  {
    ab.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    try
    {
      if (this.bIe) {
        return false;
      }
      if (this.bIf != null)
      {
        this.bIf.bJ(paramInt1, paramInt2);
        return false;
      }
    }
    finally {}
    return false;
  }
  
  public final void fE(int paramInt)
  {
    try
    {
      if (this.bIe) {
        return;
      }
      if (this.bIk != null)
      {
        this.bIk.fC(paramInt);
        return;
      }
    }
    finally {}
  }
  
  public final int getState()
  {
    return this.mCurrentState;
  }
  
  public void release()
  {
    this.bIe = true;
  }
  
  protected final void xW()
  {
    ab.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.bIe) {
        return;
      }
      if (this.bIh != null)
      {
        this.bIh.xJ();
        return;
      }
    }
    finally {}
  }
  
  protected final void xX()
  {
    ab.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.bIe) {
        return;
      }
      if (this.bIi != null)
      {
        this.bIi.xK();
        return;
      }
    }
    finally {}
  }
  
  protected final void xY()
  {
    ab.i("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.bIe) {
        return;
      }
      if (this.bIj != null)
      {
        this.bIj.xL();
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
 * JD-Core Version:    0.7.0.1
 */