package com.tencent.mm.plugin.appbrand.report.model;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class a$2
  implements Runnable
{
  a$2(a parama, z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(132580);
    Object localObject1 = this.iGy.iGs;
    Object localObject2 = this.iGz;
    Object localObject3 = com.tencent.mm.sdk.f.a.hr(((z)localObject2).getContext());
    if ((localObject3 != null) && (((Activity)localObject3).isFinishing())) {
      ((j)localObject1).iHf = true;
    }
    ((j)localObject1).l((z)localObject2);
    ((j)localObject1).IE();
    localObject2 = this.iGy.iGu;
    localObject3 = this.iGz;
    ((o)localObject2).iHi = ((String)((o)localObject2).iIf.peekFirst());
    ((o)localObject2).iHk = null;
    Intent localIntent;
    switch (o.2.gYU[com.tencent.mm.plugin.appbrand.e.xX(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((o)localObject2).gQn.atT().getReporter().aHF();
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          ab.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((o)localObject2).iHj = 8;
          ((o)localObject2).iHk = bo.bf(localIntent.getStringExtra(AppBrandProcessProxyUI.hvX), (String)localObject1);
          localObject1 = ((o)localObject2).iHk;
          ((o)localObject2).iIf.pollFirst();
          ((o)localObject2).iIf.push(bo.nullAsNil((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.sdk.f.a.hr(((z)localObject3).getContext());
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((o)localObject2).iHf = true;
      }
      ((o)localObject2).n((z)localObject3);
      AppMethodBeat.o(132580);
      return;
      ((o)localObject2).iHj = 3;
      continue;
      ((o)localObject2).iHj = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((o)localObject2).iHj = 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.a.2
 * JD-Core Version:    0.7.0.1
 */