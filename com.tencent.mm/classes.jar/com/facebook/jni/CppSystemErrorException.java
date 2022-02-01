package com.facebook.jni;

public class CppSystemErrorException
  extends CppException
{
  int errorCode;
  
  public CppSystemErrorException(String paramString, int paramInt)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.facebook.jni.CppSystemErrorException
 * JD-Core Version:    0.7.0.1
 */