package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/GameWelfareTaskMiniAppHelper$preRenderMiniApp$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as$a
  implements f
{
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(352612);
    Log.d("GameWelfareTaskMiniAppHelper", "#preRenderMiniApp onError errCode=" + paramInt + " errMsg=" + paramString);
    AppMethodBeat.o(352612);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(352606);
    Log.d("GameWelfareTaskMiniAppHelper", "#preRenderMiniApp onSuccess");
    AppMethodBeat.o(352606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.as.a
 * JD-Core Version:    0.7.0.1
 */