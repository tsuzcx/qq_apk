package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ek
  extends a
{
  private String eiB = "";
  private String eoz = "";
  private String erB = "";
  private long erz;
  private long etH;
  
  public final String abV()
  {
    AppMethodBeat.i(184190);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184190);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184191);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.erB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.etH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.erz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184191);
    return localObject;
  }
  
  public final int getId()
  {
    return 19433;
  }
  
  public final ek lY(long paramLong)
  {
    this.etH = paramLong;
    return this;
  }
  
  public final ek lZ(long paramLong)
  {
    this.erz = paramLong;
    return this;
  }
  
  public final ek rb(String paramString)
  {
    AppMethodBeat.i(184188);
    this.erB = x("Action", paramString, true);
    AppMethodBeat.o(184188);
    return this;
  }
  
  public final ek rc(String paramString)
  {
    AppMethodBeat.i(184189);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(184189);
    return this;
  }
  
  public final ek rd(String paramString)
  {
    AppMethodBeat.i(209228);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209228);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ek
 * JD-Core Version:    0.7.0.1
 */