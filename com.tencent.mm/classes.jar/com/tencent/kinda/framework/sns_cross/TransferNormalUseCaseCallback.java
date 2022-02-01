package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class TransferNormalUseCaseCallback
  implements ISnsUseCaseCallback
{
  private SnsServiceBean mBean;
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18723);
    Object localObject = this.mBean.getContext();
    if (("1".equals(paramITransmitKvData.getString("closeLoading"))) && ((localObject instanceof WalletBaseUI)))
    {
      if ((localObject instanceof RemittanceF2fDynamicCodeUI))
      {
        ((RemittanceF2fDynamicCodeUI)localObject).hideProgress();
        AppMethodBeat.o(18723);
        return;
      }
      ((WalletBaseUI)localObject).hideLoading();
      AppMethodBeat.o(18723);
      return;
    }
    String str = paramITransmitKvData.getString("transaction_id");
    int i = this.mBean.getPayScene();
    int j = paramITransmitKvData.getInt("retcode");
    long l = paramITransmitKvData.getLong("total_fee");
    int k = paramITransmitKvData.getInt("action");
    gj localgj = new gj();
    localgj.dse.dlu = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      localgj.dse.type = 0;
      if (i != 31) {
        break label362;
      }
      if ((j != 1) || (k != 1)) {
        break label339;
      }
      localgj.dse.dlw = 1;
    }
    for (;;)
    {
      localgj.dse.dlv = str;
      localgj.dse.isKinda = true;
      localgj.dse.dsf = localObject.hashCode();
      a.IbL.l(localgj);
      localObject = new aq();
      ((aq)localObject).dlt.dlu = paramITransmitKvData.getString("req_key");
      ((aq)localObject).dlt.dlv = str;
      ((aq)localObject).dlt.dlw = j;
      ((aq)localObject).dlt.dlx = (l / 100.0D);
      ((aq)localObject).dlt.isKinda = true;
      ((aq)localObject).dlt.dly = paramITransmitKvData.getInt("pay_fail_reason");
      a.IbL.l((b)localObject);
      AppMethodBeat.o(18723);
      return;
      if ((i != 32) && (i != 33)) {
        break;
      }
      localgj.dse.type = 1;
      break;
      label339:
      if ((j == 1) && (k == 2))
      {
        localgj.dse.dlw = 2;
        continue;
        label362:
        localgj.dse.dlw = j;
      }
    }
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(18722);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(18722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.TransferNormalUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */