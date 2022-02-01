package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetMethod;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;

public abstract interface cy
  extends ch.a
{
  @NetRequest(constQuery="styleid=0", method=NetMethod.URL, path="satellite", queryKeys={"z", "x", "y", "version"}, useExtraQuery=false)
  public abstract String satelliteUrl(String paramString1, String paramString2, String paramString3, String paramString4);
  
  @NetRequest(constQuery="styleid=0", method=NetMethod.URL, path="satellite", queryKeys={"z", "x", "y", "version"})
  public abstract String satelliteUrl2(String paramString1, String paramString2, String paramString3, String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.cy
 * JD-Core Version:    0.7.0.1
 */