package com.tencent.kinda.framework.sns_cross;

import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class MobileRemittanceServiceImpl
  extends BaseSnsSceneService
{
  public ITransmitKvData generateSnsUseCaseData()
  {
    AppMethodBeat.i(193166);
    ITransmitKvData localITransmitKvData = super.generateSnsUseCaseData();
    if ((this.mBean.getPayInfo() == null) || (this.mBean.getPayInfo().hwN == null))
    {
      AppMethodBeat.o(193166);
      return localITransmitKvData;
    }
    localITransmitKvData.putString("cashier_desc", this.mBean.getPayInfo().hwN.getString("extinfo_key_12"));
    AppMethodBeat.o(193166);
    return localITransmitKvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.MobileRemittanceServiceImpl
 * JD-Core Version:    0.7.0.1
 */