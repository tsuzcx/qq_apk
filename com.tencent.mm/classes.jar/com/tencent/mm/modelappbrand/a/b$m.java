package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.Map;

class b$m
  implements b.k
{
  private final WeakReference<ImageView> aFW;
  private final String key;
  private final b lzn;
  private final b.p lzo;
  boolean lzp;
  private final String url;
  
  private b$m(ImageView paramImageView, b paramb, String paramString, b.p paramp)
  {
    AppMethodBeat.i(229841);
    this.lzp = false;
    this.aFW = new WeakReference(paramImageView);
    this.lzn = paramb;
    this.key = "ImageView";
    this.url = paramString;
    this.lzo = paramp;
    AppMethodBeat.o(229841);
  }
  
  private void bhs()
  {
    AppMethodBeat.i(131364);
    ImageView localImageView = (ImageView)this.aFW.get();
    if (localImageView != null) {
      b.e(this.lzn).remove(Integer.valueOf(localImageView.hashCode()));
    }
    AppMethodBeat.o(131364);
  }
  
  public final void G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(131365);
    bhs();
    ImageView localImageView = (ImageView)this.aFW.get();
    this.lzp = true;
    if (localImageView != null)
    {
      if (!MMHandlerThread.isMainThread()) {
        Log.printDebugStack("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      if ((this.lzo != null) && (!this.lzo.bhx()))
      {
        Log.i("Luggage.AppBrandSimpleImageLoader", "check fail，abort set image url=" + this.url);
        AppMethodBeat.o(131365);
        return;
      }
      localImageView.setImageDrawable(new f(localImageView.getResources(), paramBitmap));
    }
    AppMethodBeat.o(131365);
  }
  
  public void bhq() {}
  
  public final void bhr()
  {
    AppMethodBeat.i(131366);
    bhs();
    AppMethodBeat.o(131366);
  }
  
  final ImageView getImageView()
  {
    AppMethodBeat.i(131362);
    ImageView localImageView = (ImageView)this.aFW.get();
    AppMethodBeat.o(131362);
    return localImageView;
  }
  
  public final String key()
  {
    return this.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.m
 * JD-Core Version:    0.7.0.1
 */