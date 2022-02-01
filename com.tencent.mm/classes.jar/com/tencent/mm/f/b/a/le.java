package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class le
  extends a
{
  public String gQA = "";
  public long gQB = 0L;
  public long gQC = 0L;
  public long gQD = 0L;
  public long gQE = 0L;
  public String gQF = "";
  public String gQG = "";
  public String ggg = "";
  
  public final String agH()
  {
    AppMethodBeat.i(110276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gQG);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(110276);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(110277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.gQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("deleteCount:").append(this.gQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.gQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditScene:").append(this.gQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.gQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Punctuation:").append(this.gQG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110277);
    return localObject;
  }
  
  public final int getId()
  {
    return 18246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.le
 * JD-Core Version:    0.7.0.1
 */