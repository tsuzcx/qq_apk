package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.Trace;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class n
{
  static final boolean cCY;
  static m cCZ;
  private static final ReentrantReadWriteLock cDa;
  private static o[] cDb;
  private static final AtomicInteger cDc;
  private static q[] cDd;
  private static c cDe;
  private static final HashSet<String> cDf;
  private static final Map<String, Object> cDg;
  private static final Set<String> cDh;
  private static p cDi;
  private static int cDj;
  private static int cDk;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(208204);
    cDa = new ReentrantReadWriteLock();
    cDb = null;
    cDc = new AtomicInteger(0);
    cDf = new HashSet();
    cDg = new HashMap();
    cDh = Collections.newSetFromMap(new ConcurrentHashMap());
    cDi = null;
    cDk = 0;
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 18) {
        bool = true;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      break label85;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label85:
      break label85;
    }
    cCY = bool;
    AppMethodBeat.o(208204);
  }
  
  public static o[] Qa()
  {
    try
    {
      o[] arrayOfo = cDb;
      return arrayOfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static int Qb()
  {
    AppMethodBeat.i(208128);
    int i = 0;
    cDa.writeLock().lock();
    try
    {
      int j = cDj;
      if ((j & 0x2) != 0) {
        i = 1;
      }
      return i;
    }
    finally
    {
      cDa.writeLock().unlock();
      AppMethodBeat.o(208128);
    }
  }
  
  private static void Qc()
  {
    Object localObject3 = null;
    int i = 0;
    for (;;)
    {
      final Runtime localRuntime;
      final Method localMethod;
      final String str;
      try
      {
        AppMethodBeat.i(208138);
        if (cCZ != null)
        {
          AppMethodBeat.o(208138);
          return;
        }
        localRuntime = Runtime.getRuntime();
        localMethod = Qd();
        if (localMethod == null) {
          break label88;
        }
        bool = true;
        if (!bool) {
          break;
        }
        str = n.a.Qe();
      }
      finally {}
      cCZ = new m()
      {
        /* Error */
        private static String cB(String paramAnonymousString)
        {
          // Byte code:
          //   0: ldc 44
          //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: new 52	java/io/File
          //   8: dup
          //   9: aload_0
          //   10: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
          //   13: astore_2
          //   14: ldc 57
          //   16: invokestatic 63	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
          //   19: astore_0
          //   20: new 65	java/io/FileInputStream
          //   23: dup
          //   24: aload_2
          //   25: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/io/File;)V
          //   28: astore_2
          //   29: sipush 4096
          //   32: newarray byte
          //   34: astore_3
          //   35: aload_2
          //   36: aload_3
          //   37: invokevirtual 74	java/io/InputStream:read	([B)I
          //   40: istore_1
          //   41: iload_1
          //   42: ifle +50 -> 92
          //   45: aload_0
          //   46: aload_3
          //   47: iconst_0
          //   48: iload_1
          //   49: invokevirtual 78	java/security/MessageDigest:update	([BII)V
          //   52: goto -17 -> 35
          //   55: astore_0
          //   56: ldc 44
          //   58: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   61: aload_0
          //   62: athrow
          //   63: astore_3
          //   64: aload_0
          //   65: ifnull +68 -> 133
          //   68: aload_2
          //   69: invokevirtual 84	java/io/InputStream:close	()V
          //   72: ldc 44
          //   74: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   77: aload_3
          //   78: athrow
          //   79: astore_0
          //   80: aload_0
          //   81: invokevirtual 90	java/lang/Exception:toString	()Ljava/lang/String;
          //   84: astore_0
          //   85: ldc 44
          //   87: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   90: aload_0
          //   91: areturn
          //   92: ldc 92
          //   94: iconst_1
          //   95: anewarray 4	java/lang/Object
          //   98: dup
          //   99: iconst_0
          //   100: new 94	java/math/BigInteger
          //   103: dup
          //   104: iconst_1
          //   105: aload_0
          //   106: invokevirtual 98	java/security/MessageDigest:digest	()[B
          //   109: invokespecial 101	java/math/BigInteger:<init>	(I[B)V
          //   112: aastore
          //   113: invokestatic 107	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   116: astore_0
          //   117: aload_2
          //   118: invokevirtual 84	java/io/InputStream:close	()V
          //   121: goto -36 -> 85
          //   124: astore_2
          //   125: aload_0
          //   126: aload_2
          //   127: invokevirtual 113	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
          //   130: goto -58 -> 72
          //   133: aload_2
          //   134: invokevirtual 84	java/io/InputStream:close	()V
          //   137: goto -65 -> 72
          //   140: astore_0
          //   141: goto -61 -> 80
          //   144: astore_0
          //   145: goto -65 -> 80
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	148	0	paramAnonymousString	String
          //   40	9	1	i	int
          //   13	105	2	localObject1	Object
          //   124	10	2	localThrowable	Throwable
          //   34	13	3	arrayOfByte	byte[]
          //   63	15	3	localObject2	Object
          // Exception table:
          //   from	to	target	type
          //   29	35	55	finally
          //   35	41	55	finally
          //   45	52	55	finally
          //   92	117	55	finally
          //   56	63	63	finally
          //   5	29	79	java/io/IOException
          //   72	79	79	java/io/IOException
          //   117	121	79	java/io/IOException
          //   125	130	79	java/io/IOException
          //   133	137	79	java/io/IOException
          //   68	72	124	finally
          //   5	29	140	java/lang/SecurityException
          //   72	79	140	java/lang/SecurityException
          //   117	121	140	java/lang/SecurityException
          //   125	130	140	java/lang/SecurityException
          //   133	137	140	java/lang/SecurityException
          //   5	29	144	java/security/NoSuchAlgorithmException
          //   72	79	144	java/security/NoSuchAlgorithmException
          //   117	121	144	java/security/NoSuchAlgorithmException
          //   125	130	144	java/security/NoSuchAlgorithmException
          //   133	137	144	java/security/NoSuchAlgorithmException
        }
        
        public final void PZ()
        {
          AppMethodBeat.i(208163);
          UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
          AppMethodBeat.o(208163);
          throw localUnsupportedOperationException;
        }
        
        /* Error */
        public final void v(String paramAnonymousString, int paramAnonymousInt)
        {
          // Byte code:
          //   0: iconst_1
          //   1: istore_3
          //   2: ldc 127
          //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   7: aconst_null
          //   8: astore 10
          //   10: aconst_null
          //   11: astore 11
          //   13: aconst_null
          //   14: astore 12
          //   16: aconst_null
          //   17: astore 13
          //   19: aconst_null
          //   20: astore 4
          //   22: aload_0
          //   23: getfield 24	com/facebook/soloader/n$1:cDl	Z
          //   26: ifeq +362 -> 388
          //   29: iload_2
          //   30: iconst_4
          //   31: iand
          //   32: iconst_4
          //   33: if_icmpne +284 -> 317
          //   36: iload_3
          //   37: istore_2
          //   38: iload_2
          //   39: ifeq +283 -> 322
          //   42: aload_0
          //   43: getfield 26	com/facebook/soloader/n$1:cDm	Ljava/lang/String;
          //   46: astore 9
          //   48: aload 10
          //   50: astore 8
          //   52: aload 11
          //   54: astore 5
          //   56: aload 12
          //   58: astore 6
          //   60: aload 13
          //   62: astore 7
          //   64: aload_0
          //   65: getfield 30	com/facebook/soloader/n$1:cDo	Ljava/lang/Runtime;
          //   68: astore 14
          //   70: aload 10
          //   72: astore 8
          //   74: aload 11
          //   76: astore 5
          //   78: aload 12
          //   80: astore 6
          //   82: aload 13
          //   84: astore 7
          //   86: aload 14
          //   88: monitorenter
          //   89: aload_0
          //   90: getfield 32	com/facebook/soloader/n$1:cDp	Ljava/lang/reflect/Method;
          //   93: aload_0
          //   94: getfield 30	com/facebook/soloader/n$1:cDo	Ljava/lang/Runtime;
          //   97: iconst_3
          //   98: anewarray 4	java/lang/Object
          //   101: dup
          //   102: iconst_0
          //   103: aload_1
          //   104: aastore
          //   105: dup
          //   106: iconst_1
          //   107: ldc 8
          //   109: invokevirtual 133	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
          //   112: aastore
          //   113: dup
          //   114: iconst_2
          //   115: aload 9
          //   117: aastore
          //   118: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
          //   121: checkcast 103	java/lang/String
          //   124: astore 5
          //   126: aload 5
          //   128: ifnull +203 -> 331
          //   131: new 141	java/lang/UnsatisfiedLinkError
          //   134: dup
          //   135: aload 5
          //   137: invokespecial 142	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
          //   140: astore 4
          //   142: ldc 127
          //   144: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   147: aload 4
          //   149: athrow
          //   150: astore 10
          //   152: aload 5
          //   154: astore 4
          //   156: aload 4
          //   158: astore 8
          //   160: aload 4
          //   162: astore 5
          //   164: aload 4
          //   166: astore 6
          //   168: aload 4
          //   170: astore 7
          //   172: aload 14
          //   174: monitorexit
          //   175: aload 4
          //   177: astore 8
          //   179: aload 4
          //   181: astore 5
          //   183: aload 4
          //   185: astore 6
          //   187: aload 4
          //   189: astore 7
          //   191: ldc 127
          //   193: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   196: aload 4
          //   198: astore 8
          //   200: aload 4
          //   202: astore 5
          //   204: aload 4
          //   206: astore 6
          //   208: aload 4
          //   210: astore 7
          //   212: aload 10
          //   214: athrow
          //   215: astore 4
          //   217: aload 8
          //   219: astore 5
          //   221: ldc 144
          //   223: aload_1
          //   224: invokestatic 148	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   227: invokevirtual 151	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   230: astore 6
          //   232: aload 6
          //   234: astore 5
          //   236: new 153	java/lang/RuntimeException
          //   239: dup
          //   240: aload 6
          //   242: aload 4
          //   244: invokespecial 156	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
          //   247: astore 4
          //   249: aload 6
          //   251: astore 5
          //   253: ldc 127
          //   255: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   258: aload 6
          //   260: astore 5
          //   262: aload 4
          //   264: athrow
          //   265: astore 4
          //   267: aload 5
          //   269: ifnull +40 -> 309
          //   272: new 158	java/lang/StringBuilder
          //   275: dup
          //   276: ldc 160
          //   278: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   281: aload 5
          //   283: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   286: ldc 167
          //   288: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   291: aload_1
          //   292: invokestatic 169	com/facebook/soloader/n$1:cB	(Ljava/lang/String;)Ljava/lang/String;
          //   295: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   298: ldc 171
          //   300: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   303: aload 9
          //   305: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   308: pop
          //   309: ldc 127
          //   311: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   314: aload 4
          //   316: athrow
          //   317: iconst_0
          //   318: istore_2
          //   319: goto -281 -> 38
          //   322: aload_0
          //   323: getfield 28	com/facebook/soloader/n$1:cDn	Ljava/lang/String;
          //   326: astore 9
          //   328: goto -280 -> 48
          //   331: aload 14
          //   333: monitorexit
          //   334: aload 5
          //   336: ifnull +46 -> 382
          //   339: new 158	java/lang/StringBuilder
          //   342: dup
          //   343: ldc 160
          //   345: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   348: aload 5
          //   350: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   353: ldc 167
          //   355: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   358: aload_1
          //   359: invokestatic 169	com/facebook/soloader/n$1:cB	(Ljava/lang/String;)Ljava/lang/String;
          //   362: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   365: ldc 171
          //   367: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   370: aload 9
          //   372: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   375: pop
          //   376: ldc 127
          //   378: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   381: return
          //   382: ldc 127
          //   384: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   387: return
          //   388: aload_1
          //   389: invokestatic 176	java/lang/System:load	(Ljava/lang/String;)V
          //   392: ldc 127
          //   394: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   397: return
          //   398: astore 4
          //   400: aload 6
          //   402: astore 5
          //   404: goto -183 -> 221
          //   407: astore 4
          //   409: aload 7
          //   411: astore 5
          //   413: goto -192 -> 221
          //   416: astore 10
          //   418: goto -262 -> 156
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	421	0	this	1
          //   0	421	1	paramAnonymousString	String
          //   0	421	2	paramAnonymousInt	int
          //   1	36	3	i	int
          //   20	189	4	localObject1	Object
          //   215	28	4	localIllegalAccessException	java.lang.IllegalAccessException
          //   247	16	4	localRuntimeException	RuntimeException
          //   265	50	4	localObject2	Object
          //   398	1	4	localIllegalArgumentException	java.lang.IllegalArgumentException
          //   407	1	4	localInvocationTargetException	java.lang.reflect.InvocationTargetException
          //   54	358	5	localObject3	Object
          //   58	343	6	localObject4	Object
          //   62	348	7	localObject5	Object
          //   50	168	8	localObject6	Object
          //   46	325	9	str	String
          //   8	63	10	localObject7	Object
          //   150	63	10	localObject8	Object
          //   416	1	10	localObject9	Object
          //   11	64	11	localObject10	Object
          //   14	65	12	localObject11	Object
          //   17	66	13	localObject12	Object
          // Exception table:
          //   from	to	target	type
          //   131	150	150	finally
          //   331	334	150	finally
          //   64	70	215	java/lang/IllegalAccessException
          //   86	89	215	java/lang/IllegalAccessException
          //   172	175	215	java/lang/IllegalAccessException
          //   191	196	215	java/lang/IllegalAccessException
          //   212	215	215	java/lang/IllegalAccessException
          //   64	70	265	finally
          //   86	89	265	finally
          //   172	175	265	finally
          //   191	196	265	finally
          //   212	215	265	finally
          //   221	232	265	finally
          //   236	249	265	finally
          //   253	258	265	finally
          //   262	265	265	finally
          //   64	70	398	java/lang/IllegalArgumentException
          //   86	89	398	java/lang/IllegalArgumentException
          //   172	175	398	java/lang/IllegalArgumentException
          //   191	196	398	java/lang/IllegalArgumentException
          //   212	215	398	java/lang/IllegalArgumentException
          //   64	70	407	java/lang/reflect/InvocationTargetException
          //   86	89	407	java/lang/reflect/InvocationTargetException
          //   172	175	407	java/lang/reflect/InvocationTargetException
          //   191	196	407	java/lang/reflect/InvocationTargetException
          //   212	215	407	java/lang/reflect/InvocationTargetException
          //   89	126	416	finally
        }
      };
      AppMethodBeat.o(208138);
      continue;
      label88:
      boolean bool = false;
    }
    Object localObject2 = null;
    break label166;
    label98:
    localObject3 = localObject2.split(":");
    ArrayList localArrayList = new ArrayList(localObject3.length);
    int j = localObject3.length;
    for (;;)
    {
      if (i < j)
      {
        Object localObject4 = localObject3[i];
        if (!localObject4.contains("!")) {
          localArrayList.add(localObject4);
        }
      }
      else
      {
        localObject3 = TextUtils.join(":", localArrayList);
        break;
        label166:
        if (localObject2 != null) {
          break label98;
        }
        break;
      }
      i += 1;
    }
  }
  
  private static Method Qd()
  {
    AppMethodBeat.i(208150);
    if ((Build.VERSION.SDK_INT < 23) || (Build.VERSION.SDK_INT > 27))
    {
      AppMethodBeat.o(208150);
      return null;
    }
    try
    {
      Method localMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[] { String.class, ClassLoader.class, String.class });
      localMethod.setAccessible(true);
      AppMethodBeat.o(208150);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      AppMethodBeat.o(208150);
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      label68:
      break label68;
    }
  }
  
  private static void a(Context paramContext, ArrayList<o> paramArrayList)
  {
    AppMethodBeat.i(208108);
    if ((cDj & 0x8) != 0)
    {
      cDd = null;
      paramContext = q.l(paramContext, "lib-main");
      try
      {
        SysUtil.v(paramContext);
        AppMethodBeat.o(208108);
        return;
      }
      catch (IOException paramArrayList)
      {
        new StringBuilder("Failed to delete ").append(paramContext.getCanonicalPath());
        AppMethodBeat.o(208108);
        return;
      }
    }
    Object localObject = new File(paramContext.getApplicationInfo().sourceDir);
    ArrayList localArrayList = new ArrayList();
    localObject = new b(paramContext, (File)localObject, "lib-main");
    localArrayList.add(localObject);
    new StringBuilder("adding backup source from : ").append(((b)localObject).toString());
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.getApplicationInfo().splitSourceDirs != null))
    {
      localObject = paramContext.getApplicationInfo().splitSourceDirs;
      int k = localObject.length;
      int j = 0;
      int i = 0;
      while (j < k)
      {
        b localb = new b(paramContext, new File(localObject[j]), "lib-" + i);
        new StringBuilder("adding backup source: ").append(localb.toString());
        localArrayList.add(localb);
        j += 1;
        i += 1;
      }
    }
    cDd = (q[])localArrayList.toArray(new q[localArrayList.size()]);
    paramArrayList.addAll(0, localArrayList);
    AppMethodBeat.o(208108);
  }
  
  public static void a(o[] paramArrayOfo)
  {
    try
    {
      cDb = paramArrayOfo;
      return;
    }
    finally
    {
      paramArrayOfo = finally;
      throw paramArrayOfo;
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    // Byte code:
    //   0: ldc_w 282
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +23 -> 33
    //   13: getstatic 88	com/facebook/soloader/n:cDh	Ljava/util/Set;
    //   16: aload_1
    //   17: invokeinterface 289 2 0
    //   22: ifeq +11 -> 33
    //   25: ldc_w 282
    //   28: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: ldc 2
    //   35: monitorenter
    //   36: getstatic 72	com/facebook/soloader/n:cDf	Ljava/util/HashSet;
    //   39: aload_0
    //   40: invokevirtual 290	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   43: ifeq +14 -> 57
    //   46: ldc 2
    //   48: monitorexit
    //   49: ldc_w 282
    //   52: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: getstatic 77	com/facebook/soloader/n:cDg	Ljava/util/Map;
    //   60: aload_0
    //   61: invokeinterface 295 2 0
    //   66: ifeq +62 -> 128
    //   69: getstatic 77	com/facebook/soloader/n:cDg	Ljava/util/Map;
    //   72: aload_0
    //   73: invokeinterface 299 2 0
    //   78: astore_2
    //   79: ldc 2
    //   81: monitorexit
    //   82: getstatic 59	com/facebook/soloader/n:cDa	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 306	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   91: aload_2
    //   92: monitorenter
    //   93: ldc 2
    //   95: monitorenter
    //   96: getstatic 72	com/facebook/soloader/n:cDf	Ljava/util/HashSet;
    //   99: aload_0
    //   100: invokevirtual 290	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   103: ifeq +59 -> 162
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_2
    //   110: monitorexit
    //   111: getstatic 59	com/facebook/soloader/n:cDa	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   114: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   117: invokevirtual 307	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   120: ldc_w 282
    //   123: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_0
    //   127: ireturn
    //   128: new 4	java/lang/Object
    //   131: dup
    //   132: invokespecial 104	java/lang/Object:<init>	()V
    //   135: astore_2
    //   136: getstatic 77	com/facebook/soloader/n:cDg	Ljava/util/Map;
    //   139: aload_0
    //   140: aload_2
    //   141: invokeinterface 311 3 0
    //   146: pop
    //   147: goto -68 -> 79
    //   150: astore_0
    //   151: ldc 2
    //   153: monitorexit
    //   154: ldc_w 282
    //   157: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: athrow
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_0
    //   166: iload_3
    //   167: aload 4
    //   169: invokestatic 315	com/facebook/soloader/n:d	(Ljava/lang/String;ILandroid/os/StrictMode$ThreadPolicy;)V
    //   172: ldc 2
    //   174: monitorenter
    //   175: getstatic 72	com/facebook/soloader/n:cDf	Ljava/util/HashSet;
    //   178: aload_0
    //   179: invokevirtual 316	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   182: pop
    //   183: ldc 2
    //   185: monitorexit
    //   186: iload_3
    //   187: bipush 16
    //   189: iand
    //   190: ifne +20 -> 210
    //   193: aload_1
    //   194: invokestatic 285	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +13 -> 210
    //   200: getstatic 88	com/facebook/soloader/n:cDh	Ljava/util/Set;
    //   203: aload_1
    //   204: invokeinterface 289 2 0
    //   209: pop
    //   210: aload_2
    //   211: monitorexit
    //   212: getstatic 59	com/facebook/soloader/n:cDa	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   215: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   218: invokevirtual 307	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   221: ldc_w 282
    //   224: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: iconst_1
    //   228: ireturn
    //   229: astore_0
    //   230: ldc 2
    //   232: monitorexit
    //   233: ldc_w 282
    //   236: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_0
    //   240: athrow
    //   241: astore_0
    //   242: aload_2
    //   243: monitorexit
    //   244: ldc_w 282
    //   247: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_0
    //   251: athrow
    //   252: astore_0
    //   253: getstatic 59	com/facebook/soloader/n:cDa	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   256: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   259: invokevirtual 307	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   262: ldc_w 282
    //   265: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 319	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   275: astore_1
    //   276: aload_1
    //   277: ifnull +41 -> 318
    //   280: aload_1
    //   281: ldc_w 321
    //   284: invokevirtual 161	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   287: ifeq +31 -> 318
    //   290: new 10	com/facebook/soloader/n$b
    //   293: dup
    //   294: aload_0
    //   295: aload_1
    //   296: aload_1
    //   297: ldc_w 321
    //   300: invokevirtual 325	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   303: invokevirtual 329	java/lang/String:substring	(I)Ljava/lang/String;
    //   306: invokespecial 332	com/facebook/soloader/n$b:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   309: astore_0
    //   310: ldc_w 282
    //   313: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_0
    //   317: athrow
    //   318: ldc_w 282
    //   321: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_0
    //   325: athrow
    //   326: astore_0
    //   327: ldc 2
    //   329: monitorexit
    //   330: ldc_w 282
    //   333: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload_0
    //   337: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramString1	String
    //   0	338	1	paramString2	String
    //   0	338	2	paramString3	String
    //   0	338	3	paramInt	int
    //   0	338	4	paramThreadPolicy	StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   36	49	150	finally
    //   57	79	150	finally
    //   79	82	150	finally
    //   128	147	150	finally
    //   96	109	229	finally
    //   93	96	241	finally
    //   109	111	241	finally
    //   162	165	241	finally
    //   165	172	241	finally
    //   172	175	241	finally
    //   193	210	241	finally
    //   210	212	241	finally
    //   230	241	241	finally
    //   271	276	241	finally
    //   280	318	241	finally
    //   318	326	241	finally
    //   327	338	241	finally
    //   91	93	252	finally
    //   242	252	252	finally
    //   165	172	270	java/lang/UnsatisfiedLinkError
    //   175	186	326	finally
  }
  
  /* Error */
  public static void aJ(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_1
    //   3: istore_1
    //   4: ldc_w 335
    //   7: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 341	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   13: astore_3
    //   14: getstatic 92	com/facebook/soloader/n:cDk	I
    //   17: ifeq +39 -> 56
    //   20: getstatic 92	com/facebook/soloader/n:cDk	I
    //   23: istore_1
    //   24: iload_1
    //   25: putstatic 92	com/facebook/soloader/n:cDk	I
    //   28: invokestatic 343	com/facebook/soloader/n:Qc	()V
    //   31: aload_0
    //   32: invokestatic 346	com/facebook/soloader/n:aK	(Landroid/content/Context;)V
    //   35: new 348	com/facebook/soloader/l
    //   38: dup
    //   39: invokespecial 349	com/facebook/soloader/l:<init>	()V
    //   42: invokestatic 354	com/facebook/soloader/a/a:b	(Lcom/facebook/soloader/a/b;)V
    //   45: aload_3
    //   46: invokestatic 358	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   49: ldc_w 335
    //   52: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: aload_0
    //   57: ifnull -33 -> 24
    //   60: aload_0
    //   61: invokevirtual 235	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   64: astore 4
    //   66: aload 4
    //   68: getfield 361	android/content/pm/ApplicationInfo:flags	I
    //   71: iconst_1
    //   72: iand
    //   73: ifne +68 -> 141
    //   76: iload_2
    //   77: istore_1
    //   78: new 215	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 363
    //   85: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload 4
    //   90: getfield 361	android/content/pm/ApplicationInfo:flags	I
    //   93: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc_w 365
    //   99: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_1
    //   103: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: goto -83 -> 24
    //   110: astore_0
    //   111: aload_3
    //   112: invokestatic 358	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   115: ldc_w 335
    //   118: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: athrow
    //   123: astore_0
    //   124: new 367	java/lang/RuntimeException
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 370	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   132: astore_0
    //   133: ldc_w 335
    //   136: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: athrow
    //   141: aload 4
    //   143: getfield 361	android/content/pm/ApplicationInfo:flags	I
    //   146: istore_1
    //   147: iload_1
    //   148: sipush 128
    //   151: iand
    //   152: ifeq +8 -> 160
    //   155: iconst_3
    //   156: istore_1
    //   157: goto -79 -> 78
    //   160: iconst_2
    //   161: istore_1
    //   162: goto -84 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramContext	Context
    //   3	159	1	i	int
    //   1	76	2	j	int
    //   13	99	3	localThreadPolicy	StrictMode.ThreadPolicy
    //   64	78	4	localApplicationInfo	ApplicationInfo
    // Exception table:
    //   from	to	target	type
    //   14	24	110	finally
    //   24	45	110	finally
    //   60	76	110	finally
    //   78	107	110	finally
    //   141	147	110	finally
    //   10	14	123	java/io/IOException
    //   45	55	123	java/io/IOException
    //   111	123	123	java/io/IOException
  }
  
  private static void aK(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(208094);
    if (cDb != null)
    {
      AppMethodBeat.o(208094);
      return;
    }
    cDa.writeLock().lock();
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        cDj = 0;
        localArrayList = new ArrayList();
        f(localArrayList);
        if (paramContext != null)
        {
          j = cDk;
          if (Build.VERSION.SDK_INT < 23) {
            break label380;
          }
          if (j == 2)
          {
            bool = SysUtil.a.aL(paramContext);
            if (!bool) {
              continue;
            }
            d locald = new d(paramContext);
            new StringBuilder("adding directAPK source: ").append(locald.toString());
            localArrayList.add(0, locald);
            a(paramContext, localArrayList);
          }
        }
        else
        {
          paramContext = (o[])localArrayList.toArray(new o[localArrayList.size()]);
          int k = Qb();
          i = paramContext.length;
          j = i - 1;
          if (i <= 0) {
            break label329;
          }
          new StringBuilder("Preparing SO source: ").append(paramContext[j]);
          paramContext[j].hi(k);
          i = j;
          continue;
        }
        if ((paramContext.getApplicationInfo().flags & 0x10000000) != 0) {
          break label380;
        }
        bool = true;
        continue;
        switch (cDk)
        {
        case 2: 
          paramContext = new RuntimeException("Unsupported app type, we should not reach here");
          AppMethodBeat.o(208094);
          throw paramContext;
        }
      }
      finally
      {
        cDa.writeLock().unlock();
        AppMethodBeat.o(208094);
      }
      i = 1;
      int j = i;
      if (Build.VERSION.SDK_INT <= 17) {
        j = i | 0x1;
      }
      cDe = new c(paramContext, j);
      new StringBuilder("adding application source: ").append(cDe.toString());
      localArrayList.add(0, cDe);
      continue;
      label329:
      cDb = paramContext;
      cDc.getAndIncrement();
      new StringBuilder("init finish: ").append(cDb.length).append(" SO sources prepared");
      cDa.writeLock().unlock();
      AppMethodBeat.o(208094);
      return;
      label380:
      boolean bool = false;
    }
  }
  
  static void c(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    AppMethodBeat.i(208179);
    a(paramString, null, null, paramInt, paramThreadPolicy);
    AppMethodBeat.o(208179);
  }
  
  private static Boolean cA(String paramString)
  {
    AppMethodBeat.i(208172);
    if (cDb == null)
    {
      cDa.readLock().lock();
      try
      {
        if (cDb != null) {
          break label229;
        }
        if ("http://www.android.com/".equals(System.getProperty("java.vendor.url")))
        {
          if (isInitialized()) {
            break label229;
          }
          paramString = new IllegalStateException("SoLoader.init() not yet called");
          AppMethodBeat.o(208172);
          throw paramString;
        }
      }
      finally
      {
        cDa.readLock().unlock();
        AppMethodBeat.o(208172);
      }
      try
      {
        if (!cDf.contains(paramString)) {}
        for (boolean bool = true;; bool = false)
        {
          if ((bool) && (cDi == null))
          {
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/facebook/soloader/SoLoader", "loadLibraryOnNonAndroid", "(Ljava/lang/String;)Ljava/lang/Boolean;", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
            System.loadLibrary((String)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/facebook/soloader/SoLoader", "loadLibraryOnNonAndroid", "(Ljava/lang/String;)Ljava/lang/Boolean;", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
          }
          cDa.readLock().unlock();
          AppMethodBeat.o(208172);
          return Boolean.valueOf(bool);
        }
        cDa.readLock().unlock();
      }
      finally
      {
        AppMethodBeat.o(208172);
      }
    }
    label229:
    AppMethodBeat.o(208172);
    return null;
  }
  
  private static void d(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    int i = 0;
    int i1 = 0;
    AppMethodBeat.i(208198);
    cDa.readLock().lock();
    try
    {
      if (cDb == null)
      {
        new StringBuilder("Could not load: ").append(paramString).append(" because no SO source exists");
        paramString = new UnsatisfiedLinkError("couldn't find DSO to load: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(208198);
        throw paramString;
      }
    }
    finally
    {
      cDa.readLock().unlock();
      AppMethodBeat.o(208198);
    }
    cDa.readLock().unlock();
    if (paramThreadPolicy == null) {
      paramThreadPolicy = StrictMode.allowThreadDiskReads();
    }
    for (int m = 1;; m = 0)
    {
      if (cCY) {
        a.e("SoLoader.loadLibrary[", paramString, "]");
      }
      Object localObject3;
      for (;;)
      {
        try
        {
          cDa.readLock().lock();
          int n = 0;
          int j = 0;
          i = j;
          int k;
          if (j == 0)
          {
            i = j;
            k = j;
          }
          try
          {
            if (n < cDb.length)
            {
              k = j;
              j = cDb[n].a(paramString, paramInt, paramThreadPolicy);
              if (j != 3) {
                continue;
              }
              k = j;
              if (cDd == null) {
                continue;
              }
              k = j;
              q[] arrayOfq = cDd;
              k = j;
              int i2 = arrayOfq.length;
              n = 0;
              i = j;
              if (n < i2)
              {
                localObject3 = arrayOfq[n];
                k = j;
                ((q)localObject3).cD(paramString);
                k = j;
                i = ((q)localObject3).a(paramString, paramInt, paramThreadPolicy);
                if (i != 1) {
                  continue;
                }
              }
            }
          }
          finally
          {
            i = k;
            cDa.readLock().unlock();
            i = k;
            AppMethodBeat.o(208198);
            i = k;
          }
        }
        finally {}
        try
        {
          cDa.readLock().unlock();
          if (cCY) {
            Trace.endSection();
          }
          if (m != 0) {
            StrictMode.setThreadPolicy(paramThreadPolicy);
          }
          if ((i != 0) && (i != 3)) {
            break label615;
          }
          paramString = new StringBuilder("couldn't find DSO to load: ").append(paramString);
          cDa.readLock().lock();
          paramInt = i1;
          if (paramInt >= cDb.length) {
            break label537;
          }
          paramString.append("\n\tSoSource ").append(paramInt).append(": ").append(cDb[paramInt].toString());
          paramInt += 1;
          continue;
          n += 1;
        }
        finally
        {
          break label422;
        }
        n += 1;
      }
      label422:
      if (cCY) {
        Trace.endSection();
      }
      if (m != 0) {
        StrictMode.setThreadPolicy(paramThreadPolicy);
      }
      if ((i == 0) || (i == 3))
      {
        localObject3 = new StringBuilder("couldn't find DSO to load: ").append(paramString);
        paramThreadPolicy = localThrowable.getMessage();
        paramString = paramThreadPolicy;
        if (paramThreadPolicy == null) {
          paramString = localThrowable.toString();
        }
        ((StringBuilder)localObject3).append(" caused by: ").append(paramString);
        ((StringBuilder)localObject3).append(" result: ").append(i);
        paramString = new UnsatisfiedLinkError(((StringBuilder)localObject3).toString());
        paramString.initCause(localThrowable);
        AppMethodBeat.o(208198);
        throw paramString;
        label537:
        if (cDe != null)
        {
          paramThreadPolicy = c.aI(cDe.PR());
          paramString.append("\n\tNative lib dir: ").append(paramThreadPolicy.getAbsolutePath()).append("\n");
        }
        cDa.readLock().unlock();
        paramString.append(" result: ").append(i);
        paramString = new UnsatisfiedLinkError(paramString.toString());
        AppMethodBeat.o(208198);
        throw paramString;
      }
      label615:
      AppMethodBeat.o(208198);
      return;
    }
  }
  
  private static boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(208185);
    boolean bool1 = false;
    boolean bool2;
    int i;
    int j;
    try
    {
      do
      {
        bool2 = a(paramString1, paramString2, null, paramInt, null);
        i = 0;
        bool1 = bool2;
      } while (i != 0);
      AppMethodBeat.o(208185);
      return bool2;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      j = cDc.get();
      cDa.writeLock().lock();
    }
    for (;;)
    {
      try
      {
        if ((cDe != null) && (cDe.PQ()))
        {
          new StringBuilder("sApplicationSoSource updated during load: ").append(paramString1).append(", attempting load again.");
          cDc.getAndIncrement();
          i = 1;
          cDa.writeLock().unlock();
          bool2 = bool1;
          if (cDc.get() != j) {
            break;
          }
          AppMethodBeat.o(208185);
          throw localUnsatisfiedLinkError;
        }
      }
      catch (IOException paramString1)
      {
        paramString1 = new RuntimeException(paramString1);
        AppMethodBeat.o(208185);
        throw paramString1;
      }
      finally
      {
        cDa.writeLock().unlock();
        AppMethodBeat.o(208185);
      }
      i = 0;
    }
  }
  
  private static void f(ArrayList<o> paramArrayList)
  {
    AppMethodBeat.i(208120);
    String str = System.getenv("LD_LIBRARY_PATH");
    Object localObject = str;
    if (str == null) {
      if (!SysUtil.is64Bit()) {
        break label79;
      }
    }
    label79:
    for (localObject = "/vendor/lib64:/system/lib64";; localObject = "/vendor/lib:/system/lib")
    {
      localObject = ((String)localObject).split(":");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramArrayList.add(new e(new File(localObject[i]), 2));
        i += 1;
      }
    }
    AppMethodBeat.o(208120);
  }
  
  /* Error */
  private static boolean isInitialized()
  {
    // Byte code:
    //   0: ldc_w 598
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 59	com/facebook/soloader/n:cDa	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   9: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   12: invokevirtual 306	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   15: getstatic 61	com/facebook/soloader/n:cDb	[Lcom/facebook/soloader/o;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnull +22 -> 42
    //   23: iconst_1
    //   24: istore_0
    //   25: getstatic 59	com/facebook/soloader/n:cDa	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   28: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   31: invokevirtual 307	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   34: ldc_w 598
    //   37: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload_0
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_0
    //   44: goto -19 -> 25
    //   47: astore_1
    //   48: getstatic 59	com/facebook/soloader/n:cDa	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   51: invokevirtual 303	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   54: invokevirtual 307	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   57: ldc_w 598
    //   60: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	20	0	bool	boolean
    //   18	2	1	arrayOfo	o[]
    //   47	17	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	19	47	finally
  }
  
  public static boolean loadLibrary(String paramString)
  {
    AppMethodBeat.i(208157);
    boolean bool = w(paramString, 0);
    AppMethodBeat.o(208157);
    return bool;
  }
  
  public static boolean w(String paramString, int paramInt)
  {
    AppMethodBeat.i(208166);
    Boolean localBoolean = cA(paramString);
    if (localBoolean != null)
    {
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(208166);
      return bool;
    }
    if (((cDk == 2) || (cDk == 3)) && (cDi != null))
    {
      AppMethodBeat.o(208166);
      return true;
    }
    boolean bool = d(System.mapLibraryName(paramString), paramString, 0);
    AppMethodBeat.o(208166);
    return bool;
  }
  
  public static final class b
    extends UnsatisfiedLinkError
  {
    b(Throwable paramThrowable, String paramString)
    {
      super();
      AppMethodBeat.i(208111);
      initCause(paramThrowable);
      AppMethodBeat.o(208111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.n
 * JD-Core Version:    0.7.0.1
 */