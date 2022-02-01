package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.c.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderBlurBitmapProducer;", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "Landroid/graphics/Bitmap;", "blurRadius", "", "extraBgColor", "", "(FLjava/lang/Integer;)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getExtraBgColor", "()Ljava/lang/Integer;", "setExtraBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "asResourceName", "", "source", "Companion", "plugin-finder_release"})
public final class j
  extends b<Bitmap>
{
  public static final a ztv;
  private float ztt;
  private Integer ztu;
  
  static
  {
    AppMethodBeat.i(285388);
    ztv = new a((byte)0);
    AppMethodBeat.o(285388);
  }
  
  public j(float paramFloat, Integer paramInteger)
  {
    this.ztt = paramFloat;
    this.ztu = paramInteger;
  }
  
  public final String Ot(String paramString)
  {
    AppMethodBeat.i(285387);
    p.k(paramString, "source");
    AppMethodBeat.o(285387);
    return paramString;
  }
  
  /* Error */
  public final com.tencent.mm.loader.h.e<? extends Bitmap> a(com.tencent.mm.loader.e.b.g<?> paramg, com.tencent.mm.loader.f<?, Bitmap> paramf, com.tencent.mm.loader.h.e<Bitmap> parame)
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 89
    //   8: invokestatic 82	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 90
    //   14: invokestatic 82	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_3
    //   18: ldc 91
    //   20: invokestatic 82	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_3
    //   24: invokevirtual 97	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   27: checkcast 99	android/graphics/Bitmap
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +10 -> 42
    //   35: ldc 88
    //   37: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_3
    //   41: areturn
    //   42: aload_3
    //   43: invokevirtual 97	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: ldc 101
    //   50: invokestatic 104	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   53: aload_1
    //   54: aload_2
    //   55: checkcast 99	android/graphics/Bitmap
    //   58: invokevirtual 108	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   61: iconst_1
    //   62: invokevirtual 112	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   65: astore 5
    //   67: aload 5
    //   69: ldc 114
    //   71: invokestatic 104	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   74: new 116	android/graphics/Canvas
    //   77: dup
    //   78: aload 5
    //   80: invokespecial 119	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 72	com/tencent/mm/plugin/finder/loader/j:ztu	Ljava/lang/Integer;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +41 -> 131
    //   93: aload_2
    //   94: checkcast 121	java/lang/Number
    //   97: invokevirtual 125	java/lang/Number:intValue	()I
    //   100: istore 4
    //   102: iload 4
    //   104: iconst_m1
    //   105: if_icmpeq +26 -> 131
    //   108: invokestatic 131	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   111: astore_2
    //   112: aload_2
    //   113: ldc 133
    //   115: invokestatic 104	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   118: aload_1
    //   119: aload_2
    //   120: invokevirtual 139	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   123: iload 4
    //   125: invokevirtual 145	android/content/res/Resources:getColor	(I)I
    //   128: invokevirtual 148	android/graphics/Canvas:drawColor	(I)V
    //   131: new 150	com/tencent/mm/ui/blur/f
    //   134: dup
    //   135: invokestatic 131	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   138: invokespecial 153	com/tencent/mm/ui/blur/f:<init>	(Landroid/content/Context;)V
    //   141: astore_2
    //   142: aload_2
    //   143: astore_1
    //   144: aload_2
    //   145: aload 5
    //   147: aload_0
    //   148: getfield 70	com/tencent/mm/plugin/finder/loader/j:ztt	F
    //   151: invokevirtual 157	com/tencent/mm/ui/blur/f:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   154: astore_3
    //   155: aload_3
    //   156: astore_1
    //   157: aload_2
    //   158: invokevirtual 160	com/tencent/mm/ui/blur/f:destroy	()V
    //   161: aload_1
    //   162: astore_3
    //   163: new 93	com/tencent/mm/loader/h/e
    //   166: dup
    //   167: aload_3
    //   168: invokespecial 163	com/tencent/mm/loader/h/e:<init>	(Ljava/lang/Object;)V
    //   171: astore_1
    //   172: ldc 88
    //   174: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_1
    //   178: areturn
    //   179: astore_2
    //   180: ldc 165
    //   182: new 167	java/lang/StringBuilder
    //   185: dup
    //   186: ldc 169
    //   188: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: invokevirtual 176	android/renderscript/RSInvalidStateException:getMessage	()Ljava/lang/String;
    //   195: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload_1
    //   205: astore_3
    //   206: goto -43 -> 163
    //   209: astore_3
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_2
    //   213: astore_1
    //   214: ldc 165
    //   216: new 167	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 191
    //   222: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload_3
    //   226: invokevirtual 192	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   229: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_2
    //   239: astore_1
    //   240: aload 5
    //   242: aload_0
    //   243: getfield 70	com/tencent/mm/plugin/finder/loader/j:ztt	F
    //   246: f2i
    //   247: invokestatic 201	com/tencent/mm/sdk/platformtools/BitmapUtil:fastblur	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   250: astore_3
    //   251: aload_3
    //   252: astore_1
    //   253: aload_1
    //   254: astore_3
    //   255: aload_2
    //   256: ifnull -93 -> 163
    //   259: aload_2
    //   260: invokevirtual 160	com/tencent/mm/ui/blur/f:destroy	()V
    //   263: aload_1
    //   264: astore_3
    //   265: goto -102 -> 163
    //   268: astore_2
    //   269: ldc 165
    //   271: new 167	java/lang/StringBuilder
    //   274: dup
    //   275: ldc 169
    //   277: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: aload_2
    //   281: invokevirtual 176	android/renderscript/RSInvalidStateException:getMessage	()Ljava/lang/String;
    //   284: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_1
    //   294: astore_3
    //   295: goto -132 -> 163
    //   298: astore_2
    //   299: aconst_null
    //   300: astore_1
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 160	com/tencent/mm/ui/blur/f:destroy	()V
    //   309: ldc 88
    //   311: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aload_2
    //   315: athrow
    //   316: astore_1
    //   317: ldc 165
    //   319: new 167	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 169
    //   325: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload_1
    //   329: invokevirtual 176	android/renderscript/RSInvalidStateException:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: goto -32 -> 309
    //   344: astore_2
    //   345: goto -44 -> 301
    //   348: astore_3
    //   349: goto -137 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	j
    //   0	352	1	paramg	com.tencent.mm.loader.e.b.g<?>
    //   0	352	2	paramf	com.tencent.mm.loader.f<?, Bitmap>
    //   0	352	3	parame	com.tencent.mm.loader.h.e<Bitmap>
    //   100	24	4	i	int
    //   65	176	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   157	161	179	android/renderscript/RSInvalidStateException
    //   131	142	209	java/lang/Throwable
    //   259	263	268	android/renderscript/RSInvalidStateException
    //   131	142	298	finally
    //   305	309	316	android/renderscript/RSInvalidStateException
    //   144	155	344	finally
    //   214	238	344	finally
    //   240	251	344	finally
    //   144	155	348	java/lang/Throwable
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderBlurBitmapProducer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.j
 * JD-Core Version:    0.7.0.1
 */