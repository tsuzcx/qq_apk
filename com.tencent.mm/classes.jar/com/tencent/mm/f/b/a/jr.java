package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class jr
  extends a
{
  public long gLN;
  public long gLO;
  public String gLP;
  public boolean gLQ;
  
  public jr()
  {
    this.gLN = 0L;
    this.gLO = 0L;
    this.gLP = "";
  }
  
  public jr(String paramString)
  {
    AppMethodBeat.i(121765);
    this.gLN = 0L;
    this.gLO = 0L;
    this.gLP = "";
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
      this.gLN = Util.getLong(paramString[0], 0L);
      ux(Util.getLong(paramString[1], 0L));
      AH(paramString[2]);
      this.gLQ = a.getBoolean(paramString[3]);
      AppMethodBeat.o(121765);
      return;
    }
  }
  
  private jr ux(long paramLong)
  {
    AppMethodBeat.i(121766);
    this.gLO = paramLong;
    super.bn("StartTimeStampSec", this.gLO);
    AppMethodBeat.o(121766);
    return this;
  }
  
  public final jr AH(String paramString)
  {
    AppMethodBeat.i(121768);
    this.gLP = z("Roomname", paramString, true);
    AppMethodBeat.o(121768);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(121769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gLN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLP);
    ((StringBuffer)localObject).append(",");
    if (this.gLQ) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(121769);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(121770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.gLN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.gLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.gLP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.gLQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121770);
    return localObject;
  }
  
  public final jr amf()
  {
    AppMethodBeat.i(121767);
    jr localjr = ux(Util.nowSecond());
    AppMethodBeat.o(121767);
    return localjr;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jr
 * JD-Core Version:    0.7.0.1
 */