package com.google.android.exoplayer2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class v$a
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
{
  private v$a(v paramv) {}
  
  public final void a(d paramd)
  {
    this.avs.avn = paramd;
    if (this.avs.avm != null) {
      this.avs.avm.a(paramd);
    }
  }
  
  public final void a(Metadata paramMetadata)
  {
    Iterator localIterator = this.avs.ava.iterator();
    while (localIterator.hasNext()) {
      ((e.a)localIterator.next()).a(paramMetadata);
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Iterator localIterator = this.avs.auY.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    if (this.avs.avm != null) {
      this.avs.avm.b(paramInt1, paramInt2, paramInt3, paramFloat);
    }
  }
  
  public final void b(Surface paramSurface)
  {
    if (this.avs.avf == paramSurface)
    {
      Iterator localIterator = this.avs.auY.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    if (this.avs.avm != null) {
      this.avs.avm.b(paramSurface);
    }
  }
  
  public final void b(d paramd)
  {
    if (this.avs.avm != null) {
      this.avs.avm.b(paramd);
    }
    this.avs.avd = null;
    this.avs.avn = null;
  }
  
  public final void b(String paramString, long paramLong1, long paramLong2)
  {
    if (this.avs.avl != null) {
      this.avs.avl.b(paramString, paramLong1, paramLong2);
    }
  }
  
  public final void c(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.avs.avl != null) {
      this.avs.avl.c(paramInt, paramLong1, paramLong2);
    }
  }
  
  public final void c(Format paramFormat)
  {
    this.avs.avd = paramFormat;
    if (this.avs.avm != null) {
      this.avs.avm.c(paramFormat);
    }
  }
  
  public final void c(d paramd)
  {
    this.avs.avo = paramd;
    if (this.avs.avl != null) {
      this.avs.avl.c(paramd);
    }
  }
  
  public final void cC(int paramInt)
  {
    this.avs.avp = paramInt;
    if (this.avs.avl != null) {
      this.avs.avl.cC(paramInt);
    }
  }
  
  public final void d(Format paramFormat)
  {
    this.avs.ave = paramFormat;
    if (this.avs.avl != null) {
      this.avs.avl.d(paramFormat);
    }
  }
  
  public final void d(d paramd)
  {
    if (this.avs.avl != null) {
      this.avs.avl.d(paramd);
    }
    this.avs.ave = null;
    this.avs.avo = null;
    this.avs.avp = 0;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    v.a(this.avs, new Surface(paramSurfaceTexture), true);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    v.a(this.avs, null, true);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void p(List<a> paramList)
  {
    Iterator localIterator = this.avs.auZ.iterator();
    while (localIterator.hasNext()) {
      ((j.a)localIterator.next()).p(paramList);
    }
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    v.a(this.avs, paramSurfaceHolder.getSurface(), false);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    v.a(this.avs, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.v.a
 * JD-Core Version:    0.7.0.1
 */