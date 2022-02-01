package com.tencent.mm.message;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g;
import com.tencent.mm.message.a.b;
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
  private static final com.tencent.mm.b.f<Integer, b> lNS;
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
  public String filemd5;
  public int hAN;
  public String hCH;
  public String hOj;
  public String hQQ;
  public String hRv;
  public int hXS;
  public String hzM;
  public String iaa;
  public String iab;
  public String iad;
  public String iae;
  public String iaf;
  public String iag;
  public String iah;
  public String iconUrl;
  public String kLg;
  public String mediaTagName;
  public String messageAction;
  public String messageExt;
  public int nQm;
  public int nRA;
  public String nRB;
  public String nRC;
  public int nRD;
  public String nRE;
  public String nRF;
  public int nRG;
  public String nRH;
  public String nRI;
  public int nRJ;
  public String nRK;
  public String nRL;
  public String nRM;
  public String nRN;
  public String nRO;
  public String nRP;
  public String nRQ;
  public String nRR;
  public String nRS;
  public String nRT;
  public String nRU;
  public String nRV;
  public String nRW;
  public String nRX;
  public String nRY;
  public int nRZ;
  public a nRa;
  public Map<String, String> nRb;
  public String nRc;
  public int nRd;
  public String nRe;
  public String nRf;
  public int nRg;
  public int nRh;
  public String nRi;
  public int nRj;
  public int nRk;
  public int nRl;
  public String nRm;
  public String nRn;
  public String nRo;
  public String nRp;
  public String nRq;
  public String nRr;
  public int nRs;
  public int nRt;
  public int nRu;
  public String nRv;
  public int nRw;
  public String nRx;
  public String nRy;
  public int nRz;
  public String nSA;
  public String nSB;
  public String nSC;
  public String nSD;
  public String nSE;
  public String nSF;
  public String nSG;
  public String nSH;
  public String nSI;
  public String nSJ;
  public String nSK;
  public String nSL;
  public int nSM;
  public String nSN;
  public String nSO;
  public String nSP;
  public int nSQ;
  public boolean nSR;
  public int nSS;
  public String nST;
  public int nSU;
  public String nSV;
  public String nSW;
  public String nSX;
  public List<String> nSY;
  public String nSZ;
  public int nSa;
  public int nSb;
  public String nSc;
  public String nSd;
  public String nSe;
  public String nSf;
  public String nSg;
  public int nSh;
  public String nSi;
  public String nSj;
  public String nSk;
  public int nSl;
  public int nSm;
  public String nSn;
  public String nSo;
  public int nSp;
  public int nSq;
  public int nSr;
  public String nSs;
  public String nSt;
  public String nSu;
  public String nSv;
  public String nSw;
  public String nSx;
  public String nSy;
  public int nSz;
  public String nTA;
  public String nTB;
  public String nTC;
  public String nTD;
  public String nTE;
  public int nTF;
  public String nTG;
  public int nTH;
  public String nTI;
  public String nTJ;
  public int nTK;
  public String nTL;
  public int nTM;
  public String nTN;
  public String nTO;
  public int nTP;
  public String nTQ;
  public String nTR;
  public String nTS;
  public Pair<String, String> nTT;
  public MsgQuoteItem nTU;
  public String nTV;
  public int nTW;
  public int nTX;
  public String nTY;
  public int nTZ;
  public List<String> nTa;
  public String nTb;
  public int nTc;
  public String nTd;
  public int nTe;
  public String nTf;
  public String nTg;
  public String nTh;
  public String nTi;
  public String nTj;
  public String nTk;
  public String nTl;
  public String nTm;
  public String nTn;
  public String nTo;
  public String nTp;
  public int nTq;
  public String nTr;
  public String nTs;
  public Map<String, String> nTt;
  public String nTu;
  public int nTv;
  public String nTw;
  public String nTx;
  public String nTy;
  public String nTz;
  public int nUa;
  public int nUb;
  private final HashMap<Class<? extends f>, f> nUc;
  public Map<String, String> nUd;
  public String nUe;
  private String nUf;
  private String nUg;
  public int pageType;
  public int sdkVer;
  public String secondUrl;
  public int thumbHeight;
  public int thumbWidth;
  public String thumburl;
  public int tid;
  public String title;
  public String tpurl;
  public int type;
  public String url;
  public String username;
  
  static
  {
    AppMethodBeat.i(150125);
    lNS = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(150125);
  }
  
  public k$b()
  {
    AppMethodBeat.i(150108);
    this.nSi = "";
    this.nSR = false;
    this.nSS = 0;
    this.nTv = 0;
    this.nTw = "";
    this.nTx = "";
    this.nTy = "";
    this.nTz = "";
    this.nTA = "";
    this.nTB = "";
    this.nTK = k.a.nQY.ordinal();
    this.nTT = new Pair("", "");
    this.canvasPageXml = "";
    this.nTZ = 0;
    this.nUa = 0;
    this.nUb = 0;
    this.nUc = new HashMap();
    AppMethodBeat.o(150108);
  }
  
  public static final b Hf(String paramString)
  {
    AppMethodBeat.i(150114);
    paramString = aP(paramString, null);
    AppMethodBeat.o(150114);
    return paramString;
  }
  
  public static String Hg(String paramString)
  {
    AppMethodBeat.i(150123);
    paramString = "<![CDATA[" + paramString + "]]>";
    AppMethodBeat.o(150123);
    return paramString;
  }
  
  public static b M(int paramInt, String paramString)
  {
    AppMethodBeat.i(233989);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(233989);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    i = ("parse" + paramInt + "_" + (String)localObject).hashCode();
    paramString = (b)lNS.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(233989);
      return paramString;
    }
    paramString = XmlParser.parseXml((String)localObject, "msg", null);
    if (paramString == null)
    {
      Log.e("MicroMsg.AppMessage", "parseImg failed");
      AppMethodBeat.o(233989);
      return null;
    }
    localObject = new b();
    ((b)localObject).type = paramInt;
    ((b)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((b)localObject).appVersion = Util.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((b)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((b)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((b)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((b)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    lNS.B(Integer.valueOf(i), localObject);
    AppMethodBeat.o(233989);
    return localObject;
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
    paramb = paramb.bwm();
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
      lNS.B(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
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
    if (2 == paramb.hAN) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.nRp).append("</ShakePageResult>");
    }
    Log.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(150117);
    return paramb;
  }
  
  public static final b aP(String paramString1, String paramString2)
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
      Object localObject1 = (b)lNS.get(Integer.valueOf(i));
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
          localb.nUd = ((Map)localObject1);
          localb.nUe = paramString1;
          localb.nUf = ((String)localObject2);
          localb.nUg = paramString2;
          try
          {
            localb.a((Map)localObject1, localb);
            paramString1 = k.c.access$000().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (f)((com.tencent.mm.cp.c)paramString1.next()).get();
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
          lNS.B(Integer.valueOf(i), localb);
          Log.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(Util.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(150115);
          return localb;
        }
      }
    }
  }
  
  private b bwm()
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
    localb.hzM = this.hzM;
    localb.nRd = this.nRd;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.nRg = this.nRg;
    localb.nRe = this.nRe;
    localb.hQQ = this.hQQ;
    localb.nRc = this.nRc;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.hAN = this.hAN;
    localb.nQm = this.nQm;
    localb.nRz = this.nRz;
    localb.url = this.url;
    localb.nRf = this.nRf;
    localb.iaa = this.iaa;
    localb.iab = this.iab;
    localb.kLg = this.kLg;
    localb.thumburl = this.thumburl;
    localb.nRp = this.nRp;
    localb.nRx = this.nRx;
    localb.nRy = this.nRy;
    localb.nRA = this.nRA;
    localb.nRB = this.nRB;
    localb.nRD = this.nRD;
    localb.nRC = this.nRC;
    localb.nRG = this.nRG;
    localb.nRH = this.nRH;
    localb.nRJ = this.nRJ;
    localb.nRI = this.nRI;
    localb.nRE = this.nRE;
    localb.nRF = this.nRF;
    localb.nSg = this.nSg;
    localb.hOj = this.hOj;
    localb.nSn = this.nSn;
    localb.nSo = this.nSo;
    localb.nSp = this.nSp;
    localb.nSq = this.nSp;
    localb.nSi = this.nSi;
    localb.nSl = this.nSl;
    localb.nSh = this.nSh;
    localb.nSj = this.nSj;
    localb.nSk = this.nSk;
    localb.nSz = this.nSz;
    localb.nSA = this.nSA;
    localb.nSB = this.nSB;
    localb.contentattr = this.contentattr;
    localb.iad = this.iad;
    localb.iae = this.iae;
    localb.iaf = this.iaf;
    localb.iag = this.iag;
    localb.nTs = this.nTs;
    localb.nTq = this.nTq;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.nTr = this.nTr;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.nTu = this.nTu;
    localb.nTv = this.nTv;
    localb.nTw = this.nTw;
    localb.nTx = this.nTx;
    localb.nTy = this.nTy;
    localb.nTz = this.nTz;
    localb.nTA = this.nTA;
    localb.nTB = this.nTB;
    localb.canvasPageXml = this.canvasPageXml;
    localb.iah = this.iah;
    localb.nTt = this.nTt;
    localb.nRq = this.nRq;
    localb.aesKey = this.aesKey;
    localb.filemd5 = this.filemd5;
    localb.nRh = this.nRh;
    localb.nRa = this.nRa;
    localb.nTC = this.nTC;
    localb.nTD = this.nTD;
    localb.nTF = this.nTF;
    localb.nTG = this.nTG;
    localb.nTW = this.nTW;
    localb.nTE = this.nTE;
    localb.nTX = this.nTX;
    localb.nTY = this.nTY;
    localb.nTI = this.nTI;
    localb.nTJ = this.nTJ;
    localb.nTK = this.nTK;
    localb.nTL = this.nTL;
    localb.nTN = this.nTN;
    localb.nTO = this.nTO;
    localb.nTM = this.nTM;
    localb.nTP = this.nTP;
    localb.nUf = this.nUf;
    localb.nUg = this.nUg;
    localb.nUe = this.nUe;
    localb.nUd = this.nUd;
    localb.tpurl = this.tpurl;
    localb.nRi = this.nRi;
    localb.nRj = this.nRj;
    localb.nRk = this.nRk;
    localb.nRl = this.nRl;
    localb.nRm = this.nRm;
    localb.nRn = this.nRn;
    localb.nRo = this.nRo;
    localb.nTU = this.nTU;
    localb.nTT = this.nTT;
    localb.nTQ = this.nTQ;
    localb.nTR = this.nTR;
    localb.nTS = this.nTS;
    localb.nUa = this.nUa;
    Iterator localIterator = this.nUc.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).biW();
      if (localf != null) {
        localb.a(localf);
      }
    }
    AppMethodBeat.o(150121);
    return localb;
  }
  
  public final String B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150112);
    String str = "";
    if (gK(true))
    {
      if (!Util.isNullOrNil(this.nTN))
      {
        paramContext = this.nTN;
        AppMethodBeat.o(150112);
        return paramContext;
      }
      if (Util.isNullOrNil(this.nTL)) {
        break label203;
      }
      int i = paramContext.getResources().getIdentifier(this.nTL, "string", paramContext.getPackageName());
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
      if (k.a.nQW.ordinal() == this.nTK)
      {
        str = "";
      }
      else
      {
        str = this.iab;
        continue;
        label203:
        if (k.a.nQW.ordinal() == this.nTK) {
          str = "";
        } else {
          str = this.iab;
        }
      }
    }
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
    paramf.nQu = this;
    this.nUc.put(paramf.getClass(), paramf);
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
      localObject1 = (f)((com.tencent.mm.cp.c)localIterator.next()).get();
      if (localObject1 != null)
      {
        localObject2 = paramb.aK(localObject1.getClass());
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
      paramStringBuilder.append("<showtype>").append(paramb.hAN).append("</showtype>");
      paramStringBuilder.append("<content>" + Util.escapeStringForXml(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + Util.escapeStringForXml(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + Util.escapeStringForXml(paramb.nRc) + "</lowurl>");
      paramStringBuilder.append("<forwardflag>" + paramb.nUb + "</forwardflag>");
      paramStringBuilder.append("<dataurl>" + Util.escapeStringForXml(paramb.nRx) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + Util.escapeStringForXml(paramb.nRy) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.contentattr).append("</contentattr>");
      if (!Util.isNullOrNil(paramb.hRv)) {
        paramStringBuilder.append("<syncrecordctx><![CDATA[").append(paramb.hRv).append("]]></syncrecordctx>");
      }
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(Util.escapeStringForXml(paramb.nTu)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.nTv).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(Util.escapeStringForXml(paramb.nTw)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(Util.escapeStringForXml(paramb.nTx)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(Util.escapeStringForXml(paramb.nTy)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(Util.escapeStringForXml(paramb.nTz)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(Util.escapeStringForXml(paramb.nTA)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(Util.escapeStringForXml(paramb.nTB)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      default: 
        label864:
        paramStringBuilder.append("<appattach>");
        if ((paramd == null) || ((Util.isNullOrNil(paramString)) && (paramInt1 == 0) && (paramInt2 == 0)))
        {
          paramStringBuilder.append("<totallen>" + paramb.nRd + "</totallen>");
          paramStringBuilder.append("<attachid>" + Util.escapeStringForXml(paramb.hzM) + "</attachid>");
          paramStringBuilder.append("<cdnattachurl>" + Util.escapeStringForXml(paramb.nRq) + "</cdnattachurl>");
          paramStringBuilder.append("<emoticonmd5>" + Util.escapeStringForXml(paramb.nRf) + "</emoticonmd5>");
          paramStringBuilder.append("<aeskey>" + Util.escapeStringForXml(paramb.aesKey) + "</aeskey>");
          if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
            paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
          }
          paramStringBuilder.append("<fileext>" + Util.escapeStringForXml(paramb.nRe) + "</fileext>");
          paramStringBuilder.append("<islargefilemsg>" + paramb.nRh + "</islargefilemsg>");
          localObject1 = (b)paramb.aK(b.class);
          if ((localObject1 != null) && (paramb.type == 6) && (((b)localObject1).nVD != 0L) && (!Util.isNullOrNil(((b)localObject1).nVE)))
          {
            paramStringBuilder.append("<overwrite_newmsgid>" + ((b)localObject1).nVD + "</overwrite_newmsgid>");
            paramStringBuilder.append("<fileuploadtoken>" + Hg(((b)localObject1).nVE) + "</fileuploadtoken>");
          }
          paramStringBuilder.append("</appattach>");
          if (paramb.type != 53) {
            break label4320;
          }
          paramStringBuilder.append("<extinfo>").append((String)paramb.nTT.second).append("</extinfo>");
        }
        break;
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<androidsource>" + paramb.nRg + "</androidsource>");
      if (!Util.isNullOrNil(paramb.iaa))
      {
        paramStringBuilder.append("<sourceusername>" + Util.escapeStringForXml(paramb.iaa) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + Util.escapeStringForXml(paramb.iab) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + Util.escapeStringForXml(paramb.kLg) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + Util.escapeStringForXml(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + Util.escapeStringForXml(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + Hg(Util.escapeStringForXml(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + Hg(Util.escapeStringForXml(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.nRD + "</packageflag>");
      paramStringBuilder.append("<packageid>" + Util.escapeStringForXml(paramb.nRC) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.nRJ + "</packageflag>");
      paramStringBuilder.append("<packageid>" + Util.escapeStringForXml(paramb.nRI) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.nTq + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.nTr + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + Util.escapeStringForXml(paramb.iad) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + Util.escapeStringForXml(paramb.iae) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + Util.escapeStringForXml(paramb.iaf) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + Util.escapeStringForXml(paramb.iag) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + Util.escapeStringForXml(paramb.nSg) + "</template_id>");
      Log.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + Util.escapeStringForXml(paramb.filemd5) + "</md5>");
      localIterator = k.c.access$000().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (f)((com.tencent.mm.cp.c)localIterator.next()).get();
        if (localObject1 != null)
        {
          localObject2 = paramb.aK(localObject1.getClass());
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((f)localObject1).a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
        }
      }
      localObject1 = Util.escapeStringForXml(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.nRA + "\">");
      paramStringBuilder.append("<productinfo>" + Util.escapeStringForXml(paramb.nRB) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      break label864;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.nRG + "\">");
      paramStringBuilder.append("<mallproductinfo>" + Util.escapeStringForXml(paramb.nRH) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      break label864;
      paramStringBuilder.append("<tvinfo>" + Util.escapeStringForXml(paramb.nRE) + "</tvinfo>");
      break label864;
      paramStringBuilder.append("<recorditem>" + Util.escapeStringForXml(paramb.nRF) + "</recorditem>");
      break label864;
      paramStringBuilder.append("<carditem>" + paramb.nSn + "</carditem>");
      break label864;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.nSh + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.nSi + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.nSj + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.nSk + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.nSl + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.nTs + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      break label864;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + Util.escapeStringForXml(paramb.nSD) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + Util.escapeStringForXml(paramb.nSI) + "</scenetext>");
      paramStringBuilder.append("<url>" + Util.escapeStringForXml(paramb.nSC) + "</url>");
      paramStringBuilder.append("<receivertitle>" + Util.escapeStringForXml(paramb.nSE) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + Util.escapeStringForXml(paramb.nSF) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + Util.escapeStringForXml(paramb.nSH) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + Util.escapeStringForXml(paramb.nSG) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + Util.escapeStringForXml(paramb.nSJ) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + Util.escapeStringForXml(paramb.nSK) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + Util.escapeStringForXml(paramb.nSL) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + Util.escapeStringForXml(new StringBuilder().append(paramb.hAN).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + Util.escapeStringForXml(new StringBuilder().append(paramb.nSM).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + Util.escapeStringForXml(paramb.nSN) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + Util.escapeStringForXml(paramb.nSO) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + Util.escapeStringForXml(paramb.nSP) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + Util.escapeStringForXml(new StringBuilder().append(paramb.nSQ).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + Util.escapeStringForXml(new StringBuilder().append(paramb.nSS).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
      break label864;
      paramStringBuilder.append("<refermsg>");
      if (paramb.nTU != null)
      {
        paramStringBuilder.append("<type>").append(paramb.nTU.type).append("</type>");
        paramStringBuilder.append("<svrid>").append(paramb.nTU.LgU).append("</svrid>");
        paramStringBuilder.append("<fromusr>").append(paramb.nTU.LgV).append("</fromusr>");
        paramStringBuilder.append("<chatusr>").append(paramb.nTU.LgW).append("</chatusr>");
        paramStringBuilder.append("<displayname>").append(Util.escapeStringForXml(paramb.nTU.LgX)).append("</displayname>");
        paramStringBuilder.append("<msgsource>").append(Util.escapeStringForXml(paramb.nTU.LgY)).append("</msgsource>");
        paramStringBuilder.append("<content>").append(Util.escapeStringForXml(paramb.nTU.content)).append("</content>");
      }
      paramStringBuilder.append("</refermsg>");
      break label864;
      paramStringBuilder.append("<liteapp>");
      paramStringBuilder.append("<id>").append(paramb.nTQ).append("</id>");
      paramStringBuilder.append("<path>").append(Util.escapeStringForXml(paramb.nTR)).append("</path>");
      paramStringBuilder.append("<query>").append(Util.escapeStringForXml(paramb.nTS)).append("</query>");
      paramStringBuilder.append("</liteapp>");
      break label864;
      paramStringBuilder.append("<attachid>" + Util.escapeStringForXml(paramString) + "</attachid>");
      if ((paramd.field_fileLength > 0L) && (!Util.isNullOrNil(paramd.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + Util.escapeStringForXml(paramd.field_fileId) + "</cdnattachurl>");
        if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
          break label4283;
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
        label4283:
        Log.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Long.valueOf(paramd.field_fileLength) });
      }
      label4320:
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
        this.nRb = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = Util.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = Util.escapeDirTraversal((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = Util.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.nRc = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.nUb = Util.getInt((String)paramMap.get(".msg.appmsg.forwardflag"), 0);
        this.tpurl = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.nRi = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.nRj = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.nRk = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.nRl = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.nRm = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.nRn = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.nRo = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.nRx = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.nRy = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.nRd = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.hzM = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!Util.isNullOrNil(this.tpurl)) {
          this.hzM = this.tpurl;
        }
        this.nRe = Util.escapeDirTraversal((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.nRf = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.nTT = new Pair("", (String)paramMap.get(".msg.appmsg.extinfo.solitaire_info"));
        this.nTV = Util.nullAs((String)paramMap.get(".msg.appmsg.laninfo"), "");
        this.nRg = Util.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.iaa = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.iab = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.kLg = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.appVersion = Util.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.hQQ = ((String)paramMap.get(".msg.fromusername"));
        this.nRq = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.nRr = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.nRs = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.nRt = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.nRu = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.thumbHeight = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.thumbWidth = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.aesKey = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.nRw = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.nRv = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.nRh = Util.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.nRh == 0) && (this.nRd > 26214400))
        {
          this.nRh = 1;
          Log.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.nRd) });
        }
        this.nRA = Util.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.nRB = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.nRD = Util.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.nRC = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.nRI = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.nRJ = Util.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.nRE = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.nRF = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.iad = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.iae = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.iaf = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.iag = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.nTq = p.hw((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = Util.safeParseInt((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.nTr = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = Util.nullAs((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = Util.safeParseInt((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.nTu = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.nTv = Util.safeParseInt((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.nTw = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.nTx = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.nTy = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.nTz = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.nTA = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.nTB = Util.nullAs((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = Util.nullAs((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        if (paramMap.containsKey(".msg.appmsg.gamelife"))
        {
          this.nTt = new HashMap(4);
          this.nTt.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording")));
          this.nTt.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1")));
          this.nTt.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2")));
          this.nTt.put(Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3.$lang")), Util.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3")));
        }
        this.nTD = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.nTC = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.nTE = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.nTX = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.nTF = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.nTW = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.nTG = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.nTY = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.nTI = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.nTJ = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.nTK = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), k.a.nQY.ordinal());
        this.nTL = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.nTN = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.sourcename"), "");
        this.nTO = Util.nullAs((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.sourceiconurl"), "");
        this.nTM = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.nTP = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.secflagforsinglepagemode"), 0);
        this.nTZ = Util.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label4565;
          }
          this.hAN = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.iah = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.nQm = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.nQm == 5) && (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.nQm = 0;
          }
          this.nRz = Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.nRK = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.nRL = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (Util.isNullOrNil(this.nRL)) {
            this.nRL = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.nRM = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.nRN = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.nRO = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.nRP = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.nRQ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.nRR = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.nRS = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.nRU = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.nRT = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.nRW = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.nRV = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.nRZ = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.nSb = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.nSa = Util.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.nRX = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.nRY = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.nSf = ((String)localObject);
          this.nSd = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.nSe = ((String)localObject);
          this.nSc = ((String)localObject);
          this.nSg = Util.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.nSz = Util.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.nSA = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.nSB = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = XmlParser.parseXml(paramb.nUf, "msgoperation", null);
          if ((this != null) && (paramMap != null))
          {
            this.nRa = new a();
            this.nRa.kLp = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.nRa.nUh = Util.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.nRa.nUi = Util.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.nRa.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.nRa.nUj = Util.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.nRa.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.nRa.nUk = Util.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
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
      this.nRG = Util.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.nRH = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.nSh = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.nSi = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.nSj = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.nSk = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.nSl = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.nSm = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.hXS = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.hCH = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.nTs = Util.nullAs((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.nSD = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.nSI = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.nSC = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.nSE = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.nSF = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.nSH = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.nSG = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.nSJ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.nSK = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.nSL = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.nSM = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.nSN = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.nSO = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.nSP = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.nSQ = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.nSS = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.nSl = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.nTe = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.bubbletype"), 0);
      this.nST = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.nSU = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.nSV = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.nSW = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.nSX = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.nSY = new ArrayList();
          this.nSY.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.nSZ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.nTa = new ArrayList();
          this.nTa.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.nTb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.nTc = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.nTd = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.nTf = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.nTg = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.nTh = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.nTi = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.nTj = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.nTk = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.nTl = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.nTm = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.nTn = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.nTo = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.nTp = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.hOj = paramb.nUe;
      this.nSn = "";
      this.nSp = Util.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.nSo = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.nSq = Util.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.nSR = true;
        continue;
        this.nSs = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.nSr = p.hw((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.nSt = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.nSu = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.nSv = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.nSw = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.nSx = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.nSy = Util.nullAs((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        this.nTU = new MsgQuoteItem();
        this.nTU.type = Util.getInt((String)paramMap.get(".msg.appmsg.refermsg.type"), 0);
        this.nTU.LgU = Util.getLong((String)paramMap.get(".msg.appmsg.refermsg.svrid"), 0L);
        this.nTU.LgV = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.fromusr"), "");
        this.nTU.LgW = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.nTU.LgW = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.nTU.LgX = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.displayname"), "");
        this.nTU.content = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.content"), "");
        this.nTU.LgY = Util.nullAs((String)paramMap.get(".msg.appmsg.refermsg.msgsource"), "");
        continue;
        this.nTQ = ((String)paramMap.get(".msg.appmsg.liteapp.id"));
        this.nTR = ((String)paramMap.get(".msg.appmsg.liteapp.path"));
        this.nTS = ((String)paramMap.get(".msg.appmsg.liteapp.query"));
        continue;
        label4565:
        if (this.type == 2001)
        {
          this.hAN = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.hAN = Util.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.hAN)
          {
          case 1: 
            if (Util.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = SemiXml.encode(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.nUe.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.nRp = paramb.nUe.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final <T extends f> T aK(Class<T> paramClass)
  {
    AppMethodBeat.i(150109);
    paramClass = (f)this.nUc.get(paramClass);
    AppMethodBeat.o(150109);
    return paramClass;
  }
  
  public final g bwl()
  {
    AppMethodBeat.i(150118);
    g localg = new g();
    localg.taskName = "task_AppMessage";
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.lvZ;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.nUc.entrySet().iterator();
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
  
  public final boolean bwn()
  {
    return (this.nRa != null) && (this.nRa.nUk != 0);
  }
  
  public final boolean bwo()
  {
    return (this.nRa != null) && (this.nRa.nUh == 1);
  }
  
  public final boolean bwp()
  {
    return this.nUb == 1;
  }
  
  public final boolean gK(boolean paramBoolean)
  {
    AppMethodBeat.i(150113);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.nTK >= k.a.nQW.ordinal()) && (this.nTK < k.a.nQY.ordinal()))
      {
        AppMethodBeat.o(150113);
        return true;
      }
    }
    else if ((this.nTK >= k.a.nQW.ordinal()) && (this.nTK < k.a.nQY.ordinal()))
    {
      AppMethodBeat.o(150113);
      return true;
    }
    AppMethodBeat.o(150113);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.nRa != null) && (this.nRa.nUj != 0)) {
      return this.nRa.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.nRa != null) && (this.nRa.nUi != 0)) {
      return this.nRa.title;
    }
    return this.title;
  }
  
  public static final class a
  {
    public String desc;
    public String kLp;
    public int nUh;
    public int nUi;
    public int nUj;
    public int nUk;
    public int nUl = 0;
    public int nUm = 0;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.k.b
 * JD-Core Version:    0.7.0.1
 */