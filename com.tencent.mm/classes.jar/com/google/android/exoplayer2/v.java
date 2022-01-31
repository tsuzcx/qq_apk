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
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.metadata.e.a;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v
  implements f
{
  private final f atF;
  protected final r[] atf;
  private final v.a auX = new v.a(this, (byte)0);
  final CopyOnWriteArraySet<Object> auY = new CopyOnWriteArraySet();
  final CopyOnWriteArraySet<j.a> auZ = new CopyOnWriteArraySet();
  public final CopyOnWriteArraySet<e.a> ava = new CopyOnWriteArraySet();
  private final int avb;
  private final int avc;
  Format avd;
  Format ave;
  Surface avf;
  private boolean avh;
  private int avi;
  private SurfaceHolder avj;
  private TextureView avk;
  public com.google.android.exoplayer2.a.e avl;
  com.google.android.exoplayer2.video.e avm;
  d avn;
  d avo;
  int avp;
  private b avq;
  private float avr;
  
  protected v(u paramu, g paramg, m paramm)
  {
    Looper localLooper;
    int i;
    int k;
    int j;
    if (Looper.myLooper() != null)
    {
      localLooper = Looper.myLooper();
      this.atf = paramu.a(new Handler(localLooper), this.auX, this.auX, this.auX, this.auX);
      paramu = this.atf;
      int m = paramu.length;
      i = 0;
      k = 0;
      j = 0;
      label114:
      if (i >= m) {
        break label187;
      }
      switch (paramu[i].getTrackType())
      {
      }
    }
    for (;;)
    {
      i += 1;
      break label114;
      localLooper = Looper.getMainLooper();
      break;
      j += 1;
      continue;
      k += 1;
    }
    label187:
    this.avb = j;
    this.avc = k;
    this.avr = 1.0F;
    this.avp = 0;
    this.avq = b.avR;
    this.avi = 1;
    this.atF = new h(this.atf, paramg, paramm);
  }
  
  public final void a(q.a parama)
  {
    this.atF.a(parama);
  }
  
  public final void a(com.google.android.exoplayer2.source.f paramf)
  {
    this.atF.a(paramf);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    this.atF.a(paramVarArgs);
  }
  
  public final void at(boolean paramBoolean)
  {
    this.atF.at(paramBoolean);
  }
  
  public final void b(q.a parama)
  {
    this.atF.b(parama);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    this.atF.b(paramVarArgs);
  }
  
  public final int getBufferedPercentage()
  {
    return this.atF.getBufferedPercentage();
  }
  
  public final long getBufferedPosition()
  {
    return this.atF.getBufferedPosition();
  }
  
  public final long getCurrentPosition()
  {
    return this.atF.getCurrentPosition();
  }
  
  public final long getDuration()
  {
    return this.atF.getDuration();
  }
  
  public final boolean isLoading()
  {
    return this.atF.isLoading();
  }
  
  public final int kD()
  {
    return this.atF.kD();
  }
  
  public final boolean kE()
  {
    return this.atF.kE();
  }
  
  public final void release()
  {
    this.atF.release();
    if (this.avk != null)
    {
      if (this.avk.getSurfaceTextureListener() == this.auX) {
        this.avk.setSurfaceTextureListener(null);
      }
      this.avk = null;
    }
    if (this.avj != null)
    {
      this.avj.removeCallback(this.auX);
      this.avj = null;
    }
    if (this.avf != null)
    {
      if (this.avh) {
        this.avf.release();
      }
      this.avf = null;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    this.atF.seekTo(paramLong);
  }
  
  public final void stop()
  {
    this.atF.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.v
 * JD-Core Version:    0.7.0.1
 */