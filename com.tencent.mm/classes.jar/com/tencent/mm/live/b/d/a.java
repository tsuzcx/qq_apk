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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class a
{
  public static final a Fwy;
  private static final String TAG = "MicroMsg.LiveBitmapUtil";
  
  static
  {
    AppMethodBeat.i(202794);
    Fwy = new a((byte)0);
    TAG = "MicroMsg.LiveBitmapUtil";
    AppMethodBeat.o(202794);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil$Companion;", "", "()V", "TAG", "", "addMaskLayer", "Landroid/graphics/Bitmap;", "src", "maskColor", "", "genBlurBitmapByUsername", "", "username", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "plugin-logic_release"})
  public static final class a
  {
    public static void a(String paramString, final int paramInt, final d.g.a.b<? super Bitmap, y> paramb)
    {
      AppMethodBeat.i(202793);
      h.Iye.aP((Runnable)new a(paramString, paramb, paramInt));
      AppMethodBeat.o(202793);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(String paramString, d.g.a.b paramb, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(202792);
        if (bt.isNullOrNil(this.iPR))
        {
          localObject1 = paramb;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).aA(null);
            AppMethodBeat.o(202792);
            return;
          }
          AppMethodBeat.o(202792);
          return;
        }
        Object localObject2 = a.b.exg().ew(this.iPR);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a.b.exg();
          k.g(localObject1, "AvatarDrawable.Factory.getLoader()");
          localObject1 = ((i.a)localObject1).Ky();
        }
        if (localObject1 != null) {}
        try
        {
          long l = bt.GC();
          float f = ai.cf(aj.getContext()).y / ai.cf(aj.getContext()).x;
          int i = (int)(((Bitmap)localObject1).getHeight() / f);
          localObject1 = f.l(f.a((Bitmap)localObject1, ((Bitmap)localObject1).getHeight(), i, true, false), 20);
          localObject2 = a.Fwy;
          k.g(localObject1, "blurBitmap");
          i = paramInt;
          k.h(localObject1, "src");
          localObject2 = new Paint();
          ((Paint)localObject2).setAntiAlias(true);
          Canvas localCanvas = new Canvas((Bitmap)localObject1);
          ((Paint)localObject2).setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawColor(i);
          com.tencent.mm.live.core.c.b.Bd(bt.aS(l));
          aq.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202789);
              d.g.a.b localb = this.FwA.fLH;
              if (localb != null)
              {
                localb.aA(this.FwB);
                AppMethodBeat.o(202789);
                return;
              }
              AppMethodBeat.o(202789);
            }
          });
          aq.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(202791);
              d.g.a.b localb = this.FwA.fLH;
              if (localb != null)
              {
                localb.aA(null);
                AppMethodBeat.o(202791);
                return;
              }
              AppMethodBeat.o(202791);
            }
          });
          AppMethodBeat.o(202792);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e(a.access$getTAG$cp(), "fastblur failed: " + localException.getMessage());
            aq.f((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(202790);
                d.g.a.b localb = this.FwA.fLH;
                if (localb != null)
                {
                  localb.aA(null);
                  AppMethodBeat.o(202790);
                  return;
                }
                AppMethodBeat.o(202790);
              }
            });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.d.a
 * JD-Core Version:    0.7.0.1
 */