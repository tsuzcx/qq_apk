package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface db
  extends ch.a
{
  @NetRequest(constQuery="p_ver=1", method=NetMethod.GET, path="map/traffic/event", queryKeys={"param"})
  public abstract NetResponse mapTrafficEvent(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.db
 * JD-Core Version:    0.7.0.1
 */