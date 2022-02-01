package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.c;

public final class g
{
  public static final long mfo;
  Context context;
  int duration;
  String fileName;
  Intent intent;
  public a mfp;
  String mfq;
  final AsyncTask<String, Integer, String> mfr;
  String thumbPath;
  String videoPath;
  
  static
  {
    AppMethodBeat.i(126785);
    mfo = c.awJ();
    AppMethodBeat.o(126785);
  }
  
  public g()
  {
    AppMethodBeat.i(126783);
    this.context = null;
    this.mfp = null;
    this.mfq = null;
    this.duration = 0;
    this.intent = null;
    this.fileName = null;
    this.thumbPath = null;
    this.videoPath = null;
    this.mfr = new AsyncTask()
    {
      int ret = 0;
      
      /* Error */
      private String bqj()
      {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: iconst_0
        //   7: putfield 20	com/tencent/mm/modelvideo/g$1:ret	I
        //   10: invokestatic 38	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   13: invokestatic 44	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
        //   16: istore_3
        //   17: aload_0
        //   18: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   21: getfield 48	com/tencent/mm/modelvideo/g:context	Landroid/content/Context;
        //   24: aload_0
        //   25: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   28: getfield 52	com/tencent/mm/modelvideo/g:intent	Landroid/content/Intent;
        //   31: invokestatic 58	com/tencent/mm/compatible/i/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/i/a$a;
        //   34: astore 8
        //   36: aload 8
        //   38: ifnonnull +64 -> 102
        //   41: ldc 60
        //   43: ldc 62
        //   45: invokestatic 68	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   48: getstatic 74	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   51: ldc2_w 75
        //   54: ldc2_w 77
        //   57: lconst_1
        //   58: iconst_0
        //   59: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
        //   62: aload_0
        //   63: ldc 83
        //   65: putfield 20	com/tencent/mm/modelvideo/g$1:ret	I
        //   68: ldc 26
        //   70: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   73: aconst_null
        //   74: areturn
        //   75: astore 8
        //   77: ldc 60
        //   79: ldc 88
        //   81: iconst_1
        //   82: anewarray 90	java/lang/Object
        //   85: dup
        //   86: iconst_0
        //   87: aload 8
        //   89: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   92: aastore
        //   93: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   96: aconst_null
        //   97: astore 8
        //   99: goto -63 -> 36
        //   102: aload_0
        //   103: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   106: aload 8
        //   108: getfield 105	com/tencent/mm/compatible/i/a$a:filename	Ljava/lang/String;
        //   111: putfield 108	com/tencent/mm/modelvideo/g:mfq	Ljava/lang/String;
        //   114: aload_0
        //   115: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   118: getfield 108	com/tencent/mm/modelvideo/g:mfq	Ljava/lang/String;
        //   121: invokestatic 114	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
        //   124: l2i
        //   125: istore_1
        //   126: ldc 60
        //   128: ldc 116
        //   130: iconst_4
        //   131: anewarray 90	java/lang/Object
        //   134: dup
        //   135: iconst_0
        //   136: iload_3
        //   137: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   140: aastore
        //   141: dup
        //   142: iconst_1
        //   143: iload_1
        //   144: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   147: aastore
        //   148: dup
        //   149: iconst_2
        //   150: aload 8
        //   152: getfield 130	com/tencent/mm/compatible/i/a$a:duration	I
        //   155: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   158: aastore
        //   159: dup
        //   160: iconst_3
        //   161: aload_0
        //   162: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   165: getfield 108	com/tencent/mm/modelvideo/g:mfq	Ljava/lang/String;
        //   168: aastore
        //   169: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   172: iload_1
        //   173: ifgt +30 -> 203
        //   176: getstatic 74	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   179: ldc2_w 75
        //   182: ldc2_w 77
        //   185: lconst_1
        //   186: iconst_0
        //   187: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
        //   190: aload_0
        //   191: ldc 133
        //   193: putfield 20	com/tencent/mm/modelvideo/g$1:ret	I
        //   196: ldc 26
        //   198: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   201: aconst_null
        //   202: areturn
        //   203: iload_1
        //   204: i2l
        //   205: lstore 6
        //   207: iload_3
        //   208: ifeq +43 -> 251
        //   211: ldc2_w 134
        //   214: lstore 4
        //   216: lload 6
        //   218: lload 4
        //   220: lcmp
        //   221: ifle +38 -> 259
        //   224: getstatic 74	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   227: ldc2_w 75
        //   230: ldc2_w 136
        //   233: lconst_1
        //   234: iconst_0
        //   235: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
        //   238: aload_0
        //   239: ldc 138
        //   241: putfield 20	com/tencent/mm/modelvideo/g$1:ret	I
        //   244: ldc 26
        //   246: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   249: aconst_null
        //   250: areturn
        //   251: getstatic 142	com/tencent/mm/modelvideo/g:mfo	J
        //   254: lstore 4
        //   256: goto -40 -> 216
        //   259: aload_0
        //   260: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   263: getfield 108	com/tencent/mm/modelvideo/g:mfq	Ljava/lang/String;
        //   266: aload_0
        //   267: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   270: getfield 145	com/tencent/mm/modelvideo/g:videoPath	Ljava/lang/String;
        //   273: invokestatic 149	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
        //   276: pop2
        //   277: aload_0
        //   278: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   281: aload 8
        //   283: getfield 130	com/tencent/mm/compatible/i/a$a:duration	I
        //   286: sipush 1000
        //   289: idiv
        //   290: putfield 150	com/tencent/mm/modelvideo/g:duration	I
        //   293: iconst_1
        //   294: istore_2
        //   295: iconst_1
        //   296: istore_1
        //   297: aload 8
        //   299: getfield 154	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
        //   302: ifnull +41 -> 343
        //   305: aload 8
        //   307: getfield 154	com/tencent/mm/compatible/i/a$a:bitmap	Landroid/graphics/Bitmap;
        //   310: bipush 60
        //   312: getstatic 160	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   315: aload_0
        //   316: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   319: getfield 163	com/tencent/mm/modelvideo/g:thumbPath	Ljava/lang/String;
        //   322: iconst_1
        //   323: invokestatic 169	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   326: pop
        //   327: getstatic 74	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   330: ldc2_w 75
        //   333: ldc2_w 170
        //   336: lconst_1
        //   337: iconst_0
        //   338: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
        //   341: iconst_0
        //   342: istore_1
        //   343: iload_1
        //   344: ifeq +45 -> 389
        //   347: getstatic 74	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
        //   350: ldc2_w 75
        //   353: ldc2_w 172
        //   356: lconst_1
        //   357: iconst_0
        //   358: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
        //   361: ldc 174
        //   363: sipush 320
        //   366: sipush 480
        //   369: invokestatic 178	com/tencent/mm/sdk/platformtools/BitmapUtil:createColorBitmap	(III)Landroid/graphics/Bitmap;
        //   372: bipush 60
        //   374: getstatic 160	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   377: aload_0
        //   378: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   381: getfield 163	com/tencent/mm/modelvideo/g:thumbPath	Ljava/lang/String;
        //   384: iconst_1
        //   385: invokestatic 169	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   388: pop
        //   389: aload_0
        //   390: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   393: getfield 145	com/tencent/mm/modelvideo/g:videoPath	Ljava/lang/String;
        //   396: invokestatic 182	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
        //   399: ifne +9 -> 408
        //   402: aload_0
        //   403: ldc 183
        //   405: putfield 20	com/tencent/mm/modelvideo/g$1:ret	I
        //   408: aload_0
        //   409: getfield 15	com/tencent/mm/modelvideo/g$1:mfs	Lcom/tencent/mm/modelvideo/g;
        //   412: getfield 163	com/tencent/mm/modelvideo/g:thumbPath	Ljava/lang/String;
        //   415: invokestatic 182	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
        //   418: ifne +9 -> 427
        //   421: aload_0
        //   422: ldc 184
        //   424: putfield 20	com/tencent/mm/modelvideo/g$1:ret	I
        //   427: ldc 26
        //   429: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   432: aconst_null
        //   433: areturn
        //   434: astore 8
        //   436: iload_2
        //   437: istore_1
        //   438: ldc 60
        //   440: ldc 88
        //   442: iconst_1
        //   443: anewarray 90	java/lang/Object
        //   446: dup
        //   447: iconst_0
        //   448: aload 8
        //   450: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   453: aastore
        //   454: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   457: goto -114 -> 343
        //   460: astore 8
        //   462: ldc 60
        //   464: ldc 88
        //   466: iconst_1
        //   467: anewarray 90	java/lang/Object
        //   470: dup
        //   471: iconst_0
        //   472: aload 8
        //   474: invokestatic 96	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   477: aastore
        //   478: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   481: goto -92 -> 389
        //   484: astore 8
        //   486: iconst_0
        //   487: istore_1
        //   488: goto -50 -> 438
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	491	0	this	1
        //   125	363	1	i	int
        //   294	143	2	j	int
        //   16	192	3	bool	boolean
        //   214	41	4	l1	long
        //   205	12	6	l2	long
        //   34	3	8	locala	com.tencent.mm.compatible.i.a.a
        //   75	13	8	localException1	java.lang.Exception
        //   97	209	8	localObject	Object
        //   434	15	8	localException2	java.lang.Exception
        //   460	13	8	localException3	java.lang.Exception
        //   484	1	8	localException4	java.lang.Exception
        // Exception table:
        //   from	to	target	type
        //   17	36	75	java/lang/Exception
        //   305	327	434	java/lang/Exception
        //   347	389	460	java/lang/Exception
        //   327	341	484	java/lang/Exception
      }
    };
    AppMethodBeat.o(126783);
  }
  
  public final void a(Context paramContext, Intent paramIntent, String paramString, a parama)
  {
    AppMethodBeat.i(215820);
    this.context = paramContext;
    this.intent = paramIntent;
    this.fileName = x.XS(paramString);
    s.bqB();
    this.thumbPath = x.XU(this.fileName);
    s.bqB();
    this.videoPath = x.XT(this.fileName);
    this.mfp = parama;
    this.mfr.execute(new String[0]);
    AppMethodBeat.o(215820);
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt1, String paramString1, String paramString2, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.g
 * JD-Core Version:    0.7.0.1
 */