package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.lang.ref.WeakReference;
import java.util.Map;

class b$m
  implements b.k
{
  private final b hOe;
  boolean hOf;
  final String key;
  private final WeakReference<ImageView> og;
  
  private b$m(ImageView paramImageView, b paramb)
  {
    AppMethodBeat.i(131363);
    this.hOf = false;
    this.og = new WeakReference(paramImageView);
    this.hOe = paramb;
    this.key = "ImageView";
    AppMethodBeat.o(131363);
  }
  
  private void aEu()
  {
    AppMethodBeat.i(131364);
    if (this.og.get() != null) {
      b.e(this.hOe).remove(Integer.valueOf(((ImageView)this.og.get()).hashCode()));
    }
    AppMethodBeat.o(131364);
  }
  
  public final String BN()
  {
    return this.key;
  }
  
  public final void F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(131365);
    aEu();
    ImageView localImageView = (ImageView)this.og.get();
    if (localImageView != null)
    {
      if (!ar.isMainThread()) {
        ae.l("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      localImageView.setImageDrawable(new f(localImageView.getResources(), paramBitmap));
    }
    this.hOf = true;
    AppMethodBeat.o(131365);
  }
  
  public void aEt() {}
  
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
    aEu();
    AppMethodBeat.o(131366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.m
 * JD-Core Version:    0.7.0.1
 */