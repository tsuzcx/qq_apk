package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class e
  extends f
{
  public int duration = -1;
  public int gGA = 0;
  public int gGB = 0;
  public String gGC = "";
  public boolean gGD = false;
  public y gGE;
  public int gGF = 0;
  public int gGx = -1;
  public int gGy = -1;
  public int gGz = 0;
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(123936);
    this.gGA = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.ispaysubscribe"), 0);
    this.gGx = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype"), -1);
    this.gGF = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.showsourceinfo"), 0);
    if (this.gGx == 5)
    {
      this.gGy = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.gGz = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.gGB = bt.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.gGC = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    if ((!bt.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"))) && (!bt.isNullOrNil((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"))))
    {
      this.gGD = true;
      this.gGE = new y();
      this.gGE.CEg = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.vid"));
      this.gGE.videoUrl = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.videourl"));
      this.gGE.CEf = ((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.mpurl"));
      this.gGE.gKD = ((String)paramMap.get(".msg.appmsg.thumburl"));
      this.gGE.title = ((String)paramMap.get(".msg.appmsg.title"));
      this.gGE.url = ((String)paramMap.get(".msg.appmsg.url"));
      this.gGE.dfT = ((String)paramMap.get(".msg.appmsg.sourceusername"));
      this.gGE.gKv = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
      this.gGE.videoDuration = ((int)bt.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.duration"), 0.0F));
      this.gGE.width = ((int)bt.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbwidth"), 0.0F));
      this.gGE.height = ((int)bt.getFloat((String)paramMap.get(".msg.appmsg.mmbrandmpvideo.thumbheight"), 0.0F));
    }
    AppMethodBeat.o(123936);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(123934);
    if ((this.gGx == -1) && (!this.gGD) && (this.gGF != 1))
    {
      AppMethodBeat.o(123934);
      return null;
    }
    e locale = new e();
    locale.gGx = this.gGx;
    locale.gGy = this.gGy;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.gGz = this.gGz;
    locale.gGC = this.gGC;
    locale.gGB = this.gGB;
    locale.gGD = this.gGD;
    locale.gGE = this.gGE;
    locale.gGA = this.gGA;
    locale.gGF = this.gGF;
    AppMethodBeat.o(123934);
    return locale;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123935);
    if ((this.gGx != -1) || (this.gGF == 1))
    {
      if (!bt.isNullOrNil(this.gGC)) {
        this.gGz = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.gGx).append("</itemshowtype><ispaysubscribe>").append(this.gGA).append("</ispaysubscribe>");
      if (this.gGF == 1) {
        paramStringBuilder.append("<showsourceinfo>").append(this.gGF).append("</showsourceinfo>");
      }
      if (this.gGx == 5) {
        paramStringBuilder.append("<pubtime>").append(this.gGy).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.gGz).append("</nativepage><funcflag>").append(this.gGB).append("</funcflag><vid>").append(bt.aGf(this.gGC)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    if ((this.gGD) && (this.gGE != null))
    {
      paramStringBuilder.append("<mmbrandmpvideo><vid>").append(bt.aGf(this.gGE.CEg)).append("</vid><videourl>").append(bt.aGf(this.gGE.videoUrl)).append("</videourl><mpurl>").append(bt.aGf(this.gGE.CEf)).append("</mpurl><thumbwidth>").append(this.gGE.width).append("</thumbwidth><thumbheight>").append(this.gGE.height).append("</thumbheight><duration>").append(this.gGE.videoDuration).append("</duration>");
      paramStringBuilder.append("</mmbrandmpvideo>");
    }
    AppMethodBeat.o(123935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.e
 * JD-Core Version:    0.7.0.1
 */