package com.tencent.mm.ah;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
  extends f
{
  public String appThumbUrl;
  public String dwi = "";
  public boolean hfN;
  public String hfO;
  public int hfP;
  public boolean hfQ;
  public String hfR;
  public String hfS;
  public String hfT;
  public String hfU;
  public String hfV;
  public String hfW;
  public int hfX;
  public int hfY;
  public int hfZ = 0;
  public String hga;
  public String hgb;
  public int hgc = 0;
  public String hgd;
  public boolean hge;
  public int hgf;
  public int hgg;
  public int hgh = 0;
  public String hgi = "";
  public String hgj = "";
  public String hgk = "";
  public String hgl = "";
  public String hgm = "";
  public boolean hgn = false;
  public String videoSource;
  
  public final void a(g paramg, k.b paramb)
  {
    AppMethodBeat.i(2612);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (bs.isNullOrNil(this.hgl)) && (!bs.isNullOrNil(this.hgi)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.hgi;
      paramg.field_filemd5 = this.dwi;
      paramg.field_fileType = com.tencent.mm.i.a.fqy;
      paramg.field_totalLen = ((int)i.aSp(this.hgi));
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
    if (!bs.isNullOrNil(paramb.hkd)) {
      paramStringBuilder.append("<pagepath>" + k.b.vB(paramb.hkd) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + bs.aLw(paramb.hke) + "</username>");
    paramStringBuilder.append("<appid>" + bs.aLw(paramb.hkf) + "</appid>");
    if (paramb.hkr != 0) {
      paramStringBuilder.append("<version>" + paramb.hkr + "</version>");
    }
    if (paramb.hkg != 0) {
      paramStringBuilder.append("<type>" + paramb.hkg + "</type>");
    }
    if (!bs.isNullOrNil(paramb.hks)) {
      paramStringBuilder.append("<weappiconurl>" + k.b.vB(paramb.hks) + "</weappiconurl>");
    }
    if (!bs.isNullOrNil(paramb.hkj)) {
      paramStringBuilder.append("<shareId>" + k.b.vB(paramb.hkj) + "</shareId>");
    }
    if ((paramb.hkq == 1) || (paramb.hkq == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.hkq);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.hkh);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!bs.isNullOrNil(paramb.hkk)) {
      paramStringBuilder.append("<sharekey>" + k.b.vB(paramb.hkk) + "</sharekey>");
    }
    if (!bs.isNullOrNil(this.hgb)) {
      paramStringBuilder.append("<messageextradata>").append(k.b.vB(this.hgb)).append("</messageextradata>");
    }
    if (this.hfN)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(k.b.vB(this.hfO));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.hfQ)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.hfX);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.hfY);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(k.b.vB(this.hfR));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(k.b.vB(this.hfS));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(k.b.vB(this.hfT));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(k.b.vB(this.hfU));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(k.b.vB(this.hfV));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(k.b.vB(this.hfW));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.hfP + "</appservicetype>");
    if (paramb.hkn != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.hkn + "</disableforward>");
    }
    if (paramb.et(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.hkl + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + k.b.vB(paramb.hkm) + "</appnamemultilanguagekey>");
      paramStringBuilder.append("</nativeappinfo>");
    }
    paramStringBuilder.append("<videopageinfo>");
    paramb = new StringBuilder("<thumbwidth>");
    if (paramInt1 != 0)
    {
      paramStringBuilder.append(paramInt1 + "</thumbwidth>");
      paramb = new StringBuilder("<thumbheight>");
      if (paramInt2 == 0) {
        break label1460;
      }
    }
    for (;;)
    {
      paramStringBuilder.append(paramInt2 + "</thumbheight>");
      if (!bs.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + k.b.vB(this.videoSource) + "</videosource>");
      }
      if (!bs.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + k.b.vB(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.hgh + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!bs.isNullOrNil(this.hgj)) || (!bs.isNullOrNil(this.hgi)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(k.b.vB(this.hgk)).append("</videobuttontext>");
        if ((paramd != null) && (!bs.isNullOrNil(paramd.field_fileUrl)))
        {
          i.deleteFile(this.hgi);
          this.hgj = paramd.field_fileUrl;
          this.dwi = paramd.field_filemd5;
          this.hgl = paramd.field_thumbUrl;
        }
        if (bs.isNullOrNil(this.hgj)) {
          paramStringBuilder.append("<videotemplocalpath>").append(k.b.vB(this.hgi)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(k.b.vB(this.dwi)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(k.b.vB(this.hgj)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(k.b.vB(this.hgl)).append("</videothumburl>");
        paramStringBuilder.append("<videoplaydesc>").append(k.b.vB(this.hgm)).append("</videoplaydesc>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      if (this.hfZ != 0) {
        paramStringBuilder.append("<tradingguaranteeflag>").append(this.hfZ).append("</tradingguaranteeflag>");
      }
      if (this.hgc != 0) {
        paramStringBuilder.append("<subType>").append(this.hgc).append("</subType>");
      }
      if (!TextUtils.isEmpty(this.hga)) {
        paramStringBuilder.append("<todoactivityid>").append(k.b.vB(this.hga)).append("</todoactivityid>");
      }
      paramStringBuilder.append("</weappinfo>");
      if (this.hgn) {
        paramStringBuilder.append("<roomtoolsflag>1</roomtoolsflag>");
      }
      AppMethodBeat.o(2613);
      return;
      paramInt1 = this.hgf;
      break;
      label1460:
      paramInt2 = this.hgg;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(2614);
    if (bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool = true;
      this.hfN = bool;
      this.hfO = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.hfP = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.hfP);
      this.hgb = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      this.hgc = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.subType"), this.hgc);
      if (bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label533;
      }
    }
    label533:
    for (boolean bool = true;; bool = false)
    {
      this.hfQ = bool;
      this.hfR = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.hfS = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.hfT = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.hfU = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.hfV = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.hfW = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.hfY = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.hfX = ((int)bs.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.hgf = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.hgg = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.hgh = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.hgi = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.dwi = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.hgj = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.hgk = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.hgl = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      this.hgm = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc"));
      this.hfZ = bs.getInt((String)paramMap.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
      this.hga = ((String)paramMap.get(".msg.appmsg.weappinfo.todoactivityid"));
      this.hgn = bs.getBoolean((String)paramMap.get(".msg.appmsg.roomtoolsflag"), false);
      AppMethodBeat.o(2614);
      return;
      bool = false;
      break;
    }
  }
  
  public final f alG()
  {
    AppMethodBeat.i(2610);
    a locala = new a();
    locala.hfN = this.hfN;
    locala.hfO = this.hfO;
    locala.hfP = this.hfP;
    locala.hfQ = this.hfQ;
    locala.hfR = this.hfR;
    locala.hfS = this.hfS;
    locala.hfT = this.hfT;
    locala.hfU = this.hfU;
    locala.hfV = this.hfV;
    locala.hfX = this.hfX;
    locala.hfY = this.hfY;
    locala.hgb = this.hgb;
    locala.hgc = this.hgc;
    locala.hgg = this.hgg;
    locala.hgf = this.hgf;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.hgh = this.hgh;
    locala.hgi = this.hgi;
    locala.hgj = this.hgj;
    locala.hgk = this.hgk;
    locala.hgl = this.hgl;
    locala.hgm = this.hgm;
    locala.hfZ = this.hfZ;
    locala.hgn = this.hgn;
    AppMethodBeat.o(2610);
    return locala;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2611);
    super.b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    if ((paramb != null) && (paramb.type == 48))
    {
      paramStringBuilder = paramb.hkf;
      if ((paramd == null) || (bs.isNullOrNil(paramStringBuilder)) || (bs.isNullOrNil(paramd.field_fileUrl)) || (bs.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = p.encode(paramd.field_fileUrl, "utf-8");
        String str3 = p.encode(paramd.field_thumbUrl, "utf-8");
        String str4 = p.encode(paramStringBuilder, "utf-8");
        if (!bs.isNullOrNil(paramb.description))
        {
          paramStringBuilder = p.encode(paramb.description, "utf-8");
          if (bs.isNullOrNil(this.hgk)) {
            break label308;
          }
          paramString = p.encode(this.hgk, "utf-8");
          if (!bs.isNullOrNil(paramb.title))
          {
            str1 = p.encode(paramb.title, "utf-8");
            paramStringBuilder = String.format("https://game.weixin.qq.com/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s", new Object[] { str2, str3, str4, paramStringBuilder, paramString, str1 });
            ac.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.hhV = paramd.field_thumbUrl;
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
        ac.d("MicroMsg.AppContentAppBrandPiece", "hy: no cdn result or info missing. ignore");
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        ac.printErrStackTrace("MicroMsg.AppContentAppBrandPiece", paramStringBuilder, "hy: not support utf-8!", new Object[0]);
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