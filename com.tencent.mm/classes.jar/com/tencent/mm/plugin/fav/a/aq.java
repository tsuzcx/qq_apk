package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.util.Set;

public final class aq
{
  public static Set<String> Aec;
  public static int Aed = 1;
  private static String oDk = "";
  
  /* Error */
  public static int bIG()
  {
    // Byte code:
    //   0: ldc 25
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 33	java/io/FileInputStream
    //   8: dup
    //   9: new 35	java/io/File
    //   12: dup
    //   13: invokestatic 39	com/tencent/mm/plugin/fav/a/aq:dQZ	()Ljava/lang/String;
    //   16: ldc 41
    //   18: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: new 50	java/io/BufferedReader
    //   30: dup
    //   31: new 52	java/io/InputStreamReader
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 55	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 58	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore 4
    //   44: ldc 15
    //   46: astore_3
    //   47: aload_2
    //   48: astore_1
    //   49: aload 4
    //   51: invokevirtual 61	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 5
    //   56: aload 5
    //   58: ifnull +28 -> 86
    //   61: aload_2
    //   62: astore_1
    //   63: new 63	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 5
    //   76: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_3
    //   83: goto -36 -> 47
    //   86: aload_2
    //   87: astore_1
    //   88: new 74	org/json/JSONObject
    //   91: dup
    //   92: aload_3
    //   93: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   96: ldc 79
    //   98: invokevirtual 83	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   101: istore_0
    //   102: aload_2
    //   103: astore_1
    //   104: ldc 85
    //   106: ldc 87
    //   108: iconst_2
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_3
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: iload_0
    //   119: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   122: aastore
    //   123: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_2
    //   127: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   130: ldc 25
    //   132: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_0
    //   136: ireturn
    //   137: astore_3
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: astore_1
    //   142: ldc 85
    //   144: aload_3
    //   145: aload_3
    //   146: invokevirtual 111	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   149: iconst_0
    //   150: anewarray 4	java/lang/Object
    //   153: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload_2
    //   157: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   160: ldc 25
    //   162: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   174: ldc 25
    //   176: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_2
    //   180: athrow
    //   181: astore_2
    //   182: goto -12 -> 170
    //   185: astore_3
    //   186: goto -46 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   101	35	0	i	int
    //   26	145	1	localFileInputStream1	java.io.FileInputStream
    //   24	133	2	localFileInputStream2	java.io.FileInputStream
    //   167	13	2	localObject1	Object
    //   181	1	2	localObject2	Object
    //   46	69	3	str1	String
    //   137	9	3	localException1	java.lang.Exception
    //   185	1	3	localException2	java.lang.Exception
    //   42	8	4	localBufferedReader	java.io.BufferedReader
    //   54	21	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	25	137	java/lang/Exception
    //   5	25	167	finally
    //   27	44	181	finally
    //   49	56	181	finally
    //   63	83	181	finally
    //   88	102	181	finally
    //   104	126	181	finally
    //   142	156	181	finally
    //   27	44	185	java/lang/Exception
    //   49	56	185	java/lang/Exception
    //   63	83	185	java/lang/Exception
    //   88	102	185	java/lang/Exception
    //   104	126	185	java/lang/Exception
  }
  
  /* Error */
  public static int bIH()
  {
    // Byte code:
    //   0: ldc 117
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 123	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8: invokevirtual 129	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 131
    //   15: invokevirtual 137	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: new 52	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 55	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: astore 4
    //   29: new 50	java/io/BufferedReader
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 58	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_1
    //   39: ldc 15
    //   41: astore_3
    //   42: aload_1
    //   43: astore 7
    //   45: aload 4
    //   47: astore 6
    //   49: aload_2
    //   50: astore 5
    //   52: aload_1
    //   53: invokevirtual 61	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 8
    //   58: aload 8
    //   60: ifnull +36 -> 96
    //   63: aload_1
    //   64: astore 7
    //   66: aload 4
    //   68: astore 6
    //   70: aload_2
    //   71: astore 5
    //   73: new 63	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   80: aload_3
    //   81: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_3
    //   93: goto -51 -> 42
    //   96: aload_1
    //   97: astore 7
    //   99: aload 4
    //   101: astore 6
    //   103: aload_2
    //   104: astore 5
    //   106: new 74	org/json/JSONObject
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   114: ldc 79
    //   116: invokevirtual 83	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   119: istore_0
    //   120: aload_1
    //   121: astore 7
    //   123: aload 4
    //   125: astore 6
    //   127: aload_2
    //   128: astore 5
    //   130: ldc 85
    //   132: ldc 87
    //   134: iconst_2
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_3
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: iload_0
    //   145: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_2
    //   153: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   156: aload 4
    //   158: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   161: aload_1
    //   162: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   165: ldc 117
    //   167: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iload_0
    //   171: ireturn
    //   172: astore_3
    //   173: aconst_null
    //   174: astore_1
    //   175: aconst_null
    //   176: astore 4
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_1
    //   181: astore 7
    //   183: aload 4
    //   185: astore 6
    //   187: aload_2
    //   188: astore 5
    //   190: ldc 85
    //   192: aload_3
    //   193: aload_3
    //   194: invokevirtual 111	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_2
    //   205: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   208: aload 4
    //   210: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   213: aload_1
    //   214: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   217: ldc 117
    //   219: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore_1
    //   225: aconst_null
    //   226: astore_3
    //   227: aconst_null
    //   228: astore 4
    //   230: aconst_null
    //   231: astore_2
    //   232: aload_2
    //   233: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   236: aload 4
    //   238: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   241: aload_3
    //   242: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   245: ldc 117
    //   247: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_3
    //   255: aconst_null
    //   256: astore 4
    //   258: goto -26 -> 232
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_3
    //   264: goto -32 -> 232
    //   267: astore_1
    //   268: aload 7
    //   270: astore_3
    //   271: aload 6
    //   273: astore 4
    //   275: aload 5
    //   277: astore_2
    //   278: goto -46 -> 232
    //   281: astore_3
    //   282: aconst_null
    //   283: astore_1
    //   284: aconst_null
    //   285: astore 4
    //   287: goto -107 -> 180
    //   290: astore_3
    //   291: aconst_null
    //   292: astore_1
    //   293: goto -113 -> 180
    //   296: astore_3
    //   297: goto -117 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   119	52	0	i	int
    //   11	203	1	localObject1	Object
    //   224	27	1	localObject2	Object
    //   252	1	1	localObject3	Object
    //   261	1	1	localObject4	Object
    //   267	1	1	localObject5	Object
    //   283	10	1	localObject6	Object
    //   18	260	2	localObject7	Object
    //   41	100	3	str1	String
    //   172	22	3	localException1	java.lang.Exception
    //   226	45	3	localObject8	Object
    //   281	1	3	localException2	java.lang.Exception
    //   290	1	3	localException3	java.lang.Exception
    //   296	1	3	localException4	java.lang.Exception
    //   27	259	4	localObject9	Object
    //   50	226	5	localObject10	Object
    //   47	225	6	localObject11	Object
    //   43	226	7	localObject12	Object
    //   56	29	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   12	19	172	java/lang/Exception
    //   12	19	224	finally
    //   19	29	252	finally
    //   29	39	261	finally
    //   52	58	267	finally
    //   73	93	267	finally
    //   106	120	267	finally
    //   130	152	267	finally
    //   190	204	267	finally
    //   19	29	281	java/lang/Exception
    //   29	39	290	java/lang/Exception
    //   52	58	296	java/lang/Exception
    //   73	93	296	java/lang/Exception
    //   106	120	296	java/lang/Exception
    //   130	152	296	java/lang/Exception
  }
  
  public static String dQY()
  {
    AppMethodBeat.i(127421);
    if (SdcardUtil.getAvailableInternalMemorySize() > 1048576L) {}
    for (Object localObject = new File(pl(false), "wenote/res");; localObject = new File(b.bmz(), "wenote/res"))
    {
      localObject = ((File)localObject).getAbsolutePath();
      AppMethodBeat.o(127421);
      return localObject;
    }
  }
  
  public static String dQZ()
  {
    AppMethodBeat.i(127422);
    Object localObject = new File(pl(false), "wenote/res");
    if (new File((File)localObject, "WNNote.zip").exists())
    {
      localObject = ((File)localObject).getAbsolutePath();
      AppMethodBeat.o(127422);
      return localObject;
    }
    localObject = new File(b.bmz(), "wenote/res");
    if (new File((File)localObject, "WNNote.zip").exists())
    {
      localObject = ((File)localObject).getAbsolutePath();
      AppMethodBeat.o(127422);
      return localObject;
    }
    AppMethodBeat.o(127422);
    return "";
  }
  
  public static String dRa()
  {
    AppMethodBeat.i(127423);
    Object localObject = new File(pl(true), "wenote/loc/data");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath();
    AppMethodBeat.o(127423);
    return localObject;
  }
  
  public static String dRb()
  {
    AppMethodBeat.i(127424);
    Object localObject = new StringBuilder();
    File localFile = new File(pl(false), "wenote/html/upload");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localObject = localFile.getAbsolutePath() + "/wenoteupload.htm";
    AppMethodBeat.o(127424);
    return localObject;
  }
  
  public static String dRc()
  {
    AppMethodBeat.i(127425);
    Object localObject = new File(pl(true), "wenote/image/localpath");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath();
    AppMethodBeat.o(127425);
    return localObject;
  }
  
  public static String dRd()
  {
    AppMethodBeat.i(127426);
    Object localObject = new File(pl(true), "wenote/voice/data");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath();
    AppMethodBeat.o(127426);
    return localObject;
  }
  
  private static String pl(boolean paramBoolean)
  {
    AppMethodBeat.i(127420);
    if (paramBoolean)
    {
      str = h.baE().mCJ;
      AppMethodBeat.o(127420);
      return str;
    }
    if (Util.isNullOrNil(oDk)) {
      oDk = b.bms();
    }
    String str = oDk;
    AppMethodBeat.o(127420);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aq
 * JD-Core Version:    0.7.0.1
 */