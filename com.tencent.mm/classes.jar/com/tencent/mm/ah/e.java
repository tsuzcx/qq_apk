package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class e
  extends f
{
  public int duration = -1;
  public int hBV = -1;
  public int hBW = -1;
  public int hBX = 0;
  public int hBY = 0;
  public int hBZ = 0;
  public String hCa = "";
  public boolean hCb = false;
  public y hCc;
  public int hCd = 0;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123935);
    if ((this.hBV != -1) || (this.hCd == 1))
    {
      if (!bu.isNullOrNil(this.hCa)) {
        this.hBX = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.hBV).append("</itemshowtype><ispaysubscribe>").append(this.hBY).append("</ispaysubscribe>");
      if (this.hCd == 1) {
        paramStringBuilder.append("<showsourceinfo>").append(this.hCd).append("</showsourceinfo>");
      }
      if (this.hBV == 5) {
        paramStringBuilder.append("<pubtime>").append(this.hBW).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.hBX).append("</nativepage><funcflag>").append(this.hBZ).append("</funcflag><vid>").append(bu.aSz(this.hCa)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    if ((this.hCb) && (this.hCc != null))
    {
      paramStringBuilder.append("<mmbrandmpvideo><vid>").append(bu.aSz(this.hCc.FUx)).append("</vid><videourl>").append(bu.aSz(this.hCc.videoUrl)).append("</videourl><mpurl>").append(bu.aSz(this.hCc.FUw)).append("</mpurl><thumbwidth>").append(this.hCc.width).append("</thumbwidth><thumbheight>").append(this.hCc.height).append("</thumbheight><duration>").append(this.hCc.videoDuration).append("</duration>");
      paramStringBuilder.append("</mmbrandmpvideo>");
    }
    AppMethodBeat.o(123935);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(123936);
    this.hBY = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
    this.hBV = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
    this.hCd = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
    if (this.hBV == 5)
    {
      this.hBW = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.hBX = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.hBZ = bu.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.hCa = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    if ((!bu.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"))) && (!bu.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"))))
    {
      this.hCb = true;
      this.hCc = new y();
      this.hCc.FUx = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.vid"));
      this.hCc.videoUrl = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"));
      this.hCc.FUw = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"));
      this.hCc.hGe = ((String)paramMap.get(".msg.appmsg.thumburl"));
      this.hCc.title = ((String)paramMap.get(".msg.appmsg.title"));
      this.hCc.url = ((String)paramMap.get(".msg.appmsg.url"));
      this.hCc.dpP = ((String)paramMap.get(".msg.appmsg.sourceusername"));
      this.hCc.hFW = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
      this.hCc.videoDuration = ((int)bu.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0F));
      this.hCc.width = ((int)bu.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0F));
      this.hCc.height = ((int)bu.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0F));
    }
    AppMethodBeat.o(123936);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(123934);
    if ((this.hBV == -1) && (!this.hCb) && (this.hCd != 1))
    {
      AppMethodBeat.o(123934);
      return null;
    }
    e locale = new e();
    locale.hBV = this.hBV;
    locale.hBW = this.hBW;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.hBX = this.hBX;
    locale.hCa = this.hCa;
    locale.hBZ = this.hBZ;
    locale.hCb = this.hCb;
    locale.hCc = this.hCc;
    locale.hBY = this.hBY;
    locale.hCd = this.hCd;
    AppMethodBeat.o(123934);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.e
 * JD-Core Version:    0.7.0.1
 */