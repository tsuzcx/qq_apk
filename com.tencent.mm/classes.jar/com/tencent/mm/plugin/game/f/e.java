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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public class e
{
  private static final String uvt;
  private static e uvu;
  private f<String, Bitmap> ukE;
  private f<String, Bitmap> urk;
  private ColorDrawable uvv;
  private Bitmap uvw;
  private Bitmap uvx;
  
  static
  {
    AppMethodBeat.i(42557);
    uvt = com.tencent.mm.plugin.game.commlib.util.b.c(b.a.tTe) + "image/";
    AppMethodBeat.o(42557);
  }
  
  private e()
  {
    AppMethodBeat.i(42540);
    this.ukE = new com.tencent.mm.memory.a.b(6, getClass());
    this.urk = new com.tencent.mm.memory.a.b(15, getClass());
    this.uvv = new ColorDrawable(android.support.v4.content.b.n(aj.getContext(), 2131100404));
    try
    {
      this.uvw = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
      if ((this.uvw != null) && (!this.uvw.isRecycled())) {
        this.uvx = com.tencent.mm.sdk.platformtools.g.a(this.uvw, false, 0.5F * this.uvw.getWidth());
      }
      com.tencent.mm.plugin.s.a.dxQ().add(new k.a()
      {
        public final void a(String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(42530);
          if (e.a(e.this).aM(paramAnonymousString))
          {
            paramAnonymousm = com.tencent.mm.pluginsdk.model.app.h.c(paramAnonymousString, 1, com.tencent.mm.cc.a.getDensity(null));
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
        ad.i("MicroMsg.GameImageUtil", localException.getMessage());
      }
    }
  }
  
  private void a(ImageView paramImageView, a parama)
  {
    AppMethodBeat.i(42547);
    if ((paramImageView != null) && (parama.uvJ))
    {
      if (parama.hdT == 0)
      {
        paramImageView.setImageDrawable(this.uvv);
        AppMethodBeat.o(42547);
        return;
      }
      paramImageView.setImageResource(parama.hdT);
    }
    AppMethodBeat.o(42547);
  }
  
  private void a(final String paramString, final int paramInt1, final int paramInt2, final b paramb)
  {
    AppMethodBeat.i(42550);
    ad.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.urk.aL(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.a(null, localBitmap);
      AppMethodBeat.o(42550);
      return;
    }
    c(null, paramString, new e.a.a().daw(), new b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(42536);
        ad.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          Bitmap localBitmap = e.d(paramAnonymousBitmap, paramInt1, paramInt2);
          ad.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
          paramAnonymousBitmap = localBitmap;
          if (this.uvG != 0) {
            paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.g.a(localBitmap, true, this.uvG);
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
  
  private static boolean amx(String paramString)
  {
    AppMethodBeat.i(42554);
    com.tencent.mm.vfs.e locale1 = new com.tencent.mm.vfs.e(paramString);
    if (!locale1.exists())
    {
      com.tencent.mm.vfs.e locale2;
      if (!locale1.fOJ().exists())
      {
        locale2 = locale1.fOJ();
        com.tencent.mm.vfs.e locale3 = new com.tencent.mm.vfs.e(com.tencent.mm.vfs.q.B(locale2.fOK()) + System.currentTimeMillis());
        if (locale3.mkdirs()) {
          locale3.ag(locale2);
        }
      }
      else
      {
        if ((locale1.mkdirs()) && (locale1.isDirectory())) {
          break label149;
        }
        ad.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { paramString });
        AppMethodBeat.o(42554);
        return false;
      }
      ad.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { com.tencent.mm.vfs.q.B(locale2.fOK()) });
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
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42534);
              e.3.this.qeK.setImageBitmap(paramAnonymousBitmap);
              ViewGroup.LayoutParams localLayoutParams = e.3.this.qeK.getLayoutParams();
              float f = e.3.this.val$height / e.3.this.val$width;
              localLayoutParams.width = e.3.this.uvD;
              localLayoutParams.height = ((int)(f * e.3.this.uvD));
              e.3.this.qeK.setLayoutParams(localLayoutParams);
              e.3.this.qeK.setScaleType(ImageView.ScaleType.FIT_XY);
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
    if ((!parama.idp) || (parama.uvK))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    if (!this.urk.aM(paramString))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    paramString = (Bitmap)this.urk.aL(paramString);
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
        ad.i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
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
    if (!parama.uvK)
    {
      bool = true;
      ((c.a)localObject).idp = bool;
      amx(uvt);
      str = uvt + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      ((c.a)localObject).idr = parama.idr;
      if (parama.uvK) {
        break label153;
      }
      ((c.a)localObject).hdP = str;
    }
    for (;;)
    {
      ((c.a)localObject).hfi = parama.hfi;
      ((c.a)localObject).hdX = false;
      a(paramImageView, parama);
      localObject = ((c.a)localObject).aJc();
      com.tencent.mm.aw.q.aIJ().a(paramString, null, (com.tencent.mm.aw.a.a.c)localObject, new com.tencent.mm.aw.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView)
        {
          AppMethodBeat.i(42532);
          ad.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(42532);
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, final com.tencent.mm.aw.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42533);
          ad.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(paramAnonymousString)));
          if ((paramAnonymousb != null) && (paramAnonymousb.bitmap != null))
          {
            Object localObject = paramAnonymousb.bitmap;
            paramAnonymousb = (com.tencent.mm.aw.a.d.b)localObject;
            if (parama.uvI) {
              paramAnonymousb = e.Y((Bitmap)localObject);
            }
            localObject = paramAnonymousb;
            if (parama.mNb != 0) {
              localObject = com.tencent.mm.sdk.platformtools.g.a(paramAnonymousb, false, parama.mNb);
            }
            paramAnonymousb = (com.tencent.mm.aw.a.d.b)localObject;
            if (parama.uvL > 0.0F) {
              paramAnonymousb = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * parama.uvL);
            }
            if (parama.idp) {
              e.b(e.this).q(paramAnonymousString, paramAnonymousb);
            }
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42531);
                if (e.2.this.trI != null) {
                  e.2.this.trI.setImageBitmap(paramAnonymousb);
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
      ((c.a)localObject).idr = false;
      com.tencent.mm.pluginsdk.j.a.d.a.aMl(str);
    }
  }
  
  public static e dav()
  {
    AppMethodBeat.i(42539);
    if (uvu == null) {}
    try
    {
      if (uvu == null) {
        uvu = new e();
      }
      e locale = uvu;
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
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42544);
      return;
    }
    a locala = parama;
    if (parama == null) {
      locala = new e.a.a().daw();
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
    if ((paramImageView == null) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(42553);
      return;
    }
    if (this.ukE.aM(paramString))
    {
      localBitmap = (Bitmap)this.ukE.aL(paramString);
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
      this.ukE.put(paramString, localBitmap);
      AppMethodBeat.o(42553);
      return;
    }
    paramImageView.setImageResource(2131232498);
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.s.a.dxQ().add(new k.a()
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
            com.tencent.mm.plugin.s.a.dxQ().remove(this);
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
    locala.hfi = true;
    a(paramImageView, paramString, locala.daw(), null);
    AppMethodBeat.o(42543);
  }
  
  public final Bitmap n(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42552);
    paramString = com.tencent.mm.ak.c.a(paramString, false, -1, null);
    if (((paramString != null) && (!paramString.isRecycled())) || ((this.uvw == null) || (this.uvw.isRecycled()))) {}
    try
    {
      this.uvw = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
      label64:
      if ((this.uvw != null) && (!this.uvw.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.uvw);
      }
      paramImageView = this.uvw;
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
    final int hdT;
    final boolean hfi;
    final boolean idp;
    final boolean idr;
    final int mNb;
    final boolean uvI;
    final boolean uvJ;
    final boolean uvK;
    final float uvL;
    
    private a(a parama)
    {
      this.idp = parama.idp;
      this.idr = parama.idr;
      this.hfi = parama.hfi;
      this.uvI = parama.uvI;
      this.uvJ = parama.uvJ;
      this.uvK = parama.uvK;
      this.hdT = parama.hdT;
      this.mNb = parama.mNb;
      this.uvL = parama.uvL;
    }
    
    public static final class a
    {
      public int hdT = 0;
      public boolean hfi = false;
      public boolean idp = true;
      public boolean idr = true;
      int mNb = 0;
      public boolean uvI = false;
      boolean uvJ = true;
      boolean uvK = false;
      public float uvL = 0.0F;
      
      public final e.a daw()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e
 * JD-Core Version:    0.7.0.1
 */