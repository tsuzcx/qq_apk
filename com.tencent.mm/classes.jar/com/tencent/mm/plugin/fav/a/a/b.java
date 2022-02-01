package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b
{
  public static String a(amt paramamt)
  {
    AppMethodBeat.i(103496);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramamt == null)
    {
      AppMethodBeat.o(103496);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(Util.escapeStringForXml(paramamt.vid)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(Util.escapeStringForXml(paramamt.dHc)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(Util.escapeStringForXml(paramamt.iAg)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(Util.escapeStringForXml(paramamt.iAo)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramamt.iwc).append("</itemshowtype>");
    localStringBuffer.append("<ispaysubscribe>").append(paramamt.iwf).append("</ispaysubscribe>");
    localStringBuffer.append("<nativepage>").append(paramamt.iwe).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramamt.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramamt.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramamt.iwd).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramamt.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramamt.iwg).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramamt = localStringBuffer.toString();
    AppMethodBeat.o(103496);
    return paramamt;
  }
  
  public static String b(amt paramamt)
  {
    AppMethodBeat.i(103498);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramamt == null)
    {
      AppMethodBeat.o(103498);
      return "";
    }
    localStringBuffer.append("<favbrandmpvideo>");
    localStringBuffer.append("<vid>").append(Util.escapeStringForXml(paramamt.vid)).append("</vid>");
    localStringBuffer.append("<videourl>").append(Util.escapeStringForXml(paramamt.videoUrl)).append("</videourl>");
    localStringBuffer.append("<mpurl>").append(Util.escapeStringForXml(paramamt.KOe)).append("</mpurl>");
    localStringBuffer.append("<bizusrname>").append(Util.escapeStringForXml(paramamt.dHc)).append("</bizusrname>");
    localStringBuffer.append("<biznickname>").append(Util.escapeStringForXml(paramamt.iAg)).append("</biznickname>");
    localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(paramamt.iAo)).append("</thumburl>");
    localStringBuffer.append("<thumbwidth>").append(paramamt.videoWidth).append("</thumbwidth>");
    localStringBuffer.append("<thumbheight>").append(paramamt.videoHeight).append("</thumbheight>");
    localStringBuffer.append("<duration>").append(paramamt.duration).append("</duration>");
    localStringBuffer.append("</favbrandmpvideo>");
    paramamt = localStringBuffer.toString();
    AppMethodBeat.o(103498);
    return paramamt;
  }
  
  public static amt t(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103495);
    if (!paramMap.containsKey(paramString))
    {
      Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103495);
      return null;
    }
    amt localamt = new amt();
    localamt.iwc = Util.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localamt.iwf = Util.getInt((String)paramMap.get(paramString + ".ispaysubscribe"), -1);
    localamt.iwe = Util.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localamt.videoWidth = Util.getInt((String)paramMap.get(paramString + ".width"), 0);
    localamt.videoHeight = Util.getInt((String)paramMap.get(paramString + ".height"), 0);
    localamt.iwd = Util.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localamt.duration = Util.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localamt.iwg = Util.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localamt.vid = ((String)paramMap.get(paramString + ".vid"));
    localamt.dHc = ((String)paramMap.get(paramString + ".srcusername"));
    localamt.iAg = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localamt.iAo = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(103495);
    return localamt;
  }
  
  public static amt u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103497);
    if (!paramMap.containsKey(paramString))
    {
      Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103497);
      return null;
    }
    amt localamt = new amt();
    localamt.vid = ((String)paramMap.get(paramString + ".vid"));
    localamt.videoUrl = ((String)paramMap.get(paramString + ".videourl"));
    localamt.KOe = ((String)paramMap.get(paramString + ".mpurl"));
    localamt.dHc = ((String)paramMap.get(paramString + ".bizusrname"));
    localamt.iAg = ((String)paramMap.get(paramString + ".biznickname"));
    localamt.iAo = ((String)paramMap.get(paramString + ".thumburl"));
    localamt.videoWidth = ((int)Util.getFloat((String)paramMap.get(paramString + ".thumbwidth"), 0.0F));
    localamt.videoHeight = ((int)Util.getFloat((String)paramMap.get(paramString + ".thumbheight"), 0.0F));
    localamt.duration = ((int)Util.getFloat((String)paramMap.get(paramString + ".duration"), 0.0F));
    AppMethodBeat.o(103497);
    return localamt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */