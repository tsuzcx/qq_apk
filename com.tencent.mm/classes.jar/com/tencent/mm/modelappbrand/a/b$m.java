package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.Map;

class b$m
  implements b.k
{
  private final b hLl;
  boolean hLm;
  final String key;
  private final WeakReference<ImageView> og;
  
  private b$m(ImageView paramImageView, b paramb)
  {
    AppMethodBeat.i(131363);
    this.hLm = false;
    this.og = new WeakReference(paramImageView);
    this.hLl = paramb;
    this.key = "ImageView";
    AppMethodBeat.o(131363);
  }
  
  private void aEe()
  {
    AppMethodBeat.i(131364);
    if (this.og.get() != null) {
      b.e(this.hLl).remove(Integer.valueOf(((ImageView)this.og.get()).hashCode()));
    }
    AppMethodBeat.o(131364);
  }
  
  public final String BM()
  {
    return this.key;
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(131365);
    aEe();
    ImageView localImageView = (ImageView)this.og.get();
    if (localImageView != null)
    {
      if (!aq.isMainThread()) {
        ad.l("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      localImageView.setImageDrawable(new f(localImageView.getResources(), paramBitmap));
    }
    this.hLm = true;
    AppMethodBeat.o(131365);
  }
  
  public void aEd() {}
  
  final ImageView getImageView()
  {
    AppMethodBeat.i(131362);
    ImageView localImageView = (ImageView)this.og.get();
    AppMethodBeat.o(131362);
    return localImageView;
  }
  
  public final void ox()
  {
    AppMethodBeat.i(131366);
    aEe();
    AppMethodBeat.o(131366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.m
 * JD-Core Version:    0.7.0.1
 */