package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
  implements v
{
  private int height;
  private String mwm;
  private String url;
  private int width;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.mwm = paramString1;
    this.url = paramString2;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    // Byte code:
    //   0: ldc 35
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore_3
    //   7: getstatic 47	com/tencent/mm/platformtools/v$a:gjx	Lcom/tencent/mm/platformtools/v$a;
    //   10: aload_2
    //   11: if_acmpne +147 -> 158
    //   14: aload_1
    //   15: astore_3
    //   16: ldc 49
    //   18: ldc 51
    //   20: iconst_1
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 21	com/tencent/mm/plugin/fav/ui/d:url	Ljava/lang/String;
    //   30: aastore
    //   31: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_1
    //   35: astore_3
    //   36: new 59	com/tencent/mm/vfs/b
    //   39: dup
    //   40: invokestatic 65	com/tencent/mm/plugin/fav/a/b:bvW	()Ljava/lang/String;
    //   43: invokespecial 68	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   46: astore_2
    //   47: aload_1
    //   48: astore_3
    //   49: aload_2
    //   50: invokevirtual 72	com/tencent/mm/vfs/b:exists	()Z
    //   53: ifne +10 -> 63
    //   56: aload_1
    //   57: astore_3
    //   58: aload_2
    //   59: invokevirtual 75	com/tencent/mm/vfs/b:mkdirs	()Z
    //   62: pop
    //   63: aload_1
    //   64: astore_2
    //   65: aload_1
    //   66: astore_3
    //   67: aload_0
    //   68: getfield 23	com/tencent/mm/plugin/fav/ui/d:width	I
    //   71: ifle +30 -> 101
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: astore_3
    //   78: aload_0
    //   79: getfield 25	com/tencent/mm/plugin/fav/ui/d:height	I
    //   82: ifle +19 -> 101
    //   85: aload_1
    //   86: astore_3
    //   87: aload_1
    //   88: aload_0
    //   89: getfield 23	com/tencent/mm/plugin/fav/ui/d:width	I
    //   92: aload_0
    //   93: getfield 25	com/tencent/mm/plugin/fav/ui/d:height	I
    //   96: iconst_1
    //   97: invokestatic 81	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   100: astore_2
    //   101: aload_2
    //   102: astore_3
    //   103: new 59	com/tencent/mm/vfs/b
    //   106: dup
    //   107: aload_0
    //   108: invokevirtual 84	com/tencent/mm/plugin/fav/ui/d:aon	()Ljava/lang/String;
    //   111: invokespecial 68	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   114: astore_1
    //   115: aload_2
    //   116: astore_3
    //   117: aload_1
    //   118: invokevirtual 87	com/tencent/mm/vfs/b:createNewFile	()Z
    //   121: pop
    //   122: new 89	com/tencent/mm/vfs/f
    //   125: dup
    //   126: aload_1
    //   127: invokespecial 92	com/tencent/mm/vfs/f:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   130: astore_1
    //   131: aload_1
    //   132: astore_3
    //   133: aload_2
    //   134: getstatic 98	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   137: bipush 100
    //   139: aload_1
    //   140: invokevirtual 104	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   143: pop
    //   144: aload_1
    //   145: astore_3
    //   146: aload_1
    //   147: invokevirtual 107	com/tencent/mm/vfs/f:flush	()V
    //   150: aload_2
    //   151: astore_3
    //   152: aload_1
    //   153: invokevirtual 110	com/tencent/mm/vfs/f:close	()V
    //   156: aload_2
    //   157: astore_3
    //   158: ldc 35
    //   160: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_3
    //   164: areturn
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: astore_3
    //   171: ldc 49
    //   173: aload 4
    //   175: ldc 115
    //   177: iconst_0
    //   178: anewarray 4	java/lang/Object
    //   181: invokestatic 119	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_2
    //   185: astore_3
    //   186: aload_1
    //   187: ifnull -29 -> 158
    //   190: aload_2
    //   191: astore_3
    //   192: aload_1
    //   193: invokevirtual 110	com/tencent/mm/vfs/f:close	()V
    //   196: aload_2
    //   197: astore_3
    //   198: goto -40 -> 158
    //   201: astore_1
    //   202: ldc 49
    //   204: aload_1
    //   205: ldc 115
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 119	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -56 -> 158
    //   217: astore_1
    //   218: aconst_null
    //   219: astore 4
    //   221: aload 4
    //   223: ifnull +10 -> 233
    //   226: aload_2
    //   227: astore_3
    //   228: aload 4
    //   230: invokevirtual 110	com/tencent/mm/vfs/f:close	()V
    //   233: aload_2
    //   234: astore_3
    //   235: ldc 35
    //   237: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aload_2
    //   241: astore_3
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: aload_3
    //   246: astore 4
    //   248: goto -27 -> 221
    //   251: astore 4
    //   253: goto -84 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	d
    //   0	256	1	paramBitmap	Bitmap
    //   0	256	2	parama	v.a
    //   0	256	3	paramString	String
    //   165	9	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   219	28	4	str	String
    //   251	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   122	131	165	java/io/FileNotFoundException
    //   16	34	201	java/io/IOException
    //   36	47	201	java/io/IOException
    //   49	56	201	java/io/IOException
    //   58	63	201	java/io/IOException
    //   67	74	201	java/io/IOException
    //   78	85	201	java/io/IOException
    //   87	101	201	java/io/IOException
    //   103	115	201	java/io/IOException
    //   117	122	201	java/io/IOException
    //   152	156	201	java/io/IOException
    //   192	196	201	java/io/IOException
    //   228	233	201	java/io/IOException
    //   235	240	201	java/io/IOException
    //   242	244	201	java/io/IOException
    //   122	131	217	finally
    //   133	144	244	finally
    //   146	150	244	finally
    //   171	184	244	finally
    //   133	144	251	java/io/FileNotFoundException
    //   146	150	251	java/io/FileNotFoundException
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final v.b aom()
  {
    return null;
  }
  
  public final String aon()
  {
    AppMethodBeat.i(73997);
    String str = b.bvW() + g.w(this.url.getBytes());
    AppMethodBeat.o(73997);
    return str;
  }
  
  public final String aoo()
  {
    return this.url;
  }
  
  public final String aop()
  {
    return this.mwm;
  }
  
  public final boolean aoq()
  {
    return true;
  }
  
  public final boolean aor()
  {
    return false;
  }
  
  public final Bitmap aos()
  {
    AppMethodBeat.i(73998);
    Bitmap localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), 2130839823);
    AppMethodBeat.o(73998);
    return localBitmap;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    return this.mwm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */