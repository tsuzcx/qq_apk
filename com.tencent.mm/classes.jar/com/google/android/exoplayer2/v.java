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
import com.google.android.exoplayer2.a.b.a;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.source.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v
  implements f
{
  protected final r[] aQP;
  private final f aRp;
  private final a aSH;
  final CopyOnWriteArraySet<Object> aSI;
  final CopyOnWriteArraySet<j.a> aSJ;
  public final CopyOnWriteArraySet<e.a> aSK;
  private final int aSL;
  private final int aSM;
  public Format aSN;
  Format aSO;
  private boolean aSQ;
  private int aSR;
  private SurfaceHolder aSS;
  private TextureView aST;
  public com.google.android.exoplayer2.a.e aSU;
  com.google.android.exoplayer2.video.e aSV;
  d aSW;
  d aSX;
  int aSY;
  private b aSZ;
  private float aTa;
  Surface surface;
  
  protected v(u paramu, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(92534);
    this.aSH = new a((byte)0);
    this.aSI = new CopyOnWriteArraySet();
    this.aSJ = new CopyOnWriteArraySet();
    this.aSK = new CopyOnWriteArraySet();
    Looper localLooper;
    int i;
    int k;
    int j;
    if (Looper.myLooper() != null)
    {
      localLooper = Looper.myLooper();
      this.aQP = paramu.a(new Handler(localLooper), this.aSH, this.aSH, this.aSH, this.aSH);
      paramu = this.aQP;
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
    this.aSL = j;
    this.aSM = k;
    this.aTa = 1.0F;
    this.aSY = 0;
    this.aSZ = b.aTA;
    this.aSR = 1;
    this.aRp = new h(this.aQP, paramh, paramm);
    AppMethodBeat.o(92534);
  }
  
  private void a(Surface paramSurface, boolean paramBoolean)
  {
    AppMethodBeat.i(92558);
    f.c[] arrayOfc = new f.c[this.aSL];
    r[] arrayOfr = this.aQP;
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
        this.aRp.b(arrayOfc);
        if (this.aSQ) {
          this.surface.release();
        }
      }
      for (;;)
      {
        this.surface = paramSurface;
        this.aSQ = paramBoolean;
        AppMethodBeat.o(92558);
        return;
        this.aRp.a(arrayOfc);
      }
    }
  }
  
  private void rO()
  {
    AppMethodBeat.i(92557);
    if (this.aST != null)
    {
      if (this.aST.getSurfaceTextureListener() == this.aSH) {
        this.aST.setSurfaceTextureListener(null);
      }
      this.aST = null;
    }
    if (this.aSS != null)
    {
      this.aSS.removeCallback(this.aSH);
      this.aSS = null;
    }
    AppMethodBeat.o(92557);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(92537);
    this.aSZ = paramb;
    f.c[] arrayOfc = new f.c[this.aSM];
    r[] arrayOfr = this.aQP;
    int m = arrayOfr.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      r localr = arrayOfr[j];
      if (localr.getTrackType() != 1) {
        break label104;
      }
      int k = i + 1;
      arrayOfc[i] = new f.c(localr, 3, paramb);
      i = k;
    }
    label104:
    for (;;)
    {
      j += 1;
      break;
      this.aRp.a(arrayOfc);
      AppMethodBeat.o(92537);
      return;
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(92548);
    this.aRp.a(paramp);
    AppMethodBeat.o(92548);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(92539);
    this.aRp.a(parama);
    AppMethodBeat.o(92539);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(92542);
    this.aRp.a(paramj);
    AppMethodBeat.o(92542);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92551);
    this.aRp.a(paramVarArgs);
    AppMethodBeat.o(92551);
  }
  
  public final void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(92543);
    this.aRp.aO(paramBoolean);
    AppMethodBeat.o(92543);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(92540);
    this.aRp.b(parama);
    AppMethodBeat.o(92540);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92552);
    this.aRp.b(paramVarArgs);
    AppMethodBeat.o(92552);
  }
  
  public final void c(Surface paramSurface)
  {
    AppMethodBeat.i(92535);
    rO();
    a(paramSurface, false);
    AppMethodBeat.o(92535);
  }
  
  public final void d(TextureView paramTextureView)
  {
    Surface localSurface = null;
    AppMethodBeat.i(205008);
    rO();
    this.aST = paramTextureView;
    if (paramTextureView == null) {}
    label76:
    for (;;)
    {
      a(localSurface, true);
      AppMethodBeat.o(205008);
      return;
      paramTextureView.getSurfaceTextureListener();
      paramTextureView.setSurfaceTextureListener(this.aSH);
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
    int i = this.aRp.getBufferedPercentage();
    AppMethodBeat.o(92556);
    return i;
  }
  
  public final long getBufferedPosition()
  {
    AppMethodBeat.i(92555);
    long l = this.aRp.getBufferedPosition();
    AppMethodBeat.o(92555);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(92554);
    long l = this.aRp.getCurrentPosition();
    AppMethodBeat.o(92554);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(92553);
    long l = this.aRp.getDuration();
    AppMethodBeat.o(92553);
    return l;
  }
  
  public final boolean isLoading()
  {
    AppMethodBeat.i(92546);
    boolean bool = this.aRp.isLoading();
    AppMethodBeat.o(92546);
    return bool;
  }
  
  @Deprecated
  public final void rN()
  {
    AppMethodBeat.i(92536);
    x.wa();
    x.wb();
    b.a locala = new b.a();
    locala.aTC = 1;
    locala.aTB = 2;
    a(locala.rT());
    AppMethodBeat.o(92536);
  }
  
  public final void release()
  {
    AppMethodBeat.i(92550);
    this.aRp.release();
    rO();
    if (this.surface != null)
    {
      if (this.aSQ) {
        this.surface.release();
      }
      this.surface = null;
    }
    AppMethodBeat.o(92550);
  }
  
  public final int rt()
  {
    AppMethodBeat.i(92541);
    int i = this.aRp.rt();
    AppMethodBeat.o(92541);
    return i;
  }
  
  public final boolean ru()
  {
    AppMethodBeat.i(92544);
    boolean bool = this.aRp.ru();
    AppMethodBeat.o(92544);
    return bool;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(92547);
    this.aRp.seekTo(paramLong);
    AppMethodBeat.o(92547);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(92545);
    this.aRp.setRepeatMode(paramInt);
    AppMethodBeat.o(92545);
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(92538);
    this.aTa = paramFloat;
    f.c[] arrayOfc = new f.c[this.aSM];
    r[] arrayOfr = this.aQP;
    int m = arrayOfr.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      r localr = arrayOfr[j];
      if (localr.getTrackType() != 1) {
        break label109;
      }
      int k = i + 1;
      arrayOfc[i] = new f.c(localr, 2, Float.valueOf(paramFloat));
      i = k;
    }
    label109:
    for (;;)
    {
      j += 1;
      break;
      this.aRp.a(arrayOfc);
      AppMethodBeat.o(92538);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(92549);
    this.aRp.stop();
    AppMethodBeat.o(92549);
  }
  
  final class a
    implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(92519);
      Iterator localIterator = v.this.aSI.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      if (v.this.aSV != null) {
        v.this.aSV.a(paramInt1, paramInt2, paramInt3, paramFloat);
      }
      AppMethodBeat.o(92519);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(92515);
      v.this.aSW = paramd;
      if (v.this.aSV != null) {
        v.this.aSV.a(paramd);
      }
      AppMethodBeat.o(92515);
    }
    
    public final void b(d paramd)
    {
      AppMethodBeat.i(92521);
      if (v.this.aSV != null) {
        v.this.aSV.b(paramd);
      }
      v.this.aSN = null;
      v.this.aSW = null;
      AppMethodBeat.o(92521);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(92529);
      Iterator localIterator = v.this.aSK.iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).b(paramMetadata);
      }
      AppMethodBeat.o(92529);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92516);
      if (v.this.aSV != null) {
        v.this.aSV.b(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92516);
    }
    
    public final void c(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92526);
      if (v.this.aSU != null) {
        v.this.aSU.c(paramInt, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92526);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(92517);
      v.this.aSN = paramFormat;
      if (v.this.aSV != null) {
        v.this.aSV.c(paramFormat);
      }
      AppMethodBeat.o(92517);
    }
    
    public final void c(d paramd)
    {
      AppMethodBeat.i(92522);
      v.this.aSX = paramd;
      if (v.this.aSU != null) {
        v.this.aSU.c(paramd);
      }
      AppMethodBeat.o(92522);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92524);
      if (v.this.aSU != null) {
        v.this.aSU.c(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92524);
    }
    
    public final void d(Surface paramSurface)
    {
      AppMethodBeat.i(92520);
      if (v.this.surface == paramSurface)
      {
        Iterator localIterator = v.this.aSI.iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
      if (v.this.aSV != null) {
        v.this.aSV.d(paramSurface);
      }
      AppMethodBeat.o(92520);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(92525);
      v.this.aSO = paramFormat;
      if (v.this.aSU != null) {
        v.this.aSU.d(paramFormat);
      }
      AppMethodBeat.o(92525);
    }
    
    public final void d(d paramd)
    {
      AppMethodBeat.i(92527);
      if (v.this.aSU != null) {
        v.this.aSU.d(paramd);
      }
      v.this.aSO = null;
      v.this.aSX = null;
      v.this.aSY = 0;
      AppMethodBeat.o(92527);
    }
    
    public final void dI(int paramInt)
    {
      AppMethodBeat.i(92523);
      v.this.aSY = paramInt;
      if (v.this.aSU != null) {
        v.this.aSU.dI(paramInt);
      }
      AppMethodBeat.o(92523);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(92518);
      if (v.this.aSV != null) {
        v.this.aSV.h(paramInt, paramLong);
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
    
    public final void t(List<a> paramList)
    {
      AppMethodBeat.i(92528);
      Iterator localIterator = v.this.aSJ.iterator();
      while (localIterator.hasNext()) {
        ((j.a)localIterator.next()).t(paramList);
      }
      AppMethodBeat.o(92528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.v
 * JD-Core Version:    0.7.0.1
 */