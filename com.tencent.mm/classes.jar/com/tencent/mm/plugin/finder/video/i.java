package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPOptionalParam;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerParamFactory;", "", "()V", "TAG", "", "getTPOptionalParam", "Lcom/tencent/thumbplayer/api/TPOptionalParam;", "plugin-finder_release"})
public final class i
{
  public static final i AMl;
  
  static
  {
    AppMethodBeat.i(264545);
    AMl = new i();
    AppMethodBeat.o(264545);
  }
  
  public static TPOptionalParam egZ()
  {
    AppMethodBeat.i(264543);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vMT, false);
    Log.i("Finder.FinderThumbPlayerParamFactory", "getTPOptionalParam ".concat(String.valueOf(bool)));
    if (bool)
    {
      localObject = new TPOptionalParam().buildLong(203, 3L);
      p.j(localObject, "TPOptionalParam().buildL…ATEGY_SOFT_ONLY.toLong())");
      AppMethodBeat.o(264543);
      return localObject;
    }
    Object localObject = d.AjH;
    if (((Number)d.dWv().aSr()).intValue() == 1)
    {
      localObject = d.AjH;
      if (!d.dSS()) {}
    }
    for (bool = true;; bool = false)
    {
      localObject = new TPOptionalParam().buildBoolean(123, bool);
      p.j(localObject, "TPOptionalParam().buildB…E, enableMediaCodecReuse)");
      AppMethodBeat.o(264543);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.i
 * JD-Core Version:    0.7.0.1
 */