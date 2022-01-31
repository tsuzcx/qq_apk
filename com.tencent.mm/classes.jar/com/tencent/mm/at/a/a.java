package com.tencent.mm.at.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class a
{
  private static a fGY = null;
  private b fGV;
  private com.tencent.mm.at.a.a.b fGW;
  private final i fGX;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(116018);
    this.fGX = new com.tencent.mm.at.a.b.h();
    a(com.tencent.mm.at.a.a.b.ce(paramContext));
    AppMethodBeat.o(116018);
  }
  
  public a(com.tencent.mm.at.a.a.b paramb)
  {
    AppMethodBeat.i(116019);
    this.fGX = new com.tencent.mm.at.a.b.h();
    a(paramb);
    AppMethodBeat.o(116019);
  }
  
  private static ak a(com.tencent.mm.at.a.a.c paramc)
  {
    AppMethodBeat.i(116035);
    paramc = paramc.handler;
    if ((paramc == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      paramc = new ak();
    }
    AppMethodBeat.o(116035);
    return paramc;
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.at.a.a.c paramc)
  {
    AppMethodBeat.i(116033);
    if ((paramImageView == null) || (paramc == null))
    {
      ab.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
      AppMethodBeat.o(116033);
      return;
    }
    if (paramc.ahS())
    {
      if (paramc.eOa == 0)
      {
        paramImageView.setBackgroundDrawable(paramc.f(this.fGW.eTW));
        AppMethodBeat.o(116033);
        return;
      }
      paramImageView.setBackgroundResource(paramc.eOa);
      AppMethodBeat.o(116033);
      return;
    }
    paramImageView.setBackgroundDrawable(null);
    AppMethodBeat.o(116033);
  }
  
  private void a(com.tencent.mm.at.a.a.b paramb)
  {
    try
    {
      AppMethodBeat.i(116020);
      if (paramb == null)
      {
        paramb = new IllegalArgumentException("[cpan] image loader configuration is null.");
        AppMethodBeat.o(116020);
        throw paramb;
      }
    }
    finally {}
    if (this.fGW == null)
    {
      this.fGV = new b(paramb);
      this.fGW = paramb;
      AppMethodBeat.o(116020);
    }
    for (;;)
    {
      return;
      ab.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      AppMethodBeat.o(116020);
    }
  }
  
  public static a ahM()
  {
    try
    {
      AppMethodBeat.i(116017);
      if (fGY == null) {
        fGY = new a(ah.getContext());
      }
      a locala = fGY;
      AppMethodBeat.o(116017);
      return locala;
    }
    finally {}
  }
  
  private void b(ImageView paramImageView, com.tencent.mm.at.a.a.c paramc)
  {
    AppMethodBeat.i(116034);
    if ((paramImageView == null) || (paramc == null))
    {
      ab.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      AppMethodBeat.o(116034);
      return;
    }
    if (paramc.ahR())
    {
      if (paramc.eNY == 0)
      {
        paramImageView.setImageDrawable(paramc.g(this.fGW.eTW));
        AppMethodBeat.o(116034);
        return;
      }
      paramImageView.setImageResource(paramc.eNY);
      AppMethodBeat.o(116034);
      return;
    }
    if (paramc.eOe) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(116034);
  }
  
  private void b(String paramString, ImageView paramImageView, com.tencent.mm.at.a.a.c paramc, i parami, g paramg)
  {
    AppMethodBeat.i(116027);
    if (paramc == null) {
      paramc = this.fGW.fHh;
    }
    for (;;)
    {
      if (parami == null) {
        parami = this.fGX;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        a(paramImageView, paramc);
        if (bo.isNullOrNil(paramString))
        {
          ab.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          b(paramImageView, paramc);
          this.fGV.a(localc);
          parami.a(paramString, paramImageView, null, paramc.eOi);
          AppMethodBeat.o(116027);
          return;
        }
        com.tencent.mm.at.a.f.b localb = new com.tencent.mm.at.a.f.b(paramString, localc, a(paramc), paramc, parami, this.fGV, paramg);
        parami = localb.tH(paramString);
        Bitmap localBitmap = this.fGV.tx(parami);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { parami });
          parami = localBitmap;
          if (paramc.fHu) {
            parami = d.g(localBitmap, paramc.fHv);
          }
          if (paramImageView != null) {
            paramImageView.setImageBitmap(parami);
          }
          localb.gX(0L);
          if (paramg != null) {
            paramg.b(paramString, paramImageView, new com.tencent.mm.at.a.d.b(parami));
          }
          this.fGV.a(localc);
          AppMethodBeat.o(116027);
          return;
        }
        if (paramImageView != null) {
          b(paramImageView, paramc);
        }
        if (((localb.fHh.eNN) || (!this.fGV.Ds())) && (this.fGV.a(localc, paramString)))
        {
          this.fGV.a(localb);
          this.fGV.a(localb, paramc.eNL);
        }
        AppMethodBeat.o(116027);
        return;
      }
    }
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(116021);
    b(paramString, paramImageView, null, null, null);
    AppMethodBeat.o(116021);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.at.a.a.c paramc)
  {
    AppMethodBeat.i(116025);
    b(paramString, paramImageView, paramc, null, null);
    AppMethodBeat.o(116025);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.at.a.a.c paramc, g paramg)
  {
    AppMethodBeat.i(116023);
    b(paramString, paramImageView, paramc, null, paramg);
    AppMethodBeat.o(116023);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.at.a.a.c paramc, i parami)
  {
    AppMethodBeat.i(116026);
    b(paramString, paramImageView, paramc, parami, null);
    AppMethodBeat.o(116026);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.at.a.a.c paramc, i parami, g paramg)
  {
    AppMethodBeat.i(116024);
    b(paramString, paramImageView, paramc, parami, paramg);
    AppMethodBeat.o(116024);
  }
  
  public final void a(String paramString, ImageView paramImageView, g paramg)
  {
    AppMethodBeat.i(116022);
    b(paramString, paramImageView, null, null, paramg);
    AppMethodBeat.o(116022);
  }
  
  public final void a(String paramString, com.tencent.mm.at.a.a.c paramc, com.tencent.mm.at.a.c.c paramc1)
  {
    AppMethodBeat.i(116036);
    paramString = new com.tencent.mm.at.a.f.a(paramString, paramc, this.fGV, paramc1);
    this.fGV.fHa.execute(paramString);
    AppMethodBeat.o(116036);
  }
  
  public final void b(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(116028);
    paramString = new c(paramImageView, paramString);
    this.fGV.a(paramString);
    AppMethodBeat.o(116028);
  }
  
  public final void bX(int paramInt)
  {
    AppMethodBeat.i(116029);
    ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1))
    {
      ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
      this.fGV.fHa.resume();
      AppMethodBeat.o(116029);
      return;
    }
    ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.fGV.fHa.pause();
    AppMethodBeat.o(116029);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(116030);
    if (this.fGV != null) {
      this.fGV.ahN();
    }
    AppMethodBeat.o(116030);
  }
  
  public final void j(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(116032);
    if (this.fGV != null)
    {
      b localb = this.fGV;
      if (localb.fGZ != null) {
        localb.fGZ.fHi.c(paramString, paramBitmap);
      }
    }
    AppMethodBeat.o(116032);
  }
  
  public final Bitmap tx(String paramString)
  {
    AppMethodBeat.i(116031);
    if (this.fGV != null)
    {
      paramString = this.fGV.tx(paramString);
      AppMethodBeat.o(116031);
      return paramString;
    }
    AppMethodBeat.o(116031);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.a.a
 * JD-Core Version:    0.7.0.1
 */