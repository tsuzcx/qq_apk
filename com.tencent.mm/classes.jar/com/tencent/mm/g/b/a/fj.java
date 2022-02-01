package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fj
  extends a
{
  private long eFC = 0L;
  private long eFD;
  private String eFc = "";
  private long eFd;
  private long erw;
  
  public final String abV()
  {
    AppMethodBeat.i(207432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207432);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207433);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reddot:").append(this.eFC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PanelPage:").append(this.eFD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207433);
    return localObject;
  }
  
  public final fj aga()
  {
    this.erw = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19887;
  }
  
  public final fj nM(long paramLong)
  {
    this.eFd = paramLong;
    return this;
  }
  
  public final fj nN(long paramLong)
  {
    this.eFD = paramLong;
    return this;
  }
  
  public final fj sm(String paramString)
  {
    AppMethodBeat.i(207431);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207431);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fj
 * JD-Core Version:    0.7.0.1
 */