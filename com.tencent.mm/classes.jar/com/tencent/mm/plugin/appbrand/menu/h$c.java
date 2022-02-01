package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive$GameLiveStateChangeEndReason;", "", "(Ljava/lang/String;I)V", "GameLiveStateChangeEndReason_Unkown", "GameLiveStateChangeEndReason_WeAppMenu", "GameLiveStateChangeEndReason_WeAppExit", "GameLiveStateChangeEndReason_JsApi", "GameLiveStateChangeEndReason_Finder", "plugin-appbrand-integration_release"})
public enum h$c
{
  static
  {
    AppMethodBeat.i(281146);
    c localc1 = new c("GameLiveStateChangeEndReason_Unkown", 0);
    qff = localc1;
    c localc2 = new c("GameLiveStateChangeEndReason_WeAppMenu", 1);
    qfg = localc2;
    c localc3 = new c("GameLiveStateChangeEndReason_WeAppExit", 2);
    qfh = localc3;
    c localc4 = new c("GameLiveStateChangeEndReason_JsApi", 3);
    qfi = localc4;
    c localc5 = new c("GameLiveStateChangeEndReason_Finder", 4);
    qfj = localc5;
    qfk = new c[] { localc1, localc2, localc3, localc4, localc5 };
    AppMethodBeat.o(281146);
  }
  
  private h$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.h.c
 * JD-Core Version:    0.7.0.1
 */