package com.tencent.mm.plugin.appbrand.report.model;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class b$2
  implements Runnable
{
  b$2(b paramb, s params) {}
  
  public final void run()
  {
    Object localObject1 = this.gYf.gXZ;
    Object localObject2 = this.gYg;
    Object localObject3 = l.cx(((q)localObject2).mContext);
    if ((localObject3 != null) && (((Activity)localObject3).isFinishing())) {
      ((j)localObject1).gYQ = true;
    }
    ((j)localObject1).i((s)localObject2);
    ((j)localObject1).wn();
    localObject2 = this.gYf.gYb;
    localObject3 = this.gYg;
    ((o)localObject2).gYT = ((String)((o)localObject2).gZN.peekFirst());
    ((o)localObject2).gYV = null;
    Intent localIntent;
    switch (o.2.fGn[com.tencent.mm.plugin.appbrand.g.qB(localObject2.appId).ordinal()])
    {
    default: 
      localIntent = ((o)localObject2).fzW.aad().getReporter().gXX;
      if (localIntent != null) {
        if (localIntent.getComponent() == null)
        {
          localObject1 = "";
          y.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
          ((o)localObject2).gYU = 8;
          ((o)localObject2).gYV = bk.aM(localIntent.getStringExtra(AppBrandProcessProxyUI.gea), (String)localObject1);
          localObject1 = ((o)localObject2).gYV;
          ((o)localObject2).gZN.pollFirst();
          ((o)localObject2).gZN.push(bk.pm((String)localObject1));
        }
      }
      break;
    }
    for (;;)
    {
      localObject1 = l.cx(((q)localObject3).mContext);
      if ((localObject1 != null) && (((Activity)localObject1).isFinishing())) {
        ((o)localObject2).gYQ = true;
      }
      ((o)localObject2).k((s)localObject3);
      return;
      ((o)localObject2).gYU = 3;
      continue;
      ((o)localObject2).gYU = 6;
      continue;
      localObject1 = localIntent.getComponent().getClassName();
      break;
      ((o)localObject2).gYU = 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.b.2
 * JD-Core Version:    0.7.0.1
 */