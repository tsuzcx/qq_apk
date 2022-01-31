package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaWalletMixManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;

public class KindaWalletMixManagerImpl
  implements KindaWalletMixManager
{
  private VoidCallback mCancelCallback;
  private VoidITransmitKvDataCallback mSuccessCallback;
  private c<vk> mWalletPayResultEventIListener;
  
  public KindaWalletMixManagerImpl()
  {
    AppMethodBeat.i(144545);
    this.mWalletPayResultEventIListener = new KindaWalletMixManagerImpl.1(this);
    AppMethodBeat.o(144545);
  }
  
  private cvm genWalletMixSpGenPrePayRespFromUrl(String paramString, ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(144547);
    if ((TextUtils.isEmpty(paramString)) || (paramITransmitKvData == null))
    {
      AppMethodBeat.o(144547);
      return null;
    }
    cvm localcvm = new cvm();
    localcvm.ydT = paramString;
    localcvm.ydV = false;
    localcvm.ydW = "";
    localcvm.ydU = null;
    if (paramITransmitKvData.getBool("hasCallbackRetryConf"))
    {
      localcvm.ydU = new nw();
      localcvm.ydU.wDy = paramITransmitKvData.getInt("maxCount");
      localcvm.ydU.wDx = paramITransmitKvData.getInt("intevalTime");
      localcvm.ydU.wDz = paramITransmitKvData.getString("defaultWording");
    }
    AppMethodBeat.o(144547);
    return localcvm;
  }
  
  public void startWalletMixUseCaseImpl(String paramString, ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(144546);
    paramString = genWalletMixSpGenPrePayRespFromUrl(paramString, paramITransmitKvData);
    if ((paramString != null) && (!bo.isNullOrNil(paramString.ydT)))
    {
      paramVoidCallback2 = new Intent();
      paramVoidCallback2.putExtra("prepayId", paramITransmitKvData.getString("prepayId"));
      paramVoidCallback2.putExtra("is_jsapi_offline_pay", false);
      paramVoidCallback2.putExtra("pay_gate_url", paramString.ydT);
      paramVoidCallback2.putExtra("need_dialog", paramString.ydV);
      paramVoidCallback2.putExtra("dialog_text", paramString.ydW);
      paramVoidCallback2.putExtra("max_count", paramString.ydU.wDy);
      paramVoidCallback2.putExtra("inteval_time", paramString.ydU.wDx);
      paramVoidCallback2.putExtra("default_wording", paramString.ydU.wDz);
      d.c(KindaContext.getTopOrUIPageFragmentActivity(), "wallet_core", ".ui.WalletMixOrderInfoUI", paramVoidCallback2);
    }
    this.mSuccessCallback = paramVoidITransmitKvDataCallback;
    this.mCancelCallback = paramVoidCallback1;
    this.mWalletPayResultEventIListener.alive();
    AppMethodBeat.o(144546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWalletMixManagerImpl
 * JD-Core Version:    0.7.0.1
 */