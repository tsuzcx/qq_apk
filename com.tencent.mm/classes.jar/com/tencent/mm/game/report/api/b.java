package com.tencent.mm.game.report.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public int gsc;
  public String gsd;
  
  public b() {}
  
  public b(int paramInt, String paramString)
  {
    this.gsc = paramInt;
    this.gsd = paramString;
  }
  
  public static b c(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117604);
    b localb = new b();
    localb.gsc = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length - 1;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    localb.gsd = localStringBuilder.toString();
    ad.d("MicroMsg.GameReportInfo", "appStat logID=%d, vals.size=%d, val = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVarArgs.length), localStringBuilder.toString() });
    AppMethodBeat.o(117604);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.game.report.api.b
 * JD-Core Version:    0.7.0.1
 */