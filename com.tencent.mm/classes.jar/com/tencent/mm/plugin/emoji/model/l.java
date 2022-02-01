package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ee;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  private ee xMR;
  public final Map<String, Integer> xMS;
  
  public l()
  {
    AppMethodBeat.i(108585);
    this.xMS = new HashMap();
    this.xMR = new ee();
    AppMethodBeat.o(108585);
  }
  
  public final int aoI(String paramString)
  {
    AppMethodBeat.i(269857);
    paramString = (Integer)this.xMS.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(269857);
      return -1;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(269857);
    return i;
  }
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108586);
    this.xMR.hDW.productId = paramString1;
    this.xMR.hDW.status = paramInt1;
    this.xMR.hDW.progress = paramInt2;
    this.xMR.hDW.hDX = paramString2;
    this.xMR.publish();
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.xMS.remove(paramString1);
        AppMethodBeat.o(108586);
        return;
      }
      this.xMS.put(paramString1, Integer.valueOf(paramInt2));
      AppMethodBeat.o(108586);
      return;
    }
    this.xMS.remove(paramString1);
    AppMethodBeat.o(108586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.l
 * JD-Core Version:    0.7.0.1
 */