package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.b;

public final class c
{
  public static final int iuA;
  Context context;
  int duration;
  String fileName;
  Intent intent;
  public a iuB;
  String iuC;
  final AsyncTask<String, Integer, String> iuD;
  String thumbPath;
  String videoPath;
  
  static
  {
    AppMethodBeat.i(126785);
    iuA = b.acr();
    AppMethodBeat.o(126785);
  }
  
  public c()
  {
    AppMethodBeat.i(126783);
    this.context = null;
    this.iuB = null;
    this.iuC = null;
    this.duration = 0;
    this.intent = null;
    this.fileName = null;
    this.thumbPath = null;
    this.videoPath = null;
    this.iuD = new AsyncTask()
    {
      int ret = 0;
      
      /* Error */
      private String aMQ()
      {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: iconst_0
        //   7: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
        //   10: invokestatic 38	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
        //   13: invokestatic 44	com/tencent/mm/sdk/platformtools/az:is2G	(Landroid/content/Context;)Z
        //   16: istore_3
        //   17: aload_0
        //   18: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   21: getfield 48	com/tencent/mm/modelvideo/c:context	Landroid/content/Context;
        //   24: aload_0
        //   25: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   28: getfield 52	com/tencent/mm/modelvideo/c:intent	Landroid/content/Intent;
        //   31: invokestatic 58	com/tencent/mm/compatible/h/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/h/a$a;
        //   34: astore 4
        //   36: aload 4
        //   38: ifnonnull +64 -> 102
        //   41: ldc 60
        //   43: ldc 62
        //   45: invokestatic 68	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   48: getstatic 74	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   51: ldc2_w 75
        //   54: ldc2_w 77
        //   57: lconst_1
        //   58: iconst_0
        //   59: invokevirtual 82	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
        //   62: aload_0
        //   63: ldc 83
        //   65: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
        //   68: ldc 26
        //   70: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   73: aconst_null
        //   74: areturn
        //   75: astore 4
        //   77: ldc 60
        //   79: ldc 88
        //   81: iconst_1
        //   82: anewarray 90	java/lang/Object
        //   85: dup
        //   86: iconst_0
        //   87: aload 4
        //   89: invokestatic 95	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   92: aastore
        //   93: invokestatic 98	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   96: aconst_null
        //   97: astore 4
        //   99: goto -63 -> 36
        //   102: aload_0
        //   103: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   106: aload 4
        //   108: getfield 104	com/tencent/mm/compatible/h/a$a:filename	Ljava/lang/String;
        //   111: putfield 107	com/tencent/mm/modelvideo/c:iuC	Ljava/lang/String;
        //   114: aload_0
        //   115: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   118: getfield 107	com/tencent/mm/modelvideo/c:iuC	Ljava/lang/String;
        //   121: invokestatic 113	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
        //   124: l2i
        //   125: istore_2
        //   126: ldc 60
        //   128: ldc 115
        //   130: iconst_4
        //   131: anewarray 90	java/lang/Object
        //   134: dup
        //   135: iconst_0
        //   136: iload_3
        //   137: invokestatic 121	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   140: aastore
        //   141: dup
        //   142: iconst_1
        //   143: iload_2
        //   144: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   147: aastore
        //   148: dup
        //   149: iconst_2
        //   150: aload 4
        //   152: getfield 129	com/tencent/mm/compatible/h/a$a:duration	I
        //   155: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   158: aastore
        //   159: dup
        //   160: iconst_3
        //   161: aload_0
        //   162: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   165: getfield 107	com/tencent/mm/modelvideo/c:iuC	Ljava/lang/String;
        //   168: aastore
        //   169: invokestatic 131	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   172: iload_2
        //   173: ifgt +30 -> 203
        //   176: getstatic 74	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   179: ldc2_w 75
        //   182: ldc2_w 77
        //   185: lconst_1
        //   186: iconst_0
        //   187: invokevirtual 82	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
        //   190: aload_0
        //   191: ldc 132
        //   193: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
        //   196: ldc 26
        //   198: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   201: aconst_null
        //   202: areturn
        //   203: iload_3
        //   204: ifeq +38 -> 242
        //   207: ldc 133
        //   209: istore_1
        //   210: iload_2
        //   211: iload_1
        //   212: if_icmple +37 -> 249
        //   215: getstatic 74	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   218: ldc2_w 75
        //   221: ldc2_w 134
        //   224: lconst_1
        //   225: iconst_0
        //   226: invokevirtual 82	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
        //   229: aload_0
        //   230: ldc 136
        //   232: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
        //   235: ldc 26
        //   237: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   240: aconst_null
        //   241: areturn
        //   242: getstatic 139	com/tencent/mm/modelvideo/c:iuA	I
        //   245: istore_1
        //   246: goto -36 -> 210
        //   249: aload_0
        //   250: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   253: getfield 107	com/tencent/mm/modelvideo/c:iuC	Ljava/lang/String;
        //   256: aload_0
        //   257: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   260: getfield 142	com/tencent/mm/modelvideo/c:videoPath	Ljava/lang/String;
        //   263: invokestatic 146	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
        //   266: pop2
        //   267: aload_0
        //   268: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   271: aload 4
        //   273: getfield 129	com/tencent/mm/compatible/h/a$a:duration	I
        //   276: sipush 1000
        //   279: idiv
        //   280: putfield 147	com/tencent/mm/modelvideo/c:duration	I
        //   283: iconst_1
        //   284: istore_2
        //   285: iconst_1
        //   286: istore_1
        //   287: aload 4
        //   289: getfield 151	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
        //   292: ifnull +41 -> 333
        //   295: aload 4
        //   297: getfield 151	com/tencent/mm/compatible/h/a$a:bitmap	Landroid/graphics/Bitmap;
        //   300: bipush 60
        //   302: getstatic 157	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   305: aload_0
        //   306: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   309: getfield 160	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
        //   312: iconst_1
        //   313: invokestatic 166	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   316: pop
        //   317: getstatic 74	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   320: ldc2_w 75
        //   323: ldc2_w 167
        //   326: lconst_1
        //   327: iconst_0
        //   328: invokevirtual 82	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
        //   331: iconst_0
        //   332: istore_1
        //   333: iload_1
        //   334: ifeq +45 -> 379
        //   337: getstatic 74	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
        //   340: ldc2_w 75
        //   343: ldc2_w 169
        //   346: lconst_1
        //   347: iconst_0
        //   348: invokevirtual 82	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
        //   351: ldc 171
        //   353: sipush 320
        //   356: sipush 480
        //   359: invokestatic 175	com/tencent/mm/sdk/platformtools/h:aK	(III)Landroid/graphics/Bitmap;
        //   362: bipush 60
        //   364: getstatic 157	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
        //   367: aload_0
        //   368: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   371: getfield 160	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
        //   374: iconst_1
        //   375: invokestatic 166	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
        //   378: pop
        //   379: aload_0
        //   380: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   383: getfield 142	com/tencent/mm/modelvideo/c:videoPath	Ljava/lang/String;
        //   386: invokestatic 179	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
        //   389: ifne +9 -> 398
        //   392: aload_0
        //   393: ldc 180
        //   395: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
        //   398: aload_0
        //   399: getfield 15	com/tencent/mm/modelvideo/c$1:iuE	Lcom/tencent/mm/modelvideo/c;
        //   402: getfield 160	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
        //   405: invokestatic 179	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
        //   408: ifne +9 -> 417
        //   411: aload_0
        //   412: ldc 181
        //   414: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
        //   417: ldc 26
        //   419: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   422: aconst_null
        //   423: areturn
        //   424: astore 4
        //   426: iload_2
        //   427: istore_1
        //   428: ldc 60
        //   430: ldc 88
        //   432: iconst_1
        //   433: anewarray 90	java/lang/Object
        //   436: dup
        //   437: iconst_0
        //   438: aload 4
        //   440: invokestatic 95	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   443: aastore
        //   444: invokestatic 98	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   447: goto -114 -> 333
        //   450: astore 4
        //   452: ldc 60
        //   454: ldc 88
        //   456: iconst_1
        //   457: anewarray 90	java/lang/Object
        //   460: dup
        //   461: iconst_0
        //   462: aload 4
        //   464: invokestatic 95	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   467: aastore
        //   468: invokestatic 98	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   471: goto -92 -> 379
        //   474: astore 4
        //   476: iconst_0
        //   477: istore_1
        //   478: goto -50 -> 428
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	481	0	this	1
        //   209	269	1	i	int
        //   125	302	2	j	int
        //   16	188	3	bool	boolean
        //   34	3	4	locala	com.tencent.mm.compatible.h.a.a
        //   75	13	4	localException1	java.lang.Exception
        //   97	199	4	localObject	Object
        //   424	15	4	localException2	java.lang.Exception
        //   450	13	4	localException3	java.lang.Exception
        //   474	1	4	localException4	java.lang.Exception
        // Exception table:
        //   from	to	target	type
        //   17	36	75	java/lang/Exception
        //   295	317	424	java/lang/Exception
        //   337	379	450	java/lang/Exception
        //   317	331	474	java/lang/Exception
      }
    };
    AppMethodBeat.o(126783);
  }
  
  public final void a(Context paramContext, Intent paramIntent, String paramString, a parama)
  {
    AppMethodBeat.i(217459);
    this.context = paramContext;
    this.intent = paramIntent;
    this.fileName = t.HI(paramString);
    o.aNh();
    this.thumbPath = t.HK(this.fileName);
    o.aNh();
    this.videoPath = t.HJ(this.fileName);
    this.iuB = parama;
    this.iuD.execute(new String[0]);
    AppMethodBeat.o(217459);
  }
  
  public static abstract interface a
  {
    public abstract void c(int paramInt1, String paramString1, String paramString2, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.c
 * JD-Core Version:    0.7.0.1
 */