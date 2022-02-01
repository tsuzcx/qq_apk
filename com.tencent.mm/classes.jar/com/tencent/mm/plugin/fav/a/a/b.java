package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b
{
  public static String a(anu paramanu)
  {
    AppMethodBeat.i(103496);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramanu == null)
    {
      AppMethodBeat.o(103496);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(Util.escapeStringForXml(paramanu.vid)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(Util.escapeStringForXml(paramanu.fzT)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(Util.escapeStringForXml(paramanu.lpC)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(Util.escapeStringForXml(paramanu.lpK)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramanu.llp).append("</itemshowtype>");
    localStringBuffer.append("<ispaysubscribe>").append(paramanu.lls).append("</ispaysubscribe>");
    localStringBuffer.append("<nativepage>").append(paramanu.llr).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramanu.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramanu.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramanu.llq).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramanu.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramanu.llt).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramanu = localStringBuffer.toString();
    AppMethodBeat.o(103496);
    return paramanu;
  }
  
  public static String b(anu paramanu)
  {
    AppMethodBeat.i(103498);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramanu == null)
    {
      AppMethodBeat.o(103498);
      return "";
    }
    localStringBuffer.append("<favbrandmpvideo>");
    localStringBuffer.append("<vid>").append(Util.escapeStringForXml(paramanu.vid)).append("</vid>");
    localStringBuffer.append("<videourl>").append(Util.escapeStringForXml(paramanu.videoUrl)).append("</videourl>");
    localStringBuffer.append("<mpurl>").append(Util.escapeStringForXml(paramanu.ROZ)).append("</mpurl>");
    localStringBuffer.append("<bizusrname>").append(Util.escapeStringForXml(paramanu.fzT)).append("</bizusrname>");
    localStringBuffer.append("<biznickname>").append(Util.escapeStringForXml(paramanu.lpC)).append("</biznickname>");
    localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(paramanu.lpK)).append("</thumburl>");
    localStringBuffer.append("<thumbwidth>").append(paramanu.videoWidth).append("</thumbwidth>");
    localStringBuffer.append("<thumbheight>").append(paramanu.videoHeight).append("</thumbheight>");
    localStringBuffer.append("<duration>").append(paramanu.duration).append("</duration>");
    localStringBuffer.append("</favbrandmpvideo>");
    paramanu = localStringBuffer.toString();
    AppMethodBeat.o(103498);
    return paramanu;
  }
  
  public static anu s(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103495);
    if (!paramMap.containsKey(paramString))
    {
      Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103495);
      return null;
    }
    anu localanu = new anu();
    localanu.llp = Util.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localanu.lls = Util.getInt((String)paramMap.get(paramString + ".ispaysubscribe"), -1);
    localanu.llr = Util.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localanu.videoWidth = Util.getInt((String)paramMap.get(paramString + ".width"), 0);
    localanu.videoHeight = Util.getInt((String)paramMap.get(paramString + ".height"), 0);
    localanu.llq = Util.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localanu.duration = Util.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localanu.llt = Util.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localanu.vid = ((String)paramMap.get(paramString + ".vid"));
    localanu.fzT = ((String)paramMap.get(paramString + ".srcusername"));
    localanu.lpC = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localanu.lpK = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(103495);
    return localanu;
  }
  
  public static anu t(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103497);
    if (!paramMap.containsKey(paramString))
    {
      Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103497);
      return null;
    }
    anu localanu = new anu();
    localanu.vid = ((String)paramMap.get(paramString + ".vid"));
    localanu.videoUrl = ((String)paramMap.get(paramString + ".videourl"));
    localanu.ROZ = ((String)paramMap.get(paramString + ".mpurl"));
    localanu.fzT = ((String)paramMap.get(paramString + ".bizusrname"));
    localanu.lpC = ((String)paramMap.get(paramString + ".biznickname"));
    localanu.lpK = ((String)paramMap.get(paramString + ".thumburl"));
    localanu.videoWidth = ((int)Util.getFloat((String)paramMap.get(paramString + ".thumbwidth"), 0.0F));
    localanu.videoHeight = ((int)Util.getFloat((String)paramMap.get(paramString + ".thumbheight"), 0.0F));
    localanu.duration = ((int)Util.getFloat((String)paramMap.get(paramString + ".duration"), 0.0F));
    AppMethodBeat.o(103497);
    return localanu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */