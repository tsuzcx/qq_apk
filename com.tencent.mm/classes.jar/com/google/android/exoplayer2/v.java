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
import com.google.android.exoplayer2.source.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v
  implements f
{
  protected final r[] aRK;
  private final f aSk;
  private final a aTA;
  final CopyOnWriteArraySet<Object> aTB;
  final CopyOnWriteArraySet<j.a> aTC;
  public final CopyOnWriteArraySet<e.a> aTD;
  private final int aTE;
  private final int aTF;
  Format aTG;
  Format aTH;
  private boolean aTI;
  private int aTJ;
  private SurfaceHolder aTK;
  private TextureView aTL;
  public com.google.android.exoplayer2.a.e aTM;
  com.google.android.exoplayer2.video.e aTN;
  d aTO;
  d aTP;
  int aTQ;
  private b aTR;
  private float aTS;
  Surface surface;
  
  protected v(u paramu, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(92534);
    this.aTA = new a((byte)0);
    this.aTB = new CopyOnWriteArraySet();
    this.aTC = new CopyOnWriteArraySet();
    this.aTD = new CopyOnWriteArraySet();
    Looper localLooper;
    int i;
    int k;
    int j;
    if (Looper.myLooper() != null)
    {
      localLooper = Looper.myLooper();
      this.aRK = paramu.a(new Handler(localLooper), this.aTA, this.aTA, this.aTA, this.aTA);
      paramu = this.aRK;
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
    this.aTE = j;
    this.aTF = k;
    this.aTS = 1.0F;
    this.aTQ = 0;
    this.aTR = b.aUs;
    this.aTJ = 1;
    this.aSk = new h(this.aRK, paramh, paramm);
    AppMethodBeat.o(92534);
  }
  
  private void a(Surface paramSurface, boolean paramBoolean)
  {
    AppMethodBeat.i(92558);
    f.c[] arrayOfc = new f.c[this.aTE];
    r[] arrayOfr = this.aRK;
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
        this.aSk.b(arrayOfc);
        if (this.aTI) {
          this.surface.release();
        }
      }
      for (;;)
      {
        this.surface = paramSurface;
        this.aTI = paramBoolean;
        AppMethodBeat.o(92558);
        return;
        this.aSk.a(arrayOfc);
      }
    }
  }
  
  private void rY()
  {
    AppMethodBeat.i(92557);
    if (this.aTL != null)
    {
      if (this.aTL.getSurfaceTextureListener() == this.aTA) {
        this.aTL.setSurfaceTextureListener(null);
      }
      this.aTL = null;
    }
    if (this.aTK != null)
    {
      this.aTK.removeCallback(this.aTA);
      this.aTK = null;
    }
    AppMethodBeat.o(92557);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(92548);
    this.aSk.a(paramp);
    AppMethodBeat.o(92548);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(92539);
    this.aSk.a(parama);
    AppMethodBeat.o(92539);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(92542);
    this.aSk.a(parami);
    AppMethodBeat.o(92542);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92551);
    this.aSk.a(paramVarArgs);
    AppMethodBeat.o(92551);
  }
  
  public final void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(92543);
    this.aSk.aO(paramBoolean);
    AppMethodBeat.o(92543);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(92540);
    this.aSk.b(parama);
    AppMethodBeat.o(92540);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92552);
    this.aSk.b(paramVarArgs);
    AppMethodBeat.o(92552);
  }
  
  public final void c(TextureView paramTextureView)
  {
    Surface localSurface = null;
    AppMethodBeat.i(195768);
    rY();
    this.aTL = paramTextureView;
    if (paramTextureView == null) {}
    label76:
    for (;;)
    {
      a(localSurface, true);
      AppMethodBeat.o(195768);
      return;
      paramTextureView.getSurfaceTextureListener();
      paramTextureView.setSurfaceTextureListener(this.aTA);
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
    int i = this.aSk.getBufferedPercentage();
    AppMethodBeat.o(92556);
    return i;
  }
  
  public final long getBufferedPosition()
  {
    AppMethodBeat.i(92555);
    long l = this.aSk.getBufferedPosition();
    AppMethodBeat.o(92555);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(92554);
    long l = this.aSk.getCurrentPosition();
    AppMethodBeat.o(92554);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(92553);
    long l = this.aSk.getDuration();
    AppMethodBeat.o(92553);
    return l;
  }
  
  public final boolean isLoading()
  {
    AppMethodBeat.i(92546);
    boolean bool = this.aSk.isLoading();
    AppMethodBeat.o(92546);
    return bool;
  }
  
  public final int rE()
  {
    AppMethodBeat.i(92541);
    int i = this.aSk.rE();
    AppMethodBeat.o(92541);
    return i;
  }
  
  public final boolean rF()
  {
    AppMethodBeat.i(92544);
    boolean bool = this.aSk.rF();
    AppMethodBeat.o(92544);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(92550);
    this.aSk.release();
    rY();
    if (this.surface != null)
    {
      if (this.aTI) {
        this.surface.release();
      }
      this.surface = null;
    }
    AppMethodBeat.o(92550);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(92547);
    this.aSk.seekTo(paramLong);
    AppMethodBeat.o(92547);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(92545);
    this.aSk.setRepeatMode(paramInt);
    AppMethodBeat.o(92545);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(92549);
    this.aSk.stop();
    AppMethodBeat.o(92549);
  }
  
  final class a
    implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(92519);
      Iterator localIterator = v.this.aTB.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      if (v.this.aTN != null) {
        v.this.aTN.a(paramInt1, paramInt2, paramInt3, paramFloat);
      }
      AppMethodBeat.o(92519);
    }
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(92515);
      v.this.aTO = paramd;
      if (v.this.aTN != null) {
        v.this.aTN.a(paramd);
      }
      AppMethodBeat.o(92515);
    }
    
    public final void b(d paramd)
    {
      AppMethodBeat.i(92521);
      if (v.this.aTN != null) {
        v.this.aTN.b(paramd);
      }
      v.this.aTG = null;
      v.this.aTO = null;
      AppMethodBeat.o(92521);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(92529);
      Iterator localIterator = v.this.aTD.iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).b(paramMetadata);
      }
      AppMethodBeat.o(92529);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92516);
      if (v.this.aTN != null) {
        v.this.aTN.b(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92516);
    }
    
    public final void c(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92526);
      if (v.this.aTM != null) {
        v.this.aTM.c(paramInt, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92526);
    }
    
    public final void c(Surface paramSurface)
    {
      AppMethodBeat.i(92520);
      if (v.this.surface == paramSurface)
      {
        Iterator localIterator = v.this.aTB.iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
      if (v.this.aTN != null) {
        v.this.aTN.c(paramSurface);
      }
      AppMethodBeat.o(92520);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(92517);
      v.this.aTG = paramFormat;
      if (v.this.aTN != null) {
        v.this.aTN.c(paramFormat);
      }
      AppMethodBeat.o(92517);
    }
    
    public final void c(d paramd)
    {
      AppMethodBeat.i(92522);
      v.this.aTP = paramd;
      if (v.this.aTM != null) {
        v.this.aTM.c(paramd);
      }
      AppMethodBeat.o(92522);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92524);
      if (v.this.aTM != null) {
        v.this.aTM.c(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92524);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(92525);
      v.this.aTH = paramFormat;
      if (v.this.aTM != null) {
        v.this.aTM.d(paramFormat);
      }
      AppMethodBeat.o(92525);
    }
    
    public final void d(d paramd)
    {
      AppMethodBeat.i(92527);
      if (v.this.aTM != null) {
        v.this.aTM.d(paramd);
      }
      v.this.aTH = null;
      v.this.aTP = null;
      v.this.aTQ = 0;
      AppMethodBeat.o(92527);
    }
    
    public final void dH(int paramInt)
    {
      AppMethodBeat.i(92523);
      v.this.aTQ = paramInt;
      if (v.this.aTM != null) {
        v.this.aTM.dH(paramInt);
      }
      AppMethodBeat.o(92523);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(92518);
      if (v.this.aTN != null) {
        v.this.aTN.h(paramInt, paramLong);
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
      Iterator localIterator = v.this.aTC.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.v
 * JD-Core Version:    0.7.0.1
 */