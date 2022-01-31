package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q
  implements p
{
  private static final Pattern bys;
  private o byf;
  
  static
  {
    AppMethodBeat.i(90745);
    bys = Pattern.compile("^<<//([a-z]{0,10})//>>");
    AppMethodBeat.o(90745);
  }
  
  q(o paramo)
  {
    this.byf = paramo;
  }
  
  public final String bx(String paramString)
  {
    AppMethodBeat.i(90744);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(90744);
      return null;
    }
    Object localObject = bys.matcher(paramString);
    if (((Matcher)localObject).find()) {}
    for (localObject = ((Matcher)localObject).group(1); localObject == null; localObject = null)
    {
      AppMethodBeat.o(90744);
      return null;
    }
    paramString = paramString.replaceFirst("^<<//([a-z]{0,10})//>>", "");
    boolean bool = ((String)localObject).equals("sync");
    paramString = this.byf.byl.i(paramString, bool);
    AppMethodBeat.o(90744);
    return paramString;
  }
  
  /* Error */
  public final void onReady()
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 39	com/tencent/luggage/bridge/q:byf	Lcom/tencent/luggage/bridge/o;
    //   9: astore 4
    //   11: sipush 4096
    //   14: newarray char
    //   16: astore 6
    //   18: new 93	java/io/StringWriter
    //   21: dup
    //   22: invokespecial 94	java/io/StringWriter:<init>	()V
    //   25: astore 5
    //   27: new 96	java/io/InputStreamReader
    //   30: dup
    //   31: aload 4
    //   33: getfield 100	com/tencent/luggage/bridge/o:byk	Lcom/tencent/luggage/bridge/s;
    //   36: invokeinterface 106 1 0
    //   41: invokevirtual 112	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   44: ldc 114
    //   46: invokevirtual 120	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   49: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: aload 6
    //   58: invokevirtual 127	java/io/InputStreamReader:read	([C)I
    //   61: istore_1
    //   62: iconst_m1
    //   63: iload_1
    //   64: if_icmpeq +51 -> 115
    //   67: aload_3
    //   68: astore_2
    //   69: aload 5
    //   71: aload 6
    //   73: iconst_0
    //   74: iload_1
    //   75: invokevirtual 131	java/io/StringWriter:write	([CII)V
    //   78: goto -25 -> 53
    //   81: astore 4
    //   83: aload_3
    //   84: astore_2
    //   85: ldc 133
    //   87: ldc 135
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload 4
    //   97: aastore
    //   98: invokestatic 141	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 144	java/io/InputStreamReader:close	()V
    //   109: ldc 91
    //   111: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: aload_3
    //   116: invokevirtual 144	java/io/InputStreamReader:close	()V
    //   119: aload 4
    //   121: getfield 100	com/tencent/luggage/bridge/o:byk	Lcom/tencent/luggage/bridge/s;
    //   124: aload 5
    //   126: invokevirtual 148	java/io/StringWriter:toString	()Ljava/lang/String;
    //   129: invokeinterface 152 2 0
    //   134: ldc 91
    //   136: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: astore_2
    //   141: ldc 133
    //   143: ldc 154
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_2
    //   152: aastore
    //   153: invokestatic 141	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: goto -37 -> 119
    //   159: astore_2
    //   160: ldc 133
    //   162: ldc 154
    //   164: iconst_1
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_2
    //   171: aastore
    //   172: invokestatic 141	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: ldc 91
    //   177: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: return
    //   181: astore_3
    //   182: aconst_null
    //   183: astore_2
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 144	java/io/InputStreamReader:close	()V
    //   192: ldc 91
    //   194: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_3
    //   198: athrow
    //   199: astore_2
    //   200: ldc 133
    //   202: ldc 154
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_2
    //   211: aastore
    //   212: invokestatic 141	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -23 -> 192
    //   218: astore_3
    //   219: goto -35 -> 184
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: goto -143 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	q
    //   61	14	1	i	int
    //   54	31	2	localInputStreamReader1	java.io.InputStreamReader
    //   140	12	2	localException1	java.lang.Exception
    //   159	12	2	localException2	java.lang.Exception
    //   183	6	2	localObject1	Object
    //   199	12	2	localException3	java.lang.Exception
    //   52	64	3	localInputStreamReader2	java.io.InputStreamReader
    //   181	17	3	localObject2	Object
    //   218	1	3	localObject3	Object
    //   225	1	3	localObject4	Object
    //   9	23	4	localo	o
    //   81	39	4	localException4	java.lang.Exception
    //   222	1	4	localException5	java.lang.Exception
    //   25	100	5	localStringWriter	java.io.StringWriter
    //   16	56	6	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   55	62	81	java/lang/Exception
    //   69	78	81	java/lang/Exception
    //   115	119	140	java/lang/Exception
    //   105	109	159	java/lang/Exception
    //   27	53	181	finally
    //   188	192	199	java/lang/Exception
    //   55	62	218	finally
    //   69	78	218	finally
    //   85	101	218	finally
    //   27	53	222	java/lang/Exception
  }
  
  public final void tW()
  {
    AppMethodBeat.i(90742);
    f localf = this.byf.bym;
    d.i("Java2JsMessageQueue", "reset");
    localf.bxV = false;
    localf.bxU.clear();
    AppMethodBeat.o(90742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.bridge.q
 * JD-Core Version:    0.7.0.1
 */