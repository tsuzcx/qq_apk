package com.tencent.mm.aw.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.d;
import com.tencent.mm.aw.a.c.j;
import com.tencent.mm.aw.a.c.k;
import com.tencent.mm.aw.a.c.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;

public final class a
{
  private static a hjx = null;
  private b hju;
  private com.tencent.mm.aw.a.a.b hjv;
  private final k hjw;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(130347);
    this.hjw = new com.tencent.mm.aw.a.b.h();
    a(com.tencent.mm.aw.a.a.b.cx(paramContext));
    AppMethodBeat.o(130347);
  }
  
  public a(com.tencent.mm.aw.a.a.b paramb)
  {
    AppMethodBeat.i(130348);
    this.hjw = new com.tencent.mm.aw.a.b.h();
    a(paramb);
    AppMethodBeat.o(130348);
  }
  
  private static ap a(com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130364);
    paramc = paramc.handler;
    if ((paramc == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      paramc = new ap();
    }
    AppMethodBeat.o(130364);
    return paramc;
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130362);
    if ((paramImageView == null) || (paramc == null))
    {
      ad.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
      AppMethodBeat.o(130362);
      return;
    }
    if (paramc.ayV())
    {
      if (paramc.hki == 0)
      {
        paramImageView.setBackgroundDrawable(paramc.g(this.hjv.aHZ));
        AppMethodBeat.o(130362);
        return;
      }
      paramImageView.setBackgroundResource(paramc.hki);
      AppMethodBeat.o(130362);
      return;
    }
    paramImageView.setBackgroundDrawable(null);
    AppMethodBeat.o(130362);
  }
  
  private void a(com.tencent.mm.aw.a.a.b paramb)
  {
    try
    {
      AppMethodBeat.i(130349);
      if (paramb == null)
      {
        paramb = new IllegalArgumentException("[cpan] image loader configuration is null.");
        AppMethodBeat.o(130349);
        throw paramb;
      }
    }
    finally {}
    if (this.hjv == null)
    {
      this.hju = new b(paramb);
      this.hjv = paramb;
      AppMethodBeat.o(130349);
    }
    for (;;)
    {
      return;
      ad.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      AppMethodBeat.o(130349);
    }
  }
  
  public static a ayO()
  {
    try
    {
      AppMethodBeat.i(130346);
      if (hjx == null) {
        hjx = new a(aj.getContext());
      }
      a locala = hjx;
      AppMethodBeat.o(130346);
      return locala;
    }
    finally {}
  }
  
  private void b(ImageView paramImageView, com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130363);
    if ((paramImageView == null) || (paramc == null))
    {
      ad.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.ayU())
    {
      if (paramc.hkf == 0)
      {
        paramImageView.setImageDrawable(paramc.f(this.hjv.aHZ));
        AppMethodBeat.o(130363);
        return;
      }
      paramImageView.setImageResource(paramc.hkf);
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.gjA) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(130363);
  }
  
  private void b(String paramString, ImageView paramImageView, com.tencent.mm.aw.a.a.c paramc, k paramk, com.tencent.mm.aw.a.c.h paramh)
  {
    AppMethodBeat.i(130356);
    if (paramc == null) {
      paramc = this.hjv.hjG;
    }
    for (;;)
    {
      if (paramk == null) {
        paramk = this.hjw;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        a(paramImageView, paramc);
        if (bt.isNullOrNil(paramString))
        {
          ad.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          b(paramImageView, paramc);
          this.hju.a(localc);
          paramk.a(paramString, paramImageView, null, paramc.hkt);
          AppMethodBeat.o(130356);
          return;
        }
        com.tencent.mm.aw.a.f.b localb = new com.tencent.mm.aw.a.f.b(paramString, localc, a(paramc), paramc, paramk, this.hju, paramh);
        paramk = localb.yF(paramString);
        Bitmap localBitmap = this.hju.yu(paramk);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ad.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { paramk });
          paramk = localBitmap;
          if (paramc.hka) {
            paramk = f.l(localBitmap, paramc.hkb);
          }
          if (paramImageView != null) {
            paramImageView.setImageBitmap(paramk);
          }
          localb.mw(0L);
          if (paramh != null) {
            paramh.b(paramString, paramImageView, new com.tencent.mm.aw.a.d.b(paramk));
          }
          this.hju.a(localc);
          AppMethodBeat.o(130356);
          return;
        }
        if (paramImageView != null) {
          b(paramImageView, paramc);
        }
        if (((localb.hjG.hjV) || (!this.hju.Nb())) && (this.hju.a(localc, paramString)))
        {
          this.hju.a(localb);
          this.hju.a(localb, paramc.hjT);
        }
        AppMethodBeat.o(130356);
        return;
      }
    }
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(130357);
    paramString = new c(paramImageView, paramString);
    this.hju.a(paramString);
    AppMethodBeat.o(130357);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.aw.a.a.c paramc)
  {
    AppMethodBeat.i(130354);
    b(paramString, paramImageView, paramc, null, null);
    AppMethodBeat.o(130354);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.aw.a.a.c paramc, com.tencent.mm.aw.a.c.h paramh)
  {
    AppMethodBeat.i(130352);
    b(paramString, paramImageView, paramc, null, paramh);
    AppMethodBeat.o(130352);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.aw.a.a.c paramc, k paramk)
  {
    AppMethodBeat.i(130355);
    b(paramString, paramImageView, paramc, paramk, null);
    AppMethodBeat.o(130355);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.aw.a.a.c paramc, k paramk, com.tencent.mm.aw.a.c.h paramh)
  {
    AppMethodBeat.i(130353);
    b(paramString, paramImageView, paramc, paramk, paramh);
    AppMethodBeat.o(130353);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.aw.a.c.h paramh)
  {
    AppMethodBeat.i(130351);
    b(paramString, paramImageView, null, null, paramh);
    AppMethodBeat.o(130351);
  }
  
  public final void a(String paramString, com.tencent.mm.aw.a.a.c paramc, d paramd)
  {
    AppMethodBeat.i(130365);
    paramString = new com.tencent.mm.aw.a.f.a(paramString, paramc, this.hju, paramd);
    this.hju.a(paramString);
    AppMethodBeat.o(130365);
  }
  
  public final void cq(int paramInt)
  {
    AppMethodBeat.i(130358);
    ad.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1))
    {
      ad.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
      this.hju.hjz.resume();
      AppMethodBeat.o(130358);
      return;
    }
    ad.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.hju.hjz.pause();
    AppMethodBeat.o(130358);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(130359);
    if (this.hju != null) {
      this.hju.ayP();
    }
    AppMethodBeat.o(130359);
  }
  
  public final void i(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130361);
    if (this.hju != null)
    {
      b localb = this.hju;
      if (localb.hjy != null) {
        localb.hjy.hjH.c(paramString, paramBitmap);
      }
    }
    AppMethodBeat.o(130361);
  }
  
  public final void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(130350);
    b(paramString, paramImageView, null, null, null);
    AppMethodBeat.o(130350);
  }
  
  public final Bitmap yu(String paramString)
  {
    AppMethodBeat.i(130360);
    if (this.hju != null)
    {
      paramString = this.hju.yu(paramString);
      AppMethodBeat.o(130360);
      return paramString;
    }
    AppMethodBeat.o(130360);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.a.a
 * JD-Core Version:    0.7.0.1
 */