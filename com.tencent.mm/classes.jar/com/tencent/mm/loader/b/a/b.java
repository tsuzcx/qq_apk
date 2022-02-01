package com.tencent.mm.loader.b.a;

import android.graphics.Bitmap;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.vfs.t;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "exists", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public final class b
  extends d<String, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.imageloader.DefaultImageDiskCache";
  public static final a kNm = new a((byte)0);
  private g kNk = (g)new com.tencent.mm.loader.e.a();
  
  public final boolean a(com.tencent.mm.loader.h.a.a<String> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.h.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    p.k(parama, "url");
    p.k(paramf, "httpResponse");
    p.k(parame, "opts");
    p.k(paramf1, "reaper");
    return true;
  }
  
  /* Error */
  public final boolean a(com.tencent.mm.loader.h.a.a<String> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<Bitmap> parame1, com.tencent.mm.loader.h.e<Bitmap> parame2, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ldc 73
    //   6: invokestatic 79	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc 85
    //   12: invokestatic 79	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_3
    //   16: ldc 90
    //   18: invokestatic 79	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload 5
    //   23: ldc 80
    //   25: invokestatic 79	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: aload 6
    //   30: ldc 81
    //   32: invokestatic 79	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: aload 5
    //   40: aload 6
    //   42: invokevirtual 92	com/tencent/mm/loader/b/a/b:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/h/f;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Z
    //   45: ifeq +137 -> 182
    //   48: aload_0
    //   49: aload_1
    //   50: aload 5
    //   52: aload 6
    //   54: invokevirtual 96	com/tencent/mm/loader/b/a/b:c	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Ljava/lang/String;
    //   57: astore_3
    //   58: getstatic 61	com/tencent/mm/loader/b/a/b:TAG	Ljava/lang/String;
    //   61: new 98	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 100
    //   67: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_1
    //   71: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: ldc 109
    //   76: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: getstatic 128	com/tencent/mm/loader/b/a/c:kNn	Lcom/tencent/mm/loader/b/a/c;
    //   92: astore 9
    //   94: aload_3
    //   95: invokestatic 132	com/tencent/mm/loader/b/a/c:Or	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   98: astore 9
    //   100: aload 9
    //   102: ifnull +80 -> 182
    //   105: aload 9
    //   107: checkcast 134	java/io/Closeable
    //   110: astore_3
    //   111: iconst_0
    //   112: istore 7
    //   114: aload 4
    //   116: ifnull +36 -> 152
    //   119: getstatic 128	com/tencent/mm/loader/b/a/c:kNn	Lcom/tencent/mm/loader/b/a/c;
    //   122: astore 10
    //   124: aload 4
    //   126: invokevirtual 140	com/tencent/mm/loader/h/e:aSr	()Ljava/lang/Object;
    //   129: astore 4
    //   131: aload 4
    //   133: ldc 142
    //   135: invokestatic 145	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   138: aload 4
    //   140: checkcast 147	android/graphics/Bitmap
    //   143: aload 9
    //   145: invokestatic 150	com/tencent/mm/loader/b/a/c:a	(Landroid/graphics/Bitmap;Ljava/io/OutputStream;)Z
    //   148: pop
    //   149: iconst_1
    //   150: istore 7
    //   152: iload 7
    //   154: ifne +9 -> 163
    //   157: aload_2
    //   158: aload 9
    //   160: invokevirtual 156	com/tencent/mm/loader/h/f:b	(Ljava/io/OutputStream;)V
    //   163: aload_0
    //   164: aload_1
    //   165: aload 5
    //   167: aload 6
    //   169: invokevirtual 158	com/tencent/mm/loader/b/a/b:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Z
    //   172: pop
    //   173: getstatic 164	kotlin/x:aazN	Lkotlin/x;
    //   176: astore_1
    //   177: aload_3
    //   178: aconst_null
    //   179: invokestatic 169	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore_2
    //   185: aload_2
    //   186: athrow
    //   187: astore_1
    //   188: aload_3
    //   189: aload_2
    //   190: invokestatic 169	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: aload 8
    //   198: astore_2
    //   199: goto -11 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	b
    //   0	202	1	parama	com.tencent.mm.loader.h.a.a<String>
    //   0	202	2	paramf	com.tencent.mm.loader.h.f<?>
    //   0	202	3	parame1	com.tencent.mm.loader.h.e<Bitmap>
    //   0	202	4	parame2	com.tencent.mm.loader.h.e<Bitmap>
    //   0	202	5	parame	e
    //   0	202	6	paramf1	com.tencent.mm.loader.f<?, Bitmap>
    //   112	41	7	i	int
    //   1	196	8	localObject1	Object
    //   92	67	9	localObject2	Object
    //   122	1	10	localc	c
    // Exception table:
    //   from	to	target	type
    //   119	149	184	java/lang/Throwable
    //   157	163	184	java/lang/Throwable
    //   163	177	184	java/lang/Throwable
    //   185	187	187	finally
    //   119	149	195	finally
    //   157	163	195	finally
    //   163	177	195	finally
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<String> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    try
    {
      if (parama.aSt() == com.tencent.mm.loader.h.a.b.kQO) {
        return com.tencent.mm.loader.h.b.a.Ow(parama.aSu());
      }
      if (parama.aSt() == com.tencent.mm.loader.h.a.b.kQP)
      {
        com.tencent.mm.loader.h.b.a locala = com.tencent.mm.loader.h.b.a.i(parama.aSu(), com.tencent.mm.vending.j.b.ev(parama.aSu()));
        return locala;
      }
    }
    catch (Exception localException) {}
    label137:
    for (;;)
    {
      try
      {
        parama = c(parama, parame, paramf);
        parame = (CharSequence)parama;
        if (parame == null) {
          break label127;
        }
        if (parame.length() != 0) {
          break label137;
        }
      }
      catch (FileNotFoundException parama)
      {
        return null;
      }
      parama = com.tencent.mm.loader.h.b.a.a((InputStream)new t(parama), (InputStream)new t(parama));
      return parama;
      label127:
      for (int i = 1; i != 0; i = 0) {
        return null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.b
 * JD-Core Version:    0.7.0.1
 */