package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ct$d
  implements c
{
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(354864);
    Log.i("Finder.FinderLiveVisitorPreviewPlugin", "on exit room finish");
    AppMethodBeat.o(354864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ct.d
 * JD-Core Version:    0.7.0.1
 */