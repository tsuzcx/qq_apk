package com.tencent.mm.plugin.appbrand.ag.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/video/player/thumb/ThumbPlayerInitLogic$initIfNeedInner$1", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "tpPlayerTag", "", "d", "", "tag", "msg", "e", "i", "v", "w", "luggage-tp-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  implements TPPlayerMgr.OnLogListener
{
  private final String utg = "MicroMsg.AppBrand.TPPlayer";
  
  public final int d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318071);
    Log.d(this.utg, paramString1 + ':' + paramString2);
    AppMethodBeat.o(318071);
    return 0;
  }
  
  public final int e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318104);
    Log.e(this.utg, paramString1 + ':' + paramString2);
    AppMethodBeat.o(318104);
    return 0;
  }
  
  public final int i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318082);
    Log.i(this.utg, paramString1 + ':' + paramString2);
    AppMethodBeat.o(318082);
    return 0;
  }
  
  public final int v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318045);
    Log.v(this.utg, paramString1 + ':' + paramString2);
    AppMethodBeat.o(318045);
    return 0;
  }
  
  public final int w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318095);
    Log.w(this.utg, paramString1 + ':' + paramString2);
    AppMethodBeat.o(318095);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */