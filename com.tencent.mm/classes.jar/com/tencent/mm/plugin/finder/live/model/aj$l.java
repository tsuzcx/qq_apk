package com.tencent.mm.plugin.finder.live.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$enterRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj$l
  implements c
{
  aj$l(b<? super Integer, ah> paramb) {}
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(359818);
    this.mUv.invoke(Integer.valueOf(paramInt));
    AppMethodBeat.o(359818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aj.l
 * JD-Core Version:    0.7.0.1
 */