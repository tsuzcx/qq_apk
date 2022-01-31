package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class f
{
  public static e a(e parame)
  {
    AppMethodBeat.i(78196);
    if (parame == null)
    {
      AppMethodBeat.o(78196);
      return null;
    }
    if (parame.ahh())
    {
      e locale = o.ahC().lv(parame.fDW);
      if (locale == null)
      {
        AppMethodBeat.o(78196);
        return parame;
      }
      AppMethodBeat.o(78196);
      return locale;
    }
    AppMethodBeat.o(78196);
    return parame;
  }
  
  public static boolean b(e parame)
  {
    AppMethodBeat.i(78197);
    if (parame == null)
    {
      AppMethodBeat.o(78197);
      return false;
    }
    int j = parame.offset;
    int i = parame.fsd;
    long l = parame.cFn;
    if (parame.ahh())
    {
      parame = o.ahC().lv(parame.fDW);
      j = parame.offset;
      i = parame.fsd;
      l = parame.cFn;
    }
    if (i == 0)
    {
      AppMethodBeat.o(78197);
      return true;
    }
    if (((j == i) && (i != 0)) || (l != 0L))
    {
      AppMethodBeat.o(78197);
      return true;
    }
    AppMethodBeat.o(78197);
    return false;
  }
  
  public static String c(e parame)
  {
    AppMethodBeat.i(78198);
    if (parame == null)
    {
      AppMethodBeat.o(78198);
      return "";
    }
    if (parame.ahh())
    {
      parame = o.ahC().lv(parame.fDW);
      if (parame == null)
      {
        AppMethodBeat.o(78198);
        return "";
      }
      parame = parame.fDM;
      AppMethodBeat.o(78198);
      return parame;
    }
    parame = parame.fDM;
    AppMethodBeat.o(78198);
    return parame;
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(78199);
    String str = null;
    if (!bo.isNullOrNil(paramString1)) {
      str = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[] { paramString1, bo.nullAsNil(paramString2), bo.nullAsNil(paramString3), bo.nullAsNil(paramString4) });
    }
    AppMethodBeat.o(78199);
    return str;
  }
  
  public static final a tb(String paramString)
  {
    AppMethodBeat.i(78200);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78200);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    paramString = br.F((String)localObject, "msg");
    if (paramString == null)
    {
      ab.e("MicroMsg.ImgInfoLogic", "parseImg failed");
      AppMethodBeat.o(78200);
      return null;
    }
    localObject = new a();
    ((a)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((a)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((a)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((a)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    AppMethodBeat.o(78200);
    return localObject;
  }
  
  public static String tc(String paramString)
  {
    AppMethodBeat.i(78201);
    if (!com.tencent.mm.vfs.e.cN(paramString))
    {
      AppMethodBeat.o(78201);
      return null;
    }
    long l = com.tencent.mm.vfs.e.avI(paramString);
    paramString = com.tencent.mm.a.g.w((paramString + "-" + l).getBytes());
    AppMethodBeat.o(78201);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.at.f
 * JD-Core Version:    0.7.0.1
 */