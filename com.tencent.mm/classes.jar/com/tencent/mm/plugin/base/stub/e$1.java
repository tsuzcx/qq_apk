package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.al;
import java.net.URLDecoder;

final class e$1
  implements f
{
  e$1(Activity paramActivity, Runnable paramRunnable) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(18158);
    aw.Rc().b(1200, this);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
      e.y(this.val$activity);
      AppMethodBeat.o(18158);
      return;
    }
    paramString = ((com.tencent.mm.modelsimple.ab)paramm).ajX();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramString });
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
        e.y(this.val$activity);
        AppMethodBeat.o(18158);
        return;
      }
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramString });
      e.y(this.val$activity);
      AppMethodBeat.o(18158);
      return;
    }
    paramm = paramString.getQueryParameter("result");
    if (paramm != null)
    {
      paramm = URLDecoder.decode(paramm);
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramm });
      cg localcg = new cg();
      localcg.cpD.activity = this.val$activity;
      localcg.cpD.cnR = paramm;
      localcg.cpD.cpE = 19;
      localcg.cpD.from = 3;
      localcg.cpD.cpH = paramString.getQueryParameter("appid");
      localcg.cpD.cpJ = this.val$activity.getIntent().getBundleExtra("_stat_obj");
      a.ymk.l(localcg);
      if (this.jLS != null) {
        this.jLS.run();
      }
      al.p(new e.1.1(this), 100L);
    }
    AppMethodBeat.o(18158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.e.1
 * JD-Core Version:    0.7.0.1
 */