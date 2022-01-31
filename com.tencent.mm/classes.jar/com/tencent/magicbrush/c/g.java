package com.tencent.magicbrush.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class g
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public ConcurrentLinkedDeque<TextureView.SurfaceTextureListener> bLD;
  protected MBRuntime mbRuntime;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(115998);
    this.bLD = new ConcurrentLinkedDeque();
    c.c.i("MagicBrush.MBTextureView", "MBRendererView construct", new Object[0]);
    this.mbRuntime = null;
    super.setSurfaceTextureListener(this);
    AppMethodBeat.o(115998);
  }
  
  public MBRuntime getMBRuntime()
  {
    return this.mbRuntime;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(116000);
    super.onAttachedToWindow();
    c.c.i("MagicBrush.MBTextureView", "MBRendererView.onAttachedToWindow", new Object[0]);
    AppMethodBeat.o(116000);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(116001);
    super.onDetachedFromWindow();
    c.c.i("MagicBrush.MBTextureView", "MBRendererView.onDetachedFromWindow", new Object[0]);
    AppMethodBeat.o(116001);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116002);
    c.c.i("MagicBrush.MBTextureView", "onSurfaceTextureAvailable() called with: surface = [" + paramSurfaceTexture + "], width = [" + paramInt1 + "], height = [" + paramInt2 + "]", new Object[0]);
    this.mbRuntime.notifyWindowAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if (this.bLD != null)
    {
      Iterator localIterator = this.bLD.iterator();
      while (localIterator.hasNext()) {
        ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(116002);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(116004);
    c.c.i("MagicBrush.MBTextureView", "onSurfaceTextureDestroyed() called with: surface = [" + paramSurfaceTexture + "]", new Object[0]);
    this.mbRuntime.notifyWindowDestroyed(paramSurfaceTexture, yz());
    if (this.bLD != null)
    {
      Iterator localIterator = this.bLD.iterator();
      while (localIterator.hasNext()) {
        ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureDestroyed(paramSurfaceTexture);
      }
    }
    AppMethodBeat.o(116004);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116003);
    c.c.i("MagicBrush.MBTextureView", "onSurfaceTextureSizeChanged() called with: surface = [" + paramSurfaceTexture + "], width = [" + paramInt1 + "], height = [" + paramInt2 + "]", new Object[0]);
    this.mbRuntime.notifyWindowChanged(paramSurfaceTexture, paramInt1, paramInt2);
    if (this.bLD != null)
    {
      Iterator localIterator = this.bLD.iterator();
      while (localIterator.hasNext()) {
        ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(116003);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(116005);
    if (this.bLD != null)
    {
      Iterator localIterator = this.bLD.iterator();
      while (localIterator.hasNext()) {
        ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureUpdated(paramSurfaceTexture);
      }
    }
    AppMethodBeat.o(116005);
  }
  
  public void setMBRuntime(MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(115999);
    c.c.i("MagicBrush.MBTextureView", "MBRendererView setMBRuntime", new Object[0]);
    this.mbRuntime = paramMBRuntime;
    this.mbRuntime.setMBRuntimeView(this);
    AppMethodBeat.o(115999);
  }
  
  public void yA()
  {
    AppMethodBeat.i(151482);
    c.c.i("MagicBrush.MBTextureView", "hy: request release view", new Object[0]);
    AppMethodBeat.o(151482);
  }
  
  protected boolean yz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.c.g
 * JD-Core Version:    0.7.0.1
 */