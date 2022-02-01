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
  private static final com.tencent.mm.b.f<Integer, b> fTI;
  public int aDD;
  public String action;
  public String appId;
  public String appName;
  public String canvasPageXml;
  public String content;
  public int dFq;
  public String dHo;
  public String dHp;
  public String dHr;
  public String dHs;
  public String dHt;
  public String dHu;
  public String dHv;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String dks;
  public int dlp;
  public String dne;
  public String dwI;
  public String dyU;
  public String extInfo;
  public String filemd5;
  public String fkq;
  public String gjI;
  public String hAA;
  public String hAB;
  public String hAC;
  public String hAD;
  public String hAE;
  public String hAF;
  public String hAG;
  public String hAH;
  public String hAI;
  public String hAJ;
  public String hAK;
  public String hAL;
  public int hAM;
  public int hAN;
  public int hAO;
  public String hAP;
  public String hAQ;
  public String hAR;
  public String hAS;
  public String hAT;
  public int hAU;
  public String hAV;
  public String hAW;
  public String hAX;
  public int hAY;
  public int hAZ;
  public String hAa;
  public String hAb;
  public String hAc;
  public String hAd;
  public String hAe;
  public int hAf;
  public int hAg;
  public int hAh;
  public String hAi;
  public int hAj;
  public String hAk;
  public String hAl;
  public int hAm;
  public int hAn;
  public String hAo;
  public String hAp;
  public int hAq;
  public String hAr;
  public String hAs;
  public int hAt;
  public String hAu;
  public String hAv;
  public int hAw;
  public String hAx;
  public String hAy;
  public String hAz;
  public String hBA;
  public String hBB;
  public int hBC;
  public boolean hBD;
  public int hBE;
  public String hBF;
  public int hBG;
  public String hBH;
  public String hBI;
  public String hBJ;
  public List<String> hBK;
  public String hBL;
  public List<String> hBM;
  public String hBN;
  public int hBO;
  public String hBP;
  public String hBQ;
  public String hBR;
  public String hBS;
  public String hBT;
  public String hBU;
  public String hBV;
  public String hBW;
  public String hBX;
  public String hBY;
  public String hBZ;
  public String hBa;
  public String hBb;
  public int hBc;
  public int hBd;
  public int hBe;
  public String hBf;
  public String hBg;
  public String hBh;
  public String hBi;
  public String hBj;
  public String hBk;
  public int hBl;
  public String hBm;
  public String hBn;
  public String hBo;
  public String hBp;
  public String hBq;
  public String hBr;
  public String hBs;
  public String hBt;
  public String hBu;
  public String hBv;
  public String hBw;
  public String hBx;
  public int hBy;
  public String hBz;
  public int hCA;
  public String hCB;
  public int hCC;
  private final HashMap<Class<? extends f>, f> hCD;
  public Map<String, String> hCE;
  private String hCF;
  private String hCG;
  private String hCH;
  public String hCa;
  public int hCb;
  public String hCc;
  public String hCd;
  public String hCe;
  public int hCf;
  public String hCg;
  public String hCh;
  public String hCi;
  public String hCj;
  public String hCk;
  public String hCl;
  public String hCm;
  public String hCn;
  public String hCo;
  public int hCp;
  public String hCq;
  public int hCr;
  public String hCs;
  public String hCt;
  public int hCu;
  public String hCv;
  public int hCw;
  public Pair<String, String> hCx;
  public MsgQuoteItem hCy;
  public int hCz;
  public a hzL;
  public Map<String, String> hzM;
  public String hzN;
  public int hzO;
  public String hzP;
  public String hzQ;
  public int hzR;
  public int hzS;
  public int hzT;
  public String hzU;
  public String hzV;
  public int hzW;
  public int hzX;
  public int hzY;
  public String hzZ;
  public int hzh;
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
  public String titleColor;
  public int type;
  public String url;
  public String username;
  
  static
  {
    AppMethodBeat.i(150125);
    fTI = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(150125);
  }
  
  public k$b()
  {
    AppMethodBeat.i(150108);
    this.hBD = false;
    this.hBE = 0;
    this.hCf = 0;
    this.hCg = "";
    this.hCh = "";
    this.hCi = "";
    this.hCj = "";
    this.hCk = "";
    this.hCl = "";
    this.hCu = k.a.hzJ.ordinal();
    this.hCx = new Pair("", "");
    this.canvasPageXml = "";
    this.hCC = 0;
    this.hCD = new HashMap();
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
    paramb = paramb.aza();
    AppMethodBeat.o(150119);
    return paramb;
  }
  
  public static String a(b paramb, String paramString, d paramd)
  {
    AppMethodBeat.i(150116);
    ad.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { bt.aRp(paramb.gjI), paramb.filemd5 });
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
      fTI.q(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
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
    localStringBuilder.append("<appmsg appid=\"" + bt.aRc(paramb.appId) + "\" sdkver=\"" + paramb.sdkVer + "\">");
    paramb.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    f localf = k.c.oh(paramb.type);
    if (localf != null) {
      localf.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == paramb.dlp) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.hAc).append("</ShakePageResult>");
    }
    ad.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(150117);
    return paramb;
  }
  
  public static final b aA(String paramString1, String paramString2)
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
      Object localObject1 = (b)fTI.get(Integer.valueOf(i));
      if (localObject1 != null)
      {
        AppMethodBeat.o(150115);
        return localObject1;
      }
      long l1 = System.currentTimeMillis();
      if (!bt.isNullOrNil(paramString2)) {}
      for (localObject1 = bj.aQM(paramString2);; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = bw.M((String)localObject2, "msg");
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
          localb.hCE = ((Map)localObject1);
          localb.hCF = paramString1;
          localb.hCG = ((String)localObject2);
          localb.hCH = paramString2;
          try
          {
            localb.a((Map)localObject1, localb);
            paramString1 = k.c.access$000().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (f)((com.tencent.mm.cn.c)paramString1.next()).get();
              if (localObject2 != null)
              {
                ((f)localObject2).a((Map)localObject1, localb);
                localb.a((f)localObject2);
              }
            }
            paramString1 = k.c.oh(localb.type);
          }
          catch (Exception paramString1)
          {
            ad.e("MicroMsg.AppMessage", "parse amessage xml failed");
            ad.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bt.n(paramString1) });
            AppMethodBeat.o(150115);
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, localb);
            localb.a(paramString1);
          }
          fTI.q(Integer.valueOf(i), localb);
          ad.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(bt.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(150115);
          return localb;
        }
      }
    }
  }
  
  private b aza()
  {
    AppMethodBeat.i(150121);
    b localb = new b();
    if (this == null)
    {
      AppMethodBeat.o(150121);
      return localb;
    }
    ad.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { bt.aRp(this.gjI), this.filemd5, localb.appId });
    localb.action = this.action;
    localb.appId = this.appId;
    localb.appName = this.appName;
    localb.aDD = this.aDD;
    localb.dks = this.dks;
    localb.hzO = this.hzO;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.hzR = this.hzR;
    localb.hzP = this.hzP;
    localb.dyU = this.dyU;
    localb.hzN = this.hzN;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.dlp = this.dlp;
    localb.hzh = this.hzh;
    localb.hAm = this.hAm;
    localb.url = this.url;
    localb.hzQ = this.hzQ;
    localb.dHo = this.dHo;
    localb.dHp = this.dHp;
    localb.fkq = this.fkq;
    localb.thumburl = this.thumburl;
    localb.hAc = this.hAc;
    localb.hAk = this.hAk;
    localb.hAl = this.hAl;
    localb.hAn = this.hAn;
    localb.hAo = this.hAo;
    localb.hAq = this.hAq;
    localb.hAp = this.hAp;
    localb.hAt = this.hAt;
    localb.hAu = this.hAu;
    localb.hAw = this.hAw;
    localb.hAv = this.hAv;
    localb.hAr = this.hAr;
    localb.hAs = this.hAs;
    localb.hAT = this.hAT;
    localb.dwI = this.dwI;
    localb.hBa = this.hBa;
    localb.hBb = this.hBb;
    localb.hBc = this.hBc;
    localb.hBd = this.hBc;
    localb.hAV = this.hAV;
    localb.hAY = this.hAY;
    localb.hAU = this.hAU;
    localb.hAW = this.hAW;
    localb.hAX = this.hAX;
    localb.hBl = this.hBl;
    localb.hBm = this.hBm;
    localb.hBn = this.hBn;
    localb.hzT = this.hzT;
    localb.dHr = this.dHr;
    localb.dHs = this.dHs;
    localb.dHt = this.dHt;
    localb.dHu = this.dHu;
    localb.hCd = this.hCd;
    localb.hCb = this.hCb;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.hCc = this.hCc;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.hCe = this.hCe;
    localb.hCf = this.hCf;
    localb.hCg = this.hCg;
    localb.hCh = this.hCh;
    localb.hCi = this.hCi;
    localb.hCj = this.hCj;
    localb.hCk = this.hCk;
    localb.hCl = this.hCl;
    localb.canvasPageXml = this.canvasPageXml;
    localb.dHv = this.dHv;
    localb.hAd = this.hAd;
    localb.gjI = this.gjI;
    localb.filemd5 = this.filemd5;
    localb.hzS = this.hzS;
    localb.hzL = this.hzL;
    localb.hCm = this.hCm;
    localb.hCn = this.hCn;
    localb.hCp = this.hCp;
    localb.hCq = this.hCq;
    localb.hCz = this.hCz;
    localb.hCo = this.hCo;
    localb.hCA = this.hCA;
    localb.hCB = this.hCB;
    localb.hCs = this.hCs;
    localb.hCt = this.hCt;
    localb.hCu = this.hCu;
    localb.hCv = this.hCv;
    localb.hCw = this.hCw;
    localb.hCG = this.hCG;
    localb.hCH = this.hCH;
    localb.hCF = this.hCF;
    localb.hCE = this.hCE;
    localb.hzU = this.hzU;
    localb.hzV = this.hzV;
    localb.hzW = this.hzW;
    localb.hzX = this.hzX;
    localb.hzY = this.hzY;
    localb.hzZ = this.hzZ;
    localb.hAa = this.hAa;
    localb.hAb = this.hAb;
    localb.hCy = this.hCy;
    localb.hCx = this.hCx;
    Iterator localIterator = this.hCD.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).aot();
      if (localf != null) {
        localb.a(localf);
      }
    }
    AppMethodBeat.o(150121);
    return localb;
  }
  
  public static final b yq(String paramString)
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
    paramString = (b)fTI.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(150111);
      return paramString;
    }
    paramString = bw.M((String)localObject, "msg");
    if (paramString == null)
    {
      ad.e("MicroMsg.AppMessage", "parseImg failed");
      AppMethodBeat.o(150111);
      return null;
    }
    localObject = new b();
    ((b)localObject).type = 2;
    ((b)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((b)localObject).aDD = bt.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((b)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((b)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((b)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((b)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    fTI.q(Integer.valueOf(i), localObject);
    AppMethodBeat.o(150111);
    return localObject;
  }
  
  public static final b yr(String paramString)
  {
    AppMethodBeat.i(150114);
    paramString = aA(paramString, null);
    AppMethodBeat.o(150114);
    return paramString;
  }
  
  public static String ys(String paramString)
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
    paramf.hzq = this;
    this.hCD.put(paramf.getClass(), paramf);
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
      localObject1 = (f)((com.tencent.mm.cn.c)localIterator.next()).get();
      if (localObject1 != null)
      {
        localObject2 = paramb.ao(localObject1.getClass());
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((f)localObject1).b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
      }
    }
    paramStringBuilder.append("<title>" + bt.aRc(paramb.title) + "</title>");
    paramStringBuilder.append("<des>" + bt.aRc(paramb.description) + "</des>");
    paramStringBuilder.append("<username>" + bt.aRc(paramb.username) + "</username>");
    Object localObject2 = new StringBuilder("<action>");
    if (bt.isNullOrNil(paramb.action))
    {
      localObject1 = "view";
      paramStringBuilder.append((String)localObject1 + "</action>");
      paramStringBuilder.append("<type>" + paramb.type + "</type>");
      paramStringBuilder.append("<showtype>").append(paramb.dlp).append("</showtype>");
      paramStringBuilder.append("<content>" + bt.aRc(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + bt.aRc(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + bt.aRc(paramb.hzN) + "</lowurl>");
      paramStringBuilder.append("<dataurl>" + bt.aRc(paramb.hAk) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + bt.aRc(paramb.hAl) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.hzT).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(bt.aRc(paramb.hCe)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.hCf).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(bt.aRc(paramb.hCg)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(bt.aRc(paramb.hCh)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(bt.aRc(paramb.hCi)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(bt.aRc(paramb.hCj)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(bt.aRc(paramb.hCk)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(bt.aRc(paramb.hCl)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      default: 
        label796:
        paramStringBuilder.append("<appattach>");
        if ((paramd == null) || ((bt.isNullOrNil(paramString)) && (paramInt1 == 0) && (paramInt2 == 0)))
        {
          paramStringBuilder.append("<totallen>" + paramb.hzO + "</totallen>");
          paramStringBuilder.append("<attachid>" + bt.aRc(paramb.dks) + "</attachid>");
          paramStringBuilder.append("<cdnattachurl>" + bt.aRc(paramb.hAd) + "</cdnattachurl>");
          paramStringBuilder.append("<emoticonmd5>" + bt.aRc(paramb.hzQ) + "</emoticonmd5>");
          paramStringBuilder.append("<aeskey>" + bt.aRc(paramb.gjI) + "</aeskey>");
          if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
            paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
          }
          paramStringBuilder.append("<fileext>" + bt.aRc(paramb.hzP) + "</fileext>");
          paramStringBuilder.append("<islargefilemsg>" + paramb.hzS + "</islargefilemsg>");
          paramStringBuilder.append("</appattach>");
          if (paramb.type != 53) {
            break label4047;
          }
          paramStringBuilder.append("<extinfo>").append((String)paramb.hCx.second).append("</extinfo>");
        }
        break;
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<androidsource>" + paramb.hzR + "</androidsource>");
      if (!bt.isNullOrNil(paramb.dHo))
      {
        paramStringBuilder.append("<sourceusername>" + bt.aRc(paramb.dHo) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + bt.aRc(paramb.dHp) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + bt.aRc(paramb.fkq) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + bt.aRc(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + bt.aRc(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + ys(bt.aRc(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + ys(bt.aRc(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.hAq + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bt.aRc(paramb.hAp) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.hAw + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bt.aRc(paramb.hAv) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.hCb + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.hCc + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + bt.aRc(paramb.dHr) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + bt.aRc(paramb.dHs) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + bt.aRc(paramb.dHt) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + bt.aRc(paramb.dHu) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + bt.aRc(paramb.hAT) + "</template_id>");
      ad.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + bt.aRc(paramb.filemd5) + "</md5>");
      localIterator = k.c.access$000().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (f)((com.tencent.mm.cn.c)localIterator.next()).get();
        if (localObject1 != null)
        {
          localObject2 = paramb.ao(localObject1.getClass());
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((f)localObject1).a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
        }
      }
      localObject1 = bt.aRc(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.hAn + "\">");
      paramStringBuilder.append("<productinfo>" + bt.aRc(paramb.hAo) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      break label796;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.hAt + "\">");
      paramStringBuilder.append("<mallproductinfo>" + bt.aRc(paramb.hAu) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      break label796;
      paramStringBuilder.append("<tvinfo>" + bt.aRc(paramb.hAr) + "</tvinfo>");
      break label796;
      paramStringBuilder.append("<recorditem>" + bt.aRc(paramb.hAs) + "</recorditem>");
      break label796;
      paramStringBuilder.append("<carditem>" + paramb.hBa + "</carditem>");
      break label796;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.hAU + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.hAV + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.hAW + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.hAX + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.hAY + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.hCd + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      break label796;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + bt.aRc(paramb.hBp) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + bt.aRc(paramb.hBu) + "</scenetext>");
      paramStringBuilder.append("<url>" + bt.aRc(paramb.hBo) + "</url>");
      paramStringBuilder.append("<receivertitle>" + bt.aRc(paramb.hBq) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + bt.aRc(paramb.hBr) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + bt.aRc(paramb.hBt) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + bt.aRc(paramb.hBs) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + bt.aRc(paramb.hBv) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + bt.aRc(paramb.hBw) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + bt.aRc(paramb.hBx) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + bt.aRc(new StringBuilder().append(paramb.dlp).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + bt.aRc(new StringBuilder().append(paramb.hBy).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + bt.aRc(paramb.hBz) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + bt.aRc(paramb.hBA) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + bt.aRc(paramb.hBB) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + bt.aRc(new StringBuilder().append(paramb.hBC).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + bt.aRc(new StringBuilder().append(paramb.hBE).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
      break label796;
      paramStringBuilder.append("<refermsg>");
      if (paramb.hCy != null)
      {
        paramStringBuilder.append("<type>").append(paramb.hCy.type).append("</type>");
        paramStringBuilder.append("<svrid>").append(paramb.hCy.vZc).append("</svrid>");
        paramStringBuilder.append("<fromusr>").append(paramb.hCy.vZd).append("</fromusr>");
        paramStringBuilder.append("<chatusr>").append(paramb.hCy.vZe).append("</chatusr>");
        paramStringBuilder.append("<displayname>").append(paramb.hCy.vZf).append("</displayname>");
        paramStringBuilder.append("<msgsource>").append(bt.aRc(paramb.hCy.vZg)).append("</msgsource>");
        paramStringBuilder.append("<content>").append(bt.aRc(paramb.hCy.content)).append("</content>");
      }
      paramStringBuilder.append("</refermsg>");
      break label796;
      paramStringBuilder.append("<attachid>" + bt.aRc(paramString) + "</attachid>");
      if ((paramd.field_fileLength > 0L) && (!bt.isNullOrNil(paramd.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + bt.aRc(paramd.field_fileId) + "</cdnattachurl>");
        if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
          break label4010;
        }
        paramStringBuilder.append("<totallen>" + paramd.field_fileLength + "</totallen>");
      }
      for (;;)
      {
        if (paramd.field_thumbimgLength > 0)
        {
          paramStringBuilder.append("<cdnthumburl>" + bt.aRc(paramd.field_fileId) + "</cdnthumburl>");
          if (!bt.isNullOrNil(paramd.field_thumbfilemd5)) {
            paramStringBuilder.append("<cdnthumbmd5>" + paramd.field_thumbfilemd5 + "</cdnthumbmd5>");
          }
          paramStringBuilder.append("<cdnthumblength>" + paramd.field_thumbimgLength + "</cdnthumblength>");
          paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
          paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
          paramStringBuilder.append("<cdnthumbaeskey>" + paramd.field_aesKey + "</cdnthumbaeskey>");
        }
        paramStringBuilder.append("<aeskey>" + bt.aRc(paramd.field_aesKey) + "</aeskey>");
        paramStringBuilder.append("<encryver>1</encryver>");
        break;
        label4010:
        ad.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Long.valueOf(paramd.field_fileLength) });
      }
      label4047:
      paramStringBuilder.append("<extinfo>" + bt.aRc(paramb.extInfo) + "</extinfo>");
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
        this.hzM = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = bt.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = bt.aQO((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = bt.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.hzN = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.hzU = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.hzV = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.hzW = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.hzX = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.hzY = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.hzZ = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.hAa = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.hAb = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.hAk = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.hAl = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.hzO = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.dks = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!bt.isNullOrNil(this.hzU)) {
          this.dks = this.hzU;
        }
        this.hzP = bt.aQO((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.hzQ = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.hCx = new Pair("", paramMap.get(".msg.appmsg.extinfo.solitaire_info"));
        this.hzR = bt.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.dHo = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.dHp = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.fkq = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.aDD = bt.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.dyU = ((String)paramMap.get(".msg.fromusername"));
        this.hAd = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.hAe = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.hAf = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.hAg = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.hAh = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.thumbHeight = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.thumbWidth = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.gjI = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.hAj = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.hAi = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.hzS = bt.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.hzS == 0) && (this.hzO > 26214400))
        {
          this.hzS = 1;
          ad.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.hzO) });
        }
        this.hAn = bt.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.hAo = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.hAq = bt.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.hAp = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.hAv = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.hAw = bt.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.hAr = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.hAs = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.dHr = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.dHs = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.dHt = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.dHu = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.hCb = p.er((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = bt.aRe((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.hCc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = bt.bI((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = bt.aRe((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.hCe = bt.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.hCf = bt.aRe((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.hCg = bt.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.hCh = bt.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.hCi = bt.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.hCj = bt.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.hCk = bt.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.hCl = bt.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = bt.bI((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        this.hCn = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.hCm = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.hCo = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.hCA = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.hCp = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.hCz = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.hCq = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.hCB = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.hCs = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.hCt = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.hCu = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), k.a.hzJ.ordinal());
        this.hCv = bt.bI((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.hCw = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.hCC = bt.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label4122;
          }
          this.dlp = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.dHv = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.hzh = bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.hzh == 5) && (bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.hzh = 0;
          }
          this.hAm = bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.hAx = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.hAy = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (bt.isNullOrNil(this.hAy)) {
            this.hAy = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.hAz = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.hAA = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.hAB = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.hAC = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.hAD = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.hAE = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.hAF = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.hAH = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.hAG = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.hAJ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.hAI = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.hAM = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.hAO = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.hAN = bt.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.hAK = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.hAL = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.hAS = ((String)localObject);
          this.hAQ = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.hAR = ((String)localObject);
          this.hAP = ((String)localObject);
          this.hAT = bt.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.hBl = bt.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.hBm = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.hBn = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = bw.M(paramb.hCG, "msgoperation");
          if ((this != null) && (paramMap != null))
          {
            this.hzL = new a();
            this.hzL.fkz = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.hzL.hCI = bt.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.hzL.hCJ = bt.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.hzL.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.hzL.hCK = bt.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.hzL.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.hzL.hCL = bt.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
          }
          AppMethodBeat.o(150120);
          return;
        }
      }
      catch (Exception paramMap)
      {
        ad.e("MicroMsg.AppMessage", "parse amessage xml failed");
        ad.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bt.n(paramMap) });
        AppMethodBeat.o(150120);
        throw paramMap;
      }
      this.hAt = bt.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.hAu = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.hAU = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.hAV = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.hAW = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.hAX = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.hAY = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.hAZ = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.dFq = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.dne = bt.bI((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.hCd = bt.bI((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.hBp = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.hBu = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.hBo = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.hBq = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.hBr = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.hBt = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.hBs = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.hBv = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.hBw = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.hBx = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.hBy = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.hBz = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.hBA = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.hBB = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.hBC = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.hBE = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.hBF = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.hBG = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.hBH = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.hBI = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.hBJ = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hBK = new ArrayList();
          this.hBK.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.hBL = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hBM = new ArrayList();
          this.hBM.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.hBN = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.hBO = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.hBP = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.hBQ = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.hBR = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.hBS = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.hBT = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.hBU = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.hBV = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.hBW = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.hBX = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.hBY = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.hBZ = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.hCa = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.dwI = paramb.hCF;
      this.hBa = "";
      this.hBc = bt.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.hBb = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.hBd = bt.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.hBD = true;
        continue;
        this.hBf = bt.bI((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.hBe = p.er((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.hBg = bt.bI((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.hBh = bt.bI((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.hBi = bt.bI((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.hBj = bt.bI((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.titleColor = bt.bI((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.hBk = bt.bI((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        this.hCy = new MsgQuoteItem();
        this.hCy.type = bt.getInt((String)paramMap.get(".msg.appmsg.refermsg.type"), 0);
        this.hCy.vZc = bt.getLong((String)paramMap.get(".msg.appmsg.refermsg.svrid"), 0L);
        this.hCy.vZd = bt.bI((String)paramMap.get(".msg.appmsg.refermsg.fromusr"), "");
        this.hCy.vZe = bt.bI((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.hCy.vZf = bt.bI((String)paramMap.get(".msg.appmsg.refermsg.displayname"), "");
        this.hCy.content = bt.bI((String)paramMap.get(".msg.appmsg.refermsg.content"), "");
        this.hCy.vZg = bt.bI((String)paramMap.get(".msg.appmsg.refermsg.msgsource"), "");
        continue;
        label4122:
        if (this.type == 2001)
        {
          this.dlp = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.dlp = bt.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.dlp)
          {
          case 1: 
            if (bt.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = bj.bI(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.hCF.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.hAc = paramb.hCF.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final <T extends f> T ao(Class<T> paramClass)
  {
    AppMethodBeat.i(150109);
    paramClass = (f)this.hCD.get(paramClass);
    AppMethodBeat.o(150109);
    return paramClass;
  }
  
  public final g ayZ()
  {
    AppMethodBeat.i(150118);
    g localg = new g();
    localg.fJi = "task_AppMessage";
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.fIw;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.hCD.entrySet().iterator();
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
  
  public final boolean azb()
  {
    return (this.hzL != null) && (this.hzL.hCL != 0);
  }
  
  public final boolean azc()
  {
    return (this.hzL != null) && (this.hzL.hCI == 1);
  }
  
  public final boolean ev(boolean paramBoolean)
  {
    AppMethodBeat.i(150113);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.hCu >= k.a.hzH.ordinal()) && (this.hCu < k.a.hzJ.ordinal()))
      {
        AppMethodBeat.o(150113);
        return true;
      }
    }
    else if ((this.hCu >= k.a.hzH.ordinal()) && (this.hCu < k.a.hzJ.ordinal()))
    {
      AppMethodBeat.o(150113);
      return true;
    }
    AppMethodBeat.o(150113);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.hzL != null) && (this.hzL.hCK != 0)) {
      return this.hzL.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.hzL != null) && (this.hzL.hCJ != 0)) {
      return this.hzL.title;
    }
    return this.title;
  }
  
  public final String t(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150112);
    String str = "";
    if (ev(true))
    {
      if (bt.isNullOrNil(this.hCv)) {
        break label178;
      }
      int i = paramContext.getResources().getIdentifier(this.hCv, "string", paramContext.getPackageName());
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
      if (k.a.hzH.ordinal() == this.hCu)
      {
        str = "";
      }
      else
      {
        str = this.dHp;
        continue;
        label178:
        if (k.a.hzH.ordinal() == this.hCu) {
          str = "";
        } else {
          str = this.dHp;
        }
      }
    }
  }
  
  public static final class a
  {
    public String desc;
    public String fkz;
    public int hCI;
    public int hCJ;
    public int hCK;
    public int hCL;
    public int hCM = 0;
    public int hCN = 0;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.k.b
 * JD-Core Version:    0.7.0.1
 */