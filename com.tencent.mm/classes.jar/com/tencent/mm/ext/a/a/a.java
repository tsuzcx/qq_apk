package com.tencent.mm.ext.a.a;

import android.net.LocalServerSocket;
import android.util.Log;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class a
{
  private static final Set<String> lYX;
  private static final List<b> lYY;
  private static final Map<String, ClassLoader> lYZ;
  private static final Pattern lZb;
  private static final Method[] lZc;
  private static final Boolean[] lZd;
  private static final String[] lZe;
  private static final ThreadLocal<Boolean> lZf;
  private static final ThreadLocal<Boolean> lZg;
  private static final a mqk;
  
  static
  {
    AppMethodBeat.i(235367);
    lYX = new TreeSet();
    lYY = new ArrayList();
    lYZ = new ConcurrentHashMap(64);
    mqk = new a("load-lib-spin");
    lZb = Pattern.compile("lib([^\\s/]+?)\\.so");
    lZc = new Method[] { null };
    lZd = new Boolean[] { null };
    lZe = new String[] { null };
    lZf = new ThreadLocal();
    lZg = new ThreadLocal();
    AppMethodBeat.o(235367);
  }
  
  private a()
  {
    AppMethodBeat.i(235353);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(235353);
    throw localUnsupportedOperationException;
  }
  
  private static String DD(String arg0)
  {
    AppMethodBeat.i(235336);
    String str = "lib" + ??? + ".so";
    synchronized (lYX)
    {
      Iterator localIterator = lYX.iterator();
      while (localIterator.hasNext())
      {
        File localFile = new File((String)localIterator.next(), str);
        if ((!localFile.isDirectory()) && (localFile.canRead()))
        {
          str = localFile.getAbsolutePath();
          AppMethodBeat.o(235336);
          return str;
        }
      }
      AppMethodBeat.o(235336);
      return null;
    }
  }
  
  private static void a(UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    AppMethodBeat.i(235320);
    List localList = lYY;
    int i = 0;
    label86:
    for (;;)
    {
      try
      {
        Iterator localIterator = lYY.iterator();
        if (localIterator.hasNext())
        {
          if ((!((b)localIterator.next()).aXd()) || (i != 0)) {
            break label86;
          }
          i = 1;
          break label86;
        }
        if (i == 0)
        {
          AppMethodBeat.o(235320);
          throw paramUnsatisfiedLinkError;
        }
      }
      finally
      {
        AppMethodBeat.o(235320);
      }
      AppMethodBeat.o(235320);
      return;
    }
  }
  
  private static void aQl()
  {
    AppMethodBeat.i(235316);
    synchronized (lYY)
    {
      Iterator localIterator = lYY.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(235316);
  }
  
  /* Error */
  private static String d(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 81	com/tencent/mm/ext/a/a/a:lZc	[Ljava/lang/reflect/Method;
    //   8: astore 4
    //   10: aload 4
    //   12: monitorenter
    //   13: getstatic 81	com/tencent/mm/ext/a/a/a:lZc	[Ljava/lang/reflect/Method;
    //   16: iconst_0
    //   17: aaload
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_3
    //   22: ifnonnull +31 -> 53
    //   25: ldc 197
    //   27: ldc 199
    //   29: iconst_1
    //   30: anewarray 186	java/lang/Class
    //   33: dup
    //   34: iconst_0
    //   35: ldc 87
    //   37: aastore
    //   38: invokevirtual 203	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   41: astore_2
    //   42: aload_2
    //   43: iconst_1
    //   44: invokevirtual 207	java/lang/reflect/Method:setAccessible	(Z)V
    //   47: getstatic 81	com/tencent/mm/ext/a/a/a:lZc	[Ljava/lang/reflect/Method;
    //   50: iconst_0
    //   51: aload_2
    //   52: aastore
    //   53: aload_2
    //   54: aload_1
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: aastore
    //   63: invokevirtual 211	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast 87	java/lang/String
    //   69: astore_0
    //   70: aload 4
    //   72: monitorexit
    //   73: ldc 195
    //   75: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: ldc 213
    //   83: aload_1
    //   84: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokevirtual 220	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_0
    //   91: getstatic 96	com/tencent/mm/ext/a/a/a:lZg	Ljava/lang/ThreadLocal;
    //   94: invokevirtual 223	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   97: checkcast 83	java/lang/Boolean
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +10 -> 112
    //   105: aload_1
    //   106: invokevirtual 226	java/lang/Boolean:booleanValue	()Z
    //   109: ifne +31 -> 140
    //   112: getstatic 96	com/tencent/mm/ext/a/a/a:lZg	Ljava/lang/ThreadLocal;
    //   115: getstatic 230	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   118: invokevirtual 233	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   121: ldc 235
    //   123: aload_0
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 241	com/tencent/liteapp/b/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: getstatic 96	com/tencent/mm/ext/a/a/a:lZg	Ljava/lang/ThreadLocal;
    //   134: getstatic 244	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   137: invokevirtual 233	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   140: aload 4
    //   142: monitorexit
    //   143: ldc 195
    //   145: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_0
    //   151: aload 4
    //   153: monitorexit
    //   154: ldc 195
    //   156: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_0
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString	String
    //   0	161	1	paramClassLoader	ClassLoader
    //   20	34	2	localMethod1	Method
    //   18	4	3	localMethod2	Method
    //   8	144	4	arrayOfMethod	Method[]
    // Exception table:
    //   from	to	target	type
    //   13	19	80	finally
    //   25	53	80	finally
    //   53	70	80	finally
    //   70	73	150	finally
    //   81	101	150	finally
    //   105	112	150	finally
    //   112	140	150	finally
    //   140	143	150	finally
  }
  
  private static void h(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(235349);
    Boolean localBoolean = (Boolean)lZf.get();
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      lZf.set(Boolean.TRUE);
      b.i(paramString1, paramString2, paramVarArgs);
      lZf.set(Boolean.FALSE);
      AppMethodBeat.o(235349);
      return;
    }
    Log.println(2, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(235349);
  }
  
  /* Error */
  public static void load(String paramString)
  {
    // Byte code:
    //   0: ldc_w 262
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 2
    //   8: invokevirtual 266	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   11: pop
    //   12: ldc 2
    //   14: invokevirtual 266	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   17: astore_1
    //   18: getstatic 60	com/tencent/mm/ext/a/a/a:lYZ	Ljava/util/Map;
    //   21: aload_0
    //   22: invokeinterface 271 2 0
    //   27: checkcast 197	java/lang/ClassLoader
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +62 -> 94
    //   35: aload_2
    //   36: aload_1
    //   37: if_acmpeq +50 -> 87
    //   40: new 261	java/lang/UnsatisfiedLinkError
    //   43: dup
    //   44: new 110	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 273
    //   51: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 275
    //   61: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: ldc_w 280
    //   71: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 281	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   84: invokestatic 283	com/tencent/mm/ext/a/a/a:a	(Ljava/lang/UnsatisfiedLinkError;)V
    //   87: ldc_w 262
    //   90: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: aload_0
    //   95: invokestatic 285	com/tencent/mm/ext/a/a/a:DD	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +91 -> 191
    //   103: invokestatic 291	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   106: aload_2
    //   107: invokevirtual 293	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   110: ldc 235
    //   112: ldc_w 295
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_2
    //   126: aastore
    //   127: invokestatic 297	com/tencent/mm/ext/a/a/a:h	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: invokestatic 299	com/tencent/mm/ext/a/a/a:aQl	()V
    //   133: getstatic 60	com/tencent/mm/ext/a/a/a:lYZ	Ljava/util/Map;
    //   136: aload_0
    //   137: aload_1
    //   138: invokeinterface 303 3 0
    //   143: pop
    //   144: ldc_w 262
    //   147: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore_3
    //   152: ldc2_w 304
    //   155: invokestatic 311	java/lang/Thread:sleep	(J)V
    //   158: invokestatic 291	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   161: aload_2
    //   162: invokevirtual 293	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   165: ldc 235
    //   167: ldc_w 313
    //   170: iconst_2
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_0
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload_2
    //   181: aastore
    //   182: invokestatic 297	com/tencent/mm/ext/a/a/a:h	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: invokestatic 299	com/tencent/mm/ext/a/a/a:aQl	()V
    //   188: goto -55 -> 133
    //   191: ldc 235
    //   193: ldc_w 315
    //   196: iconst_2
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload_0
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: aload_1
    //   207: aastore
    //   208: invokestatic 297	com/tencent/mm/ext/a/a/a:h	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: aload_1
    //   213: invokestatic 317	com/tencent/mm/ext/a/a/a:d	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/String;
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull -85 -> 133
    //   221: invokestatic 291	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   224: aload_2
    //   225: invokevirtual 293	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   228: ldc 235
    //   230: ldc_w 295
    //   233: iconst_2
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_0
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: aload_2
    //   244: aastore
    //   245: invokestatic 297	com/tencent/mm/ext/a/a/a:h	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: invokestatic 299	com/tencent/mm/ext/a/a/a:aQl	()V
    //   251: goto -118 -> 133
    //   254: astore_3
    //   255: ldc2_w 318
    //   258: invokestatic 311	java/lang/Thread:sleep	(J)V
    //   261: invokestatic 291	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   264: aload_2
    //   265: invokevirtual 293	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   268: ldc 235
    //   270: ldc_w 313
    //   273: iconst_2
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload_0
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: aload_2
    //   284: aastore
    //   285: invokestatic 297	com/tencent/mm/ext/a/a/a:h	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: invokestatic 299	com/tencent/mm/ext/a/a/a:aQl	()V
    //   291: goto -158 -> 133
    //   294: astore_2
    //   295: goto -162 -> 133
    //   298: astore_3
    //   299: goto -141 -> 158
    //   302: astore_3
    //   303: goto -42 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramString	String
    //   17	196	1	localClassLoader	ClassLoader
    //   30	254	2	localObject1	Object
    //   294	1	2	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   151	1	3	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   254	1	3	localUnsatisfiedLinkError3	UnsatisfiedLinkError
    //   298	1	3	localObject2	Object
    //   302	1	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   103	133	151	java/lang/UnsatisfiedLinkError
    //   221	251	254	java/lang/UnsatisfiedLinkError
    //   261	291	294	java/lang/UnsatisfiedLinkError
    //   152	158	298	finally
    //   255	261	302	finally
  }
  
  static final class a
  {
    private volatile int lZh = 0;
    private LocalServerSocket lZi = null;
    private final String mName;
    
    a(String paramString)
    {
      this.mName = paramString;
    }
    
    protected final void finalize()
    {
      try
      {
        AppMethodBeat.i(235322);
        if (this.lZi != null)
        {
          a.co(this.lZi);
          this.lZi = null;
        }
        super.finalize();
        AppMethodBeat.o(235322);
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean aXd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ext.a.a.a
 * JD-Core Version:    0.7.0.1
 */