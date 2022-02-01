package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eh
  extends a
{
  public String dEE;
  public long dUA = 0L;
  public long dUB = 0L;
  public String dUC;
  public String dUD;
  public String dUx;
  public long dUy = 0L;
  public long dUz = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(110276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dEE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUD);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(110276);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(110277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.dEE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.dUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.dUy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("deleteCount:").append(this.dUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("addCount:").append(this.dUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditScene:").append(this.dUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.dUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Punctuation:").append(this.dUD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110277);
    return localObject;
  }
  
  public final int getId()
  {
    return 18246;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eh
 * JD-Core Version:    0.7.0.1
 */