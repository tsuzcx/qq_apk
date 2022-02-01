package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cs
  extends ch.a
{
  @NetRequest(method=NetMethod.URL, path="indoor_map", useExtraQuery=false)
  public abstract String getIndoorMapUrl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cs
 * JD-Core Version:    0.7.0.1
 */