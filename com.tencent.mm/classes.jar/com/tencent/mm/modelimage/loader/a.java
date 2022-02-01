package com.tencent.mm.modelimage.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.d;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.b.j;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.modelimage.loader.b.o;
import com.tencent.mm.modelimage.loader.impr.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static a oJR = null;
  private b oJO;
  private com.tencent.mm.modelimage.loader.a.b oJP;
  private final k oJQ;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(130347);
    this.oJQ = new g();
    a(com.tencent.mm.modelimage.loader.a.b.dR(paramContext));
    AppMethodBeat.o(130347);
  }
  
  public a(com.tencent.mm.modelimage.loader.a.b paramb)
  {
    AppMethodBeat.i(130348);
    this.oJQ = new g();
    a(paramb);
    AppMethodBeat.o(130348);
  }
  
  private static MMHandler a(com.tencent.mm.modelimage.loader.a.c paramc)
  {
    AppMethodBeat.i(130364);
    paramc = paramc.handler;
    if ((paramc == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      paramc = new MMHandler();
    }
    AppMethodBeat.o(130364);
    return paramc;
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.modelimage.loader.a.c paramc)
  {
    AppMethodBeat.i(130362);
    if ((paramImageView == null) || (paramc == null))
    {
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
      AppMethodBeat.o(130362);
      return;
    }
    if (paramc.bKr())
    {
      if (paramc.oKE == 0)
      {
        paramImageView.setBackgroundDrawable(paramc.h(this.oJP.oJY));
        AppMethodBeat.o(130362);
        return;
      }
      paramImageView.setBackgroundResource(paramc.oKE);
      AppMethodBeat.o(130362);
      return;
    }
    paramImageView.setBackgroundDrawable(null);
    AppMethodBeat.o(130362);
  }
  
  private void a(com.tencent.mm.modelimage.loader.a.b paramb)
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
    if (this.oJP == null)
    {
      this.oJO = new b(paramb);
      this.oJP = paramb;
      AppMethodBeat.o(130349);
    }
    for (;;)
    {
      return;
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      AppMethodBeat.o(130349);
    }
  }
  
  private void b(ImageView paramImageView, com.tencent.mm.modelimage.loader.a.c paramc)
  {
    AppMethodBeat.i(130363);
    if ((paramImageView == null) || (paramc == null))
    {
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.bKq())
    {
      if (paramc.oKB == 0)
      {
        paramImageView.setImageDrawable(paramc.g(this.oJP.oJY));
        AppMethodBeat.o(130363);
        return;
      }
      paramImageView.setImageResource(paramc.oKB);
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.nqa) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(130363);
  }
  
  private void b(String paramString, ImageView paramImageView, com.tencent.mm.modelimage.loader.a.c paramc, k paramk, h paramh)
  {
    AppMethodBeat.i(130356);
    if (paramc == null) {
      paramc = this.oJP.oKb;
    }
    for (;;)
    {
      if (paramk == null) {
        paramk = this.oJQ;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        a(paramImageView, paramc);
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          b(paramImageView, paramc);
          this.oJO.a(localc);
          paramk.onImageLoadComplete(paramString, paramImageView, null, paramc.oKP);
          AppMethodBeat.o(130356);
          return;
        }
        com.tencent.mm.modelimage.loader.e.b localb = new com.tencent.mm.modelimage.loader.e.b(paramString, localc, a(paramc), paramc, paramk, this.oJO, paramh);
        paramk = localb.Oy(paramString);
        Bitmap localBitmap = this.oJO.Oo(paramk);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { paramk });
          paramk = localBitmap;
          if (paramc.oKw) {
            paramk = BitmapUtil.fastblur(localBitmap, paramc.oKx);
          }
          if (paramImageView != null) {
            paramImageView.setImageBitmap(paramk);
          }
          localb.iV(0L);
          if (paramh != null) {
            paramh.b(paramString, paramImageView, new com.tencent.mm.modelimage.loader.c.b(paramk));
          }
          this.oJO.a(localc);
          AppMethodBeat.o(130356);
          return;
        }
        if (paramImageView != null) {
          b(paramImageView, paramc);
        }
        if (((localb.oKb.oKq) || (!this.oJO.aFF())) && (this.oJO.a(localc, paramString)))
        {
          this.oJO.a(localb);
          this.oJO.a(localb, paramc.oKo);
        }
        AppMethodBeat.o(130356);
        return;
      }
    }
  }
  
  public static a bKl()
  {
    try
    {
      AppMethodBeat.i(130346);
      if (oJR == null) {
        oJR = new a(MMApplicationContext.getContext());
      }
      a locala = oJR;
      AppMethodBeat.o(130346);
      return locala;
    }
    finally {}
  }
  
  public final Bitmap Oo(String paramString)
  {
    AppMethodBeat.i(130360);
    if (this.oJO != null)
    {
      paramString = this.oJO.Oo(paramString);
      AppMethodBeat.o(130360);
      return paramString;
    }
    AppMethodBeat.o(130360);
    return null;
  }
  
  public final void Op(String paramString)
  {
    AppMethodBeat.i(239065);
    if (this.oJO != null)
    {
      b localb = this.oJO;
      if (localb.oJS != null) {
        localb.oJS.oKc.remove(paramString);
      }
    }
    AppMethodBeat.o(239065);
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(130357);
    paramString = new c(paramImageView, paramString);
    this.oJO.a(paramString);
    AppMethodBeat.o(130357);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.modelimage.loader.a.c paramc)
  {
    AppMethodBeat.i(130354);
    b(paramString, paramImageView, paramc, null, null);
    AppMethodBeat.o(130354);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.modelimage.loader.a.c paramc, h paramh)
  {
    AppMethodBeat.i(130352);
    b(paramString, paramImageView, paramc, null, paramh);
    AppMethodBeat.o(130352);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.modelimage.loader.a.c paramc, k paramk)
  {
    AppMethodBeat.i(130355);
    b(paramString, paramImageView, paramc, paramk, null);
    AppMethodBeat.o(130355);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.modelimage.loader.a.c paramc, k paramk, h paramh)
  {
    AppMethodBeat.i(130353);
    b(paramString, paramImageView, paramc, paramk, paramh);
    AppMethodBeat.o(130353);
  }
  
  public final void a(String paramString, ImageView paramImageView, h paramh)
  {
    AppMethodBeat.i(130351);
    b(paramString, paramImageView, null, null, paramh);
    AppMethodBeat.o(130351);
  }
  
  public final void a(String paramString, com.tencent.mm.modelimage.loader.a.c paramc, d paramd)
  {
    AppMethodBeat.i(130365);
    paramString = new com.tencent.mm.modelimage.loader.e.a(paramString, paramc, this.oJO, paramd);
    this.oJO.a(paramString);
    AppMethodBeat.o(130365);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(130359);
    if (this.oJO != null) {
      this.oJO.bja();
    }
    AppMethodBeat.o(130359);
  }
  
  public final void h(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130361);
    if (this.oJO != null)
    {
      b localb = this.oJO;
      if (localb.oJS != null) {
        localb.oJS.oKc.put(paramString, paramBitmap);
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
      this.oJO.oJT.resume();
      AppMethodBeat.o(130358);
      return;
    }
    Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.oJO.oJT.pause();
    AppMethodBeat.o(130358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.a
 * JD-Core Version:    0.7.0.1
 */