package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
{
  static d a;
  private static final String b;
  private d.a c;
  private boolean d = false;
  private volatile boolean e = false;
  private Context f = null;
  private int g = 0;
  private volatile boolean h = false;
  private int i = 48000;
  private int j = 2;
  private int k = 16;
  
  static
  {
    AppMethodBeat.i(66627);
    b = "AudioCenter:" + d.class.getSimpleName();
    a = new d();
    AppMethodBeat.o(66627);
  }
  
  public static d a()
  {
    return a;
  }
  
  /* Error */
  public void a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 87
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 69	com/tencent/liteav/audio/impl/Play/d:f	Landroid/content/Context;
    //   12: aload_0
    //   13: iload_2
    //   14: putfield 71	com/tencent/liteav/audio/impl/Play/d:g	I
    //   17: aload_0
    //   18: getfield 73	com/tencent/liteav/audio/impl/Play/d:h	Z
    //   21: ifeq +26 -> 47
    //   24: getstatic 54	com/tencent/liteav/audio/impl/Play/d:b	Ljava/lang/String;
    //   27: ldc 89
    //   29: invokestatic 95	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: invokestatic 100	com/tencent/liteav/audio/impl/a:a	()Lcom/tencent/liteav/audio/impl/a;
    //   35: iload_2
    //   36: invokevirtual 102	com/tencent/liteav/audio/impl/a:b	(I)V
    //   39: ldc 87
    //   41: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: getstatic 54	com/tencent/liteav/audio/impl/Play/d:b	Ljava/lang/String;
    //   50: ldc 104
    //   52: invokestatic 95	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc 87
    //   57: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -16 -> 44
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	d
    //   0	68	1	paramContext	Context
    //   0	68	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	44	63	finally
    //   47	60	63	finally
  }
  
  public void b()
  {
    AppMethodBeat.i(66624);
    TXCLog.w(b, "mult-track-player start!");
    if (this.e)
    {
      TXCLog.e(b, "mult-track-player can not start because of has started!");
      AppMethodBeat.o(66624);
      return;
    }
    if ((this.i == 0) || (this.j == 0))
    {
      TXCLog.e(b, "strat mult-track-player failed with invalid audio info , samplerate:" + this.i + ", channels:" + this.j);
      AppMethodBeat.o(66624);
      return;
    }
    this.e = true;
    if (this.c == null)
    {
      this.c = new d.1(this, "AUDIO_TRACK");
      this.c.start();
    }
    TXCLog.w(b, "mult-track-player thread start finish!");
    AppMethodBeat.o(66624);
  }
  
  public void c()
  {
    AppMethodBeat.i(66625);
    TXCLog.w(b, "mult-track-player stop!");
    if (!this.e)
    {
      TXCLog.w(b, "mult-track-player can not stop because of not started yet!");
      AppMethodBeat.o(66625);
      return;
    }
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
    }
    this.g = 0;
    this.f = null;
    this.h = false;
    this.e = false;
    TXCLog.w(b, "mult-track-player stop finish!");
    AppMethodBeat.o(66625);
  }
  
  public boolean d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.d
 * JD-Core Version:    0.7.0.1
 */