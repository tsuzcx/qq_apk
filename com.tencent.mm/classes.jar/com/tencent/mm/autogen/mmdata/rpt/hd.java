package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hd
  extends a
{
  public String iAN = "";
  public String iGJ = "";
  public int iGK;
  public String iGL = "";
  public long iGM;
  public String inx = "";
  private String ixK = "";
  public String ixp = "";
  public String ixs = "";
  private String ixy = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369025);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGM);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369025);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369031);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("findercontextid:").append(this.iGJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.ixs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_code:").append(this.iGK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_time:").append(this.iGL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderusername:").append(this.ixp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.iAN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.ixK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ref_commentscene:").append(this.ixy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTime:").append(this.iGM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369031);
    return localObject;
  }
  
  public final int getId()
  {
    return 21874;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hd
 * JD-Core Version:    0.7.0.1
 */