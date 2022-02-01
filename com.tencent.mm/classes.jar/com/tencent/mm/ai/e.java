package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class e
  extends f
{
  public int duration = -1;
  public int hzh = -1;
  public int hzi = -1;
  public int hzj = 0;
  public int hzk = 0;
  public int hzl = 0;
  public String hzm = "";
  public boolean hzn = false;
  public y hzo;
  public int hzp = 0;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123935);
    if ((this.hzh != -1) || (this.hzp == 1))
    {
      if (!bt.isNullOrNil(this.hzm)) {
        this.hzj = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.hzh).append("</itemshowtype><ispaysubscribe>").append(this.hzk).append("</ispaysubscribe>");
      if (this.hzp == 1) {
        paramStringBuilder.append("<showsourceinfo>").append(this.hzp).append("</showsourceinfo>");
      }
      if (this.hzh == 5) {
        paramStringBuilder.append("<pubtime>").append(this.hzi).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.hzj).append("</nativepage><funcflag>").append(this.hzl).append("</funcflag><vid>").append(bt.aRc(this.hzm)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    if ((this.hzn) && (this.hzo != null))
    {
      paramStringBuilder.append("<mmbrandmpvideo><vid>").append(bt.aRc(this.hzo.FCc)).append("</vid><videourl>").append(bt.aRc(this.hzo.videoUrl)).append("</videourl><mpurl>").append(bt.aRc(this.hzo.FCb)).append("</mpurl><thumbwidth>").append(this.hzo.width).append("</thumbwidth><thumbheight>").append(this.hzo.height).append("</thumbheight><duration>").append(this.hzo.videoDuration).append("</duration>");
      paramStringBuilder.append("</mmbrandmpvideo>");
    }
    AppMethodBeat.o(123935);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(123936);
    this.hzk = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
    this.hzh = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
    this.hzp = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
    if (this.hzh == 5)
    {
      this.hzi = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.hzj = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.hzl = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.hzm = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    if ((!bt.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"))) && (!bt.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"))))
    {
      this.hzn = true;
      this.hzo = new y();
      this.hzo.FCc = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.vid"));
      this.hzo.videoUrl = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"));
      this.hzo.FCb = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"));
      this.hzo.hDm = ((String)paramMap.get(".msg.appmsg.thumburl"));
      this.hzo.title = ((String)paramMap.get(".msg.appmsg.title"));
      this.hzo.url = ((String)paramMap.get(".msg.appmsg.url"));
      this.hzo.doK = ((String)paramMap.get(".msg.appmsg.sourceusername"));
      this.hzo.hDe = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
      this.hzo.videoDuration = ((int)bt.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0F));
      this.hzo.width = ((int)bt.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0F));
      this.hzo.height = ((int)bt.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0F));
    }
    AppMethodBeat.o(123936);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(123934);
    if ((this.hzh == -1) && (!this.hzn) && (this.hzp != 1))
    {
      AppMethodBeat.o(123934);
      return null;
    }
    e locale = new e();
    locale.hzh = this.hzh;
    locale.hzi = this.hzi;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.hzj = this.hzj;
    locale.hzm = this.hzm;
    locale.hzl = this.hzl;
    locale.hzn = this.hzn;
    locale.hzo = this.hzo;
    locale.hzk = this.hzk;
    locale.hzp = this.hzp;
    AppMethodBeat.o(123934);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.e
 * JD-Core Version:    0.7.0.1
 */