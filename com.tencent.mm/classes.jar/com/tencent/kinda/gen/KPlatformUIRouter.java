package com.tencent.kinda.gen;

public abstract interface KPlatformUIRouter
{
  public abstract void gotoExternApp(String paramString1, int paramInt, String paramString2);
  
  public abstract void openTinyApp(String paramString1, String paramString2, String paramString3);
  
  public abstract void openTinyAppImpl(String paramString1, String paramString2, String paramString3, VoidCallback paramVoidCallback);
  
  public abstract void openUrlScheme(String paramString);
  
  public abstract void openWeb(ITransmitKvData paramITransmitKvData);
  
  public abstract void openWebImpl(ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KPlatformUIRouter
 * JD-Core Version:    0.7.0.1
 */