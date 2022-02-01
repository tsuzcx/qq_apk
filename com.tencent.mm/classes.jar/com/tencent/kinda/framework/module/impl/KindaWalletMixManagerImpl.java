package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaWalletMixManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.g.a.yp.a;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class KindaWalletMixManagerImpl
  implements KindaWalletMixManager
{
  private static final String TAG = "KindaWalletMixManagerImpl";
  private VoidCallback mCancelCallback;
  private VoidITransmitKvDataCallback mSuccessCallback;
  private c<yp> mWalletPayResultEventIListener;
  
  public KindaWalletMixManagerImpl()
  {
    AppMethodBeat.i(18662);
    this.mWalletPayResultEventIListener = new c()
    {
      public boolean callback(yp paramAnonymousyp)
      {
        AppMethodBeat.i(18660);
        int i = paramAnonymousyp.dNx.result;
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
            paramAnonymousyp = paramAnonymousyp.dNx.intent;
            if (paramAnonymousyp != null) {
              localITransmitKvData.putBool("is_jsapi_close_page", "1".equals(paramAnonymousyp.getStringExtra("is_jsapi_close_page")));
            }
            KindaWalletMixManagerImpl.this.mSuccessCallback.call(localITransmitKvData);
          }
        }
      }
    };
    AppMethodBeat.o(18662);
  }
  
  private ebj genWalletMixSpGenPrePayRespFromUrl(String paramString, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18664);
    if ((TextUtils.isEmpty(paramString)) || (paramITransmitKvData == null))
    {
      AppMethodBeat.o(18664);
      return null;
    }
    ebj localebj = new ebj();
    localebj.HNX = paramString;
    localebj.HNZ = false;
    localebj.HOa = "";
    localebj.HNY = null;
    if (paramITransmitKvData.getBool("hasCallbackRetryConf"))
    {
      localebj.HNY = new sc();
      localebj.HNY.FOR = paramITransmitKvData.getInt("maxCount");
      localebj.HNY.FOQ = paramITransmitKvData.getInt("intevalTime");
      localebj.HNY.FOS = paramITransmitKvData.getString("defaultWording");
    }
    AppMethodBeat.o(18664);
    return localebj;
  }
  
  public void startWalletMixUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18663);
    paramString = genWalletMixSpGenPrePayRespFromUrl(paramString, paramITransmitKvData);
    if ((paramString != null) && (!bt.isNullOrNil(paramString.HNX)))
    {
      paramVoidCallback2 = KindaContext.getTopOrUIPageFragmentActivity();
      if (paramVoidCallback2 == null)
      {
        ad.e("KindaWalletMixManagerImpl", "KindaWalletMixManagerImpl startWalletMixUseCaseImpl() KindaContext.getTopOrUIPageFragmentActivity() return null!");
        AppMethodBeat.o(18663);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("prepayId", paramITransmitKvData.getString("prepayId"));
      localIntent.putExtra("is_jsapi_offline_pay", false);
      localIntent.putExtra("pay_gate_url", paramString.HNX);
      localIntent.putExtra("need_dialog", paramString.HNZ);
      localIntent.putExtra("dialog_text", paramString.HOa);
      localIntent.putExtra("max_count", paramString.HNY.FOR);
      localIntent.putExtra("inteval_time", paramString.HNY.FOQ);
      localIntent.putExtra("default_wording", paramString.HNY.FOS);
      d.c(paramVoidCallback2, "wallet_core", ".ui.WalletMixOrderInfoUI", localIntent);
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