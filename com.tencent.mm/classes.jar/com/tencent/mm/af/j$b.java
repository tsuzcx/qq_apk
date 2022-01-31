package com.tencent.mm.af;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class j$b
  extends f
{
  private static final com.tencent.mm.a.f<Integer, b> eka;
  public String action;
  public String appId;
  public String appName;
  public int bDc;
  public int cEW;
  public String cGN;
  public String cGO;
  public String cGQ;
  public String cGR;
  public String cGS;
  public String cGT;
  public String cGU;
  public String canvasPageXml;
  public String cmN;
  public String color;
  public String content;
  public String cpp;
  public String cxK;
  public String czp;
  public String dGR;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String ewj;
  public String extInfo;
  public int fgA;
  public int fgB;
  public String fgC;
  public String fgD;
  public int fgE;
  public int fgF;
  public int fgG;
  public String fgH;
  public String fgI;
  public String fgJ;
  public String fgK;
  public String fgL;
  public String fgM;
  public int fgN;
  public int fgO;
  public int fgP;
  public int fgQ;
  public int fgR;
  public String fgS;
  public int fgT;
  public String fgU;
  public String fgV;
  public int fgW;
  public int fgX;
  public String fgY;
  public String fgZ;
  public int fgh;
  public j.b.a fgt;
  public Map<String, String> fgu;
  public String fgv;
  public int fgw;
  public String fgx;
  public String fgy;
  public int fgz;
  public String fhA;
  public String fhB;
  public String fhC;
  public int fhD;
  public String fhE;
  public String fhF;
  public String fhG;
  public int fhH;
  public int fhI;
  public String fhJ;
  public String fhK;
  public int fhL;
  public int fhM;
  public int fhN;
  public String fhO;
  public String fhP;
  public String fhQ;
  public String fhR;
  public String fhS;
  public String fhT;
  public String fhU;
  public int fhV;
  public String fhW;
  public String fhX;
  public String fhY;
  public String fhZ;
  public int fha;
  public String fhb;
  public String fhc;
  public int fhd;
  public String fhe;
  public String fhf;
  public int fhg;
  public String fhh;
  public String fhi;
  public String fhj;
  public String fhk;
  public String fhl;
  public String fhm;
  public String fhn;
  public String fho;
  public String fhp;
  public String fhq;
  public String fhr;
  public String fhs;
  public String fht;
  public String fhu;
  public int fhv;
  public int fhw;
  public int fhx;
  public String fhy;
  public String fhz;
  public String fiA;
  public String fiB;
  public String fiC;
  public String fiD;
  public String fiE;
  public String fiF;
  public String fiG;
  public String fiH;
  public String fiI;
  public String fiJ;
  public String fiK;
  public int fiL;
  public String fiM;
  public String fiN;
  public String fiO;
  public int fiP;
  public String fiQ;
  public String fiR;
  public String fiS;
  public String fiT;
  public String fiU;
  public String fiV;
  public String fiW;
  public String fiX;
  public String fiY;
  public int fiZ;
  public String fia;
  public String fib;
  public String fic;
  public String fid;
  public String fie;
  public String fif;
  public String fig;
  public String fih;
  public int fii;
  public String fij;
  public String fik;
  public String fil;
  public String filemd5;
  public int fim;
  public boolean fin;
  public int fio;
  public String fip;
  public int fiq;
  public String fir;
  public String fis;
  public String fit;
  public List<String> fiu;
  public String fiv;
  public List<String> fiw;
  public String fix;
  public int fiy;
  public String fiz;
  public String fja;
  public int fjb;
  public String fjc;
  public String fjd;
  public int fje;
  public String fjf;
  public int fjg;
  public int fjh;
  public int fji;
  public String fjj;
  public int fjk;
  private final HashMap<Class<? extends f>, f> fjl;
  public Map<String, String> fjm;
  private String fjn;
  private String fjo;
  private String fjp;
  public String iconUrl;
  public String mediaTagName;
  public String messageAction;
  public String messageExt;
  public int pageType;
  public int sdkVer;
  public String secondUrl;
  public int showType;
  public String thumburl;
  public int tid;
  public String title;
  public int type;
  public String url;
  public String username;
  
  static
  {
    AppMethodBeat.i(77787);
    eka = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(77787);
  }
  
  public j$b()
  {
    AppMethodBeat.i(77771);
    this.fin = false;
    this.fio = 0;
    this.fiP = 0;
    this.fiQ = "";
    this.fiR = "";
    this.fiS = "";
    this.fiT = "";
    this.fiU = "";
    this.fiV = "";
    this.fje = j.a.fgr.ordinal();
    this.canvasPageXml = "";
    this.fjk = 0;
    this.fjl = new HashMap();
    AppMethodBeat.o(77771);
  }
  
  private b Yn()
  {
    AppMethodBeat.i(77783);
    b localb = new b();
    if (this == null)
    {
      AppMethodBeat.o(77783);
      return localb;
    }
    ab.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { bo.aqg(this.ewj), this.filemd5, localb.appId });
    localb.action = this.action;
    localb.appId = this.appId;
    localb.appName = this.appName;
    localb.bDc = this.bDc;
    localb.cmN = this.cmN;
    localb.fgw = this.fgw;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.fgz = this.fgz;
    localb.fgx = this.fgx;
    localb.czp = this.czp;
    localb.fgv = this.fgv;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.showType = this.showType;
    localb.fgh = this.fgh;
    localb.fgW = this.fgW;
    localb.url = this.url;
    localb.fgy = this.fgy;
    localb.cGN = this.cGN;
    localb.cGO = this.cGO;
    localb.dGR = this.dGR;
    localb.thumburl = this.thumburl;
    localb.fgK = this.fgK;
    localb.fgU = this.fgU;
    localb.fgV = this.fgV;
    localb.fgX = this.fgX;
    localb.fgY = this.fgY;
    localb.fha = this.fha;
    localb.fgZ = this.fgZ;
    localb.fhd = this.fhd;
    localb.fhe = this.fhe;
    localb.fhg = this.fhg;
    localb.fhf = this.fhf;
    localb.fhb = this.fhb;
    localb.fhc = this.fhc;
    localb.fhC = this.fhC;
    localb.cxK = this.cxK;
    localb.fhJ = this.fhJ;
    localb.fhK = this.fhK;
    localb.fhL = this.fhL;
    localb.fhM = this.fhL;
    localb.fhE = this.fhE;
    localb.fhH = this.fhH;
    localb.fhD = this.fhD;
    localb.fhF = this.fhF;
    localb.fhG = this.fhG;
    localb.fhV = this.fhV;
    localb.fhW = this.fhW;
    localb.fhX = this.fhX;
    localb.fgB = this.fgB;
    localb.cGQ = this.cGQ;
    localb.cGR = this.cGR;
    localb.cGS = this.cGS;
    localb.cGT = this.cGT;
    localb.fiN = this.fiN;
    localb.fiL = this.fiL;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.fiM = this.fiM;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.fiO = this.fiO;
    localb.fiP = this.fiP;
    localb.fiQ = this.fiQ;
    localb.fiR = this.fiR;
    localb.fiS = this.fiS;
    localb.fiT = this.fiT;
    localb.fiU = this.fiU;
    localb.fiV = this.fiV;
    localb.canvasPageXml = this.canvasPageXml;
    localb.cGU = this.cGU;
    localb.fgL = this.fgL;
    localb.ewj = this.ewj;
    localb.filemd5 = this.filemd5;
    localb.fgA = this.fgA;
    localb.fgt = this.fgt;
    localb.fiW = this.fiW;
    localb.fiX = this.fiX;
    localb.fiZ = this.fiZ;
    localb.fja = this.fja;
    localb.fjh = this.fjh;
    localb.fiY = this.fiY;
    localb.fji = this.fji;
    localb.fjj = this.fjj;
    localb.fjc = this.fjc;
    localb.fjd = this.fjd;
    localb.fje = this.fje;
    localb.fjf = this.fjf;
    localb.fjg = this.fjg;
    localb.fjo = this.fjo;
    localb.fjp = this.fjp;
    localb.fjn = this.fjn;
    localb.fjm = this.fjm;
    localb.fgC = this.fgC;
    localb.fgD = this.fgD;
    localb.fgE = this.fgE;
    localb.fgF = this.fgF;
    localb.fgG = this.fgG;
    localb.fgH = this.fgH;
    localb.fgI = this.fgI;
    localb.fgJ = this.fgJ;
    Iterator localIterator = this.fjl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).Yk();
      if (localf != null) {
        localb.a(localf);
      }
    }
    AppMethodBeat.o(77783);
    return localb;
  }
  
  public static b a(b paramb)
  {
    AppMethodBeat.i(77781);
    if (paramb == null)
    {
      paramb = new b();
      AppMethodBeat.o(77781);
      return paramb;
    }
    paramb = paramb.Yn();
    AppMethodBeat.o(77781);
    return paramb;
  }
  
  public static String a(b paramb, String paramString, d paramd)
  {
    AppMethodBeat.i(77779);
    ab.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { bo.aqg(paramb.ewj), paramb.filemd5 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msg>");
    if ((paramb.fgR != 0) && (paramb.fgQ != 0))
    {
      ab.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[] { Integer.valueOf(paramb.fgR), Integer.valueOf(paramb.fgQ) });
      localStringBuilder.append(a(paramb, paramString, paramd, paramb.fgR, paramb.fgQ));
    }
    for (;;)
    {
      localStringBuilder.append("</msg>");
      eka.f(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
      paramb = localStringBuilder.toString();
      AppMethodBeat.o(77779);
      return paramb;
      ab.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
      localStringBuilder.append(a(paramb, paramString, paramd, 0, 0));
    }
  }
  
  public static String a(b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77780);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<appmsg appid=\"" + bo.apT(paramb.appId) + "\" sdkver=\"" + paramb.sdkVer + "\">");
    paramb.b(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    f localf = j.c.kp(paramb.type);
    if (localf != null) {
      localf.b(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == paramb.showType) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.fgK).append("</ShakePageResult>");
    }
    ab.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(77780);
    return paramb;
  }
  
  public static final b ab(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77778);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(77778);
      return null;
    }
    int i = paramString1.indexOf('<');
    if (i > 0) {}
    for (Object localObject2 = paramString1.substring(i);; localObject2 = paramString1)
    {
      i = ((String)localObject2).hashCode();
      Object localObject1 = (b)eka.get(Integer.valueOf(i));
      if (localObject1 != null)
      {
        AppMethodBeat.o(77778);
        return localObject1;
      }
      long l1 = System.currentTimeMillis();
      if (!bo.isNullOrNil(paramString2)) {}
      for (localObject1 = be.apC(paramString2);; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = br.F((String)localObject2, "msg");
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            ab.e("MicroMsg.AppMessage", "parse msg failed");
            AppMethodBeat.o(77778);
            return null;
          }
          long l2 = System.currentTimeMillis();
          b localb = new b();
          localb.fjm = ((Map)localObject1);
          localb.fjn = paramString1;
          localb.fjo = ((String)localObject2);
          localb.fjp = paramString2;
          try
          {
            localb.a((Map)localObject1, localb);
            paramString1 = j.c.Yo().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (f)((com.tencent.mm.cm.c)paramString1.next()).get();
              ((f)localObject2).a((Map)localObject1, localb);
              localb.a((f)localObject2);
            }
            paramString1 = j.c.kp(localb.type);
          }
          catch (Exception paramString1)
          {
            ab.e("MicroMsg.AppMessage", "parse amessage xml failed");
            ab.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bo.l(paramString1) });
            AppMethodBeat.o(77778);
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, localb);
            localb.a(paramString1);
          }
          eka.f(Integer.valueOf(i), localb);
          ab.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(bo.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(77778);
          return localb;
        }
      }
    }
  }
  
  public static final b mX(String paramString)
  {
    AppMethodBeat.i(77774);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77774);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    i = "parseImg_".concat(String.valueOf(localObject)).hashCode();
    paramString = (b)eka.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(77774);
      return paramString;
    }
    paramString = br.F((String)localObject, "msg");
    if (paramString == null)
    {
      ab.e("MicroMsg.AppMessage", "parseImg failed");
      AppMethodBeat.o(77774);
      return null;
    }
    localObject = new b();
    ((b)localObject).type = 2;
    ((b)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((b)localObject).bDc = bo.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((b)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((b)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((b)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((b)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    eka.f(Integer.valueOf(i), localObject);
    AppMethodBeat.o(77774);
    return localObject;
  }
  
  public static final b mY(String paramString)
  {
    AppMethodBeat.i(77777);
    paramString = ab(paramString, null);
    AppMethodBeat.o(77777);
    return paramString;
  }
  
  public static String mZ(String paramString)
  {
    AppMethodBeat.i(77785);
    paramString = "<![CDATA[" + paramString + "]]>";
    AppMethodBeat.o(77785);
    return paramString;
  }
  
  public final <T extends f> T R(Class<T> paramClass)
  {
    AppMethodBeat.i(77772);
    paramClass = (f)this.fjl.get(paramClass);
    AppMethodBeat.o(77772);
    return paramClass;
  }
  
  public final g Ym()
  {
    AppMethodBeat.i(151540);
    g localg = new g();
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.ecF;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.fjl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)((Map.Entry)localIterator.next()).getValue();
      if (localf != null) {
        localf.a(localg, this);
      }
    }
    AppMethodBeat.o(151540);
    return localg;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(77773);
    if (paramf == null)
    {
      ab.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
      AppMethodBeat.o(77773);
      return;
    }
    paramf.fgm = this;
    this.fjl.put(paramf.getClass(), paramf);
    AppMethodBeat.o(77773);
  }
  
  public final void a(j paramj)
  {
    paramj.field_appId = this.appId;
    paramj.field_title = this.title;
    paramj.field_description = this.description;
    paramj.field_type = this.type;
    paramj.field_source = this.appName;
  }
  
  public final void a(Map<String, String> paramMap, b paramb)
  {
    AppMethodBeat.i(77782);
    for (;;)
    {
      try
      {
        this.fgu = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = bo.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = bo.apD((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = bo.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.fgv = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.fgC = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.fgD = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.fgE = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.fgF = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.fgG = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.fgH = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.fgI = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.fgJ = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.fgU = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.fgV = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.fgw = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.cmN = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!bo.isNullOrNil(this.fgC)) {
          this.cmN = this.fgC;
        }
        this.fgx = bo.apD((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.fgy = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.fgz = bo.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.cGN = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.cGO = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.dGR = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.bDc = bo.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.czp = ((String)paramMap.get(".msg.fromusername"));
        this.fgL = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.fgM = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.fgN = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.fgO = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.fgP = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.fgQ = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.fgR = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.ewj = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.fgT = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.fgS = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.fgA = bo.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.fgA == 0) && (this.fgw > 26214400))
        {
          this.fgA = 1;
          ab.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.fgw) });
        }
        this.fgX = bo.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.fgY = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.fha = bo.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.fgZ = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.fhf = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.fhg = bo.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.fhb = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.fhc = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.cGQ = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.cGR = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.cGS = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.cGT = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.fiL = p.cU((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = bo.apV((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.fiM = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = bo.bf((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = bo.apV((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.fiO = bo.bf((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.fiP = bo.apV((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.fiQ = bo.bf((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.fiR = bo.bf((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.fiS = bo.bf((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.fiT = bo.bf((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.fiU = bo.bf((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.fiV = bo.bf((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = bo.bf((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        this.fiX = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.fiW = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.fiY = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.fji = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.fiZ = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.fjh = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.fja = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.fjj = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.fjc = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.fjd = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.fje = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), j.a.fgr.ordinal());
        this.fjf = bo.bf((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.fjg = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.fjk = bo.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label3910;
          }
          this.showType = bo.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.cGU = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.fgh = bo.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.fgh == 5) && (bo.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.fgh = 0;
          }
          this.fgW = bo.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.fhh = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.fhi = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (bo.isNullOrNil(this.fhi)) {
            this.fhi = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.fhj = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.fhk = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.fhl = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.fhm = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.color = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.fhn = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.fho = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.fhq = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.fhp = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.fhs = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.fhr = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.fhv = bo.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.fhx = bo.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.fhw = bo.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.fht = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.fhu = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.fhB = ((String)localObject);
          this.fhz = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.fhA = ((String)localObject);
          this.fhy = ((String)localObject);
          this.fhC = bo.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.fhV = bo.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.fhW = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.fhX = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = br.F(paramb.fjo, "msgoperation");
          if ((this != null) && (paramMap != null))
          {
            this.fgt = new j.b.a();
            this.fgt.dHa = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.fgt.fjq = bo.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.fgt.fjr = bo.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.fgt.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.fgt.fjs = bo.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.fgt.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.fgt.fjt = bo.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
          }
          AppMethodBeat.o(77782);
          return;
        }
      }
      catch (Exception paramMap)
      {
        ab.e("MicroMsg.AppMessage", "parse amessage xml failed");
        ab.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bo.l(paramMap) });
        AppMethodBeat.o(77782);
        throw paramMap;
      }
      this.fhd = bo.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.fhe = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.fhD = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.fhE = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.fhF = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.fhG = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.fhH = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.fhI = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.cEW = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.cpp = bo.bf((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.fiN = bo.bf((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.fhZ = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.fie = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.fhY = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.fia = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.fib = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.fid = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.fic = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.fif = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.fig = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.fih = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.fii = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.fij = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.fik = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.fil = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.fim = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.fio = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.fip = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.fiq = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.fir = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.fis = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.fit = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.fiu = new ArrayList();
          this.fiu.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.fiv = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!bo.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.fiw = new ArrayList();
          this.fiw.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.fix = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.fiy = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.fiz = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.fiA = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.fiB = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.fiC = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.fiD = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.fiE = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.fiF = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.fiG = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.fiH = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.fiI = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.fiJ = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.fiK = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.cxK = paramb.fjn;
      this.fhJ = "";
      this.fhL = bo.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.fhK = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.fhM = bo.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.fin = true;
        continue;
        this.fhO = bo.bf((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.fhN = p.cU((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.fhP = bo.bf((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.fhQ = bo.bf((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.fhR = bo.bf((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.fhS = bo.bf((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.fhT = bo.bf((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.fhU = bo.bf((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        label3910:
        if (this.type == 2001)
        {
          this.showType = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.showType = bo.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.showType)
          {
          case 1: 
            if (bo.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = be.aT(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.fjn.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.fgK = paramb.fjn.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final void b(StringBuilder paramStringBuilder, b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77784);
    Iterator localIterator = j.c.Yo().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (f)((com.tencent.mm.cm.c)localIterator.next()).get();
      localObject2 = paramb.R(localObject1.getClass());
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      ((f)localObject1).a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    paramStringBuilder.append("<title>" + bo.apT(paramb.title) + "</title>");
    paramStringBuilder.append("<des>" + bo.apT(paramb.description) + "</des>");
    paramStringBuilder.append("<username>" + bo.apT(paramb.username) + "</username>");
    Object localObject2 = new StringBuilder("<action>");
    if (bo.isNullOrNil(paramb.action))
    {
      localObject1 = "view";
      paramStringBuilder.append((String)localObject1 + "</action>");
      paramStringBuilder.append("<type>" + paramb.type + "</type>");
      paramStringBuilder.append("<showtype>").append(paramb.showType).append("</showtype>");
      paramStringBuilder.append("<content>" + bo.apT(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + bo.apT(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + bo.apT(paramb.fgv) + "</lowurl>");
      paramStringBuilder.append("<dataurl>" + bo.apT(paramb.fgU) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + bo.apT(paramb.fgV) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.fgB).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(bo.apT(paramb.fiO)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.fiP).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(bo.apT(paramb.fiQ)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(bo.apT(paramb.fiR)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(bo.apT(paramb.fiS)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(bo.apT(paramb.fiT)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(bo.apT(paramb.fiU)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(bo.apT(paramb.fiV)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<appattach>");
      if ((paramd != null) && ((!bo.isNullOrNil(paramString)) || (paramInt1 != 0) || (paramInt2 != 0))) {
        break label3353;
      }
      paramStringBuilder.append("<totallen>" + paramb.fgw + "</totallen>");
      paramStringBuilder.append("<attachid>" + bo.apT(paramb.cmN) + "</attachid>");
      paramStringBuilder.append("<cdnattachurl>" + bo.apT(paramb.fgL) + "</cdnattachurl>");
      paramStringBuilder.append("<emoticonmd5>" + bo.apT(paramb.fgy) + "</emoticonmd5>");
      paramStringBuilder.append("<aeskey>" + bo.apT(paramb.ewj) + "</aeskey>");
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
        paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
      }
      paramStringBuilder.append("<fileext>" + bo.apT(paramb.fgx) + "</fileext>");
      paramStringBuilder.append("<islargefilemsg>" + paramb.fgA + "</islargefilemsg>");
      paramStringBuilder.append("</appattach>");
      paramStringBuilder.append("<extinfo>" + bo.apT(paramb.extInfo) + "</extinfo>");
      paramStringBuilder.append("<androidsource>" + paramb.fgz + "</androidsource>");
      if (!bo.isNullOrNil(paramb.cGN))
      {
        paramStringBuilder.append("<sourceusername>" + bo.apT(paramb.cGN) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + bo.apT(paramb.cGO) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + bo.apT(paramb.dGR) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + bo.apT(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + bo.apT(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + mZ(bo.apT(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + mZ(bo.apT(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.fha + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bo.apT(paramb.fgZ) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.fhg + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bo.apT(paramb.fhf) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.fiL + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.fiM + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + bo.apT(paramb.cGQ) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + bo.apT(paramb.cGR) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + bo.apT(paramb.cGS) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + bo.apT(paramb.cGT) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + bo.apT(paramb.fhC) + "</template_id>");
      ab.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + bo.apT(paramb.filemd5) + "</md5>");
      localIterator = j.c.Yo().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (f)((com.tencent.mm.cm.c)localIterator.next()).get();
        localObject2 = paramb.R(localObject1.getClass());
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((f)localObject1).b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
      }
      localObject1 = bo.apT(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.fgX + "\">");
      paramStringBuilder.append("<productinfo>" + bo.apT(paramb.fgY) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      continue;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.fhd + "\">");
      paramStringBuilder.append("<mallproductinfo>" + bo.apT(paramb.fhe) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      continue;
      paramStringBuilder.append("<tvinfo>" + bo.apT(paramb.fhb) + "</tvinfo>");
      continue;
      paramStringBuilder.append("<recorditem>" + bo.apT(paramb.fhc) + "</recorditem>");
      continue;
      paramStringBuilder.append("<carditem>" + paramb.fhJ + "</carditem>");
      continue;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.fhD + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.fhE + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.fhF + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.fhG + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.fhH + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.fiN + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      continue;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + bo.apT(paramb.fhZ) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + bo.apT(paramb.fie) + "</scenetext>");
      paramStringBuilder.append("<url>" + bo.apT(paramb.fhY) + "</url>");
      paramStringBuilder.append("<receivertitle>" + bo.apT(paramb.fia) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + bo.apT(paramb.fib) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + bo.apT(paramb.fid) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + bo.apT(paramb.fic) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + bo.apT(paramb.fif) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + bo.apT(paramb.fig) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + bo.apT(paramb.fih) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + bo.apT(new StringBuilder().append(paramb.showType).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + bo.apT(new StringBuilder().append(paramb.fii).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + bo.apT(paramb.fij) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + bo.apT(paramb.fik) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + bo.apT(paramb.fil) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + bo.apT(new StringBuilder().append(paramb.fim).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + bo.apT(new StringBuilder().append(paramb.fio).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
    }
    label3353:
    paramStringBuilder.append("<attachid>" + bo.apT(paramString) + "</attachid>");
    if ((paramd.field_fileLength > 0) && (!bo.isNullOrNil(paramd.field_fileId)))
    {
      paramStringBuilder.append("<cdnattachurl>" + bo.apT(paramd.field_fileId) + "</cdnattachurl>");
      if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
        break label3785;
      }
      paramStringBuilder.append("<totallen>" + paramd.field_fileLength + "</totallen>");
    }
    for (;;)
    {
      if (paramd.field_thumbimgLength > 0)
      {
        paramStringBuilder.append("<cdnthumburl>" + bo.apT(paramd.field_fileId) + "</cdnthumburl>");
        if (!bo.isNullOrNil(paramd.field_thumbfilemd5)) {
          paramStringBuilder.append("<cdnthumbmd5>" + paramd.field_thumbfilemd5 + "</cdnthumbmd5>");
        }
        paramStringBuilder.append("<cdnthumblength>" + paramd.field_thumbimgLength + "</cdnthumblength>");
        paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
        paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
        paramStringBuilder.append("<cdnthumbaeskey>" + paramd.field_aesKey + "</cdnthumbaeskey>");
      }
      paramStringBuilder.append("<aeskey>" + bo.apT(paramd.field_aesKey) + "</aeskey>");
      paramStringBuilder.append("<encryver>1</encryver>");
      break;
      label3785:
      ab.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Integer.valueOf(paramd.field_fileLength) });
    }
    AppMethodBeat.o(77784);
  }
  
  public final boolean cH(boolean paramBoolean)
  {
    AppMethodBeat.i(77776);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.fje >= j.a.fgp.ordinal()) && (this.fje < j.a.fgr.ordinal()))
      {
        AppMethodBeat.o(77776);
        return true;
      }
    }
    else if ((this.fje >= j.a.fgp.ordinal()) && (this.fje < j.a.fgr.ordinal()))
    {
      AppMethodBeat.o(77776);
      return true;
    }
    AppMethodBeat.o(77776);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.fgt != null) && (this.fgt.fjs != 0)) {
      return this.fgt.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.fgt != null) && (this.fgt.fjr != 0)) {
      return this.fgt.title;
    }
    return this.title;
  }
  
  public final String q(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(77775);
    String str = "";
    if (cH(true))
    {
      if (bo.isNullOrNil(this.fjf)) {
        break label178;
      }
      int i = paramContext.getResources().getIdentifier(this.fjf, "string", paramContext.getPackageName());
      ab.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label149;
      }
      str = paramContext.getResources().getString(i);
    }
    for (;;)
    {
      paramContext = str;
      if (paramBoolean)
      {
        paramContext = str;
        if (!str.isEmpty()) {
          paramContext = "[" + str + "]";
        }
      }
      ab.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { paramContext });
      AppMethodBeat.o(77775);
      return paramContext;
      label149:
      if (j.a.fgp.ordinal() == this.fje)
      {
        str = "";
      }
      else
      {
        str = this.cGO;
        continue;
        label178:
        if (j.a.fgp.ordinal() == this.fje) {
          str = "";
        } else {
          str = this.cGO;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.af.j.b
 * JD-Core Version:    0.7.0.1
 */