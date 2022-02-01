package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper$preRender$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-finder_release"})
public final class s$b
  implements f
{
  s$b(a parama, g paramg, long paramLong) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(264184);
    s locals = s.xWG;
    Log.i(s.getTAG(), "prerender mini pro fail,errCode:" + paramInt + ",errMsg:" + paramString);
    if (this.xWL)
    {
      paramString = s.xWG;
      s.e(this.xWJ);
      paramString = s.xWG;
      s.dwT();
    }
    if (this.xWI != null)
    {
      paramString = u.xWQ;
      u.a(this.xWI, this.xWJ, this.xWK, System.currentTimeMillis());
    }
    AppMethodBeat.o(264184);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(264182);
    Object localObject = s.xWG;
    Log.i(s.getTAG(), "prerender mini pro success!");
    if (this.xWI != null)
    {
      localObject = u.xWQ;
      u.a(this.xWI, this.xWJ, this.xWK, System.currentTimeMillis());
    }
    AppMethodBeat.o(264182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.s.b
 * JD-Core Version:    0.7.0.1
 */