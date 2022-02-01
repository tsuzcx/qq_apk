package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kh
  extends a
{
  public long gMN;
  public int gMO;
  public int gMP;
  public int gMQ;
  
  public final String agH()
  {
    AppMethodBeat.i(19866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gMN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(19866);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(19867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("msgId:").append(this.gMN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectLen:").append(this.gMO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.gMP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipLen:").append(this.gMQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19867);
    return localObject;
  }
  
  public final int getId()
  {
    return 18617;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kh
 * JD-Core Version:    0.7.0.1
 */