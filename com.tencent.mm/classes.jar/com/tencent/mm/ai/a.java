package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
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
  public String dIs = "";
  public boolean hxV;
  public String hxW;
  public int hxX;
  public boolean hxY;
  public String hxZ;
  public String hya;
  public String hyb;
  public String hyc;
  public String hyd;
  public String hye;
  public int hyf;
  public int hyg;
  public int hyh = 0;
  public String hyi;
  public String hyj;
  public int hyk = 0;
  public boolean hyl;
  public String hym;
  public boolean hyn;
  public int hyo;
  public int hyp;
  public int hyq = 0;
  public String hyr = "";
  public String hys = "";
  public String hyt = "";
  public String hyu = "";
  public String hyv = "";
  public boolean hyw = false;
  public String videoSource;
  
  public final void a(g paramg, k.b paramb)
  {
    AppMethodBeat.i(2612);
    super.a(paramg, paramb);
    if ((paramb.type == 48) && (bt.isNullOrNil(this.hyu)) && (!bt.isNullOrNil(this.hyr)))
    {
      paramg.field_appType = 213;
      paramg.field_fullpath = this.hyr;
      paramg.field_filemd5 = this.dIs;
      paramg.field_fileType = com.tencent.mm.i.a.fIF;
      paramg.field_totalLen = ((int)i.aYo(this.hyr));
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
    if (!bt.isNullOrNil(paramb.hCm)) {
      paramStringBuilder.append("<pagepath>" + k.b.ys(paramb.hCm) + "</pagepath>");
    }
    paramStringBuilder.append("<username>" + bt.aRc(paramb.hCn) + "</username>");
    paramStringBuilder.append("<appid>" + bt.aRc(paramb.hCo) + "</appid>");
    if (paramb.hCA != 0) {
      paramStringBuilder.append("<version>" + paramb.hCA + "</version>");
    }
    if (paramb.hCp != 0) {
      paramStringBuilder.append("<type>" + paramb.hCp + "</type>");
    }
    if (!bt.isNullOrNil(paramb.hCB)) {
      paramStringBuilder.append("<weappiconurl>" + k.b.ys(paramb.hCB) + "</weappiconurl>");
    }
    if (!bt.isNullOrNil(paramb.hCs)) {
      paramStringBuilder.append("<shareId>" + k.b.ys(paramb.hCs) + "</shareId>");
    }
    if ((paramb.hCz == 1) || (paramb.hCz == 2))
    {
      paramStringBuilder.append("<pkginfo>");
      paramStringBuilder.append("<type>");
      paramStringBuilder.append(paramb.hCz);
      paramStringBuilder.append("</type>");
      paramStringBuilder.append("<md5>");
      paramStringBuilder.append(paramb.hCq);
      paramStringBuilder.append("</md5>");
      paramStringBuilder.append("</pkginfo>");
    }
    if (!bt.isNullOrNil(paramb.hCt)) {
      paramStringBuilder.append("<sharekey>" + k.b.ys(paramb.hCt) + "</sharekey>");
    }
    if (!bt.isNullOrNil(this.hyj)) {
      paramStringBuilder.append("<messageextradata>").append(k.b.ys(this.hyj)).append("</messageextradata>");
    }
    if (this.hxV)
    {
      paramStringBuilder.append("<wadynamicpageinfo>");
      paramStringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
      paramStringBuilder.append("<cacheKey>");
      paramStringBuilder.append(k.b.ys(this.hxW));
      paramStringBuilder.append("</cacheKey>");
      paramStringBuilder.append("</wadynamicpageinfo>");
    }
    if (this.hxY)
    {
      paramStringBuilder.append("<waupdatablemsginfov3>");
      paramStringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
      paramStringBuilder.append("<updatablemsgperiod>");
      paramStringBuilder.append(this.hyf);
      paramStringBuilder.append("</updatablemsgperiod>");
      paramStringBuilder.append("<updatablemsgstate>");
      paramStringBuilder.append(this.hyg);
      paramStringBuilder.append("</updatablemsgstate>");
      paramStringBuilder.append("<updatablemsgcontent>");
      paramStringBuilder.append(k.b.ys(this.hxZ));
      paramStringBuilder.append("</updatablemsgcontent>");
      paramStringBuilder.append("<updatablemsgcontentcolor>");
      paramStringBuilder.append(k.b.ys(this.hya));
      paramStringBuilder.append("</updatablemsgcontentcolor>");
      paramStringBuilder.append("<subscribeentrycontent>");
      paramStringBuilder.append(k.b.ys(this.hyb));
      paramStringBuilder.append("</subscribeentrycontent>");
      paramStringBuilder.append("<subscribeentrybuttonwording>");
      paramStringBuilder.append(k.b.ys(this.hyc));
      paramStringBuilder.append("</subscribeentrybuttonwording>");
      paramStringBuilder.append("<subscribeconfirmedcontent>");
      paramStringBuilder.append(k.b.ys(this.hyd));
      paramStringBuilder.append("</subscribeconfirmedcontent>");
      paramStringBuilder.append("<expiredsubscribewording>");
      paramStringBuilder.append(k.b.ys(this.hye));
      paramStringBuilder.append("</expiredsubscribewording>");
      paramStringBuilder.append("</waupdatablemsginfov3>");
    }
    paramStringBuilder.append("<appservicetype>" + this.hxX + "</appservicetype>");
    if (paramb.hCw != 0) {
      paramStringBuilder.append("<disableforward>" + paramb.hCw + "</disableforward>");
    }
    if (paramb.ev(true))
    {
      paramStringBuilder.append("<nativeappinfo>");
      paramStringBuilder.append("<type>" + paramb.hCu + "</type>");
      paramStringBuilder.append("<appnamemultilanguagekey>" + k.b.ys(paramb.hCv) + "</appnamemultilanguagekey>");
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
      if (!bt.isNullOrNil(this.videoSource)) {
        paramStringBuilder.append("<videosource>" + k.b.ys(this.videoSource) + "</videosource>");
      }
      if (!bt.isNullOrNil(this.appThumbUrl)) {
        paramStringBuilder.append("<appthumburl>" + k.b.ys(this.appThumbUrl) + "</appthumburl>");
      }
      paramStringBuilder.append("<fromopensdk>" + this.hyq + "</fromopensdk>");
      paramStringBuilder.append("</videopageinfo>");
      if ((!bt.isNullOrNil(this.hys)) || (!bt.isNullOrNil(this.hyr)))
      {
        paramStringBuilder.append("<screenvideoinfo>");
        paramStringBuilder.append("<videobuttontext>").append(k.b.ys(this.hyt)).append("</videobuttontext>");
        if ((paramd != null) && (!bt.isNullOrNil(paramd.field_fileUrl)))
        {
          i.deleteFile(this.hyr);
          this.hys = paramd.field_fileUrl;
          this.dIs = paramd.field_filemd5;
          this.hyu = paramd.field_thumbUrl;
        }
        if (bt.isNullOrNil(this.hys)) {
          paramStringBuilder.append("<videotemplocalpath>").append(k.b.ys(this.hyr)).append("</videotemplocalpath>");
        }
        paramStringBuilder.append("<videomd5>").append(k.b.ys(this.dIs)).append("</videomd5>");
        paramStringBuilder.append("<videoremoteurl>").append(k.b.ys(this.hys)).append("</videoremoteurl>");
        paramStringBuilder.append("<videothumburl>").append(k.b.ys(this.hyu)).append("</videothumburl>");
        paramStringBuilder.append("<videoplaydesc>").append(k.b.ys(this.hyv)).append("</videoplaydesc>");
        paramStringBuilder.append("</screenvideoinfo>");
      }
      if (this.hyh != 0) {
        paramStringBuilder.append("<tradingguaranteeflag>").append(this.hyh).append("</tradingguaranteeflag>");
      }
      if (this.hyk != 0) {
        paramStringBuilder.append("<subType>").append(this.hyk).append("</subType>");
      }
      if (!TextUtils.isEmpty(this.hyi)) {
        paramStringBuilder.append("<todoactivityid>").append(k.b.ys(this.hyi)).append("</todoactivityid>");
      }
      paramStringBuilder.append("</weappinfo>");
      if (this.hyw) {
        paramStringBuilder.append("<roomtoolsflag>1</roomtoolsflag>");
      }
      if (this.hyl) {
        paramStringBuilder.append("<isprivatemessage>1</isprivatemessage>");
      }
      AppMethodBeat.o(2613);
      return;
      paramInt1 = this.hyo;
      break;
      label1475:
      paramInt2 = this.hyp;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    boolean bool2 = true;
    AppMethodBeat.i(2614);
    if (bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1)
    {
      bool1 = true;
      this.hxV = bool1;
      this.hxW = ((String)paramMap.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey"));
      this.hxX = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.appservicetype"), this.hxX);
      this.hyj = ((String)paramMap.get(".msg.appmsg.weappinfo.messageextradata"));
      this.hyk = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.subType"), this.hyk);
      if (bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) != 1) {
        break label564;
      }
      bool1 = true;
      label136:
      this.hxY = bool1;
      this.hxZ = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent"));
      this.hya = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor"));
      this.hyb = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent"));
      this.hyc = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording"));
      this.hyd = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent"));
      this.hye = ((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording"));
      this.hyg = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
      this.hyf = ((int)bt.getLong((String)paramMap.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10L));
      this.hyo = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
      this.hyp = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
      this.videoSource = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.videosource"));
      this.appThumbUrl = ((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl"));
      this.hyq = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
      this.hyr = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videotemplocalpath"));
      this.dIs = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videomd5"));
      this.hys = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoremoteurl"));
      this.hyt = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videobuttontext"));
      this.hyu = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videothumburl"));
      this.hyv = ((String)paramMap.get(".msg.appmsg.weappinfo.screenvideoinfo.videoplaydesc"));
      this.hyh = bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.tradingguaranteeflag"), 0);
      this.hyi = ((String)paramMap.get(".msg.appmsg.weappinfo.todoactivityid"));
      this.hyw = bt.getBoolean((String)paramMap.get(".msg.appmsg.roomtoolsflag"), false);
      if (bt.getInt((String)paramMap.get(".msg.appmsg.weappinfo.isprivatemessage"), 0) != 1) {
        break label569;
      }
    }
    label564:
    label569:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hyl = bool1;
      AppMethodBeat.o(2614);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label136;
    }
  }
  
  public final f aot()
  {
    AppMethodBeat.i(2610);
    a locala = new a();
    locala.hxV = this.hxV;
    locala.hxW = this.hxW;
    locala.hxX = this.hxX;
    locala.hxY = this.hxY;
    locala.hxZ = this.hxZ;
    locala.hya = this.hya;
    locala.hyb = this.hyb;
    locala.hyc = this.hyc;
    locala.hyd = this.hyd;
    locala.hyf = this.hyf;
    locala.hyg = this.hyg;
    locala.hyj = this.hyj;
    locala.hyk = this.hyk;
    locala.hyp = this.hyp;
    locala.hyo = this.hyo;
    locala.videoSource = this.videoSource;
    locala.appThumbUrl = this.appThumbUrl;
    locala.hyq = this.hyq;
    locala.hyr = this.hyr;
    locala.hys = this.hys;
    locala.hyt = this.hyt;
    locala.hyu = this.hyu;
    locala.hyv = this.hyv;
    locala.hyh = this.hyh;
    locala.hyw = this.hyw;
    AppMethodBeat.o(2610);
    return locala;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2611);
    super.b(paramStringBuilder, paramb, paramString, paramd, paramInt1, paramInt2);
    if ((paramb != null) && (paramb.type == 48))
    {
      paramStringBuilder = paramb.hCo;
      if ((paramd == null) || (bt.isNullOrNil(paramStringBuilder)) || (bt.isNullOrNil(paramd.field_fileUrl)) || (bt.isNullOrNil(paramd.field_thumbUrl))) {}
    }
    for (;;)
    {
      try
      {
        String str2 = q.encode(paramd.field_fileUrl, "utf-8");
        String str3 = q.encode(paramd.field_thumbUrl, "utf-8");
        String str4 = q.encode(paramStringBuilder, "utf-8");
        if (!bt.isNullOrNil(paramb.description))
        {
          paramStringBuilder = q.encode(paramb.description, "utf-8");
          if (bt.isNullOrNil(this.hyt)) {
            break label308;
          }
          paramString = q.encode(this.hyt, "utf-8");
          if (!bt.isNullOrNil(paramb.title))
          {
            str1 = q.encode(paramb.title, "utf-8");
            paramStringBuilder = String.format("https://game.weixin.qq.com/cgi-bin/h5/static/minigame/video/index.html?url=%s&cover=%s&appid=%s&extWording=%s&btnWording=%s&shareTitle=%s", new Object[] { str2, str3, str4, paramStringBuilder, paramString, str1 });
            ad.i("MicroMsg.AppContentAppBrandPiece", "hy: formatted url is %s", new Object[] { paramStringBuilder });
            paramb.url = paramStringBuilder;
            paramb.thumburl = paramd.field_thumbUrl;
            paramb.hAe = paramd.field_thumbUrl;
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
      label308:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a
 * JD-Core Version:    0.7.0.1
 */