package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.co;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.net.URLDecoder;

final class f$1
  implements com.tencent.mm.ak.f
{
  f$1(Activity paramActivity, Runnable paramRunnable) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(22227);
    bc.ajj().b(1200, this);
    ae.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
      f.L(this.val$activity);
      AppMethodBeat.o(22227);
      return;
    }
    paramString = ((ac)paramn).aLz();
    ae.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramString });
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString == null)
      {
        ae.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
        f.L(this.val$activity);
        AppMethodBeat.o(22227);
        return;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramString });
      f.L(this.val$activity);
      AppMethodBeat.o(22227);
      return;
    }
    paramn = paramString.getQueryParameter("result");
    if (paramn != null)
    {
      paramn = URLDecoder.decode(paramn);
      ae.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramn });
      co localco = new co();
      localco.dou.activity = this.val$activity;
      localco.dou.dmI = paramn;
      localco.dou.dov = 19;
      localco.dou.from = 3;
      localco.dou.dox = paramString.getQueryParameter("appid");
      localco.dou.doz = this.val$activity.getIntent().getBundleExtra("_stat_obj");
      a.IvT.l(localco);
      if (this.nTo != null) {
        this.nTo.run();
      }
      ar.o(new Runnable()
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