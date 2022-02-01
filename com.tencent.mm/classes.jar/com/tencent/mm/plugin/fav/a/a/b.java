package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class b
{
  public static String a(ajv paramajv)
  {
    AppMethodBeat.i(103496);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramajv == null)
    {
      AppMethodBeat.o(103496);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(bt.aRc(paramajv.hzm)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(bt.aRc(paramajv.doK)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(bt.aRc(paramajv.hDe)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(bt.aRc(paramajv.hDm)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramajv.hzh).append("</itemshowtype>");
    localStringBuffer.append("<ispaysubscribe>").append(paramajv.hzk).append("</ispaysubscribe>");
    localStringBuffer.append("<nativepage>").append(paramajv.hzj).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramajv.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramajv.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramajv.hzi).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramajv.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramajv.hzl).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramajv = localStringBuffer.toString();
    AppMethodBeat.o(103496);
    return paramajv;
  }
  
  public static String b(ajv paramajv)
  {
    AppMethodBeat.i(103498);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramajv == null)
    {
      AppMethodBeat.o(103498);
      return "";
    }
    localStringBuffer.append("<favbrandmpvideo>");
    localStringBuffer.append("<vid>").append(bt.aRc(paramajv.hzm)).append("</vid>");
    localStringBuffer.append("<videourl>").append(bt.aRc(paramajv.videoUrl)).append("</videourl>");
    localStringBuffer.append("<mpurl>").append(bt.aRc(paramajv.FCb)).append("</mpurl>");
    localStringBuffer.append("<bizusrname>").append(bt.aRc(paramajv.doK)).append("</bizusrname>");
    localStringBuffer.append("<biznickname>").append(bt.aRc(paramajv.hDe)).append("</biznickname>");
    localStringBuffer.append("<thumburl>").append(bt.aRc(paramajv.hDm)).append("</thumburl>");
    localStringBuffer.append("<thumbwidth>").append(paramajv.videoWidth).append("</thumbwidth>");
    localStringBuffer.append("<thumbheight>").append(paramajv.videoHeight).append("</thumbheight>");
    localStringBuffer.append("<duration>").append(paramajv.duration).append("</duration>");
    localStringBuffer.append("</favbrandmpvideo>");
    paramajv = localStringBuffer.toString();
    AppMethodBeat.o(103498);
    return paramajv;
  }
  
  public static ajv t(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103495);
    if (!paramMap.containsKey(paramString))
    {
      ad.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103495);
      return null;
    }
    ajv localajv = new ajv();
    localajv.hzh = bt.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localajv.hzk = bt.getInt((String)paramMap.get(paramString + ".ispaysubscribe"), -1);
    localajv.hzj = bt.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localajv.videoWidth = bt.getInt((String)paramMap.get(paramString + ".width"), 0);
    localajv.videoHeight = bt.getInt((String)paramMap.get(paramString + ".height"), 0);
    localajv.hzi = bt.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localajv.duration = bt.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localajv.hzl = bt.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localajv.hzm = ((String)paramMap.get(paramString + ".vid"));
    localajv.doK = ((String)paramMap.get(paramString + ".srcusername"));
    localajv.hDe = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localajv.hDm = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(103495);
    return localajv;
  }
  
  public static ajv u(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(103497);
    if (!paramMap.containsKey(paramString))
    {
      ad.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(103497);
      return null;
    }
    ajv localajv = new ajv();
    localajv.hzm = ((String)paramMap.get(paramString + ".vid"));
    localajv.videoUrl = ((String)paramMap.get(paramString + ".videourl"));
    localajv.FCb = ((String)paramMap.get(paramString + ".mpurl"));
    localajv.doK = ((String)paramMap.get(paramString + ".bizusrname"));
    localajv.hDe = ((String)paramMap.get(paramString + ".biznickname"));
    localajv.hDm = ((String)paramMap.get(paramString + ".thumburl"));
    localajv.videoWidth = ((int)bt.getFloat((String)paramMap.get(paramString + ".thumbwidth"), 0.0F));
    localajv.videoHeight = ((int)bt.getFloat((String)paramMap.get(paramString + ".thumbheight"), 0.0F));
    localajv.duration = ((int)bt.getFloat((String)paramMap.get(paramString + ".duration"), 0.0F));
    AppMethodBeat.o(103497);
    return localajv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */