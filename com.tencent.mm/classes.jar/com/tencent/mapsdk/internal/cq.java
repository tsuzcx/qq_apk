package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cq
  extends ch.a
{
  @NetRequest(constQuery="channel=1&output=json&uuid=unknown", method=NetMethod.GET, path="mkey/index.php/mkey/check", queryKeys={"key", "key2", "pid", "pid2", "hm", "suid", "os", "psv", "ver", "pf", "nt"})
  public abstract NetResponse checkAuth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10);
  
  @NetRequest(constQuery="channel=1&output=json", method=NetMethod.GET, path="sdkapis/v1/cos_token", queryKeys={"filename", "key", "pid"})
  public abstract NetResponse uploadToken(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cq
 * JD-Core Version:    0.7.0.1
 */