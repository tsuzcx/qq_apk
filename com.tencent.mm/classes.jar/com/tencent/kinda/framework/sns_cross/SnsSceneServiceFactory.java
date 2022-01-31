package com.tencent.kinda.framework.sns_cross;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnsSceneServiceFactory
{
  public static ISnsUseCaseCallback createCallback(int paramInt)
  {
    AppMethodBeat.i(144604);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new SnsSceneServiceFactory.1();
    }
    for (;;)
    {
      AppMethodBeat.o(144604);
      return localObject;
      localObject = new TransferNormalUseCaseCallback();
      continue;
      localObject = new NewAAUseCaseCallback();
      continue;
      localObject = new LuckMoneyUseCaseCallback();
      continue;
      localObject = new T2BUseCaseCallback();
    }
  }
  
  public static ISnsSceneService createService(int paramInt)
  {
    AppMethodBeat.i(144603);
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = new DefaultSnsServiceImpl();
    }
    for (;;)
    {
      AppMethodBeat.o(144603);
      return localObject;
      localObject = new QRCodeRewardServiceImpl();
      continue;
      localObject = new NewAASceneServiceImpl();
      continue;
      localObject = new T2BSceneServiceImpl();
      continue;
      localObject = new HongBaoServiceImpl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.SnsSceneServiceFactory
 * JD-Core Version:    0.7.0.1
 */