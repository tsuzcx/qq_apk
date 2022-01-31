package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandVideoView$8$1
  implements Runnable
{
  AppBrandVideoView$8$1(AppBrandVideoView.8 param8, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(126449);
    if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
      AppBrandVideoView.a(this.icY.icX).setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(126449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.8.1
 * JD-Core Version:    0.7.0.1
 */