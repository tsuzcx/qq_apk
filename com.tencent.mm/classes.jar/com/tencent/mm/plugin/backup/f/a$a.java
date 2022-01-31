package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class a$a
{
  public static String jDr = "]]>";
  public static String jzf = "<msg>";
  public static String jzg = "</msg>";
  
  public static String Go(String paramString)
  {
    AppMethodBeat.i(17445);
    p localp = ((a)g.E(a.class)).b(0L, paramString);
    a.a.a locala = new a.a.a(paramString);
    if (!locala.bRg)
    {
      ab.e("MicroMsg.AppmsgConvert", "buffer error");
      AppMethodBeat.o(17445);
      return "";
    }
    a.a.b localb = new a.a.b();
    Object localObject1 = localp.fjy;
    Object localObject3 = new HashMap();
    localb.Gp("msg");
    ((Map)localObject3).put("appid", (String)locala.jDs.get(".msg.appmsg.$appid"));
    ((Map)localObject3).put("sdkver", (String)locala.jDs.get(".msg.appmsg.$sdkver"));
    localb.n("appmsg", (Map)localObject3);
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
      localb.da("title", str1);
      localb.da("des", (String)locala.jDs.get(".msg.appmsg.des"));
      localb.da("action", (String)locala.jDs.get(".msg.appmsg.action"));
      localb.bG("type", locala.getInt(".msg.appmsg.type"));
      localb.bG("showtype", locala.getInt(".msg.appmsg.showtype"));
      localb.da("content", (String)locala.jDs.get(".msg.appmsg.content"));
      localb.da("url", (String)localObject2);
      localb.da("lowurl", (String)locala.jDs.get(".msg.appmsg.lowurl"));
      localb.Gp("appattach");
      localb.bG("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
      localb.da("attachid", (String)locala.jDs.get(".msg.appmsg.appattach.attachid"));
      localb.da("fileext", (String)locala.jDs.get(".msg.appmsg.appattach.fileext"));
      localb.Gq("appattach");
      localb.Gp("mmreader");
      ((Map)localObject3).put("type", localp.type);
      ((Map)localObject3).put("convMsgCount", paramString.size());
      localb.n("category", (Map)localObject3);
      localb.da("name", localp.cGO);
      localb.Gp("topnew");
      localb.da("cover", (String)locala.jDs.get(".msg.appmsg.mmreader.category.topnew.cover"));
      localb.da("width", (String)locala.jDs.get(".msg.appmsg.mmreader.category.topnew.width"));
      localb.da("height", (String)locala.jDs.get(".msg.appmsg.mmreader.category.topnew.height"));
      localb.da("digest", (String)localObject1);
      localb.Gq("topnew");
      i = 0;
      label560:
      if (i >= paramString.size()) {
        break label980;
      }
      localb.Gp("item");
      if (paramString.get(i) != null)
      {
        localObject1 = ((q)paramString.get(i)).title;
        localObject2 = ((q)paramString.get(i)).url;
        str1 = ((q)paramString.get(i)).fjH;
        localObject3 = ((q)paramString.get(i)).fjI;
        String str2 = ((q)paramString.get(i)).time;
        String str3 = ((q)paramString.get(i)).fjJ;
        String str4 = ((q)paramString.get(i)).fjK;
        String str5 = ((q)paramString.get(i)).fjL;
        localb.da("title", (String)localObject1);
        localb.da("url", (String)localObject2);
        localb.da("shorturl", str1);
        localb.da("longurl", (String)localObject3);
        localb.da("pub_time", str2);
        localb.da("cover", str3);
        localb.da("tweetid", str4);
        localb.da("digest", str5);
        localObject2 = new StringBuilder(".msg.appmsg.mmreader.category.item");
        if (i != 0) {
          break label972;
        }
      }
    }
    label972:
    for (localObject1 = "";; localObject1 = String.valueOf(i))
    {
      localObject1 = (String)localObject1;
      localb.da("fileid", (String)locala.jDs.get((String)localObject1 + ".fileid"));
      localb.Gp("source");
      localb.Gp("source");
      localb.da("name", localp.cGO);
      localb.Gq("source");
      localb.Gq("source");
      localb.Gq("item");
      i += 1;
      break label560;
      str1 = ((q)paramString.get(0)).title;
      localObject2 = ((q)paramString.get(0)).url;
      paramString.get(0);
      localObject1 = ((q)paramString.get(0)).fjL;
      break;
    }
    label980:
    localb.Gq("category");
    localb.Gp("publisher");
    localb.da("convName", localp.cGN);
    localb.da("nickname", localp.cGO);
    localb.Gq("publisher");
    localb.Gq("mmreader");
    localb.Gq("appmsg");
    localb.da("fromusername", localp.cGN);
    localb.bG("scene", locala.getInt(".msg.scene"));
    localb.Gp("appinfo");
    localb.da("version", (String)locala.jDs.get(".msg.appinfo.appname"));
    localb.da("appname", (String)locala.jDs.get(".msg.appinfo.version"));
    localb.Gq("appinfo");
    localb.da("commenturl", localp.dGR);
    localb.Gq("msg");
    ab.d("MicroMsg.AppmsgConvert", "xml " + localb.jDt.toString());
    paramString = localb.jDt.toString();
    AppMethodBeat.o(17445);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.a.a
 * JD-Core Version:    0.7.0.1
 */