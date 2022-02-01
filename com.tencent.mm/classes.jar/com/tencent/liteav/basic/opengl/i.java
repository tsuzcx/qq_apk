package com.tencent.liteav.basic.opengl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i
  extends f
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
  
  public i(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static void a(Handler paramHandler, final HandlerThread paramHandlerThread)
  {
    AppMethodBeat.i(230182);
    if ((paramHandler == null) || (paramHandlerThread == null))
    {
      AppMethodBeat.o(230182);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.obj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(230266);
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230221);
            if (i.1.this.a != null) {
              i.1.this.a.removeCallbacksAndMessages(null);
            }
            if (i.1.this.b != null)
            {
              if (TXCBuild.VersionInt() >= 18)
              {
                i.1.this.b.quitSafely();
                AppMethodBeat.o(230221);
                return;
              }
              i.1.this.b.quit();
            }
            AppMethodBeat.o(230221);
          }
        });
        AppMethodBeat.o(230266);
      }
    };
    paramHandler.sendMessage(localMessage);
    AppMethodBeat.o(230182);
  }
  
  private void a(Message paramMessage)
  {
    AppMethodBeat.i(230193);
    try
    {
      e();
      AppMethodBeat.o(230193);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "surface-render: init egl context exception " + this.c);
      this.c = null;
      AppMethodBeat.o(230193);
    }
  }
  
  private void b(Message paramMessage)
  {
    AppMethodBeat.i(230197);
    f();
    AppMethodBeat.o(230197);
  }
  
  private void c(Message paramMessage)
  {
    AppMethodBeat.i(230204);
    try
    {
      if (this.i != null) {
        this.i.d();
      }
      AppMethodBeat.o(230204);
      return;
    }
    catch (Exception paramMessage)
    {
      TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + paramMessage.getMessage());
      AppMethodBeat.o(230204);
    }
  }
  
  private boolean e()
  {
    AppMethodBeat.i(230214);
    TXCLog.i("TXGLThreadHandler", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) }));
    if (!this.d) {
      this.g = b.a(null, this.h, this.c, this.a, this.b);
    }
    while ((this.g == null) && (this.e == null))
    {
      AppMethodBeat.o(230214);
      return false;
      this.e = c.a(null, this.f, this.c, this.a, this.b);
    }
    TXCLog.w("TXGLThreadHandler", "surface-render: create egl context " + this.c);
    if (this.i != null) {
      this.i.c();
    }
    AppMethodBeat.o(230214);
    return true;
  }
  
  private void f()
  {
    AppMethodBeat.i(230219);
    TXCLog.w("TXGLThreadHandler", "surface-render: destroy egl context " + this.c);
    this.d = false;
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
      this.e.d();
      this.e = null;
    }
    this.c = null;
    AppMethodBeat.o(230219);
  }
  
  public javax.microedition.khronos.egl.EGLContext a()
  {
    AppMethodBeat.i(230230);
    if (this.g != null)
    {
      javax.microedition.khronos.egl.EGLContext localEGLContext = this.g.d();
      AppMethodBeat.o(230230);
      return localEGLContext;
    }
    AppMethodBeat.o(230230);
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
    AppMethodBeat.i(230242);
    if (this.g != null) {
      this.g.a();
    }
    if (this.e != null) {
      this.e.e();
    }
    AppMethodBeat.o(230242);
  }
  
  public void d()
  {
    AppMethodBeat.i(230245);
    if (this.g != null) {
      this.g.b();
    }
    if (this.e != null) {
      this.e.b();
    }
    AppMethodBeat.o(230245);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(230254);
    if (paramMessage == null)
    {
      AppMethodBeat.o(230254);
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
      AppMethodBeat.o(230254);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.i
 * JD-Core Version:    0.7.0.1
 */