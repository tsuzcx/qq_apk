package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.cgi.g.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$doDisableComment$1$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveBanComment$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "enable", "", "onSuccess", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$f
  implements g.a
{
  f$f(f paramf, String paramString, m<? super Boolean, ? super Boolean, ah> paramm) {}
  
  public final void qo(boolean paramBoolean)
  {
    AppMethodBeat.i(359596);
    Log.i(this.CEm.TAG, "doDisableComment success, enable:" + paramBoolean + " username:" + this.mrr);
    Object localObject = (Map)((e)this.CEm.business(e.class)).EcN;
    String str = this.mrr;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((Map)localObject).put(str, Boolean.valueOf(bool));
      localObject = this.tGw;
      if (localObject != null) {
        ((m)localObject).invoke(Boolean.TRUE, Boolean.valueOf(paramBoolean));
      }
      AppMethodBeat.o(359596);
      return;
    }
  }
  
  public final void w(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(359603);
    Log.i(this.CEm.TAG, "doDisableComment fail, enable:" + paramBoolean + " username:" + this.mrr + " errType:" + paramInt1 + " errCode:" + paramInt2);
    m localm = this.tGw;
    if (localm != null) {
      localm.invoke(Boolean.FALSE, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(359603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.f
 * JD-Core Version:    0.7.0.1
 */