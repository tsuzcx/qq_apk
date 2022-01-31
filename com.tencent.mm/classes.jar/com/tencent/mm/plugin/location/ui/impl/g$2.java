package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.5;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.protocal.c.bka;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$2
  implements o.b
{
  g$2(g paramg) {}
  
  public final void a(bka parambka)
  {
    g.a(this.lKi, parambka);
  }
  
  public final void bej()
  {
    y.i("MicroMsg.ShareMapUI", "onJoinSucess");
    o localo = this.lKi.lJW;
    localo.lDZ = true;
    localo.bef();
    localo.beg();
    this.lKi.lJV.hk(true);
    if (this.lKi.lJY != null) {
      this.lKi.lJY.bex();
    }
  }
  
  public final void bek()
  {
    this.lKi.lJV.hk(false);
    this.lKi.lJW.stop();
    this.lKi.lJW.sY(3);
    k.beA();
    this.lKi.activity.finish();
    this.lKi.activity.overridePendingTransition(a.a.push_empty_out, a.a.push_up_out);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    y.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.mm.plugin.report.service.h.nFQ.f(10997, new Object[] { "7", "", Integer.valueOf(0), Integer.valueOf(0) });
    l locall = this.lKi.lJX;
    y.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[] { paramString });
    Context localContext = ae.getContext();
    Object localObject = null;
    if (bk.bl(paramString)) {
      if (paramInt == 0) {
        paramString = localContext.getString(a.h.location_join_failed_tips);
      }
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(locall.mContext, paramString, "", locall.mResources.getString(a.h.app_ok), false, new l.5(locall, paramInt));
      return;
      if (paramInt == 1)
      {
        paramString = localContext.getString(a.h.location_refresh_failed_tips);
      }
      else
      {
        paramString = localObject;
        if (paramInt == 2) {
          paramString = localContext.getString(a.h.location_refresh_kick_out_tips);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.2
 * JD-Core Version:    0.7.0.1
 */