package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;

public final class b
  extends BaseVideoView
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a dF(Context paramContext)
  {
    AppMethodBeat.i(211512);
    this.lxL = 1;
    paramContext = new a(paramContext);
    AppMethodBeat.o(211512);
    return paramContext;
  }
  
  public final TextureView getVideoTexture()
  {
    return (TextureView)this.lxG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.b
 * JD-Core Version:    0.7.0.1
 */