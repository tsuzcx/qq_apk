package com.tencent.kinda.framework.sns_cross;

import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class DefaultSnsServiceImpl
  extends BaseSnsSceneService
{
  public ITransmitKvData generateSnsUseCaseData()
  {
    AppMethodBeat.i(18707);
    ITransmitKvData localITransmitKvData = super.generateSnsUseCaseData();
    Object localObject = this.mBean.getPayInfo();
    if ((localObject == null) || (((PayInfo)localObject).hbR == null))
    {
      AppMethodBeat.o(18707);
      return localITransmitKvData;
    }
    localObject = ((PayInfo)localObject).hbR;
    localITransmitKvData.putString("cashier_desc", ((Bundle)localObject).getString("cashier_desc"));
    localITransmitKvData.putString("succ_tip", ((Bundle)localObject).getString("succ_tip"));
    localITransmitKvData.putString("prepay_page_payee", ((Bundle)localObject).getString("prepay_page_payee"));
    localITransmitKvData.putBool("need_kinda_cashier_Loading", ((Bundle)localObject).getBoolean("need_kinda_cashier_Loading", false));
    AppMethodBeat.o(18707);
    return localITransmitKvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.DefaultSnsServiceImpl
 * JD-Core Version:    0.7.0.1
 */