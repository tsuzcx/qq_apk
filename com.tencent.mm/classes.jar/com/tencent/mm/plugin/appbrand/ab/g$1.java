package com.tencent.mm.plugin.appbrand.ab;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.ad;

final class g$1
  implements b.k
{
  g$1(ImageView paramImageView, Runnable paramRunnable, String paramString) {}
  
  public final String BM()
  {
    return "AppBrandWeishiUtil#THUMB";
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49346);
    ad.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
    ImageView localImageView = this.Bq;
    if ((localImageView != null) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localImageView.setImageBitmap(paramBitmap);
    }
    if (this.mRF != null) {
      this.mRF.run();
    }
    AppMethodBeat.o(49346);
  }
  
  public final void aEd() {}
  
  public final void ox()
  {
    AppMethodBeat.i(49347);
    ad.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
    if (this.mRz != null) {
      g.a(this.Bq, this.mRz, null, this.mRF);
    }
    AppMethodBeat.o(49347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.g.1
 * JD-Core Version:    0.7.0.1
 */