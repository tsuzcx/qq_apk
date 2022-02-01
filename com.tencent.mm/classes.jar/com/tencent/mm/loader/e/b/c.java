package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  extends f<ImageView>
{
  boolean iao = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, boolean paramBoolean)
  {
    super(paramg);
    this.iao = paramBoolean;
  }
  
  public final void a(g<?> paramg, com.tencent.mm.loader.f<?, ?> paramf)
  {
    if (paramg == null) {
      Log.w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
    }
    do
    {
      return;
      paramg = (ImageView)paramg.getView();
    } while ((paramg == null) || (!this.iao));
    int i;
    if ((paramf.hYp > 0) || (paramf.hYr != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.hYp == 0)
      {
        paramg.setImageDrawable(paramf.hYr);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.hYp);
        return;
      }
    }
    paramg.setImageBitmap(null);
  }
  
  protected boolean a(Bitmap paramBitmap, g<?> paramg)
  {
    ImageView localImageView = (ImageView)paramg.getView();
    paramg = paramg.iaG.value();
    if (localImageView != null)
    {
      localImageView.setImageMatrix(null);
      if ((paramg instanceof com.tencent.mm.loader.h.a.d)) {
        localImageView.addOnLayoutChangeListener(new c.1(this, paramg, localImageView));
      }
      localImageView.setImageBitmap(paramBitmap);
    }
    for (;;)
    {
      return true;
      Log.e("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView is null");
    }
  }
  
  public final int aJV()
  {
    return this.ias.iaH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c
 * JD-Core Version:    0.7.0.1
 */