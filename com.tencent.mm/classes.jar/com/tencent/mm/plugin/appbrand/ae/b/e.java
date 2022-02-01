package com.tencent.mm.plugin.appbrand.ae.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/widget/ThumbVideoView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/BaseVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createVideoTextureView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/IVideoView;", "plugin-appbrand-integration_release"})
public final class e
  extends BaseVideoView
{
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(273660);
    AppMethodBeat.o(273660);
  }
  
  public final a dY(Context paramContext)
  {
    AppMethodBeat.i(273658);
    p.k(paramContext, "context");
    this.pDV = 2;
    paramContext = (a)new d(paramContext);
    AppMethodBeat.o(273658);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.b.e
 * JD-Core Version:    0.7.0.1
 */