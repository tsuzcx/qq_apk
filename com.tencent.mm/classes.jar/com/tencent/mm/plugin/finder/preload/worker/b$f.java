package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.c;
import com.tencent.mm.plugin.thumbplayer.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$enqueue$3", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
public final class b$f
  implements d
{
  b$f(c paramc) {}
  
  public final void DP(int paramInt)
  {
    AppMethodBeat.i(202655);
    ac.i(b.b(this.rwi), "preload task on Start " + this.rwq.field_mediaId + ' ' + paramInt);
    b.da("startPreload", paramInt);
    AppMethodBeat.o(202655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b.f
 * JD-Core Version:    0.7.0.1
 */