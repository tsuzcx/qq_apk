package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bf
  extends a
{
  private String eoj = "";
  private long erW;
  private long erY;
  private long erZ;
  
  public final String abV()
  {
    AppMethodBeat.i(208860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erZ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208860);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208861);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Followcount:").append(this.erZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208861);
    return localObject;
  }
  
  public final bf acz()
  {
    this.erY = 0L;
    return this;
  }
  
  public final bf du(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final bf dv(long paramLong)
  {
    this.erZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21345;
  }
  
  public final bf jf(String paramString)
  {
    AppMethodBeat.i(208859);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(208859);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bf
 * JD-Core Version:    0.7.0.1
 */