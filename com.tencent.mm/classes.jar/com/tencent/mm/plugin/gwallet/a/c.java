package com.tencent.mm.plugin.gwallet.a;

public final class c
{
  public int ljp;
  String ljq;
  
  public c(int paramInt, String paramString)
  {
    this.ljp = paramInt;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.ljq = b.sq(paramInt);
      return;
    }
    this.ljq = (paramString + " (response: " + b.sq(paramInt) + ")");
  }
  
  public final int baN()
  {
    switch (this.ljp)
    {
    default: 
      return this.ljp;
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
    return this.ljp == 0;
  }
  
  public final String toString()
  {
    return "IapResult: " + this.ljq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.c
 * JD-Core Version:    0.7.0.1
 */