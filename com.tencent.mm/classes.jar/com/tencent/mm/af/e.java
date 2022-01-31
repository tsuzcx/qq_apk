package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e
  extends f
{
  public int duration = -1;
  public int fgh = -1;
  public int fgi = -1;
  public int fgj = 0;
  public int fgk = 0;
  public String fgl = "";
  public int videoHeight = -1;
  public int videoWidth = -1;
  
  public final f Yk()
  {
    AppMethodBeat.i(11207);
    if (this.fgh == -1)
    {
      AppMethodBeat.o(11207);
      return null;
    }
    e locale = new e();
    locale.fgh = this.fgh;
    locale.fgi = this.fgi;
    locale.duration = this.duration;
    locale.videoWidth = this.videoWidth;
    locale.videoHeight = this.videoHeight;
    locale.fgj = this.fgj;
    locale.fgl = this.fgl;
    locale.fgk = this.fgk;
    AppMethodBeat.o(11207);
    return locale;
  }
  
  public final void a(Map<String, String> paramMap, j.b paramb)
  {
    AppMethodBeat.i(11209);
    paramb = (String)paramMap.get(".msg.appmsg.mmreadershare.itemshowtype");
    if ((paramb != null) && (Pattern.compile("\\d").matcher(paramb).matches())) {
      this.fgh = Integer.valueOf(paramb).intValue();
    }
    if (this.fgh == 5)
    {
      this.fgi = bo.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.pubtime"), 0);
      this.duration = bo.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.duration"), 0);
      this.videoWidth = bo.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.width"), 0);
      this.videoHeight = bo.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.height"), 0);
      this.fgj = bo.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.nativepage"), 0);
      this.fgk = bo.getInt((String)paramMap.get(".msg.appmsg.mmreadershare.funcflag"), 0);
      this.fgl = ((String)paramMap.get(".msg.appmsg.mmreadershare.vid"));
    }
    AppMethodBeat.o(11209);
  }
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11208);
    if (this.fgh != -1)
    {
      if (!bo.isNullOrNil(this.fgl)) {
        this.fgj = 1;
      }
      paramStringBuilder.append("<mmreadershare><itemshowtype>").append(this.fgh).append("</itemshowtype>");
      if (this.fgh == 5) {
        paramStringBuilder.append("<pubtime>").append(this.fgi).append("</pubtime><duration>").append(this.duration).append("</duration><width>").append(this.videoWidth).append("</width><height>").append(this.videoHeight).append("</height><nativepage>").append(this.fgj).append("</nativepage><funcflag>").append(this.fgk).append("</funcflag><vid>").append(bo.apT(this.fgl)).append("</vid>");
      }
      paramStringBuilder.append("</mmreadershare>");
    }
    AppMethodBeat.o(11208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.af.e
 * JD-Core Version:    0.7.0.1
 */