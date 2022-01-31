package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class db
  extends a
{
  private String cUk = "";
  private String cUs = "";
  private long dce = 0L;
  private long deb = 0L;
  private long dec = 0L;
  private int ded = 0;
  private String dee = "";
  private String def = "";
  private String deg = "";
  private String deh = "";
  private long dei = 0L;
  private String dej = "";
  private String dek = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(128916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dec);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ded);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dee);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.def);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.deh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dei);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dej);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dek);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dce);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(128916);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128917);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.cUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.deb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.dec);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.ded);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.dee);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.def);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.deg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.deh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.dei);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.dej);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.cUs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.dek);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.dce);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128917);
    return localObject;
  }
  
  public final db Hk()
  {
    this.ded = 9;
    return this;
  }
  
  public final db fF(long paramLong)
  {
    this.deb = paramLong;
    return this;
  }
  
  public final db fG(long paramLong)
  {
    this.dec = paramLong;
    return this;
  }
  
  public final db fH(long paramLong)
  {
    this.dei = paramLong;
    return this;
  }
  
  public final db fI(long paramLong)
  {
    this.dce = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 13582;
  }
  
  public final db in(String paramString)
  {
    AppMethodBeat.i(128910);
    this.cUk = t("appid", paramString, true);
    AppMethodBeat.o(128910);
    return this;
  }
  
  public final db io(String paramString)
  {
    AppMethodBeat.i(128911);
    this.def = t("errorMessage", paramString, true);
    AppMethodBeat.o(128911);
    return this;
  }
  
  public final db ip(String paramString)
  {
    AppMethodBeat.i(128912);
    this.deg = t("errorStack", paramString, true);
    AppMethodBeat.o(128912);
    return this;
  }
  
  public final db iq(String paramString)
  {
    AppMethodBeat.i(128913);
    this.deh = t("sdkversion", paramString, true);
    AppMethodBeat.o(128913);
    return this;
  }
  
  public final db ir(String paramString)
  {
    AppMethodBeat.i(128914);
    this.dej = t("route", paramString, true);
    AppMethodBeat.o(128914);
    return this;
  }
  
  public final db is(String paramString)
  {
    AppMethodBeat.i(128915);
    this.cUs = t("query", paramString, true);
    AppMethodBeat.o(128915);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.db
 * JD-Core Version:    0.7.0.1
 */