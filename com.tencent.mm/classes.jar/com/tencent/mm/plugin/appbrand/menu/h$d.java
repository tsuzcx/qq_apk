package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive$GameLiveStateChangeEvent;", "", "(Ljava/lang/String;I)V", "GameLiveStateChangeEvent_End", "GameLiveStateChangeEvent_Start", "GameLiveStateChangeEvent_PreStart", "GameLiveStateChangeEvent_Cancel", "GameLiveStateChangeEvent_MenuClick", "plugin-appbrand-integration_release"})
public enum h$d
{
  static
  {
    AppMethodBeat.i(268732);
    d locald1 = new d("GameLiveStateChangeEvent_End", 0);
    qfl = locald1;
    d locald2 = new d("GameLiveStateChangeEvent_Start", 1);
    qfm = locald2;
    d locald3 = new d("GameLiveStateChangeEvent_PreStart", 2);
    qfn = locald3;
    d locald4 = new d("GameLiveStateChangeEvent_Cancel", 3);
    qfo = locald4;
    d locald5 = new d("GameLiveStateChangeEvent_MenuClick", 4);
    qfp = locald5;
    qfq = new d[] { locald1, locald2, locald3, locald4, locald5 };
    AppMethodBeat.o(268732);
  }
  
  private h$d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.h.d
 * JD-Core Version:    0.7.0.1
 */