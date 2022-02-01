package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.ex;
import com.tencent.mm.plugin.game.protobuf.g;
import com.tencent.mm.plugin.game.protobuf.y;
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
    if (Util.isNullOrNil(paramg.muA))
    {
      Log.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(41523);
      return null;
    }
    Log.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { paramg.muA });
    c localc = new c();
    localc.field_appId = paramg.muA;
    localc.field_appName = paramg.IGU;
    localc.field_appIconUrl = paramg.IGT;
    localc.field_appType = ",1,";
    localc.field_packageName = paramg.IcK;
    localc.field_appVersion = paramg.crz;
    localc.field_appInfoFlag = paramg.IGY;
    if (paramg.IGX != null)
    {
      localc.AE(paramg.IGX.IId);
      localc.AH(paramg.IGX.IIe);
      localc.pl(paramg.IGX.IIh);
      localc.AI(paramg.IGX.IIf);
      localc.ICy = paramg.IGX.IIj;
      localc.tQv = paramg.IGX.IIi;
      localc.hMd = paramg.IGX.IIk;
    }
    if ((paramg.IGX != null) && (paramg.IGX.IIg != null))
    {
      localc.AN(paramg.IGX.IIg.IId);
      localc.AO(paramg.IGX.IIg.IMs);
      localc.AL(paramg.IGX.IIg.IMt);
      localc.AM(paramg.IGX.IIg.IMu);
      localc.pm(paramg.IGX.IIg.IMw);
    }
    localc.ICg = paramg.IGG;
    localc.ICf = paramg.IGV;
    localc.status = paramg.vhk;
    localc.ICi = paramg.IGL;
    localc.versionCode = paramg.IGW;
    localc.hAR = paramg.IGQ;
    localc.piu = paramg.IGZ;
    localc.ICr = paramg.IHe;
    if ((paramg.IGX != null) && (paramg.IGX.IIg != null))
    {
      localc.ICk = paramg.IGX.IIg.IMv;
      localc.ICl = paramg.IGX.IIg.IMx;
      localc.ICm = paramg.IGX.IIg.IMy;
    }
    localc.appType = paramg.IHg;
    localc.ICz = paramg.IHh;
    AppMethodBeat.o(41523);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */