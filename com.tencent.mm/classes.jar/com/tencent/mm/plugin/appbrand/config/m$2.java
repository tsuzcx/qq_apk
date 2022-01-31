package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class m$2
  implements m.b
{
  m$2(m.c paramc, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(129853);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (this.hjr != null) {
        this.hjr.yA("");
      }
      AppMethodBeat.o(129853);
      return;
    }
    paramString = (afv)paramb.fsW.fta;
    if ((paramString.wYW == null) || (paramString.wYW.size() == 0))
    {
      ab.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
      if (this.hjr != null) {
        this.hjr.yA("");
      }
      AppMethodBeat.o(129853);
      return;
    }
    paramString = (dq)paramString.wYW.get(0);
    ab.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramString.wpG, Integer.valueOf(paramString.wpF) });
    if (!bo.isNullOrNil(paramString.wpG))
    {
      m.a.M(this.hjq, paramString.jKs, paramString.wpF);
      m.a.N(this.hjq, paramString.jKs, paramString.wpF);
      m.a.i(this.hjq, paramString.jKs, paramString.wpG);
      if (this.hjr != null)
      {
        this.hjr.yA(paramString.wpG);
        AppMethodBeat.o(129853);
      }
    }
    else if (this.hjr != null)
    {
      this.hjr.yA("");
    }
    AppMethodBeat.o(129853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m.2
 * JD-Core Version:    0.7.0.1
 */