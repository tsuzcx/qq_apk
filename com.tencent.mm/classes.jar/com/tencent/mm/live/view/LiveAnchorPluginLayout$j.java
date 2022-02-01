package com.tencent.mm.live.view;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveAnchorPluginLayout$stopLive$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveAnchorPluginLayout$j
  implements c
{
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(246173);
    Log.i("MicroMsg.LiveCoreAnchor", "on exitRoom finish");
    AppMethodBeat.o(246173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveAnchorPluginLayout.j
 * JD-Core Version:    0.7.0.1
 */