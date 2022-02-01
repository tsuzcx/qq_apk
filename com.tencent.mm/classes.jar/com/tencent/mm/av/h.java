package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.o;
import java.util.Map;

public final class h
{
  public static final a FK(String paramString)
  {
    AppMethodBeat.i(150558);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150558);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    paramString = bx.M((String)localObject, "msg");
    if (paramString == null)
    {
      ae.e("MicroMsg.ImgInfoLogic", "parseImg failed");
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
  
  public static String FL(String paramString)
  {
    AppMethodBeat.i(150559);
    if (!o.fB(paramString))
    {
      AppMethodBeat.o(150559);
      return null;
    }
    long l = o.aZR(paramString);
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
    if (paramg.aIB())
    {
      g localg = q.aIX().pw(paramg.icz);
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
    int i = paramg.hPI;
    long l = paramg.dCd;
    if (paramg.aIB())
    {
      paramg = q.aIX().pw(paramg.icz);
      j = paramg.offset;
      i = paramg.hPI;
      l = paramg.dCd;
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
    if (paramg.aIB())
    {
      paramg = q.aIX().pw(paramg.icz);
      if (paramg == null)
      {
        AppMethodBeat.o(150556);
        return "";
      }
      paramg = paramg.ico;
      AppMethodBeat.o(150556);
      return paramg;
    }
    paramg = paramg.ico;
    AppMethodBeat.o(150556);
    return paramg;
  }
  
  public static String d(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(150557);
    String str = null;
    if (!bu.isNullOrNil(paramString1)) {
      str = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[] { paramString1, bu.nullAsNil(paramString2), bu.nullAsNil(paramString3), bu.nullAsNil(paramString4) });
    }
    AppMethodBeat.o(150557);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.h
 * JD-Core Version:    0.7.0.1
 */