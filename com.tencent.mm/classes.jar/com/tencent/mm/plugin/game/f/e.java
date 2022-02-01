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
import com.tencent.mm.av.o;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.game.commlib.e.b.a;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.lang.ref.WeakReference;

public class e
{
  private static final String twh;
  private static e twi;
  private com.tencent.mm.b.f<String, Bitmap> tmf;
  private com.tencent.mm.b.f<String, Bitmap> tsM;
  private ColorDrawable twj;
  private Bitmap twk;
  private Bitmap twl;
  
  static
  {
    AppMethodBeat.i(42557);
    twh = com.tencent.mm.plugin.game.commlib.e.b.b(b.a.sWw) + "image/";
    AppMethodBeat.o(42557);
  }
  
  private e()
  {
    AppMethodBeat.i(42540);
    this.tmf = new com.tencent.mm.memory.a.b(6, getClass());
    this.tsM = new com.tencent.mm.memory.a.b(15, getClass());
    this.twj = new ColorDrawable(android.support.v4.content.b.n(ai.getContext(), 2131100404));
    try
    {
      this.twk = BackwardSupportUtil.b.b(ai.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
      if ((this.twk != null) && (!this.twk.isRecycled())) {
        this.twl = com.tencent.mm.sdk.platformtools.f.a(this.twk, false, 0.5F * this.twk.getWidth());
      }
      com.tencent.mm.plugin.s.a.dny().add(new k.a()
      {
        public final void a(String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(42530);
          if (e.a(e.this).aK(paramAnonymousString))
          {
            paramAnonymousm = com.tencent.mm.pluginsdk.model.app.h.c(paramAnonymousString, 1, com.tencent.mm.cc.a.getDensity(null));
            e.a(e.this).o(paramAnonymousString, paramAnonymousm);
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
        ac.i("MicroMsg.GameImageUtil", localException.getMessage());
      }
    }
  }
  
  private void a(ImageView paramImageView, a parama)
  {
    AppMethodBeat.i(42547);
    if ((paramImageView != null) && (parama.twx))
    {
      if (parama.gKi == 0)
      {
        paramImageView.setImageDrawable(this.twj);
        AppMethodBeat.o(42547);
        return;
      }
      paramImageView.setImageResource(parama.gKi);
    }
    AppMethodBeat.o(42547);
  }
  
  private void a(final String paramString, final int paramInt1, final int paramInt2, final b paramb)
  {
    AppMethodBeat.i(42550);
    ac.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.tsM.aJ(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.a(null, localBitmap);
      AppMethodBeat.o(42550);
      return;
    }
    c(null, paramString, new e.a.a().cRM(), new b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(42536);
        ac.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          Bitmap localBitmap = e.d(paramAnonymousBitmap, paramInt1, paramInt2);
          ac.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
          paramAnonymousBitmap = localBitmap;
          if (this.twu != 0) {
            paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.f.a(localBitmap, true, this.twu);
          }
          e.b(e.this).o(paramString, paramAnonymousBitmap);
          if (paramb != null) {
            paramb.a(paramAnonymousView, paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(42536);
      }
    });
    AppMethodBeat.o(42550);
  }
  
  private static boolean ahU(String paramString)
  {
    AppMethodBeat.i(42554);
    com.tencent.mm.vfs.e locale1 = new com.tencent.mm.vfs.e(paramString);
    if (!locale1.exists())
    {
      com.tencent.mm.vfs.e locale2;
      if (!locale1.fxU().exists())
      {
        locale2 = locale1.fxU();
        com.tencent.mm.vfs.e locale3 = new com.tencent.mm.vfs.e(q.B(locale2.fxV()) + System.currentTimeMillis());
        if (locale3.mkdirs()) {
          locale3.ae(locale2);
        }
      }
      else
      {
        if ((locale1.mkdirs()) && (locale1.isDirectory())) {
          break label149;
        }
        ac.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { paramString });
        AppMethodBeat.o(42554);
        return false;
      }
      ac.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { q.B(locale2.fxV()) });
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
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42534);
              e.3.this.pBf.setImageBitmap(paramAnonymousBitmap);
              ViewGroup.LayoutParams localLayoutParams = e.3.this.pBf.getLayoutParams();
              float f = e.3.this.val$height / e.3.this.val$width;
              localLayoutParams.width = e.3.this.twr;
              localLayoutParams.height = ((int)(f * e.3.this.twr));
              e.3.this.pBf.setLayoutParams(localLayoutParams);
              e.3.this.pBf.setScaleType(ImageView.ScaleType.FIT_XY);
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
    if ((!parama.hKv) || (parama.twy))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    if (!this.tsM.aK(paramString))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    paramString = (Bitmap)this.tsM.aJ(paramString);
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
        ac.i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
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
    if (!parama.twy)
    {
      bool = true;
      ((c.a)localObject).hKv = bool;
      ahU(twh);
      str = twh + g.getMessageDigest(paramString.getBytes());
      ((c.a)localObject).hKx = parama.hKx;
      if (parama.twy) {
        break label153;
      }
      ((c.a)localObject).gKe = str;
    }
    for (;;)
    {
      ((c.a)localObject).gLt = parama.gLt;
      ((c.a)localObject).gKm = false;
      a(paramImageView, parama);
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(paramString, null, (com.tencent.mm.av.a.a.c)localObject, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView)
        {
          AppMethodBeat.i(42532);
          ac.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(42532);
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, final com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42533);
          ac.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(paramAnonymousString)));
          if ((paramAnonymousb != null) && (paramAnonymousb.bitmap != null))
          {
            Object localObject = paramAnonymousb.bitmap;
            paramAnonymousb = (com.tencent.mm.av.a.d.b)localObject;
            if (parama.tww) {
              paramAnonymousb = e.Y((Bitmap)localObject);
            }
            localObject = paramAnonymousb;
            if (parama.mmz != 0) {
              localObject = com.tencent.mm.sdk.platformtools.f.a(paramAnonymousb, false, parama.mmz);
            }
            paramAnonymousb = (com.tencent.mm.av.a.d.b)localObject;
            if (parama.twz > 0.0F) {
              paramAnonymousb = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * parama.twz);
            }
            if (parama.hKv) {
              e.b(e.this).o(paramAnonymousString, paramAnonymousb);
            }
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42531);
                if (e.2.this.svh != null) {
                  e.2.this.svh.setImageBitmap(paramAnonymousb);
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
      ((c.a)localObject).hKx = false;
      com.tencent.mm.pluginsdk.h.a.d.a.aGL(str);
    }
  }
  
  public static e cRL()
  {
    AppMethodBeat.i(42539);
    if (twi == null) {}
    try
    {
      if (twi == null) {
        twi = new e();
      }
      e locale = twi;
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
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42544);
      return;
    }
    a locala = parama;
    if (parama == null) {
      locala = new e.a.a().cRM();
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
    if ((paramImageView == null) || (bs.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(42553);
      return;
    }
    if (this.tmf.aK(paramString))
    {
      localBitmap = (Bitmap)this.tmf.aJ(paramString);
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
      this.tmf.put(paramString, localBitmap);
      AppMethodBeat.o(42553);
      return;
    }
    paramImageView.setImageResource(2131232498);
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.s.a.dny().add(new k.a()
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
            com.tencent.mm.plugin.s.a.dny().remove(this);
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
    locala.gLt = true;
    a(paramImageView, paramString, locala.cRM(), null);
    AppMethodBeat.o(42543);
  }
  
  public final Bitmap n(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42552);
    paramString = com.tencent.mm.aj.c.a(paramString, false, -1, null);
    if (((paramString != null) && (!paramString.isRecycled())) || ((this.twk == null) || (this.twk.isRecycled()))) {}
    try
    {
      this.twk = BackwardSupportUtil.b.b(ai.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
      label64:
      if ((this.twk != null) && (!this.twk.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.twk);
      }
      paramImageView = this.twk;
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
    final int gKi;
    final boolean gLt;
    final boolean hKv;
    final boolean hKx;
    final int mmz;
    final boolean tww;
    final boolean twx;
    final boolean twy;
    final float twz;
    
    private a(a parama)
    {
      this.hKv = parama.hKv;
      this.hKx = parama.hKx;
      this.gLt = parama.gLt;
      this.tww = parama.tww;
      this.twx = parama.twx;
      this.twy = parama.twy;
      this.gKi = parama.gKi;
      this.mmz = parama.mmz;
      this.twz = parama.twz;
    }
    
    public static final class a
    {
      public int gKi = 0;
      public boolean gLt = false;
      public boolean hKv = true;
      public boolean hKx = true;
      int mmz = 0;
      public boolean tww = false;
      boolean twx = true;
      boolean twy = false;
      public float twz = 0.0F;
      
      public final e.a cRM()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e
 * JD-Core Version:    0.7.0.1
 */