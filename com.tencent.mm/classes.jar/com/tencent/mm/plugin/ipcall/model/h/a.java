package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class a
{
  private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
  public String Desc = "";
  public String ImgUrl = "";
  public String Title = "";
  public int ndI = 0;
  public String tLC = "";
  
  public static a aiK(String paramString)
  {
    AppMethodBeat.i(25530);
    ac.d(TAG, "getIPCallActivityMsgInfoFromXML:".concat(String.valueOf(paramString)));
    a locala = new a();
    int i = paramString.indexOf("<ActivityInfo");
    if (i == -1)
    {
      ac.e(TAG, "msgContent not start with <ActivityInfo");
      AppMethodBeat.o(25530);
      return locala;
    }
    Map localMap = bv.L(paramString.substring(i), "ActivityInfo");
    if (localMap == null)
    {
      ac.e(TAG, "XmlParser values is null, xml %s", new Object[] { paramString });
      AppMethodBeat.o(25530);
      return null;
    }
    if (localMap.containsKey(".ActivityInfo.Title")) {
      locala.Title = ((String)localMap.get(".ActivityInfo.Title"));
    }
    if (localMap.containsKey(".ActivityInfo.Desc")) {
      locala.Desc = ((String)localMap.get(".ActivityInfo.Desc"));
    }
    if (localMap.containsKey(".ActivityInfo.ImgUrl")) {
      locala.ImgUrl = ((String)localMap.get(".ActivityInfo.ImgUrl"));
    }
    if (localMap.containsKey(".ActivityInfo.StartBtnText")) {
      locala.tLC = ((String)localMap.get(".ActivityInfo.StartBtnText"));
    }
    if (localMap.containsKey(".ActivityInfo.ActivityType")) {
      locala.ndI = bs.getInt((String)localMap.get(".ActivityInfo.ActivityType"), 0);
    }
    ac.d(TAG, "msgInfo:", new Object[] { locala.toString() });
    AppMethodBeat.o(25530);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.a
 * JD-Core Version:    0.7.0.1
 */