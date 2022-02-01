package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface ct
  extends ch.a
{
  @NetRequest(method=NetMethod.GET, path="map/poi/detail", queryKeys={"id", "key"})
  public abstract NetResponse poiDetail(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ct
 * JD-Core Version:    0.7.0.1
 */