package com.tencent.mm.as;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class f
{
  public static e a(e parame)
  {
    e locale1;
    if (parame == null) {
      locale1 = null;
    }
    e locale2;
    do
    {
      do
      {
        return locale1;
        locale1 = parame;
      } while (!parame.Or());
      locale2 = o.OJ().iH(parame.enz);
      locale1 = parame;
    } while (locale2 == null);
    return locale2;
  }
  
  public static boolean b(e parame)
  {
    if (parame == null) {}
    int j;
    int i;
    long l;
    do
    {
      return false;
      j = parame.offset;
      i = parame.ebK;
      l = parame.bXr;
      if (parame.Or())
      {
        parame = o.OJ().iH(parame.enz);
        j = parame.offset;
        i = parame.ebK;
        l = parame.bXr;
      }
      if (i == 0) {
        return true;
      }
    } while (((j != i) || (i == 0)) && (l == 0L));
    return true;
  }
  
  public static String c(e parame)
  {
    if (parame == null) {
      return "";
    }
    if (parame.Or())
    {
      parame = o.OJ().iH(parame.enz);
      if (parame == null) {
        return "";
      }
      return parame.enq;
    }
    return parame.enq;
  }
  
  public static String c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = null;
    if (!bk.bl(paramString1)) {
      str = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[] { paramString1, bk.pm(paramString2), bk.pm(paramString3), bk.pm(paramString4) });
    }
    return str;
  }
  
  public static final a mb(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    paramString = bn.s((String)localObject, "msg");
    if (paramString == null)
    {
      y.e("MicroMsg.ImgInfoLogic", "parseImg failed");
      return null;
    }
    localObject = new a();
    ((a)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((a)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((a)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((a)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    return localObject;
  }
  
  public static String mc(String paramString)
  {
    if (!com.tencent.mm.vfs.e.bK(paramString)) {
      return null;
    }
    long l = com.tencent.mm.vfs.e.aeQ(paramString);
    return com.tencent.mm.a.g.o((paramString + "-" + l).getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.f
 * JD-Core Version:    0.7.0.1
 */