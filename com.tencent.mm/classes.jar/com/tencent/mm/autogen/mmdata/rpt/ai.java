package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ai
  extends a
{
  public long iob;
  public long iog;
  public long ioh;
  public long ioi;
  public long ioj;
  public String iok;
  public long iol;
  public long iom;
  public long ion;
  
  public ai()
  {
    this.iob = 0L;
    this.iog = 0L;
    this.ioh = 0L;
    this.ioi = 0L;
    this.ioj = 0L;
    this.iok = "";
    this.iol = 0L;
    this.iom = 0L;
    this.ion = 0L;
  }
  
  public ai(String paramString)
  {
    AppMethodBeat.i(368580);
    this.iob = 0L;
    this.iog = 0L;
    this.ioh = 0L;
    this.ioi = 0L;
    this.ioj = 0L;
    this.iok = "";
    this.iol = 0L;
    this.iom = 0L;
    this.ion = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 9) {
          break label210;
        }
        String[] arrayOfString = new String[9];
        Arrays.fill(arrayOfString, 0, 9, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label210:
    for (;;)
    {
      this.iob = Util.getLong(paramString[0], 0L);
      es(Util.getLong(paramString[1], 0L));
      this.ioh = Util.getLong(paramString[2], 0L);
      this.ioi = Util.getLong(paramString[3], 0L);
      et(Util.getLong(paramString[4], 0L));
      ky(paramString[5]);
      this.iol = Util.getLong(paramString[6], 0L);
      this.iom = Util.getLong(paramString[7], 0L);
      this.ion = Util.getLong(paramString[8], 0L);
      AppMethodBeat.o(368580);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368614);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iob);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iog);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iok);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iol);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iom);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ion);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368614);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368619);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ds:").append(this.iob);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstExposeTimeMs:").append(this.iog);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstExposeCtrlType:").append(this.ioh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeCount:").append(this.ioi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("totalStayTimeSec:").append(this.ioj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTipsId:").append(this.iok);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tipsIdExposeCount:").append(this.iol);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterCount:").append(this.iom);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterWithRedDotCount:").append(this.ion);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368619);
    return localObject;
  }
  
  public final ai es(long paramLong)
  {
    AppMethodBeat.i(368592);
    this.iog = paramLong;
    super.bw("firstExposeTimeMs", this.iog);
    AppMethodBeat.o(368592);
    return this;
  }
  
  public final ai et(long paramLong)
  {
    AppMethodBeat.i(368599);
    this.ioj = paramLong;
    super.bx("totalStayTimeSec", this.ioj);
    AppMethodBeat.o(368599);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final ai ky(String paramString)
  {
    AppMethodBeat.i(368607);
    this.iok = F("lastTipsId", paramString, true);
    AppMethodBeat.o(368607);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ai
 * JD-Core Version:    0.7.0.1
 */