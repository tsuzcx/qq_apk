package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class e
  extends f
{
  public int duration = -1;
  public int llp = -1;
  public int llq = -1;
  public int llr = 0;
  public int lls = 0;
  public int llt = 0;
  public boolean llu = false;
  public y llv;
  public int llw = 0;
  public String vid = "";
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123935);
    if ((this.llp != -1) || (this.llw == 1))
    {
      if (!Util.isNullOrNil(this.vid)) {
        this.llr = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.llp).append("</itemshowtype><ispaysubscribe>").append(this.lls).append("</ispaysubscribe>");
      if (this.llw == 1) {
        paramStringBuilder.append("<showsourceinfo>").append(this.llw).append("</showsourceinfo>");
      }
      if (this.llp == 5) {
        paramStringBuilder.append("<pubtime>").append(this.llq).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.llr).append("</nativepage><funcflag>").append(this.llt).append("</funcflag><vid>").append(Util.escapeStringForXml(this.vid)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    if ((this.llu) && (this.llv != null))
    {
      paramStringBuilder.append("<mmbrandmpvideo><vid>").append(Util.escapeStringForXml(this.llv.RPa)).append("</vid><videourl>").append(Util.escapeStringForXml(this.llv.videoUrl)).append("</videourl><mpurl>").append(Util.escapeStringForXml(this.llv.ROZ)).append("</mpurl><thumbwidth>").append(this.llv.width).append("</thumbwidth><thumbheight>").append(this.llv.height).append("</thumbheight><duration>").append(this.llv.videoDuration).append("</duration>");
      paramStringBuilder.append("</mmbrandmpvideo>");
    }
    AppMethodBeat.o(123935);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(123936);
    this.lls = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
    this.llp = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
    this.llw = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
    if (this.llp == 5)
    {
      this.llq = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.llr = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.llt = Util.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.vid = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    if ((!Util.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"))) && (!Util.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"))))
    {
      this.llu = true;
      this.llv = new y();
      this.llv.RPa = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.vid"));
      this.llv.videoUrl = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"));
      this.llv.ROZ = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"));
      this.llv.lpK = ((String)paramMap.get(".msg.appmsg.thumburl"));
      this.llv.title = ((String)paramMap.get(".msg.appmsg.title"));
      this.llv.url = ((String)paramMap.get(".msg.appmsg.url"));
      this.llv.fzT = ((String)paramMap.get(".msg.appmsg.sourceusername"));
      this.llv.lpC = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
      this.llv.videoDuration = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0F));
      this.llv.width = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0F));
      this.llv.height = ((int)Util.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0F));
    }
    AppMethodBeat.o(123936);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(123934);
    if ((this.llp == -1) && (!this.llu) && (this.llw != 1))
    {
      AppMethodBeat.o(123934);
      return null;
    }
    e locale = new e();
    locale.llp = this.llp;
    locale.llq = this.llq;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.llr = this.llr;
    locale.vid = this.vid;
    locale.llt = this.llt;
    locale.llu = this.llu;
    locale.llv = this.llv;
    locale.lls = this.lls;
    locale.llw = this.llw;
    AppMethodBeat.o(123934);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aj.e
 * JD-Core Version:    0.7.0.1
 */