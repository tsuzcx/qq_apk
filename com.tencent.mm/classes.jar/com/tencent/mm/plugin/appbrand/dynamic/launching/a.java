package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.Callable;

public final class a
  implements Callable<k>
{
  final int aDD;
  final String appId;
  final int dtF;
  final int khF;
  final String khG;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.dtF = paramInt1;
    this.aDD = paramInt2;
    this.scene = paramInt3;
    this.khF = paramInt4;
    this.khG = paramString2;
  }
  
  public final k bgg()
  {
    AppMethodBeat.i(121398);
    Object localObject2 = new k();
    ((k)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aYR();
    if (localObject3 == null)
    {
      AppMethodBeat.o(121398);
      return null;
    }
    Object localObject1 = new eiq();
    ((eiq)localObject1).GLq = com.tencent.mm.plugin.appbrand.dynamic.k.b.sr(this.dtF);
    ((eiq)localObject1).FFN = this.aDD;
    ((eiq)localObject1).HTf = this.khF;
    ((eiq)localObject1).Scene = this.scene;
    ((eiq)localObject1).HTg = 0;
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
      if ((i != 0) && (((k)localObject2).field_launchAction != null) && (1 == ((k)localObject2).field_launchAction.FqN) && (((k)localObject2).field_versionInfo != null) && (((k)localObject2).field_versionInfo.FFN >= this.aDD)) {
        break label561;
      }
      if ((this.khG != null) && (this.khG.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new bti();
          ((bti)localObject2).parseFrom(Base64.decode(this.khG, 0));
          boolean bool;
          label245:
          egj localegj;
          if (((bti)localObject2).GNR == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aYR().a(this.appId, this.dtF, this.khF, (bti)localObject2);
            if (((bti)localObject2).GNR != null)
            {
              String str = ((e)g.ab(e.class)).aYu().aP(this.appId, this.dtF);
              localegj = new egj();
              localegj.HRw = str;
              localegj.FFN = ((bti)localObject2).GNR.FFN;
              if (this.dtF != 10102) {
                break label426;
              }
              localegj.HRv = ((bti)localObject2).GNR.HQF;
              ((e)g.ab(e.class)).aYu().a(this.appId, localegj, this.dtF);
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
            if (this.dtF == 10002)
            {
              localegj.HRv = ((bti)localObject2).GNR.HQE;
              ((e)g.ab(e.class)).aYu().a(this.appId, localegj, this.dtF);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (eiq)localObject1);
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.khG });
        }
      }
    }
    a.a locala = y.e(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (bti)locala.hNC);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).khZ;
    AppMethodBeat.o(121398);
    return localObject1;
    label561:
    com.tencent.mm.ci.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (eiq)localObject1)));
    AppMethodBeat.o(121398);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */