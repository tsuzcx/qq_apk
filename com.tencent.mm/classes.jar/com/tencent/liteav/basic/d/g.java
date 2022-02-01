package com.tencent.liteav.basic.d;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
  extends Handler
{
  public int a = 720;
  public int b = 1280;
  public Surface c = null;
  public boolean d = false;
  public android.opengl.EGLContext e = null;
  public b f = null;
  public javax.microedition.khronos.egl.EGLContext g = null;
  private a h = null;
  private c i = null;
  
  public g(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static void a(Handler paramHandler, final HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(193091);
    if ((paramHandler == null) || (paramHandlerThread == null))
    {
      AppMethodBeat.o(193091);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.obj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14583);
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(193135);
            if (g.1.this.a != null) {
              g.1.this.a.removeCallbacksAndMessages(null);
            }
            if (g.1.this.b != null)
            {
              if (Build.VERSION.SDK_INT >= 18)
              {
                g.1.this.b.quitSafely();
                AppMethodBeat.o(193135);
                return;
              }
              g.1.this.b.quit();
            }
            AppMethodBeat.o(193135);
          }
        });
        AppMethodBeat.o(14583);
      }
    };
    paramHandler.sendMessage(localMessage);
    AppMethodBeat.o(193091);
  }
  
  private void a(Message paramMessage)
  {
    AppMethodBeat.i(193095);
    try
    {
      e();
      AppMethodBeat.o(193095);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "surface-render: init egl context exception " + this.c);
      this.c = null;
      AppMethodBeat.o(193095);
    }
  }
  
  private void b(Message paramMessage)
  {
    AppMethodBeat.i(193096);
    f();
    AppMethodBeat.o(193096);
  }
  
  private void c(Message paramMessage)
  {
    AppMethodBeat.i(193097);
    try
    {
      if (this.h != null) {
        this.h.d();
      }
      AppMethodBeat.o(193097);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + paramMessage.getMessage());
      AppMethodBeat.o(193097);
    }
  }
  
  private boolean e()
  {
    AppMethodBeat.i(193098);
    TXCLog.i("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    if (!this.d) {
      this.f = b.a(null, this.g, this.c, this.a, this.b);
    }
    while ((this.f == null) && (this.i == null))
    {
      AppMethodBeat.o(193098);
      return false;
      this.i = c.a(null, this.e, this.c, this.a, this.b);
    }
    TXCLog.w("TXGLThreadHandler", "surface-render: create egl context " + this.c);
    if (this.h != null) {
      this.h.c();
    }
    AppMethodBeat.o(193098);
    return true;
  }
  
  private void f()
  {
    AppMethodBeat.i(14514);
    TXCLog.w("TXGLThreadHandler", "surface-render: destroy egl context " + this.c);
    if (this.h != null) {
      this.h.e();
    }
    if (this.f != null)
    {
      this.f.c();
      this.f = null;
    }
    if (this.i != null)
    {
      this.i.c();
      this.i = null;
    }
    this.c = null;
    AppMethodBeat.o(14514);
  }
  
  public javax.microedition.khronos.egl.EGLContext a()
  {
    AppMethodBeat.i(193092);
    if (this.f != null)
    {
      javax.microedition.khronos.egl.EGLContext localEGLContext = this.f.d();
      AppMethodBeat.o(193092);
      return localEGLContext;
    }
    AppMethodBeat.o(193092);
    return null;
  }
  
  public void a(a parama)
  {
    this.h = parama;
  }
  
  public Surface b()
  {
    return this.c;
  }
  
  public void c()
  {
    AppMethodBeat.i(193093);
    if (this.f != null) {
      this.f.a();
    }
    if (this.i != null) {
      this.i.d();
    }
    AppMethodBeat.o(193093);
  }
  
  public void d()
  {
    AppMethodBeat.i(14511);
    if (this.f != null) {
      this.f.b();
    }
    if (this.i != null) {
      this.i.b();
    }
    AppMethodBeat.o(14511);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(193094);
    if (paramMessage == null)
    {
      AppMethodBeat.o(193094);
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
      AppMethodBeat.o(193094);
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
  
  static abstract interface a
  {
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.d.g
 * JD-Core Version:    0.7.0.1
 */