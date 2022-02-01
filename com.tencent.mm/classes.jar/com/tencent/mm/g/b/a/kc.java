package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kc
  extends a
{
  public String dTT = "";
  public String eCq = "";
  public long eEs = 0L;
  public String eEt = "";
  public long eEu = 0L;
  public long eEv = 0L;
  public long eEw = 0L;
  public long eEx = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(116508);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEx);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116508);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116509);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.eEs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pkgMd5:").append(this.eEt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("downloadUrl:").append(this.eCq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSuccess:").append(this.eEu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeCostInMs:").append(this.eEv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeStampInMs:").append(this.eEw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalLen:").append(this.eEx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116509);
    return localObject;
  }
  
  public final int getId()
  {
    return 15778;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kc
 * JD-Core Version:    0.7.0.1
 */