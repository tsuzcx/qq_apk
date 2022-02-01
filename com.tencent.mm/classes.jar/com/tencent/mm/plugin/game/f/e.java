package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.lang.ref.WeakReference;

public class e
{
  private static final String uGS;
  private static e uGT;
  private f<String, Bitmap> uCE;
  private ColorDrawable uGU;
  private Bitmap uGV;
  private Bitmap uGW;
  private f<String, Bitmap> uwb;
  
  static
  {
    AppMethodBeat.i(42557);
    uGS = com.tencent.mm.plugin.game.commlib.util.b.c(b.a.udV) + "image/";
    AppMethodBeat.o(42557);
  }
  
  private e()
  {
    AppMethodBeat.i(42540);
    this.uwb = new com.tencent.mm.memory.a.b(6, getClass());
    this.uCE = new com.tencent.mm.memory.a.b(15, getClass());
    this.uGU = new ColorDrawable(android.support.v4.content.b.n(ak.getContext(), 2131100404));
    try
    {
      this.uGV = BackwardSupportUtil.b.b(ak.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      if ((this.uGV != null) && (!this.uGV.isRecycled())) {
        this.uGW = com.tencent.mm.sdk.platformtools.h.a(this.uGV, false, 0.5F * this.uGV.getWidth());
      }
      com.tencent.mm.plugin.s.a.dBg().add(new k.a()
      {
        public final void a(String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(42530);
          if (e.a(e.this).aM(paramAnonymousString))
          {
            paramAnonymousm = com.tencent.mm.pluginsdk.model.app.h.c(paramAnonymousString, 1, com.tencent.mm.cb.a.getDensity(null));
            e.a(e.this).q(paramAnonymousString, paramAnonymousm);
          }
          AppMethodBeat.o(42530);
        }
      });
      AppMethodBeat.o(42540);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.i("MicroMsg.GameImageUtil", localException.getMessage());
      }
    }
  }
  
  private void a(ImageView paramImageView, a parama)
  {
    AppMethodBeat.i(42547);
    if ((paramImageView != null) && (parama.uHi))
    {
      if (parama.hgH == 0)
      {
        paramImageView.setImageDrawable(this.uGU);
        AppMethodBeat.o(42547);
        return;
      }
      paramImageView.setImageResource(parama.hgH);
    }
    AppMethodBeat.o(42547);
  }
  
  private void a(final String paramString, final int paramInt1, final int paramInt2, final b paramb)
  {
    AppMethodBeat.i(42550);
    ae.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.uCE.aL(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.a(null, localBitmap);
      AppMethodBeat.o(42550);
      return;
    }
    c(null, paramString, new e.a.a().ddi(), new b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(42536);
        ae.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          Bitmap localBitmap = e.d(paramAnonymousBitmap, paramInt1, paramInt2);
          ae.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
          paramAnonymousBitmap = localBitmap;
          if (this.uHf != 0) {
            paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.h.a(localBitmap, true, this.uHf);
          }
          e.b(e.this).q(paramString, paramAnonymousBitmap);
          if (paramb != null) {
            paramb.a(paramAnonymousView, paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(42536);
      }
    });
    AppMethodBeat.o(42550);
  }
  
  private static boolean anv(String paramString)
  {
    AppMethodBeat.i(42554);
    k localk1 = new k(paramString);
    if (!localk1.exists())
    {
      k localk2;
      if (!localk1.fTg().exists())
      {
        localk2 = localk1.fTg();
        k localk3 = new k(w.B(localk2.fTh()) + System.currentTimeMillis());
        if (localk3.mkdirs()) {
          localk3.ag(localk2);
        }
      }
      else
      {
        if ((localk1.mkdirs()) && (localk1.isDirectory())) {
          break label149;
        }
        ae.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { paramString });
        AppMethodBeat.o(42554);
        return false;
      }
      ae.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { w.B(localk2.fTh()) });
      AppMethodBeat.o(42554);
      return false;
    }
    label149:
    AppMethodBeat.o(42554);
    return true;
  }
  
  private void b(final ImageView paramImageView, String paramString, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(42549);
    a(paramString, paramInt1, paramInt2, new b()
    {
      public final void a(View paramAnonymousView, final Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(42535);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42534);
              e.3.this.qlp.setImageBitmap(paramAnonymousBitmap);
              ViewGroup.LayoutParams localLayoutParams = e.3.this.qlp.getLayoutParams();
              float f = e.3.this.val$height / e.3.this.val$width;
              localLayoutParams.width = e.3.this.uHc;
              localLayoutParams.height = ((int)(f * e.3.this.uHc));
              e.3.this.qlp.setLayoutParams(localLayoutParams);
              e.3.this.qlp.setScaleType(ImageView.ScaleType.FIT_XY);
              AppMethodBeat.o(42534);
            }
          });
        }
        AppMethodBeat.o(42535);
      }
    });
    AppMethodBeat.o(42549);
  }
  
  private boolean b(ImageView paramImageView, String paramString, a parama, b paramb)
  {
    AppMethodBeat.i(42545);
    if ((!parama.igi) || (parama.uHj))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    if (!this.uCE.aM(paramString))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    paramString = (Bitmap)this.uCE.aL(paramString);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      if (paramImageView != null) {
        paramImageView.setImageBitmap(paramString);
      }
      if (paramb != null) {
        paramb.a(paramImageView, paramString);
      }
      AppMethodBeat.o(42545);
      return true;
    }
    AppMethodBeat.o(42545);
    return false;
  }
  
  private static Bitmap c(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42551);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == paramInt1) && (j == paramInt2))
    {
      AppMethodBeat.o(42551);
      return paramBitmap;
    }
    float f1 = j / paramInt2;
    float f2 = i / paramInt1;
    if (f1 < f2) {}
    for (paramInt2 = (int)(f1 * paramInt1);; paramInt2 = i)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(paramBitmap, (i - paramInt2) / 2, 0, paramInt2, j);
        paramInt1 = j;
        ae.i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(42551);
        return localBitmap;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Bitmap localBitmap;
        AppMethodBeat.o(42551);
      }
      paramInt1 = (int)(paramInt2 * f2);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, (j - paramInt1) / 2, i, paramInt1);
    }
    return paramBitmap;
  }
  
  private void c(final ImageView paramImageView, String paramString, final a parama, final b paramb)
  {
    AppMethodBeat.i(42546);
    Object localObject = new c.a();
    boolean bool;
    String str;
    if (!parama.uHj)
    {
      bool = true;
      ((c.a)localObject).igi = bool;
      anv(uGS);
      str = uGS + g.getMessageDigest(paramString.getBytes());
      ((c.a)localObject).igk = parama.igk;
      if (parama.uHj) {
        break label153;
      }
      ((c.a)localObject).hgD = str;
    }
    for (;;)
    {
      ((c.a)localObject).hhW = parama.hhW;
      ((c.a)localObject).hgL = false;
      a(paramImageView, parama);
      localObject = ((c.a)localObject).aJu();
      q.aJb().a(paramString, null, (com.tencent.mm.av.a.a.c)localObject, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView)
        {
          AppMethodBeat.i(42532);
          ae.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(42532);
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, final com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42533);
          ae.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(paramAnonymousString)));
          if ((paramAnonymousb != null) && (paramAnonymousb.bitmap != null))
          {
            Object localObject = paramAnonymousb.bitmap;
            paramAnonymousb = (com.tencent.mm.av.a.d.b)localObject;
            if (parama.uHh) {
              paramAnonymousb = e.Z((Bitmap)localObject);
            }
            localObject = paramAnonymousb;
            if (parama.mSe != 0) {
              localObject = com.tencent.mm.sdk.platformtools.h.a(paramAnonymousb, false, parama.mSe);
            }
            paramAnonymousb = (com.tencent.mm.av.a.d.b)localObject;
            if (parama.uHk > 0.0F) {
              paramAnonymousb = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * parama.uHk);
            }
            if (parama.igi) {
              e.b(e.this).q(paramAnonymousString, paramAnonymousb);
            }
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42531);
                if (e.2.this.tCz != null) {
                  e.2.this.tCz.setImageBitmap(paramAnonymousb);
                }
                AppMethodBeat.o(42531);
              }
            });
            if (paramb != null) {
              paramb.a(paramAnonymousView, paramAnonymousb);
            }
          }
          AppMethodBeat.o(42533);
        }
      });
      AppMethodBeat.o(42546);
      return;
      bool = false;
      break;
      label153:
      ((c.a)localObject).igk = false;
      com.tencent.mm.pluginsdk.j.a.d.a.aNH(str);
    }
  }
  
  public static e ddh()
  {
    AppMethodBeat.i(42539);
    if (uGT == null) {}
    try
    {
      if (uGT == null) {
        uGT = new e();
      }
      e locale = uGT;
      AppMethodBeat.o(42539);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(42539);
    }
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(42548);
    b(paramImageView, paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(42548);
  }
  
  public final void a(ImageView paramImageView, String paramString, a parama)
  {
    AppMethodBeat.i(42542);
    a(paramImageView, paramString, parama, null);
    AppMethodBeat.o(42542);
  }
  
  public final void a(ImageView paramImageView, String paramString, a parama, b paramb)
  {
    AppMethodBeat.i(42544);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42544);
      return;
    }
    a locala = parama;
    if (parama == null) {
      locala = new e.a.a().ddi();
    }
    if (b(paramImageView, paramString, locala, paramb))
    {
      AppMethodBeat.o(42544);
      return;
    }
    c(paramImageView, paramString, locala, paramb);
    AppMethodBeat.o(42544);
  }
  
  public final void c(final ImageView paramImageView, final String paramString, final float paramFloat)
  {
    AppMethodBeat.i(42553);
    if ((paramImageView == null) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(42553);
      return;
    }
    if (this.uwb.aM(paramString))
    {
      localBitmap = (Bitmap)this.uwb.aL(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(42553);
        return;
      }
    }
    Bitmap localBitmap = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 1, paramFloat);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramImageView.setImageBitmap(localBitmap);
      this.uwb.put(paramString, localBitmap);
      AppMethodBeat.o(42553);
      return;
    }
    paramImageView.setImageResource(2131232498);
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.s.a.dBg().add(new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(42537);
        if (paramString.equals(paramAnonymousString))
        {
          paramAnonymousString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 1, paramFloat);
          if (paramAnonymousString != null)
          {
            if ((paramImageView != null) && (paramImageView.get() != null)) {
              ((ImageView)paramImageView.get()).setImageBitmap(paramAnonymousString);
            }
            e.a(e.this).put(paramString, paramAnonymousString);
            com.tencent.mm.plugin.s.a.dBg().remove(this);
          }
        }
        AppMethodBeat.o(42537);
      }
    });
    AppMethodBeat.o(42553);
  }
  
  public final void l(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42541);
    a(paramImageView, paramString, null, null);
    AppMethodBeat.o(42541);
  }
  
  public final void m(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42543);
    e.a.a locala = new e.a.a();
    locala.hhW = true;
    a(paramImageView, paramString, locala.ddi(), null);
    AppMethodBeat.o(42543);
  }
  
  public final Bitmap n(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42552);
    paramString = com.tencent.mm.aj.c.a(paramString, false, -1, null);
    if (((paramString != null) && (!paramString.isRecycled())) || ((this.uGV == null) || (this.uGV.isRecycled()))) {}
    try
    {
      this.uGV = BackwardSupportUtil.b.b(ak.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      label64:
      if ((this.uGV != null) && (!this.uGV.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.uGV);
      }
      paramImageView = this.uGV;
      AppMethodBeat.o(42552);
      return paramImageView;
      if (paramImageView != null) {
        paramImageView.setImageBitmap(paramString);
      }
      AppMethodBeat.o(42552);
      return paramString;
    }
    catch (Exception paramString)
    {
      break label64;
    }
  }
  
  public static final class a
  {
    final int hgH;
    final boolean hhW;
    final boolean igi;
    final boolean igk;
    final int mSe;
    final boolean uHh;
    final boolean uHi;
    final boolean uHj;
    final float uHk;
    
    private a(a parama)
    {
      this.igi = parama.igi;
      this.igk = parama.igk;
      this.hhW = parama.hhW;
      this.uHh = parama.uHh;
      this.uHi = parama.uHi;
      this.uHj = parama.uHj;
      this.hgH = parama.hgH;
      this.mSe = parama.mSe;
      this.uHk = parama.uHk;
    }
    
    public static final class a
    {
      public int hgH = 0;
      public boolean hhW = false;
      public boolean igi = true;
      public boolean igk = true;
      int mSe = 0;
      public boolean uHh = false;
      boolean uHi = true;
      boolean uHj = false;
      public float uHk = 0.0F;
      
      public final e.a ddi()
      {
        AppMethodBeat.i(42538);
        e.a locala = new e.a(this, (byte)0);
        AppMethodBeat.o(42538);
        return locala;
      }
    }
  }
  
  public static abstract class b
  {
    public abstract void a(View paramView, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e
 * JD-Core Version:    0.7.0.1
 */