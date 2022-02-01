package com.tencent.mm.plugin.appbrand.ag.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/widget/AppBrandThumbVideoView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/BaseVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createVideoTextureView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/IVideoView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends BaseVideoView
{
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(317904);
    AppMethodBeat.o(317904);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a eS(Context paramContext)
  {
    AppMethodBeat.i(317912);
    s.u(paramContext, "context");
    this.sJh = 2;
    paramContext = (com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a)new a(paramContext);
    AppMethodBeat.o(317912);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.a.b
 * JD-Core Version:    0.7.0.1
 */