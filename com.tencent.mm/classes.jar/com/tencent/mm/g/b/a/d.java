package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class d
  extends a
{
  public boolean eiJ;
  public long eiK;
  public long eiL;
  private String eiM;
  public long eiU;
  private String eiV;
  public int eiW;
  public int eiX;
  public String eiY;
  public long eiZ;
  public long eja;
  public int ejb;
  public int ejc;
  public long ejd;
  public long eje;
  public long ejf;
  private long ejg;
  public long ejh;
  public long eji;
  public String ejj;
  public long ejk;
  public String ejl;
  private String ejm;
  public int ejn;
  
  public d()
  {
    this.eiV = "";
    this.eiY = "";
    this.eiM = "";
    this.ejj = "";
    this.ejl = "";
    this.ejm = "";
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(238830);
    this.eiV = "";
    this.eiY = "";
    this.eiM = "";
    this.ejj = "";
    this.ejl = "";
    this.ejm = "";
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
      this.eiU = Util.getLong(paramString[0], 0L);
      this.eiJ = a.getBoolean(paramString[1]);
      bG(Util.getLong(paramString[2], 0L));
      this.eiL = Util.getLong(paramString[3], 0L);
      hG(paramString[4]);
      this.eiW = Util.getInt(paramString[5], 0);
      this.eiX = Util.getInt(paramString[6], 0);
      hH(paramString[7]);
      this.eiZ = Util.getLong(paramString[8], 0L);
      this.eja = Util.getLong(paramString[9], 0L);
      hI(paramString[10]);
      this.ejb = Util.getInt(paramString[11], 0);
      this.ejc = Util.getInt(paramString[12], 0);
      this.ejd = Util.getLong(paramString[13], 0L);
      this.eje = Util.getLong(paramString[14], 0L);
      this.ejf = Util.getLong(paramString[15], 0L);
      bH(Util.getLong(paramString[16], 0L));
      this.ejh = Util.getLong(paramString[17], 0L);
      this.eji = Util.getLong(paramString[18], 0L);
      hJ(paramString[19]);
      this.ejk = Util.getLong(paramString[20], 0L);
      hK(paramString[21]);
      hL(paramString[22]);
      this.ejn = Util.getInt(paramString[23], 0);
      AppMethodBeat.o(238830);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(238839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiU);
    ((StringBuffer)localObject).append(",");
    if (this.eiJ) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiV);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiX);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiY);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eja);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eiM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eje);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejh);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eji);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejk);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejl);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ejn);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(238839);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238840);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IsEnterFinderUI:").append(this.eiU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMsgOpenWechatBool:").append(this.eiJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastEnterFinderTimeStampMs:").append(this.eiK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderStayTime:").append(this.eiL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotTipsId:").append(this.eiV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotCtrlType:").append(this.eiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastFinderRedDotShowType:").append(this.eiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastSessionId:").append(this.eiY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendsTabRedDot:").append(this.eiZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendsTabRedUnread:").append(this.eja);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotTipsId:").append(this.eiM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotCtrlType:").append(this.ejb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRedDotShowType:").append(this.ejc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsRedDot:").append(this.ejd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUnread:").append(this.eje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopStoryRedDot:").append(this.ejf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterFinderTimeStampMs:").append(this.ejg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderStayTime:").append(this.ejh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LastSessionDuration:").append(this.eji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FindFriendUIExposure:").append(this.ejj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatDuration7DayHour:").append(this.ejk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatDurationNMinute:").append(this.ejl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatUseCount:").append(this.ejn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238840);
    return localObject;
  }
  
  public final d bG(long paramLong)
  {
    AppMethodBeat.i(238831);
    this.eiK = paramLong;
    super.bj("LastEnterFinderTimeStampMs", this.eiK);
    AppMethodBeat.o(238831);
    return this;
  }
  
  public final d bH(long paramLong)
  {
    AppMethodBeat.i(238835);
    this.ejg = paramLong;
    super.bj("EnterFinderTimeStampMs", this.ejg);
    AppMethodBeat.o(238835);
    return this;
  }
  
  public final int getId()
  {
    return 20964;
  }
  
  public final d hG(String paramString)
  {
    AppMethodBeat.i(238832);
    this.eiV = x("LastFinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(238832);
    return this;
  }
  
  public final d hH(String paramString)
  {
    AppMethodBeat.i(238833);
    this.eiY = x("LastSessionId", paramString, true);
    AppMethodBeat.o(238833);
    return this;
  }
  
  public final d hI(String paramString)
  {
    AppMethodBeat.i(238834);
    this.eiM = x("FinderRedDotTipsId", paramString, true);
    AppMethodBeat.o(238834);
    return this;
  }
  
  public final d hJ(String paramString)
  {
    AppMethodBeat.i(238836);
    this.ejj = x("FindFriendUIExposure", paramString, true);
    AppMethodBeat.o(238836);
    return this;
  }
  
  public final d hK(String paramString)
  {
    AppMethodBeat.i(238837);
    this.ejl = x("WechatDurationNMinute", paramString, true);
    AppMethodBeat.o(238837);
    return this;
  }
  
  public final d hL(String paramString)
  {
    AppMethodBeat.i(238838);
    this.ejm = x("NetType", paramString, true);
    AppMethodBeat.o(238838);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.d
 * JD-Core Version:    0.7.0.1
 */