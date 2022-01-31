package com.tencent.mm.as.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.as.a.c.e;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.as.a.c.l;
import com.tencent.mm.as.a.c.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class a
{
  private static a eqx = null;
  private b equ;
  private com.tencent.mm.as.a.a.b eqv;
  private final i eqw = new com.tencent.mm.as.a.b.h();
  
  public a(Context paramContext)
  {
    a(com.tencent.mm.as.a.a.b.bz(paramContext));
  }
  
  public a(com.tencent.mm.as.a.a.b paramb)
  {
    a(paramb);
  }
  
  public static a OT()
  {
    try
    {
      if (eqx == null) {
        eqx = new a(ae.getContext());
      }
      a locala = eqx;
      return locala;
    }
    finally {}
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.as.a.a.c paramc)
  {
    if ((paramImageView == null) || (paramc == null)) {
      y.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
    }
    label80:
    label88:
    do
    {
      return;
      int i;
      Resources localResources;
      if ((paramc.eru > 0) || (paramc.erv != null))
      {
        i = 1;
        if (i == 0) {
          continue;
        }
        if (paramc.eru != 0) {
          break label88;
        }
        localResources = this.eqv.eqO;
        if (paramc.eru == 0) {
          break label80;
        }
      }
      for (paramc = localResources.getDrawable(paramc.eru);; paramc = paramc.erv)
      {
        paramImageView.setImageDrawable(paramc);
        return;
        i = 0;
        break;
      }
      paramImageView.setImageResource(paramc.eru);
      return;
    } while (!paramc.erC);
    paramImageView.setImageDrawable(null);
  }
  
  private void a(com.tencent.mm.as.a.a.b paramb)
  {
    if (paramb == null) {
      try
      {
        throw new IllegalArgumentException("[cpan] image loader configuration is null.");
      }
      finally {}
    }
    if (this.eqv == null)
    {
      this.equ = new b(paramb);
      this.eqv = paramb;
    }
    for (;;)
    {
      return;
      y.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
    }
  }
  
  private void a(String paramString, ImageView paramImageView, com.tencent.mm.as.a.a.c paramc, i parami, g paramg, e parame, com.tencent.mm.as.a.c.d paramd, l paraml)
  {
    if (paramc == null) {
      paramc = this.eqv.eqR;
    }
    for (;;)
    {
      if (parami == null) {
        parami = this.eqw;
      }
      for (;;)
      {
        c localc = new c(paramImageView, paramString);
        if ((paramImageView == null) || (paramc == null))
        {
          y.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
          if (!bk.bl(paramString)) {
            break label192;
          }
          y.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
          a(paramImageView, paramc);
          this.equ.a(localc);
          parami.a(paramString, paramImageView, null, paramc.erJ);
        }
        label164:
        label173:
        label184:
        label698:
        for (;;)
        {
          return;
          int i;
          if ((paramc.ery > 0) || (paramc.erz != null))
          {
            i = 1;
            label110:
            if (i == 0) {
              break label184;
            }
            if (paramc.ery != 0) {
              break label173;
            }
            localObject = this.eqv.eqO;
            if (paramc.ery == 0) {
              break label164;
            }
          }
          for (Object localObject = ((Resources)localObject).getDrawable(paramc.ery);; localObject = paramc.erz)
          {
            paramImageView.setBackgroundDrawable((Drawable)localObject);
            break;
            i = 0;
            break label110;
          }
          paramImageView.setBackgroundResource(paramc.ery);
          break;
          paramImageView.setBackgroundDrawable(null);
          break;
          label192:
          localObject = paramc.handler;
          if ((localObject == null) || (Looper.myLooper() == Looper.getMainLooper())) {
            localObject = new ah();
          }
          paramd = new com.tencent.mm.as.a.f.b(paramString, localc, (ah)localObject, paramc, parami, this.equ, paramg, parame, paramd, paraml);
          parami = paramd.mx(paramString);
          parame = this.equ.mr(parami);
          if ((parame != null) && (!parame.isRecycled()))
          {
            y.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", new Object[] { parami });
            parami = parame;
            if (paramc.erp) {
              parami = com.tencent.mm.sdk.platformtools.c.f(parame, paramc.erq);
            }
            if (paramImageView != null) {
              paramImageView.setImageBitmap(parami);
            }
            paramd.cc(0L);
            if (paramg != null) {
              paramg.b(paramString, paramImageView, new com.tencent.mm.as.a.d.b(parami));
            }
            this.equ.a(localc);
            return;
          }
          if (paramImageView != null) {
            a(paramImageView, paramc);
          }
          if ((paramd.eqR.erg) || (!this.equ.eqz.uf()))
          {
            paramImageView = this.equ;
            if (!bk.bl(paramString))
            {
              parami = (String)paramImageView.eqB.get(Integer.valueOf(localc.eqE));
              if ((bk.bl(parami)) || (!paramString.equals(parami))) {
                paramImageView.eqB.put(Integer.valueOf(localc.eqE), paramString);
              }
            }
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label698;
              }
              paramString = this.equ;
              if ((paramString.eqC != null) && (paramd.erR != null))
              {
                paramImageView = (com.tencent.mm.as.a.f.b)paramString.eqC.get(Integer.valueOf(paramd.erR.eqE));
                if ((paramImageView != null) && (paramImageView.erR != null) && (paramd.erR.eqE == paramImageView.erR.eqE))
                {
                  paramString.eqz.remove(paramImageView);
                  y.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", new Object[] { paramImageView.url });
                }
                paramString.eqC.put(Integer.valueOf(paramd.erR.eqE), paramd);
              }
              paramString = this.equ;
              boolean bool = paramc.ere;
              if (((ExecutorService)paramString.eqy.eqZ).isShutdown()) {
                paramString.eqz = com.tencent.mm.as.a.a.a.bm(paramString.eqy.eqP, paramString.eqy.eqQ);
              }
              paramString.eqz.execute(paramd);
              if ((!bool) || (!com.tencent.mm.as.a.g.b.OZ())) {
                break;
              }
              paramString.eqA.execute(new com.tencent.mm.as.a.f.d());
              return;
            }
          }
        }
      }
    }
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    a(paramString, paramImageView, null, null, null, null, null, null);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.as.a.a.c paramc)
  {
    a(paramString, paramImageView, paramc, null, null, null, null, null);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.as.a.a.c paramc, e parame, com.tencent.mm.as.a.c.d paramd, l paraml)
  {
    a(paramString, paramImageView, paramc, null, null, parame, paramd, paraml);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.as.a.a.c paramc, g paramg)
  {
    a(paramString, paramImageView, paramc, null, paramg, null, null, null);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.as.a.a.c paramc, i parami)
  {
    a(paramString, paramImageView, paramc, parami, null, null, null, null);
  }
  
  public final void a(String paramString, ImageView paramImageView, com.tencent.mm.as.a.a.c paramc, i parami, g paramg)
  {
    a(paramString, paramImageView, paramc, parami, paramg, null, null, null);
  }
  
  public final void a(String paramString, ImageView paramImageView, g paramg)
  {
    a(paramString, paramImageView, null, null, paramg, null, null, null);
  }
  
  public final void a(String paramString, com.tencent.mm.as.a.a.c paramc, com.tencent.mm.as.a.c.c paramc1)
  {
    paramString = new com.tencent.mm.as.a.f.a(paramString, paramc, this.equ, paramc1);
    this.equ.eqz.execute(paramString);
  }
  
  public final void b(String paramString, ImageView paramImageView)
  {
    paramString = new c(paramImageView, paramString);
    this.equ.a(paramString);
  }
  
  public final void bR(int paramInt)
  {
    y.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1))
    {
      y.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
      this.equ.eqz.resume();
      return;
    }
    y.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
    this.equ.eqz.pause();
  }
  
  public final void detach()
  {
    if (this.equ != null)
    {
      b localb = this.equ;
      if (localb.eqy != null)
      {
        localb.eqy.eqS.clear();
        localb.eqy.eqT.OW();
      }
    }
  }
  
  public final void i(String paramString, Bitmap paramBitmap)
  {
    if (this.equ != null)
    {
      b localb = this.equ;
      if (localb.eqy != null) {
        localb.eqy.eqS.c(paramString, paramBitmap);
      }
    }
  }
  
  public final Bitmap mr(String paramString)
  {
    if (this.equ != null) {
      return this.equ.mr(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.as.a.a
 * JD-Core Version:    0.7.0.1
 */