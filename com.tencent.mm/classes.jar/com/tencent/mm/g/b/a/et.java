package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class et
  extends a
{
  private String eEs = "";
  public long eEt = 0L;
  public long eEu = 0L;
  public long erW;
  
  public final String abV()
  {
    AppMethodBeat.i(184627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEu);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184627);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.eEs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.eEt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.eEu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184628);
    return localObject;
  }
  
  public final int getId()
  {
    return 19353;
  }
  
  public final et rR(String paramString)
  {
    AppMethodBeat.i(184626);
    this.eEs = x("Roomid", paramString, true);
    AppMethodBeat.o(184626);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.et
 * JD-Core Version:    0.7.0.1
 */