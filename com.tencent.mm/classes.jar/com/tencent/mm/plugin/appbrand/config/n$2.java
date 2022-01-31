package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class n$2
  implements n.b
{
  n$2(n.c paramc, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (this.fQF != null) {
        this.fQF.rf("");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramString = (abd)paramb.ecF.ecN;
          if ((paramString.taG != null) && (paramString.taG.size() != 0)) {
            break;
          }
          y.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
        } while (this.fQF == null);
        this.fQF.rf("");
        return;
        paramString = (de)paramString.taG.get(0);
        y.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", new Object[] { paramString.swu, Integer.valueOf(paramString.swt) });
        if (bk.bl(paramString.swu)) {
          break;
        }
        n.a.A(this.fQE, paramString.hQR, paramString.swt);
        n.a.B(this.fQE, paramString.hQR, paramString.swt);
        n.a.h(this.fQE, paramString.hQR, paramString.swu);
      } while (this.fQF == null);
      this.fQF.rf(paramString.swu);
      return;
    } while (this.fQF == null);
    this.fQF.rf("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n.2
 * JD-Core Version:    0.7.0.1
 */