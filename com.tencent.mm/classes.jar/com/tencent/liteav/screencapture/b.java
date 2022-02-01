package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(21)
public class b
{
  private static final String b;
  private static b c;
  private byte _hellAccFlag_;
  MediaProjection.Callback a;
  private HashMap<Surface, VirtualDisplay> d;
  private Context e;
  private MediaProjectionManager f;
  private MediaProjection g;
  private HashSet<b> h;
  private int i;
  private Handler j;
  private HashSet<Object> k;
  private boolean l;
  private WeakReference<com.tencent.liteav.basic.c.a> m;
  private HandlerThread n;
  private Handler o;
  private int p;
  private HashSet<a> q;
  private Runnable r;
  private BroadcastReceiver s;
  
  static
  {
    AppMethodBeat.i(16558);
    b = b.class.getSimpleName();
    c = new b();
    AppMethodBeat.o(16558);
  }
  
  private b()
  {
    AppMethodBeat.i(16540);
    this.d = new HashMap();
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = new HashSet();
    this.i = 1;
    this.j = null;
    this.k = new HashSet();
    this.l = false;
    this.m = null;
    this.n = new HandlerThread("TXCScreenCaptureImplSingleton");
    this.o = null;
    this.p = 0;
    this.q = new HashSet();
    this.r = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16523);
        b.a(b.this);
        b.a locala;
        try
        {
          if (b.b(b.this) == null) {
            return;
          }
          int i = ((WindowManager)b.b(b.this).getSystemService("window")).getDefaultDisplay().getRotation();
          if ((i != 0) && (i != 2)) {
            break label181;
          }
          if (b.c(b.this) != 0)
          {
            TXCLog.i(b.c(), "ORIENTATION_PORTRAIT, mDelegateSet size = " + b.d(b.this).size());
            Iterator localIterator1 = b.d(b.this).iterator();
            while (localIterator1.hasNext())
            {
              locala = (b.a)localIterator1.next();
              if (locala != null) {
                locala.a(0);
              }
            }
          }
          b.a(b.this, 0);
        }
        finally
        {
          AppMethodBeat.o(16523);
        }
        AppMethodBeat.o(16523);
        return;
        label181:
        if (b.c(b.this) != 90)
        {
          TXCLog.i(b.c(), "ORIENTATION_LANDSCAPE, mDelegateSet size = " + b.d(b.this).size());
          Iterator localIterator2 = b.d(b.this).iterator();
          while (localIterator2.hasNext())
          {
            locala = (b.a)localIterator2.next();
            if (locala != null) {
              locala.a(90);
            }
          }
        }
        b.a(b.this, 90);
        AppMethodBeat.o(16523);
      }
    };
    this.a = new MediaProjection.Callback()
    {
      public void onStop()
      {
        AppMethodBeat.i(16538);
        if (!b.e(b.this))
        {
          AppMethodBeat.o(16538);
          return;
        }
        b.a(b.this, false);
        AppMethodBeat.o(16538);
      }
    };
    this.s = new b.7(this);
    this.j = new Handler(Looper.getMainLooper());
    this.n.start();
    this.o = new Handler(this.n.getLooper());
    AppMethodBeat.o(16540);
  }
  
  public static b a()
  {
    return c;
  }
  
  /* Error */
  @TargetApi(21)
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: sipush 16554
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 95	com/tencent/liteav/screencapture/b:e	Landroid/content/Context;
    //   12: ifnull +14 -> 26
    //   15: aload_0
    //   16: getfield 95	com/tencent/liteav/screencapture/b:e	Landroid/content/Context;
    //   19: aload_0
    //   20: getfield 142	com/tencent/liteav/screencapture/b:s	Landroid/content/BroadcastReceiver;
    //   23: invokevirtual 170	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   26: iload_1
    //   27: sipush 1001
    //   30: if_icmpne +16 -> 46
    //   33: iload_2
    //   34: iconst_m1
    //   35: if_icmpne +11 -> 46
    //   38: aload_0
    //   39: getfield 106	com/tencent/liteav/screencapture/b:i	I
    //   42: iconst_2
    //   43: if_icmpeq +29 -> 72
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 106	com/tencent/liteav/screencapture/b:i	I
    //   51: aload_0
    //   52: getfield 114	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   55: sipush -1308
    //   58: ldc 172
    //   60: invokestatic 177	com/tencent/liteav/basic/util/d:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   63: aload_0
    //   64: monitorexit
    //   65: sipush 16554
    //   68: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: return
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 97	com/tencent/liteav/screencapture/b:f	Landroid/media/projection/MediaProjectionManager;
    //   77: iload_2
    //   78: aload_3
    //   79: invokevirtual 183	android/media/projection/MediaProjectionManager:getMediaProjection	(ILandroid/content/Intent;)Landroid/media/projection/MediaProjection;
    //   82: putfield 99	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   85: aload_0
    //   86: getfield 99	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   89: aload_0
    //   90: getfield 137	com/tencent/liteav/screencapture/b:a	Landroid/media/projection/MediaProjection$Callback;
    //   93: aload_0
    //   94: getfield 108	com/tencent/liteav/screencapture/b:j	Landroid/os/Handler;
    //   97: invokevirtual 189	android/media/projection/MediaProjection:registerCallback	(Landroid/media/projection/MediaProjection$Callback;Landroid/os/Handler;)V
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield 112	com/tencent/liteav/screencapture/b:l	Z
    //   105: aload_0
    //   106: getfield 104	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   109: invokevirtual 193	java/util/HashSet:size	()I
    //   112: ifne +29 -> 141
    //   115: aload_0
    //   116: getfield 114	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   119: sipush -1308
    //   122: ldc 172
    //   124: invokestatic 177	com/tencent/liteav/basic/util/d:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   127: aload_0
    //   128: iconst_1
    //   129: putfield 106	com/tencent/liteav/screencapture/b:i	I
    //   132: aload_0
    //   133: monitorexit
    //   134: sipush 16554
    //   137: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: aload_0
    //   142: getfield 104	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   145: invokevirtual 197	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   148: astore_3
    //   149: aload_3
    //   150: invokeinterface 203 1 0
    //   155: ifeq +158 -> 313
    //   158: aload_3
    //   159: invokeinterface 207 1 0
    //   164: checkcast 21	com/tencent/liteav/screencapture/b$b
    //   167: astore 4
    //   169: aload 4
    //   171: ifnull -22 -> 149
    //   174: aload 4
    //   176: getfield 210	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   179: ifnull -30 -> 149
    //   182: aload 4
    //   184: getfield 212	com/tencent/liteav/screencapture/b$b:b	I
    //   187: ifeq -38 -> 149
    //   190: aload 4
    //   192: getfield 214	com/tencent/liteav/screencapture/b$b:c	I
    //   195: ifeq -46 -> 149
    //   198: aload_0
    //   199: getfield 99	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   202: ldc 216
    //   204: aload 4
    //   206: getfield 212	com/tencent/liteav/screencapture/b$b:b	I
    //   209: aload 4
    //   211: getfield 214	com/tencent/liteav/screencapture/b$b:c	I
    //   214: iconst_1
    //   215: iconst_1
    //   216: aload 4
    //   218: getfield 210	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   221: aconst_null
    //   222: aconst_null
    //   223: invokevirtual 220	android/media/projection/MediaProjection:createVirtualDisplay	(Ljava/lang/String;IIIILandroid/view/Surface;Landroid/hardware/display/VirtualDisplay$Callback;Landroid/os/Handler;)Landroid/hardware/display/VirtualDisplay;
    //   226: astore 5
    //   228: aload 5
    //   230: ifnonnull +29 -> 259
    //   233: aload_0
    //   234: getfield 114	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   237: sipush -1308
    //   240: ldc 172
    //   242: invokestatic 177	com/tencent/liteav/basic/util/d:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   245: aload_0
    //   246: iconst_1
    //   247: putfield 106	com/tencent/liteav/screencapture/b:i	I
    //   250: aload_0
    //   251: monitorexit
    //   252: sipush 16554
    //   255: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: return
    //   259: aload_0
    //   260: getfield 93	com/tencent/liteav/screencapture/b:d	Ljava/util/HashMap;
    //   263: aload 4
    //   265: getfield 210	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   268: aload 5
    //   270: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: goto -125 -> 149
    //   277: astore_3
    //   278: aload_0
    //   279: monitorexit
    //   280: sipush 16554
    //   283: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_3
    //   287: athrow
    //   288: astore_3
    //   289: aload_0
    //   290: iconst_1
    //   291: putfield 106	com/tencent/liteav/screencapture/b:i	I
    //   294: aload_0
    //   295: getfield 114	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   298: sipush -1308
    //   301: ldc 172
    //   303: invokestatic 177	com/tencent/liteav/basic/util/d:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   306: sipush 16554
    //   309: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: return
    //   313: aload_0
    //   314: getfield 104	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   317: invokevirtual 227	java/util/HashSet:clear	()V
    //   320: aload_0
    //   321: iconst_3
    //   322: putfield 106	com/tencent/liteav/screencapture/b:i	I
    //   325: aload_0
    //   326: monitorexit
    //   327: aload_0
    //   328: getfield 114	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   331: ifnull +25 -> 356
    //   334: new 144	android/os/Handler
    //   337: dup
    //   338: invokestatic 150	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   341: invokespecial 153	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   344: new 16	com/tencent/liteav/screencapture/b$6
    //   347: dup
    //   348: aload_0
    //   349: invokespecial 228	com/tencent/liteav/screencapture/b$6:<init>	(Lcom/tencent/liteav/screencapture/b;)V
    //   352: invokevirtual 232	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   355: pop
    //   356: sipush 16554
    //   359: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: return
    //   363: astore 4
    //   365: goto -339 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	b
    //   0	368	1	paramInt1	int
    //   0	368	2	paramInt2	int
    //   0	368	3	paramIntent	Intent
    //   167	97	4	localb	b
    //   363	1	4	localException	Exception
    //   226	43	5	localVirtualDisplay	VirtualDisplay
    // Exception table:
    //   from	to	target	type
    //   8	26	277	finally
    //   38	46	277	finally
    //   46	65	277	finally
    //   72	134	277	finally
    //   141	149	277	finally
    //   149	169	277	finally
    //   174	228	277	finally
    //   233	252	277	finally
    //   259	274	277	finally
    //   278	280	277	finally
    //   313	327	277	finally
    //   6	8	288	java/lang/Exception
    //   280	288	288	java/lang/Exception
    //   8	26	363	java/lang/Exception
  }
  
  private void d()
  {
    AppMethodBeat.i(16546);
    this.i = 4;
    this.j.postDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16501);
        synchronized (b.this)
        {
          if (b.f(b.this).size() == 0) {
            b.g(b.this);
          }
          AppMethodBeat.o(16501);
          return;
        }
      }
    }, 1000L);
    AppMethodBeat.o(16546);
  }
  
  private void e()
  {
    AppMethodBeat.i(16547);
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
    {
      VirtualDisplay localVirtualDisplay = (VirtualDisplay)localIterator.next();
      if (localVirtualDisplay != null) {
        localVirtualDisplay.release();
      }
    }
    this.d.clear();
    this.k.clear();
    i();
    AppMethodBeat.o(16547);
  }
  
  private void f()
  {
    AppMethodBeat.i(16548);
    this.o.postDelayed(this.r, 50L);
    AppMethodBeat.o(16548);
  }
  
  private void g()
  {
    AppMethodBeat.i(16549);
    this.o.removeCallbacks(this.r);
    AppMethodBeat.o(16549);
  }
  
  @TargetApi(21)
  private boolean h()
  {
    AppMethodBeat.i(16552);
    if (this.i != 1)
    {
      AppMethodBeat.o(16552);
      return true;
    }
    if ((this.e == null) || (this.f == null))
    {
      AppMethodBeat.o(16552);
      return false;
    }
    f();
    this.i = 2;
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("TXScreenCapture.OnAssistantActivityResult");
    this.e.registerReceiver(this.s, (IntentFilter)localObject1);
    Object localObject2 = new Intent(this.e, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
    ((Intent)localObject2).addFlags(268435456);
    ((Intent)localObject2).putExtra("TXScreenCapture.ScreenCaptureIntent", this.f.createScreenCaptureIntent());
    localObject1 = this.e;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/liteav/screencapture/b", "h", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/liteav/screencapture/b", "h", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(16552);
    return true;
  }
  
  @TargetApi(21)
  private void i()
  {
    AppMethodBeat.i(16553);
    if (!this.k.isEmpty())
    {
      AppMethodBeat.o(16553);
      return;
    }
    this.l = false;
    if (this.g != null)
    {
      this.g.stop();
      this.g.unregisterCallback(this.a);
    }
    try
    {
      if (this.e != null) {
        this.e.unregisterReceiver(this.s);
      }
      label71:
      this.g = null;
      this.i = 1;
      g();
      AppMethodBeat.o(16553);
      return;
    }
    catch (Exception localException)
    {
      break label71;
    }
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(16542);
    try
    {
      if (this.e != paramContext)
      {
        b();
        this.f = null;
        this.e = paramContext;
        if (this.e == null) {
          return;
        }
        if (this.f == null) {
          this.f = ((MediaProjectionManager)this.e.getSystemService("media_projection"));
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(16542);
    }
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(16544);
    try
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb != null) && (localb.a != null) && (localb.b != 0) && (localb.c != 0) && (localb.a == paramSurface)) {
          this.h.remove(localb);
        }
      }
      if (!this.d.containsKey(paramSurface)) {
        return;
      }
      ((VirtualDisplay)this.d.get(paramSurface)).release();
      this.d.remove(paramSurface);
      d();
      return;
    }
    finally
    {
      AppMethodBeat.o(16544);
    }
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(16541);
    if (parama == null)
    {
      this.m = null;
      AppMethodBeat.o(16541);
      return;
    }
    this.m = new WeakReference(parama);
    AppMethodBeat.o(16541);
  }
  
  public void a(final a parama)
  {
    AppMethodBeat.i(16550);
    this.j.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16527);
        b.d(b.this).add(parama);
        AppMethodBeat.o(16527);
      }
    });
    AppMethodBeat.o(16550);
  }
  
  /* Error */
  @TargetApi(21)
  public boolean a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: sipush 16543
    //   6: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 106	com/tencent/liteav/screencapture/b:i	I
    //   15: iconst_3
    //   16: if_icmpeq +11 -> 27
    //   19: aload_0
    //   20: getfield 106	com/tencent/liteav/screencapture/b:i	I
    //   23: iconst_4
    //   24: if_icmpne +95 -> 119
    //   27: aload_0
    //   28: getfield 99	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   31: ifnonnull +3 -> 34
    //   34: aload_0
    //   35: getfield 99	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   38: ifnull +148 -> 186
    //   41: aload_0
    //   42: iconst_1
    //   43: putfield 112	com/tencent/liteav/screencapture/b:l	Z
    //   46: aload_0
    //   47: getfield 99	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   50: ldc 216
    //   52: iload_2
    //   53: iload_3
    //   54: iconst_1
    //   55: iconst_1
    //   56: aload_1
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 220	android/media/projection/MediaProjection:createVirtualDisplay	(Ljava/lang/String;IIIILandroid/view/Surface;Landroid/hardware/display/VirtualDisplay$Callback;Landroid/os/Handler;)Landroid/hardware/display/VirtualDisplay;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnonnull +31 -> 97
    //   69: iload 4
    //   71: ifne +15 -> 86
    //   74: aload_0
    //   75: getfield 114	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   78: sipush -1308
    //   81: ldc 172
    //   83: invokestatic 177	com/tencent/liteav/basic/util/d:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   86: aload_0
    //   87: monitorexit
    //   88: sipush 16543
    //   91: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iload 4
    //   96: ireturn
    //   97: aload_0
    //   98: iconst_3
    //   99: putfield 106	com/tencent/liteav/screencapture/b:i	I
    //   102: aload_0
    //   103: getfield 93	com/tencent/liteav/screencapture/b:d	Ljava/util/HashMap;
    //   106: aload_1
    //   107: aload 6
    //   109: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: iconst_1
    //   114: istore 4
    //   116: goto -47 -> 69
    //   119: new 21	com/tencent/liteav/screencapture/b$b
    //   122: dup
    //   123: aload_0
    //   124: aconst_null
    //   125: invokespecial 392	com/tencent/liteav/screencapture/b$b:<init>	(Lcom/tencent/liteav/screencapture/b;Lcom/tencent/liteav/screencapture/b$1;)V
    //   128: astore 6
    //   130: aload 6
    //   132: iload_3
    //   133: putfield 214	com/tencent/liteav/screencapture/b$b:c	I
    //   136: aload 6
    //   138: iload_2
    //   139: putfield 212	com/tencent/liteav/screencapture/b$b:b	I
    //   142: aload 6
    //   144: aload_1
    //   145: putfield 210	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   148: aload_0
    //   149: getfield 104	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   152: aload 6
    //   154: invokevirtual 395	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload_0
    //   159: invokespecial 397	com/tencent/liteav/screencapture/b:h	()Z
    //   162: istore 5
    //   164: iload 5
    //   166: istore 4
    //   168: goto -99 -> 69
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: sipush 16543
    //   177: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: goto -114 -> 69
    //   186: iconst_0
    //   187: istore 4
    //   189: goto -21 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	b
    //   0	192	1	paramSurface	Surface
    //   0	192	2	paramInt1	int
    //   0	192	3	paramInt2	int
    //   1	187	4	bool1	boolean
    //   162	3	5	bool2	boolean
    //   62	91	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	27	171	finally
    //   27	34	171	finally
    //   34	64	171	finally
    //   74	86	171	finally
    //   86	88	171	finally
    //   97	113	171	finally
    //   119	164	171	finally
    //   172	174	171	finally
    //   11	27	182	java/lang/Exception
    //   27	34	182	java/lang/Exception
    //   34	64	182	java/lang/Exception
    //   97	113	182	java/lang/Exception
    //   119	164	182	java/lang/Exception
  }
  
  public void b()
  {
    AppMethodBeat.i(16545);
    try
    {
      e();
      return;
    }
    finally
    {
      AppMethodBeat.o(16545);
    }
  }
  
  public void b(final a parama)
  {
    AppMethodBeat.i(16551);
    this.j.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16503);
        b.d(b.this).remove(parama);
        AppMethodBeat.o(16503);
      }
    });
    AppMethodBeat.o(16551);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
  
  class b
  {
    Surface a;
    int b;
    int c;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.b
 * JD-Core Version:    0.7.0.1
 */