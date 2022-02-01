package com.tencent.mm.ai;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
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
  private static final com.tencent.mm.b.f<Integer, b> fwL;
  public int aAS;
  public String action;
  public String appId;
  public String appName;
  public String canvasPageXml;
  public String content;
  public String dbA;
  public int dcz;
  public String dem;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String dnn;
  public String dpv;
  public int dvC;
  public String dxA;
  public String dxC;
  public String dxD;
  public String dxE;
  public String dxF;
  public String dxG;
  public String dxz;
  public String eOT;
  public String extInfo;
  public String fMw;
  public String filemd5;
  public int gGx;
  public String gHA;
  public String gHB;
  public int gHC;
  public int gHD;
  public String gHE;
  public String gHF;
  public int gHG;
  public String gHH;
  public String gHI;
  public int gHJ;
  public String gHK;
  public String gHL;
  public int gHM;
  public String gHN;
  public String gHO;
  public String gHP;
  public String gHQ;
  public String gHR;
  public String gHS;
  public String gHT;
  public String gHU;
  public String gHV;
  public String gHW;
  public String gHX;
  public String gHY;
  public String gHZ;
  public a gHb;
  public Map<String, String> gHc;
  public String gHd;
  public int gHe;
  public String gHf;
  public String gHg;
  public int gHh;
  public int gHi;
  public int gHj;
  public String gHk;
  public String gHl;
  public int gHm;
  public int gHn;
  public int gHo;
  public String gHp;
  public String gHq;
  public String gHr;
  public String gHs;
  public String gHt;
  public String gHu;
  public int gHv;
  public int gHw;
  public int gHx;
  public String gHy;
  public int gHz;
  public String gIA;
  public String gIB;
  public int gIC;
  public String gID;
  public String gIE;
  public String gIF;
  public String gIG;
  public String gIH;
  public String gII;
  public String gIJ;
  public String gIK;
  public String gIL;
  public String gIM;
  public String gIN;
  public String gIO;
  public int gIP;
  public String gIQ;
  public String gIR;
  public String gIS;
  public int gIT;
  public boolean gIU;
  public int gIV;
  public String gIW;
  public int gIX;
  public String gIY;
  public String gIZ;
  public String gIa;
  public String gIb;
  public int gIc;
  public int gId;
  public int gIe;
  public String gIf;
  public String gIg;
  public String gIh;
  public String gIi;
  public String gIj;
  public int gIk;
  public String gIl;
  public String gIm;
  public String gIn;
  public int gIo;
  public int gIp;
  public String gIq;
  public String gIr;
  public int gIs;
  public int gIt;
  public int gIu;
  public String gIv;
  public String gIw;
  public String gIx;
  public String gIy;
  public String gIz;
  public String gJA;
  public String gJB;
  public String gJC;
  public String gJD;
  public String gJE;
  public String gJF;
  public int gJG;
  public String gJH;
  public int gJI;
  public String gJJ;
  public String gJK;
  public int gJL;
  public String gJM;
  public int gJN;
  public Pair<String, String> gJO;
  public MsgQuoteItem gJP;
  public int gJQ;
  public int gJR;
  public String gJS;
  public int gJT;
  private final HashMap<Class<? extends f>, f> gJU;
  public Map<String, String> gJV;
  private String gJW;
  private String gJX;
  private String gJY;
  public String gJa;
  public List<String> gJb;
  public String gJc;
  public List<String> gJd;
  public String gJe;
  public int gJf;
  public String gJg;
  public String gJh;
  public String gJi;
  public String gJj;
  public String gJk;
  public String gJl;
  public String gJm;
  public String gJn;
  public String gJo;
  public String gJp;
  public String gJq;
  public String gJr;
  public int gJs;
  public String gJt;
  public String gJu;
  public String gJv;
  public int gJw;
  public String gJx;
  public String gJy;
  public String gJz;
  public String iconUrl;
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
    fwL = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(150125);
  }
  
  public k$b()
  {
    AppMethodBeat.i(150108);
    this.gIU = false;
    this.gIV = 0;
    this.gJw = 0;
    this.gJx = "";
    this.gJy = "";
    this.gJz = "";
    this.gJA = "";
    this.gJB = "";
    this.gJC = "";
    this.gJL = k.a.gGZ.ordinal();
    this.gJO = new Pair("", "");
    this.canvasPageXml = "";
    this.gJT = 0;
    this.gJU = new HashMap();
    AppMethodBeat.o(150108);
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
    paramb = paramb.apx();
    AppMethodBeat.o(150119);
    return paramb;
  }
  
  public static String a(b paramb, String paramString, d paramd)
  {
    AppMethodBeat.i(150116);
    ad.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { bt.aGs(paramb.fMw), paramb.filemd5 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msg>");
    if ((paramb.thumbWidth != 0) && (paramb.thumbHeight != 0))
    {
      ad.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[] { Integer.valueOf(paramb.thumbWidth), Integer.valueOf(paramb.thumbHeight) });
      localStringBuilder.append(a(paramb, paramString, paramd, paramb.thumbWidth, paramb.thumbHeight));
    }
    for (;;)
    {
      localStringBuilder.append("</msg>");
      fwL.o(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
      paramb = localStringBuilder.toString();
      AppMethodBeat.o(150116);
      return paramb;
      ad.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
      localStringBuilder.append(a(paramb, paramString, paramd, 0, 0));
    }
  }
  
  public static String a(b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150117);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<appmsg appid=\"" + bt.aGf(paramb.appId) + "\" sdkver=\"" + paramb.sdkVer + "\">");
    paramb.b(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    f localf = k.c.mU(paramb.type);
    if (localf != null) {
      localf.b(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == paramb.dcz) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.gHs).append("</ShakePageResult>");
    }
    ad.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(150117);
    return paramb;
  }
  
  private b apx()
  {
    AppMethodBeat.i(150121);
    b localb = new b();
    if (this == null)
    {
      AppMethodBeat.o(150121);
      return localb;
    }
    ad.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { bt.aGs(this.fMw), this.filemd5, localb.appId });
    localb.action = this.action;
    localb.appId = this.appId;
    localb.appName = this.appName;
    localb.aAS = this.aAS;
    localb.dbA = this.dbA;
    localb.gHe = this.gHe;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.gHh = this.gHh;
    localb.gHf = this.gHf;
    localb.dpv = this.dpv;
    localb.gHd = this.gHd;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.dcz = this.dcz;
    localb.gGx = this.gGx;
    localb.gHC = this.gHC;
    localb.url = this.url;
    localb.gHg = this.gHg;
    localb.dxz = this.dxz;
    localb.dxA = this.dxA;
    localb.eOT = this.eOT;
    localb.thumburl = this.thumburl;
    localb.gHs = this.gHs;
    localb.gHA = this.gHA;
    localb.gHB = this.gHB;
    localb.gHD = this.gHD;
    localb.gHE = this.gHE;
    localb.gHG = this.gHG;
    localb.gHF = this.gHF;
    localb.gHJ = this.gHJ;
    localb.gHK = this.gHK;
    localb.gHM = this.gHM;
    localb.gHL = this.gHL;
    localb.gHH = this.gHH;
    localb.gHI = this.gHI;
    localb.gIj = this.gIj;
    localb.dnn = this.dnn;
    localb.gIq = this.gIq;
    localb.gIr = this.gIr;
    localb.gIs = this.gIs;
    localb.gIt = this.gIs;
    localb.gIl = this.gIl;
    localb.gIo = this.gIo;
    localb.gIk = this.gIk;
    localb.gIm = this.gIm;
    localb.gIn = this.gIn;
    localb.gIC = this.gIC;
    localb.gID = this.gID;
    localb.gIE = this.gIE;
    localb.gHj = this.gHj;
    localb.dxC = this.dxC;
    localb.dxD = this.dxD;
    localb.dxE = this.dxE;
    localb.dxF = this.dxF;
    localb.gJu = this.gJu;
    localb.gJs = this.gJs;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.gJt = this.gJt;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.gJv = this.gJv;
    localb.gJw = this.gJw;
    localb.gJx = this.gJx;
    localb.gJy = this.gJy;
    localb.gJz = this.gJz;
    localb.gJA = this.gJA;
    localb.gJB = this.gJB;
    localb.gJC = this.gJC;
    localb.canvasPageXml = this.canvasPageXml;
    localb.dxG = this.dxG;
    localb.gHt = this.gHt;
    localb.fMw = this.fMw;
    localb.filemd5 = this.filemd5;
    localb.gHi = this.gHi;
    localb.gHb = this.gHb;
    localb.gJD = this.gJD;
    localb.gJE = this.gJE;
    localb.gJG = this.gJG;
    localb.gJH = this.gJH;
    localb.gJQ = this.gJQ;
    localb.gJF = this.gJF;
    localb.gJR = this.gJR;
    localb.gJS = this.gJS;
    localb.gJJ = this.gJJ;
    localb.gJK = this.gJK;
    localb.gJL = this.gJL;
    localb.gJM = this.gJM;
    localb.gJN = this.gJN;
    localb.gJX = this.gJX;
    localb.gJY = this.gJY;
    localb.gJW = this.gJW;
    localb.gJV = this.gJV;
    localb.gHk = this.gHk;
    localb.gHl = this.gHl;
    localb.gHm = this.gHm;
    localb.gHn = this.gHn;
    localb.gHo = this.gHo;
    localb.gHp = this.gHp;
    localb.gHq = this.gHq;
    localb.gHr = this.gHr;
    localb.gJP = this.gJP;
    localb.gJO = this.gJO;
    Iterator localIterator = this.gJU.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).apu();
      if (localf != null) {
        localb.a(localf);
      }
    }
    AppMethodBeat.o(150121);
    return localb;
  }
  
  public static final b ar(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150115);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(150115);
      return null;
    }
    int i = paramString1.indexOf('<');
    if (i > 0) {}
    for (Object localObject2 = paramString1.substring(i);; localObject2 = paramString1)
    {
      i = ((String)localObject2).hashCode();
      Object localObject1 = (b)fwL.get(Integer.valueOf(i));
      if (localObject1 != null)
      {
        AppMethodBeat.o(150115);
        return localObject1;
      }
      long l1 = System.currentTimeMillis();
      if (!bt.isNullOrNil(paramString2)) {}
      for (localObject1 = bj.aFP(paramString2);; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = bw.K((String)localObject2, "msg");
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            ad.e("MicroMsg.AppMessage", "parse msg failed");
            AppMethodBeat.o(150115);
            return null;
          }
          long l2 = System.currentTimeMillis();
          b localb = new b();
          localb.gJV = ((Map)localObject1);
          localb.gJW = paramString1;
          localb.gJX = ((String)localObject2);
          localb.gJY = paramString2;
          try
          {
            localb.a((Map)localObject1, localb);
            paramString1 = k.c.apA().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (f)((com.tencent.mm.co.c)paramString1.next()).get();
              if (localObject2 != null)
              {
                ((f)localObject2).a((Map)localObject1, localb);
                localb.a((f)localObject2);
              }
            }
            paramString1 = k.c.mU(localb.type);
          }
          catch (Exception paramString1)
          {
            ad.e("MicroMsg.AppMessage", "parse amessage xml failed");
            ad.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bt.m(paramString1) });
            AppMethodBeat.o(150115);
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, localb);
            localb.a(paramString1);
          }
          fwL.o(Integer.valueOf(i), localb);
          ad.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(bt.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(150115);
          return localb;
        }
      }
    }
  }
  
  public static final b rw(String paramString)
  {
    AppMethodBeat.i(150111);
    if (bt.isNullOrNil(paramString))
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
    paramString = (b)fwL.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(150111);
      return paramString;
    }
    paramString = bw.K((String)localObject, "msg");
    if (paramString == null)
    {
      ad.e("MicroMsg.AppMessage", "parseImg failed");
      AppMethodBeat.o(150111);
      return null;
    }
    localObject = new b();
    ((b)localObject).type = 2;
    ((b)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((b)localObject).aAS = bt.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((b)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((b)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((b)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((b)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    fwL.o(Integer.valueOf(i), localObject);
    AppMethodBeat.o(150111);
    return localObject;
  }
  
  public static final b rx(String paramString)
  {
    AppMethodBeat.i(150114);
    paramString = ar(paramString, null);
    AppMethodBeat.o(150114);
    return paramString;
  }
  
  public static String ry(String paramString)
  {
    AppMethodBeat.i(150123);
    paramString = "<![CDATA[" + paramString + "]]>";
    AppMethodBeat.o(150123);
    return paramString;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(150110);
    if (paramf == null)
    {
      ad.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
      AppMethodBeat.o(150110);
      return;
    }
    paramf.gGG = this;
    this.gJU.put(paramf.getClass(), paramf);
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
  
  public final void a(Map<String, String> paramMap, b paramb)
  {
    AppMethodBeat.i(150120);
    for (;;)
    {
      try
      {
        this.gHc = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = bt.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = bt.aFR((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = bt.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.gHd = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.gHk = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.gHl = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.gHm = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.gHn = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.gHo = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.gHp = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.gHq = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.gHr = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.gHA = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.gHB = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.gHe = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.dbA = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!bt.isNullOrNil(this.gHk)) {
          this.dbA = this.gHk;
        }
        this.gHf = bt.aFR((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.gHg = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.gJO = new Pair("", paramMap.get(".msg.appmsg.extinfo.solitaire_info"));
        this.gHh = bt.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.dxz = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.dxA = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.eOT = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.aAS = bt.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.dpv = ((String)paramMap.get(".msg.fromusername"));
        this.gHt = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.gHu = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.gHv = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.gHw = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.gHx = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.thumbHeight = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.thumbWidth = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.fMw = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.gHz = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.gHy = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.gHi = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.gHi == 0) && (this.gHe > 26214400))
        {
          this.gHi = 1;
          ad.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.gHe) });
        }
        this.gHD = bt.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.gHE = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.gHG = bt.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.gHF = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.gHL = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.gHM = bt.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.gHH = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.gHI = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.dxC = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.dxD = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.dxE = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.dxF = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.gJs = p.dG((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = bt.aGh((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.gJt = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = bt.by((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = bt.aGh((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.gJv = bt.by((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.gJw = bt.aGh((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.gJx = bt.by((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.gJy = bt.by((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.gJz = bt.by((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.gJA = bt.by((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.gJB = bt.by((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.gJC = bt.by((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = bt.by((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        this.gJE = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.gJD = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.gJF = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.gJR = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.gJG = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.gJQ = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.gJH = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.gJS = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.gJJ = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.gJK = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.gJL = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), k.a.gGZ.ordinal());
        this.gJM = bt.by((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.gJN = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.gJT = bt.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label4122;
          }
          this.dcz = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.dxG = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.gGx = bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.gGx == 5) && (bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.gGx = 0;
          }
          this.gHC = bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.gHN = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.gHO = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (bt.isNullOrNil(this.gHO)) {
            this.gHO = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.gHP = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.gHQ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.gHR = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.gHS = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.gHT = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.gHU = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.gHV = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.gHX = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.gHW = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.gHZ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.gHY = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.gIc = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.gIe = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.gId = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.gIa = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.gIb = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.gIi = ((String)localObject);
          this.gIg = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.gIh = ((String)localObject);
          this.gIf = ((String)localObject);
          this.gIj = bt.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.gIC = bt.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.gID = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.gIE = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = bw.K(paramb.gJX, "msgoperation");
          if ((this != null) && (paramMap != null))
          {
            this.gHb = new a();
            this.gHb.ePc = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.gHb.gJZ = bt.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.gHb.gKa = bt.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.gHb.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.gHb.gKb = bt.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.gHb.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.gHb.gKc = bt.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
          }
          AppMethodBeat.o(150120);
          return;
        }
      }
      catch (Exception paramMap)
      {
        ad.e("MicroMsg.AppMessage", "parse amessage xml failed");
        ad.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bt.m(paramMap) });
        AppMethodBeat.o(150120);
        throw paramMap;
      }
      this.gHJ = bt.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.gHK = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.gIk = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.gIl = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.gIm = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.gIn = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.gIo = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.gIp = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.dvC = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.dem = bt.by((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.gJu = bt.by((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.gIG = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.gIL = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.gIF = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.gIH = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.gII = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.gIK = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.gIJ = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.gIM = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.gIN = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.gIO = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.gIP = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.gIQ = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.gIR = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.gIS = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.gIT = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.gIV = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.gIW = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.gIX = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.gIY = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.gIZ = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.gJa = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.gJb = new ArrayList();
          this.gJb.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.gJc = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.gJd = new ArrayList();
          this.gJd.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.gJe = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.gJf = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.gJg = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.gJh = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.gJi = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.gJj = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.gJk = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.gJl = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.gJm = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.gJn = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.gJo = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.gJp = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.gJq = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.gJr = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.dnn = paramb.gJW;
      this.gIq = "";
      this.gIs = bt.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.gIr = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.gIt = bt.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.gIU = true;
        continue;
        this.gIv = bt.by((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.gIu = p.dG((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.gIw = bt.by((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.gIx = bt.by((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.gIy = bt.by((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.gIz = bt.by((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.gIA = bt.by((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.gIB = bt.by((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        this.gJP = new MsgQuoteItem();
        this.gJP.type = bt.getInt((String)paramMap.get(".msg.appmsg.refermsg.type"), 0);
        this.gJP.tNr = bt.getLong((String)paramMap.get(".msg.appmsg.refermsg.svrid"), 0L);
        this.gJP.tNs = bt.by((String)paramMap.get(".msg.appmsg.refermsg.fromusr"), "");
        this.gJP.tNt = bt.by((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.gJP.tNu = bt.by((String)paramMap.get(".msg.appmsg.refermsg.displayname"), "");
        this.gJP.content = bt.by((String)paramMap.get(".msg.appmsg.refermsg.content"), "");
        this.gJP.tNv = bt.by((String)paramMap.get(".msg.appmsg.refermsg.msgsource"), "");
        continue;
        label4122:
        if (this.type == 2001)
        {
          this.dcz = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.dcz = bt.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.dcz)
          {
          case 1: 
            if (bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = bj.bA(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.gJW.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.gHs = paramb.gJW.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final <T extends f> T ao(Class<T> paramClass)
  {
    AppMethodBeat.i(150109);
    paramClass = (f)this.gJU.get(paramClass);
    AppMethodBeat.o(150109);
    return paramClass;
  }
  
  public final g apw()
  {
    AppMethodBeat.i(150118);
    g localg = new g();
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.fmV;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.gJU.entrySet().iterator();
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
  
  public final boolean apy()
  {
    return (this.gHb != null) && (this.gHb.gKc != 0);
  }
  
  public final boolean apz()
  {
    return (this.gHb != null) && (this.gHb.gJZ == 1);
  }
  
  public final void b(StringBuilder paramStringBuilder, b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150122);
    Iterator localIterator = k.c.apA().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (f)((com.tencent.mm.co.c)localIterator.next()).get();
      if (localObject1 != null)
      {
        localObject2 = paramb.ao(localObject1.getClass());
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((f)localObject1).a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
      }
    }
    paramStringBuilder.append("<title>" + bt.aGf(paramb.title) + "</title>");
    paramStringBuilder.append("<des>" + bt.aGf(paramb.description) + "</des>");
    paramStringBuilder.append("<username>" + bt.aGf(paramb.username) + "</username>");
    Object localObject2 = new StringBuilder("<action>");
    if (bt.isNullOrNil(paramb.action))
    {
      localObject1 = "view";
      paramStringBuilder.append((String)localObject1 + "</action>");
      paramStringBuilder.append("<type>" + paramb.type + "</type>");
      paramStringBuilder.append("<showtype>").append(paramb.dcz).append("</showtype>");
      paramStringBuilder.append("<content>" + bt.aGf(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + bt.aGf(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + bt.aGf(paramb.gHd) + "</lowurl>");
      paramStringBuilder.append("<dataurl>" + bt.aGf(paramb.gHA) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + bt.aGf(paramb.gHB) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.gHj).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(bt.aGf(paramb.gJv)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.gJw).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(bt.aGf(paramb.gJx)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(bt.aGf(paramb.gJy)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(bt.aGf(paramb.gJz)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(bt.aGf(paramb.gJA)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(bt.aGf(paramb.gJB)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(bt.aGf(paramb.gJC)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      default: 
        label796:
        paramStringBuilder.append("<appattach>");
        if ((paramd == null) || ((bt.isNullOrNil(paramString)) && (paramInt1 == 0) && (paramInt2 == 0)))
        {
          paramStringBuilder.append("<totallen>" + paramb.gHe + "</totallen>");
          paramStringBuilder.append("<attachid>" + bt.aGf(paramb.dbA) + "</attachid>");
          paramStringBuilder.append("<cdnattachurl>" + bt.aGf(paramb.gHt) + "</cdnattachurl>");
          paramStringBuilder.append("<emoticonmd5>" + bt.aGf(paramb.gHg) + "</emoticonmd5>");
          paramStringBuilder.append("<aeskey>" + bt.aGf(paramb.fMw) + "</aeskey>");
          if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
            paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
          }
          paramStringBuilder.append("<fileext>" + bt.aGf(paramb.gHf) + "</fileext>");
          paramStringBuilder.append("<islargefilemsg>" + paramb.gHi + "</islargefilemsg>");
          paramStringBuilder.append("</appattach>");
          if (paramb.type != 53) {
            break label4047;
          }
          paramStringBuilder.append("<extinfo>").append((String)paramb.gJO.second).append("</extinfo>");
        }
        break;
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<androidsource>" + paramb.gHh + "</androidsource>");
      if (!bt.isNullOrNil(paramb.dxz))
      {
        paramStringBuilder.append("<sourceusername>" + bt.aGf(paramb.dxz) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + bt.aGf(paramb.dxA) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + bt.aGf(paramb.eOT) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + bt.aGf(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + bt.aGf(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + ry(bt.aGf(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + ry(bt.aGf(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.gHG + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bt.aGf(paramb.gHF) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.gHM + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bt.aGf(paramb.gHL) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.gJs + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.gJt + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + bt.aGf(paramb.dxC) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + bt.aGf(paramb.dxD) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + bt.aGf(paramb.dxE) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + bt.aGf(paramb.dxF) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + bt.aGf(paramb.gIj) + "</template_id>");
      ad.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + bt.aGf(paramb.filemd5) + "</md5>");
      localIterator = k.c.apA().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (f)((com.tencent.mm.co.c)localIterator.next()).get();
        if (localObject1 != null)
        {
          localObject2 = paramb.ao(localObject1.getClass());
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((f)localObject1).b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
        }
      }
      localObject1 = bt.aGf(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.gHD + "\">");
      paramStringBuilder.append("<productinfo>" + bt.aGf(paramb.gHE) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      break label796;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.gHJ + "\">");
      paramStringBuilder.append("<mallproductinfo>" + bt.aGf(paramb.gHK) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      break label796;
      paramStringBuilder.append("<tvinfo>" + bt.aGf(paramb.gHH) + "</tvinfo>");
      break label796;
      paramStringBuilder.append("<recorditem>" + bt.aGf(paramb.gHI) + "</recorditem>");
      break label796;
      paramStringBuilder.append("<carditem>" + paramb.gIq + "</carditem>");
      break label796;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.gIk + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.gIl + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.gIm + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.gIn + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.gIo + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.gJu + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      break label796;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + bt.aGf(paramb.gIG) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + bt.aGf(paramb.gIL) + "</scenetext>");
      paramStringBuilder.append("<url>" + bt.aGf(paramb.gIF) + "</url>");
      paramStringBuilder.append("<receivertitle>" + bt.aGf(paramb.gIH) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + bt.aGf(paramb.gII) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + bt.aGf(paramb.gIK) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + bt.aGf(paramb.gIJ) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + bt.aGf(paramb.gIM) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + bt.aGf(paramb.gIN) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + bt.aGf(paramb.gIO) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + bt.aGf(new StringBuilder().append(paramb.dcz).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + bt.aGf(new StringBuilder().append(paramb.gIP).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + bt.aGf(paramb.gIQ) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + bt.aGf(paramb.gIR) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + bt.aGf(paramb.gIS) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + bt.aGf(new StringBuilder().append(paramb.gIT).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + bt.aGf(new StringBuilder().append(paramb.gIV).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
      break label796;
      paramStringBuilder.append("<refermsg>");
      if (paramb.gJP != null)
      {
        paramStringBuilder.append("<type>").append(paramb.gJP.type).append("</type>");
        paramStringBuilder.append("<svrid>").append(paramb.gJP.tNr).append("</svrid>");
        paramStringBuilder.append("<fromusr>").append(paramb.gJP.tNs).append("</fromusr>");
        paramStringBuilder.append("<chatusr>").append(paramb.gJP.tNt).append("</chatusr>");
        paramStringBuilder.append("<displayname>").append(paramb.gJP.tNu).append("</displayname>");
        paramStringBuilder.append("<msgsource>").append(bt.aGf(paramb.gJP.tNv)).append("</msgsource>");
        paramStringBuilder.append("<content>").append(bt.aGf(paramb.gJP.content)).append("</content>");
      }
      paramStringBuilder.append("</refermsg>");
      break label796;
      paramStringBuilder.append("<attachid>" + bt.aGf(paramString) + "</attachid>");
      if ((paramd.field_fileLength > 0L) && (!bt.isNullOrNil(paramd.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + bt.aGf(paramd.field_fileId) + "</cdnattachurl>");
        if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
          break label4010;
        }
        paramStringBuilder.append("<totallen>" + paramd.field_fileLength + "</totallen>");
      }
      for (;;)
      {
        if (paramd.field_thumbimgLength > 0)
        {
          paramStringBuilder.append("<cdnthumburl>" + bt.aGf(paramd.field_fileId) + "</cdnthumburl>");
          if (!bt.isNullOrNil(paramd.field_thumbfilemd5)) {
            paramStringBuilder.append("<cdnthumbmd5>" + paramd.field_thumbfilemd5 + "</cdnthumbmd5>");
          }
          paramStringBuilder.append("<cdnthumblength>" + paramd.field_thumbimgLength + "</cdnthumblength>");
          paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
          paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
          paramStringBuilder.append("<cdnthumbaeskey>" + paramd.field_aesKey + "</cdnthumbaeskey>");
        }
        paramStringBuilder.append("<aeskey>" + bt.aGf(paramd.field_aesKey) + "</aeskey>");
        paramStringBuilder.append("<encryver>1</encryver>");
        break;
        label4010:
        ad.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Long.valueOf(paramd.field_fileLength) });
      }
      label4047:
      paramStringBuilder.append("<extinfo>" + bt.aGf(paramb.extInfo) + "</extinfo>");
    }
    AppMethodBeat.o(150122);
  }
  
  public final boolean dY(boolean paramBoolean)
  {
    AppMethodBeat.i(150113);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.gJL >= k.a.gGX.ordinal()) && (this.gJL < k.a.gGZ.ordinal()))
      {
        AppMethodBeat.o(150113);
        return true;
      }
    }
    else if ((this.gJL >= k.a.gGX.ordinal()) && (this.gJL < k.a.gGZ.ordinal()))
    {
      AppMethodBeat.o(150113);
      return true;
    }
    AppMethodBeat.o(150113);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.gHb != null) && (this.gHb.gKb != 0)) {
      return this.gHb.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.gHb != null) && (this.gHb.gKa != 0)) {
      return this.gHb.title;
    }
    return this.title;
  }
  
  public final String r(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150112);
    String str = "";
    if (dY(true))
    {
      if (bt.isNullOrNil(this.gJM)) {
        break label178;
      }
      int i = paramContext.getResources().getIdentifier(this.gJM, "string", paramContext.getPackageName());
      ad.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(i) });
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
      ad.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { paramContext });
      AppMethodBeat.o(150112);
      return paramContext;
      label149:
      if (k.a.gGX.ordinal() == this.gJL)
      {
        str = "";
      }
      else
      {
        str = this.dxA;
        continue;
        label178:
        if (k.a.gGX.ordinal() == this.gJL) {
          str = "";
        } else {
          str = this.dxA;
        }
      }
    }
  }
  
  public static final class a
  {
    public String desc;
    public String ePc;
    public int gJZ;
    public int gKa;
    public int gKb;
    public int gKc;
    public int gKd = 0;
    public int gKe = 0;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.k.b
 * JD-Core Version:    0.7.0.1
 */