package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import java.lang.ref.WeakReference;

final class PluginMessenger$5$1
  extends com.tencent.mm.plugin.messenger.a.a
{
  PluginMessenger$5$1(PluginMessenger.5 param5, WeakReference paramWeakReference, String paramString1, String paramString2, long paramLong)
  {
    super(1, null);
  }
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(213023);
    try
    {
      if (this.iVY.get() != null)
      {
        paramView = new LiveConfig.a();
        paramView.kic = LiveConfig.khY;
        paramView.kid = this.EUq;
        paramView.kig = this.EUr;
        paramView.liveId = this.EUs;
        paramView.scene = LiveConfig.khU;
        paramView = paramView.aJw();
        ((com.tencent.mm.live.a)h.ag(com.tencent.mm.live.a.class)).liveEntranceJumper().d((Context)this.iVY.get(), paramView);
      }
      AppMethodBeat.o(213023);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(213023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.5.1
 * JD-Core Version:    0.7.0.1
 */