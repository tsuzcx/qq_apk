package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.lang.ref.WeakReference;

public class e
{
  private static final String lgk = com.tencent.mm.loader.a.b.bkH + "Game/Image/";
  private static e lgl;
  private f<String, Bitmap> kWF = new f(6);
  private f<String, Bitmap> ldz = new f(15);
  private ColorDrawable lgm = new ColorDrawable(android.support.v4.content.b.i(ae.getContext(), g.b.game_default_background));
  private Bitmap lgn;
  private Bitmap lgo;
  
  private e()
  {
    try
    {
      this.lgn = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      if ((this.lgn != null) && (!this.lgn.isRecycled())) {
        this.lgo = com.tencent.mm.sdk.platformtools.c.a(this.lgn, false, 0.5F * this.lgn.getWidth());
      }
      com.tencent.mm.plugin.z.a.brn().c(new j.a()
      {
        public final void a(String paramAnonymousString, l paramAnonymousl)
        {
          if (e.a(e.this).aC(paramAnonymousString))
          {
            paramAnonymousl = com.tencent.mm.pluginsdk.model.app.g.b(paramAnonymousString, 1, com.tencent.mm.cb.a.getDensity(null));
            e.a(e.this).f(paramAnonymousString, paramAnonymousl);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.i("MicroMsg.GameImageUtil", localException.getMessage());
      }
    }
  }
  
  private void b(ImageView paramImageView, String paramString, e.a parama, e.b paramb)
  {
    Object localObject = new c.a();
    boolean bool;
    String str;
    File localFile2;
    if (!parama.lgB)
    {
      bool = true;
      ((c.a)localObject).erd = bool;
      str = lgk;
      File localFile1 = new File(str);
      if (!localFile1.exists())
      {
        if (!localFile1.getParentFile().exists())
        {
          localFile2 = localFile1.getParentFile();
          File localFile3 = new File(localFile2.getAbsolutePath() + System.currentTimeMillis());
          if (!localFile3.mkdir()) {
            break label277;
          }
          localFile3.renameTo(localFile2);
        }
        if ((!localFile1.mkdir()) || (!localFile1.isDirectory())) {
          y.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { str });
        }
      }
      label149:
      str = lgk + com.tencent.mm.a.g.o(paramString.getBytes());
      ((c.a)localObject).erf = parama.erf;
      if (parama.lgB) {
        break label300;
      }
      ((c.a)localObject).erh = str;
      label200:
      ((c.a)localObject).erD = parama.erD;
      ((c.a)localObject).erC = false;
      if ((paramImageView != null) && (parama.lgA))
      {
        if (parama.lgC != 0) {
          break label315;
        }
        paramImageView.setImageDrawable(this.lgm);
      }
    }
    for (;;)
    {
      localObject = ((c.a)localObject).OV();
      o.ON().a(paramString, null, (com.tencent.mm.as.a.a.c)localObject, new e.2(this, paramb, parama, paramImageView));
      return;
      bool = false;
      break;
      label277:
      y.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { localFile2.getAbsolutePath() });
      break label149;
      label300:
      ((c.a)localObject).erf = false;
      com.tencent.mm.pluginsdk.g.a.d.a.Wp(str);
      break label200;
      label315:
      paramImageView.setImageResource(parama.lgC);
    }
  }
  
  public static e baw()
  {
    if (lgl == null) {}
    try
    {
      if (lgl == null) {
        lgl = new e();
      }
      return lgl;
    }
    finally {}
  }
  
  public final void a(ImageView paramImageView, String paramString, float paramFloat)
  {
    if ((paramImageView == null) || (bk.bl(paramString))) {
      return;
    }
    if (this.kWF.aC(paramString))
    {
      localBitmap = (Bitmap)this.kWF.get(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramImageView.setImageBitmap(localBitmap);
        return;
      }
    }
    Bitmap localBitmap = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 1, paramFloat);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramImageView.setImageBitmap(localBitmap);
      this.kWF.put(paramString, localBitmap);
      return;
    }
    paramImageView.setImageResource(g.d.game_default_icon);
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.z.a.brn().c(new e.5(this, paramString, paramFloat, paramImageView));
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramImageView = new e.3(this, paramImageView, paramInt2, paramInt1, paramInt3);
    y.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.ldz.get(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramImageView.a(null, localBitmap);
      return;
    }
    b(null, paramString, new e.a.a().bax(), new e.4(this, paramImageView, paramInt1, paramInt2, paramString));
  }
  
  public final void a(ImageView paramImageView, String paramString, e.a parama)
  {
    a(paramImageView, paramString, parama, null);
  }
  
  public final void a(ImageView paramImageView, String paramString, e.a parama, e.b paramb)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return;
      e.a locala = parama;
      if (parama == null) {
        locala = new e.a.a().bax();
      }
      int i;
      if ((!locala.erd) || (locala.lgB)) {
        i = 0;
      }
      while (i == 0)
      {
        b(paramImageView, paramString, locala, paramb);
        return;
        if (this.ldz.aC(paramString))
        {
          parama = (Bitmap)this.ldz.get(paramString);
          if ((parama != null) && (!parama.isRecycled()))
          {
            if (paramImageView != null) {
              paramImageView.setImageBitmap(parama);
            }
            if (paramb != null) {
              paramb.a(paramImageView, parama);
            }
            i = 1;
            continue;
          }
        }
        i = 0;
      }
    }
  }
  
  public final void g(ImageView paramImageView, String paramString)
  {
    a(paramImageView, paramString, null, null);
  }
  
  public final Bitmap h(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = com.tencent.mm.ag.b.a(paramString, false, -1);
    if (((localBitmap != null) && (!localBitmap.isRecycled())) || ((this.lgn == null) || (this.lgn.isRecycled()))) {}
    try
    {
      this.lgn = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      label57:
      if ((this.lgn != null) && (!this.lgn.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.lgn);
      }
      paramString = this.lgn;
      do
      {
        return paramString;
        paramString = localBitmap;
      } while (paramImageView == null);
      paramImageView.setImageBitmap(localBitmap);
      return localBitmap;
    }
    catch (Exception paramString)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e
 * JD-Core Version:    0.7.0.1
 */