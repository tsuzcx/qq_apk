package com.tencent.map.swlocation.api;

import com.b.a.a.q;

public abstract interface INetworkApi
  extends q
{
  @Deprecated
  public abstract byte[] httpRequest(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] httpRequest(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.swlocation.api.INetworkApi
 * JD-Core Version:    0.7.0.1
 */