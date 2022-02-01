package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class mi
  extends a
{
  public long jbA;
  public String jbB;
  public boolean jbC;
  public long jbz;
  
  public mi()
  {
    this.jbz = 0L;
    this.jbA = 0L;
    this.jbB = "";
  }
  
  public mi(String paramString)
  {
    AppMethodBeat.i(121765);
    this.jbz = 0L;
    this.jbA = 0L;
    this.jbB = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 4) {
          break label117;
        }
        String[] arrayOfString = new String[4];
        Arrays.fill(arrayOfString, 0, 4, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label117:
    for (;;)
    {
      this.jbz = Util.getLong(paramString[0], 0L);
      fm(Util.getLong(paramString[1], 0L));
      uN(paramString[2]);
      this.jbC = a.getBoolean(paramString[3]);
      AppMethodBeat.o(121765);
      return;
    }
  }
  
  private mi fm(long paramLong)
  {
    AppMethodBeat.i(121766);
    this.jbA = paramLong;
    super.bz("StartTimeStampSec", this.jbA);
    AppMethodBeat.o(121766);
    return this;
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(121769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jbz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbB);
    ((StringBuffer)localObject).append(",");
    if (this.jbC) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(121769);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.jbz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.jbA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.jbB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.jbC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121770);
    return localObject;
  }
  
  public final mi aIR()
  {
    AppMethodBeat.i(121767);
    mi localmi = fm(Util.nowSecond());
    AppMethodBeat.o(121767);
    return localmi;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final mi uN(String paramString)
  {
    AppMethodBeat.i(121768);
    this.jbB = F("Roomname", paramString, true);
    AppMethodBeat.o(121768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mi
 * JD-Core Version:    0.7.0.1
 */