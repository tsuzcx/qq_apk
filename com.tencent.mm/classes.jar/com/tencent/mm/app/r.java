package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.HashMap;

public final class r
{
  static String cIK = "";
  static ApplicationLike cIg;
  String cIL;
  String cIM;
  long cIN;
  long cIO;
  
  public r(ApplicationLike paramApplicationLike)
  {
    cIg = paramApplicationLike;
    d.cIg = paramApplicationLike;
  }
  
  static final boolean D(File paramFile)
  {
    int i = 0;
    AppMethodBeat.i(175407);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(175407);
      return false;
    }
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null)
      {
        AppMethodBeat.o(175407);
        return false;
      }
      while (i < paramFile.length)
      {
        paramFile[i].delete();
        i += 1;
      }
      AppMethodBeat.o(175407);
      return true;
    }
    AppMethodBeat.o(175407);
    return false;
  }
  
  static void a(ApplicationLike paramApplicationLike)
  {
    AppMethodBeat.i(125024);
    if (paramApplicationLike == null)
    {
      AppMethodBeat.o(125024);
      return;
    }
    if ((paramApplicationLike == null) || (paramApplicationLike.getApplication() == null))
    {
      paramApplicationLike = new TinkerRuntimeException("tinkerApplication is null");
      AppMethodBeat.o(125024);
      throw paramApplicationLike;
    }
    paramApplicationLike = paramApplicationLike.getTinkerResultIntent();
    if ((paramApplicationLike != null) && (ShareIntentUtil.getIntentReturnCode(paramApplicationLike) == 0)) {}
    for (paramApplicationLike = ShareIntentUtil.getIntentPackageConfig(paramApplicationLike);; paramApplicationLike = null)
    {
      if (paramApplicationLike != null)
      {
        a.gML = (String)paramApplicationLike.get("patch.rev");
        a.gMN = (String)paramApplicationLike.get("NEW_TINKER_ID");
        ac.w("MicroMsg.MMApplicationLikeImpl", "application set patch rev:%s patch tinkerId:%s ", new Object[] { a.gML, a.gMN });
      }
      AppMethodBeat.o(125024);
      return;
    }
  }
  
  static String eo(String paramString)
  {
    AppMethodBeat.i(125025);
    try
    {
      File localFile = SharePatchFileUtil.getPatchDirectory(cIg.getApplication());
      String str = SharePatchFileUtil.getPatchVersionDirectory(b.d(cIg));
      localFile = new File(localFile.getAbsolutePath(), str);
      paramString = new File(localFile.getAbsolutePath() + "/lib/lib/" + paramString).getAbsolutePath();
      AppMethodBeat.o(125025);
      return paramString;
    }
    catch (Throwable paramString)
    {
      ac.printErrStackTrace("MicroMsg.MMApplicationLikeImpl", paramString, "[-] Fail to get patched native libs path.", new Object[0]);
      AppMethodBeat.o(125025);
    }
    return null;
  }
  
  /* Error */
  static String getProcessNameByPid(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: iload_1
    //   10: ifgt +11 -> 21
    //   13: ldc 167
    //   15: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: ldc 17
    //   20: areturn
    //   21: aload_0
    //   22: ldc 169
    //   24: invokevirtual 175	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   27: checkcast 177	android/app/ActivityManager
    //   30: invokevirtual 181	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   33: invokeinterface 187 1 0
    //   38: astore_0
    //   39: aload_0
    //   40: invokeinterface 192 1 0
    //   45: ifeq +70 -> 115
    //   48: aload_0
    //   49: invokeinterface 196 1 0
    //   54: checkcast 198	android/app/ActivityManager$RunningAppProcessInfo
    //   57: astore 4
    //   59: aload 4
    //   61: getfield 202	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   64: iload_1
    //   65: if_icmpne -26 -> 39
    //   68: aload 4
    //   70: getfield 205	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   73: ifnull -34 -> 39
    //   76: aload 4
    //   78: getfield 205	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   81: ldc 17
    //   83: invokevirtual 209	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifne -47 -> 39
    //   89: aload 4
    //   91: getfield 205	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   94: astore_0
    //   95: ldc 167
    //   97: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: ldc 108
    //   105: aload_0
    //   106: ldc 17
    //   108: iconst_0
    //   109: anewarray 4	java/lang/Object
    //   112: invokestatic 162	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: sipush 128
    //   118: newarray byte
    //   120: astore 5
    //   122: new 211	java/io/FileInputStream
    //   125: dup
    //   126: new 145	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 213
    //   132: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: iload_1
    //   136: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc 219
    //   141: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   150: astore 4
    //   152: aload 4
    //   154: astore_0
    //   155: aload 4
    //   157: aload 5
    //   159: invokevirtual 224	java/io/FileInputStream:read	([B)I
    //   162: istore_3
    //   163: iload_3
    //   164: ifle +44 -> 208
    //   167: iconst_0
    //   168: istore_1
    //   169: goto +132 -> 301
    //   172: aload 4
    //   174: astore_0
    //   175: new 96	java/lang/String
    //   178: dup
    //   179: aload 5
    //   181: iconst_0
    //   182: iload_2
    //   183: invokespecial 227	java/lang/String:<init>	([BII)V
    //   186: astore 5
    //   188: aload 4
    //   190: invokevirtual 230	java/io/FileInputStream:close	()V
    //   193: ldc 167
    //   195: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 5
    //   200: areturn
    //   201: iload_1
    //   202: iconst_1
    //   203: iadd
    //   204: istore_1
    //   205: goto +96 -> 301
    //   208: aload 4
    //   210: invokevirtual 230	java/io/FileInputStream:close	()V
    //   213: ldc 167
    //   215: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: ldc 17
    //   220: areturn
    //   221: astore 5
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: astore_0
    //   229: ldc 108
    //   231: aload 5
    //   233: ldc 17
    //   235: iconst_0
    //   236: anewarray 4	java/lang/Object
    //   239: invokestatic 162	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload 4
    //   244: ifnull -31 -> 213
    //   247: aload 4
    //   249: invokevirtual 230	java/io/FileInputStream:close	()V
    //   252: goto -39 -> 213
    //   255: astore_0
    //   256: goto -43 -> 213
    //   259: astore 4
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 230	java/io/FileInputStream:close	()V
    //   271: ldc 167
    //   273: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 4
    //   278: athrow
    //   279: astore_0
    //   280: goto -87 -> 193
    //   283: astore_0
    //   284: goto -71 -> 213
    //   287: astore_0
    //   288: goto -17 -> 271
    //   291: astore 4
    //   293: goto -30 -> 263
    //   296: astore 5
    //   298: goto -72 -> 226
    //   301: iload_3
    //   302: istore_2
    //   303: iload_1
    //   304: iload_3
    //   305: if_icmpge -133 -> 172
    //   308: aload 5
    //   310: iload_1
    //   311: baload
    //   312: sipush 128
    //   315: if_icmpgt +10 -> 325
    //   318: aload 5
    //   320: iload_1
    //   321: baload
    //   322: ifgt -121 -> 201
    //   325: iload_1
    //   326: istore_2
    //   327: goto -155 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramContext	android.content.Context
    //   0	330	1	paramInt	int
    //   182	145	2	i	int
    //   162	144	3	j	int
    //   57	191	4	localObject1	Object
    //   259	18	4	localObject2	Object
    //   291	1	4	localObject3	Object
    //   120	79	5	localObject4	Object
    //   221	11	5	localException1	java.lang.Exception
    //   296	23	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	39	102	java/lang/Exception
    //   39	95	102	java/lang/Exception
    //   122	152	221	java/lang/Exception
    //   247	252	255	java/lang/Exception
    //   122	152	259	finally
    //   188	193	279	java/lang/Exception
    //   208	213	283	java/lang/Exception
    //   267	271	287	java/lang/Exception
    //   155	163	291	finally
    //   175	188	291	finally
    //   229	242	291	finally
    //   155	163	296	java/lang/Exception
    //   175	188	296	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.r
 * JD-Core Version:    0.7.0.1
 */