package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class b
{
  public static String a(ahf paramahf)
  {
    AppMethodBeat.i(103496);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramahf == null)
    {
      AppMethodBeat.o(103496);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(bs.aLw(paramahf.hhd)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(bs.aLw(paramahf.ddo)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(bs.aLw(paramahf.hkV)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(bs.aLw(paramahf.hld)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramahf.hgY).append("</itemshowtype>");
    localStringBuffer.append("<ispaysubscribe>").append(paramahf.hhb).append("</ispaysubscribe>");
    localStringBuffer.append("<nativepage>").append(paramahf.hha).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramahf.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramahf.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramahf.hgZ).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramahf.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramahf.hhc).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramahf = localStringBuffer.toString();
    AppMethodBeat.o(103496);
    return paramahf;
  }
  
  public static String b(ahf paramahf)
  {
    AppMethodBeat.i(103498);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramahf == null)
    {
      AppMethodBeat.o(103498);
      return "";
    }
    localStringBuffer.append("<favbrandmpvideo>");
    localStringBuffer.append("<vid>").append(bs.aLw(paramahf.hhd)).append("</vid>");
    localStringBuffer.append("<videourl>").append(bs.aLw(paramahf.videoUrl)).append("</videourl>");
    localStringBuffer.append("<mpurl>").append(bs.aLw(paramahf.DWF)).append("</mpurl>");
    localStringBuffer.append("<bizusrname>").append(bs.aLw(paramahf.ddo)).append("</bizusrname>");
    localStringBuffer.append("<biznickname>").append(bs.aLw(paramahf.hkV)).append("</biznickname>");
    localStringBuffer.append("<thumburl>").append(bs.aLw(paramahf.hld)).append("</thumburl>");
    localStringBuffer.append("<thumbwidth>").append(paramahf.videoWidth).append("</thumbwidth>");
    localStringBuffer.append("<thumbheight>").append(paramahf.videoHeight).append("</thumbheight>");
    localStringBuffer.append("<duration>").append(paramahf.duration).append("</duration>");
    localStringBuffer.append("</favbrandmpvideo>");
    paramahf = localStringBuffer.toString();
    AppMethodBeat.o(103498);
    return paramahf;
  }
  
  public static ahf r(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103495);
    if (!paramMap.containsKey(paramString))
    {
      ac.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103495);
      return null;
    }
    ahf localahf = new ahf();
    localahf.hgY = bs.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localahf.hhb = bs.getInt((String)paramMap.get(paramString + ".ispaysubscribe"), -1);
    localahf.hha = bs.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localahf.videoWidth = bs.getInt((String)paramMap.get(paramString + ".width"), 0);
    localahf.videoHeight = bs.getInt((String)paramMap.get(paramString + ".height"), 0);
    localahf.hgZ = bs.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localahf.duration = bs.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localahf.hhc = bs.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localahf.hhd = ((String)paramMap.get(paramString + ".vid"));
    localahf.ddo = ((String)paramMap.get(paramString + ".srcusername"));
    localahf.hkV = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localahf.hld = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(103495);
    return localahf;
  }
  
  public static ahf s(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103497);
    if (!paramMap.containsKey(paramString))
    {
      ac.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103497);
      return null;
    }
    ahf localahf = new ahf();
    localahf.hhd = ((String)paramMap.get(paramString + ".vid"));
    localahf.videoUrl = ((String)paramMap.get(paramString + ".videourl"));
    localahf.DWF = ((String)paramMap.get(paramString + ".mpurl"));
    localahf.ddo = ((String)paramMap.get(paramString + ".bizusrname"));
    localahf.hkV = ((String)paramMap.get(paramString + ".biznickname"));
    localahf.hld = ((String)paramMap.get(paramString + ".thumburl"));
    localahf.videoWidth = ((int)bs.getFloat((String)paramMap.get(paramString + ".thumbwidth"), 0.0F));
    localahf.videoHeight = ((int)bs.getFloat((String)paramMap.get(paramString + ".thumbheight"), 0.0F));
    localahf.duration = ((int)bs.getFloat((String)paramMap.get(paramString + ".duration"), 0.0F));
    AppMethodBeat.o(103497);
    return localahf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */