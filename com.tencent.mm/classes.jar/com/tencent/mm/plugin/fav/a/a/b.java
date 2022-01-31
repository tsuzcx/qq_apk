package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class b
{
  public static String a(aci paramaci)
  {
    AppMethodBeat.i(152623);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramaci == null)
    {
      AppMethodBeat.o(152623);
      return "";
    }
    localStringBuffer.append("<appmsgshareitem>");
    localStringBuffer.append("<vid>").append(bo.apT(paramaci.fgl)).append("</vid>");
    localStringBuffer.append("<srcusername>").append(bo.apT(paramaci.cqX)).append("</srcusername>");
    localStringBuffer.append("<srcdisplayname>").append(bo.apT(paramaci.fjB)).append("</srcdisplayname>");
    localStringBuffer.append("<cover>").append(bo.apT(paramaci.fjJ)).append("</cover>");
    localStringBuffer.append("<itemshowtype>").append(paramaci.fgh).append("</itemshowtype>");
    localStringBuffer.append("<nativepage>").append(paramaci.fgj).append("</nativepage>");
    localStringBuffer.append("<width>").append(paramaci.videoWidth).append("</width>");
    localStringBuffer.append("<height>").append(paramaci.videoHeight).append("</height>");
    localStringBuffer.append("<pubtime>").append(paramaci.fgi).append("</pubtime>");
    localStringBuffer.append("<duration>").append(paramaci.duration).append("</duration>");
    localStringBuffer.append("<funcflag>").append(paramaci.fgk).append("</funcflag>");
    localStringBuffer.append("</appmsgshareitem>");
    paramaci = localStringBuffer.toString();
    AppMethodBeat.o(152623);
    return paramaci;
  }
  
  public static aci o(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(152622);
    if (!paramMap.containsKey(paramString))
    {
      ab.v("MicroMsg.FavUrlItemParser", "cur fav not contains %s", new Object[] { paramString });
      AppMethodBeat.o(152622);
      return null;
    }
    aci localaci = new aci();
    localaci.fgh = bo.getInt((String)paramMap.get(paramString + ".itemshowtype"), -1);
    localaci.fgj = bo.getInt((String)paramMap.get(paramString + ".nativepage"), 0);
    localaci.videoWidth = bo.getInt((String)paramMap.get(paramString + ".width"), 0);
    localaci.videoHeight = bo.getInt((String)paramMap.get(paramString + ".height"), 0);
    localaci.fgi = bo.getInt((String)paramMap.get(paramString + ".pubtime"), 0);
    localaci.duration = bo.getInt((String)paramMap.get(paramString + ".duration"), 0);
    localaci.fgk = bo.getInt((String)paramMap.get(paramString + ".funcflag"), 0);
    localaci.fgl = ((String)paramMap.get(paramString + ".vid"));
    localaci.cqX = ((String)paramMap.get(paramString + ".srcusername"));
    localaci.fjB = ((String)paramMap.get(paramString + ".srcdisplayname"));
    localaci.fjJ = ((String)paramMap.get(paramString + ".cover"));
    AppMethodBeat.o(152622);
    return localaci;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.a.b
 * JD-Core Version:    0.7.0.1
 */