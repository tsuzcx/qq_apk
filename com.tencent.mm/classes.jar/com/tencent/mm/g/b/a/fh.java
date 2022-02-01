package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fh
  extends a
{
  private String eFc = "";
  private long eFd;
  private long eFf;
  private String eFx = "";
  private String eFy = "";
  private long erw;
  private String evz = "";
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207424);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFy);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207424);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207425);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.evz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.eFx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.eFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eFy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207425);
    return localObject;
  }
  
  public final fh afZ()
  {
    this.erw = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19896;
  }
  
  public final fh nD(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final fh nE(long paramLong)
  {
    this.eFd = paramLong;
    return this;
  }
  
  public final fh nF(long paramLong)
  {
    this.eFf = paramLong;
    return this;
  }
  
  public final fh sg(String paramString)
  {
    AppMethodBeat.i(207421);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207421);
    return this;
  }
  
  public final fh sh(String paramString)
  {
    AppMethodBeat.i(207422);
    this.evz = x("topic", paramString, true);
    AppMethodBeat.o(207422);
    return this;
  }
  
  public final fh si(String paramString)
  {
    AppMethodBeat.i(207423);
    this.eFy = x("liveusername", paramString, true);
    AppMethodBeat.o(207423);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fh
 * JD-Core Version:    0.7.0.1
 */