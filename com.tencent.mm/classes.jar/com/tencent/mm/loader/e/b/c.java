package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends f<ImageView>
{
  boolean gke = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, boolean paramBoolean)
  {
    super(paramg);
    this.gke = paramBoolean;
  }
  
  public final void a(g<?> paramg, com.tencent.mm.loader.f<?, ?> paramf)
  {
    if (paramg == null) {
      ad.w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
    }
    do
    {
      return;
      paramg = (ImageView)paramg.getView();
    } while ((paramg == null) || (!this.gke));
    int i;
    if ((paramf.gin > 0) || (paramf.gip != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.gin == 0)
      {
        paramg.setImageDrawable(paramf.gip);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.gin);
        return;
      }
    }
    paramg.setImageBitmap(null);
  }
  
  protected final boolean a(Bitmap paramBitmap, g<?> paramg)
  {
    paramg = (ImageView)paramg.getView();
    if (paramg != null)
    {
      ad.d("MicroMsg.Loader.ImageViewShowTarget", "onResourceReadyUI imageView %s resource %s", new Object[] { paramg, paramBitmap });
      paramg.setImageBitmap(paramBitmap);
      return true;
    }
    ad.e("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView is null");
    return true;
  }
  
  public final int aht()
  {
    return this.gkf.gku;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c
 * JD-Core Version:    0.7.0.1
 */