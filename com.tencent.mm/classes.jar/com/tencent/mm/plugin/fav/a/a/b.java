package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class b
{
  public static String a(agg paramagg)
  {
    AppMethodBeat.i(103496);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramagg == null)
    {
      AppMethodBeat.o(103496);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(bt.aGf(paramagg.gGC)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(bt.aGf(paramagg.dfT)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(bt.aGf(paramagg.gKv)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(bt.aGf(paramagg.gKD)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramagg.gGx).append("</itemshowtype>");
    localStringBuffer.append("<ispaysubscribe>").append(paramagg.gGA).append("</ispaysubscribe>");
    localStringBuffer.append("<nativepage>").append(paramagg.gGz).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramagg.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramagg.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramagg.gGy).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramagg.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramagg.gGB).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramagg = localStringBuffer.toString();
    AppMethodBeat.o(103496);
    return paramagg;
  }
  
  public static String b(agg paramagg)
  {
    AppMethodBeat.i(103498);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramagg == null)
    {
      AppMethodBeat.o(103498);
      return "";
    }
    localStringBuffer.append("<favbrandmpvideo>");
    localStringBuffer.append("<vid>").append(bt.aGf(paramagg.gGC)).append("</vid>");
    localStringBuffer.append("<videourl>").append(bt.aGf(paramagg.videoUrl)).append("</videourl>");
    localStringBuffer.append("<mpurl>").append(bt.aGf(paramagg.CEf)).append("</mpurl>");
    localStringBuffer.append("<bizusrname>").append(bt.aGf(paramagg.dfT)).append("</bizusrname>");
    localStringBuffer.append("<biznickname>").append(bt.aGf(paramagg.gKv)).append("</biznickname>");
    localStringBuffer.append("<thumburl>").append(bt.aGf(paramagg.gKD)).append("</thumburl>");
    localStringBuffer.append("<thumbwidth>").append(paramagg.videoWidth).append("</thumbwidth>");
    localStringBuffer.append("<thumbheight>").append(paramagg.videoHeight).append("</thumbheight>");
    localStringBuffer.append("<duration>").append(paramagg.duration).append("</duration>");
    localStringBuffer.append("</favbrandmpvideo>");
    paramagg = localStringBuffer.toString();
    AppMethodBeat.o(103498);
    return paramagg;
  }
  
  public static agg q(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103495);
    if (!paramMap.containsKey(paramString))
    {
      ad.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103495);
      return null;
    }
    agg localagg = new agg();
    localagg.gGx = bt.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localagg.gGA = bt.getInt((String)paramMap.get(paramString + ".ispaysubscribe"), -1);
    localagg.gGz = bt.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localagg.videoWidth = bt.getInt((String)paramMap.get(paramString + ".width"), 0);
    localagg.videoHeight = bt.getInt((String)paramMap.get(paramString + ".height"), 0);
    localagg.gGy = bt.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localagg.duration = bt.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localagg.gGB = bt.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localagg.gGC = ((String)paramMap.get(paramString + ".vid"));
    localagg.dfT = ((String)paramMap.get(paramString + ".srcusername"));
    localagg.gKv = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localagg.gKD = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(103495);
    return localagg;
  }
  
  public static agg r(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103497);
    if (!paramMap.containsKey(paramString))
    {
      ad.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103497);
      return null;
    }
    agg localagg = new agg();
    localagg.gGC = ((String)paramMap.get(paramString + ".vid"));
    localagg.videoUrl = ((String)paramMap.get(paramString + ".videourl"));
    localagg.CEf = ((String)paramMap.get(paramString + ".mpurl"));
    localagg.dfT = ((String)paramMap.get(paramString + ".bizusrname"));
    localagg.gKv = ((String)paramMap.get(paramString + ".biznickname"));
    localagg.gKD = ((String)paramMap.get(paramString + ".thumburl"));
    localagg.videoWidth = ((int)bt.getFloat((String)paramMap.get(paramString + ".thumbwidth"), 0.0F));
    localagg.videoHeight = ((int)bt.getFloat((String)paramMap.get(paramString + ".thumbheight"), 0.0F));
    localagg.duration = ((int)bt.getFloat((String)paramMap.get(paramString + ".duration"), 0.0F));
    AppMethodBeat.o(103497);
    return localagg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */