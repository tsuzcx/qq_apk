package com.tencent.mm.aj;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.b.p;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class k$b
  extends f
{
  private static final com.tencent.mm.b.f<Integer, b> jla;
  public String action;
  public String aesKey;
  public String appId;
  public String appName;
  public int appVersion;
  public String canvasPageXml;
  public String content;
  public int contentattr;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String extInfo;
  public String fII;
  public String fLi;
  public int fRX;
  public String fUd;
  public String fUe;
  public String fUg;
  public String fUh;
  public String fUi;
  public String fUj;
  public String fUk;
  public String filemd5;
  public String fvr;
  public int fwp;
  public String fyc;
  public String iconUrl;
  public String ilh;
  public a llU;
  public Map<String, String> llV;
  public String llW;
  public int llX;
  public String llY;
  public String llZ;
  public int llp;
  public String lmA;
  public int lmB;
  public String lmC;
  public String lmD;
  public int lmE;
  public String lmF;
  public String lmG;
  public String lmH;
  public String lmI;
  public String lmJ;
  public String lmK;
  public String lmL;
  public String lmM;
  public String lmN;
  public String lmO;
  public String lmP;
  public String lmQ;
  public String lmR;
  public String lmS;
  public String lmT;
  public int lmU;
  public int lmV;
  public int lmW;
  public String lmX;
  public String lmY;
  public String lmZ;
  public int lma;
  public int lmb;
  public String lmc;
  public String lmd;
  public int lme;
  public int lmf;
  public int lmg;
  public String lmh;
  public String lmi;
  public String lmj;
  public String lmk;
  public String lml;
  public String lmm;
  public int lmn;
  public int lmo;
  public int lmp;
  public String lmq;
  public int lmr;
  public String lms;
  public String lmt;
  public int lmu;
  public int lmv;
  public String lmw;
  public String lmx;
  public int lmy;
  public String lmz;
  public String lnA;
  public String lnB;
  public String lnC;
  public String lnD;
  public String lnE;
  public String lnF;
  public String lnG;
  public String lnH;
  public int lnI;
  public String lnJ;
  public String lnK;
  public String lnL;
  public int lnM;
  public boolean lnN;
  public int lnO;
  public String lnP;
  public int lnQ;
  public String lnR;
  public String lnS;
  public String lnT;
  public List<String> lnU;
  public String lnV;
  public List<String> lnW;
  public String lnX;
  public int lnY;
  public String lnZ;
  public String lna;
  public String lnb;
  public int lnc;
  public String lnd;
  public String lne;
  public String lnf;
  public int lnh;
  public int lni;
  public String lnj;
  public String lnk;
  public int lnl;
  public int lnm;
  public int lnn;
  public String lno;
  public String lnp;
  public String lnq;
  public String lnr;
  public String lns;
  public String lnt;
  public String lnu;
  public int lnv;
  public String lnw;
  public String lnx;
  public String lny;
  public String lnz;
  public String loA;
  public String loB;
  public int loC;
  public String loD;
  public int loE;
  public String loF;
  public String loG;
  public int loH;
  public String loI;
  public int loJ;
  public String loK;
  public String loL;
  public int loM;
  public String loN;
  public String loO;
  public String loP;
  public Pair<String, String> loQ;
  public MsgQuoteItem loR;
  public String loS;
  public int loT;
  public int loU;
  public String loV;
  public int loW;
  public int loX;
  public int loY;
  private final HashMap<Class<? extends f>, f> loZ;
  public String loa;
  public String lob;
  public String lod;
  public String loe;
  public String lof;
  public String loh;
  public String loi;
  public String loj;
  public String lok;
  public String lol;
  public String lom;
  public int lon;
  public String loo;
  public String lop;
  public Map<String, String> loq;
  public String lor;
  public int los;
  public String lot;
  public String lou;
  public String lov;
  public String low;
  public String lox;
  public String loy;
  public String loz;
  public Map<String, String> lpa;
  public String lpb;
  private String lpc;
  private String lpd;
  public String mediaTagName;
  public String messageAction;
  public String messageExt;
  public int pageType;
  public int sdkVer;
  public String secondUrl;
  public int thumbHeight;
  public int thumbWidth;
  public String thumburl;
  public int tid;
  public String title;
  public int type;
  public String url;
  public String username;
  
  static
  {
    AppMethodBeat.i(150125);
    jla = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(150125);
  }
  
  public k$b()
  {
    AppMethodBeat.i(150108);
    this.lnd = "";
    this.lnN = false;
    this.lnO = 0;
    this.los = 0;
    this.lot = "";
    this.lou = "";
    this.lov = "";
    this.low = "";
    this.lox = "";
    this.loy = "";
    this.loH = k.a.llS.ordinal();
    this.loQ = new Pair("", "");
    this.canvasPageXml = "";
    this.loW = 0;
    this.loX = 0;
    this.loY = 0;
    this.loZ = new HashMap();
    AppMethodBeat.o(150108);
  }
  
  public static final b OP(String paramString)
  {
    AppMethodBeat.i(150111);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150111);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    i = "parseImg_".concat(String.valueOf(localObject)).hashCode();
    paramString = (b)jla.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(150111);
      return paramString;
    }
    paramString = XmlParser.parseXml((String)localObject, "msg", null);
    if (paramString == null)
    {
      Log.e("MicroMsg.AppMessage", "parseImg failed");
      AppMethodBeat.o(150111);
      return null;
    }
    localObject = new b();
    ((b)localObject).type = 2;
    ((b)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((b)localObject).appVersion = Util.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((b)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((b)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((b)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((b)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    jla.q(Integer.valueOf(i), localObject);
    AppMethodBeat.o(150111);
    return localObject;
  }
  
  public static final b OQ(String paramString)
  {
    AppMethodBeat.i(150114);
    paramString = aG(paramString, null);
    AppMethodBeat.o(150114);
    return paramString;
  }
  
  public static String OR(String paramString)
  {
    AppMethodBeat.i(150123);
    paramString = "<![CDATA[" + paramString + "]]>";
    AppMethodBeat.o(150123);
    return paramString;
  }
  
  public static b a(b paramb)
  {
    AppMethodBeat.i(150119);
    if (paramb == null)
    {
      paramb = new b();
      AppMethodBeat.o(150119);
      return paramb;
    }
    paramb = paramb.bbt();
    AppMethodBeat.o(150119);
    return paramb;
  }
  
  public static String a(b paramb, String paramString, d paramd)
  {
    AppMethodBeat.i(150116);
    Log.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { Util.secPrint(paramb.aesKey), paramb.filemd5 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msg>");
    if ((paramb.thumbWidth != 0) && (paramb.thumbHeight != 0))
    {
      Log.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[] { Integer.valueOf(paramb.thumbWidth), Integer.valueOf(paramb.thumbHeight) });
      localStringBuilder.append(a(paramb, paramString, paramd, paramb.thumbWidth, paramb.thumbHeight));
    }
    for (;;)
    {
      localStringBuilder.append("</msg>");
      jla.q(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
      paramb = localStringBuilder.toString();
      AppMethodBeat.o(150116);
      return paramb;
      Log.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
      localStringBuilder.append(a(paramb, paramString, paramd, 0, 0));
    }
  }
  
  public static String a(b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150117);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<appmsg appid=\"" + Util.escapeStringForXml(paramb.appId) + "\" sdkver=\"" + paramb.sdkVer + "\">");
    paramb.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    f localf = k.c.uC(paramb.type);
    if (localf != null) {
      localf.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == paramb.fwp) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.lmk).append("</ShakePageResult>");
    }
    Log.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(150117);
    return paramb;
  }
  
  public static final b aG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150115);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(150115);
      return null;
    }
    int i = paramString1.indexOf('<');
    if (i > 0) {}
    for (Object localObject2 = paramString1.substring(i);; localObject2 = paramString1)
    {
      i = ((String)localObject2).hashCode();
      Object localObject1 = (b)jla.get(Integer.valueOf(i));
      if (localObject1 != null)
      {
        AppMethodBeat.o(150115);
        return localObject1;
      }
      long l1 = System.currentTimeMillis();
      if (!Util.isNullOrNil(paramString2)) {}
      for (localObject1 = SemiXml.decode(paramString2);; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = XmlParser.parseXml((String)localObject2, "msg", null);
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            Log.e("MicroMsg.AppMessage", "parse msg failed");
            AppMethodBeat.o(150115);
            return null;
          }
          long l2 = System.currentTimeMillis();
          b localb = new b();
          localb.lpa = ((Map)localObject1);
          localb.lpb = paramString1;
          localb.lpc = ((String)localObject2);
          localb.lpd = paramString2;
          try
          {
            localb.a((Map)localObject1, localb);
            paramString1 = k.c.access$000().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (f)((com.tencent.mm.cw.c)paramString1.next()).get();
              if (localObject2 != null)
              {
                ((f)localObject2).a((Map)localObject1, localb);
                localb.a((f)localObject2);
              }
            }
            paramString1 = k.c.uC(localb.type);
          }
          catch (Exception paramString1)
          {
            Log.e("MicroMsg.AppMessage", "parse amessage xml failed");
            Log.e("MicroMsg.AppMessage", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
            AppMethodBeat.o(150115);
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, localb);
            localb.a(paramString1);
          }
          jla.q(Integer.valueOf(i), localb);
          Log.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(Util.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(150115);
          return localb;
        }
      }
    }
  }
  
  private b bbt()
  {
    AppMethodBeat.i(150121);
    b localb = new b();
    if (this == null)
    {
      AppMethodBeat.o(150121);
      return localb;
    }
    Log.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { Util.secPrint(this.aesKey), this.filemd5, localb.appId });
    localb.action = this.action;
    localb.appId = this.appId;
    localb.appName = this.appName;
    localb.appVersion = this.appVersion;
    localb.fvr = this.fvr;
    localb.llX = this.llX;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.lma = this.lma;
    localb.llY = this.llY;
    localb.fLi = this.fLi;
    localb.llW = this.llW;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.fwp = this.fwp;
    localb.llp = this.llp;
    localb.lmu = this.lmu;
    localb.url = this.url;
    localb.llZ = this.llZ;
    localb.fUd = this.fUd;
    localb.fUe = this.fUe;
    localb.ilh = this.ilh;
    localb.thumburl = this.thumburl;
    localb.lmk = this.lmk;
    localb.lms = this.lms;
    localb.lmt = this.lmt;
    localb.lmv = this.lmv;
    localb.lmw = this.lmw;
    localb.lmy = this.lmy;
    localb.lmx = this.lmx;
    localb.lmB = this.lmB;
    localb.lmC = this.lmC;
    localb.lmE = this.lmE;
    localb.lmD = this.lmD;
    localb.lmz = this.lmz;
    localb.lmA = this.lmA;
    localb.lnb = this.lnb;
    localb.fII = this.fII;
    localb.lnj = this.lnj;
    localb.lnk = this.lnk;
    localb.lnl = this.lnl;
    localb.lnm = this.lnl;
    localb.lnd = this.lnd;
    localb.lnh = this.lnh;
    localb.lnc = this.lnc;
    localb.lne = this.lne;
    localb.lnf = this.lnf;
    localb.lnv = this.lnv;
    localb.lnw = this.lnw;
    localb.lnx = this.lnx;
    localb.contentattr = this.contentattr;
    localb.fUg = this.fUg;
    localb.fUh = this.fUh;
    localb.fUi = this.fUi;
    localb.fUj = this.fUj;
    localb.lop = this.lop;
    localb.lon = this.lon;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.loo = this.loo;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.lor = this.lor;
    localb.los = this.los;
    localb.lot = this.lot;
    localb.lou = this.lou;
    localb.lov = this.lov;
    localb.low = this.low;
    localb.lox = this.lox;
    localb.loy = this.loy;
    localb.canvasPageXml = this.canvasPageXml;
    localb.fUk = this.fUk;
    localb.loq = this.loq;
    localb.lml = this.lml;
    localb.aesKey = this.aesKey;
    localb.filemd5 = this.filemd5;
    localb.lmb = this.lmb;
    localb.llU = this.llU;
    localb.loz = this.loz;
    localb.loA = this.loA;
    localb.loC = this.loC;
    localb.loD = this.loD;
    localb.loT = this.loT;
    localb.loB = this.loB;
    localb.loU = this.loU;
    localb.loV = this.loV;
    localb.loF = this.loF;
    localb.loG = this.loG;
    localb.loH = this.loH;
    localb.loI = this.loI;
    localb.loK = this.loK;
    localb.loL = this.loL;
    localb.loJ = this.loJ;
    localb.loM = this.loM;
    localb.lpc = this.lpc;
    localb.lpd = this.lpd;
    localb.lpb = this.lpb;
    localb.lpa = this.lpa;
    localb.lmc = this.lmc;
    localb.lmd = this.lmd;
    localb.lme = this.lme;
    localb.lmf = this.lmf;
    localb.lmg = this.lmg;
    localb.lmh = this.lmh;
    localb.lmi = this.lmi;
    localb.lmj = this.lmj;
    localb.loR = this.loR;
    localb.loQ = this.loQ;
    localb.loN = this.loN;
    localb.loO = this.loO;
    localb.loP = this.loP;
    localb.loX = this.loX;
    Iterator localIterator = this.loZ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).aPj();
      if (localf != null) {
        localb.a(localf);
      }
    }
    AppMethodBeat.o(150121);
    return localb;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(150110);
    if (paramf == null)
    {
      Log.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
      AppMethodBeat.o(150110);
      return;
    }
    paramf.llx = this;
    this.loZ.put(paramf.getClass(), paramf);
    AppMethodBeat.o(150110);
  }
  
  public final void a(k paramk)
  {
    paramk.field_appId = this.appId;
    paramk.field_title = this.title;
    paramk.field_description = this.description;
    paramk.field_type = this.type;
    paramk.field_source = this.appName;
  }
  
  public final void a(StringBuilder paramStringBuilder, b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150122);
    Iterator localIterator = k.c.access$000().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (f)((com.tencent.mm.cw.c)localIterator.next()).get();
      if (localObject1 != null)
      {
        localObject2 = paramb.ar(localObject1.getClass());
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((f)localObject1).b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
      }
    }
    paramStringBuilder.append("<title>" + Util.escapeStringForXml(paramb.title) + "</title>");
    paramStringBuilder.append("<des>" + Util.escapeStringForXml(paramb.description) + "</des>");
    paramStringBuilder.append("<username>" + Util.escapeStringForXml(paramb.username) + "</username>");
    Object localObject2 = new StringBuilder("<action>");
    if (Util.isNullOrNil(paramb.action))
    {
      localObject1 = "view";
      paramStringBuilder.append((String)localObject1 + "</action>");
      paramStringBuilder.append("<type>" + paramb.type + "</type>");
      paramStringBuilder.append("<showtype>").append(paramb.fwp).append("</showtype>");
      paramStringBuilder.append("<content>" + Util.escapeStringForXml(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + Util.escapeStringForXml(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + Util.escapeStringForXml(paramb.llW) + "</lowurl>");
      paramStringBuilder.append("<forwardflag>" + paramb.loY + "</forwardflag>");
      paramStringBuilder.append("<dataurl>" + Util.escapeStringForXml(paramb.lms) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + Util.escapeStringForXml(paramb.lmt) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.contentattr).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(Util.escapeStringForXml(paramb.lor)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.los).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(Util.escapeStringForXml(paramb.lot)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(Util.escapeStringForXml(paramb.lou)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(Util.escapeStringForXml(paramb.lov)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(Util.escapeStringForXml(paramb.low)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(paramb.lox)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(Util.escapeStringForXml(paramb.loy)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      default: 
        label832:
        paramStringBuilder.append("<appattach>");
        if ((paramd == null) || ((Util.isNullOrNil(paramString)) && (paramInt1 == 0) && (paramInt2 == 0)))
        {
          paramStringBuilder.append("<totallen>" + paramb.llX + "</totallen>");
          paramStringBuilder.append("<attachid>" + Util.escapeStringForXml(paramb.fvr) + "</attachid>");
          paramStringBuilder.append("<cdnattachurl>" + Util.escapeStringForXml(paramb.lml) + "</cdnattachurl>");
          paramStringBuilder.append("<emoticonmd5>" + Util.escapeStringForXml(paramb.llZ) + "</emoticonmd5>");
          paramStringBuilder.append("<aeskey>" + Util.escapeStringForXml(paramb.aesKey) + "</aeskey>");
          if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
            paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
          }
          paramStringBuilder.append("<fileext>" + Util.escapeStringForXml(paramb.llY) + "</fileext>");
          paramStringBuilder.append("<islargefilemsg>" + paramb.lmb + "</islargefilemsg>");
          localObject1 = (b)paramb.ar(b.class);
          if ((localObject1 != null) && (paramb.type == 6) && (((b)localObject1).lqB != 0L) && (!Util.isNullOrNil(((b)localObject1).lqC)))
          {
            paramStringBuilder.append("<overwrite_newmsgid>" + ((b)localObject1).lqB + "</overwrite_newmsgid>");
            paramStringBuilder.append("<fileuploadtoken>" + OR(((b)localObject1).lqC) + "</fileuploadtoken>");
          }
          paramStringBuilder.append("</appattach>");
          if (paramb.type != 53) {
            break label4288;
          }
          paramStringBuilder.append("<extinfo>").append((String)paramb.loQ.second).append("</extinfo>");
        }
        break;
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<androidsource>" + paramb.lma + "</androidsource>");
      if (!Util.isNullOrNil(paramb.fUd))
      {
        paramStringBuilder.append("<sourceusername>" + Util.escapeStringForXml(paramb.fUd) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + Util.escapeStringForXml(paramb.fUe) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + Util.escapeStringForXml(paramb.ilh) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + Util.escapeStringForXml(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + Util.escapeStringForXml(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + OR(Util.escapeStringForXml(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + OR(Util.escapeStringForXml(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.lmy + "</packageflag>");
      paramStringBuilder.append("<packageid>" + Util.escapeStringForXml(paramb.lmx) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.lmE + "</packageflag>");
      paramStringBuilder.append("<packageid>" + Util.escapeStringForXml(paramb.lmD) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.lon + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.loo + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + Util.escapeStringForXml(paramb.fUg) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + Util.escapeStringForXml(paramb.fUh) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + Util.escapeStringForXml(paramb.fUi) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + Util.escapeStringForXml(paramb.fUj) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + Util.escapeStringForXml(paramb.lnb) + "</template_id>");
      Log.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + Util.escapeStringForXml(paramb.filemd5) + "</md5>");
      localIterator = k.c.access$000().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (f)((com.tencent.mm.cw.c)localIterator.next()).get();
        if (localObject1 != null)
        {
          localObject2 = paramb.ar(localObject1.getClass());
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((f)localObject1).a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
        }
      }
      localObject1 = Util.escapeStringForXml(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.lmv + "\">");
      paramStringBuilder.append("<productinfo>" + Util.escapeStringForXml(paramb.lmw) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      break label832;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.lmB + "\">");
      paramStringBuilder.append("<mallproductinfo>" + Util.escapeStringForXml(paramb.lmC) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      break label832;
      paramStringBuilder.append("<tvinfo>" + Util.escapeStringForXml(paramb.lmz) + "</tvinfo>");
      break label832;
      paramStringBuilder.append("<recorditem>" + Util.escapeStringForXml(paramb.lmA) + "</recorditem>");
      break label832;
      paramStringBuilder.append("<carditem>" + paramb.lnj + "</carditem>");
      break label832;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.lnc + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.lnd + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.lne + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.lnf + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.lnh + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.lop + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      break label832;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + Util.escapeStringForXml(paramb.lnz) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + Util.escapeStringForXml(paramb.lnE) + "</scenetext>");
      paramStringBuilder.append("<url>" + Util.escapeStringForXml(paramb.lny) + "</url>");
      paramStringBuilder.append("<receivertitle>" + Util.escapeStringForXml(paramb.lnA) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + Util.escapeStringForXml(paramb.lnB) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + Util.escapeStringForXml(paramb.lnD) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + Util.escapeStringForXml(paramb.lnC) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + Util.escapeStringForXml(paramb.lnF) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + Util.escapeStringForXml(paramb.lnG) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + Util.escapeStringForXml(paramb.lnH) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + Util.escapeStringForXml(new StringBuilder().append(paramb.fwp).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + Util.escapeStringForXml(new StringBuilder().append(paramb.lnI).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + Util.escapeStringForXml(paramb.lnJ) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + Util.escapeStringForXml(paramb.lnK) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + Util.escapeStringForXml(paramb.lnL) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + Util.escapeStringForXml(new StringBuilder().append(paramb.lnM).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + Util.escapeStringForXml(new StringBuilder().append(paramb.lnO).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
      break label832;
      paramStringBuilder.append("<refermsg>");
      if (paramb.loR != null)
      {
        paramStringBuilder.append("<type>").append(paramb.loR.type).append("</type>");
        paramStringBuilder.append("<svrid>").append(paramb.loR.FkS).append("</svrid>");
        paramStringBuilder.append("<fromusr>").append(paramb.loR.FkT).append("</fromusr>");
        paramStringBuilder.append("<chatusr>").append(paramb.loR.FkU).append("</chatusr>");
        paramStringBuilder.append("<displayname>").append(Util.escapeStringForXml(paramb.loR.FkV)).append("</displayname>");
        paramStringBuilder.append("<msgsource>").append(Util.escapeStringForXml(paramb.loR.FkW)).append("</msgsource>");
        paramStringBuilder.append("<content>").append(Util.escapeStringForXml(paramb.loR.content)).append("</content>");
      }
      paramStringBuilder.append("</refermsg>");
      break label832;
      paramStringBuilder.append("<liteapp>");
      paramStringBuilder.append("<id>").append(paramb.loN).append("</id>");
      paramStringBuilder.append("<path>").append(Util.escapeStringForXml(paramb.loO)).append("</path>");
      paramStringBuilder.append("<query>").append(Util.escapeStringForXml(paramb.loP)).append("</query>");
      paramStringBuilder.append("</liteapp>");
      break label832;
      paramStringBuilder.append("<attachid>" + Util.escapeStringForXml(paramString) + "</attachid>");
      if ((paramd.field_fileLength > 0L) && (!Util.isNullOrNil(paramd.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + Util.escapeStringForXml(paramd.field_fileId) + "</cdnattachurl>");
        if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
          break label4251;
        }
        paramStringBuilder.append("<totallen>" + paramd.field_fileLength + "</totallen>");
      }
      for (;;)
      {
        if (paramd.field_thumbimgLength > 0)
        {
          paramStringBuilder.append("<cdnthumburl>" + Util.escapeStringForXml(paramd.field_fileId) + "</cdnthumburl>");
          if (!Util.isNullOrNil(paramd.field_thumbfilemd5)) {
            paramStringBuilder.append("<cdnthumbmd5>" + paramd.field_thumbfilemd5 + "</cdnthumbmd5>");
          }
          paramStringBuilder.append("<cdnthumblength>" + paramd.field_thumbimgLength + "</cdnthumblength>");
          paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
          paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
          paramStringBuilder.append("<cdnthumbaeskey>" + paramd.field_aesKey + "</cdnthumbaeskey>");
        }
        paramStringBuilder.append("<aeskey>" + Util.escapeStringForXml(paramd.field_aesKey) + "</aeskey>");
        paramStringBuilder.append("<encryver>1</encryver>");
        break;
        label4251:
        Log.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Long.valueOf(paramd.field_fileLength) });
      }
      label4288:
      paramStringBuilder.append("<extinfo>" + Util.escapeStringForXml(paramb.extInfo) + "</extinfo>");
    }
    AppMethodBeat.o(150122);
  }
  
  public final void a(Map<String, String> paramMap, b paramb)
  {
    AppMethodBeat.i(150120);
    for (;;)
    {
      try
      {
        this.llV = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = Util.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = Util.escapeDirTraversal((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = Util.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.llW = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.loY = Util.getInt((String)paramMap.get(".msg.appmsg.forwardflag"), 0);
        this.lmc = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.lmd = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.lme = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.lmf = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.lmg = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.lmh = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.lmi = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.lmj = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.lms = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.lmt = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.llX = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.fvr = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!Util.isNullOrNil(this.lmc)) {
          this.fvr = this.lmc;
        }
        this.llY = Util.escapeDirTraversal((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.llZ = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.loQ = new Pair("", paramMap.get(".msg.appmsg.extinfo.solitaire_info"));
        this.loS = Util.nullAs((String)paramMap.get(".msg.appmsg.laninfo"), "");
        this.lma = Util.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.fUd = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.fUe = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.ilh = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.appVersion = Util.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.fLi = ((String)paramMap.get(".msg.fromusername"));
        this.lml = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.lmm = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.lmn = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.lmo = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.lmp = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.thumbHeight = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.thumbWidth = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.aesKey = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.lmr = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.lmq = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.lmb = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.lmb == 0) && (this.llX > 26214400))
        {
          this.lmb = 1;
          Log.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.llX) });
        }
        this.lmv = Util.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.lmw = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.lmy = Util.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.lmx = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.lmD = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.lmE = Util.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.lmz = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.lmA = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.fUg = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.fUh = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.fUi = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.fUj = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.lon = p.fT((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = Util.safeParseInt((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.loo = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = Util.nullAs((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = Util.safeParseInt((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.lor = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.los = Util.safeParseInt((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.lot = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.lou = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.lov = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.low = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.lox = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.loy = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = Util.nullAs((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        if (paramMap.containsKey(".msg.appmsg.gamelife"))
        {
          this.loq = new HashMap(4);
          this.loq.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording")));
          this.loq.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1")));
          this.loq.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2")));
          this.loq.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3")));
        }
        this.loA = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.loz = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.loB = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.loU = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.loC = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.loT = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.loD = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.loV = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.loF = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.loG = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.loH = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), k.a.llS.ordinal());
        this.loI = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.loK = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.sourcename"), "");
        this.loL = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.sourceiconurl"), "");
        this.loJ = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.loM = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.secflagforsinglepagemode"), 0);
        this.loW = Util.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label4541;
          }
          this.fwp = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.fUk = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.llp = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.llp == 5) && (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.llp = 0;
          }
          this.lmu = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.lmF = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.lmG = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (Util.isNullOrNil(this.lmG)) {
            this.lmG = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.lmH = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.lmI = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.lmJ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.lmK = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.lmL = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.lmM = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.lmN = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.lmP = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.lmO = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.lmR = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.lmQ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.lmU = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.lmW = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.lmV = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.lmS = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.lmT = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.lna = ((String)localObject);
          this.lmY = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.lmZ = ((String)localObject);
          this.lmX = ((String)localObject);
          this.lnb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.lnv = Util.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.lnw = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.lnx = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = XmlParser.parseXml(paramb.lpc, "msgoperation", null);
          if ((this != null) && (paramMap != null))
          {
            this.llU = new a();
            this.llU.ilq = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.llU.lpe = Util.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.llU.lpf = Util.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.llU.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.llU.lpg = Util.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.llU.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.llU.lph = Util.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
          }
          AppMethodBeat.o(150120);
          return;
        }
      }
      catch (Exception paramMap)
      {
        Log.e("MicroMsg.AppMessage", "parse amessage xml failed");
        Log.e("MicroMsg.AppMessage", "exception:%s", new Object[] { Util.stackTraceToString(paramMap) });
        AppMethodBeat.o(150120);
        throw paramMap;
      }
      this.lmB = Util.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.lmC = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.lnc = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.lnd = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.lne = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.lnf = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.lnh = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.lni = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.fRX = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.fyc = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.lop = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.lnz = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.lnE = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.lny = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.lnA = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.lnB = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.lnD = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.lnC = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.lnF = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.lnG = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.lnH = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.lnI = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.lnJ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.lnK = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.lnL = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.lnM = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.lnO = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.lnh = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.lnP = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.lnQ = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.lnR = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.lnS = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.lnT = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.lnU = new ArrayList();
          this.lnU.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.lnV = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.lnW = new ArrayList();
          this.lnW.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.lnX = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.lnY = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.lnZ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.loa = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.lob = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.lod = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.loe = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.lof = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.loh = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.loi = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.loj = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.lok = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.lol = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.lom = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.fII = paramb.lpb;
      this.lnj = "";
      this.lnl = Util.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.lnk = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.lnm = Util.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.lnN = true;
        continue;
        this.lno = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.lnn = p.fT((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.lnp = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.lnq = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.lnr = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.lns = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.lnt = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.lnu = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        this.loR = new MsgQuoteItem();
        this.loR.type = Util.getInt((String)paramMap.get(".msg.appmsg.refermsg.type"), 0);
        this.loR.FkS = Util.getLong((String)paramMap.get(".msg.appmsg.refermsg.svrid"), 0L);
        this.loR.FkT = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.fromusr"), "");
        this.loR.FkU = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.loR.FkU = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.loR.FkV = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.displayname"), "");
        this.loR.content = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.content"), "");
        this.loR.FkW = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.msgsource"), "");
        continue;
        this.loN = ((String)paramMap.get(".msg.appmsg.liteapp.id"));
        this.loO = ((String)paramMap.get(".msg.appmsg.liteapp.path"));
        this.loP = ((String)paramMap.get(".msg.appmsg.liteapp.query"));
        continue;
        label4541:
        if (this.type == 2001)
        {
          this.fwp = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.fwp = Util.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.fwp)
          {
          case 1: 
            if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = SemiXml.encode(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.lpb.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.lmk = paramb.lpb.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final <T extends f> T ar(Class<T> paramClass)
  {
    AppMethodBeat.i(150109);
    paramClass = (f)this.loZ.get(paramClass);
    AppMethodBeat.o(150109);
    return paramClass;
  }
  
  public final Map<String, String> bbr()
  {
    return this.lpa;
  }
  
  public final g bbs()
  {
    AppMethodBeat.i(150118);
    g localg = new g();
    localg.taskName = "task_AppMessage";
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.iTU;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.loZ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)((Map.Entry)localIterator.next()).getValue();
      if (localf != null) {
        localf.a(localg, this);
      }
    }
    AppMethodBeat.o(150118);
    return localg;
  }
  
  public final boolean bbu()
  {
    return (this.llU != null) && (this.llU.lph != 0);
  }
  
  public final boolean bbv()
  {
    return (this.llU != null) && (this.llU.lpe == 1);
  }
  
  public final boolean bbw()
  {
    return this.loY == 1;
  }
  
  public final boolean fX(boolean paramBoolean)
  {
    AppMethodBeat.i(150113);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.loH >= k.a.llQ.ordinal()) && (this.loH < k.a.llS.ordinal()))
      {
        AppMethodBeat.o(150113);
        return true;
      }
    }
    else if ((this.loH >= k.a.llQ.ordinal()) && (this.loH < k.a.llS.ordinal()))
    {
      AppMethodBeat.o(150113);
      return true;
    }
    AppMethodBeat.o(150113);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.llU != null) && (this.llU.lpg != 0)) {
      return this.llU.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.llU != null) && (this.llU.lpf != 0)) {
      return this.llU.title;
    }
    return this.title;
  }
  
  public final String z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150112);
    String str = "";
    if (fX(true))
    {
      if (!Util.isNullOrNil(this.loK))
      {
        paramContext = this.loK;
        AppMethodBeat.o(150112);
        return paramContext;
      }
      if (Util.isNullOrNil(this.loI)) {
        break label203;
      }
      int i = paramContext.getResources().getIdentifier(this.loI, "string", paramContext.getPackageName());
      Log.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label173;
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
      Log.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { paramContext });
      AppMethodBeat.o(150112);
      return paramContext;
      label173:
      if (k.a.llQ.ordinal() == this.loH)
      {
        str = "";
      }
      else
      {
        str = this.fUe;
        continue;
        label203:
        if (k.a.llQ.ordinal() == this.loH) {
          str = "";
        } else {
          str = this.fUe;
        }
      }
    }
  }
  
  public static final class a
  {
    public String desc;
    public String ilq;
    public int lpe;
    public int lpf;
    public int lpg;
    public int lph;
    public int lpi = 0;
    public int lpj = 0;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.k.b
 * JD-Core Version:    0.7.0.1
 */