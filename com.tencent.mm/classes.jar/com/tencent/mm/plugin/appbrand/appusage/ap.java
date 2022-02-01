package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic;", "", "()V", "mReceiver", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "clear", "", "notifyReceiver", "entrances", "", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "registerEntranceInfoUpdateReceiverForId", "receiver", "requestEntranceInfo", "unregisterEntranceInfoUpdateReceiverForId", "Companion", "EntranceId", "EntranceInfoUpdateReceiver", "ShowCaseType", "plugin-appbrand-integration_release"})
public final class ap
{
  public static final a iVV;
  public final Map<b, List<c>> iVU;
  
  static
  {
    AppMethodBeat.i(180446);
    iVV = new a((byte)0);
    AppMethodBeat.o(180446);
  }
  
  public ap()
  {
    AppMethodBeat.i(180445);
    this.iVU = ((Map)new LinkedHashMap());
    AppMethodBeat.o(180445);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "(Ljava/lang/String;I)V", "ENTRANCE_ID_NONE", "ENTRANCE_ID_NEARBY", "ENTRANCE_ID_LIVE", "ENTRANCE_ID_FRIENDS_USING", "Companion", "plugin-appbrand-integration_release"})
  public static enum b
  {
    public static final a iWb;
    
    static
    {
      AppMethodBeat.i(180436);
      b localb1 = new b("ENTRANCE_ID_NONE", 0);
      iVW = localb1;
      b localb2 = new b("ENTRANCE_ID_NEARBY", 1);
      iVX = localb2;
      b localb3 = new b("ENTRANCE_ID_LIVE", 2);
      iVY = localb3;
      b localb4 = new b("ENTRANCE_ID_FRIENDS_USING", 3);
      iVZ = localb4;
      iWa = new b[] { localb1, localb2, localb3, localb4 };
      iWb = new a((byte)0);
      AppMethodBeat.o(180436);
    }
    
    private b() {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "id", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "onEntranceInfoUpdate", "", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(ado paramado);
    
    public abstract ap.b aSh();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "", "(Ljava/lang/String;I)V", "TYPE_NULL", "TYPE_WORDING", "TYPE_ICON_WORDING", "TYPE_ICON_WORDING_ICON2", "TYPE_WORDING_ICON", "Companion", "plugin-appbrand-integration_release"})
  public static enum d
  {
    public static final a iWi;
    
    static
    {
      AppMethodBeat.i(180439);
      d locald1 = new d("TYPE_NULL", 0);
      iWc = locald1;
      d locald2 = new d("TYPE_WORDING", 1);
      iWd = locald2;
      d locald3 = new d("TYPE_ICON_WORDING", 2);
      iWe = locald3;
      d locald4 = new d("TYPE_ICON_WORDING_ICON2", 3);
      iWf = locald4;
      d locald5 = new d("TYPE_WORDING_ICON", 4);
      iWg = locald5;
      iWh = new d[] { locald1, locald2, locald3, locald4, locald5 };
      iWi = new a((byte)0);
      AppMethodBeat.o(180439);
    }
    
    private d() {}
    
    public static final d qP(int paramInt)
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
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "id", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$requestEntranceInfo$locationCallback$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-appbrand-integration_release"})
  public static final class e
    implements com.tencent.mm.modelgeo.b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(180444);
      d.axT().c((com.tencent.mm.modelgeo.b.a)this);
      e.bk(this);
      com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
      locala.nB(3752);
      locala.wg("/cgi-bin/mmbiz-bin/wxaapp/getwxadesktopentrance");
      bds localbds = new bds();
      localbds.DBm = paramFloat1;
      localbds.DBn = paramFloat2;
      locala.c((a)localbds);
      locala.d((a)new bdt());
      x.a(locala.atI(), (x.a)new a(this), true);
      AppMethodBeat.o(180444);
      return false;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a
      implements x.a
    {
      a(ap.e parame) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
      {
        AppMethodBeat.i(180443);
        k.g(paramb, "rr");
        paramb = paramb.auM();
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && ((paramb instanceof bdt)))
        {
          paramString = this.iWk.iWj;
          paramb = ((bdt)paramb).DBo;
          k.g(paramb, "resp.entrance_info");
          ap.a(paramString, (List)paramb);
        }
        for (;;)
        {
          AppMethodBeat.o(180443);
          return 0;
          ad.e("WxaDesktopEntranceShowLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ap
 * JD-Core Version:    0.7.0.1
 */