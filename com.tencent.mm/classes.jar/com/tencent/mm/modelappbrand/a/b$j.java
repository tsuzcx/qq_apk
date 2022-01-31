package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

class b$j
  implements b.h
{
  private final WeakReference<ImageView> aoA;
  private final b eay;
  boolean eaz = false;
  final String key;
  
  private b$j(ImageView paramImageView, b paramb)
  {
    this.aoA = new WeakReference(paramImageView);
    this.eay = paramb;
    this.key = ("ImageView#" + paramImageView.hashCode());
  }
  
  private void JK()
  {
    if (this.aoA.get() != null) {
      b.c(this.eay).remove(Integer.valueOf(((ImageView)this.aoA.get()).hashCode()));
    }
  }
  
  public void JG() {}
  
  public final void JH()
  {
    JK();
  }
  
  final ImageView getImageView()
  {
    return (ImageView)this.aoA.get();
  }
  
  public final void p(Bitmap paramBitmap)
  {
    JK();
    ImageView localImageView = (ImageView)this.aoA.get();
    if (localImageView != null)
    {
      if (!ai.isMainThread()) {
        y.b("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      localImageView.setImageDrawable(new e(localImageView.getResources(), paramBitmap));
    }
    this.eaz = true;
  }
  
  public final String pU()
  {
    return this.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.j
 * JD-Core Version:    0.7.0.1
 */