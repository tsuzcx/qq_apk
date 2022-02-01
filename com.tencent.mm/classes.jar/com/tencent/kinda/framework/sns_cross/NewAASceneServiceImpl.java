package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;

class NewAASceneServiceImpl
  extends BaseSnsSceneService
{
  public ITransmitKvData generateSnsUseCaseData()
  {
    AppMethodBeat.i(18711);
    ITransmitKvData localITransmitKvData = super.generateSnsUseCaseData();
    String str = SnsTextUtil.getReceiverText(this.mBean.getContext(), this.mBean.getReceiverName(), this.mBean.getTrueName());
    localITransmitKvData.putString("prepay_page_payee", str);
    localITransmitKvData.putString("cashier_desc", this.mBean.getContext().getString(2131768192, new Object[] { str }));
    AppMethodBeat.o(18711);
    return localITransmitKvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.NewAASceneServiceImpl
 * JD-Core Version:    0.7.0.1
 */