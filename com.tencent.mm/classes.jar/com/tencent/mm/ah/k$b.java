package com.tencent.mm.ah;

import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.i.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
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
  private static final com.tencent.mm.b.f<Integer, b> fVO;
  public int aDD;
  public String action;
  public String appId;
  public String appName;
  public String canvasPageXml;
  public String content;
  public int dGv;
  public String dIA;
  public String dIt;
  public String dIu;
  public String dIw;
  public String dIx;
  public String dIy;
  public String dIz;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String dlu;
  public int dmr;
  public String dog;
  public String dxN;
  public String dzZ;
  public String extInfo;
  public String filemd5;
  public String fmn;
  public String gmb;
  public int hBV;
  public Map<String, String> hCA;
  public String hCB;
  public int hCC;
  public String hCD;
  public String hCE;
  public int hCF;
  public int hCG;
  public int hCH;
  public String hCI;
  public String hCJ;
  public int hCK;
  public int hCL;
  public int hCM;
  public String hCN;
  public String hCO;
  public String hCP;
  public String hCQ;
  public String hCR;
  public String hCS;
  public int hCT;
  public int hCU;
  public int hCV;
  public String hCW;
  public int hCX;
  public String hCY;
  public String hCZ;
  public a hCz;
  public int hDA;
  public int hDB;
  public int hDC;
  public String hDD;
  public String hDE;
  public String hDF;
  public String hDG;
  public String hDH;
  public int hDI;
  public String hDJ;
  public String hDK;
  public String hDL;
  public int hDM;
  public int hDN;
  public String hDO;
  public String hDP;
  public int hDQ;
  public int hDR;
  public int hDS;
  public String hDT;
  public String hDU;
  public String hDV;
  public String hDW;
  public String hDX;
  public String hDY;
  public int hDZ;
  public int hDa;
  public int hDb;
  public String hDc;
  public String hDd;
  public int hDe;
  public String hDf;
  public String hDg;
  public int hDh;
  public String hDi;
  public String hDj;
  public int hDk;
  public String hDl;
  public String hDm;
  public String hDn;
  public String hDo;
  public String hDp;
  public String hDq;
  public String hDr;
  public String hDs;
  public String hDt;
  public String hDu;
  public String hDv;
  public String hDw;
  public String hDx;
  public String hDy;
  public String hDz;
  public List<String> hEA;
  public String hEB;
  public int hEC;
  public String hED;
  public String hEE;
  public String hEF;
  public String hEG;
  public String hEH;
  public String hEI;
  public String hEJ;
  public String hEK;
  public String hEL;
  public String hEM;
  public String hEN;
  public String hEO;
  public int hEP;
  public String hEQ;
  public String hER;
  public Map<String, String> hES;
  public String hET;
  public int hEU;
  public String hEV;
  public String hEW;
  public String hEX;
  public String hEY;
  public String hEZ;
  public String hEa;
  public String hEb;
  public String hEc;
  public String hEd;
  public String hEe;
  public String hEf;
  public String hEg;
  public String hEh;
  public String hEi;
  public String hEj;
  public String hEk;
  public String hEl;
  public int hEm;
  public String hEn;
  public String hEo;
  public String hEp;
  public int hEq;
  public boolean hEr;
  public int hEs;
  public String hEt;
  public int hEu;
  public String hEv;
  public String hEw;
  public String hEx;
  public List<String> hEy;
  public String hEz;
  public String hFa;
  public String hFb;
  public String hFc;
  public String hFd;
  public int hFe;
  public String hFf;
  public int hFg;
  public String hFh;
  public String hFi;
  public int hFj;
  public String hFk;
  public int hFl;
  public String hFm;
  public String hFn;
  public String hFo;
  public Pair<String, String> hFp;
  public MsgQuoteItem hFq;
  public int hFr;
  public int hFs;
  public String hFt;
  public int hFu;
  private final HashMap<Class<? extends f>, f> hFv;
  public Map<String, String> hFw;
  private String hFx;
  private String hFy;
  private String hFz;
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
    fVO = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(150125);
  }
  
  public k$b()
  {
    AppMethodBeat.i(150108);
    this.hEr = false;
    this.hEs = 0;
    this.hEU = 0;
    this.hEV = "";
    this.hEW = "";
    this.hEX = "";
    this.hEY = "";
    this.hEZ = "";
    this.hFa = "";
    this.hFj = k.a.hCx.ordinal();
    this.hFp = new Pair("", "");
    this.canvasPageXml = "";
    this.hFu = 0;
    this.hFv = new HashMap();
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
    paramb = paramb.azp();
    AppMethodBeat.o(150119);
    return paramb;
  }
  
  public static String a(b paramb, String paramString, d paramd)
  {
    AppMethodBeat.i(150116);
    ae.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { bu.aSM(paramb.gmb), paramb.filemd5 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msg>");
    if ((paramb.thumbWidth != 0) && (paramb.thumbHeight != 0))
    {
      ae.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[] { Integer.valueOf(paramb.thumbWidth), Integer.valueOf(paramb.thumbHeight) });
      localStringBuilder.append(a(paramb, paramString, paramd, paramb.thumbWidth, paramb.thumbHeight));
    }
    for (;;)
    {
      localStringBuilder.append("</msg>");
      fVO.q(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
      paramb = localStringBuilder.toString();
      AppMethodBeat.o(150116);
      return paramb;
      ae.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
      localStringBuilder.append(a(paramb, paramString, paramd, 0, 0));
    }
  }
  
  public static String a(b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150117);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<appmsg appid=\"" + bu.aSz(paramb.appId) + "\" sdkver=\"" + paramb.sdkVer + "\">");
    paramb.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    f localf = k.c.ok(paramb.type);
    if (localf != null) {
      localf.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == paramb.dmr) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.hCQ).append("</ShakePageResult>");
    }
    ae.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(150117);
    return paramb;
  }
  
  public static final b aB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150115);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(150115);
      return null;
    }
    int i = paramString1.indexOf('<');
    if (i > 0) {}
    for (Object localObject2 = paramString1.substring(i);; localObject2 = paramString1)
    {
      i = ((String)localObject2).hashCode();
      Object localObject1 = (b)fVO.get(Integer.valueOf(i));
      if (localObject1 != null)
      {
        AppMethodBeat.o(150115);
        return localObject1;
      }
      long l1 = System.currentTimeMillis();
      if (!bu.isNullOrNil(paramString2)) {}
      for (localObject1 = bk.aSj(paramString2);; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = bx.M((String)localObject2, "msg");
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            ae.e("MicroMsg.AppMessage", "parse msg failed");
            AppMethodBeat.o(150115);
            return null;
          }
          long l2 = System.currentTimeMillis();
          b localb = new b();
          localb.hFw = ((Map)localObject1);
          localb.hFx = paramString1;
          localb.hFy = ((String)localObject2);
          localb.hFz = paramString2;
          try
          {
            localb.a((Map)localObject1, localb);
            paramString1 = k.c.access$000().iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (f)((com.tencent.mm.cm.c)paramString1.next()).get();
              if (localObject2 != null)
              {
                ((f)localObject2).a((Map)localObject1, localb);
                localb.a((f)localObject2);
              }
            }
            paramString1 = k.c.ok(localb.type);
          }
          catch (Exception paramString1)
          {
            ae.e("MicroMsg.AppMessage", "parse amessage xml failed");
            ae.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bu.o(paramString1) });
            AppMethodBeat.o(150115);
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, localb);
            localb.a(paramString1);
          }
          fVO.q(Integer.valueOf(i), localb);
          ae.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(bu.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(150115);
          return localb;
        }
      }
    }
  }
  
  private b azp()
  {
    AppMethodBeat.i(150121);
    b localb = new b();
    if (this == null)
    {
      AppMethodBeat.o(150121);
      return localb;
    }
    ae.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { bu.aSM(this.gmb), this.filemd5, localb.appId });
    localb.action = this.action;
    localb.appId = this.appId;
    localb.appName = this.appName;
    localb.aDD = this.aDD;
    localb.dlu = this.dlu;
    localb.hCC = this.hCC;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.hCF = this.hCF;
    localb.hCD = this.hCD;
    localb.dzZ = this.dzZ;
    localb.hCB = this.hCB;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.dmr = this.dmr;
    localb.hBV = this.hBV;
    localb.hDa = this.hDa;
    localb.url = this.url;
    localb.hCE = this.hCE;
    localb.dIt = this.dIt;
    localb.dIu = this.dIu;
    localb.fmn = this.fmn;
    localb.thumburl = this.thumburl;
    localb.hCQ = this.hCQ;
    localb.hCY = this.hCY;
    localb.hCZ = this.hCZ;
    localb.hDb = this.hDb;
    localb.hDc = this.hDc;
    localb.hDe = this.hDe;
    localb.hDd = this.hDd;
    localb.hDh = this.hDh;
    localb.hDi = this.hDi;
    localb.hDk = this.hDk;
    localb.hDj = this.hDj;
    localb.hDf = this.hDf;
    localb.hDg = this.hDg;
    localb.hDH = this.hDH;
    localb.dxN = this.dxN;
    localb.hDO = this.hDO;
    localb.hDP = this.hDP;
    localb.hDQ = this.hDQ;
    localb.hDR = this.hDQ;
    localb.hDJ = this.hDJ;
    localb.hDM = this.hDM;
    localb.hDI = this.hDI;
    localb.hDK = this.hDK;
    localb.hDL = this.hDL;
    localb.hDZ = this.hDZ;
    localb.hEa = this.hEa;
    localb.hEb = this.hEb;
    localb.hCH = this.hCH;
    localb.dIw = this.dIw;
    localb.dIx = this.dIx;
    localb.dIy = this.dIy;
    localb.dIz = this.dIz;
    localb.hER = this.hER;
    localb.hEP = this.hEP;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.hEQ = this.hEQ;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.hET = this.hET;
    localb.hEU = this.hEU;
    localb.hEV = this.hEV;
    localb.hEW = this.hEW;
    localb.hEX = this.hEX;
    localb.hEY = this.hEY;
    localb.hEZ = this.hEZ;
    localb.hFa = this.hFa;
    localb.canvasPageXml = this.canvasPageXml;
    localb.dIA = this.dIA;
    localb.hES = this.hES;
    localb.hCR = this.hCR;
    localb.gmb = this.gmb;
    localb.filemd5 = this.filemd5;
    localb.hCG = this.hCG;
    localb.hCz = this.hCz;
    localb.hFb = this.hFb;
    localb.hFc = this.hFc;
    localb.hFe = this.hFe;
    localb.hFf = this.hFf;
    localb.hFr = this.hFr;
    localb.hFd = this.hFd;
    localb.hFs = this.hFs;
    localb.hFt = this.hFt;
    localb.hFh = this.hFh;
    localb.hFi = this.hFi;
    localb.hFj = this.hFj;
    localb.hFk = this.hFk;
    localb.hFl = this.hFl;
    localb.hFy = this.hFy;
    localb.hFz = this.hFz;
    localb.hFx = this.hFx;
    localb.hFw = this.hFw;
    localb.hCI = this.hCI;
    localb.hCJ = this.hCJ;
    localb.hCK = this.hCK;
    localb.hCL = this.hCL;
    localb.hCM = this.hCM;
    localb.hCN = this.hCN;
    localb.hCO = this.hCO;
    localb.hCP = this.hCP;
    localb.hFq = this.hFq;
    localb.hFp = this.hFp;
    localb.hFm = this.hFm;
    localb.hFn = this.hFn;
    localb.hFo = this.hFo;
    Iterator localIterator = this.hFv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).aoI();
      if (localf != null) {
        localb.a(localf);
      }
    }
    AppMethodBeat.o(150121);
    return localb;
  }
  
  public static final b za(String paramString)
  {
    AppMethodBeat.i(150111);
    if (bu.isNullOrNil(paramString))
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
    paramString = (b)fVO.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(150111);
      return paramString;
    }
    paramString = bx.M((String)localObject, "msg");
    if (paramString == null)
    {
      ae.e("MicroMsg.AppMessage", "parseImg failed");
      AppMethodBeat.o(150111);
      return null;
    }
    localObject = new b();
    ((b)localObject).type = 2;
    ((b)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((b)localObject).aDD = bu.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((b)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((b)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((b)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((b)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    fVO.q(Integer.valueOf(i), localObject);
    AppMethodBeat.o(150111);
    return localObject;
  }
  
  public static final b zb(String paramString)
  {
    AppMethodBeat.i(150114);
    paramString = aB(paramString, null);
    AppMethodBeat.o(150114);
    return paramString;
  }
  
  public static String zc(String paramString)
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
      ae.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
      AppMethodBeat.o(150110);
      return;
    }
    paramf.hCe = this;
    this.hFv.put(paramf.getClass(), paramf);
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
      localObject1 = (f)((com.tencent.mm.cm.c)localIterator.next()).get();
      if (localObject1 != null)
      {
        localObject2 = paramb.ao(localObject1.getClass());
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        ((f)localObject1).b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
      }
    }
    paramStringBuilder.append("<title>" + bu.aSz(paramb.title) + "</title>");
    paramStringBuilder.append("<des>" + bu.aSz(paramb.description) + "</des>");
    paramStringBuilder.append("<username>" + bu.aSz(paramb.username) + "</username>");
    Object localObject2 = new StringBuilder("<action>");
    if (bu.isNullOrNil(paramb.action))
    {
      localObject1 = "view";
      paramStringBuilder.append((String)localObject1 + "</action>");
      paramStringBuilder.append("<type>" + paramb.type + "</type>");
      paramStringBuilder.append("<showtype>").append(paramb.dmr).append("</showtype>");
      paramStringBuilder.append("<content>" + bu.aSz(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + bu.aSz(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + bu.aSz(paramb.hCB) + "</lowurl>");
      paramStringBuilder.append("<dataurl>" + bu.aSz(paramb.hCY) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + bu.aSz(paramb.hCZ) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.hCH).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(bu.aSz(paramb.hET)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.hEU).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(bu.aSz(paramb.hEV)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(bu.aSz(paramb.hEW)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(bu.aSz(paramb.hEX)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(bu.aSz(paramb.hEY)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(bu.aSz(paramb.hEZ)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(bu.aSz(paramb.hFa)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      default: 
        label804:
        paramStringBuilder.append("<appattach>");
        if ((paramd == null) || ((bu.isNullOrNil(paramString)) && (paramInt1 == 0) && (paramInt2 == 0)))
        {
          paramStringBuilder.append("<totallen>" + paramb.hCC + "</totallen>");
          paramStringBuilder.append("<attachid>" + bu.aSz(paramb.dlu) + "</attachid>");
          paramStringBuilder.append("<cdnattachurl>" + bu.aSz(paramb.hCR) + "</cdnattachurl>");
          paramStringBuilder.append("<emoticonmd5>" + bu.aSz(paramb.hCE) + "</emoticonmd5>");
          paramStringBuilder.append("<aeskey>" + bu.aSz(paramb.gmb) + "</aeskey>");
          if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
            paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
          }
          paramStringBuilder.append("<fileext>" + bu.aSz(paramb.hCD) + "</fileext>");
          paramStringBuilder.append("<islargefilemsg>" + paramb.hCG + "</islargefilemsg>");
          paramStringBuilder.append("</appattach>");
          if (paramb.type != 53) {
            break label4143;
          }
          paramStringBuilder.append("<extinfo>").append((String)paramb.hFp.second).append("</extinfo>");
        }
        break;
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<androidsource>" + paramb.hCF + "</androidsource>");
      if (!bu.isNullOrNil(paramb.dIt))
      {
        paramStringBuilder.append("<sourceusername>" + bu.aSz(paramb.dIt) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + bu.aSz(paramb.dIu) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + bu.aSz(paramb.fmn) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + bu.aSz(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + bu.aSz(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + zc(bu.aSz(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + zc(bu.aSz(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.hDe + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bu.aSz(paramb.hDd) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.hDk + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bu.aSz(paramb.hDj) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.hEP + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.hEQ + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + bu.aSz(paramb.dIw) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + bu.aSz(paramb.dIx) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + bu.aSz(paramb.dIy) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + bu.aSz(paramb.dIz) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + bu.aSz(paramb.hDH) + "</template_id>");
      ae.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + bu.aSz(paramb.filemd5) + "</md5>");
      localIterator = k.c.access$000().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (f)((com.tencent.mm.cm.c)localIterator.next()).get();
        if (localObject1 != null)
        {
          localObject2 = paramb.ao(localObject1.getClass());
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((f)localObject1).a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
        }
      }
      localObject1 = bu.aSz(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.hDb + "\">");
      paramStringBuilder.append("<productinfo>" + bu.aSz(paramb.hDc) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      break label804;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.hDh + "\">");
      paramStringBuilder.append("<mallproductinfo>" + bu.aSz(paramb.hDi) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      break label804;
      paramStringBuilder.append("<tvinfo>" + bu.aSz(paramb.hDf) + "</tvinfo>");
      break label804;
      paramStringBuilder.append("<recorditem>" + bu.aSz(paramb.hDg) + "</recorditem>");
      break label804;
      paramStringBuilder.append("<carditem>" + paramb.hDO + "</carditem>");
      break label804;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.hDI + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.hDJ + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.hDK + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.hDL + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.hDM + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.hER + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      break label804;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + bu.aSz(paramb.hEd) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + bu.aSz(paramb.hEi) + "</scenetext>");
      paramStringBuilder.append("<url>" + bu.aSz(paramb.hEc) + "</url>");
      paramStringBuilder.append("<receivertitle>" + bu.aSz(paramb.hEe) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + bu.aSz(paramb.hEf) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + bu.aSz(paramb.hEh) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + bu.aSz(paramb.hEg) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + bu.aSz(paramb.hEj) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + bu.aSz(paramb.hEk) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + bu.aSz(paramb.hEl) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + bu.aSz(new StringBuilder().append(paramb.dmr).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + bu.aSz(new StringBuilder().append(paramb.hEm).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + bu.aSz(paramb.hEn) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + bu.aSz(paramb.hEo) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + bu.aSz(paramb.hEp) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + bu.aSz(new StringBuilder().append(paramb.hEq).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + bu.aSz(new StringBuilder().append(paramb.hEs).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
      break label804;
      paramStringBuilder.append("<refermsg>");
      if (paramb.hFq != null)
      {
        paramStringBuilder.append("<type>").append(paramb.hFq.type).append("</type>");
        paramStringBuilder.append("<svrid>").append(paramb.hFq.wlg).append("</svrid>");
        paramStringBuilder.append("<fromusr>").append(paramb.hFq.wlh).append("</fromusr>");
        paramStringBuilder.append("<chatusr>").append(paramb.hFq.wli).append("</chatusr>");
        paramStringBuilder.append("<displayname>").append(paramb.hFq.wlj).append("</displayname>");
        paramStringBuilder.append("<msgsource>").append(bu.aSz(paramb.hFq.wlk)).append("</msgsource>");
        paramStringBuilder.append("<content>").append(bu.aSz(paramb.hFq.content)).append("</content>");
      }
      paramStringBuilder.append("</refermsg>");
      break label804;
      paramStringBuilder.append("<liteapp>");
      paramStringBuilder.append("<id>").append(paramb.hFm).append("</id>");
      paramStringBuilder.append("<path>").append(bu.aSz(paramb.hFn)).append("</path>");
      paramStringBuilder.append("<query>").append(bu.aSz(paramb.hFo)).append("</query>");
      paramStringBuilder.append("</liteapp>");
      break label804;
      paramStringBuilder.append("<attachid>" + bu.aSz(paramString) + "</attachid>");
      if ((paramd.field_fileLength > 0L) && (!bu.isNullOrNil(paramd.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + bu.aSz(paramd.field_fileId) + "</cdnattachurl>");
        if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
          break label4106;
        }
        paramStringBuilder.append("<totallen>" + paramd.field_fileLength + "</totallen>");
      }
      for (;;)
      {
        if (paramd.field_thumbimgLength > 0)
        {
          paramStringBuilder.append("<cdnthumburl>" + bu.aSz(paramd.field_fileId) + "</cdnthumburl>");
          if (!bu.isNullOrNil(paramd.field_thumbfilemd5)) {
            paramStringBuilder.append("<cdnthumbmd5>" + paramd.field_thumbfilemd5 + "</cdnthumbmd5>");
          }
          paramStringBuilder.append("<cdnthumblength>" + paramd.field_thumbimgLength + "</cdnthumblength>");
          paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
          paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
          paramStringBuilder.append("<cdnthumbaeskey>" + paramd.field_aesKey + "</cdnthumbaeskey>");
        }
        paramStringBuilder.append("<aeskey>" + bu.aSz(paramd.field_aesKey) + "</aeskey>");
        paramStringBuilder.append("<encryver>1</encryver>");
        break;
        label4106:
        ae.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Long.valueOf(paramd.field_fileLength) });
      }
      label4143:
      paramStringBuilder.append("<extinfo>" + bu.aSz(paramb.extInfo) + "</extinfo>");
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
        this.hCA = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = bu.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = bu.aSl((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = bu.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.hCB = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.hCI = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.hCJ = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.hCK = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.hCL = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.hCM = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.hCN = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.hCO = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.hCP = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.hCY = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.hCZ = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.hCC = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.dlu = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!bu.isNullOrNil(this.hCI)) {
          this.dlu = this.hCI;
        }
        this.hCD = bu.aSl((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.hCE = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.hFp = new Pair("", paramMap.get(".msg.appmsg.extinfo.solitaire_info"));
        this.hCF = bu.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.dIt = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.dIu = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.fmn = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.aDD = bu.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.dzZ = ((String)paramMap.get(".msg.fromusername"));
        this.hCR = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.hCS = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.hCT = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.hCU = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.hCV = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.thumbHeight = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.thumbWidth = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.gmb = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.hCX = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.hCW = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.hCG = bu.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.hCG == 0) && (this.hCC > 26214400))
        {
          this.hCG = 1;
          ae.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.hCC) });
        }
        this.hDb = bu.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.hDc = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.hDe = bu.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.hDd = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.hDj = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.hDk = bu.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.hDf = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.hDg = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.dIw = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.dIx = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.dIy = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.dIz = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.hEP = p.ew((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = bu.aSB((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.hEQ = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = bu.bI((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = bu.aSB((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.hET = bu.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.hEU = bu.aSB((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.hEV = bu.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.hEW = bu.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.hEX = bu.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.hEY = bu.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.hEZ = bu.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.hFa = bu.bI((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = bu.bI((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        if (paramMap.containsKey(".msg.appmsg.gamelife"))
        {
          this.hES = new HashMap(4);
          this.hES.put(bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording.$lang")), bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording")));
          this.hES.put(bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1.$lang")), bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording1")));
          this.hES.put(bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2.$lang")), bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording2")));
          this.hES.put(bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3.$lang")), bu.nullAsNil((String)paramMap.get(".msg.appmsg.gamelife.digest.wording3")));
        }
        this.hFc = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.hFb = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.hFd = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.hFs = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.hFe = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.hFr = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.hFf = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.hFt = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.hFh = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.hFi = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.hFj = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), k.a.hCx.ordinal());
        this.hFk = bu.bI((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.hFl = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.hFu = bu.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label4416;
          }
          this.dmr = bu.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.dIA = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.hBV = bu.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.hBV == 5) && (bu.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.hBV = 0;
          }
          this.hDa = bu.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.hDl = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.hDm = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (bu.isNullOrNil(this.hDm)) {
            this.hDm = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.hDn = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.hDo = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.hDp = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.hDq = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.hDr = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.hDs = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.hDt = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.hDv = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.hDu = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.hDx = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.hDw = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.hDA = bu.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.hDC = bu.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.hDB = bu.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.hDy = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.hDz = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.hDG = ((String)localObject);
          this.hDE = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.hDF = ((String)localObject);
          this.hDD = ((String)localObject);
          this.hDH = bu.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.hDZ = bu.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.hEa = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.hEb = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = bx.M(paramb.hFy, "msgoperation");
          if ((this != null) && (paramMap != null))
          {
            this.hCz = new a();
            this.hCz.fmw = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.hCz.hFA = bu.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.hCz.hFB = bu.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.hCz.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.hCz.hFC = bu.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.hCz.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.hCz.hFD = bu.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
          }
          AppMethodBeat.o(150120);
          return;
        }
      }
      catch (Exception paramMap)
      {
        ae.e("MicroMsg.AppMessage", "parse amessage xml failed");
        ae.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bu.o(paramMap) });
        AppMethodBeat.o(150120);
        throw paramMap;
      }
      this.hDh = bu.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.hDi = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.hDI = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.hDJ = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.hDK = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.hDL = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.hDM = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.hDN = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.dGv = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.dog = bu.bI((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.hER = bu.bI((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.hEd = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.hEi = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.hEc = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.hEe = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.hEf = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.hEh = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.hEg = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.hEj = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.hEk = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.hEl = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.hEm = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.hEn = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.hEo = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.hEp = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.hEq = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.hEs = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.hEt = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.hEu = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.hEv = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.hEw = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.hEx = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hEy = new ArrayList();
          this.hEy.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.hEz = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hEA = new ArrayList();
          this.hEA.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.hEB = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.hEC = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.hED = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.hEE = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.hEF = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.hEG = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.hEH = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.hEI = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.hEJ = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.hEK = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.hEL = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.hEM = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.hEN = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.hEO = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.dxN = paramb.hFx;
      this.hDO = "";
      this.hDQ = bu.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.hDP = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.hDR = bu.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.hEr = true;
        continue;
        this.hDT = bu.bI((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.hDS = p.ew((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.hDU = bu.bI((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.hDV = bu.bI((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.hDW = bu.bI((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.hDX = bu.bI((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.titleColor = bu.bI((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.hDY = bu.bI((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        this.hFq = new MsgQuoteItem();
        this.hFq.type = bu.getInt((String)paramMap.get(".msg.appmsg.refermsg.type"), 0);
        this.hFq.wlg = bu.getLong((String)paramMap.get(".msg.appmsg.refermsg.svrid"), 0L);
        this.hFq.wlh = bu.bI((String)paramMap.get(".msg.appmsg.refermsg.fromusr"), "");
        this.hFq.wli = bu.bI((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.hFq.wli = bu.bI((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.hFq.wlj = bu.bI((String)paramMap.get(".msg.appmsg.refermsg.displayname"), "");
        this.hFq.content = bu.bI((String)paramMap.get(".msg.appmsg.refermsg.content"), "");
        this.hFq.wlk = bu.bI((String)paramMap.get(".msg.appmsg.refermsg.msgsource"), "");
        continue;
        this.hFm = ((String)paramMap.get(".msg.appmsg.liteapp.id"));
        this.hFn = ((String)paramMap.get(".msg.appmsg.liteapp.path"));
        this.hFo = ((String)paramMap.get(".msg.appmsg.liteapp.query"));
        continue;
        label4416:
        if (this.type == 2001)
        {
          this.dmr = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.dmr = bu.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.dmr)
          {
          case 1: 
            if (bu.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = bk.bO(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.hFx.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.hCQ = paramb.hFx.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final <T extends f> T ao(Class<T> paramClass)
  {
    AppMethodBeat.i(150109);
    paramClass = (f)this.hFv.get(paramClass);
    AppMethodBeat.o(150109);
    return paramClass;
  }
  
  public final g azo()
  {
    AppMethodBeat.i(150118);
    g localg = new g();
    localg.fLl = "task_AppMessage";
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.fKA;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.hFv.entrySet().iterator();
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
  
  public final boolean azq()
  {
    return (this.hCz != null) && (this.hCz.hFD != 0);
  }
  
  public final boolean azr()
  {
    return (this.hCz != null) && (this.hCz.hFA == 1);
  }
  
  public final boolean ex(boolean paramBoolean)
  {
    AppMethodBeat.i(150113);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.hFj >= k.a.hCv.ordinal()) && (this.hFj < k.a.hCx.ordinal()))
      {
        AppMethodBeat.o(150113);
        return true;
      }
    }
    else if ((this.hFj >= k.a.hCv.ordinal()) && (this.hFj < k.a.hCx.ordinal()))
    {
      AppMethodBeat.o(150113);
      return true;
    }
    AppMethodBeat.o(150113);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.hCz != null) && (this.hCz.hFC != 0)) {
      return this.hCz.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.hCz != null) && (this.hCz.hFB != 0)) {
      return this.hCz.title;
    }
    return this.title;
  }
  
  public final String t(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150112);
    String str = "";
    if (ex(true))
    {
      if (bu.isNullOrNil(this.hFk)) {
        break label180;
      }
      int i = paramContext.getResources().getIdentifier(this.hFk, "string", paramContext.getPackageName());
      ae.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label150;
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
      ae.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { paramContext });
      AppMethodBeat.o(150112);
      return paramContext;
      label150:
      if (k.a.hCv.ordinal() == this.hFj)
      {
        str = "";
      }
      else
      {
        str = this.dIu;
        continue;
        label180:
        if (k.a.hCv.ordinal() == this.hFj) {
          str = "";
        } else {
          str = this.dIu;
        }
      }
    }
  }
  
  public static final class a
  {
    public String desc;
    public String fmw;
    public int hFA;
    public int hFB;
    public int hFC;
    public int hFD;
    public int hFE = 0;
    public int hFF = 0;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.k.b
 * JD-Core Version:    0.7.0.1
 */