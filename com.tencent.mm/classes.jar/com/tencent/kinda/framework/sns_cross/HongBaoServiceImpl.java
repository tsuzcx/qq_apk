package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.kinda.framework.R.string;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HongBaoServiceImpl
  extends BaseSnsSceneService
{
  public ITransmitKvData generateSnsUseCaseData()
  {
    AppMethodBeat.i(18708);
    ITransmitKvData localITransmitKvData = super.generateSnsUseCaseData();
    localITransmitKvData.putString("cashier_desc", this.mBean.getContext().getResources().getString(R.string.lucky_money_title));
    AppMethodBeat.o(18708);
    return localITransmitKvData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.HongBaoServiceImpl
 * JD-Core Version:    0.7.0.1
 */