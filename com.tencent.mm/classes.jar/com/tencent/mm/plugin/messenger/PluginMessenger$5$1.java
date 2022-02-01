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
    super(1);
  }
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(288539);
    try
    {
      if (this.lxV.get() != null)
      {
        paramView = new LiveConfig.a();
        paramView.mIy = LiveConfig.mIu;
        paramView.mIz = this.KPo;
        paramView.mIC = this.KPp;
        paramView.liveId = this.KPq;
        paramView.scene = LiveConfig.mIq;
        paramView = paramView.bcd();
        ((com.tencent.mm.live.a)h.az(com.tencent.mm.live.a.class)).liveEntranceJumper().d((Context)this.lxV.get(), paramView);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(288539);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.5.1
 * JD-Core Version:    0.7.0.1
 */