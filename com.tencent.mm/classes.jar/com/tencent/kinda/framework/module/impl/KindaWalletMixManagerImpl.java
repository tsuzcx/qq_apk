package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaWalletMixManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.ade.a;
import com.tencent.mm.br.c;
import com.tencent.mm.protocal.protobuf.geh;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class KindaWalletMixManagerImpl
  implements KindaWalletMixManager
{
  private static final String TAG = "KindaWalletMixManagerImpl";
  private VoidCallback mCancelCallback;
  private VoidITransmitKvDataCallback mSuccessCallback;
  private IListener<ade> mWalletPayResultEventIListener;
  
  public KindaWalletMixManagerImpl()
  {
    AppMethodBeat.i(18662);
    this.mWalletPayResultEventIListener = new IListener(f.hfK)
    {
      public boolean callback(ade paramAnonymousade)
      {
        AppMethodBeat.i(18660);
        int i = paramAnonymousade.ihj.result;
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
            paramAnonymousade = paramAnonymousade.ihj.intent;
            if (paramAnonymousade != null) {
              localITransmitKvData.putBool("is_jsapi_close_page", "1".equals(paramAnonymousade.getStringExtra("is_jsapi_close_page")));
            }
            KindaWalletMixManagerImpl.this.mSuccessCallback.call(localITransmitKvData);
          }
        }
      }
    };
    AppMethodBeat.o(18662);
  }
  
  private geh genWalletMixSpGenPrePayRespFromUrl(String paramString, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18664);
    if ((TextUtils.isEmpty(paramString)) || (paramITransmitKvData == null))
    {
      AppMethodBeat.o(18664);
      return null;
    }
    geh localgeh = new geh();
    localgeh.acbS = paramString;
    localgeh.acbU = false;
    localgeh.acbV = "";
    localgeh.acbT = null;
    if (paramITransmitKvData.getBool("hasCallbackRetryConf"))
    {
      localgeh.acbT = new uz();
      localgeh.acbT.ZaY = paramITransmitKvData.getInt("maxCount");
      localgeh.acbT.ZaX = paramITransmitKvData.getInt("intevalTime");
      localgeh.acbT.ZaZ = paramITransmitKvData.getString("defaultWording");
    }
    AppMethodBeat.o(18664);
    return localgeh;
  }
  
  public void startWalletMixUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18663);
    paramString = genWalletMixSpGenPrePayRespFromUrl(paramString, paramITransmitKvData);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.acbS)))
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
      localIntent.putExtra("pay_gate_url", paramString.acbS);
      localIntent.putExtra("need_dialog", paramString.acbU);
      localIntent.putExtra("dialog_text", paramString.acbV);
      localIntent.putExtra("max_count", paramString.acbT.ZaY);
      localIntent.putExtra("inteval_time", paramString.acbT.ZaX);
      localIntent.putExtra("default_wording", paramString.acbT.ZaZ);
      c.c(paramVoidCallback2, "wallet_core", ".ui.WalletMixOrderInfoUI", localIntent);
    }
    this.mSuccessCallback = paramVoidITransmitKvDataCallback;
    this.mCancelCallback = paramVoidCallback1;
    this.mWalletPayResultEventIListener.alive();
    AppMethodBeat.o(18663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWalletMixManagerImpl
 * JD-Core Version:    0.7.0.1
 */