package com.tencent.mm.plugin.appbrand.share.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaShareMessagePage$1$1
  implements Runnable
{
  WxaShareMessagePage$1$1(WxaShareMessagePage.1 param1, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(132755);
    this.iJR.iJQ.iJK.setImageBitmap(this.val$bitmap);
    this.iJR.iJQ.iJH.setImageBitmap(this.val$bitmap);
    AppMethodBeat.o(132755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage.1.1
 * JD-Core Version:    0.7.0.1
 */