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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
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
  private static final com.tencent.mm.b.f<Integer, b> fAs;
  public int aBM;
  public String action;
  public String appId;
  public String appName;
  public int cZX;
  public String cZa;
  public String canvasPageXml;
  public String content;
  public String dbI;
  public String desc;
  public String description;
  public String designerName;
  public String designerRediretctUrl;
  public String dkV;
  public String dng;
  public int dto;
  public String dvl;
  public String dvm;
  public String dvo;
  public String dvp;
  public String dvq;
  public String dvr;
  public String dvs;
  public String eSb;
  public String extInfo;
  public String fQi;
  public String filemd5;
  public int hgY;
  public a hhC;
  public Map<String, String> hhD;
  public String hhE;
  public int hhF;
  public String hhG;
  public String hhH;
  public int hhI;
  public int hhJ;
  public int hhK;
  public String hhL;
  public String hhM;
  public int hhN;
  public int hhO;
  public int hhP;
  public String hhQ;
  public String hhR;
  public String hhS;
  public String hhT;
  public String hhU;
  public String hhV;
  public int hhW;
  public int hhX;
  public int hhY;
  public String hhZ;
  public String hiA;
  public String hiB;
  public String hiC;
  public int hiD;
  public int hiE;
  public int hiF;
  public String hiG;
  public String hiH;
  public String hiI;
  public String hiJ;
  public String hiK;
  public int hiL;
  public String hiM;
  public String hiN;
  public String hiO;
  public int hiP;
  public int hiQ;
  public String hiR;
  public String hiS;
  public int hiT;
  public int hiU;
  public int hiV;
  public String hiW;
  public String hiX;
  public String hiY;
  public String hiZ;
  public int hia;
  public String hib;
  public String hic;
  public int hid;
  public int hie;
  public String hif;
  public String hig;
  public int hih;
  public String hii;
  public String hij;
  public int hik;
  public String hil;
  public String him;
  public int hin;
  public String hio;
  public String hip;
  public String hiq;
  public String hir;
  public String his;
  public String hit;
  public String hiu;
  public String hiv;
  public String hiw;
  public String hix;
  public String hiy;
  public String hiz;
  public String hjA;
  public List<String> hjB;
  public String hjC;
  public List<String> hjD;
  public String hjE;
  public int hjF;
  public String hjG;
  public String hjH;
  public String hjI;
  public String hjJ;
  public String hjK;
  public String hjL;
  public String hjM;
  public String hjN;
  public String hjO;
  public String hjP;
  public String hjQ;
  public String hjR;
  public int hjS;
  public String hjT;
  public String hjU;
  public String hjV;
  public int hjW;
  public String hjX;
  public String hjY;
  public String hjZ;
  public String hja;
  public String hjb;
  public int hjc;
  public String hjd;
  public String hje;
  public String hjf;
  public String hjg;
  public String hjh;
  public String hji;
  public String hjj;
  public String hjk;
  public String hjl;
  public String hjm;
  public String hjn;
  public String hjo;
  public int hjp;
  public String hjq;
  public String hjr;
  public String hjs;
  public int hjt;
  public boolean hju;
  public int hjv;
  public String hjw;
  public int hjx;
  public String hjy;
  public String hjz;
  public String hka;
  public String hkb;
  public String hkc;
  public String hkd;
  public String hke;
  public String hkf;
  public int hkg;
  public String hkh;
  public int hki;
  public String hkj;
  public String hkk;
  public int hkl;
  public String hkm;
  public int hkn;
  public Pair<String, String> hko;
  public MsgQuoteItem hkp;
  public int hkq;
  public int hkr;
  public String hks;
  public int hkt;
  private final HashMap<Class<? extends f>, f> hku;
  public Map<String, String> hkv;
  private String hkw;
  private String hkx;
  private String hky;
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
    fAs = new com.tencent.mm.memory.a.c(100);
    AppMethodBeat.o(150125);
  }
  
  public k$b()
  {
    AppMethodBeat.i(150108);
    this.hju = false;
    this.hjv = 0;
    this.hjW = 0;
    this.hjX = "";
    this.hjY = "";
    this.hjZ = "";
    this.hka = "";
    this.hkb = "";
    this.hkc = "";
    this.hkl = k.a.hhA.ordinal();
    this.hko = new Pair("", "");
    this.canvasPageXml = "";
    this.hkt = 0;
    this.hku = new HashMap();
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
    paramb = paramb.awn();
    AppMethodBeat.o(150119);
    return paramb;
  }
  
  public static String a(b paramb, String paramString, d paramd)
  {
    AppMethodBeat.i(150116);
    ac.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { bs.aLJ(paramb.fQi), paramb.filemd5 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msg>");
    if ((paramb.thumbWidth != 0) && (paramb.thumbHeight != 0))
    {
      ac.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[] { Integer.valueOf(paramb.thumbWidth), Integer.valueOf(paramb.thumbHeight) });
      localStringBuilder.append(a(paramb, paramString, paramd, paramb.thumbWidth, paramb.thumbHeight));
    }
    for (;;)
    {
      localStringBuilder.append("</msg>");
      fAs.o(Integer.valueOf(localStringBuilder.toString().hashCode()), paramb);
      paramb = localStringBuilder.toString();
      AppMethodBeat.o(150116);
      return paramb;
      ac.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
      localStringBuilder.append(a(paramb, paramString, paramd, 0, 0));
    }
  }
  
  public static String a(b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150117);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<appmsg appid=\"" + bs.aLw(paramb.appId) + "\" sdkver=\"" + paramb.sdkVer + "\">");
    paramb.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    f localf = k.c.nI(paramb.type);
    if (localf != null) {
      localf.a(localStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    }
    localStringBuilder.append("</appmsg>");
    if (2 == paramb.cZX) {
      localStringBuilder.append("<ShakePageResult>").append(paramb.hhT).append("</ShakePageResult>");
    }
    ac.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(150117);
    return paramb;
  }
  
  private b awn()
  {
    AppMethodBeat.i(150121);
    b localb = new b();
    if (this == null)
    {
      AppMethodBeat.o(150121);
      return localb;
    }
    ac.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { bs.aLJ(this.fQi), this.filemd5, localb.appId });
    localb.action = this.action;
    localb.appId = this.appId;
    localb.appName = this.appName;
    localb.aBM = this.aBM;
    localb.cZa = this.cZa;
    localb.hhF = this.hhF;
    localb.content = this.content;
    localb.description = this.description;
    localb.username = this.username;
    localb.extInfo = this.extInfo;
    localb.mediaTagName = this.mediaTagName;
    localb.messageAction = this.messageAction;
    localb.messageExt = this.messageExt;
    localb.hhI = this.hhI;
    localb.hhG = this.hhG;
    localb.dng = this.dng;
    localb.hhE = this.hhE;
    localb.sdkVer = this.sdkVer;
    localb.title = this.title;
    localb.type = this.type;
    localb.cZX = this.cZX;
    localb.hgY = this.hgY;
    localb.hid = this.hid;
    localb.url = this.url;
    localb.hhH = this.hhH;
    localb.dvl = this.dvl;
    localb.dvm = this.dvm;
    localb.eSb = this.eSb;
    localb.thumburl = this.thumburl;
    localb.hhT = this.hhT;
    localb.hib = this.hib;
    localb.hic = this.hic;
    localb.hie = this.hie;
    localb.hif = this.hif;
    localb.hih = this.hih;
    localb.hig = this.hig;
    localb.hik = this.hik;
    localb.hil = this.hil;
    localb.hin = this.hin;
    localb.him = this.him;
    localb.hii = this.hii;
    localb.hij = this.hij;
    localb.hiK = this.hiK;
    localb.dkV = this.dkV;
    localb.hiR = this.hiR;
    localb.hiS = this.hiS;
    localb.hiT = this.hiT;
    localb.hiU = this.hiT;
    localb.hiM = this.hiM;
    localb.hiP = this.hiP;
    localb.hiL = this.hiL;
    localb.hiN = this.hiN;
    localb.hiO = this.hiO;
    localb.hjc = this.hjc;
    localb.hjd = this.hjd;
    localb.hje = this.hje;
    localb.hhK = this.hhK;
    localb.dvo = this.dvo;
    localb.dvp = this.dvp;
    localb.dvq = this.dvq;
    localb.dvr = this.dvr;
    localb.hjU = this.hjU;
    localb.hjS = this.hjS;
    localb.designerName = this.designerName;
    localb.designerRediretctUrl = this.designerName;
    localb.tid = this.tid;
    localb.hjT = this.hjT;
    localb.desc = this.desc;
    localb.iconUrl = this.iconUrl;
    localb.secondUrl = this.secondUrl;
    localb.pageType = this.pageType;
    localb.hjV = this.hjV;
    localb.hjW = this.hjW;
    localb.hjX = this.hjX;
    localb.hjY = this.hjY;
    localb.hjZ = this.hjZ;
    localb.hka = this.hka;
    localb.hkb = this.hkb;
    localb.hkc = this.hkc;
    localb.canvasPageXml = this.canvasPageXml;
    localb.dvs = this.dvs;
    localb.hhU = this.hhU;
    localb.fQi = this.fQi;
    localb.filemd5 = this.filemd5;
    localb.hhJ = this.hhJ;
    localb.hhC = this.hhC;
    localb.hkd = this.hkd;
    localb.hke = this.hke;
    localb.hkg = this.hkg;
    localb.hkh = this.hkh;
    localb.hkq = this.hkq;
    localb.hkf = this.hkf;
    localb.hkr = this.hkr;
    localb.hks = this.hks;
    localb.hkj = this.hkj;
    localb.hkk = this.hkk;
    localb.hkl = this.hkl;
    localb.hkm = this.hkm;
    localb.hkn = this.hkn;
    localb.hkx = this.hkx;
    localb.hky = this.hky;
    localb.hkw = this.hkw;
    localb.hkv = this.hkv;
    localb.hhL = this.hhL;
    localb.hhM = this.hhM;
    localb.hhN = this.hhN;
    localb.hhO = this.hhO;
    localb.hhP = this.hhP;
    localb.hhQ = this.hhQ;
    localb.hhR = this.hhR;
    localb.hhS = this.hhS;
    localb.hkp = this.hkp;
    localb.hko = this.hko;
    Iterator localIterator = this.hku.entrySet().iterator();
    while (localIterator.hasNext())
    {
      f localf = ((f)((Map.Entry)localIterator.next()).getValue()).alG();
      if (localf != null) {
        localb.a(localf);
      }
    }
    AppMethodBeat.o(150121);
    return localb;
  }
  
  public static final b az(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150115);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(150115);
      return null;
    }
    int i = paramString1.indexOf('<');
    if (i > 0) {}
    for (Object localObject2 = paramString1.substring(i);; localObject2 = paramString1)
    {
      i = ((String)localObject2).hashCode();
      Object localObject1 = (b)fAs.get(Integer.valueOf(i));
      if (localObject1 != null)
      {
        AppMethodBeat.o(150115);
        return localObject1;
      }
      long l1 = System.currentTimeMillis();
      if (!bs.isNullOrNil(paramString2)) {}
      for (localObject1 = bi.aLg(paramString2);; localObject1 = null)
      {
        if (localObject1 == null) {
          localObject1 = bv.L((String)localObject2, "msg");
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            ac.e("MicroMsg.AppMessage", "parse msg failed");
            AppMethodBeat.o(150115);
            return null;
          }
          long l2 = System.currentTimeMillis();
          b localb = new b();
          localb.hkv = ((Map)localObject1);
          localb.hkw = paramString1;
          localb.hkx = ((String)localObject2);
          localb.hky = paramString2;
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
            paramString1 = k.c.nI(localb.type);
          }
          catch (Exception paramString1)
          {
            ac.e("MicroMsg.AppMessage", "parse amessage xml failed");
            ac.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bs.m(paramString1) });
            AppMethodBeat.o(150115);
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, localb);
            localb.a(paramString1);
          }
          fAs.o(Integer.valueOf(i), localb);
          ac.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(bs.nullAsNil(paramString2).hashCode()) });
          AppMethodBeat.o(150115);
          return localb;
        }
      }
    }
  }
  
  public static final b vA(String paramString)
  {
    AppMethodBeat.i(150114);
    paramString = az(paramString, null);
    AppMethodBeat.o(150114);
    return paramString;
  }
  
  public static String vB(String paramString)
  {
    AppMethodBeat.i(150123);
    paramString = "<![CDATA[" + paramString + "]]>";
    AppMethodBeat.o(150123);
    return paramString;
  }
  
  public static final b vz(String paramString)
  {
    AppMethodBeat.i(150111);
    if (bs.isNullOrNil(paramString))
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
    paramString = (b)fAs.get(Integer.valueOf(i));
    if (paramString != null)
    {
      AppMethodBeat.o(150111);
      return paramString;
    }
    paramString = bv.L((String)localObject, "msg");
    if (paramString == null)
    {
      ac.e("MicroMsg.AppMessage", "parseImg failed");
      AppMethodBeat.o(150111);
      return null;
    }
    localObject = new b();
    ((b)localObject).type = 2;
    ((b)localObject).appId = ((String)paramString.get(".msg.appinfo.appid"));
    ((b)localObject).aBM = bs.getInt((String)paramString.get(".msg.appinfo.version"), 0);
    ((b)localObject).appName = ((String)paramString.get(".msg.appinfo.appname"));
    ((b)localObject).mediaTagName = ((String)paramString.get(".msg.appinfo.mediatagname"));
    ((b)localObject).messageExt = ((String)paramString.get(".msg.appinfo.messageext"));
    ((b)localObject).messageAction = ((String)paramString.get(".msg.appinfo.messageaction"));
    fAs.o(Integer.valueOf(i), localObject);
    AppMethodBeat.o(150111);
    return localObject;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(150110);
    if (paramf == null)
    {
      ac.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
      AppMethodBeat.o(150110);
      return;
    }
    paramf.hhh = this;
    this.hku.put(paramf.getClass(), paramf);
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
    paramStringBuilder.append("<title>" + bs.aLw(paramb.title) + "</title>");
    paramStringBuilder.append("<des>" + bs.aLw(paramb.description) + "</des>");
    paramStringBuilder.append("<username>" + bs.aLw(paramb.username) + "</username>");
    Object localObject2 = new StringBuilder("<action>");
    if (bs.isNullOrNil(paramb.action))
    {
      localObject1 = "view";
      paramStringBuilder.append((String)localObject1 + "</action>");
      paramStringBuilder.append("<type>" + paramb.type + "</type>");
      paramStringBuilder.append("<showtype>").append(paramb.cZX).append("</showtype>");
      paramStringBuilder.append("<content>" + bs.aLw(paramb.content) + "</content>");
      paramStringBuilder.append("<url>" + bs.aLw(paramb.url) + "</url>");
      paramStringBuilder.append("<lowurl>" + bs.aLw(paramb.hhE) + "</lowurl>");
      paramStringBuilder.append("<dataurl>" + bs.aLw(paramb.hib) + "</dataurl>");
      paramStringBuilder.append("<lowdataurl>" + bs.aLw(paramb.hic) + "</lowdataurl>");
      paramStringBuilder.append("<contentattr>").append(paramb.hhK).append("</contentattr>");
      paramStringBuilder.append("<streamvideo>");
      paramStringBuilder.append("<streamvideourl>").append(bs.aLw(paramb.hjV)).append("</streamvideourl>");
      paramStringBuilder.append("<streamvideototaltime>").append(paramb.hjW).append("</streamvideototaltime>");
      paramStringBuilder.append("<streamvideotitle>").append(bs.aLw(paramb.hjX)).append("</streamvideotitle>");
      paramStringBuilder.append("<streamvideowording>").append(bs.aLw(paramb.hjY)).append("</streamvideowording>");
      paramStringBuilder.append("<streamvideoweburl>").append(bs.aLw(paramb.hjZ)).append("</streamvideoweburl>");
      paramStringBuilder.append("<streamvideothumburl>").append(bs.aLw(paramb.hka)).append("</streamvideothumburl>");
      paramStringBuilder.append("<streamvideoaduxinfo>").append(bs.aLw(paramb.hkb)).append("</streamvideoaduxinfo>");
      paramStringBuilder.append("<streamvideopublishid>").append(bs.aLw(paramb.hkc)).append("</streamvideopublishid>");
      paramStringBuilder.append("</streamvideo>");
      paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { paramb.canvasPageXml }));
      switch (paramb.type)
      {
      default: 
        label796:
        paramStringBuilder.append("<appattach>");
        if ((paramd == null) || ((bs.isNullOrNil(paramString)) && (paramInt1 == 0) && (paramInt2 == 0)))
        {
          paramStringBuilder.append("<totallen>" + paramb.hhF + "</totallen>");
          paramStringBuilder.append("<attachid>" + bs.aLw(paramb.cZa) + "</attachid>");
          paramStringBuilder.append("<cdnattachurl>" + bs.aLw(paramb.hhU) + "</cdnattachurl>");
          paramStringBuilder.append("<emoticonmd5>" + bs.aLw(paramb.hhH) + "</emoticonmd5>");
          paramStringBuilder.append("<aeskey>" + bs.aLw(paramb.fQi) + "</aeskey>");
          if ((paramInt1 != 0) && (paramInt2 != 0))
          {
            paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
            paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
          }
          paramStringBuilder.append("<fileext>" + bs.aLw(paramb.hhG) + "</fileext>");
          paramStringBuilder.append("<islargefilemsg>" + paramb.hhJ + "</islargefilemsg>");
          paramStringBuilder.append("</appattach>");
          if (paramb.type != 53) {
            break label4047;
          }
          paramStringBuilder.append("<extinfo>").append((String)paramb.hko.second).append("</extinfo>");
        }
        break;
      }
    }
    for (;;)
    {
      paramStringBuilder.append("<androidsource>" + paramb.hhI + "</androidsource>");
      if (!bs.isNullOrNil(paramb.dvl))
      {
        paramStringBuilder.append("<sourceusername>" + bs.aLw(paramb.dvl) + "</sourceusername>");
        paramStringBuilder.append("<sourcedisplayname>" + bs.aLw(paramb.dvm) + "</sourcedisplayname>");
        paramStringBuilder.append("<commenturl>" + bs.aLw(paramb.eSb) + "</commenturl>");
      }
      paramStringBuilder.append("<thumburl>" + bs.aLw(paramb.thumburl) + "</thumburl>");
      paramStringBuilder.append("<mediatagname>" + bs.aLw(paramb.mediaTagName) + "</mediatagname>");
      paramStringBuilder.append("<messageaction>" + vB(bs.aLw(paramb.messageAction)) + "</messageaction>");
      paramStringBuilder.append("<messageext>" + vB(bs.aLw(paramb.messageExt)) + "</messageext>");
      paramStringBuilder.append("<emoticongift>");
      paramStringBuilder.append("<packageflag>" + paramb.hih + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bs.aLw(paramb.hig) + "</packageid>");
      paramStringBuilder.append("</emoticongift>");
      paramStringBuilder.append("<emoticonshared>");
      paramStringBuilder.append("<packageflag>" + paramb.hin + "</packageflag>");
      paramStringBuilder.append("<packageid>" + bs.aLw(paramb.him) + "</packageid>");
      paramStringBuilder.append("</emoticonshared>");
      paramStringBuilder.append("<designershared>");
      paramStringBuilder.append("<designeruin>" + paramb.hjS + "</designeruin>");
      paramStringBuilder.append("<designername>" + paramb.designerName + "</designername>");
      paramStringBuilder.append("<designerrediretcturl>" + paramb.designerRediretctUrl + "</designerrediretcturl>");
      paramStringBuilder.append("</designershared>");
      paramStringBuilder.append("<emotionpageshared>");
      paramStringBuilder.append("<tid>" + paramb.tid + "</tid>");
      paramStringBuilder.append("<title>" + paramb.hjT + "</title>");
      paramStringBuilder.append("<desc>" + paramb.desc + "</desc>");
      paramStringBuilder.append("<iconUrl>" + paramb.iconUrl + "</iconUrl>");
      paramStringBuilder.append("<secondUrl>" + paramb.secondUrl + "</secondUrl>");
      paramStringBuilder.append("<pageType>" + paramb.pageType + "</pageType>");
      paramStringBuilder.append("</emotionpageshared>");
      paramStringBuilder.append("<webviewshared>");
      paramStringBuilder.append("<shareUrlOriginal>" + bs.aLw(paramb.dvo) + "</shareUrlOriginal>");
      paramStringBuilder.append("<shareUrlOpen>" + bs.aLw(paramb.dvp) + "</shareUrlOpen>");
      paramStringBuilder.append("<jsAppId>" + bs.aLw(paramb.dvq) + "</jsAppId>");
      paramStringBuilder.append("<publisherId>" + bs.aLw(paramb.dvr) + "</publisherId>");
      paramStringBuilder.append("</webviewshared>");
      paramStringBuilder.append("<template_id>" + bs.aLw(paramb.hiK) + "</template_id>");
      ac.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { paramb.filemd5 });
      paramStringBuilder.append("<md5>" + bs.aLw(paramb.filemd5) + "</md5>");
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
      localObject1 = bs.aLw(paramb.action);
      break;
      paramStringBuilder.append("<productitem type=\"" + paramb.hie + "\">");
      paramStringBuilder.append("<productinfo>" + bs.aLw(paramb.hif) + "</productinfo>");
      paramStringBuilder.append("</productitem>");
      break label796;
      paramStringBuilder.append("<mallproductitem type=\"" + paramb.hik + "\">");
      paramStringBuilder.append("<mallproductinfo>" + bs.aLw(paramb.hil) + "</mallproductinfo>");
      paramStringBuilder.append("</mallproductitem>");
      break label796;
      paramStringBuilder.append("<tvinfo>" + bs.aLw(paramb.hii) + "</tvinfo>");
      break label796;
      paramStringBuilder.append("<recorditem>" + bs.aLw(paramb.hij) + "</recorditem>");
      break label796;
      paramStringBuilder.append("<carditem>" + paramb.hiR + "</carditem>");
      break label796;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<paysubtype>" + paramb.hiL + "</paysubtype>");
      paramStringBuilder.append("<feedesc>" + paramb.hiM + "</feedesc>");
      paramStringBuilder.append("<transcationid>" + paramb.hiN + "</transcationid>");
      paramStringBuilder.append("<transferid>" + paramb.hiO + "</transferid>");
      paramStringBuilder.append("<invalidtime>" + paramb.hiP + "</invalidtime>");
      paramStringBuilder.append("<pay_memo>" + paramb.hjU + "</pay_memo>");
      paramStringBuilder.append("</wcpayinfo>");
      break label796;
      paramStringBuilder.append("<wcpayinfo>");
      paramStringBuilder.append("<iconurl>" + bs.aLw(paramb.hjg) + "</iconurl>");
      paramStringBuilder.append("<scenetext>" + bs.aLw(paramb.hjl) + "</scenetext>");
      paramStringBuilder.append("<url>" + bs.aLw(paramb.hjf) + "</url>");
      paramStringBuilder.append("<receivertitle>" + bs.aLw(paramb.hjh) + "</receivertitle>");
      paramStringBuilder.append("<sendertitle>" + bs.aLw(paramb.hji) + "</sendertitle>");
      paramStringBuilder.append("<receiverdes>" + bs.aLw(paramb.hjk) + "</receiverdes>");
      paramStringBuilder.append("<senderdes>" + bs.aLw(paramb.hjj) + "</senderdes>");
      paramStringBuilder.append("<templateid>" + bs.aLw(paramb.hjm) + "</templateid>");
      paramStringBuilder.append("<sceneid>" + bs.aLw(paramb.hjn) + "</sceneid>");
      paramStringBuilder.append("<nativeurl>" + bs.aLw(paramb.hjo) + "</nativeurl>");
      paramStringBuilder.append("<innertype>" + bs.aLw(new StringBuilder().append(paramb.cZX).toString()) + "</innertype>");
      paramStringBuilder.append("<localtype>" + bs.aLw(new StringBuilder().append(paramb.hjp).toString()) + "</localtype>");
      paramStringBuilder.append("<paymsgid>" + bs.aLw(paramb.hjq) + "</paymsgid>");
      paramStringBuilder.append("<imageid>" + bs.aLw(paramb.hjr) + "</imageid>");
      paramStringBuilder.append("<imageaeskey>" + bs.aLw(paramb.hjs) + "</imageaeskey>");
      paramStringBuilder.append("<imagelength>" + bs.aLw(new StringBuilder().append(paramb.hjt).toString()) + "</imagelength>");
      paramStringBuilder.append("<droptips>" + bs.aLw(new StringBuilder().append(paramb.hjv).toString()) + "</droptips>");
      paramStringBuilder.append("</wcpayinfo>");
      break label796;
      paramStringBuilder.append("<refermsg>");
      if (paramb.hkp != null)
      {
        paramStringBuilder.append("<type>").append(paramb.hkp.type).append("</type>");
        paramStringBuilder.append("<svrid>").append(paramb.hkp.uVU).append("</svrid>");
        paramStringBuilder.append("<fromusr>").append(paramb.hkp.uVV).append("</fromusr>");
        paramStringBuilder.append("<chatusr>").append(paramb.hkp.uVW).append("</chatusr>");
        paramStringBuilder.append("<displayname>").append(paramb.hkp.uVX).append("</displayname>");
        paramStringBuilder.append("<msgsource>").append(bs.aLw(paramb.hkp.uVY)).append("</msgsource>");
        paramStringBuilder.append("<content>").append(bs.aLw(paramb.hkp.content)).append("</content>");
      }
      paramStringBuilder.append("</refermsg>");
      break label796;
      paramStringBuilder.append("<attachid>" + bs.aLw(paramString) + "</attachid>");
      if ((paramd.field_fileLength > 0L) && (!bs.isNullOrNil(paramd.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + bs.aLw(paramd.field_fileId) + "</cdnattachurl>");
        if ((paramb.type == 19) || (paramb.type == 24) || (paramb.type == 4) || (paramb.type == 3) || (paramb.type == 7) || (paramb.type == 27) || (paramb.type == 26)) {
          break label4010;
        }
        paramStringBuilder.append("<totallen>" + paramd.field_fileLength + "</totallen>");
      }
      for (;;)
      {
        if (paramd.field_thumbimgLength > 0)
        {
          paramStringBuilder.append("<cdnthumburl>" + bs.aLw(paramd.field_fileId) + "</cdnthumburl>");
          if (!bs.isNullOrNil(paramd.field_thumbfilemd5)) {
            paramStringBuilder.append("<cdnthumbmd5>" + paramd.field_thumbfilemd5 + "</cdnthumbmd5>");
          }
          paramStringBuilder.append("<cdnthumblength>" + paramd.field_thumbimgLength + "</cdnthumblength>");
          paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
          paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
          paramStringBuilder.append("<cdnthumbaeskey>" + paramd.field_aesKey + "</cdnthumbaeskey>");
        }
        paramStringBuilder.append("<aeskey>" + bs.aLw(paramd.field_aesKey) + "</aeskey>");
        paramStringBuilder.append("<encryver>1</encryver>");
        break;
        label4010:
        ac.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(paramb.type), Long.valueOf(paramd.field_fileLength) });
      }
      label4047:
      paramStringBuilder.append("<extinfo>" + bs.aLw(paramb.extInfo) + "</extinfo>");
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
        this.hhD = paramMap;
        this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
        this.sdkVer = bs.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
        this.title = bs.aLi((String)paramMap.get(".msg.appmsg.title"));
        this.description = ((String)paramMap.get(".msg.appmsg.des"));
        this.username = ((String)paramMap.get(".msg.appmsg.username"));
        this.action = ((String)paramMap.get(".msg.appmsg.action"));
        this.type = bs.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
        this.content = ((String)paramMap.get(".msg.appmsg.content"));
        this.url = ((String)paramMap.get(".msg.appmsg.url"));
        this.hhE = ((String)paramMap.get(".msg.appmsg.lowurl"));
        this.hhL = ((String)paramMap.get(".msg.appmsg.appattach.tpurl"));
        this.hhM = ((String)paramMap.get(".msg.appmsg.appattach.tpthumburl"));
        this.hhN = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumblength"), 0);
        this.hhO = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbheight"), 0);
        this.hhP = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
        this.hhQ = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbmd5"));
        this.hhR = ((String)paramMap.get(".msg.appmsg.appattach.tpauthkey"));
        this.hhS = ((String)paramMap.get(".msg.appmsg.appattach.tpthumbaeskey"));
        this.hib = ((String)paramMap.get(".msg.appmsg.dataurl"));
        this.hic = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
        this.hhF = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
        this.cZa = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
        if (!bs.isNullOrNil(this.hhL)) {
          this.cZa = this.hhL;
        }
        this.hhG = bs.aLi((String)paramMap.get(".msg.appmsg.appattach.fileext"));
        this.hhH = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
        this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
        this.hko = new Pair("", paramMap.get(".msg.appmsg.extinfo.solitaire_info"));
        this.hhI = bs.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
        this.dvl = ((String)paramMap.get(".msg.appmsg.sourceusername"));
        this.dvm = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
        this.eSb = ((String)paramMap.get(".msg.commenturl"));
        this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
        this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
        this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
        this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
        this.aBM = bs.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
        this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
        this.dng = ((String)paramMap.get(".msg.fromusername"));
        this.hhU = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
        this.hhV = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
        this.hhW = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
        this.hhX = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
        this.hhY = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
        this.thumbHeight = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
        this.thumbWidth = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
        this.fQi = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
        this.hia = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
        this.hhZ = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
        this.hhJ = bs.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
        if ((this.hhJ == 0) && (this.hhF > 26214400))
        {
          this.hhJ = 1;
          ac.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.hhF) });
        }
        this.hie = bs.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
        this.hif = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
        this.hih = bs.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
        this.hig = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
        this.him = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
        this.hin = bs.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
        this.hii = ((String)paramMap.get(".msg.appmsg.tvinfo"));
        this.hij = ((String)paramMap.get(".msg.appmsg.recorditem"));
        this.dvo = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
        this.dvp = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
        this.dvq = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
        this.dvr = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
        this.hjS = p.dv((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
        this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
        this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
        this.tid = bs.aLy((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
        this.hjT = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
        this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
        this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
        this.secondUrl = bs.bG((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
        this.pageType = bs.aLy((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
        this.hjV = bs.bG((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
        this.hjW = bs.aLy((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
        this.hjX = bs.bG((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
        this.hjY = bs.bG((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
        this.hjZ = bs.bG((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
        this.hka = bs.bG((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
        this.hkb = bs.bG((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
        this.hkc = bs.bG((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
        this.canvasPageXml = bs.bG((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
        this.hke = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
        this.hkd = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
        this.hkf = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
        this.hkr = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
        this.hkg = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
        this.hkq = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
        this.hkh = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
        this.hks = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
        this.hkj = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
        this.hkk = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
        this.hkl = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.type"), k.a.hhA.ordinal());
        this.hkm = bs.bG((String)paramMap.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
        this.hkn = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.disableforward"), 0);
        this.hkt = bs.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
        switch (this.type)
        {
        case 13: 
          if (this.type != 21) {
            break label4122;
          }
          this.cZX = bs.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.dvs = ((String)paramMap.get(".msg.appmsg.statextstr"));
          this.hgY = bs.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
          if ((this.hgY == 5) && (bs.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
            this.hgY = 0;
          }
          this.hid = bs.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
          this.hio = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
          this.hip = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
          if (bs.isNullOrNil(this.hip)) {
            this.hip = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
          }
          this.hiq = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
          this.hir = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
          this.his = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
          this.hit = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
          this.hiu = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
          this.hiv = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
          this.hiw = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
          this.hiy = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
          this.hix = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
          this.hiA = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
          this.hiz = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
          this.hiD = bs.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
          this.hiF = bs.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
          this.hiE = bs.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
          this.hiB = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
          this.hiC = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
          this.hiJ = ((String)localObject);
          this.hiH = ((String)localObject);
          localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
          this.hiI = ((String)localObject);
          this.hiG = ((String)localObject);
          this.hiK = bs.nullAsNil((String)paramMap.get(".msg.appmsg.template_id"));
          this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
          this.hjc = bs.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
          this.hjd = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
          this.hje = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
          paramMap = bv.L(paramb.hkx, "msgoperation");
          if ((this != null) && (paramMap != null))
          {
            this.hhC = new a();
            this.hhC.eSk = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
            this.hhC.hkz = bs.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
            this.hhC.hkA = bs.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
            this.hhC.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
            this.hhC.hkB = bs.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
            this.hhC.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
            this.hhC.hkC = bs.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
          }
          AppMethodBeat.o(150120);
          return;
        }
      }
      catch (Exception paramMap)
      {
        ac.e("MicroMsg.AppMessage", "parse amessage xml failed");
        ac.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bs.m(paramMap) });
        AppMethodBeat.o(150120);
        throw paramMap;
      }
      this.hik = bs.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
      this.hil = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
      continue;
      this.hiL = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
      this.hiM = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
      this.hiN = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
      this.hiO = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
      this.hiP = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
      this.hiQ = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
      this.dto = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
      this.dbI = bs.bG((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
      this.hjU = bs.bG((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
      continue;
      this.hjg = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
      this.hjl = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
      this.hjf = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
      this.hjh = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
      this.hji = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
      this.hjk = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
      this.hjj = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
      this.hjm = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
      this.hjn = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
      this.hjo = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
      this.hjp = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
      this.hjq = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
      this.hjr = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
      this.hjs = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
      this.hjt = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
      this.hjv = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
      this.hjw = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
      this.hjx = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
      this.hjy = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
      this.hjz = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
      this.hjA = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
      Object localObject = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hjB = new ArrayList();
          this.hjB.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.hjC = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
      localObject = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          this.hjD = new ArrayList();
          this.hjD.addAll(Arrays.asList((Object[])localObject));
        }
      }
      this.hjE = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
      this.hjF = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
      this.hjG = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
      continue;
      this.hjH = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
      this.hjI = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
      this.hjJ = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
      this.hjK = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
      this.hjL = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
      this.hjM = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
      this.hjN = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
      this.hjO = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
      this.hjP = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
      this.hjQ = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
      this.hjR = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
      continue;
      this.dkV = paramb.hkw;
      this.hiR = "";
      this.hiT = bs.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
      this.hiS = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
      this.hiU = bs.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
      continue;
      if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
      {
        this.hju = true;
        continue;
        this.hiW = bs.bG((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
        this.hiV = p.dv((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
        this.hiX = bs.bG((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
        this.hiY = bs.bG((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        this.hiZ = bs.bG((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
        this.hja = bs.bG((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        this.titleColor = bs.bG((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
        this.hjb = bs.bG((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
        continue;
        this.hkp = new MsgQuoteItem();
        this.hkp.type = bs.getInt((String)paramMap.get(".msg.appmsg.refermsg.type"), 0);
        this.hkp.uVU = bs.getLong((String)paramMap.get(".msg.appmsg.refermsg.svrid"), 0L);
        this.hkp.uVV = bs.bG((String)paramMap.get(".msg.appmsg.refermsg.fromusr"), "");
        this.hkp.uVW = bs.bG((String)paramMap.get(".msg.appmsg.refermsg.chatusr"), "");
        this.hkp.uVX = bs.bG((String)paramMap.get(".msg.appmsg.refermsg.displayname"), "");
        this.hkp.content = bs.bG((String)paramMap.get(".msg.appmsg.refermsg.content"), "");
        this.hkp.uVY = bs.bG((String)paramMap.get(".msg.appmsg.refermsg.msgsource"), "");
        continue;
        label4122:
        if (this.type == 2001)
        {
          this.cZX = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
        }
        else
        {
          this.cZX = bs.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
          switch (this.cZX)
          {
          case 1: 
            if (bs.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
              this.content = bi.bF(paramMap);
            }
            break;
          case 2: 
            localObject = paramb.hkw.toLowerCase();
            int i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
            int j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
            this.hhT = paramb.hkw.substring(i + 17, j);
            continue;
          }
        }
      }
    }
  }
  
  public final <T extends f> T ao(Class<T> paramClass)
  {
    AppMethodBeat.i(150109);
    paramClass = (f)this.hku.get(paramClass);
    AppMethodBeat.o(150109);
    return paramClass;
  }
  
  public final g awm()
  {
    AppMethodBeat.i(150118);
    g localg = new g();
    localg.field_fullpath = "";
    localg.field_fileType = a.MediaType_THUMBIMAGE;
    localg.field_priority = a.fqp;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    Iterator localIterator = this.hku.entrySet().iterator();
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
  
  public final boolean awo()
  {
    return (this.hhC != null) && (this.hhC.hkC != 0);
  }
  
  public final boolean awp()
  {
    return (this.hhC != null) && (this.hhC.hkz == 1);
  }
  
  public final boolean et(boolean paramBoolean)
  {
    AppMethodBeat.i(150113);
    if (paramBoolean)
    {
      if ((44 == this.type) && (this.hkl >= k.a.hhy.ordinal()) && (this.hkl < k.a.hhA.ordinal()))
      {
        AppMethodBeat.o(150113);
        return true;
      }
    }
    else if ((this.hkl >= k.a.hhy.ordinal()) && (this.hkl < k.a.hhA.ordinal()))
    {
      AppMethodBeat.o(150113);
      return true;
    }
    AppMethodBeat.o(150113);
    return false;
  }
  
  public final String getDescription()
  {
    if ((this.hhC != null) && (this.hhC.hkB != 0)) {
      return this.hhC.desc;
    }
    return this.description;
  }
  
  public final String getTitle()
  {
    if ((this.hhC != null) && (this.hhC.hkA != 0)) {
      return this.hhC.title;
    }
    return this.title;
  }
  
  public final String r(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150112);
    String str = "";
    if (et(true))
    {
      if (bs.isNullOrNil(this.hkm)) {
        break label178;
      }
      int i = paramContext.getResources().getIdentifier(this.hkm, "string", paramContext.getPackageName());
      ac.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(i) });
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
      ac.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { paramContext });
      AppMethodBeat.o(150112);
      return paramContext;
      label149:
      if (k.a.hhy.ordinal() == this.hkl)
      {
        str = "";
      }
      else
      {
        str = this.dvm;
        continue;
        label178:
        if (k.a.hhy.ordinal() == this.hkl) {
          str = "";
        } else {
          str = this.dvm;
        }
      }
    }
  }
  
  public static final class a
  {
    public String desc;
    public String eSk;
    public int hkA;
    public int hkB;
    public int hkC;
    public int hkD = 0;
    public int hkE = 0;
    public int hkz;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.k.b
 * JD-Core Version:    0.7.0.1
 */