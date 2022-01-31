package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a$a
{
  private String city;
  private String country;
  private String hKf;
  String hKg;
  private String state;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(126257);
    this.country = bo.nullAsNil(paramString1);
    this.state = bo.nullAsNil(paramString2);
    this.city = bo.nullAsNil(paramString3);
    this.hKf = bo.nullAsNil(paramString4);
    this.hKg = bo.nullAsNil(paramString5);
    AppMethodBeat.o(126257);
  }
  
  public final String aCR()
  {
    AppMethodBeat.i(126258);
    if ((bo.apE(this.country)) || (bo.apE(this.state)) || (bo.apE(this.city)) || (bo.apE(this.hKf)) || (bo.apE(this.hKg)))
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
      if (this.hKf.length() > 0) {
        ((StringBuilder)localObject).append(this.hKf);
      }
      if (this.hKg.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.hKg);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(126258);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.hKf.length() > 0)
    {
      ((StringBuilder)localObject).append(this.hKf);
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
    if (this.hKg.length() > 0)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.hKg);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(126258);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a.a
 * JD-Core Version:    0.7.0.1
 */