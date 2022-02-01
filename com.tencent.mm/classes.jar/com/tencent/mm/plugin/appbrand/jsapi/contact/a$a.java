package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class a$a
{
  private String country;
  private String exW;
  private String koI;
  String koJ;
  private String state;
  
  public a$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(137485);
    this.country = bs.nullAsNil(paramString1);
    this.state = bs.nullAsNil(paramString2);
    this.exW = bs.nullAsNil(paramString3);
    this.koI = bs.nullAsNil(paramString4);
    this.koJ = bs.nullAsNil(paramString5);
    AppMethodBeat.o(137485);
  }
  
  public final String bgx()
  {
    AppMethodBeat.i(137486);
    if ((bs.aLj(this.country)) || (bs.aLj(this.state)) || (bs.aLj(this.exW)) || (bs.aLj(this.koI)) || (bs.aLj(this.koJ)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0) {
        ((StringBuilder)localObject).append(this.country);
      }
      if (this.state.length() > 0) {
        ((StringBuilder)localObject).append(this.state);
      }
      if (this.exW.length() > 0) {
        ((StringBuilder)localObject).append(this.exW);
      }
      if (this.koI.length() > 0) {
        ((StringBuilder)localObject).append(this.koI);
      }
      if (this.koJ.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.koJ);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137486);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.koI.length() > 0)
    {
      ((StringBuilder)localObject).append(this.koI);
      ((StringBuilder)localObject).append(" ");
    }
    if (this.exW.length() > 0) {
      ((StringBuilder)localObject).append(this.exW + " ");
    }
    if (this.state.length() > 0) {
      ((StringBuilder)localObject).append(this.state + " ");
    }
    if (this.country.length() > 0) {
      ((StringBuilder)localObject).append(this.country);
    }
    if (this.koJ.length() > 0)
    {
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.koJ);
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