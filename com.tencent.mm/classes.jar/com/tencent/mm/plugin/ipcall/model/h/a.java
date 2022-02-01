package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class a
{
  private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
  public String Desc = "";
  public String ImgUrl = "";
  public String Title = "";
  public int nJA = 0;
  public String vac = "";
  
  public static a aoz(String paramString)
  {
    AppMethodBeat.i(25530);
    ae.d(TAG, "getIPCallActivityMsgInfoFromXML:".concat(String.valueOf(paramString)));
    a locala = new a();
    int i = paramString.indexOf("<ActivityInfo");
    if (i == -1)
    {
      ae.e(TAG, "msgContent not start with <ActivityInfo");
      AppMethodBeat.o(25530);
      return locala;
    }
    Map localMap = bx.M(paramString.substring(i), "ActivityInfo");
    if (localMap == null)
    {
      ae.e(TAG, "XmlParser values is null, xml %s", new Object[] { paramString });
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
      locala.vac = ((String)localMap.get(".ActivityInfo.StartBtnText"));
    }
    if (localMap.containsKey(".ActivityInfo.ActivityType")) {
      locala.nJA = bu.getInt((String)localMap.get(".ActivityInfo.ActivityType"), 0);
    }
    ae.d(TAG, "msgInfo:", new Object[] { locala.toString() });
    AppMethodBeat.o(25530);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.a
 * JD-Core Version:    0.7.0.1
 */