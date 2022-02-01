package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cw
  extends ch.a
{
  @NetRequest(constQuery="ctrlpf=vector&ctrlmb=and", method=NetMethod.GET, queryKeys={"apikey", "ver", "ctrlver", "uk", "frontier", "scenetype", "mpt"})
  public abstract NetResponse checkAuth(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cw
 * JD-Core Version:    0.7.0.1
 */