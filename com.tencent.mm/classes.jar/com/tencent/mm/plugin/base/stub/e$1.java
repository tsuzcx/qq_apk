package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLDecoder;

final class e$1
  implements f
{
  e$1(Activity paramActivity, Runnable paramRunnable) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(1200, this);
    y.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
      e.v(this.val$activity);
    }
    do
    {
      return;
      paramString = ((aa)paramm).QQ();
      y.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramString });
      try
      {
        paramString = Uri.parse(paramString);
        if (paramString == null)
        {
          y.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
          e.v(this.val$activity);
          return;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramString });
        e.v(this.val$activity);
        return;
      }
      paramm = paramString.getQueryParameter("result");
    } while (paramm == null);
    paramm = URLDecoder.decode(paramm);
    y.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramm });
    cd localcd = new cd();
    localcd.bIi.activity = this.val$activity;
    localcd.bIi.bGE = paramm;
    localcd.bIi.bIj = 19;
    localcd.bIi.from = 3;
    localcd.bIi.bIm = paramString.getQueryParameter("appid");
    localcd.bIi.bIo = this.val$activity.getIntent().getBundleExtra("_stat_obj");
    a.udP.m(localcd);
    if (this.hSk != null) {
      this.hSk.run();
    }
    ai.l(new e.1.1(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.e.1
 * JD-Core Version:    0.7.0.1
 */