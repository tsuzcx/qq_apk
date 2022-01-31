package com.tencent.mm.modelsimple;

import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class q$2
  implements bi.a
{
  q$2(q paramq, i.e parame) {}
  
  public final void a(e parame)
  {
    if ((parame == null) || (parame.KR() == null) || (this.ezO.eNt == null) || (this.ezO.spz == null) || (this.ezO.spz.tPv == null))
    {
      f.nEG.a(148L, 8L, 1L, false);
      y.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
      return;
    }
    y.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, uin:%d", new Object[] { bk.aac(bk.bD(this.ezO.eNt)), Integer.valueOf(this.ezO.spz.tPv.jwX) });
    parame.KR().w(this.ezO.eNt, this.ezO.spz.tPv.jwX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.q.2
 * JD-Core Version:    0.7.0.1
 */