package com.tencent.mm.loader.d.b;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  extends f<ImageView>
{
  boolean nqC = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, boolean paramBoolean)
  {
    super(paramg);
    this.nqC = paramBoolean;
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
    } while ((paramg == null) || (!this.nqC));
    int i;
    if ((paramf.noM > 0) || (paramf.noO != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.noM == 0)
      {
        paramg.setImageDrawable(paramf.noO);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.noM);
        return;
      }
    }
    paramg.setImageBitmap(null);
  }
  
  protected boolean a(Bitmap paramBitmap, final g<?> paramg)
  {
    final ImageView localImageView = (ImageView)paramg.getView();
    paramg = paramg.nqP.bmg();
    if (localImageView != null)
    {
      localImageView.setImageMatrix(null);
      if ((paramg instanceof com.tencent.mm.loader.g.a.d)) {
        localImageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            paramAnonymousView = ((com.tencent.mm.loader.g.a.d)paramg).aj(paramAnonymousView.getWidth(), paramAnonymousView.getHeight());
            if (paramAnonymousView != null)
            {
              localImageView.setScaleType(ImageView.ScaleType.MATRIX);
              localImageView.setImageMatrix(paramAnonymousView);
            }
            localImageView.removeOnLayoutChangeListener(this);
          }
        });
      }
      localImageView.setImageBitmap(paramBitmap);
      Log.i("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView get ");
    }
    for (;;)
    {
      return true;
      Log.e("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView is null");
    }
  }
  
  public final int blK()
  {
    return this.nqG.nqQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.b.c
 * JD-Core Version:    0.7.0.1
 */