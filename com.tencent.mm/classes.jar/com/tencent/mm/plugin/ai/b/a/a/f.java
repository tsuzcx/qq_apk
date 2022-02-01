package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class f
{
  private static final String[] noM = { "7day_clk_rate_h", "7day_impr_h", "last_stay_secs", "snsunread", "friendstabredunread", "7day_clk_h", "from_last_hours", "wechatdurationnminute_10", "wechatdurationnminute_30", "wechatdurationnminute_90", "findfrienduiexposure_10", "findfrienduiexposure_30", "findfrienduiexposure_90", "lastsessionduration", "wechatduration7dayhour" };
  private String filePath;
  boolean msB;
  HashMap<String, float[]> noN;
  
  public f(String paramString)
  {
    AppMethodBeat.i(240331);
    this.noN = new HashMap();
    this.msB = true;
    this.filePath = paramString;
    AppMethodBeat.o(240331);
  }
  
  private boolean d(HashMap<String, String[]> paramHashMap)
  {
    AppMethodBeat.i(240340);
    if (paramHashMap.isEmpty())
    {
      AppMethodBeat.o(240340);
      return false;
    }
    String[] arrayOfString1 = noM;
    int k = arrayOfString1.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label137;
      }
      String str = arrayOfString1[i];
      if (!paramHashMap.containsKey(str)) {
        break label151;
      }
      String[] arrayOfString2 = (String[])paramHashMap.remove(str);
      if ((arrayOfString2 == null) || (arrayOfString2.length <= 0)) {
        break;
      }
      float[] arrayOfFloat = new float[arrayOfString2.length - 1];
      int j = 1;
      while (j < arrayOfString2.length)
      {
        arrayOfFloat[(j - 1)] = Util.getFloat(arrayOfString2[j], 0.0F);
        j += 1;
      }
      this.noN.put(str, arrayOfFloat);
      i += 1;
    }
    label137:
    label151:
    for (this.msB = false;; this.msB = false)
    {
      boolean bool = this.msB;
      AppMethodBeat.o(240340);
      return bool;
    }
  }
  
  /* Error */
  public final boolean uY()
  {
    // Byte code:
    //   0: ldc 109
    //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 63	java/util/HashMap
    //   8: dup
    //   9: invokespecial 64	java/util/HashMap:<init>	()V
    //   12: astore 7
    //   14: aload_0
    //   15: getfield 70	com/tencent/mm/plugin/ai/b/a/a/f:filePath	Ljava/lang/String;
    //   18: invokestatic 115	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_2
    //   22: new 117	java/io/BufferedReader
    //   25: dup
    //   26: new 119	java/io/InputStreamReader
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 122	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 125	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore 5
    //   39: aload 5
    //   41: astore 4
    //   43: aload_2
    //   44: astore_3
    //   45: aload 5
    //   47: invokevirtual 129	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnull +114 -> 168
    //   57: aload 5
    //   59: astore 4
    //   61: aload_2
    //   62: astore_3
    //   63: aload 6
    //   65: iconst_1
    //   66: aload 6
    //   68: invokevirtual 133	java/lang/String:length	()I
    //   71: iconst_1
    //   72: isub
    //   73: invokevirtual 137	java/lang/String:substring	(II)Ljava/lang/String;
    //   76: ldc 139
    //   78: invokevirtual 143	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: astore 6
    //   83: aload 5
    //   85: astore 4
    //   87: aload_2
    //   88: astore_3
    //   89: aload 7
    //   91: aload 6
    //   93: iconst_0
    //   94: aaload
    //   95: aload 6
    //   97: invokevirtual 99	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: goto -62 -> 39
    //   104: astore 6
    //   106: aload 5
    //   108: astore 4
    //   110: aload_2
    //   111: astore_3
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield 68	com/tencent/mm/plugin/ai/b/a/a/f:msB	Z
    //   117: aload 5
    //   119: astore 4
    //   121: aload_2
    //   122: astore_3
    //   123: ldc 145
    //   125: aload 6
    //   127: ldc 147
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload 5
    //   138: ifnull +8 -> 146
    //   141: aload 5
    //   143: invokevirtual 156	java/io/BufferedReader:close	()V
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 159	java/io/InputStream:close	()V
    //   154: aload_0
    //   155: aload 7
    //   157: invokespecial 161	com/tencent/mm/plugin/ai/b/a/a/f:d	(Ljava/util/HashMap;)Z
    //   160: istore_1
    //   161: ldc 109
    //   163: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: iload_1
    //   167: ireturn
    //   168: aload 5
    //   170: invokevirtual 156	java/io/BufferedReader:close	()V
    //   173: aload_2
    //   174: ifnull -20 -> 154
    //   177: aload_2
    //   178: invokevirtual 159	java/io/InputStream:close	()V
    //   181: goto -27 -> 154
    //   184: astore_2
    //   185: goto -31 -> 154
    //   188: astore 6
    //   190: aconst_null
    //   191: astore 5
    //   193: aconst_null
    //   194: astore_2
    //   195: aload 5
    //   197: astore 4
    //   199: aload_2
    //   200: astore_3
    //   201: aload_0
    //   202: iconst_0
    //   203: putfield 68	com/tencent/mm/plugin/ai/b/a/a/f:msB	Z
    //   206: aload 5
    //   208: astore 4
    //   210: aload_2
    //   211: astore_3
    //   212: ldc 145
    //   214: aload 6
    //   216: ldc 147
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload 5
    //   227: ifnull +8 -> 235
    //   230: aload 5
    //   232: invokevirtual 156	java/io/BufferedReader:close	()V
    //   235: aload_2
    //   236: ifnull -82 -> 154
    //   239: aload_2
    //   240: invokevirtual 159	java/io/InputStream:close	()V
    //   243: goto -89 -> 154
    //   246: astore_2
    //   247: goto -93 -> 154
    //   250: astore 5
    //   252: aconst_null
    //   253: astore 4
    //   255: aconst_null
    //   256: astore_2
    //   257: aload 4
    //   259: ifnull +8 -> 267
    //   262: aload 4
    //   264: invokevirtual 156	java/io/BufferedReader:close	()V
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 159	java/io/InputStream:close	()V
    //   275: ldc 109
    //   277: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload 5
    //   282: athrow
    //   283: astore_3
    //   284: goto -111 -> 173
    //   287: astore_3
    //   288: goto -142 -> 146
    //   291: astore_2
    //   292: goto -138 -> 154
    //   295: astore_3
    //   296: goto -61 -> 235
    //   299: astore_3
    //   300: goto -33 -> 267
    //   303: astore_2
    //   304: goto -29 -> 275
    //   307: astore 5
    //   309: aconst_null
    //   310: astore 4
    //   312: goto -55 -> 257
    //   315: astore 5
    //   317: aload_3
    //   318: astore_2
    //   319: goto -62 -> 257
    //   322: astore 6
    //   324: aconst_null
    //   325: astore 5
    //   327: goto -132 -> 195
    //   330: astore 6
    //   332: goto -137 -> 195
    //   335: astore 6
    //   337: aconst_null
    //   338: astore 5
    //   340: aconst_null
    //   341: astore_2
    //   342: goto -236 -> 106
    //   345: astore 6
    //   347: aconst_null
    //   348: astore 5
    //   350: goto -244 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	f
    //   160	7	1	bool	boolean
    //   21	157	2	localInputStream	java.io.InputStream
    //   184	1	2	localIOException1	java.io.IOException
    //   194	46	2	localObject1	Object
    //   246	1	2	localIOException2	java.io.IOException
    //   256	16	2	localObject2	Object
    //   291	1	2	localIOException3	java.io.IOException
    //   303	1	2	localIOException4	java.io.IOException
    //   318	24	2	localObject3	Object
    //   44	168	3	localObject4	Object
    //   283	1	3	localIOException5	java.io.IOException
    //   287	1	3	localIOException6	java.io.IOException
    //   295	1	3	localIOException7	java.io.IOException
    //   299	19	3	localIOException8	java.io.IOException
    //   41	270	4	localBufferedReader1	java.io.BufferedReader
    //   37	194	5	localBufferedReader2	java.io.BufferedReader
    //   250	31	5	localObject5	Object
    //   307	1	5	localObject6	Object
    //   315	1	5	localObject7	Object
    //   325	24	5	localObject8	Object
    //   50	46	6	localObject9	Object
    //   104	22	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   188	27	6	localException1	java.lang.Exception
    //   322	1	6	localException2	java.lang.Exception
    //   330	1	6	localException3	java.lang.Exception
    //   335	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   345	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   12	144	7	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   45	52	104	java/io/FileNotFoundException
    //   63	83	104	java/io/FileNotFoundException
    //   89	101	104	java/io/FileNotFoundException
    //   177	181	184	java/io/IOException
    //   14	22	188	java/lang/Exception
    //   239	243	246	java/io/IOException
    //   14	22	250	finally
    //   168	173	283	java/io/IOException
    //   141	146	287	java/io/IOException
    //   150	154	291	java/io/IOException
    //   230	235	295	java/io/IOException
    //   262	267	299	java/io/IOException
    //   271	275	303	java/io/IOException
    //   22	39	307	finally
    //   45	52	315	finally
    //   63	83	315	finally
    //   89	101	315	finally
    //   112	117	315	finally
    //   123	136	315	finally
    //   201	206	315	finally
    //   212	225	315	finally
    //   22	39	322	java/lang/Exception
    //   45	52	330	java/lang/Exception
    //   63	83	330	java/lang/Exception
    //   89	101	330	java/lang/Exception
    //   14	22	335	java/io/FileNotFoundException
    //   22	39	345	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */