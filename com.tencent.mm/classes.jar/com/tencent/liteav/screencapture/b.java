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
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.c.a;
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
  MediaProjection.Callback a;
  private HashMap<Surface, VirtualDisplay> d;
  private Context e;
  private MediaProjectionManager f;
  private MediaProjection g;
  private HashSet<b.b> h;
  private int i;
  private Handler j;
  private HashSet<Object> k;
  private boolean l;
  private WeakReference<a> m;
  private HandlerThread n;
  private Handler o;
  private int p;
  private HashSet<b.a> q;
  private Runnable r;
  private BroadcastReceiver s;
  
  static
  {
    AppMethodBeat.i(66789);
    b = b.class.getSimpleName();
    c = new b();
    AppMethodBeat.o(66789);
  }
  
  private b()
  {
    AppMethodBeat.i(66771);
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
        AppMethodBeat.i(66800);
        b.a(b.this);
        b.a locala;
        try
        {
          if (b.b(b.this) == null) {
            return;
          }
          int i = ((WindowManager)b.b(b.this).getSystemService("window")).getDefaultDisplay().getRotation();
          if ((i != 0) && (i != 2)) {
            break label177;
          }
          if (b.c(b.this) != 0)
          {
            TXCLog.d(b.c(), "ORIENTATION_PORTRAIT, mDelegateSet size = " + b.d(b.this).size());
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
          AppMethodBeat.o(66800);
        }
        AppMethodBeat.o(66800);
        return;
        label177:
        if (b.c(b.this) != 90)
        {
          TXCLog.d(b.c(), "ORIENTATION_LANDSCAPE, mDelegateSet size = " + b.d(b.this).size());
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
        AppMethodBeat.o(66800);
      }
    };
    this.a = new MediaProjection.Callback()
    {
      public void onStop()
      {
        AppMethodBeat.i(66769);
        if (!b.e(b.this))
        {
          AppMethodBeat.o(66769);
          return;
        }
        b.a(b.this, false);
        AppMethodBeat.o(66769);
      }
    };
    this.s = new b.7(this);
    this.j = new Handler(Looper.getMainLooper());
    this.n.start();
    this.o = new Handler(this.n.getLooper());
    AppMethodBeat.o(66771);
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
    //   0: ldc 161
    //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 91	com/tencent/liteav/screencapture/b:e	Landroid/content/Context;
    //   11: ifnull +14 -> 25
    //   14: aload_0
    //   15: getfield 91	com/tencent/liteav/screencapture/b:e	Landroid/content/Context;
    //   18: aload_0
    //   19: getfield 138	com/tencent/liteav/screencapture/b:s	Landroid/content/BroadcastReceiver;
    //   22: invokevirtual 167	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   25: iload_1
    //   26: sipush 1001
    //   29: if_icmpne +16 -> 45
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpne +11 -> 45
    //   37: aload_0
    //   38: getfield 102	com/tencent/liteav/screencapture/b:i	I
    //   41: iconst_2
    //   42: if_icmpeq +28 -> 70
    //   45: aload_0
    //   46: iconst_1
    //   47: putfield 102	com/tencent/liteav/screencapture/b:i	I
    //   50: aload_0
    //   51: getfield 110	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   54: sipush -1308
    //   57: ldc 169
    //   59: invokestatic 174	com/tencent/liteav/basic/util/b:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   62: aload_0
    //   63: monitorexit
    //   64: ldc 161
    //   66: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 93	com/tencent/liteav/screencapture/b:f	Landroid/media/projection/MediaProjectionManager;
    //   75: iload_2
    //   76: aload_3
    //   77: invokevirtual 180	android/media/projection/MediaProjectionManager:getMediaProjection	(ILandroid/content/Intent;)Landroid/media/projection/MediaProjection;
    //   80: putfield 95	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   83: aload_0
    //   84: getfield 95	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   87: aload_0
    //   88: getfield 133	com/tencent/liteav/screencapture/b:a	Landroid/media/projection/MediaProjection$Callback;
    //   91: aload_0
    //   92: getfield 104	com/tencent/liteav/screencapture/b:j	Landroid/os/Handler;
    //   95: invokevirtual 186	android/media/projection/MediaProjection:registerCallback	(Landroid/media/projection/MediaProjection$Callback;Landroid/os/Handler;)V
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 108	com/tencent/liteav/screencapture/b:l	Z
    //   103: aload_0
    //   104: getfield 100	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   107: invokevirtual 190	java/util/HashSet:size	()I
    //   110: ifne +28 -> 138
    //   113: aload_0
    //   114: getfield 110	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   117: sipush -1308
    //   120: ldc 169
    //   122: invokestatic 174	com/tencent/liteav/basic/util/b:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 102	com/tencent/liteav/screencapture/b:i	I
    //   130: aload_0
    //   131: monitorexit
    //   132: ldc 161
    //   134: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: aload_0
    //   139: getfield 100	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   142: invokevirtual 194	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   145: astore_3
    //   146: aload_3
    //   147: invokeinterface 200 1 0
    //   152: ifeq +155 -> 307
    //   155: aload_3
    //   156: invokeinterface 204 1 0
    //   161: checkcast 16	com/tencent/liteav/screencapture/b$b
    //   164: astore 4
    //   166: aload 4
    //   168: ifnull -22 -> 146
    //   171: aload 4
    //   173: getfield 207	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   176: ifnull -30 -> 146
    //   179: aload 4
    //   181: getfield 209	com/tencent/liteav/screencapture/b$b:b	I
    //   184: ifeq -38 -> 146
    //   187: aload 4
    //   189: getfield 211	com/tencent/liteav/screencapture/b$b:c	I
    //   192: ifeq -46 -> 146
    //   195: aload_0
    //   196: getfield 95	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   199: ldc 213
    //   201: aload 4
    //   203: getfield 209	com/tencent/liteav/screencapture/b$b:b	I
    //   206: aload 4
    //   208: getfield 211	com/tencent/liteav/screencapture/b$b:c	I
    //   211: iconst_1
    //   212: iconst_1
    //   213: aload 4
    //   215: getfield 207	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   218: aconst_null
    //   219: aconst_null
    //   220: invokevirtual 217	android/media/projection/MediaProjection:createVirtualDisplay	(Ljava/lang/String;IIIILandroid/view/Surface;Landroid/hardware/display/VirtualDisplay$Callback;Landroid/os/Handler;)Landroid/hardware/display/VirtualDisplay;
    //   223: astore 5
    //   225: aload 5
    //   227: ifnonnull +28 -> 255
    //   230: aload_0
    //   231: getfield 110	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   234: sipush -1308
    //   237: ldc 169
    //   239: invokestatic 174	com/tencent/liteav/basic/util/b:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   242: aload_0
    //   243: iconst_1
    //   244: putfield 102	com/tencent/liteav/screencapture/b:i	I
    //   247: aload_0
    //   248: monitorexit
    //   249: ldc 161
    //   251: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: aload_0
    //   256: getfield 89	com/tencent/liteav/screencapture/b:d	Ljava/util/HashMap;
    //   259: aload 4
    //   261: getfield 207	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   264: aload 5
    //   266: invokevirtual 221	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   269: pop
    //   270: goto -124 -> 146
    //   273: astore_3
    //   274: aload_0
    //   275: monitorexit
    //   276: ldc 161
    //   278: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload_3
    //   282: athrow
    //   283: astore_3
    //   284: aload_0
    //   285: iconst_1
    //   286: putfield 102	com/tencent/liteav/screencapture/b:i	I
    //   289: aload_0
    //   290: getfield 110	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   293: sipush -1308
    //   296: ldc 169
    //   298: invokestatic 174	com/tencent/liteav/basic/util/b:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   301: ldc 161
    //   303: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: return
    //   307: aload_0
    //   308: getfield 100	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   311: invokevirtual 224	java/util/HashSet:clear	()V
    //   314: aload_0
    //   315: iconst_3
    //   316: putfield 102	com/tencent/liteav/screencapture/b:i	I
    //   319: aload_0
    //   320: monitorexit
    //   321: aload_0
    //   322: getfield 110	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   325: ifnull +25 -> 350
    //   328: new 140	android/os/Handler
    //   331: dup
    //   332: invokestatic 146	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   335: invokespecial 149	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   338: new 226	com/tencent/liteav/screencapture/b$6
    //   341: dup
    //   342: aload_0
    //   343: invokespecial 227	com/tencent/liteav/screencapture/b$6:<init>	(Lcom/tencent/liteav/screencapture/b;)V
    //   346: invokevirtual 231	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   349: pop
    //   350: ldc 161
    //   352: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: return
    //   356: astore 4
    //   358: goto -333 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	b
    //   0	361	1	paramInt1	int
    //   0	361	2	paramInt2	int
    //   0	361	3	paramIntent	Intent
    //   164	96	4	localb	b.b
    //   356	1	4	localException	Exception
    //   223	42	5	localVirtualDisplay	VirtualDisplay
    // Exception table:
    //   from	to	target	type
    //   7	25	273	finally
    //   37	45	273	finally
    //   45	64	273	finally
    //   70	132	273	finally
    //   138	146	273	finally
    //   146	166	273	finally
    //   171	225	273	finally
    //   230	249	273	finally
    //   255	270	273	finally
    //   274	276	273	finally
    //   307	321	273	finally
    //   5	7	283	java/lang/Exception
    //   276	283	283	java/lang/Exception
    //   7	25	356	java/lang/Exception
  }
  
  private void d()
  {
    AppMethodBeat.i(66777);
    this.i = 4;
    this.j.postDelayed(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(66761);
        synchronized (b.this)
        {
          if (b.f(b.this).size() == 0) {
            b.g(b.this);
          }
          AppMethodBeat.o(66761);
          return;
        }
      }
    }, 1000L);
    AppMethodBeat.o(66777);
  }
  
  private void e()
  {
    AppMethodBeat.i(66778);
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
    AppMethodBeat.o(66778);
  }
  
  private void f()
  {
    AppMethodBeat.i(66779);
    this.o.postDelayed(this.r, 50L);
    AppMethodBeat.o(66779);
  }
  
  private void g()
  {
    AppMethodBeat.i(66780);
    this.o.removeCallbacks(this.r);
    AppMethodBeat.o(66780);
  }
  
  @TargetApi(21)
  private boolean h()
  {
    AppMethodBeat.i(66783);
    if (this.i != 1)
    {
      AppMethodBeat.o(66783);
      return true;
    }
    if ((this.e == null) || (this.f == null))
    {
      AppMethodBeat.o(66783);
      return false;
    }
    f();
    this.i = 2;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("TXScreenCapture.OnAssistantActivityResult");
    this.e.registerReceiver(this.s, (IntentFilter)localObject);
    localObject = new Intent(this.e, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("TXScreenCapture.ScreenCaptureIntent", this.f.createScreenCaptureIntent());
    this.e.startActivity((Intent)localObject);
    AppMethodBeat.o(66783);
    return true;
  }
  
  @TargetApi(21)
  private void i()
  {
    AppMethodBeat.i(66784);
    if (!this.k.isEmpty())
    {
      AppMethodBeat.o(66784);
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
      AppMethodBeat.o(66784);
      return;
    }
    catch (Exception localException)
    {
      break label71;
    }
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(66773);
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
      AppMethodBeat.o(66773);
    }
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(66775);
    try
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        b.b localb = (b.b)localIterator.next();
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
      AppMethodBeat.o(66775);
    }
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(146454);
    if (parama == null)
    {
      this.m = null;
      AppMethodBeat.o(146454);
      return;
    }
    this.m = new WeakReference(parama);
    AppMethodBeat.o(146454);
  }
  
  public void a(b.a parama)
  {
    AppMethodBeat.i(66781);
    this.j.post(new b.4(this, parama));
    AppMethodBeat.o(66781);
  }
  
  /* Error */
  @TargetApi(21)
  public boolean a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc_w 374
    //   6: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 102	com/tencent/liteav/screencapture/b:i	I
    //   15: iconst_3
    //   16: if_icmpeq +11 -> 27
    //   19: aload_0
    //   20: getfield 102	com/tencent/liteav/screencapture/b:i	I
    //   23: iconst_4
    //   24: if_icmpne +95 -> 119
    //   27: aload_0
    //   28: getfield 95	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   31: ifnonnull +3 -> 34
    //   34: aload_0
    //   35: getfield 95	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   38: ifnull +148 -> 186
    //   41: aload_0
    //   42: iconst_1
    //   43: putfield 108	com/tencent/liteav/screencapture/b:l	Z
    //   46: aload_0
    //   47: getfield 95	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   50: ldc 213
    //   52: iload_2
    //   53: iload_3
    //   54: iconst_1
    //   55: iconst_1
    //   56: aload_1
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 217	android/media/projection/MediaProjection:createVirtualDisplay	(Ljava/lang/String;IIIILandroid/view/Surface;Landroid/hardware/display/VirtualDisplay$Callback;Landroid/os/Handler;)Landroid/hardware/display/VirtualDisplay;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnonnull +31 -> 97
    //   69: iload 4
    //   71: ifne +15 -> 86
    //   74: aload_0
    //   75: getfield 110	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   78: sipush -1308
    //   81: ldc 169
    //   83: invokestatic 174	com/tencent/liteav/basic/util/b:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   86: aload_0
    //   87: monitorexit
    //   88: ldc_w 374
    //   91: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iload 4
    //   96: ireturn
    //   97: aload_0
    //   98: iconst_3
    //   99: putfield 102	com/tencent/liteav/screencapture/b:i	I
    //   102: aload_0
    //   103: getfield 89	com/tencent/liteav/screencapture/b:d	Ljava/util/HashMap;
    //   106: aload_1
    //   107: aload 6
    //   109: invokevirtual 221	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: iconst_1
    //   114: istore 4
    //   116: goto -47 -> 69
    //   119: new 16	com/tencent/liteav/screencapture/b$b
    //   122: dup
    //   123: aload_0
    //   124: aconst_null
    //   125: invokespecial 377	com/tencent/liteav/screencapture/b$b:<init>	(Lcom/tencent/liteav/screencapture/b;Lcom/tencent/liteav/screencapture/b$1;)V
    //   128: astore 6
    //   130: aload 6
    //   132: iload_3
    //   133: putfield 211	com/tencent/liteav/screencapture/b$b:c	I
    //   136: aload 6
    //   138: iload_2
    //   139: putfield 209	com/tencent/liteav/screencapture/b$b:b	I
    //   142: aload 6
    //   144: aload_1
    //   145: putfield 207	com/tencent/liteav/screencapture/b$b:a	Landroid/view/Surface;
    //   148: aload_0
    //   149: getfield 100	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   152: aload 6
    //   154: invokevirtual 380	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload_0
    //   159: invokespecial 382	com/tencent/liteav/screencapture/b:h	()Z
    //   162: istore 5
    //   164: iload 5
    //   166: istore 4
    //   168: goto -99 -> 69
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: ldc_w 374
    //   177: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(66776);
    try
    {
      e();
      return;
    }
    finally
    {
      AppMethodBeat.o(66776);
    }
  }
  
  public void b(final b.a parama)
  {
    AppMethodBeat.i(66782);
    this.j.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(66763);
        b.d(b.this).remove(parama);
        AppMethodBeat.o(66763);
      }
    });
    AppMethodBeat.o(66782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.b
 * JD-Core Version:    0.7.0.1
 */