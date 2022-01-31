package com.d.a.a;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class t
{
  private static Context aZu;
  private static WeakReference<t.b> aZv;
  private static WeakReference<t.d> aZw;
  private static WeakReference<t.c> aZx;
  private static WeakReference<t.e> aZy;
  private static final t.a aZz = new t.a((byte)0);
  private static String imei;
  private static boolean isRunning = false;
  
  public static void a(Context paramContext, q paramq)
  {
    aZu = paramContext.getApplicationContext();
    try
    {
      w.pE().a(paramContext, new m[] { aZz });
      r.pi().aYN = paramq;
      r.pi().aYO = imei;
      return;
    }
    catch (Exception paramContext) {}
  }
  
  /* Error */
  public static boolean a(android.os.Handler paramHandler, long paramLong, t.b paramb, t.d paramd)
  {
    // Byte code:
    //   0: getstatic 54	com/d/a/a/t:aZu	Landroid/content/Context;
    //   3: ifnonnull +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: getstatic 35	com/d/a/a/t:isRunning	Z
    //   11: ifeq +5 -> 16
    //   14: iconst_1
    //   15: ireturn
    //   16: new 85	java/lang/ref/WeakReference
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 88	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   24: putstatic 90	com/d/a/a/t:aZv	Ljava/lang/ref/WeakReference;
    //   27: new 85	java/lang/ref/WeakReference
    //   30: dup
    //   31: aload 4
    //   33: invokespecial 88	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   36: putstatic 92	com/d/a/a/t:aZw	Ljava/lang/ref/WeakReference;
    //   39: new 85	java/lang/ref/WeakReference
    //   42: dup
    //   43: aconst_null
    //   44: invokespecial 88	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   47: putstatic 94	com/d/a/a/t:aZx	Ljava/lang/ref/WeakReference;
    //   50: invokestatic 60	com/d/a/a/w:pE	()Lcom/d/a/a/w;
    //   53: astore_3
    //   54: aload_0
    //   55: ifnull +183 -> 238
    //   58: aload_3
    //   59: aload_0
    //   60: new 96	com/d/a/a/n$c
    //   63: dup
    //   64: lload_1
    //   65: ldc2_w 97
    //   68: invokespecial 101	com/d/a/a/n$c:<init>	(JJ)V
    //   71: invokevirtual 104	com/d/a/a/w:a	(Landroid/os/Handler;Lcom/d/a/a/d$a;)V
    //   74: getstatic 109	com/d/a/a/y:bbL	Z
    //   77: ifeq +105 -> 182
    //   80: invokestatic 115	com/d/a/a/o:ph	()Ljava/lang/String;
    //   83: putstatic 118	com/d/a/a/y:bbS	Ljava/lang/String;
    //   86: new 120	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 122
    //   92: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: getstatic 118	com/d/a/a/y:bbS	Ljava/lang/String;
    //   98: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: ldc 134
    //   106: invokestatic 138	com/d/a/a/o:m	(Ljava/lang/String;Ljava/lang/String;)Z
    //   109: pop
    //   110: new 120	java/lang/StringBuilder
    //   113: dup
    //   114: ldc 140
    //   116: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: getstatic 118	com/d/a/a/y:bbS	Ljava/lang/String;
    //   122: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: ldc 142
    //   130: invokestatic 138	com/d/a/a/o:m	(Ljava/lang/String;Ljava/lang/String;)Z
    //   133: pop
    //   134: new 120	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 144
    //   140: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: getstatic 118	com/d/a/a/y:bbS	Ljava/lang/String;
    //   146: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: ldc 146
    //   154: invokestatic 138	com/d/a/a/o:m	(Ljava/lang/String;Ljava/lang/String;)Z
    //   157: pop
    //   158: new 120	java/lang/StringBuilder
    //   161: dup
    //   162: ldc 148
    //   164: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: getstatic 118	com/d/a/a/y:bbS	Ljava/lang/String;
    //   170: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: ldc 150
    //   178: invokestatic 138	com/d/a/a/o:m	(Ljava/lang/String;Ljava/lang/String;)Z
    //   181: pop
    //   182: getstatic 152	com/d/a/a/t:aZy	Ljava/lang/ref/WeakReference;
    //   185: ifnull +47 -> 232
    //   188: getstatic 152	com/d/a/a/t:aZy	Ljava/lang/ref/WeakReference;
    //   191: invokevirtual 156	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   194: checkcast 14	com/d/a/a/t$e
    //   197: ifnull +35 -> 232
    //   200: getstatic 54	com/d/a/a/t:aZu	Landroid/content/Context;
    //   203: ldc 158
    //   205: invokevirtual 162	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   208: checkcast 164	android/location/LocationManager
    //   211: astore_0
    //   212: aload_0
    //   213: ldc 166
    //   215: invokevirtual 170	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   218: istore 5
    //   220: iload 5
    //   222: ifne +10 -> 232
    //   225: aload_0
    //   226: ldc 172
    //   228: invokevirtual 170	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   231: pop
    //   232: iconst_1
    //   233: putstatic 35	com/d/a/a/t:isRunning	Z
    //   236: iconst_1
    //   237: ireturn
    //   238: new 174	android/os/Handler
    //   241: dup
    //   242: getstatic 54	com/d/a/a/t:aZu	Landroid/content/Context;
    //   245: invokevirtual 178	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   248: invokespecial 181	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   251: astore_0
    //   252: goto -194 -> 58
    //   255: astore_0
    //   256: iconst_0
    //   257: putstatic 35	com/d/a/a/t:isRunning	Z
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_3
    //   263: iconst_0
    //   264: istore 5
    //   266: goto -46 -> 220
    //   269: astore_0
    //   270: goto -38 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramHandler	android.os.Handler
    //   0	273	1	paramLong	long
    //   0	273	3	paramb	t.b
    //   0	273	4	paramd	t.d
    //   218	47	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   50	54	255	java/lang/Exception
    //   58	182	255	java/lang/Exception
    //   182	212	255	java/lang/Exception
    //   212	220	255	java/lang/Exception
    //   225	232	255	java/lang/Exception
    //   232	236	255	java/lang/Exception
    //   238	252	255	java/lang/Exception
    //   212	220	262	java/lang/SecurityException
    //   225	232	269	java/lang/SecurityException
  }
  
  public static void finish()
  {
    try
    {
      w.pE().pa();
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public static void pv()
  {
    // Byte code:
    //   0: invokestatic 60	com/d/a/a/w:pE	()Lcom/d/a/a/w;
    //   3: invokevirtual 189	com/d/a/a/w:stop	()V
    //   6: iconst_0
    //   7: putstatic 35	com/d/a/a/t:isRunning	Z
    //   10: return
    //   11: astore_0
    //   12: iconst_0
    //   13: putstatic 35	com/d/a/a/t:isRunning	Z
    //   16: return
    //   17: astore_0
    //   18: iconst_0
    //   19: putstatic 35	com/d/a/a/t:isRunning	Z
    //   22: aload_0
    //   23: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	1	0	localException	Exception
    //   17	6	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	11	java/lang/Exception
    //   0	6	17	finally
  }
  
  public static void setImei(String paramString)
  {
    imei = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.d.a.a.t
 * JD-Core Version:    0.7.0.1
 */