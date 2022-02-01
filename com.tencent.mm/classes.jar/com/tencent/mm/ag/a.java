package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
  extends f
{
  public String appThumbUrl;
  public String ebj = "";
  public String imageUrl;
  public boolean iuQ;
  public String iuR;
  public int iuS;
  public boolean iuT;
  public String iuU;
  public String iuV;
  public String iuW;
  public String iuX;
  public String iuY;
  public String iuZ;
  public int iva;
  public int ivb;
  public int ivc = 0;
  public String ivd;
  public String ive;
  public int ivf = 0;
  public boolean ivg;
  public boolean ivh;
  public int ivi;
  public int ivj;
  public int ivk = 0;
  public String ivl = "";
  public String ivm = "";
  public String ivn = "";
  public String ivo = "";
  public String ivp = "";
  public boolean ivq = false;
  public String videoSource;
  
  public final void a(g paramg, k.b paramb)
  {
    AppMethodBeat.i(2612);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (Util.isNullOrNil(this.ivo)) && (!Util.isNullOrNil(this.ivl)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.ivl;
      paramg.field_filemd5 = this.ebj;
      paramg.field_fileType = com.tencent.mm.i.a.gpV;
      paramg.field_totalLen = ((int)s.boW(this.ivl));
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
    if (!Util.isNullOrNil(paramb.izh)) {
      paramStringBuilder.append("<pagepath>" + k.b.HE(paramb.izh) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + Util.escapeStringForXml(paramb.izi) + "</username>");
    paramStringBuilder.append("<appid>" + Util.escapeStringForXml(paramb.izj) + "</appid>");
    if (paramb.izA != 0) {
      paramStringBuilder.append("<version>" + paramb.izA + "</version>");
    }
    if (paramb.izk != 0) {
      paramStringBuilder.append("<type>" + paramb.izk + "</type>");
    }
    if (!Util.isNullOrNil(paramb.izB)) {
      paramStringBuilder.append("<weappiconurl>" + k.b.HE(paramb.izB) + "</weappiconurl>");
    }
    if (!Util.isNullOrNil(this.imageUrl)) {
      paramStringBuilder.append("<weapppagethumbrawurl>" + k.b.HE(this.imageUrl) + "</weapppagethumbrawurl>");
    }
    if (!Util.isNullOrNil(paramb.izn)) {
      paramStringBuilder.append("<shareId>" + k.b.HE(paramb.izn) + "</shareId>");
    }
    if ((paramb.izz == 1) || (paramb.izz == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.izz);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.izl);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!Util.isNullOrNil(paramb.izo)) {
      paramStringBuilder.append("<sharekey>" + k.b.HE(paramb.izo) + "</sharekey>");
    }
    if (!Util.isNullOrNil(this.ive)) {
      paramStringBuilder.append("<messageextradata>").append(k.b.HE(this.ive)).append("</messageextradata>");
    }
    if (this.iuQ)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(k.b.HE(this.iuR));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.iuT)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.iva);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.ivb);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(k.b.HE(this.iuU));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(k.b.HE(this.iuV));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(k.b.HE(this.iuW));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(k.b.HE(this.iuX));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(k.b.HE(this.iuY));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(k.b.HE(this.iuZ));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.iuS + "</appservicetype>");
    if (paramb.izr != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.izr + "</disableforward>");
    }
    if (paramb.fn(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.izp + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + k.b.HE(paramb.izq) + "</appnamemultilanguagekey>");
      paramStringBuilder.append("<sourcename>" + k.b.HE(paramb.izs) + "</sourcename>");
      paramStringBuilder.append("<sourceiconurl>" + k.b.HE(paramb.izt) + "</sourceiconurl>");
      paramStringBuilder.append("</nativeappinfo>");
    }
    paramStringBuilder.append("<videopageinfo>");
    paramb = new StringBuilder("<thumbwidth>");
    if (paramInt1 != 0)
    {
      paramStringBuilder.append(paramInt1 + "</thumbwidth>");
      paramb = new StringBuilder("<thumbheight>");
      if (paramInt2 == 0) {
        break label1587;
      }
    }
    for (;;)
    {
      paramStringBuilder.append(paramInt2 + "</thumbheight>");
      if (!Util.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + k.b.HE(this.videoSource) + "</videosource>");
      }
      if (!Util.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + k.b.HE(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.ivk + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!Util.isNullOrNil(this.ivm)) || (!Util.isNullOrNil(this.ivl)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(k.b.HE(this.ivn)).append("</videobuttontext>");
        if ((paramd != null) && (!Util.isNullOrNil(paramd.field_fileUrl)))
        {
          s.deleteFile(this.ivl);
          this.ivm = paramd.field_fileUrl;
          this.ebj = paramd.field_filemd5;
          this.ivo = paramd.field_thumbUrl;
        }
        if (Util.isNullOrNil(this.ivm)) {
          paramStringBuilder.append("<videotemplocalpath>").append(k.b.HE(this.ivl)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(k.b.HE(this.ebj)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(k.b.HE(this.ivm)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(k.b.HE(this.ivo)).append("</videothumburl>");
        paramStringBuilder.append("<videoplaydesc>").append(k.b.HE(this.ivp)).append("</videoplaydesc>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      if (this.ivc != 0) {
        paramStringBuilder.append("<tradingguaranteeflag>").append(this.ivc).append("</tradingguaranteeflag>");
      }
      if (this.ivf != 0) {
        paramStringBuilder.append("<subType>").append(this.ivf).append("</subType>");
      }
      if (!TextUtils.isEmpty(this.ivd)) {
        paramStringBuilder.append("<todoactivityid>").append(k.b.HE(this.ivd)).append("</todoactivityid>");
      }
      paramStringBuilder.append("</weappinfo>");
      if (this.ivq) {
        paramStringBuilder.append("<roomtoolsflag>1</roomtoolsflag>");
      }
      if (this.ivg) {
        paramStringBuilder.append("<isprivatemessage>1</isprivatemessage>");
      }
      AppMethodBeat.o(2613);
      return;
      paramInt1 = this.ivi;
      break;
      label1587:
      paramInt2 = this.ivj;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    boolean bool2 = true;
    AppMethodBeat.i(2614);
    if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool1 = true;
      this.iuQ = bool1;
      this.iuR = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.iuS = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.iuS);
      this.ive = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      this.ivf = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.subType"), this.ivf);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label580;
      }
      bool1 = true;
      label136:
      this.iuT = bool1;
      this.iuU = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.iuV = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.iuW = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.iuX = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.iuY = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.iuZ = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.ivb = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.iva = ((int)Util.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.ivi = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.ivj = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.ivk = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.ivl = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.ebj = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.ivm = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.ivn = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.ivo = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      this.ivp = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc"));
      this.ivc = Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
      this.ivd = ((String)paramMap.get(".msg.appmsg.weappinfo.todoactivityid"));
      this.ivq = Util.getBoolean((String)paramMap.get(".msg.appmsg.roomtoolsflag"), false);
      if (Util.getInt((String)paramMap.get(".msg.appmsg.weappinfo.isprivatemessage"), 0) != 1) {
        break label585;
      }
    }
    label580:
    label585:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ivg = bool1;
      this.imageUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.weapppagethumbrawurl"));
      AppMethodBeat.o(2614);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label136;
    }
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(2610);
    a locala = new a();
    locala.iuQ = this.iuQ;
    locala.iuR = this.iuR;
    locala.iuS = this.iuS;
    locala.iuT = this.iuT;
    locala.iuU = this.iuU;
    locala.iuV = this.iuV;
    locala.iuW = this.iuW;
    locala.iuX = this.iuX;
    locala.iuY = this.iuY;
    locala.iva = this.iva;
    locala.ivb = this.ivb;
    locala.ive = this.ive;
    locala.ivf = this.ivf;
    locala.ivj = this.ivj;
    locala.ivi = this.ivi;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.ivk = this.ivk;
    locala.ivl = this.ivl;
    locala.ivm = this.ivm;
    locala.ivn = this.ivn;
    locala.ivo = this.ivo;
    locala.ivp = this.ivp;
    locala.ivc = this.ivc;
    locala.ivq = this.ivq;
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
      paramStringBuilder = paramb.izj;
      if ((paramd == null) || (Util.isNullOrNil(paramStringBuilder)) || (Util.isNullOrNil(paramd.field_fileUrl)) || (Util.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = "https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s";
        String str3 = q.encode(paramd.field_fileUrl, "utf-8");
        String str4 = q.encode(paramd.field_thumbUrl, "utf-8");
        String str5 = q.encode(paramStringBuilder, "utf-8");
        if (!Util.isNullOrNil(paramb.description))
        {
          paramStringBuilder = q.encode(paramb.description, "utf-8");
          if (Util.isNullOrNil(this.ivn)) {
            break label337;
          }
          paramString = q.encode(this.ivn, "utf-8");
          if (!Util.isNullOrNil(paramb.title))
          {
            str1 = q.encode(paramb.title, "utf-8");
            paramStringBuilder = String.format(str2, new Object[] { str3, str4, str5, paramStringBuilder, paramString, str1 });
            Log.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.iwX = paramd.field_thumbUrl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.a
 * JD-Core Version:    0.7.0.1
 */