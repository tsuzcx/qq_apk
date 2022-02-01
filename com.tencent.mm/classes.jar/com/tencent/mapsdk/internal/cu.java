package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cu
  extends ch.a
{
  @NetRequest(constQuery="pf=androidsdk&fr=02001", method=NetMethod.POST, path="fileupdate", queryKeys={"sdkver", "suid", "appsuid", "nt", "api_key"})
  public abstract NetResponse configFileUpdate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cu
 * JD-Core Version:    0.7.0.1
 */