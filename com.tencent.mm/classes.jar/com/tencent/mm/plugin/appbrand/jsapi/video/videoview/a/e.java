package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

public class e
  extends BaseVideoView
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public a dY(Context paramContext)
  {
    AppMethodBeat.i(227060);
    this.pDV = 1;
    paramContext = new d(paramContext);
    AppMethodBeat.o(227060);
    return paramContext;
  }
  
  public TextureView getVideoTexture()
  {
    return (TextureView)this.pDQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e
 * JD-Core Version:    0.7.0.1
 */