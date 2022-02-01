package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.Callable;

public final class a
  implements Callable<k>
{
  final int aAS;
  final String appId;
  final int dkC;
  final int jnh;
  final String jnj;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.dkC = paramInt1;
    this.aAS = paramInt2;
    this.scene = paramInt3;
    this.jnh = paramInt4;
    this.jnj = paramString2;
  }
  
  public final k aVE()
  {
    AppMethodBeat.i(121398);
    Object localObject2 = new k();
    ((k)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aOE();
    if (localObject3 == null)
    {
      AppMethodBeat.o(121398);
      return null;
    }
    Object localObject1 = new dwt();
    ((dwt)localObject1).DGx = b.rc(this.dkC);
    ((dwt)localObject1).CHC = this.aAS;
    ((dwt)localObject1).EKF = this.jnh;
    ((dwt)localObject1).Scene = this.scene;
    ((dwt)localObject1).EKG = 0;
    int i;
    if (((j)localObject3).a((k)localObject2, new String[] { "appId", "pkgType", "widgetType" }))
    {
      if (((k)localObject2).field_jsApiInfo == null) {
        break label416;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (((k)localObject2).field_launchAction != null) && (1 == ((k)localObject2).field_launchAction.Ctr) && (((k)localObject2).field_versionInfo != null) && (((k)localObject2).field_versionInfo.CHC >= this.aAS)) {
        break label561;
      }
      if ((this.jnj != null) && (this.jnj.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new bkz();
          ((bkz)localObject2).parseFrom(Base64.decode(this.jnj, 0));
          boolean bool;
          label245:
          duo localduo;
          if (((bkz)localObject2).DIS == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aOE().a(this.appId, this.dkC, this.jnh, (bkz)localObject2);
            if (((bkz)localObject2).DIS != null)
            {
              String str = ((e)g.ab(e.class)).aOk().aJ(this.appId, this.dkC);
              localduo = new duo();
              localduo.EIX = str;
              localduo.CHC = ((bkz)localObject2).DIS.CHC;
              if (this.dkC != 10102) {
                break label426;
              }
              localduo.EIW = ((bkz)localObject2).DIS.EIn;
              ((e)g.ab(e.class)).aOk().a(this.appId, localduo, this.dkC);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(121398);
            return localObject3;
            label416:
            i = 0;
            break;
            bool = false;
            break label245;
            label426:
            if (this.dkC == 10002)
            {
              localduo.EIW = ((bkz)localObject2).DIS.EIm;
              ((e)g.ab(e.class)).aOk().a(this.appId, localduo, this.dkC);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (dwt)localObject1);
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.jnj });
        }
      }
    }
    c.a locala = y.e(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (bkz)locala.gUK);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).jnC;
    AppMethodBeat.o(121398);
    return localObject1;
    label561:
    com.tencent.mm.cj.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (dwt)localObject1)));
    AppMethodBeat.o(121398);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */