package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaWalletMixManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.a;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class KindaWalletMixManagerImpl
  implements KindaWalletMixManager
{
  private static final String TAG = "KindaWalletMixManagerImpl";
  private VoidCallback mCancelCallback;
  private VoidITransmitKvDataCallback mSuccessCallback;
  private c<yv> mWalletPayResultEventIListener;
  
  public KindaWalletMixManagerImpl()
  {
    AppMethodBeat.i(18662);
    this.mWalletPayResultEventIListener = new c()
    {
      public boolean callback(yv paramAnonymousyv)
      {
        AppMethodBeat.i(18660);
        int i = paramAnonymousyv.dON.result;
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
            paramAnonymousyv = paramAnonymousyv.dON.intent;
            if (paramAnonymousyv != null) {
              localITransmitKvData.putBool("is_jsapi_close_page", "1".equals(paramAnonymousyv.getStringExtra("is_jsapi_close_page")));
            }
            KindaWalletMixManagerImpl.this.mSuccessCallback.call(localITransmitKvData);
          }
        }
      }
    };
    AppMethodBeat.o(18662);
  }
  
  private eda genWalletMixSpGenPrePayRespFromUrl(String paramString, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18664);
    if ((TextUtils.isEmpty(paramString)) || (paramITransmitKvData == null))
    {
      AppMethodBeat.o(18664);
      return null;
    }
    eda localeda = new eda();
    localeda.Iie = paramString;
    localeda.Iig = false;
    localeda.Iih = "";
    localeda.Iif = null;
    if (paramITransmitKvData.getBool("hasCallbackRetryConf"))
    {
      localeda.Iif = new se();
      localeda.Iif.Ghq = paramITransmitKvData.getInt("maxCount");
      localeda.Iif.Ghp = paramITransmitKvData.getInt("intevalTime");
      localeda.Iif.Ghr = paramITransmitKvData.getString("defaultWording");
    }
    AppMethodBeat.o(18664);
    return localeda;
  }
  
  public void startWalletMixUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18663);
    paramString = genWalletMixSpGenPrePayRespFromUrl(paramString, paramITransmitKvData);
    if ((paramString != null) && (!bu.isNullOrNil(paramString.Iie)))
    {
      paramVoidCallback2 = KindaContext.getTopOrUIPageFragmentActivity();
      if (paramVoidCallback2 == null)
      {
        ae.e("KindaWalletMixManagerImpl", "KindaWalletMixManagerImpl startWalletMixUseCaseImpl() KindaContext.getTopOrUIPageFragmentActivity() return null!");
        AppMethodBeat.o(18663);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("prepayId", paramITransmitKvData.getString("prepayId"));
      localIntent.putExtra("is_jsapi_offline_pay", false);
      localIntent.putExtra("pay_gate_url", paramString.Iie);
      localIntent.putExtra("need_dialog", paramString.Iig);
      localIntent.putExtra("dialog_text", paramString.Iih);
      localIntent.putExtra("max_count", paramString.Iif.Ghq);
      localIntent.putExtra("inteval_time", paramString.Iif.Ghp);
      localIntent.putExtra("default_wording", paramString.Iif.Ghr);
      d.c(paramVoidCallback2, "wallet_core", ".ui.WalletMixOrderInfoUI", localIntent);
    }
    this.mSuccessCallback = paramVoidITransmitKvDataCallback;
    this.mCancelCallback = paramVoidCallback1;
    this.mWalletPayResultEventIListener.alive();
    AppMethodBeat.o(18663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWalletMixManagerImpl
 * JD-Core Version:    0.7.0.1
 */