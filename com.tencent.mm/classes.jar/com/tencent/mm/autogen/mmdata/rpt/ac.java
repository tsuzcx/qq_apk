package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ac
  extends a
{
  private String ijk = "";
  private String ilM = "";
  private String imT = "";
  public long inc;
  public long ind = 0L;
  public long ine;
  private String inf = "";
  private String ing = "";
  private String inh = "";
  public long ini;
  
  public final String aIE()
  {
    AppMethodBeat.i(368716);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ine);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ing);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ini);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368716);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Event:").append(this.inc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ine);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sn:").append(this.inf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BluetoothDeviceid:").append(this.ing);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EntryPackage:").append(this.inh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartErrCode:").append(this.ini);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368723);
    return localObject;
  }
  
  public final int getId()
  {
    return 25092;
  }
  
  public final ac ks(String paramString)
  {
    AppMethodBeat.i(368682);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(368682);
    return this;
  }
  
  public final ac kt(String paramString)
  {
    AppMethodBeat.i(368687);
    this.inf = F("Sn", paramString, true);
    AppMethodBeat.o(368687);
    return this;
  }
  
  public final ac ku(String paramString)
  {
    AppMethodBeat.i(368694);
    this.ing = F("BluetoothDeviceid", paramString, true);
    AppMethodBeat.o(368694);
    return this;
  }
  
  public final ac kv(String paramString)
  {
    AppMethodBeat.i(368700);
    this.inh = F("EntryPackage", paramString, true);
    AppMethodBeat.o(368700);
    return this;
  }
  
  public final ac kw(String paramString)
  {
    AppMethodBeat.i(368705);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368705);
    return this;
  }
  
  public final ac kx(String paramString)
  {
    AppMethodBeat.i(368708);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(368708);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ac
 * JD-Core Version:    0.7.0.1
 */