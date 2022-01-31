package com.tencent.mm.plugin.appbrand.appusage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.appbrand.service.n.b;
import com.tencent.mm.plugin.appbrand.service.n.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.sdk.g.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
  implements n
{
  public final void a(Context paramContext, n.c paramc, String paramString)
  {
    AppMethodBeat.i(129732);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1054;
    localAppBrandStatObject.cmF = paramString;
    ((j)com.tencent.mm.kernel.g.E(j.class)).a(paramContext, paramc.username, null, paramc.hcr, paramc.bDc, null, localAppBrandStatObject);
    AppMethodBeat.o(129732);
  }
  
  public final void a(Context paramContext, String paramString, n.a parama)
  {
    AppMethodBeat.i(129731);
    Intent localIntent = new Intent(paramContext, AppBrandLauncherUI.class);
    localIntent.putExtra("extra_enter_scene", 10);
    localIntent.putExtra("extra_enter_scene_note", paramString + ":" + parama.tag);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(129731);
  }
  
  public final n.b axG()
  {
    int j = 4;
    AppMethodBeat.i(129730);
    Object localObject1 = new n.b();
    ((n.b)localObject1).items = new ArrayList(0);
    ((n.b)localObject1).iJv = -1;
    ((n.b)localObject1).cyA = "";
    if (!com.tencent.mm.kernel.g.RJ().eHg)
    {
      AppMethodBeat.o(129730);
      return localObject1;
    }
    if (!i.awU())
    {
      AppMethodBeat.o(129730);
      return localObject1;
    }
    Object localObject2 = x.axD();
    n.b localb = new n.b();
    int i;
    if (localObject2 == null)
    {
      localObject1 = null;
      localb.cyA = ((String)localObject1);
      if (localObject2 != null) {
        break label308;
      }
      i = 0;
      label101:
      localb.iJv = i;
      if (localObject2 != null) {
        break label317;
      }
      localObject1 = new am.1(this, com.tencent.mm.plugin.appbrand.app.g.auK().a(new String[] { "brandId", "versionType" }, 4, 0));
      i = j;
    }
    for (;;)
    {
      localb.items = new ArrayList(i);
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Object[])((Iterator)localObject1).next();
        WxaAttributes localWxaAttributes = com.tencent.mm.plugin.appbrand.app.g.auF().d((String)localObject2[0], new String[] { "nickname", "brandIconURL" });
        if (localWxaAttributes != null)
        {
          n.c localc = new n.c();
          localc.username = ((String)localObject2[0]);
          localc.hcr = ((Integer)localObject2[1]).intValue();
          localc.bDc = ((Integer)localObject2[2]).intValue();
          localc.nickname = localWxaAttributes.field_nickname;
          localc.hcN = localWxaAttributes.field_brandIconURL;
          localb.items.add(localc);
        }
      }
      localObject1 = ((apo)localObject2).nQe;
      break;
      label308:
      i = ((apo)localObject2).xfq;
      break label101;
      label317:
      localObject1 = new am.2(this, (apo)localObject2);
      i = ((apo)localObject2).xfp.size();
      d.post(new am.3(this, (apo)localObject2), "BatchSyncWxaAttrBySearchShowOut");
    }
    localObject1 = x.a.hcu;
    x.axC();
    AppMethodBeat.o(129730);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am
 * JD-Core Version:    0.7.0.1
 */