package com.tencent.mm.av.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.d;
import com.tencent.mm.av.a.c.j;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;

public final class a
{
  private static a hKa = null;
  private b hJX;
  private com.tencent.mm.av.a.a.b hJY;
  private final k hJZ;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(130347);
    this.hJZ = new com.tencent.mm.av.a.b.h();
    a(com.tencent.mm.av.a.a.b.cG(paramContext));
    AppMethodBeat.o(130347);
  }
  
  public a(com.tencent.mm.av.a.a.b paramb)
  {
    AppMethodBeat.i(130348);
    this.hJZ = new com.tencent.mm.av.a.b.h();
    a(paramb);
    AppMethodBeat.o(130348);
  }
  
  private static ao a(com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130364);
    paramc = paramc.handler;
    if ((paramc == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      paramc = new ao();
    }
    AppMethodBeat.o(130364);
    return paramc;
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130362);
    if ((paramImageView == null) || (paramc == null))
    {
      ac.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
      AppMethodBeat.o(130362);
      return;
    }
    if (paramc.aFM())
    {
      if (paramc.hKL == 0)
      {
        paramImageView.setBackgroundDrawable(paramc.g(this.hJY.aIP));
        AppMethodBeat.o(130362);
        return;
      }
      paramImageView.setBackgroundResource(paramc.hKL);
      AppMethodBeat.o(130362);
      return;
    }
    paramImageView.setBackgroundDrawable(null);
    AppMethodBeat.o(130362);
  }
  
  private void a(com.tencent.mm.av.a.a.b paramb)
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
    if (this.hJY == null)
    {
      this.hJX = new b(paramb);
      this.hJY = paramb;
      AppMethodBeat.o(130349);
    }
    for (;;)
    {
      return;
      ac.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      AppMethodBeat.o(130349);
    }
  }
  
  public static a aFG()
  {
    try
    {
      AppMethodBeat.i(130346);
      if (hKa == null) {
        hKa = new a(ai.getContext());
      }
      a locala = hKa;
      AppMethodBeat.o(130346);
      return locala;
    }
    finally {}
  }
  
  private void b(ImageView paramImageView, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130363);
    if ((paramImageView == null) || (paramc == null))
    {
      ac.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.aFL())
    {
      if (paramc.hKI == 0)
      {
        paramImageView.setImageDrawable(paramc.f(this.hJY.aIP));
        AppMethodBeat.o(130363);
        return;
      }
      paramImageView.setImageResource(paramc.hKI);
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.gKm) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(130363);
  }
  
  private void b(String paramString, ImageView paramImageView, com.tencent.mm.av.a.a.c paramc, k paramk, com.tencent.mm.av.a.c.h paramh)
  {
    AppMethodBeat.i(130356);
    if (paramc == null) {
      paramc = this.hJY.hKj;
    }
    for (;;)
    {
      if (paramk == null) {
        paramk = this.hJZ;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        a(paramImageView, paramc);
        if (bs.isNullOrNil(paramString))
        {
          ac.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          b(paramImageView, paramc);
          this.hJX.a(localc);
          paramk.a(paramString, paramImageView, null, paramc.hKW);
          AppMethodBeat.o(130356);
          return;
        }
        com.tencent.mm.av.a.f.b localb = new com.tencent.mm.av.a.f.b(paramString, localc, a(paramc), paramc, paramk, this.hJX, paramh);
        paramk = localb.CK(paramString);
        Bitmap localBitmap = this.hJX.Cz(paramk);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ac.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { paramk });
          paramk = localBitmap;
          if (paramc.hKD) {
            paramk = f.l(localBitmap, paramc.hKE);
          }
          if (paramImageView != null) {
            paramImageView.setImageBitmap(paramk);
          }
          localb.qk(0L);
          if (paramh != null) {
            paramh.b(paramString, paramImageView, new com.tencent.mm.av.a.d.b(paramk));
          }
          this.hJX.a(localc);
          AppMethodBeat.o(130356);
          return;
        }
        if (paramImageView != null) {
          b(paramImageView, paramc);
        }
        if (((localb.hKj.hKy) || (!this.hJX.MZ())) && (this.hJX.a(localc, paramString)))
        {
          this.hJX.a(localb);
          this.hJX.a(localb, paramc.hKw);
        }
        AppMethodBeat.o(130356);
        return;
      }
    }
  }
  
  public final Bitmap Cz(String paramString)
  {
    AppMethodBeat.i(130360);
    if (this.hJX != null)
    {
      paramString = this.hJX.Cz(paramString);
      AppMethodBeat.o(130360);
      return paramString;
    }
    AppMethodBeat.o(130360);
    return null;
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(130357);
    paramString = new c(paramImageView, paramString);
    this.hJX.a(paramString);
    AppMethodBeat.o(130357);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130354);
    b(paramString, paramImageView, paramc, null, null);
    AppMethodBeat.o(130354);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.av.a.a.c paramc, com.tencent.mm.av.a.c.h paramh)
  {
    AppMethodBeat.i(130352);
    b(paramString, paramImageView, paramc, null, paramh);
    AppMethodBeat.o(130352);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.av.a.a.c paramc, k paramk)
  {
    AppMethodBeat.i(130355);
    b(paramString, paramImageView, paramc, paramk, null);
    AppMethodBeat.o(130355);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.av.a.a.c paramc, k paramk, com.tencent.mm.av.a.c.h paramh)
  {
    AppMethodBeat.i(130353);
    b(paramString, paramImageView, paramc, paramk, paramh);
    AppMethodBeat.o(130353);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.av.a.c.h paramh)
  {
    AppMethodBeat.i(130351);
    b(paramString, paramImageView, null, null, paramh);
    AppMethodBeat.o(130351);
  }
  
  public final void a(String paramString, com.tencent.mm.av.a.a.c paramc, d paramd)
  {
    AppMethodBeat.i(130365);
    paramString = new com.tencent.mm.av.a.f.a(paramString, paramc, this.hJX, paramd);
    this.hJX.a(paramString);
    AppMethodBeat.o(130365);
  }
  
  public final void cp(int paramInt)
  {
    AppMethodBeat.i(130358);
    ac.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1))
    {
      ac.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
      this.hJX.hKc.resume();
      AppMethodBeat.o(130358);
      return;
    }
    ac.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.hJX.hKc.pause();
    AppMethodBeat.o(130358);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(130359);
    if (this.hJX != null) {
      this.hJX.alK();
    }
    AppMethodBeat.o(130359);
  }
  
  public final void h(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130361);
    if (this.hJX != null)
    {
      b localb = this.hJX;
      if (localb.hKb != null) {
        localb.hKb.hKk.put(paramString, paramBitmap);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.av.a.a
 * JD-Core Version:    0.7.0.1
 */