package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class i
  extends a
{
  public long ejW = 0L;
  public int ejX = 0;
  public long ejY = 0L;
  private int ejZ = 0;
  private String eka = "";
  private String ekb = "";
  
  public final String abV()
  {
    AppMethodBeat.i(91239);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eka);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekb);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(91239);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(91240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_result:").append(this.ejX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_code:").append(this.ejY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session:").append(this.ejZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_ext:").append(this.eka);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session2:").append(this.ekb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(91240);
    return localObject;
  }
  
  public final int getId()
  {
    return 15894;
  }
  
  public final i hM(String paramString)
  {
    AppMethodBeat.i(91238);
    this.ekb = x("session2", paramString, true);
    AppMethodBeat.o(91238);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.i
 * JD-Core Version:    0.7.0.1
 */