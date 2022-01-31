package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public final class a
{
  private static String eQw = "";
  public static int fAR = 1;
  
  private static String agk()
  {
    AppMethodBeat.i(62273);
    if (bo.isNullOrNil(eQw)) {
      eQw = com.tencent.mm.compatible.util.e.eQw.replace("/data/user/0", "/data/data");
    }
    String str = eQw;
    AppMethodBeat.o(62273);
    return str;
  }
  
  public static String agl()
  {
    AppMethodBeat.i(62274);
    Object localObject = new b(agk(), "emoji/res");
    if (!((b)localObject).exists()) {
      ((b)localObject).mkdirs();
    }
    localObject = j.p(((b)localObject).dQJ());
    AppMethodBeat.o(62274);
    return localObject;
  }
  
  public static String agm()
  {
    AppMethodBeat.i(62275);
    String str = agk() + "emoji/newemoji/";
    AppMethodBeat.o(62275);
    return str;
  }
  
  public static int agn()
  {
    AppMethodBeat.i(62276);
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      InputStream localInputStream = com.tencent.mm.vfs.e.q(new b(agl(), "config.conf"));
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
      ab.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", new Object[] { str1, Integer.valueOf(i) });
      return i;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localException, localException.getMessage(), new Object[0]);
      return 1;
    }
    finally
    {
      bo.b(localObject3);
      AppMethodBeat.o(62276);
    }
  }
  
  /* Error */
  private static int ago()
  {
    // Byte code:
    //   0: ldc 160
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 166	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   8: invokevirtual 172	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 174
    //   15: invokevirtual 180	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_2
    //   19: new 111	java/io/InputStreamReader
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 114	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: astore 4
    //   29: new 109	java/io/BufferedReader
    //   32: dup
    //   33: aload 4
    //   35: invokespecial 117	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
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
    //   53: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 8
    //   58: aload 8
    //   60: ifnull +36 -> 96
    //   63: aload_1
    //   64: astore 7
    //   66: aload 4
    //   68: astore 6
    //   70: aload_2
    //   71: astore 5
    //   73: new 81	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   80: aload_3
    //   81: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_3
    //   93: goto -51 -> 42
    //   96: aload_1
    //   97: astore 7
    //   99: aload 4
    //   101: astore 6
    //   103: aload_2
    //   104: astore 5
    //   106: new 122	org/json/JSONObject
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 125	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   114: ldc 127
    //   116: invokevirtual 131	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   119: istore_0
    //   120: aload_1
    //   121: astore 7
    //   123: aload 4
    //   125: astore 6
    //   127: aload_2
    //   128: astore 5
    //   130: ldc 133
    //   132: ldc 135
    //   134: iconst_2
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_3
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: iload_0
    //   145: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_2
    //   153: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   156: aload 4
    //   158: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   161: aload_1
    //   162: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   165: ldc 160
    //   167: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   190: ldc 133
    //   192: aload_3
    //   193: aload_3
    //   194: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_2
    //   205: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   208: aload 4
    //   210: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   213: aload_1
    //   214: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   217: ldc 160
    //   219: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   233: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   236: aload 4
    //   238: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   241: aload_3
    //   242: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   245: ldc 160
    //   247: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void cX(boolean paramBoolean)
  {
    AppMethodBeat.i(62279);
    b localb = new b(agl());
    ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", new Object[] { localb.dQK() });
    if (d.whK)
    {
      ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.vfs.e.O(j.p(localb.mUri), true);
      d(localb);
    }
    for (;;)
    {
      com.tencent.mm.vfs.e.O(j.p(new b(com.tencent.mm.compatible.util.e.eQz, "emoji").mUri), true);
      AppMethodBeat.o(62279);
      return;
      fAR = agn();
      if (paramBoolean)
      {
        int i = ago();
        ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(fAR) });
        if (fAR < i)
        {
          com.tencent.mm.vfs.e.O(j.p(localb.mUri), true);
          d(localb);
        }
      }
      else if (fAR == 1)
      {
        ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", new Object[] { Integer.valueOf(fAR) });
        com.tencent.mm.vfs.e.O(j.p(localb.mUri), true);
        d(localb);
      }
    }
  }
  
  private static void d(b paramb)
  {
    AppMethodBeat.i(62280);
    if (!paramb.exists()) {
      paramb.mkdirs();
    }
    b localb = new b(paramb, ".nomedia");
    if (!localb.exists()) {}
    try
    {
      localb.createNewFile();
      paramb = new b(paramb, "emoji_template.zip");
      if (sP(j.p(paramb.dQJ())))
      {
        int i = com.tencent.mm.vfs.e.iH(j.p(paramb.dQJ()), paramb.getParent());
        if (i < 0)
        {
          ab.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + i + ", zipFilePath = " + j.p(paramb.dQJ()) + ", unzipPath = " + paramb.getParent());
          AppMethodBeat.o(62280);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localIOException, "create nomedia file error", new Object[0]);
      }
      fAR = agn();
      ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[] { paramb.getParent(), Integer.valueOf(fAR) });
      AppMethodBeat.o(62280);
      return;
    }
    ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", new Object[] { j.p(paramb.dQJ()) });
    AppMethodBeat.o(62280);
  }
  
  public static void e(b paramb)
  {
    AppMethodBeat.i(62281);
    b localb1 = new b(agl());
    com.tencent.mm.vfs.e.O(j.p(localb1.mUri), true);
    localb1.mkdirs();
    b localb2 = new b(localb1, ".nomedia");
    if (!localb2.exists()) {}
    try
    {
      localb2.createNewFile();
      localb1 = new b(localb1, "emoji_template.zip");
      com.tencent.mm.vfs.e.C(j.p(paramb.mUri), j.p(localb1.mUri));
      int i = bo.ii(j.p(localb1.mUri), localb1.getParent());
      if (i < 0)
      {
        ab.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + i + ", zipFilePath = " + j.p(localb1.dQJ()) + ", unzipPath = " + localb1.getParent());
        AppMethodBeat.o(62281);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localIOException, "create nomedia file error", new Object[0]);
      }
      fAR = agn();
      ab.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[] { localb1.getParent(), Integer.valueOf(fAR) });
      AppMethodBeat.o(62281);
    }
  }
  
  /* Error */
  private static boolean sP(String paramString)
  {
    // Byte code:
    //   0: ldc_w 282
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 166	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   9: invokevirtual 172	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_2
    //   13: aload_2
    //   14: ldc 242
    //   16: invokevirtual 180	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +37 -> 58
    //   24: ldc 133
    //   26: ldc_w 284
    //   29: invokestatic 265	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 282
    //   35: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: ireturn
    //   40: astore_2
    //   41: ldc 133
    //   43: aload_2
    //   44: ldc 14
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aconst_null
    //   54: astore_2
    //   55: goto -35 -> 20
    //   58: new 52	com/tencent/mm/vfs/b
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 184	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 64	com/tencent/mm/vfs/b:exists	()Z
    //   71: ifeq +8 -> 79
    //   74: aload_0
    //   75: invokevirtual 287	com/tencent/mm/vfs/b:delete	()Z
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 290	com/tencent/mm/vfs/b:dQI	()Lcom/tencent/mm/vfs/b;
    //   83: invokevirtual 67	com/tencent/mm/vfs/b:mkdirs	()Z
    //   86: pop
    //   87: aload_0
    //   88: invokestatic 294	com/tencent/mm/vfs/e:r	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull +110 -> 203
    //   96: sipush 1024
    //   99: newarray byte
    //   101: astore_3
    //   102: aload_2
    //   103: aload_3
    //   104: invokevirtual 300	java/io/InputStream:read	([B)I
    //   107: istore_1
    //   108: iload_1
    //   109: iconst_m1
    //   110: if_icmpeq +60 -> 170
    //   113: aload_0
    //   114: aload_3
    //   115: iconst_0
    //   116: iload_1
    //   117: invokevirtual 306	java/io/OutputStream:write	([BII)V
    //   120: goto -18 -> 102
    //   123: astore_3
    //   124: ldc 133
    //   126: aload_3
    //   127: ldc 14
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_2
    //   137: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   140: aload_0
    //   141: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   144: ldc_w 282
    //   147: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_0
    //   153: ldc 133
    //   155: aload_0
    //   156: ldc 14
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 158	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aconst_null
    //   166: astore_0
    //   167: goto -75 -> 92
    //   170: aload_2
    //   171: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   174: aload_0
    //   175: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   178: ldc_w 282
    //   181: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_3
    //   187: aload_2
    //   188: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   191: aload_0
    //   192: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   195: ldc_w 282
    //   198: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload_3
    //   202: athrow
    //   203: aload_2
    //   204: invokestatic 151	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   207: ldc_w 282
    //   210: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iconst_0
    //   214: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   107	10	1	i	int
    //   12	9	2	localObject1	Object
    //   40	4	2	localIOException1	IOException
    //   54	150	2	localCloseable	java.io.Closeable
    //   101	14	3	arrayOfByte	byte[]
    //   123	4	3	localIOException2	IOException
    //   186	16	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	40	java/io/IOException
    //   96	102	123	java/io/IOException
    //   102	108	123	java/io/IOException
    //   113	120	123	java/io/IOException
    //   87	92	152	java/io/FileNotFoundException
    //   96	102	186	finally
    //   102	108	186	finally
    //   113	120	186	finally
    //   124	136	186	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ao.a
 * JD-Core Version:    0.7.0.1
 */