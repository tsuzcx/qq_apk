package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a$a
{
  private String country;
  private String fuK;
  private String lRP;
  String lRQ;
  private String state;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(137485);
    this.country = Util.nullAsNil(paramString1);
    this.state = Util.nullAsNil(paramString2);
    this.fuK = Util.nullAsNil(paramString3);
    this.lRP = Util.nullAsNil(paramString4);
    this.lRQ = Util.nullAsNil(paramString5);
    AppMethodBeat.o(137485);
  }
  
  public final String bGg()
  {
    AppMethodBeat.i(137486);
    if ((Util.isChinese(this.country)) || (Util.isChinese(this.state)) || (Util.isChinese(this.fuK)) || (Util.isChinese(this.lRP)) || (Util.isChinese(this.lRQ)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0) {
        ((StringBuilder)localObject).append(this.country);
      }
      if (this.state.length() > 0) {
        ((StringBuilder)localObject).append(this.state);
      }
      if (this.fuK.length() > 0) {
        ((StringBuilder)localObject).append(this.fuK);
      }
      if (this.lRP.length() > 0) {
        ((StringBuilder)localObject).append(this.lRP);
      }
      if (this.lRQ.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.lRQ);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137486);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.lRP.length() > 0)
    {
      ((StringBuilder)localObject).append(this.lRP);
      ((StringBuilder)localObject).append(" ");
    }
    if (this.fuK.length() > 0) {
      ((StringBuilder)localObject).append(this.fuK + " ");
    }
    if (this.state.length() > 0) {
      ((StringBuilder)localObject).append(this.state + " ");
    }
    if (this.country.length() > 0) {
      ((StringBuilder)localObject).append(this.country);
    }
    if (this.lRQ.length() > 0)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.lRQ);
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