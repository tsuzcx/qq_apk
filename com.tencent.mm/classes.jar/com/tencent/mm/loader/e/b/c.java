package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ac;

public class c
  extends f<ImageView>
{
  boolean gKR = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, boolean paramBoolean)
  {
    super(paramg);
    this.gKR = paramBoolean;
  }
  
  public final void a(g<?> paramg, com.tencent.mm.loader.f<?, ?> paramf)
  {
    if (paramg == null) {
      ac.w("MicroMsg.Loader.ImageViewShowTarget", "[ViewShowTarget] should show default view or options is null.");
    }
    do
    {
      return;
      paramg = (ImageView)paramg.getView();
    } while ((paramg == null) || (!this.gKR));
    int i;
    if ((paramf.gIW > 0) || (paramf.gIY != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.gIW == 0)
      {
        paramg.setImageDrawable(paramf.gIY);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.gIW);
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
      ac.d("MicroMsg.Loader.ImageViewShowTarget", "onResourceReadyUI imageView %s resource %s", new Object[] { paramg, paramBitmap });
      paramg.setImageBitmap(paramBitmap);
      return true;
    }
    ac.e("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView is null");
    return true;
  }
  
  public final int aov()
  {
    return this.gKS.gLh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c
 * JD-Core Version:    0.7.0.1
 */