package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$requestEntranceInfo$locationCallback$1", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "onGetLocation", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "speed", "", "accuracy", "altitude", "plugin-appbrand-integration_release"})
public final class ap$e
  implements b.a
{
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(180444);
    com.tencent.mm.modelgeo.d.blq().b((b.a)this);
    h.bs(this);
    d.a locala = new d.a();
    locala.vD(3752);
    locala.TW("/cgi-bin/mmbiz-bin/wxaapp/getwxadesktopentrance");
    cgv localcgv = new cgv();
    localcgv.Toj = paramFloat1;
    localcgv.Tok = paramFloat2;
    locala.c((a)localcgv);
    locala.d((a)new cgw());
    aa.a(locala.bgN(), (aa.a)new a(this), true);
    AppMethodBeat.o(180444);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(ap.e parame) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, q paramq)
    {
      AppMethodBeat.i(180443);
      p.j(paramd, "rr");
      paramd = paramd.bhY();
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && ((paramd instanceof cgw)))
      {
        paramString = this.nQP.nQO;
        paramd = ((cgw)paramd).Tol;
        p.j(paramd, "resp.entrance_info");
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