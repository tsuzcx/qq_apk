package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.source.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v
  implements f
{
  private final f avX;
  protected final r[] avx;
  private TextureView axA;
  public com.google.android.exoplayer2.a.e axB;
  com.google.android.exoplayer2.video.e axC;
  d axD;
  d axE;
  int axF;
  private b axG;
  private float axH;
  private final v.a axo;
  final CopyOnWriteArraySet<Object> axp;
  final CopyOnWriteArraySet<j.a> axq;
  public final CopyOnWriteArraySet<e.a> axr;
  private final int axs;
  private final int axt;
  Format axu;
  Format axv;
  Surface axw;
  private boolean axx;
  private int axy;
  private SurfaceHolder axz;
  
  protected v(u paramu, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(95410);
    this.axo = new v.a(this, (byte)0);
    this.axp = new CopyOnWriteArraySet();
    this.axq = new CopyOnWriteArraySet();
    this.axr = new CopyOnWriteArraySet();
    Looper localLooper;
    int i;
    int k;
    int j;
    if (Looper.myLooper() != null)
    {
      localLooper = Looper.myLooper();
      this.avx = paramu.a(new Handler(localLooper), this.axo, this.axo, this.axo, this.axo);
      paramu = this.avx;
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
    this.axs = j;
    this.axt = k;
    this.axH = 1.0F;
    this.axF = 0;
    this.axG = b.ayh;
    this.axy = 1;
    this.avX = new h(this.avx, paramh, paramm);
    AppMethodBeat.o(95410);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(151939);
    this.avX.a(paramp);
    AppMethodBeat.o(151939);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(95411);
    this.avX.a(parama);
    AppMethodBeat.o(95411);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(95414);
    this.avX.a(parami);
    AppMethodBeat.o(95414);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(95422);
    this.avX.a(paramVarArgs);
    AppMethodBeat.o(95422);
  }
  
  public final void aC(boolean paramBoolean)
  {
    AppMethodBeat.i(95415);
    this.avX.aC(paramBoolean);
    AppMethodBeat.o(95415);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(95412);
    this.avX.b(parama);
    AppMethodBeat.o(95412);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(95423);
    this.avX.b(paramVarArgs);
    AppMethodBeat.o(95423);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(95427);
    int i = this.avX.getBufferedPercentage();
    AppMethodBeat.o(95427);
    return i;
  }
  
  public final long getBufferedPosition()
  {
    AppMethodBeat.i(95426);
    long l = this.avX.getBufferedPosition();
    AppMethodBeat.o(95426);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(95425);
    long l = this.avX.getCurrentPosition();
    AppMethodBeat.o(95425);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(95424);
    long l = this.avX.getDuration();
    AppMethodBeat.o(95424);
    return l;
  }
  
  public final boolean isLoading()
  {
    AppMethodBeat.i(95418);
    boolean bool = this.avX.isLoading();
    AppMethodBeat.o(95418);
    return bool;
  }
  
  public final int mJ()
  {
    AppMethodBeat.i(95413);
    int i = this.avX.mJ();
    AppMethodBeat.o(95413);
    return i;
  }
  
  public final boolean mK()
  {
    AppMethodBeat.i(95416);
    boolean bool = this.avX.mK();
    AppMethodBeat.o(95416);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(95421);
    this.avX.release();
    if (this.axA != null)
    {
      if (this.axA.getSurfaceTextureListener() == this.axo) {
        this.axA.setSurfaceTextureListener(null);
      }
      this.axA = null;
    }
    if (this.axz != null)
    {
      this.axz.removeCallback(this.axo);
      this.axz = null;
    }
    if (this.axw != null)
    {
      if (this.axx) {
        this.axw.release();
      }
      this.axw = null;
    }
    AppMethodBeat.o(95421);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(95419);
    this.avX.seekTo(paramLong);
    AppMethodBeat.o(95419);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(95417);
    this.avX.setRepeatMode(paramInt);
    AppMethodBeat.o(95417);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(95420);
    this.avX.stop();
    AppMethodBeat.o(95420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.v
 * JD-Core Version:    0.7.0.1
 */