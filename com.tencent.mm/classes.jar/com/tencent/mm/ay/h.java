package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.u;
import java.util.Map;

public final class h
{
  public static final a VS(String paramString)
  {
    AppMethodBeat.i(150558);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150558);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    paramString = XmlParser.parseXml((String)localObject, "msg", null);
    if (paramString == null)
    {
      Log.e("MicroMsg.ImgInfoLogic", "parseImg failed");
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
  
  public static String VT(String paramString)
  {
    AppMethodBeat.i(150559);
    if (!u.agG(paramString))
    {
      AppMethodBeat.o(150559);
      return null;
    }
    long l = u.bBQ(paramString);
    paramString = com.tencent.mm.b.g.getMessageDigest((paramString + "-" + l).getBytes());
    AppMethodBeat.o(150559);
    return paramString;
  }
  
  public static g a(g paramg)
  {
    AppMethodBeat.i(150554);
    if (paramg == null)
    {
      AppMethodBeat.o(150554);
      return null;
    }
    if (paramg.blK())
    {
      g localg = q.bmh().wl(paramg.lNR);
      if (localg == null)
      {
        AppMethodBeat.o(150554);
        return paramg;
      }
      AppMethodBeat.o(150554);
      return localg;
    }
    AppMethodBeat.o(150554);
    return paramg;
  }
  
  public static boolean b(g paramg)
  {
    AppMethodBeat.i(150555);
    if (paramg == null)
    {
      AppMethodBeat.o(150555);
      return false;
    }
    int j = paramg.offset;
    int i = paramg.lAW;
    long l = paramg.fNu;
    if (paramg.blK())
    {
      paramg = q.bmh().wl(paramg.lNR);
      j = paramg.offset;
      i = paramg.lAW;
      l = paramg.fNu;
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
  
  public static String c(g paramg)
  {
    AppMethodBeat.i(150556);
    if (paramg == null)
    {
      AppMethodBeat.o(150556);
      return "";
    }
    if (paramg.blK())
    {
      paramg = q.bmh().wl(paramg.lNR);
      if (paramg == null)
      {
        AppMethodBeat.o(150556);
        return "";
      }
      paramg = paramg.lNH;
      AppMethodBeat.o(150556);
      return paramg;
    }
    paramg = paramg.lNH;
    AppMethodBeat.o(150556);
    return paramg;
  }
  
  public static String d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(150557);
    String str = null;
    if (!Util.isNullOrNil(paramString1)) {
      str = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[] { paramString1, Util.nullAsNil(paramString2), Util.nullAsNil(paramString3), Util.nullAsNil(paramString4) });
    }
    AppMethodBeat.o(150557);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.h
 * JD-Core Version:    0.7.0.1
 */