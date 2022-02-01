package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class jk
  extends a
{
  public String iSU;
  public long iSV;
  public long iSW;
  public long ixB;
  
  public jk()
  {
    this.iSU = "";
    this.ixB = 0L;
    this.iSV = 0L;
    this.iSW = 0L;
  }
  
  public jk(String paramString)
  {
    AppMethodBeat.i(121753);
    this.iSU = "";
    this.ixB = 0L;
    this.iSV = 0L;
    this.iSW = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 4) {
          break label123;
        }
        String[] arrayOfString = new String[4];
        Arrays.fill(arrayOfString, 0, 4, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label123:
    for (;;)
    {
      sh(paramString[0]);
      this.ixB = Util.getLong(paramString[1], 0L);
      fh(Util.getLong(paramString[2], 0L));
      this.iSW = Util.getLong(paramString[3], 0L);
      AppMethodBeat.o(121753);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(121756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iSU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSW);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(121756);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.iSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.iSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.iSW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121757);
    return localObject;
  }
  
  public final jk fh(long paramLong)
  {
    AppMethodBeat.i(121755);
    this.iSV = paramLong;
    super.by("TimeStampMs", this.iSV);
    AppMethodBeat.o(121755);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final jk sh(String paramString)
  {
    AppMethodBeat.i(121754);
    this.iSU = F("Name", paramString, true);
    AppMethodBeat.o(121754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jk
 * JD-Core Version:    0.7.0.1
 */