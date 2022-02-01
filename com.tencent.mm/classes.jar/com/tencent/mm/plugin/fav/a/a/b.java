package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class b
{
  public static String a(akf paramakf)
  {
    AppMethodBeat.i(103496);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramakf == null)
    {
      AppMethodBeat.o(103496);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(bu.aSz(paramakf.hCa)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(bu.aSz(paramakf.dpP)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(bu.aSz(paramakf.hFW)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(bu.aSz(paramakf.hGe)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramakf.hBV).append("</itemshowtype>");
    localStringBuffer.append("<ispaysubscribe>").append(paramakf.hBY).append("</ispaysubscribe>");
    localStringBuffer.append("<nativepage>").append(paramakf.hBX).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramakf.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramakf.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramakf.hBW).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramakf.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramakf.hBZ).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramakf = localStringBuffer.toString();
    AppMethodBeat.o(103496);
    return paramakf;
  }
  
  public static String b(akf paramakf)
  {
    AppMethodBeat.i(103498);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramakf == null)
    {
      AppMethodBeat.o(103498);
      return "";
    }
    localStringBuffer.append("<favbrandmpvideo>");
    localStringBuffer.append("<vid>").append(bu.aSz(paramakf.hCa)).append("</vid>");
    localStringBuffer.append("<videourl>").append(bu.aSz(paramakf.videoUrl)).append("</videourl>");
    localStringBuffer.append("<mpurl>").append(bu.aSz(paramakf.FUw)).append("</mpurl>");
    localStringBuffer.append("<bizusrname>").append(bu.aSz(paramakf.dpP)).append("</bizusrname>");
    localStringBuffer.append("<biznickname>").append(bu.aSz(paramakf.hFW)).append("</biznickname>");
    localStringBuffer.append("<thumburl>").append(bu.aSz(paramakf.hGe)).append("</thumburl>");
    localStringBuffer.append("<thumbwidth>").append(paramakf.videoWidth).append("</thumbwidth>");
    localStringBuffer.append("<thumbheight>").append(paramakf.videoHeight).append("</thumbheight>");
    localStringBuffer.append("<duration>").append(paramakf.duration).append("</duration>");
    localStringBuffer.append("</favbrandmpvideo>");
    paramakf = localStringBuffer.toString();
    AppMethodBeat.o(103498);
    return paramakf;
  }
  
  public static akf u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103495);
    if (!paramMap.containsKey(paramString))
    {
      ae.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103495);
      return null;
    }
    akf localakf = new akf();
    localakf.hBV = bu.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localakf.hBY = bu.getInt((String)paramMap.get(paramString + ".ispaysubscribe"), -1);
    localakf.hBX = bu.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localakf.videoWidth = bu.getInt((String)paramMap.get(paramString + ".width"), 0);
    localakf.videoHeight = bu.getInt((String)paramMap.get(paramString + ".height"), 0);
    localakf.hBW = bu.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localakf.duration = bu.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localakf.hBZ = bu.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localakf.hCa = ((String)paramMap.get(paramString + ".vid"));
    localakf.dpP = ((String)paramMap.get(paramString + ".srcusername"));
    localakf.hFW = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localakf.hGe = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(103495);
    return localakf;
  }
  
  public static akf v(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103497);
    if (!paramMap.containsKey(paramString))
    {
      ae.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103497);
      return null;
    }
    akf localakf = new akf();
    localakf.hCa = ((String)paramMap.get(paramString + ".vid"));
    localakf.videoUrl = ((String)paramMap.get(paramString + ".videourl"));
    localakf.FUw = ((String)paramMap.get(paramString + ".mpurl"));
    localakf.dpP = ((String)paramMap.get(paramString + ".bizusrname"));
    localakf.hFW = ((String)paramMap.get(paramString + ".biznickname"));
    localakf.hGe = ((String)paramMap.get(paramString + ".thumburl"));
    localakf.videoWidth = ((int)bu.getFloat((String)paramMap.get(paramString + ".thumbwidth"), 0.0F));
    localakf.videoHeight = ((int)bu.getFloat((String)paramMap.get(paramString + ".thumbheight"), 0.0F));
    localakf.duration = ((int)bu.getFloat((String)paramMap.get(paramString + ".duration"), 0.0F));
    AppMethodBeat.o(103497);
    return localakf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */