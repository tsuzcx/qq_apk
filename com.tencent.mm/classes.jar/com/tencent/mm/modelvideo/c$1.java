package com.tencent.mm.modelvideo;

import android.os.AsyncTask;

final class c$1
  extends AsyncTask<String, Integer, String>
{
  int ret = 0;
  
  c$1(c paramc) {}
  
  /* Error */
  private String Sb()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   5: invokestatic 31	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   8: invokestatic 37	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   11: istore_3
    //   12: aload_0
    //   13: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   16: getfield 41	com/tencent/mm/modelvideo/c:context	Landroid/content/Context;
    //   19: aload_0
    //   20: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   23: getfield 45	com/tencent/mm/modelvideo/c:intent	Landroid/content/Intent;
    //   26: invokestatic 51	com/tencent/mm/compatible/j/a:h	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/j/a$a;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnonnull +59 -> 92
    //   36: ldc 53
    //   38: ldc 55
    //   40: invokestatic 61	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: getstatic 67	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   46: ldc2_w 68
    //   49: ldc2_w 70
    //   52: lconst_1
    //   53: iconst_0
    //   54: invokevirtual 75	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   57: aload_0
    //   58: ldc 76
    //   60: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   63: aconst_null
    //   64: areturn
    //   65: astore 4
    //   67: ldc 53
    //   69: ldc 78
    //   71: iconst_1
    //   72: anewarray 80	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: aload 4
    //   79: invokestatic 86	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   82: aastore
    //   83: invokestatic 89	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aconst_null
    //   87: astore 4
    //   89: goto -58 -> 31
    //   92: aload_0
    //   93: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   96: aload 4
    //   98: getfield 95	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   101: putfield 98	com/tencent/mm/modelvideo/c:eFj	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   108: getfield 98	com/tencent/mm/modelvideo/c:eFj	Ljava/lang/String;
    //   111: invokestatic 104	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   114: l2i
    //   115: istore_2
    //   116: ldc 53
    //   118: ldc 106
    //   120: iconst_4
    //   121: anewarray 80	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: iload_3
    //   127: invokestatic 112	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: iload_2
    //   134: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_2
    //   140: aload 4
    //   142: getfield 120	com/tencent/mm/compatible/j/a$a:duration	I
    //   145: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: iconst_3
    //   151: aload_0
    //   152: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   155: getfield 98	com/tencent/mm/modelvideo/c:eFj	Ljava/lang/String;
    //   158: aastore
    //   159: invokestatic 123	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: iload_2
    //   163: ifgt +25 -> 188
    //   166: getstatic 67	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   169: ldc2_w 68
    //   172: ldc2_w 70
    //   175: lconst_1
    //   176: iconst_0
    //   177: invokevirtual 75	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   180: aload_0
    //   181: ldc 124
    //   183: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   186: aconst_null
    //   187: areturn
    //   188: iload_3
    //   189: ifeq +33 -> 222
    //   192: ldc 125
    //   194: istore_1
    //   195: iload_2
    //   196: iload_1
    //   197: if_icmple +32 -> 229
    //   200: getstatic 67	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   203: ldc2_w 68
    //   206: ldc2_w 126
    //   209: lconst_1
    //   210: iconst_0
    //   211: invokevirtual 75	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   214: aload_0
    //   215: ldc 128
    //   217: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   220: aconst_null
    //   221: areturn
    //   222: getstatic 131	com/tencent/mm/modelvideo/c:eFh	I
    //   225: istore_1
    //   226: goto -31 -> 195
    //   229: aload_0
    //   230: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   233: getfield 98	com/tencent/mm/modelvideo/c:eFj	Ljava/lang/String;
    //   236: aload_0
    //   237: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   240: getfield 134	com/tencent/mm/modelvideo/c:videoPath	Ljava/lang/String;
    //   243: invokestatic 138	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   246: pop2
    //   247: aload_0
    //   248: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   251: aload 4
    //   253: getfield 120	com/tencent/mm/compatible/j/a$a:duration	I
    //   256: sipush 1000
    //   259: idiv
    //   260: putfield 139	com/tencent/mm/modelvideo/c:duration	I
    //   263: iconst_1
    //   264: istore_2
    //   265: iconst_1
    //   266: istore_1
    //   267: aload 4
    //   269: getfield 143	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   272: ifnull +40 -> 312
    //   275: aload 4
    //   277: getfield 143	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   280: bipush 60
    //   282: getstatic 149	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   285: aload_0
    //   286: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   289: getfield 152	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
    //   292: iconst_1
    //   293: invokestatic 157	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   296: getstatic 67	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   299: ldc2_w 68
    //   302: ldc2_w 158
    //   305: lconst_1
    //   306: iconst_0
    //   307: invokevirtual 75	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   310: iconst_0
    //   311: istore_1
    //   312: iload_1
    //   313: ifeq +44 -> 357
    //   316: getstatic 67	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   319: ldc2_w 68
    //   322: ldc2_w 160
    //   325: lconst_1
    //   326: iconst_0
    //   327: invokevirtual 75	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   330: ldc 162
    //   332: sipush 320
    //   335: sipush 480
    //   338: invokestatic 166	com/tencent/mm/sdk/platformtools/c:ah	(III)Landroid/graphics/Bitmap;
    //   341: bipush 60
    //   343: getstatic 149	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   346: aload_0
    //   347: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   350: getfield 152	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
    //   353: iconst_1
    //   354: invokestatic 157	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   357: aload_0
    //   358: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   361: getfield 134	com/tencent/mm/modelvideo/c:videoPath	Ljava/lang/String;
    //   364: invokestatic 170	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   367: ifne +9 -> 376
    //   370: aload_0
    //   371: ldc 171
    //   373: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   376: aload_0
    //   377: getfield 15	com/tencent/mm/modelvideo/c$1:eFl	Lcom/tencent/mm/modelvideo/c;
    //   380: getfield 152	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
    //   383: invokestatic 170	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   386: ifne +9 -> 395
    //   389: aload_0
    //   390: ldc 172
    //   392: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   395: aconst_null
    //   396: areturn
    //   397: astore 4
    //   399: iload_2
    //   400: istore_1
    //   401: ldc 53
    //   403: ldc 78
    //   405: iconst_1
    //   406: anewarray 80	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: aload 4
    //   413: invokestatic 86	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   416: aastore
    //   417: invokestatic 89	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: goto -108 -> 312
    //   423: astore 4
    //   425: ldc 53
    //   427: ldc 78
    //   429: iconst_1
    //   430: anewarray 80	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload 4
    //   437: invokestatic 86	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   440: aastore
    //   441: invokestatic 89	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: goto -87 -> 357
    //   447: astore 4
    //   449: iconst_0
    //   450: istore_1
    //   451: goto -50 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	1
    //   194	257	1	i	int
    //   115	285	2	j	int
    //   11	178	3	bool	boolean
    //   29	3	4	locala	com.tencent.mm.compatible.j.a.a
    //   65	13	4	localException1	java.lang.Exception
    //   87	189	4	localObject	java.lang.Object
    //   397	15	4	localException2	java.lang.Exception
    //   423	13	4	localException3	java.lang.Exception
    //   447	1	4	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	31	65	java/lang/Exception
    //   275	296	397	java/lang/Exception
    //   316	357	423	java/lang/Exception
    //   296	310	447	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.c.1
 * JD-Core Version:    0.7.0.1
 */