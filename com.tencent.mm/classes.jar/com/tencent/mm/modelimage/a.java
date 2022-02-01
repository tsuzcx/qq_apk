package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a
{
  public String appId;
  public String mediaTagName;
  public String messageAction;
  public String messageExt;
  
  public a() {}
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.appId = paramString1;
    this.mediaTagName = paramString2;
    this.messageExt = paramString3;
    this.messageAction = paramString4;
  }
  
  public static String NL(String paramString)
  {
    AppMethodBeat.i(238963);
    String str = "";
    if (!Util.isNullOrNil(paramString)) {
      str = "<msg>" + paramString + "</msg>";
    }
    AppMethodBeat.o(238963);
    return str;
  }
  
  public static a NM(String paramString)
  {
    AppMethodBeat.i(238970);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(238970);
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
      Log.e("MicroMsg.AppMsgAppInfo", "parseImg failed");
      AppMethodBeat.o(238970);
      return null;
    }
    localObject = new a();
    ((a)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((a)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((a)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((a)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    AppMethodBeat.o(238970);
    return localObject;
  }
  
  public static String a(a parama)
  {
    AppMethodBeat.i(238967);
    String str2 = "";
    String str1 = str2;
    if (parama != null)
    {
      str1 = str2;
      if (!Util.isNullOrNil(parama.appId)) {
        str1 = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[] { Util.nullAsNil(parama.appId), Util.nullAsNil(parama.mediaTagName), Util.nullAsNil(parama.messageExt), Util.nullAsNil(parama.messageAction) });
      }
    }
    AppMethodBeat.o(238967);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.a
 * JD-Core Version:    0.7.0.1
 */