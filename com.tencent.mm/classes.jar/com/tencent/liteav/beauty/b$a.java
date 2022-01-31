package com.tencent.liteav.beauty;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.a.a.c;
import com.tencent.liteav.beauty.b.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

class b$a
  extends Handler
{
  private String b = "EGLDrawThreadHandler";
  
  b$a(b paramb, Looper paramLooper, Context paramContext)
  {
    super(paramLooper);
  }
  
  private void a(Object paramObject)
  {
    AppMethodBeat.i(66902);
    TXCLog.i(this.b, "come into InitEGL");
    paramObject = (c.b)paramObject;
    a();
    b.a(this.a, new com.tencent.liteav.beauty.a.a.a());
    b.a(this.a, new c(b.m(this.a), paramObject.g, paramObject.f, false));
    b.n(this.a).b();
    if (!b.a(this.a, paramObject))
    {
      TXCLog.e(this.b, "initInternal failed!");
      AppMethodBeat.o(66902);
      return;
    }
    TXCLog.i(this.b, "come out InitEGL");
    AppMethodBeat.o(66902);
  }
  
  public void a()
  {
    AppMethodBeat.i(66903);
    TXCLog.i(this.b, "come into releaseEGL");
    if ((b.o(this.a) != null) && (b.o(this.a)[0] > 0))
    {
      GLES20.glDeleteBuffers(1, b.o(this.a), 0);
      b.a(this.a, null);
    }
    b.p(this.a);
    if (b.n(this.a) != null)
    {
      b.n(this.a).c();
      b.a(this.a, null);
    }
    if (b.m(this.a) != null)
    {
      b.m(this.a).a();
      b.a(this.a, null);
    }
    b.b(this.a, false);
    NativeLoad.getInstance();
    NativeLoad.nativeDeleteYuv2Yuv();
    TXCLog.i(this.b, "come out releaseEGL");
    AppMethodBeat.o(66903);
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: ldc 127
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 132	java/lang/Object:wait	()V
    //   11: aload_0
    //   12: monitorexit
    //   13: ldc 127
    //   15: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: ldc 127
    //   24: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: athrow
    //   29: astore_1
    //   30: goto -19 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	a
    //   19	9	1	localObject	Object
    //   29	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   7	11	19	finally
    //   11	13	19	finally
    //   20	22	19	finally
    //   7	11	29	java/lang/InterruptedException
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(66904);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        if (1 == i) {}
        try
        {
          notify();
          return;
        }
        finally
        {
          AppMethodBeat.o(66904);
        }
        a(paramMessage.obj);
        b.b(this.a, true);
        i = 1;
        continue;
        a();
        this.a.d.a();
        i = 0;
        continue;
        b.a(this.a, (byte[])paramMessage.obj);
        i = 0;
        continue;
        b.b(this.a, paramMessage.arg1);
        i = 1;
        continue;
        b.a(this.a, (float)(paramMessage.arg1 / 100.0D));
        if (b.a(this.a) == null) {
          break;
        }
        b.a(this.a).a(b.q(this.a));
        i = 0;
        continue;
        paramMessage = (c.b)paramMessage.obj;
        b.b(this.a, paramMessage);
        i = 0;
      }
      b.a(this.a, b.c(this.a), b.d(this.a), b.r(this.a), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
      this.a.f.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a
 * JD-Core Version:    0.7.0.1
 */