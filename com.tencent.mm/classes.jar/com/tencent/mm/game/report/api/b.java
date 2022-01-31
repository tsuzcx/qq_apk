package com.tencent.mm.game.report.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public int ezN;
  public String ezO;
  
  public b() {}
  
  public b(int paramInt, String paramString)
  {
    this.ezN = paramInt;
    this.ezO = paramString;
  }
  
  public static b b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(128610);
    b localb = new b();
    localb.ezN = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length - 1;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[j]));
    localb.ezO = localStringBuilder.toString();
    ab.d("MicroMsg.GameReportInfo", "appStat logID=%d, vals.size=%d, val = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVarArgs.length), localStringBuilder.toString() });
    AppMethodBeat.o(128610);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.game.report.api.b
 * JD-Core Version:    0.7.0.1
 */