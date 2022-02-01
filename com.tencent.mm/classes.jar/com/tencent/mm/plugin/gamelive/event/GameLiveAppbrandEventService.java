package com.tencent.mm.plugin.gamelive.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "setRuntime", "clear", "", "sendLiveCommentChangeEvent", "liveCommentInfoPayload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload;", "sendLiveMuteChangeEvent", "mute", "", "volume", "", "sendLiveNetWorkEvent", "netWork", "threshold", "sendLiveStateChangeEvent", "event", "reason", "payload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveStartInfoPayload;", "Companion", "EventOnGameLiveInfo", "EventOnGameLiveMicStateChange", "EventOnGameLiveNetWorkStateChange", "LiveCommentWrapperInfoPayload", "LiveCurrentRoomInfoPayload", "LiveIntPayload", "LiveMemberInfoListPayload", "LiveMemberInfoPayload", "LiveNetWorkPayload", "LivePlayGamePayLoad", "LiveSingleCommentPayload", "LiveStartInfoPayload", "LiveTopicPayload", "SimpleLiveStateChangePayload", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandEventService
{
  public static final a Jfk;
  public w qxC;
  
  static
  {
    AppMethodBeat.i(277418);
    Jfk = new a((byte)0);
    AppMethodBeat.o(277418);
  }
  
  public GameLiveAppbrandEventService(w paramw)
  {
    this.qxC = paramw;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$Companion;", "", "()V", "TAG", "", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService
 * JD-Core Version:    0.7.0.1
 */