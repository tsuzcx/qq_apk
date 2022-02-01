package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class a
{
  private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
  public String Desc = "";
  public String ImgUrl = "";
  public String Title = "";
  public int nEf = 0;
  public String uOp = "";
  
  public static a anx(String paramString)
  {
    AppMethodBeat.i(25530);
    ad.d(TAG, "getIPCallActivityMsgInfoFromXML:".concat(String.valueOf(paramString)));
    a locala = new a();
    int i = paramString.indexOf("<ActivityInfo");
    if (i == -1)
    {
      ad.e(TAG, "msgContent not start with <ActivityInfo");
      AppMethodBeat.o(25530);
      return locala;
    }
    Map localMap = bw.M(paramString.substring(i), "ActivityInfo");
    if (localMap == null)
    {
      ad.e(TAG, "XmlParser values is null, xml %s", new Object[] { paramString });
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
      locala.uOp = ((String)localMap.get(".ActivityInfo.StartBtnText"));
    }
    if (localMap.containsKey(".ActivityInfo.ActivityType")) {
      locala.nEf = bt.getInt((String)localMap.get(".ActivityInfo.ActivityType"), 0);
    }
    ad.d(TAG, "msgInfo:", new Object[] { locala.toString() });
    AppMethodBeat.o(25530);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.a
 * JD-Core Version:    0.7.0.1
 */