package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.c.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderBlurBitmapProducer;", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "Landroid/graphics/Bitmap;", "blurRadius", "", "extraBgColor", "", "(FLjava/lang/Integer;)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getExtraBgColor", "()Ljava/lang/Integer;", "setExtraBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "asResourceName", "", "source", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<Bitmap>
{
  public static final f.a Exm;
  private Integer Exn;
  private float ayo;
  
  static
  {
    AppMethodBeat.i(331717);
    Exm = new f.a((byte)0);
    AppMethodBeat.o(331717);
  }
  
  public f(float paramFloat, Integer paramInteger)
  {
    this.ayo = paramFloat;
    this.Exn = paramInteger;
  }
  
  public final String GH(String paramString)
  {
    AppMethodBeat.i(331730);
    s.u(paramString, "source");
    AppMethodBeat.o(331730);
    return paramString;
  }
  
  /* Error */
  public final com.tencent.mm.loader.g.e<? extends Bitmap> a(com.tencent.mm.loader.d.b.g<?> paramg, com.tencent.mm.loader.f<?, Bitmap> paramf, com.tencent.mm.loader.g.e<Bitmap> parame)
  {
    // Byte code:
    //   0: ldc 89
    //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 90
    //   8: invokestatic 84	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 91
    //   14: invokestatic 84	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_3
    //   18: ldc 92
    //   20: invokestatic 84	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_3
    //   24: getfield 98	com/tencent/mm/loader/g/e:value	Ljava/lang/Object;
    //   27: checkcast 100	android/graphics/Bitmap
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +10 -> 42
    //   35: ldc 89
    //   37: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_3
    //   41: areturn
    //   42: aload_1
    //   43: aload_3
    //   44: getfield 98	com/tencent/mm/loader/g/e:value	Ljava/lang/Object;
    //   47: checkcast 100	android/graphics/Bitmap
    //   50: invokevirtual 104	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   53: iconst_1
    //   54: invokevirtual 108	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   57: astore 5
    //   59: aload 5
    //   61: ifnonnull +10 -> 71
    //   64: ldc 89
    //   66: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_3
    //   70: areturn
    //   71: new 110	android/graphics/Canvas
    //   74: dup
    //   75: aload 5
    //   77: invokespecial 113	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 74	com/tencent/mm/plugin/finder/loader/f:Exn	Ljava/lang/Integer;
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +33 -> 120
    //   90: aload_2
    //   91: checkcast 115	java/lang/Number
    //   94: invokevirtual 119	java/lang/Number:intValue	()I
    //   97: istore 4
    //   99: iload 4
    //   101: iconst_m1
    //   102: if_icmpeq +18 -> 120
    //   105: aload_1
    //   106: invokestatic 125	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   109: invokevirtual 131	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   112: iload 4
    //   114: invokevirtual 137	android/content/res/Resources:getColor	(I)I
    //   117: invokevirtual 140	android/graphics/Canvas:drawColor	(I)V
    //   120: new 142	com/tencent/mm/ui/blur/f
    //   123: dup
    //   124: invokestatic 125	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   127: invokespecial 145	com/tencent/mm/ui/blur/f:<init>	(Landroid/content/Context;)V
    //   130: astore_3
    //   131: aload_3
    //   132: aload 5
    //   134: aload_0
    //   135: getfield 72	com/tencent/mm/plugin/finder/loader/f:ayo	F
    //   138: invokevirtual 149	com/tencent/mm/ui/blur/f:c	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   141: astore_1
    //   142: aload_3
    //   143: invokevirtual 152	com/tencent/mm/ui/blur/f:destroy	()V
    //   146: aload_1
    //   147: astore_3
    //   148: new 94	com/tencent/mm/loader/g/e
    //   151: dup
    //   152: aload_3
    //   153: invokespecial 155	com/tencent/mm/loader/g/e:<init>	(Ljava/lang/Object;)V
    //   156: astore_1
    //   157: ldc 89
    //   159: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: areturn
    //   164: astore_2
    //   165: ldc 157
    //   167: ldc 159
    //   169: aload_2
    //   170: invokevirtual 163	android/renderscript/RSInvalidStateException:getMessage	()Ljava/lang/String;
    //   173: invokestatic 167	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_1
    //   180: astore_3
    //   181: goto -33 -> 148
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_1
    //   187: ldc 157
    //   189: ldc 175
    //   191: aload_2
    //   192: invokevirtual 178	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   195: invokestatic 167	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   198: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 5
    //   203: aload_0
    //   204: getfield 72	com/tencent/mm/plugin/finder/loader/f:ayo	F
    //   207: f2i
    //   208: invokestatic 187	com/tencent/mm/sdk/platformtools/BitmapUtil:fastblur	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   211: astore_2
    //   212: aload_2
    //   213: astore_3
    //   214: aload_1
    //   215: ifnull -67 -> 148
    //   218: aload_1
    //   219: invokevirtual 152	com/tencent/mm/ui/blur/f:destroy	()V
    //   222: aload_2
    //   223: astore_3
    //   224: goto -76 -> 148
    //   227: astore_1
    //   228: ldc 157
    //   230: ldc 159
    //   232: aload_1
    //   233: invokevirtual 163	android/renderscript/RSInvalidStateException:getMessage	()Ljava/lang/String;
    //   236: invokestatic 167	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   239: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_2
    //   243: astore_3
    //   244: goto -96 -> 148
    //   247: astore_2
    //   248: aload_1
    //   249: ifnull +7 -> 256
    //   252: aload_1
    //   253: invokevirtual 152	com/tencent/mm/ui/blur/f:destroy	()V
    //   256: ldc 89
    //   258: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload_2
    //   262: athrow
    //   263: astore_1
    //   264: ldc 157
    //   266: ldc 159
    //   268: aload_1
    //   269: invokevirtual 163	android/renderscript/RSInvalidStateException:getMessage	()Ljava/lang/String;
    //   272: invokestatic 167	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   275: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: goto -22 -> 256
    //   281: astore_2
    //   282: aload_3
    //   283: astore_1
    //   284: goto -97 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	f
    //   0	287	1	paramg	com.tencent.mm.loader.d.b.g<?>
    //   0	287	2	paramf	com.tencent.mm.loader.f<?, Bitmap>
    //   0	287	3	parame	com.tencent.mm.loader.g.e<Bitmap>
    //   97	16	4	i	int
    //   57	145	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   142	146	164	android/renderscript/RSInvalidStateException
    //   120	131	184	finally
    //   218	222	227	android/renderscript/RSInvalidStateException
    //   187	212	247	finally
    //   252	256	263	android/renderscript/RSInvalidStateException
    //   131	142	281	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.f
 * JD-Core Version:    0.7.0.1
 */