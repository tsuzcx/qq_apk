package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class f
{
  public static e a(e parame)
  {
    AppMethodBeat.i(150554);
    if (parame == null)
    {
      AppMethodBeat.o(150554);
      return null;
    }
    if (parame.ayi())
    {
      e locale = o.ayF().od(parame.hgu);
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
    int i = parame.gTY;
    long l = parame.drA;
    if (parame.ayi())
    {
      parame = o.ayF().od(parame.hgu);
      j = parame.offset;
      i = parame.gTY;
      l = parame.drA;
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
    if (parame.ayi())
    {
      parame = o.ayF().od(parame.hgu);
      if (parame == null)
      {
        AppMethodBeat.o(150556);
        return "";
      }
      parame = parame.hgj;
      AppMethodBeat.o(150556);
      return parame;
    }
    parame = parame.hgj;
    AppMethodBeat.o(150556);
    return parame;
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(150557);
    String str = null;
    if (!bt.isNullOrNil(paramString1)) {
      str = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[] { paramString1, bt.nullAsNil(paramString2), bt.nullAsNil(paramString3), bt.nullAsNil(paramString4) });
    }
    AppMethodBeat.o(150557);
    return str;
  }
  
  public static final a ye(String paramString)
  {
    AppMethodBeat.i(150558);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150558);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    paramString = bw.K((String)localObject, "msg");
    if (paramString == null)
    {
      ad.e("MicroMsg.ImgInfoLogic", "parseImg failed");
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
  
  public static String yf(String paramString)
  {
    AppMethodBeat.i(150559);
    if (!i.eK(paramString))
    {
      AppMethodBeat.o(150559);
      return null;
    }
    long l = i.aMN(paramString);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + "-" + l).getBytes());
    AppMethodBeat.o(150559);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.f
 * JD-Core Version:    0.7.0.1
 */