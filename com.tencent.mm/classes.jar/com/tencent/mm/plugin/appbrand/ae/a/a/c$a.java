package com.tencent.mm.plugin.appbrand.ae.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/video/player/thumb/ThumbPlayerInitLogic$initIfNeedInner$1", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "tpPlayerTag", "", "d", "", "tag", "msg", "e", "i", "v", "w", "plugin-compat_release"})
public final class c$a
  implements TPPlayerMgr.OnLogListener
{
  private final String rkm = "MicroMsg.AppBrand.TPPlayer";
  
  public final int d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207418);
    Log.d(this.rkm, paramString1 + ':' + paramString2);
    AppMethodBeat.o(207418);
    return 0;
  }
  
  public final int e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207421);
    Log.e(this.rkm, paramString1 + ':' + paramString2);
    AppMethodBeat.o(207421);
    return 0;
  }
  
  public final int i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207419);
    Log.i(this.rkm, paramString1 + ':' + paramString2);
    AppMethodBeat.o(207419);
    return 0;
  }
  
  public final int v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207417);
    Log.v(this.rkm, paramString1 + ':' + paramString2);
    AppMethodBeat.o(207417);
    return 0;
  }
  
  public final int w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207420);
    Log.w(this.rkm, paramString1 + ':' + paramString2);
    AppMethodBeat.o(207420);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */