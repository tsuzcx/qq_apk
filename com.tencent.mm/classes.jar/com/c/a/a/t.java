package com.c.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class t
{
  private static Context bQd;
  private static WeakReference<t.b> bQe;
  private static WeakReference<t.d> bQf;
  private static WeakReference<c> bQg;
  private static WeakReference<e> bQh;
  private static final a bQi;
  private static String imei;
  private static boolean isRunning;
  
  static
  {
    AppMethodBeat.i(87923);
    isRunning = false;
    bQi = new a((byte)0);
    AppMethodBeat.o(87923);
  }
  
  public static void a(Context paramContext, q paramq)
  {
    AppMethodBeat.i(87924);
    bQd = paramContext.getApplicationContext();
    try
    {
      w.zl().a(paramContext, new m[] { bQi });
      r.yP().bPy = paramq;
      r.yP().bPz = imei;
      AppMethodBeat.o(87924);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(87924);
    }
  }
  
  /* Error */
  public static boolean a(android.os.Handler paramHandler, long paramLong, t.b paramb, t.d paramd)
  {
    // Byte code:
    //   0: ldc 97
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 67	com/c/a/a/t:bQd	Landroid/content/Context;
    //   8: ifnonnull +10 -> 18
    //   11: ldc 97
    //   13: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: getstatic 45	com/c/a/a/t:isRunning	Z
    //   21: ifeq +10 -> 31
    //   24: ldc 97
    //   26: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_1
    //   30: ireturn
    //   31: new 99	java/lang/ref/WeakReference
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 102	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   39: putstatic 104	com/c/a/a/t:bQe	Ljava/lang/ref/WeakReference;
    //   42: new 99	java/lang/ref/WeakReference
    //   45: dup
    //   46: aload 4
    //   48: invokespecial 102	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   51: putstatic 106	com/c/a/a/t:bQf	Ljava/lang/ref/WeakReference;
    //   54: new 99	java/lang/ref/WeakReference
    //   57: dup
    //   58: aconst_null
    //   59: invokespecial 102	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   62: putstatic 108	com/c/a/a/t:bQg	Ljava/lang/ref/WeakReference;
    //   65: invokestatic 73	com/c/a/a/w:zl	()Lcom/c/a/a/w;
    //   68: astore_3
    //   69: aload_0
    //   70: ifnull +188 -> 258
    //   73: aload_3
    //   74: aload_0
    //   75: new 110	com/c/a/a/n$c
    //   78: dup
    //   79: lload_1
    //   80: ldc2_w 111
    //   83: invokespecial 115	com/c/a/a/n$c:<init>	(JJ)V
    //   86: invokevirtual 118	com/c/a/a/w:a	(Landroid/os/Handler;Lcom/c/a/a/d$a;)V
    //   89: getstatic 123	com/c/a/a/y:bSu	Z
    //   92: ifeq +105 -> 197
    //   95: invokestatic 129	com/c/a/a/o:yO	()Ljava/lang/String;
    //   98: putstatic 132	com/c/a/a/y:bSB	Ljava/lang/String;
    //   101: new 134	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 136
    //   107: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: getstatic 132	com/c/a/a/y:bSB	Ljava/lang/String;
    //   113: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: ldc 148
    //   121: invokestatic 152	com/c/a/a/o:t	(Ljava/lang/String;Ljava/lang/String;)Z
    //   124: pop
    //   125: new 134	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 154
    //   131: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: getstatic 132	com/c/a/a/y:bSB	Ljava/lang/String;
    //   137: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: ldc 156
    //   145: invokestatic 152	com/c/a/a/o:t	(Ljava/lang/String;Ljava/lang/String;)Z
    //   148: pop
    //   149: new 134	java/lang/StringBuilder
    //   152: dup
    //   153: ldc 158
    //   155: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: getstatic 132	com/c/a/a/y:bSB	Ljava/lang/String;
    //   161: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: ldc 160
    //   169: invokestatic 152	com/c/a/a/o:t	(Ljava/lang/String;Ljava/lang/String;)Z
    //   172: pop
    //   173: new 134	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 162
    //   179: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: getstatic 132	com/c/a/a/y:bSB	Ljava/lang/String;
    //   185: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: ldc 164
    //   193: invokestatic 152	com/c/a/a/o:t	(Ljava/lang/String;Ljava/lang/String;)Z
    //   196: pop
    //   197: getstatic 166	com/c/a/a/t:bQh	Ljava/lang/ref/WeakReference;
    //   200: ifnull +47 -> 247
    //   203: getstatic 166	com/c/a/a/t:bQh	Ljava/lang/ref/WeakReference;
    //   206: invokevirtual 170	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   209: checkcast 16	com/c/a/a/t$e
    //   212: ifnull +35 -> 247
    //   215: getstatic 67	com/c/a/a/t:bQd	Landroid/content/Context;
    //   218: ldc 172
    //   220: invokevirtual 176	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   223: checkcast 178	android/location/LocationManager
    //   226: astore_0
    //   227: aload_0
    //   228: ldc 180
    //   230: invokevirtual 184	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   233: istore 5
    //   235: iload 5
    //   237: ifne +10 -> 247
    //   240: aload_0
    //   241: ldc 186
    //   243: invokevirtual 184	android/location/LocationManager:isProviderEnabled	(Ljava/lang/String;)Z
    //   246: pop
    //   247: iconst_1
    //   248: putstatic 45	com/c/a/a/t:isRunning	Z
    //   251: ldc 97
    //   253: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: iconst_1
    //   257: ireturn
    //   258: new 188	android/os/Handler
    //   261: dup
    //   262: getstatic 67	com/c/a/a/t:bQd	Landroid/content/Context;
    //   265: invokevirtual 192	android/content/Context:getMainLooper	()Landroid/os/Looper;
    //   268: invokespecial 195	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   271: astore_0
    //   272: goto -199 -> 73
    //   275: astore_0
    //   276: iconst_0
    //   277: putstatic 45	com/c/a/a/t:isRunning	Z
    //   280: ldc 97
    //   282: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(87927);
    try
    {
      w.zl().yH();
      AppMethodBeat.o(87927);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(87927);
    }
  }
  
  public static void setImei(String paramString)
  {
    imei = paramString;
  }
  
  /* Error */
  public static void zc()
  {
    // Byte code:
    //   0: ldc 203
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 73	com/c/a/a/w:zl	()Lcom/c/a/a/w;
    //   8: invokevirtual 206	com/c/a/a/w:stop	()V
    //   11: iconst_0
    //   12: putstatic 45	com/c/a/a/t:isRunning	Z
    //   15: ldc 203
    //   17: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: astore_0
    //   22: iconst_0
    //   23: putstatic 45	com/c/a/a/t:isRunning	Z
    //   26: ldc 203
    //   28: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: astore_0
    //   33: iconst_0
    //   34: putstatic 45	com/c/a/a/t:isRunning	Z
    //   37: ldc 203
    //   39: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(87922);
      switch (paramp.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(87922);
        return;
        if (t.zd() != null)
        {
          Object localObject = (t.b)t.zd().get();
          if (localObject != null)
          {
            paramp = (n.a)paramp;
            ((t.b)localObject).onLocationUpdate(paramp.lat, paramp.lng, paramp.bOW, paramp.bOX, paramp.bOY);
            AppMethodBeat.o(87922);
            return;
            if (t.ze() != null)
            {
              localObject = (t.d)t.ze().get();
              if (localObject != null)
              {
                paramp = (n.b)paramp;
                ((t.d)localObject).onMessage(paramp.code, paramp.message);
                AppMethodBeat.o(87922);
                return;
                if (t.zf() != null)
                {
                  localObject = (t.c)t.zf().get();
                  if (localObject != null)
                  {
                    ((t.c)localObject).onRefAdded(((s.e)paramp).bQb);
                    AppMethodBeat.o(87922);
                    return;
                    if (t.zf() != null)
                    {
                      localObject = (t.c)t.zf().get();
                      if (localObject != null) {
                        ((t.c)localObject).onTrackProcessed(((s.g)paramp).bQc);
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
  
  public static abstract interface c
  {
    public abstract void onRefAdded(int paramInt);
    
    public abstract void onTrackProcessed(boolean paramBoolean);
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.t
 * JD-Core Version:    0.7.0.1
 */