package com.tencent.mm.an;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

public final class a
{
  private static String dOQ = "";
  public static int ekB = 1;
  
  public static int NA()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      InputStream localInputStream = com.tencent.mm.vfs.e.o(new b(Ny(), "config.conf"));
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
      y.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", new Object[] { str1, Integer.valueOf(i) });
      return i;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      y.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localException, localException.getMessage(), new Object[0]);
      return 1;
    }
    finally
    {
      bk.b(localObject3);
    }
  }
  
  /* Error */
  private static int NB()
  {
    // Byte code:
    //   0: invokestatic 110	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   3: invokevirtual 116	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: astore_1
    //   7: aload_1
    //   8: ldc 118
    //   10: invokevirtual 124	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_2
    //   14: new 43	java/io/InputStreamReader
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 46	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: astore 4
    //   24: new 41	java/io/BufferedReader
    //   27: dup
    //   28: aload 4
    //   30: invokespecial 49	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_1
    //   34: ldc 14
    //   36: astore_3
    //   37: aload_1
    //   38: astore 7
    //   40: aload 4
    //   42: astore 6
    //   44: aload_2
    //   45: astore 5
    //   47: aload_1
    //   48: invokevirtual 52	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 8
    //   53: aload 8
    //   55: ifnull +36 -> 91
    //   58: aload_1
    //   59: astore 7
    //   61: aload 4
    //   63: astore 6
    //   65: aload_2
    //   66: astore 5
    //   68: new 54	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   75: aload_3
    //   76: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 8
    //   81: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_3
    //   88: goto -51 -> 37
    //   91: aload_1
    //   92: astore 7
    //   94: aload 4
    //   96: astore 6
    //   98: aload_2
    //   99: astore 5
    //   101: new 65	org/json/JSONObject
    //   104: dup
    //   105: aload_3
    //   106: invokespecial 68	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: ldc 70
    //   111: invokevirtual 74	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   114: istore_0
    //   115: aload_1
    //   116: astore 7
    //   118: aload 4
    //   120: astore 6
    //   122: aload_2
    //   123: astore 5
    //   125: ldc 76
    //   127: ldc 78
    //   129: iconst_2
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_3
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: iload_0
    //   140: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: invokestatic 90	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload_2
    //   148: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   151: aload 4
    //   153: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   156: aload_1
    //   157: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   160: iload_0
    //   161: ireturn
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_1
    //   165: aconst_null
    //   166: astore 4
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_1
    //   171: astore 7
    //   173: aload 4
    //   175: astore 6
    //   177: aload_2
    //   178: astore 5
    //   180: ldc 76
    //   182: aload_3
    //   183: aload_3
    //   184: invokevirtual 99	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 103	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload_2
    //   195: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   198: aload 4
    //   200: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   203: aload_1
    //   204: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   207: iconst_1
    //   208: ireturn
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_3
    //   212: aconst_null
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_2
    //   217: aload_2
    //   218: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   221: aload 4
    //   223: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   226: aload_3
    //   227: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_3
    //   235: aconst_null
    //   236: astore 4
    //   238: goto -21 -> 217
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_3
    //   244: goto -27 -> 217
    //   247: astore_1
    //   248: aload 7
    //   250: astore_3
    //   251: aload 6
    //   253: astore 4
    //   255: aload 5
    //   257: astore_2
    //   258: goto -41 -> 217
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_1
    //   264: aconst_null
    //   265: astore 4
    //   267: goto -97 -> 170
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_1
    //   273: goto -103 -> 170
    //   276: astore_3
    //   277: goto -107 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   114	47	0	i	int
    //   6	198	1	localObject1	Object
    //   209	22	1	localObject2	Object
    //   232	1	1	localObject3	Object
    //   241	1	1	localObject4	Object
    //   247	1	1	localObject5	Object
    //   263	10	1	localObject6	Object
    //   13	245	2	localObject7	Object
    //   36	100	3	str1	String
    //   162	22	3	localException1	Exception
    //   211	40	3	localObject8	Object
    //   261	1	3	localException2	Exception
    //   270	1	3	localException3	Exception
    //   276	1	3	localException4	Exception
    //   22	244	4	localObject9	Object
    //   45	211	5	localObject10	Object
    //   42	210	6	localObject11	Object
    //   38	211	7	localObject12	Object
    //   51	29	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   7	14	162	java/lang/Exception
    //   7	14	209	finally
    //   14	24	232	finally
    //   24	34	241	finally
    //   47	53	247	finally
    //   68	88	247	finally
    //   101	115	247	finally
    //   125	147	247	finally
    //   180	194	247	finally
    //   14	24	261	java/lang/Exception
    //   24	34	270	java/lang/Exception
    //   47	53	276	java/lang/Exception
    //   68	88	276	java/lang/Exception
    //   101	115	276	java/lang/Exception
    //   125	147	276	java/lang/Exception
  }
  
  private static String Nx()
  {
    if (bk.bl(dOQ)) {
      dOQ = com.tencent.mm.compatible.util.e.dOQ.replace("/data/user/0", "/data/data");
    }
    return dOQ;
  }
  
  public static String Ny()
  {
    b localb = new b(Nx(), "emoji/res");
    if (!localb.exists()) {
      localb.mkdirs();
    }
    return j.n(localb.cLr());
  }
  
  public static String Nz()
  {
    return Nx() + "emoji/newemoji/";
  }
  
  public static void bV(boolean paramBoolean)
  {
    b localb = new b(Ny());
    y.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", new Object[] { localb.cLs() });
    if (d.spd)
    {
      y.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.vfs.e.K(j.n(localb.mUri), true);
      c(localb);
    }
    for (;;)
    {
      com.tencent.mm.vfs.e.K(j.n(new b(com.tencent.mm.compatible.util.e.bkH, "emoji").mUri), true);
      return;
      ekB = NA();
      if (paramBoolean)
      {
        int i = NB();
        y.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(ekB) });
        if (ekB < i)
        {
          com.tencent.mm.vfs.e.K(j.n(localb.mUri), true);
          c(localb);
        }
      }
      else if (ekB == 1)
      {
        y.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", new Object[] { Integer.valueOf(ekB) });
        com.tencent.mm.vfs.e.K(j.n(localb.mUri), true);
        c(localb);
      }
    }
  }
  
  private static void c(b paramb)
  {
    if (!paramb.exists()) {
      paramb.mkdirs();
    }
    b localb = new b(paramb, ".nomedia");
    if (!localb.exists()) {}
    try
    {
      localb.createNewFile();
      paramb = new b(paramb, "emoji_template.zip");
      if (lR(j.n(paramb.cLr())))
      {
        int i = com.tencent.mm.vfs.e.gE(j.n(paramb.cLr()), paramb.getParent());
        if (i < 0)
        {
          y.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + i + ", zipFilePath = " + j.n(paramb.cLr()) + ", unzipPath = " + paramb.getParent());
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localIOException, "create nomedia file error", new Object[0]);
      }
      ekB = NA();
      y.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[] { paramb.getParent(), Integer.valueOf(ekB) });
      return;
    }
    y.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", new Object[] { j.n(paramb.cLr()) });
  }
  
  public static void d(b paramb)
  {
    b localb1 = new b(Ny());
    com.tencent.mm.vfs.e.K(j.n(localb1.mUri), true);
    localb1.mkdirs();
    b localb2 = new b(localb1, ".nomedia");
    if (!localb2.exists()) {}
    try
    {
      localb2.createNewFile();
      localb1 = new b(localb1, "emoji_template.zip");
      com.tencent.mm.vfs.e.r(j.n(paramb.mUri), j.n(localb1.mUri));
      int i = bk.gh(j.n(localb1.mUri), localb1.getParent());
      if (i < 0)
      {
        y.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + i + ", zipFilePath = " + j.n(localb1.cLr()) + ", unzipPath = " + localb1.getParent());
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", localIOException, "create nomedia file error", new Object[0]);
      }
      ekB = NA();
      y.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", new Object[] { localb1.getParent(), Integer.valueOf(ekB) });
    }
  }
  
  /* Error */
  private static boolean lR(String paramString)
  {
    // Byte code:
    //   0: invokestatic 110	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   3: invokevirtual 116	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 228
    //   10: invokevirtual 124	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +31 -> 46
    //   18: ldc 76
    //   20: ldc_w 268
    //   23: invokestatic 251	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: astore_2
    //   29: ldc 76
    //   31: aload_2
    //   32: ldc 14
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokestatic 103	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aconst_null
    //   42: astore_2
    //   43: goto -29 -> 14
    //   46: new 23	com/tencent/mm/vfs/b
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 169	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 150	com/tencent/mm/vfs/b:exists	()Z
    //   59: ifeq +8 -> 67
    //   62: aload_0
    //   63: invokevirtual 271	com/tencent/mm/vfs/b:delete	()Z
    //   66: pop
    //   67: aload_0
    //   68: invokevirtual 274	com/tencent/mm/vfs/b:cLq	()Lcom/tencent/mm/vfs/b;
    //   71: invokevirtual 153	com/tencent/mm/vfs/b:mkdirs	()Z
    //   74: pop
    //   75: aload_0
    //   76: invokestatic 278	com/tencent/mm/vfs/e:p	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull +92 -> 173
    //   84: sipush 1024
    //   87: newarray byte
    //   89: astore_3
    //   90: aload_2
    //   91: aload_3
    //   92: invokevirtual 284	java/io/InputStream:read	([B)I
    //   95: istore_1
    //   96: iload_1
    //   97: iconst_m1
    //   98: if_icmpeq +54 -> 152
    //   101: aload_0
    //   102: aload_3
    //   103: iconst_0
    //   104: iload_1
    //   105: invokevirtual 290	java/io/OutputStream:write	([BII)V
    //   108: goto -18 -> 90
    //   111: astore_3
    //   112: ldc 76
    //   114: aload_3
    //   115: ldc 14
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 103	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_2
    //   125: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   128: aload_0
    //   129: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: astore_0
    //   135: ldc 76
    //   137: aload_0
    //   138: ldc 14
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 103	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aconst_null
    //   148: astore_0
    //   149: goto -69 -> 80
    //   152: aload_2
    //   153: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   156: aload_0
    //   157: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   160: iconst_1
    //   161: ireturn
    //   162: astore_3
    //   163: aload_2
    //   164: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   167: aload_0
    //   168: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   171: aload_3
    //   172: athrow
    //   173: aload_2
    //   174: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   177: iconst_0
    //   178: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramString	String
    //   95	10	1	i	int
    //   6	9	2	localObject1	Object
    //   28	4	2	localIOException1	IOException
    //   42	132	2	localCloseable	java.io.Closeable
    //   89	14	3	arrayOfByte	byte[]
    //   111	4	3	localIOException2	IOException
    //   162	10	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	14	28	java/io/IOException
    //   84	90	111	java/io/IOException
    //   90	96	111	java/io/IOException
    //   101	108	111	java/io/IOException
    //   75	80	134	java/io/FileNotFoundException
    //   84	90	162	finally
    //   90	96	162	finally
    //   101	108	162	finally
    //   112	124	162	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.an.a
 * JD-Core Version:    0.7.0.1
 */