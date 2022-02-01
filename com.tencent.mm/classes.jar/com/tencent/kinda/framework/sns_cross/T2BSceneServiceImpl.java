package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class T2BSceneServiceImpl
  extends BaseSnsSceneService
{
  public ITransmitKvData generateSnsUseCaseData()
  {
    AppMethodBeat.i(18719);
    ITransmitKvData localITransmitKvData = super.generateSnsUseCaseData();
    if ((this.mBean.getPayInfo() == null) || (this.mBean.getPayInfo().iqp == null))
    {
      AppMethodBeat.o(18719);
      return localITransmitKvData;
    }
    Object localObject = this.mBean.getPayInfo().iqp;
    String str = ((Bundle)localObject).getString("extinfo_key_3");
    localObject = ((Bundle)localObject).getString("extinfo_key_4");
    str = this.mBean.getContext().getString(2131756534, new Object[] { str, localObject }) + this.mBean.getTrueName();
    localITransmitKvData.putString("cashier_desc", this.mBean.getContext().getString(2131764505, new Object[] { str }));
    AppMethodBeat.o(18719);
    return localITransmitKvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.T2BSceneServiceImpl
 * JD-Core Version:    0.7.0.1
 */