package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class SnsSceneServiceFactory
{
  public static ISnsUseCaseCallback createCallback(int paramInt)
  {
    AppMethodBeat.i(18716);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new ISnsUseCaseCallback()
      {
        public final void call(ITransmitKvData paramAnonymousITransmitKvData) {}
        
        public final void setData(Context paramAnonymousContext, PayInfo paramAnonymousPayInfo) {}
      };
    }
    for (;;)
    {
      AppMethodBeat.o(18716);
      return localObject;
      localObject = new TransferNormalUseCaseCallback();
      continue;
      localObject = new NewAAUseCaseCallback();
      continue;
      localObject = new LuckMoneyUseCaseCallback();
      continue;
      localObject = new T2BUseCaseCallback();
      continue;
      localObject = new MobileRemittanceCaseCallBack();
    }
  }
  
  public static ISnsSceneService createService(int paramInt)
  {
    AppMethodBeat.i(18715);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new DefaultSnsServiceImpl();
    }
    for (;;)
    {
      AppMethodBeat.o(18715);
      return localObject;
      localObject = new QRCodeRewardServiceImpl();
      continue;
      localObject = new NewAASceneServiceImpl();
      continue;
      localObject = new T2BSceneServiceImpl();
      continue;
      localObject = new MobileRemittanceServiceImpl();
      continue;
      localObject = new HongBaoServiceImpl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.SnsSceneServiceFactory
 * JD-Core Version:    0.7.0.1
 */