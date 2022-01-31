package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

class QRCodeRewardServiceImpl
  extends BaseSnsSceneService
{
  public ITransmitKvData generateSnsUseCaseData()
  {
    AppMethodBeat.i(144602);
    ITransmitKvData localITransmitKvData = super.generateSnsUseCaseData();
    localITransmitKvData.putString("rece_desc", "收款方");
    localITransmitKvData.putString("rece_name", SnsTextUtil.getReceiverText(this.mBean.getContext(), this.mBean.getReceiverName(), this.mBean.getTrueName()));
    localITransmitKvData.putString("username", this.mBean.getReceiverName());
    localITransmitKvData.putString("cashier_desc", this.mBean.getContext().getString(2131302211));
    localITransmitKvData.putString("rece_remark", this.mBean.getPayInfo().wgv.getString("extinfo_key_3"));
    localITransmitKvData.putString("payee_remark", this.mBean.getPayInfo().wgv.getString("extinfo_key_7"));
    AppMethodBeat.o(144602);
    return localITransmitKvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.QRCodeRewardServiceImpl
 * JD-Core Version:    0.7.0.1
 */