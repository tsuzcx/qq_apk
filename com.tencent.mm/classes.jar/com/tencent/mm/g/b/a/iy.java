package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iy
  extends a
{
  private String eQe = "";
  public long eQf = 0L;
  private String eQj = "";
  public long ekE = 0L;
  private String emL = "";
  
  public final String abV()
  {
    AppMethodBeat.i(110289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(110289);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(110290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.emL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchUserName:").append(this.eQe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.ekE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Identifier:").append(this.eQj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(110290);
    return localObject;
  }
  
  public final int getId()
  {
    return 18252;
  }
  
  public final iy wx(String paramString)
  {
    AppMethodBeat.i(110286);
    this.emL = x("ChatName", paramString, true);
    AppMethodBeat.o(110286);
    return this;
  }
  
  public final iy wy(String paramString)
  {
    AppMethodBeat.i(110287);
    this.eQe = x("LaunchUserName", paramString, true);
    AppMethodBeat.o(110287);
    return this;
  }
  
  public final iy wz(String paramString)
  {
    AppMethodBeat.i(110288);
    this.eQj = x("Identifier", paramString, true);
    AppMethodBeat.o(110288);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iy
 * JD-Core Version:    0.7.0.1
 */