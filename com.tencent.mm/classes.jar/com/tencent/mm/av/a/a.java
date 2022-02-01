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
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static a jaI = null;
  private b jaF;
  private com.tencent.mm.av.a.a.b jaG;
  private final k jaH;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(130347);
    this.jaH = new com.tencent.mm.av.a.b.h();
    a(com.tencent.mm.av.a.a.b.db(paramContext));
    AppMethodBeat.o(130347);
  }
  
  public a(com.tencent.mm.av.a.a.b paramb)
  {
    AppMethodBeat.i(130348);
    this.jaH = new com.tencent.mm.av.a.b.h();
    a(paramb);
    AppMethodBeat.o(130348);
  }
  
  private static MMHandler a(com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130364);
    paramc = paramc.handler;
    if ((paramc == null) || (Looper.myLooper() == Looper.getMainLooper())) {
      paramc = new MMHandler();
    }
    AppMethodBeat.o(130364);
    return paramc;
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130362);
    if ((paramImageView == null) || (paramc == null))
    {
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
      AppMethodBeat.o(130362);
      return;
    }
    if (paramc.bdh())
    {
      if (paramc.jbt == 0)
      {
        paramImageView.setBackgroundDrawable(paramc.h(this.jaG.aKy));
        AppMethodBeat.o(130362);
        return;
      }
      paramImageView.setBackgroundResource(paramc.jbt);
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
    if (this.jaG == null)
    {
      this.jaF = new b(paramb);
      this.jaG = paramb;
      AppMethodBeat.o(130349);
    }
    for (;;)
    {
      return;
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
      AppMethodBeat.o(130349);
    }
  }
  
  private void b(ImageView paramImageView, com.tencent.mm.av.a.a.c paramc)
  {
    AppMethodBeat.i(130363);
    if ((paramImageView == null) || (paramc == null))
    {
      Log.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.bdg())
    {
      if (paramc.jbq == 0)
      {
        paramImageView.setImageDrawable(paramc.g(this.jaG.aKy));
        AppMethodBeat.o(130363);
        return;
      }
      paramImageView.setImageResource(paramc.jbq);
      AppMethodBeat.o(130363);
      return;
    }
    if (paramc.hZF) {
      paramImageView.setImageDrawable(null);
    }
    AppMethodBeat.o(130363);
  }
  
  private void b(String paramString, ImageView paramImageView, com.tencent.mm.av.a.a.c paramc, k paramk, com.tencent.mm.av.a.c.h paramh)
  {
    AppMethodBeat.i(130356);
    if (paramc == null) {
      paramc = this.jaG.jaR;
    }
    for (;;)
    {
      if (paramk == null) {
        paramk = this.jaH;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        a(paramImageView, paramc);
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          b(paramImageView, paramc);
          this.jaF.a(localc);
          paramk.a(paramString, paramImageView, null, paramc.jbE);
          AppMethodBeat.o(130356);
          return;
        }
        com.tencent.mm.av.a.f.b localb = new com.tencent.mm.av.a.f.b(paramString, localc, a(paramc), paramc, paramk, this.jaF, paramh);
        paramk = localb.Pc(paramString);
        Bitmap localBitmap = this.jaF.OQ(paramk);
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { paramk });
          paramk = localBitmap;
          if (paramc.jbl) {
            paramk = BitmapUtil.fastblur(localBitmap, paramc.jbm);
          }
          if (paramImageView != null) {
            paramImageView.setImageBitmap(paramk);
          }
          localb.AC(0L);
          if (paramh != null) {
            paramh.b(paramString, paramImageView, new com.tencent.mm.av.a.d.b(paramk));
          }
          this.jaF.a(localc);
          AppMethodBeat.o(130356);
          return;
        }
        if (paramImageView != null) {
          b(paramImageView, paramc);
        }
        if (((localb.jaR.jbg) || (!this.jaF.YY())) && (this.jaF.a(localc, paramString)))
        {
          this.jaF.a(localb);
          this.jaF.a(localb, paramc.jbe);
        }
        AppMethodBeat.o(130356);
        return;
      }
    }
  }
  
  public static a bdb()
  {
    try
    {
      AppMethodBeat.i(130346);
      if (jaI == null) {
        jaI = new a(MMApplicationContext.getContext());
      }
      a locala = jaI;
      AppMethodBeat.o(130346);
      return locala;
    }
    finally {}
  }
  
  public final Bitmap OQ(String paramString)
  {
    AppMethodBeat.i(130360);
    if (this.jaF != null)
    {
      paramString = this.jaF.OQ(paramString);
      AppMethodBeat.o(130360);
      return paramString;
    }
    AppMethodBeat.o(130360);
    return null;
  }
  
  public final void OR(String paramString)
  {
    AppMethodBeat.i(212679);
    if (this.jaF != null)
    {
      b localb = this.jaF;
      if (localb.jaJ != null) {
        localb.jaJ.jaS.remove(paramString);
      }
    }
    AppMethodBeat.o(212679);
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(130357);
    paramString = new c(paramImageView, paramString);
    this.jaF.a(paramString);
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
    paramString = new com.tencent.mm.av.a.f.a(paramString, paramc, this.jaF, paramd);
    this.jaF.a(paramString);
    AppMethodBeat.o(130365);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(130359);
    if (this.jaF != null) {
      this.jaF.aHn();
    }
    AppMethodBeat.o(130359);
  }
  
  public final void h(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130361);
    if (this.jaF != null)
    {
      b localb = this.jaF;
      if (localb.jaJ != null) {
        localb.jaJ.jaS.put(paramString, paramBitmap);
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
      this.jaF.jaK.resume();
      AppMethodBeat.o(130358);
      return;
    }
    Log.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.jaF.jaK.pause();
    AppMethodBeat.o(130358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.a
 * JD-Core Version:    0.7.0.1
 */