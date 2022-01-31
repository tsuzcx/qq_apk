package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.Callable;

public final class a
  implements Callable<k>
{
  final String appId;
  final int bDc;
  final int cvs;
  final int hpZ;
  final String hqa;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.cvs = paramInt1;
    this.bDc = paramInt2;
    this.scene = paramInt3;
    this.hpZ = paramInt4;
    this.hqa = paramString2;
  }
  
  public final k azX()
  {
    AppMethodBeat.i(10917);
    Object localObject2 = new k();
    ((k)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.E(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auH();
    if (localObject3 == null)
    {
      AppMethodBeat.o(10917);
      return null;
    }
    Object localObject1 = new dbt();
    ((dbt)localObject1).xmQ = b.nI(this.cvs);
    ((dbt)localObject1).wwX = this.bDc;
    ((dbt)localObject1).yhX = this.hpZ;
    ((dbt)localObject1).Scene = this.scene;
    ((dbt)localObject1).yhY = 0;
    int i;
    if (((j)localObject3).a((k)localObject2, new String[] { "appId", "pkgType", "widgetType" }))
    {
      if (((k)localObject2).field_jsApiInfo == null) {
        break label419;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (((k)localObject2).field_launchAction != null) && (1 == ((k)localObject2).field_launchAction.wld) && (((k)localObject2).field_versionInfo != null) && (((k)localObject2).field_versionInfo.wwX >= this.bDc)) {
        break label565;
      }
      if ((this.hqa != null) && (this.hqa.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new azp();
          ((azp)localObject2).parseFrom(Base64.decode(this.hqa, 0));
          boolean bool;
          label247:
          czy localczy;
          if (((azp)localObject2).xpb == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.E(com.tencent.mm.plugin.appbrand.widget.a.a.class)).auH().a(this.appId, this.cvs, this.hpZ, (azp)localObject2);
            if (((azp)localObject2).xpb != null)
            {
              String str = ((d)g.E(d.class)).we().au(this.appId, this.cvs);
              localczy = new czy();
              localczy.ygH = str;
              localczy.wwX = ((azp)localObject2).xpb.wwX;
              if (this.cvs != 10102) {
                break label429;
              }
              localczy.ygG = ((azp)localObject2).xpb.yga;
              ((d)g.E(d.class)).we().a(this.appId, localczy, this.cvs);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(10917);
            return localObject3;
            label419:
            i = 0;
            break;
            bool = false;
            break label247;
            label429:
            if (this.cvs == 10002)
            {
              localczy.ygG = ((azp)localObject2).xpb.yfZ;
              ((d)g.E(d.class)).we().a(this.appId, localczy, this.cvs);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (dbt)localObject1);
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.hqa });
        }
      }
    }
    a.a locala = x.c(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (azp)locala.fsN);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).hqt;
    AppMethodBeat.o(10917);
    return localObject1;
    label565:
    com.tencent.mm.ch.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (dbt)localObject1)));
    AppMethodBeat.o(10917);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */