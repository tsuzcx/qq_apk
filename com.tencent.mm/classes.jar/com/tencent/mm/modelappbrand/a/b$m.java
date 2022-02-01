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
  private final b gSt;
  boolean gSu;
  final String key;
  private final WeakReference<ImageView> lo;
  
  private b$m(ImageView paramImageView, b paramb)
  {
    AppMethodBeat.i(131363);
    this.gSu = false;
    this.lo = new WeakReference(paramImageView);
    this.gSt = paramb;
    this.key = "ImageView";
    AppMethodBeat.o(131363);
  }
  
  private void auk()
  {
    AppMethodBeat.i(131364);
    if (this.lo.get() != null) {
      b.e(this.gSt).remove(Integer.valueOf(((ImageView)this.lo.get()).hashCode()));
    }
    AppMethodBeat.o(131364);
  }
  
  public final String AL()
  {
    return this.key;
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(131365);
    auk();
    ImageView localImageView = (ImageView)this.lo.get();
    if (localImageView != null)
    {
      if (!aq.isMainThread()) {
        ad.l("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      localImageView.setImageDrawable(new f(localImageView.getResources(), paramBitmap));
    }
    this.gSu = true;
    AppMethodBeat.o(131365);
  }
  
  public void auj() {}
  
  final ImageView getImageView()
  {
    AppMethodBeat.i(131362);
    ImageView localImageView = (ImageView)this.lo.get();
    AppMethodBeat.o(131362);
    return localImageView;
  }
  
  public final void nV()
  {
    AppMethodBeat.i(131366);
    auk();
    AppMethodBeat.o(131366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.m
 * JD-Core Version:    0.7.0.1
 */