package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.net.URLDecoder;

final class f$1
  implements h
{
  f$1(Activity paramActivity, Runnable paramRunnable) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(22227);
    bh.aZW().b(1200, this);
    Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
      f.U(this.val$activity);
      AppMethodBeat.o(22227);
      return;
    }
    paramString = ((ad)paramp).bMz();
    Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramString });
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString == null)
      {
        Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
        f.U(this.val$activity);
        AppMethodBeat.o(22227);
        return;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramString });
      f.U(this.val$activity);
      AppMethodBeat.o(22227);
      return;
    }
    paramp = paramString.getQueryParameter("result");
    if (paramp != null)
    {
      paramp = URLDecoder.decode(paramp);
      Log.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramp });
      df localdf = new df();
      localdf.hDa.activity = this.val$activity;
      localdf.hDa.hBi = paramp;
      localdf.hDa.hDb = 19;
      localdf.hDa.from = 3;
      localdf.hDa.hDd = paramString.getQueryParameter("appid");
      localdf.hDa.hDf = this.val$activity.getIntent().getBundleExtra("_stat_obj");
      localdf.publish();
      if (this.vrX != null) {
        this.vrX.run();
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.1
 * JD-Core Version:    0.7.0.1
 */