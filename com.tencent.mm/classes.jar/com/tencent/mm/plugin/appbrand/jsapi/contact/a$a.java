package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class a$a
{
  private String country;
  private String evA;
  private String jOh;
  String jOi;
  private String state;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(137485);
    this.country = bt.nullAsNil(paramString1);
    this.state = bt.nullAsNil(paramString2);
    this.evA = bt.nullAsNil(paramString3);
    this.jOh = bt.nullAsNil(paramString4);
    this.jOi = bt.nullAsNil(paramString5);
    AppMethodBeat.o(137485);
  }
  
  public final String aZF()
  {
    AppMethodBeat.i(137486);
    if ((bt.aFS(this.country)) || (bt.aFS(this.state)) || (bt.aFS(this.evA)) || (bt.aFS(this.jOh)) || (bt.aFS(this.jOi)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0) {
        ((StringBuilder)localObject).append(this.country);
      }
      if (this.state.length() > 0) {
        ((StringBuilder)localObject).append(this.state);
      }
      if (this.evA.length() > 0) {
        ((StringBuilder)localObject).append(this.evA);
      }
      if (this.jOh.length() > 0) {
        ((StringBuilder)localObject).append(this.jOh);
      }
      if (this.jOi.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jOi);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137486);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.jOh.length() > 0)
    {
      ((StringBuilder)localObject).append(this.jOh);
      ((StringBuilder)localObject).append(" ");
    }
    if (this.evA.length() > 0) {
      ((StringBuilder)localObject).append(this.evA + " ");
    }
    if (this.state.length() > 0) {
      ((StringBuilder)localObject).append(this.state + " ");
    }
    if (this.country.length() > 0) {
      ((StringBuilder)localObject).append(this.country);
    }
    if (this.jOi.length() > 0)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.jOi);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(137486);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a.a
 * JD-Core Version:    0.7.0.1
 */