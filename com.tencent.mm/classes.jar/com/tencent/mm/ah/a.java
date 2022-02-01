package com.tencent.mm.ah;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
  extends f
{
  public String appThumbUrl;
  public String dJw = "";
  public boolean hAJ;
  public String hAK;
  public int hAL;
  public boolean hAM;
  public String hAN;
  public String hAO;
  public String hAP;
  public String hAQ;
  public String hAR;
  public String hAS;
  public int hAT;
  public int hAU;
  public int hAV = 0;
  public String hAW;
  public String hAX;
  public int hAY = 0;
  public boolean hAZ;
  public String hBa;
  public boolean hBb;
  public int hBc;
  public int hBd;
  public int hBe = 0;
  public String hBf = "";
  public String hBg = "";
  public String hBh = "";
  public String hBi = "";
  public String hBj = "";
  public boolean hBk = false;
  public String videoSource;
  
  public final void a(g paramg, k.b paramb)
  {
    AppMethodBeat.i(2612);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (bu.isNullOrNil(this.hBi)) && (!bu.isNullOrNil(this.hBf)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.hBf;
      paramg.field_filemd5 = this.dJw;
      paramg.field_fileType = com.tencent.mm.i.a.fKJ;
      paramg.field_totalLen = ((int)o.aZR(this.hBf));
      paramg.field_needStorage = true;
      paramg.field_isStreamMedia = false;
      paramg.field_force_aeskeycdn = false;
      paramg.field_trysafecdn = true;
      paramg.field_bzScene = 2;
      paramg.snsVersion = 1;
    }
    AppMethodBeat.o(2612);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2613);
    paramStringBuilder.append("<weappinfo>");
    if (!bu.isNullOrNil(paramb.hFb)) {
      paramStringBuilder.append("<pagepath>" + k.b.zc(paramb.hFb) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + bu.aSz(paramb.hFc) + "</username>");
    paramStringBuilder.append("<appid>" + bu.aSz(paramb.hFd) + "</appid>");
    if (paramb.hFs != 0) {
      paramStringBuilder.append("<version>" + paramb.hFs + "</version>");
    }
    if (paramb.hFe != 0) {
      paramStringBuilder.append("<type>" + paramb.hFe + "</type>");
    }
    if (!bu.isNullOrNil(paramb.hFt)) {
      paramStringBuilder.append("<weappiconurl>" + k.b.zc(paramb.hFt) + "</weappiconurl>");
    }
    if (!bu.isNullOrNil(paramb.hFh)) {
      paramStringBuilder.append("<shareId>" + k.b.zc(paramb.hFh) + "</shareId>");
    }
    if ((paramb.hFr == 1) || (paramb.hFr == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.hFr);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.hFf);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!bu.isNullOrNil(paramb.hFi)) {
      paramStringBuilder.append("<sharekey>" + k.b.zc(paramb.hFi) + "</sharekey>");
    }
    if (!bu.isNullOrNil(this.hAX)) {
      paramStringBuilder.append("<messageextradata>").append(k.b.zc(this.hAX)).append("</messageextradata>");
    }
    if (this.hAJ)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(k.b.zc(this.hAK));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.hAM)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.hAT);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.hAU);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(k.b.zc(this.hAN));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(k.b.zc(this.hAO));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(k.b.zc(this.hAP));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(k.b.zc(this.hAQ));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(k.b.zc(this.hAR));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(k.b.zc(this.hAS));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.hAL + "</appservicetype>");
    if (paramb.hFl != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.hFl + "</disableforward>");
    }
    if (paramb.ex(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.hFj + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + k.b.zc(paramb.hFk) + "</appnamemultilanguagekey>");
      paramStringBuilder.append("</nativeappinfo>");
    }
    paramStringBuilder.append("<videopageinfo>");
    paramb = new StringBuilder("<thumbwidth>");
    if (paramInt1 != 0)
    {
      paramStringBuilder.append(paramInt1 + "</thumbwidth>");
      paramb = new StringBuilder("<thumbheight>");
      if (paramInt2 == 0) {
        break label1475;
      }
    }
    for (;;)
    {
      paramStringBuilder.append(paramInt2 + "</thumbheight>");
      if (!bu.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + k.b.zc(this.videoSource) + "</videosource>");
      }
      if (!bu.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + k.b.zc(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.hBe + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!bu.isNullOrNil(this.hBg)) || (!bu.isNullOrNil(this.hBf)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(k.b.zc(this.hBh)).append("</videobuttontext>");
        if ((paramd != null) && (!bu.isNullOrNil(paramd.field_fileUrl)))
        {
          o.deleteFile(this.hBf);
          this.hBg = paramd.field_fileUrl;
          this.dJw = paramd.field_filemd5;
          this.hBi = paramd.field_thumbUrl;
        }
        if (bu.isNullOrNil(this.hBg)) {
          paramStringBuilder.append("<videotemplocalpath>").append(k.b.zc(this.hBf)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(k.b.zc(this.dJw)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(k.b.zc(this.hBg)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(k.b.zc(this.hBi)).append("</videothumburl>");
        paramStringBuilder.append("<videoplaydesc>").append(k.b.zc(this.hBj)).append("</videoplaydesc>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      if (this.hAV != 0) {
        paramStringBuilder.append("<tradingguaranteeflag>").append(this.hAV).append("</tradingguaranteeflag>");
      }
      if (this.hAY != 0) {
        paramStringBuilder.append("<subType>").append(this.hAY).append("</subType>");
      }
      if (!TextUtils.isEmpty(this.hAW)) {
        paramStringBuilder.append("<todoactivityid>").append(k.b.zc(this.hAW)).append("</todoactivityid>");
      }
      paramStringBuilder.append("</weappinfo>");
      if (this.hBk) {
        paramStringBuilder.append("<roomtoolsflag>1</roomtoolsflag>");
      }
      if (this.hAZ) {
        paramStringBuilder.append("<isprivatemessage>1</isprivatemessage>");
      }
      AppMethodBeat.o(2613);
      return;
      paramInt1 = this.hBc;
      break;
      label1475:
      paramInt2 = this.hBd;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    boolean bool2 = true;
    AppMethodBeat.i(2614);
    if (bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool1 = true;
      this.hAJ = bool1;
      this.hAK = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.hAL = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.hAL);
      this.hAX = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      this.hAY = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.subType"), this.hAY);
      if (bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label564;
      }
      bool1 = true;
      label136:
      this.hAM = bool1;
      this.hAN = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.hAO = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.hAP = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.hAQ = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.hAR = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.hAS = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.hAU = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.hAT = ((int)bu.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.hBc = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.hBd = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.hBe = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.hBf = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.dJw = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.hBg = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.hBh = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.hBi = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      this.hBj = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc"));
      this.hAV = bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
      this.hAW = ((String)paramMap.get(".msg.appmsg.weappinfo.todoactivityid"));
      this.hBk = bu.getBoolean((String)paramMap.get(".msg.appmsg.roomtoolsflag"), false);
      if (bu.getInt((String)paramMap.get(".msg.appmsg.weappinfo.isprivatemessage"), 0) != 1) {
        break label569;
      }
    }
    label564:
    label569:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hAZ = bool1;
      AppMethodBeat.o(2614);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label136;
    }
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(2610);
    a locala = new a();
    locala.hAJ = this.hAJ;
    locala.hAK = this.hAK;
    locala.hAL = this.hAL;
    locala.hAM = this.hAM;
    locala.hAN = this.hAN;
    locala.hAO = this.hAO;
    locala.hAP = this.hAP;
    locala.hAQ = this.hAQ;
    locala.hAR = this.hAR;
    locala.hAT = this.hAT;
    locala.hAU = this.hAU;
    locala.hAX = this.hAX;
    locala.hAY = this.hAY;
    locala.hBd = this.hBd;
    locala.hBc = this.hBc;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.hBe = this.hBe;
    locala.hBf = this.hBf;
    locala.hBg = this.hBg;
    locala.hBh = this.hBh;
    locala.hBi = this.hBi;
    locala.hBj = this.hBj;
    locala.hAV = this.hAV;
    locala.hBk = this.hBk;
    AppMethodBeat.o(2610);
    return locala;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2611);
    super.b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    if ((paramb != null) && (paramb.type == 48))
    {
      paramStringBuilder = paramb.hFd;
      if ((paramd == null) || (bu.isNullOrNil(paramStringBuilder)) || (bu.isNullOrNil(paramd.field_fileUrl)) || (bu.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = q.encode(paramd.field_fileUrl, "utf-8");
        String str3 = q.encode(paramd.field_thumbUrl, "utf-8");
        String str4 = q.encode(paramStringBuilder, "utf-8");
        if (!bu.isNullOrNil(paramb.description))
        {
          paramStringBuilder = q.encode(paramb.description, "utf-8");
          if (bu.isNullOrNil(this.hBh)) {
            break label308;
          }
          paramString = q.encode(this.hBh, "utf-8");
          if (!bu.isNullOrNil(paramb.title))
          {
            str1 = q.encode(paramb.title, "utf-8");
            paramStringBuilder = String.format("https://game.weixin.qq.com/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s", new Object[] { str2, str3, str4, paramStringBuilder, paramString, str1 });
            ae.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.hCS = paramd.field_thumbUrl;
            AppMethodBeat.o(2611);
          }
        }
        else
        {
          paramStringBuilder = "";
          continue;
        }
        String str1 = "";
        continue;
        ae.d("MicroMsg.AppContentAppBrandPiece", "hy: no cdn result or info missing. ignore");
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        ae.printErrStackTrace("MicroMsg.AppContentAppBrandPiece", paramStringBuilder, "hy: not support utf-8!", new Object[0]);
        AppMethodBeat.o(2611);
        return;
      }
      AppMethodBeat.o(2611);
      return;
      label308:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.a
 * JD-Core Version:    0.7.0.1
 */