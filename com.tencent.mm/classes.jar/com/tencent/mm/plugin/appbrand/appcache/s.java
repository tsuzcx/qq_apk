package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.bk;

public final class s
{
  private final String appId;
  private final String fCQ;
  private volatile String fCR;
  
  public s(String paramString)
  {
    this.appId = paramString;
    this.fCQ = null;
  }
  
  public s(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    if ((bk.bl(paramString2)) || ("__APP__".equals(paramString2)))
    {
      this.fCQ = paramString2;
      return;
    }
    this.fCQ = a.qR(paramString2);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder;
    if (bk.bl(this.fCR))
    {
      localStringBuilder = new StringBuilder().append(this.appId);
      if (!bk.bl(this.fCQ)) {
        break label55;
      }
    }
    label55:
    for (String str = "";; str = "$" + this.fCQ)
    {
      this.fCR = str;
      return this.fCR;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.s
 * JD-Core Version:    0.7.0.1
 */