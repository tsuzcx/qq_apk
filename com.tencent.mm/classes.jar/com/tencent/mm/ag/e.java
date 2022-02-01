package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class e
  extends f
{
  public int duration = -1;
  public int iwc = -1;
  public int iwd = -1;
  public int iwe = 0;
  public int iwf = 0;
  public int iwg = 0;
  public boolean iwh = false;
  public y iwi;
  public int iwj = 0;
  public String vid = "";
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123935);
    if ((this.iwc != -1) || (this.iwj == 1))
    {
      if (!Util.isNullOrNil(this.vid)) {
        this.iwe = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.iwc).append("</itemshowtype><ispaysubscribe>").append(this.iwf).append("</ispaysubscribe>");
      if (this.iwj == 1) {
        paramStringBuilder.append("<showsourceinfo>").append(this.iwj).append("</showsourceinfo>");
      }
      if (this.iwc == 5) {
        paramStringBuilder.append("<pubtime>").append(this.iwd).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.iwe).append("</nativepage><funcflag>").append(this.iwg).append("</funcflag><vid>").append(Util.escapeStringForXml(this.vid)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    if ((this.iwh) && (this.iwi != null))
    {
      paramStringBuilder.append("<mmbrandmpvideo><vid>").append(Util.escapeStringForXml(this.iwi.KOf)).append("</vid><videourl>").append(Util.escapeStringForXml(this.iwi.videoUrl)).append("</videourl><mpurl>").append(Util.escapeStringForXml(this.iwi.KOe)).append("</mpurl><thumbwidth>").append(this.iwi.width).append("</thumbwidth><thumbheight>").append(this.iwi.height).append("</thumbheight><duration>").append(this.iwi.videoDuration).append("</duration>");
      paramStringBuilder.append("</mmbrandmpvideo>");
    }
    AppMethodBeat.o(123935);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(123936);
    this.iwf = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
    this.iwc = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
    this.iwj = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
    if (this.iwc == 5)
    {
      this.iwd = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.iwe = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.iwg = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.vid = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    if ((!Util.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"))) && (!Util.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"))))
    {
      this.iwh = true;
      this.iwi = new y();
      this.iwi.KOf = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.vid"));
      this.iwi.videoUrl = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"));
      this.iwi.KOe = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"));
      this.iwi.iAo = ((String)paramMap.get(".msg.appmsg.thumburl"));
      this.iwi.title = ((String)paramMap.get(".msg.appmsg.title"));
      this.iwi.url = ((String)paramMap.get(".msg.appmsg.url"));
      this.iwi.dHc = ((String)paramMap.get(".msg.appmsg.sourceusername"));
      this.iwi.iAg = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
      this.iwi.videoDuration = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0F));
      this.iwi.width = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0F));
      this.iwi.height = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0F));
    }
    AppMethodBeat.o(123936);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(123934);
    if ((this.iwc == -1) && (!this.iwh) && (this.iwj != 1))
    {
      AppMethodBeat.o(123934);
      return null;
    }
    e locale = new e();
    locale.iwc = this.iwc;
    locale.iwd = this.iwd;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.iwe = this.iwe;
    locale.vid = this.vid;
    locale.iwg = this.iwg;
    locale.iwh = this.iwh;
    locale.iwi = this.iwi;
    locale.iwf = this.iwf;
    locale.iwj = this.iwj;
    AppMethodBeat.o(123934);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.e
 * JD-Core Version:    0.7.0.1
 */