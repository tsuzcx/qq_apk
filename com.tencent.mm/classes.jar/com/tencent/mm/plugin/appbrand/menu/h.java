package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "Companion", "EventOnGameStateChange", "GameLiveStateChangeEndReason", "GameLiveStateChangeEvent", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a<ah>
{
  public static final h.a tjI;
  
  static
  {
    AppMethodBeat.i(323809);
    tjI = new h.a((byte)0);
    AppMethodBeat.o(323809);
  }
  
  public h()
  {
    super(x.tkO.ordinal());
    AppMethodBeat.i(323803);
    AppMethodBeat.o(323803);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive$GameLiveStateChangeEndReason;", "", "(Ljava/lang/String;I)V", "GameLiveStateChangeEndReason_Unkown", "GameLiveStateChangeEndReason_WeAppMenu", "GameLiveStateChangeEndReason_WeAppExit", "GameLiveStateChangeEndReason_JsApi", "GameLiveStateChangeEndReason_Finder", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(323894);
      tjK = new c("GameLiveStateChangeEndReason_Unkown", 0);
      tjL = new c("GameLiveStateChangeEndReason_WeAppMenu", 1);
      tjM = new c("GameLiveStateChangeEndReason_WeAppExit", 2);
      tjN = new c("GameLiveStateChangeEndReason_JsApi", 3);
      tjO = new c("GameLiveStateChangeEndReason_Finder", 4);
      tjP = new c[] { tjK, tjL, tjM, tjN, tjO };
      AppMethodBeat.o(323894);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_GameLive$GameLiveStateChangeEvent;", "", "(Ljava/lang/String;I)V", "GameLiveStateChangeEvent_End", "GameLiveStateChangeEvent_Start", "GameLiveStateChangeEvent_PreStart", "GameLiveStateChangeEvent_Cancel", "GameLiveStateChangeEvent_MenuClick", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(323892);
      tjQ = new d("GameLiveStateChangeEvent_End", 0);
      tjR = new d("GameLiveStateChangeEvent_Start", 1);
      tjS = new d("GameLiveStateChangeEvent_PreStart", 2);
      tjT = new d("GameLiveStateChangeEvent_Cancel", 3);
      tjU = new d("GameLiveStateChangeEvent_MenuClick", 4);
      tjV = new d[] { tjQ, tjR, tjS, tjT, tjU };
      AppMethodBeat.o(323892);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.h
 * JD-Core Version:    0.7.0.1
 */