package com.tencent.mm.live.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah$d
  implements c
{
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(247354);
    Log.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
    AppMethodBeat.o(247354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.ah.d
 * JD-Core Version:    0.7.0.1
 */