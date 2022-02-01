package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$requestEntranceInfo$locationCallback$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-appbrand-integration_release"})
public final class ap$e
  implements b.a
{
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(180444);
    com.tencent.mm.modelgeo.d.bca().c((b.a)this);
    f.bs(this);
    d.a locala = new d.a();
    locala.sG(3752);
    locala.MB("/cgi-bin/mmbiz-bin/wxaapp/getwxadesktopentrance");
    bzb localbzb = new bzb();
    localbzb.MeH = paramFloat1;
    localbzb.MeI = paramFloat2;
    locala.c((a)localbzb);
    locala.d((a)new bzc());
    aa.a(locala.aXF(), (aa.a)new a(this), true);
    AppMethodBeat.o(180444);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(ap.e parame) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.d paramd, q paramq)
    {
      AppMethodBeat.i(180443);
      p.g(paramd, "rr");
      paramd = paramd.aYK();
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && ((paramd instanceof bzc)))
      {
        paramString = this.kWC.kWB;
        paramd = ((bzc)paramd).MeJ;
        p.g(paramd, "resp.entrance_info");
        ap.a(paramString, (List)paramd);
      }
      for (;;)
      {
        AppMethodBeat.o(180443);
        return 0;
        Log.e("WxaDesktopEntranceShowLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ap.e
 * JD-Core Version:    0.7.0.1
 */