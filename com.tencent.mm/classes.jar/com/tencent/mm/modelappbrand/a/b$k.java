package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.Map;

class b$k
  implements b.i
{
  private final WeakReference<ImageView> aqT;
  private final b fqH;
  boolean fqI;
  final String key;
  
  private b$k(ImageView paramImageView, b paramb)
  {
    AppMethodBeat.i(77341);
    this.fqI = false;
    this.aqT = new WeakReference(paramImageView);
    this.fqH = paramb;
    this.key = ("ImageView#" + paramImageView.hashCode());
    AppMethodBeat.o(77341);
  }
  
  private void acK()
  {
    AppMethodBeat.i(77342);
    if (this.aqT.get() != null) {
      b.c(this.fqH).remove(Integer.valueOf(((ImageView)this.aqT.get()).hashCode()));
    }
    AppMethodBeat.o(77342);
  }
  
  public void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(77344);
    acK();
    AppMethodBeat.o(77344);
  }
  
  final ImageView getImageView()
  {
    AppMethodBeat.i(77340);
    ImageView localImageView = (ImageView)this.aqT.get();
    AppMethodBeat.o(77340);
    return localImageView;
  }
  
  public final String tX()
  {
    return this.key;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77343);
    acK();
    ImageView localImageView = (ImageView)this.aqT.get();
    if (localImageView != null)
    {
      if (!al.isMainThread()) {
        ab.a("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      localImageView.setImageDrawable(new e(localImageView.getResources(), paramBitmap));
    }
    this.fqI = true;
    AppMethodBeat.o(77343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.k
 * JD-Core Version:    0.7.0.1
 */