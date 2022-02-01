package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lj
  extends a
{
  private String iFt = "";
  private String iZQ = "";
  private String iZR = "";
  private String iZS = "";
  public long ila;
  private String imd = "";
  public long inE;
  private String ipx = "";
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368189);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZS);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368189);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368193);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionTS:").append(this.inE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("setting:").append(this.iZQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("session_id:").append(this.imd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderid:").append(this.iFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickid:").append(this.iZR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestID:").append(this.iZS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368193);
    return localObject;
  }
  
  public final int getId()
  {
    return 21837;
  }
  
  public final lj ug(String paramString)
  {
    AppMethodBeat.i(368157);
    this.iZQ = F("setting", paramString, true);
    AppMethodBeat.o(368157);
    return this;
  }
  
  public final lj uh(String paramString)
  {
    AppMethodBeat.i(368161);
    this.ipx = F("appid", paramString, true);
    AppMethodBeat.o(368161);
    return this;
  }
  
  public final lj ui(String paramString)
  {
    AppMethodBeat.i(368165);
    this.imd = F("session_id", paramString, true);
    AppMethodBeat.o(368165);
    return this;
  }
  
  public final lj uj(String paramString)
  {
    AppMethodBeat.i(368171);
    this.iFt = F("finderid", paramString, true);
    AppMethodBeat.o(368171);
    return this;
  }
  
  public final lj uk(String paramString)
  {
    AppMethodBeat.i(368176);
    this.iZR = F("clickid", paramString, true);
    AppMethodBeat.o(368176);
    return this;
  }
  
  public final lj ul(String paramString)
  {
    AppMethodBeat.i(368181);
    this.iZS = F("requestID", paramString, true);
    AppMethodBeat.o(368181);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lj
 * JD-Core Version:    0.7.0.1
 */