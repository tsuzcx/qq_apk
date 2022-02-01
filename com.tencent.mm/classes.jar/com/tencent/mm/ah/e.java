package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class e
  extends f
{
  public int duration = -1;
  public int hgY = -1;
  public int hgZ = -1;
  public int hha = 0;
  public int hhb = 0;
  public int hhc = 0;
  public String hhd = "";
  public boolean hhe = false;
  public y hhf;
  public int hhg = 0;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123935);
    if ((this.hgY != -1) || (this.hhg == 1))
    {
      if (!bs.isNullOrNil(this.hhd)) {
        this.hha = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.hgY).append("</itemshowtype><ispaysubscribe>").append(this.hhb).append("</ispaysubscribe>");
      if (this.hhg == 1) {
        paramStringBuilder.append("<showsourceinfo>").append(this.hhg).append("</showsourceinfo>");
      }
      if (this.hgY == 5) {
        paramStringBuilder.append("<pubtime>").append(this.hgZ).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.hha).append("</nativepage><funcflag>").append(this.hhc).append("</funcflag><vid>").append(bs.aLw(this.hhd)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    if ((this.hhe) && (this.hhf != null))
    {
      paramStringBuilder.append("<mmbrandmpvideo><vid>").append(bs.aLw(this.hhf.DWG)).append("</vid><videourl>").append(bs.aLw(this.hhf.videoUrl)).append("</videourl><mpurl>").append(bs.aLw(this.hhf.DWF)).append("</mpurl><thumbwidth>").append(this.hhf.width).append("</thumbwidth><thumbheight>").append(this.hhf.height).append("</thumbheight><duration>").append(this.hhf.videoDuration).append("</duration>");
      paramStringBuilder.append("</mmbrandmpvideo>");
    }
    AppMethodBeat.o(123935);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(123936);
    this.hhb = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
    this.hgY = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
    this.hhg = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
    if (this.hgY == 5)
    {
      this.hgZ = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.hha = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.hhc = bs.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.hhd = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    if ((!bs.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"))) && (!bs.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"))))
    {
      this.hhe = true;
      this.hhf = new y();
      this.hhf.DWG = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.vid"));
      this.hhf.videoUrl = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"));
      this.hhf.DWF = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"));
      this.hhf.hld = ((String)paramMap.get(".msg.appmsg.thumburl"));
      this.hhf.title = ((String)paramMap.get(".msg.appmsg.title"));
      this.hhf.url = ((String)paramMap.get(".msg.appmsg.url"));
      this.hhf.ddo = ((String)paramMap.get(".msg.appmsg.sourceusername"));
      this.hhf.hkV = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
      this.hhf.videoDuration = ((int)bs.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0F));
      this.hhf.width = ((int)bs.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0F));
      this.hhf.height = ((int)bs.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0F));
    }
    AppMethodBeat.o(123936);
  }
  
  public final f alG()
  {
    AppMethodBeat.i(123934);
    if ((this.hgY == -1) && (!this.hhe) && (this.hhg != 1))
    {
      AppMethodBeat.o(123934);
      return null;
    }
    e locale = new e();
    locale.hgY = this.hgY;
    locale.hgZ = this.hgZ;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.hha = this.hha;
    locale.hhd = this.hhd;
    locale.hhc = this.hhc;
    locale.hhe = this.hhe;
    locale.hhf = this.hhf;
    locale.hhb = this.hhb;
    locale.hhg = this.hhg;
    AppMethodBeat.o(123934);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.e
 * JD-Core Version:    0.7.0.1
 */