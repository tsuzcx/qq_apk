package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class e
  extends f
{
  public int duration = -1;
  public int nQm = -1;
  public int nQn = -1;
  public int nQo = 0;
  public int nQp = 0;
  public int nQq = 0;
  public boolean nQr = false;
  public y nQs;
  public int nQt = 0;
  public String vid = "";
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public static boolean uA(int paramInt)
  {
    return (paramInt == 5) || (paramInt == 16);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123935);
    if ((this.nQm != -1) || (this.nQt == 1))
    {
      if (!Util.isNullOrNil(this.vid)) {
        this.nQo = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.nQm).append("</itemshowtype><ispaysubscribe>").append(this.nQp).append("</ispaysubscribe>");
      if (this.nQt == 1) {
        paramStringBuilder.append("<showsourceinfo>").append(this.nQt).append("</showsourceinfo>");
      }
      if ((this.nQm == 5) || (this.nQm == 16)) {
        paramStringBuilder.append("<pubtime>").append(this.nQn).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.nQo).append("</nativepage><funcflag>").append(this.nQq).append("</funcflag><vid>").append(Util.escapeStringForXml(this.vid)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    if ((this.nQr) && (this.nQs != null))
    {
      paramStringBuilder.append("<mmbrandmpvideo><vid>").append(Util.escapeStringForXml(this.nQs.YMn)).append("</vid><videourl>").append(Util.escapeStringForXml(this.nQs.videoUrl)).append("</videourl><mpurl>").append(Util.escapeStringForXml(this.nQs.YMm)).append("</mpurl><thumbwidth>").append(this.nQs.width).append("</thumbwidth><thumbheight>").append(this.nQs.height).append("</thumbheight><duration>").append(this.nQs.videoDuration).append("</duration>");
      paramStringBuilder.append("</mmbrandmpvideo>");
    }
    AppMethodBeat.o(123935);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(123936);
    this.nQp = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
    this.nQm = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
    this.nQt = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
    if ((this.nQm == 5) || (this.nQm == 16))
    {
      this.nQn = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.nQo = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.nQq = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.vid = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    if ((!Util.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"))) && (!Util.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"))))
    {
      this.nQr = true;
      this.nQs = new y();
      this.nQs.YMn = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.vid"));
      this.nQs.videoUrl = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"));
      this.nQs.YMm = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"));
      this.nQs.nUM = ((String)paramMap.get(".msg.appmsg.thumburl"));
      this.nQs.title = ((String)paramMap.get(".msg.appmsg.title"));
      this.nQs.url = ((String)paramMap.get(".msg.appmsg.url"));
      this.nQs.hEE = ((String)paramMap.get(".msg.appmsg.sourceusername"));
      this.nQs.nUF = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
      this.nQs.videoDuration = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0F));
      this.nQs.width = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0F));
      this.nQs.height = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0F));
    }
    AppMethodBeat.o(123936);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(123934);
    if ((this.nQm == -1) && (!this.nQr) && (this.nQt != 1))
    {
      AppMethodBeat.o(123934);
      return null;
    }
    e locale = new e();
    locale.nQm = this.nQm;
    locale.nQn = this.nQn;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.nQo = this.nQo;
    locale.vid = this.vid;
    locale.nQq = this.nQq;
    locale.nQr = this.nQr;
    locale.nQs = this.nQs;
    locale.nQp = this.nQp;
    locale.nQt = this.nQt;
    AppMethodBeat.o(123934);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.e
 * JD-Core Version:    0.7.0.1
 */