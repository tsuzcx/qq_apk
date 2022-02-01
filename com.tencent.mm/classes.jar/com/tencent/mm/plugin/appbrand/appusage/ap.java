package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic;", "", "()V", "mReceiver", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "clear", "", "notifyReceiver", "entrances", "", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "registerEntranceInfoUpdateReceiverForId", "receiver", "requestEntranceInfo", "unregisterEntranceInfoUpdateReceiverForId", "Companion", "EntranceId", "EntranceInfoUpdateReceiver", "ShowCaseType", "plugin-appbrand-integration_release"})
public final class ap
{
  public static final a jTz;
  public final Map<b, List<c>> jTy;
  
  static
  {
    AppMethodBeat.i(180446);
    jTz = new a((byte)0);
    AppMethodBeat.o(180446);
  }
  
  public ap()
  {
    AppMethodBeat.i(180445);
    this.jTy = ((Map)new LinkedHashMap());
    AppMethodBeat.o(180445);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "", "(Ljava/lang/String;I)V", "ENTRANCE_ID_NONE", "ENTRANCE_ID_NEARBY", "ENTRANCE_ID_LIVE", "ENTRANCE_ID_FRIENDS_USING", "Companion", "plugin-appbrand-integration_release"})
  public static enum b
  {
    public static final a jTF;
    
    static
    {
      AppMethodBeat.i(180436);
      b localb1 = new b("ENTRANCE_ID_NONE", 0);
      jTA = localb1;
      b localb2 = new b("ENTRANCE_ID_NEARBY", 1);
      jTB = localb2;
      b localb3 = new b("ENTRANCE_ID_LIVE", 2);
      jTC = localb3;
      b localb4 = new b("ENTRANCE_ID_FRIENDS_USING", 3);
      jTD = localb4;
      jTE = new b[] { localb1, localb2, localb3, localb4 };
      jTF = new a((byte)0);
      AppMethodBeat.o(180436);
    }
    
    private b() {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "id", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceInfoUpdateReceiver;", "", "getEntranceId", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$EntranceId;", "onEntranceInfoUpdate", "", "info", "Lcom/tencent/mm/protocal/protobuf/EntranceInfo;", "plugin-appbrand-integration_release"})
  public static abstract interface c
  {
    public abstract void a(ahg paramahg);
    
    public abstract ap.b bdh();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType$Companion;", "", "()V", "getByOrdinal", "Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "id", "", "plugin-appbrand-integration_release"})
  public static final class d$a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$requestEntranceInfo$locationCallback$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-appbrand-integration_release"})
  public static final class e
    implements com.tencent.mm.modelgeo.b.a
  {
    public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
    {
      AppMethodBeat.i(180444);
      d.aIh().c((com.tencent.mm.modelgeo.b.a)this);
      f.bj(this);
      com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
      locala.oS(3752);
      locala.DN("/cgi-bin/mmbiz-bin/wxaapp/getwxadesktopentrance");
      bmk localbmk = new bmk();
      localbmk.GZH = paramFloat1;
      localbmk.GZI = paramFloat2;
      locala.c((a)localbmk);
      locala.d((a)new bml());
      x.a(locala.aDS(), (x.a)new a(this), true);
      AppMethodBeat.o(180444);
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a
      implements x.a
    {
      a(ap.e parame) {}
      
      public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
      {
        AppMethodBeat.i(180443);
        p.g(paramb, "rr");
        paramb = paramb.aEV();
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && ((paramb instanceof bml)))
        {
          paramString = this.jTO.jTN;
          paramb = ((bml)paramb).GZJ;
          p.g(paramb, "resp.entrance_info");
          ap.a(paramString, (List)paramb);
        }
        for (;;)
        {
          AppMethodBeat.o(180443);
          return 0;
          ae.e("WxaDesktopEntranceShowLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ap
 * JD-Core Version:    0.7.0.1
 */