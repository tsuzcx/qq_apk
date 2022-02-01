package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/MiniProgramUICallback;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "liveRoomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "halfScreenChangeListener", "Lcom/tencent/mm/plugin/finder/live/MiniProgramHalfScreenStatusChangeListener;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/MiniProgramHalfScreenStatusChangeListener;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "plugin-finder_release"})
public final class v
  implements i
{
  private final String TAG;
  private final a xWR;
  private final MiniProgramHalfScreenStatusChangeListener xWS;
  
  public v(a parama, MiniProgramHalfScreenStatusChangeListener paramMiniProgramHalfScreenStatusChangeListener)
  {
    this.xWR = parama;
    this.xWS = paramMiniProgramHalfScreenStatusChangeListener;
    this.TAG = "MiniProgramUICallback";
  }
  
  public final void bFd()
  {
    AppMethodBeat.i(264729);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject = this.xWR;
    if (localObject != null)
    {
      localObject = (c)((a)localObject).business(c.class);
      if (localObject != null)
      {
        localObject = ((c)localObject).liveInfo;
        if (localObject == null) {}
      }
    }
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i(str, localObject + " luanchMiniProgram error!");
      localObject = this.xWR;
      if (localObject == null) {
        break;
      }
      localObject = (j)((a)localObject).business(j.class);
      if (localObject == null) {
        break;
      }
      ((j)localObject).ziO = false;
      AppMethodBeat.o(264729);
      return;
    }
    AppMethodBeat.o(264729);
  }
  
  public final void bFe()
  {
    AppMethodBeat.i(264730);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject = this.xWR;
    if (localObject != null)
    {
      localObject = (c)((a)localObject).business(c.class);
      if (localObject != null)
      {
        localObject = ((c)localObject).liveInfo;
        if (localObject == null) {}
      }
    }
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i(str, localObject + " onAppBrandUIEnter!");
      localObject = this.xWR;
      if (localObject == null) {
        break;
      }
      localObject = (j)((a)localObject).business(j.class);
      if (localObject == null) {
        break;
      }
      ((j)localObject).ziO = true;
      AppMethodBeat.o(264730);
      return;
    }
    AppMethodBeat.o(264730);
  }
  
  public final void bFf()
  {
    AppMethodBeat.i(264732);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject = this.xWR;
    if (localObject != null)
    {
      localObject = (c)((a)localObject).business(c.class);
      if (localObject != null)
      {
        localObject = ((c)localObject).liveInfo;
        if (localObject == null) {}
      }
    }
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i(str, localObject + " onAppBrandProcessDied!");
      localObject = this.xWR;
      if (localObject == null) {
        break;
      }
      localObject = (j)((a)localObject).business(j.class);
      if (localObject == null) {
        break;
      }
      ((j)localObject).ziO = false;
      AppMethodBeat.o(264732);
      return;
    }
    AppMethodBeat.o(264732);
  }
  
  public final void hn(boolean paramBoolean)
  {
    AppMethodBeat.i(264731);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("live:");
    Object localObject = this.xWR;
    if (localObject != null)
    {
      localObject = (c)((a)localObject).business(c.class);
      if (localObject != null)
      {
        localObject = ((c)localObject).liveInfo;
        if (localObject == null) {}
      }
    }
    for (localObject = Long.valueOf(((bac)localObject).liveId);; localObject = null)
    {
      Log.i(str, localObject + " onAppBrandUIExit isFinish:" + paramBoolean + '!');
      localObject = this.xWR;
      if (localObject != null)
      {
        localObject = (j)((a)localObject).business(j.class);
        if (localObject != null) {
          ((j)localObject).ziO = false;
        }
      }
      localObject = this.xWS;
      if (localObject == null) {
        break;
      }
      Log.i("MiniProgramHalfScreenStatusChangeListener", "exitMiniPro enableMiniWindow:" + ((MiniProgramHalfScreenStatusChangeListener)localObject).xWA + ", style:" + ((MiniProgramHalfScreenStatusChangeListener)localObject).style + '!');
      if (((MiniProgramHalfScreenStatusChangeListener)localObject).style == 1) {
        ((MiniProgramHalfScreenStatusChangeListener)localObject).dwN();
      }
      AppMethodBeat.o(264731);
      return;
    }
    AppMethodBeat.o(264731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.v
 * JD-Core Version:    0.7.0.1
 */