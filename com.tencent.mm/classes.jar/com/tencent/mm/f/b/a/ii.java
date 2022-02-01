package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ii
  extends a
{
  private int gCF;
  private String gHZ;
  private int gIA;
  private int gIB;
  private String gIa;
  private String gIb;
  private String gIc;
  private String gId;
  private String gIf;
  private String gIh;
  private String gIm;
  private long gIn;
  private long gIo;
  private String gIp;
  private String gIq;
  private String gIr;
  private String gIs;
  private long gIt;
  private long gIu;
  private long gIv;
  private long gIw;
  private long gIx;
  private long gIy;
  private String gIz;
  private long giq;
  private String git;
  private String gjj;
  private String gmO;
  private long gnP;
  private String gpX;
  private long gzP;
  
  public ii()
  {
    this.gjj = "";
    this.gIm = "";
    this.gHZ = "";
    this.gIa = "";
    this.gIb = "";
    this.gIc = "";
    this.gId = "";
    this.gIh = "";
    this.gIf = "";
    this.gpX = "";
    this.gIp = "";
    this.gmO = "";
    this.gIq = "";
    this.gIr = "";
    this.gIs = "";
    this.git = "";
    this.gIz = "";
  }
  
  public ii(String paramString)
  {
    AppMethodBeat.i(231855);
    this.gjj = "";
    this.gIm = "";
    this.gHZ = "";
    this.gIa = "";
    this.gIb = "";
    this.gIc = "";
    this.gId = "";
    this.gIh = "";
    this.gIf = "";
    this.gpX = "";
    this.gIp = "";
    this.gmO = "";
    this.gIq = "";
    this.gIr = "";
    this.gIs = "";
    this.git = "";
    this.gIz = "";
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
      yh(paramString[0]);
      yi(paramString[1]);
      yj(paramString[2]);
      yk(paramString[3]);
      yl(paramString[4]);
      ym(paramString[5]);
      yn(paramString[6]);
      this.giq = Util.getLong(paramString[7], 0L);
      this.gIn = Util.getLong(paramString[8], 0L);
      yo(paramString[9]);
      yp(paramString[10]);
      yq(paramString[11]);
      this.gIo = Util.getLong(paramString[12], 0L);
      yr(paramString[13]);
      ys(paramString[14]);
      yt(paramString[15]);
      yu(paramString[16]);
      yv(paramString[17]);
      this.gzP = Util.getLong(paramString[18], 0L);
      this.gIt = Util.getLong(paramString[19], 0L);
      this.gIu = Util.getLong(paramString[20], 0L);
      this.gIv = Util.getLong(paramString[21], 0L);
      this.gIw = Util.getLong(paramString[22], 0L);
      this.gIx = Util.getLong(paramString[23], 0L);
      this.gnP = Util.getLong(paramString[24], 0L);
      yw(paramString[25]);
      this.gIy = Util.getLong(paramString[26], 0L);
      yx(paramString[27]);
      this.gIA = Util.getInt(paramString[28], 0);
      this.gIB = Util.getInt(paramString[29], 0);
      this.gCF = Util.getInt(paramString[30], 0);
      AppMethodBeat.o(231855);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(231878);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.git);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gIB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(231878);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(231881);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateContextId:").append(this.gIm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.gHZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.gIa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.gIb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.gIc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.gId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSave:").append(this.gIn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvUserId:").append(this.gIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvObjectId:").append(this.gIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.gpX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFinderNew:").append(this.gIo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartList:").append(this.gIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUin:").append(this.gIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("KeyWord:").append(this.gIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpId:").append(this.gIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.gzP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartNum:").append(this.gIt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PartId:").append(this.gIu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFrom:").append(this.gIv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEdit:").append(this.gIw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNull:").append(this.gIx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.git);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateType:").append(this.gIy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaterialCount:").append(this.gIz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Transition:").append(this.gIA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HideMediaCount:").append(this.gIB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageType:").append(this.gCF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231881);
    return localObject;
  }
  
  public final ii alR()
  {
    this.gIB = 0;
    return this;
  }
  
  public final ii alS()
  {
    this.gCF = 1;
    return this;
  }
  
  public final int getId()
  {
    return 22259;
  }
  
  public final ii nh(int paramInt)
  {
    this.gIA = paramInt;
    return this;
  }
  
  public final ii sP(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final ii sQ(long paramLong)
  {
    this.gIn = paramLong;
    return this;
  }
  
  public final ii sR(long paramLong)
  {
    this.gIo = paramLong;
    return this;
  }
  
  public final ii sS(long paramLong)
  {
    this.gzP = paramLong;
    return this;
  }
  
  public final ii sT(long paramLong)
  {
    this.gIt = paramLong;
    return this;
  }
  
  public final ii sU(long paramLong)
  {
    this.gIu = paramLong;
    return this;
  }
  
  public final ii sV(long paramLong)
  {
    this.gIv = paramLong;
    return this;
  }
  
  public final ii sW(long paramLong)
  {
    this.gIw = paramLong;
    return this;
  }
  
  public final ii sX(long paramLong)
  {
    this.gIx = paramLong;
    return this;
  }
  
  public final ii sY(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final ii sZ(long paramLong)
  {
    this.gIy = paramLong;
    return this;
  }
  
  public final ii yh(String paramString)
  {
    AppMethodBeat.i(231856);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(231856);
    return this;
  }
  
  public final ii yi(String paramString)
  {
    AppMethodBeat.i(231858);
    this.gIm = z("CreateContextId", paramString, true);
    AppMethodBeat.o(231858);
    return this;
  }
  
  public final ii yj(String paramString)
  {
    AppMethodBeat.i(231859);
    this.gHZ = z("SongName", paramString, true);
    AppMethodBeat.o(231859);
    return this;
  }
  
  public final ii yk(String paramString)
  {
    AppMethodBeat.i(231860);
    this.gIa = z("SongId", paramString, true);
    AppMethodBeat.o(231860);
    return this;
  }
  
  public final ii yl(String paramString)
  {
    AppMethodBeat.i(231861);
    this.gIb = z("WebUrl", paramString, true);
    AppMethodBeat.o(231861);
    return this;
  }
  
  public final ii ym(String paramString)
  {
    AppMethodBeat.i(231863);
    this.gIc = z("DataUrl", paramString, true);
    AppMethodBeat.o(231863);
    return this;
  }
  
  public final ii yn(String paramString)
  {
    AppMethodBeat.i(231864);
    this.gId = z("Singer", paramString, true);
    AppMethodBeat.o(231864);
    return this;
  }
  
  public final ii yo(String paramString)
  {
    AppMethodBeat.i(231865);
    this.gIh = z("MvUserId", paramString, true);
    AppMethodBeat.o(231865);
    return this;
  }
  
  public final ii yp(String paramString)
  {
    AppMethodBeat.i(231866);
    this.gIf = z("MvObjectId", paramString, true);
    AppMethodBeat.o(231866);
    return this;
  }
  
  public final ii yq(String paramString)
  {
    AppMethodBeat.i(231867);
    this.gpX = z("FinderSessionId", paramString, true);
    AppMethodBeat.o(231867);
    return this;
  }
  
  public final ii yr(String paramString)
  {
    AppMethodBeat.i(231868);
    this.gIp = z("PartList", paramString, true);
    AppMethodBeat.o(231868);
    return this;
  }
  
  public final ii ys(String paramString)
  {
    AppMethodBeat.i(231869);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(231869);
    return this;
  }
  
  public final ii yt(String paramString)
  {
    AppMethodBeat.i(231870);
    this.gIq = z("FinderUin", paramString, true);
    AppMethodBeat.o(231870);
    return this;
  }
  
  public final ii yu(String paramString)
  {
    AppMethodBeat.i(231871);
    this.gIr = z("KeyWord", paramString, true);
    AppMethodBeat.o(231871);
    return this;
  }
  
  public final ii yv(String paramString)
  {
    AppMethodBeat.i(231872);
    this.gIs = z("ExpId", paramString, true);
    AppMethodBeat.o(231872);
    return this;
  }
  
  public final ii yw(String paramString)
  {
    AppMethodBeat.i(231875);
    this.git = z("RequestId", paramString, true);
    AppMethodBeat.o(231875);
    return this;
  }
  
  public final ii yx(String paramString)
  {
    AppMethodBeat.i(231876);
    this.gIz = z("MaterialCount", paramString, true);
    AppMethodBeat.o(231876);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ii
 * JD-Core Version:    0.7.0.1
 */