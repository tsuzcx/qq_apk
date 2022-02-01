package com.tencent.luggage.game.b;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.game.e.a.4;
import com.tencent.luggage.wxa.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  implements IImageDecodeService.b
{
  public String appId = "";
  public WeakReference<com.tencent.luggage.game.d.a.a.b> csA = null;
  public BaseImageDecodeService csB = null;
  public ArrayList<String> csC;
  public boolean csD;
  public int csE;
  public double csF;
  public int csG = 1004;
  public boolean csz;
  
  private void a(String paramString1, e.a parama, String paramString2)
  {
    AppMethodBeat.i(247400);
    if (this.csA.get() != null) {
      ((com.tencent.luggage.game.d.a.a.b)this.csA.get()).OY().a(parama, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(247400);
  }
  
  private static void iG(int paramInt)
  {
    AppMethodBeat.i(247401);
    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(807L, paramInt, 1L, false);
    AppMethodBeat.o(247401);
  }
  
  public final void a(final String paramString, IImageDecodeService.b.a parama, final com.github.henryye.nativeiv.api.a parama1)
  {
    AppMethodBeat.i(247399);
    switch (b.2.csJ[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247399);
      return;
      parama = com.tencent.luggage.game.e.a.Qf();
      long l1 = parama1.aKk;
      long l2 = parama1.aKl;
      h.ZvG.be(new a.4(parama, l1));
      parama.cwi.add(Long.valueOf(l2));
      h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(246803);
          synchronized (b.a(b.this))
          {
            if ((b.this.csD) && (!b.a(b.this).contains(paramString)) && (parama1 != null))
            {
              if (b.this.csE == 0) {
                break label203;
              }
              if (b.a(b.this).size() < b.this.csE)
              {
                Log.d("MicroMsg.MBImageDecodeRegistry", "reportDecodeInfo mMaxSampleNum report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", new Object[] { Integer.valueOf(b.a(b.this).size()), parama1.aKm, b.b(b.this), Integer.valueOf(b.this.csG), Long.valueOf(parama1.aKk), Long.valueOf(parama1.mHeight), Long.valueOf(parama1.mWidth) });
                b.a(b.this, paramString, parama1);
              }
            }
            label203:
            while (Math.random() >= b.this.csF)
            {
              AppMethodBeat.o(246803);
              return;
            }
            Log.d("MicroMsg.MBImageDecodeRegistry", "reportDecodeInfo mSampleRate report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", new Object[] { Integer.valueOf(b.a(b.this).size()), parama1.aKm, b.b(b.this), Integer.valueOf(b.this.csG), Long.valueOf(parama1.aKk), Long.valueOf(parama1.mHeight), Long.valueOf(parama1.mWidth) });
            b.a(b.this, paramString, parama1);
          }
        }
      });
      if (parama1.aKl >= 1000L)
      {
        iG(11);
        AppMethodBeat.o(247399);
        return;
        if (TextUtils.isEmpty(parama1.aKn)) {
          a(paramString, e.a.ctE, MMApplicationContext.getContext().getString(a.e.appbrand_game_image_load_error));
        }
        for (;;)
        {
          iG(7);
          AppMethodBeat.o(247399);
          return;
          a(paramString, e.a.ctE, String.format("%s: %s", new Object[] { MMApplicationContext.getContext().getString(a.e.appbrand_game_image_load_error), parama1.aKn }));
        }
        a(paramString, e.a.ctE, MMApplicationContext.getContext().getString(a.e.appbrand_game_image_precheck_failed));
        iG(5);
        AppMethodBeat.o(247399);
        return;
        a(paramString, e.a.ctE, MMApplicationContext.getContext().getString(a.e.appbrand_game_image_decode_resource_error_format));
        iG(0);
        AppMethodBeat.o(247399);
        return;
        a(paramString, e.a.ctE, String.format(MMApplicationContext.getContext().getString(a.e.appbrand_game_image_size_exceed), new Object[] { Integer.valueOf(parama1.uJ), Integer.valueOf(parama1.EK), Long.valueOf(parama1.mWidth), Long.valueOf(parama1.mHeight) }));
        iG(3);
        AppMethodBeat.o(247399);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.ctE, MMApplicationContext.getContext().getString(a.e.appbrand_game_image_decode_resource_error_io));
        iG(4);
        AppMethodBeat.o(247399);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "OUT_OF_MEMORY path:%s", new Object[] { paramString });
        a(paramString, e.a.ctE, MMApplicationContext.getContext().getString(a.e.appbrand_game_image_decode_resource_error_out_of_memory));
        iG(1);
        AppMethodBeat.o(247399);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
        a(paramString, e.a.ctE, MMApplicationContext.getContext().getString(a.e.appbrand_game_image_decode_internal_error));
        iG(5);
        AppMethodBeat.o(247399);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "THROW_EXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.ctE, MMApplicationContext.getContext().getString(a.e.appbrand_game_image_decode_resource_error_unknown));
        iG(16);
        AppMethodBeat.o(247399);
        return;
        Log.i("MicroMsg.MBImageDecodeRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
        iG(8);
      }
    }
  }
  
  public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.b.b
 * JD-Core Version:    0.7.0.1
 */