package com.tencent.mm.plugin.gamelive.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "clear", "", "sendLiveCommentChangeEvent", "liveCommentInfoPayload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload;", "sendLiveMuteChangeEvent", "mute", "", "volume", "", "sendLiveNetWorkEvent", "netWork", "threshold", "sendLiveStateChangeEvent", "event", "reason", "payload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveStartInfoPayload;", "Companion", "EventOnGameLiveInfo", "EventOnGameLiveMicStateChange", "EventOnGameLiveNetWorkStateChange", "LiveCommentWrapperInfoPayload", "LiveIntPayload", "LiveMemberInfoListPayload", "LiveMemberInfoPayload", "LiveNetWorkPayload", "LiveSingleCommentPayload", "LiveStartInfoPayload", "SimpleLiveStateChangePayload", "plugin-gamelive_release"})
public final class GameLiveAppbrandEventService
{
  public static final a Dmb;
  public t nAH;
  
  static
  {
    AppMethodBeat.i(208081);
    Dmb = new a((byte)0);
    AppMethodBeat.o(208081);
  }
  
  public GameLiveAppbrandEventService(t paramt)
  {
    this.nAH = paramt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$Companion;", "", "()V", "TAG", "", "plugin-gamelive_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService
 * JD-Core Version:    0.7.0.1
 */