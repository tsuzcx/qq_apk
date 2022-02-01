package com.tencent.mm.aj;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.api.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
  extends f
{
  public String appThumbUrl;
  public String fVg = "";
  public String imageUrl;
  public boolean ljZ;
  public String lka;
  public int lkb;
  public boolean lkc;
  public String lkd;
  public String lke;
  public String lkf;
  public String lkg;
  public String lkh;
  public String lki;
  public int lkj;
  public int lkk;
  public int lkl = 0;
  public String lkm;
  public String lkn;
  public int lko = 0;
  public boolean lkp;
  public boolean lkq;
  public int lkr;
  public int lks;
  public int lkt = 0;
  public String lku = "";
  public String lkv = "";
  public String lkw = "";
  public String lkx = "";
  public String lky = "";
  public boolean lkz = false;
  public String videoSource;
  
  public final void a(g paramg, k.b paramb)
  {
    AppMethodBeat.i(2612);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (Util.isNullOrNil(this.lkx)) && (!Util.isNullOrNil(this.lku)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.lku;
      paramg.field_filemd5 = this.fVg;
      paramg.field_fileType = com.tencent.mm.i.a.iUd;
      paramg.field_totalLen = ((int)u.bBQ(this.lku));
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
    if (!Util.isNullOrNil(paramb.loz)) {
      paramStringBuilder.append("<pagepath>" + k.b.OR(paramb.loz) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + Util.escapeStringForXml(paramb.loA) + "</username>");
    paramStringBuilder.append("<appid>" + Util.escapeStringForXml(paramb.loB) + "</appid>");
    if (paramb.loU != 0) {
      paramStringBuilder.append("<version>" + paramb.loU + "</version>");
    }
    if (paramb.loC != 0) {
      paramStringBuilder.append("<type>" + paramb.loC + "</type>");
    }
    if (!Util.isNullOrNil(paramb.loV)) {
      paramStringBuilder.append("<weappiconurl>" + k.b.OR(paramb.loV) + "</weappiconurl>");
    }
    if (!Util.isNullOrNil(this.imageUrl)) {
      paramStringBuilder.append("<weapppagethumbrawurl>" + k.b.OR(this.imageUrl) + "</weapppagethumbrawurl>");
    }
    if (!Util.isNullOrNil(paramb.loF)) {
      paramStringBuilder.append("<shareId>" + k.b.OR(paramb.loF) + "</shareId>");
    }
    if ((paramb.loT == 1) || (paramb.loT == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.loT);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.loD);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!Util.isNullOrNil(paramb.loG)) {
      paramStringBuilder.append("<sharekey>" + k.b.OR(paramb.loG) + "</sharekey>");
    }
    if (!Util.isNullOrNil(this.lkn)) {
      paramStringBuilder.append("<messageextradata>").append(k.b.OR(this.lkn)).append("</messageextradata>");
    }
    if (this.ljZ)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(k.b.OR(this.lka));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.lkc)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.lkj);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.lkk);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(k.b.OR(this.lkd));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(k.b.OR(this.lke));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(k.b.OR(this.lkf));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(k.b.OR(this.lkg));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(k.b.OR(this.lkh));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(k.b.OR(this.lki));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.lkb + "</appservicetype>");
    if (paramb.loJ != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.loJ + "</disableforward>");
    }
    paramStringBuilder.append("<secflagforsinglepagemode>" + paramb.loM + "</secflagforsinglepagemode>");
    if (paramb.fX(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.loH + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + k.b.OR(paramb.loI) + "</appnamemultilanguagekey>");
      paramStringBuilder.append("<sourcename>" + k.b.OR(paramb.loK) + "</sourcename>");
      paramStringBuilder.append("<sourceiconurl>" + k.b.OR(paramb.loL) + "</sourceiconurl>");
      paramStringBuilder.append("</nativeappinfo>");
    }
    paramStringBuilder.append("<videopageinfo>");
    paramb = new StringBuilder("<thumbwidth>");
    if (paramInt1 != 0)
    {
      paramStringBuilder.append(paramInt1 + "</thumbwidth>");
      paramb = new StringBuilder("<thumbheight>");
      if (paramInt2 == 0) {
        break label1618;
      }
    }
    for (;;)
    {
      paramStringBuilder.append(paramInt2 + "</thumbheight>");
      if (!Util.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + k.b.OR(this.videoSource) + "</videosource>");
      }
      if (!Util.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + k.b.OR(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.lkt + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!Util.isNullOrNil(this.lkv)) || (!Util.isNullOrNil(this.lku)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(k.b.OR(this.lkw)).append("</videobuttontext>");
        if ((paramd != null) && (!Util.isNullOrNil(paramd.field_fileUrl)))
        {
          u.deleteFile(this.lku);
          this.lkv = paramd.field_fileUrl;
          this.fVg = paramd.field_filemd5;
          this.lkx = paramd.field_thumbUrl;
        }
        if (Util.isNullOrNil(this.lkv)) {
          paramStringBuilder.append("<videotemplocalpath>").append(k.b.OR(this.lku)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(k.b.OR(this.fVg)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(k.b.OR(this.lkv)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(k.b.OR(this.lkx)).append("</videothumburl>");
        paramStringBuilder.append("<videoplaydesc>").append(k.b.OR(this.lky)).append("</videoplaydesc>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      if (this.lkl != 0) {
        paramStringBuilder.append("<tradingguaranteeflag>").append(this.lkl).append("</tradingguaranteeflag>");
      }
      if (this.lko != 0) {
        paramStringBuilder.append("<subType>").append(this.lko).append("</subType>");
      }
      if (!TextUtils.isEmpty(this.lkm)) {
        paramStringBuilder.append("<todoactivityid>").append(k.b.OR(this.lkm)).append("</todoactivityid>");
      }
      paramStringBuilder.append("</weappinfo>");
      if (this.lkz) {
        paramStringBuilder.append("<roomtoolsflag>1</roomtoolsflag>");
      }
      if (this.lkp) {
        paramStringBuilder.append("<isprivatemessage>1</isprivatemessage>");
      }
      AppMethodBeat.o(2613);
      return;
      paramInt1 = this.lkr;
      break;
      label1618:
      paramInt2 = this.lks;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    boolean bool2 = true;
    AppMethodBeat.i(2614);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool1 = true;
      this.ljZ = bool1;
      this.lka = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.lkb = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.lkb);
      this.lkn = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      this.lko = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.subType"), this.lko);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label580;
      }
      bool1 = true;
      label136:
      this.lkc = bool1;
      this.lkd = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.lke = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.lkf = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.lkg = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.lkh = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.lki = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.lkk = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.lkj = ((int)Util.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.lkr = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.lks = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.lkt = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.lku = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.fVg = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.lkv = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.lkw = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.lkx = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      this.lky = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc"));
      this.lkl = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
      this.lkm = ((String)paramMap.get(".msg.appmsg.weappinfo.todoactivityid"));
      this.lkz = Util.getBoolean((String)paramMap.get(".msg.appmsg.roomtoolsflag"), false);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.isprivatemessage"), 0) != 1) {
        break label585;
      }
    }
    label580:
    label585:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.lkp = bool1;
      this.imageUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.weapppagethumbrawurl"));
      AppMethodBeat.o(2614);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label136;
    }
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(2610);
    a locala = new a();
    locala.ljZ = this.ljZ;
    locala.lka = this.lka;
    locala.lkb = this.lkb;
    locala.lkc = this.lkc;
    locala.lkd = this.lkd;
    locala.lke = this.lke;
    locala.lkf = this.lkf;
    locala.lkg = this.lkg;
    locala.lkh = this.lkh;
    locala.lkj = this.lkj;
    locala.lkk = this.lkk;
    locala.lkn = this.lkn;
    locala.lko = this.lko;
    locala.lks = this.lks;
    locala.lkr = this.lkr;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.lkt = this.lkt;
    locala.lku = this.lku;
    locala.lkv = this.lkv;
    locala.lkw = this.lkw;
    locala.lkx = this.lkx;
    locala.lky = this.lky;
    locala.lkl = this.lkl;
    locala.lkz = this.lkz;
    locala.imageUrl = this.imageUrl;
    AppMethodBeat.o(2610);
    return locala;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2611);
    super.b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    if ((paramb != null) && (paramb.type == 48))
    {
      paramStringBuilder = paramb.loB;
      if ((paramd == null) || (Util.isNullOrNil(paramStringBuilder)) || (Util.isNullOrNil(paramd.field_fileUrl)) || (Util.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = "https://" + WeChatHosts.domainString(a.a.host_game_weixin_qq_com) + "/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s";
        String str3 = q.an(paramd.field_fileUrl, "utf-8");
        String str4 = q.an(paramd.field_thumbUrl, "utf-8");
        String str5 = q.an(paramStringBuilder, "utf-8");
        if (!Util.isNullOrNil(paramb.description))
        {
          paramStringBuilder = q.an(paramb.description, "utf-8");
          if (Util.isNullOrNil(this.lkw)) {
            break label337;
          }
          paramString = q.an(this.lkw, "utf-8");
          if (!Util.isNullOrNil(paramb.title))
          {
            str1 = q.an(paramb.title, "utf-8");
            paramStringBuilder = String.format(str2, new Object[] { str3, str4, str5, paramStringBuilder, paramString, str1 });
            Log.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.lmm = paramd.field_thumbUrl;
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
        Log.d("MicroMsg.AppContentAppBrandPiece", "hy: no cdn result or info missing. ignore");
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        Log.printErrStackTrace("MicroMsg.AppContentAppBrandPiece", paramStringBuilder, "hy: not support utf-8!", new Object[0]);
        AppMethodBeat.o(2611);
        return;
      }
      AppMethodBeat.o(2611);
      return;
      label337:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.a
 * JD-Core Version:    0.7.0.1
 */