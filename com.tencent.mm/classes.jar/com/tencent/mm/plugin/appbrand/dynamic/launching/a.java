package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.plugin.appbrand.widget.p;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.giz;
import com.tencent.mm.protocal.protobuf.gjb;
import com.tencent.mm.protocal.protobuf.gks;
import com.tencent.mm.protocal.protobuf.gnk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.Callable;

public final class a
  implements Callable<p>
{
  final String appId;
  final int appVersion;
  final int hJK;
  final int rmS;
  final String rmT;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.hJK = paramInt1;
    this.appVersion = paramInt2;
    this.scene = paramInt3;
    this.rmS = paramInt4;
    this.rmT = paramString2;
  }
  
  public final p cnS()
  {
    AppMethodBeat.i(121398);
    Object localObject2 = new p();
    ((p)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.b.b)h.ax(com.tencent.mm.plugin.appbrand.widget.b.b.class)).cfe();
    if (localObject3 == null)
    {
      AppMethodBeat.o(121398);
      return null;
    }
    Object localObject1 = new gnk();
    ((gnk)localObject1).aaJu = com.tencent.mm.plugin.appbrand.dynamic.k.b.zT(this.hJK);
    ((gnk)localObject1).YQB = this.appVersion;
    ((gnk)localObject1).acis = this.rmS;
    ((gnk)localObject1).IJG = this.scene;
    ((gnk)localObject1).acit = 0;
    int i;
    if (((o)localObject3).a((p)localObject2, new String[] { "appId", "pkgType", "widgetType" }))
    {
      if (((p)localObject2).field_jsApiInfo == null) {
        break label416;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (((p)localObject2).field_launchAction != null) && (1 == ((p)localObject2).field_launchAction.aamK) && (((p)localObject2).field_versionInfo != null) && (((p)localObject2).field_versionInfo.YQB >= this.appVersion)) {
        break label564;
      }
      if ((this.rmT != null) && (this.rmT.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new dgw();
          ((dgw)localObject2).parseFrom(Base64.decode(this.rmT, 0));
          boolean bool;
          label245:
          gks localgks;
          if (((dgw)localObject2).aaMj == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.b.b)h.ax(com.tencent.mm.plugin.appbrand.widget.b.b.class)).cfe().a(this.appId, this.hJK, this.rmS, (dgw)localObject2);
            if (((dgw)localObject2).aaMj != null)
            {
              String str = ((e)h.ax(e.class)).ceo().bF(this.appId, this.hJK);
              localgks = new gks();
              localgks.acgD = str;
              localgks.YQB = ((dgw)localObject2).aaMj.YQB;
              if (this.hJK != 10102) {
                break label426;
              }
              localgks.acgC = ((dgw)localObject2).aaMj.acfr;
              ((e)h.ax(e.class)).ceo().a(this.appId, localgks, this.hJK);
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
            if (this.hJK == 10002)
            {
              localgks.acgC = ((dgw)localObject2).aaMj.acfq;
              ((e)h.ax(e.class)).ceo().a(this.appId, localgks, this.hJK);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (gnk)localObject1);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.rmT });
        }
      }
    }
    b.a locala = aa.a(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr, 20000L);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (dgw)locala.ott);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rnm;
    AppMethodBeat.o(121398);
    return localObject1;
    label564:
    com.tencent.mm.ci.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (gnk)localObject1)));
    AppMethodBeat.o(121398);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */