package com.tencent.mapsdk.internal;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class su
  extends TextureView
  implements TextureView.SurfaceTextureListener, bt
{
  private sj a;
  private si b;
  
  public su(bd parambd)
  {
    super(parambd.getContext());
    AppMethodBeat.i(223739);
    this.a = ((sj)parambd.b());
    setSurfaceTextureListener(this);
    setOpaque(parambd.n());
    this.b = new si(this.a);
    si.a(parambd.m());
    this.b.start();
    AppMethodBeat.o(223739);
  }
  
  public final void a()
  {
    AppMethodBeat.i(223790);
    if (this.b != null) {
      this.b.b();
    }
    AppMethodBeat.o(223790);
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(223849);
    if (this.b != null) {
      si.a(paramFloat);
    }
    AppMethodBeat.o(223849);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223840);
    this.b.a(paramObject);
    if (this.a != null)
    {
      this.a.a(null, null);
      this.a.a(null, paramInt1, paramInt2);
    }
    AppMethodBeat.o(223840);
  }
  
  public final void b()
  {
    AppMethodBeat.i(223801);
    if (this.b != null) {
      this.b.a();
    }
    AppMethodBeat.o(223801);
  }
  
  public final void c()
  {
    AppMethodBeat.i(223808);
    if (this.b != null) {
      this.b.c();
    }
    AppMethodBeat.o(223808);
  }
  
  public final void d()
  {
    AppMethodBeat.i(223782);
    if (this.b != null) {
      synchronized (this.b)
      {
        this.b.notify();
        AppMethodBeat.o(223782);
        return;
      }
    }
    AppMethodBeat.o(223782);
  }
  
  protected final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(223889);
    if ((this.a != null) && (this.a.a(paramMotionEvent)))
    {
      AppMethodBeat.o(223889);
      return true;
    }
    boolean bool = super.dispatchHoverEvent(paramMotionEvent);
    AppMethodBeat.o(223889);
    return bool;
  }
  
  public final boolean e()
  {
    AppMethodBeat.i(223869);
    boolean bool = isOpaque();
    AppMethodBeat.o(223869);
    return bool;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(223824);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.e(paramInt1, paramInt2);
    }
    AppMethodBeat.o(223824);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223750);
    a(paramSurfaceTexture, paramInt1, paramInt2);
    AppMethodBeat.o(223750);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223758);
    if (this.a != null)
    {
      this.a.a(null, paramInt1, paramInt2);
      if (this.b != null) {
        this.b.d();
      }
    }
    AppMethodBeat.o(223758);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void setMapOpaque(boolean paramBoolean)
  {
    AppMethodBeat.i(223861);
    if (this.a != null) {
      setOpaque(paramBoolean);
    }
    AppMethodBeat.o(223861);
  }
  
  public final void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.su
 * JD-Core Version:    0.7.0.1
 */