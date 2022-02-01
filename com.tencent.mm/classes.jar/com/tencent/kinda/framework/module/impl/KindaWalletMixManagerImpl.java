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
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xv.a;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class KindaWalletMixManagerImpl
  implements KindaWalletMixManager
{
  private static final String TAG = "KindaWalletMixManagerImpl";
  private VoidCallback mCancelCallback;
  private VoidITransmitKvDataCallback mSuccessCallback;
  private c<xv> mWalletPayResultEventIListener;
  
  public KindaWalletMixManagerImpl()
  {
    AppMethodBeat.i(18662);
    this.mWalletPayResultEventIListener = new c()
    {
      public boolean callback(xv paramAnonymousxv)
      {
        AppMethodBeat.i(18660);
        int i = paramAnonymousxv.dBk.result;
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
            paramAnonymousxv = paramAnonymousxv.dBk.intent;
            if (paramAnonymousxv != null) {
              localITransmitKvData.putBool("is_jsapi_close_page", "1".equals(paramAnonymousxv.getStringExtra("is_jsapi_close_page")));
            }
            KindaWalletMixManagerImpl.this.mSuccessCallback.call(localITransmitKvData);
          }
        }
      }
    };
    AppMethodBeat.o(18662);
  }
  
  private dvk genWalletMixSpGenPrePayRespFromUrl(String paramString, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18664);
    if ((TextUtils.isEmpty(paramString)) || (paramITransmitKvData == null))
    {
      AppMethodBeat.o(18664);
      return null;
    }
    dvk localdvk = new dvk();
    localdvk.GcR = paramString;
    localdvk.GcT = false;
    localdvk.GcU = "";
    localdvk.GcS = null;
    if (paramITransmitKvData.getBool("hasCallbackRetryConf"))
    {
      localdvk.GcS = new ql();
      localdvk.GcS.EhK = paramITransmitKvData.getInt("maxCount");
      localdvk.GcS.EhJ = paramITransmitKvData.getInt("intevalTime");
      localdvk.GcS.EhL = paramITransmitKvData.getString("defaultWording");
    }
    AppMethodBeat.o(18664);
    return localdvk;
  }
  
  public void startWalletMixUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18663);
    paramString = genWalletMixSpGenPrePayRespFromUrl(paramString, paramITransmitKvData);
    if ((paramString != null) && (!bs.isNullOrNil(paramString.GcR)))
    {
      paramVoidCallback2 = KindaContext.getTopOrUIPageFragmentActivity();
      if (paramVoidCallback2 == null)
      {
        ac.e("KindaWalletMixManagerImpl", "KindaWalletMixManagerImpl startWalletMixUseCaseImpl() KindaContext.getTopOrUIPageFragmentActivity() return null!");
        AppMethodBeat.o(18663);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("prepayId", paramITransmitKvData.getString("prepayId"));
      localIntent.putExtra("is_jsapi_offline_pay", false);
      localIntent.putExtra("pay_gate_url", paramString.GcR);
      localIntent.putExtra("need_dialog", paramString.GcT);
      localIntent.putExtra("dialog_text", paramString.GcU);
      localIntent.putExtra("max_count", paramString.GcS.EhK);
      localIntent.putExtra("inteval_time", paramString.GcS.EhJ);
      localIntent.putExtra("default_wording", paramString.GcS.EhL);
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