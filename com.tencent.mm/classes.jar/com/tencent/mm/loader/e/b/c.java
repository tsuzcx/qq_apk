package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends f<ImageView>
{
  private boolean eOB = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, byte paramByte)
  {
    super(paramg);
    this.eOB = false;
  }
  
  public final int TJ()
  {
    return this.eOC.eOR;
  }
  
  protected final void a(Bitmap paramBitmap, g<?> paramg)
  {
    paramg = (ImageView)paramg.getView();
    ab.i("MicroMsg.Loader.ImageViewShowTarget", "onResourceReadyUI %s imageView %s", new Object[] { paramBitmap, paramg });
    if (paramg != null) {
      paramg.setImageBitmap(paramBitmap);
    }
  }
  
  public final void a(g<?> paramg, com.tencent.mm.loader.f<?, ?> paramf)
  {
    if (paramg == null) {
      ab.w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
    }
    do
    {
      return;
      paramg = (ImageView)paramg.getView();
    } while ((paramg == null) || (!this.eOB));
    int i;
    if ((paramf.eMX > 0) || (paramf.eMY != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.eMX == 0)
      {
        paramg.setImageDrawable(paramf.eMY);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.eMX);
        return;
      }
    }
    paramg.setImageBitmap(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c
 * JD-Core Version:    0.7.0.1
 */