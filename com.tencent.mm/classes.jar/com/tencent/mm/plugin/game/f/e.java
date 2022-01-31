package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.lang.ref.WeakReference;

public class e
{
  private static final String nEf;
  private static e nEg;
  private f<String, Bitmap> nBu;
  private ColorDrawable nEh;
  private Bitmap nEi;
  private Bitmap nEj;
  private f<String, Bitmap> nuH;
  
  static
  {
    AppMethodBeat.i(112353);
    nEf = com.tencent.mm.loader.j.b.eQz + "Game/Image/";
    AppMethodBeat.o(112353);
  }
  
  private e()
  {
    AppMethodBeat.i(112336);
    this.nuH = new com.tencent.mm.memory.a.b(6, getClass());
    this.nBu = new com.tencent.mm.memory.a.b(15, getClass());
    this.nEh = new ColorDrawable(android.support.v4.content.b.m(ah.getContext(), 2131690083));
    try
    {
      this.nEi = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      if ((this.nEi != null) && (!this.nEi.isRecycled())) {
        this.nEj = d.a(this.nEi, false, 0.5F * this.nEi.getWidth());
      }
      com.tencent.mm.plugin.s.a.cac().add(new e.1(this));
      AppMethodBeat.o(112336);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.i("MicroMsg.GameImageUtil", localException.getMessage());
      }
    }
  }
  
  private static boolean QE(String paramString)
  {
    AppMethodBeat.i(112350);
    File localFile1 = new File(paramString);
    if (!localFile1.exists())
    {
      File localFile2;
      if (!localFile1.getParentFile().exists())
      {
        localFile2 = localFile1.getParentFile();
        File localFile3 = new File(localFile2.getAbsolutePath() + System.currentTimeMillis());
        if (localFile3.mkdir()) {
          localFile3.renameTo(localFile2);
        }
      }
      else
      {
        if ((localFile1.mkdir()) && (localFile1.isDirectory())) {
          break label141;
        }
        ab.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[] { paramString });
        AppMethodBeat.o(112350);
        return false;
      }
      ab.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[] { localFile2.getAbsolutePath() });
      AppMethodBeat.o(112350);
      return false;
    }
    label141:
    AppMethodBeat.o(112350);
    return true;
  }
  
  private void a(ImageView paramImageView, e.a parama)
  {
    AppMethodBeat.i(112343);
    if ((paramImageView != null) && (parama.nEv))
    {
      if (parama.nEx == 0)
      {
        paramImageView.setImageDrawable(this.nEh);
        AppMethodBeat.o(112343);
        return;
      }
      paramImageView.setImageResource(parama.nEx);
    }
    AppMethodBeat.o(112343);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, e.b paramb)
  {
    AppMethodBeat.i(112346);
    ab.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
    Bitmap localBitmap = (Bitmap)this.nBu.Y(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramb.a(null, localBitmap);
      AppMethodBeat.o(112346);
      return;
    }
    c(null, paramString, new e.a.a().bHF(), new e.4(this, paramb, paramInt1, paramInt2, paramString));
    AppMethodBeat.o(112346);
  }
  
  private static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112347);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i == paramInt1) && (j == paramInt2))
    {
      AppMethodBeat.o(112347);
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
        ab.i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        AppMethodBeat.o(112347);
        return localBitmap;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Bitmap localBitmap;
        AppMethodBeat.o(112347);
      }
      paramInt1 = (int)(paramInt2 * f2);
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, (j - paramInt1) / 2, i, paramInt1);
    }
    return paramBitmap;
  }
  
  private void b(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112345);
    a(paramString, paramInt1, paramInt2, new e.3(this, paramImageView, paramInt2, paramInt1, paramInt3));
    AppMethodBeat.o(112345);
  }
  
  private boolean b(ImageView paramImageView, String paramString, e.a parama, e.b paramb)
  {
    AppMethodBeat.i(112341);
    if ((!parama.eNK) || (parama.nEw))
    {
      AppMethodBeat.o(112341);
      return false;
    }
    if (!this.nBu.Z(paramString))
    {
      AppMethodBeat.o(112341);
      return false;
    }
    paramString = (Bitmap)this.nBu.Y(paramString);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      if (paramImageView != null) {
        paramImageView.setImageBitmap(paramString);
      }
      if (paramb != null) {
        paramb.a(paramImageView, paramString);
      }
      AppMethodBeat.o(112341);
      return true;
    }
    AppMethodBeat.o(112341);
    return false;
  }
  
  public static e bHE()
  {
    AppMethodBeat.i(112335);
    if (nEg == null) {}
    try
    {
      if (nEg == null) {
        nEg = new e();
      }
      e locale = nEg;
      AppMethodBeat.o(112335);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(112335);
    }
  }
  
  private void c(ImageView paramImageView, String paramString, e.a parama, e.b paramb)
  {
    AppMethodBeat.i(112342);
    Object localObject = new c.a();
    boolean bool;
    String str;
    if (!parama.nEw)
    {
      bool = true;
      ((c.a)localObject).eNK = bool;
      QE(nEf);
      str = nEf + com.tencent.mm.a.g.w(paramString.getBytes());
      ((c.a)localObject).eNM = parama.eNM;
      if (parama.nEw) {
        break label153;
      }
      ((c.a)localObject).eNO = str;
    }
    for (;;)
    {
      ((c.a)localObject).eOk = parama.eOk;
      ((c.a)localObject).eOe = false;
      a(paramImageView, parama);
      localObject = ((c.a)localObject).ahY();
      o.ahG().a(paramString, null, (c)localObject, new e.2(this, paramb, parama, paramImageView));
      AppMethodBeat.o(112342);
      return;
      bool = false;
      break;
      label153:
      ((c.a)localObject).eNM = false;
      com.tencent.mm.pluginsdk.g.a.d.a.alT(str);
    }
  }
  
  public final void a(ImageView paramImageView, String paramString, float paramFloat)
  {
    AppMethodBeat.i(112349);
    if ((paramImageView == null) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(112349);
      return;
    }
    if (this.nuH.Z(paramString))
    {
      localBitmap = (Bitmap)this.nuH.Y(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramImageView.setImageBitmap(localBitmap);
        AppMethodBeat.o(112349);
        return;
      }
    }
    Bitmap localBitmap = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 1, paramFloat);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      paramImageView.setImageBitmap(localBitmap);
      this.nuH.put(paramString, localBitmap);
      AppMethodBeat.o(112349);
      return;
    }
    paramImageView.setImageResource(2130838963);
    paramImageView = new WeakReference(paramImageView);
    com.tencent.mm.plugin.s.a.cac().add(new e.5(this, paramString, paramFloat, paramImageView));
    AppMethodBeat.o(112349);
  }
  
  public final void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112344);
    b(paramImageView, paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(112344);
  }
  
  public final void a(ImageView paramImageView, String paramString, e.a parama)
  {
    AppMethodBeat.i(112338);
    a(paramImageView, paramString, parama, null);
    AppMethodBeat.o(112338);
  }
  
  public final void a(ImageView paramImageView, String paramString, e.a parama, e.b paramb)
  {
    AppMethodBeat.i(112340);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(112340);
      return;
    }
    e.a locala = parama;
    if (parama == null) {
      locala = new e.a.a().bHF();
    }
    if (b(paramImageView, paramString, locala, paramb))
    {
      AppMethodBeat.o(112340);
      return;
    }
    c(paramImageView, paramString, locala, paramb);
    AppMethodBeat.o(112340);
  }
  
  public final void i(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112337);
    a(paramImageView, paramString, null, null);
    AppMethodBeat.o(112337);
  }
  
  public final void j(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112339);
    e.a.a locala = new e.a.a();
    locala.eOk = true;
    a(paramImageView, paramString, locala.bHF(), null);
    AppMethodBeat.o(112339);
  }
  
  public final Bitmap k(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(112348);
    paramString = com.tencent.mm.ah.b.b(paramString, false, -1);
    if (((paramString != null) && (!paramString.isRecycled())) || ((this.nEi == null) || (this.nEi.isRecycled()))) {}
    try
    {
      this.nEi = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      label63:
      if ((this.nEi != null) && (!this.nEi.isRecycled()) && (paramImageView != null)) {
        paramImageView.setImageBitmap(this.nEi);
      }
      paramImageView = this.nEi;
      AppMethodBeat.o(112348);
      return paramImageView;
      if (paramImageView != null) {
        paramImageView.setImageBitmap(paramString);
      }
      AppMethodBeat.o(112348);
      return paramString;
    }
    catch (Exception paramString)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e
 * JD-Core Version:    0.7.0.1
 */