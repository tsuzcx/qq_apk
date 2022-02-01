package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fi
  extends a
{
  public String dSR = "";
  public long emA = 0L;
  public String emB = "";
  public String emC = "";
  public String emw = "";
  public long emx = 0L;
  public long emy = 0L;
  public long emz = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(110276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emC);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(110276);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(110277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.emw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.emx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("deleteCount:").append(this.emy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.emz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditScene:").append(this.emA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.emB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Punctuation:").append(this.emC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110277);
    return localObject;
  }
  
  public final int getId()
  {
    return 18246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fi
 * JD-Core Version:    0.7.0.1
 */