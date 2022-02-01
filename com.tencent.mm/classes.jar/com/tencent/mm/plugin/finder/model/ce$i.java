package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.c;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.upload.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/model/SetProfileCoverViewModel$uploadCover$2$2", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ce$i
  implements e<c>
{
  ce$i(p<? super String> paramp) {}
  
  public final void a(c paramc, i parami)
  {
    AppMethodBeat.i(332123);
    s.u(paramc, "task");
    s.u(parami, "status");
    Log.i("Finder.SetProfileCoverViewModel", "onLoaderFin status:" + parami + " url:" + ((k)paramc).coverUrl);
    if ((parami == i.nrG) && (!Util.isNullOrNil(((k)paramc).coverUrl)))
    {
      parami = (d)this.EDL;
      paramc = ((k)paramc).coverUrl;
      Result.Companion localCompanion = Result.Companion;
      parami.resumeWith(Result.constructor-impl(paramc));
      AppMethodBeat.o(332123);
      return;
    }
    paramc = (d)this.EDL;
    parami = Result.Companion;
    paramc.resumeWith(Result.constructor-impl(""));
    AppMethodBeat.o(332123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ce.i
 * JD-Core Version:    0.7.0.1
 */