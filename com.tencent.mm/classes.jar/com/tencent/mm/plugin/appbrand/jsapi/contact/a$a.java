package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class a$a
{
  private String country;
  private String ePv;
  private String kJI;
  String kJJ;
  private String state;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(137485);
    this.country = bt.nullAsNil(paramString1);
    this.state = bt.nullAsNil(paramString2);
    this.ePv = bt.nullAsNil(paramString3);
    this.kJI = bt.nullAsNil(paramString4);
    this.kJJ = bt.nullAsNil(paramString5);
    AppMethodBeat.o(137485);
  }
  
  public final String bkb()
  {
    AppMethodBeat.i(137486);
    if ((bt.aQP(this.country)) || (bt.aQP(this.state)) || (bt.aQP(this.ePv)) || (bt.aQP(this.kJI)) || (bt.aQP(this.kJJ)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0) {
        ((StringBuilder)localObject).append(this.country);
      }
      if (this.state.length() > 0) {
        ((StringBuilder)localObject).append(this.state);
      }
      if (this.ePv.length() > 0) {
        ((StringBuilder)localObject).append(this.ePv);
      }
      if (this.kJI.length() > 0) {
        ((StringBuilder)localObject).append(this.kJI);
      }
      if (this.kJJ.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.kJJ);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137486);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.kJI.length() > 0)
    {
      ((StringBuilder)localObject).append(this.kJI);
      ((StringBuilder)localObject).append(" ");
    }
    if (this.ePv.length() > 0) {
      ((StringBuilder)localObject).append(this.ePv + " ");
    }
    if (this.state.length() > 0) {
      ((StringBuilder)localObject).append(this.state + " ");
    }
    if (this.country.length() > 0) {
      ((StringBuilder)localObject).append(this.country);
    }
    if (this.kJJ.length() > 0)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.kJJ);
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