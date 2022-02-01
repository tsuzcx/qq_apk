package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
  extends f
{
  public String appThumbUrl;
  public String dyw = "";
  public String gFA;
  public int gFB = 0;
  public String gFC;
  public boolean gFD;
  public int gFE;
  public int gFF;
  public int gFG = 0;
  public String gFH = "";
  public String gFI = "";
  public String gFJ = "";
  public String gFK = "";
  public String gFL = "";
  public boolean gFM = false;
  public boolean gFm;
  public String gFn;
  public int gFo;
  public boolean gFp;
  public String gFq;
  public String gFr;
  public String gFs;
  public String gFt;
  public String gFu;
  public String gFv;
  public int gFw;
  public int gFx;
  public int gFy = 0;
  public String gFz;
  public String videoSource;
  
  public final void a(g paramg, k.b paramb)
  {
    AppMethodBeat.i(2612);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (bt.isNullOrNil(this.gFK)) && (!bt.isNullOrNil(this.gFH)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.gFH;
      paramg.field_filemd5 = this.dyw;
      paramg.field_fileType = com.tencent.mm.i.a.fne;
      paramg.field_totalLen = ((int)i.aMN(this.gFH));
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
    AppMethodBeat.i(2611);
    super.a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    if ((paramb != null) && (paramb.type == 48))
    {
      paramStringBuilder = paramb.gJF;
      if ((paramd == null) || (bt.isNullOrNil(paramStringBuilder)) || (bt.isNullOrNil(paramd.field_fileUrl)) || (bt.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = p.encode(paramd.field_fileUrl, "utf-8");
        String str3 = p.encode(paramd.field_thumbUrl, "utf-8");
        String str4 = p.encode(paramStringBuilder, "utf-8");
        if (!bt.isNullOrNil(paramb.description))
        {
          paramStringBuilder = p.encode(paramb.description, "utf-8");
          if (bt.isNullOrNil(this.gFJ)) {
            break label295;
          }
          paramString = p.encode(this.gFJ, "utf-8");
          if (!bt.isNullOrNil(paramb.title))
          {
            str1 = p.encode(paramb.title, "utf-8");
            paramStringBuilder = String.format("https://game.weixin.qq.com/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s", new Object[] { str2, str3, str4, paramStringBuilder, paramString, str1 });
            ad.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.gHu = paramd.field_thumbUrl;
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
        ad.d("MicroMsg.AppContentAppBrandPiece", "hy: no cdn result or info missing. ignore");
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        ad.printErrStackTrace("MicroMsg.AppContentAppBrandPiece", paramStringBuilder, "hy: not support utf-8!", new Object[0]);
        AppMethodBeat.o(2611);
        return;
      }
      AppMethodBeat.o(2611);
      return;
      label295:
      paramString = "";
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(2614);
    if (bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool = true;
      this.gFm = bool;
      this.gFn = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.gFo = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.gFo);
      this.gFA = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      this.gFB = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.subType"), this.gFB);
      if (bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label522;
      }
    }
    label522:
    for (boolean bool = true;; bool = false)
    {
      this.gFp = bool;
      this.gFq = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.gFr = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.gFs = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.gFt = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.gFu = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.gFv = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.gFx = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.gFw = ((int)bt.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.gFE = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.gFF = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.gFG = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.gFH = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.dyw = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.gFI = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.gFJ = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.gFK = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      this.gFL = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc"));
      this.gFy = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
      this.gFz = ((String)paramMap.get(".msg.appmsg.weappinfo.todoactivityid"));
      this.gFM = bt.getBoolean((String)paramMap.get(".msg.appmsg.roomtoolsflag"), false);
      AppMethodBeat.o(2614);
      return;
      bool = false;
      break;
    }
  }
  
  public final f apu()
  {
    AppMethodBeat.i(2610);
    a locala = new a();
    locala.gFm = this.gFm;
    locala.gFn = this.gFn;
    locala.gFo = this.gFo;
    locala.gFp = this.gFp;
    locala.gFq = this.gFq;
    locala.gFr = this.gFr;
    locala.gFs = this.gFs;
    locala.gFt = this.gFt;
    locala.gFu = this.gFu;
    locala.gFw = this.gFw;
    locala.gFx = this.gFx;
    locala.gFA = this.gFA;
    locala.gFB = this.gFB;
    locala.gFF = this.gFF;
    locala.gFE = this.gFE;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.gFG = this.gFG;
    locala.gFH = this.gFH;
    locala.gFI = this.gFI;
    locala.gFJ = this.gFJ;
    locala.gFK = this.gFK;
    locala.gFL = this.gFL;
    locala.gFy = this.gFy;
    locala.gFM = this.gFM;
    AppMethodBeat.o(2610);
    return locala;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2613);
    paramStringBuilder.append("<weappinfo>");
    if (!bt.isNullOrNil(paramb.gJD)) {
      paramStringBuilder.append("<pagepath>" + k.b.ry(paramb.gJD) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + bt.aGf(paramb.gJE) + "</username>");
    paramStringBuilder.append("<appid>" + bt.aGf(paramb.gJF) + "</appid>");
    if (paramb.gJR != 0) {
      paramStringBuilder.append("<version>" + paramb.gJR + "</version>");
    }
    if (paramb.gJG != 0) {
      paramStringBuilder.append("<type>" + paramb.gJG + "</type>");
    }
    if (!bt.isNullOrNil(paramb.gJS)) {
      paramStringBuilder.append("<weappiconurl>" + k.b.ry(paramb.gJS) + "</weappiconurl>");
    }
    if (!bt.isNullOrNil(paramb.gJJ)) {
      paramStringBuilder.append("<shareId>" + k.b.ry(paramb.gJJ) + "</shareId>");
    }
    if ((paramb.gJQ == 1) || (paramb.gJQ == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.gJQ);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.gJH);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!bt.isNullOrNil(paramb.gJK)) {
      paramStringBuilder.append("<sharekey>" + k.b.ry(paramb.gJK) + "</sharekey>");
    }
    if (!bt.isNullOrNil(this.gFA)) {
      paramStringBuilder.append("<messageextradata>").append(k.b.ry(this.gFA)).append("</messageextradata>");
    }
    if (this.gFm)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(k.b.ry(this.gFn));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.gFp)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.gFw);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.gFx);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(k.b.ry(this.gFq));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(k.b.ry(this.gFr));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(k.b.ry(this.gFs));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(k.b.ry(this.gFt));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(k.b.ry(this.gFu));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(k.b.ry(this.gFv));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.gFo + "</appservicetype>");
    if (paramb.gJN != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.gJN + "</disableforward>");
    }
    if (paramb.dY(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.gJL + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + k.b.ry(paramb.gJM) + "</appnamemultilanguagekey>");
      paramStringBuilder.append("</nativeappinfo>");
    }
    paramStringBuilder.append("<videopageinfo>");
    paramb = new StringBuilder("<thumbwidth>");
    if (paramInt1 != 0)
    {
      paramStringBuilder.append(paramInt1 + "</thumbwidth>");
      paramb = new StringBuilder("<thumbheight>");
      if (paramInt2 == 0) {
        break label1493;
      }
    }
    for (;;)
    {
      paramStringBuilder.append(paramInt2 + "</thumbheight>");
      if (!bt.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + k.b.ry(this.videoSource) + "</videosource>");
      }
      if (!bt.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + k.b.ry(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.gFG + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!bt.isNullOrNil(this.gFI)) || (!bt.isNullOrNil(this.gFH)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(k.b.ry(this.gFJ)).append("</videobuttontext>");
        if ((paramd != null) && (!bt.isNullOrNil(paramd.field_fileUrl)))
        {
          i.deleteFile(this.gFH);
          this.gFI = paramd.field_fileUrl;
          this.dyw = paramd.field_filemd5;
          this.gFK = paramd.field_thumbUrl;
        }
        if (bt.isNullOrNil(this.gFI)) {
          paramStringBuilder.append("<videotemplocalpath>").append(k.b.ry(this.gFH)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(k.b.ry(this.dyw)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(k.b.ry(this.gFI)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(k.b.ry(this.gFK)).append("</videothumburl>");
        paramStringBuilder.append("<videoplaydesc>").append(k.b.ry(this.gFL)).append("</videoplaydesc>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      if (this.gFy != 0) {
        paramStringBuilder.append("<tradingguaranteeflag>").append(this.gFy).append("</tradingguaranteeflag>");
      }
      if (this.gFB != 0) {
        paramStringBuilder.append("<subType>").append(this.gFB).append("</subType>");
      }
      if (!TextUtils.isEmpty(this.gFz)) {
        paramStringBuilder.append("<todoactivityid>").append(k.b.ry(this.gFz)).append("</todoactivityid>");
      }
      paramStringBuilder.append("</weappinfo>");
      if (this.gFM) {
        paramStringBuilder.append("<roomtoolsflag>1</roomtoolsflag>");
      }
      AppMethodBeat.o(2613);
      return;
      paramInt1 = this.gFE;
      break;
      label1493:
      paramInt2 = this.gFF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.a
 * JD-Core Version:    0.7.0.1
 */