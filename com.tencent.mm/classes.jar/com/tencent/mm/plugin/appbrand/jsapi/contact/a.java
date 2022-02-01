package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  String fuD;
  b lRC;
  String lRD;
  a.a lRE;
  a.a lRF;
  a.a lRG;
  String lRH;
  String lRI;
  String lRJ;
  String lRK;
  String lRL;
  String lRM;
  String lRN;
  String lRO;
  String nickName;
  String remark;
  String title;
  String url;
  
  public static final class b
  {
    String firstName;
    String lastName;
    String middleName;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(137487);
      this.firstName = Util.nullAsNil(paramString1);
      this.middleName = Util.nullAsNil(paramString2);
      this.lastName = Util.nullAsNil(paramString3);
      AppMethodBeat.o(137487);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a
 * JD-Core Version:    0.7.0.1
 */