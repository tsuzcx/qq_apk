package com.tencent.mm.message;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g;
import com.tencent.mm.plugin.appbrand.api.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.y;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
  extends f
{
  public String appThumbUrl;
  public String ibd = "";
  public String imageUrl;
  public boolean nOK;
  public String nOL;
  public int nOM;
  public boolean nON;
  public String nOO;
  public String nOP;
  public String nOQ;
  public String nOR;
  public String nOS;
  public String nOT;
  public int nOU;
  public int nOV;
  public int nOW = 0;
  public int nOX = 0;
  public String nOY;
  public String nOZ;
  public int nPa = 0;
  public boolean nPb;
  public boolean nPc;
  public int nPd;
  public int nPe;
  public int nPf = 0;
  public String nPg = "";
  public String nPh = "";
  public String nPi = "";
  public String nPj = "";
  public String nPk = "";
  public boolean nPl = false;
  public String videoSource;
  
  public final void a(g paramg, k.b paramb)
  {
    AppMethodBeat.i(2612);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (Util.isNullOrNil(this.nPj)) && (!Util.isNullOrNil(this.nPg)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.nPg;
      paramg.field_filemd5 = this.ibd;
      paramg.field_fileType = com.tencent.mm.g.a.lwi;
      paramg.field_totalLen = ((int)y.bEl(this.nPg));
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
    if (!Util.isNullOrNil(paramb.nTC)) {
      paramStringBuilder.append("<pagepath>" + k.b.Hg(paramb.nTC) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + Util.escapeStringForXml(paramb.nTD) + "</username>");
    paramStringBuilder.append("<appid>" + Util.escapeStringForXml(paramb.nTE) + "</appid>");
    if (paramb.nTX != 0) {
      paramStringBuilder.append("<version>" + paramb.nTX + "</version>");
    }
    if (paramb.nTF != 0) {
      paramStringBuilder.append("<type>" + paramb.nTF + "</type>");
    }
    if (!Util.isNullOrNil(paramb.nTY)) {
      paramStringBuilder.append("<weappiconurl>" + k.b.Hg(paramb.nTY) + "</weappiconurl>");
    }
    if (!Util.isNullOrNil(this.imageUrl)) {
      paramStringBuilder.append("<weapppagethumbrawurl>" + k.b.Hg(this.imageUrl) + "</weapppagethumbrawurl>");
    }
    if (!Util.isNullOrNil(paramb.nTI)) {
      paramStringBuilder.append("<shareId>" + k.b.Hg(paramb.nTI) + "</shareId>");
    }
    if ((paramb.nTW == 1) || (paramb.nTW == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.nTW);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.nTG);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!Util.isNullOrNil(paramb.nTJ)) {
      paramStringBuilder.append("<sharekey>" + k.b.Hg(paramb.nTJ) + "</sharekey>");
    }
    if (!Util.isNullOrNil(this.nOZ)) {
      paramStringBuilder.append("<messageextradata>").append(k.b.Hg(this.nOZ)).append("</messageextradata>");
    }
    if (this.nOK)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(k.b.Hg(this.nOL));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.nON)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.nOU);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.nOV);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(k.b.Hg(this.nOO));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(k.b.Hg(this.nOP));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(k.b.Hg(this.nOQ));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(k.b.Hg(this.nOR));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(k.b.Hg(this.nOS));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(k.b.Hg(this.nOT));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.nOM + "</appservicetype>");
    if (paramb.nTM != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.nTM + "</disableforward>");
    }
    paramStringBuilder.append("<secflagforsinglepagemode>" + paramb.nTP + "</secflagforsinglepagemode>");
    if (paramb.gK(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.nTK + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + k.b.Hg(paramb.nTL) + "</appnamemultilanguagekey>");
      paramStringBuilder.append("<sourcename>" + k.b.Hg(paramb.nTN) + "</sourcename>");
      paramStringBuilder.append("<sourceiconurl>" + k.b.Hg(paramb.nTO) + "</sourceiconurl>");
      paramStringBuilder.append("</nativeappinfo>");
    }
    paramStringBuilder.append("<videopageinfo>");
    paramb = new StringBuilder("<thumbwidth>");
    if (paramInt1 != 0)
    {
      paramStringBuilder.append(paramInt1 + "</thumbwidth>");
      paramb = new StringBuilder("<thumbheight>");
      if (paramInt2 == 0) {
        break label1647;
      }
    }
    for (;;)
    {
      paramStringBuilder.append(paramInt2 + "</thumbheight>");
      if (!Util.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + k.b.Hg(this.videoSource) + "</videosource>");
      }
      if (!Util.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + k.b.Hg(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.nPf + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!Util.isNullOrNil(this.nPh)) || (!Util.isNullOrNil(this.nPg)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(k.b.Hg(this.nPi)).append("</videobuttontext>");
        if ((paramd != null) && (!Util.isNullOrNil(paramd.field_fileUrl)))
        {
          y.deleteFile(this.nPg);
          this.nPh = paramd.field_fileUrl;
          this.ibd = paramd.field_filemd5;
          this.nPj = paramd.field_thumbUrl;
        }
        if (Util.isNullOrNil(this.nPh)) {
          paramStringBuilder.append("<videotemplocalpath>").append(k.b.Hg(this.nPg)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(k.b.Hg(this.ibd)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(k.b.Hg(this.nPh)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(k.b.Hg(this.nPj)).append("</videothumburl>");
        paramStringBuilder.append("<videoplaydesc>").append(k.b.Hg(this.nPk)).append("</videoplaydesc>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      if (this.nOW != 0) {
        paramStringBuilder.append("<tradingguaranteeflag>").append(this.nOW).append("</tradingguaranteeflag>");
      }
      if (this.nOX != 0) {
        paramStringBuilder.append("<showRelievedBuyFlag>").append(this.nOX).append("</showRelievedBuyFlag>");
      }
      if (this.nPa != 0) {
        paramStringBuilder.append("<subType>").append(this.nPa).append("</subType>");
      }
      if (!TextUtils.isEmpty(this.nOY)) {
        paramStringBuilder.append("<todoactivityid>").append(k.b.Hg(this.nOY)).append("</todoactivityid>");
      }
      paramStringBuilder.append("</weappinfo>");
      if (this.nPl) {
        paramStringBuilder.append("<roomtoolsflag>1</roomtoolsflag>");
      }
      if (this.nPb) {
        paramStringBuilder.append("<isprivatemessage>1</isprivatemessage>");
      }
      AppMethodBeat.o(2613);
      return;
      paramInt1 = this.nPd;
      break;
      label1647:
      paramInt2 = this.nPe;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    boolean bool2 = true;
    AppMethodBeat.i(2614);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool1 = true;
      this.nOK = bool1;
      this.nOL = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.nOM = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.nOM);
      this.nOZ = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      this.nPa = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.subType"), this.nPa);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label600;
      }
      bool1 = true;
      label136:
      this.nON = bool1;
      this.nOO = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.nOP = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.nOQ = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.nOR = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.nOS = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.nOT = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.nOV = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.nOU = ((int)Util.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.nPd = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.nPe = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.nPf = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.nPg = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.ibd = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.nPh = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.nPi = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.nPj = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      this.nPk = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc"));
      this.nOW = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
      this.nOX = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.showRelievedBuyFlag"), 0);
      this.nOY = ((String)paramMap.get(".msg.appmsg.weappinfo.todoactivityid"));
      this.nPl = Util.getBoolean((String)paramMap.get(".msg.appmsg.roomtoolsflag"), false);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.isprivatemessage"), 0) != 1) {
        break label605;
      }
    }
    label600:
    label605:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.nPb = bool1;
      this.imageUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.weapppagethumbrawurl"));
      AppMethodBeat.o(2614);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label136;
    }
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2611);
    super.b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    if ((paramb != null) && (paramb.type == 48))
    {
      paramStringBuilder = paramb.nTE;
      if ((paramd == null) || (Util.isNullOrNil(paramStringBuilder)) || (Util.isNullOrNil(paramd.field_fileUrl)) || (Util.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = "https://" + WeChatHosts.domainString(a.a.host_game_weixin_qq_com) + "/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s";
        String str3 = r.as(paramd.field_fileUrl, "utf-8");
        String str4 = r.as(paramd.field_thumbUrl, "utf-8");
        String str5 = r.as(paramStringBuilder, "utf-8");
        if (!Util.isNullOrNil(paramb.description))
        {
          paramStringBuilder = r.as(paramb.description, "utf-8");
          if (Util.isNullOrNil(this.nPi)) {
            break label337;
          }
          paramString = r.as(this.nPi, "utf-8");
          if (!Util.isNullOrNil(paramb.title))
          {
            str1 = r.as(paramb.title, "utf-8");
            paramStringBuilder = String.format(str2, new Object[] { str3, str4, str5, paramStringBuilder, paramString, str1 });
            Log.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.nRr = paramd.field_thumbUrl;
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
  
  public final f biW()
  {
    AppMethodBeat.i(2610);
    a locala = new a();
    locala.nOK = this.nOK;
    locala.nOL = this.nOL;
    locala.nOM = this.nOM;
    locala.nON = this.nON;
    locala.nOO = this.nOO;
    locala.nOP = this.nOP;
    locala.nOQ = this.nOQ;
    locala.nOR = this.nOR;
    locala.nOS = this.nOS;
    locala.nOU = this.nOU;
    locala.nOV = this.nOV;
    locala.nOZ = this.nOZ;
    locala.nPa = this.nPa;
    locala.nPe = this.nPe;
    locala.nPd = this.nPd;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.nPf = this.nPf;
    locala.nPg = this.nPg;
    locala.nPh = this.nPh;
    locala.nPi = this.nPi;
    locala.nPj = this.nPj;
    locala.nPk = this.nPk;
    locala.nOW = this.nOW;
    locala.nOX = this.nOX;
    locala.nPl = this.nPl;
    locala.imageUrl = this.imageUrl;
    AppMethodBeat.o(2610);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.a
 * JD-Core Version:    0.7.0.1
 */