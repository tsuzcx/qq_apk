package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.renderer.i;

public class h
  extends com.tencent.liteav.basic.module.a
  implements com.tencent.liteav.audio.d, com.tencent.liteav.basic.b.b, com.tencent.liteav.basic.c.a, i, com.tencent.liteav.videodecoder.d
{
  private Context a = null;
  private g b = null;
  private com.tencent.liteav.videodecoder.b c = null;
  private com.tencent.liteav.renderer.h d = null;
  private com.tencent.liteav.basic.b.a e = null;
  private com.tencent.liteav.audio.b f = null;
  private com.tencent.liteav.basic.c.a g = null;
  private boolean h = false;
  private int i = 0;
  private long j = 0L;
  private byte[] k = null;
  private o l = null;
  private int m;
  private boolean n = false;
  private String o;
  private final float p = com.tencent.liteav.basic.a.a.o;
  private final float q = com.tencent.liteav.basic.a.a.p;
  private final float r = com.tencent.liteav.basic.a.a.q;
  private final float s = 0.3F;
  private boolean t = false;
  private h.a u = null;
  
  public h(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.m = paramInt;
    com.tencent.liteav.basic.e.b.a().a(this.a);
  }
  
  private void a(int paramInt, String paramString)
  {
    com.tencent.liteav.basic.c.a locala = this.g;
    if (locala != null)
    {
      Bundle localBundle = new Bundle();
      new StringBuilder("TXCRenderAndDec notifyEvent: mUserID  ").append(this.j);
      localBundle.putLong("EVT_USERID", this.j);
      localBundle.putInt("EVT_ID", paramInt);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString != null) {
        localBundle.putCharSequence("EVT_MSG", paramString);
      }
      locala.onNotifyEvent(paramInt, localBundle);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    com.tencent.liteav.audio.b.a(paramContext, paramInt);
  }
  
  private void c(SurfaceTexture paramSurfaceTexture)
  {
    com.tencent.liteav.videodecoder.b localb = this.c;
    if (localb != null)
    {
      localb.a(this.b.i);
      if (paramSurfaceTexture != null) {
        if (this.h) {
          break label48;
        }
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramSurfaceTexture, null, null, bool);
      localb.b();
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    float f2;
    float f1;
    if (paramBoolean)
    {
      f2 = this.b.c;
      float f3 = this.b.b;
      f1 = f2;
      if (f2 > this.q) {
        f1 = this.q;
      }
      f2 = f3;
      if (f3 > this.r) {
        f2 = this.r;
      }
      if (f1 < f2) {
        break label320;
      }
      f1 = this.q;
      f2 = this.r;
    }
    label305:
    label320:
    for (;;)
    {
      this.b.g = true;
      this.b.a = f1;
      this.b.c = f1;
      this.b.b = f2;
      if (this.f != null)
      {
        this.f.a(true, this.a);
        this.f.c(true);
      }
      if (this.e != null) {
        this.e.b(paramBoolean);
      }
      return;
      TXCLog.e("TXCRenderAndDec", "setupRealTimePlayParams current cache time : min-cache[" + this.b.c + "], max-cache[" + this.b.b + "], org-cache[" + this.b.a + "]");
      if (this.f != null)
      {
        if ((this.b == null) || (!this.b.h)) {
          break label305;
        }
        this.f.a(true, this.a);
      }
      for (;;)
      {
        this.f.c(false);
        if ((this.b.a <= this.b.b) && (this.b.a >= this.b.c)) {
          break;
        }
        this.b.a = this.b.b;
        break;
        this.f.a(false, this.a);
      }
    }
  }
  
  private void p()
  {
    if (this.d != null) {}
    for (SurfaceTexture localSurfaceTexture = this.d.a();; localSurfaceTexture = null)
    {
      c(localSurfaceTexture);
      return;
    }
  }
  
  private void q()
  {
    c(this.h);
    if (this.f != null)
    {
      this.f.a(this.b.a);
      this.f.a(this.b.g);
      this.f.c(this.b.c);
      this.f.b(this.b.b);
      setStatusValue(2012, Long.valueOf((this.b.c * 1000.0F)));
      setStatusValue(2013, Long.valueOf((this.b.b * 1000.0F)));
      setStatusValue(2015, Long.valueOf(0L));
    }
    if (this.e != null) {
      this.e.a(this.b.c);
    }
    if ((this.c != null) && (this.c.a()) && (this.b.c < 0.3F) && (this.b.b < 0.3F))
    {
      this.b.i = false;
      this.c.c();
      p();
    }
    if (this.d != null) {
      this.d.a(this.b.d);
    }
  }
  
  private void r()
  {
    com.tencent.liteav.videodecoder.b localb = this.c;
    if (localb != null)
    {
      TXCLog.w("TXCRenderAndDec", "switch to soft decoder when hw error");
      localb.c();
      this.b.i = false;
      c(this.h);
      p();
    }
  }
  
  public void a()
  {
    this.h = false;
    this.i = 0;
    if (this.c != null)
    {
      this.c.a(null);
      this.c.a(null);
      this.c.c();
    }
    if (this.f != null)
    {
      this.f.a(null);
      this.f.a();
    }
    if (this.e != null)
    {
      this.e.a(null);
      this.e.b();
    }
    if (this.d != null)
    {
      this.d.h();
      this.d.a(null);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.d != null) {
      this.d.b(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.d != null) {
      this.d.b(paramInt1, paramInt2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("EVT_MSG", "分辨率改变");
    localBundle.putInt("EVT_PARAM1", paramInt1);
    localBundle.putInt("EVT_PARAM2", paramInt2);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    onNotifyEvent(2009, localBundle);
  }
  
  /* Error */
  public void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 10
    //   6: iload 11
    //   8: istore 9
    //   10: aload_0
    //   11: getfield 81	com/tencent/liteav/h:l	Lcom/tencent/liteav/o;
    //   14: ifnull +107 -> 121
    //   17: iload 11
    //   19: istore 9
    //   21: aload_0
    //   22: getfield 79	com/tencent/liteav/h:k	[B
    //   25: ifnull +96 -> 121
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 79	com/tencent/liteav/h:k	[B
    //   34: astore 12
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 79	com/tencent/liteav/h:k	[B
    //   41: iload 10
    //   43: istore 9
    //   45: aload_0
    //   46: getfield 81	com/tencent/liteav/h:l	Lcom/tencent/liteav/o;
    //   49: ifnull +70 -> 119
    //   52: iload 10
    //   54: istore 9
    //   56: aload 12
    //   58: ifnull +61 -> 119
    //   61: iload 10
    //   63: istore 9
    //   65: aload_0
    //   66: getfield 63	com/tencent/liteav/h:c	Lcom/tencent/liteav/videodecoder/b;
    //   69: ifnull +50 -> 119
    //   72: aload 12
    //   74: arraylength
    //   75: iload_3
    //   76: iload 4
    //   78: imul
    //   79: iconst_3
    //   80: imul
    //   81: iconst_2
    //   82: idiv
    //   83: if_icmpgt +84 -> 167
    //   86: aload_0
    //   87: getfield 63	com/tencent/liteav/h:c	Lcom/tencent/liteav/videodecoder/b;
    //   90: aload 12
    //   92: lload_1
    //   93: aload 12
    //   95: arraylength
    //   96: invokevirtual 303	com/tencent/liteav/videodecoder/b:a	([BJI)V
    //   99: aload_0
    //   100: getfield 81	com/tencent/liteav/h:l	Lcom/tencent/liteav/o;
    //   103: aload 12
    //   105: iload_3
    //   106: iload 4
    //   108: lload 5
    //   110: l2i
    //   111: invokeinterface 309 5 0
    //   116: iconst_1
    //   117: istore 9
    //   119: aload_0
    //   120: monitorexit
    //   121: iload 9
    //   123: ifne +43 -> 166
    //   126: lload_1
    //   127: lconst_0
    //   128: lcmp
    //   129: ifle +21 -> 150
    //   132: aload_0
    //   133: getfield 65	com/tencent/liteav/h:d	Lcom/tencent/liteav/renderer/h;
    //   136: ifnull +14 -> 150
    //   139: aload_0
    //   140: getfield 65	com/tencent/liteav/h:d	Lcom/tencent/liteav/renderer/h;
    //   143: lload_1
    //   144: iload_3
    //   145: iload 4
    //   147: invokevirtual 312	com/tencent/liteav/renderer/h:a	(JII)V
    //   150: aload_0
    //   151: getfield 67	com/tencent/liteav/h:e	Lcom/tencent/liteav/basic/b/a;
    //   154: ifnull +12 -> 166
    //   157: aload_0
    //   158: getfield 67	com/tencent/liteav/h:e	Lcom/tencent/liteav/basic/b/a;
    //   161: lload 5
    //   163: invokevirtual 315	com/tencent/liteav/basic/b/a:a	(J)V
    //   166: return
    //   167: ldc 197
    //   169: ldc_w 317
    //   172: invokestatic 220	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iload 10
    //   177: istore 9
    //   179: goto -60 -> 119
    //   182: astore 12
    //   184: aload_0
    //   185: monitorexit
    //   186: aload 12
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	h
    //   0	189	1	paramLong1	long
    //   0	189	3	paramInt1	int
    //   0	189	4	paramInt2	int
    //   0	189	5	paramLong2	long
    //   0	189	7	paramLong3	long
    //   8	170	9	i1	int
    //   4	172	10	i2	int
    //   1	17	11	i3	int
    //   34	70	12	arrayOfByte	byte[]
    //   182	5	12	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   30	41	182	finally
    //   45	52	182	finally
    //   65	116	182	finally
    //   119	121	182	finally
    //   167	175	182	finally
    //   184	186	182	finally
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    c(paramSurfaceTexture);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.d != null)
    {
      this.d.a(paramSurfaceTexture, paramInt1, paramInt2);
      if (this.u != null) {
        this.u.a(paramLong1);
      }
      if (this.e != null) {
        this.e.a(paramLong1);
      }
    }
  }
  
  public void a(Surface paramSurface)
  {
    com.tencent.liteav.videodecoder.b localb;
    if (this.c != null)
    {
      localb = this.c;
      if (this.h) {
        break label58;
      }
    }
    label58:
    for (boolean bool = true;; bool = false)
    {
      localb.a(paramSurface, null, null, bool);
      this.c.c();
      if (paramSurface != null)
      {
        this.c.a(true);
        this.c.b();
      }
      return;
    }
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    this.g = parama;
  }
  
  public void a(com.tencent.liteav.basic.f.a parama)
  {
    if (this.f != null)
    {
      this.f.a(parama);
      return;
    }
    TXCLog.w("TXCRenderAndDec", "decAudio fail which audio play hasn't been created!");
  }
  
  public void a(com.tencent.liteav.basic.f.b paramb)
  {
    try
    {
      if (this.e != null) {
        this.e.a(paramb);
      }
      return;
    }
    catch (Exception paramb) {}
  }
  
  public void a(g paramg)
  {
    this.b = paramg;
    q();
  }
  
  public void a(h.a parama)
  {
    this.u = parama;
  }
  
  public void a(o paramo)
  {
    try
    {
      this.l = paramo;
      return;
    }
    finally {}
  }
  
  public void a(com.tencent.liteav.renderer.h paramh)
  {
    this.d = paramh;
    if ((this.d != null) && (this.g != null)) {
      this.d.a(this);
    }
    if ((this.d != null) && (this.b != null)) {
      this.d.a(this.b.d);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.n = true;
    if (this.d != null)
    {
      this.d.a(this);
      this.d.g();
      this.d.setID(getID());
    }
    this.c = new com.tencent.liteav.videodecoder.b();
    this.c.a(this.j);
    this.c.a(this);
    this.c.a(this);
    this.f = new com.tencent.liteav.audio.b();
    this.f.a(this);
    c(this.h);
    this.f.a(this.i);
    this.f.a(this.a);
    this.e = new com.tencent.liteav.basic.b.a();
    this.e.a(this);
    this.e.a();
    p();
    q();
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      this.k = paramArrayOfByte;
      return true;
    }
    finally {}
  }
  
  public long b()
  {
    if (this.f != null) {
      return this.f.b();
    }
    return 0L;
  }
  
  public void b(int paramInt)
  {
    if (this.d != null) {
      this.d.c(paramInt);
    }
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
      if (this.c != null) {
        this.c.c();
      }
      if (this.u != null) {
        this.u.a(paramSurfaceTexture);
      }
      return;
    }
    catch (Exception paramSurfaceTexture) {}
  }
  
  public void b(com.tencent.liteav.basic.f.b paramb)
  {
    try
    {
      if (this.c != null)
      {
        this.c.a(paramb);
        return;
      }
      if (this.e != null)
      {
        this.e.a(paramb.g);
        return;
      }
    }
    catch (Exception paramb) {}
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.f != null) {
      this.f.d(paramBoolean);
    }
  }
  
  public long c()
  {
    if (this.e != null) {
      return this.e.d();
    }
    return 0L;
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
    if (this.f != null) {
      this.f.a(this.i);
    }
  }
  
  public void c(com.tencent.liteav.basic.f.b paramb)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("EVT_GET_MSG", paramb.a);
    onNotifyEvent(2012, localBundle);
  }
  
  public long d()
  {
    if (this.e != null) {
      return this.e.e();
    }
    return 0L;
  }
  
  public int e()
  {
    if (this.c != null) {
      return this.c.d();
    }
    return 0;
  }
  
  public long f()
  {
    if ((this.e != null) && (this.f != null)) {
      return this.f.c() - this.e.f();
    }
    return 0L;
  }
  
  public int g()
  {
    if (this.f != null) {
      return this.f.d();
    }
    return 0;
  }
  
  public long h()
  {
    if ((this.f != null) && (this.e != null)) {
      return this.f.e() - this.e.g();
    }
    return 0L;
  }
  
  public float i()
  {
    if (this.f != null) {
      return this.f.f();
    }
    return 0.0F;
  }
  
  public int j()
  {
    if (this.e != null) {
      return this.e.h();
    }
    return 0;
  }
  
  public String k()
  {
    if (this.f != null) {}
    for (int i1 = this.f.g();; i1 = TXEAudioDef.TXE_AEC_NONE) {
      return i1 + " | " + this.o;
    }
  }
  
  public void l()
  {
    long l3 = 0L;
    TXAudioJitterBufferReportInfo localTXAudioJitterBufferReportInfo;
    long l1;
    long l2;
    if (this.f != null)
    {
      localTXAudioJitterBufferReportInfo = this.f.h();
      if (localTXAudioJitterBufferReportInfo != null)
      {
        if (localTXAudioJitterBufferReportInfo.mLoadCnt != 0) {
          break label330;
        }
        l1 = 0L;
        if (localTXAudioJitterBufferReportInfo.mTimeTotalCacheTimeCnt != 0L) {
          break label346;
        }
        l2 = 0L;
        label47:
        if (localTXAudioJitterBufferReportInfo.mTimeTotalJittCnt != 0) {
          break label362;
        }
      }
    }
    label330:
    label346:
    label362:
    for (int i1 = 0;; i1 = localTXAudioJitterBufferReportInfo.mTimeTotalJitt / localTXAudioJitterBufferReportInfo.mTimeTotalJittCnt)
    {
      long l4 = i1;
      setStatusValue(2001, Long.valueOf(l1));
      setStatusValue(2002, Long.valueOf(localTXAudioJitterBufferReportInfo.mLoadCnt));
      setStatusValue(2003, Long.valueOf(localTXAudioJitterBufferReportInfo.mLoadMaxTime));
      setStatusValue(2004, Long.valueOf(localTXAudioJitterBufferReportInfo.mSpeedCnt));
      setStatusValue(2005, Long.valueOf(localTXAudioJitterBufferReportInfo.mNoDataCnt));
      setStatusValue(2007, Long.valueOf(localTXAudioJitterBufferReportInfo.mAvgCacheTime));
      setStatusValue(2008, Long.valueOf(localTXAudioJitterBufferReportInfo.mIsRealTime));
      setStatusValue(2010, Long.valueOf(l2));
      setStatusValue(2011, Long.valueOf(l4));
      setStatusValue(2014, Long.valueOf(localTXAudioJitterBufferReportInfo.mTimeDropCnt));
      if (this.e != null)
      {
        setStatusValue(2006, Long.valueOf(d()));
        setStatusValue(6007, Long.valueOf(this.e.k()));
        setStatusValue(6008, Long.valueOf(this.e.j()));
        setStatusValue(6009, Long.valueOf(this.e.i()));
      }
      if (this.c != null)
      {
        l1 = l3;
        if (this.c.a() == true) {
          l1 = 1L;
        }
        setStatusValue(5002, Long.valueOf(l1));
      }
      return;
      l1 = localTXAudioJitterBufferReportInfo.mLoadTime / localTXAudioJitterBufferReportInfo.mLoadCnt;
      break;
      l2 = localTXAudioJitterBufferReportInfo.mTimeTotalCacheTime / localTXAudioJitterBufferReportInfo.mTimeTotalCacheTimeCnt;
      break label47;
    }
  }
  
  public void m()
  {
    com.tencent.liteav.videodecoder.b localb = this.c;
    if ((localb != null) && (localb.e())) {
      localb.b(true);
    }
  }
  
  public long n()
  {
    try
    {
      if (this.f != null)
      {
        long l1 = this.f.c();
        return l1;
      }
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public int o()
  {
    try
    {
      if (this.c != null)
      {
        int i1 = this.c.d();
        return i1;
      }
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 2106) {
      r();
    }
    for (;;)
    {
      com.tencent.liteav.basic.c.a locala = this.g;
      if (locala != null) {
        locala.onNotifyEvent(paramInt, paramBundle);
      }
      return;
      if ((paramInt == 2003) && (this.n))
      {
        a(2004, "视频播放开始");
        this.n = false;
      }
    }
  }
  
  public void onPlayAudioInfoChanged(com.tencent.liteav.basic.f.a parama1, com.tencent.liteav.basic.f.a parama2)
  {
    if (this.u != null) {
      this.u.a(parama2);
    }
    if ((parama1 != null) && (parama2 != null)) {
      this.o = (parama1.a + "," + parama1.b + " | " + parama2.a + "," + parama2.b);
    }
  }
  
  public void onPlayError(int paramInt, String paramString) {}
  
  public void onPlayJitterStateNotify(int paramInt)
  {
    if (paramInt == TXEAudioDef.TXE_AUDIO_JITTER_STATE_LOADING)
    {
      if (this.e != null) {
        this.e.a(true);
      }
      a(2007, "视频缓冲中...");
    }
    do
    {
      do
      {
        return;
        if (paramInt == TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_LAODING)
        {
          a(2007, "视频缓冲中...");
          return;
        }
        if (paramInt == TXEAudioDef.TXE_AUDIO_JITTER_STATE_PLAYING)
        {
          if (this.e != null) {
            this.e.a(false);
          }
          a(2004, "视频播放开始");
          return;
        }
      } while (paramInt != TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_PLAY);
      if (this.e != null) {
        this.e.a(false);
      }
    } while (!this.n);
    a(2004, "视频播放开始");
    this.n = false;
  }
  
  public void onPlayPcmData(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.u != null) {
      this.u.a(paramArrayOfByte, paramLong);
    }
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    if (this.d != null) {
      this.d.setID(getID());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.h
 * JD-Core Version:    0.7.0.1
 */