package com.tencent.mm.game.report.api;

import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  public int dCy;
  public String dCz;
  
  public d() {}
  
  public d(int paramInt, String paramString)
  {
    this.dCy = paramInt;
    this.dCz = paramString;
  }
  
  public static d c(int paramInt, Object... paramVarArgs)
  {
    d locald = new d();
    locald.dCy = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length - 1;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    locald.dCz = localStringBuilder.toString();
    y.d("MicroMsg.GameReportInfo", "appStat logID=%d, vals.size=%d, val = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVarArgs.length), localStringBuilder.toString() });
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.game.report.api.d
 * JD-Core Version:    0.7.0.1
 */