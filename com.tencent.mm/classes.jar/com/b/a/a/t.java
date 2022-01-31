package com.b.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class t
{
  private static Context bqa;
  private static WeakReference<t.b> bqb;
  private static WeakReference<t.d> bqc;
  private static WeakReference<t.c> bqd;
  private static WeakReference<t.e> bqe;
  private static final a bqf;
  private static String imei;
  private static boolean isRunning;
  
  static
  {
    AppMethodBeat.i(55578);
    isRunning = false;
    bqf = new a((byte)0);
    AppMethodBeat.o(55578);
  }
  
  public static void a(Context paramContext, q paramq)
  {
    AppMethodBeat.i(55579);
    bqa = paramContext.getApplicationContext();
    try
    {
      w.tK().a(paramContext, new m[] { bqf });
      r.to().bpv = paramq;
      r.to().bpw = imei;
      AppMethodBeat.o(55579);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55579);
    }
  }
  
  /* Error */
  public static boolean a(android.os.Handler paramHandler, long paramLong, t.b paramb, t.d paramd)
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 65	com/b/a/a/t:bqa	Landroid/content/Context;
    //   8: ifnonnull +10 -> 18
    //   11: ldc 95
    //   13: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: getstatic 43	com/b/a/a/t:isRunning	Z
    //   21: ifeq +10 -> 31
    //   24: ldc 95
    //   26: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_1
    //   30: ireturn
    //   31: new 97	java/lang/ref/WeakReference
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 100	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   39: putstatic 102	com/b/a/a/t:bqb	Ljava/lang/ref/WeakReference;
    //   42: new 97	java/lang/ref/WeakReference
    //   45: dup
    //   46: aload 4
    //   48: invokespecial 100	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   51: putstatic 104	com/b/a/a/t:bqc	Ljava/lang/ref/WeakReference;
    //   54: new 97	java/lang/ref/WeakReference
    //   57: dup
    //   58: aconst_null
    //   59: invokespecial 100	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   62: putstatic 106	com/b/a/a/t:bqd	Ljava/lang/ref/WeakReference;
    //   65: invokestatic 71	com/b/a/a/w:tK	()Lcom/b/a/a/w;
    //   68: astore_3
    //   69: aload_0
    //   70: ifnull +188 -> 258
    //   73: aload_3
    //   74: aload_0
    //   75: new 108	com/b/a/a/n$c
    //   78: dup
    //   79: lload_1
    //   80: ldc2_w 109
    //   83: invokespecial 113	com/b/a/a/n$c:<init>	(JJ)V
    //   86: invokevirtual 116	com/b/a/a/w:a	(Landroid/os/Handler;Lcom/b/a/a/d$a;)V
    //   89: getstatic 121	com/b/a/a/y:bsr	Z
    //   92: ifeq +105 -> 197
    //   95: invokestatic 127	com/b/a/a/o:tn	()Ljava/lang/String;
    //   98: putstatic 130	com/b/a/a/y:bsy	Ljava/lang/String;
    //   101: new 132	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 134
    //   107: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: getstatic 130	com/b/a/a/y:bsy	Ljava/lang/String;
    //   113: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: ldc 146
    //   121: invokestatic 150	com/b/a/a/o:r	(Ljava/lang/String;Ljava/lang/String;)Z
    //   124: pop
    //   125: new 132	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 152
    //   131: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: getstatic 130	com/b/a/a/y:bsy	Ljava/lang/String;
    //   137: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: ldc 154
    //   145: invokestatic 150	com/b/a/a/o:r	(Ljava/lang/String;Ljava/lang/String;)Z
    //   148: pop
    //   149: new 132	java/lang/StringBuilder
    //   152: dup
    //   153: ldc 156
    //   155: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: getstatic 130	com/b/a/a/y:bsy	Ljava/lang/String;
    //   161: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: ldc 158
    //   169: invokestatic 150	com/b/a/a/o:r	(Ljava/lang/String;Ljava/lang/String;)Z
    //   172: pop
    //   173: new 132	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 160
    //   179: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: getstatic 130	com/b/a/a/y:bsy	Ljava/lang/String;
    //   185: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: ldc 162
    //   193: invokestatic 150	com/b/a/a/o:r	(Ljava/lang/String;Ljava/lang/String;)Z
    //   196: pop
    //   197: getstatic 164	com/b/a/a/t:bqe	Ljava/lang/ref/WeakReference;
    //   200: ifnull +47 -> 247
    //   203: getstatic 164	com/b/a/a/t:bqe	Ljava/lang/ref/WeakReference;
    //   206: invokevirtual 168	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   209: checkcast 15	com/b/a/a/t$e
    //   212: ifnull +35 -> 247
    //   215: getstatic 65	com/b/a/a/t:bqa	Landroid/content/Context;
    //   218: ldc 170
    //   220: invokevirtual 174	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   223: checkcast 176	android/location/LocationManager
    //   226: astore_0
    //   227: aload_0
    //   228: ldc 178
    //   230: invokevirtual 182	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   233: istore 5
    //   235: iload 5
    //   237: ifne +10 -> 247
    //   240: aload_0
    //   241: ldc 184
    //   243: invokevirtual 182	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   246: pop
    //   247: iconst_1
    //   248: putstatic 43	com/b/a/a/t:isRunning	Z
    //   251: ldc 95
    //   253: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: iconst_1
    //   257: ireturn
    //   258: new 186	android/os/Handler
    //   261: dup
    //   262: getstatic 65	com/b/a/a/t:bqa	Landroid/content/Context;
    //   265: invokevirtual 190	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   268: invokespecial 193	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   271: astore_0
    //   272: goto -199 -> 73
    //   275: astore_0
    //   276: iconst_0
    //   277: putstatic 43	com/b/a/a/t:isRunning	Z
    //   280: ldc 95
    //   282: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_0
    //   286: ireturn
    //   287: astore_3
    //   288: iconst_0
    //   289: istore 5
    //   291: goto -56 -> 235
    //   294: astore_0
    //   295: goto -48 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramHandler	android.os.Handler
    //   0	298	1	paramLong	long
    //   0	298	3	paramb	t.b
    //   0	298	4	paramd	t.d
    //   233	57	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	69	275	java/lang/Exception
    //   73	197	275	java/lang/Exception
    //   197	227	275	java/lang/Exception
    //   227	235	275	java/lang/Exception
    //   240	247	275	java/lang/Exception
    //   247	251	275	java/lang/Exception
    //   258	272	275	java/lang/Exception
    //   227	235	287	java/lang/SecurityException
    //   240	247	294	java/lang/SecurityException
  }
  
  public static void finish()
  {
    AppMethodBeat.i(55582);
    try
    {
      w.tK().tg();
      AppMethodBeat.o(55582);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(55582);
    }
  }
  
  public static void setImei(String paramString)
  {
    imei = paramString;
  }
  
  /* Error */
  public static void tB()
  {
    // Byte code:
    //   0: ldc 201
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 71	com/b/a/a/w:tK	()Lcom/b/a/a/w;
    //   8: invokevirtual 204	com/b/a/a/w:stop	()V
    //   11: iconst_0
    //   12: putstatic 43	com/b/a/a/t:isRunning	Z
    //   15: ldc 201
    //   17: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: astore_0
    //   22: iconst_0
    //   23: putstatic 43	com/b/a/a/t:isRunning	Z
    //   26: ldc 201
    //   28: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: astore_0
    //   33: iconst_0
    //   34: putstatic 43	com/b/a/a/t:isRunning	Z
    //   37: ldc 201
    //   39: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	1	0	localException	Exception
    //   32	11	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	21	java/lang/Exception
    //   5	11	32	finally
  }
  
  static final class a
    implements m
  {
    public final void a(p paramp)
    {
      AppMethodBeat.i(55577);
      switch (paramp.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(55577);
        return;
        if (t.tC() != null)
        {
          Object localObject = (t.b)t.tC().get();
          if (localObject != null)
          {
            paramp = (n.a)paramp;
            ((t.b)localObject).onLocationUpdate(paramp.lat, paramp.lng, paramp.boR, paramp.boS, paramp.boT);
            AppMethodBeat.o(55577);
            return;
            if (t.tD() != null)
            {
              localObject = (t.d)t.tD().get();
              if (localObject != null)
              {
                paramp = (n.b)paramp;
                ((t.d)localObject).onMessage(paramp.code, paramp.message);
                AppMethodBeat.o(55577);
                return;
                if (t.tE() != null)
                {
                  localObject = (t.c)t.tE().get();
                  if (localObject != null)
                  {
                    ((t.c)localObject).onRefAdded(((s.e)paramp).bpY);
                    AppMethodBeat.o(55577);
                    return;
                    if (t.tE() != null)
                    {
                      localObject = (t.c)t.tE().get();
                      if (localObject != null) {
                        ((t.c)localObject).onTrackProcessed(((s.g)paramp).bpZ);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.b.a.a.t
 * JD-Core Version:    0.7.0.1
 */