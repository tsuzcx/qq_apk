package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ad;

public class c
  extends f<ImageView>
{
  boolean heG = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, boolean paramBoolean)
  {
    super(paramg);
    this.heG = paramBoolean;
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
    } while ((paramg == null) || (!this.heG));
    int i;
    if ((paramf.hcH > 0) || (paramf.hcJ != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.hcH == 0)
      {
        paramg.setImageDrawable(paramf.hcJ);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.hcH);
        return;
      }
    }
    paramg.setImageBitmap(null);
  }
  
  protected boolean a(Bitmap paramBitmap, g<?> paramg)
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
  
  public final int arh()
  {
    return this.heH.heW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c
 * JD-Core Version:    0.7.0.1
 */