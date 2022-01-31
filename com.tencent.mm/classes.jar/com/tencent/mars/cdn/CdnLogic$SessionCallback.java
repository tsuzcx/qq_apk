package com.tencent.mars.cdn;

public abstract interface CdnLogic$SessionCallback
{
  public abstract byte[] decodeSessionResponseBuf(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] getSessionRequestBuf(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.CdnLogic.SessionCallback
 * JD-Core Version:    0.7.0.1
 */