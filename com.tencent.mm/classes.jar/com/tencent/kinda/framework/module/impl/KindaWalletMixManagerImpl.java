package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaWalletMixManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aaa.a;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class KindaWalletMixManagerImpl
  implements KindaWalletMixManager
{
  private static final String TAG = "KindaWalletMixManagerImpl";
  private VoidCallback mCancelCallback;
  private VoidITransmitKvDataCallback mSuccessCallback;
  private IListener<aaa> mWalletPayResultEventIListener;
  
  public KindaWalletMixManagerImpl()
  {
    AppMethodBeat.i(18662);
    this.mWalletPayResultEventIListener = new IListener()
    {
      public boolean callback(aaa paramAnonymousaaa)
      {
        AppMethodBeat.i(18660);
        int i = paramAnonymousaaa.egJ.result;
        if (i == 0) {
          if (KindaWalletMixManagerImpl.this.mCancelCallback != null) {
            KindaWalletMixManagerImpl.this.mCancelCallback.call();
          }
        }
        for (;;)
        {
          KindaWalletMixManagerImpl.this.mWalletPayResultEventIListener.dead();
          AppMethodBeat.o(18660);
          return false;
          if ((i == -1) && (KindaWalletMixManagerImpl.this.mSuccessCallback != null))
          {
            ITransmitKvData localITransmitKvData = ITransmitKvData.create();
            paramAnonymousaaa = paramAnonymousaaa.egJ.intent;
            if (paramAnonymousaaa != null) {
              localITransmitKvData.putBool("is_jsapi_close_page", "1".equals(paramAnonymousaaa.getStringExtra("is_jsapi_close_page")));
            }
            KindaWalletMixManagerImpl.this.mSuccessCallback.call(localITransmitKvData);
          }
        }
      }
    };
    AppMethodBeat.o(18662);
  }
  
  private exi genWalletMixSpGenPrePayRespFromUrl(String paramString, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18664);
    if ((TextUtils.isEmpty(paramString)) || (paramITransmitKvData == null))
    {
      AppMethodBeat.o(18664);
      return null;
    }
    exi localexi = new exi();
    localexi.NuI = paramString;
    localexi.NuK = false;
    localexi.NuL = "";
    localexi.NuJ = null;
    if (paramITransmitKvData.getBool("hasCallbackRetryConf"))
    {
      localexi.NuJ = new th();
      localexi.NuJ.LbT = paramITransmitKvData.getInt("maxCount");
      localexi.NuJ.LbS = paramITransmitKvData.getInt("intevalTime");
      localexi.NuJ.LbU = paramITransmitKvData.getString("defaultWording");
    }
    AppMethodBeat.o(18664);
    return localexi;
  }
  
  public void startWalletMixUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18663);
    paramString = genWalletMixSpGenPrePayRespFromUrl(paramString, paramITransmitKvData);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.NuI)))
    {
      paramVoidCallback2 = KindaContext.getTopOrUIPageFragmentActivity();
      if (paramVoidCallback2 == null)
      {
        Log.e("KindaWalletMixManagerImpl", "KindaWalletMixManagerImpl startWalletMixUseCaseImpl() KindaContext.getTopOrUIPageFragmentActivity() return null!");
        AppMethodBeat.o(18663);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("prepayId", paramITransmitKvData.getString("prepayId"));
      localIntent.putExtra("is_jsapi_offline_pay", false);
      localIntent.putExtra("pay_gate_url", paramString.NuI);
      localIntent.putExtra("need_dialog", paramString.NuK);
      localIntent.putExtra("dialog_text", paramString.NuL);
      localIntent.putExtra("max_count", paramString.NuJ.LbT);
      localIntent.putExtra("inteval_time", paramString.NuJ.LbS);
      localIntent.putExtra("default_wording", paramString.NuJ.LbU);
      c.c(paramVoidCallback2, "wallet_core", ".ui.WalletMixOrderInfoUI", localIntent);
    }
    this.mSuccessCallback = paramVoidITransmitKvDataCallback;
    this.mCancelCallback = paramVoidCallback1;
    this.mWalletPayResultEventIListener.alive();
    AppMethodBeat.o(18663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWalletMixManagerImpl
 * JD-Core Version:    0.7.0.1
 */