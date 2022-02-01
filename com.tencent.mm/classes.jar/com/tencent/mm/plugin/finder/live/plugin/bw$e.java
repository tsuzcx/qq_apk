package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.WxImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenShareWidget$inputPicInfo$1", "Lcom/tencent/mm/graphics/model/OnImageLoadEventListenerAdapter;", "onImageLoadError", "", "result", "Lcom/davemorrissey/labs/subscaleview/decoder/ImageDecodeResult;", "onImageLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onPreviewLoadError", "onTileLoadError", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bw$e
  extends c
{
  bw$e(WxImageView paramWxImageView) {}
  
  public final void onImageLoadError(ImageDecodeResult paramImageDecodeResult)
  {
    AppMethodBeat.i(354060);
    s.u(paramImageDecodeResult, "result");
    Log.w("FinderLiveScreenShareWidget", s.X("onImageLoadError, result:", paramImageDecodeResult));
    AppMethodBeat.o(354060);
  }
  
  public final void onImageLoaded(Bitmap paramBitmap)
  {
    AppMethodBeat.i(354050);
    s.u(paramBitmap, "bitmap");
    Log.d("FinderLiveScreenShareWidget", "wxImageView, onImageLoaded.");
    this.DiV.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
    this.DiV.jma();
    AppMethodBeat.o(354050);
  }
  
  public final void onPreviewLoadError(ImageDecodeResult paramImageDecodeResult)
  {
    AppMethodBeat.i(354056);
    s.u(paramImageDecodeResult, "result");
    Log.d("FinderLiveScreenShareWidget", s.X("wxImageView, onPreviewLoadError. result:", paramImageDecodeResult));
    AppMethodBeat.o(354056);
  }
  
  public final void onTileLoadError(ImageDecodeResult paramImageDecodeResult)
  {
    AppMethodBeat.i(354066);
    s.u(paramImageDecodeResult, "result");
    Log.w("FinderLiveScreenShareWidget", s.X("onTileLoadError, result:", paramImageDecodeResult));
    AppMethodBeat.o(354066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bw.e
 * JD-Core Version:    0.7.0.1
 */