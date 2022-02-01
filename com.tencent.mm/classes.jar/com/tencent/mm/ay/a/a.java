package com.tencent.mm.ay.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.d;
import com.tencent.mm.ay.a.c.j;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.ay.a.c.o;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static a lRf = null;
  private b lRc;
  private com.tencent.mm.ay.a.a.b lRd;
  private final k lRe;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(130347);
    this.lRe = new com.tencent.mm.ay.a.b.h();
    a(com.tencent.mm.ay.a.a.b.cY(paramContext));
    AppMethodBeat.o(130347);
  }
  
  public a(com.tencent.mm.ay.a.a.b paramb)
  {
    AppMethodBeat.i(130348);
    this.lRe = new com.tencent.mm.ay.a.b.h();
    a(paramb);
    AppMethodBeat.o(130348);
  }
  
  private static MMHandler a(com.tencent.mm.ay.a.a.c paramc)
  {
    AppMethodBeat.i(130364);
    paramc = paramc.handler;
    if ((paramc == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      paramc = new MMHandler();
    }
    AppMethodBeat.o(130364);
    return paramc;
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ay.a.a.c paramc)
  {
    AppMethodBeat.i(130362);
    if ((paramImageView == null) || (paramc == null))
    {
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
      AppMethodBeat.o(130362);
      return;
    }
    if (paramc.bmy())
    {
      if (paramc.lRS == 0)
      {
        paramImageView.setBackgroundDrawable(paramc.h(this.lRd.lRm));
        AppMethodBeat.o(130362);
        return;
      }
      paramImageView.setBackgroundResource(paramc.lRS);
      AppMethodBeat.o(130362);
      return;
    }
    paramImageView.setBackgroundDrawable(null);
    AppMethodBeat.o(130362);
  }
  
  private void a(com.tencent.mm.ay.a.a.b paramb)
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
    if (this.lRd == null)
    {
      this.lRc = new b(paramb);
      this.lRd = paramb;
      AppMethodBeat.o(130349);
    }
    for (;;)
    {
      return;
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      AppMethodBeat.o(130349);
    }
  }
  
  private void b(ImageView paramImageView, com.tencent.mm.ay.a.a.c paramc)
  {
    AppMethodBeat.i(130363);
    if ((paramImageView == null) || (paramc == null))
    {
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.bmx())
    {
      if (paramc.lRP == 0)
      {
        paramImageView.setImageDrawable(paramc.g(this.lRd.lRm));
        AppMethodBeat.o(130363);
        return;
      }
      paramImageView.setImageResource(paramc.lRP);
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.kOl) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(130363);
  }
  
  private void b(String paramString, ImageView paramImageView, com.tencent.mm.ay.a.a.c paramc, k paramk, com.tencent.mm.ay.a.c.h paramh)
  {
    AppMethodBeat.i(130356);
    if (paramc == null) {
      paramc = this.lRd.lRp;
    }
    for (;;)
    {
      if (paramk == null) {
        paramk = this.lRe;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        a(paramImageView, paramc);
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          b(paramImageView, paramc);
          this.lRc.a(localc);
          paramk.a(paramString, paramImageView, null, paramc.lSd);
          AppMethodBeat.o(130356);
          return;
        }
        com.tencent.mm.ay.a.f.b localb = new com.tencent.mm.ay.a.f.b(paramString, localc, a(paramc), paramc, paramk, this.lRc, paramh);
        paramk = localb.Wz(paramString);
        Bitmap localBitmap = this.lRc.Wo(paramk);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { paramk });
          paramk = localBitmap;
          if (paramc.lRK) {
            paramk = BitmapUtil.fastblur(localBitmap, paramc.lRL);
          }
          if (paramImageView != null) {
            paramImageView.setImageBitmap(paramk);
          }
          localb.GK(0L);
          if (paramh != null) {
            paramh.b(paramString, paramImageView, new com.tencent.mm.ay.a.d.b(paramk));
          }
          this.lRc.a(localc);
          AppMethodBeat.o(130356);
          return;
        }
        if (paramImageView != null) {
          b(paramImageView, paramc);
        }
        if (((localb.lRp.lRE) || (!this.lRc.adH())) && (this.lRc.a(localc, paramString)))
        {
          this.lRc.a(localb);
          this.lRc.a(localb, paramc.lRC);
        }
        AppMethodBeat.o(130356);
        return;
      }
    }
  }
  
  public static a bms()
  {
    try
    {
      AppMethodBeat.i(130346);
      if (lRf == null) {
        lRf = new a(MMApplicationContext.getContext());
      }
      a locala = lRf;
      AppMethodBeat.o(130346);
      return locala;
    }
    finally {}
  }
  
  public final Bitmap Wo(String paramString)
  {
    AppMethodBeat.i(130360);
    if (this.lRc != null)
    {
      paramString = this.lRc.Wo(paramString);
      AppMethodBeat.o(130360);
      return paramString;
    }
    AppMethodBeat.o(130360);
    return null;
  }
  
  public final void Wp(String paramString)
  {
    AppMethodBeat.i(246086);
    if (this.lRc != null)
    {
      b localb = this.lRc;
      if (localb.lRg != null) {
        localb.lRg.lRq.remove(paramString);
      }
    }
    AppMethodBeat.o(246086);
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(130357);
    paramString = new c(paramImageView, paramString);
    this.lRc.a(paramString);
    AppMethodBeat.o(130357);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ay.a.a.c paramc)
  {
    AppMethodBeat.i(130354);
    b(paramString, paramImageView, paramc, null, null);
    AppMethodBeat.o(130354);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ay.a.a.c paramc, com.tencent.mm.ay.a.c.h paramh)
  {
    AppMethodBeat.i(130352);
    b(paramString, paramImageView, paramc, null, paramh);
    AppMethodBeat.o(130352);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ay.a.a.c paramc, k paramk)
  {
    AppMethodBeat.i(130355);
    b(paramString, paramImageView, paramc, paramk, null);
    AppMethodBeat.o(130355);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ay.a.a.c paramc, k paramk, com.tencent.mm.ay.a.c.h paramh)
  {
    AppMethodBeat.i(130353);
    b(paramString, paramImageView, paramc, paramk, paramh);
    AppMethodBeat.o(130353);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.ay.a.c.h paramh)
  {
    AppMethodBeat.i(130351);
    b(paramString, paramImageView, null, null, paramh);
    AppMethodBeat.o(130351);
  }
  
  public final void a(String paramString, com.tencent.mm.ay.a.a.c paramc, d paramd)
  {
    AppMethodBeat.i(130365);
    paramString = new com.tencent.mm.ay.a.f.a(paramString, paramc, this.lRc, paramd);
    this.lRc.a(paramString);
    AppMethodBeat.o(130365);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(130359);
    if (this.lRc != null) {
      this.lRc.aPn();
    }
    AppMethodBeat.o(130359);
  }
  
  public final void h(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130361);
    if (this.lRc != null)
    {
      b localb = this.lRc;
      if (localb.lRg != null) {
        localb.lRg.lRq.put(paramString, paramBitmap);
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
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(130358);
    Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1))
    {
      Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
      this.lRc.lRh.resume();
      AppMethodBeat.o(130358);
      return;
    }
    Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.lRc.lRh.pause();
    AppMethodBeat.o(130358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ay.a.a
 * JD-Core Version:    0.7.0.1
 */