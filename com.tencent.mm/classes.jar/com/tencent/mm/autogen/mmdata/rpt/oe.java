package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oe
  extends a
{
  public String imN = "";
  public String jiW = "";
  public long jiX = 0L;
  public long jiY = 0L;
  public long jiZ = 0L;
  public long jja = 0L;
  public String jjb = "";
  public String jjc = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(110276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(110276);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(110277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.jiW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.jiX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("deleteCount:").append(this.jiY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.jiZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditScene:").append(this.jja);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.jjb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Punctuation:").append(this.jjc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110277);
    return localObject;
  }
  
  public final int getId()
  {
    return 18246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.oe
 * JD-Core Version:    0.7.0.1
 */