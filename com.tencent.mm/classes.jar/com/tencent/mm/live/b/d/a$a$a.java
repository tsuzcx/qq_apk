package com.tencent.mm.live.b.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class a$a$a
  implements Runnable
{
  a$a$a(String paramString, d.g.a.b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(189992);
    if (bs.isNullOrNil(this.gxu))
    {
      localObject1 = this.fPt;
      if (localObject1 != null)
      {
        ((d.g.a.b)localObject1).ay(null);
        AppMethodBeat.o(189992);
        return;
      }
      AppMethodBeat.o(189992);
      return;
    }
    Object localObject2 = a.b.eMA().el(this.gxu);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a.b.eMA();
      k.g(localObject1, "AvatarDrawable.Factory.getLoader()");
      localObject1 = ((i.a)localObject1).Kj();
    }
    if (localObject1 != null) {}
    try
    {
      long l = bs.Gn();
      float f = aj.cl(ai.getContext()).y / aj.cl(ai.getContext()).x;
      int i = (int)(((Bitmap)localObject1).getHeight() / f);
      localObject1 = f.l(f.a((Bitmap)localObject1, ((Bitmap)localObject1).getHeight(), i, true, false), 20);
      localObject2 = a.gxt;
      k.g(localObject1, "blurBitmap");
      i = this.gxv;
      k.h(localObject1, "src");
      localObject2 = new Paint();
      ((Paint)localObject2).setAntiAlias(true);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      ((Paint)localObject2).setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawColor(i);
      com.tencent.mm.live.core.c.b.pf(bs.aO(l));
      ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189989);
          d.g.a.b localb = this.gxw.fPt;
          if (localb != null)
          {
            localb.ay(this.gxx);
            AppMethodBeat.o(189989);
            return;
          }
          AppMethodBeat.o(189989);
        }
      });
      ap.f((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189991);
          d.g.a.b localb = this.gxw.fPt;
          if (localb != null)
          {
            localb.ay(null);
            AppMethodBeat.o(189991);
            return;
          }
          AppMethodBeat.o(189991);
        }
      });
      AppMethodBeat.o(189992);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e(a.access$getTAG$cp(), "fastblur failed: " + localException.getMessage());
        ap.f((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189990);
            d.g.a.b localb = this.gxw.fPt;
            if (localb != null)
            {
              localb.ay(null);
              AppMethodBeat.o(189990);
              return;
            }
            AppMethodBeat.o(189990);
          }
        });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.b.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */