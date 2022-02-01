package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.preload.model.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$1", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "onCancel", "", "mediaId", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
public final class b$1
  implements com.tencent.mm.plugin.finder.preload.b
{
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(202638);
    k.h(paramString1, "mediaId");
    k.h(paramString2, "fileFormat");
    k.h(paramString3, "codingFormat");
    k.h(paramc, "task");
    AppMethodBeat.o(202638);
  }
  
  public final void a(String paramString1, String paramString2, com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(202641);
    k.h(paramString1, "mediaId");
    k.h(paramString2, "msg");
    k.h(paramc, "task");
    b.h(this.rwi);
    AppMethodBeat.o(202641);
  }
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.finder.preload.c paramc)
  {
    AppMethodBeat.i(202640);
    k.h(paramString, "mediaId");
    k.h(paramc, "task");
    if (b.f(this.rwi).rvE)
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.aei(paramString);
      MediaPreloadCore.a locala = MediaPreloadCore.rvo;
      if ((!MediaPreloadCore.a.a((w)localObject).rvp) && (!paramBoolean))
      {
        ac.w(b.b(this.rwi), "Moov failure! try to download all! ".concat(String.valueOf(localObject)));
        b.a(this.rwi, paramString, false);
        paramc.frB = 100;
        paramc.field_preloadRatio = 100;
        b.a(this.rwi, paramc);
        AppMethodBeat.o(202640);
        return;
      }
    }
    b.h(this.rwi);
    AppMethodBeat.o(202640);
  }
  
  public final void adG(String paramString)
  {
    AppMethodBeat.i(202642);
    k.h(paramString, "mediaId");
    ac.e(b.b(this.rwi), "[onFormatChange] mediaId=".concat(String.valueOf(paramString)));
    b.a(this.rwi, paramString, false);
    com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
    i.deleteFile(com.tencent.mm.plugin.finder.storage.logic.c.aei(paramString).getFilePath());
    localc = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
    com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, 0L, 0L, -2);
    AppMethodBeat.o(202642);
  }
  
  public final void cZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(202639);
    k.h(paramString, "mediaId");
    AppMethodBeat.o(202639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b.1
 * JD-Core Version:    0.7.0.1
 */