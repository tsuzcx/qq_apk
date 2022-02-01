package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  String hDf;
  String nickName;
  b oOh;
  String oOi;
  a oOj;
  a oOk;
  a oOl;
  String oOm;
  String oOn;
  String oOo;
  String oOp;
  String oOq;
  String oOr;
  String oOs;
  String oOt;
  String remark;
  String title;
  String url;
  
  public static final class a
  {
    private String city;
    private String country;
    private String oOu;
    String oOv;
    private String state;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(137485);
      this.country = Util.nullAsNil(paramString1);
      this.state = Util.nullAsNil(paramString2);
      this.city = Util.nullAsNil(paramString3);
      this.oOu = Util.nullAsNil(paramString4);
      this.oOv = Util.nullAsNil(paramString5);
      AppMethodBeat.o(137485);
    }
    
    public final String bRQ()
    {
      AppMethodBeat.i(137486);
      if ((Util.isChinese(this.country)) || (Util.isChinese(this.state)) || (Util.isChinese(this.city)) || (Util.isChinese(this.oOu)) || (Util.isChinese(this.oOv)))
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
        if (this.oOu.length() > 0) {
          ((StringBuilder)localObject).append(this.oOu);
        }
        if (this.oOv.length() > 0)
        {
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.oOv);
        }
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(137486);
        return localObject;
      }
      Object localObject = new StringBuilder();
      if (this.oOu.length() > 0)
      {
        ((StringBuilder)localObject).append(this.oOu);
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
      if (this.oOv.length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.oOv);
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(137486);
      return localObject;
    }
  }
  
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