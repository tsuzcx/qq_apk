package com.tencent.kinda.gen;

public abstract interface KCrtService
{
  public abstract void delCert();
  
  public abstract String getCrtNo();
  
  public abstract boolean hasCrt();
  
  public abstract String sign(String paramString, byte[] paramArrayOfByte);
  
  public abstract void startGenDigitalCrtImpl(KGenDigitalCrtReq paramKGenDigitalCrtReq, VoidCallback paramVoidCallback, VoidStringCallback paramVoidStringCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KCrtService
 * JD-Core Version:    0.7.0.1
 */