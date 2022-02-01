package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bz
  extends a
{
  private String eoD = "";
  private String erU = "";
  private long eua;
  private long euq = 0L;
  private long eur;
  private String eus = "";
  private long eut;
  private long euu;
  
  public final String abV()
  {
    AppMethodBeat.i(208945);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eur);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eua);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eus);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eut);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208945);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208946);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromTab:").append(this.euq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toTab:").append(this.eur);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.erU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickContextid:").append(this.eus);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasRedDot:").append(this.eut);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuallyTapped:").append(this.euu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.eoD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208946);
    return localObject;
  }
  
  public final String acW()
  {
    return this.eus;
  }
  
  public final bz acX()
  {
    this.eut = 1L;
    return this;
  }
  
  public final bz fi(long paramLong)
  {
    this.euq = paramLong;
    return this;
  }
  
  public final bz fj(long paramLong)
  {
    this.eur = paramLong;
    return this;
  }
  
  public final bz fk(long paramLong)
  {
    this.eua = paramLong;
    return this;
  }
  
  public final bz fl(long paramLong)
  {
    this.euu = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19949;
  }
  
  public final bz kF(String paramString)
  {
    AppMethodBeat.i(208942);
    this.erU = x("Sessionid", paramString, true);
    AppMethodBeat.o(208942);
    return this;
  }
  
  public final bz kG(String paramString)
  {
    AppMethodBeat.i(208943);
    this.eus = x("ClickContextid", paramString, true);
    AppMethodBeat.o(208943);
    return this;
  }
  
  public final bz kH(String paramString)
  {
    AppMethodBeat.i(208944);
    this.eoD = x("ContextID", paramString, true);
    AppMethodBeat.o(208944);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bz
 * JD-Core Version:    0.7.0.1
 */