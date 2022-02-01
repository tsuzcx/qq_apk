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
    AppMethodBeat.i(214458);
    ITransmitKvData localITransmitKvData = super.generateSnsUseCaseData();
    if ((this.mBean.getPayInfo() == null) || (this.mBean.getPayInfo().iqp == null))
    {
      AppMethodBeat.o(214458);
      return localITransmitKvData;
    }
    localITransmitKvData.putString("cashier_desc", this.mBean.getPayInfo().iqp.getString("extinfo_key_12"));
    AppMethodBeat.o(214458);
    return localITransmitKvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.MobileRemittanceServiceImpl
 * JD-Core Version:    0.7.0.1
 */