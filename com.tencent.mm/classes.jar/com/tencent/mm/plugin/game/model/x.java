package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.es;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class x
{
  public static c a(g paramg)
  {
    AppMethodBeat.i(41523);
    if (paramg == null)
    {
      Log.e("MicroMsg.GamePBData", "Invalid pb object");
      AppMethodBeat.o(41523);
      return null;
    }
    if (Util.isNullOrNil(paramg.jUi))
    {
      Log.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(41523);
      return null;
    }
    Log.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { paramg.jUi });
    c localc = new c();
    localc.field_appId = paramg.jUi;
    localc.field_appName = paramg.CMP;
    localc.field_appIconUrl = paramg.CMO;
    localc.field_appType = ",1,";
    localc.field_packageName = paramg.CqB;
    localc.field_appVersion = paramg.rWt;
    localc.field_appInfoFlag = paramg.CMT;
    if (paramg.CMS != null)
    {
      localc.HZ(paramg.CMS.CNT);
      localc.Ic(paramg.CMS.CNU);
      localc.pm(paramg.CMS.CNX);
      localc.Id(paramg.CMS.CNV);
      localc.CIo = paramg.CMS.CNZ;
      localc.qLO = paramg.CMS.CNY;
      localc.fGH = paramg.CMS.COa;
    }
    if ((paramg.CMS != null) && (paramg.CMS.CNW != null))
    {
      localc.Ii(paramg.CMS.CNW.CNT);
      localc.Ij(paramg.CMS.CNW.CSc);
      localc.Ig(paramg.CMS.CNW.CSd);
      localc.Ih(paramg.CMS.CNW.CSe);
      localc.pn(paramg.CMS.CNW.CSg);
    }
    localc.CHW = paramg.CMB;
    localc.CHV = paramg.CMQ;
    localc.status = paramg.rVU;
    localc.CHY = paramg.CMG;
    localc.versionCode = paramg.CMR;
    localc.fwt = paramg.CML;
    localc.moD = paramg.CMU;
    localc.CIh = paramg.CMZ;
    if ((paramg.CMS != null) && (paramg.CMS.CNW != null))
    {
      localc.CIa = paramg.CMS.CNW.CSf;
      localc.CIb = paramg.CMS.CNW.CSh;
      localc.CIc = paramg.CMS.CNW.CSi;
    }
    localc.appType = paramg.CNb;
    localc.CIp = paramg.CNc;
    AppMethodBeat.o(41523);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */