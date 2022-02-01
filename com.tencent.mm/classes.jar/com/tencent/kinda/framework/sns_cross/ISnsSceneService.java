package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public abstract interface ISnsSceneService
{
  public abstract ITransmitKvData generateSnsUseCaseData();
  
  public abstract void setData(Context paramContext, PayInfo paramPayInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.ISnsSceneService
 * JD-Core Version:    0.7.0.1
 */