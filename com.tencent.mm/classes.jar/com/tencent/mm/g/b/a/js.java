package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class js
  extends a
{
  public long eRo = 0L;
  private String eSl = "";
  public long eSm = 0L;
  private String eSn = "";
  public long eSo = 0L;
  private String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(94854);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eSl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRo);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94854);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.eSl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.eSm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.eSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.eSo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.eRo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94855);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
  
  public final js wZ(String paramString)
  {
    AppMethodBeat.i(94851);
    this.eSl = x("EnterObjectId", paramString, true);
    AppMethodBeat.o(94851);
    return this;
  }
  
  public final js xa(String paramString)
  {
    AppMethodBeat.i(94852);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(94852);
    return this;
  }
  
  public final js xb(String paramString)
  {
    AppMethodBeat.i(94853);
    this.eSn = x("ExposeUinList", paramString, true);
    AppMethodBeat.o(94853);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.js
 * JD-Core Version:    0.7.0.1
 */