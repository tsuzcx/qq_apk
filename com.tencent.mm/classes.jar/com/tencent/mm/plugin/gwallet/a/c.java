package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  String mMessage;
  public int mResponse;
  
  public c(int paramInt, String paramString)
  {
    AppMethodBeat.i(64601);
    this.mResponse = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.mMessage = b.getResponseDesc(paramInt);
      AppMethodBeat.o(64601);
      return;
    }
    this.mMessage = (paramString + " (response: " + b.getResponseDesc(paramInt) + ")");
    AppMethodBeat.o(64601);
  }
  
  public final int getResponse()
  {
    switch (this.mResponse)
    {
    default: 
      return this.mResponse;
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
    return this.mResponse == 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64602);
    String str = "IapResult: " + this.mMessage;
    AppMethodBeat.o(64602);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.c
 * JD-Core Version:    0.7.0.1
 */