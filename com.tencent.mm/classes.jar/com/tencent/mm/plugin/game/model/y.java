package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.d.dp;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.q;
import com.tencent.mm.sdk.platformtools.bk;

public class y
{
  public static d a(e parame)
  {
    if (parame == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBData", "Invalid pb object");
      return null;
    }
    if (bk.bl(parame.kRX))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.GamePBData", "No AppID field, abort");
      return null;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { parame.kRX });
    d locald = new d();
    locald.field_appId = parame.kRX;
    locald.field_appName = parame.kRZ;
    locald.field_appIconUrl = parame.kRY;
    locald.field_appType = ",1,";
    locald.field_packageName = parame.kSb;
    locald.field_appVersion = parame.hQQ;
    locald.field_appInfoFlag = parame.kSe;
    if (parame.kSd != null)
    {
      locald.cN(parame.kSd.kSL);
      locald.cQ(parame.kSd.kSM);
      locald.fd(parame.kSd.kSP);
      locald.cR(parame.kSd.kSN);
      locald.kOq = parame.kSd.kSR;
      locald.kOr = parame.kSd.kSQ;
      locald.bOz = parame.kSd.kSS;
    }
    if ((parame.kSd != null) && (parame.kSd.kSO != null))
    {
      locald.cW(parame.kSd.kSO.kSL);
      locald.cX(parame.kSd.kSO.kWv);
      locald.cU(parame.kSd.kSO.kWw);
      locald.cV(parame.kSd.kSO.kWx);
      locald.fe(parame.kSd.kSO.kWz);
    }
    locald.kNX = parame.kRN;
    locald.kNW = parame.kSa;
    locald.status = parame.hQq;
    locald.kNZ = parame.kRS;
    locald.versionCode = parame.kSc;
    locald.bGy = parame.kRU;
    locald.kOb = parame.kSf;
    locald.kOj = parame.kSk;
    if ((parame.kSd != null) && (parame.kSd.kSO != null))
    {
      locald.kOc = parame.kSd.kSO.kWy;
      locald.kOd = parame.kSd.kSO.kWA;
      locald.kOe = parame.kSd.kSO.kWB;
    }
    locald.dlO = parame.kSm;
    locald.kOs = parame.kSn;
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.y
 * JD-Core Version:    0.7.0.1
 */