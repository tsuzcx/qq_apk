package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ck
  extends a
{
  private String elt = "";
  private String evU = "";
  private String evV = "";
  private String evW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209020);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evW);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209020);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209021);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportExtraInfo:").append(this.evU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceFeedid:").append(this.evV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceUsername:").append(this.evW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209021);
    return localObject;
  }
  
  public final int getId()
  {
    return 21140;
  }
  
  public final ck mb(String paramString)
  {
    AppMethodBeat.i(209016);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(209016);
    return this;
  }
  
  public final ck mc(String paramString)
  {
    AppMethodBeat.i(209017);
    this.evU = x("ReportExtraInfo", paramString, true);
    AppMethodBeat.o(209017);
    return this;
  }
  
  public final ck md(String paramString)
  {
    AppMethodBeat.i(209018);
    this.evV = x("EnterSourceFeedid", paramString, true);
    AppMethodBeat.o(209018);
    return this;
  }
  
  public final ck me(String paramString)
  {
    AppMethodBeat.i(209019);
    this.evW = x("EnterSourceUsername", paramString, true);
    AppMethodBeat.o(209019);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ck
 * JD-Core Version:    0.7.0.1
 */