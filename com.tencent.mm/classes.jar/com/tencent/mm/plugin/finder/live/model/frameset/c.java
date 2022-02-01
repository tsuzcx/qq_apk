package com.tencent.mm.plugin.finder.live.model.frameset;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.surface.c.f;
import com.tencent.mm.plugin.surface.d.a;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer;
import com.tencent.mm.plugin.surface.view.SurfaceAppContainer.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr;", "", "()V", "TAG", "", "appId", "frameSetRoot", "Lcom/tencent/mm/plugin/surface/render/FrameSetRoot;", "isInitialized", "", "createFrameSetRoot", "", "target", "context", "Landroid/content/Context;", "finderUserName", "objectId", "", "getFrameSetRoot", "initConfig", "onDataChange", "data", "release", "unMount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public f CMX;
  public final String TAG = "Finder.FinderLiveFrameSetSurfaceMgr";
  public final String appId = "wx9e221f7828fa7482";
  public boolean baY;
  
  public final void a(Object paramObject, Context paramContext, String paramString, long paramLong)
  {
    AppMethodBeat.i(359828);
    s.u(paramObject, "target");
    s.u(paramContext, "context");
    s.u(paramString, "finderUserName");
    if (this.CMX == null)
    {
      SurfaceAppContainer.a locala = SurfaceAppContainer.SLJ;
      this.CMX = SurfaceAppContainer.a.b(paramObject, paramContext, this.appId, "frames", "?finderUsername=" + paramString + "&objectId=" + d.hF(paramLong));
    }
    Log.i(this.TAG, "createFrameSetRoot");
    AppMethodBeat.o(359828);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(359833);
    Log.i(this.TAG, "unMount");
    f localf = this.CMX;
    if (localf != null) {
      localf.destroy();
    }
    this.CMX = null;
    AppMethodBeat.o(359833);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetSurfaceMgr$initConfig$1$config$1", "Lcom/tencent/mm/plugin/surface/reporter/SurfaceReporter;", "reportFirstFrameRender", "", "reportJsException", "appId", "", "source", "message", "stackTrace", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.frameset.c
 * JD-Core Version:    0.7.0.1
 */