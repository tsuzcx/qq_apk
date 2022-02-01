package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cx
  extends ch.a
{
  @NetRequest(method=NetMethod.POST, path="rttserverex/", userAgent="sosomap navsns")
  public abstract NetResponse rttData(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cx
 * JD-Core Version:    0.7.0.1
 */