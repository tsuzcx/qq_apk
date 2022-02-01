package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cr
  extends ch.a
{
  @NetRequest(method=NetMethod.URL, path="indoormap2", useExtraQuery=false)
  public abstract String getIndoorMapUrl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cr
 * JD-Core Version:    0.7.0.1
 */