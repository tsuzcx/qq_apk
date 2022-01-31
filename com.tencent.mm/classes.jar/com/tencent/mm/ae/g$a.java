package com.tencent.mm.ae;

import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.ck.c;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g$a
  extends d
{
  private static final f<Integer, a> dss = new f(100);
  public String action;
  public String appId;
  public String appName;
  public String bFE;
  public String bHY;
  public String bQr;
  public String bRO;
  public int bXd;
  public String bYG;
  public String bYH;
  public String bYJ;
  public String bYK;
  public String bYL;
  public String bYM;
  public String bYN;
  public String cQF;
  public String canvasPageXml = "";
  public int cau;
  public String color;
  public String content;
  public int dQA;
  public String dQB;
  public String dQC;
  public int dQD;
  public int dQE;
  public int dQF;
  public String dQG;
  public String dQH;
  public String dQI;
  public String dQJ;
  public String dQK;
  public String dQL;
  public int dQM;
  public int dQN;
  public int dQO;
  public int dQP;
  public int dQQ;
  public String dQR;
  public String dQS;
  public int dQT;
  public String dQU;
  public String dQV;
  public int dQW;
  public int dQX;
  public int dQY;
  public String dQZ;
  public g.a.a dQs;
  public Map<String, String> dQt;
  public String dQu;
  public int dQv;
  public String dQw;
  public String dQx;
  public int dQy;
  public int dQz;
  public String dRA;
  public String dRB;
  public String dRC;
  public String dRD;
  public int dRE;
  public String dRF;
  public String dRG;
  public String dRH;
  public int dRI;
  public int dRJ;
  public String dRK;
  public String dRL;
  public int dRM;
  public int dRN;
  public int dRO;
  public String dRP;
  public String dRQ;
  public String dRR;
  public String dRS;
  public String dRT;
  public String dRU;
  public String dRV;
  public int dRW;
  public String dRX;
  public String dRY;
  public String dRZ;
  public String dRa;
  public int dRb;
  public String dRc;
  public String dRd;
  public int dRe;
  public String dRf;
  public String dRg;
  public int dRh;
  public String dRi;
  public String dRj;
  public String dRk;
  public String dRl;
  public String dRm;
  public String dRn;
  public String dRo;
  public String dRp;
  public String dRq;
  public String dRr;
  public String dRs;
  public String dRt;
  public String dRu;
  public String dRv;
  public int dRw;
  public int dRx;
  public int dRy;
  public String dRz;
  public String dSA;
  public String dSB;
  public String dSC;
  public String dSD;
  public String dSE;
  public String dSF;
  public String dSG;
  public String dSH;
  public String dSI;
  public String dSJ;
  public String dSK;
  public String dSL;
  public int dSM;
  public String dSN;
  public String dSO;
  public String dSP;
  public int dSQ = 0;
  public String dSR = "";
  public String dSS = "";
  public String dST = "";
  public String dSU = "";
  public String dSV = "";
  public String dSW = "";
  public String dSX;
  public String dSY;
  public String dSZ;
  public String dSa;
  public String dSb;
  public String dSc;
  public String dSd;
  public String dSe;
  public String dSf;
  public String dSg;
  public String dSh;
  public String dSi;
  public int dSj;
  public String dSk;
  public String dSl;
  public String dSm;
  public int dSn;
  public boolean dSo = false;
  public int dSp = 0;
  public String dSq;
  public int dSr;
  public String dSs;
  public String dSt;
  public String dSu;
  public List<String> dSv;
  public String dSw;
  public List<String> dSx;
  public String dSy;
  public int dSz;
  public int dTa;
  public String dTb;
  public int dTc;
  public String dTd;
  public String dTe;
  public int dTf;
  public int dTg;
  public String dTh;
  public String dTi = null;
  public int dTj = 0;
  private final HashMap<Class<? extends d>, d> dTk = new HashMap();
  public Map<String, String> dTl;
  private String dTm;
  private String dTn;
  private String dTo;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String extInfo;
  public String filemd5;
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
  
  private a Fm()
  {
    a locala = new a();
    if (this == null) {
      return locala;
    }
    y.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { bk.aac(this.dQR), this.filemd5, locala.appId });
    locala.action = this.action;
    locala.appId = this.appId;
    locala.appName = this.appName;
    locala.cau = this.cau;
    locala.bFE = this.bFE;
    locala.dQv = this.dQv;
    locala.content = this.content;
    locala.description = this.description;
    locala.username = this.username;
    locala.extInfo = this.extInfo;
    locala.mediaTagName = this.mediaTagName;
    locala.messageAction = this.messageAction;
    locala.messageExt = this.messageExt;
    locala.dQy = this.dQy;
    locala.dQw = this.dQw;
    locala.bRO = this.bRO;
    locala.dQu = this.dQu;
    locala.sdkVer = this.sdkVer;
    locala.title = this.title;
    locala.type = this.type;
    locala.showType = this.showType;
    locala.dQW = this.dQW;
    locala.dQX = this.dQX;
    locala.url = this.url;
    locala.dQx = this.dQx;
    locala.bYG = this.bYG;
    locala.bYH = this.bYH;
    locala.cQF = this.cQF;
    locala.thumburl = this.thumburl;
    locala.dQJ = this.dQJ;
    locala.dQU = this.dQU;
    locala.dQV = this.dQV;
    locala.dQY = this.dQY;
    locala.dQZ = this.dQZ;
    locala.dRb = this.dRb;
    locala.dRa = this.dRa;
    locala.dRe = this.dRe;
    locala.dRf = this.dRf;
    locala.dRh = this.dRh;
    locala.dRg = this.dRg;
    locala.dRc = this.dRc;
    locala.dRd = this.dRd;
    locala.dRD = this.dRD;
    locala.bQr = this.bQr;
    locala.dRK = this.dRK;
    locala.dRL = this.dRL;
    locala.dRM = this.dRM;
    locala.dRN = this.dRM;
    locala.dRF = this.dRF;
    locala.dRI = this.dRI;
    locala.dRE = this.dRE;
    locala.dRG = this.dRG;
    locala.dRH = this.dRH;
    locala.dRW = this.dRW;
    locala.dRX = this.dRX;
    locala.dRY = this.dRY;
    locala.dQA = this.dQA;
    locala.bYJ = this.bYJ;
    locala.bYK = this.bYK;
    locala.bYL = this.bYL;
    locala.bYM = this.bYM;
    locala.dSO = this.dSO;
    locala.dSM = this.dSM;
    locala.designerName = this.designerName;
    locala.designerRediretctUrl = this.designerName;
    locala.tid = this.tid;
    locala.dSN = this.dSN;
    locala.desc = this.desc;
    locala.iconUrl = this.iconUrl;
    locala.secondUrl = this.secondUrl;
    locala.pageType = this.pageType;
    locala.dSP = this.dSP;
    locala.dSQ = this.dSQ;
    locala.dSR = this.dSR;
    locala.dSS = this.dSS;
    locala.dST = this.dST;
    locala.dSU = this.dSU;
    locala.dSV = this.dSV;
    locala.dSW = this.dSW;
    locala.canvasPageXml = this.canvasPageXml;
    locala.bYN = this.bYN;
    locala.dQK = this.dQK;
    locala.dQR = this.dQR;
    locala.filemd5 = this.filemd5;
    locala.dQz = this.dQz;
    locala.dQs = this.dQs;
    locala.dSX = this.dSX;
    locala.dSY = this.dSY;
    locala.dTa = this.dTa;
    locala.dTb = this.dTb;
    locala.dTf = this.dTf;
    locala.dSZ = this.dSZ;
    locala.dTg = this.dTg;
    locala.dTh = this.dTh;
    locala.dTd = this.dTd;
    locala.dTn = this.dTn;
    locala.dTo = this.dTo;
    locala.dTm = this.dTm;
    locala.dTl = this.dTl;
    locala.dQB = this.dQB;
    locala.dQC = this.dQC;
    locala.dQD = this.dQD;
    locala.dQE = this.dQE;
    locala.dQF = this.dQF;
    locala.dQG = this.dQG;
    locala.dQH = this.dQH;
    locala.dQI = this.dQI;
    Iterator localIterator = this.dTk.entrySet().iterator();
    while (localIterator.hasNext())
    {
      d locald = ((d)((Map.Entry)localIterator.next()).getValue()).Fk();
      if (locald != null) {
        locala.a(locald);
      }
    }
    return locala;
  }
  
  public static final a M(String paramString1, String paramString2)
  {
    Object localObject1;
    if (bk.bl(paramString1))
    {
      localObject1 = null;
      return localObject1;
    }
    int i = paramString1.indexOf('<');
    if (i > 0) {}
    for (Object localObject2 = paramString1.substring(i);; localObject2 = paramString1)
    {
      i = ((String)localObject2).hashCode();
      a locala = (a)dss.get(Integer.valueOf(i));
      localObject1 = locala;
      if (locala != null) {
        break;
      }
      long l1 = System.currentTimeMillis();
      if (!bk.bl(paramString2)) {}
      for (localObject1 = ba.Zx(paramString2);; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = bn.s((String)localObject2, "msg");
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            y.e("MicroMsg.AppMessage", "parse msg failed");
            return null;
          }
          long l2 = System.currentTimeMillis();
          locala = new a();
          locala.dTl = ((Map)localObject1);
          locala.dTm = paramString1;
          locala.dTn = ((String)localObject2);
          locala.dTo = paramString2;
          try
          {
            locala.a((Map)localObject1, locala);
            paramString1 = g.b.bC().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (d)((c)paramString1.next()).get();
              ((d)localObject2).a((Map)localObject1, locala);
              locala.a((d)localObject2);
            }
            paramString1 = g.b.hE(locala.type);
          }
          catch (Exception paramString1)
          {
            y.e("MicroMsg.AppMessage", "parse amessage xml failed");
            y.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bk.j(paramString1) });
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, locala);
            locala.a(paramString1);
          }
          dss.f(Integer.valueOf(i), locala);
          y.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(bk.pm(paramString2).hashCode()) });
          return locala;
        }
      }
    }
  }
  
  public static a a(a parama)
  {
    if (parama == null) {
      return new a();
    }
    return parama.Fm();
  }
  
  public static String a(a parama, String paramString, com.tencent.mm.j.d paramd)
  {
    y.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { bk.aac(parama.dQR), parama.filemd5 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msg>");
    if ((parama.dQQ != 0) && (parama.dQP != 0))
    {
      y.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[] { Integer.valueOf(parama.dQQ), Integer.valueOf(parama.dQP) });
      localStringBuilder.append(a(parama, paramString, paramd, parama.dQQ, parama.dQP));
    }
    for (;;)
    {
      localStringBuilder.append("</msg>");
      dss.f(Integer.valueOf(localStringBuilder.toString().hashCode()), parama);
      return localStringBuilder.toString();
      y.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
      localStringBuilder.append(a(parama, paramString, paramd, 0, 0));
    }
  }
  
  public static String a(a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<appmsg appid=\"" + bk.ZP(parama.appId) + "\" sdkver=\"" + parama.sdkVer + "\">");
    parama.a(localStringBuilder, parama, paramString, paramd, paramInt1, paramInt2);
    d locald = g.b.hE(parama.type);
    if (locald != null) {
      locald.a(localStringBuilder, parama, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == parama.showType) {
      localStringBuilder.append("<ShakePageResult>").append(parama.dQJ).append("</ShakePageResult>");
    }
    y.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    return localStringBuilder.toString();
  }
  
  public static final a go(String paramString)
  {
    if (bk.bl(paramString)) {
      paramString = null;
    }
    int i;
    a locala;
    do
    {
      return paramString;
      i = paramString.indexOf('<');
      localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ("parseImg_" + (String)localObject).hashCode();
      locala = (a)dss.get(Integer.valueOf(i));
      paramString = locala;
    } while (locala != null);
    paramString = bn.s((String)localObject, "msg");
    if (paramString == null)
    {
      y.e("MicroMsg.AppMessage", "parseImg failed");
      return null;
    }
    Object localObject = new a();
    ((a)localObject).type = 2;
    ((a)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((a)localObject).cau = bk.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((a)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((a)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((a)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((a)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    dss.f(Integer.valueOf(i), localObject);
    return localObject;
  }
  
  public static final a gp(String paramString)
  {
    return M(paramString, null);
  }
  
  public static String gq(String paramString)
  {
    return "<![CDATA[" + paramString + "]]>";
  }
  
  public final <T extends d> T A(Class<T> paramClass)
  {
    return (d)this.dTk.get(paramClass);
  }
  
  public final void a(d paramd)
  {
    if (paramd == null)
    {
      y.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
      return;
    }
    paramd.dQq = this;
    this.dTk.put(paramd.getClass(), paramd);
  }
  
  public final void a(g paramg)
  {
    paramg.field_appId = this.appId;
    paramg.field_title = this.title;
    paramg.field_description = this.description;
    paramg.field_type = this.type;
    paramg.field_source = this.appName;
  }
  
  public final void a(StringBuilder paramStringBuilder, a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append("<title>" + bk.ZP(parama.title) + "</title>");
    paramStringBuilder.append("<des>" + bk.ZP(parama.description) + "</des>");
    paramStringBuilder.append("<username>" + bk.ZP(parama.username) + "</username>");
    Object localObject2 = new StringBuilder("<action>");
    Object localObject1;
    if (bk.bl(parama.action))
    {
      localObject1 = "view";
      paramStringBuilder.append((String)localObject1 + "</action>");
      paramStringBuilder.append("<type>" + parama.type + "</type>");
      paramStringBuilder.append("<showtype>").append(parama.showType).append("</showtype>");
      paramStringBuilder.append("<content>" + bk.ZP(parama.content) + "</content>");
      paramStringBuilder.append("<url>" + bk.ZP(parama.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + bk.ZP(parama.dQu) + "</lowurl>");
      paramStringBuilder.append("<dataurl>" + bk.ZP(parama.dQU) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + bk.ZP(parama.dQV) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(parama.dQA).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(bk.ZP(parama.dSP)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(parama.dSQ).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(bk.ZP(parama.dSR)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(bk.ZP(parama.dSS)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(bk.ZP(parama.dST)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(bk.ZP(parama.dSU)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(bk.ZP(parama.dSV)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(bk.ZP(parama.dSW)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { parama.canvasPageXml }));
      switch (parama.type)
      {
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<appattach>");
      if ((paramd != null) && ((!bk.bl(paramString)) || (paramInt1 != 0) || (paramInt2 != 0))) {
        break label3271;
      }
      paramStringBuilder.append("<totallen>" + parama.dQv + "</totallen>");
      paramStringBuilder.append("<attachid>" + bk.ZP(parama.bFE) + "</attachid>");
      paramStringBuilder.append("<cdnattachurl>" + bk.ZP(parama.dQK) + "</cdnattachurl>");
      paramStringBuilder.append("<emoticonmd5>" + bk.ZP(parama.dQx) + "</emoticonmd5>");
      paramStringBuilder.append("<aeskey>" + bk.ZP(parama.dQR) + "</aeskey>");
      if ((paramInt1 != 0) && (paramInt2 != 0))
      {
        paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
        paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
      }
      paramStringBuilder.append("<fileext>" + bk.ZP(parama.dQw) + "</fileext>");
      paramStringBuilder.append("<islargefilemsg>" + parama.dQz + "</islargefilemsg>");
      paramStringBuilder.append("</appattach>");
      paramStringBuilder.append("<extinfo>" + bk.ZP(parama.extInfo) + "</extinfo>");
      paramStringBuilder.append("<androidsource>" + parama.dQy + "</androidsource>");
      if (!bk.bl(parama.bYG))
      {
        paramStringBuilder.append("<sourceusername>" + bk.ZP(parama.bYG) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + bk.ZP(parama.bYH) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + bk.ZP(parama.cQF) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + bk.ZP(parama.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + bk.ZP(parama.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + gq(bk.ZP(parama.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + gq(bk.ZP(parama.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + parama.dRb + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bk.ZP(parama.dRa) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + parama.dRh + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bk.ZP(parama.dRg) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + parama.dSM + "</designeruin>");
      paramStringBuilder.append("<designername>" + parama.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + parama.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + parama.tid + "</tid>");
      paramStringBuilder.append("<title>" + parama.dSN + "</title>");
      paramStringBuilder.append("<desc>" + parama.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + parama.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + parama.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + parama.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + bk.ZP(parama.bYJ) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + bk.ZP(parama.bYK) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + bk.ZP(parama.bYL) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + bk.ZP(parama.bYM) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + bk.ZP(parama.dRD) + "</template_id>");
      y.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { parama.filemd5 });
      paramStringBuilder.append("<md5>" + bk.ZP(parama.filemd5) + "</md5>");
      Iterator localIterator = g.b.bC().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (d)((c)localIterator.next()).get();
        localObject2 = parama.A(localObject1.getClass());
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((d)localObject1).a(paramStringBuilder, parama, paramString, paramd, paramInt1, paramInt2);
      }
      localObject1 = bk.ZP(parama.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + parama.dQY + "\">");
      paramStringBuilder.append("<productinfo>" + bk.ZP(parama.dQZ) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      continue;
      paramStringBuilder.append("<mallproductitem type=\"" + parama.dRe + "\">");
      paramStringBuilder.append("<mallproductinfo>" + bk.ZP(parama.dRf) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      continue;
      paramStringBuilder.append("<tvinfo>" + bk.ZP(parama.dRc) + "</tvinfo>");
      continue;
      paramStringBuilder.append("<recorditem>" + bk.ZP(parama.dRd) + "</recorditem>");
      continue;
      paramStringBuilder.append("<carditem>" + parama.dRK + "</carditem>");
      continue;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + parama.dRE + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + parama.dRF + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + parama.dRG + "</transcationid>");
      paramStringBuilder.append("<transferid>" + parama.dRH + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + parama.dRI + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + parama.dSO + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      continue;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + bk.ZP(parama.dSa) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + bk.ZP(parama.dSf) + "</scenetext>");
      paramStringBuilder.append("<url>" + bk.ZP(parama.dRZ) + "</url>");
      paramStringBuilder.append("<receivertitle>" + bk.ZP(parama.dSb) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + bk.ZP(parama.dSc) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + bk.ZP(parama.dSe) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + bk.ZP(parama.dSd) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + bk.ZP(parama.dSg) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + bk.ZP(parama.dSh) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + bk.ZP(parama.dSi) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + bk.ZP(new StringBuilder().append(parama.showType).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + bk.ZP(new StringBuilder().append(parama.dSj).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + bk.ZP(parama.dSk) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + bk.ZP(parama.dSl) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + bk.ZP(parama.dSm) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + bk.ZP(new StringBuilder().append(parama.dSn).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + bk.ZP(new StringBuilder().append(parama.dSp).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
    }
    label3271:
    paramStringBuilder.append("<attachid>" + bk.ZP(paramString) + "</attachid>");
    if ((paramd.field_fileLength > 0) && (!bk.bl(paramd.field_fileId)))
    {
      paramStringBuilder.append("<cdnattachurl>" + bk.ZP(paramd.field_fileId) + "</cdnattachurl>");
      if ((parama.type == 19) || (parama.type == 24) || (parama.type == 4) || (parama.type == 3) || (parama.type == 7) || (parama.type == 27) || (parama.type == 26)) {
        break label3703;
      }
      paramStringBuilder.append("<totallen>" + paramd.field_fileLength + "</totallen>");
    }
    for (;;)
    {
      if (paramd.field_thumbimgLength > 0)
      {
        paramStringBuilder.append("<cdnthumburl>" + bk.ZP(paramd.field_fileId) + "</cdnthumburl>");
        if (!bk.bl(paramd.field_thumbfilemd5)) {
          paramStringBuilder.append("<cdnthumbmd5>" + paramd.field_thumbfilemd5 + "</cdnthumbmd5>");
        }
        paramStringBuilder.append("<cdnthumblength>" + paramd.field_thumbimgLength + "</cdnthumblength>");
        paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
        paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
        paramStringBuilder.append("<cdnthumbaeskey>" + paramd.field_aesKey + "</cdnthumbaeskey>");
      }
      paramStringBuilder.append("<aeskey>" + bk.ZP(paramd.field_aesKey) + "</aeskey>");
      paramStringBuilder.append("<encryver>1</encryver>");
      break;
      label3703:
      y.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(parama.type), Integer.valueOf(paramd.field_fileLength) });
    }
  }
  
  public final void a(Map<String, String> paramMap, a parama)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        this.dQt = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = bk.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = bk.Zy((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = bk.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.dQu = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.dQB = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.dQC = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.dQD = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.dQE = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.dQF = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.dQG = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.dQH = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.dQI = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.dQU = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.dQV = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.dQv = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.bFE = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!bk.bl(this.dQB)) {
          this.bFE = this.dQB;
        }
        this.dQw = bk.Zy((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.dQx = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.dQy = bk.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.bYG = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.bYH = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.cQF = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.cau = bk.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.bRO = ((String)paramMap.get(".msg.fromusername"));
        this.dQK = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.dQL = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.dQM = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.dQN = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.dQO = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.dQP = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.dQQ = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.dQR = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.dQT = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.dQS = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.dQz = bk.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.dQz == 0) && (this.dQv > 26214400))
        {
          this.dQz = 1;
          y.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.dQv) });
        }
        this.dQY = bk.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.dQZ = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.dRb = bk.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.dRa = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.dRg = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.dRh = bk.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.dRc = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.dRd = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.bYJ = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.bYK = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.bYL = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.bYM = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.dSM = o.bS((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = bk.ZR((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.dSN = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = bk.aM((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = bk.ZR((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.dSP = bk.aM((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.dSQ = bk.ZR((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.dSR = bk.aM((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.dSS = bk.aM((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.dST = bk.aM((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.dSU = bk.aM((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.dSV = bk.aM((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.dSW = bk.aM((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = bk.aM((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        this.dSY = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.dSX = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.dSZ = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.dTg = bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.dTa = bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.dTf = bk.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.dTb = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.dTh = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.dTd = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.dTe = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        i = parama.dTm.indexOf("<cache");
        j = parama.dTm.indexOf("</cache>");
        if (j - i > "<cache".length()) {
          this.dTi = parama.dTm.substring(i, "</cache>".length() + j);
        }
        this.dTj = bk.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label3886;
          }
          this.showType = bk.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.bYN = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.dQW = bk.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.dQW == 5) && (bk.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.dQW = 0;
          }
          this.dQX = bk.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.dRi = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.dRj = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (bk.bl(this.dRj)) {
            this.dRj = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.dRk = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.dRl = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.dRm = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.dRn = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.color = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.dRo = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.dRp = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.dRr = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.dRq = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.dRt = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.dRs = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.dRw = bk.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.dRy = bk.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.dRx = bk.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.dRu = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.dRv = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.dRC = ((String)localObject);
          this.dRA = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.dRB = ((String)localObject);
          this.dRz = ((String)localObject);
          this.dRD = bk.pm((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.dRW = bk.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.dRX = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.dRY = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = bn.s(parama.dTn, "msgoperation");
          if ((this != null) && (paramMap != null))
          {
            this.dQs = new g.a.a();
            this.dQs.cQO = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.dQs.dTp = bk.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.dQs.dTq = bk.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.dQs.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.dQs.dTr = bk.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.dQs.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.dQs.dTs = bk.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
          }
          return;
        }
      }
      catch (Exception paramMap)
      {
        y.e("MicroMsg.AppMessage", "parse amessage xml failed");
        y.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bk.j(paramMap) });
        throw paramMap;
      }
      this.dRe = bk.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.dRf = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.dRE = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.dRF = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.dRG = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.dRH = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.dRI = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.dRJ = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.bXd = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.bHY = bk.aM((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.dSO = bk.aM((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.dSa = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.dSf = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.dRZ = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.dSb = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.dSc = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.dSe = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.dSd = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.dSg = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.dSh = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.dSi = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.dSj = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.dSk = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.dSl = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.dSm = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.dSn = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.dSp = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.dSq = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.dSr = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.dSs = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.dSt = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.dSu = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!bk.bl((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.dSv = new ArrayList();
          this.dSv.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.dSw = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!bk.bl((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.dSx = new ArrayList();
          this.dSx.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.dSy = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.dSz = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.dSA = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.dSB = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.dSC = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.dSD = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.dSE = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.dSF = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.dSG = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.dSH = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.dSI = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.dSJ = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.dSK = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.dSL = bk.pm((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.bQr = parama.dTm;
      this.dRK = "";
      this.dRM = bk.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.dRL = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.dRN = bk.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.dSo = true;
        continue;
        this.dRP = bk.aM((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.dRO = o.bS((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.dRQ = bk.aM((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.dRR = bk.aM((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.dRS = bk.aM((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.dRT = bk.aM((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.dRU = bk.aM((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.dRV = bk.aM((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        label3886:
        if (this.type == 2001)
        {
          this.showType = bk.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.showType = bk.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.showType)
          {
          case 1: 
            if (bk.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = ba.au(paramMap);
            }
            break;
          case 2: 
            localObject = parama.dTm.toLowerCase();
            i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.dQJ = parama.dTm.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final String getDescription()
  {
    if ((this.dQs != null) && (this.dQs.dTr != 0)) {
      return this.dQs.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.dQs != null) && (this.dQs.dTq != 0)) {
      return this.dQs.title;
    }
    return this.title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ae.g.a
 * JD-Core Version:    0.7.0.1
 */