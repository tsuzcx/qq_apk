package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.cgi.e.a;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryCreateConfig$setLiveLotterySetting$1$2", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad$b
  implements e.a
{
  ad$b(diq paramdiq) {}
  
  public final void a(bvg parambvg)
  {
    AppMethodBeat.i(352859);
    s.u(this, "this");
    AppMethodBeat.o(352859);
  }
  
  public final void am(int paramInt, long paramLong)
  {
    AppMethodBeat.i(352848);
    h.baE().ban().set(at.a.adeL, Long.valueOf(this.Czi.CJK));
    h.baE().ban().set(at.a.adeM, Integer.valueOf(this.Czi.BBE));
    Log.i("FinderLiveLotteryCreateConfig", "setLiveLotterySetting success:" + this.Czi.CJK + ", " + this.Czi.BBE + '!');
    AppMethodBeat.o(352848);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(352853);
    Log.e("FinderLiveLotteryCreateConfig", "setLiveLotterySetting fail!");
    AppMethodBeat.o(352853);
  }
  
  public final void eho()
  {
    AppMethodBeat.i(352864);
    s.u(this, "this");
    AppMethodBeat.o(352864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ad.b
 * JD-Core Version:    0.7.0.1
 */