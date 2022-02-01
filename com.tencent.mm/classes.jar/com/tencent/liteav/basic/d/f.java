package com.tencent.liteav.basic.d;

import android.os.Build.VERSION;
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
  public b f = null;
  public javax.microedition.khronos.egl.EGLContext g = null;
  private a h = null;
  private c i = null;
  
  public f(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static void a(Handler paramHandler, final HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(14563);
    if ((paramHandler == null) || (paramHandlerThread == null))
    {
      AppMethodBeat.o(14563);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.obj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14585);
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(14498);
            if (f.1.this.a != null) {
              f.1.this.a.removeCallbacksAndMessages(null);
            }
            if (f.1.this.b != null)
            {
              if (Build.VERSION.SDK_INT >= 18)
              {
                f.1.this.b.quitSafely();
                AppMethodBeat.o(14498);
                return;
              }
              f.1.this.b.quit();
            }
            AppMethodBeat.o(14498);
          }
        });
        AppMethodBeat.o(14585);
      }
    };
    paramHandler.sendMessage(localMessage);
    AppMethodBeat.o(14563);
  }
  
  private void a(Message paramMessage)
  {
    AppMethodBeat.i(14567);
    try
    {
      e();
      AppMethodBeat.o(14567);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "surface-render: init egl context exception " + this.c);
      this.c = null;
      AppMethodBeat.o(14567);
    }
  }
  
  private void b(Message paramMessage)
  {
    AppMethodBeat.i(14568);
    f();
    AppMethodBeat.o(14568);
  }
  
  private void c(Message paramMessage)
  {
    AppMethodBeat.i(14569);
    try
    {
      if (this.h != null) {
        this.h.d();
      }
      AppMethodBeat.o(14569);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + paramMessage.getMessage());
      AppMethodBeat.o(14569);
    }
  }
  
  private boolean e()
  {
    AppMethodBeat.i(182424);
    TXCLog.i("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    if (!this.d) {
      this.f = b.a(null, this.g, this.c, this.a, this.b);
    }
    while ((this.f == null) && (this.i == null))
    {
      AppMethodBeat.o(182424);
      return false;
      this.i = c.a(null, this.e, this.c, this.a, this.b);
    }
    TXCLog.w("TXGLThreadHandler", "surface-render: create egl context " + this.c);
    if (this.h != null) {
      this.h.c();
    }
    AppMethodBeat.o(182424);
    return true;
  }
  
  private void f()
  {
    AppMethodBeat.i(182425);
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
    AppMethodBeat.o(182425);
  }
  
  public javax.microedition.khronos.egl.EGLContext a()
  {
    AppMethodBeat.i(14564);
    if (this.f != null)
    {
      javax.microedition.khronos.egl.EGLContext localEGLContext = this.f.d();
      AppMethodBeat.o(14564);
      return localEGLContext;
    }
    AppMethodBeat.o(14564);
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
    AppMethodBeat.i(14565);
    if (this.f != null) {
      this.f.a();
    }
    if (this.i != null) {
      this.i.d();
    }
    AppMethodBeat.o(14565);
  }
  
  public void d()
  {
    AppMethodBeat.i(182423);
    if (this.f != null) {
      this.f.b();
    }
    if (this.i != null) {
      this.i.b();
    }
    AppMethodBeat.o(182423);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(14566);
    if (paramMessage == null)
    {
      AppMethodBeat.o(14566);
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
      AppMethodBeat.o(14566);
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
 * Qualified Name:     com.tencent.liteav.basic.d.f
 * JD-Core Version:    0.7.0.1
 */