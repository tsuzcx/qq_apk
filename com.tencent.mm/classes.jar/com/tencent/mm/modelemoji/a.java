package com.tencent.mm.modelemoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public final class a
{
  public static int oDj = 1;
  private static String oDk = "";
  
  /* Error */
  private static boolean NF(String paramString)
  {
    // Byte code:
    //   0: ldc 24
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 36	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8: invokevirtual 42	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: astore_2
    //   12: aload_2
    //   13: ldc 44
    //   15: invokevirtual 50	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnonnull +35 -> 55
    //   23: ldc 52
    //   25: ldc 54
    //   27: invokestatic 60	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 24
    //   32: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_0
    //   36: ireturn
    //   37: astore_2
    //   38: ldc 52
    //   40: aload_2
    //   41: ldc 14
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aconst_null
    //   51: astore_2
    //   52: goto -33 -> 19
    //   55: new 69	com/tencent/mm/vfs/u
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 73	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 77	com/tencent/mm/vfs/u:jKS	()Z
    //   68: ifeq +8 -> 76
    //   71: aload_0
    //   72: invokevirtual 80	com/tencent/mm/vfs/u:diJ	()Z
    //   75: pop
    //   76: aload_0
    //   77: invokevirtual 84	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   80: invokevirtual 87	com/tencent/mm/vfs/u:jKY	()Z
    //   83: pop
    //   84: aload_0
    //   85: invokestatic 93	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +107 -> 197
    //   93: sipush 1024
    //   96: newarray byte
    //   98: astore_3
    //   99: aload_2
    //   100: aload_3
    //   101: invokevirtual 99	java/io/InputStream:read	([B)I
    //   104: istore_1
    //   105: iload_1
    //   106: iconst_m1
    //   107: if_icmpeq +59 -> 166
    //   110: aload_0
    //   111: aload_3
    //   112: iconst_0
    //   113: iload_1
    //   114: invokevirtual 105	java/io/OutputStream:write	([BII)V
    //   117: goto -18 -> 99
    //   120: astore_3
    //   121: ldc 52
    //   123: aload_3
    //   124: ldc 14
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload_2
    //   134: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   137: aload_0
    //   138: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   141: ldc 24
    //   143: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_0
    //   149: ldc 52
    //   151: aload_0
    //   152: ldc 14
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aconst_null
    //   162: astore_0
    //   163: goto -74 -> 89
    //   166: aload_2
    //   167: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   170: aload_0
    //   171: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   174: ldc 24
    //   176: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_1
    //   180: ireturn
    //   181: astore_3
    //   182: aload_2
    //   183: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   186: aload_0
    //   187: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   190: ldc 24
    //   192: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_3
    //   196: athrow
    //   197: aload_2
    //   198: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   201: ldc 24
    //   203: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_0
    //   207: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   104	10	1	i	int
    //   11	9	2	localObject1	Object
    //   37	4	2	localIOException1	IOException
    //   51	147	2	localCloseable	java.io.Closeable
    //   98	14	3	arrayOfByte	byte[]
    //   120	4	3	localIOException2	IOException
    //   181	15	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	19	37	java/io/IOException
    //   93	99	120	java/io/IOException
    //   99	105	120	java/io/IOException
    //   110	117	120	java/io/IOException
    //   84	89	148	java/io/FileNotFoundException
    //   93	99	181	finally
    //   99	105	181	finally
    //   110	117	181	finally
    //   121	133	181	finally
  }
  
  private static String bID()
  {
    AppMethodBeat.i(104501);
    if (Util.isNullOrNil(oDk)) {
      oDk = b.bms();
    }
    String str = oDk;
    AppMethodBeat.o(104501);
    return str;
  }
  
  public static String bIE()
  {
    AppMethodBeat.i(104502);
    Object localObject = new u(bID(), "emoji/res");
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    localObject = ah.v(((u)localObject).jKT());
    AppMethodBeat.o(104502);
    return localObject;
  }
  
  public static String bIF()
  {
    AppMethodBeat.i(104503);
    String str = bID() + "emoji/newemoji/";
    AppMethodBeat.o(104503);
    return str;
  }
  
  public static int bIG()
  {
    AppMethodBeat.i(104504);
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      InputStream localInputStream = y.ao(new u(bIE(), "config.conf"));
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      String str2;
      for (String str1 = "";; str1 = str1 + str2)
      {
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        str2 = localBufferedReader.readLine();
        if (str2 == null) {
          break;
        }
        localObject1 = localInputStream;
        localObject3 = localInputStream;
      }
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      int i = new JSONObject(str1).getInt("version");
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      Log.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", new Object[] { str1, Integer.valueOf(i) });
      return i;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localException, localException.getMessage(), new Object[0]);
      return 1;
    }
    finally
    {
      Util.qualityClose(localObject3);
      AppMethodBeat.o(104504);
    }
  }
  
  /* Error */
  private static int bIH()
  {
    // Byte code:
    //   0: ldc 207
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 36	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8: invokevirtual 42	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 209
    //   15: invokevirtual 50	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: new 172	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 175	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: astore 4
    //   29: new 170	java/io/BufferedReader
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 178	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_1
    //   39: ldc 14
    //   41: astore_3
    //   42: aload_1
    //   43: astore 7
    //   45: aload 4
    //   47: astore 6
    //   49: aload_2
    //   50: astore 5
    //   52: aload_1
    //   53: invokevirtual 181	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 8
    //   58: aload 8
    //   60: ifnull +36 -> 96
    //   63: aload_1
    //   64: astore 7
    //   66: aload 4
    //   68: astore 6
    //   70: aload_2
    //   71: astore 5
    //   73: new 144	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   80: aload_3
    //   81: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_3
    //   93: goto -51 -> 42
    //   96: aload_1
    //   97: astore 7
    //   99: aload 4
    //   101: astore 6
    //   103: aload_2
    //   104: astore 5
    //   106: new 183	org/json/JSONObject
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   114: ldc 186
    //   116: invokevirtual 190	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   119: istore_0
    //   120: aload_1
    //   121: astore 7
    //   123: aload 4
    //   125: astore 6
    //   127: aload_2
    //   128: astore 5
    //   130: ldc 52
    //   132: ldc 192
    //   134: iconst_2
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_3
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: iload_0
    //   145: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 202	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_2
    //   153: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   156: aload 4
    //   158: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   161: aload_1
    //   162: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   165: ldc 207
    //   167: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   190: ldc 52
    //   192: aload_3
    //   193: aload_3
    //   194: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_2
    //   205: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   208: aload 4
    //   210: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   213: aload_1
    //   214: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   217: ldc 207
    //   219: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   233: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   236: aload 4
    //   238: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   241: aload_3
    //   242: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   245: ldc 207
    //   247: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   172	22	3	localException1	Exception
    //   226	45	3	localObject8	Object
    //   281	1	3	localException2	Exception
    //   290	1	3	localException3	Exception
    //   296	1	3	localException4	Exception
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
  
  public static void hh(boolean paramBoolean)
  {
    AppMethodBeat.i(104507);
    u localu = new u(bIE());
    Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", new Object[] { localu.jKU() });
    if (d.Yxk)
    {
      Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", new Object[] { Boolean.valueOf(paramBoolean) });
      y.ew(ah.v(localu.mUri), true);
      j(localu);
    }
    for (;;)
    {
      y.ew(b.bmz() + "emoji", true);
      AppMethodBeat.o(104507);
      return;
      oDj = bIG();
      if (paramBoolean)
      {
        int i = bIH();
        Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(oDj) });
        if (oDj < i)
        {
          y.ew(ah.v(localu.mUri), true);
          j(localu);
        }
      }
      else if (oDj == 1)
      {
        Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", new Object[] { Integer.valueOf(oDj) });
        y.ew(ah.v(localu.mUri), true);
        j(localu);
      }
    }
  }
  
  private static void j(u paramu)
  {
    AppMethodBeat.i(104508);
    if (!paramu.jKS()) {
      paramu.jKY();
    }
    u localu = new u(paramu, ".nomedia");
    if (!localu.jKS()) {}
    try
    {
      localu.jKZ();
      paramu = new u(paramu, "emoji_template.zip");
      if (NF(ah.v(paramu.jKT())))
      {
        int i = y.aA(ah.v(paramu.jKT()), paramu.jKO());
        if (i < 0)
        {
          Log.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + i + ", zipFilePath = " + ah.v(paramu.jKT()) + ", unzipPath = " + paramu.jKO());
          AppMethodBeat.o(104508);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localIOException, "create nomedia file error", new Object[0]);
      }
      oDj = bIG();
      Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[] { paramu.jKO(), Integer.valueOf(oDj) });
      AppMethodBeat.o(104508);
      return;
    }
    Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", new Object[] { ah.v(paramu.jKT()) });
    AppMethodBeat.o(104508);
  }
  
  public static void k(u paramu)
  {
    AppMethodBeat.i(104509);
    u localu1 = new u(bIE());
    y.ew(ah.v(localu1.mUri), true);
    localu1.jKY();
    u localu2 = new u(localu1, ".nomedia");
    if (!localu2.jKS()) {}
    try
    {
      localu2.jKZ();
      localu1 = new u(localu1, "emoji_template.zip");
      y.O(ah.v(paramu.mUri), ah.v(localu1.mUri), false);
      int i = Util.UnZipFolder(ah.v(localu1.mUri), localu1.jKO());
      if (i < 0)
      {
        Log.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + i + ", zipFilePath = " + ah.v(localu1.jKT()) + ", unzipPath = " + localu1.jKO());
        AppMethodBeat.o(104509);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localIOException, "create nomedia file error", new Object[0]);
      }
      oDj = bIG();
      Log.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[] { localu1.jKO(), Integer.valueOf(oDj) });
      AppMethodBeat.o(104509);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelemoji.a
 * JD-Core Version:    0.7.0.1
 */