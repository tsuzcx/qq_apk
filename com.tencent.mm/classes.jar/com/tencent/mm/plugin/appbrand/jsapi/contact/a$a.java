package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a$a
{
  private String city;
  private String country;
  private String rSh;
  String rSi;
  private String state;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(137485);
    this.country = Util.nullAsNil(paramString1);
    this.state = Util.nullAsNil(paramString2);
    this.city = Util.nullAsNil(paramString3);
    this.rSh = Util.nullAsNil(paramString4);
    this.rSi = Util.nullAsNil(paramString5);
    AppMethodBeat.o(137485);
  }
  
  public final String crV()
  {
    AppMethodBeat.i(137486);
    if ((Util.isChinese(this.country)) || (Util.isChinese(this.state)) || (Util.isChinese(this.city)) || (Util.isChinese(this.rSh)) || (Util.isChinese(this.rSi)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0) {
        ((StringBuilder)localObject).append(this.country);
      }
      if (this.state.length() > 0) {
        ((StringBuilder)localObject).append(this.state);
      }
      if (this.city.length() > 0) {
        ((StringBuilder)localObject).append(this.city);
      }
      if (this.rSh.length() > 0) {
        ((StringBuilder)localObject).append(this.rSh);
      }
      if (this.rSi.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.rSi);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137486);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.rSh.length() > 0)
    {
      ((StringBuilder)localObject).append(this.rSh);
      ((StringBuilder)localObject).append(" ");
    }
    if (this.city.length() > 0) {
      ((StringBuilder)localObject).append(this.city + " ");
    }
    if (this.state.length() > 0) {
      ((StringBuilder)localObject).append(this.state + " ");
    }
    if (this.country.length() > 0) {
      ((StringBuilder)localObject).append(this.country);
    }
    if (this.rSi.length() > 0)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.rSi);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(137486);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a.a
 * JD-Core Version:    0.7.0.1
 */