package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iv
  extends a
{
  public String eQe = "";
  public long eQf = 0L;
  public long eQg = 0L;
  public long eQh = 0L;
  public long eQi = 0L;
  public String eQj = "";
  public String eQk = "";
  public String emL = "";
  
  public final String abV()
  {
    AppMethodBeat.i(110276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQk);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(110276);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(110277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.eQe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("deleteCount:").append(this.eQg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.eQh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditScene:").append(this.eQi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.eQj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Punctuation:").append(this.eQk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110277);
    return localObject;
  }
  
  public final int getId()
  {
    return 18246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iv
 * JD-Core Version:    0.7.0.1
 */