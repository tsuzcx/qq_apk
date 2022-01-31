package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class s$2
  implements bk.a
{
  s$2(s params, j.g paramg) {}
  
  public final void a(com.tencent.mm.network.e parame)
  {
    AppMethodBeat.i(123439);
    if ((parame == null) || (parame.adI() == null) || (this.fPE.ME(1) == null) || (this.fPE.ME(2) == null) || (this.fPE.ME(3) == null) || (this.fPE.wil == null) || (this.fPE.wil.xWm == null))
    {
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 8L, 1L, false);
      ab.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
      AppMethodBeat.o(123439);
      return;
    }
    ab.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, %s, %s uin:%d", new Object[] { bo.aqg(bo.cd(this.fPE.ME(1))), bo.aqg(bo.cd(this.fPE.ME(2))), bo.aqg(bo.cd(this.fPE.ME(3))), Integer.valueOf(this.fPE.wil.xWm.lGw) });
    parame.adI().a(this.fPE.ME(1), this.fPE.ME(2), this.fPE.ME(3), this.fPE.wil.xWm.lGw);
    AppMethodBeat.o(123439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s.2
 * JD-Core Version:    0.7.0.1
 */