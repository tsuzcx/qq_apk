package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cg
  extends a
{
  private long erz;
  private long evl;
  private String evm = "";
  
  public final String abV()
  {
    AppMethodBeat.i(208996);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evm);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208996);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208997);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InnerVersion:").append(this.erz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("type:").append(this.evl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("data:").append(this.evm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208997);
    return localObject;
  }
  
  public final cg adb()
  {
    this.erz = 4L;
    return this;
  }
  
  public final cg fS(long paramLong)
  {
    this.evl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21680;
  }
  
  public final cg lH(String paramString)
  {
    AppMethodBeat.i(208995);
    this.evm = x("data", paramString, true);
    AppMethodBeat.o(208995);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cg
 * JD-Core Version:    0.7.0.1
 */