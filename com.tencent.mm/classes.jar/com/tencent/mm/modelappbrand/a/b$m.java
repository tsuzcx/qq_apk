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
  private final b iJj;
  private final b.p iJk;
  boolean iJl;
  private final String key;
  private final WeakReference<ImageView> oi;
  private final String url;
  
  private b$m(ImageView paramImageView, b paramb, String paramString, b.p paramp)
  {
    AppMethodBeat.i(204410);
    this.iJl = false;
    this.oi = new WeakReference(paramImageView);
    this.iJj = paramb;
    this.key = "ImageView";
    this.url = paramString;
    this.iJk = paramp;
    AppMethodBeat.o(204410);
  }
  
  private void aYh()
  {
    AppMethodBeat.i(131364);
    ImageView localImageView = (ImageView)this.oi.get();
    if (localImageView != null) {
      b.e(this.iJj).remove(Integer.valueOf(localImageView.hashCode()));
    }
    AppMethodBeat.o(131364);
  }
  
  public final void I(Bitmap paramBitmap)
  {
    AppMethodBeat.i(131365);
    aYh();
    ImageView localImageView = (ImageView)this.oi.get();
    this.iJl = true;
    if (localImageView != null)
    {
      if (!MMHandlerThread.isMainThread()) {
        Log.printDebugStack("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
      }
      if ((this.iJk != null) && (!this.iJk.e(localImageView)))
      {
        Log.i("Luggage.AppBrandSimpleImageLoader", "check fail，abort set image url=" + this.url);
        AppMethodBeat.o(131365);
        return;
      }
      localImageView.setImageDrawable(new f(localImageView.getResources(), paramBitmap));
    }
    AppMethodBeat.o(131365);
  }
  
  public final String Lb()
  {
    return this.key;
  }
  
  public void aYg() {}
  
  final ImageView getImageView()
  {
    AppMethodBeat.i(131362);
    ImageView localImageView = (ImageView)this.oi.get();
    AppMethodBeat.o(131362);
    return localImageView;
  }
  
  public final void oD()
  {
    AppMethodBeat.i(131366);
    aYh();
    AppMethodBeat.o(131366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.m
 * JD-Core Version:    0.7.0.1
 */