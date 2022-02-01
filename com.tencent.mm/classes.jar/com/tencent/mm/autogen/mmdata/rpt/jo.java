package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jo
  extends a
{
  public int iUl = 0;
  public int iUm = 0;
  public int iUn = 0;
  public int iUo;
  public int iUp = -1;
  public int iUq = 0;
  public int iUr = 0;
  private String iUs = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iUl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUs);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368497);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ApkCompatVersion:").append(this.iUl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResCompatVersion:").append(this.iUm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.iUn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Event:").append(this.iUo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResSubType:").append(this.iUp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadFailCount:").append(this.iUq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResVersion:").append(this.iUr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sha1:").append(this.iUs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368504);
    return localObject;
  }
  
  public final int getId()
  {
    return 25056;
  }
  
  public final jo sn(String paramString)
  {
    AppMethodBeat.i(368489);
    this.iUs = F("Sha1", paramString, true);
    AppMethodBeat.o(368489);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jo
 * JD-Core Version:    0.7.0.1
 */