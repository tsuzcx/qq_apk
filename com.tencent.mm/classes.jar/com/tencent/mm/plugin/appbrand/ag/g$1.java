package com.tencent.mm.plugin.appbrand.ag;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.sdk.platformtools.Log;

final class g$1
  implements b.k
{
  g$1(ImageView paramImageView, Runnable paramRunnable, String paramString) {}
  
  public final void G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49346);
    Log.i("MicroMsg.AppBrandWeishiUtil", "thumb loaded");
    ImageView localImageView = this.aqP;
    if ((localImageView != null) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localImageView.setImageBitmap(paramBitmap);
    }
    if (this.rmg != null) {
      this.rmg.run();
    }
    AppMethodBeat.o(49346);
  }
  
  public final void bhq() {}
  
  public final void bhr()
  {
    AppMethodBeat.i(49347);
    Log.e("MicroMsg.AppBrandWeishiUtil", "thumb loaded fail");
    if (this.rlV != null) {
      g.a(this.aqP, this.rlV, null, this.rmg);
    }
    AppMethodBeat.o(49347);
  }
  
  public final String key()
  {
    return "AppBrandWeishiUtil#THUMB";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.g.1
 * JD-Core Version:    0.7.0.1
 */