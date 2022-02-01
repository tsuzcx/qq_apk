package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ab;
import com.tencent.mm.an.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.protocal.protobuf.fmh;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fqb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;

public final class a
  implements Callable<m>
{
  final String appId;
  final int appVersion;
  final int fES;
  final int ojq;
  final String ojr;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.fES = paramInt1;
    this.appVersion = paramInt2;
    this.scene = paramInt3;
    this.ojq = paramInt4;
    this.ojr = paramString2;
  }
  
  public final m bND()
  {
    AppMethodBeat.i(121398);
    Object localObject2 = new m();
    ((m)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)h.ae(com.tencent.mm.plugin.appbrand.widget.a.b.class)).bFH();
    if (localObject3 == null)
    {
      AppMethodBeat.o(121398);
      return null;
    }
    Object localObject1 = new fqb();
    ((fqb)localObject1).TuP = com.tencent.mm.plugin.appbrand.dynamic.k.b.zD(this.fES);
    ((fqb)localObject1).RTb = this.appVersion;
    ((fqb)localObject1).UNQ = this.ojq;
    ((fqb)localObject1).CPw = this.scene;
    ((fqb)localObject1).UNR = 0;
    int i;
    if (((l)localObject3).a((m)localObject2, new String[] { "appId", "pkgType", "widgetType" }))
    {
      if (((m)localObject2).field_jsApiInfo == null) {
        break label416;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (((m)localObject2).field_launchAction != null) && (1 == ((m)localObject2).field_launchAction.SZN) && (((m)localObject2).field_versionInfo != null) && (((m)localObject2).field_versionInfo.RTb >= this.appVersion)) {
        break label561;
      }
      if ((this.ojr != null) && (this.ojr.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new cqc();
          ((cqc)localObject2).parseFrom(Base64.decode(this.ojr, 0));
          boolean bool;
          label245:
          fnt localfnt;
          if (((cqc)localObject2).TxC == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.b)h.ae(com.tencent.mm.plugin.appbrand.widget.a.b.class)).bFH().a(this.appId, this.fES, this.ojq, (cqc)localObject2);
            if (((cqc)localObject2).TxC != null)
            {
              String str = ((e)h.ae(e.class)).bFb().bo(this.appId, this.fES);
              localfnt = new fnt();
              localfnt.UMj = str;
              localfnt.RTb = ((cqc)localObject2).TxC.RTb;
              if (this.fES != 10102) {
                break label426;
              }
              localfnt.UMi = ((cqc)localObject2).TxC.ULe;
              ((e)h.ae(e.class)).bFb().a(this.appId, localfnt, this.fES);
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
            if (this.fES == 10002)
            {
              localfnt.UMi = ((cqc)localObject2).TxC.ULd;
              ((e)h.ae(e.class)).bFb().a(this.appId, localfnt, this.fES);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (fqb)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.ojr });
        }
      }
    }
    c.a locala = ab.e(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (cqc)locala.lBJ);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).ojK;
    AppMethodBeat.o(121398);
    return localObject1;
    label561:
    com.tencent.mm.co.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (fqb)localObject1)));
    AppMethodBeat.o(121398);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */