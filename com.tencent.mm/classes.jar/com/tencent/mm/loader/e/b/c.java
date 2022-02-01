package com.tencent.mm.loader.e.b;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class c
  extends f<ImageView>
{
  boolean kOU = true;
  
  public c(g<ImageView> paramg)
  {
    super(paramg);
  }
  
  public c(g<ImageView> paramg, boolean paramBoolean)
  {
    super(paramg);
    this.kOU = paramBoolean;
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
    } while ((paramg == null) || (!this.kOU));
    int i;
    if ((paramf.kMT > 0) || (paramf.kMV != null)) {
      i = 1;
    }
    while (i != 0) {
      if (paramf.kMT == 0)
      {
        paramg.setImageDrawable(paramf.kMV);
        return;
        i = 0;
      }
      else
      {
        paramg.setImageResource(paramf.kMT);
        return;
      }
    }
    paramg.setImageBitmap(null);
  }
  
  protected boolean a(Bitmap paramBitmap, final g<?> paramg)
  {
    final ImageView localImageView = (ImageView)paramg.getView();
    paramg = paramg.kPm.aSr();
    if (localImageView != null)
    {
      localImageView.setImageMatrix(null);
      if ((paramg instanceof com.tencent.mm.loader.h.a.d)) {
        localImageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
        {
          public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
          {
            paramAnonymousView = ((com.tencent.mm.loader.h.a.d)paramg).F(paramAnonymousView.getWidth(), paramAnonymousView.getHeight());
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
    }
    for (;;)
    {
      return true;
      Log.e("MicroMsg.Loader.ImageViewShowTarget", "[onResourceReadyUI]  imageView is null");
    }
  }
  
  public final int aRV()
  {
    return this.kOY.kPn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.c
 * JD-Core Version:    0.7.0.1
 */