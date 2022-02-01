package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetHead;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface da
  extends ch.a
{
  @NetRequest(constQuery="channel=1&output=json&uuid=unknown", head=@NetHead(keys={"Content-Type"}, values={"application/json"}), method=NetMethod.POST, path="ditusdk/monitor", queryKeys={"key", "key2", "pid", "pid2", "hm", "suid", "os", "psv", "ver", "pf", "nt"}, userAgent="QQ Map Mobile")
  public abstract NetResponse report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.da
 * JD-Core Version:    0.7.0.1
 */