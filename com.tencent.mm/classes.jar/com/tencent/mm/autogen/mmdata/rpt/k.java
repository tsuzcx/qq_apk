package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class k
  extends a
{
  private String ikA;
  private String ikB;
  public long ikx;
  private long iky;
  public long ikz;
  
  public k()
  {
    this.ikx = 0L;
    this.iky = 0L;
    this.ikz = 0L;
    this.ikA = "";
    this.ikB = "";
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(368661);
    this.ikx = 0L;
    this.iky = 0L;
    this.ikz = 0L;
    this.ikA = "";
    this.ikB = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 5) {
          break label137;
        }
        String[] arrayOfString = new String[5];
        Arrays.fill(arrayOfString, 0, 5, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label137:
    for (;;)
    {
      this.ikx = Util.getLong(paramString[0], 0L);
      ep(Util.getLong(paramString[1], 0L));
      this.ikz = Util.getLong(paramString[2], 0L);
      kd(paramString[3]);
      ke(paramString[4]);
      AppMethodBeat.o(368661);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368680);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iky);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikB);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368680);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368685);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lastGpsScene:").append(this.ikx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastGpsTimeMs:").append(this.iky);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastPre:").append(this.ikz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("longitude:").append(this.ikA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("latitude:").append(this.ikB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368685);
    return localObject;
  }
  
  public final k ep(long paramLong)
  {
    AppMethodBeat.i(368668);
    this.iky = paramLong;
    super.bw("lastGpsTimeMs", this.iky);
    AppMethodBeat.o(368668);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final k kd(String paramString)
  {
    AppMethodBeat.i(368673);
    this.ikA = F("longitude", paramString, true);
    AppMethodBeat.o(368673);
    return this;
  }
  
  public final k ke(String paramString)
  {
    AppMethodBeat.i(368675);
    this.ikB = F("latitude", paramString, true);
    AppMethodBeat.o(368675);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.k
 * JD-Core Version:    0.7.0.1
 */