package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nx
  extends a
{
  private String fhv = "";
  private String fiH = "";
  private String fiI = "";
  private int fiJ = -1;
  private long fiK = 0L;
  private String fiL = "";
  
  public final nx Ba(String paramString)
  {
    AppMethodBeat.i(220244);
    this.fiH = x("ViewId", paramString, true);
    AppMethodBeat.o(220244);
    return this;
  }
  
  public final nx Bb(String paramString)
  {
    AppMethodBeat.i(220245);
    this.fhv = x("PageId", paramString, true);
    AppMethodBeat.o(220245);
    return this;
  }
  
  public final nx Bc(String paramString)
  {
    AppMethodBeat.i(220246);
    this.fiI = x("LayoutId", paramString, true);
    AppMethodBeat.o(220246);
    return this;
  }
  
  public final nx Bd(String paramString)
  {
    AppMethodBeat.i(220247);
    this.fiL = x("resName", paramString, true);
    AppMethodBeat.o(220247);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(184287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fiH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fhv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiL);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184287);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ViewId:").append(this.fiH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.fhv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LayoutId:").append(this.fiI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpEvent:").append(this.fiJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeConsuming:").append(this.fiK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resName:").append(this.fiL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184288);
    return localObject;
  }
  
  public final int getId()
  {
    return 19316;
  }
  
  public final nx mY(int paramInt)
  {
    this.fiJ = paramInt;
    return this;
  }
  
  public final nx ys(long paramLong)
  {
    this.fiK = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nx
 * JD-Core Version:    0.7.0.1
 */