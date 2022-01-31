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
import android.view.Surface;
import com.tencent.liteav.basic.c.a;
import com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@TargetApi(21)
public class b
{
  private static final String b = b.class.getSimpleName();
  private static b c = new b();
  MediaProjection.Callback a = new MediaProjection.Callback()
  {
    public void onStop()
    {
      if (!b.a(b.this)) {
        return;
      }
      b.a(b.this, false);
    }
  };
  private HashMap<Surface, VirtualDisplay> d = new HashMap();
  private Context e = null;
  private MediaProjectionManager f = null;
  private MediaProjection g = null;
  private HashSet<b.a> h = new HashSet();
  private int i = 1;
  private Handler j = null;
  private HashSet<Object> k = new HashSet();
  private boolean l = false;
  private WeakReference<a> m = null;
  private BroadcastReceiver n = new b.3(this);
  
  public static b a()
  {
    return c;
  }
  
  /* Error */
  @TargetApi(21)
  private void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/liteav/screencapture/b:e	Landroid/content/Context;
    //   6: ifnull +14 -> 20
    //   9: aload_0
    //   10: getfield 66	com/tencent/liteav/screencapture/b:e	Landroid/content/Context;
    //   13: aload_0
    //   14: getfield 95	com/tencent/liteav/screencapture/b:n	Landroid/content/BroadcastReceiver;
    //   17: invokevirtual 116	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   20: iload_1
    //   21: sipush 1001
    //   24: if_icmpne +16 -> 40
    //   27: iload_2
    //   28: iconst_m1
    //   29: if_icmpne +11 -> 40
    //   32: aload_0
    //   33: getfield 77	com/tencent/liteav/screencapture/b:i	I
    //   36: iconst_2
    //   37: if_icmpeq +23 -> 60
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 77	com/tencent/liteav/screencapture/b:i	I
    //   45: aload_0
    //   46: getfield 85	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   49: sipush -1308
    //   52: ldc 118
    //   54: invokestatic 123	com/tencent/liteav/basic/util/a:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 68	com/tencent/liteav/screencapture/b:f	Landroid/media/projection/MediaProjectionManager;
    //   65: iload_2
    //   66: aload_3
    //   67: invokevirtual 129	android/media/projection/MediaProjectionManager:getMediaProjection	(ILandroid/content/Intent;)Landroid/media/projection/MediaProjection;
    //   70: putfield 70	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   73: aload_0
    //   74: getfield 70	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   77: aload_0
    //   78: getfield 90	com/tencent/liteav/screencapture/b:a	Landroid/media/projection/MediaProjection$Callback;
    //   81: aload_0
    //   82: getfield 79	com/tencent/liteav/screencapture/b:j	Landroid/os/Handler;
    //   85: invokevirtual 135	android/media/projection/MediaProjection:registerCallback	(Landroid/media/projection/MediaProjection$Callback;Landroid/os/Handler;)V
    //   88: aload_0
    //   89: iconst_1
    //   90: putfield 83	com/tencent/liteav/screencapture/b:l	Z
    //   93: aload_0
    //   94: getfield 75	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   97: invokevirtual 139	java/util/HashSet:size	()I
    //   100: ifne +47 -> 147
    //   103: aload_0
    //   104: getfield 85	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   107: sipush -1308
    //   110: ldc 118
    //   112: invokestatic 123	com/tencent/liteav/basic/util/a:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield 77	com/tencent/liteav/screencapture/b:i	I
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore_3
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield 77	com/tencent/liteav/screencapture/b:i	I
    //   134: aload_0
    //   135: getfield 85	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   138: sipush -1308
    //   141: ldc 118
    //   143: invokestatic 123	com/tencent/liteav/basic/util/a:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   146: return
    //   147: aload_0
    //   148: getfield 75	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   151: invokevirtual 143	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   154: astore_3
    //   155: aload_3
    //   156: invokeinterface 149 1 0
    //   161: ifeq +116 -> 277
    //   164: aload_3
    //   165: invokeinterface 153 1 0
    //   170: checkcast 8	com/tencent/liteav/screencapture/b$a
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull -22 -> 155
    //   180: aload 4
    //   182: getfield 156	com/tencent/liteav/screencapture/b$a:a	Landroid/view/Surface;
    //   185: ifnull -30 -> 155
    //   188: aload 4
    //   190: getfield 158	com/tencent/liteav/screencapture/b$a:b	I
    //   193: ifeq -38 -> 155
    //   196: aload 4
    //   198: getfield 160	com/tencent/liteav/screencapture/b$a:c	I
    //   201: ifeq -46 -> 155
    //   204: aload_0
    //   205: getfield 70	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   208: ldc 162
    //   210: aload 4
    //   212: getfield 158	com/tencent/liteav/screencapture/b$a:b	I
    //   215: aload 4
    //   217: getfield 160	com/tencent/liteav/screencapture/b$a:c	I
    //   220: iconst_1
    //   221: iconst_1
    //   222: aload 4
    //   224: getfield 156	com/tencent/liteav/screencapture/b$a:a	Landroid/view/Surface;
    //   227: aconst_null
    //   228: aconst_null
    //   229: invokevirtual 166	android/media/projection/MediaProjection:createVirtualDisplay	(Ljava/lang/String;IIIILandroid/view/Surface;Landroid/hardware/display/VirtualDisplay$Callback;Landroid/os/Handler;)Landroid/hardware/display/VirtualDisplay;
    //   232: astore 5
    //   234: aload 5
    //   236: ifnonnull +23 -> 259
    //   239: aload_0
    //   240: getfield 85	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   243: sipush -1308
    //   246: ldc 118
    //   248: invokestatic 123	com/tencent/liteav/basic/util/a:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   251: aload_0
    //   252: iconst_1
    //   253: putfield 77	com/tencent/liteav/screencapture/b:i	I
    //   256: aload_0
    //   257: monitorexit
    //   258: return
    //   259: aload_0
    //   260: getfield 64	com/tencent/liteav/screencapture/b:d	Ljava/util/HashMap;
    //   263: aload 4
    //   265: getfield 156	com/tencent/liteav/screencapture/b$a:a	Landroid/view/Surface;
    //   268: aload 5
    //   270: invokevirtual 170	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: goto -119 -> 155
    //   277: aload_0
    //   278: getfield 75	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   281: invokevirtual 173	java/util/HashSet:clear	()V
    //   284: aload_0
    //   285: iconst_3
    //   286: putfield 77	com/tencent/liteav/screencapture/b:i	I
    //   289: aload_0
    //   290: monitorexit
    //   291: aload_0
    //   292: getfield 85	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   295: sipush 1004
    //   298: ldc 175
    //   300: invokestatic 123	com/tencent/liteav/basic/util/a:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   303: return
    //   304: astore 4
    //   306: goto -286 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	b
    //   0	309	1	paramInt1	int
    //   0	309	2	paramInt2	int
    //   0	309	3	paramIntent	Intent
    //   173	91	4	locala	b.a
    //   304	1	4	localException	Exception
    //   232	37	5	localVirtualDisplay	VirtualDisplay
    // Exception table:
    //   from	to	target	type
    //   2	20	123	finally
    //   32	40	123	finally
    //   40	59	123	finally
    //   60	122	123	finally
    //   124	126	123	finally
    //   147	155	123	finally
    //   155	175	123	finally
    //   180	234	123	finally
    //   239	258	123	finally
    //   259	274	123	finally
    //   277	291	123	finally
    //   0	2	128	java/lang/Exception
    //   126	128	128	java/lang/Exception
    //   2	20	304	java/lang/Exception
  }
  
  private void c()
  {
    this.i = 4;
    this.j.postDelayed(new b.2(this), 1000L);
  }
  
  private void d()
  {
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
    f();
  }
  
  @TargetApi(21)
  private boolean e()
  {
    if (this.i != 1) {
      return true;
    }
    if ((this.e == null) || (this.f == null)) {
      return false;
    }
    this.i = 2;
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("TXScreenCapture.OnAssistantActivityResult");
    this.e.registerReceiver(this.n, (IntentFilter)localObject);
    localObject = new Intent(this.e, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("TXScreenCapture.ScreenCaptureIntent", this.f.createScreenCaptureIntent());
    this.e.startActivity((Intent)localObject);
    return true;
  }
  
  @TargetApi(21)
  private void f()
  {
    if (!this.k.isEmpty()) {
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
        this.e.unregisterReceiver(this.n);
      }
      label59:
      this.g = null;
      this.i = 1;
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  public void a(Context paramContext)
  {
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
    finally {}
  }
  
  public void a(Surface paramSurface)
  {
    try
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        b.a locala = (b.a)localIterator.next();
        if ((locala != null) && (locala.a != null) && (locala.b != 0) && (locala.c != 0) && (locala.a == paramSurface)) {
          this.h.remove(locala);
        }
      }
      if (!this.d.containsKey(paramSurface)) {
        return;
      }
      ((VirtualDisplay)this.d.get(paramSurface)).release();
      this.d.remove(paramSurface);
      c();
      return;
    }
    finally {}
  }
  
  public void a(a parama)
  {
    if (parama == null)
    {
      this.m = null;
      return;
    }
    this.m = new WeakReference(parama);
  }
  
  /* Error */
  @TargetApi(21)
  public boolean a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 77	com/tencent/liteav/screencapture/b:i	I
    //   9: iconst_3
    //   10: if_icmpeq +11 -> 21
    //   13: aload_0
    //   14: getfield 77	com/tencent/liteav/screencapture/b:i	I
    //   17: iconst_4
    //   18: if_icmpne +83 -> 101
    //   21: iload 5
    //   23: istore 4
    //   25: aload_0
    //   26: getfield 70	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   29: ifnull +50 -> 79
    //   32: aload_0
    //   33: getfield 70	com/tencent/liteav/screencapture/b:g	Landroid/media/projection/MediaProjection;
    //   36: ldc 162
    //   38: iload_2
    //   39: iload_3
    //   40: iconst_1
    //   41: iconst_1
    //   42: aload_1
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 166	android/media/projection/MediaProjection:createVirtualDisplay	(Ljava/lang/String;IIIILandroid/view/Surface;Landroid/hardware/display/VirtualDisplay$Callback;Landroid/os/Handler;)Landroid/hardware/display/VirtualDisplay;
    //   48: astore 6
    //   50: aload 6
    //   52: ifnull +117 -> 169
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 83	com/tencent/liteav/screencapture/b:l	Z
    //   60: aload_0
    //   61: iconst_3
    //   62: putfield 77	com/tencent/liteav/screencapture/b:i	I
    //   65: aload_0
    //   66: getfield 64	com/tencent/liteav/screencapture/b:d	Ljava/util/HashMap;
    //   69: aload_1
    //   70: aload 6
    //   72: invokevirtual 170	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: iconst_1
    //   77: istore 4
    //   79: iload 4
    //   81: ifne +15 -> 96
    //   84: aload_0
    //   85: getfield 85	com/tencent/liteav/screencapture/b:m	Ljava/lang/ref/WeakReference;
    //   88: sipush -1308
    //   91: ldc 118
    //   93: invokestatic 123	com/tencent/liteav/basic/util/a:a	(Ljava/lang/ref/WeakReference;ILjava/lang/String;)V
    //   96: aload_0
    //   97: monitorexit
    //   98: iload 4
    //   100: ireturn
    //   101: new 8	com/tencent/liteav/screencapture/b$a
    //   104: dup
    //   105: aload_0
    //   106: aconst_null
    //   107: invokespecial 290	com/tencent/liteav/screencapture/b$a:<init>	(Lcom/tencent/liteav/screencapture/b;Lcom/tencent/liteav/screencapture/b$1;)V
    //   110: astore 6
    //   112: aload 6
    //   114: iload_3
    //   115: putfield 160	com/tencent/liteav/screencapture/b$a:c	I
    //   118: aload 6
    //   120: iload_2
    //   121: putfield 158	com/tencent/liteav/screencapture/b$a:b	I
    //   124: aload 6
    //   126: aload_1
    //   127: putfield 156	com/tencent/liteav/screencapture/b$a:a	Landroid/view/Surface;
    //   130: aload_0
    //   131: getfield 75	com/tencent/liteav/screencapture/b:h	Ljava/util/HashSet;
    //   134: aload 6
    //   136: invokevirtual 293	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   139: pop
    //   140: aload_0
    //   141: invokespecial 295	com/tencent/liteav/screencapture/b:e	()Z
    //   144: istore 4
    //   146: goto -67 -> 79
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: iload 5
    //   157: istore 4
    //   159: goto -80 -> 79
    //   162: astore_1
    //   163: iconst_1
    //   164: istore 4
    //   166: goto -87 -> 79
    //   169: iconst_0
    //   170: istore 4
    //   172: goto -93 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	b
    //   0	175	1	paramSurface	Surface
    //   0	175	2	paramInt1	int
    //   0	175	3	paramInt2	int
    //   23	148	4	bool1	boolean
    //   1	155	5	bool2	boolean
    //   48	87	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	21	149	finally
    //   25	50	149	finally
    //   55	60	149	finally
    //   60	76	149	finally
    //   84	96	149	finally
    //   96	98	149	finally
    //   101	146	149	finally
    //   150	152	149	finally
    //   5	21	154	java/lang/Exception
    //   25	50	154	java/lang/Exception
    //   55	60	154	java/lang/Exception
    //   101	146	154	java/lang/Exception
    //   60	76	162	java/lang/Exception
  }
  
  public void b()
  {
    try
    {
      d();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.b
 * JD-Core Version:    0.7.0.1
 */