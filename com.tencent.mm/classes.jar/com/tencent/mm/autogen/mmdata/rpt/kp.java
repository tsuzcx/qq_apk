package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class kp
  extends a
{
  public long iMe;
  public int iPH;
  private String iWS;
  private String iWT;
  private String iWU;
  private String iWV;
  private String iWY;
  private String iXa;
  private String iXc;
  private String iXh;
  public long iXi;
  public long iXj;
  private String iXk;
  private String iXl;
  private String iXm;
  private String iXn;
  public long iXo;
  public long iXp;
  public long iXq;
  public long iXr;
  public long iXs;
  public long iXt;
  private String iXu;
  public int iXv;
  public int iXw;
  public long ioV;
  private String ioY;
  private String ipT;
  public long iqr;
  private String ivZ;
  private String izJ;
  
  public kp()
  {
    this.ipT = "";
    this.iXh = "";
    this.iWS = "";
    this.iWY = "";
    this.iWU = "";
    this.iWV = "";
    this.iWT = "";
    this.iXc = "";
    this.iXa = "";
    this.izJ = "";
    this.iXk = "";
    this.ivZ = "";
    this.iXl = "";
    this.iXm = "";
    this.iXn = "";
    this.ioY = "";
    this.iXu = "";
  }
  
  public kp(String paramString)
  {
    AppMethodBeat.i(368803);
    this.ipT = "";
    this.iXh = "";
    this.iWS = "";
    this.iWY = "";
    this.iWU = "";
    this.iWV = "";
    this.iWT = "";
    this.iXc = "";
    this.iXa = "";
    this.izJ = "";
    this.iXk = "";
    this.ivZ = "";
    this.iXl = "";
    this.iXm = "";
    this.iXn = "";
    this.ioY = "";
    this.iXu = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 31) {
          break label480;
        }
        String[] arrayOfString = new String[31];
        Arrays.fill(arrayOfString, 0, 31, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label480:
    for (;;)
    {
      sZ(paramString[0]);
      ta(paramString[1]);
      tb(paramString[2]);
      tc(paramString[3]);
      td(paramString[4]);
      te(paramString[5]);
      tf(paramString[6]);
      this.ioV = Util.getLong(paramString[7], 0L);
      this.iXi = Util.getLong(paramString[8], 0L);
      tg(paramString[9]);
      th(paramString[10]);
      ti(paramString[11]);
      this.iXj = Util.getLong(paramString[12], 0L);
      tj(paramString[13]);
      tk(paramString[14]);
      tl(paramString[15]);
      tm(paramString[16]);
      tn(paramString[17]);
      this.iMe = Util.getLong(paramString[18], 0L);
      this.iXo = Util.getLong(paramString[19], 0L);
      this.iXp = Util.getLong(paramString[20], 0L);
      this.iXq = Util.getLong(paramString[21], 0L);
      this.iXr = Util.getLong(paramString[22], 0L);
      this.iXs = Util.getLong(paramString[23], 0L);
      this.iqr = Util.getLong(paramString[24], 0L);
      to(paramString[25]);
      this.iXt = Util.getLong(paramString[26], 0L);
      tp(paramString[27]);
      this.iXv = Util.getInt(paramString[28], 0);
      this.iXw = Util.getInt(paramString[29], 0);
      this.iPH = Util.getInt(paramString[30], 0);
      AppMethodBeat.o(368803);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368891);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPH);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368891);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateContextId:").append(this.iXh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.iWS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.iWY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.iWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.iWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.iWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSave:").append(this.iXi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvUserId:").append(this.iXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvObjectId:").append(this.iXa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.izJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFinderNew:").append(this.iXj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartList:").append(this.iXk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUin:").append(this.iXl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyWord:").append(this.iXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.iXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.iMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartNum:").append(this.iXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartId:").append(this.iXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFrom:").append(this.iXq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEdit:").append(this.iXr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNull:").append(this.iXs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.ioY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateType:").append(this.iXt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaterialCount:").append(this.iXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Transition:").append(this.iXv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideMediaCount:").append(this.iXw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageType:").append(this.iPH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368906);
    return localObject;
  }
  
  public final int getId()
  {
    return 22259;
  }
  
  public final kp sZ(String paramString)
  {
    AppMethodBeat.i(368811);
    this.ipT = F("ContextId", paramString, true);
    AppMethodBeat.o(368811);
    return this;
  }
  
  public final kp ta(String paramString)
  {
    AppMethodBeat.i(368817);
    this.iXh = F("CreateContextId", paramString, true);
    AppMethodBeat.o(368817);
    return this;
  }
  
  public final kp tb(String paramString)
  {
    AppMethodBeat.i(368819);
    this.iWS = F("SongName", paramString, true);
    AppMethodBeat.o(368819);
    return this;
  }
  
  public final kp tc(String paramString)
  {
    AppMethodBeat.i(368824);
    this.iWY = F("SongId", paramString, true);
    AppMethodBeat.o(368824);
    return this;
  }
  
  public final kp td(String paramString)
  {
    AppMethodBeat.i(368831);
    this.iWU = F("WebUrl", paramString, true);
    AppMethodBeat.o(368831);
    return this;
  }
  
  public final kp te(String paramString)
  {
    AppMethodBeat.i(368837);
    this.iWV = F("DataUrl", paramString, true);
    AppMethodBeat.o(368837);
    return this;
  }
  
  public final kp tf(String paramString)
  {
    AppMethodBeat.i(368839);
    this.iWT = F("Singer", paramString, true);
    AppMethodBeat.o(368839);
    return this;
  }
  
  public final kp tg(String paramString)
  {
    AppMethodBeat.i(368844);
    this.iXc = F("MvUserId", paramString, true);
    AppMethodBeat.o(368844);
    return this;
  }
  
  public final kp th(String paramString)
  {
    AppMethodBeat.i(368849);
    this.iXa = F("MvObjectId", paramString, true);
    AppMethodBeat.o(368849);
    return this;
  }
  
  public final kp ti(String paramString)
  {
    AppMethodBeat.i(368852);
    this.izJ = F("FinderSessionId", paramString, true);
    AppMethodBeat.o(368852);
    return this;
  }
  
  public final kp tj(String paramString)
  {
    AppMethodBeat.i(368857);
    this.iXk = F("PartList", paramString, true);
    AppMethodBeat.o(368857);
    return this;
  }
  
  public final kp tk(String paramString)
  {
    AppMethodBeat.i(368862);
    this.ivZ = F("FeedId", paramString, true);
    AppMethodBeat.o(368862);
    return this;
  }
  
  public final kp tl(String paramString)
  {
    AppMethodBeat.i(368866);
    this.iXl = F("FinderUin", paramString, true);
    AppMethodBeat.o(368866);
    return this;
  }
  
  public final kp tm(String paramString)
  {
    AppMethodBeat.i(368871);
    this.iXm = F("KeyWord", paramString, true);
    AppMethodBeat.o(368871);
    return this;
  }
  
  public final kp tn(String paramString)
  {
    AppMethodBeat.i(368873);
    this.iXn = F("ExpId", paramString, true);
    AppMethodBeat.o(368873);
    return this;
  }
  
  public final kp to(String paramString)
  {
    AppMethodBeat.i(368878);
    this.ioY = F("RequestId", paramString, true);
    AppMethodBeat.o(368878);
    return this;
  }
  
  public final kp tp(String paramString)
  {
    AppMethodBeat.i(368884);
    this.iXu = F("MaterialCount", paramString, true);
    AppMethodBeat.o(368884);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kp
 * JD-Core Version:    0.7.0.1
 */