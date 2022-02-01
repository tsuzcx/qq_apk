package com.tencent.mm.plugin.gamelive;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoListPayload;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlTask$invoke$getMemberListCallback$1", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService$IGetMemberListCallback;", "getMemberList", "", "list", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoListPayload;", "plugin-gamelive_release"})
public final class PluginGameLive$c$b
  implements b.b
{
  PluginGameLive$c$b(f paramf) {}
  
  public final void a(GameLiveAppbrandEventService.LiveMemberInfoListPayload paramLiveMemberInfoListPayload)
  {
    AppMethodBeat.i(208637);
    p.k(paramLiveMemberInfoListPayload, "list");
    f localf = this.nyL;
    if (localf != null)
    {
      localf.aH(new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Dkv, null, (Parcelable)paramLiveMemberInfoListPayload, 6));
      AppMethodBeat.o(208637);
      return;
    }
    AppMethodBeat.o(208637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.PluginGameLive.c.b
 * JD-Core Version:    0.7.0.1
 */