package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nq
  extends a
{
  public long eLZ = 0L;
  public long fid = 0L;
  public long fie = 0L;
  public long fif = 0L;
  public long fig = 0L;
  private String fih = "";
  private String fii = "";
  
  public final nq AO(String paramString)
  {
    AppMethodBeat.i(121785);
    this.fih = x("ExptKey", paramString, true);
    AppMethodBeat.o(121785);
    return this;
  }
  
  public final nq AP(String paramString)
  {
    AppMethodBeat.i(121786);
    this.fii = x("ExptVal", paramString, false);
    AppMethodBeat.o(121786);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(121787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fid);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fie);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fig);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fih);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fii);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(121787);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121788);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptId:").append(this.fid);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupId:").append(this.fie);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptSeq:").append(this.fif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.eLZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampSec:").append(this.fig);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptKey:").append(this.fih);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptVal:").append(this.fii);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121788);
    return localObject;
  }
  
  public final int getId()
  {
    return 15452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nq
 * JD-Core Version:    0.7.0.1
 */