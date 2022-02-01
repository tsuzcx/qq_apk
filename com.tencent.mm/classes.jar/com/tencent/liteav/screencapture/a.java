package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.d.j;
import com.tencent.liteav.basic.d.k;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class a
{
  protected Handler a;
  protected volatile HandlerThread b;
  protected volatile a c;
  protected volatile WeakReference<c> d;
  protected volatile int e;
  protected int f;
  protected int g;
  protected int h;
  protected boolean i;
  private Object j;
  private boolean k;
  private int l;
  private int m;
  private Context n;
  private b.a o;
  
  public a(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(16504);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = 0;
    this.f = 720;
    this.g = 1280;
    this.h = 20;
    this.i = false;
    this.j = null;
    this.k = false;
    this.l = this.f;
    this.m = this.g;
    this.n = null;
    this.o = new b.a()
    {
      public void a(int paramAnonymousInt)
      {
        AppMethodBeat.i(16502);
        a.this.b(paramAnonymousInt);
        a.this.b(105, a.a(a.this), a.b(a.this));
        AppMethodBeat.o(16502);
      }
    };
    this.n = paramContext;
    this.a = new Handler(Looper.getMainLooper());
    this.k = paramBoolean;
    if (Build.VERSION.SDK_INT >= 21) {
      b.a().a(paramContext);
    }
    AppMethodBeat.o(16504);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16505);
    int i1;
    if (this.k)
    {
      i1 = ((WindowManager)this.n.getSystemService("window")).getDefaultDisplay().getRotation();
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
      TXCLog.i("ScreenCapture", String.format("start screen capture orientation[%d] input size[%d/%d] output size[%d/%d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.f), Integer.valueOf(this.g) }));
      this.h = paramInt3;
      if (Build.VERSION.SDK_INT >= 21) {
        break;
      }
      a(20000004, null);
      AppMethodBeat.o(16505);
      return 20000004;
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
        i1 = 0;
      }
    }
    this.l = this.f;
    this.m = this.g;
    a();
    if (this.k) {
      b.a().a(this.o);
    }
    AppMethodBeat.o(16505);
    return 0;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: sipush 16511
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 168	com/tencent/liteav/screencapture/a:b	()V
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: new 170	android/os/HandlerThread
    //   16: dup
    //   17: ldc 172
    //   19: invokespecial 175	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   22: putfield 57	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   25: aload_0
    //   26: getfield 57	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   29: invokevirtual 178	android/os/HandlerThread:start	()V
    //   32: aload_0
    //   33: new 14	com/tencent/liteav/screencapture/a$a
    //   36: dup
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 57	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   42: invokevirtual 181	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   45: aload_0
    //   46: invokespecial 184	com/tencent/liteav/screencapture/a$a:<init>	(Lcom/tencent/liteav/screencapture/a;Landroid/os/Looper;Lcom/tencent/liteav/screencapture/a;)V
    //   49: putfield 59	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 63	com/tencent/liteav/screencapture/a:e	I
    //   57: iconst_1
    //   58: iadd
    //   59: putfield 63	com/tencent/liteav/screencapture/a:e	I
    //   62: aload_0
    //   63: getfield 59	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   66: aload_0
    //   67: getfield 63	com/tencent/liteav/screencapture/a:e	I
    //   70: putfield 186	com/tencent/liteav/screencapture/a$a:a	I
    //   73: aload_0
    //   74: getfield 59	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   77: aload_0
    //   78: getfield 77	com/tencent/liteav/screencapture/a:l	I
    //   81: putfield 187	com/tencent/liteav/screencapture/a$a:e	I
    //   84: aload_0
    //   85: getfield 59	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   88: aload_0
    //   89: getfield 79	com/tencent/liteav/screencapture/a:m	I
    //   92: putfield 188	com/tencent/liteav/screencapture/a$a:f	I
    //   95: aload_0
    //   96: getfield 59	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   99: astore_2
    //   100: aload_0
    //   101: getfield 69	com/tencent/liteav/screencapture/a:h	I
    //   104: ifgt +25 -> 129
    //   107: iconst_1
    //   108: istore_1
    //   109: aload_2
    //   110: iload_1
    //   111: putfield 189	com/tencent/liteav/screencapture/a$a:g	I
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_0
    //   117: bipush 100
    //   119: invokevirtual 191	com/tencent/liteav/screencapture/a:a	(I)V
    //   122: sipush 16511
    //   125: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: aload_0
    //   130: getfield 69	com/tencent/liteav/screencapture/a:h	I
    //   133: istore_1
    //   134: goto -25 -> 109
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: sipush 16511
    //   143: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_2
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	a
    //   108	26	1	i1	int
    //   99	11	2	locala	a
    //   137	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	107	137	finally
    //   109	116	137	finally
    //   129	134	137	finally
    //   138	140	137	finally
  }
  
  protected void a(int paramInt)
  {
    AppMethodBeat.i(16515);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(16515);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(16519);
    c localc = c();
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
    }
    AppMethodBeat.o(16519);
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
  
  protected void a(int paramInt, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(16518);
    c localc = c();
    if (localc != null) {
      localc.a(paramInt, paramEGLContext);
    }
    AppMethodBeat.o(16518);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(16509);
    b.a().a(parama);
    AppMethodBeat.o(16509);
  }
  
  public void a(c paramc)
  {
    AppMethodBeat.i(16508);
    this.d = new WeakReference(paramc);
    AppMethodBeat.o(16508);
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(16506);
    b.a().b(this.o);
    this.j = paramObject;
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
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 59	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   12: ifnull +29 -> 41
    //   15: aload_0
    //   16: getfield 59	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   19: new 8	com/tencent/liteav/screencapture/a$2
    //   22: dup
    //   23: aload_0
    //   24: iload_1
    //   25: invokespecial 243	com/tencent/liteav/screencapture/a$2:<init>	(Lcom/tencent/liteav/screencapture/a;Z)V
    //   28: invokevirtual 239	com/tencent/liteav/screencapture/a$a:post	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: aload_0
    //   33: monitorexit
    //   34: sipush 16507
    //   37: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: aload_0
    //   42: iload_1
    //   43: putfield 71	com/tencent/liteav/screencapture/a:i	Z
    //   46: goto -14 -> 32
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: sipush 16507
    //   55: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	a
    //   0	60	1	paramBoolean	boolean
    //   49	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	32	49	finally
    //   32	34	49	finally
    //   41	46	49	finally
    //   50	52	49	finally
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
    if (paramInt == 0)
    {
      if (this.f < this.g)
      {
        i1 = this.f;
        this.l = i1;
        if (this.f >= this.g) {
          break label108;
        }
      }
      label108:
      for (i1 = this.g;; i1 = this.f)
      {
        this.m = i1;
        TXCLog.i("ScreenCapture", String.format("reset screen capture angle[%d] output size[%d/%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.l), Integer.valueOf(this.m) }));
        AppMethodBeat.o(16520);
        return;
        i1 = this.g;
        break;
      }
    }
    if (this.f < this.g)
    {
      i1 = this.g;
      label132:
      this.l = i1;
      if (this.f >= this.g) {
        break label169;
      }
    }
    label169:
    for (int i1 = this.f;; i1 = this.g)
    {
      this.m = i1;
      break;
      i1 = this.f;
      break label132;
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
  
  protected c c()
  {
    AppMethodBeat.i(16513);
    if (this.d == null)
    {
      AppMethodBeat.o(16513);
      return null;
    }
    c localc = (c)this.d.get();
    AppMethodBeat.o(16513);
    return localc;
  }
  
  protected class a
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
    protected com.tencent.liteav.basic.d.b k;
    protected h l;
    float[] m;
    
    public a(Looper paramLooper, a parama)
    {
      super();
      AppMethodBeat.i(16528);
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
      AppMethodBeat.o(16528);
    }
    
    protected void a(Message paramMessage)
    {
      AppMethodBeat.i(16530);
      this.i = 0L;
      this.j = 0L;
      if (!a())
      {
        b();
        a.this.b();
        a.this.a(20000003, null);
        AppMethodBeat.o(16530);
        return;
      }
      a.this.a(0, this.k.d());
      AppMethodBeat.o(16530);
    }
    
    protected boolean a()
    {
      AppMethodBeat.i(16534);
      TXCLog.i("ScreenCapture", String.format("init egl size[%d/%d]", new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.f) }));
      this.k = com.tencent.liteav.basic.d.b.a(null, null, null, this.e, this.f);
      if (this.k == null)
      {
        AppMethodBeat.o(16534);
        return false;
      }
      this.l = new h();
      if (!this.l.a())
      {
        AppMethodBeat.o(16534);
        return false;
      }
      this.l.a(true);
      this.l.a(this.e, this.f);
      this.l.a(k.e, k.a(j.a, false, false));
      d();
      AppMethodBeat.o(16534);
      return true;
    }
    
    protected void b()
    {
      AppMethodBeat.i(16535);
      c();
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
      AppMethodBeat.o(16535);
    }
    
    protected void b(Message paramMessage)
    {
      AppMethodBeat.i(16531);
      paramMessage = a.this.c();
      if (paramMessage != null) {
        paramMessage.a(a.c(a.this));
      }
      b();
      AppMethodBeat.o(16531);
    }
    
    protected void c()
    {
      AppMethodBeat.i(16536);
      if (this.d != null)
      {
        this.d.setOnFrameAvailableListener(null);
        this.d.release();
        this.h = false;
        this.d = null;
      }
      b.a().a(this.c);
      if (this.c != null)
      {
        this.c.release();
        this.c = null;
      }
      if (this.b != null)
      {
        GLES20.glDeleteTextures(1, this.b, 0);
        this.b = null;
      }
      AppMethodBeat.o(16536);
    }
    
    protected void c(Message paramMessage)
    {
      AppMethodBeat.i(16532);
      a.this.a(102, 5L);
      if (!a.this.i)
      {
        AppMethodBeat.o(16532);
        return;
      }
      if (!this.h)
      {
        this.i = 0L;
        this.j = System.nanoTime();
        AppMethodBeat.o(16532);
        return;
      }
      long l1 = System.nanoTime();
      if (l1 < this.j + this.i * 1000L * 1000L * 1000L / this.g)
      {
        AppMethodBeat.o(16532);
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
        AppMethodBeat.o(16532);
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
        a.this.a(0, i1, this.e, this.f, TXCTimeUtil.getTimeTick());
        AppMethodBeat.o(16532);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          TXCLog.e("ScreenCapture", "onMsgRend Exception " + paramMessage.getMessage());
        }
      }
    }
    
    protected void d()
    {
      AppMethodBeat.i(16537);
      this.b = new int[1];
      this.b[0] = i.b();
      if (this.b[0] <= 0)
      {
        this.b = null;
        AppMethodBeat.o(16537);
        return;
      }
      this.d = new SurfaceTexture(this.b[0]);
      this.c = new Surface(this.d);
      this.d.setDefaultBufferSize(this.e, this.f);
      this.d.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
      {
        public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(16524);
          a.this.a(104, new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(16526);
              a.a.this.h = true;
              a.this.a(102);
              AppMethodBeat.o(16526);
            }
          });
          paramAnonymousSurfaceTexture.setOnFrameAvailableListener(null);
          AppMethodBeat.o(16524);
        }
      });
      b.a().a(this.c, this.e, this.f);
      AppMethodBeat.o(16537);
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
    
    protected void e(Message paramMessage)
    {
      AppMethodBeat.i(16533);
      if (paramMessage == null)
      {
        AppMethodBeat.o(16533);
        return;
      }
      this.e = paramMessage.arg1;
      this.f = paramMessage.arg2;
      c();
      this.l.a(this.e, this.f);
      d();
      TXCLog.i("ScreenCapture", String.format("set screen capture size[%d/%d]", new Object[] { Integer.valueOf(a.a(a.this)), Integer.valueOf(a.b(a.this)) }));
      AppMethodBeat.o(16533);
    }
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(16529);
      if (paramMessage == null)
      {
        AppMethodBeat.o(16529);
        return;
      }
      if ((this.a != a.this.e) && (101 != paramMessage.what))
      {
        AppMethodBeat.o(16529);
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
        AppMethodBeat.o(16529);
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
        continue;
        d(paramMessage);
        continue;
        e(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a
 * JD-Core Version:    0.7.0.1
 */