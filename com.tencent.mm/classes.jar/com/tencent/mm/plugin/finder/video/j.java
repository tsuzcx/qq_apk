package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPOptionalParam;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerParamFactory;", "", "()V", "TAG", "", "getTPOptionalParam", "Lcom/tencent/thumbplayer/api/TPOptionalParam;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j GoW;
  
  static
  {
    AppMethodBeat.i(334743);
    GoW = new j();
    AppMethodBeat.o(334743);
  }
  
  public static TPOptionalParam fje()
  {
    AppMethodBeat.i(334737);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zdA, false);
    Log.i("Finder.FinderThumbPlayerParamFactory", s.X("getTPOptionalParam ", Boolean.valueOf(bool)));
    if (bool)
    {
      localTPOptionalParam = new TPOptionalParam().buildLong(203, 3L);
      s.s(localTPOptionalParam, "{\n            TPOptional…_ONLY.toLong())\n        }");
      AppMethodBeat.o(334737);
      return localTPOptionalParam;
    }
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildBoolean(123, false);
    s.s(localTPOptionalParam, "{\n            var enable…ediaCodecReuse)\n        }");
    AppMethodBeat.o(334737);
    return localTPOptionalParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.j
 * JD-Core Version:    0.7.0.1
 */