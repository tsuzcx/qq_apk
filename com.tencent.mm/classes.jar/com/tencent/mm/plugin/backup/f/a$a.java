package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class a$a
{
  public static String hFI = "<msg>";
  public static String hFJ = "</msg>";
  public static String hJN = "]]>";
  
  public static String xv(String paramString)
  {
    l locall = ((a)g.r(a.class)).d(0L, paramString);
    a.a.a locala = new a.a.a(paramString);
    if (!locala.hJP)
    {
      y.e("MicroMsg.AppmsgConvert", "buffer error");
      return "";
    }
    a.a.b localb = new a.a.b();
    Object localObject1 = locall.dTx;
    Object localObject3 = new HashMap();
    localb.xw("msg");
    ((Map)localObject3).put("appid", (String)locala.hJO.get(".msg.appmsg.$appid"));
    ((Map)localObject3).put("sdkver", (String)locala.hJO.get(".msg.appmsg.$sdkver"));
    localb.k("appmsg", (Map)localObject3);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new LinkedList();
    }
    String str1;
    Object localObject2;
    int i;
    if (paramString.size() == 0)
    {
      str1 = "";
      localObject2 = "";
      localObject1 = "";
      localb.cj("title", str1);
      localb.cj("des", (String)locala.hJO.get(".msg.appmsg.des"));
      localb.cj("action", (String)locala.hJO.get(".msg.appmsg.action"));
      localb.bg("type", locala.getInt(".msg.appmsg.type"));
      localb.bg("showtype", locala.getInt(".msg.appmsg.showtype"));
      localb.cj("content", (String)locala.hJO.get(".msg.appmsg.content"));
      localb.cj("url", (String)localObject2);
      localb.cj("lowurl", (String)locala.hJO.get(".msg.appmsg.lowurl"));
      localb.xw("appattach");
      localb.bg("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
      localb.cj("attachid", (String)locala.hJO.get(".msg.appmsg.appattach.attachid"));
      localb.cj("fileext", (String)locala.hJO.get(".msg.appmsg.appattach.fileext"));
      localb.xx("appattach");
      localb.xw("mmreader");
      ((Map)localObject3).put("type", locall.type);
      ((Map)localObject3).put("convMsgCount", paramString.size());
      localb.k("category", (Map)localObject3);
      localb.cj("name", locall.bYH);
      localb.xw("topnew");
      localb.cj("cover", (String)locala.hJO.get(".msg.appmsg.mmreader.category.topnew.cover"));
      localb.cj("width", (String)locala.hJO.get(".msg.appmsg.mmreader.category.topnew.width"));
      localb.cj("height", (String)locala.hJO.get(".msg.appmsg.mmreader.category.topnew.height"));
      localb.cj("digest", (String)localObject1);
      localb.xx("topnew");
      i = 0;
      label548:
      if (i >= paramString.size()) {
        break label971;
      }
      localb.xw("item");
      if (paramString.get(i) != null)
      {
        localObject1 = ((m)paramString.get(i)).title;
        localObject2 = ((m)paramString.get(i)).url;
        str1 = ((m)paramString.get(i)).dTB;
        localObject3 = ((m)paramString.get(i)).dTC;
        String str2 = ((m)paramString.get(i)).time;
        String str3 = ((m)paramString.get(i)).dTD;
        String str4 = ((m)paramString.get(i)).dTE;
        String str5 = ((m)paramString.get(i)).dTF;
        localb.cj("title", (String)localObject1);
        localb.cj("url", (String)localObject2);
        localb.cj("shorturl", str1);
        localb.cj("longurl", (String)localObject3);
        localb.cj("pub_time", str2);
        localb.cj("cover", str3);
        localb.cj("tweetid", str4);
        localb.cj("digest", str5);
        localObject2 = new StringBuilder(".msg.appmsg.mmreader.category.item");
        if (i != 0) {
          break label963;
        }
      }
    }
    label963:
    for (localObject1 = "";; localObject1 = String.valueOf(i))
    {
      localObject1 = (String)localObject1;
      localb.cj("fileid", (String)locala.hJO.get((String)localObject1 + ".fileid"));
      localb.xw("source");
      localb.xw("source");
      localb.cj("name", locall.bYH);
      localb.xx("source");
      localb.xx("source");
      localb.xx("item");
      i += 1;
      break label548;
      str1 = ((m)paramString.get(0)).title;
      localObject2 = ((m)paramString.get(0)).url;
      localObject1 = ((m)paramString.get(0)).dTD;
      localObject1 = ((m)paramString.get(0)).dTF;
      break;
    }
    label971:
    localb.xx("category");
    localb.xw("publisher");
    localb.cj("convName", locall.bYG);
    localb.cj("nickname", locall.bYH);
    localb.xx("publisher");
    localb.xx("mmreader");
    localb.xx("appmsg");
    localb.cj("fromusername", locall.bYG);
    localb.bg("scene", locala.getInt(".msg.scene"));
    localb.xw("appinfo");
    localb.cj("version", (String)locala.hJO.get(".msg.appinfo.appname"));
    localb.cj("appname", (String)locala.hJO.get(".msg.appinfo.version"));
    localb.xx("appinfo");
    localb.cj("commenturl", locall.cQF);
    localb.xx("msg");
    y.d("MicroMsg.AppmsgConvert", "xml " + localb.hJQ.toString());
    return localb.hJQ.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a.a
 * JD-Core Version:    0.7.0.1
 */