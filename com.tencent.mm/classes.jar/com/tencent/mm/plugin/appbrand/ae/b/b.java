package com.tencent.mm.plugin.appbrand.ae.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/widget/AppBrandThumbVideoView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/BaseVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createVideoTextureView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/IVideoView;", "plugin-appbrand-integration_release"})
public final class b
  extends BaseVideoView
{
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(279539);
    AppMethodBeat.o(279539);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a dY(Context paramContext)
  {
    AppMethodBeat.i(279538);
    p.k(paramContext, "context");
    this.pDV = 2;
    paramContext = (com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a)new a(paramContext);
    AppMethodBeat.o(279538);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.b.b
 * JD-Core Version:    0.7.0.1
 */