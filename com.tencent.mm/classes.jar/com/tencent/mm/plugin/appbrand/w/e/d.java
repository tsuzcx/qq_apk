package com.tencent.mm.plugin.appbrand.w.e;

import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends g
  implements b
{
  private String hmB = "*";
  
  public final String aqO()
  {
    return this.hmB;
  }
  
  public final void wQ(String paramString)
  {
    if (paramString == null)
    {
      y.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
      return;
    }
    this.hmB = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.e.d
 * JD-Core Version:    0.7.0.1
 */