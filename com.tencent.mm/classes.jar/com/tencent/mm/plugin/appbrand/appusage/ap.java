package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajs;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic;", "", "()V", "mReceiver", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "clear", "", "notifyReceiver", "entrances", "", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "registerEntranceInfoUpdateReceiverForId", "receiver", "requestEntranceInfo", "unregisterEntranceInfoUpdateReceiverForId", "Companion", "EntranceId", "EntranceInfoUpdateReceiver", "ShowCaseType", "plugin-appbrand-integration_release"})
public final class ap
{
  public static final a kWn;
  public final Map<b, List<c>> kWm;
  
  static
  {
    AppMethodBeat.i(180446);
    kWn = new a((byte)0);
    AppMethodBeat.o(180446);
  }
  
  public ap()
  {
    AppMethodBeat.i(180445);
    this.kWm = ((Map)new LinkedHashMap());
    AppMethodBeat.o(180445);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "(Ljava/lang/String;I)V", "ENTRANCE_ID_NONE", "ENTRANCE_ID_NEARBY", "ENTRANCE_ID_LIVE", "ENTRANCE_ID_FRIENDS_USING", "Companion", "plugin-appbrand-integration_release"})
  public static enum b
  {
    public static final a kWt;
    
    static
    {
      AppMethodBeat.i(180436);
      b localb1 = new b("ENTRANCE_ID_NONE", 0);
      kWo = localb1;
      b localb2 = new b("ENTRANCE_ID_NEARBY", 1);
      kWp = localb2;
      b localb3 = new b("ENTRANCE_ID_LIVE", 2);
      kWq = localb3;
      b localb4 = new b("ENTRANCE_ID_FRIENDS_USING", 3);
      kWr = localb4;
      kWs = new b[] { localb1, localb2, localb3, localb4 };
      kWt = new a((byte)0);
      AppMethodBeat.o(180436);
    }
    
    private b() {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "id", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "onEntranceInfoUpdate", "", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(ajs paramajs);
    
    public abstract ap.b byw();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "", "(Ljava/lang/String;I)V", "TYPE_NULL", "TYPE_WORDING", "TYPE_ICON_WORDING", "TYPE_ICON_WORDING_ICON2", "TYPE_WORDING_ICON", "Companion", "plugin-appbrand-integration_release"})
  public static enum d
  {
    public static final a kWA;
    
    static
    {
      AppMethodBeat.i(180439);
      d locald1 = new d("TYPE_NULL", 0);
      kWu = locald1;
      d locald2 = new d("TYPE_WORDING", 1);
      kWv = locald2;
      d locald3 = new d("TYPE_ICON_WORDING", 2);
      kWw = locald3;
      d locald4 = new d("TYPE_ICON_WORDING_ICON2", 3);
      kWx = locald4;
      d locald5 = new d("TYPE_WORDING_ICON", 4);
      kWy = locald5;
      kWz = new d[] { locald1, locald2, locald3, locald4, locald5 };
      kWA = new a((byte)0);
      AppMethodBeat.o(180439);
    }
    
    private d() {}
    
    public static final d wb(int paramInt)
    {
      AppMethodBeat.i(180442);
      d[] arrayOfd = values();
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        if (paramInt == locald.ordinal())
        {
          AppMethodBeat.o(180442);
          return locald;
        }
        i += 1;
      }
      AppMethodBeat.o(180442);
      return null;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "id", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ap
 * JD-Core Version:    0.7.0.1
 */