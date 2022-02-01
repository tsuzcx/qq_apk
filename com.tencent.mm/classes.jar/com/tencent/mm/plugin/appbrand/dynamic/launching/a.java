package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.protocal.protobuf.ffa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;

public final class a
  implements Callable<j>
{
  final String appId;
  final int appVersion;
  final int dMe;
  final int loG;
  final String loH;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.dMe = paramInt1;
    this.appVersion = paramInt2;
    this.scene = paramInt3;
    this.loG = paramInt4;
    this.loH = paramString2;
  }
  
  public final j bCh()
  {
    AppMethodBeat.i(121398);
    Object localObject2 = new j();
    ((j)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buE();
    if (localObject3 == null)
    {
      AppMethodBeat.o(121398);
      return null;
    }
    Object localObject1 = new ffa();
    ((ffa)localObject1).MjZ = com.tencent.mm.plugin.appbrand.dynamic.k.b.wq(this.dMe);
    ((ffa)localObject1).KSa = this.appVersion;
    ((ffa)localObject1).NAo = this.loG;
    ((ffa)localObject1).Scene = this.scene;
    ((ffa)localObject1).NAp = 0;
    int i;
    if (((i)localObject3).a((j)localObject2, new String[] { "appId", "pkgType", "widgetType" }))
    {
      if (((j)localObject2).field_jsApiInfo == null) {
        break label416;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (((j)localObject2).field_launchAction != null) && (1 == ((j)localObject2).field_launchAction.KCD) && (((j)localObject2).field_versionInfo != null) && (((j)localObject2).field_versionInfo.KSa >= this.appVersion)) {
        break label561;
      }
      if ((this.loH != null) && (this.loH.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new chg();
          ((chg)localObject2).parseFrom(Base64.decode(this.loH, 0));
          boolean bool;
          label245:
          fcs localfcs;
          if (((chg)localObject2).MmH == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.af(com.tencent.mm.plugin.appbrand.widget.a.b.class)).buE().a(this.appId, this.dMe, this.loG, (chg)localObject2);
            if (((chg)localObject2).MmH != null)
            {
              String str = ((e)g.af(e.class)).bub().aX(this.appId, this.dMe);
              localfcs = new fcs();
              localfcs.NyF = str;
              localfcs.KSa = ((chg)localObject2).MmH.KSa;
              if (this.dMe != 10102) {
                break label426;
              }
              localfcs.NyE = ((chg)localObject2).MmH.NxN;
              ((e)g.af(e.class)).bub().a(this.appId, localfcs, this.dMe);
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
            if (this.dMe == 10002)
            {
              localfcs.NyE = ((chg)localObject2).MmH.NxM;
              ((e)g.af(e.class)).bub().a(this.appId, localfcs, this.dMe);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (ffa)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.loH });
        }
      }
    }
    c.a locala = ab.e(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (chg)locala.iLC);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).lpa;
    AppMethodBeat.o(121398);
    return localObject1;
    label561:
    com.tencent.mm.ch.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (ffa)localObject1)));
    AppMethodBeat.o(121398);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */