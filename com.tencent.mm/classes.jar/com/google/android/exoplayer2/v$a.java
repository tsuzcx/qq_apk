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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class v$a
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
{
  private v$a(v paramv) {}
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(95393);
    this.axI.axD = paramd;
    if (this.axI.axC != null) {
      this.axI.axC.a(paramd);
    }
    AppMethodBeat.o(95393);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(95395);
    Iterator localIterator = this.axI.axp.iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    if (this.axI.axC != null) {
      this.axI.axC.b(paramInt1, paramInt2, paramInt3, paramFloat);
    }
    AppMethodBeat.o(95395);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(95397);
    if (this.axI.axC != null) {
      this.axI.axC.b(paramd);
    }
    this.axI.axu = null;
    this.axI.axD = null;
    AppMethodBeat.o(95397);
  }
  
  public final void b(Metadata paramMetadata)
  {
    AppMethodBeat.i(95405);
    Iterator localIterator = this.axI.axr.iterator();
    while (localIterator.hasNext()) {
      ((e.a)localIterator.next()).b(paramMetadata);
    }
    AppMethodBeat.o(95405);
  }
  
  public final void b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151937);
    if (this.axI.axC != null) {
      this.axI.axC.b(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(151937);
  }
  
  public final void c(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95402);
    if (this.axI.axB != null) {
      this.axI.axB.c(paramInt, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95402);
  }
  
  public final void c(Surface paramSurface)
  {
    AppMethodBeat.i(95396);
    if (this.axI.axw == paramSurface)
    {
      Iterator localIterator = this.axI.axp.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    if (this.axI.axC != null) {
      this.axI.axC.c(paramSurface);
    }
    AppMethodBeat.o(95396);
  }
  
  public final void c(Format paramFormat)
  {
    AppMethodBeat.i(95394);
    this.axI.axu = paramFormat;
    if (this.axI.axC != null) {
      this.axI.axC.c(paramFormat);
    }
    AppMethodBeat.o(95394);
  }
  
  public final void c(d paramd)
  {
    AppMethodBeat.i(95398);
    this.axI.axE = paramd;
    if (this.axI.axB != null) {
      this.axI.axB.c(paramd);
    }
    AppMethodBeat.o(95398);
  }
  
  public final void c(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95400);
    if (this.axI.axB != null) {
      this.axI.axB.c(paramString, paramLong1, paramLong2);
    }
    AppMethodBeat.o(95400);
  }
  
  public final void cX(int paramInt)
  {
    AppMethodBeat.i(95399);
    this.axI.axF = paramInt;
    if (this.axI.axB != null) {
      this.axI.axB.cX(paramInt);
    }
    AppMethodBeat.o(95399);
  }
  
  public final void d(Format paramFormat)
  {
    AppMethodBeat.i(95401);
    this.axI.axv = paramFormat;
    if (this.axI.axB != null) {
      this.axI.axB.d(paramFormat);
    }
    AppMethodBeat.o(95401);
  }
  
  public final void d(d paramd)
  {
    AppMethodBeat.i(95403);
    if (this.axI.axB != null) {
      this.axI.axB.d(paramd);
    }
    this.axI.axv = null;
    this.axI.axE = null;
    this.axI.axF = 0;
    AppMethodBeat.o(95403);
  }
  
  public final void h(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151938);
    if (this.axI.axC != null) {
      this.axI.axC.h(paramInt, paramLong);
    }
    AppMethodBeat.o(151938);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95408);
    v.a(this.axI, new Surface(paramSurfaceTexture), true);
    AppMethodBeat.o(95408);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(95409);
    v.a(this.axI, null, true);
    AppMethodBeat.o(95409);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void r(List<a> paramList)
  {
    AppMethodBeat.i(95404);
    Iterator localIterator = this.axI.axq.iterator();
    while (localIterator.hasNext()) {
      ((j.a)localIterator.next()).r(paramList);
    }
    AppMethodBeat.o(95404);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(95406);
    v.a(this.axI, paramSurfaceHolder.getSurface(), false);
    AppMethodBeat.o(95406);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(95407);
    v.a(this.axI, null, false);
    AppMethodBeat.o(95407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.v.a
 * JD-Core Version:    0.7.0.1
 */