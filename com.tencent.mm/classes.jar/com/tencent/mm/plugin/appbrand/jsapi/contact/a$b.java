package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a$b
{
  String firstName;
  String lastName;
  String middleName;
  
  public a$b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126259);
    this.firstName = bo.nullAsNil(paramString1);
    this.middleName = bo.nullAsNil(paramString2);
    this.lastName = bo.nullAsNil(paramString3);
    AppMethodBeat.o(126259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a.b
 * JD-Core Version:    0.7.0.1
 */