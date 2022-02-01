package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.er;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.plugin.game.protobuf.w;
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
    if (Util.isNullOrNil(paramg.hik))
    {
      Log.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(41523);
      return null;
    }
    Log.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { paramg.hik });
    c localc = new c();
    localc.field_appId = paramg.hik;
    localc.field_appName = paramg.Name;
    localc.field_appIconUrl = paramg.xIJ;
    localc.field_appType = ",1,";
    localc.field_packageName = paramg.xuk;
    localc.field_appVersion = paramg.Version;
    localc.field_appInfoFlag = paramg.xIN;
    if (paramg.xIM != null)
    {
      localc.Bl(paramg.xIM.xJL);
      localc.Bo(paramg.xIM.xJM);
      localc.mZ(paramg.xIM.xJP);
      localc.Bp(paramg.xIM.xJN);
      localc.xEn = paramg.xIM.xJR;
      localc.nJC = paramg.xIM.xJQ;
      localc.dNv = paramg.xIM.xJS;
    }
    if ((paramg.xIM != null) && (paramg.xIM.xJO != null))
    {
      localc.Bu(paramg.xIM.xJO.xJL);
      localc.Bv(paramg.xIM.xJO.xNS);
      localc.Bs(paramg.xIM.xJO.xNT);
      localc.Bt(paramg.xIM.xJO.xNU);
      localc.na(paramg.xIM.xJO.xNW);
    }
    localc.xDV = paramg.Desc;
    localc.xDU = paramg.xIK;
    localc.status = paramg.oTW;
    localc.xDX = paramg.xIB;
    localc.versionCode = paramg.xIL;
    localc.dDJ = paramg.xIG;
    localc.jyX = paramg.xIO;
    localc.xEg = paramg.xIT;
    if ((paramg.xIM != null) && (paramg.xIM.xJO != null))
    {
      localc.xDZ = paramg.xIM.xJO.xNV;
      localc.xEa = paramg.xIM.xJO.xNX;
      localc.xEb = paramg.xIM.xJO.xNY;
    }
    localc.appType = paramg.xIV;
    localc.xEo = paramg.xIW;
    AppMethodBeat.o(41523);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */