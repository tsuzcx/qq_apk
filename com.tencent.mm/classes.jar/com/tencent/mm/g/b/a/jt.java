package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jt
  extends a
{
  private long eQv = 0L;
  private String eSp = "";
  private String eSq = "";
  private long eSr = 0L;
  private String eSs = "";
  private String eSt = "";
  private long eqk = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(118519);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSt);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118519);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118520);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTime:").append(this.eqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.eQv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList:").append(this.eSp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayUinList:").append(this.eSq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.eSr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList1:").append(this.eSs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitPlayVideoList2:").append(this.eSt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118520);
    return localObject;
  }
  
  public final String ahQ()
  {
    return this.eSp;
  }
  
  public final String ahR()
  {
    return this.eSs;
  }
  
  public final String ahS()
  {
    return this.eSt;
  }
  
  public final int getId()
  {
    return 16842;
  }
  
  public final jt sP(long paramLong)
  {
    this.eqk = paramLong;
    return this;
  }
  
  public final jt sQ(long paramLong)
  {
    this.eQv = paramLong;
    return this;
  }
  
  public final jt sR(long paramLong)
  {
    this.eSr = paramLong;
    return this;
  }
  
  public final jt xc(String paramString)
  {
    AppMethodBeat.i(118516);
    this.eSp = x("WaitPlayVideoList", paramString, true);
    AppMethodBeat.o(118516);
    return this;
  }
  
  public final jt xd(String paramString)
  {
    AppMethodBeat.i(118517);
    this.eSs = x("WaitPlayVideoList1", paramString, true);
    AppMethodBeat.o(118517);
    return this;
  }
  
  public final jt xe(String paramString)
  {
    AppMethodBeat.i(118518);
    this.eSt = x("WaitPlayVideoList2", paramString, true);
    AppMethodBeat.o(118518);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jt
 * JD-Core Version:    0.7.0.1
 */