package com.tencent.mm.plugin.finder.live.gala.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/util/GalaUtils;", "", "()V", "FINLDER_LIVE_GALA_HINE_SHOW", "", "TAG", "convertGroupName", "groupId", "isNeedShowGalaHint", "", "setHasShowGalaHint", "", "hasShow", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b admb;
  
  static
  {
    AppMethodBeat.i(371139);
    admb = new b();
    AppMethodBeat.o(371139);
  }
  
  public static String bhS(String paramString)
  {
    AppMethodBeat.i(371135);
    s.u(paramString, "groupId");
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    if (localau == null)
    {
      paramString = MMApplicationContext.getString(p.h.XMx);
      s.s(paramString, "getString(R.string.finde…_gala_bottom_content_box)");
      AppMethodBeat.o(371135);
      return paramString;
    }
    paramString = aa.b(localau, paramString);
    s.s(paramString, "getDisplayName(ct, groupId)");
    AppMethodBeat.o(371135);
    return paramString;
  }
  
  public static boolean jdm()
  {
    AppMethodBeat.i(371127);
    if (h.baE().ban().getInt(at.a.aklx, 0) == 0)
    {
      AppMethodBeat.o(371127);
      return true;
    }
    AppMethodBeat.o(371127);
    return false;
  }
  
  public static void jdn()
  {
    AppMethodBeat.i(371130);
    h.baE().ban().set(at.a.aklx, Integer.valueOf(1));
    AppMethodBeat.o(371130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.d.b
 * JD-Core Version:    0.7.0.1
 */