package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v
  implements f
{
  private final f bcC;
  protected final r[] bcc;
  private final a bdR;
  final CopyOnWriteArraySet<Object> bdS;
  final CopyOnWriteArraySet<j.a> bdT;
  public final CopyOnWriteArraySet<e.a> bdU;
  private final int bdV;
  private final int bdW;
  Format bdX;
  Format bdY;
  private boolean bdZ;
  private int bea;
  private SurfaceHolder beb;
  private TextureView bec;
  public com.google.android.exoplayer2.a.e bed;
  com.google.android.exoplayer2.video.e bee;
  d bef;
  d beg;
  int beh;
  private b bei;
  private float bej;
  Surface surface;
  
  protected v(u paramu, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(92534);
    this.bdR = new a((byte)0);
    this.bdS = new CopyOnWriteArraySet();
    this.bdT = new CopyOnWriteArraySet();
    this.bdU = new CopyOnWriteArraySet();
    Looper localLooper;
    int i;
    int k;
    int j;
    if (Looper.myLooper() != null)
    {
      localLooper = Looper.myLooper();
      this.bcc = paramu.a(new Handler(localLooper), this.bdR, this.bdR, this.bdR, this.bdR);
      paramu = this.bcc;
      int m = paramu.length;
      i = 0;
      k = 0;
      j = 0;
      label119:
      if (i >= m) {
        break label191;
      }
      switch (paramu[i].getTrackType())
      {
      }
    }
    for (;;)
    {
      i += 1;
      break label119;
      localLooper = Looper.getMainLooper();
      break;
      j += 1;
      continue;
      k += 1;
    }
    label191:
    this.bdV = j;
    this.bdW = k;
    this.bej = 1.0F;
    this.beh = 0;
    this.bei = b.beJ;
    this.bea = 1;
    this.bcC = new h(this.bcc, paramh, paramm);
    AppMethodBeat.o(92534);
  }
  
  private void a(Surface paramSurface, boolean paramBoolean)
  {
    AppMethodBeat.i(92558);
    f.c[] arrayOfc = new f.c[this.bdV];
    r[] arrayOfr = this.bcc;
    int m = arrayOfr.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      r localr = arrayOfr[j];
      if (localr.getTrackType() != 2) {
        break label157;
      }
      int k = i + 1;
      arrayOfc[i] = new f.c(localr, 1, paramSurface);
      i = k;
    }
    label157:
    for (;;)
    {
      j += 1;
      break;
      if ((this.surface != null) && (this.surface != paramSurface))
      {
        this.bcC.b(arrayOfc);
        if (this.bdZ) {
          this.surface.release();
        }
      }
      for (;;)
      {
        this.surface = paramSurface;
        this.bdZ = paramBoolean;
        AppMethodBeat.o(92558);
        return;
        this.bcC.a(arrayOfc);
      }
    }
  }
  
  private void tC()
  {
    AppMethodBeat.i(92557);
    if (this.bec != null)
    {
      if (this.bec.getSurfaceTextureListener() == this.bdR) {
        this.bec.setSurfaceTextureListener(null);
      }
      this.bec = null;
    }
    if (this.beb != null)
    {
      this.beb.removeCallback(this.bdR);
      this.beb = null;
    }
    AppMethodBeat.o(92557);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(92548);
    this.bcC.a(paramp);
    AppMethodBeat.o(92548);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(92539);
    this.bcC.a(parama);
    AppMethodBeat.o(92539);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(92542);
    this.bcC.a(paramk);
    AppMethodBeat.o(92542);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92551);
    this.bcC.a(paramVarArgs);
    AppMethodBeat.o(92551);
  }
  
  public final void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(92543);
    this.bcC.aO(paramBoolean);
    AppMethodBeat.o(92543);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(92540);
    this.bcC.b(parama);
    AppMethodBeat.o(92540);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92552);
    this.bcC.b(paramVarArgs);
    AppMethodBeat.o(92552);
  }
  
  public final void c(TextureView paramTextureView)
  {
    Surface localSurface = null;
    AppMethodBeat.i(196037);
    tC();
    this.bec = paramTextureView;
    if (paramTextureView == null) {}
    label76:
    for (;;)
    {
      a(localSurface, true);
      AppMethodBeat.o(196037);
      return;
      paramTextureView.getSurfaceTextureListener();
      paramTextureView.setSurfaceTextureListener(this.bdR);
      if (paramTextureView.isAvailable()) {}
      for (paramTextureView = paramTextureView.getSurfaceTexture();; paramTextureView = null)
      {
        if (paramTextureView == null) {
          break label76;
        }
        localSurface = new Surface(paramTextureView);
        break;
      }
    }
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(92556);
    int i = this.bcC.getBufferedPercentage();
    AppMethodBeat.o(92556);
    return i;
  }
  
  public final long getBufferedPosition()
  {
    AppMethodBeat.i(92555);
    long l = this.bcC.getBufferedPosition();
    AppMethodBeat.o(92555);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(92554);
    long l = this.bcC.getCurrentPosition();
    AppMethodBeat.o(92554);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(92553);
    long l = this.bcC.getDuration();
    AppMethodBeat.o(92553);
    return l;
  }
  
  public final boolean isLoading()
  {
    AppMethodBeat.i(92546);
    boolean bool = this.bcC.isLoading();
    AppMethodBeat.o(92546);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(92550);
    this.bcC.release();
    tC();
    if (this.surface != null)
    {
      if (this.bdZ) {
        this.surface.release();
      }
      this.surface = null;
    }
    AppMethodBeat.o(92550);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(92547);
    this.bcC.seekTo(paramLong);
    AppMethodBeat.o(92547);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(92545);
    this.bcC.setRepeatMode(paramInt);
    AppMethodBeat.o(92545);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(92549);
    this.bcC.stop();
    AppMethodBeat.o(92549);
  }
  
  public final int ti()
  {
    AppMethodBeat.i(92541);
    int i = this.bcC.ti();
    AppMethodBeat.o(92541);
    return i;
  }
  
  public final boolean tj()
  {
    AppMethodBeat.i(92544);
    boolean bool = this.bcC.tj();
    AppMethodBeat.o(92544);
    return bool;
  }
  
  final class a
    implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(92519);
      Iterator localIterator = v.this.bdS.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      if (v.this.bee != null) {
        v.this.bee.a(paramInt1, paramInt2, paramInt3, paramFloat);
      }
      AppMethodBeat.o(92519);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(92515);
      v.this.bef = paramd;
      if (v.this.bee != null) {
        v.this.bee.a(paramd);
      }
      AppMethodBeat.o(92515);
    }
    
    public final void b(d paramd)
    {
      AppMethodBeat.i(92521);
      if (v.this.bee != null) {
        v.this.bee.b(paramd);
      }
      v.this.bdX = null;
      v.this.bef = null;
      AppMethodBeat.o(92521);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(92529);
      Iterator localIterator = v.this.bdU.iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).b(paramMetadata);
      }
      AppMethodBeat.o(92529);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92516);
      if (v.this.bee != null) {
        v.this.bee.b(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92516);
    }
    
    public final void c(Surface paramSurface)
    {
      AppMethodBeat.i(92520);
      if (v.this.surface == paramSurface)
      {
        Iterator localIterator = v.this.bdS.iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
      if (v.this.bee != null) {
        v.this.bee.c(paramSurface);
      }
      AppMethodBeat.o(92520);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(92517);
      v.this.bdX = paramFormat;
      if (v.this.bee != null) {
        v.this.bee.c(paramFormat);
      }
      AppMethodBeat.o(92517);
    }
    
    public final void c(d paramd)
    {
      AppMethodBeat.i(92522);
      v.this.beg = paramd;
      if (v.this.bed != null) {
        v.this.bed.c(paramd);
      }
      AppMethodBeat.o(92522);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92524);
      if (v.this.bed != null) {
        v.this.bed.c(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92524);
    }
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92526);
      if (v.this.bed != null) {
        v.this.bed.d(paramInt, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92526);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(92525);
      v.this.bdY = paramFormat;
      if (v.this.bed != null) {
        v.this.bed.d(paramFormat);
      }
      AppMethodBeat.o(92525);
    }
    
    public final void d(d paramd)
    {
      AppMethodBeat.i(92527);
      if (v.this.bed != null) {
        v.this.bed.d(paramd);
      }
      v.this.bdY = null;
      v.this.beg = null;
      v.this.beh = 0;
      AppMethodBeat.o(92527);
    }
    
    public final void dG(int paramInt)
    {
      AppMethodBeat.i(92523);
      v.this.beh = paramInt;
      if (v.this.bed != null) {
        v.this.bed.dG(paramInt);
      }
      AppMethodBeat.o(92523);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(92518);
      if (v.this.bee != null) {
        v.this.bee.h(paramInt, paramLong);
      }
      AppMethodBeat.o(92518);
    }
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92532);
      v.a(v.this, new Surface(paramSurfaceTexture), true);
      AppMethodBeat.o(92532);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(92533);
      v.a(v.this, null, true);
      AppMethodBeat.o(92533);
      return true;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
    
    public final void s(List<a> paramList)
    {
      AppMethodBeat.i(92528);
      Iterator localIterator = v.this.bdT.iterator();
      while (localIterator.hasNext()) {
        ((j.a)localIterator.next()).s(paramList);
      }
      AppMethodBeat.o(92528);
    }
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(92530);
      v.a(v.this, paramSurfaceHolder.getSurface(), false);
      AppMethodBeat.o(92530);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(92531);
      v.a(v.this, null, false);
      AppMethodBeat.o(92531);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.v
 * JD-Core Version:    0.7.0.1
 */