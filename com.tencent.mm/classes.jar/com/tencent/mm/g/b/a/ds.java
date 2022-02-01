package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ds
  extends a
{
  public long dQB = 0L;
  private String dTr = "";
  private String eiB = "";
  private String eiC = "";
  private String eiD = "";
  private String eiE = "";
  
  public final String RC()
  {
    AppMethodBeat.i(218127);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(218127);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(218128);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResignationWorkUsername:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TakeOverWorkUsername:").append(this.eiC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseDescId:").append(this.eiD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WorkEnterpriseName:").append(this.eiE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(218128);
    return localObject;
  }
  
  public final int getId()
  {
    return 19942;
  }
  
  public final ds nr(String paramString)
  {
    AppMethodBeat.i(218122);
    this.eiB = t("ResignationWorkUsername", paramString, true);
    AppMethodBeat.o(218122);
    return this;
  }
  
  public final ds ns(String paramString)
  {
    AppMethodBeat.i(218123);
    this.eiC = t("TakeOverWorkUsername", paramString, true);
    AppMethodBeat.o(218123);
    return this;
  }
  
  public final ds nt(String paramString)
  {
    AppMethodBeat.i(218124);
    this.eiD = t("WorkEnterpriseDescId", paramString, true);
    AppMethodBeat.o(218124);
    return this;
  }
  
  public final ds nu(String paramString)
  {
    AppMethodBeat.i(218125);
    this.eiE = t("WorkEnterpriseName", paramString, true);
    AppMethodBeat.o(218125);
    return this;
  }
  
  public final ds nv(String paramString)
  {
    AppMethodBeat.i(218126);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(218126);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ds
 * JD-Core Version:    0.7.0.1
 */