package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pc
  extends a
{
  public long ikr = 0L;
  public long iuE = 0L;
  public long jjn = 0L;
  public String jlh = "";
  private String jli = "";
  public String jlj = "";
  public String jlk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(118519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jli);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(118519);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(118520);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.iuE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.jjn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.jlh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.jli);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.ikr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.jlj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.jlk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118520);
    return localObject;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final pc wG(String paramString)
  {
    AppMethodBeat.i(118516);
    this.jlh = F("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(118516);
    return this;
  }
  
  public final pc wH(String paramString)
  {
    AppMethodBeat.i(118517);
    this.jlj = F("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(118517);
    return this;
  }
  
  public final pc wI(String paramString)
  {
    AppMethodBeat.i(118518);
    this.jlk = F("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(118518);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pc
 * JD-Core Version:    0.7.0.1
 */