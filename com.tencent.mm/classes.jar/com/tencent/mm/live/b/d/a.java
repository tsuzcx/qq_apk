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
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class a
{
  private static final String TAG = "MicroMsg.LiveBitmapUtil";
  public static final a gRe;
  
  static
  {
    AppMethodBeat.i(212280);
    gRe = new a((byte)0);
    TAG = "MicroMsg.LiveBitmapUtil";
    AppMethodBeat.o(212280);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil$Companion;", "", "()V", "TAG", "", "addMaskLayer", "Landroid/graphics/Bitmap;", "src", "maskColor", "", "genBlurBitmapByUsername", "", "username", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "plugin-logic_release"})
  public static final class a
  {
    public static void a(String paramString, final int paramInt, final d.g.a.b<? super Bitmap, z> paramb)
    {
      AppMethodBeat.i(212279);
      h.LTJ.aR((Runnable)new a(paramString, paramb, paramInt));
      AppMethodBeat.o(212279);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(String paramString, d.g.a.b paramb, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(212278);
        if (bt.isNullOrNil(this.gRf))
        {
          localObject1 = paramb;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).invoke(null);
            AppMethodBeat.o(212278);
            return;
          }
          AppMethodBeat.o(212278);
          return;
        }
        Object localObject2 = a.b.fbx().fg(this.gRf);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a.b.fbx();
          p.g(localObject1, "AvatarDrawable.Factory.getLoader()");
          localObject1 = ((j.a)localObject1).LL();
        }
        if (localObject1 != null) {}
        try
        {
          long l = bt.HI();
          float f = al.ci(aj.getContext()).y / al.ci(aj.getContext()).x;
          int i = (int)(((Bitmap)localObject1).getHeight() / f);
          localObject1 = g.l(g.a((Bitmap)localObject1, ((Bitmap)localObject1).getHeight(), i, true, false), 20);
          localObject2 = a.gRe;
          p.g(localObject1, "blurBitmap");
          i = paramInt;
          p.h(localObject1, "src");
          localObject2 = new Paint();
          ((Paint)localObject2).setAntiAlias(true);
          Canvas localCanvas = new Canvas((Bitmap)localObject1);
          ((Paint)localObject2).setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawColor(i);
          com.tencent.mm.live.core.c.b.rg(bt.aO(l));
          aq.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(212275);
              d.g.a.b localb = this.gRh.giT;
              if (localb != null)
              {
                localb.invoke(this.gRi);
                AppMethodBeat.o(212275);
                return;
              }
              AppMethodBeat.o(212275);
            }
          });
          aq.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(212277);
              d.g.a.b localb = this.gRh.giT;
              if (localb != null)
              {
                localb.invoke(null);
                AppMethodBeat.o(212277);
                return;
              }
              AppMethodBeat.o(212277);
            }
          });
          AppMethodBeat.o(212278);
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
                AppMethodBeat.i(212276);
                d.g.a.b localb = this.gRh.giT;
                if (localb != null)
                {
                  localb.invoke(null);
                  AppMethodBeat.o(212276);
                  return;
                }
                AppMethodBeat.o(212276);
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