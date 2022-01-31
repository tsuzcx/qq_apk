package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;

public final class p
{
  public static String CN(String paramString)
  {
    AppMethodBeat.i(102094);
    paramString = H(new File(ah.getContext().getCacheDir(), paramString));
    AppMethodBeat.o(102094);
    return paramString;
  }
  
  public static void CO(String paramString)
  {
    AppMethodBeat.i(102095);
    boolean bool = new File(ah.getContext().getCacheDir(), paramString).delete();
    ab.i("MicroMsg.JsApiStorageHelper", "deleteTmpFile: " + paramString + ":" + bool);
    AppMethodBeat.o(102095);
  }
  
  /* Error */
  private static String H(File paramFile)
  {
    // Byte code:
    //   0: ldc 77
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 80	java/io/File:exists	()Z
    //   9: ifne +11 -> 20
    //   12: ldc 77
    //   14: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: ldc 82
    //   19: areturn
    //   20: new 84	java/lang/StringBuffer
    //   23: dup
    //   24: invokespecial 87	java/lang/StringBuffer:<init>	()V
    //   27: astore_3
    //   28: new 89	java/io/BufferedReader
    //   31: dup
    //   32: new 91	java/io/FileReader
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 94	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   40: invokespecial 97	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: sipush 1024
    //   49: newarray char
    //   51: astore 4
    //   53: aload_2
    //   54: astore_0
    //   55: aload_2
    //   56: aload 4
    //   58: invokevirtual 101	java/io/BufferedReader:read	([C)I
    //   61: istore_1
    //   62: iload_1
    //   63: iconst_m1
    //   64: if_icmpeq +52 -> 116
    //   67: aload_2
    //   68: astore_0
    //   69: aload_3
    //   70: aload 4
    //   72: iconst_0
    //   73: iload_1
    //   74: invokestatic 107	java/lang/String:valueOf	([CII)Ljava/lang/String;
    //   77: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   80: pop
    //   81: goto -28 -> 53
    //   84: astore_3
    //   85: aload_2
    //   86: astore_0
    //   87: ldc 77
    //   89: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_2
    //   93: astore_0
    //   94: aload_3
    //   95: athrow
    //   96: astore_3
    //   97: aload_0
    //   98: astore_2
    //   99: aload_3
    //   100: astore_0
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 113	java/io/BufferedReader:close	()V
    //   109: ldc 77
    //   111: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_0
    //   115: athrow
    //   116: aload_2
    //   117: invokevirtual 113	java/io/BufferedReader:close	()V
    //   120: aload_3
    //   121: invokevirtual 114	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   124: astore_0
    //   125: ldc 77
    //   127: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: areturn
    //   132: astore_0
    //   133: ldc 77
    //   135: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: athrow
    //   140: astore_0
    //   141: ldc 77
    //   143: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_0
    //   147: athrow
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_2
    //   151: goto -50 -> 101
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: goto -72 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramFile	File
    //   61	13	1	i	int
    //   43	114	2	localObject1	Object
    //   27	43	3	localStringBuffer	java.lang.StringBuffer
    //   84	11	3	localIOException1	java.io.IOException
    //   96	25	3	localObject2	Object
    //   154	1	3	localIOException2	java.io.IOException
    //   51	20	4	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   46	53	84	java/io/IOException
    //   55	62	84	java/io/IOException
    //   69	81	84	java/io/IOException
    //   46	53	96	finally
    //   55	62	96	finally
    //   69	81	96	finally
    //   87	92	96	finally
    //   94	96	96	finally
    //   116	120	132	java/lang/Exception
    //   105	109	140	java/lang/Exception
    //   28	44	148	finally
    //   28	44	154	java/io/IOException
  }
  
  static String a(m.a parama)
  {
    if (parama == m.a.gZV) {
      return "ok";
    }
    if (parama == m.a.gZZ) {
      return "fail:quota reached";
    }
    return "fail:internal error set DB data fail";
  }
  
  /* Error */
  public static void g(String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 134
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 15	java/io/File
    //   8: dup
    //   9: invokestatic 21	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   12: invokevirtual 27	android/content/Context:getCacheDir	()Ljava/io/File;
    //   15: aload_0
    //   16: invokespecial 31	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_0
    //   20: new 136	java/io/FileWriter
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 137	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   28: astore 4
    //   30: aload_1
    //   31: arraylength
    //   32: istore_3
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: iload_3
    //   37: if_icmpge +18 -> 55
    //   40: aload 4
    //   42: aload_1
    //   43: iload_2
    //   44: aaload
    //   45: invokevirtual 140	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   48: iload_2
    //   49: iconst_1
    //   50: iadd
    //   51: istore_2
    //   52: goto -17 -> 35
    //   55: aload 4
    //   57: invokevirtual 141	java/io/FileWriter:close	()V
    //   60: ldc 134
    //   62: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: astore_0
    //   67: ldc 134
    //   69: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 141	java/io/FileWriter:close	()V
    //   84: ldc 134
    //   86: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: athrow
    //   91: astore_1
    //   92: goto -8 -> 84
    //   95: astore_0
    //   96: aload 4
    //   98: astore_1
    //   99: goto -23 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramString	String
    //   0	102	1	paramVarArgs	String[]
    //   34	18	2	i	int
    //   32	6	3	j	int
    //   28	69	4	localFileWriter	java.io.FileWriter
    // Exception table:
    //   from	to	target	type
    //   55	60	66	java/io/IOException
    //   20	30	73	finally
    //   80	84	91	java/io/IOException
    //   30	33	95	finally
    //   40	48	95	finally
  }
  
  public static int k(String... paramVarArgs)
  {
    AppMethodBeat.i(102091);
    int m = paramVarArgs.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      String str = paramVarArgs[i];
      k = j;
      if (str != null) {
        k = j + str.length();
      }
      i += 1;
    }
    AppMethodBeat.o(102091);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.p
 * JD-Core Version:    0.7.0.1
 */