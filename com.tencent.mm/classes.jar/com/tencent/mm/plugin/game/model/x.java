package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.er;
import com.tencent.mm.plugin.game.d.g;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class x
{
  public static c a(g paramg)
  {
    AppMethodBeat.i(41523);
    if (paramg == null)
    {
      ae.e("MicroMsg.GamePBData", "Invalid pb object");
      AppMethodBeat.o(41523);
      return null;
    }
    if (bu.isNullOrNil(paramg.gvv))
    {
      ae.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(41523);
      return null;
    }
    ae.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { paramg.gvv });
    c localc = new c();
    localc.field_appId = paramg.gvv;
    localc.field_appName = paramg.Name;
    localc.field_appIconUrl = paramg.uqq;
    localc.field_appType = ",1,";
    localc.field_packageName = paramg.uqs;
    localc.field_appVersion = paramg.Version;
    localc.field_appInfoFlag = paramg.uqv;
    if (paramg.uqu != null)
    {
      localc.sU(paramg.uqu.uru);
      localc.sX(paramg.uqu.urv);
      localc.jX(paramg.uqu.ury);
      localc.sY(paramg.uqu.urw);
      localc.ulV = paramg.uqu.urA;
      localc.myB = paramg.uqu.urz;
      localc.dvO = paramg.uqu.urB;
    }
    if ((paramg.uqu != null) && (paramg.uqu.urx != null))
    {
      localc.td(paramg.uqu.urx.uru);
      localc.te(paramg.uqu.urx.uvR);
      localc.tb(paramg.uqu.urx.uvS);
      localc.tc(paramg.uqu.urx.uvT);
      localc.jY(paramg.uqu.urx.uvV);
    }
    localc.ulD = paramg.Desc;
    localc.ulC = paramg.uqr;
    localc.status = paramg.nJb;
    localc.ulF = paramg.uqi;
    localc.versionCode = paramg.uqt;
    localc.dmu = paramg.uqn;
    localc.iEF = paramg.uqw;
    localc.ulO = paramg.uqB;
    if ((paramg.uqu != null) && (paramg.uqu.urx != null))
    {
      localc.ulH = paramg.uqu.urx.uvU;
      localc.ulI = paramg.uqu.urx.uvW;
      localc.ulJ = paramg.uqu.urx.uvX;
    }
    localc.appType = paramg.uqD;
    localc.ulW = paramg.uqE;
    AppMethodBeat.o(41523);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */