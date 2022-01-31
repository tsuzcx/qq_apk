package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements e
{
  public static float a;
  public static boolean b;
  public static float c;
  public static float d;
  public static boolean e;
  private static final String f;
  private TXCAudioBasePlayController g;
  private c h;
  private int i;
  private float j;
  private boolean k;
  private float l;
  private float m;
  private boolean n;
  private boolean o;
  private boolean p;
  private int q;
  private Context r;
  private String s;
  private int t;
  private com.tencent.liteav.basic.module.a u;
  private boolean v;
  
  static
  {
    AppMethodBeat.i(66541);
    f = "AudioCenter:" + a.class.getSimpleName();
    a = 5.0F;
    b = true;
    c = 5.0F;
    d = 1.0F;
    e = false;
    AppMethodBeat.o(66541);
  }
  
  public a()
  {
    AppMethodBeat.i(146204);
    this.g = null;
    this.i = 0;
    this.j = a;
    this.k = b;
    this.l = c;
    this.m = d;
    this.n = false;
    this.o = false;
    this.p = e;
    this.q = 0;
    this.t = 0;
    this.u = null;
    this.v = false;
    this.u = new com.tencent.liteav.basic.module.a();
    this.u.setID("18446744073709551615");
    AppMethodBeat.o(146204);
  }
  
  private void a(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(66521);
    if ((paramInt == 2) && (!TXCTraeJNI.nativeCheckTraeEngine(paramContext)))
    {
      TXCLog.e(f, "set aec type failed, check trae library failed!!");
      AppMethodBeat.o(66521);
      return;
    }
    TXCLog.i(f, "set aec type to " + paramInt + ", cur type " + this.i);
    this.i = paramInt;
    AppMethodBeat.o(66521);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66536);
    TXCAudioBasePlayController.setAudioMode(paramContext, paramInt);
    AppMethodBeat.o(66536);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(66523);
    TXCAudioBasePlayController.setAudioCorePlayListener(paramc);
    AppMethodBeat.o(66523);
  }
  
  public static void f(boolean paramBoolean)
  {
    AppMethodBeat.i(146213);
    TXCAudioBasePlayController.nativeEnableCoreplayVolumeLevelCal(paramBoolean);
    AppMethodBeat.o(146213);
  }
  
  public static int h()
  {
    AppMethodBeat.i(146214);
    int i1 = TXCAudioBasePlayController.nativeGetCorePlayVolumeLevel();
    AppMethodBeat.o(146214);
    return i1;
  }
  
  public int a()
  {
    int i1 = 0;
    try
    {
      AppMethodBeat.i(66519);
      this.h = null;
      this.j = a;
      this.k = b;
      this.l = c;
      this.m = d;
      this.n = false;
      this.o = false;
      this.p = e;
      this.q = 0;
      this.r = null;
      this.s = null;
      this.t = 0;
      if (this.g != null)
      {
        i1 = this.g.stopPlay();
        this.g = null;
      }
      com.tencent.liteav.audio.impl.c.a().b(this);
      AppMethodBeat.o(66519);
      return i1;
    }
    finally {}
  }
  
  /* Error */
  public int a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 184
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 106	com/tencent/liteav/audio/a:t	I
    //   12: aload_0
    //   13: getfield 86	com/tencent/liteav/audio/a:g	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   16: ifnonnull +15 -> 31
    //   19: bipush 155
    //   21: istore_1
    //   22: ldc 184
    //   24: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: aload_0
    //   32: getfield 86	com/tencent/liteav/audio/a:g	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   35: aload_0
    //   36: getfield 106	com/tencent/liteav/audio/a:t	I
    //   39: invokevirtual 187	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:setStreamFormat	(I)I
    //   42: istore_1
    //   43: ldc 184
    //   45: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -21 -> 27
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	a
    //   0	56	1	paramInt	int
    //   51	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	51	finally
    //   22	27	51	finally
    //   31	48	51	finally
  }
  
  public int a(Context paramContext)
  {
    int i1 = -901;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(66518);
        if (paramContext == null)
        {
          TXCLog.e(f, "invalid param, start play failed!");
          AppMethodBeat.o(66518);
          return i1;
        }
        if (com.tencent.liteav.audio.impl.b.c(this.i) != 0) {
          TXCLog.w(f, "start player failed, with aec type " + this.i + ", invalid aec recorder has started!");
        }
        if ((this.g != null) && (this.g.isPlaying()))
        {
          TXCLog.e(f, "play has started, can not start again!");
          i1 = -104;
          AppMethodBeat.o(66518);
          continue;
        }
        this.r = paramContext;
      }
      finally {}
      com.tencent.liteav.audio.impl.a.a().a(paramContext);
      com.tencent.liteav.audio.impl.c.a().a(this.r);
      com.tencent.liteav.audio.impl.c.a().a(this);
      if (this.g == null) {
        if (this.i != 2) {
          break label304;
        }
      }
      label304:
      for (this.g = new com.tencent.liteav.audio.impl.Play.c(paramContext.getApplicationContext());; this.g = new com.tencent.liteav.audio.impl.Play.b(paramContext.getApplicationContext()))
      {
        if (this.g == null) {
          break label322;
        }
        a(this.i, this.r);
        b(this.h);
        a(this.j);
        a(this.k);
        b(this.l);
        c(this.m);
        d(this.n);
        c(this.o);
        b(this.q);
        e(this.p);
        a(this.s);
        b(this.v);
        a(this.t);
        i1 = this.g.startPlay();
        AppMethodBeat.o(66518);
        break;
      }
      label322:
      TXCLog.e(f, "start play failed! controller is null!");
      AppMethodBeat.o(66518);
    }
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(66524);
    this.j = paramFloat;
    if (this.g != null) {
      this.g.setCacheTime(paramFloat);
    }
    AppMethodBeat.o(66524);
  }
  
  public void a(String paramString)
  {
    try
    {
      AppMethodBeat.i(146205);
      this.s = paramString;
      if (this.g != null) {
        this.g.setUserID(this.s);
      }
      AppMethodBeat.o(146205);
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(66525);
    this.k = paramBoolean;
    if (this.g != null) {
      this.g.enableAutojustCache(paramBoolean);
    }
    AppMethodBeat.o(66525);
  }
  
  public void a(boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(66520);
    if (!paramBoolean)
    {
      a(0, paramContext);
      this.u.setStatusValue(18005, Integer.valueOf(0));
      AppMethodBeat.o(66520);
      return;
    }
    if (com.tencent.liteav.basic.e.b.a().g())
    {
      a(1, paramContext);
      this.u.setStatusValue(18005, Integer.valueOf(1));
      AppMethodBeat.o(66520);
      return;
    }
    com.tencent.liteav.audio.impl.a.a(com.tencent.liteav.basic.e.b.a().b());
    this.u.setStatusValue(18005, Integer.valueOf(2));
    a(2, paramContext);
    AppMethodBeat.o(66520);
  }
  
  public int b()
  {
    AppMethodBeat.i(146208);
    if (this.g != null)
    {
      int i1 = this.g.getVolumeLevel();
      AppMethodBeat.o(146208);
      return i1;
    }
    AppMethodBeat.o(146208);
    return 0;
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(66526);
    this.l = paramFloat;
    if (this.g != null) {
      this.g.setAutoAdjustMaxCache(paramFloat);
    }
    AppMethodBeat.o(66526);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(66540);
    this.q = paramInt;
    if (this.g != null) {
      this.g.setSmootheMode(this.q);
    }
    AppMethodBeat.o(66540);
  }
  
  public void b(c paramc)
  {
    AppMethodBeat.i(146207);
    this.h = paramc;
    if (this.g != null) {
      this.g.setListener(paramc);
    }
    AppMethodBeat.o(146207);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(66533);
    this.v = paramBoolean;
    if (this.g != null) {
      this.g.setEnableVolumeLevelCal(paramBoolean);
    }
    AppMethodBeat.o(66533);
  }
  
  /* Error */
  public float c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 320
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 86	com/tencent/liteav/audio/a:g	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 86	com/tencent/liteav/audio/a:g	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   19: invokevirtual 323	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:getCacheThreshold	()F
    //   22: fstore_1
    //   23: ldc_w 320
    //   26: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: fload_1
    //   32: freturn
    //   33: fconst_0
    //   34: fstore_1
    //   35: ldc_w 320
    //   38: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	a
    //   22	13	1	f1	float
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   35	41	44	finally
  }
  
  public void c(float paramFloat)
  {
    AppMethodBeat.i(66527);
    this.m = paramFloat;
    if (this.g != null) {
      this.g.setAutoAdjustMinCache(paramFloat);
    }
    AppMethodBeat.o(66527);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(146212);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(146212);
      return;
      if (this.g != null)
      {
        this.g.setMute(true);
        AppMethodBeat.o(146212);
        return;
        if (this.g != null)
        {
          this.g.setMute(true);
          AppMethodBeat.o(146212);
          return;
          if (this.g != null) {
            this.g.setMute(this.p);
          }
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(66534);
    this.o = paramBoolean;
    if (this.g != null) {
      this.g.enableHWAcceleration(paramBoolean);
    }
    AppMethodBeat.o(66534);
  }
  
  public int d()
  {
    AppMethodBeat.i(66530);
    int i1;
    if (d.a().d())
    {
      if (this.i == 2)
      {
        TXCLog.e(f, "audio track has start, but aec type is trae!!" + this.i);
        AppMethodBeat.o(66530);
        return 0;
      }
      i1 = this.i;
      AppMethodBeat.o(66530);
      return i1;
    }
    if (TXCTraeJNI.nativeTraeIsPlaying())
    {
      if (this.i != 2)
      {
        TXCLog.e(f, "trae engine has start, but aec type is not trae!!" + this.i);
        AppMethodBeat.o(66530);
        return 2;
      }
      i1 = this.i;
      AppMethodBeat.o(66530);
      return i1;
    }
    AppMethodBeat.o(66530);
    return 0;
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(66535);
    this.n = paramBoolean;
    if (this.g != null) {
      this.g.enableRealTimePlay(paramBoolean);
    }
    AppMethodBeat.o(66535);
  }
  
  public int e()
  {
    return 48000;
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(146210);
    this.p = paramBoolean;
    if (this.g != null) {
      this.g.setMute(paramBoolean);
    }
    AppMethodBeat.o(146210);
  }
  
  public int f()
  {
    return 2;
  }
  
  public TXAudioJitterBufferReportInfo g()
  {
    AppMethodBeat.i(146211);
    if (this.g != null)
    {
      TXAudioJitterBufferReportInfo localTXAudioJitterBufferReportInfo = this.g.getReportInfo();
      AppMethodBeat.o(146211);
      return localTXAudioJitterBufferReportInfo;
    }
    AppMethodBeat.o(146211);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.audio.a
 * JD-Core Version:    0.7.0.1
 */