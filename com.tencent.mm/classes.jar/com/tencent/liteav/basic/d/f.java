package com.tencent.liteav.basic.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
  extends Handler
{
  public int a = 720;
  public int b = 1280;
  public Surface c = null;
  public boolean d = false;
  public android.opengl.EGLContext e = null;
  protected b f = null;
  public javax.microedition.khronos.egl.EGLContext g = null;
  private f.a h = null;
  private c i = null;
  
  public f(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static void a(Handler paramHandler, HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(146497);
    if ((paramHandler == null) || (paramHandlerThread == null))
    {
      AppMethodBeat.o(146497);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.obj = new f.1(paramHandler, paramHandlerThread);
    paramHandler.sendMessage(localMessage);
    AppMethodBeat.o(146497);
  }
  
  private void a(Message paramMessage)
  {
    AppMethodBeat.i(146501);
    try
    {
      d();
      AppMethodBeat.o(146501);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "surface-render: init egl context exception " + this.c);
      this.c = null;
      AppMethodBeat.o(146501);
    }
  }
  
  private void b(Message paramMessage)
  {
    AppMethodBeat.i(146502);
    e();
    AppMethodBeat.o(146502);
  }
  
  private void c(Message paramMessage)
  {
    AppMethodBeat.i(146503);
    try
    {
      if (this.h != null) {
        this.h.d();
      }
      AppMethodBeat.o(146503);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + paramMessage.getMessage());
      AppMethodBeat.o(146503);
    }
  }
  
  private boolean d()
  {
    AppMethodBeat.i(146504);
    TXCLog.d("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    if (!this.d) {
      this.f = b.a(null, this.g, this.c, this.a, this.b);
    }
    while ((this.f == null) && (this.i == null))
    {
      AppMethodBeat.o(146504);
      return false;
      this.i = c.a(null, this.e, this.c, this.a, this.b);
    }
    TXCLog.w("TXGLThreadHandler", "surface-render: create egl context " + this.c);
    if (this.h != null) {
      this.h.c();
    }
    AppMethodBeat.o(146504);
    return true;
  }
  
  private void e()
  {
    AppMethodBeat.i(146505);
    TXCLog.w("TXGLThreadHandler", "surface-render: destroy egl context " + this.c);
    if (this.h != null) {
      this.h.e();
    }
    if (this.f != null)
    {
      this.f.b();
      this.f = null;
    }
    if (this.i != null)
    {
      this.i.b();
      this.i = null;
    }
    this.c = null;
    AppMethodBeat.o(146505);
  }
  
  public javax.microedition.khronos.egl.EGLContext a()
  {
    AppMethodBeat.i(146498);
    if (this.f != null)
    {
      javax.microedition.khronos.egl.EGLContext localEGLContext = this.f.c();
      AppMethodBeat.o(146498);
      return localEGLContext;
    }
    AppMethodBeat.o(146498);
    return null;
  }
  
  public void a(f.a parama)
  {
    this.h = parama;
  }
  
  public Surface b()
  {
    return this.c;
  }
  
  public void c()
  {
    AppMethodBeat.i(146499);
    if (this.f != null) {
      this.f.a();
    }
    if (this.i != null) {
      this.i.c();
    }
    AppMethodBeat.o(146499);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(146500);
    if (paramMessage == null)
    {
      AppMethodBeat.o(146500);
      return;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      if ((paramMessage != null) && (paramMessage.obj != null)) {
        ((Runnable)paramMessage.obj).run();
      }
      AppMethodBeat.o(146500);
      return;
      a(paramMessage);
      continue;
      try
      {
        c(paramMessage);
      }
      catch (Exception localException) {}
      continue;
      b(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.d.f
 * JD-Core Version:    0.7.0.1
 */