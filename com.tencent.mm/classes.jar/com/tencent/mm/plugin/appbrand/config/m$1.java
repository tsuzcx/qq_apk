package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class m$1
  implements m.b
{
  m$1(String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(129852);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(129852);
      return;
    }
    paramString = (afv)paramb.fsW.fta;
    if ((paramString.wYW == null) || (paramString.wYW.size() == 0))
    {
      ab.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
      AppMethodBeat.o(129852);
      return;
    }
    ab.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramString.wYW.size()) });
    paramString = paramString.wYW.iterator();
    while (paramString.hasNext())
    {
      paramb = (dq)paramString.next();
      ab.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramb.wpG, Integer.valueOf(paramb.wpF) });
      if (!bo.isNullOrNil(paramb.wpG))
      {
        m.a.M(this.hjq, paramb.jKs, paramb.wpF);
        m.a.N(this.hjq, paramb.jKs, paramb.wpF);
        m.a.i(this.hjq, paramb.jKs, paramb.wpG);
      }
    }
    AppMethodBeat.o(129852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m.1
 * JD-Core Version:    0.7.0.1
 */