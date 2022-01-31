package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class v
{
  private static final Object eqH;
  
  static
  {
    AppMethodBeat.i(93013);
    eqH = new Object();
    AppMethodBeat.o(93013);
  }
  
  /* Error */
  private static void a(Camera paramCamera)
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 37
    //   7: ldc 39
    //   9: invokevirtual 45	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   12: astore 5
    //   14: aload 5
    //   16: iconst_1
    //   17: invokevirtual 51	java/lang/reflect/Field:setAccessible	(Z)V
    //   20: aconst_null
    //   21: astore 4
    //   23: ldc 37
    //   25: invokevirtual 55	java/lang/Class:getDeclaredClasses	()[Ljava/lang/Class;
    //   28: astore 6
    //   30: aload 6
    //   32: arraylength
    //   33: istore_2
    //   34: iconst_0
    //   35: istore_1
    //   36: aload 4
    //   38: astore_3
    //   39: iload_1
    //   40: iload_2
    //   41: if_icmpge +32 -> 73
    //   44: aload 6
    //   46: iload_1
    //   47: aaload
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 59	java/lang/Class:getName	()Ljava/lang/String;
    //   53: ldc 61
    //   55: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   58: ifeq +52 -> 110
    //   61: aload_3
    //   62: invokevirtual 71	java/lang/Class:getConstructors	()[Ljava/lang/reflect/Constructor;
    //   65: iconst_0
    //   66: aaload
    //   67: astore_3
    //   68: aload_3
    //   69: iconst_1
    //   70: invokevirtual 74	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   73: aload 5
    //   75: aload_0
    //   76: aload_3
    //   77: iconst_3
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: aload_0
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: invokestatic 80	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   94: aastore
    //   95: invokevirtual 84	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 86	android/os/Handler
    //   101: invokevirtual 90	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   104: ldc 35
    //   106: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: iload_1
    //   111: iconst_1
    //   112: iadd
    //   113: istore_1
    //   114: goto -78 -> 36
    //   117: astore_0
    //   118: ldc 92
    //   120: ldc 94
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_0
    //   129: aastore
    //   130: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: getstatic 106	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   136: ldc2_w 107
    //   139: ldc2_w 109
    //   142: lconst_1
    //   143: iconst_0
    //   144: invokevirtual 114	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   147: ldc 35
    //   149: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: return
    //   153: astore_0
    //   154: ldc 92
    //   156: ldc 94
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: aastore
    //   166: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: getstatic 106	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   172: ldc2_w 107
    //   175: ldc2_w 109
    //   178: lconst_1
    //   179: iconst_0
    //   180: invokevirtual 114	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   183: ldc 35
    //   185: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: return
    //   189: astore_0
    //   190: ldc 92
    //   192: ldc 94
    //   194: iconst_1
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_0
    //   201: aastore
    //   202: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: ldc 35
    //   207: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: return
    //   211: astore_0
    //   212: ldc 92
    //   214: ldc 94
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_0
    //   223: aastore
    //   224: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: ldc 35
    //   229: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: return
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_0
    //   236: aload_0
    //   237: ifnull +17 -> 254
    //   240: getstatic 106	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
    //   243: ldc2_w 107
    //   246: ldc2_w 109
    //   249: lconst_1
    //   250: iconst_0
    //   251: invokevirtual 114	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   254: ldc 35
    //   256: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_3
    //   260: athrow
    //   261: astore_3
    //   262: goto -26 -> 236
    //   265: astore_3
    //   266: goto -30 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramCamera	Camera
    //   35	79	1	i	int
    //   33	9	2	j	int
    //   38	39	3	localObject1	Object
    //   233	27	3	localObject2	Object
    //   261	1	3	localObject3	Object
    //   265	1	3	localObject4	Object
    //   21	16	4	localObject5	Object
    //   12	62	5	localField	java.lang.reflect.Field
    //   28	17	6	arrayOfClass	java.lang.Class[]
    // Exception table:
    //   from	to	target	type
    //   5	20	117	java/lang/NoSuchFieldException
    //   23	34	117	java/lang/NoSuchFieldException
    //   49	73	117	java/lang/NoSuchFieldException
    //   73	104	117	java/lang/NoSuchFieldException
    //   5	20	153	java/lang/IllegalAccessException
    //   23	34	153	java/lang/IllegalAccessException
    //   49	73	153	java/lang/IllegalAccessException
    //   73	104	153	java/lang/IllegalAccessException
    //   5	20	189	java/lang/reflect/InvocationTargetException
    //   23	34	189	java/lang/reflect/InvocationTargetException
    //   49	73	189	java/lang/reflect/InvocationTargetException
    //   73	104	189	java/lang/reflect/InvocationTargetException
    //   5	20	211	java/lang/InstantiationException
    //   23	34	211	java/lang/InstantiationException
    //   49	73	211	java/lang/InstantiationException
    //   73	104	211	java/lang/InstantiationException
    //   5	20	233	finally
    //   23	34	233	finally
    //   49	73	233	finally
    //   73	104	233	finally
    //   190	205	233	finally
    //   212	227	233	finally
    //   118	133	261	finally
    //   154	169	265	finally
  }
  
  public static u b(int paramInt, Looper arg1)
  {
    AppMethodBeat.i(93010);
    if (com.tencent.mm.compatible.util.d.fv(28)) {
      try
      {
        ??? = new u(c(paramInt, ???));
        AppMethodBeat.o(93010);
        return ???;
      }
      catch (Exception ???)
      {
        ab.printErrStackTrace("MicroMsg.MMCamera", ???, "opnImpl error, try camera directly, myLooper: %s", new Object[] { Looper.myLooper() });
        if (Looper.myLooper() == null)
        {
          Camera[] arrayOfCamera = new Camera[1];
          arrayOfCamera[0] = null;
          com.tencent.mm.sdk.g.d.h(new v.1(arrayOfCamera, paramInt), "MMCamera_openLooperNull").start();
          synchronized (eqH)
          {
            try
            {
              eqH.wait();
              ab.i("MicroMsg.MMCamera", "openCamera wait finish");
              ??? = new u(arrayOfCamera[0]);
              AppMethodBeat.o(93010);
              return ???;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.MMCamera", localException, "MMCamera_openLooperNull wait error", new Object[0]);
              }
            }
          }
        }
        ??? = new u(Camera.open(paramInt));
        AppMethodBeat.o(93010);
        return ???;
      }
    }
    ??? = new u(c(paramInt, ???));
    AppMethodBeat.o(93010);
    return ???;
  }
  
  private static Camera c(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(93011);
    Camera localCamera = Camera.open(paramInt);
    if (paramLooper == null)
    {
      AppMethodBeat.o(93011);
      return localCamera;
    }
    a(localCamera);
    AppMethodBeat.o(93011);
    return localCamera;
  }
  
  public static u c(Looper paramLooper)
  {
    AppMethodBeat.i(93009);
    Camera localCamera = Camera.open();
    if (paramLooper == null)
    {
      paramLooper = new u(localCamera);
      AppMethodBeat.o(93009);
      return paramLooper;
    }
    a(localCamera);
    paramLooper = new u(localCamera);
    AppMethodBeat.o(93009);
    return paramLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.e.v
 * JD-Core Version:    0.7.0.1
 */