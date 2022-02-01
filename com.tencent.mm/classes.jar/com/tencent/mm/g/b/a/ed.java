package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class ed
  extends a
{
  public long ehF;
  public long ehG;
  public String ehH;
  public boolean ehI;
  
  public ed()
  {
    this.ehF = 0L;
    this.ehG = 0L;
    this.ehH = "";
  }
  
  public ed(String paramString)
  {
    AppMethodBeat.i(121765);
    this.ehF = 0L;
    this.ehG = 0L;
    this.ehH = "";
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
      this.ehF = bt.getLong(paramString[0], 0L);
      jW(bt.getLong(paramString[1], 0L));
      nu(paramString[2]);
      this.ehI = a.getBoolean(paramString[3]);
      AppMethodBeat.o(121765);
      return;
    }
  }
  
  private ed jW(long paramLong)
  {
    AppMethodBeat.i(121766);
    this.ehG = paramLong;
    super.bh("StartTimeStampSec", this.ehG);
    AppMethodBeat.o(121766);
    return this;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ehF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehH);
    ((StringBuffer)localObject).append(",");
    if (this.ehI) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(121769);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.ehF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.ehG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.ehH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.ehI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121770);
    return localObject;
  }
  
  public final ed Ti()
  {
    AppMethodBeat.i(121767);
    ed localed = jW(bt.aQJ());
    AppMethodBeat.o(121767);
    return localed;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final ed nu(String paramString)
  {
    AppMethodBeat.i(121768);
    this.ehH = t("Roomname", paramString, true);
    AppMethodBeat.o(121768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ed
 * JD-Core Version:    0.7.0.1
 */