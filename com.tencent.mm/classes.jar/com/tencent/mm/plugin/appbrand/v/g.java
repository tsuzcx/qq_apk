package com.tencent.mm.plugin.appbrand.v;

public final class g
{
  private long hlp;
  private long hlq;
  private g.a hlr;
  
  public g() {}
  
  public g(long paramLong, g.a parama)
  {
    this.hlp = paramLong;
    this.hlr = parama;
  }
  
  public final boolean k(Object... paramVarArgs)
  {
    boolean bool1 = false;
    int i;
    if (System.currentTimeMillis() - this.hlq < this.hlp)
    {
      i = 1;
      if (i == 0) {
        break label31;
      }
    }
    label31:
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        i = 0;
        break;
      } while (this.hlr == null);
      bool2 = this.hlr.i(paramVarArgs);
      bool1 = bool2;
    } while (!bool2);
    this.hlq = System.currentTimeMillis();
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.g
 * JD-Core Version:    0.7.0.1
 */