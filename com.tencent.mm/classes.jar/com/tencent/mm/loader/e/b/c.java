package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ae;

public class c
  extends f<ImageView>
{
  boolean hhu = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, boolean paramBoolean)
  {
    super(paramg);
    this.hhu = paramBoolean;
  }
  
  public final void a(g<?> paramg, com.tencent.mm.loader.f<?, ?> paramf)
  {
    if (paramg == null) {
      ae.w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
    }
    do
    {
      return;
      paramg = (ImageView)paramg.getView();
    } while ((paramg == null) || (!this.hhu));
    int i;
    if ((paramf.hfv > 0) || (paramf.hfx != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.hfv == 0)
      {
        paramg.setImageDrawable(paramf.hfx);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.hfv);
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
      ae.d("MicroMsg.Loader.ImageViewShowTarget", "onResourceReadyUI imageView %s resource %s", new Object[] { paramg, paramBitmap });
      paramg.setImageBitmap(paramBitmap);
      return true;
    }
    ae.e("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView is null");
    return true;
  }
  
  public final int arw()
  {
    return this.hhv.hhK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c
 * JD-Core Version:    0.7.0.1
 */