package com.tencent.mm.plugin.finder.live.preloader;

import android.os.Bundle;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c;
import com.tencent.mm.plugin.finder.report.av;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/preloader/LiveVisitorCoreFutureTask$preload$2$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$c
  implements c
{
  b$c(b paramb) {}
  
  public final void callback(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(350955);
    h.jXD();
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(350955);
      return;
      paramBundle = av.Fui;
      av.eNU();
      paramBundle = r.Fqi;
      r.d(this.DmW.mJH);
      Log.i("LiveVisitorCoreLoadTask", "TXLivePlayer:receive first frame");
      AppMethodBeat.o(350955);
      return;
      paramBundle = r.Fqi;
      r.eMI();
      AppMethodBeat.o(350955);
      return;
      paramBundle = r.Fqi;
      r.eMG();
      AppMethodBeat.o(350955);
      return;
      paramBundle = r.Fqi;
      r.eMH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.preloader.b.c
 * JD-Core Version:    0.7.0.1
 */