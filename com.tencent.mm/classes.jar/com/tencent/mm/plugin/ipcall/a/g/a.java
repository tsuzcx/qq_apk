package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a
{
  private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
  public String Desc = "";
  public String ImgUrl = "";
  public String Title = "";
  public int jKs = 0;
  public String nQa = "";
  
  public static a QY(String paramString)
  {
    AppMethodBeat.i(21915);
    ab.d(TAG, "getIPCallActivityMsgInfoFromXML:".concat(String.valueOf(paramString)));
    a locala = new a();
    int i = paramString.indexOf("<ActivityInfo");
    if (i == -1)
    {
      ab.e(TAG, "msgContent not start with <ActivityInfo");
      AppMethodBeat.o(21915);
      return locala;
    }
    Map localMap = br.F(paramString.substring(i), "ActivityInfo");
    if (localMap == null)
    {
      ab.e(TAG, "XmlParser values is null, xml %s", new Object[] { paramString });
      AppMethodBeat.o(21915);
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
      locala.nQa = ((String)localMap.get(".ActivityInfo.StartBtnText"));
    }
    if (localMap.containsKey(".ActivityInfo.ActivityType")) {
      locala.jKs = bo.getInt((String)localMap.get(".ActivityInfo.ActivityType"), 0);
    }
    ab.d(TAG, "msgInfo:", new Object[] { locala.toString() });
    AppMethodBeat.o(21915);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.a
 * JD-Core Version:    0.7.0.1
 */