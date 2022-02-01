package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ei;
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
    if (bt.isNullOrNil(paramf.gsT))
    {
      ad.e("MicroMsg.GamePBData", "No AppID field, abort");
      AppMethodBeat.o(41523);
      return null;
    }
    ad.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[] { paramf.gsT });
    c localc = new c();
    localc.field_appId = paramf.gsT;
    localc.field_appName = paramf.Name;
    localc.field_appIconUrl = paramf.ufg;
    localc.field_appType = ",1,";
    localc.field_packageName = paramf.ufi;
    localc.field_appVersion = paramf.Version;
    localc.field_appInfoFlag = paramf.ufl;
    if (paramf.ufk != null)
    {
      localc.sz(paramf.ufk.ufX);
      localc.sC(paramf.ufk.ufY);
      localc.jV(paramf.ufk.ugb);
      localc.sD(paramf.ufk.ufZ);
      localc.uaT = paramf.ufk.ugd;
      localc.mtE = paramf.ufk.ugc;
      localc.duJ = paramf.ufk.uge;
    }
    if ((paramf.ufk != null) && (paramf.ufk.uga != null))
    {
      localc.sI(paramf.ufk.uga.ufX);
      localc.sJ(paramf.ufk.uga.uku);
      localc.sG(paramf.ufk.uga.ukv);
      localc.sH(paramf.ufk.uga.ukw);
      localc.jW(paramf.ufk.uga.uky);
    }
    localc.uaB = paramf.Desc;
    localc.uaA = paramf.ufh;
    localc.status = paramf.nDG;
    localc.uaD = paramf.ufb;
    localc.versionCode = paramf.ufj;
    localc.dls = paramf.ufd;
    localc.iBM = paramf.ufm;
    localc.uaM = paramf.ufr;
    if ((paramf.ufk != null) && (paramf.ufk.uga != null))
    {
      localc.uaF = paramf.ufk.uga.ukx;
      localc.uaG = paramf.ufk.uga.ukz;
      localc.uaH = paramf.ufk.uga.ukA;
    }
    localc.appType = paramf.uft;
    localc.uaU = paramf.ufu;
    AppMethodBeat.o(41523);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.x
 * JD-Core Version:    0.7.0.1
 */