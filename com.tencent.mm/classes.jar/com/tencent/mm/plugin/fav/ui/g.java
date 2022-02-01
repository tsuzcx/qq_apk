package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.aj;

public final class g
  implements s
{
  private int height;
  private String qdZ;
  private String url;
  private int width;
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.qdZ = paramString1;
    this.url = paramString2;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore_3
    //   7: getstatic 47	com/tencent/mm/platformtools/s$a:hUk	Lcom/tencent/mm/platformtools/s$a;
    //   10: aload_2
    //   11: if_acmpne +172 -> 183
    //   14: aload_1
    //   15: astore_3
    //   16: ldc 49
    //   18: ldc 51
    //   20: iconst_1
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 21	com/tencent/mm/plugin/fav/ui/g:url	Ljava/lang/String;
    //   30: aastore
    //   31: invokestatic 57	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_1
    //   35: astore_3
    //   36: new 59	com/tencent/mm/vfs/e
    //   39: dup
    //   40: invokestatic 65	com/tencent/mm/plugin/fav/a/b:chp	()Ljava/lang/String;
    //   43: invokespecial 68	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_1
    //   48: astore_3
    //   49: aload_2
    //   50: invokevirtual 72	com/tencent/mm/vfs/e:exists	()Z
    //   53: ifne +10 -> 63
    //   56: aload_1
    //   57: astore_3
    //   58: aload_2
    //   59: invokevirtual 75	com/tencent/mm/vfs/e:mkdirs	()Z
    //   62: pop
    //   63: aload_1
    //   64: astore_2
    //   65: aload_1
    //   66: astore_3
    //   67: aload_0
    //   68: getfield 23	com/tencent/mm/plugin/fav/ui/g:width	I
    //   71: ifle +30 -> 101
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: astore_3
    //   78: aload_0
    //   79: getfield 25	com/tencent/mm/plugin/fav/ui/g:height	I
    //   82: ifle +19 -> 101
    //   85: aload_1
    //   86: astore_3
    //   87: aload_1
    //   88: aload_0
    //   89: getfield 23	com/tencent/mm/plugin/fav/ui/g:width	I
    //   92: aload_0
    //   93: getfield 25	com/tencent/mm/plugin/fav/ui/g:height	I
    //   96: iconst_1
    //   97: invokestatic 81	com/tencent/mm/sdk/platformtools/f:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   100: astore_2
    //   101: aload_2
    //   102: astore_3
    //   103: new 59	com/tencent/mm/vfs/e
    //   106: dup
    //   107: aload_0
    //   108: invokevirtual 84	com/tencent/mm/plugin/fav/ui/g:aGy	()Ljava/lang/String;
    //   111: invokespecial 68	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   114: astore 5
    //   116: aload_2
    //   117: astore_3
    //   118: aload 5
    //   120: invokevirtual 87	com/tencent/mm/vfs/e:createNewFile	()Z
    //   123: pop
    //   124: aconst_null
    //   125: astore 4
    //   127: aconst_null
    //   128: astore_1
    //   129: aload 5
    //   131: invokestatic 93	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   134: astore 5
    //   136: aload 5
    //   138: astore_1
    //   139: aload 5
    //   141: astore 4
    //   143: aload_2
    //   144: getstatic 99	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   147: bipush 100
    //   149: aload 5
    //   151: invokevirtual 105	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   154: pop
    //   155: aload 5
    //   157: astore_1
    //   158: aload 5
    //   160: astore 4
    //   162: aload 5
    //   164: invokevirtual 110	java/io/OutputStream:flush	()V
    //   167: aload_2
    //   168: astore_3
    //   169: aload 5
    //   171: ifnull +12 -> 183
    //   174: aload_2
    //   175: astore_3
    //   176: aload 5
    //   178: invokevirtual 113	java/io/OutputStream:close	()V
    //   181: aload_2
    //   182: astore_3
    //   183: ldc 35
    //   185: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_3
    //   189: areturn
    //   190: astore_3
    //   191: aload_1
    //   192: astore 4
    //   194: ldc 49
    //   196: aload_3
    //   197: ldc 118
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 122	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload_2
    //   207: astore_3
    //   208: aload_1
    //   209: ifnull -26 -> 183
    //   212: aload_2
    //   213: astore_3
    //   214: aload_1
    //   215: invokevirtual 113	java/io/OutputStream:close	()V
    //   218: aload_2
    //   219: astore_3
    //   220: goto -37 -> 183
    //   223: astore_1
    //   224: ldc 49
    //   226: aload_1
    //   227: ldc 118
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 122	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto -53 -> 183
    //   239: astore_1
    //   240: aload 4
    //   242: ifnull +10 -> 252
    //   245: aload_2
    //   246: astore_3
    //   247: aload 4
    //   249: invokevirtual 113	java/io/OutputStream:close	()V
    //   252: aload_2
    //   253: astore_3
    //   254: ldc 35
    //   256: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_2
    //   260: astore_3
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	g
    //   0	263	1	paramBitmap	Bitmap
    //   0	263	2	parama	s.a
    //   0	263	3	paramString	String
    //   125	123	4	localObject1	Object
    //   114	63	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   129	136	190	java/io/FileNotFoundException
    //   143	155	190	java/io/FileNotFoundException
    //   162	167	190	java/io/FileNotFoundException
    //   16	34	223	java/io/IOException
    //   36	47	223	java/io/IOException
    //   49	56	223	java/io/IOException
    //   58	63	223	java/io/IOException
    //   67	74	223	java/io/IOException
    //   78	85	223	java/io/IOException
    //   87	101	223	java/io/IOException
    //   103	116	223	java/io/IOException
    //   118	124	223	java/io/IOException
    //   176	181	223	java/io/IOException
    //   214	218	223	java/io/IOException
    //   247	252	223	java/io/IOException
    //   254	259	223	java/io/IOException
    //   261	263	223	java/io/IOException
    //   129	136	239	finally
    //   143	155	239	finally
    //   162	167	239	finally
    //   194	206	239	finally
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final String aGA()
  {
    return this.qdZ;
  }
  
  public final boolean aGB()
  {
    return true;
  }
  
  public final boolean aGC()
  {
    return false;
  }
  
  public final Bitmap aGD()
  {
    AppMethodBeat.i(106734);
    Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233478);
    AppMethodBeat.o(106734);
    return localBitmap;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(106733);
    String str = b.chp() + com.tencent.mm.b.g.getMessageDigest(this.url.getBytes());
    AppMethodBeat.o(106733);
    return str;
  }
  
  public final String aGz()
  {
    return this.url;
  }
  
  public final String getCacheKey()
  {
    return this.qdZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.g
 * JD-Core Version:    0.7.0.1
 */