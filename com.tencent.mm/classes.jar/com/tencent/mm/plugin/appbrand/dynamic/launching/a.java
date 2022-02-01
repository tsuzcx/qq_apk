package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.ekh;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.Callable;

public final class a
  implements Callable<k>
{
  final int aDD;
  final String appId;
  final int duK;
  final int kkV;
  final String kkW;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.duK = paramInt1;
    this.aDD = paramInt2;
    this.scene = paramInt3;
    this.kkV = paramInt4;
    this.kkW = paramString2;
  }
  
  public final k bgO()
  {
    AppMethodBeat.i(121398);
    Object localObject2 = new k();
    ((k)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aZn();
    if (localObject3 == null)
    {
      AppMethodBeat.o(121398);
      return null;
    }
    Object localObject1 = new ekh();
    ((ekh)localObject1).HeR = com.tencent.mm.plugin.appbrand.dynamic.k.b.su(this.duK);
    ((ekh)localObject1).FYj = this.aDD;
    ((ekh)localObject1).Inm = this.kkV;
    ((ekh)localObject1).Scene = this.scene;
    ((ekh)localObject1).Inn = 0;
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
      if ((i != 0) && (((k)localObject2).field_launchAction != null) && (1 == ((k)localObject2).field_launchAction.FJl) && (((k)localObject2).field_versionInfo != null) && (((k)localObject2).field_versionInfo.FYj >= this.aDD)) {
        break label561;
      }
      if ((this.kkW != null) && (this.kkW.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new buc();
          ((buc)localObject2).parseFrom(Base64.decode(this.kkW, 0));
          boolean bool;
          label245:
          eia localeia;
          if (((buc)localObject2).Hhr == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)g.ab(com.tencent.mm.plugin.appbrand.widget.a.b.class)).aZn().a(this.appId, this.duK, this.kkV, (buc)localObject2);
            if (((buc)localObject2).Hhr != null)
            {
              String str = ((e)g.ab(e.class)).aYP().aS(this.appId, this.duK);
              localeia = new eia();
              localeia.IlD = str;
              localeia.FYj = ((buc)localObject2).Hhr.FYj;
              if (this.duK != 10102) {
                break label426;
              }
              localeia.IlC = ((buc)localObject2).Hhr.IkM;
              ((e)g.ab(e.class)).aYP().a(this.appId, localeia, this.duK);
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
            if (this.duK == 10002)
            {
              localeia.IlC = ((buc)localObject2).Hhr.IkL;
              ((e)g.ab(e.class)).aYP().a(this.appId, localeia, this.duK);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (ekh)localObject1);
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.kkW });
        }
      }
    }
    a.a locala = y.e(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (buc)locala.hQv);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).klp;
    AppMethodBeat.o(121398);
    return localObject1;
    label561:
    com.tencent.mm.ch.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (ekh)localObject1)));
    AppMethodBeat.o(121398);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */