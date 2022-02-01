package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.e;
import com.tencent.mm.plugin.finder.preload.g;
import com.tencent.mm.plugin.findersdk.a.bk.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/service/FinderFeedDetailService$FinderPreloadVideoService$preloadVideoWorker$2$2$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "onCancel", "", "mediaId", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "receivedSize", "", "onReject", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$b$a$a
  implements e
{
  e$b$a$a(e.b paramb) {}
  
  public final void B(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(330190);
    s.u(paramString, "mediaId");
    AppMethodBeat.o(330190);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, g paramg)
  {
    AppMethodBeat.i(330184);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "fileFormat");
    s.u(paramString3, "codingFormat");
    s.u(paramg, "task");
    paramString1 = this.FyZ.FyY;
    if (paramString1 != null) {
      paramString1.rl(paramg.feedId);
    }
    AppMethodBeat.o(330184);
  }
  
  public final void a(String paramString, g paramg)
  {
    AppMethodBeat.i(330220);
    s.u(paramString, "mediaId");
    s.u(paramg, "task");
    paramString = this.FyZ.FyY;
    if (paramString != null) {
      paramString.rm(paramg.feedId);
    }
    AppMethodBeat.o(330220);
  }
  
  public final void a(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(330204);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "msg");
    s.u(paramg, "task");
    paramString1 = this.FyZ.FyY;
    if (paramString1 != null) {
      paramString1.rm(paramg.feedId);
    }
    AppMethodBeat.o(330204);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, g paramg, long paramLong)
  {
    AppMethodBeat.i(330195);
    s.u(paramString, "mediaId");
    s.u(paramg, "task");
    paramString = this.FyZ.FyY;
    if (paramString != null) {
      paramString.a(paramg.feedId, paramBoolean, paramInt, paramLong);
    }
    AppMethodBeat.o(330195);
  }
  
  public final void azf(String paramString)
  {
    AppMethodBeat.i(330211);
    s.u(paramString, "mediaId");
    AppMethodBeat.o(330211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.e.b.a.a
 * JD-Core Version:    0.7.0.1
 */