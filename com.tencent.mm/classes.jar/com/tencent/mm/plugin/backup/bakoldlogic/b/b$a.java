package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class b$a
{
  public static String INVALID_TAG = "]]>";
  public static String rLm = "<msg>";
  public static String rLn = "</msg>";
  
  public static String aoj(String paramString)
  {
    AppMethodBeat.i(21834);
    u localu = ((a)h.ae(a.class)).b(0L, paramString);
    a locala = new a(paramString);
    if (!locala.cSY)
    {
      Log.e("MicroMsg.AppmsgConvert", "buffer error");
      AppMethodBeat.o(21834);
      return "";
    }
    b.a.b localb = new b.a.b();
    Object localObject1 = localu.lpz;
    Object localObject3 = new HashMap();
    localb.startTag("msg");
    ((Map)localObject3).put("appid", (String)locala.rPz.get(".msg.appmsg.$appid"));
    ((Map)localObject3).put("sdkver", (String)locala.rPz.get(".msg.appmsg.$sdkver"));
    localb.startTag("appmsg", (Map)localObject3);
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
      localb.addTag("title", str1);
      localb.addTag("des", (String)locala.rPz.get(".msg.appmsg.des"));
      localb.addTag("action", (String)locala.rPz.get(".msg.appmsg.action"));
      localb.addTag("type", locala.getInt(".msg.appmsg.type"));
      localb.addTag("showtype", locala.getInt(".msg.appmsg.showtype"));
      localb.addTag("content", (String)locala.rPz.get(".msg.appmsg.content"));
      localb.addTag("url", (String)localObject2);
      localb.addTag("lowurl", (String)locala.rPz.get(".msg.appmsg.lowurl"));
      localb.startTag("appattach");
      localb.addTag("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
      localb.addTag("attachid", (String)locala.rPz.get(".msg.appmsg.appattach.attachid"));
      localb.addTag("fileext", (String)locala.rPz.get(".msg.appmsg.appattach.fileext"));
      localb.endTag("appattach");
      localb.startTag("mmreader");
      ((Map)localObject3).put("type", localu.type);
      ((Map)localObject3).put("convMsgCount", paramString.size());
      localb.startTag("category", (Map)localObject3);
      localb.addTag("name", localu.fUe);
      localb.startTag("topnew");
      localb.addTag("cover", (String)locala.rPz.get(".msg.appmsg.mmreader.category.topnew.cover"));
      localb.addTag("width", (String)locala.rPz.get(".msg.appmsg.mmreader.category.topnew.width"));
      localb.addTag("height", (String)locala.rPz.get(".msg.appmsg.mmreader.category.topnew.height"));
      localb.addTag("digest", (String)localObject1);
      localb.endTag("topnew");
      i = 0;
      label560:
      if (i >= paramString.size()) {
        break label980;
      }
      localb.startTag("item");
      if (paramString.get(i) != null)
      {
        localObject1 = ((v)paramString.get(i)).title;
        localObject2 = ((v)paramString.get(i)).url;
        str1 = ((v)paramString.get(i)).lpI;
        localObject3 = ((v)paramString.get(i)).lpJ;
        String str2 = ((v)paramString.get(i)).time;
        String str3 = ((v)paramString.get(i)).lpK;
        String str4 = ((v)paramString.get(i)).lpL;
        String str5 = ((v)paramString.get(i)).lpM;
        localb.addTag("title", (String)localObject1);
        localb.addTag("url", (String)localObject2);
        localb.addTag("shorturl", str1);
        localb.addTag("longurl", (String)localObject3);
        localb.addTag("pub_time", str2);
        localb.addTag("cover", str3);
        localb.addTag("tweetid", str4);
        localb.addTag("digest", str5);
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
      localb.addTag("fileid", (String)locala.rPz.get((String)localObject1 + ".fileid"));
      localb.startTag("source");
      localb.startTag("source");
      localb.addTag("name", localu.fUe);
      localb.endTag("source");
      localb.endTag("source");
      localb.endTag("item");
      i += 1;
      break label560;
      str1 = ((v)paramString.get(0)).title;
      localObject2 = ((v)paramString.get(0)).url;
      paramString.get(0);
      localObject1 = ((v)paramString.get(0)).lpM;
      break;
    }
    label980:
    localb.endTag("category");
    localb.startTag("publisher");
    localb.addTag("convName", localu.fUd);
    localb.addTag("nickname", localu.fUe);
    localb.endTag("publisher");
    localb.endTag("mmreader");
    localb.endTag("appmsg");
    localb.addTag("fromusername", localu.fUd);
    localb.addTag("scene", locala.getInt(".msg.scene"));
    localb.startTag("appinfo");
    localb.addTag("version", (String)locala.rPz.get(".msg.appinfo.appname"));
    localb.addTag("appname", (String)locala.rPz.get(".msg.appinfo.version"));
    localb.endTag("appinfo");
    localb.addTag("commenturl", localu.ilh);
    localb.endTag("msg");
    Log.d("MicroMsg.AppmsgConvert", "xml " + localb.sb.toString());
    paramString = localb.sb.toString();
    AppMethodBeat.o(21834);
    return paramString;
  }
  
  static final class a
  {
    boolean cSY;
    Map<String, String> rPz;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21824);
      this.rPz = null;
      this.cSY = true;
      this.rPz = SemiXml.decode(paramString);
      if (this.rPz == null)
      {
        this.cSY = false;
        this.rPz = new HashMap();
      }
      AppMethodBeat.o(21824);
    }
    
    final int getInt(String paramString)
    {
      AppMethodBeat.i(21825);
      if (!this.rPz.containsKey(paramString))
      {
        AppMethodBeat.o(21825);
        return 0;
      }
      int i = Util.getInt((String)this.rPz.get(paramString), 0);
      AppMethodBeat.o(21825);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b.a
 * JD-Core Version:    0.7.0.1
 */