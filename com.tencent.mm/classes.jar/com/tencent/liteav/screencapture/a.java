package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class a
{
  protected Handler a;
  protected volatile HandlerThread b;
  protected volatile a.a c;
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
    AppMethodBeat.i(66744);
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
    this.o = new a.1(this);
    this.n = paramContext;
    this.a = new Handler(Looper.getMainLooper());
    this.k = paramBoolean;
    if (Build.VERSION.SDK_INT >= 21) {
      b.a().a(paramContext);
    }
    AppMethodBeat.o(66744);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66745);
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
      TXCLog.d("ScreenCapture", String.format("start screen capture orientation[%d] input size[%d/%d] output size[%d/%d]", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.f), Integer.valueOf(this.g) }));
      this.h = paramInt3;
      if (Build.VERSION.SDK_INT >= 21) {
        break;
      }
      a(20000004, null);
      AppMethodBeat.o(66745);
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
    AppMethodBeat.o(66745);
    return 0;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 163	com/tencent/liteav/screencapture/a:b	()V
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: new 165	android/os/HandlerThread
    //   15: dup
    //   16: ldc 167
    //   18: invokespecial 170	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   21: putfield 48	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   24: aload_0
    //   25: getfield 48	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   28: invokevirtual 173	android/os/HandlerThread:start	()V
    //   31: aload_0
    //   32: new 6	com/tencent/liteav/screencapture/a$a
    //   35: dup
    //   36: aload_0
    //   37: aload_0
    //   38: getfield 48	com/tencent/liteav/screencapture/a:b	Landroid/os/HandlerThread;
    //   41: invokevirtual 176	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   44: aload_0
    //   45: invokespecial 179	com/tencent/liteav/screencapture/a$a:<init>	(Lcom/tencent/liteav/screencapture/a;Landroid/os/Looper;Lcom/tencent/liteav/screencapture/a;)V
    //   48: putfield 50	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 54	com/tencent/liteav/screencapture/a:e	I
    //   56: iconst_1
    //   57: iadd
    //   58: putfield 54	com/tencent/liteav/screencapture/a:e	I
    //   61: aload_0
    //   62: getfield 50	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   65: aload_0
    //   66: getfield 54	com/tencent/liteav/screencapture/a:e	I
    //   69: putfield 181	com/tencent/liteav/screencapture/a$a:a	I
    //   72: aload_0
    //   73: getfield 50	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   76: aload_0
    //   77: getfield 68	com/tencent/liteav/screencapture/a:l	I
    //   80: putfield 182	com/tencent/liteav/screencapture/a$a:e	I
    //   83: aload_0
    //   84: getfield 50	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   87: aload_0
    //   88: getfield 70	com/tencent/liteav/screencapture/a:m	I
    //   91: putfield 183	com/tencent/liteav/screencapture/a$a:f	I
    //   94: aload_0
    //   95: getfield 50	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   98: astore_2
    //   99: aload_0
    //   100: getfield 60	com/tencent/liteav/screencapture/a:h	I
    //   103: ifgt +24 -> 127
    //   106: iconst_1
    //   107: istore_1
    //   108: aload_2
    //   109: iload_1
    //   110: putfield 184	com/tencent/liteav/screencapture/a$a:g	I
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_0
    //   116: bipush 100
    //   118: invokevirtual 186	com/tencent/liteav/screencapture/a:a	(I)V
    //   121: ldc 161
    //   123: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    //   127: aload_0
    //   128: getfield 60	com/tencent/liteav/screencapture/a:h	I
    //   131: istore_1
    //   132: goto -24 -> 108
    //   135: astore_2
    //   136: aload_0
    //   137: monitorexit
    //   138: ldc 161
    //   140: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_2
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	a
    //   107	25	1	i1	int
    //   98	11	2	locala	a.a
    //   135	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	106	135	finally
    //   108	115	135	finally
    //   127	132	135	finally
    //   136	138	135	finally
  }
  
  protected void a(int paramInt)
  {
    AppMethodBeat.i(66755);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessage(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(66755);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(66759);
    c localc = c();
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
    }
    AppMethodBeat.o(66759);
  }
  
  protected void a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(66754);
    try
    {
      if (this.c != null) {
        this.c.sendEmptyMessageDelayed(paramInt, paramLong);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(66754);
    }
  }
  
  protected void a(int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(66757);
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
      AppMethodBeat.o(66757);
    }
  }
  
  protected void a(int paramInt, EGLContext paramEGLContext)
  {
    AppMethodBeat.i(66758);
    c localc = c();
    if (localc != null) {
      localc.a(paramInt, paramEGLContext);
    }
    AppMethodBeat.o(66758);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(146453);
    b.a().a(parama);
    AppMethodBeat.o(146453);
  }
  
  public void a(c paramc)
  {
    AppMethodBeat.i(66748);
    this.d = new WeakReference(paramc);
    AppMethodBeat.o(66748);
  }
  
  public void a(Object paramObject)
  {
    AppMethodBeat.i(66746);
    b.a().b(this.o);
    this.j = paramObject;
    b();
    AppMethodBeat.o(66746);
  }
  
  public void a(Runnable paramRunnable)
  {
    try
    {
      AppMethodBeat.i(66750);
      if (this.c != null) {
        this.c.post(paramRunnable);
      }
      AppMethodBeat.o(66750);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 245
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 50	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   11: ifnull +28 -> 39
    //   14: aload_0
    //   15: getfield 50	com/tencent/liteav/screencapture/a:c	Lcom/tencent/liteav/screencapture/a$a;
    //   18: new 247	com/tencent/liteav/screencapture/a$2
    //   21: dup
    //   22: aload_0
    //   23: iload_1
    //   24: invokespecial 250	com/tencent/liteav/screencapture/a$2:<init>	(Lcom/tencent/liteav/screencapture/a;Z)V
    //   27: invokevirtual 243	com/tencent/liteav/screencapture/a$a:post	(Ljava/lang/Runnable;)Z
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: ldc 245
    //   35: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload_0
    //   40: iload_1
    //   41: putfield 62	com/tencent/liteav/screencapture/a:i	Z
    //   44: goto -13 -> 31
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: ldc 245
    //   52: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	a
    //   0	57	1	paramBoolean	boolean
    //   47	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	31	47	finally
    //   31	33	47	finally
    //   39	44	47	finally
    //   48	50	47	finally
  }
  
  protected void b()
  {
    AppMethodBeat.i(66752);
    try
    {
      this.e += 1;
      if (this.c != null)
      {
        HandlerThread localHandlerThread = this.b;
        a(101, new a.3(this, this.c, localHandlerThread));
      }
      this.c = null;
      this.b = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(66752);
    }
  }
  
  protected void b(int paramInt)
  {
    AppMethodBeat.i(66760);
    if (paramInt == 0)
    {
      if (this.f < this.g)
      {
        i1 = this.f;
        this.l = i1;
        if (this.f >= this.g) {
          break label109;
        }
      }
      label109:
      for (i1 = this.g;; i1 = this.f)
      {
        this.m = i1;
        TXCLog.d("ScreenCapture", String.format("reset screen capture angle[%d] output size[%d/%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.l), Integer.valueOf(this.m) }));
        AppMethodBeat.o(66760);
        return;
        i1 = this.g;
        break;
      }
    }
    if (this.f < this.g)
    {
      i1 = this.g;
      label133:
      this.l = i1;
      if (this.f >= this.g) {
        break label170;
      }
    }
    label170:
    for (int i1 = this.f;; i1 = this.g)
    {
      this.m = i1;
      break;
      i1 = this.f;
      break label133;
    }
  }
  
  protected void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66756);
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
      AppMethodBeat.o(66756);
    }
  }
  
  protected c c()
  {
    AppMethodBeat.i(66753);
    if (this.d == null)
    {
      AppMethodBeat.o(66753);
      return null;
    }
    c localc = (c)this.d.get();
    AppMethodBeat.o(66753);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a
 * JD-Core Version:    0.7.0.1
 */