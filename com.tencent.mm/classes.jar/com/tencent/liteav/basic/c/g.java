package com.tencent.liteav.basic.c;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g
  extends e
{
  public int a = 720;
  public int b = 1280;
  public Surface c = null;
  public boolean d = false;
  public c e = null;
  public android.opengl.EGLContext f = null;
  public b g = null;
  public javax.microedition.khronos.egl.EGLContext h = null;
  private a i = null;
  
  public g(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static void a(Handler paramHandler, final HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(222246);
    if ((paramHandler == null) || (paramHandlerThread == null))
    {
      AppMethodBeat.o(222246);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.obj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222245);
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222310);
            if (g.1.this.a != null) {
              g.1.this.a.removeCallbacksAndMessages(null);
            }
            if (g.1.this.b != null)
            {
              if (Build.VERSION.SDK_INT >= 18)
              {
                g.1.this.b.quitSafely();
                AppMethodBeat.o(222310);
                return;
              }
              g.1.this.b.quit();
            }
            AppMethodBeat.o(222310);
          }
        });
        AppMethodBeat.o(222245);
      }
    };
    paramHandler.sendMessage(localMessage);
    AppMethodBeat.o(222246);
  }
  
  private void a(Message paramMessage)
  {
    AppMethodBeat.i(222251);
    try
    {
      e();
      AppMethodBeat.o(222251);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "surface-render: init egl context exception " + this.c);
      this.c = null;
      AppMethodBeat.o(222251);
    }
  }
  
  private void b(Message paramMessage)
  {
    AppMethodBeat.i(222252);
    f();
    AppMethodBeat.o(222252);
  }
  
  private void c(Message paramMessage)
  {
    AppMethodBeat.i(222253);
    try
    {
      if (this.i != null) {
        this.i.d();
      }
      AppMethodBeat.o(222253);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + paramMessage.getMessage());
      AppMethodBeat.o(222253);
    }
  }
  
  private boolean e()
  {
    AppMethodBeat.i(222254);
    TXCLog.i("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    if (!this.d) {
      this.g = b.a(null, this.h, this.c, this.a, this.b);
    }
    while ((this.g == null) && (this.e == null))
    {
      AppMethodBeat.o(222254);
      return false;
      this.e = c.a(null, this.f, this.c, this.a, this.b);
    }
    TXCLog.w("TXGLThreadHandler", "surface-render: create egl context " + this.c);
    if (this.i != null) {
      this.i.c();
    }
    AppMethodBeat.o(222254);
    return true;
  }
  
  private void f()
  {
    AppMethodBeat.i(222255);
    TXCLog.w("TXGLThreadHandler", "surface-render: destroy egl context " + this.c);
    if (this.i != null) {
      this.i.e();
    }
    if (this.g != null)
    {
      this.g.c();
      this.g = null;
    }
    if (this.e != null)
    {
      this.e.c();
      this.e = null;
    }
    this.c = null;
    AppMethodBeat.o(222255);
  }
  
  public javax.microedition.khronos.egl.EGLContext a()
  {
    AppMethodBeat.i(222247);
    if (this.g != null)
    {
      javax.microedition.khronos.egl.EGLContext localEGLContext = this.g.d();
      AppMethodBeat.o(222247);
      return localEGLContext;
    }
    AppMethodBeat.o(222247);
    return null;
  }
  
  public void a(a parama)
  {
    this.i = parama;
  }
  
  public Surface b()
  {
    return this.c;
  }
  
  public void c()
  {
    AppMethodBeat.i(222248);
    if (this.g != null) {
      this.g.a();
    }
    if (this.e != null) {
      this.e.d();
    }
    AppMethodBeat.o(222248);
  }
  
  public void d()
  {
    AppMethodBeat.i(222249);
    if (this.g != null) {
      this.g.b();
    }
    if (this.e != null) {
      this.e.b();
    }
    AppMethodBeat.o(222249);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(222250);
    if (paramMessage == null)
    {
      AppMethodBeat.o(222250);
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
      AppMethodBeat.o(222250);
      return;
      a(paramMessage);
      continue;
      c(paramMessage);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.c.g
 * JD-Core Version:    0.7.0.1
 */