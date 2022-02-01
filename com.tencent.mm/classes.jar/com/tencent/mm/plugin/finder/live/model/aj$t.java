package com.tencent.mm.plugin.finder.live.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$release$4", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj$t
  implements c
{
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(359753);
    Log.i("Finder.FinderLiveService", "on exitRoom finish");
    AppMethodBeat.o(359753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aj.t
 * JD-Core Version:    0.7.0.1
 */