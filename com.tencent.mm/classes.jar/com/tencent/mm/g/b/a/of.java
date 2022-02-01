package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class of
  extends a
{
  private long eDd;
  private String eJC;
  private String eJK;
  private String eJu;
  private String eJv;
  private String eJw;
  private String eJz;
  private String ePe;
  private long enl;
  private String eno;
  private String eoz;
  private long erW;
  private String err;
  private String etQ;
  private String huc;
  private String kRT;
  private long kRU;
  private long kRV;
  private String kSc;
  private String kSd;
  private String kSe;
  private long olg;
  private long olh;
  private long oli;
  private long olj;
  private long olk;
  
  public of()
  {
    this.eoz = "";
    this.kRT = "";
    this.eJu = "";
    this.eJC = "";
    this.eJv = "";
    this.eJw = "";
    this.eJK = "";
    this.huc = "";
    this.eJz = "";
    this.etQ = "";
    this.kSc = "";
    this.err = "";
    this.kSd = "";
    this.kSe = "";
    this.ePe = "";
    this.eno = "";
  }
  
  public of(String paramString)
  {
    AppMethodBeat.i(258765);
    this.eoz = "";
    this.kRT = "";
    this.eJu = "";
    this.eJC = "";
    this.eJv = "";
    this.eJw = "";
    this.eJK = "";
    this.huc = "";
    this.eJz = "";
    this.etQ = "";
    this.kSc = "";
    this.err = "";
    this.kSd = "";
    this.kSe = "";
    this.ePe = "";
    this.eno = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 26) {
          break label417;
        }
        String[] arrayOfString = new String[26];
        Arrays.fill(arrayOfString, 0, 26, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label417:
    for (;;)
    {
      bla(paramString[0]);
      ble(paramString[1]);
      bnJ(paramString[2]);
      bvy(paramString[3]);
      bvz(paramString[4]);
      bvA(paramString[5]);
      bvB(paramString[6]);
      this.enl = Util.getLong(paramString[7], 0L);
      this.kRU = Util.getLong(paramString[8], 0L);
      bvC(paramString[9]);
      bvD(paramString[10]);
      bvE(paramString[11]);
      this.kRV = Util.getLong(paramString[12], 0L);
      bvF(paramString[13]);
      bvG(paramString[14]);
      bvH(paramString[15]);
      bvI(paramString[16]);
      bvJ(paramString[17]);
      this.eDd = Util.getLong(paramString[18], 0L);
      this.olg = Util.getLong(paramString[19], 0L);
      this.olh = Util.getLong(paramString[20], 0L);
      this.oli = Util.getLong(paramString[21], 0L);
      this.olj = Util.getLong(paramString[22], 0L);
      this.olk = Util.getLong(paramString[23], 0L);
      this.erW = Util.getLong(paramString[24], 0L);
      bvK(paramString[25]);
      AppMethodBeat.o(258765);
      return;
    }
  }
  
  public final of PF(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final of PG(long paramLong)
  {
    this.kRU = paramLong;
    return this;
  }
  
  public final of PH(long paramLong)
  {
    this.kRV = paramLong;
    return this;
  }
  
  public final of PI(long paramLong)
  {
    this.eDd = paramLong;
    return this;
  }
  
  public final of PJ(long paramLong)
  {
    this.olg = paramLong;
    return this;
  }
  
  public final of PK(long paramLong)
  {
    this.olh = paramLong;
    return this;
  }
  
  public final of PL(long paramLong)
  {
    this.oli = paramLong;
    return this;
  }
  
  public final of PM(long paramLong)
  {
    this.olj = paramLong;
    return this;
  }
  
  public final of PN(long paramLong)
  {
    this.olk = paramLong;
    return this;
  }
  
  public final of PO(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258782);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kRT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kRU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.huc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kRV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kSc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ePe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.olg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.olh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oli);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.olj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.olk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eno);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258782);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateContextId:").append(this.kRT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.eJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.eJC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.eJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.eJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.eJK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSave:").append(this.kRU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvUserId:").append(this.huc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvObjectId:").append(this.eJz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.etQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFinderNew:").append(this.kRV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartList:").append(this.kSc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUin:").append(this.kSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyWord:").append(this.kSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.ePe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.eDd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartNum:").append(this.olg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartId:").append(this.olh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFrom:").append(this.oli);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEdit:").append(this.olj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNull:").append(this.olk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.eno);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258783);
    return localObject;
  }
  
  public final of bla(String paramString)
  {
    AppMethodBeat.i(258766);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(258766);
    return this;
  }
  
  public final of ble(String paramString)
  {
    AppMethodBeat.i(258767);
    this.kRT = x("CreateContextId", paramString, true);
    AppMethodBeat.o(258767);
    return this;
  }
  
  public final of bnJ(String paramString)
  {
    AppMethodBeat.i(258768);
    this.eJu = x("SongName", paramString, true);
    AppMethodBeat.o(258768);
    return this;
  }
  
  public final of bvA(String paramString)
  {
    AppMethodBeat.i(258771);
    this.eJw = x("DataUrl", paramString, true);
    AppMethodBeat.o(258771);
    return this;
  }
  
  public final of bvB(String paramString)
  {
    AppMethodBeat.i(258772);
    this.eJK = x("Singer", paramString, true);
    AppMethodBeat.o(258772);
    return this;
  }
  
  public final of bvC(String paramString)
  {
    AppMethodBeat.i(258773);
    this.huc = x("MvUserId", paramString, true);
    AppMethodBeat.o(258773);
    return this;
  }
  
  public final of bvD(String paramString)
  {
    AppMethodBeat.i(258774);
    this.eJz = x("MvObjectId", paramString, true);
    AppMethodBeat.o(258774);
    return this;
  }
  
  public final of bvE(String paramString)
  {
    AppMethodBeat.i(258775);
    this.etQ = x("FinderSessionId", paramString, true);
    AppMethodBeat.o(258775);
    return this;
  }
  
  public final of bvF(String paramString)
  {
    AppMethodBeat.i(258776);
    this.kSc = x("PartList", paramString, true);
    AppMethodBeat.o(258776);
    return this;
  }
  
  public final of bvG(String paramString)
  {
    AppMethodBeat.i(258777);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(258777);
    return this;
  }
  
  public final of bvH(String paramString)
  {
    AppMethodBeat.i(258778);
    this.kSd = x("FinderUin", paramString, true);
    AppMethodBeat.o(258778);
    return this;
  }
  
  public final of bvI(String paramString)
  {
    AppMethodBeat.i(258779);
    this.kSe = x("KeyWord", paramString, true);
    AppMethodBeat.o(258779);
    return this;
  }
  
  public final of bvJ(String paramString)
  {
    AppMethodBeat.i(258780);
    this.ePe = x("ExpId", paramString, true);
    AppMethodBeat.o(258780);
    return this;
  }
  
  public final of bvK(String paramString)
  {
    AppMethodBeat.i(258781);
    this.eno = x("RequestId", paramString, true);
    AppMethodBeat.o(258781);
    return this;
  }
  
  public final of bvy(String paramString)
  {
    AppMethodBeat.i(258769);
    this.eJC = x("SongId", paramString, true);
    AppMethodBeat.o(258769);
    return this;
  }
  
  public final of bvz(String paramString)
  {
    AppMethodBeat.i(258770);
    this.eJv = x("WebUrl", paramString, true);
    AppMethodBeat.o(258770);
    return this;
  }
  
  public final int getId()
  {
    return 22259;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.of
 * JD-Core Version:    0.7.0.1
 */