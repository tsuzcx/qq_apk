package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class n$1
  implements n.b
{
  n$1(String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    for (;;)
    {
      return;
      paramString = (abd)paramb.ecF.ecN;
      if ((paramString.taG == null) || (paramString.taG.size() == 0))
      {
        y.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
        return;
      }
      y.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", new Object[] { Integer.valueOf(paramString.taG.size()) });
      paramString = paramString.taG.iterator();
      while (paramString.hasNext())
      {
        paramb = (de)paramString.next();
        y.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramb.swu, Integer.valueOf(paramb.swt) });
        if (!bk.bl(paramb.swu))
        {
          n.a.A(this.fQE, paramb.hQR, paramb.swt);
          n.a.B(this.fQE, paramb.hQR, paramb.swt);
          n.a.h(this.fQE, paramb.hQR, paramb.swu);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n.1
 * JD-Core Version:    0.7.0.1
 */