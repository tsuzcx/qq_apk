package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lj
  extends a
{
  public long eEP = 0L;
  private String eXp = "";
  public long eYC = 0L;
  public long eYD = 0L;
  private String eYE = "";
  private String eiB = "";
  public long enl = 0L;
  public long etp = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(187815);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXp);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187815);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187816);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DismissType:").append(this.eYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionSourceType:").append(this.eYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStamp:").append(this.eEP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSceneId:").append(this.eYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryKey:").append(this.eXp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187816);
    return localObject;
  }
  
  public final lj aiB()
  {
    this.enl = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 20996;
  }
  
  public final lj uR(long paramLong)
  {
    this.eYC = paramLong;
    return this;
  }
  
  public final lj uS(long paramLong)
  {
    this.eYD = paramLong;
    return this;
  }
  
  public final lj uT(long paramLong)
  {
    this.eEP = paramLong;
    return this;
  }
  
  public final lj uU(long paramLong)
  {
    this.etp = paramLong;
    return this;
  }
  
  public final lj yD(String paramString)
  {
    AppMethodBeat.i(187812);
    this.eYE = x("EnterSceneId", paramString, true);
    AppMethodBeat.o(187812);
    return this;
  }
  
  public final lj yE(String paramString)
  {
    AppMethodBeat.i(187813);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(187813);
    return this;
  }
  
  public final lj yF(String paramString)
  {
    AppMethodBeat.i(187814);
    this.eXp = x("QueryKey", paramString, true);
    AppMethodBeat.o(187814);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lj
 * JD-Core Version:    0.7.0.1
 */