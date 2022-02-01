package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class nl
  extends a
{
  public int jeZ;
  public long jfa;
  public long jfb;
  public long jfc;
  public long jfd;
  public long jfe;
  private int jff;
  public long jfg;
  public int jfh;
  public long jfi;
  public long jfj;
  public int jfk;
  public int jfl;
  
  public nl()
  {
    this.jeZ = 0;
    this.jfa = 0L;
    this.jfb = 0L;
    this.jfc = 0L;
    this.jfd = 0L;
    this.jfe = 0L;
    this.jff = 0;
    this.jfg = 0L;
    this.jfh = -1;
    this.jfi = 0L;
    this.jfj = -1L;
    this.jfk = 0;
    this.jfl = 0;
  }
  
  public nl(String paramString)
  {
    AppMethodBeat.i(367852);
    this.jeZ = 0;
    this.jfa = 0L;
    this.jfb = 0L;
    this.jfc = 0L;
    this.jfd = 0L;
    this.jfe = 0L;
    this.jff = 0;
    this.jfg = 0L;
    this.jfh = -1;
    this.jfi = 0L;
    this.jfj = -1L;
    this.jfk = 0;
    this.jfl = 0;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 13) {
          break label280;
        }
        String[] arrayOfString = new String[13];
        Arrays.fill(arrayOfString, 0, 13, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label280:
    for (;;)
    {
      this.jeZ = Util.getInt(paramString[0], 0);
      this.jfa = Util.getLong(paramString[1], 0L);
      this.jfb = Util.getLong(paramString[2], 0L);
      this.jfc = Util.getLong(paramString[3], 0L);
      this.jfd = Util.getLong(paramString[4], 0L);
      this.jfe = Util.getLong(paramString[5], 0L);
      this.jff = Util.getInt(paramString[6], 0);
      this.jfg = Util.getLong(paramString[7], 0L);
      this.jfh = Util.getInt(paramString[8], 0);
      this.jfi = Util.getLong(paramString[9], 0L);
      this.jfj = Util.getLong(paramString[10], 0L);
      this.jfk = Util.getInt(paramString[11], 0);
      this.jfl = Util.getInt(paramString[12], 0);
      AppMethodBeat.o(367852);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(367866);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jeZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jff);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfl);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367866);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367873);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Code:").append(this.jeZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginDbCount:").append(this.jfa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteDbCount:").append(this.jfb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginDbSize:").append(this.jfc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteDbSize:").append(this.jfd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CleanCostTime:").append(this.jfe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NeedRestUserSize:").append(this.jff);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeLimit:").append(this.jfg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstTimeClean:").append(this.jfh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCleanTime:").append(this.jfi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeSinceLastClean:").append(this.jfj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportType:").append(this.jfk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailTime:").append(this.jfl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367873);
    return localObject;
  }
  
  public final int getId()
  {
    return 23030;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nl
 * JD-Core Version:    0.7.0.1
 */