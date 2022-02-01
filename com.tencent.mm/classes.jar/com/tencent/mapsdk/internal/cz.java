package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cz
  extends ch.a
{
  @NetRequest(constQuery="styleid=7", method=NetMethod.URL, path="scenic/", queryKeys={"x", "y", "z", "version"}, useExtraQuery=false)
  public abstract String sketchTileUrl(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cz
 * JD-Core Version:    0.7.0.1
 */