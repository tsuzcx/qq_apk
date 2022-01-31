package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.clk;
import com.tencent.mm.protocal.c.cll;
import com.tencent.mm.protocal.c.cmh;
import com.tencent.mm.protocal.c.cnl;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.Callable;

public final class a
  implements Callable<j>
{
  final String appId;
  final int bOa;
  final int cau;
  final String fWA;
  final int fWz;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.bOa = paramInt1;
    this.cau = paramInt2;
    this.scene = paramInt3;
    this.fWz = paramInt4;
    this.fWA = paramString2;
  }
  
  public final j afs()
  {
    Object localObject2 = new j();
    ((j)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.r(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aaV();
    if (localObject3 == null) {
      return null;
    }
    Object localObject1 = new cnl();
    ((cnl)localObject1).tmZ = b.kK(this.bOa);
    ((cnl)localObject1).sCy = this.cau;
    ((cnl)localObject1).uae = this.fWz;
    ((cnl)localObject1).pyo = this.scene;
    ((cnl)localObject1).uaf = 0;
    if (((i)localObject3).a((j)localObject2, new String[] { "appId", "pkgType", "widgetType" })) {
      if (((j)localObject2).field_jsApiInfo == null) {
        break label509;
      }
    }
    label506:
    label509:
    for (int i = 1;; i = 0)
    {
      a.a locala;
      if ((i == 0) || (((j)localObject2).field_launchAction == null) || (1 != ((j)localObject2).field_launchAction.ssy) || (((j)localObject2).field_versionInfo == null) || (((j)localObject2).field_versionInfo.sCy < this.cau))
      {
        if ((this.fWA != null) && (this.fWA.length() > 0))
        {
          u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
          try
          {
            localObject2 = new atk();
            ((atk)localObject2).aH(Base64.decode(this.fWA, 0));
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.r(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aaV().a(this.appId, this.bOa, this.fWz, (atk)localObject2);
            if (((atk)localObject2).tpd == null) {
              break label506;
            }
            String str = ((c)g.r(c.class)).aaG().aj(this.appId, this.bOa);
            cmh localcmh = new cmh();
            localcmh.tZl = str;
            localcmh.sCy = ((atk)localObject2).tpd.sCy;
            if (this.bOa == 10102)
            {
              localcmh.tZk = ((atk)localObject2).tpd.tYH;
              ((c)g.r(c.class)).aaG().a(this.appId, localcmh, this.bOa);
            }
            else if (this.bOa == 10002)
            {
              localcmh.tZk = ((atk)localObject2).tpd.tYG;
              ((c)g.r(c.class)).aaG().a(this.appId, localcmh, this.bOa);
            }
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.fWA });
          }
        }
        else
        {
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (cnl)localObject1);
          locala = x.c(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).dmK);
          ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.aox, (atk)locala.ecw);
          return ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).fWT;
        }
      }
      else
      {
        com.tencent.mm.cg.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (cnl)localObject1)));
        return locala;
      }
      return localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */