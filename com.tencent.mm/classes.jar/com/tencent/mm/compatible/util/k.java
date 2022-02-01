package com.tencent.mm.compatible.util;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

public final class k
{
  private static final Set<String> lYX;
  private static final List<k.b> lYY;
  private static final Map<String, ClassLoader> lYZ;
  private static final a lZa;
  private static final Pattern lZb;
  private static final Method[] lZc;
  private static final Boolean[] lZd;
  private static final String[] lZe;
  private static final ThreadLocal<Boolean> lZf;
  private static final ThreadLocal<Boolean> lZg;
  
  static
  {
    AppMethodBeat.i(125079);
    lYX = new TreeSet();
    lYY = new ArrayList();
    lYZ = new ConcurrentHashMap(64);
    lZa = new a("load-lib-spin");
    lZb = Pattern.compile("lib([^\\s/]+?)\\.so");
    lZc = new Method[] { null };
    lZd = new Boolean[] { null };
    lZe = new String[] { null };
    lZf = new ThreadLocal();
    lZg = new ThreadLocal();
    AppMethodBeat.o(125079);
  }
  
  private k()
  {
    AppMethodBeat.i(125077);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(125077);
    throw localUnsupportedOperationException;
  }
  
  private static long C(File paramFile)
  {
    AppMethodBeat.i(125073);
    CRC32 localCRC32 = new CRC32();
    byte[] arrayOfByte = new byte[4096];
    try
    {
      localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
      try
      {
        for (;;)
        {
          int i = localBufferedInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localCRC32.update(arrayOfByte, 0, i);
        }
        closeQuietly(localBufferedInputStream);
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        long l;
        BufferedInputStream localBufferedInputStream = null;
      }
    }
    AppMethodBeat.o(125073);
    throw paramFile;
    l = localCRC32.getValue();
    closeQuietly(localBufferedInputStream);
    AppMethodBeat.o(125073);
    return l;
  }
  
  public static void DA(String paramString)
  {
    AppMethodBeat.i(125061);
    ClassLoader localClassLoader1 = k.class.getClassLoader();
    ClassLoader localClassLoader2 = (ClassLoader)lYZ.get(paramString);
    if (localClassLoader2 != null)
    {
      if (localClassLoader2 != localClassLoader1) {
        a(new UnsatisfiedLinkError("Library " + paramString + "to be loaded by classloader: " + localClassLoader1 + " has already loaded by classloader: " + localClassLoader2));
      }
      AppMethodBeat.o(125061);
      return;
    }
    b(paramString, localClassLoader1);
    lYZ.put(paramString, localClassLoader1);
    AppMethodBeat.o(125061);
  }
  
  public static boolean DB(String paramString)
  {
    AppMethodBeat.i(125062);
    boolean bool = lYZ.containsKey(paramString);
    AppMethodBeat.o(125062);
    return bool;
  }
  
  private static String DC(String paramString)
  {
    AppMethodBeat.i(125063);
    paramString = "lib" + paramString + ".so";
    AppMethodBeat.o(125063);
    return paramString;
  }
  
  private static String DD(String arg0)
  {
    AppMethodBeat.i(125066);
    String str = DC(???);
    synchronized (lYX)
    {
      Iterator localIterator = lYX.iterator();
      while (localIterator.hasNext())
      {
        File localFile = new File((String)localIterator.next(), str);
        if ((!localFile.isDirectory()) && (localFile.canRead()))
        {
          str = localFile.getAbsolutePath();
          AppMethodBeat.o(125066);
          return str;
        }
      }
      AppMethodBeat.o(125066);
      return null;
    }
  }
  
  public static void Dz(String paramString)
  {
    AppMethodBeat.i(125057);
    synchronized (lYX)
    {
      lYX.add(paramString);
      a(2, "MicroMsg.LoadLibrary", "[+] Prior library search path '%s' added.", new Object[] { paramString });
      AppMethodBeat.o(125057);
      return;
    }
  }
  
  private static String G(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125068);
    locala = lZa;
    try
    {
      lZa.lock();
      paramString = DC(paramString);
      paramContext = new File(dj(paramContext), paramString);
      if ((!paramContext.isDirectory()) && (paramContext.canRead())) {
        paramContext = paramContext.getAbsolutePath();
      }
    }
    finally
    {
      lZa.unlock();
      AppMethodBeat.o(125068);
    }
    try
    {
      lZa.unlock();
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(125068);
    }
    lZa.unlock();
    AppMethodBeat.o(125068);
    return null;
  }
  
  /* Error */
  private static String H(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 268
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 88	com/tencent/mm/compatible/util/k:lZe	[Ljava/lang/String;
    //   9: astore 9
    //   11: aload 9
    //   13: monitorenter
    //   14: getstatic 88	com/tencent/mm/compatible/util/k:lZe	[Ljava/lang/String;
    //   17: iconst_0
    //   18: aaload
    //   19: astore 7
    //   21: aload 7
    //   23: ifnonnull +283 -> 306
    //   26: getstatic 274	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 21
    //   31: if_icmplt +156 -> 187
    //   34: invokestatic 277	com/tencent/mm/compatible/util/k:awm	()Z
    //   37: ifeq +142 -> 179
    //   40: getstatic 282	android/os/Build:SUPPORTED_64_BIT_ABIS	[Ljava/lang/String;
    //   43: astore 4
    //   45: new 284	java/util/zip/ZipFile
    //   48: dup
    //   49: aload_0
    //   50: invokevirtual 290	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   53: getfield 296	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   56: invokespecial 297	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   59: astore 5
    //   61: aload 5
    //   63: astore_0
    //   64: aload 4
    //   66: arraylength
    //   67: istore_3
    //   68: iconst_0
    //   69: istore_2
    //   70: aconst_null
    //   71: astore_0
    //   72: iload_2
    //   73: iload_3
    //   74: if_icmpge +278 -> 352
    //   77: aload 4
    //   79: iload_2
    //   80: aaload
    //   81: astore 8
    //   83: aload 5
    //   85: astore_0
    //   86: new 158	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 299
    //   93: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 8
    //   98: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 301
    //   104: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 6
    //   116: aload 5
    //   118: astore_0
    //   119: aload 5
    //   121: aload 6
    //   123: invokevirtual 305	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   126: ifnull +121 -> 247
    //   129: aload 6
    //   131: astore_0
    //   132: aload 8
    //   134: astore_1
    //   135: aload_1
    //   136: ifnonnull +21 -> 157
    //   139: aload 5
    //   141: astore_0
    //   142: iconst_4
    //   143: ldc 243
    //   145: ldc_w 307
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aconst_null
    //   156: astore_0
    //   157: aload 5
    //   159: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   162: getstatic 88	com/tencent/mm/compatible/util/k:lZe	[Ljava/lang/String;
    //   165: iconst_0
    //   166: aload_1
    //   167: aastore
    //   168: aload 9
    //   170: monitorexit
    //   171: ldc_w 268
    //   174: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_0
    //   178: areturn
    //   179: getstatic 310	android/os/Build:SUPPORTED_32_BIT_ABIS	[Ljava/lang/String;
    //   182: astore 4
    //   184: goto -139 -> 45
    //   187: getstatic 313	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   190: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifne +38 -> 231
    //   196: iconst_2
    //   197: anewarray 86	java/lang/String
    //   200: astore 4
    //   202: aload 4
    //   204: iconst_0
    //   205: getstatic 322	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   208: aastore
    //   209: aload 4
    //   211: iconst_1
    //   212: getstatic 313	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   215: aastore
    //   216: goto -171 -> 45
    //   219: astore_0
    //   220: aload 9
    //   222: monitorexit
    //   223: ldc_w 268
    //   226: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_0
    //   230: athrow
    //   231: iconst_1
    //   232: anewarray 86	java/lang/String
    //   235: astore 4
    //   237: aload 4
    //   239: iconst_0
    //   240: getstatic 322	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   243: aastore
    //   244: goto -199 -> 45
    //   247: iload_2
    //   248: iconst_1
    //   249: iadd
    //   250: istore_2
    //   251: aload 6
    //   253: astore_0
    //   254: goto -182 -> 72
    //   257: astore 4
    //   259: aconst_null
    //   260: astore_1
    //   261: aload_1
    //   262: astore_0
    //   263: new 324	java/lang/IllegalStateException
    //   266: dup
    //   267: aload 4
    //   269: invokespecial 327	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   272: astore 4
    //   274: aload_1
    //   275: astore_0
    //   276: ldc_w 268
    //   279: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aload_1
    //   283: astore_0
    //   284: aload 4
    //   286: athrow
    //   287: astore 4
    //   289: aload_0
    //   290: astore_1
    //   291: aload 4
    //   293: astore_0
    //   294: aload_1
    //   295: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   298: ldc_w 268
    //   301: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_0
    //   305: athrow
    //   306: new 158	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 299
    //   313: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: aload 7
    //   318: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 301
    //   324: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_1
    //   328: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore_0
    //   335: goto -167 -> 168
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_1
    //   341: goto -47 -> 294
    //   344: astore 4
    //   346: aload 5
    //   348: astore_1
    //   349: goto -88 -> 261
    //   352: aload 7
    //   354: astore_1
    //   355: goto -220 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramContext	Context
    //   0	358	1	paramString	String
    //   69	182	2	i	int
    //   67	8	3	j	int
    //   43	195	4	arrayOfString1	String[]
    //   257	11	4	localIOException1	java.io.IOException
    //   272	13	4	localIllegalStateException	IllegalStateException
    //   287	5	4	localObject	Object
    //   344	1	4	localIOException2	java.io.IOException
    //   59	288	5	localZipFile	ZipFile
    //   114	138	6	str1	String
    //   19	334	7	str2	String
    //   81	52	8	str3	String
    //   9	212	9	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   14	21	219	finally
    //   26	45	219	finally
    //   157	168	219	finally
    //   168	171	219	finally
    //   179	184	219	finally
    //   187	216	219	finally
    //   231	244	219	finally
    //   294	306	219	finally
    //   306	335	219	finally
    //   45	61	257	java/io/IOException
    //   64	68	287	finally
    //   86	116	287	finally
    //   119	129	287	finally
    //   142	155	287	finally
    //   263	274	287	finally
    //   276	282	287	finally
    //   284	287	287	finally
    //   45	61	338	finally
    //   64	68	344	java/io/IOException
    //   86	116	344	java/io/IOException
    //   119	129	344	java/io/IOException
    //   142	155	344	java/io/IOException
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(125075);
    Boolean localBoolean = (Boolean)lZf.get();
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      lZf.set(Boolean.TRUE);
      switch (paramInt)
      {
      }
      for (;;)
      {
        lZf.set(Boolean.FALSE);
        AppMethodBeat.o(125075);
        return;
        com.tencent.mm.sdk.platformtools.Log.v(paramString1, paramString2, paramVarArgs);
        continue;
        com.tencent.mm.sdk.platformtools.Log.d(paramString1, paramString2, paramVarArgs);
        continue;
        com.tencent.mm.sdk.platformtools.Log.i(paramString1, paramString2, paramVarArgs);
        continue;
        com.tencent.mm.sdk.platformtools.Log.w(paramString1, paramString2, paramVarArgs);
        continue;
        com.tencent.mm.sdk.platformtools.Log.e(paramString1, paramString2, paramVarArgs);
      }
    }
    if (paramVarArgs.length == 0)
    {
      android.util.Log.println(paramInt, paramString1, paramString2);
      AppMethodBeat.o(125075);
      return;
    }
    android.util.Log.println(paramInt, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(125075);
  }
  
  /* Error */
  private static void a(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 372
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 284	java/util/zip/ZipFile
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 290	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   17: getfield 296	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   20: invokespecial 297	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   23: astore 6
    //   25: aload_0
    //   26: aload_1
    //   27: invokestatic 374	com/tencent/mm/compatible/util/k:H	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnonnull +58 -> 90
    //   35: new 376	java/io/FileNotFoundException
    //   38: dup
    //   39: new 158	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 378
    //   46: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 380
    //   56: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 381	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   65: astore_0
    //   66: ldc_w 372
    //   69: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: aload 6
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   82: ldc_w 372
    //   85: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_0
    //   89: athrow
    //   90: aload 6
    //   92: aload_0
    //   93: invokevirtual 305	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   96: astore 8
    //   98: new 220	java/io/File
    //   101: dup
    //   102: aload_2
    //   103: aload_1
    //   104: invokespecial 261	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 230	java/io/File:isDirectory	()Z
    //   112: ifeq +153 -> 265
    //   115: iconst_3
    //   116: ldc 243
    //   118: ldc_w 383
    //   121: iconst_1
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_0
    //   128: invokevirtual 236	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_0
    //   136: invokevirtual 386	java/io/File:delete	()Z
    //   139: pop
    //   140: new 220	java/io/File
    //   143: dup
    //   144: new 158	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 387	java/lang/StringBuilder:<init>	()V
    //   151: aload_0
    //   152: invokevirtual 236	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   155: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 389
    //   161: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 390	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore 7
    //   172: new 392	java/io/BufferedOutputStream
    //   175: dup
    //   176: new 394	java/io/FileOutputStream
    //   179: dup
    //   180: aload 7
    //   182: invokespecial 395	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   185: invokespecial 398	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   188: astore_2
    //   189: new 112	java/io/BufferedInputStream
    //   192: dup
    //   193: aload 6
    //   195: aload 8
    //   197: invokevirtual 402	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   200: invokespecial 120	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   203: astore_1
    //   204: sipush 4096
    //   207: newarray byte
    //   209: astore 8
    //   211: aload_1
    //   212: aload 8
    //   214: invokevirtual 126	java/io/InputStream:read	([B)I
    //   217: istore_3
    //   218: iload_3
    //   219: ifle +99 -> 318
    //   222: aload_2
    //   223: aload 8
    //   225: iconst_0
    //   226: iload_3
    //   227: invokevirtual 407	java/io/OutputStream:write	([BII)V
    //   230: goto -19 -> 211
    //   233: astore_0
    //   234: aload 7
    //   236: invokevirtual 386	java/io/File:delete	()Z
    //   239: pop
    //   240: ldc_w 372
    //   243: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_0
    //   247: athrow
    //   248: astore_0
    //   249: aload_2
    //   250: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   253: aload_1
    //   254: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   257: ldc_w 372
    //   260: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_0
    //   264: athrow
    //   265: aload_0
    //   266: invokevirtual 233	java/io/File:canRead	()Z
    //   269: ifeq -129 -> 140
    //   272: aload 8
    //   274: invokevirtual 412	java/util/zip/ZipEntry:getCrc	()J
    //   277: lstore 4
    //   279: aload_0
    //   280: invokestatic 414	com/tencent/mm/compatible/util/k:C	(Ljava/io/File;)J
    //   283: lload 4
    //   285: lcmp
    //   286: ifne -146 -> 140
    //   289: iconst_3
    //   290: ldc 243
    //   292: ldc_w 416
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload_1
    //   302: aastore
    //   303: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: aload 6
    //   308: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   311: ldc_w 372
    //   314: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: return
    //   318: aload_2
    //   319: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   322: aload_1
    //   323: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   326: aload 7
    //   328: aload_0
    //   329: invokevirtual 420	java/io/File:renameTo	(Ljava/io/File;)Z
    //   332: ifne +53 -> 385
    //   335: new 267	java/io/IOException
    //   338: dup
    //   339: new 158	java/lang/StringBuilder
    //   342: dup
    //   343: ldc_w 422
    //   346: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload 7
    //   351: invokevirtual 236	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   354: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc_w 424
    //   360: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: invokevirtual 236	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   367: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokespecial 425	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   376: astore_0
    //   377: ldc_w 372
    //   380: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload_0
    //   384: athrow
    //   385: aload 6
    //   387: invokestatic 134	com/tencent/mm/compatible/util/k:closeQuietly	(Ljava/lang/Object;)V
    //   390: ldc_w 372
    //   393: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: return
    //   397: astore_0
    //   398: aload 7
    //   400: astore_1
    //   401: goto -323 -> 78
    //   404: astore_0
    //   405: aconst_null
    //   406: astore_2
    //   407: aconst_null
    //   408: astore_1
    //   409: goto -175 -> 234
    //   412: astore_0
    //   413: aconst_null
    //   414: astore_1
    //   415: goto -181 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramContext	Context
    //   0	418	1	paramString	String
    //   0	418	2	paramFile	File
    //   217	10	3	i	int
    //   277	7	4	l	long
    //   23	363	6	localZipFile	ZipFile
    //   1	398	7	localFile	File
    //   96	177	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	31	74	finally
    //   35	74	74	finally
    //   90	140	74	finally
    //   140	172	74	finally
    //   249	265	74	finally
    //   265	306	74	finally
    //   318	385	74	finally
    //   204	211	233	finally
    //   211	218	233	finally
    //   222	230	233	finally
    //   234	248	248	finally
    //   9	25	397	finally
    //   172	189	404	finally
    //   189	204	412	finally
  }
  
  public static void a(k.b paramb)
  {
    AppMethodBeat.i(240831);
    synchronized (lYY)
    {
      if (!lYY.contains(paramb)) {
        lYY.add(paramb);
      }
      AppMethodBeat.o(240831);
      return;
    }
  }
  
  private static void a(UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    AppMethodBeat.i(125059);
    List localList = lYY;
    int i = 0;
    label90:
    for (;;)
    {
      try
      {
        Iterator localIterator = lYY.iterator();
        if (localIterator.hasNext())
        {
          if ((!((k.b)localIterator.next()).aCx()) || (i != 0)) {
            break label90;
          }
          i = 1;
          break label90;
        }
        if (i == 0)
        {
          AppMethodBeat.o(125059);
          throw paramUnsatisfiedLinkError;
        }
      }
      finally
      {
        AppMethodBeat.o(125059);
      }
      AppMethodBeat.o(125059);
      return;
    }
  }
  
  private static void aQl()
  {
    AppMethodBeat.i(125058);
    synchronized (lYY)
    {
      Iterator localIterator = lYY.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(125058);
  }
  
  private static boolean awm()
  {
    AppMethodBeat.i(125070);
    synchronized (lZd)
    {
      Boolean localBoolean2 = lZd[0];
      Boolean localBoolean1 = localBoolean2;
      if (localBoolean2 == null) {
        if (Build.VERSION.SDK_INT < 23) {
          break label60;
        }
      }
      for (localBoolean1 = Boolean.valueOf(Process.is64Bit());; localBoolean1 = Boolean.valueOf(Build.CPU_ABI.contains("64")))
      {
        lZd[0] = localBoolean1;
        boolean bool = localBoolean1.booleanValue();
        AppMethodBeat.o(125070);
        return bool;
        label60:
        if (Build.VERSION.SDK_INT <= 19) {
          break;
        }
      }
      localBoolean1 = Boolean.FALSE;
    }
  }
  
  private static String b(UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    AppMethodBeat.i(125065);
    paramUnsatisfiedLinkError = paramUnsatisfiedLinkError.getMessage();
    if (TextUtils.isEmpty(paramUnsatisfiedLinkError))
    {
      AppMethodBeat.o(125065);
      return null;
    }
    paramUnsatisfiedLinkError = lZb.matcher(paramUnsatisfiedLinkError);
    if (paramUnsatisfiedLinkError.find())
    {
      paramUnsatisfiedLinkError = paramUnsatisfiedLinkError.group(1);
      if (TextUtils.isEmpty(paramUnsatisfiedLinkError))
      {
        AppMethodBeat.o(125065);
        return null;
      }
      AppMethodBeat.o(125065);
      return paramUnsatisfiedLinkError;
    }
    AppMethodBeat.o(125065);
    return null;
  }
  
  /* Error */
  private static void b(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc_w 473
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 475	com/tencent/mm/compatible/util/k:DD	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +86 -> 98
    //   15: invokestatic 481	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: aload_3
    //   19: invokevirtual 484	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   22: iconst_2
    //   23: ldc 243
    //   25: ldc_w 486
    //   28: iconst_2
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_3
    //   39: aastore
    //   40: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: invokestatic 488	com/tencent/mm/compatible/util/k:aQl	()V
    //   46: ldc_w 473
    //   49: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: astore_1
    //   54: ldc2_w 489
    //   57: invokestatic 496	java/lang/Thread:sleep	(J)V
    //   60: invokestatic 481	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   63: aload_3
    //   64: invokevirtual 484	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   67: iconst_2
    //   68: ldc 243
    //   70: ldc_w 498
    //   73: iconst_2
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_3
    //   84: aastore
    //   85: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: invokestatic 488	com/tencent/mm/compatible/util/k:aQl	()V
    //   91: ldc_w 473
    //   94: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: iconst_2
    //   99: ldc 243
    //   101: ldc_w 500
    //   104: iconst_2
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload_0
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload_1
    //   115: aastore
    //   116: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_0
    //   120: aload_1
    //   121: invokestatic 503	com/tencent/mm/compatible/util/k:d	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/String;
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull +87 -> 213
    //   129: invokestatic 481	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   132: aload_3
    //   133: invokevirtual 484	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   136: iconst_2
    //   137: ldc 243
    //   139: ldc_w 486
    //   142: iconst_2
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_0
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_3
    //   153: aastore
    //   154: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: invokestatic 488	com/tencent/mm/compatible/util/k:aQl	()V
    //   160: ldc_w 473
    //   163: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: return
    //   167: astore 4
    //   169: ldc2_w 504
    //   172: invokestatic 496	java/lang/Thread:sleep	(J)V
    //   175: invokestatic 481	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   178: aload_3
    //   179: invokevirtual 484	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   182: iconst_2
    //   183: ldc 243
    //   185: ldc_w 498
    //   188: iconst_2
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_0
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload_3
    //   199: aastore
    //   200: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: invokestatic 488	com/tencent/mm/compatible/util/k:aQl	()V
    //   206: ldc_w 473
    //   209: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: return
    //   213: iconst_4
    //   214: ldc 243
    //   216: ldc_w 507
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: iconst_2
    //   227: ldc 243
    //   229: ldc_w 509
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: iconst_2
    //   240: ldc 243
    //   242: ldc_w 511
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: new 513	com/tencent/mm/hellhoundlib/b/a
    //   255: dup
    //   256: invokespecial 514	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   259: aload_0
    //   260: invokevirtual 518	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   263: astore_3
    //   264: new 4	java/lang/Object
    //   267: dup
    //   268: invokespecial 100	java/lang/Object:<init>	()V
    //   271: astore 4
    //   273: aload 4
    //   275: aload_3
    //   276: invokevirtual 522	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   279: ldc_w 524
    //   282: ldc_w 526
    //   285: ldc_w 527
    //   288: ldc_w 529
    //   291: ldc_w 531
    //   294: ldc_w 532
    //   297: invokestatic 537	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload_3
    //   301: iconst_0
    //   302: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   305: checkcast 86	java/lang/String
    //   308: invokestatic 545	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   311: aload 4
    //   313: ldc_w 524
    //   316: ldc_w 526
    //   319: ldc_w 527
    //   322: ldc_w 529
    //   325: ldc_w 531
    //   328: ldc_w 532
    //   331: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   334: ldc_w 473
    //   337: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: return
    //   341: astore_3
    //   342: ldc 243
    //   344: aload_3
    //   345: ldc_w 551
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 554	com/tencent/mm/compatible/util/k:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: invokestatic 559	com/tencent/mm/compatible/util/h:aQf	()Z
    //   358: ifeq +46 -> 404
    //   361: iconst_2
    //   362: ldc 243
    //   364: ldc_w 561
    //   367: iconst_0
    //   368: anewarray 4	java/lang/Object
    //   371: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload_0
    //   375: invokestatic 563	com/tencent/mm/compatible/util/h:loadLibrary	(Ljava/lang/String;)Z
    //   378: istore_2
    //   379: iload_2
    //   380: ifeq +24 -> 404
    //   383: ldc_w 473
    //   386: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: return
    //   390: astore_3
    //   391: ldc 243
    //   393: aload_3
    //   394: ldc_w 565
    //   397: iconst_0
    //   398: anewarray 4	java/lang/Object
    //   401: invokestatic 554	com/tencent/mm/compatible/util/k:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: aload_0
    //   405: aload_1
    //   406: invokestatic 567	com/tencent/mm/compatible/util/k:c	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   409: ldc_w 473
    //   412: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: return
    //   416: astore_1
    //   417: goto -357 -> 60
    //   420: astore 4
    //   422: goto -247 -> 175
    //   425: astore_3
    //   426: goto -200 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString	String
    //   0	429	1	paramClassLoader	ClassLoader
    //   378	2	2	bool	boolean
    //   10	291	3	localObject1	Object
    //   341	4	3	localThrowable1	Throwable
    //   390	4	3	localThrowable2	Throwable
    //   425	1	3	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   167	1	4	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   271	41	4	localObject2	Object
    //   420	1	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	46	53	java/lang/UnsatisfiedLinkError
    //   129	160	167	java/lang/UnsatisfiedLinkError
    //   252	334	341	finally
    //   374	379	390	finally
    //   54	60	416	finally
    //   169	175	420	finally
    //   175	206	425	java/lang/UnsatisfiedLinkError
  }
  
  private static void b(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(125076);
    Boolean localBoolean = (Boolean)lZg.get();
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      lZg.set(Boolean.TRUE);
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
      lZg.set(Boolean.FALSE);
    }
    AppMethodBeat.o(125076);
  }
  
  /* Error */
  private static void c(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc_w 572
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 66	com/tencent/mm/compatible/util/k:lZa	Lcom/tencent/mm/compatible/util/k$a;
    //   9: astore_2
    //   10: aload_2
    //   11: monitorenter
    //   12: getstatic 66	com/tencent/mm/compatible/util/k:lZa	Lcom/tencent/mm/compatible/util/k$a;
    //   15: invokevirtual 254	com/tencent/mm/compatible/util/k$a:lock	()V
    //   18: invokestatic 578	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   21: astore_3
    //   22: aload_3
    //   23: aload_0
    //   24: invokestatic 206	com/tencent/mm/compatible/util/k:DC	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aload_3
    //   28: invokestatic 258	com/tencent/mm/compatible/util/k:dj	(Landroid/content/Context;)Ljava/io/File;
    //   31: invokestatic 580	com/tencent/mm/compatible/util/k:a	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)V
    //   34: invokestatic 578	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   37: aload_0
    //   38: invokestatic 582	com/tencent/mm/compatible/util/k:G	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +268 -> 311
    //   46: invokestatic 481	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   49: aload_3
    //   50: invokevirtual 484	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   53: iconst_2
    //   54: ldc 243
    //   56: ldc_w 486
    //   59: iconst_2
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_3
    //   70: aastore
    //   71: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: invokestatic 488	com/tencent/mm/compatible/util/k:aQl	()V
    //   77: getstatic 66	com/tencent/mm/compatible/util/k:lZa	Lcom/tencent/mm/compatible/util/k$a;
    //   80: invokevirtual 264	com/tencent/mm/compatible/util/k$a:unlock	()V
    //   83: aload_2
    //   84: monitorexit
    //   85: ldc_w 572
    //   88: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: astore 4
    //   94: ldc2_w 504
    //   97: invokestatic 496	java/lang/Thread:sleep	(J)V
    //   100: invokestatic 481	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   103: aload_3
    //   104: invokevirtual 484	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   107: iconst_2
    //   108: ldc 243
    //   110: ldc_w 498
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_0
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_3
    //   124: aastore
    //   125: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: invokestatic 488	com/tencent/mm/compatible/util/k:aQl	()V
    //   131: goto -54 -> 77
    //   134: astore 4
    //   136: ldc 243
    //   138: aload 4
    //   140: ldc_w 584
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 554	com/tencent/mm/compatible/util/k:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload 4
    //   152: invokestatic 586	com/tencent/mm/compatible/util/k:b	(Ljava/lang/UnsatisfiedLinkError;)Ljava/lang/String;
    //   155: astore 5
    //   157: aload 5
    //   159: ifnull +77 -> 236
    //   162: aload 5
    //   164: aload_0
    //   165: invokevirtual 589	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifne +68 -> 236
    //   171: aload 5
    //   173: aload_1
    //   174: invokestatic 567	com/tencent/mm/compatible/util/k:c	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   177: invokestatic 481	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   180: aload_3
    //   181: invokevirtual 484	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   184: iconst_2
    //   185: ldc 243
    //   187: ldc_w 498
    //   190: iconst_2
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: aastore
    //   198: dup
    //   199: iconst_1
    //   200: aload_3
    //   201: aastore
    //   202: invokestatic 248	com/tencent/mm/compatible/util/k:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: invokestatic 488	com/tencent/mm/compatible/util/k:aQl	()V
    //   208: goto -131 -> 77
    //   211: astore_0
    //   212: aload_0
    //   213: invokestatic 180	com/tencent/mm/compatible/util/k:a	(Ljava/lang/UnsatisfiedLinkError;)V
    //   216: getstatic 66	com/tencent/mm/compatible/util/k:lZa	Lcom/tencent/mm/compatible/util/k$a;
    //   219: invokevirtual 264	com/tencent/mm/compatible/util/k$a:unlock	()V
    //   222: goto -139 -> 83
    //   225: astore_0
    //   226: aload_2
    //   227: monitorexit
    //   228: ldc_w 572
    //   231: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: athrow
    //   236: ldc_w 572
    //   239: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload 4
    //   244: athrow
    //   245: astore_0
    //   246: new 156	java/lang/UnsatisfiedLinkError
    //   249: dup
    //   250: new 158	java/lang/StringBuilder
    //   253: dup
    //   254: ldc_w 591
    //   257: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_0
    //   261: invokevirtual 595	java/lang/Object:getClass	()Ljava/lang/Class;
    //   264: invokevirtual 598	java/lang/Class:getName	()Ljava/lang/String;
    //   267: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 600
    //   273: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: invokevirtual 603	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 177	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   289: astore_1
    //   290: aload_1
    //   291: aload_0
    //   292: invokevirtual 607	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   295: invokevirtual 611	java/lang/UnsatisfiedLinkError:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   298: aload_1
    //   299: invokestatic 180	com/tencent/mm/compatible/util/k:a	(Ljava/lang/UnsatisfiedLinkError;)V
    //   302: getstatic 66	com/tencent/mm/compatible/util/k:lZa	Lcom/tencent/mm/compatible/util/k$a;
    //   305: invokevirtual 264	com/tencent/mm/compatible/util/k$a:unlock	()V
    //   308: goto -225 -> 83
    //   311: new 156	java/lang/UnsatisfiedLinkError
    //   314: dup
    //   315: new 158	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 613
    //   322: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload_0
    //   326: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 615
    //   332: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokespecial 177	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   341: astore_0
    //   342: ldc_w 572
    //   345: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload_0
    //   349: athrow
    //   350: astore_0
    //   351: getstatic 66	com/tencent/mm/compatible/util/k:lZa	Lcom/tencent/mm/compatible/util/k$a;
    //   354: invokevirtual 264	com/tencent/mm/compatible/util/k$a:unlock	()V
    //   357: ldc_w 572
    //   360: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aload_0
    //   364: athrow
    //   365: astore 4
    //   367: goto -267 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramString	String
    //   0	370	1	paramClassLoader	ClassLoader
    //   9	218	2	locala	a
    //   21	180	3	localObject1	Object
    //   92	1	4	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   134	109	4	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   365	1	4	localObject2	Object
    //   155	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   46	77	92	java/lang/UnsatisfiedLinkError
    //   100	131	134	java/lang/UnsatisfiedLinkError
    //   12	42	211	java/lang/UnsatisfiedLinkError
    //   136	157	211	java/lang/UnsatisfiedLinkError
    //   162	208	211	java/lang/UnsatisfiedLinkError
    //   236	245	211	java/lang/UnsatisfiedLinkError
    //   311	350	211	java/lang/UnsatisfiedLinkError
    //   77	83	225	finally
    //   83	85	225	finally
    //   216	222	225	finally
    //   302	308	225	finally
    //   351	365	225	finally
    //   12	42	245	finally
    //   46	77	245	finally
    //   100	131	245	finally
    //   136	157	245	finally
    //   162	208	245	finally
    //   236	245	245	finally
    //   311	350	245	finally
    //   212	216	350	finally
    //   246	302	350	finally
    //   94	100	365	finally
  }
  
  private static void closeQuietly(Object paramObject)
  {
    AppMethodBeat.i(125074);
    if (paramObject == null)
    {
      AppMethodBeat.o(125074);
      return;
    }
    try
    {
      if ((paramObject instanceof Closeable)) {
        ((Closeable)paramObject).close();
      }
    }
    catch (IllegalStateException paramObject)
    {
      AppMethodBeat.o(125074);
      throw paramObject;
      if ((paramObject instanceof AutoCloseable)) {
        ((AutoCloseable)paramObject).close();
      }
    }
    finally
    {
      AppMethodBeat.o(125074);
      return;
    }
    if ((paramObject instanceof ZipFile))
    {
      ((ZipFile)paramObject).close();
      AppMethodBeat.o(125074);
      return;
    }
    if ((paramObject instanceof LocalServerSocket))
    {
      ((LocalServerSocket)paramObject).close();
      AppMethodBeat.o(125074);
      return;
    }
    paramObject = new IllegalStateException(paramObject.getClass().getName() + " is not closeable.");
    AppMethodBeat.o(125074);
    throw paramObject;
  }
  
  /* Error */
  private static String d(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc_w 634
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 80	com/tencent/mm/compatible/util/k:lZc	[Ljava/lang/reflect/Method;
    //   9: astore 4
    //   11: aload 4
    //   13: monitorenter
    //   14: getstatic 80	com/tencent/mm/compatible/util/k:lZc	[Ljava/lang/reflect/Method;
    //   17: iconst_0
    //   18: aaload
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: ifnonnull +32 -> 55
    //   26: ldc 154
    //   28: ldc_w 636
    //   31: iconst_1
    //   32: anewarray 142	java/lang/Class
    //   35: dup
    //   36: iconst_0
    //   37: ldc 86
    //   39: aastore
    //   40: invokevirtual 640	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   43: astore_2
    //   44: aload_2
    //   45: iconst_1
    //   46: invokevirtual 644	java/lang/reflect/Method:setAccessible	(Z)V
    //   49: getstatic 80	com/tencent/mm/compatible/util/k:lZc	[Ljava/lang/reflect/Method;
    //   52: iconst_0
    //   53: aload_2
    //   54: aastore
    //   55: aload_2
    //   56: aload_1
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: aastore
    //   65: invokevirtual 648	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 86	java/lang/String
    //   71: astore_2
    //   72: aload_2
    //   73: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +82 -> 158
    //   79: new 513	com/tencent/mm/hellhoundlib/b/a
    //   82: dup
    //   83: invokespecial 514	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   86: aload_0
    //   87: invokevirtual 518	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   90: astore_0
    //   91: new 4	java/lang/Object
    //   94: dup
    //   95: invokespecial 100	java/lang/Object:<init>	()V
    //   98: astore_3
    //   99: aload_3
    //   100: aload_0
    //   101: invokevirtual 522	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   104: ldc_w 524
    //   107: ldc_w 650
    //   110: ldc_w 651
    //   113: ldc_w 529
    //   116: ldc_w 531
    //   119: ldc_w 532
    //   122: invokestatic 537	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: iconst_0
    //   127: invokevirtual 541	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   130: checkcast 86	java/lang/String
    //   133: invokestatic 545	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   136: aload_3
    //   137: ldc_w 524
    //   140: ldc_w 650
    //   143: ldc_w 651
    //   146: ldc_w 529
    //   149: ldc_w 531
    //   152: ldc_w 532
    //   155: invokestatic 549	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 4
    //   160: monitorexit
    //   161: ldc_w 634
    //   164: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_2
    //   168: areturn
    //   169: astore_0
    //   170: ldc 243
    //   172: aload_0
    //   173: ldc_w 653
    //   176: aload_1
    //   177: invokestatic 656	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 659	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 554	com/tencent/mm/compatible/util/k:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: aload 4
    //   192: monitorexit
    //   193: ldc_w 634
    //   196: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_0
    //   202: aload 4
    //   204: monitorexit
    //   205: ldc_w 634
    //   208: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_0
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   0	213	1	paramClassLoader	ClassLoader
    //   21	147	2	localObject1	Object
    //   19	118	3	localObject2	Object
    //   9	194	4	arrayOfMethod	Method[]
    // Exception table:
    //   from	to	target	type
    //   14	20	169	finally
    //   26	55	169	finally
    //   55	158	169	finally
    //   158	161	201	finally
    //   170	193	201	finally
  }
  
  private static File dj(Context paramContext)
  {
    AppMethodBeat.i(125069);
    paramContext = paramContext.getDir("recovery_lib", 0);
    AppMethodBeat.o(125069);
    return paramContext;
  }
  
  public static String fX(String paramString)
  {
    AppMethodBeat.i(125060);
    String str = DD(paramString);
    if (str != null)
    {
      a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", new Object[] { paramString, str });
      AppMethodBeat.o(125060);
      return str;
    }
    str = d(paramString, k.class.getClassLoader());
    if (str != null)
    {
      a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", new Object[] { paramString, str });
      AppMethodBeat.o(125060);
      return str;
    }
    str = G(MMApplicationContext.getContext(), paramString);
    if (str != null) {
      a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", new Object[] { paramString, str });
    }
    for (;;)
    {
      AppMethodBeat.o(125060);
      return str;
      a(4, "MicroMsg.LoadLibrary", "[-] Fail to find library [%s].", new Object[] { str });
    }
  }
  
  public static void load(String paramString)
  {
    AppMethodBeat.i(240844);
    k.class.getClassLoader();
    DA(paramString);
    AppMethodBeat.o(240844);
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
        AppMethodBeat.i(125056);
        if (this.lZi != null)
        {
          k.co(this.lZi);
          this.lZi = null;
        }
        super.finalize();
        AppMethodBeat.o(125056);
        return;
      }
      finally {}
    }
    
    /* Error */
    final void lock()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 44
      //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 22	com/tencent/mm/compatible/util/k$a:lZi	Landroid/net/LocalServerSocket;
      //   11: ifnull +21 -> 32
      //   14: aload_0
      //   15: aload_0
      //   16: getfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   19: iconst_1
      //   20: iadd
      //   21: putfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   24: ldc 44
      //   26: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   29: aload_0
      //   30: monitorexit
      //   31: return
      //   32: aload_0
      //   33: new 46	android/net/LocalServerSocket
      //   36: dup
      //   37: new 48	java/lang/StringBuilder
      //   40: dup
      //   41: invokespecial 49	java/lang/StringBuilder:<init>	()V
      //   44: aload_0
      //   45: getfield 24	com/tencent/mm/compatible/util/k$a:mName	Ljava/lang/String;
      //   48: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: invokestatic 59	android/os/Process:myUid	()I
      //   54: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   57: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   60: invokespecial 68	android/net/LocalServerSocket:<init>	(Ljava/lang/String;)V
      //   63: putfield 22	com/tencent/mm/compatible/util/k$a:lZi	Landroid/net/LocalServerSocket;
      //   66: aload_0
      //   67: aload_0
      //   68: getfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   71: iconst_1
      //   72: iadd
      //   73: putfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   76: ldc 44
      //   78: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   81: goto -52 -> 29
      //   84: astore_1
      //   85: aload_0
      //   86: monitorexit
      //   87: aload_1
      //   88: athrow
      //   89: astore_1
      //   90: lconst_1
      //   91: invokestatic 74	java/lang/Thread:sleep	(J)V
      //   94: aload_0
      //   95: getfield 22	com/tencent/mm/compatible/util/k$a:lZi	Landroid/net/LocalServerSocket;
      //   98: ifnonnull -66 -> 32
      //   101: ldc 44
      //   103: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   106: goto -77 -> 29
      //   109: astore_1
      //   110: goto -16 -> 94
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	this	a
      //   84	4	1	localObject1	Object
      //   89	1	1	localObject2	Object
      //   109	1	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	29	84	finally
      //   76	81	84	finally
      //   94	106	84	finally
      //   32	76	89	finally
      //   90	94	109	finally
    }
    
    /* Error */
    final void unlock()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 76
      //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   11: ifne +11 -> 22
      //   14: ldc 76
      //   16: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: aload_0
      //   24: getfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   27: iconst_1
      //   28: isub
      //   29: putfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   32: aload_0
      //   33: getfield 20	com/tencent/mm/compatible/util/k$a:lZh	I
      //   36: ifne +22 -> 58
      //   39: aload_0
      //   40: getfield 22	com/tencent/mm/compatible/util/k$a:lZi	Landroid/net/LocalServerSocket;
      //   43: ifnull +15 -> 58
      //   46: aload_0
      //   47: getfield 22	com/tencent/mm/compatible/util/k$a:lZi	Landroid/net/LocalServerSocket;
      //   50: invokestatic 37	com/tencent/mm/compatible/util/k:co	(Ljava/lang/Object;)V
      //   53: aload_0
      //   54: aconst_null
      //   55: putfield 22	com/tencent/mm/compatible/util/k$a:lZi	Landroid/net/LocalServerSocket;
      //   58: ldc 76
      //   60: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   63: goto -44 -> 19
      //   66: astore_1
      //   67: aload_0
      //   68: monitorexit
      //   69: aload_1
      //   70: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	71	0	this	a
      //   66	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	19	66	finally
      //   22	58	66	finally
      //   58	63	66	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.util.k
 * JD-Core Version:    0.7.0.1
 */