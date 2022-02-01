package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class dj
  extends a
{
  public long dSa;
  public long dSb;
  public String dSc;
  public boolean dSd;
  
  public dj()
  {
    this.dSa = 0L;
    this.dSb = 0L;
    this.dSc = "";
  }
  
  public dj(String paramString)
  {
    AppMethodBeat.i(121765);
    this.dSa = 0L;
    this.dSb = 0L;
    this.dSc = "";
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
      this.dSa = bs.getLong(paramString[0], 0L);
      il(bs.getLong(paramString[1], 0L));
      ln(paramString[2]);
      this.dSd = a.getBoolean(paramString[3]);
      AppMethodBeat.o(121765);
      return;
    }
  }
  
  private dj il(long paramLong)
  {
    AppMethodBeat.i(121766);
    this.dSb = paramLong;
    super.be("StartTimeStampSec", this.dSb);
    AppMethodBeat.o(121766);
    return this;
  }
  
  public final String PR()
  {
    AppMethodBeat.i(121769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSc);
    ((StringBuffer)localObject).append(",");
    if (this.dSd) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      arz((String)localObject);
      AppMethodBeat.o(121769);
      return localObject;
    }
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExptFlag:").append(this.dSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampSec:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Roomname:").append(this.dSc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hardcodeExptBool:").append(this.dSd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121770);
    return localObject;
  }
  
  public final dj Rb()
  {
    AppMethodBeat.i(121767);
    dj localdj = il(bs.aNx());
    AppMethodBeat.o(121767);
    return localdj;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final dj ln(String paramString)
  {
    AppMethodBeat.i(121768);
    this.dSc = t("Roomname", paramString, true);
    AppMethodBeat.o(121768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dj
 * JD-Core Version:    0.7.0.1
 */