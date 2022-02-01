package com.tencent.mm.ag;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static final com.tencent.mm.b.f<Integer, b> gAU;
  public String action;
  public String aesKey;
  public String appId;
  public String appName;
  public int appVersion;
  public String canvasPageXml;
  public String content;
  public int contentattr;
  public String dCK;
  public int dDG;
  public String dFv;
  public String dPu;
  public String dRL;
  public int dYg;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String eag;
  public String eah;
  public String eaj;
  public String eak;
  public String eal;
  public String eam;
  public String ean;
  public String extInfo;
  public String fQR;
  public String filemd5;
  public String iconUrl;
  public a iwF;
  public Map<String, String> iwG;
  public String iwH;
  public int iwI;
  public String iwJ;
  public String iwK;
  public int iwL;
  public int iwM;
  public String iwN;
  public String iwO;
  public int iwP;
  public int iwQ;
  public int iwR;
  public String iwS;
  public String iwT;
  public String iwU;
  public String iwV;
  public String iwW;
  public String iwX;
  public int iwY;
  public int iwZ;
  public int iwc;
  public String ixA;
  public String ixB;
  public String ixC;
  public String ixD;
  public String ixE;
  public int ixF;
  public int ixG;
  public int ixH;
  public String ixI;
  public String ixJ;
  public String ixK;
  public String ixL;
  public String ixM;
  public int ixN;
  public String ixO;
  public String ixP;
  public String ixQ;
  public int ixR;
  public int ixS;
  public String ixT;
  public String ixU;
  public int ixV;
  public int ixW;
  public int ixX;
  public String ixY;
  public String ixZ;
  public int ixa;
  public String ixb;
  public int ixc;
  public String ixd;
  public String ixe;
  public int ixf;
  public int ixg;
  public String ixh;
  public String ixi;
  public int ixj;
  public String ixk;
  public String ixl;
  public int ixm;
  public String ixn;
  public String ixo;
  public int ixp;
  public String ixq;
  public String ixr;
  public String ixs;
  public String ixt;
  public String ixu;
  public String ixv;
  public String ixw;
  public String ixx;
  public String ixy;
  public String ixz;
  public int iyA;
  public String iyB;
  public String iyC;
  public String iyD;
  public List<String> iyE;
  public String iyF;
  public List<String> iyG;
  public String iyH;
  public int iyI;
  public String iyJ;
  public String iyK;
  public String iyL;
  public String iyM;
  public String iyN;
  public String iyO;
  public String iyP;
  public String iyQ;
  public String iyR;
  public String iyS;
  public String iyT;
  public String iyU;
  public int iyV;
  public String iyW;
  public String iyX;
  public Map<String, String> iyY;
  public String iyZ;
  public String iya;
  public String iyb;
  public String iyc;
  public String iyd;
  public String iye;
  public int iyf;
  public String iyg;
  public String iyh;
  public String iyi;
  public String iyj;
  public String iyk;
  public String iyl;
  public String iym;
  public String iyn;
  public String iyo;
  public String iyp;
  public String iyq;
  public String iyr;
  public int iys;
  public String iyt;
  public String iyu;
  public String iyv;
  public int iyw;
  public boolean iyx;
  public int iyy;
  public String iyz;
  public int izA;
  public String izB;
  public int izC;
  public int izD;
  private final HashMap<Class<? extends f>, f> izE;
  public Map<String, String> izF;
  private String izG;
  private String izH;
  private String izI;
  public int iza;
  public String izb;
  public String izc;
  public String izd;
  public String ize;
  public String izf;
  public String izg;
  public String izh;
  public String izi;
  public String izj;
  public int izk;
  public String izl;
  public int izm;
  public String izn;
  public String izo;
  public int izp;
  public String izq;
  public int izr;
  public String izs;
  public String izt;
  public String izu;
  public String izv;
  public String izw;
  public Pair<String, String> izx;
  public MsgQuoteItem izy;
  public int izz;
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
    gAU = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(150125);
  }
  
  public k$b()
  {
    AppMethodBeat.i(150108);
    this.iyx = false;
    this.iyy = 0;
    this.iza = 0;
    this.izb = "";
    this.izc = "";
    this.izd = "";
    this.ize = "";
    this.izf = "";
    this.izg = "";
    this.izp = k.a.iwD.ordinal();
    this.izx = new Pair("", "");
    this.canvasPageXml = "";
    this.izC = 0;
    this.izD = 0;
    this.izE = new HashMap();
    AppMethodBeat.o(150108);
  }
  
  public static final b HC(String paramString)
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
    paramString = (b)gAU.get(Integer.valueOf(i));
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
    gAU.x(Integer.valueOf(i), localObject);
    AppMethodBeat.o(150111);
    return localObject;
  }
  
  public static final b HD(String paramString)
  {
    AppMethodBeat.i(150114);
    paramString = aD(paramString, null);
    AppMethodBeat.o(150114);
    return paramString;
  }
  
  public static String HE(String paramString)
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
    paramb = paramb.aSw();
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
      gAU.x(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
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
    f localf = k.c.rI(paramb.type);
    if (localf != null) {
      localf.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == paramb.dDG) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.iwV).append("</ShakePageResult>");
    }
    Log.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(150117);
    return paramb;
  }
  
  public static final b aD(String paramString1, String paramString2)
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
      Object localObject1 = (b)gAU.get(Integer.valueOf(i));
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
          localb.izF = ((Map)localObject1);
          localb.izG = paramString1;
          localb.izH = ((String)localObject2);
          localb.izI = paramString2;
          try
          {
            localb.a((Map)localObject1, localb);
            paramString1 = k.c.access$000().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (f)((com.tencent.mm.co.c)paramString1.next()).get();
              if (localObject2 != null)
              {
                ((f)localObject2).a((Map)localObject1, localb);
                localb.a((f)localObject2);
              }
            }
            paramString1 = k.c.rI(localb.type);
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
          gAU.x(Integer.valueOf(i), localb);
          Log.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(Util.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(150115);
          return localb;
        }
      }
    }
  }
  
  private b aSw()
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
    localb.dCK = this.dCK;
    localb.iwI = this.iwI;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.iwL = this.iwL;
    localb.iwJ = this.iwJ;
    localb.dRL = this.dRL;
    localb.iwH = this.iwH;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.dDG = this.dDG;
    localb.iwc = this.iwc;
    localb.ixf = this.ixf;
    localb.url = this.url;
    localb.iwK = this.iwK;
    localb.eag = this.eag;
    localb.eah = this.eah;
    localb.fQR = this.fQR;
    localb.thumburl = this.thumburl;
    localb.iwV = this.iwV;
    localb.ixd = this.ixd;
    localb.ixe = this.ixe;
    localb.ixg = this.ixg;
    localb.ixh = this.ixh;
    localb.ixj = this.ixj;
    localb.ixi = this.ixi;
    localb.ixm = this.ixm;
    localb.ixn = this.ixn;
    localb.ixp = this.ixp;
    localb.ixo = this.ixo;
    localb.ixk = this.ixk;
    localb.ixl = this.ixl;
    localb.ixM = this.ixM;
    localb.dPu = this.dPu;
    localb.ixT = this.ixT;
    localb.ixU = this.ixU;
    localb.ixV = this.ixV;
    localb.ixW = this.ixV;
    localb.ixO = this.ixO;
    localb.ixR = this.ixR;
    localb.ixN = this.ixN;
    localb.ixP = this.ixP;
    localb.ixQ = this.ixQ;
    localb.iyf = this.iyf;
    localb.iyg = this.iyg;
    localb.iyh = this.iyh;
    localb.contentattr = this.contentattr;
    localb.eaj = this.eaj;
    localb.eak = this.eak;
    localb.eal = this.eal;
    localb.eam = this.eam;
    localb.iyX = this.iyX;
    localb.iyV = this.iyV;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.iyW = this.iyW;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.iyZ = this.iyZ;
    localb.iza = this.iza;
    localb.izb = this.izb;
    localb.izc = this.izc;
    localb.izd = this.izd;
    localb.ize = this.ize;
    localb.izf = this.izf;
    localb.izg = this.izg;
    localb.canvasPageXml = this.canvasPageXml;
    localb.ean = this.ean;
    localb.iyY = this.iyY;
    localb.iwW = this.iwW;
    localb.aesKey = this.aesKey;
    localb.filemd5 = this.filemd5;
    localb.iwM = this.iwM;
    localb.iwF = this.iwF;
    localb.izh = this.izh;
    localb.izi = this.izi;
    localb.izk = this.izk;
    localb.izl = this.izl;
    localb.izz = this.izz;
    localb.izj = this.izj;
    localb.izA = this.izA;
    localb.izB = this.izB;
    localb.izn = this.izn;
    localb.izo = this.izo;
    localb.izp = this.izp;
    localb.izq = this.izq;
    localb.izs = this.izs;
    localb.izt = this.izt;
    localb.izr = this.izr;
    localb.izH = this.izH;
    localb.izI = this.izI;
    localb.izG = this.izG;
    localb.izF = this.izF;
    localb.iwN = this.iwN;
    localb.iwO = this.iwO;
    localb.iwP = this.iwP;
    localb.iwQ = this.iwQ;
    localb.iwR = this.iwR;
    localb.iwS = this.iwS;
    localb.iwT = this.iwT;
    localb.iwU = this.iwU;
    localb.izy = this.izy;
    localb.izx = this.izx;
    localb.izu = this.izu;
    localb.izv = this.izv;
    localb.izw = this.izw;
    localb.izD = this.izD;
    Iterator localIterator = this.izE.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).aHj();
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
    paramf.iwk = this;
    this.izE.put(paramf.getClass(), paramf);
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
      localObject1 = (f)((com.tencent.mm.co.c)localIterator.next()).get();
      if (localObject1 != null)
      {
        localObject2 = paramb.as(localObject1.getClass());
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
      paramStringBuilder.append("<showtype>").append(paramb.dDG).append("</showtype>");
      paramStringBuilder.append("<content>" + Util.escapeStringForXml(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + Util.escapeStringForXml(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + Util.escapeStringForXml(paramb.iwH) + "</lowurl>");
      paramStringBuilder.append("<dataurl>" + Util.escapeStringForXml(paramb.ixd) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + Util.escapeStringForXml(paramb.ixe) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.contentattr).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(Util.escapeStringForXml(paramb.iyZ)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.iza).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(Util.escapeStringForXml(paramb.izb)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(Util.escapeStringForXml(paramb.izc)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(Util.escapeStringForXml(paramb.izd)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(Util.escapeStringForXml(paramb.ize)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(paramb.izf)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(Util.escapeStringForXml(paramb.izg)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      default: 
        label804:
        paramStringBuilder.append("<appattach>");
        if ((paramd == null) || ((Util.isNullOrNil(paramString)) && (paramInt1 == 0) && (paramInt2 == 0)))
        {
          paramStringBuilder.append("<totallen>" + paramb.iwI + "</totallen>");
          paramStringBuilder.append("<attachid>" + Util.escapeStringForXml(paramb.dCK) + "</attachid>");
          paramStringBuilder.append("<cdnattachurl>" + Util.escapeStringForXml(paramb.iwW) + "</cdnattachurl>");
          paramStringBuilder.append("<emoticonmd5>" + Util.escapeStringForXml(paramb.iwK) + "</emoticonmd5>");
          paramStringBuilder.append("<aeskey>" + Util.escapeStringForXml(paramb.aesKey) + "</aeskey>");
          if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
            paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
          }
          paramStringBuilder.append("<fileext>" + Util.escapeStringForXml(paramb.iwJ) + "</fileext>");
          paramStringBuilder.append("<islargefilemsg>" + paramb.iwM + "</islargefilemsg>");
          paramStringBuilder.append("</appattach>");
          if (paramb.type != 53) {
            break label4146;
          }
          paramStringBuilder.append("<extinfo>").append((String)paramb.izx.second).append("</extinfo>");
        }
        break;
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<androidsource>" + paramb.iwL + "</androidsource>");
      if (!Util.isNullOrNil(paramb.eag))
      {
        paramStringBuilder.append("<sourceusername>" + Util.escapeStringForXml(paramb.eag) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + Util.escapeStringForXml(paramb.eah) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + Util.escapeStringForXml(paramb.fQR) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + Util.escapeStringForXml(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + Util.escapeStringForXml(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + HE(Util.escapeStringForXml(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + HE(Util.escapeStringForXml(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.ixj + "</packageflag>");
      paramStringBuilder.append("<packageid>" + Util.escapeStringForXml(paramb.ixi) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.ixp + "</packageflag>");
      paramStringBuilder.append("<packageid>" + Util.escapeStringForXml(paramb.ixo) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.iyV + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.iyW + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + Util.escapeStringForXml(paramb.eaj) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + Util.escapeStringForXml(paramb.eak) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + Util.escapeStringForXml(paramb.eal) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + Util.escapeStringForXml(paramb.eam) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + Util.escapeStringForXml(paramb.ixM) + "</template_id>");
      Log.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + Util.escapeStringForXml(paramb.filemd5) + "</md5>");
      localIterator = k.c.access$000().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (f)((com.tencent.mm.co.c)localIterator.next()).get();
        if (localObject1 != null)
        {
          localObject2 = paramb.as(localObject1.getClass());
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((f)localObject1).a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
        }
      }
      localObject1 = Util.escapeStringForXml(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.ixg + "\">");
      paramStringBuilder.append("<productinfo>" + Util.escapeStringForXml(paramb.ixh) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      break label804;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.ixm + "\">");
      paramStringBuilder.append("<mallproductinfo>" + Util.escapeStringForXml(paramb.ixn) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      break label804;
      paramStringBuilder.append("<tvinfo>" + Util.escapeStringForXml(paramb.ixk) + "</tvinfo>");
      break label804;
      paramStringBuilder.append("<recorditem>" + Util.escapeStringForXml(paramb.ixl) + "</recorditem>");
      break label804;
      paramStringBuilder.append("<carditem>" + paramb.ixT + "</carditem>");
      break label804;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.ixN + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.ixO + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.ixP + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.ixQ + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.ixR + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.iyX + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      break label804;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + Util.escapeStringForXml(paramb.iyj) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + Util.escapeStringForXml(paramb.iyo) + "</scenetext>");
      paramStringBuilder.append("<url>" + Util.escapeStringForXml(paramb.iyi) + "</url>");
      paramStringBuilder.append("<receivertitle>" + Util.escapeStringForXml(paramb.iyk) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + Util.escapeStringForXml(paramb.iyl) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + Util.escapeStringForXml(paramb.iyn) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + Util.escapeStringForXml(paramb.iym) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + Util.escapeStringForXml(paramb.iyp) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + Util.escapeStringForXml(paramb.iyq) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + Util.escapeStringForXml(paramb.iyr) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + Util.escapeStringForXml(new StringBuilder().append(paramb.dDG).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + Util.escapeStringForXml(new StringBuilder().append(paramb.iys).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + Util.escapeStringForXml(paramb.iyt) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + Util.escapeStringForXml(paramb.iyu) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + Util.escapeStringForXml(paramb.iyv) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + Util.escapeStringForXml(new StringBuilder().append(paramb.iyw).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + Util.escapeStringForXml(new StringBuilder().append(paramb.iyy).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
      break label804;
      paramStringBuilder.append("<refermsg>");
      if (paramb.izy != null)
      {
        paramStringBuilder.append("<type>").append(paramb.izy.type).append("</type>");
        paramStringBuilder.append("<svrid>").append(paramb.izy.zFI).append("</svrid>");
        paramStringBuilder.append("<fromusr>").append(paramb.izy.zFJ).append("</fromusr>");
        paramStringBuilder.append("<chatusr>").append(paramb.izy.zFK).append("</chatusr>");
        paramStringBuilder.append("<displayname>").append(Util.escapeStringForXml(paramb.izy.zFL)).append("</displayname>");
        paramStringBuilder.append("<msgsource>").append(Util.escapeStringForXml(paramb.izy.zFM)).append("</msgsource>");
        paramStringBuilder.append("<content>").append(Util.escapeStringForXml(paramb.izy.content)).append("</content>");
      }
      paramStringBuilder.append("</refermsg>");
      break label804;
      paramStringBuilder.append("<liteapp>");
      paramStringBuilder.append("<id>").append(paramb.izu).append("</id>");
      paramStringBuilder.append("<path>").append(Util.escapeStringForXml(paramb.izv)).append("</path>");
      paramStringBuilder.append("<query>").append(Util.escapeStringForXml(paramb.izw)).append("</query>");
      paramStringBuilder.append("</liteapp>");
      break label804;
      paramStringBuilder.append("<attachid>" + Util.escapeStringForXml(paramString) + "</attachid>");
      if ((paramd.field_fileLength > 0L) && (!Util.isNullOrNil(paramd.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + Util.escapeStringForXml(paramd.field_fileId) + "</cdnattachurl>");
        if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
          break label4109;
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
        label4109:
        Log.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Long.valueOf(paramd.field_fileLength) });
      }
      label4146:
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
        this.iwG = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = Util.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = Util.escapeDirTraversal((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = Util.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.iwH = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.iwN = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.iwO = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.iwP = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.iwQ = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.iwR = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.iwS = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.iwT = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.iwU = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.ixd = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.ixe = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.iwI = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.dCK = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!Util.isNullOrNil(this.iwN)) {
          this.dCK = this.iwN;
        }
        this.iwJ = Util.escapeDirTraversal((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.iwK = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.izx = new Pair("", paramMap.get(".msg.appmsg.extinfo.solitaire_info"));
        this.iwL = Util.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.eag = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.eah = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.fQR = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.appVersion = Util.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.dRL = ((String)paramMap.get(".msg.fromusername"));
        this.iwW = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.iwX = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.iwY = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.iwZ = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.ixa = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.thumbHeight = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.thumbWidth = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.aesKey = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.ixc = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.ixb = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.iwM = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.iwM == 0) && (this.iwI > 26214400))
        {
          this.iwM = 1;
          Log.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.iwI) });
        }
        this.ixg = Util.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.ixh = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.ixj = Util.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.ixi = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.ixo = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.ixp = Util.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.ixk = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.ixl = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.eaj = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.eak = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.eal = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.eam = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.iyV = p.fd((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = Util.safeParseInt((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.iyW = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = Util.nullAs((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = Util.safeParseInt((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.iyZ = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.iza = Util.safeParseInt((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.izb = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.izc = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.izd = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.ize = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.izf = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.izg = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = Util.nullAs((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        if (paramMap.containsKey(".msg.appmsg.gamelife"))
        {
          this.iyY = new HashMap(4);
          this.iyY.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording")));
          this.iyY.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1")));
          this.iyY.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2")));
          this.iyY.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3")));
        }
        this.izi = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.izh = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.izj = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.izA = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.izk = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.izz = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.izl = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.izB = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.izn = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.izo = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.izp = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), k.a.iwD.ordinal());
        this.izq = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.izs = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.sourcename"), "");
        this.izt = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.sourceiconurl"), "");
        this.izr = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.izC = Util.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label4481;
          }
          this.dDG = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.ean = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.iwc = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.iwc == 5) && (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.iwc = 0;
          }
          this.ixf = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.ixq = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.ixr = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (Util.isNullOrNil(this.ixr)) {
            this.ixr = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.ixs = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.ixt = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.ixu = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.ixv = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.ixw = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.ixx = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.ixy = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.ixA = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.ixz = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.ixC = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.ixB = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.ixF = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.ixH = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.ixG = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.ixD = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.ixE = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.ixL = ((String)localObject);
          this.ixJ = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.ixK = ((String)localObject);
          this.ixI = ((String)localObject);
          this.ixM = Util.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.iyf = Util.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.iyg = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.iyh = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = XmlParser.parseXml(paramb.izH, "msgoperation", null);
          if ((this != null) && (paramMap != null))
          {
            this.iwF = new a();
            this.iwF.fRa = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.iwF.izJ = Util.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.iwF.izK = Util.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.iwF.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.iwF.izL = Util.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.iwF.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.iwF.izM = Util.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
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
      this.ixm = Util.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.ixn = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.ixN = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.ixO = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.ixP = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.ixQ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.ixR = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.ixS = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.dYg = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.dFv = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.iyX = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.iyj = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.iyo = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.iyi = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.iyk = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.iyl = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.iyn = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.iym = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.iyp = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.iyq = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.iyr = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.iys = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.iyt = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.iyu = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.iyv = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.iyw = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.iyy = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.ixR = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.iyz = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.iyA = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.iyB = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.iyC = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.iyD = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.iyE = new ArrayList();
          this.iyE.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.iyF = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.iyG = new ArrayList();
          this.iyG.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.iyH = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.iyI = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.iyJ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.iyK = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.iyL = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.iyM = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.iyN = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.iyO = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.iyP = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.iyQ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.iyR = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.iyS = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.iyT = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.iyU = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.dPu = paramb.izG;
      this.ixT = "";
      this.ixV = Util.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.ixU = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.ixW = Util.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.iyx = true;
        continue;
        this.ixY = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.ixX = p.fd((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.ixZ = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.iya = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.iyb = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.iyc = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.iyd = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.iye = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        this.izy = new MsgQuoteItem();
        this.izy.type = Util.getInt((String)paramMap.get(".msg.appmsg.refermsg.type"), 0);
        this.izy.zFI = Util.getLong((String)paramMap.get(".msg.appmsg.refermsg.svrid"), 0L);
        this.izy.zFJ = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.fromusr"), "");
        this.izy.zFK = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.izy.zFK = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.izy.zFL = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.displayname"), "");
        this.izy.content = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.content"), "");
        this.izy.zFM = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.msgsource"), "");
        continue;
        this.izu = ((String)paramMap.get(".msg.appmsg.liteapp.id"));
        this.izv = ((String)paramMap.get(".msg.appmsg.liteapp.path"));
        this.izw = ((String)paramMap.get(".msg.appmsg.liteapp.query"));
        continue;
        label4481:
        if (this.type == 2001)
        {
          this.dDG = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.dDG = Util.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.dDG)
          {
          case 1: 
            if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = SemiXml.encode(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.izG.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.iwV = paramb.izG.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final Map<String, String> aSu()
  {
    return this.izF;
  }
  
  public final g aSv()
  {
    AppMethodBeat.i(150118);
    g localg = new g();
    localg.taskName = "task_AppMessage";
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.gpM;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.izE.entrySet().iterator();
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
  
  public final boolean aSx()
  {
    return (this.iwF != null) && (this.iwF.izM != 0);
  }
  
  public final boolean aSy()
  {
    return (this.iwF != null) && (this.iwF.izJ == 1);
  }
  
  public final <T extends f> T as(Class<T> paramClass)
  {
    AppMethodBeat.i(150109);
    paramClass = (f)this.izE.get(paramClass);
    AppMethodBeat.o(150109);
    return paramClass;
  }
  
  public final boolean fn(boolean paramBoolean)
  {
    AppMethodBeat.i(150113);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.izp >= k.a.iwB.ordinal()) && (this.izp < k.a.iwD.ordinal()))
      {
        AppMethodBeat.o(150113);
        return true;
      }
    }
    else if ((this.izp >= k.a.iwB.ordinal()) && (this.izp < k.a.iwD.ordinal()))
    {
      AppMethodBeat.o(150113);
      return true;
    }
    AppMethodBeat.o(150113);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.iwF != null) && (this.iwF.izL != 0)) {
      return this.iwF.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.iwF != null) && (this.iwF.izK != 0)) {
      return this.iwF.title;
    }
    return this.title;
  }
  
  public final String w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150112);
    String str = "";
    if (fn(true))
    {
      if (!Util.isNullOrNil(this.izs))
      {
        paramContext = this.izs;
        AppMethodBeat.o(150112);
        return paramContext;
      }
      if (Util.isNullOrNil(this.izq)) {
        break label203;
      }
      int i = paramContext.getResources().getIdentifier(this.izq, "string", paramContext.getPackageName());
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
      if (k.a.iwB.ordinal() == this.izp)
      {
        str = "";
      }
      else
      {
        str = this.eah;
        continue;
        label203:
        if (k.a.iwB.ordinal() == this.izp) {
          str = "";
        } else {
          str = this.eah;
        }
      }
    }
  }
  
  public static final class a
  {
    public String desc;
    public String fRa;
    public int izJ;
    public int izK;
    public int izL;
    public int izM;
    public int izN = 0;
    public int izO = 0;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.k.b
 * JD-Core Version:    0.7.0.1
 */