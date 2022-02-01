package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int uPh;
  String uPi;
  
  public c(int paramInt, String paramString)
  {
    AppMethodBeat.i(64601);
    this.uPh = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.uPi = b.IH(paramInt);
      AppMethodBeat.o(64601);
      return;
    }
    this.uPi = (paramString + " (response: " + b.IH(paramInt) + ")");
    AppMethodBeat.o(64601);
  }
  
  public final int dez()
  {
    switch (this.uPh)
    {
    default: 
      return this.uPh;
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
    return this.uPh == 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64602);
    String str = "IapResult: " + this.uPi;
    AppMethodBeat.o(64602);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.c
 * JD-Core Version:    0.7.0.1
 */