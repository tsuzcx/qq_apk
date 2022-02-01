package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.dt;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.d.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class x
{
  public static c a(f paramf)
  {
    AppMethodBeat.i(41523);
    if (paramf == null)
    {
      ad.e("MicroMsg.GamePBData", "Invalid pb object");
      AppMethodBeat.o(41523);
      return null;
    }
    if (bt.isNullOrNil(paramf.fVC))
    {
      ad.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(41523);
      return null;
    }
    ad.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { paramf.fVC });
    c localc = new c();
    localc.field_appId = paramf.fVC;
    localc.field_appName = paramf.Name;
    localc.field_appIconUrl = paramf.rZw;
    localc.field_appType = ",1,";
    localc.field_packageName = paramf.rZy;
    localc.field_appVersion = paramf.Version;
    localc.field_appInfoFlag = paramf.rZB;
    if (paramf.rZA != null)
    {
      localc.mJ(paramf.rZA.san);
      localc.mM(paramf.rZA.sao);
      localc.jz(paramf.rZA.sar);
      localc.mN(paramf.rZA.sap);
      localc.rVl = paramf.rZA.sat;
      localc.lrU = paramf.rZA.sas;
      localc.dlp = paramf.rZA.sau;
    }
    if ((paramf.rZA != null) && (paramf.rZA.saq != null))
    {
      localc.mS(paramf.rZA.saq.san);
      localc.mT(paramf.rZA.saq.seb);
      localc.mQ(paramf.rZA.saq.sec);
      localc.mR(paramf.rZA.saq.sed);
      localc.jA(paramf.rZA.saq.sef);
    }
    localc.rUT = paramf.Desc;
    localc.rUS = paramf.rZx;
    localc.status = paramf.mBi;
    localc.rUV = paramf.rZr;
    localc.versionCode = paramf.rZz;
    localc.dcC = paramf.rZt;
    localc.hHQ = paramf.rZC;
    localc.rVe = paramf.rZH;
    if ((paramf.rZA != null) && (paramf.rZA.saq != null))
    {
      localc.rUX = paramf.rZA.saq.see;
      localc.rUY = paramf.rZA.saq.seg;
      localc.rUZ = paramf.rZA.saq.seh;
    }
    localc.appType = paramf.rZJ;
    localc.rVm = paramf.rZK;
    AppMethodBeat.o(41523);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */