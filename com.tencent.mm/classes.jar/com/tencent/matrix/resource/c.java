package com.tencent.matrix.resource;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.HandlerThread;

public class c
  extends com.tencent.matrix.d.b
{
  public final com.tencent.matrix.resource.b.a eZp;
  public com.tencent.matrix.resource.f.b eZq = null;
  
  public c(com.tencent.matrix.resource.b.a parama)
  {
    this.eZp = parama;
  }
  
  public static boolean azg()
  {
    return com.tencent.matrix.resource.processor.b.azg();
  }
  
  public static void e(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new com.tencent.matrix.resource.f.a()
    {
      /* Error */
      public final void onActivityDestroyed(android.app.Activity paramAnonymousActivity)
      {
        // Byte code:
        //   0: invokestatic 22	java/lang/System:currentTimeMillis	()J
        //   3: lstore_3
        //   4: aload_1
        //   5: ifnull +157 -> 162
        //   8: aload_1
        //   9: ldc 24
        //   11: invokevirtual 30	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   14: checkcast 32	android/view/inputmethod/InputMethodManager
        //   17: astore 5
        //   19: aload 5
        //   21: ifnull +141 -> 162
        //   24: iconst_0
        //   25: istore_2
        //   26: iload_2
        //   27: iconst_3
        //   28: if_icmpge +134 -> 162
        //   31: iconst_3
        //   32: anewarray 34	java/lang/String
        //   35: dup
        //   36: iconst_0
        //   37: ldc 36
        //   39: aastore
        //   40: dup
        //   41: iconst_1
        //   42: ldc 38
        //   44: aastore
        //   45: dup
        //   46: iconst_2
        //   47: ldc 40
        //   49: aastore
        //   50: iload_2
        //   51: aaload
        //   52: astore 6
        //   54: aload 5
        //   56: invokevirtual 46	java/lang/Object:getClass	()Ljava/lang/Class;
        //   59: aload 6
        //   61: invokevirtual 52	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //   64: astore 6
        //   66: aload 6
        //   68: invokevirtual 58	java/lang/reflect/Field:isAccessible	()Z
        //   71: ifne +9 -> 80
        //   74: aload 6
        //   76: iconst_1
        //   77: invokevirtual 62	java/lang/reflect/Field:setAccessible	(Z)V
        //   80: aload 6
        //   82: aload 5
        //   84: invokevirtual 66	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   87: astore 7
        //   89: aload 7
        //   91: instanceof 68
        //   94: ifeq +234 -> 328
        //   97: aload 7
        //   99: checkcast 68	android/view/View
        //   102: astore 7
        //   104: aload 7
        //   106: invokevirtual 72	android/view/View:getContext	()Landroid/content/Context;
        //   109: aload_1
        //   110: if_acmpne +14 -> 124
        //   113: aload 6
        //   115: aload 5
        //   117: aconst_null
        //   118: invokevirtual 76	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   121: goto +207 -> 328
        //   124: ldc 78
        //   126: new 80	java/lang/StringBuilder
        //   129: dup
        //   130: ldc 82
        //   132: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   135: aload 7
        //   137: invokevirtual 72	android/view/View:getContext	()Landroid/content/Context;
        //   140: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   143: ldc 91
        //   145: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload_1
        //   149: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   152: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   155: iconst_0
        //   156: anewarray 42	java/lang/Object
        //   159: invokestatic 104	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   162: ldc 78
        //   164: ldc 106
        //   166: iconst_1
        //   167: anewarray 42	java/lang/Object
        //   170: dup
        //   171: iconst_0
        //   172: invokestatic 22	java/lang/System:currentTimeMillis	()J
        //   175: lload_3
        //   176: lsub
        //   177: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   180: aastore
        //   181: invokestatic 104	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   184: invokestatic 22	java/lang/System:currentTimeMillis	()J
        //   187: lstore_3
        //   188: aload_1
        //   189: ifnull +125 -> 314
        //   192: aload_1
        //   193: invokevirtual 118	android/app/Activity:getWindow	()Landroid/view/Window;
        //   196: ifnull +118 -> 314
        //   199: aload_1
        //   200: invokevirtual 118	android/app/Activity:getWindow	()Landroid/view/Window;
        //   203: invokevirtual 124	android/view/Window:peekDecorView	()Landroid/view/View;
        //   206: ifnull +108 -> 314
        //   209: aload_1
        //   210: invokevirtual 118	android/app/Activity:getWindow	()Landroid/view/Window;
        //   213: invokevirtual 124	android/view/Window:peekDecorView	()Landroid/view/View;
        //   216: invokevirtual 127	android/view/View:getRootView	()Landroid/view/View;
        //   219: astore 5
        //   221: aload 5
        //   223: invokestatic 133	com/tencent/matrix/resource/a:cU	(Landroid/view/View;)V
        //   226: aload 5
        //   228: instanceof 135
        //   231: ifeq +11 -> 242
        //   234: aload 5
        //   236: checkcast 135	android/view/ViewGroup
        //   239: invokevirtual 138	android/view/ViewGroup:removeAllViews	()V
        //   242: ldc 78
        //   244: ldc 140
        //   246: iconst_1
        //   247: anewarray 42	java/lang/Object
        //   250: dup
        //   251: iconst_0
        //   252: invokestatic 22	java/lang/System:currentTimeMillis	()J
        //   255: lload_3
        //   256: lsub
        //   257: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   260: aastore
        //   261: invokestatic 104	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   264: aload_1
        //   265: invokestatic 144	com/tencent/matrix/resource/a:ch	(Landroid/content/Context;)V
        //   268: return
        //   269: astore 6
        //   271: ldc 78
        //   273: ldc 146
        //   275: iconst_1
        //   276: anewarray 42	java/lang/Object
        //   279: dup
        //   280: iconst_0
        //   281: aload 6
        //   283: invokevirtual 149	java/lang/Throwable:toString	()Ljava/lang/String;
        //   286: aastore
        //   287: invokestatic 151	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   290: goto +38 -> 328
        //   293: astore 5
        //   295: ldc 78
        //   297: ldc 153
        //   299: iconst_1
        //   300: anewarray 42	java/lang/Object
        //   303: dup
        //   304: iconst_0
        //   305: aload 5
        //   307: aastore
        //   308: invokestatic 156	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   311: goto -69 -> 242
        //   314: ldc 78
        //   316: ldc 158
        //   318: iconst_0
        //   319: anewarray 42	java/lang/Object
        //   322: invokestatic 104	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   325: goto -83 -> 242
        //   328: iload_2
        //   329: iconst_1
        //   330: iadd
        //   331: istore_2
        //   332: goto -306 -> 26
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	335	0	this	1
        //   0	335	1	paramAnonymousActivity	android.app.Activity
        //   25	307	2	i	int
        //   3	253	3	l	long
        //   17	218	5	localObject1	Object
        //   293	13	5	localObject2	Object
        //   52	62	6	localObject3	Object
        //   269	13	6	localObject4	Object
        //   87	49	7	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   54	80	269	finally
        //   80	121	269	finally
        //   124	162	269	finally
        //   221	242	293	finally
      }
    });
  }
  
  public void destroy()
  {
    super.destroy();
    if (!isSupported())
    {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "ResourcePlugin destroy, ResourcePlugin is not supported, just return", new Object[0]);
      return;
    }
    com.tencent.matrix.resource.f.b localb = this.eZq;
    localb.fcP.azz();
    localb.mHandlerThread.quitSafely();
    localb.fcU.onDestroy();
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "watcher is destroyed.", new Object[0]);
  }
  
  public String getTag()
  {
    return "memory";
  }
  
  public void init(Application paramApplication, com.tencent.matrix.d.c paramc)
  {
    super.init(paramApplication, paramc);
    if (Build.VERSION.SDK_INT < 14)
    {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.eZq = new com.tencent.matrix.resource.f.b(paramApplication, this);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    com.tencent.matrix.e.c.d("Matrix.ResourcePlugin", "onForeground: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.matrix.resource.f.b localb;
    if ((isPluginStarted()) && (this.eZq != null))
    {
      localb = this.eZq;
      if (paramBoolean)
      {
        com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "we are in foreground, modify scan time[%sms].", new Object[] { Long.valueOf(localb.fcS) });
        localb.fcP.azz();
        localb.fcP.fdb = localb.fcS;
        localb.fcP.a(localb.fcW, 0);
      }
    }
    else
    {
      return;
    }
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "we are in background, modify scan time[%sms].", new Object[] { Long.valueOf(localb.fcR) });
    localb.fcP.fdb = localb.fcR;
  }
  
  public void start()
  {
    super.start();
    if (!isSupported()) {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
    }
    com.tencent.matrix.resource.f.b localb;
    Application localApplication;
    do
    {
      return;
      localb = this.eZq;
      localb.azv();
      localApplication = localb.fcO.getApplication();
    } while (localApplication == null);
    localApplication.registerActivityLifecycleCallbacks(localb.fcV);
    localb.fcP.a(localb.fcW, 0);
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
  }
  
  public void stop()
  {
    super.stop();
    if (!isSupported())
    {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
      return;
    }
    this.eZq.azv();
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.c
 * JD-Core Version:    0.7.0.1
 */