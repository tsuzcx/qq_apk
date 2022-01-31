package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class a
{
  private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
  public String bGw = "";
  public int hQR = 0;
  public String kRN = "";
  public String lsF = "";
  public String lsG = "";
  
  public static a Fy(String paramString)
  {
    y.d(TAG, "getIPCallActivityMsgInfoFromXML:" + paramString);
    a locala = new a();
    int i = paramString.indexOf("<ActivityInfo");
    if (i == -1)
    {
      y.e(TAG, "msgContent not start with <ActivityInfo");
      return locala;
    }
    Map localMap = bn.s(paramString.substring(i), "ActivityInfo");
    if (localMap == null)
    {
      y.e(TAG, "XmlParser values is null, xml %s", new Object[] { paramString });
      return null;
    }
    if (localMap.containsKey(".ActivityInfo.Title")) {
      locala.bGw = ((String)localMap.get(".ActivityInfo.Title"));
    }
    if (localMap.containsKey(".ActivityInfo.Desc")) {
      locala.kRN = ((String)localMap.get(".ActivityInfo.Desc"));
    }
    if (localMap.containsKey(".ActivityInfo.ImgUrl")) {
      locala.lsF = ((String)localMap.get(".ActivityInfo.ImgUrl"));
    }
    if (localMap.containsKey(".ActivityInfo.StartBtnText")) {
      locala.lsG = ((String)localMap.get(".ActivityInfo.StartBtnText"));
    }
    if (localMap.containsKey(".ActivityInfo.ActivityType")) {
      locala.hQR = bk.getInt((String)localMap.get(".ActivityInfo.ActivityType"), 0);
    }
    y.d(TAG, "msgInfo:", new Object[] { locala.toString() });
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.a
 * JD-Core Version:    0.7.0.1
 */