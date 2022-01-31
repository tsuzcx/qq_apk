package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.widget.ImageView;

final class AppBrandVideoView$8$1
  implements Runnable
{
  AppBrandVideoView$8$1(AppBrandVideoView.8 param8, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if ((this.ara != null) && (!this.ara.isRecycled())) {
      AppBrandVideoView.a(this.gDT.gDS).setImageBitmap(this.ara);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.8.1
 * JD-Core Version:    0.7.0.1
 */