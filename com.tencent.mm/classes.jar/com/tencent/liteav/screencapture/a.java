package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.c.i;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLContext;

public class a
{
  protected final Handler a;
  protected volatile HandlerThread b;
  protected volatile b c;
  protected volatile WeakReference<b> d;
  protected volatile int e;
  protected int f;
  protected int g;
  protected int h;
  protected boolean i;
  private final boolean j;
  private final Context k;
  private Object l;
  private int m;
  private int n;
  private WeakReference<com.tencent.liteav.basic.b.b> o;
  private WeakReference<a> p;
  private c.b q;
  
  public a(Context paramContext, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(221408);
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 720;
    this.g = 1280;
    this.h = 20;
    this.i = true;
    this.l = null;
    this.m = this.f;
    this.n = this.g;
    this.o = null;
    this.q = new c.b()
    {
      public void a()
      {
        AppMethodBeat.i(221423);
        f.a(a.a(a.this), -7001, "Screen recording stopped. It may be preempted by other apps");
        a.a locala = a.b(a.this);
        a.a(a.this, null);
        if (locala != null) {
          locala.onScreenCaptureStopped(1);
        }
        AppMethodBeat.o(221423);
      }
      
      public void a(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(221424);
        if (a.c(a.this))
        {
          a.this.b(paramAnonymousBoolean);
          a.this.b(105, a.d(a.this), a.e(a.this));
        }
        AppMethodBeat.o(221424);
      }
      
      public void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(221422);
        if (paramAnonymousBoolean1)
        {
          a.this.b(106);
          AppMethodBeat.o(221422);
          return;
        }
        a.a(a.this, null);
        f.a(a.a(a.this), -1308, "Failed to share screen");
        AppMethodBeat.o(221422);
      }
    };
    this.p = new WeakReference(parama);
    this.k = paramContext.getApplicationContext();
    this.a = new Handler(Looper.getMainLooper());
    this.j = paramBoolean;
    AppMethodBeat.o(221408);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221412);
    if (this.j)
    {
      int i1 = ((WindowManager)this.k.getSystemService("window")).getDefaultDisplay().getRotation();
      if ((i1 == 0) || (i1 == 2)) {
        if (paramInt1 > paramInt2)
        {
          this.f = paramInt2;
          this.g = paramInt1;
        }
      }
    }
    for (;;)
    {
      this.m = this.f;
      this.n = this.g;
      AppMethodBeat.o(221412);
      return;
      this.f = paramInt1;
      this.g = paramInt2;
      continue;
      if (paramInt1 < paramInt2)
      {
        this.f = paramInt2;
        this.g = paramInt1;
      }
      else
      {
        this.f = paramInt1;
        this.g = paramInt2;
        continue;
        this.f = paramInt1;
        this.g = paramInt2;
      }
    }
  }
  
  private a d()
  {
    AppMethodBeat.i(221418);
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      AppMethodBeat.o(221418);
      return localObject;
    }
    AppMethodBeat.o(221418);
    return null;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16505);
    this.h = paramInt3;
    if (Build.VERSION.SDK_INT < 21)
    {
      c(20000004);
      AppMethodBeat.o(16505);
      return 20000004;
    }
    c(paramInt1, paramInt2);
    a();
    TXCLog.i("TXCScreenCapture", "start screen capture");
    AppMethodBeat.o(16505);
    return 0;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: sipush 16511
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 187	com/tencent/liteav/screencapture/a:b	()V
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: new 189	android/os/HandlerThread
    //   16: dup
    //   17: ldc 191
    //   19: invokespecial 194	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   22: putfield 66	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   25: aload_0
    //   26: getfield 66	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   29: invokevirtual 197	android/os/HandlerThread:start	()V
    //   32: aload_0
    //   33: new 17	com/tencent/liteav/screencapture/a$b
    //   36: dup
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 66	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   42: invokevirtual 200	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   45: aload_0
    //   46: invokespecial 203	com/tencent/liteav/screencapture/a$b:<init>	(Lcom/tencent/liteav/screencapture/a;Landroid/os/Looper;Lcom/tencent/liteav/screencapture/a;)V
    //   49: putfield 68	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$b;
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 72	com/tencent/liteav/screencapture/a:e	I
    //   57: iconst_1
    //   58: iadd
    //   59: putfield 72	com/tencent/liteav/screencapture/a:e	I
    //   62: aload_0
    //   63: getfield 68	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$b;
    //   66: aload_0
    //   67: getfield 72	com/tencent/liteav/screencapture/a:e	I
    //   70: putfield 205	com/tencent/liteav/screencapture/a$b:a	I
    //   73: aload_0
    //   74: getfield 68	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$b;
    //   77: aload_0
    //   78: getfield 84	com/tencent/liteav/screencapture/a:m	I
    //   81: putfield 206	com/tencent/liteav/screencapture/a$b:e	I
    //   84: aload_0
    //   85: getfield 68	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$b;
    //   88: aload_0
    //   89: getfield 86	com/tencent/liteav/screencapture/a:n	I
    //   92: putfield 207	com/tencent/liteav/screencapture/a$b:f	I
    //   95: aload_0
    //   96: getfield 68	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$b;
    //   99: astore_2
    //   100: aload_0
    //   101: getfield 78	com/tencent/liteav/screencapture/a:h	I
    //   104: ifgt +25 -> 129
    //   107: iconst_1
    //   108: istore_1
    //   109: aload_2
    //   110: iload_1
    //   111: putfield 208	com/tencent/liteav/screencapture/a$b:g	I
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_0
    //   117: bipush 100
    //   119: invokevirtual 210	com/tencent/liteav/screencapture/a:b	(I)V
    //   122: sipush 16511
    //   125: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: aload_0
    //   130: getfield 78	com/tencent/liteav/screencapture/a:h	I
    //   133: istore_1
    //   134: goto -25 -> 109
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: sipush 16511
    //   143: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	a
    //   108	26	1	i1	int
    //   99	11	2	localb	b
    //   137	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	107	137	finally
    //   109	116	137	finally
    //   129	134	137	finally
    //   138	140	137	finally
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(16515);
    this.h = paramInt;
    b(103, paramInt);
    AppMethodBeat.o(16515);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221411);
    c(paramInt1, paramInt2);
    b(105, paramInt1, paramInt2);
    AppMethodBeat.o(221411);
  }
  
  protected void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(16514);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(16514);
    }
  }
  
  protected void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(16517);
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt;
        localMessage.obj = paramRunnable;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(16517);
    }
  }
  
  protected void a(int paramInt1, EGLContext paramEGLContext, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(221416);
    b localb = c();
    if (localb != null) {
      localb.a(paramInt1, paramEGLContext, paramInt2, paramInt3, paramInt4, paramLong);
    }
    AppMethodBeat.o(221416);
  }
  
  public void a(com.tencent.liteav.basic.b.b paramb)
  {
    AppMethodBeat.i(221410);
    this.o = new WeakReference(paramb);
    AppMethodBeat.o(221410);
  }
  
  public void a(b paramb)
  {
    AppMethodBeat.i(221409);
    this.d = new WeakReference(paramb);
    AppMethodBeat.o(221409);
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(16506);
    TXCLog.i("TXCScreenCapture", "stop encode: ".concat(String.valueOf(paramObject)));
    this.l = paramObject;
    b();
    AppMethodBeat.o(16506);
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      AppMethodBeat.i(16510);
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      AppMethodBeat.o(16510);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(final boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 16507
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: new 8	com/tencent/liteav/screencapture/a$2
    //   11: dup
    //   12: aload_0
    //   13: iload_1
    //   14: invokespecial 269	com/tencent/liteav/screencapture/a$2:<init>	(Lcom/tencent/liteav/screencapture/a;Z)V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 68	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$b;
    //   22: ifnull +21 -> 43
    //   25: aload_0
    //   26: getfield 68	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$b;
    //   29: aload_2
    //   30: invokevirtual 265	com/tencent/liteav/screencapture/a$b:post	(Ljava/lang/Runnable;)Z
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: sipush 16507
    //   39: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: return
    //   43: aload_2
    //   44: invokeinterface 274 1 0
    //   49: goto -15 -> 34
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: sipush 16507
    //   58: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	a
    //   0	63	1	paramBoolean	boolean
    //   17	27	2	local2	2
    //   52	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	34	52	finally
    //   34	36	52	finally
    //   43	49	52	finally
    //   53	55	52	finally
  }
  
  protected void b()
  {
    AppMethodBeat.i(16512);
    try
    {
      this.e += 1;
      if (this.c != null)
      {
        final HandlerThread localHandlerThread = this.b;
        a(101, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(16525);
            a.this.a.post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(16539);
                if (a.3.this.a != null) {
                  a.3.this.a.removeCallbacksAndMessages(null);
                }
                if (a.3.this.b != null)
                {
                  if (Build.VERSION.SDK_INT >= 18)
                  {
                    a.3.this.b.quitSafely();
                    AppMethodBeat.o(16539);
                    return;
                  }
                  a.3.this.b.quit();
                }
                AppMethodBeat.o(16539);
              }
            });
            AppMethodBeat.o(16525);
          }
        });
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(16512);
    }
  }
  
  protected void b(int paramInt)
  {
    AppMethodBeat.i(16520);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(16520);
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221414);
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt1;
        localMessage.arg1 = paramInt2;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(221414);
    }
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16516);
    try
    {
      if (this.c != null)
      {
        Message localMessage = new Message();
        localMessage.what = paramInt1;
        localMessage.arg1 = paramInt2;
        localMessage.arg2 = paramInt3;
        this.c.sendMessage(localMessage);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(16516);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    AppMethodBeat.i(221417);
    if (paramBoolean)
    {
      if (this.f < this.g)
      {
        i1 = this.f;
        this.m = i1;
        if (this.f >= this.g) {
          break label112;
        }
      }
      label112:
      for (i1 = this.g;; i1 = this.f)
      {
        this.n = i1;
        TXCLog.i("TXCScreenCapture", String.format(Locale.ENGLISH, "reset screen capture isPortrait[%b] output size[%d/%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.m), Integer.valueOf(this.n) }));
        AppMethodBeat.o(221417);
        return;
        i1 = this.g;
        break;
      }
    }
    if (this.f < this.g)
    {
      i1 = this.g;
      label136:
      this.m = i1;
      if (this.f >= this.g) {
        break label173;
      }
    }
    label173:
    for (int i1 = this.f;; i1 = this.g)
    {
      this.n = i1;
      break;
      i1 = this.f;
      break label136;
    }
  }
  
  protected b c()
  {
    AppMethodBeat.i(221413);
    if (this.d == null)
    {
      AppMethodBeat.o(221413);
      return null;
    }
    b localb = (b)this.d.get();
    AppMethodBeat.o(221413);
    return localb;
  }
  
  protected void c(int paramInt)
  {
    AppMethodBeat.i(221415);
    a locala = d();
    if ((locala != null) && (paramInt == 0)) {
      locala.onScreenCaptureStarted();
    }
    AppMethodBeat.o(221415);
  }
  
  public static abstract interface a
  {
    public abstract void onScreenCapturePaused();
    
    public abstract void onScreenCaptureResumed();
    
    public abstract void onScreenCaptureStarted();
    
    public abstract void onScreenCaptureStopped(int paramInt);
  }
  
  protected class b
    extends Handler
  {
    public int a;
    public int[] b;
    public Surface c;
    public SurfaceTexture d;
    public int e;
    public int f;
    public int g;
    protected boolean h;
    protected long i;
    protected long j;
    protected com.tencent.liteav.basic.c.b k;
    protected i l;
    float[] m;
    private boolean o;
    
    public b(Looper paramLooper, a parama)
    {
      super();
      AppMethodBeat.i(221384);
      this.a = 0;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = 720;
      this.f = 1280;
      this.g = 25;
      this.h = false;
      this.i = 0L;
      this.j = 0L;
      this.k = null;
      this.l = null;
      this.m = new float[16];
      this.o = true;
      TXCLog.i("TXCScreenCapture", "TXCScreenCaptureGLThreadHandler inited. hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(221384);
    }
    
    protected void a()
    {
      AppMethodBeat.i(221387);
      if ((this.o) && (this.k != null))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("EVT_MSG", "Screen recording started successfully");
        f.a(a.a(a.this), 1004, localBundle);
        a.this.c(0);
      }
      this.o = false;
      AppMethodBeat.o(221387);
    }
    
    protected void a(Message paramMessage)
    {
      AppMethodBeat.i(221386);
      this.i = 0L;
      this.j = 0L;
      if (!b())
      {
        c();
        a.this.b();
        a.this.c(20000003);
      }
      AppMethodBeat.o(221386);
    }
    
    protected void b(Message paramMessage)
    {
      AppMethodBeat.i(221388);
      a.this.i = false;
      paramMessage = a.b(a.this);
      if (paramMessage != null) {
        paramMessage.onScreenCaptureStopped(0);
      }
      paramMessage = a.this.c();
      if (paramMessage != null) {
        paramMessage.a(a.f(a.this));
      }
      c();
      AppMethodBeat.o(221388);
    }
    
    protected boolean b()
    {
      AppMethodBeat.i(221391);
      TXCLog.i("TXCScreenCapture", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) }));
      this.k = com.tencent.liteav.basic.c.b.a(null, null, null, this.e, this.f);
      if (this.k == null)
      {
        AppMethodBeat.o(221391);
        return false;
      }
      this.l = new i();
      if (!this.l.a())
      {
        AppMethodBeat.o(221391);
        return false;
      }
      this.l.a(true);
      this.l.a(this.e, this.f);
      this.l.a(l.e, l.a(k.a, false, false));
      e();
      AppMethodBeat.o(221391);
      return true;
    }
    
    protected void c()
    {
      AppMethodBeat.i(221392);
      d();
      if (this.l != null)
      {
        this.l.d();
        this.l = null;
      }
      if (this.k != null)
      {
        this.k.c();
        this.k = null;
      }
      AppMethodBeat.o(221392);
    }
    
    protected void c(Message paramMessage)
    {
      AppMethodBeat.i(221389);
      a.this.a(102, 5L);
      if (!a.this.i)
      {
        AppMethodBeat.o(221389);
        return;
      }
      if (this.k == null)
      {
        TXCLog.e("TXCScreenCapture", "eglhelper is null");
        AppMethodBeat.o(221389);
        return;
      }
      if (!this.h)
      {
        this.i = 0L;
        this.j = System.nanoTime();
        AppMethodBeat.o(221389);
        return;
      }
      long l1 = System.nanoTime();
      if (l1 < this.j + this.i * 1000L * 1000L * 1000L / this.g)
      {
        AppMethodBeat.o(221389);
        return;
      }
      if (this.j == 0L) {
        this.j = l1;
      }
      for (;;)
      {
        this.i += 1L;
        if ((this.d != null) && (this.b != null)) {
          break;
        }
        AppMethodBeat.o(221389);
        return;
        if (l1 > this.j + 1000000000L)
        {
          this.i = 0L;
          this.j = l1;
        }
      }
      this.d.getTransformMatrix(this.m);
      try
      {
        this.d.updateTexImage();
        this.l.a(this.m);
        GLES20.glViewport(0, 0, this.e, this.f);
        int i1 = this.l.b(this.b[0]);
        a.this.a(0, this.k.d(), i1, this.e, this.f, TXCTimeUtil.getTimeTick());
        AppMethodBeat.o(221389);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          TXCLog.e("TXCScreenCapture", "onMsgRend Exception " + paramMessage.getMessage());
        }
      }
    }
    
    protected void d()
    {
      AppMethodBeat.i(221393);
      new e(Looper.getMainLooper()).a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221426);
          c.a(a.g(a.this)).a(a.b.this.c);
          AppMethodBeat.o(221426);
        }
      });
      if (this.c != null)
      {
        this.c.release();
        this.c = null;
      }
      if (this.d != null)
      {
        this.d.setOnFrameAvailableListener(null);
        this.d.release();
        this.h = false;
        this.d = null;
      }
      if (this.b != null)
      {
        GLES20.glDeleteTextures(1, this.b, 0);
        this.b = null;
      }
      AppMethodBeat.o(221393);
    }
    
    protected void d(Message paramMessage)
    {
      if (paramMessage == null) {
        return;
      }
      if (paramMessage.arg1 <= 0) {}
      for (int i1 = 1;; i1 = paramMessage.arg1)
      {
        this.g = i1;
        this.i = 0L;
        this.j = 0L;
        return;
      }
    }
    
    protected void e()
    {
      AppMethodBeat.i(221394);
      this.b = new int[1];
      this.b[0] = j.b();
      if (this.b[0] <= 0)
      {
        this.b = null;
        AppMethodBeat.o(221394);
        return;
      }
      this.d = new SurfaceTexture(this.b[0]);
      this.c = new Surface(this.d);
      this.d.setDefaultBufferSize(this.e, this.f);
      this.d.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
      {
        public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(221421);
          a.this.a(104, new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(221407);
              a.b.this.h = true;
              a.this.b(102);
              AppMethodBeat.o(221407);
            }
          });
          paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
          AppMethodBeat.o(221421);
        }
      });
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221427);
          c.a(a.g(a.this)).a(a.b.this.c, a.b.this.e, a.b.this.f, a.h(a.this));
          AppMethodBeat.o(221427);
        }
      });
      AppMethodBeat.o(221394);
    }
    
    protected void e(Message paramMessage)
    {
      AppMethodBeat.i(221390);
      if (paramMessage == null)
      {
        AppMethodBeat.o(221390);
        return;
      }
      this.e = paramMessage.arg1;
      this.f = paramMessage.arg2;
      d();
      this.l.a(this.e, this.f);
      e();
      TXCLog.i("TXCScreenCapture", String.format("set screen capture size[%d/%d]", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(a.e(a.this)) }));
      AppMethodBeat.o(221390);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(221385);
      if (paramMessage == null)
      {
        AppMethodBeat.o(221385);
        return;
      }
      if ((this.a != a.this.e) && (101 != paramMessage.what))
      {
        AppMethodBeat.o(221385);
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
        AppMethodBeat.o(221385);
        return;
        a(paramMessage);
        continue;
        try
        {
          c(paramMessage);
        }
        catch (Exception localException)
        {
          TXCLog.e("TXCScreenCapture", "render failed.", localException);
        }
        continue;
        b(paramMessage);
        continue;
        d(paramMessage);
        continue;
        e(paramMessage);
        continue;
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a
 * JD-Core Version:    0.7.0.1
 */