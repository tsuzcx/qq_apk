package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class op
  extends a
{
  private String gfm = "";
  public long hcg = 0L;
  public long hci = 0L;
  public long hcj = 0L;
  public long hck = 0L;
  
  public final op FF(String paramString)
  {
    AppMethodBeat.i(43480);
    this.gfm = z("Appid", paramString, true);
    AppMethodBeat.o(43480);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hci);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hck);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hcg);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43481);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DeleteReason:").append(this.hci);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.gfm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DebugType:").append(this.hcj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteCount:").append(this.hck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AbtestStatus:").append(this.hcg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43482);
    return localObject;
  }
  
  public final int getId()
  {
    return 15402;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.op
 * JD-Core Version:    0.7.0.1
 */