package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic;", "", "()V", "mReceiver", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "clear", "", "notifyReceiver", "entrances", "", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "registerEntranceInfoUpdateReceiverForId", "receiver", "requestEntranceInfo", "unregisterEntranceInfoUpdateReceiverForId", "Companion", "EntranceId", "EntranceInfoUpdateReceiver", "ShowCaseType", "plugin-appbrand-integration_release"})
public final class ap
{
  public static final a jQh;
  public final Map<b, List<c>> jQg;
  
  static
  {
    AppMethodBeat.i(180446);
    jQh = new a((byte)0);
    AppMethodBeat.o(180446);
  }
  
  public ap()
  {
    AppMethodBeat.i(180445);
    this.jQg = ((Map)new LinkedHashMap());
    AppMethodBeat.o(180445);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "(Ljava/lang/String;I)V", "ENTRANCE_ID_NONE", "ENTRANCE_ID_NEARBY", "ENTRANCE_ID_LIVE", "ENTRANCE_ID_FRIENDS_USING", "Companion", "plugin-appbrand-integration_release"})
  public static enum b
  {
    public static final a jQn;
    
    static
    {
      AppMethodBeat.i(180436);
      b localb1 = new b("ENTRANCE_ID_NONE", 0);
      jQi = localb1;
      b localb2 = new b("ENTRANCE_ID_NEARBY", 1);
      jQj = localb2;
      b localb3 = new b("ENTRANCE_ID_LIVE", 2);
      jQk = localb3;
      b localb4 = new b("ENTRANCE_ID_FRIENDS_USING", 3);
      jQl = localb4;
      jQm = new b[] { localb1, localb2, localb3, localb4 };
      jQn = new a((byte)0);
      AppMethodBeat.o(180436);
    }
    
    private b() {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "id", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "onEntranceInfoUpdate", "", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(agw paramagw);
    
    public abstract ap.b bcC();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "id", "", "plugin-appbrand-integration_release"})
  public static final class d$a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$requestEntranceInfo$locationCallback$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-appbrand-integration_release"})
  public static final class e
    implements com.tencent.mm.modelgeo.b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(180444);
      d.aHQ().c((com.tencent.mm.modelgeo.b.a)this);
      e.bj(this);
      com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
      locala.oP(3752);
      locala.Dl("/cgi-bin/mmbiz-bin/wxaapp/getwxadesktopentrance");
      bls localbls = new bls();
      localbls.GGf = paramFloat1;
      localbls.GGg = paramFloat2;
      locala.c((a)localbls);
      locala.d((a)new blt());
      x.a(locala.aDC(), (x.a)new a(this), true);
      AppMethodBeat.o(180444);
      return false;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a
      implements x.a
    {
      a(ap.e parame) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
      {
        AppMethodBeat.i(180443);
        p.g(paramb, "rr");
        paramb = paramb.aEF();
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && ((paramb instanceof blt)))
        {
          paramString = this.jQw.jQv;
          paramb = ((blt)paramb).GGh;
          p.g(paramb, "resp.entrance_info");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ap
 * JD-Core Version:    0.7.0.1
 */