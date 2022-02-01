package com.tencent.mm.plugin.game.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;

public class e
{
  private static final String IYc;
  private static e IYd;
  private f<String, Bitmap> IMC;
  private f<String, Bitmap> ITd;
  private ColorDrawable IYe;
  private Bitmap IYf;
  private Bitmap IYg;
  
  static
  {
    AppMethodBeat.i(42557);
    IYc = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Itn) + "image/";
    AppMethodBeat.o(42557);
  }
  
  private e()
  {
    AppMethodBeat.i(42540);
    this.IMC = new com.tencent.mm.memory.a.b(6, getClass());
    this.ITd = new com.tencent.mm.memory.a.b(15, getClass());
    this.IYe = new ColorDrawable(Color.parseColor("#EFEFF4"));
    try
    {
      this.IYf = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
      if ((this.IYf != null) && (!this.IYf.isRecycled())) {
        this.IYg = BitmapUtil.getRoundedCornerBitmap(this.IYf, false, 0.5F * this.IYf.getWidth());
      }
      com.tencent.mm.plugin.openapi.a.gxn().add(new MStorage.IOnStorageChange()
      {
        public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
        {
          AppMethodBeat.i(42530);
          if (e.a(e.this).check(paramAnonymousString))
          {
            paramAnonymousMStorageEventData = com.tencent.mm.pluginsdk.model.app.h.c(paramAnonymousString, 1, com.tencent.mm.cd.a.getDensity(null));
            e.a(e.this).B(paramAnonymousString, paramAnonymousMStorageEventData);
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
    if ((paramImageView != null) && (parama.IYs))
    {
      if (parama.npW == 0)
      {
        paramImageView.setImageDrawable(this.IYe);
        AppMethodBeat.o(42547);
        return;
      }
      paramImageView.setImageResource(parama.npW);
    }
    AppMethodBeat.o(42547);
  }
  
  private void a(final String paramString, final int paramInt1, final int paramInt2, final b paramb)
  {
    AppMethodBeat.i(42550);
    Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.ITd.ct(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.a(null, localBitmap);
      AppMethodBeat.o(42550);
      return;
    }
    c(null, paramString, new e.a.a().fIc(), new b()
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
          if (this.IYp != 0) {
            paramAnonymousBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, this.IYp);
          }
          e.b(e.this).B(paramString, paramAnonymousBitmap);
          if (paramb != null) {
            paramb.a(paramAnonymousView, paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(42536);
      }
    });
    AppMethodBeat.o(42550);
  }
  
  private static boolean aHr(String paramString)
  {
    AppMethodBeat.i(42554);
    u localu1 = new u(paramString);
    if (!localu1.jKS())
    {
      u localu2;
      if (!localu1.jKP().jKS())
      {
        localu2 = localu1.jKP();
        u localu3 = new u(ah.v(localu2.jKT()) + System.currentTimeMillis());
        if (localu3.jKY()) {
          localu3.am(localu2);
        }
      }
      else
      {
        if ((localu1.jKY()) && (localu1.isDirectory())) {
          break label149;
        }
        Log.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { paramString });
        AppMethodBeat.o(42554);
        return false;
      }
      Log.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { ah.v(localu2.jKT()) });
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
              e.3.this.ytT.setImageBitmap(paramAnonymousBitmap);
              ViewGroup.LayoutParams localLayoutParams = e.3.this.ytT.getLayoutParams();
              float f = e.3.this.val$height / e.3.this.val$width;
              localLayoutParams.width = e.3.this.IYm;
              localLayoutParams.height = ((int)(f * e.3.this.IYm));
              e.3.this.ytT.setLayoutParams(localLayoutParams);
              e.3.this.ytT.setScaleType(ImageView.ScaleType.FIT_XY);
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
    if ((!parama.oKn) || (parama.IYt))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    if (!this.ITd.check(paramString))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    paramString = (Bitmap)this.ITd.ct(paramString);
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
    Object localObject = new com.tencent.mm.modelimage.loader.a.c.a();
    boolean bool;
    String str;
    if (!parama.IYt)
    {
      bool = true;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKn = bool;
      aHr(IYc);
      str = IYc + g.getMessageDigest(paramString.getBytes());
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = parama.oKp;
      if (parama.IYt) {
        break label153;
      }
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).fullPath = str;
    }
    for (;;)
    {
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nrc = parama.nrc;
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).nqa = false;
      a(paramImageView, parama);
      localObject = ((com.tencent.mm.modelimage.loader.a.c.a)localObject).bKx();
      r.bKe().a(paramString, null, (com.tencent.mm.modelimage.loader.a.c)localObject, new com.tencent.mm.modelimage.loader.b.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, final com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          AppMethodBeat.i(42533);
          Log.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(paramAnonymousString)));
          if ((paramAnonymousb != null) && (paramAnonymousb.bitmap != null))
          {
            Object localObject = paramAnonymousb.bitmap;
            paramAnonymousb = (com.tencent.mm.modelimage.loader.c.b)localObject;
            if (parama.IYr) {
              paramAnonymousb = e.ao((Bitmap)localObject);
            }
            localObject = paramAnonymousb;
            if (parama.uoP != 0) {
              localObject = BitmapUtil.getRoundedCornerBitmap(paramAnonymousb, false, parama.uoP);
            }
            paramAnonymousb = (com.tencent.mm.modelimage.loader.c.b)localObject;
            if (parama.IYu > 0.0F) {
              paramAnonymousb = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * parama.IYu);
            }
            if (parama.oKn) {
              e.b(e.this).B(paramAnonymousString, paramAnonymousb);
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42531);
                if (e.2.this.nqD != null) {
                  e.2.this.nqD.setImageBitmap(paramAnonymousb);
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
        
        public final void c(String paramAnonymousString, View paramAnonymousView)
        {
          AppMethodBeat.i(42532);
          Log.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(42532);
        }
      });
      AppMethodBeat.o(42546);
      return;
      bool = false;
      break;
      label153:
      ((com.tencent.mm.modelimage.loader.a.c.a)localObject).oKp = false;
      com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(str);
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
  
  public static e fIb()
  {
    AppMethodBeat.i(42539);
    if (IYd == null) {}
    try
    {
      if (IYd == null) {
        IYd = new e();
      }
      e locale = IYd;
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
      locala = new e.a.a().fIc();
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
    if (this.IMC.check(paramString))
    {
      localBitmap = (Bitmap)this.IMC.ct(paramString);
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
      this.IMC.put(paramString, localBitmap);
      AppMethodBeat.o(42553);
      return;
    }
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.openapi.a.gxn().add(new MStorage.IOnStorageChange()
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
            com.tencent.mm.plugin.openapi.a.gxn().remove(this);
          }
        }
        AppMethodBeat.o(42537);
      }
    });
    AppMethodBeat.o(42553);
  }
  
  public final void p(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42541);
    a(paramImageView, paramString, null, null);
    AppMethodBeat.o(42541);
  }
  
  public final void q(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42543);
    e.a.a locala = new e.a.a();
    locala.nrc = true;
    a(paramImageView, paramString, locala.fIc(), null);
    AppMethodBeat.o(42543);
  }
  
  public final Bitmap r(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42552);
    paramString = d.a(paramString, false, -1, null);
    if (((paramString != null) && (!paramString.isRecycled())) || ((this.IYf == null) || (this.IYf.isRecycled()))) {}
    try
    {
      this.IYf = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
      label64:
      if ((this.IYf != null) && (!this.IYf.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.IYf);
      }
      paramImageView = this.IYf;
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
    final boolean IYr;
    final boolean IYs;
    final boolean IYt;
    final float IYu;
    final int npW;
    final boolean nrc;
    final boolean oKn;
    final boolean oKp;
    final int uoP;
    
    private a(a parama)
    {
      this.oKn = parama.oKn;
      this.oKp = parama.oKp;
      this.nrc = parama.nrc;
      this.IYr = parama.IYr;
      this.IYs = parama.IYs;
      this.IYt = parama.IYt;
      this.npW = parama.npW;
      this.uoP = parama.uoP;
      this.IYu = parama.IYu;
    }
    
    public static final class a
    {
      public boolean IYr = false;
      public boolean IYs = true;
      boolean IYt = false;
      public float IYu = 0.0F;
      public int npW = 0;
      public boolean nrc = false;
      public boolean oKn = true;
      public boolean oKp = true;
      int uoP = 0;
      
      public final e.a fIc()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.e
 * JD-Core Version:    0.7.0.1
 */