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
import com.tencent.mm.am.d;
import com.tencent.mm.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.lang.ref.WeakReference;

public class e
{
  private static final String DdL;
  private static e DdM;
  private f<String, Bitmap> CSm;
  private f<String, Bitmap> CYN;
  private ColorDrawable DdN;
  private Bitmap DdO;
  private Bitmap DdP;
  
  static
  {
    AppMethodBeat.i(42557);
    DdL = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Czx) + "image/";
    AppMethodBeat.o(42557);
  }
  
  private e()
  {
    AppMethodBeat.i(42540);
    this.CSm = new com.tencent.mm.memory.a.b(6, getClass());
    this.CYN = new com.tencent.mm.memory.a.b(15, getClass());
    this.DdN = new ColorDrawable(Color.parseColor("#EFEFF4"));
    try
    {
      this.DdO = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.ci.a.getDensity(null));
      if ((this.DdO != null) && (!this.DdO.isRecycled())) {
        this.DdP = BitmapUtil.getRoundedCornerBitmap(this.DdO, false, 0.5F * this.DdO.getWidth());
      }
      com.tencent.mm.plugin.ab.a.fmz().add(new MStorage.IOnStorageChange()
      {
        public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
        {
          AppMethodBeat.i(42530);
          if (e.a(e.this).check(paramAnonymousString))
          {
            paramAnonymousMStorageEventData = com.tencent.mm.pluginsdk.model.app.h.c(paramAnonymousString, 1, com.tencent.mm.ci.a.getDensity(null));
            e.a(e.this).q(paramAnonymousString, paramAnonymousMStorageEventData);
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
    if ((paramImageView != null) && (parama.Deb))
    {
      if (parama.kOh == 0)
      {
        paramImageView.setImageDrawable(this.DdN);
        AppMethodBeat.o(42547);
        return;
      }
      paramImageView.setImageResource(parama.kOh);
    }
    AppMethodBeat.o(42547);
  }
  
  private void a(final String paramString, final int paramInt1, final int paramInt2, final b paramb)
  {
    AppMethodBeat.i(42550);
    Log.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.CYN.aX(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.a(null, localBitmap);
      AppMethodBeat.o(42550);
      return;
    }
    c(null, paramString, new e.a.a().eAb(), new b()
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
          if (this.DdY != 0) {
            paramAnonymousBitmap = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, this.DdY);
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
  
  private static boolean aKA(String paramString)
  {
    AppMethodBeat.i(42554);
    com.tencent.mm.vfs.q localq1 = new com.tencent.mm.vfs.q(paramString);
    if (!localq1.ifE())
    {
      com.tencent.mm.vfs.q localq2;
      if (!localq1.ifB().ifE())
      {
        localq2 = localq1.ifB();
        com.tencent.mm.vfs.q localq3 = new com.tencent.mm.vfs.q(localq2.bOF() + System.currentTimeMillis());
        if (localq3.ifK()) {
          localq3.aj(localq2);
        }
      }
      else
      {
        if ((localq1.ifK()) && (localq1.isDirectory())) {
          break label143;
        }
        Log.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { paramString });
        AppMethodBeat.o(42554);
        return false;
      }
      Log.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { localq2.bOF() });
      AppMethodBeat.o(42554);
      return false;
    }
    label143:
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
              e.3.this.vhS.setImageBitmap(paramAnonymousBitmap);
              ViewGroup.LayoutParams localLayoutParams = e.3.this.vhS.getLayoutParams();
              float f = e.3.this.val$height / e.3.this.val$width;
              localLayoutParams.width = e.3.this.DdV;
              localLayoutParams.height = ((int)(f * e.3.this.DdV));
              e.3.this.vhS.setLayoutParams(localLayoutParams);
              e.3.this.vhS.setScaleType(ImageView.ScaleType.FIT_XY);
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
    if ((!parama.lRB) || (parama.Dec))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    if (!this.CYN.check(paramString))
    {
      AppMethodBeat.o(42545);
      return false;
    }
    paramString = (Bitmap)this.CYN.aX(paramString);
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
    Object localObject = new com.tencent.mm.ay.a.a.c.a();
    boolean bool;
    String str;
    if (!parama.Dec)
    {
      bool = true;
      ((com.tencent.mm.ay.a.a.c.a)localObject).lRB = bool;
      aKA(DdL);
      str = DdL + g.getMessageDigest(paramString.getBytes());
      ((com.tencent.mm.ay.a.a.c.a)localObject).lRD = parama.lRD;
      if (parama.Dec) {
        break label153;
      }
      ((com.tencent.mm.ay.a.a.c.a)localObject).fullPath = str;
    }
    for (;;)
    {
      ((com.tencent.mm.ay.a.a.c.a)localObject).kPz = parama.kPz;
      ((com.tencent.mm.ay.a.a.c.a)localObject).kOl = false;
      a(paramImageView, parama);
      localObject = ((com.tencent.mm.ay.a.a.c.a)localObject).bmL();
      com.tencent.mm.ay.q.bml().a(paramString, null, (com.tencent.mm.ay.a.a.c)localObject, new com.tencent.mm.ay.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView)
        {
          AppMethodBeat.i(42532);
          Log.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(42532);
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, final com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42533);
          Log.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(paramAnonymousString)));
          if ((paramAnonymousb != null) && (paramAnonymousb.bitmap != null))
          {
            Object localObject = paramAnonymousb.bitmap;
            paramAnonymousb = (com.tencent.mm.ay.a.d.b)localObject;
            if (parama.Dea) {
              paramAnonymousb = e.ac((Bitmap)localObject);
            }
            localObject = paramAnonymousb;
            if (parama.rgT != 0) {
              localObject = BitmapUtil.getRoundedCornerBitmap(paramAnonymousb, false, parama.rgT);
            }
            paramAnonymousb = (com.tencent.mm.ay.a.d.b)localObject;
            if (parama.Ded > 0.0F) {
              paramAnonymousb = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, ((Bitmap)localObject).getWidth() * parama.Ded);
            }
            if (parama.lRB) {
              e.b(e.this).q(paramAnonymousString, paramAnonymousb);
            }
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(42531);
                if (e.2.this.kOW != null) {
                  e.2.this.kOW.setImageBitmap(paramAnonymousb);
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
      ((com.tencent.mm.ay.a.a.c.a)localObject).lRD = false;
      com.tencent.mm.pluginsdk.k.a.d.a.bqF(str);
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
  
  public static e eAa()
  {
    AppMethodBeat.i(42539);
    if (DdM == null) {}
    try
    {
      if (DdM == null) {
        DdM = new e();
      }
      e locale = DdM;
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
      locala = new e.a.a().eAb();
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
    if (this.CSm.check(paramString))
    {
      localBitmap = (Bitmap)this.CSm.aX(paramString);
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
      this.CSm.put(paramString, localBitmap);
      AppMethodBeat.o(42553);
      return;
    }
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.ab.a.fmz().add(new MStorage.IOnStorageChange()
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
            com.tencent.mm.plugin.ab.a.fmz().remove(this);
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
    locala.kPz = true;
    a(paramImageView, paramString, locala.eAb(), null);
    AppMethodBeat.o(42543);
  }
  
  public final Bitmap q(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(42552);
    paramString = d.a(paramString, false, -1, null);
    if (((paramString != null) && (!paramString.isRecycled())) || ((this.DdO == null) || (this.DdO.isRecycled()))) {}
    try
    {
      this.DdO = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.ci.a.getDensity(null));
      label64:
      if ((this.DdO != null) && (!this.DdO.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.DdO);
      }
      paramImageView = this.DdO;
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
    final boolean Dea;
    final boolean Deb;
    final boolean Dec;
    final float Ded;
    final int kOh;
    final boolean kPz;
    final boolean lRB;
    final boolean lRD;
    final int rgT;
    
    private a(a parama)
    {
      this.lRB = parama.lRB;
      this.lRD = parama.lRD;
      this.kPz = parama.kPz;
      this.Dea = parama.Dea;
      this.Deb = parama.Deb;
      this.Dec = parama.Dec;
      this.kOh = parama.kOh;
      this.rgT = parama.rgT;
      this.Ded = parama.Ded;
    }
    
    public static final class a
    {
      public boolean Dea = false;
      boolean Deb = true;
      boolean Dec = false;
      public float Ded = 0.0F;
      public int kOh = 0;
      public boolean kPz = false;
      public boolean lRB = true;
      public boolean lRD = true;
      int rgT = 0;
      
      public final e.a eAb()
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
 * Qualified Name:     com.tencent.mm.plugin.game.d.e
 * JD-Core Version:    0.7.0.1
 */