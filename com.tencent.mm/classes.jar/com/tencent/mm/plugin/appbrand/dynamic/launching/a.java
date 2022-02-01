package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.dynamic.g.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.Callable;

public final class a
  implements Callable<k>
{
  final int aBM;
  final String appId;
  final int dib;
  final int jNu;
  final String jNv;
  final int scene;
  
  public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    this.appId = paramString1;
    this.dib = paramInt1;
    this.aBM = paramInt2;
    this.scene = paramInt3;
    this.jNu = paramInt4;
    this.jNv = paramString2;
  }
  
  public final k bcC()
  {
    AppMethodBeat.i(121398);
    Object localObject2 = new k();
    ((k)localObject2).field_appId = this.appId;
    Object localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aVw();
    if (localObject3 == null)
    {
      AppMethodBeat.o(121398);
      return null;
    }
    Object localObject1 = new eck();
    ((eck)localObject1).FbR = b.rP(this.dib);
    ((eck)localObject1).Eae = this.aBM;
    ((eck)localObject1).GhR = this.jNu;
    ((eck)localObject1).Scene = this.scene;
    ((eck)localObject1).GhS = 0;
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
      if ((i != 0) && (((k)localObject2).field_launchAction != null) && (1 == ((k)localObject2).field_launchAction.DLI) && (((k)localObject2).field_versionInfo != null) && (((k)localObject2).field_versionInfo.Eae >= this.aBM)) {
        break label561;
      }
      if ((this.jNv != null) && (this.jNv.length() > 0))
      {
        u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "has preloaded launch data", new Object[0]);
        try
        {
          localObject2 = new bov();
          ((bov)localObject2).parseFrom(Base64.decode(this.jNv, 0));
          boolean bool;
          label245:
          eaf localeaf;
          if (((bov)localObject2).Fen == null)
          {
            bool = true;
            u.i("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch info versioninfo is null %b", new Object[] { Boolean.valueOf(bool) });
            localObject3 = ((com.tencent.mm.plugin.appbrand.widget.a.a)g.ab(com.tencent.mm.plugin.appbrand.widget.a.a.class)).aVw().a(this.appId, this.dib, this.jNu, (bov)localObject2);
            if (((bov)localObject2).Fen != null)
            {
              String str = ((e)g.ab(e.class)).aVa().aN(this.appId, this.dib);
              localeaf = new eaf();
              localeaf.Ggj = str;
              localeaf.Eae = ((bov)localObject2).Fen.Eae;
              if (this.dib != 10102) {
                break label426;
              }
              localeaf.Ggi = ((bov)localObject2).Fen.Gfz;
              ((e)g.ab(e.class)).aVa().a(this.appId, localeaf, this.dib);
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
            if (this.dib == 10002)
            {
              localeaf.Ggi = ((bov)localObject2).Fen.Gfy;
              ((e)g.ab(e.class)).aVa().a(this.appId, localeaf, this.dib);
            }
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, true, (eck)localObject1);
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.AppBrand.PrepareStepCheckWidgetLaunchInfo", "preload launch data parse fail[%s]", new Object[] { this.jNv });
        }
      }
    }
    c.a locala = y.e(((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).rr);
    ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).a(locala.errType, locala.errCode, locala.errMsg, (bov)locala.hvj);
    localObject1 = ((com.tencent.mm.plugin.appbrand.dynamic.g.a)localObject1).jNO;
    AppMethodBeat.o(121398);
    return localObject1;
    label561:
    com.tencent.mm.ci.a.post(new a.1(new com.tencent.mm.plugin.appbrand.dynamic.g.a(this.appId, false, (eck)localObject1)));
    AppMethodBeat.o(121398);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.a
 * JD-Core Version:    0.7.0.1
 */