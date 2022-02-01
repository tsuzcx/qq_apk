package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b
{
  public static String a(arn paramarn)
  {
    AppMethodBeat.i(103496);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramarn == null)
    {
      AppMethodBeat.o(103496);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(Util.escapeStringForXml(paramarn.vid)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(Util.escapeStringForXml(paramarn.hEE)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(Util.escapeStringForXml(paramarn.nUF)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(Util.escapeStringForXml(paramarn.nUM)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramarn.nQm).append("</itemshowtype>");
    localStringBuffer.append("<ispaysubscribe>").append(paramarn.nQp).append("</ispaysubscribe>");
    localStringBuffer.append("<nativepage>").append(paramarn.nQo).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramarn.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramarn.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramarn.nQn).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramarn.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramarn.nQq).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramarn = localStringBuffer.toString();
    AppMethodBeat.o(103496);
    return paramarn;
  }
  
  public static String b(arn paramarn)
  {
    AppMethodBeat.i(103498);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramarn == null)
    {
      AppMethodBeat.o(103498);
      return "";
    }
    localStringBuffer.append("<favbrandmpvideo>");
    localStringBuffer.append("<vid>").append(Util.escapeStringForXml(paramarn.vid)).append("</vid>");
    localStringBuffer.append("<videourl>").append(Util.escapeStringForXml(paramarn.videoUrl)).append("</videourl>");
    localStringBuffer.append("<mpurl>").append(Util.escapeStringForXml(paramarn.YMm)).append("</mpurl>");
    localStringBuffer.append("<bizusrname>").append(Util.escapeStringForXml(paramarn.hEE)).append("</bizusrname>");
    localStringBuffer.append("<biznickname>").append(Util.escapeStringForXml(paramarn.nUF)).append("</biznickname>");
    localStringBuffer.append("<thumburl>").append(Util.escapeStringForXml(paramarn.nUM)).append("</thumburl>");
    localStringBuffer.append("<thumbwidth>").append(paramarn.videoWidth).append("</thumbwidth>");
    localStringBuffer.append("<thumbheight>").append(paramarn.videoHeight).append("</thumbheight>");
    localStringBuffer.append("<duration>").append(paramarn.duration).append("</duration>");
    localStringBuffer.append("</favbrandmpvideo>");
    paramarn = localStringBuffer.toString();
    AppMethodBeat.o(103498);
    return paramarn;
  }
  
  public static arn u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103495);
    if (!paramMap.containsKey(paramString))
    {
      Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103495);
      return null;
    }
    arn localarn = new arn();
    localarn.nQm = Util.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localarn.nQp = Util.getInt((String)paramMap.get(paramString + ".ispaysubscribe"), -1);
    localarn.nQo = Util.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localarn.videoWidth = Util.getInt((String)paramMap.get(paramString + ".width"), 0);
    localarn.videoHeight = Util.getInt((String)paramMap.get(paramString + ".height"), 0);
    localarn.nQn = Util.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localarn.duration = Util.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localarn.nQq = Util.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localarn.vid = ((String)paramMap.get(paramString + ".vid"));
    localarn.hEE = ((String)paramMap.get(paramString + ".srcusername"));
    localarn.nUF = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localarn.nUM = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(103495);
    return localarn;
  }
  
  public static arn v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103497);
    if (!paramMap.containsKey(paramString))
    {
      Log.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103497);
      return null;
    }
    arn localarn = new arn();
    localarn.vid = ((String)paramMap.get(paramString + ".vid"));
    localarn.videoUrl = ((String)paramMap.get(paramString + ".videourl"));
    localarn.YMm = ((String)paramMap.get(paramString + ".mpurl"));
    localarn.hEE = ((String)paramMap.get(paramString + ".bizusrname"));
    localarn.nUF = ((String)paramMap.get(paramString + ".biznickname"));
    localarn.nUM = ((String)paramMap.get(paramString + ".thumburl"));
    localarn.videoWidth = ((int)Util.getFloat((String)paramMap.get(paramString + ".thumbwidth"), 0.0F));
    localarn.videoHeight = ((int)Util.getFloat((String)paramMap.get(paramString + ".thumbheight"), 0.0F));
    localarn.duration = ((int)Util.getFloat((String)paramMap.get(paramString + ".duration"), 0.0F));
    AppMethodBeat.o(103497);
    return localarn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */