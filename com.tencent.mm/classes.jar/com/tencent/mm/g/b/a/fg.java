package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fg
  extends a
{
  public String dRB;
  public String ekP;
  public long ekQ = 0L;
  public long ekR = 0L;
  public long ekS = 0L;
  public long ekT = 0L;
  public String ekU;
  public String ekV;
  
  public final String RD()
  {
    AppMethodBeat.i(110276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekV);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(110276);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(110277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.ekP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.ekQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("deleteCount:").append(this.ekR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.ekS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditScene:").append(this.ekT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.ekU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Punctuation:").append(this.ekV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110277);
    return localObject;
  }
  
  public final int getId()
  {
    return 18246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fg
 * JD-Core Version:    0.7.0.1
 */