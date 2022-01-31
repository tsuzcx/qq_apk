package com.tencent.kinda.gen;

import java.util.HashMap;

public abstract class KNetworkMockManager
{
  public static native HashMap<Integer, String> getCgiList();
  
  public abstract byte[] jsonToRequestData(String paramString);
  
  public abstract byte[] jsonToResponseData(String paramString);
  
  public abstract String requestDataToJson(byte[] paramArrayOfByte);
  
  public abstract String responseDataToJson(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KNetworkMockManager
 * JD-Core Version:    0.7.0.1
 */