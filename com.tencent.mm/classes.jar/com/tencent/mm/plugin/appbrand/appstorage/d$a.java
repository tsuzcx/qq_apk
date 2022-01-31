package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bk;

public final class d$a
{
  private String cCB;
  private String country;
  private String fGP;
  public String fGQ;
  private String state;
  
  public d$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.country = bk.pm(paramString1);
    this.state = bk.pm(paramString2);
    this.cCB = bk.pm(paramString3);
    this.fGP = bk.pm(paramString4);
    this.fGQ = bk.pm(paramString5);
  }
  
  public final String acH()
  {
    if ((bk.Zz(this.country)) || (bk.Zz(this.state)) || (bk.Zz(this.cCB)) || (bk.Zz(this.fGP)) || (bk.Zz(this.fGQ)))
    {
      localStringBuilder = new StringBuilder();
      if (this.country.length() > 0) {
        localStringBuilder.append(this.country);
      }
      if (this.state.length() > 0) {
        localStringBuilder.append(this.state);
      }
      if (this.cCB.length() > 0) {
        localStringBuilder.append(this.cCB);
      }
      if (this.fGP.length() > 0) {
        localStringBuilder.append(this.fGP);
      }
      if (this.fGQ.length() > 0)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.fGQ);
      }
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.fGP.length() > 0)
    {
      localStringBuilder.append(this.fGP);
      localStringBuilder.append(" ");
    }
    if (this.cCB.length() > 0) {
      localStringBuilder.append(this.cCB + " ");
    }
    if (this.state.length() > 0) {
      localStringBuilder.append(this.state + " ");
    }
    if (this.country.length() > 0) {
      localStringBuilder.append(this.country);
    }
    if (this.fGQ.length() > 0)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.fGQ);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.d.a
 * JD-Core Version:    0.7.0.1
 */