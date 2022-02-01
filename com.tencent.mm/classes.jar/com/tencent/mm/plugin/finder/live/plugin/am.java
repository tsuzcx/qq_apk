package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicFramePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "currentFrameParam", "Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam;", "getCurrentFrameParam", "()Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam;", "setCurrentFrameParam", "(Lcom/tencent/mm/plugin/finder/live/model/frameset/FinderLiveFrameSetLayoutParam;)V", "getEntranceRoot", "()Landroid/view/ViewGroup;", "canClearScreen", "", "checkVisible", "", "mount", "resume", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends b
{
  final ViewGroup CZa;
  com.tencent.mm.plugin.finder.live.model.frameset.b CZb;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public am(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355837);
    this.CZa = paramViewGroup;
    this.nfT = paramb;
    this.TAG = "MicroMsg.FinderLiveGameDynamicFramePlugin";
    AppMethodBeat.o(355837);
  }
  
  public final void eoD()
  {
    String str1 = null;
    AppMethodBeat.i(355894);
    bgz localbgz = ((e)business(e.class)).Edj;
    if (localbgz == null)
    {
      tO(8);
      Log.e(this.TAG, "liveGameData is null");
      AppMethodBeat.o(355894);
      return;
    }
    if (!localbgz.ZQx)
    {
      AppMethodBeat.o(355894);
      return;
    }
    Object localObject;
    if (localbgz.ZQw == 0)
    {
      str1 = this.TAG;
      localObject = this.CZb;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject).id)
      {
        Log.e(str1, "game_frameset_visibility is 0, id:%s", new Object[] { localObject });
        tO(8);
        AppMethodBeat.o(355894);
        return;
      }
    }
    if (this.CZb != null)
    {
      localObject = this.CZb;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = Integer.valueOf(((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject).CMz))
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(355894);
        throw ((Throwable)localObject);
      }
      int i = ((Integer)localObject).intValue();
      if ((localbgz.ZQw & i) == 0)
      {
        String str2 = this.TAG;
        localObject = this.CZb;
        if (localObject == null) {}
        for (localObject = str1;; localObject = ((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject).id)
        {
          Log.i(str2, "frameSet id:%s is invisible, bit:%d, game_frameset_visibility:%d", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(localbgz.ZQw) });
          tO(8);
          AppMethodBeat.o(355894);
          return;
        }
      }
      if (isLandscape())
      {
        localObject = this.CZb;
        if ((localObject != null) && (!((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject).CMx)) {}
        for (i = 1; i != 0; i = 0)
        {
          Log.i(this.TAG, "not support show in landscape");
          tO(8);
          AppMethodBeat.o(355894);
          return;
        }
      }
      if (!isLandscape())
      {
        localObject = this.CZb;
        if ((localObject != null) && (!((com.tencent.mm.plugin.finder.live.model.frameset.b)localObject).CMw)) {}
        for (i = 1; i != 0; i = 0)
        {
          Log.i(this.TAG, "not support show in portrait");
          tO(8);
          AppMethodBeat.o(355894);
          return;
        }
      }
      tO(0);
      localObject = (ap)getPlugin(ap.class);
      if (localObject != null) {
        ((ap)localObject).a(localbgz);
      }
    }
    AppMethodBeat.o(355894);
  }
  
  public final boolean eoI()
  {
    com.tencent.mm.plugin.finder.live.model.frameset.b localb;
    if (this.CZb != null) {
      localb = this.CZb;
    }
    return (localb != null) && (localb.CMy == true);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355855);
    super.mount();
    AppMethodBeat.o(355855);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(355862);
    super.resume();
    AppMethodBeat.o(355862);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355879);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355879);
      return;
      eoD();
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355870);
    super.unMount();
    AppMethodBeat.o(355870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.am
 * JD-Core Version:    0.7.0.1
 */