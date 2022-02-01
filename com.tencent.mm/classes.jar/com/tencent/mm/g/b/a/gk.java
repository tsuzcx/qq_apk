package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gk
  extends a
{
  private String eJA = "";
  private long eJB;
  private String eJC = "";
  private long eJD;
  private long eJE;
  private long eJF;
  private long eJG;
  private long eJH;
  private long eJI;
  private long eJJ;
  private String eJK = "";
  private String eJu = "";
  private String eJv = "";
  private String eJw = "";
  private String eJx = "";
  private String eJy = "";
  private String eJz = "";
  private long enl;
  private String eoz = "";
  private long erW;
  
  public final gk PP(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final gk PQ(long paramLong)
  {
    this.eJD = paramLong;
    return this;
  }
  
  public final gk PR(long paramLong)
  {
    this.eJE = paramLong;
    return this;
  }
  
  public final gk PS(long paramLong)
  {
    this.eJF = paramLong;
    return this;
  }
  
  public final gk PT(long paramLong)
  {
    this.eJG = paramLong;
    return this;
  }
  
  public final gk PU(long paramLong)
  {
    this.eJH = paramLong;
    return this;
  }
  
  public final gk PV(long paramLong)
  {
    this.eJI = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(256701);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(256701);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(256702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.eJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.eJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.eJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromSourceId:").append(this.eJy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvObjectId:").append(this.eJz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvNonceId:").append(this.eJA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLyric:").append(this.eJB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.eJC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PCU:").append(this.eJD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FCU:").append(this.eJE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MCU:").append(this.eJF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCreate:").append(this.eJG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayDuration:").append(this.eJH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCommentArea:").append(this.eJI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpoCommentNum:").append(this.eJJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.eJK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(256702);
    return localObject;
  }
  
  public final gk bvL(String paramString)
  {
    AppMethodBeat.i(258784);
    this.eJK = x("Singer", paramString, true);
    AppMethodBeat.o(258784);
    return this;
  }
  
  public final int getId()
  {
    return 22223;
  }
  
  public final gk qn(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final gk qo(long paramLong)
  {
    this.eJB = paramLong;
    return this;
  }
  
  public final gk tW(String paramString)
  {
    AppMethodBeat.i(256692);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(256692);
    return this;
  }
  
  public final gk tX(String paramString)
  {
    AppMethodBeat.i(256693);
    this.eJu = x("SongName", paramString, true);
    AppMethodBeat.o(256693);
    return this;
  }
  
  public final gk tY(String paramString)
  {
    AppMethodBeat.i(256694);
    this.eJv = x("WebUrl", paramString, true);
    AppMethodBeat.o(256694);
    return this;
  }
  
  public final gk tZ(String paramString)
  {
    AppMethodBeat.i(256695);
    this.eJw = x("DataUrl", paramString, true);
    AppMethodBeat.o(256695);
    return this;
  }
  
  public final gk ua(String paramString)
  {
    AppMethodBeat.i(256696);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(256696);
    return this;
  }
  
  public final gk ub(String paramString)
  {
    AppMethodBeat.i(256697);
    this.eJy = x("FromSourceId", paramString, true);
    AppMethodBeat.o(256697);
    return this;
  }
  
  public final gk uc(String paramString)
  {
    AppMethodBeat.i(256698);
    this.eJz = x("MvObjectId", paramString, true);
    AppMethodBeat.o(256698);
    return this;
  }
  
  public final gk ud(String paramString)
  {
    AppMethodBeat.i(256699);
    this.eJA = x("MvNonceId", paramString, true);
    AppMethodBeat.o(256699);
    return this;
  }
  
  public final gk ue(String paramString)
  {
    AppMethodBeat.i(256700);
    this.eJC = x("SongId", paramString, true);
    AppMethodBeat.o(256700);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gk
 * JD-Core Version:    0.7.0.1
 */