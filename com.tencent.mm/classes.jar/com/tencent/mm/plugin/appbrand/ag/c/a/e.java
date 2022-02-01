package com.tencent.mm.plugin.appbrand.ag.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/widget/ThumbVideoView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/BaseVideoView;", "context", "Landroid/content/Context;", "mp4Only", "", "(Landroid/content/Context;Z)V", "createVideoTextureView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/videoview/IVideoView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends BaseVideoView
{
  private final boolean usR;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(317913);
    this.usR = false;
    AppMethodBeat.o(317913);
  }
  
  public final a eS(Context paramContext)
  {
    AppMethodBeat.i(317922);
    s.u(paramContext, "context");
    this.sJh = 2;
    paramContext = (a)new d(paramContext, this.usR);
    AppMethodBeat.o(317922);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.a.e
 * JD-Core Version:    0.7.0.1
 */