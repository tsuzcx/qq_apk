package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bo
  extends a
{
  private String eiB = "";
  private long eor;
  private long ete;
  private long etf;
  private String etg = "";
  private long eth;
  private long eti;
  private long etj;
  private long etk;
  private long etl;
  private long etm;
  
  public final String abV()
  {
    AppMethodBeat.i(208896);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ete);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eth);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eti);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eor);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etm);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208896);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208897);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.ete);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.etf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReasonWording:").append(this.etg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasAvatar:").append(this.eth);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNickName:").append(this.eti);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.etj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSex:").append(this.etk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.eor);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasCheckAgreement:").append(this.etl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("createscene:").append(this.etm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208897);
    return localObject;
  }
  
  public final bo acC()
  {
    this.eth = 1L;
    return this;
  }
  
  public final bo acD()
  {
    this.eti = 1L;
    return this;
  }
  
  public final bo acE()
  {
    this.etk = 1L;
    return this;
  }
  
  public final bo acF()
  {
    this.eor = 1L;
    return this;
  }
  
  public final bo em(long paramLong)
  {
    this.ete = paramLong;
    return this;
  }
  
  public final bo en(long paramLong)
  {
    this.etf = paramLong;
    return this;
  }
  
  public final bo eo(long paramLong)
  {
    this.etm = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19815;
  }
  
  public final bo jL(String paramString)
  {
    AppMethodBeat.i(208894);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(208894);
    return this;
  }
  
  public final bo jM(String paramString)
  {
    AppMethodBeat.i(208895);
    this.etg = x("FailReasonWording", paramString, true);
    AppMethodBeat.o(208895);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bo
 * JD-Core Version:    0.7.0.1
 */