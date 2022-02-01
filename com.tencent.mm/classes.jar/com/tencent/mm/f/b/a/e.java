package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class e
  extends a
{
  public long gdA;
  public long gdB;
  public String gdC;
  public long gdD;
  public String gdE;
  private String gdF;
  public int gdG;
  public boolean gdc;
  public long gdd;
  public long gde;
  private String gdf;
  public long gdn;
  private String gdo;
  public int gdp;
  public int gdq;
  public String gdr;
  public long gds;
  public long gdt;
  public int gdu;
  public int gdv;
  public long gdw;
  public long gdx;
  public long gdy;
  private long gdz;
  
  public e()
  {
    this.gdo = "";
    this.gdr = "";
    this.gdf = "";
    this.gdC = "";
    this.gdE = "";
    this.gdF = "";
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(239547);
    this.gdo = "";
    this.gdr = "";
    this.gdf = "";
    this.gdC = "";
    this.gdE = "";
    this.gdF = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 24) {
          break label364;
        }
        String[] arrayOfString = new String[24];
        Arrays.fill(arrayOfString, 0, 24, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label364:
    for (;;)
    {
      this.gdn = Util.getLong(paramString[0], 0L);
      this.gdc = a.getBoolean(paramString[1]);
      bV(Util.getLong(paramString[2], 0L));
      this.gde = Util.getLong(paramString[3], 0L);
      iw(paramString[4]);
      this.gdp = Util.getInt(paramString[5], 0);
      this.gdq = Util.getInt(paramString[6], 0);
      ix(paramString[7]);
      this.gds = Util.getLong(paramString[8], 0L);
      this.gdt = Util.getLong(paramString[9], 0L);
      iy(paramString[10]);
      this.gdu = Util.getInt(paramString[11], 0);
      this.gdv = Util.getInt(paramString[12], 0);
      this.gdw = Util.getLong(paramString[13], 0L);
      this.gdx = Util.getLong(paramString[14], 0L);
      this.gdy = Util.getLong(paramString[15], 0L);
      bW(Util.getLong(paramString[16], 0L));
      this.gdA = Util.getLong(paramString[17], 0L);
      this.gdB = Util.getLong(paramString[18], 0L);
      iz(paramString[19]);
      this.gdD = Util.getLong(paramString[20], 0L);
      iA(paramString[21]);
      iB(paramString[22]);
      this.gdG = Util.getInt(paramString[23], 0);
      AppMethodBeat.o(239547);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(239574);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdn);
    ((StringBuffer)localObject).append(",");
    if (this.gdc) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gde);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdo);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gds);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdu);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdx);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdz);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdB);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdC);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gdG);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(239574);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(239581);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IsEnterFinderUI:").append(this.gdn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMsgOpenWechatBool:").append(this.gdc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastEnterFinderTimeStampMs:").append(this.gdd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderStayTime:").append(this.gde);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotTipsId:").append(this.gdo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotCtrlType:").append(this.gdp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotShowType:").append(this.gdq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastSessionId:").append(this.gdr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendsTabRedDot:").append(this.gds);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendsTabRedUnread:").append(this.gdt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotTipsId:").append(this.gdf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotCtrlType:").append(this.gdu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotShowType:").append(this.gdv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsRedDot:").append(this.gdw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUnread:").append(this.gdx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopStoryRedDot:").append(this.gdy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterFinderTimeStampMs:").append(this.gdz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderStayTime:").append(this.gdA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastSessionDuration:").append(this.gdB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FindFriendUIExposure:").append(this.gdC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatDuration7DayHour:").append(this.gdD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatDurationNMinute:").append(this.gdE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.gdF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatUseCount:").append(this.gdG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(239581);
    return localObject;
  }
  
  public final e bV(long paramLong)
  {
    AppMethodBeat.i(239551);
    this.gdd = paramLong;
    super.bm("LastEnterFinderTimeStampMs", this.gdd);
    AppMethodBeat.o(239551);
    return this;
  }
  
  public final e bW(long paramLong)
  {
    AppMethodBeat.i(239563);
    this.gdz = paramLong;
    super.bm("EnterFinderTimeStampMs", this.gdz);
    AppMethodBeat.o(239563);
    return this;
  }
  
  public final int getId()
  {
    return 20964;
  }
  
  public final e iA(String paramString)
  {
    AppMethodBeat.i(239568);
    this.gdE = z("WechatDurationNMinute", paramString, true);
    AppMethodBeat.o(239568);
    return this;
  }
  
  public final e iB(String paramString)
  {
    AppMethodBeat.i(239570);
    this.gdF = z("NetType", paramString, true);
    AppMethodBeat.o(239570);
    return this;
  }
  
  public final e iw(String paramString)
  {
    AppMethodBeat.i(239555);
    this.gdo = z("LastFinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(239555);
    return this;
  }
  
  public final e ix(String paramString)
  {
    AppMethodBeat.i(239558);
    this.gdr = z("LastSessionId", paramString, true);
    AppMethodBeat.o(239558);
    return this;
  }
  
  public final e iy(String paramString)
  {
    AppMethodBeat.i(239560);
    this.gdf = z("FinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(239560);
    return this;
  }
  
  public final e iz(String paramString)
  {
    AppMethodBeat.i(239566);
    this.gdC = z("FindFriendUIExposure", paramString, true);
    AppMethodBeat.o(239566);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.e
 * JD-Core Version:    0.7.0.1
 */