package com.tencent.liteav.beauty;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.a.a.c;
import com.tencent.liteav.beauty.b.l;

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
    TXCLog.i(this.b, "come into InitEGL");
    paramObject = (c.b)paramObject;
    a();
    b.a(this.a, new com.tencent.liteav.beauty.a.a.a());
    b.a(this.a, new c(b.m(this.a), paramObject.g, paramObject.f, false));
    b.n(this.a).b();
    if (!b.a(this.a, paramObject))
    {
      TXCLog.e(this.b, "initInternal failed!");
      return;
    }
    TXCLog.i(this.b, "come out InitEGL");
  }
  
  public void a()
  {
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
    b.a(this.a, false);
    NativeLoad.getInstance();
    NativeLoad.nativeDeleteYuv2Yuv();
    TXCLog.i(this.b, "come out releaseEGL");
  }
  
  /* Error */
  void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 122	java/lang/Object:wait	()V
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: athrow
    //   14: astore_1
    //   15: goto -9 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	18	0	this	a
    //   9	4	1	localObject	Object
    //   14	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	6	9	finally
    //   6	8	9	finally
    //   10	12	9	finally
    //   2	6	14	java/lang/InterruptedException
  }
  
  public void handleMessage(Message paramMessage)
  {
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
        finally {}
        a(paramMessage.obj);
        b.a(this.a, true);
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