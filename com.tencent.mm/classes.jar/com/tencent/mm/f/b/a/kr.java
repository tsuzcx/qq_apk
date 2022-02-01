package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class kr
  extends a
{
  public int gOL;
  public long gOM;
  public long gON;
  public long gOO;
  public long gOP;
  public long gOQ;
  private int gOR;
  public long gOS;
  public int gOT;
  public long gOU;
  public long gOV;
  public int nmJ;
  
  public kr()
  {
    this.gOL = 0;
    this.gOM = 0L;
    this.gON = 0L;
    this.gOO = 0L;
    this.gOP = 0L;
    this.gOQ = 0L;
    this.gOR = 0;
    this.gOS = 0L;
    this.gOT = -1;
    this.gOU = 0L;
    this.gOV = -1L;
    this.nmJ = 0;
  }
  
  public kr(String paramString)
  {
    AppMethodBeat.i(233203);
    this.gOL = 0;
    this.gOM = 0L;
    this.gON = 0L;
    this.gOO = 0L;
    this.gOP = 0L;
    this.gOQ = 0L;
    this.gOR = 0;
    this.gOS = 0L;
    this.gOT = -1;
    this.gOU = 0L;
    this.gOV = -1L;
    this.nmJ = 0;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 12) {
          break label263;
        }
        String[] arrayOfString = new String[12];
        Arrays.fill(arrayOfString, 0, 12, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label263:
    for (;;)
    {
      this.gOL = Util.getInt(paramString[0], 0);
      this.gOM = Util.getLong(paramString[1], 0L);
      this.gON = Util.getLong(paramString[2], 0L);
      this.gOO = Util.getLong(paramString[3], 0L);
      this.gOP = Util.getLong(paramString[4], 0L);
      this.gOQ = Util.getLong(paramString[5], 0L);
      this.gOR = Util.getInt(paramString[6], 0);
      this.gOS = Util.getLong(paramString[7], 0L);
      this.gOT = Util.getInt(paramString[8], 0);
      this.gOU = Util.getLong(paramString[9], 0L);
      this.gOV = Util.getLong(paramString[10], 0L);
      this.nmJ = Util.getInt(paramString[11], 0);
      AppMethodBeat.o(233203);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(233207);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gOL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gON);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nmJ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(233207);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(233209);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Code:").append(this.gOL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginDbCount:").append(this.gOM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteDbCount:").append(this.gON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginDbSize:").append(this.gOO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteDbSize:").append(this.gOP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CleanCostTime:").append(this.gOQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NeedRestUserSize:").append(this.gOR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeLimit:").append(this.gOS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstTimeClean:").append(this.gOT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCleanTime:").append(this.gOU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeSinceLastClean:").append(this.gOV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportType:").append(this.nmJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(233209);
    return localObject;
  }
  
  public final int getId()
  {
    return 23030;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kr
 * JD-Core Version:    0.7.0.1
 */