package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;

public class b
  implements e
{
  public static final int a = TXEAudioDef.TXE_AEC_NONE;
  public static float b = 5.0F;
  public static boolean c = true;
  public static float d = 5.0F;
  public static float e = 1.0F;
  public static boolean f = false;
  private static final String g = "AudioCenter:" + b.class.getSimpleName();
  private TXCAudioBasePlayController h = null;
  private d i;
  private int j = a;
  private float k = b;
  private boolean l = c;
  private float m = d;
  private float n = e;
  private boolean o = false;
  private boolean p = false;
  private boolean q = f;
  private int r = 0;
  private Context s;
  
  private void a(int paramInt, Context paramContext)
  {
    if ((paramInt == TXEAudioDef.TXE_AEC_TRAE) && (!TXCTraeJNI.nativeCheckTraeEngine(paramContext)))
    {
      TXCLog.e(g, "set aec type failed, check trae library failed!!");
      return;
    }
    TXCLog.i(g, "set aec type to " + paramInt + ", cur type " + this.j);
    this.j = paramInt;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    TXCAudioBasePlayController.setAudioMode(paramContext, paramInt);
  }
  
  public int a()
  {
    try
    {
      int i1 = TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK;
      this.i = null;
      this.k = b;
      this.l = c;
      this.m = d;
      this.n = e;
      this.o = false;
      this.p = false;
      this.q = f;
      this.r = 0;
      this.s = null;
      if (this.h != null)
      {
        i1 = this.h.stopPlay();
        this.h = null;
      }
      com.tencent.liteav.audio.impl.c.a().b(this);
      return i1;
    }
    finally {}
  }
  
  public int a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      int i1;
      try
      {
        TXCLog.e(g, "invalid param, start play failed!");
        i1 = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        return i1;
      }
      finally {}
      if (com.tencent.liteav.audio.impl.a.c(this.j) != TXEAudioDef.TXE_AUDIO_PLAY_ERR_OK) {
        TXCLog.w(g, "start player failed, with aec type " + this.j + ", invalid aec recorder has started!");
      }
      if ((this.h != null) && (this.h.isPlaying()))
      {
        TXCLog.e(g, "play has started, can not start again!");
        i1 = TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
      }
      else
      {
        this.s = paramContext;
        com.tencent.liteav.audio.impl.c.a().a(this.s);
        com.tencent.liteav.audio.impl.c.a().a(this);
        if (this.h == null)
        {
          if (this.j == TXEAudioDef.TXE_AEC_TRAE) {
            this.h = new com.tencent.liteav.audio.impl.Play.c(paramContext.getApplicationContext());
          }
        }
        else
        {
          if (this.h == null) {
            break label276;
          }
          a(this.j, this.s);
          a(this.i);
          a(this.k);
          a(this.l);
          b(this.m);
          c(this.n);
          c(this.o);
          b(this.p);
          a(this.r);
          d(this.q);
          i1 = this.h.startPlay();
          continue;
        }
        this.h = new com.tencent.liteav.audio.impl.Play.b(paramContext.getApplicationContext());
        continue;
        label276:
        TXCLog.e(g, "start play failed! controller is null!");
        i1 = TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
      }
    }
  }
  
  /* Error */
  public int a(com.tencent.liteav.basic.f.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   6: ifnonnull +19 -> 25
    //   9: getstatic 57	com/tencent/liteav/audio/b:g	Ljava/lang/String;
    //   12: ldc 226
    //   14: invokestatic 115	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 229	com/tencent/liteav/audio/TXEAudioDef:TXE_AUDIO_PLAY_ERR_INVALID_STATE	I
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   29: aload_1
    //   30: invokevirtual 232	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:playData	(Lcom/tencent/liteav/basic/f/a;)I
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	b
    //   0	42	1	parama	com.tencent.liteav.basic.f.a
    //   20	14	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	21	37	finally
    //   25	34	37	finally
  }
  
  public void a(float paramFloat)
  {
    this.k = paramFloat;
    if (this.h != null) {
      this.h.setCacheTime(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.r = paramInt;
    if (this.h != null) {
      this.h.setSmootheMode(this.r);
    }
  }
  
  public void a(d paramd)
  {
    this.i = paramd;
    if (this.h != null) {
      this.h.setListener(paramd);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
    if (this.h != null) {
      this.h.enableAutojustCache(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Context paramContext)
  {
    if (!paramBoolean)
    {
      a(TXEAudioDef.TXE_AEC_NONE, paramContext);
      return;
    }
    if (com.tencent.liteav.basic.e.b.a().g())
    {
      a(TXEAudioDef.TXE_AEC_SYSTEM, paramContext);
      return;
    }
    a.a(com.tencent.liteav.basic.e.b.a().b());
    a(TXEAudioDef.TXE_AEC_TRAE, paramContext);
  }
  
  /* Error */
  public long b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   13: invokevirtual 265	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:getCacheDuration	()J
    //   16: lstore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: lload_1
    //   20: lreturn
    //   21: lconst_0
    //   22: lstore_1
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	b
    //   16	7	1	l1	long
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public void b(float paramFloat)
  {
    this.m = paramFloat;
    if (this.h != null) {
      this.h.setAutoAdjustMaxCache(paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.h == null);
        this.h.setMute(true);
        return;
      } while (this.h == null);
      this.h.setMute(true);
      return;
    } while (this.h == null);
    this.h.setMute(this.q);
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if (this.h != null) {
      this.h.enableHWAcceleration(paramBoolean);
    }
  }
  
  /* Error */
  public long c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   13: invokevirtual 277	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:getCurPts	()J
    //   16: lstore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: lload_1
    //   20: lreturn
    //   21: lconst_0
    //   22: lstore_1
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	b
    //   16	7	1	l1	long
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public void c(float paramFloat)
  {
    this.n = paramFloat;
    if (this.h != null) {
      this.h.setAutoAdjustMinCache(paramFloat);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (this.h != null) {
      this.h.enableRealTimePlay(paramBoolean);
    }
  }
  
  /* Error */
  public int d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   13: invokevirtual 286	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:getRecvJitter	()I
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	b
    //   16	7	1	i1	int
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public void d(boolean paramBoolean)
  {
    this.q = paramBoolean;
    if (this.h != null) {
      this.h.setMute(paramBoolean);
    }
  }
  
  /* Error */
  public long e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   13: invokevirtual 289	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:getCurRecvTS	()J
    //   16: lstore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: lload_1
    //   20: lreturn
    //   21: lconst_0
    //   22: lstore_1
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	b
    //   16	7	1	l1	long
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  /* Error */
  public float f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 80	com/tencent/liteav/audio/b:h	Lcom/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController;
    //   13: invokevirtual 293	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:getCacheThreshold	()F
    //   16: fstore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: fload_1
    //   20: freturn
    //   21: fconst_0
    //   22: fstore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	b
    //   16	7	1	f1	float
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
  
  public int g()
  {
    if (com.tencent.liteav.audio.impl.Play.d.a().d())
    {
      if (this.j == TXEAudioDef.TXE_AEC_TRAE)
      {
        TXCLog.e(g, "audio track has start, but aec type is trae!!" + this.j);
        return TXEAudioDef.TXE_AEC_NONE;
      }
      return this.j;
    }
    if (TXCTraeJNI.nativeTraeIsPlaying())
    {
      if (this.j != TXEAudioDef.TXE_AEC_TRAE)
      {
        TXCLog.e(g, "trae engine has start, but aec type is not trae!!" + this.j);
        return TXEAudioDef.TXE_AEC_TRAE;
      }
      return this.j;
    }
    return TXEAudioDef.TXE_AEC_NONE;
  }
  
  public TXAudioJitterBufferReportInfo h()
  {
    if (this.h != null) {
      return this.h.getReportInfo();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.b
 * JD-Core Version:    0.7.0.1
 */