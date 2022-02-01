package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class e
  extends a
{
  public long ijD;
  private String ijE;
  public int ijF;
  public int ijG;
  public String ijH;
  public long ijI;
  public long ijJ;
  public int ijK;
  public int ijL;
  public long ijM;
  public long ijN;
  public long ijO;
  private long ijP;
  public long ijQ;
  public long ijR;
  public String ijS;
  public long ijT;
  public String ijU;
  private String ijV;
  public int ijW;
  public boolean ijs;
  public long ijt;
  public long iju;
  private String ijv;
  
  public e()
  {
    this.ijE = "";
    this.ijH = "";
    this.ijv = "";
    this.ijS = "";
    this.ijU = "";
    this.ijV = "";
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(368742);
    this.ijE = "";
    this.ijH = "";
    this.ijv = "";
    this.ijS = "";
    this.ijU = "";
    this.ijV = "";
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
      this.ijD = Util.getLong(paramString[0], 0L);
      this.ijs = a.getBoolean(paramString[1]);
      el(Util.getLong(paramString[2], 0L));
      this.iju = Util.getLong(paramString[3], 0L);
      jS(paramString[4]);
      this.ijF = Util.getInt(paramString[5], 0);
      this.ijG = Util.getInt(paramString[6], 0);
      jT(paramString[7]);
      this.ijI = Util.getLong(paramString[8], 0L);
      this.ijJ = Util.getLong(paramString[9], 0L);
      jU(paramString[10]);
      this.ijK = Util.getInt(paramString[11], 0);
      this.ijL = Util.getInt(paramString[12], 0);
      this.ijM = Util.getLong(paramString[13], 0L);
      this.ijN = Util.getLong(paramString[14], 0L);
      this.ijO = Util.getLong(paramString[15], 0L);
      em(Util.getLong(paramString[16], 0L));
      this.ijQ = Util.getLong(paramString[17], 0L);
      this.ijR = Util.getLong(paramString[18], 0L);
      jV(paramString[19]);
      this.ijT = Util.getLong(paramString[20], 0L);
      jW(paramString[21]);
      jX(paramString[22]);
      this.ijW = Util.getInt(paramString[23], 0);
      AppMethodBeat.o(368742);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368796);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijD);
    ((StringBuffer)localObject).append(",");
    if (this.ijs) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iju);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijE);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijF);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijI);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijJ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijO);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijQ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijR);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijS);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ijW);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(368796);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368800);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IsEnterFinderUI:").append(this.ijD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMsgOpenWechatBool:").append(this.ijs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastEnterFinderTimeStampMs:").append(this.ijt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderStayTime:").append(this.iju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotTipsId:").append(this.ijE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotCtrlType:").append(this.ijF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotShowType:").append(this.ijG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastSessionId:").append(this.ijH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendsTabRedDot:").append(this.ijI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendsTabRedUnread:").append(this.ijJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotTipsId:").append(this.ijv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotCtrlType:").append(this.ijK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotShowType:").append(this.ijL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsRedDot:").append(this.ijM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUnread:").append(this.ijN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopStoryRedDot:").append(this.ijO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterFinderTimeStampMs:").append(this.ijP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderStayTime:").append(this.ijQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastSessionDuration:").append(this.ijR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FindFriendUIExposure:").append(this.ijS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatDuration7DayHour:").append(this.ijT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatDurationNMinute:").append(this.ijU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ijV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatUseCount:").append(this.ijW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368800);
    return localObject;
  }
  
  public final e el(long paramLong)
  {
    AppMethodBeat.i(368749);
    this.ijt = paramLong;
    super.by("LastEnterFinderTimeStampMs", this.ijt);
    AppMethodBeat.o(368749);
    return this;
  }
  
  public final e em(long paramLong)
  {
    AppMethodBeat.i(368768);
    this.ijP = paramLong;
    super.by("EnterFinderTimeStampMs", this.ijP);
    AppMethodBeat.o(368768);
    return this;
  }
  
  public final int getId()
  {
    return 20964;
  }
  
  public final e jS(String paramString)
  {
    AppMethodBeat.i(368754);
    this.ijE = F("LastFinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(368754);
    return this;
  }
  
  public final e jT(String paramString)
  {
    AppMethodBeat.i(368761);
    this.ijH = F("LastSessionId", paramString, true);
    AppMethodBeat.o(368761);
    return this;
  }
  
  public final e jU(String paramString)
  {
    AppMethodBeat.i(368765);
    this.ijv = F("FinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(368765);
    return this;
  }
  
  public final e jV(String paramString)
  {
    AppMethodBeat.i(368774);
    this.ijS = F("FindFriendUIExposure", paramString, true);
    AppMethodBeat.o(368774);
    return this;
  }
  
  public final e jW(String paramString)
  {
    AppMethodBeat.i(368780);
    this.ijU = F("WechatDurationNMinute", paramString, true);
    AppMethodBeat.o(368780);
    return this;
  }
  
  public final e jX(String paramString)
  {
    AppMethodBeat.i(368787);
    this.ijV = F("NetType", paramString, true);
    AppMethodBeat.o(368787);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.e
 * JD-Core Version:    0.7.0.1
 */