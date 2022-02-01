package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class f
{
  public static final a Cj(String paramString)
  {
    AppMethodBeat.i(150558);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150558);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    paramString = bv.L((String)localObject, "msg");
    if (paramString == null)
    {
      ac.e("MicroMsg.ImgInfoLogic", "parseImg failed");
      AppMethodBeat.o(150558);
      return null;
    }
    localObject = new a();
    ((a)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((a)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((a)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((a)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    AppMethodBeat.o(150558);
    return localObject;
  }
  
  public static String Ck(String paramString)
  {
    AppMethodBeat.i(150559);
    if (!i.eA(paramString))
    {
      AppMethodBeat.o(150559);
      return null;
    }
    long l = i.aSp(paramString);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + "-" + l).getBytes());
    AppMethodBeat.o(150559);
    return paramString;
  }
  
  public static e a(e parame)
  {
    AppMethodBeat.i(150554);
    if (parame == null)
    {
      AppMethodBeat.o(150554);
      return null;
    }
    if (parame.aFa())
    {
      e locale = o.aFx().oR(parame.hGX);
      if (locale == null)
      {
        AppMethodBeat.o(150554);
        return parame;
      }
      AppMethodBeat.o(150554);
      return locale;
    }
    AppMethodBeat.o(150554);
    return parame;
  }
  
  public static boolean b(e parame)
  {
    AppMethodBeat.i(150555);
    if (parame == null)
    {
      AppMethodBeat.o(150555);
      return false;
    }
    int j = parame.offset;
    int i = parame.hux;
    long l = parame.dpl;
    if (parame.aFa())
    {
      parame = o.aFx().oR(parame.hGX);
      j = parame.offset;
      i = parame.hux;
      l = parame.dpl;
    }
    if (i == 0)
    {
      AppMethodBeat.o(150555);
      return true;
    }
    if (((j == i) && (i != 0)) || (l != 0L))
    {
      AppMethodBeat.o(150555);
      return true;
    }
    AppMethodBeat.o(150555);
    return false;
  }
  
  public static String c(e parame)
  {
    AppMethodBeat.i(150556);
    if (parame == null)
    {
      AppMethodBeat.o(150556);
      return "";
    }
    if (parame.aFa())
    {
      parame = o.aFx().oR(parame.hGX);
      if (parame == null)
      {
        AppMethodBeat.o(150556);
        return "";
      }
      parame = parame.hGM;
      AppMethodBeat.o(150556);
      return parame;
    }
    parame = parame.hGM;
    AppMethodBeat.o(150556);
    return parame;
  }
  
  public static String e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(150557);
    String str = null;
    if (!bs.isNullOrNil(paramString1)) {
      str = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[] { paramString1, bs.nullAsNil(paramString2), bs.nullAsNil(paramString3), bs.nullAsNil(paramString4) });
    }
    AppMethodBeat.o(150557);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.f
 * JD-Core Version:    0.7.0.1
 */