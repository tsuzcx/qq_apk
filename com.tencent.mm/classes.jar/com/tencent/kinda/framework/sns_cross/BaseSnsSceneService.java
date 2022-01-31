package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public abstract class BaseSnsSceneService
  implements ISnsSceneService
{
  SnsServiceBean mBean;
  
  public ITransmitKvData generateSnsUseCaseData()
  {
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putString("req_key", this.mBean.getReqKey());
    localITransmitKvData.putInt("payChannel", this.mBean.getChannel());
    localITransmitKvData.putInt("payScene", this.mBean.getPayScene());
    return localITransmitKvData;
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.BaseSnsSceneService
 * JD-Core Version:    0.7.0.1
 */