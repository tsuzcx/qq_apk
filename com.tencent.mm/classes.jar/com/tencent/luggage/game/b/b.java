package com.tencent.luggage.game.b;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.luggage.game.c.e.a;
import com.tencent.luggage.game.e.a.4;
import com.tencent.luggage.wxa.a.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b
  implements IImageDecodeService.b
{
  public String appId = "";
  public int ekA = 1004;
  public boolean ekt;
  public WeakReference<com.tencent.luggage.game.d.a.a.b> eku = null;
  public BaseImageDecodeService ekv = null;
  public ArrayList<String> ekw;
  public boolean ekx;
  public int eky;
  public double ekz;
  
  private void a(String paramString1, e.a parama, String paramString2)
  {
    AppMethodBeat.i(220130);
    if (this.eku.get() != null) {
      ((com.tencent.luggage.game.d.a.a.b)this.eku.get()).apg().a(parama, paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(220130);
  }
  
  private static void mk(int paramInt)
  {
    AppMethodBeat.i(220132);
    ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(807L, paramInt, 1L, false);
    AppMethodBeat.o(220132);
  }
  
  public final void a(final String paramString, IImageDecodeService.b.a parama, final com.github.henryye.nativeiv.api.a parama1)
  {
    AppMethodBeat.i(220141);
    switch (2.ekD[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(220141);
      return;
      parama = com.tencent.luggage.game.e.a.aqp();
      long l1 = parama1.cEg;
      long l2 = parama1.cEh;
      h.ahAA.bm(new a.4(parama, l1));
      parama.eoh.add(Long.valueOf(l2));
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220121);
          synchronized (b.a(b.this))
          {
            if ((b.this.ekx) && (!b.a(b.this).contains(paramString)) && (parama1 != null))
            {
              if (b.this.eky == 0) {
                break label203;
              }
              if (b.a(b.this).size() < b.this.eky)
              {
                Log.d("MicroMsg.MBImageDecodeRegistry", "reportDecodeInfo mMaxSampleNum report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", new Object[] { Integer.valueOf(b.a(b.this).size()), parama1.cEi, b.b(b.this), Integer.valueOf(b.this.ekA), Long.valueOf(parama1.cEg), Long.valueOf(parama1.mHeight), Long.valueOf(parama1.mWidth) });
                b.a(b.this, paramString, parama1);
              }
            }
            label203:
            while (Math.random() >= b.this.ekz)
            {
              AppMethodBeat.o(220121);
              return;
            }
            Log.d("MicroMsg.MBImageDecodeRegistry", "reportDecodeInfo mSampleRate report size:%d, getSourceType:%s,appId:%s,mAppType:%d,getSize:%d,getWidth:%d,getHeight:%d", new Object[] { Integer.valueOf(b.a(b.this).size()), parama1.cEi, b.b(b.this), Integer.valueOf(b.this.ekA), Long.valueOf(parama1.cEg), Long.valueOf(parama1.mHeight), Long.valueOf(parama1.mWidth) });
            b.a(b.this, paramString, parama1);
          }
        }
      });
      if (parama1.cEh >= 1000L)
      {
        mk(11);
        AppMethodBeat.o(220141);
        return;
        if (TextUtils.isEmpty(parama1.cEj)) {
          a(paramString, e.a.ely, MMApplicationContext.getContext().getString(a.f.appbrand_game_image_load_error));
        }
        for (;;)
        {
          mk(7);
          AppMethodBeat.o(220141);
          return;
          a(paramString, e.a.ely, String.format("%s: %s", new Object[] { MMApplicationContext.getContext().getString(a.f.appbrand_game_image_load_error), parama1.cEj }));
        }
        a(paramString, e.a.ely, MMApplicationContext.getContext().getString(a.f.appbrand_game_image_precheck_failed));
        mk(5);
        AppMethodBeat.o(220141);
        return;
        a(paramString, e.a.ely, MMApplicationContext.getContext().getString(a.f.appbrand_game_image_decode_resource_error_format));
        mk(0);
        AppMethodBeat.o(220141);
        return;
        a(paramString, e.a.ely, String.format(MMApplicationContext.getContext().getString(a.f.appbrand_game_image_size_exceed), new Object[] { Integer.valueOf(parama1.vF), Integer.valueOf(parama1.bkR), Long.valueOf(parama1.mWidth), Long.valueOf(parama1.mHeight) }));
        mk(3);
        AppMethodBeat.o(220141);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "IOEXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.ely, MMApplicationContext.getContext().getString(a.f.appbrand_game_image_decode_resource_error_io));
        mk(4);
        AppMethodBeat.o(220141);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "OUT_OF_MEMORY path:%s", new Object[] { paramString });
        a(paramString, e.a.ely, MMApplicationContext.getContext().getString(a.f.appbrand_game_image_decode_resource_error_out_of_memory));
        mk(1);
        AppMethodBeat.o(220141);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "NATIVE_DECODE_ERROR path:%s", new Object[] { paramString });
        a(paramString, e.a.ely, MMApplicationContext.getContext().getString(a.f.appbrand_game_image_decode_internal_error));
        mk(5);
        AppMethodBeat.o(220141);
        return;
        Log.e("MicroMsg.MBImageDecodeRegistry", "THROW_EXCEPTION path:%s", new Object[] { paramString });
        a(paramString, e.a.ely, MMApplicationContext.getContext().getString(a.f.appbrand_game_image_decode_resource_error_unknown));
        mk(16);
        AppMethodBeat.o(220141);
        return;
        Log.i("MicroMsg.MBImageDecodeRegistry", "USE_LEGACY path:%s", new Object[] { paramString });
        mk(8);
      }
    }
  }
  
  public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.b.b
 * JD-Core Version:    0.7.0.1
 */