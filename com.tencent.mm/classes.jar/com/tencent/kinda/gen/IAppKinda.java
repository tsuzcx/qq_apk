package com.tencent.kinda.gen;

public abstract class IAppKinda
{
  public static native IAppKinda getInstance();
  
  public abstract void applicationBecomeActive();
  
  public abstract void applicationEnterBackground();
  
  public abstract void applicationEnterForeground();
  
  public abstract void applicationReceiveMemoryWarning();
  
  public abstract void applicationResignActive();
  
  public abstract void applicationWillTerminate();
  
  public abstract boolean getIsPaying();
  
  public abstract boolean isInAnyUseCase();
  
  public abstract void networkChange(ITransmitKvData paramITransmitKvData);
  
  public abstract void notifyAllUseCases(ITransmitKvData paramITransmitKvData);
  
  public abstract UseCase startUseCase(String paramString, ITransmitKvData paramITransmitKvData, UseCaseCallback paramUseCaseCallback);
  
  public abstract void stopUseCase(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.IAppKinda
 * JD-Core Version:    0.7.0.1
 */