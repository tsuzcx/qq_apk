package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fo
  extends a
{
  public long gBe = 0L;
  private String gBf = "";
  private String gBg = "";
  public long gef = 0L;
  public long gnP = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(120834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBg);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(120834);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(120835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileID:").append(this.gBf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AesKey:").append(this.gBg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(120835);
    return localObject;
  }
  
  public final int getId()
  {
    return 17055;
  }
  
  public final fo uU(String paramString)
  {
    AppMethodBeat.i(211972);
    this.gBf = z("FileID", paramString, true);
    AppMethodBeat.o(211972);
    return this;
  }
  
  public final fo uV(String paramString)
  {
    AppMethodBeat.i(211973);
    this.gBg = z("AesKey", paramString, true);
    AppMethodBeat.o(211973);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fo
 * JD-Core Version:    0.7.0.1
 */