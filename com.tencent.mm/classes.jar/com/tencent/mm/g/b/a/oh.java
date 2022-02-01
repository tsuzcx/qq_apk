package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oh
  extends a
{
  private long eJB;
  private String eJC = "";
  private String eJK = "";
  private String eJu = "";
  private String eJv = "";
  private String eJw = "";
  private String eJx = "";
  private long enl;
  private String eoz = "";
  private String opT = "";
  private String opV = "";
  private String opW = "";
  
  public final oh Qg(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final oh Qh(long paramLong)
  {
    this.eJB = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258807);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoz);
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
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.opT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.opV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.opW);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258807);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
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
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLyric:").append(this.eJB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sect:").append(this.opT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CoverURL:").append(this.opV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Language:").append(this.opW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258808);
    return localObject;
  }
  
  public final oh bvX(String paramString)
  {
    AppMethodBeat.i(258798);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(258798);
    return this;
  }
  
  public final oh bvY(String paramString)
  {
    AppMethodBeat.i(258799);
    this.eJu = x("SongName", paramString, true);
    AppMethodBeat.o(258799);
    return this;
  }
  
  public final oh bvZ(String paramString)
  {
    AppMethodBeat.i(258800);
    this.eJC = x("SongId", paramString, true);
    AppMethodBeat.o(258800);
    return this;
  }
  
  public final oh bwa(String paramString)
  {
    AppMethodBeat.i(258801);
    this.eJv = x("WebUrl", paramString, true);
    AppMethodBeat.o(258801);
    return this;
  }
  
  public final oh bwb(String paramString)
  {
    AppMethodBeat.i(258802);
    this.eJw = x("DataUrl", paramString, true);
    AppMethodBeat.o(258802);
    return this;
  }
  
  public final oh bwc(String paramString)
  {
    AppMethodBeat.i(258803);
    this.eJK = x("Singer", paramString, true);
    AppMethodBeat.o(258803);
    return this;
  }
  
  public final oh bwd(String paramString)
  {
    AppMethodBeat.i(258804);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(258804);
    return this;
  }
  
  public final oh bwe(String paramString)
  {
    AppMethodBeat.i(258805);
    this.opT = x("Sect", paramString, true);
    AppMethodBeat.o(258805);
    return this;
  }
  
  public final oh bwf(String paramString)
  {
    AppMethodBeat.i(258806);
    this.opV = x("CoverURL", paramString, true);
    AppMethodBeat.o(258806);
    return this;
  }
  
  public final int getId()
  {
    return 22234;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.oh
 * JD-Core Version:    0.7.0.1
 */