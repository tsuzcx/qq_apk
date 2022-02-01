package com.tencent.mm.live.b.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.g.a.b;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class a
{
  private static final String TAG = "MicroMsg.LiveBitmapUtil";
  public static final a kyA;
  
  static
  {
    AppMethodBeat.i(196943);
    kyA = new a((byte)0);
    TAG = "MicroMsg.LiveBitmapUtil";
    AppMethodBeat.o(196943);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil$Companion;", "", "()V", "TAG", "", "addMaskLayer", "Landroid/graphics/Bitmap;", "src", "maskColor", "", "genBlurBitmapByBm", "", "bm", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "genBlurBitmapByUsername", "username", "plugin-logic_release"})
  public static final class a
  {
    public static void a(Bitmap paramBitmap, final int paramInt, final b<? super Bitmap, x> paramb)
    {
      AppMethodBeat.i(189803);
      h.ZvG.be((Runnable)new a(paramBitmap, paramb, paramInt));
      AppMethodBeat.o(189803);
    }
    
    public static void b(String paramString, final int paramInt, final b<? super Bitmap, x> paramb)
    {
      AppMethodBeat.i(189794);
      h.ZvG.be((Runnable)new b(paramString, paramb, paramInt));
      AppMethodBeat.o(189794);
    }
    
    public static Bitmap c(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(189798);
      p.k(paramBitmap, "src");
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Canvas localCanvas = new Canvas(paramBitmap);
      localPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawColor(paramInt);
      AppMethodBeat.o(189798);
      return paramBitmap;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(Bitmap paramBitmap, b paramb, int paramInt) {}
      
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 52
        //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 39	com/tencent/mm/live/b/d/a$a$a:kyB	Landroid/graphics/Bitmap;
        //   9: ifnonnull +32 -> 41
        //   12: aload_0
        //   13: getfield 41	com/tencent/mm/live/b/d/a$a$a:jFa	Lkotlin/g/a/b;
        //   16: astore_3
        //   17: aload_3
        //   18: ifnull +17 -> 35
        //   21: aload_3
        //   22: aconst_null
        //   23: invokeinterface 64 2 0
        //   28: pop
        //   29: ldc 52
        //   31: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   34: return
        //   35: ldc 52
        //   37: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   40: return
        //   41: aload_0
        //   42: getfield 39	com/tencent/mm/live/b/d/a$a$a:kyB	Landroid/graphics/Bitmap;
        //   45: astore_3
        //   46: invokestatic 73	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   49: invokestatic 79	com/tencent/mm/ui/ar:au	(Landroid/content/Context;)Landroid/graphics/Point;
        //   52: getfield 84	android/graphics/Point:y	I
        //   55: i2f
        //   56: invokestatic 73	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   59: invokestatic 79	com/tencent/mm/ui/ar:au	(Landroid/content/Context;)Landroid/graphics/Point;
        //   62: getfield 87	android/graphics/Point:x	I
        //   65: i2f
        //   66: fdiv
        //   67: fstore_1
        //   68: aload_3
        //   69: invokevirtual 93	android/graphics/Bitmap:getHeight	()I
        //   72: i2f
        //   73: fload_1
        //   74: fdiv
        //   75: f2i
        //   76: istore_2
        //   77: aload_3
        //   78: aload_3
        //   79: invokevirtual 93	android/graphics/Bitmap:getHeight	()I
        //   82: iload_2
        //   83: iconst_1
        //   84: iconst_0
        //   85: invokestatic 99	com/tencent/mm/sdk/platformtools/BitmapUtil:extractThumbNail	(Landroid/graphics/Bitmap;IIZZ)Landroid/graphics/Bitmap;
        //   88: astore 4
        //   90: new 101	kotlin/g/b/aa$f
        //   93: dup
        //   94: invokespecial 102	kotlin/g/b/aa$f:<init>	()V
        //   97: astore_3
        //   98: aload_3
        //   99: aconst_null
        //   100: putfield 106	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
        //   103: getstatic 112	com/tencent/mm/live/b/d/c:kyK	Lcom/tencent/mm/live/b/d/c;
        //   106: astore 5
        //   108: aload_3
        //   109: invokestatic 116	com/tencent/mm/live/b/d/c:aPp	()Lcom/tencent/mm/ui/blur/f;
        //   112: aload 4
        //   114: ldc 117
        //   116: invokevirtual 123	com/tencent/mm/ui/blur/f:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
        //   119: putfield 106	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
        //   122: aload_3
        //   123: getfield 106	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
        //   126: checkcast 89	android/graphics/Bitmap
        //   129: ifnull +106 -> 235
        //   132: getstatic 127	com/tencent/mm/live/b/d/a:kyA	Lcom/tencent/mm/live/b/d/a$a;
        //   135: astore 4
        //   137: aload_3
        //   138: getfield 106	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
        //   141: checkcast 89	android/graphics/Bitmap
        //   144: aload_0
        //   145: getfield 43	com/tencent/mm/live/b/d/a$a$a:kyC	I
        //   148: invokestatic 131	com/tencent/mm/live/b/d/a$a:c	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   151: pop
        //   152: new 15	com/tencent/mm/live/b/d/a$a$a$1
        //   155: dup
        //   156: aload_0
        //   157: aload_3
        //   158: invokespecial 134	com/tencent/mm/live/b/d/a$a$a$1:<init>	(Lcom/tencent/mm/live/b/d/a$a$a;Lkotlin/g/b/aa$f;)V
        //   161: checkcast 6	java/lang/Runnable
        //   164: invokestatic 140	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   167: ldc 52
        //   169: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   172: return
        //   173: astore_3
        //   174: invokestatic 144	com/tencent/mm/live/b/d/a:access$getTAG$cp	()Ljava/lang/String;
        //   177: new 146	java/lang/StringBuilder
        //   180: dup
        //   181: ldc 148
        //   183: invokespecial 151	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   186: aload_3
        //   187: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   190: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   193: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   196: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   199: new 19	com/tencent/mm/live/b/d/a$a$a$3
        //   202: dup
        //   203: aload_0
        //   204: invokespecial 170	com/tencent/mm/live/b/d/a$a$a$3:<init>	(Lcom/tencent/mm/live/b/d/a$a$a;)V
        //   207: checkcast 6	java/lang/Runnable
        //   210: invokestatic 140	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   213: ldc 52
        //   215: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   218: return
        //   219: astore 5
        //   221: aload_3
        //   222: aload 4
        //   224: bipush 30
        //   226: invokestatic 173	com/tencent/mm/sdk/platformtools/BitmapUtil:fastblur	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
        //   229: putfield 106	kotlin/g/b/aa$f:aaBC	Ljava/lang/Object;
        //   232: goto -110 -> 122
        //   235: new 17	com/tencent/mm/live/b/d/a$a$a$2
        //   238: dup
        //   239: aload_0
        //   240: invokespecial 174	com/tencent/mm/live/b/d/a$a$a$2:<init>	(Lcom/tencent/mm/live/b/d/a$a$a;)V
        //   243: checkcast 6	java/lang/Runnable
        //   246: invokestatic 140	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
        //   249: ldc 52
        //   251: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   254: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	255	0	this	a
        //   67	7	1	f	float
        //   76	7	2	i	int
        //   16	142	3	localObject1	Object
        //   173	49	3	localException	Exception
        //   88	135	4	localObject2	Object
        //   106	1	5	localc	c
        //   219	1	5	localThrowable	java.lang.Throwable
        // Exception table:
        //   from	to	target	type
        //   41	103	173	java/lang/Exception
        //   103	122	173	java/lang/Exception
        //   122	172	173	java/lang/Exception
        //   221	232	173	java/lang/Exception
        //   235	249	173	java/lang/Exception
        //   103	122	219	java/lang/Throwable
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(String paramString, b paramb, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(191713);
        if (Util.isNullOrNil(this.kyF))
        {
          localObject1 = paramb;
          if (localObject1 != null)
          {
            ((b)localObject1).invoke(null);
            AppMethodBeat.o(191713);
            return;
          }
          AppMethodBeat.o(191713);
          return;
        }
        Object localObject2 = a.b.hjf().gJ(this.kyF);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a.b.hjf();
          p.j(localObject1, "AvatarDrawable.Factory.getLoader()");
          localObject1 = ((j.a)localObject1).aaC();
        }
        if (localObject1 != null) {}
        try
        {
          long l = Util.currentTicks();
          float f = ar.au(MMApplicationContext.getContext()).y / ar.au(MMApplicationContext.getContext()).x;
          int i = (int)(((Bitmap)localObject1).getHeight() / f);
          localObject1 = BitmapUtil.fastblur(BitmapUtil.extractThumbNail((Bitmap)localObject1, ((Bitmap)localObject1).getHeight(), i, true, false), 20);
          localObject2 = a.kyA;
          p.j(localObject1, "blurBitmap");
          a.a.c((Bitmap)localObject1, paramInt);
          c.FE(Util.ticksToNow(l));
          MMHandlerThread.postToMainThread((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(190614);
              b localb = this.kyG.jFa;
              if (localb != null)
              {
                localb.invoke(this.kyH);
                AppMethodBeat.o(190614);
                return;
              }
              AppMethodBeat.o(190614);
            }
          });
          MMHandlerThread.postToMainThread((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(189858);
              b localb = this.kyG.jFa;
              if (localb != null)
              {
                localb.invoke(null);
                AppMethodBeat.o(189858);
                return;
              }
              AppMethodBeat.o(189858);
            }
          });
          AppMethodBeat.o(191713);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e(a.access$getTAG$cp(), "fastblur failed: " + localException.getMessage());
            MMHandlerThread.postToMainThread((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(195948);
                b localb = this.kyG.jFa;
                if (localb != null)
                {
                  localb.invoke(null);
                  AppMethodBeat.o(195948);
                  return;
                }
                AppMethodBeat.o(195948);
              }
            });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.d.a
 * JD-Core Version:    0.7.0.1
 */