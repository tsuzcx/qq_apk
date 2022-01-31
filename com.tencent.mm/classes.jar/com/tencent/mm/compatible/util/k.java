package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.au;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class k
{
  private static final au etl;
  private static volatile boolean etm;
  private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs;
  
  static
  {
    AppMethodBeat.i(93104);
    mLoadedLibs = new HashMap();
    etl = new au("LoadLibrary", TimeUnit.DAYS.toMillis(1L));
    etm = false;
    AppMethodBeat.o(93104);
  }
  
  /* Error */
  public static void a(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 56
    //   7: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 62	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   14: ifne +88 -> 102
    //   17: aload_1
    //   18: ifnonnull +6 -> 24
    //   21: goto +81 -> 102
    //   24: ldc 64
    //   26: iload_2
    //   27: invokestatic 70	junit/framework/Assert:assertFalse	(Ljava/lang/String;Z)V
    //   30: getstatic 48	com/tencent/mm/compatible/util/k:etm	Z
    //   33: ifeq +29 -> 62
    //   36: ldc 72
    //   38: ldc 74
    //   40: iconst_0
    //   41: anewarray 4	java/lang/Object
    //   44: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: aload_1
    //   49: iconst_1
    //   50: invokestatic 83	com/tencent/mm/compatible/util/k:a	(Ljava/lang/String;Ljava/lang/ClassLoader;Z)V
    //   53: ldc 56
    //   55: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: iconst_1
    //   63: putstatic 48	com/tencent/mm/compatible/util/k:etm	Z
    //   66: aload_0
    //   67: aload_1
    //   68: iconst_0
    //   69: invokestatic 83	com/tencent/mm/compatible/util/k:a	(Ljava/lang/String;Ljava/lang/ClassLoader;Z)V
    //   72: iconst_0
    //   73: putstatic 48	com/tencent/mm/compatible/util/k:etm	Z
    //   76: ldc 56
    //   78: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: goto -23 -> 58
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    //   90: astore_0
    //   91: iconst_0
    //   92: putstatic 48	com/tencent/mm/compatible/util/k:etm	Z
    //   95: ldc 56
    //   97: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: athrow
    //   102: iconst_1
    //   103: istore_2
    //   104: goto -80 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   0	107	1	paramClassLoader	ClassLoader
    //   1	103	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	17	84	finally
    //   24	58	84	finally
    //   62	66	84	finally
    //   72	81	84	finally
    //   91	102	84	finally
    //   66	72	90	finally
  }
  
  private static void a(String paramString, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139720);
        ab.i("MicroMsg.LoadLibrary", "initial try load library:" + paramString + ", cl: " + paramClassLoader);
        localObject = (WeakReference)mLoadedLibs.get(paramString);
        if (localObject == null) {
          break label155;
        }
        localObject = (ClassLoader)((WeakReference)localObject).get();
        if (localObject == null) {
          break label155;
        }
        if (localObject == paramClassLoader)
        {
          ab.i("MicroMsg.LoadLibrary", "already loaded library");
          AppMethodBeat.o(139720);
          return;
        }
        if (!paramBoolean)
        {
          paramBoolean = bool1;
          w(4, paramBoolean);
          paramString = new UnsatisfiedLinkError("Library '" + paramString + "' was loaded by a different ClassLoader.");
          AppMethodBeat.o(139720);
          throw paramString;
        }
      }
      finally {}
      paramBoolean = false;
      continue;
      label155:
      ab.i("MicroMsg.LoadLibrary", "try load library:".concat(String.valueOf(paramString)));
      try
      {
        System.loadLibrary(paramString);
        mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
        if (paramBoolean) {
          break label376;
        }
        bool1 = true;
        w(1, bool1);
        AppMethodBeat.o(139720);
      }
      catch (UnsatisfiedLinkError paramClassLoader)
      {
        localObject = lq(paramString);
        if (localObject == null) {
          break label381;
        }
      }
      if (((String)localObject).isEmpty())
      {
        break label381;
        label231:
        w(2, paramBoolean);
        paramString = "Fail to find full path of lib: ".concat(String.valueOf(paramString));
        ab.w("MicroMsg.LoadLibrary", paramString);
        paramString = new UnsatisfiedLinkError(paramString);
        paramString.initCause(paramClassLoader);
        AppMethodBeat.o(139720);
        throw paramString;
      }
      else
      {
        ab.i("MicroMsg.LoadLibrary", "Full path was found: [%s,%s]", new Object[] { paramString, localObject });
        try
        {
          System.load((String)localObject);
          if (!paramBoolean) {}
          for (bool1 = true;; bool1 = false)
          {
            w(1, bool1);
            AppMethodBeat.o(139720);
            break;
          }
          try
          {
            Thread.sleep(500L);
            for (;;)
            {
              try
              {
                System.load((String)localObject);
                if (paramBoolean) {
                  continue;
                }
                bool1 = true;
                w(1, bool1);
                AppMethodBeat.o(139720);
              }
              catch (UnsatisfiedLinkError paramString)
              {
                if (paramBoolean) {
                  continue;
                }
                paramBoolean = true;
                continue;
              }
              w(3, paramBoolean);
              AppMethodBeat.o(139720);
              break;
              paramBoolean = false;
            }
          }
          catch (Throwable paramString)
          {
            break label330;
          }
        }
        catch (UnsatisfiedLinkError paramString) {}
      }
    }
    for (;;)
    {
      label330:
      label376:
      bool1 = false;
      break;
      label381:
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        break label231;
      }
      paramBoolean = false;
      break label231;
      bool1 = false;
    }
  }
  
  public static boolean lp(String paramString)
  {
    try
    {
      AppMethodBeat.i(93101);
      boolean bool = mLoadedLibs.containsKey(paramString);
      AppMethodBeat.o(93101);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String lq(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 194
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 2
    //   10: invokevirtual 200	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   13: astore_1
    //   14: ldc 122
    //   16: ldc 202
    //   18: iconst_1
    //   19: anewarray 196	java/lang/Class
    //   22: dup
    //   23: iconst_0
    //   24: ldc 137
    //   26: aastore
    //   27: invokevirtual 206	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   30: astore_2
    //   31: aload_2
    //   32: iconst_1
    //   33: invokevirtual 212	java/lang/reflect/Method:setAccessible	(Z)V
    //   36: aload_2
    //   37: aload_1
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: aastore
    //   46: invokevirtual 216	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 137	java/lang/String
    //   52: astore_0
    //   53: ldc 194
    //   55: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_0
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: goto -13 -> 53
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramString	String
    //   13	25	1	localClassLoader	ClassLoader
    //   30	7	2	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   8	53	63	java/lang/Throwable
    //   3	8	69	finally
    //   8	53	69	finally
    //   53	58	69	finally
  }
  
  private static void w(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(139721);
    if (paramBoolean)
    {
      AppMethodBeat.o(139721);
      return;
    }
    if (!etl.apw("rpt_idkey_1073_0_".concat(String.valueOf(paramInt))))
    {
      AppMethodBeat.o(139721);
      return;
    }
    try
    {
      ab.d("MicroMsg.LoadLibrary", "[+] Report idkey, id:%s, totalCountKey:%s, specValueKey:%s, specValue:%s", new Object[] { Integer.valueOf(1073), Integer.valueOf(0), Integer.valueOf(paramInt), Integer.valueOf(1) });
      e.qrI.d(1073, paramInt, 0, 1, true);
      AppMethodBeat.o(139721);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.k
 * JD-Core Version:    0.7.0.1
 */