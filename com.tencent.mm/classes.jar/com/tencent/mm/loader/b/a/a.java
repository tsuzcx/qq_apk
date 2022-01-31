package com.tencent.mm.loader.b.a;

import a.f.b.j;
import a.l;
import a.l.m;
import a.v;
import android.graphics.Bitmap;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "T", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "exists", "save", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "Companion", "libimageloader_release"})
public abstract class a<T>
  extends d<T, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.IDiskCache";
  public static final a eNl = new a((byte)0);
  private com.tencent.mm.loader.f.f eNk;
  
  public String a(com.tencent.mm.loader.h.a.a<T> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    j.q(parama, "url");
    j.q(parame, "opts");
    j.q(paramf, "reaper");
    String str1 = parame.Tu();
    if (str1 != null)
    {
      paramf = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      String str2 = parame.Ts();
      paramf = str1;
      if (str2 != null)
      {
        paramf = str1;
        if (str2.length() > 0)
        {
          parame = parame.Tt();
          if ((parame == null) || (parame.length() == 0) || (!m.jw(str2, parame)))
          {
            ab.e(TAG, "[johnw] SFS can't deal with absolute path: %s", new Object[] { str2 });
            throw ((Throwable)new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(str2))));
          }
          parame = str2.substring(parame.length());
          j.p(parame, "(this as java.lang.String).substring(startIndex)");
          paramf = parame;
          if (m.jw(parame, "/"))
          {
            if (parame == null) {
              throw new v("null cannot be cast to non-null type java.lang.String");
            }
            paramf = parame.substring(1);
            j.p(paramf, "(this as java.lang.String).substring(startIndex)");
          }
        }
      }
    }
    if (paramf != null)
    {
      parame = paramf;
      if (paramf.length() != 0) {}
    }
    else
    {
      parame = this.eNk;
      if (parame == null) {
        j.ebi();
      }
      parame = parame.b(parama);
    }
    if (parame != null)
    {
      parama = parame;
      if (parame.length() != 0) {}
    }
    else
    {
      parama = "";
    }
    return parama;
  }
  
  /* Error */
  public final boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<Bitmap> parame1, com.tencent.mm.loader.h.e<Bitmap> parame2, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ldc 62
    //   6: invokestatic 68	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc 153
    //   12: invokestatic 68	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_3
    //   16: ldc 154
    //   18: invokestatic 68	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload 5
    //   23: ldc 69
    //   25: invokestatic 68	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: aload 6
    //   30: ldc 70
    //   32: invokestatic 68	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: aload 5
    //   40: aload 6
    //   42: invokevirtual 157	com/tencent/mm/loader/b/a/a:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/h/f;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Z
    //   45: pop
    //   46: aload_0
    //   47: aload_1
    //   48: aload 5
    //   50: aload 6
    //   52: invokevirtual 159	com/tencent/mm/loader/b/a/a:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Ljava/lang/String;
    //   55: astore_3
    //   56: getstatic 57	com/tencent/mm/loader/b/a/a:TAG	Ljava/lang/String;
    //   59: new 161	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 163
    //   65: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: aload_1
    //   69: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: ldc 170
    //   74: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: getstatic 186	com/tencent/mm/loader/b/a/c:eNn	Lcom/tencent/mm/loader/b/a/c;
    //   90: astore 9
    //   92: aload_3
    //   93: aload 5
    //   95: invokevirtual 190	com/tencent/mm/loader/c/e:TC	()Lcom/tencent/mm/modelsfs/SFSContext;
    //   98: invokestatic 193	com/tencent/mm/loader/b/a/c:a	(Ljava/lang/String;Lcom/tencent/mm/modelsfs/SFSContext;)Ljava/io/OutputStream;
    //   101: astore 9
    //   103: aload 9
    //   105: ifnull +80 -> 185
    //   108: aload 9
    //   110: checkcast 195	java/io/Closeable
    //   113: astore_3
    //   114: iconst_0
    //   115: istore 7
    //   117: aload 4
    //   119: ifnull +36 -> 155
    //   122: getstatic 186	com/tencent/mm/loader/b/a/c:eNn	Lcom/tencent/mm/loader/b/a/c;
    //   125: astore 10
    //   127: aload 4
    //   129: invokevirtual 201	com/tencent/mm/loader/h/e:value	()Ljava/lang/Object;
    //   132: astore 4
    //   134: aload 4
    //   136: ldc 203
    //   138: invokestatic 130	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   141: aload 4
    //   143: checkcast 205	android/graphics/Bitmap
    //   146: aload 9
    //   148: invokestatic 208	com/tencent/mm/loader/b/a/c:a	(Landroid/graphics/Bitmap;Ljava/io/OutputStream;)Z
    //   151: pop
    //   152: iconst_1
    //   153: istore 7
    //   155: iload 7
    //   157: ifne +9 -> 166
    //   160: aload_2
    //   161: aload 9
    //   163: invokevirtual 213	com/tencent/mm/loader/h/f:b	(Ljava/io/OutputStream;)V
    //   166: aload_0
    //   167: aload_1
    //   168: aload 5
    //   170: aload 6
    //   172: invokevirtual 216	com/tencent/mm/loader/b/a/a:b	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Z
    //   175: pop
    //   176: getstatic 222	a/y:BMg	La/y;
    //   179: astore_1
    //   180: aload_3
    //   181: aconst_null
    //   182: invokestatic 227	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   185: iconst_1
    //   186: ireturn
    //   187: astore_2
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload_3
    //   192: aload_2
    //   193: invokestatic 227	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload 8
    //   201: astore_2
    //   202: goto -11 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	a
    //   0	205	1	parama	com.tencent.mm.loader.h.a.a<T>
    //   0	205	2	paramf	com.tencent.mm.loader.h.f<?>
    //   0	205	3	parame1	com.tencent.mm.loader.h.e<Bitmap>
    //   0	205	4	parame2	com.tencent.mm.loader.h.e<Bitmap>
    //   0	205	5	parame	e
    //   0	205	6	paramf1	com.tencent.mm.loader.f<?, Bitmap>
    //   115	41	7	i	int
    //   1	199	8	localObject1	Object
    //   90	72	9	localObject2	Object
    //   125	1	10	localc	c
    // Exception table:
    //   from	to	target	type
    //   122	152	187	java/lang/Throwable
    //   160	166	187	java/lang/Throwable
    //   166	180	187	java/lang/Throwable
    //   188	190	190	finally
    //   122	152	198	finally
    //   160	166	198	finally
    //   166	180	198	finally
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.a
 * JD-Core Version:    0.7.0.1
 */