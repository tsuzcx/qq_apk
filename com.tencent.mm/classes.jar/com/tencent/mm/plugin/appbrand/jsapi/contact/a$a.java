package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class a$a
{
  private String country;
  private String eRg;
  private String kMX;
  String kMY;
  private String state;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(137485);
    this.country = bu.nullAsNil(paramString1);
    this.state = bu.nullAsNil(paramString2);
    this.eRg = bu.nullAsNil(paramString3);
    this.kMX = bu.nullAsNil(paramString4);
    this.kMY = bu.nullAsNil(paramString5);
    AppMethodBeat.o(137485);
  }
  
  public final String bkK()
  {
    AppMethodBeat.i(137486);
    if ((bu.aSm(this.country)) || (bu.aSm(this.state)) || (bu.aSm(this.eRg)) || (bu.aSm(this.kMX)) || (bu.aSm(this.kMY)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0) {
        ((StringBuilder)localObject).append(this.country);
      }
      if (this.state.length() > 0) {
        ((StringBuilder)localObject).append(this.state);
      }
      if (this.eRg.length() > 0) {
        ((StringBuilder)localObject).append(this.eRg);
      }
      if (this.kMX.length() > 0) {
        ((StringBuilder)localObject).append(this.kMX);
      }
      if (this.kMY.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.kMY);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137486);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.kMX.length() > 0)
    {
      ((StringBuilder)localObject).append(this.kMX);
      ((StringBuilder)localObject).append(" ");
    }
    if (this.eRg.length() > 0) {
      ((StringBuilder)localObject).append(this.eRg + " ");
    }
    if (this.state.length() > 0) {
      ((StringBuilder)localObject).append(this.state + " ");
    }
    if (this.country.length() > 0) {
      ((StringBuilder)localObject).append(this.country);
    }
    if (this.kMY.length() > 0)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.kMY);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(137486);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a.a
 * JD-Core Version:    0.7.0.1
 */