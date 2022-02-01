package com.tencent.luggage.game.b;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.a.c.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.game.e.a.4;
import com.tencent.luggage.game.e.a.6;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  implements IImageDecodeService.b
{
  public static final b ciB;
  private final int ciA = 2048;
  private boolean ciC;
  private WeakReference<com.tencent.luggage.game.d.a.a.b> ciD = null;
  private final int ciz = 2048;
  
  static
  {
    AppMethodBeat.i(130469);
    ciB = new b();
    AppMethodBeat.o(130469);
  }
  
  private void a(String paramString1, e.a parama, String paramString2)
  {
    AppMethodBeat.i(130467);
    if (this.ciD.get() != null) {
      ((com.tencent.luggage.game.d.a.a.b)this.ciD.get()).CH().a(parama, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(130467);
  }
  
  private static void gs(int paramInt)
  {
    AppMethodBeat.i(130468);
    ((com.tencent.mm.plugin.appbrand.t.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(807L, paramInt, 1L, false);
    AppMethodBeat.o(130468);
  }
  
  public final void a(MBRuntime paramMBRuntime, AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
  {
    AppMethodBeat.i(130465);
    this.ciC = paramBoolean;
    ad.i("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
    if ((paramBoolean) && (paramAppBrandRuntime != null) && ((paramAppBrandRuntime.Ew() instanceof c))) {}
    for (com.tencent.luggage.game.d.a.a.b localb = (com.tencent.luggage.game.d.a.a.b)((c)paramAppBrandRuntime.Ew()).Q(com.tencent.luggage.game.d.a.a.b.class);; localb = null)
    {
      this.ciD = new WeakReference(localb);
      paramMBRuntime = paramMBRuntime.Hi();
      paramMBRuntime.addImageStreamFetcher(new b.a(paramAppBrandRuntime, (byte)0), true);
      paramMBRuntime.addImageStreamFetcher(new b.b(paramAppBrandRuntime), false);
      paramMBRuntime.setKvReportDelegate(new c());
      paramAppBrandRuntime = new com.tencent.magicbrush.b.a();
      paramAppBrandRuntime.bc(2048, 2048);
      paramMBRuntime.setBitmapDecodeSlave(paramAppBrandRuntime);
      paramMBRuntime.addDecodeEventListener(this);
      AppMethodBeat.o(130465);
      return;
    }
  }
  
  public final void a(String paramString, IImageDecodeService.b.a parama, com.github.henryye.nativeiv.api.a parama1)
  {
    AppMethodBeat.i(130466);
    switch (1.ciE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130466);
      return;
      parama = com.tencent.luggage.game.e.a.DO();
      long l1 = parama1.baQ;
      long l2 = parama1.baR;
      h.LTJ.aR(new a.4(parama, l1));
      parama.clI.add(Long.valueOf(l2));
      h.LTJ.aR(new a.6(parama, paramString, parama1));
      if (parama1.baR >= 1000L)
      {
        gs(11);
        AppMethodBeat.o(130466);
        return;
        if (TextUtils.isEmpty(parama1.baT)) {
          a(paramString, e.a.cjr, aj.getContext().getString(2131755963));
        }
        for (;;)
        {
          gs(7);
          AppMethodBeat.o(130466);
          return;
          a(paramString, e.a.cjr, String.format("%s: %s", new Object[] { aj.getContext().getString(2131755963), parama1.baT }));
        }
        a(paramString, e.a.cjr, aj.getContext().getString(2131755964));
        gs(5);
        AppMethodBeat.o(130466);
        return;
        a(paramString, e.a.cjr, aj.getContext().getString(2131755959));
        gs(0);
        AppMethodBeat.o(130466);
        return;
        a(paramString, e.a.cjr, String.format(aj.getContext().getString(2131755965), new Object[] { Integer.valueOf(parama1.mMaxWidth), Integer.valueOf(parama1.mMaxHeight), Long.valueOf(parama1.mWidth), Long.valueOf(parama1.mHeight) }));
        gs(3);
        AppMethodBeat.o(130466);
        return;
        ad.e("MicroMsg.MBImageHandlerRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.cjr, aj.getContext().getString(2131755960));
        gs(4);
        AppMethodBeat.o(130466);
        return;
        ad.e("MicroMsg.MBImageHandlerRegistry", "OUT_OF_MEMORY path:%s", new Object[] { paramString });
        a(paramString, e.a.cjr, aj.getContext().getString(2131755961));
        gs(1);
        AppMethodBeat.o(130466);
        return;
        ad.e("MicroMsg.MBImageHandlerRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
        a(paramString, e.a.cjr, aj.getContext().getString(2131755956));
        gs(5);
        AppMethodBeat.o(130466);
        return;
        ad.i("MicroMsg.MBImageHandlerRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
        gs(8);
      }
    }
  }
  
  public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig) {}
  
  public static final class c
    implements c.b
  {
    private int ciH = 14883;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.b.b
 * JD-Core Version:    0.7.0.1
 */