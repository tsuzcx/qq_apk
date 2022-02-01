package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.net.URLDecoder;

final class f$1
  implements g
{
  f$1(Activity paramActivity, Runnable paramRunnable) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(22227);
    az.aeS().b(1200, this);
    ad.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
      f.K(this.val$activity);
      AppMethodBeat.o(22227);
      return;
    }
    paramString = ((ab)paramn).aBb();
    ad.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramString });
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString == null)
      {
        ad.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
        f.K(this.val$activity);
        AppMethodBeat.o(22227);
        return;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramString });
      f.K(this.val$activity);
      AppMethodBeat.o(22227);
      return;
    }
    paramn = paramString.getQueryParameter("result");
    if (paramn != null)
    {
      paramn = URLDecoder.decode(paramn);
      ad.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramn });
      cl localcl = new cl();
      localcl.deA.activity = this.val$activity;
      localcl.deA.dcO = paramn;
      localcl.deA.deB = 19;
      localcl.deA.from = 3;
      localcl.deA.deE = paramString.getQueryParameter("appid");
      localcl.deA.deG = this.val$activity.getIntent().getBundleExtra("_stat_obj");
      a.ESL.l(localcl);
      if (this.mKM != null) {
        this.mKM.run();
      }
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22226);
          f.1.this.val$activity.finish();
          AppMethodBeat.o(22226);
        }
      }, 100L);
    }
    AppMethodBeat.o(22227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.1
 * JD-Core Version:    0.7.0.1
 */