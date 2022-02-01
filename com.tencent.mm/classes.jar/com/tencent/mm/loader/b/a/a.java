package com.tencent.mm.loader.b.a;

import android.graphics.Bitmap;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.f.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "T", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "exists", "save", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "Companion", "libimageloader_release"})
public abstract class a<T>
  extends d<T, Bitmap>
{
  private static final String TAG = "MicroMsg.Loader.IDiskCache";
  public static final a hYH = new a((byte)0);
  private g hYG = (g)new com.tencent.mm.loader.e.a();
  
  /* Error */
  public boolean a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<Bitmap> parame1, com.tencent.mm.loader.h.e<Bitmap> parame2, e parame, f<?, Bitmap> paramf1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ldc 71
    //   6: invokestatic 77	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc 78
    //   12: invokestatic 77	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_3
    //   16: ldc 79
    //   18: invokestatic 77	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload 5
    //   23: ldc 80
    //   25: invokestatic 77	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: aload 6
    //   30: ldc 81
    //   32: invokestatic 77	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: aload 5
    //   40: aload 6
    //   42: invokevirtual 84	com/tencent/mm/loader/b/a/a:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/h/f;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Z
    //   45: ifeq +136 -> 181
    //   48: aload_0
    //   49: aload_1
    //   50: aload 5
    //   52: aload 6
    //   54: invokevirtual 88	com/tencent/mm/loader/b/a/a:c	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Ljava/lang/String;
    //   57: astore_3
    //   58: getstatic 57	com/tencent/mm/loader/b/a/a:TAG	Ljava/lang/String;
    //   61: new 90	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 92
    //   67: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_1
    //   71: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: ldc 101
    //   76: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: getstatic 120	com/tencent/mm/loader/b/a/c:hYJ	Lcom/tencent/mm/loader/b/a/c;
    //   92: astore 9
    //   94: aload_3
    //   95: invokestatic 124	com/tencent/mm/loader/b/a/c:Hg	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   98: astore 10
    //   100: aload 10
    //   102: ifnull +79 -> 181
    //   105: aload 10
    //   107: checkcast 126	java/io/Closeable
    //   110: astore 9
    //   112: aload 4
    //   114: ifnull +69 -> 183
    //   117: aload 4
    //   119: invokevirtual 132	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   122: checkcast 134	android/graphics/Bitmap
    //   125: astore_3
    //   126: aload 4
    //   128: ifnull +79 -> 207
    //   131: aload_3
    //   132: ifnull +75 -> 207
    //   135: getstatic 120	com/tencent/mm/loader/b/a/c:hYJ	Lcom/tencent/mm/loader/b/a/c;
    //   138: astore 4
    //   140: aload_3
    //   141: aload 10
    //   143: invokestatic 137	com/tencent/mm/loader/b/a/c:a	(Landroid/graphics/Bitmap;Ljava/io/OutputStream;)Z
    //   146: pop
    //   147: iconst_1
    //   148: istore 7
    //   150: iload 7
    //   152: ifne +9 -> 161
    //   155: aload_2
    //   156: aload 10
    //   158: invokevirtual 143	com/tencent/mm/loader/h/f:b	(Ljava/io/OutputStream;)V
    //   161: aload_0
    //   162: aload_1
    //   163: aload 5
    //   165: aload 6
    //   167: invokevirtual 146	com/tencent/mm/loader/b/a/a:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Z
    //   170: pop
    //   171: getstatic 152	kotlin/x:SXb	Lkotlin/x;
    //   174: astore_1
    //   175: aload 9
    //   177: aconst_null
    //   178: invokestatic 157	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   181: iconst_1
    //   182: ireturn
    //   183: aconst_null
    //   184: astore_3
    //   185: goto -59 -> 126
    //   188: astore_2
    //   189: aload_2
    //   190: athrow
    //   191: astore_1
    //   192: aload 9
    //   194: aload_2
    //   195: invokestatic 157	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   198: aload_1
    //   199: athrow
    //   200: astore_1
    //   201: aload 8
    //   203: astore_2
    //   204: goto -12 -> 192
    //   207: iconst_0
    //   208: istore 7
    //   210: goto -60 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	a
    //   0	213	1	parama	com.tencent.mm.loader.h.a.a<T>
    //   0	213	2	paramf	com.tencent.mm.loader.h.f<?>
    //   0	213	3	parame1	com.tencent.mm.loader.h.e<Bitmap>
    //   0	213	4	parame2	com.tencent.mm.loader.h.e<Bitmap>
    //   0	213	5	parame	e
    //   0	213	6	paramf1	f<?, Bitmap>
    //   148	61	7	i	int
    //   1	201	8	localObject1	Object
    //   92	101	9	localObject2	Object
    //   98	59	10	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   117	126	188	java/lang/Throwable
    //   135	147	188	java/lang/Throwable
    //   155	161	188	java/lang/Throwable
    //   161	175	188	java/lang/Throwable
    //   189	191	191	finally
    //   117	126	200	finally
    //   135	147	200	finally
    //   155	161	200	finally
    //   161	175	200	finally
  }
  
  public String c(com.tencent.mm.loader.h.a.a<T> parama, e parame, f<?, Bitmap> paramf)
  {
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    return super.c(parama, parame, paramf);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.a
 * JD-Core Version:    0.7.0.1
 */