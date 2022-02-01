package com.google.android.exoplayer2;

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
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class v
  implements f
{
  private final f cFZ;
  protected final r[] cFy;
  public com.google.android.exoplayer2.a.e cHA;
  private com.google.android.exoplayer2.video.e cHB;
  private d cHC;
  private d cHD;
  private int cHE;
  private b cHF;
  public float cHG;
  public final a cHo;
  private final CopyOnWriteArraySet<Object> cHp;
  private final CopyOnWriteArraySet<j.a> cHq;
  public final CopyOnWriteArraySet<e.a> cHr;
  private final int cHs;
  private final int cHt;
  private Format cHu;
  private Format cHv;
  private boolean cHw;
  private int cHx;
  private SurfaceHolder cHy;
  public TextureView cHz;
  private Surface surface;
  
  protected v(u paramu, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(92534);
    this.cHo = new a((byte)0);
    this.cHp = new CopyOnWriteArraySet();
    this.cHq = new CopyOnWriteArraySet();
    this.cHr = new CopyOnWriteArraySet();
    Looper localLooper;
    int i;
    int k;
    int j;
    if (Looper.myLooper() != null)
    {
      localLooper = Looper.myLooper();
      this.cFy = paramu.a(new Handler(localLooper), this.cHo, this.cHo, this.cHo, this.cHo);
      paramu = this.cFy;
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
    this.cHs = j;
    this.cHt = k;
    this.cHG = 1.0F;
    this.cHE = 0;
    this.cHF = b.cIg;
    this.cHx = 1;
    this.cFZ = new h(this.cFy, paramh, paramm);
    AppMethodBeat.o(92534);
  }
  
  public final void J(int paramInt)
  {
    AppMethodBeat.i(92545);
    this.cFZ.J(paramInt);
    AppMethodBeat.o(92545);
  }
  
  public final int QC()
  {
    AppMethodBeat.i(92541);
    int i = this.cFZ.QC();
    AppMethodBeat.o(92541);
    return i;
  }
  
  public final boolean QD()
  {
    AppMethodBeat.i(92544);
    boolean bool = this.cFZ.QD();
    AppMethodBeat.o(92544);
    return bool;
  }
  
  public final long QF()
  {
    AppMethodBeat.i(92555);
    long l = this.cFZ.QF();
    AppMethodBeat.o(92555);
    return l;
  }
  
  public final void QV()
  {
    AppMethodBeat.i(92557);
    if (this.cHz != null)
    {
      if (this.cHz.getSurfaceTextureListener() == this.cHo) {
        this.cHz.setSurfaceTextureListener(null);
      }
      this.cHz = null;
    }
    if (this.cHy != null)
    {
      this.cHy.removeCallback(this.cHo);
      this.cHy = null;
    }
    AppMethodBeat.o(92557);
  }
  
  public final void a(Surface paramSurface, boolean paramBoolean)
  {
    AppMethodBeat.i(92558);
    f.c[] arrayOfc = new f.c[this.cHs];
    r[] arrayOfr = this.cFy;
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
        this.cFZ.b(arrayOfc);
        if (this.cHw) {
          this.surface.release();
        }
      }
      for (;;)
      {
        this.surface = paramSurface;
        this.cHw = paramBoolean;
        AppMethodBeat.o(92558);
        return;
        this.cFZ.a(arrayOfc);
      }
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(92548);
    this.cFZ.a(paramp);
    AppMethodBeat.o(92548);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(92539);
    this.cFZ.a(parama);
    AppMethodBeat.o(92539);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(92542);
    this.cFZ.a(paramk);
    AppMethodBeat.o(92542);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92551);
    this.cFZ.a(paramVarArgs);
    AppMethodBeat.o(92551);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(92540);
    this.cFZ.b(parama);
    AppMethodBeat.o(92540);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(92552);
    this.cFZ.b(paramVarArgs);
    AppMethodBeat.o(92552);
  }
  
  public final void bv(boolean paramBoolean)
  {
    AppMethodBeat.i(92543);
    this.cFZ.bv(paramBoolean);
    AppMethodBeat.o(92543);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(92556);
    int i = this.cFZ.getBufferedPercentage();
    AppMethodBeat.o(92556);
    return i;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(92554);
    long l = this.cFZ.getCurrentPosition();
    AppMethodBeat.o(92554);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(92553);
    long l = this.cFZ.getDuration();
    AppMethodBeat.o(92553);
    return l;
  }
  
  public final boolean isLoading()
  {
    AppMethodBeat.i(92546);
    boolean bool = this.cFZ.isLoading();
    AppMethodBeat.o(92546);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(92550);
    this.cFZ.release();
    QV();
    if (this.surface != null)
    {
      if (this.cHw) {
        this.surface.release();
      }
      this.surface = null;
    }
    AppMethodBeat.o(92550);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(92547);
    this.cFZ.seekTo(paramLong);
    AppMethodBeat.o(92547);
  }
  
  @Deprecated
  public final void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(210231);
    int i = x.iN(paramInt);
    paramInt = x.iO(paramInt);
    Object localObject = new b.a();
    ((b.a)localObject).cIi = i;
    ((b.a)localObject).cIh = paramInt;
    localObject = ((b.a)localObject).Ra();
    this.cHF = ((b)localObject);
    f.c[] arrayOfc = new f.c[this.cHt];
    r[] arrayOfr = this.cFy;
    int k = arrayOfr.length;
    i = 0;
    paramInt = 0;
    if (i < k)
    {
      r localr = arrayOfr[i];
      if (localr.getTrackType() != 1) {
        break label144;
      }
      int j = paramInt + 1;
      arrayOfc[paramInt] = new f.c(localr, 3, localObject);
      paramInt = j;
    }
    label144:
    for (;;)
    {
      i += 1;
      break;
      this.cFZ.a(arrayOfc);
      AppMethodBeat.o(210231);
      return;
    }
  }
  
  public final void setVolume(float paramFloat)
  {
    AppMethodBeat.i(92538);
    this.cHG = paramFloat;
    f.c[] arrayOfc = new f.c[this.cHt];
    r[] arrayOfr = this.cFy;
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
      this.cFZ.a(arrayOfc);
      AppMethodBeat.o(92538);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(92549);
    this.cFZ.stop();
    AppMethodBeat.o(92549);
  }
  
  final class a
    implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.google.android.exoplayer2.a.e, j.a, e.a, com.google.android.exoplayer2.video.e
  {
    private a() {}
    
    public final void a(d paramd)
    {
      AppMethodBeat.i(92515);
      v.a(v.this, paramd);
      if (v.a(v.this) != null) {
        v.a(v.this).a(paramd);
      }
      AppMethodBeat.o(92515);
    }
    
    public final void ag(List<a> paramList)
    {
      AppMethodBeat.i(92528);
      Iterator localIterator = v.e(v.this).iterator();
      while (localIterator.hasNext()) {
        ((j.a)localIterator.next()).ag(paramList);
      }
      AppMethodBeat.o(92528);
    }
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      AppMethodBeat.i(92519);
      Iterator localIterator = v.b(v.this).iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      if (v.a(v.this) != null) {
        v.a(v.this).b(paramInt1, paramInt2, paramInt3, paramFloat);
      }
      AppMethodBeat.o(92519);
    }
    
    public final void b(d paramd)
    {
      AppMethodBeat.i(92521);
      if (v.a(v.this) != null) {
        v.a(v.this).b(paramd);
      }
      v.a(v.this, null);
      v.a(v.this, null);
      AppMethodBeat.o(92521);
    }
    
    public final void b(Metadata paramMetadata)
    {
      AppMethodBeat.i(92529);
      Iterator localIterator = v.f(v.this).iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).b(paramMetadata);
      }
      AppMethodBeat.o(92529);
    }
    
    public final void b(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92516);
      if (v.a(v.this) != null) {
        v.a(v.this).b(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92516);
    }
    
    public final void c(Format paramFormat)
    {
      AppMethodBeat.i(92517);
      v.a(v.this, paramFormat);
      if (v.a(v.this) != null) {
        v.a(v.this).c(paramFormat);
      }
      AppMethodBeat.o(92517);
    }
    
    public final void c(d paramd)
    {
      AppMethodBeat.i(92522);
      v.b(v.this, paramd);
      if (v.d(v.this) != null) {
        v.d(v.this).c(paramd);
      }
      AppMethodBeat.o(92522);
    }
    
    public final void c(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92524);
      if (v.d(v.this) != null) {
        v.d(v.this).c(paramString, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92524);
    }
    
    public final void d(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92526);
      if (v.d(v.this) != null) {
        v.d(v.this).d(paramInt, paramLong1, paramLong2);
      }
      AppMethodBeat.o(92526);
    }
    
    public final void d(Format paramFormat)
    {
      AppMethodBeat.i(92525);
      v.b(v.this, paramFormat);
      if (v.d(v.this) != null) {
        v.d(v.this).d(paramFormat);
      }
      AppMethodBeat.o(92525);
    }
    
    public final void d(d paramd)
    {
      AppMethodBeat.i(92527);
      if (v.d(v.this) != null) {
        v.d(v.this).d(paramd);
      }
      v.b(v.this, null);
      v.b(v.this, null);
      v.a(v.this, 0);
      AppMethodBeat.o(92527);
    }
    
    public final void f(Surface paramSurface)
    {
      AppMethodBeat.i(92520);
      if (v.c(v.this) == paramSurface)
      {
        Iterator localIterator = v.b(v.this).iterator();
        while (localIterator.hasNext()) {
          localIterator.next();
        }
      }
      if (v.a(v.this) != null) {
        v.a(v.this).f(paramSurface);
      }
      AppMethodBeat.o(92520);
    }
    
    public final void h(int paramInt, long paramLong)
    {
      AppMethodBeat.i(92518);
      if (v.a(v.this) != null) {
        v.a(v.this).h(paramInt, paramLong);
      }
      AppMethodBeat.o(92518);
    }
    
    public final void hl(int paramInt)
    {
      AppMethodBeat.i(92523);
      v.a(v.this, paramInt);
      if (v.d(v.this) != null) {
        v.d(v.this).hl(paramInt);
      }
      AppMethodBeat.o(92523);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.v
 * JD-Core Version:    0.7.0.1
 */