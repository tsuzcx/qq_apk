package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class b$a
{
  public static String ntd = "<msg>";
  public static String nte = "</msg>";
  public static String nxj = "]]>";
  
  public static String VX(String paramString)
  {
    AppMethodBeat.i(21834);
    u localu = ((a)g.ab(a.class)).a(0L, paramString);
    a locala = new a(paramString);
    if (!locala.cJS)
    {
      ad.e("MicroMsg.AppmsgConvert", "buffer error");
      AppMethodBeat.o(21834);
      return "";
    }
    b localb = new b();
    Object localObject1 = localu.hDb;
    Object localObject3 = new HashMap();
    localb.VY("msg");
    ((Map)localObject3).put("appid", (String)locala.nxk.get(".msg.appmsg.$appid"));
    ((Map)localObject3).put("sdkver", (String)locala.nxk.get(".msg.appmsg.$sdkver"));
    localb.r("appmsg", (Map)localObject3);
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
      localb.ew("title", str1);
      localb.ew("des", (String)locala.nxk.get(".msg.appmsg.des"));
      localb.ew("action", (String)locala.nxk.get(".msg.appmsg.action"));
      localb.cl("type", locala.getInt(".msg.appmsg.type"));
      localb.cl("showtype", locala.getInt(".msg.appmsg.showtype"));
      localb.ew("content", (String)locala.nxk.get(".msg.appmsg.content"));
      localb.ew("url", (String)localObject2);
      localb.ew("lowurl", (String)locala.nxk.get(".msg.appmsg.lowurl"));
      localb.VY("appattach");
      localb.cl("totallen", locala.getInt(".msg.appmsg.appattach.totallen"));
      localb.ew("attachid", (String)locala.nxk.get(".msg.appmsg.appattach.attachid"));
      localb.ew("fileext", (String)locala.nxk.get(".msg.appmsg.appattach.fileext"));
      localb.VZ("appattach");
      localb.VY("mmreader");
      ((Map)localObject3).put("type", localu.type);
      ((Map)localObject3).put("convMsgCount", paramString.size());
      localb.r("category", (Map)localObject3);
      localb.ew("name", localu.dHp);
      localb.VY("topnew");
      localb.ew("cover", (String)locala.nxk.get(".msg.appmsg.mmreader.category.topnew.cover"));
      localb.ew("width", (String)locala.nxk.get(".msg.appmsg.mmreader.category.topnew.width"));
      localb.ew("height", (String)locala.nxk.get(".msg.appmsg.mmreader.category.topnew.height"));
      localb.ew("digest", (String)localObject1);
      localb.VZ("topnew");
      i = 0;
      label560:
      if (i >= paramString.size()) {
        break label980;
      }
      localb.VY("item");
      if (paramString.get(i) != null)
      {
        localObject1 = ((v)paramString.get(i)).title;
        localObject2 = ((v)paramString.get(i)).url;
        str1 = ((v)paramString.get(i)).hDk;
        localObject3 = ((v)paramString.get(i)).hDl;
        String str2 = ((v)paramString.get(i)).time;
        String str3 = ((v)paramString.get(i)).hDm;
        String str4 = ((v)paramString.get(i)).hDn;
        String str5 = ((v)paramString.get(i)).hDo;
        localb.ew("title", (String)localObject1);
        localb.ew("url", (String)localObject2);
        localb.ew("shorturl", str1);
        localb.ew("longurl", (String)localObject3);
        localb.ew("pub_time", str2);
        localb.ew("cover", str3);
        localb.ew("tweetid", str4);
        localb.ew("digest", str5);
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
      localb.ew("fileid", (String)locala.nxk.get((String)localObject1 + ".fileid"));
      localb.VY("source");
      localb.VY("source");
      localb.ew("name", localu.dHp);
      localb.VZ("source");
      localb.VZ("source");
      localb.VZ("item");
      i += 1;
      break label560;
      str1 = ((v)paramString.get(0)).title;
      localObject2 = ((v)paramString.get(0)).url;
      paramString.get(0);
      localObject1 = ((v)paramString.get(0)).hDo;
      break;
    }
    label980:
    localb.VZ("category");
    localb.VY("publisher");
    localb.ew("convName", localu.dHo);
    localb.ew("nickname", localu.dHp);
    localb.VZ("publisher");
    localb.VZ("mmreader");
    localb.VZ("appmsg");
    localb.ew("fromusername", localu.dHo);
    localb.cl("scene", locala.getInt(".msg.scene"));
    localb.VY("appinfo");
    localb.ew("version", (String)locala.nxk.get(".msg.appinfo.appname"));
    localb.ew("appname", (String)locala.nxk.get(".msg.appinfo.version"));
    localb.VZ("appinfo");
    localb.ew("commenturl", localu.fkq);
    localb.VZ("msg");
    ad.d("MicroMsg.AppmsgConvert", "xml " + localb.nxl.toString());
    paramString = localb.nxl.toString();
    AppMethodBeat.o(21834);
    return paramString;
  }
  
  static final class a
  {
    boolean cJS;
    Map<String, String> nxk;
    
    public a(String paramString)
    {
      AppMethodBeat.i(21824);
      this.nxk = null;
      this.cJS = true;
      this.nxk = bj.aQM(paramString);
      if (this.nxk == null)
      {
        this.cJS = false;
        this.nxk = new HashMap();
      }
      AppMethodBeat.o(21824);
    }
    
    final int getInt(String paramString)
    {
      AppMethodBeat.i(21825);
      if (!this.nxk.containsKey(paramString))
      {
        AppMethodBeat.o(21825);
        return 0;
      }
      int i = bt.getInt((String)this.nxk.get(paramString), 0);
      AppMethodBeat.o(21825);
      return i;
    }
  }
  
  static final class b
  {
    StringBuffer nxl;
    
    b()
    {
      AppMethodBeat.i(21826);
      this.nxl = new StringBuffer();
      AppMethodBeat.o(21826);
    }
    
    private void setText(int paramInt)
    {
      AppMethodBeat.i(21830);
      this.nxl.append(paramInt);
      AppMethodBeat.o(21830);
    }
    
    private void setText(String paramString)
    {
      AppMethodBeat.i(21829);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(21829);
        return;
      }
      if (paramString.contains(b.a.nxj))
      {
        this.nxl.append("<![CDATA[" + bt.aRc(paramString) + "]]>");
        AppMethodBeat.o(21829);
        return;
      }
      this.nxl.append("<![CDATA[" + paramString + "]]>");
      AppMethodBeat.o(21829);
    }
    
    public final void VY(String paramString)
    {
      AppMethodBeat.i(21827);
      this.nxl.append("<" + paramString + ">");
      AppMethodBeat.o(21827);
    }
    
    public final void VZ(String paramString)
    {
      AppMethodBeat.i(21828);
      this.nxl.append("</" + paramString + ">");
      AppMethodBeat.o(21828);
    }
    
    public final void cl(String paramString, int paramInt)
    {
      AppMethodBeat.i(21832);
      VY(paramString);
      setText(paramInt);
      VZ(paramString);
      AppMethodBeat.o(21832);
    }
    
    public final void ew(String paramString1, String paramString2)
    {
      AppMethodBeat.i(21831);
      VY(paramString1);
      setText(paramString2);
      VZ(paramString1);
      AppMethodBeat.o(21831);
    }
    
    public final void r(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(21833);
      this.nxl.append("<".concat(String.valueOf(paramString)));
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = (String)paramMap.get(str1);
        this.nxl.append(" " + str1 + " =  \"" + str2 + "\" ");
      }
      this.nxl.append(">");
      paramMap.clear();
      AppMethodBeat.o(21833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.b.a
 * JD-Core Version:    0.7.0.1
 */