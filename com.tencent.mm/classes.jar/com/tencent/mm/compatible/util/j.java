package com.tencent.mm.compatible.util;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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

public final class j
{
  private static final Set<String> gfL;
  private static final List<b> gfM;
  private static final Map<String, ClassLoader> gfN;
  private static final a gfO;
  private static final Pattern gfP;
  private static final Method[] gfQ;
  private static final Boolean[] gfR;
  private static final String[] gfS;
  private static final ThreadLocal<Boolean> gfT;
  private static final ThreadLocal<Boolean> gfU;
  
  static
  {
    AppMethodBeat.i(125079);
    gfL = new TreeSet();
    gfM = new ArrayList();
    gfN = new ConcurrentHashMap(64);
    gfO = new a("load-lib-spin");
    gfP = Pattern.compile("lib([^\\s/]+?)\\.so");
    gfQ = new Method[] { null };
    gfR = new Boolean[] { null };
    gfS = new String[] { null };
    gfT = new ThreadLocal();
    gfU = new ThreadLocal();
    AppMethodBeat.o(125079);
  }
  
  private j()
  {
    AppMethodBeat.i(125077);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(125077);
    throw localUnsupportedOperationException;
  }
  
  /* Error */
  private static String A(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 110
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 89	com/tencent/mm/compatible/util/j:gfS	[Ljava/lang/String;
    //   8: astore 9
    //   10: aload 9
    //   12: monitorenter
    //   13: getstatic 89	com/tencent/mm/compatible/util/j:gfS	[Ljava/lang/String;
    //   16: iconst_0
    //   17: aaload
    //   18: astore 7
    //   20: aload 7
    //   22: ifnonnull +276 -> 298
    //   25: getstatic 116	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 21
    //   30: if_icmplt +152 -> 182
    //   33: invokestatic 120	com/tencent/mm/compatible/util/j:is64BitRuntime	()Z
    //   36: ifeq +138 -> 174
    //   39: getstatic 125	android/os/Build:SUPPORTED_64_BIT_ABIS	[Ljava/lang/String;
    //   42: astore 4
    //   44: new 127	java/util/zip/ZipFile
    //   47: dup
    //   48: aload_0
    //   49: invokevirtual 133	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   52: getfield 139	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   55: invokespecial 140	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   58: astore 5
    //   60: aload 5
    //   62: astore_0
    //   63: aload 4
    //   65: arraylength
    //   66: istore_3
    //   67: iconst_0
    //   68: istore_2
    //   69: aconst_null
    //   70: astore_0
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge +269 -> 342
    //   76: aload 4
    //   78: iload_2
    //   79: aaload
    //   80: astore 8
    //   82: aload 5
    //   84: astore_0
    //   85: new 142	java/lang/StringBuilder
    //   88: dup
    //   89: ldc 144
    //   91: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload 8
    //   96: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 151
    //   101: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 6
    //   113: aload 5
    //   115: astore_0
    //   116: aload 5
    //   118: aload 6
    //   120: invokevirtual 159	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   123: ifnull +118 -> 241
    //   126: aload 6
    //   128: astore_0
    //   129: aload 8
    //   131: astore_1
    //   132: aload_1
    //   133: ifnonnull +20 -> 153
    //   136: aload 5
    //   138: astore_0
    //   139: iconst_4
    //   140: ldc 161
    //   142: ldc 163
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 166	com/tencent/mm/compatible/util/j:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aconst_null
    //   152: astore_0
    //   153: aload 5
    //   155: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   158: getstatic 89	com/tencent/mm/compatible/util/j:gfS	[Ljava/lang/String;
    //   161: iconst_0
    //   162: aload_1
    //   163: aastore
    //   164: aload 9
    //   166: monitorexit
    //   167: ldc 110
    //   169: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_0
    //   173: areturn
    //   174: getstatic 173	android/os/Build:SUPPORTED_32_BIT_ABIS	[Ljava/lang/String;
    //   177: astore 4
    //   179: goto -135 -> 44
    //   182: getstatic 176	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   185: invokestatic 182	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +37 -> 225
    //   191: iconst_2
    //   192: anewarray 87	java/lang/String
    //   195: astore 4
    //   197: aload 4
    //   199: iconst_0
    //   200: getstatic 185	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   203: aastore
    //   204: aload 4
    //   206: iconst_1
    //   207: getstatic 176	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   210: aastore
    //   211: goto -167 -> 44
    //   214: astore_0
    //   215: aload 9
    //   217: monitorexit
    //   218: ldc 110
    //   220: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_0
    //   224: athrow
    //   225: iconst_1
    //   226: anewarray 87	java/lang/String
    //   229: astore 4
    //   231: aload 4
    //   233: iconst_0
    //   234: getstatic 185	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   237: aastore
    //   238: goto -194 -> 44
    //   241: iload_2
    //   242: iconst_1
    //   243: iadd
    //   244: istore_2
    //   245: aload 6
    //   247: astore_0
    //   248: goto -177 -> 71
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_1
    //   255: aload_1
    //   256: astore_0
    //   257: new 187	java/lang/IllegalStateException
    //   260: dup
    //   261: aload 4
    //   263: invokespecial 190	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   266: astore 4
    //   268: aload_1
    //   269: astore_0
    //   270: ldc 110
    //   272: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_1
    //   276: astore_0
    //   277: aload 4
    //   279: athrow
    //   280: astore 4
    //   282: aload_0
    //   283: astore_1
    //   284: aload 4
    //   286: astore_0
    //   287: aload_1
    //   288: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   291: ldc 110
    //   293: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aload_0
    //   297: athrow
    //   298: new 142	java/lang/StringBuilder
    //   301: dup
    //   302: ldc 144
    //   304: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   307: aload 7
    //   309: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc 151
    //   314: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_1
    //   318: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore_0
    //   325: goto -161 -> 164
    //   328: astore_0
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -44 -> 287
    //   334: astore 4
    //   336: aload 5
    //   338: astore_1
    //   339: goto -84 -> 255
    //   342: aload 7
    //   344: astore_1
    //   345: goto -213 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramContext	Context
    //   0	348	1	paramString	String
    //   68	177	2	i	int
    //   66	8	3	j	int
    //   42	190	4	arrayOfString1	String[]
    //   251	11	4	localIOException1	java.io.IOException
    //   266	12	4	localIllegalStateException	IllegalStateException
    //   280	5	4	localObject	Object
    //   334	1	4	localIOException2	java.io.IOException
    //   58	279	5	localZipFile	ZipFile
    //   111	135	6	str1	String
    //   18	325	7	str2	String
    //   80	50	8	str3	String
    //   8	208	9	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   13	20	214	finally
    //   25	44	214	finally
    //   153	164	214	finally
    //   164	167	214	finally
    //   174	179	214	finally
    //   182	211	214	finally
    //   215	218	214	finally
    //   225	238	214	finally
    //   287	298	214	finally
    //   298	325	214	finally
    //   44	60	251	java/io/IOException
    //   63	67	280	finally
    //   85	113	280	finally
    //   116	126	280	finally
    //   139	151	280	finally
    //   257	268	280	finally
    //   270	275	280	finally
    //   277	280	280	finally
    //   44	60	328	finally
    //   63	67	334	java/io/IOException
    //   85	113	334	java/io/IOException
    //   116	126	334	java/io/IOException
    //   139	151	334	java/io/IOException
  }
  
  private static long E(File paramFile)
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
  
  private static void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(125075);
    Boolean localBoolean = (Boolean)gfT.get();
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      gfT.set(Boolean.TRUE);
      switch (paramInt)
      {
      }
      for (;;)
      {
        gfT.set(Boolean.FALSE);
        AppMethodBeat.o(125075);
        return;
        ae.v(paramString1, paramString2, paramVarArgs);
        continue;
        ae.d(paramString1, paramString2, paramVarArgs);
        continue;
        ae.i(paramString1, paramString2, paramVarArgs);
        continue;
        ae.w(paramString1, paramString2, paramVarArgs);
        continue;
        ae.e(paramString1, paramString2, paramVarArgs);
      }
    }
    if (paramVarArgs.length == 0)
    {
      Log.println(paramInt, paramString1, paramString2);
      AppMethodBeat.o(125075);
      return;
    }
    Log.println(paramInt, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(125075);
  }
  
  /* Error */
  private static void a(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc_w 269
    //   6: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 127	java/util/zip/ZipFile
    //   12: dup
    //   13: aload_0
    //   14: invokevirtual 133	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   17: getfield 139	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   20: invokespecial 140	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   23: astore 8
    //   25: aload_0
    //   26: aload_1
    //   27: invokestatic 271	com/tencent/mm/compatible/util/j:A	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnonnull +58 -> 90
    //   35: new 273	java/io/FileNotFoundException
    //   38: dup
    //   39: new 142	java/lang/StringBuilder
    //   42: dup
    //   43: ldc_w 275
    //   46: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 277
    //   56: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokespecial 278	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   65: astore_0
    //   66: ldc_w 269
    //   69: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: aload 8
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   82: ldc_w 269
    //   85: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_0
    //   89: athrow
    //   90: aload 8
    //   92: aload_0
    //   93: invokevirtual 159	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   96: astore_0
    //   97: new 280	java/io/File
    //   100: dup
    //   101: aload_2
    //   102: aload_1
    //   103: invokespecial 283	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   106: astore 7
    //   108: aload 7
    //   110: invokevirtual 286	java/io/File:isDirectory	()Z
    //   113: ifeq +190 -> 303
    //   116: iconst_3
    //   117: ldc 161
    //   119: ldc_w 288
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload 7
    //   130: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 166	com/tencent/mm/compatible/util/j:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 7
    //   139: invokevirtual 294	java/io/File:delete	()Z
    //   142: pop
    //   143: new 280	java/io/File
    //   146: dup
    //   147: new 142	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   154: aload 7
    //   156: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   159: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 297
    //   165: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 298	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore 9
    //   176: new 300	java/io/BufferedOutputStream
    //   179: dup
    //   180: new 302	java/io/FileOutputStream
    //   183: dup
    //   184: aload 9
    //   186: invokespecial 303	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   189: invokespecial 306	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   192: astore_1
    //   193: new 198	java/io/BufferedInputStream
    //   196: dup
    //   197: aload 8
    //   199: aload_0
    //   200: invokevirtual 310	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   203: invokespecial 206	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   206: astore_0
    //   207: aload_1
    //   208: astore_2
    //   209: aload_0
    //   210: astore 6
    //   212: sipush 4096
    //   215: newarray byte
    //   217: astore 10
    //   219: aload_1
    //   220: astore_2
    //   221: aload_0
    //   222: astore 6
    //   224: aload_0
    //   225: aload 10
    //   227: invokevirtual 212	java/io/InputStream:read	([B)I
    //   230: istore_3
    //   231: iload_3
    //   232: ifle +125 -> 357
    //   235: aload_1
    //   236: astore_2
    //   237: aload_0
    //   238: astore 6
    //   240: aload_1
    //   241: aload 10
    //   243: iconst_0
    //   244: iload_3
    //   245: invokevirtual 315	java/io/OutputStream:write	([BII)V
    //   248: goto -29 -> 219
    //   251: astore 7
    //   253: aload_1
    //   254: astore_2
    //   255: aload_0
    //   256: astore 6
    //   258: aload 9
    //   260: invokevirtual 294	java/io/File:delete	()Z
    //   263: pop
    //   264: aload_1
    //   265: astore_2
    //   266: aload_0
    //   267: astore 6
    //   269: ldc_w 269
    //   272: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_1
    //   276: astore_2
    //   277: aload_0
    //   278: astore 6
    //   280: aload 7
    //   282: athrow
    //   283: astore_0
    //   284: aload_2
    //   285: astore_1
    //   286: aload_1
    //   287: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   290: aload 6
    //   292: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   295: ldc_w 269
    //   298: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_0
    //   302: athrow
    //   303: aload 7
    //   305: invokevirtual 318	java/io/File:canRead	()Z
    //   308: ifeq -165 -> 143
    //   311: aload_0
    //   312: invokevirtual 323	java/util/zip/ZipEntry:getCrc	()J
    //   315: lstore 4
    //   317: aload 7
    //   319: invokestatic 325	com/tencent/mm/compatible/util/j:E	(Ljava/io/File;)J
    //   322: lload 4
    //   324: lcmp
    //   325: ifne -182 -> 143
    //   328: iconst_3
    //   329: ldc 161
    //   331: ldc_w 327
    //   334: iconst_1
    //   335: anewarray 4	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: aload_1
    //   341: aastore
    //   342: invokestatic 166	com/tencent/mm/compatible/util/j:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: aload 8
    //   347: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   350: ldc_w 269
    //   353: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: return
    //   357: aload_1
    //   358: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   361: aload_0
    //   362: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   365: aload 9
    //   367: aload 7
    //   369: invokevirtual 331	java/io/File:renameTo	(Ljava/io/File;)Z
    //   372: ifne +54 -> 426
    //   375: new 109	java/io/IOException
    //   378: dup
    //   379: new 142	java/lang/StringBuilder
    //   382: dup
    //   383: ldc_w 333
    //   386: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   389: aload 9
    //   391: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 335
    //   400: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload 7
    //   405: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   408: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokespecial 336	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   417: astore_0
    //   418: ldc_w 269
    //   421: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: aload_0
    //   425: athrow
    //   426: aload 8
    //   428: invokestatic 170	com/tencent/mm/compatible/util/j:closeQuietly	(Ljava/lang/Object;)V
    //   431: ldc_w 269
    //   434: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: return
    //   438: astore_0
    //   439: aload 6
    //   441: astore_1
    //   442: goto -364 -> 78
    //   445: astore_0
    //   446: aconst_null
    //   447: astore_1
    //   448: aconst_null
    //   449: astore 6
    //   451: goto -165 -> 286
    //   454: astore_0
    //   455: aconst_null
    //   456: astore 6
    //   458: goto -172 -> 286
    //   461: astore 7
    //   463: aconst_null
    //   464: astore_1
    //   465: aconst_null
    //   466: astore_0
    //   467: goto -214 -> 253
    //   470: astore 7
    //   472: aconst_null
    //   473: astore_0
    //   474: goto -221 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	paramContext	Context
    //   0	477	1	paramString	String
    //   0	477	2	paramFile	File
    //   230	15	3	i	int
    //   315	8	4	l	long
    //   1	456	6	localContext	Context
    //   106	49	7	localFile1	File
    //   251	153	7	localThrowable1	Throwable
    //   461	1	7	localThrowable2	Throwable
    //   470	1	7	localThrowable3	Throwable
    //   23	404	8	localZipFile	ZipFile
    //   174	216	9	localFile2	File
    //   217	25	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	31	74	finally
    //   35	74	74	finally
    //   90	143	74	finally
    //   143	176	74	finally
    //   286	303	74	finally
    //   303	345	74	finally
    //   357	426	74	finally
    //   212	219	251	java/lang/Throwable
    //   224	231	251	java/lang/Throwable
    //   240	248	251	java/lang/Throwable
    //   212	219	283	finally
    //   224	231	283	finally
    //   240	248	283	finally
    //   258	264	283	finally
    //   269	275	283	finally
    //   280	283	283	finally
    //   9	25	438	finally
    //   176	193	445	finally
    //   193	207	454	finally
    //   176	193	461	java/lang/Throwable
    //   193	207	470	java/lang/Throwable
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(211733);
    synchronized (gfM)
    {
      if (!gfM.contains(paramb)) {
        gfM.add(paramb);
      }
      AppMethodBeat.o(211733);
      return;
    }
  }
  
  private static void a(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(211735);
    String str = vQ(paramString);
    if (str != null) {
      try
      {
        Runtime.getRuntime().load(str);
        a(2, "MicroMsg.LoadLibrary", "[+] Library [%s] was loaded, path: %s", new Object[] { paramString, str });
        aby();
        AppMethodBeat.o(211735);
        return;
      }
      catch (UnsatisfiedLinkError paramClassLoader) {}
    }
    try
    {
      Thread.sleep(50L);
      Runtime.getRuntime().load(str);
      a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s", new Object[] { paramString, str });
      aby();
      AppMethodBeat.o(211735);
      return;
      a(2, "MicroMsg.LoadLibrary", "[+] Try to load library [%s] with cl: %s", new Object[] { paramString, paramClassLoader });
      str = c(paramString, paramClassLoader);
      if (str != null) {
        try
        {
          Runtime.getRuntime().load(str);
          a(2, "MicroMsg.LoadLibrary", "[+] Library [%s] was loaded, path: %s", new Object[] { paramString, str });
          aby();
          AppMethodBeat.o(211735);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {}
      }
    }
    catch (Throwable paramClassLoader)
    {
      try
      {
        Thread.sleep(5L);
        try
        {
          label174:
          Runtime.getRuntime().load(str);
          a(2, "MicroMsg.LoadLibrary", "[+] [RE] Library [%s] was loaded, path: %s", new Object[] { paramString, str });
          aby();
          AppMethodBeat.o(211735);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
        b(paramString, paramClassLoader);
        AppMethodBeat.o(211735);
        return;
        paramClassLoader = paramClassLoader;
      }
      catch (Throwable localThrowable)
      {
        break label174;
      }
    }
  }
  
  private static void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(125076);
    Boolean localBoolean = (Boolean)gfU.get();
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      gfU.set(Boolean.TRUE);
      ae.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
      gfU.set(Boolean.FALSE);
    }
    AppMethodBeat.o(125076);
  }
  
  private static void a(UnsatisfiedLinkError paramUnsatisfiedLinkError)
  {
    AppMethodBeat.i(125059);
    List localList = gfM;
    int i = 0;
    label90:
    for (;;)
    {
      try
      {
        Iterator localIterator = gfM.iterator();
        if (localIterator.hasNext())
        {
          if ((!((b)localIterator.next()).Mi()) || (i != 0)) {
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
  
  private static void aby()
  {
    AppMethodBeat.i(125058);
    synchronized (gfM)
    {
      Iterator localIterator = gfM.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(125058);
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
    paramUnsatisfiedLinkError = gfP.matcher(paramUnsatisfiedLinkError);
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
  @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static void b(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc_w 436
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 67	com/tencent/mm/compatible/util/j:gfO	Lcom/tencent/mm/compatible/util/j$a;
    //   9: astore_2
    //   10: aload_2
    //   11: monitorenter
    //   12: getstatic 67	com/tencent/mm/compatible/util/j:gfO	Lcom/tencent/mm/compatible/util/j$a;
    //   15: invokevirtual 439	com/tencent/mm/compatible/util/j$a:lock	()V
    //   18: invokestatic 445	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   21: astore_3
    //   22: aload_3
    //   23: aload_0
    //   24: invokestatic 448	com/tencent/mm/compatible/util/j:vP	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aload_3
    //   28: invokestatic 452	com/tencent/mm/compatible/util/j:ce	(Landroid/content/Context;)Ljava/io/File;
    //   31: invokestatic 454	com/tencent/mm/compatible/util/j:a	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)V
    //   34: invokestatic 445	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   37: aload_0
    //   38: invokestatic 457	com/tencent/mm/compatible/util/j:z	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +268 -> 311
    //   46: invokestatic 361	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   49: aload_3
    //   50: invokevirtual 364	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   53: iconst_2
    //   54: ldc 161
    //   56: ldc_w 366
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
    //   71: invokestatic 166	com/tencent/mm/compatible/util/j:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: invokestatic 369	com/tencent/mm/compatible/util/j:aby	()V
    //   77: getstatic 67	com/tencent/mm/compatible/util/j:gfO	Lcom/tencent/mm/compatible/util/j$a;
    //   80: invokevirtual 460	com/tencent/mm/compatible/util/j$a:unlock	()V
    //   83: aload_2
    //   84: monitorexit
    //   85: ldc_w 436
    //   88: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: astore 4
    //   94: ldc2_w 386
    //   97: invokestatic 377	java/lang/Thread:sleep	(J)V
    //   100: invokestatic 361	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   103: aload_3
    //   104: invokevirtual 364	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   107: iconst_2
    //   108: ldc 161
    //   110: ldc_w 379
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
    //   125: invokestatic 166	com/tencent/mm/compatible/util/j:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: invokestatic 369	com/tencent/mm/compatible/util/j:aby	()V
    //   131: goto -54 -> 77
    //   134: astore 4
    //   136: ldc 161
    //   138: aload 4
    //   140: ldc_w 462
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 464	com/tencent/mm/compatible/util/j:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload 4
    //   152: invokestatic 466	com/tencent/mm/compatible/util/j:b	(Ljava/lang/UnsatisfiedLinkError;)Ljava/lang/String;
    //   155: astore 5
    //   157: aload 5
    //   159: ifnull +77 -> 236
    //   162: aload 5
    //   164: aload_0
    //   165: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifne +68 -> 236
    //   171: aload 5
    //   173: aload_1
    //   174: invokestatic 389	com/tencent/mm/compatible/util/j:b	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   177: invokestatic 361	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   180: aload_3
    //   181: invokevirtual 364	java/lang/Runtime:load	(Ljava/lang/String;)V
    //   184: iconst_2
    //   185: ldc 161
    //   187: ldc_w 379
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
    //   202: invokestatic 166	com/tencent/mm/compatible/util/j:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: invokestatic 369	com/tencent/mm/compatible/util/j:aby	()V
    //   208: goto -131 -> 77
    //   211: astore_0
    //   212: aload_0
    //   213: invokestatic 471	com/tencent/mm/compatible/util/j:a	(Ljava/lang/UnsatisfiedLinkError;)V
    //   216: getstatic 67	com/tencent/mm/compatible/util/j:gfO	Lcom/tencent/mm/compatible/util/j$a;
    //   219: invokevirtual 460	com/tencent/mm/compatible/util/j$a:unlock	()V
    //   222: goto -139 -> 83
    //   225: astore_0
    //   226: aload_2
    //   227: monitorexit
    //   228: ldc_w 436
    //   231: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: athrow
    //   236: ldc_w 436
    //   239: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload 4
    //   244: athrow
    //   245: astore_0
    //   246: new 350	java/lang/UnsatisfiedLinkError
    //   249: dup
    //   250: new 142	java/lang/StringBuilder
    //   253: dup
    //   254: ldc_w 473
    //   257: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_0
    //   261: invokevirtual 477	java/lang/Object:getClass	()Ljava/lang/Class;
    //   264: invokevirtual 482	java/lang/Class:getName	()Ljava/lang/String;
    //   267: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 484
    //   273: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_0
    //   277: invokevirtual 485	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 486	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   289: astore_1
    //   290: aload_1
    //   291: aload_0
    //   292: invokevirtual 490	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   295: invokevirtual 494	java/lang/UnsatisfiedLinkError:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   298: aload_1
    //   299: invokestatic 471	com/tencent/mm/compatible/util/j:a	(Ljava/lang/UnsatisfiedLinkError;)V
    //   302: getstatic 67	com/tencent/mm/compatible/util/j:gfO	Lcom/tencent/mm/compatible/util/j$a;
    //   305: invokevirtual 460	com/tencent/mm/compatible/util/j$a:unlock	()V
    //   308: goto -225 -> 83
    //   311: new 350	java/lang/UnsatisfiedLinkError
    //   314: dup
    //   315: new 142	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 496
    //   322: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload_0
    //   326: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 498
    //   332: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokespecial 486	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   341: astore_0
    //   342: ldc_w 436
    //   345: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload_0
    //   349: athrow
    //   350: astore_0
    //   351: getstatic 67	com/tencent/mm/compatible/util/j:gfO	Lcom/tencent/mm/compatible/util/j$a;
    //   354: invokevirtual 460	com/tencent/mm/compatible/util/j$a:unlock	()V
    //   357: ldc_w 436
    //   360: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aload_0
    //   364: athrow
    //   365: astore 4
    //   367: goto -267 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramString	String
    //   0	370	1	paramClassLoader	ClassLoader
    //   9	218	2	locala	a
    //   21	180	3	localObject	Object
    //   92	1	4	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   134	109	4	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   365	1	4	localThrowable	Throwable
    //   155	17	5	str	String
    // Exception table:
    //   from	to	target	type
    //   46	77	92	java/lang/UnsatisfiedLinkError
    //   94	100	134	java/lang/UnsatisfiedLinkError
    //   100	131	134	java/lang/UnsatisfiedLinkError
    //   12	42	211	java/lang/UnsatisfiedLinkError
    //   136	157	211	java/lang/UnsatisfiedLinkError
    //   162	208	211	java/lang/UnsatisfiedLinkError
    //   236	245	211	java/lang/UnsatisfiedLinkError
    //   311	350	211	java/lang/UnsatisfiedLinkError
    //   77	83	225	finally
    //   83	85	225	finally
    //   216	222	225	finally
    //   226	228	225	finally
    //   302	308	225	finally
    //   351	365	225	finally
    //   12	42	245	java/lang/Throwable
    //   46	77	245	java/lang/Throwable
    //   100	131	245	java/lang/Throwable
    //   136	157	245	java/lang/Throwable
    //   162	208	245	java/lang/Throwable
    //   236	245	245	java/lang/Throwable
    //   311	350	245	java/lang/Throwable
    //   12	42	350	finally
    //   46	77	350	finally
    //   94	100	350	finally
    //   100	131	350	finally
    //   136	157	350	finally
    //   162	208	350	finally
    //   212	216	350	finally
    //   236	245	350	finally
    //   246	302	350	finally
    //   311	350	350	finally
    //   94	100	365	java/lang/Throwable
  }
  
  private static String c(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(125067);
    synchronized (gfQ)
    {
      try
      {
        Method localMethod2 = gfQ[0];
        Method localMethod1 = localMethod2;
        if (localMethod2 == null)
        {
          localMethod1 = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
          localMethod1.setAccessible(true);
          gfQ[0] = localMethod1;
        }
        paramString = (String)localMethod1.invoke(paramClassLoader, new Object[] { paramString });
        AppMethodBeat.o(125067);
        return paramString;
      }
      catch (Throwable paramString)
      {
        a("MicroMsg.LoadLibrary", paramString, "[-] Fail to find library in classloader: ".concat(String.valueOf(paramClassLoader)), new Object[0]);
        AppMethodBeat.o(125067);
        return null;
      }
    }
  }
  
  private static File ce(Context paramContext)
  {
    AppMethodBeat.i(125069);
    paramContext = paramContext.getDir("recovery_lib", 0);
    AppMethodBeat.o(125069);
    return paramContext;
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
      if ((paramObject instanceof Closeable))
      {
        ((Closeable)paramObject).close();
        AppMethodBeat.o(125074);
        return;
      }
    }
    catch (IllegalStateException paramObject)
    {
      AppMethodBeat.o(125074);
      throw paramObject;
      if ((paramObject instanceof AutoCloseable))
      {
        ((AutoCloseable)paramObject).close();
        AppMethodBeat.o(125074);
        return;
      }
    }
    catch (Throwable paramObject)
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
  
  private static boolean is64BitRuntime()
  {
    AppMethodBeat.i(125070);
    synchronized (gfR)
    {
      Boolean localBoolean2 = gfR[0];
      Boolean localBoolean1 = localBoolean2;
      if (localBoolean2 == null) {
        if (Build.VERSION.SDK_INT < 23) {
          break label60;
        }
      }
      for (localBoolean1 = Boolean.valueOf(Process.is64Bit());; localBoolean1 = Boolean.valueOf(Build.CPU_ABI.contains("64")))
      {
        gfR[0] = localBoolean1;
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
  
  public static void load(String paramString)
  {
    AppMethodBeat.i(211734);
    j.class.getClassLoader();
    vN(paramString);
    AppMethodBeat.o(211734);
  }
  
  public static void vL(String paramString)
  {
    AppMethodBeat.i(125057);
    synchronized (gfL)
    {
      gfL.add(paramString);
      a(2, "MicroMsg.LoadLibrary", "[+] Prior library search path '%s' added.", new Object[] { paramString });
      AppMethodBeat.o(125057);
      return;
    }
  }
  
  public static String vM(String paramString)
  {
    AppMethodBeat.i(125060);
    String str = vQ(paramString);
    if (str != null)
    {
      a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", new Object[] { paramString, str });
      AppMethodBeat.o(125060);
      return str;
    }
    str = c(paramString, j.class.getClassLoader());
    if (str != null)
    {
      a(2, "MicroMsg.LoadLibrary", "[+] Found library [%s] at %s.", new Object[] { paramString, str });
      AppMethodBeat.o(125060);
      return str;
    }
    str = z(ak.getContext(), paramString);
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
  
  public static void vN(String paramString)
  {
    AppMethodBeat.i(125061);
    ClassLoader localClassLoader1 = j.class.getClassLoader();
    ClassLoader localClassLoader2 = (ClassLoader)gfN.get(paramString);
    if (localClassLoader2 != null)
    {
      if (localClassLoader2 != localClassLoader1) {
        a(new UnsatisfiedLinkError("Library " + paramString + "to be loaded by classloader: " + localClassLoader1 + " has already loaded by classloader: " + localClassLoader2));
      }
      AppMethodBeat.o(125061);
      return;
    }
    a(paramString, localClassLoader1);
    gfN.put(paramString, localClassLoader1);
    AppMethodBeat.o(125061);
  }
  
  public static boolean vO(String paramString)
  {
    AppMethodBeat.i(125062);
    boolean bool = gfN.containsKey(paramString);
    AppMethodBeat.o(125062);
    return bool;
  }
  
  private static String vP(String paramString)
  {
    AppMethodBeat.i(125063);
    paramString = "lib" + paramString + ".so";
    AppMethodBeat.o(125063);
    return paramString;
  }
  
  private static String vQ(String arg0)
  {
    AppMethodBeat.i(125066);
    String str = vP(???);
    synchronized (gfL)
    {
      Iterator localIterator = gfL.iterator();
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
  
  private static String z(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125068);
    locala = gfO;
    try
    {
      gfO.lock();
      paramString = vP(paramString);
      paramContext = new File(ce(paramContext), paramString);
      if ((!paramContext.isDirectory()) && (paramContext.canRead())) {
        paramContext = paramContext.getAbsolutePath();
      }
    }
    finally
    {
      gfO.unlock();
      AppMethodBeat.o(125068);
    }
    try
    {
      gfO.unlock();
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(125068);
    }
    gfO.unlock();
    AppMethodBeat.o(125068);
    return null;
  }
  
  static final class a
  {
    private volatile int gfV = 0;
    private LocalServerSocket gfW = null;
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
        if (this.gfW != null)
        {
          j.aP(this.gfW);
          this.gfW = null;
        }
        super.finalize();
        AppMethodBeat.o(125056);
        return;
      }
      finally {}
    }
    
    final void lock()
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(125054);
          if (this.gfW != null)
          {
            this.gfV += 1;
            AppMethodBeat.o(125054);
            return;
          }
        }
        finally
        {
          try
          {
            this.gfW = new LocalServerSocket(this.mName + Process.myUid());
            this.gfV += 1;
            AppMethodBeat.o(125054);
          }
          catch (Throwable localThrowable1) {}
          localObject = finally;
        }
        try
        {
          Thread.sleep(1L);
          label94:
          if (this.gfW != null) {
            continue;
          }
          AppMethodBeat.o(125054);
        }
        catch (Throwable localThrowable2)
        {
          break label94;
        }
      }
    }
    
    /* Error */
    final void unlock()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 78
      //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 20	com/tencent/mm/compatible/util/j$a:gfV	I
      //   11: ifne +11 -> 22
      //   14: ldc 78
      //   16: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: aload_0
      //   24: getfield 20	com/tencent/mm/compatible/util/j$a:gfV	I
      //   27: iconst_1
      //   28: isub
      //   29: putfield 20	com/tencent/mm/compatible/util/j$a:gfV	I
      //   32: aload_0
      //   33: getfield 20	com/tencent/mm/compatible/util/j$a:gfV	I
      //   36: ifne +22 -> 58
      //   39: aload_0
      //   40: getfield 22	com/tencent/mm/compatible/util/j$a:gfW	Landroid/net/LocalServerSocket;
      //   43: ifnull +15 -> 58
      //   46: aload_0
      //   47: getfield 22	com/tencent/mm/compatible/util/j$a:gfW	Landroid/net/LocalServerSocket;
      //   50: invokestatic 37	com/tencent/mm/compatible/util/j:aP	(Ljava/lang/Object;)V
      //   53: aload_0
      //   54: aconst_null
      //   55: putfield 22	com/tencent/mm/compatible/util/j$a:gfW	Landroid/net/LocalServerSocket;
      //   58: ldc 78
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
  
  public static abstract interface b
  {
    public abstract boolean Mi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.j
 * JD-Core Version:    0.7.0.1
 */