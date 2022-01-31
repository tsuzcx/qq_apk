package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class a
  extends f
{
  public String appThumbUrl;
  public String cHH = "";
  public boolean ffc;
  public String ffd;
  public int ffe;
  public boolean fff;
  public String ffg;
  public String ffh;
  public String ffi;
  public String ffj;
  public String ffk;
  public String ffl;
  public int ffm;
  public int ffn;
  public String ffo;
  public String ffp;
  public boolean ffq;
  public int ffr;
  public int ffs;
  public int fft = 0;
  public String ffu = "";
  public String ffv = "";
  public String ffw = "";
  public String ffx = "";
  public String videoSource;
  
  public final f Yk()
  {
    AppMethodBeat.i(51119);
    a locala = new a();
    locala.ffc = this.ffc;
    locala.ffd = this.ffd;
    locala.ffe = this.ffe;
    locala.fff = this.fff;
    locala.ffg = this.ffg;
    locala.ffh = this.ffh;
    locala.ffi = this.ffi;
    locala.ffj = this.ffj;
    locala.ffk = this.ffk;
    locala.ffm = this.ffm;
    locala.ffn = this.ffn;
    locala.ffo = this.ffo;
    locala.ffs = this.ffs;
    locala.ffr = this.ffr;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.fft = this.fft;
    locala.ffu = this.ffu;
    locala.ffv = this.ffv;
    locala.ffw = this.ffw;
    locala.ffx = this.ffx;
    AppMethodBeat.o(51119);
    return locala;
  }
  
  public final void a(g paramg, j.b paramb)
  {
    AppMethodBeat.i(150440);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (bo.isNullOrNil(this.ffx)) && (!bo.isNullOrNil(this.ffu)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.ffu;
      paramg.field_filemd5 = this.cHH;
      paramg.field_fileType = com.tencent.mm.i.a.ecN;
      paramg.field_totalLen = e.cM(this.ffu);
      paramg.field_needStorage = false;
      paramg.field_isStreamMedia = true;
      paramg.field_force_aeskeycdn = false;
      paramg.field_trysafecdn = true;
      paramg.field_bzScene = 2;
    }
    AppMethodBeat.o(150440);
  }
  
  public final void a(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150439);
    super.a(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    if ((paramb != null) && (paramb.type == 48))
    {
      paramStringBuilder = paramb.fiY;
      if ((paramd == null) || (bo.isNullOrNil(paramStringBuilder)) || (bo.isNullOrNil(paramd.field_fileUrl)) || (bo.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = q.encode(paramd.field_fileUrl, "utf-8");
        String str3 = q.encode(paramd.field_thumbUrl, "utf-8");
        String str4 = q.encode(paramStringBuilder, "utf-8");
        if (!bo.isNullOrNil(paramb.description))
        {
          paramStringBuilder = q.encode(paramb.description, "utf-8");
          if (bo.isNullOrNil(this.ffw)) {
            break label291;
          }
          paramString = q.encode(this.ffw, "utf-8");
          if (!bo.isNullOrNil(paramb.title))
          {
            str1 = q.encode(paramb.title, "utf-8");
            paramStringBuilder = String.format("https://game.weixin.qq.com/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s", new Object[] { str2, str3, str4, paramStringBuilder, paramString, str1 });
            ab.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.fgM = paramd.field_thumbUrl;
            AppMethodBeat.o(150439);
          }
        }
        else
        {
          paramStringBuilder = "";
          continue;
        }
        String str1 = "";
        continue;
        ab.d("MicroMsg.AppContentAppBrandPiece", "hy: no cdn result or info missing. ignore");
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        ab.printErrStackTrace("MicroMsg.AppContentAppBrandPiece", paramStringBuilder, "hy: not support utf-8!", new Object[0]);
        AppMethodBeat.o(150439);
        return;
      }
      AppMethodBeat.o(150439);
      return;
      label291:
      paramString = "";
    }
  }
  
  public final void a(Map<String, String> paramMap, j.b paramb)
  {
    AppMethodBeat.i(51121);
    if (bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool = true;
      this.ffc = bool;
      this.ffd = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.ffe = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.ffe);
      this.ffo = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      if (bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label428;
      }
    }
    label428:
    for (boolean bool = true;; bool = false)
    {
      this.fff = bool;
      this.ffg = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.ffh = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.ffi = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.ffj = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.ffk = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.ffl = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.ffn = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.ffm = ((int)bo.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.ffr = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.ffs = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.fft = bo.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.ffu = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.cHH = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.ffv = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.ffw = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.ffx = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      AppMethodBeat.o(51121);
      return;
      bool = false;
      break;
    }
  }
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51120);
    paramStringBuilder.append("<weappinfo>");
    if (!bo.isNullOrNil(paramb.fiW)) {
      paramStringBuilder.append("<pagepath>" + j.b.mZ(paramb.fiW) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + bo.apT(paramb.fiX) + "</username>");
    paramStringBuilder.append("<appid>" + bo.apT(paramb.fiY) + "</appid>");
    if (paramb.fji != 0) {
      paramStringBuilder.append("<version>" + paramb.fji + "</version>");
    }
    if (paramb.fiZ != 0) {
      paramStringBuilder.append("<type>" + paramb.fiZ + "</type>");
    }
    if (!bo.isNullOrNil(paramb.fjj)) {
      paramStringBuilder.append("<weappiconurl>" + j.b.mZ(paramb.fjj) + "</weappiconurl>");
    }
    if (!bo.isNullOrNil(paramb.fjc)) {
      paramStringBuilder.append("<shareId>" + j.b.mZ(paramb.fjc) + "</shareId>");
    }
    if ((paramb.fjh == 1) || (paramb.fjh == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.fjh);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.fja);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!bo.isNullOrNil(paramb.fjd)) {
      paramStringBuilder.append("<sharekey>" + j.b.mZ(paramb.fjd) + "</sharekey>");
    }
    if (!bo.isNullOrNil(this.ffo)) {
      paramStringBuilder.append("<messageextradata>").append(j.b.mZ(this.ffo)).append("</messageextradata>");
    }
    if (this.ffc)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(j.b.mZ(this.ffd));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.fff)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.ffm);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.ffn);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(j.b.mZ(this.ffg));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(j.b.mZ(this.ffh));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(j.b.mZ(this.ffi));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(j.b.mZ(this.ffj));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(j.b.mZ(this.ffk));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(j.b.mZ(this.ffl));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.ffe + "</appservicetype>");
    if (paramb.fjg != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.fjg + "</disableforward>");
    }
    if (paramb.cH(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.fje + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + j.b.mZ(paramb.fjf) + "</appnamemultilanguagekey>");
      paramStringBuilder.append("</nativeappinfo>");
    }
    paramStringBuilder.append("<videopageinfo>");
    paramb = new StringBuilder("<thumbwidth>");
    if (paramInt1 != 0)
    {
      paramStringBuilder.append(paramInt1 + "</thumbwidth>");
      paramb = new StringBuilder("<thumbheight>");
      if (paramInt2 == 0) {
        break label1364;
      }
    }
    for (;;)
    {
      paramStringBuilder.append(paramInt2 + "</thumbheight>");
      if (!bo.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + j.b.mZ(this.videoSource) + "</videosource>");
      }
      if (!bo.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + j.b.mZ(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.fft + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!bo.isNullOrNil(this.ffv)) || (!bo.isNullOrNil(this.ffu)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(j.b.mZ(this.ffw)).append("</videobuttontext>");
        if ((paramd != null) && (!bo.isNullOrNil(paramd.field_fileUrl)))
        {
          e.deleteFile(this.ffu);
          this.ffv = paramd.field_fileUrl;
          this.cHH = paramd.field_filemd5;
          this.ffx = paramd.field_thumbUrl;
        }
        if (bo.isNullOrNil(this.ffv)) {
          paramStringBuilder.append("<videotemplocalpath>").append(j.b.mZ(this.ffu)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(j.b.mZ(this.cHH)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(j.b.mZ(this.ffv)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(j.b.mZ(this.ffx)).append("</videothumburl>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      paramStringBuilder.append("</weappinfo>");
      AppMethodBeat.o(51120);
      return;
      paramInt1 = this.ffr;
      break;
      label1364:
      paramInt2 = this.ffs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.af.a
 * JD-Core Version:    0.7.0.1
 */