package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int nGE;
  String nGF;
  
  public c(int paramInt, String paramString)
  {
    AppMethodBeat.i(41705);
    this.nGE = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.nGF = b.xq(paramInt);
      AppMethodBeat.o(41705);
      return;
    }
    this.nGF = (paramString + " (response: " + b.xq(paramInt) + ")");
    AppMethodBeat.o(41705);
  }
  
  public final int bHN()
  {
    switch (this.nGE)
    {
    default: 
      return this.nGE;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case -1009: 
    case -1002: 
    case -1001: 
    case -1000: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
      return 5;
    case 5: 
      return 6;
    case 7: 
      return 100000002;
    case 8: 
      return 106;
    }
    return 3;
  }
  
  public final boolean isSuccess()
  {
    return this.nGE == 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(41706);
    String str = "IapResult: " + this.nGF;
    AppMethodBeat.o(41706);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.c
 * JD-Core Version:    0.7.0.1
 */