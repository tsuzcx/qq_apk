package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  implements v
{
  private int height;
  private String kbQ;
  private String url;
  private int width;
  
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.kbQ = paramString1;
    this.url = paramString2;
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    return b.aPI() + g.o(this.url.getBytes());
  }
  
  public final String UP()
  {
    return this.url;
  }
  
  public final String UQ()
  {
    return this.kbQ;
  }
  
  public final boolean UR()
  {
    return true;
  }
  
  public final boolean US()
  {
    return false;
  }
  
  public final Bitmap UT()
  {
    return BitmapFactory.decodeResource(ae.getContext().getResources(), n.d.nosdcard_headimg);
  }
  
  public final void UU() {}
  
  /* Error */
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: getstatic 102	com/tencent/mm/platformtools/v$a:eRD	Lcom/tencent/mm/platformtools/v$a;
    //   5: aload_2
    //   6: if_acmpne +147 -> 153
    //   9: aload_1
    //   10: astore_3
    //   11: ldc 104
    //   13: ldc 106
    //   15: iconst_1
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_0
    //   22: getfield 21	com/tencent/mm/plugin/fav/ui/d:url	Ljava/lang/String;
    //   25: aastore
    //   26: invokestatic 112	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_1
    //   30: astore_3
    //   31: new 114	com/tencent/mm/vfs/b
    //   34: dup
    //   35: invokestatic 40	com/tencent/mm/plugin/fav/a/b:aPI	()Ljava/lang/String;
    //   38: invokespecial 117	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   41: astore_2
    //   42: aload_1
    //   43: astore_3
    //   44: aload_2
    //   45: invokevirtual 120	com/tencent/mm/vfs/b:exists	()Z
    //   48: ifne +10 -> 58
    //   51: aload_1
    //   52: astore_3
    //   53: aload_2
    //   54: invokevirtual 123	com/tencent/mm/vfs/b:mkdirs	()Z
    //   57: pop
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 23	com/tencent/mm/plugin/fav/ui/d:width	I
    //   66: ifle +30 -> 96
    //   69: aload_1
    //   70: astore_2
    //   71: aload_1
    //   72: astore_3
    //   73: aload_0
    //   74: getfield 25	com/tencent/mm/plugin/fav/ui/d:height	I
    //   77: ifle +19 -> 96
    //   80: aload_1
    //   81: astore_3
    //   82: aload_1
    //   83: aload_0
    //   84: getfield 23	com/tencent/mm/plugin/fav/ui/d:width	I
    //   87: aload_0
    //   88: getfield 25	com/tencent/mm/plugin/fav/ui/d:height	I
    //   91: iconst_1
    //   92: invokestatic 128	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   95: astore_2
    //   96: aload_2
    //   97: astore_3
    //   98: new 114	com/tencent/mm/vfs/b
    //   101: dup
    //   102: aload_0
    //   103: invokevirtual 130	com/tencent/mm/plugin/fav/ui/d:UO	()Ljava/lang/String;
    //   106: invokespecial 117	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   109: astore_1
    //   110: aload_2
    //   111: astore_3
    //   112: aload_1
    //   113: invokevirtual 133	com/tencent/mm/vfs/b:createNewFile	()Z
    //   116: pop
    //   117: new 135	com/tencent/mm/vfs/f
    //   120: dup
    //   121: aload_1
    //   122: invokespecial 138	com/tencent/mm/vfs/f:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   125: astore_1
    //   126: aload_1
    //   127: astore_3
    //   128: aload_2
    //   129: getstatic 144	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   132: bipush 100
    //   134: aload_1
    //   135: invokevirtual 150	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   138: pop
    //   139: aload_1
    //   140: astore_3
    //   141: aload_1
    //   142: invokevirtual 153	com/tencent/mm/vfs/f:flush	()V
    //   145: aload_2
    //   146: astore_3
    //   147: aload_1
    //   148: invokevirtual 156	com/tencent/mm/vfs/f:close	()V
    //   151: aload_2
    //   152: astore_3
    //   153: aload_3
    //   154: areturn
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_1
    //   159: aload_1
    //   160: astore_3
    //   161: ldc 104
    //   163: aload 4
    //   165: ldc 158
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 162	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_2
    //   175: astore_3
    //   176: aload_1
    //   177: ifnull -24 -> 153
    //   180: aload_2
    //   181: astore_3
    //   182: aload_1
    //   183: invokevirtual 156	com/tencent/mm/vfs/f:close	()V
    //   186: aload_2
    //   187: areturn
    //   188: astore_1
    //   189: ldc 104
    //   191: aload_1
    //   192: ldc 158
    //   194: iconst_0
    //   195: anewarray 4	java/lang/Object
    //   198: invokestatic 162	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload_3
    //   202: areturn
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 4
    //   207: aload 4
    //   209: ifnull +10 -> 219
    //   212: aload_2
    //   213: astore_3
    //   214: aload 4
    //   216: invokevirtual 156	com/tencent/mm/vfs/f:close	()V
    //   219: aload_2
    //   220: astore_3
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload_3
    //   225: astore 4
    //   227: goto -20 -> 207
    //   230: astore 4
    //   232: goto -73 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	d
    //   0	235	1	paramBitmap	Bitmap
    //   0	235	2	parama	v.a
    //   0	235	3	paramString	String
    //   155	9	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   205	21	4	str	String
    //   230	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   117	126	155	java/io/FileNotFoundException
    //   11	29	188	java/io/IOException
    //   31	42	188	java/io/IOException
    //   44	51	188	java/io/IOException
    //   53	58	188	java/io/IOException
    //   62	69	188	java/io/IOException
    //   73	80	188	java/io/IOException
    //   82	96	188	java/io/IOException
    //   98	110	188	java/io/IOException
    //   112	117	188	java/io/IOException
    //   147	151	188	java/io/IOException
    //   182	186	188	java/io/IOException
    //   214	219	188	java/io/IOException
    //   221	223	188	java/io/IOException
    //   117	126	203	finally
    //   128	139	223	finally
    //   141	145	223	finally
    //   161	174	223	finally
    //   128	139	230	java/io/FileNotFoundException
    //   141	145	230	java/io/FileNotFoundException
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return this.kbQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d
 * JD-Core Version:    0.7.0.1
 */