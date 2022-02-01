package com.tencent.mm.plugin.game.e;

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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;

public class e
{
  private static final String xZe;
  private static e xZf;
  private f<String, Bitmap> xOc;
  private f<String, Bitmap> xUC;
  private ColorDrawable xZg;
  private Bitmap xZh;
  private Bitmap xZi;
  
  static
  {
    AppMethodBeat.i(42557);
    xZe = com.tencent.mm.plugin.game.commlib.util.b.c(b.a.xvH) + "image/";
    AppMethodBeat.o(42557);
  }
  
  private e()
  {
    AppMethodBeat.i(42540);
    this.xOc = new com.tencent.mm.memory.a.b(6, getClass());
    this.xUC = new com.tencent.mm.memory.a.b(15, getClass());
    this.xZg = new ColorDrawable(android.support.v4.content.b.n(MMApplicationContext.getContext(), 2131100506));
    try
    {
      this.xZh = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      if ((this.xZh != null) && (!this.xZh.isRecycled())) {
        this.xZi = BitmapUtil.getRoundedCornerBitmap(this.xZh, false, 0.5F * this.xZh.getWidth());
      }
      com.tencent.mm.plugin.r.a.eAS().add(new MStorage.IOnStorageChange()
      {
        public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
        {
          AppMethodBeat.i(42530);
          if (e.a(e.this).check(paramAnonymousString))
          {
            paramAnonymousMStorageEventData = com.tencent.mm.pluginsdk.model.app.h.c(paramAnonymousString, 1, com.tencent.mm.cb.a.getDensity(null));
            e.a(e.this).x(paramAnonymousString, paramAnonymousMStorageEventData);
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
        Log.i("MicroMsg.GameImageUtil", localException.getMessage());
      }
    }
  }
  
  private void a(ImageView paramImageView, a parama)
  {
    AppMethodBeat.i(42547);
    if ((paramImageView != null) && (parama.xZu))
    {
      if (parama.hZB == 0)
      {
        paramImageView.setImageDrawable(this.xZg);
        AppMethodBeat.o(42547);
        return;
      }
      paramImageView.setImageResource(parama.hZB);
    }
    AppMethodBeat.o(42547);
  }
  
  private void a(final String paramString, final int paramInt1, final int paramInt2, final b paramb)
  {
    AppMethodBeat.i(42550);
    Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.xUC.aT(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.a(null, localBitmap);
      AppMethodBeat.o(42550);
      return;
    }
    c(null, paramString, new e.a.a().dWS(), new b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(42536);
        Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
        {
          Bitmap localBitmap = e.e(paramAnonymousBitmap, paramInt1, paramInt2);
          Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
          paramAnonymousBitmap = localBitmap;
          if (this.xZr != 0) {
            paramAnonymousBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, this.xZr);
          }
          e.b(e.this).x(paramString, paramAnonymousBitmap);
          if (paramb != null) {
            paramb.a(paramAnonymousView, paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(42536);
      }
    });
    AppMethodBeat.o(42550);
  }
  
  private static boolean aAO(String paramString)
  {
    AppMethodBeat.i(42554);
    o localo1 = new o(paramString);
    if (!localo1.exists())
    {
      o localo2;
      if (!localo1.heq().exists())
      {
        localo2 = localo1.heq();
        o localo3 = new o(aa.z(localo2.her()) + System.currentTimeMillis());
        if (localo3.mkdirs()) {
          localo3.am(localo2);
        }
      }
      else
      {
        if ((localo1.mkdirs()) && (localo1.isDirectory())) {
          break label149;
        }
        Log.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { paramString });
        AppMethodBeat.o(42554);
        return false;
      }
      Log.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { aa.z(localo2.her()) });
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
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42534);
              e.3.this.rCk.setImageBitmap(paramAnonymousBitmap);
              ViewGroup.LayoutParams localLayoutParams = e.3.this.rCk.getLayoutParams();
              float f = e.3.this.val$height / e.3.this.val$width;
              localLayoutParams.width = e.3.this.xZo;
              localLayoutParams.height = ((int)(f * e.3.this.xZo));
              e.3.this.rCk.setLayoutParams(localLayoutParams);
              e.3.this.rCk.setScaleType(ImageView.ScaleType.FIT_XY);
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
    if ((!parama.jbd) || (parama.xZv))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    if (!this.xUC.check(paramString))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    paramString = (Bitmap)this.xUC.aT(paramString);
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
  
  private void c(final ImageView paramImageView, String paramString, final a parama, final b paramb)
  {
    AppMethodBeat.i(42546);
    Object localObject = new c.a();
    boolean bool;
    String str;
    if (!parama.xZv)
    {
      bool = true;
      ((c.a)localObject).jbd = bool;
      aAO(xZe);
      str = xZe + g.getMessageDigest(paramString.getBytes());
      ((c.a)localObject).jbf = parama.jbf;
      if (parama.xZv) {
        break label153;
      }
      ((c.a)localObject).fullPath = str;
    }
    for (;;)
    {
      ((c.a)localObject).iaT = parama.iaT;
      ((c.a)localObject).hZF = false;
      a(paramImageView, parama);
      localObject = ((c.a)localObject).bdv();
      q.bcV().a(paramString, null, (com.tencent.mm.av.a.a.c)localObject, new com.tencent.mm.av.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView)
        {
          AppMethodBeat.i(42532);
          Log.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(42532);
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, final com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42533);
          Log.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(paramAnonymousString)));
          if ((paramAnonymousb != null) && (paramAnonymousb.bitmap != null))
          {
            Object localObject = paramAnonymousb.bitmap;
            paramAnonymousb = (com.tencent.mm.av.a.d.b)localObject;
            if (parama.xZt) {
              paramAnonymousb = e.af((Bitmap)localObject);
            }
            localObject = paramAnonymousb;
            if (parama.ofi != 0) {
              localObject = BitmapUtil.getRoundedCornerBitmap(paramAnonymousb, false, parama.ofi);
            }
            paramAnonymousb = (com.tencent.mm.av.a.d.b)localObject;
            if (parama.xZw > 0.0F) {
              paramAnonymousb = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * parama.xZw);
            }
            if (parama.jbd) {
              e.b(e.this).x(paramAnonymousString, paramAnonymousb);
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42531);
                if (e.2.this.iaq != null) {
                  e.2.this.iaq.setImageBitmap(paramAnonymousb);
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
      ((c.a)localObject).jbf = false;
      com.tencent.mm.pluginsdk.j.a.d.a.bej(str);
    }
  }
  
  private static Bitmap d(Bitmap paramBitmap, int paramInt1, int paramInt2)
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
        Log.i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
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
  
  public static e dWR()
  {
    AppMethodBeat.i(42539);
    if (xZf == null) {}
    try
    {
      if (xZf == null) {
        xZf = new e();
      }
      e locale = xZf;
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
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(42544);
      return;
    }
    a locala = parama;
    if (parama == null) {
      locala = new e.a.a().dWS();
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
    if ((paramImageView == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(42553);
      return;
    }
    if (this.xOc.check(paramString))
    {
      localBitmap = (Bitmap)this.xOc.aT(paramString);
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
      this.xOc.put(paramString, localBitmap);
      AppMethodBeat.o(42553);
      return;
    }
    paramImageView.setImageResource(2131232887);
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.r.a.eAS().add(new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
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
            com.tencent.mm.plugin.r.a.eAS().remove(this);
          }
        }
        AppMethodBeat.o(42537);
      }
    });
    AppMethodBeat.o(42553);
  }
  
  public final void o(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42541);
    a(paramImageView, paramString, null, null);
    AppMethodBeat.o(42541);
  }
  
  public final void p(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42543);
    e.a.a locala = new e.a.a();
    locala.iaT = true;
    a(paramImageView, paramString, locala.dWS(), null);
    AppMethodBeat.o(42543);
  }
  
  public final Bitmap q(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42552);
    paramString = com.tencent.mm.aj.c.a(paramString, false, -1, null);
    if (((paramString != null) && (!paramString.isRecycled())) || ((this.xZh == null) || (this.xZh.isRecycled()))) {}
    try
    {
      this.xZh = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      label64:
      if ((this.xZh != null) && (!this.xZh.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.xZh);
      }
      paramImageView = this.xZh;
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
    final int hZB;
    final boolean iaT;
    final boolean jbd;
    final boolean jbf;
    final int ofi;
    final boolean xZt;
    final boolean xZu;
    final boolean xZv;
    final float xZw;
    
    private a(a parama)
    {
      this.jbd = parama.jbd;
      this.jbf = parama.jbf;
      this.iaT = parama.iaT;
      this.xZt = parama.xZt;
      this.xZu = parama.xZu;
      this.xZv = parama.xZv;
      this.hZB = parama.hZB;
      this.ofi = parama.ofi;
      this.xZw = parama.xZw;
    }
    
    public static final class a
    {
      public int hZB = 0;
      public boolean iaT = false;
      public boolean jbd = true;
      public boolean jbf = true;
      int ofi = 0;
      public boolean xZt = false;
      boolean xZu = true;
      boolean xZv = false;
      public float xZw = 0.0F;
      
      public final e.a dWS()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.e.e
 * JD-Core Version:    0.7.0.1
 */