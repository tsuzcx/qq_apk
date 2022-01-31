package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ds;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class x
{
  public static c a(e parame)
  {
    AppMethodBeat.i(111358);
    if (parame == null)
    {
      ab.e("MicroMsg.GamePBData", "Invalid pb object");
      AppMethodBeat.o(111358);
      return null;
    }
    if (bo.isNullOrNil(parame.npZ))
    {
      ab.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(111358);
      return null;
    }
    ab.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { parame.npZ });
    c localc = new c();
    localc.field_appId = parame.npZ;
    localc.field_appName = parame.Name;
    localc.field_appIconUrl = parame.nqa;
    localc.field_appType = ",1,";
    localc.field_packageName = parame.nqc;
    localc.field_appVersion = parame.Version;
    localc.field_appInfoFlag = parame.nqf;
    if (parame.nqe != null)
    {
      localc.iV(parame.nqe.nqK);
      localc.iY(parame.nqe.nqL);
      localc.ho(parame.nqe.nqO);
      localc.iZ(parame.nqe.nqM);
      localc.nmn = parame.nqe.nqQ;
      localc.nmo = parame.nqe.nqP;
      localc.cvQ = parame.nqe.nqR;
    }
    if ((parame.nqe != null) && (parame.nqe.nqN != null))
    {
      localc.je(parame.nqe.nqN.nqK);
      localc.jf(parame.nqe.nqN.nux);
      localc.jc(parame.nqe.nqN.nuy);
      localc.jd(parame.nqe.nqN.nuz);
      localc.hp(parame.nqe.nqN.nuB);
    }
    localc.nlU = parame.Desc;
    localc.nlT = parame.nqb;
    localc.status = parame.jJS;
    localc.nlW = parame.npU;
    localc.versionCode = parame.nqd;
    localc.cnG = parame.npW;
    localc.nlY = parame.nqg;
    localc.nmg = parame.nql;
    if ((parame.nqe != null) && (parame.nqe.nqN != null))
    {
      localc.nlZ = parame.nqe.nqN.nuA;
      localc.nma = parame.nqe.nqN.nuC;
      localc.nmb = parame.nqe.nqN.nuD;
    }
    localc.edl = parame.nqn;
    localc.nmp = parame.nqo;
    AppMethodBeat.o(111358);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */