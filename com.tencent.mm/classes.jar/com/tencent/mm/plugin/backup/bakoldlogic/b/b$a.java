package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class b$a
{
  public static String nCE = "]]>";
  public static String nyy = "<msg>";
  public static String nyz = "</msg>";
  
  public static String WJ(String paramString)
  {
    AppMethodBeat.i(21834);
    u localu = ((a)g.ab(a.class)).a(0L, paramString);
    a locala = new a(paramString);
    if (!locala.cKB)
    {
      ae.e("MicroMsg.AppmsgConvert", "buffer error");
      AppMethodBeat.o(21834);
      return "";
    }
    b.a.b localb = new b.a.b();
    Object localObject1 = localu.hFT;
    Object localObject3 = new HashMap();
    localb.WK("msg");
    ((Map)localObject3).put("appid", (String)locala.nCF.get(".msg.appmsg.$appid"));
    ((Map)localObject3).put("sdkver", (String)locala.nCF.get(".msg.appmsg.$sdkver"));
    localb.s("appmsg", (Map)localObject3);
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
      localb.ez("title", str1);
      localb.ez("des", (String)locala.nCF.get(".msg.appmsg.des"));
      localb.ez("action", (String)locala.nCF.get(".msg.appmsg.action"));
      localb.cp("type", locala.getInt(".msg.appmsg.type"));
      localb.cp("showtype", locala.getInt(".msg.appmsg.showtype"));
      localb.ez("content", (String)locala.nCF.get(".msg.appmsg.content"));
      localb.ez("url", (String)localObject2);
      localb.ez("lowurl", (String)locala.nCF.get(".msg.appmsg.lowurl"));
      localb.WK("appattach");
      localb.cp("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
      localb.ez("attachid", (String)locala.nCF.get(".msg.appmsg.appattach.attachid"));
      localb.ez("fileext", (String)locala.nCF.get(".msg.appmsg.appattach.fileext"));
      localb.WL("appattach");
      localb.WK("mmreader");
      ((Map)localObject3).put("type", localu.type);
      ((Map)localObject3).put("convMsgCount", paramString.size());
      localb.s("category", (Map)localObject3);
      localb.ez("name", localu.dIu);
      localb.WK("topnew");
      localb.ez("cover", (String)locala.nCF.get(".msg.appmsg.mmreader.category.topnew.cover"));
      localb.ez("width", (String)locala.nCF.get(".msg.appmsg.mmreader.category.topnew.width"));
      localb.ez("height", (String)locala.nCF.get(".msg.appmsg.mmreader.category.topnew.height"));
      localb.ez("digest", (String)localObject1);
      localb.WL("topnew");
      i = 0;
      label560:
      if (i >= paramString.size()) {
        break label980;
      }
      localb.WK("item");
      if (paramString.get(i) != null)
      {
        localObject1 = ((v)paramString.get(i)).title;
        localObject2 = ((v)paramString.get(i)).url;
        str1 = ((v)paramString.get(i)).hGc;
        localObject3 = ((v)paramString.get(i)).hGd;
        String str2 = ((v)paramString.get(i)).time;
        String str3 = ((v)paramString.get(i)).hGe;
        String str4 = ((v)paramString.get(i)).hGf;
        String str5 = ((v)paramString.get(i)).hGg;
        localb.ez("title", (String)localObject1);
        localb.ez("url", (String)localObject2);
        localb.ez("shorturl", str1);
        localb.ez("longurl", (String)localObject3);
        localb.ez("pub_time", str2);
        localb.ez("cover", str3);
        localb.ez("tweetid", str4);
        localb.ez("digest", str5);
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
      localb.ez("fileid", (String)locala.nCF.get((String)localObject1 + ".fileid"));
      localb.WK("source");
      localb.WK("source");
      localb.ez("name", localu.dIu);
      localb.WL("source");
      localb.WL("source");
      localb.WL("item");
      i += 1;
      break label560;
      str1 = ((v)paramString.get(0)).title;
      localObject2 = ((v)paramString.get(0)).url;
      paramString.get(0);
      localObject1 = ((v)paramString.get(0)).hGg;
      break;
    }
    label980:
    localb.WL("category");
    localb.WK("publisher");
    localb.ez("convName", localu.dIt);
    localb.ez("nickname", localu.dIu);
    localb.WL("publisher");
    localb.WL("mmreader");
    localb.WL("appmsg");
    localb.ez("fromusername", localu.dIt);
    localb.cp("scene", locala.getInt(".msg.scene"));
    localb.WK("appinfo");
    localb.ez("version", (String)locala.nCF.get(".msg.appinfo.appname"));
    localb.ez("appname", (String)locala.nCF.get(".msg.appinfo.version"));
    localb.WL("appinfo");
    localb.ez("commenturl", localu.fmn);
    localb.WL("msg");
    ae.d("MicroMsg.AppmsgConvert", "xml " + localb.nCG.toString());
    paramString = localb.nCG.toString();
    AppMethodBeat.o(21834);
    return paramString;
  }
  
  static final class a
  {
    boolean cKB;
    Map<String, String> nCF;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21824);
      this.nCF = null;
      this.cKB = true;
      this.nCF = bk.aSj(paramString);
      if (this.nCF == null)
      {
        this.cKB = false;
        this.nCF = new HashMap();
      }
      AppMethodBeat.o(21824);
    }
    
    final int getInt(String paramString)
    {
      AppMethodBeat.i(21825);
      if (!this.nCF.containsKey(paramString))
      {
        AppMethodBeat.o(21825);
        return 0;
      }
      int i = bu.getInt((String)this.nCF.get(paramString), 0);
      AppMethodBeat.o(21825);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b.a
 * JD-Core Version:    0.7.0.1
 */