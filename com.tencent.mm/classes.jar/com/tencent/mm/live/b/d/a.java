package com.tencent.mm.live.b.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil;", "", "()V", "Companion", "plugin-logic_release"})
public final class a
{
  private static final String TAG = "MicroMsg.LiveBitmapUtil";
  public static final a gTM;
  
  static
  {
    AppMethodBeat.i(215900);
    gTM = new a((byte)0);
    TAG = "MicroMsg.LiveBitmapUtil";
    AppMethodBeat.o(215900);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/util/LiveBitmapUtil$Companion;", "", "()V", "TAG", "", "addMaskLayer", "Landroid/graphics/Bitmap;", "src", "maskColor", "", "genBlurBitmapByUsername", "", "username", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "plugin-logic_release"})
  public static final class a
  {
    public static void a(String paramString, final int paramInt, final d.g.a.b<? super Bitmap, z> paramb)
    {
      AppMethodBeat.i(215899);
      com.tencent.e.h.MqF.aO((Runnable)new a(paramString, paramb, paramInt));
      AppMethodBeat.o(215899);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(String paramString, d.g.a.b paramb, int paramInt) {}
      
      public final void run()
      {
        AppMethodBeat.i(215898);
        if (bu.isNullOrNil(this.gTN))
        {
          localObject1 = paramb;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).invoke(null);
            AppMethodBeat.o(215898);
            return;
          }
          AppMethodBeat.o(215898);
          return;
        }
        Object localObject2 = a.b.ffl().fl(this.gTN);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a.b.ffl();
          p.g(localObject1, "AvatarDrawable.Factory.getLoader()");
          localObject1 = ((j.a)localObject1).LT();
        }
        if (localObject1 != null) {}
        try
        {
          long l = bu.HQ();
          float f = al.ck(ak.getContext()).y / al.ck(ak.getContext()).x;
          int i = (int)(((Bitmap)localObject1).getHeight() / f);
          localObject1 = com.tencent.mm.sdk.platformtools.h.l(com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, ((Bitmap)localObject1).getHeight(), i, true, false), 20);
          localObject2 = a.gTM;
          p.g(localObject1, "blurBitmap");
          i = paramInt;
          p.h(localObject1, "src");
          localObject2 = new Paint();
          ((Paint)localObject2).setAntiAlias(true);
          Canvas localCanvas = new Canvas((Bitmap)localObject1);
          ((Paint)localObject2).setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawColor(i);
          com.tencent.mm.live.core.c.b.rt(bu.aO(l));
          ar.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215895);
              d.g.a.b localb = this.gTP.gll;
              if (localb != null)
              {
                localb.invoke(this.gTQ);
                AppMethodBeat.o(215895);
                return;
              }
              AppMethodBeat.o(215895);
            }
          });
          ar.f((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215897);
              d.g.a.b localb = this.gTP.gll;
              if (localb != null)
              {
                localb.invoke(null);
                AppMethodBeat.o(215897);
                return;
              }
              AppMethodBeat.o(215897);
            }
          });
          AppMethodBeat.o(215898);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e(a.access$getTAG$cp(), "fastblur failed: " + localException.getMessage());
            ar.f((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(215896);
                d.g.a.b localb = this.gTP.gll;
                if (localb != null)
                {
                  localb.invoke(null);
                  AppMethodBeat.o(215896);
                  return;
                }
                AppMethodBeat.o(215896);
              }
            });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.b.d.a
 * JD-Core Version:    0.7.0.1
 */