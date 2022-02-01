package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class np
  extends a
{
  public long fid = 0L;
  public long fie = 0L;
  public long fif = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(121783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fid);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fie);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fif);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(121783);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121784);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.fid);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.fie);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.fif);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121784);
    return localObject;
  }
  
  public final int getId()
  {
    return 16909;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.np
 * JD-Core Version:    0.7.0.1
 */