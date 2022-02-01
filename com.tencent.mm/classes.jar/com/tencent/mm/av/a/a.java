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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  private static a ifN = null;
  private b ifK;
  private com.tencent.mm.av.a.a.b ifL;
  private final k ifM;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(130347);
    this.ifM = new com.tencent.mm.av.a.b.h();
    a(com.tencent.mm.av.a.a.b.cF(paramContext));
    AppMethodBeat.o(130347);
  }
  
  public a(com.tencent.mm.av.a.a.b paramb)
  {
    AppMethodBeat.i(130348);
    this.ifM = new com.tencent.mm.av.a.b.h();
    a(paramb);
    AppMethodBeat.o(130348);
  }
  
  private static aq a(com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130364);
    paramc = paramc.handler;
    if ((paramc == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      paramc = new aq();
    }
    AppMethodBeat.o(130364);
    return paramc;
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130362);
    if ((paramImageView == null) || (paramc == null))
    {
      ae.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
      AppMethodBeat.o(130362);
      return;
    }
    if (paramc.aJn())
    {
      if (paramc.igy == 0)
      {
        paramImageView.setBackgroundDrawable(paramc.g(this.ifL.aKG));
        AppMethodBeat.o(130362);
        return;
      }
      paramImageView.setBackgroundResource(paramc.igy);
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
    if (this.ifL == null)
    {
      this.ifK = new b(paramb);
      this.ifL = paramb;
      AppMethodBeat.o(130349);
    }
    for (;;)
    {
      return;
      ae.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      AppMethodBeat.o(130349);
    }
  }
  
  public static a aJh()
  {
    try
    {
      AppMethodBeat.i(130346);
      if (ifN == null) {
        ifN = new a(ak.getContext());
      }
      a locala = ifN;
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
      ae.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.aJm())
    {
      if (paramc.igv == 0)
      {
        paramImageView.setImageDrawable(paramc.f(this.ifL.aKG));
        AppMethodBeat.o(130363);
        return;
      }
      paramImageView.setImageResource(paramc.igv);
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.hgL) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(130363);
  }
  
  private void b(String paramString, ImageView paramImageView, com.tencent.mm.av.a.a.c paramc, k paramk, com.tencent.mm.av.a.c.h paramh)
  {
    AppMethodBeat.i(130356);
    if (paramc == null) {
      paramc = this.ifL.ifW;
    }
    for (;;)
    {
      if (paramk == null) {
        paramk = this.ifM;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        a(paramImageView, paramc);
        if (bu.isNullOrNil(paramString))
        {
          ae.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          b(paramImageView, paramc);
          this.ifK.a(localc);
          paramk.a(paramString, paramImageView, null, paramc.igJ);
          AppMethodBeat.o(130356);
          return;
        }
        com.tencent.mm.av.a.f.b localb = new com.tencent.mm.av.a.f.b(paramString, localc, a(paramc), paramc, paramk, this.ifK, paramh);
        paramk = localb.Gq(paramString);
        Bitmap localBitmap = this.ifK.Gf(paramk);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ae.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { paramk });
          paramk = localBitmap;
          if (paramc.igq) {
            paramk = com.tencent.mm.sdk.platformtools.h.l(localBitmap, paramc.igr);
          }
          if (paramImageView != null) {
            paramImageView.setImageBitmap(paramk);
          }
          localb.sw(0L);
          if (paramh != null) {
            paramh.b(paramString, paramImageView, new com.tencent.mm.av.a.d.b(paramk));
          }
          this.ifK.a(localc);
          AppMethodBeat.o(130356);
          return;
        }
        if (paramImageView != null) {
          b(paramImageView, paramc);
        }
        if (((localb.ifW.igl) || (!this.ifK.OG())) && (this.ifK.a(localc, paramString)))
        {
          this.ifK.a(localb);
          this.ifK.a(localb, paramc.igj);
        }
        AppMethodBeat.o(130356);
        return;
      }
    }
  }
  
  public final Bitmap Gf(String paramString)
  {
    AppMethodBeat.i(130360);
    if (this.ifK != null)
    {
      paramString = this.ifK.Gf(paramString);
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
    this.ifK.a(paramString);
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
    paramString = new com.tencent.mm.av.a.f.a(paramString, paramc, this.ifK, paramd);
    this.ifK.a(paramString);
    AppMethodBeat.o(130365);
  }
  
  public final void cp(int paramInt)
  {
    AppMethodBeat.i(130358);
    ae.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1))
    {
      ae.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
      this.ifK.ifP.resume();
      AppMethodBeat.o(130358);
      return;
    }
    ae.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.ifK.ifP.pause();
    AppMethodBeat.o(130358);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(130359);
    if (this.ifK != null) {
      this.ifK.aoM();
    }
    AppMethodBeat.o(130359);
  }
  
  public final void h(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130361);
    if (this.ifK != null)
    {
      b localb = this.ifK;
      if (localb.ifO != null) {
        localb.ifO.ifX.put(paramString, paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.a
 * JD-Core Version:    0.7.0.1
 */