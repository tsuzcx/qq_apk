package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class od
  extends a
{
  private String eJC = "";
  private String eJK = "";
  private String eJu = "";
  private String eJv = "";
  private String eJw = "";
  private String eJx = "";
  private String eJy = "";
  private long enl;
  private String eoz = "";
  private long erW;
  
  public final od PA(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final od Pz(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final od TA(String paramString)
  {
    AppMethodBeat.i(258745);
    this.eJC = x("SongId", paramString, true);
    AppMethodBeat.o(258745);
    return this;
  }
  
  public final od Tz(String paramString)
  {
    AppMethodBeat.i(258744);
    this.eJu = x("SongName", paramString, true);
    AppMethodBeat.o(258744);
    return this;
  }
  
  public final od VN(String paramString)
  {
    AppMethodBeat.i(258746);
    this.eJv = x("WebUrl", paramString, true);
    AppMethodBeat.o(258746);
    return this;
  }
  
  public final od VO(String paramString)
  {
    AppMethodBeat.i(258747);
    this.eJw = x("DataUrl", paramString, true);
    AppMethodBeat.o(258747);
    return this;
  }
  
  public final od VP(String paramString)
  {
    AppMethodBeat.i(258748);
    this.eJK = x("Singer", paramString, true);
    AppMethodBeat.o(258748);
    return this;
  }
  
  public final od VS(String paramString)
  {
    AppMethodBeat.i(258749);
    this.eJy = x("FromSourceId", paramString, true);
    AppMethodBeat.o(258749);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258751);
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
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258751);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258752);
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
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromSourceId:").append(this.eJy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258752);
    return localObject;
  }
  
  public final od agP(String paramString)
  {
    AppMethodBeat.i(258750);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(258750);
    return this;
  }
  
  public final od fL(String paramString)
  {
    AppMethodBeat.i(258743);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(258743);
    return this;
  }
  
  public final int getId()
  {
    return 22243;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.od
 * JD-Core Version:    0.7.0.1
 */