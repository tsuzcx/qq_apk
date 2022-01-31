package com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.g.a.a;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.l;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.e.a;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.a.2;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  extends com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
{
  f bID;
  private boolean bIE;
  private b.e bIF;
  private i bIG;
  List<r> bIH;
  f.a bII;
  private b.b bIJ;
  private e bIK;
  int bIL;
  private boolean bIM;
  private boolean bIN;
  private final AtomicBoolean bIO;
  volatile boolean bIe;
  private HandlerThread mHandlerThread;
  private Handler mMainHandler;
  private Surface mSurface;
  int mVideoHeight;
  int mVideoWidth;
  Context zF;
  
  public b()
  {
    AppMethodBeat.i(139970);
    this.bIO = new AtomicBoolean();
    this.zF = ah.getContext();
    this.mHandlerThread = new HandlerThread("ExoMediaPlayer_HandlerThread");
    this.mHandlerThread.start();
    this.mMainHandler = new Handler(this.mHandlerThread.getLooper());
    this.bIF = new b.e((byte)0);
    this.bII = new b.c(this, (byte)0);
    this.bIJ = new b.b(this, (byte)0);
    this.bIK = new e(this.mMainHandler);
    this.bIK.bIU = 1000;
    this.bIK.bIW = new b.a(this, (byte)0);
    Object localObject1 = new b.d(this, (byte)0);
    this.bIH = new a(this.zF, this.mMainHandler, (j.a)localObject1, (e.a)localObject1, (com.google.android.exoplayer2.a.e)localObject1, (com.google.android.exoplayer2.video.e)localObject1).yc();
    this.mMainHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139935);
        synchronized (b.this)
        {
          b localb2 = b.this;
          com.google.android.exoplayer2.g.c localc = new com.google.android.exoplayer2.g.c(new a.a(new l()));
          com.google.android.exoplayer2.c localc1 = new com.google.android.exoplayer2.c();
          localb2.bID = new com.google.android.exoplayer2.h((r[])localb2.bIH.toArray(new r[localb2.bIH.size()]), localc, localc1);
          localb2.bID.a(localb2.bII);
          b.this.notifyAll();
          AppMethodBeat.o(139935);
          return;
        }
      }
    });
    try
    {
      for (;;)
      {
        localObject1 = this.bID;
        if (localObject1 != null) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
    finally
    {
      AppMethodBeat.o(139970);
    }
    AppMethodBeat.o(139970);
  }
  
  private void T(Object paramObject)
  {
    AppMethodBeat.i(139989);
    a(1, 2, paramObject, false);
    AppMethodBeat.o(139989);
  }
  
  private void Z(float paramFloat)
  {
    AppMethodBeat.i(139976);
    T(Float.valueOf(paramFloat));
    AppMethodBeat.o(139976);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(139990);
    if (this.bIH.isEmpty())
    {
      AppMethodBeat.o(139990);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.bIH.iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      if (localr.getTrackType() == paramInt1) {
        localArrayList.add(new f.c(localr, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.bID.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      AppMethodBeat.o(139990);
      return;
    }
    this.bID.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
    AppMethodBeat.o(139990);
  }
  
  private void bh(boolean paramBoolean)
  {
    AppMethodBeat.i(139987);
    ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "setBufferRepeaterStarted ".concat(String.valueOf(paramBoolean)));
    if ((paramBoolean) && (this.bIk != null))
    {
      this.bIK.start();
      AppMethodBeat.o(139987);
      return;
    }
    this.bIK.bIT = false;
    AppMethodBeat.o(139987);
  }
  
  public final boolean Y(float paramFloat)
  {
    AppMethodBeat.i(139974);
    if (yb())
    {
      p localp = new p(paramFloat, paramFloat);
      this.bID.a(localp);
      AppMethodBeat.o(139974);
      return true;
    }
    AppMethodBeat.o(139974);
    return false;
  }
  
  final int getBufferedPercentage()
  {
    AppMethodBeat.i(139986);
    if (yb())
    {
      int i = this.bID.getBufferedPercentage();
      AppMethodBeat.o(139986);
      return i;
    }
    AppMethodBeat.o(139986);
    return 0;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(139978);
    if (yb())
    {
      int i = (int)this.bID.getCurrentPosition();
      AppMethodBeat.o(139978);
      return i;
    }
    AppMethodBeat.o(139978);
    return 0;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(139977);
    if (yb())
    {
      int i = (int)this.bID.getDuration();
      AppMethodBeat.o(139977);
      return i;
    }
    AppMethodBeat.o(139977);
    return 0;
  }
  
  public final int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public final int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(139971);
    if (yb())
    {
      switch (this.bID.mJ())
      {
      }
      do
      {
        AppMethodBeat.o(139971);
        return false;
        boolean bool = this.bID.mK();
        AppMethodBeat.o(139971);
        return bool;
      } while (!this.bIM);
      AppMethodBeat.o(139971);
      return true;
    }
    AppMethodBeat.o(139971);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(139981);
    if (yb())
    {
      this.bID.aC(false);
      this.mCurrentState = 3;
    }
    AppMethodBeat.o(139981);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(139979);
    if (this.bIG == null)
    {
      ab.w("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      AppMethodBeat.o(139979);
      return;
    }
    if (yb())
    {
      this.bID.aC(false);
      this.bID.a(this.bIG);
    }
    AppMethodBeat.o(139979);
  }
  
  public final void release()
  {
    AppMethodBeat.i(139985);
    this.bIe = true;
    if (yb())
    {
      bh(false);
      if (yb())
      {
        this.bID.release();
        this.bID.b(this.bII);
        this.bID = null;
      }
      this.mVideoWidth = 0;
      this.mVideoHeight = 0;
      this.bIL = 0;
    }
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.mSurface != null)
    {
      if (this.bIE) {
        this.mSurface.release();
      }
      this.mSurface = null;
    }
    this.bIf = null;
    this.bIg = null;
    this.bIh = null;
    this.bIi = null;
    this.bIj = null;
    this.bIk = null;
    this.bIl = null;
    this.mCurrentState = -2;
    super.release();
    AppMethodBeat.o(139985);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(139984);
    if (yb())
    {
      bh(false);
      if (yb())
      {
        this.bID.aC(false);
        this.bID.stop();
      }
      this.bIM = false;
      this.bIL = 0;
      this.bIF.bIR = new int[] { 1, 1, 1, 1 };
      this.mCurrentState = 0;
    }
    AppMethodBeat.o(139984);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(139982);
    b.e locale;
    if (yb())
    {
      this.bID.seekTo(paramLong);
      locale = this.bIF;
      if ((this.bIF.bIR[3] & 0xF0000000) == 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      locale.d(bool, 100);
      AppMethodBeat.o(139982);
      return;
    }
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(139972);
    paramString = Uri.parse(paramString);
    int i = x.g(paramString);
    g.a locala = c.ax(this.zF);
    switch (i)
    {
    default: 
      ab.e("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, unsupported type:".concat(String.valueOf(i)));
      paramString = null;
    }
    for (;;)
    {
      this.bIG = paramString;
      this.mCurrentState = 1;
      AppMethodBeat.o(139972);
      return;
      ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS");
      paramString = new com.google.android.exoplayer2.source.b.h(paramString, locala, this.mMainHandler, this.bIJ);
      continue;
      ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other");
      paramString = new g(paramString, new a.2(com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.a.xO()), new com.google.android.exoplayer2.c.c(), this.mMainHandler, this.bIJ);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(139975);
    if (yb())
    {
      if (paramBoolean)
      {
        Z(0.0F);
        AppMethodBeat.o(139975);
        return;
      }
      Z(1.0F);
    }
    AppMethodBeat.o(139975);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(139973);
    if ((yb()) && (yb()))
    {
      if ((this.mSurface == null) || (this.mSurface == paramSurface) || (paramSurface == null)) {
        break label116;
      }
      if (this.bIE) {
        this.mSurface.release();
      }
      a(2, 1, paramSurface, true);
      long l = this.bID.getCurrentPosition();
      if (x.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new b.2(this, l), 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.bIE = false;
      AppMethodBeat.o(139973);
      return;
      label116:
      a(2, 1, paramSurface, false);
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(139980);
    if (yb())
    {
      this.bID.aC(true);
      this.mCurrentState = 3;
    }
    AppMethodBeat.o(139980);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(139983);
    if ((yb()) && (!this.bIO.getAndSet(true)))
    {
      this.bID.aC(false);
      this.bID.stop();
      this.mCurrentState = 5;
    }
    AppMethodBeat.o(139983);
  }
  
  final boolean yb()
  {
    return this.bID != null;
  }
  
  final void yd()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(139988);
        if ((this.bID == null) || (this.bIe))
        {
          AppMethodBeat.o(139988);
          return;
        }
        int i = this.bID.mJ();
        boolean bool = this.bID.mK();
        j = b.e.e(bool, i);
        if (j == this.bIF.bIR[3]) {
          break label478;
        }
        ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, set new recent state [" + bool + "," + i + "]");
        this.bIF.d(bool, i);
        if (j == 3)
        {
          bh(true);
          if (j != b.e.e(true, 4)) {
            break label214;
          }
          if (!this.bIM) {
            break label195;
          }
          ab.i("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
          this.bIN = true;
          seekTo(0L);
          AppMethodBeat.o(139988);
          continue;
        }
        if (j == 1) {
          break label187;
        }
      }
      finally {}
      if (j == 4)
      {
        label187:
        bh(false);
        continue;
        label195:
        this.mCurrentState = 6;
        xX();
        AppMethodBeat.o(139988);
        continue;
        label214:
        if (this.bIF.b(new int[] { b.e.e(false, 1), b.e.e(false, 2), b.e.e(false, 3) }, false))
        {
          this.mCurrentState = 2;
          xW();
          AppMethodBeat.o(139988);
        }
        else if ((this.bIF.b(new int[] { 100, 2, 3 }, true) | this.bIF.b(new int[] { 2, 100, 3 }, true) | this.bIF.b(new int[] { 100, 3, 2, 3 }, true)))
        {
          if (!this.bIN)
          {
            xY();
            AppMethodBeat.o(139988);
          }
          else
          {
            this.bIN = false;
            AppMethodBeat.o(139988);
          }
        }
        else if (this.bIF.b(new int[] { b.e.e(true, 3), b.e.e(true, 2) }, false))
        {
          bO(701, getBufferedPercentage());
          AppMethodBeat.o(139988);
        }
        else
        {
          if (this.bIF.b(new int[] { b.e.e(true, 2), b.e.e(true, 3) }, false)) {
            bO(702, getBufferedPercentage());
          }
          label478:
          AppMethodBeat.o(139988);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.b
 * JD-Core Version:    0.7.0.1
 */