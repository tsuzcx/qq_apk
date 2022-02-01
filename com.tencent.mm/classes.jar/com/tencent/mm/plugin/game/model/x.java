package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.dt;
import com.tencent.mm.plugin.game.d.f;
import com.tencent.mm.plugin.game.d.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class x
{
  public static c a(f paramf)
  {
    AppMethodBeat.i(41523);
    if (paramf == null)
    {
      ac.e("MicroMsg.GamePBData", "Invalid pb object");
      AppMethodBeat.o(41523);
      return null;
    }
    if (bs.isNullOrNil(paramf.fZx))
    {
      ac.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(41523);
      return null;
    }
    ac.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { paramf.fZx });
    c localc = new c();
    localc.field_appId = paramf.fZx;
    localc.field_appName = paramf.Name;
    localc.field_appIconUrl = paramf.thp;
    localc.field_appType = ",1,";
    localc.field_packageName = paramf.thr;
    localc.field_appVersion = paramf.Version;
    localc.field_appInfoFlag = paramf.thu;
    if (paramf.tht != null)
    {
      localc.pP(paramf.tht.tih);
      localc.pS(paramf.tht.tii);
      localc.jx(paramf.tht.til);
      localc.pT(paramf.tht.tij);
      localc.tdd = paramf.tht.tin;
      localc.lTP = paramf.tht.tim;
      localc.diX = paramf.tht.tio;
    }
    if ((paramf.tht != null) && (paramf.tht.tik != null))
    {
      localc.pY(paramf.tht.tik.tih);
      localc.pZ(paramf.tht.tik.tlV);
      localc.pW(paramf.tht.tik.tlW);
      localc.pX(paramf.tht.tik.tlX);
      localc.jy(paramf.tht.tik.tlZ);
    }
    localc.tcL = paramf.Desc;
    localc.tcK = paramf.thq;
    localc.status = paramf.ndj;
    localc.tcN = paramf.thk;
    localc.versionCode = paramf.ths;
    localc.daa = paramf.thm;
    localc.iis = paramf.thv;
    localc.tcW = paramf.thA;
    if ((paramf.tht != null) && (paramf.tht.tik != null))
    {
      localc.tcP = paramf.tht.tik.tlY;
      localc.tcQ = paramf.tht.tik.tma;
      localc.tcR = paramf.tht.tik.tmb;
    }
    localc.appType = paramf.thC;
    localc.tde = paramf.thD;
    AppMethodBeat.o(41523);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */