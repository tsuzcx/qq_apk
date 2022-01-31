package com.tencent.mm.plugin.game.d;

public final class s
  extends com.tencent.mm.bv.a
{
  public String euK;
  public String kRU;
  public int kSU;
  public int kSV;
  public int kSW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.kSU);
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      paramVarArgs.gB(3, this.kSV);
      if (this.kRU != null) {
        paramVarArgs.d(4, this.kRU);
      }
      paramVarArgs.gB(5, this.kSW);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.kSU) + 0;
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt + d.a.a.a.gy(3, this.kSV);
      paramInt = i;
      if (this.kRU != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRU);
      }
      return paramInt + d.a.a.a.gy(5, this.kSW);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locals.kSU = locala.xpH.oD();
        return 0;
      case 2: 
        locals.euK = locala.xpH.readString();
        return 0;
      case 3: 
        locals.kSV = locala.xpH.oD();
        return 0;
      case 4: 
        locals.kRU = locala.xpH.readString();
        return 0;
      }
      locals.kSW = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.s
 * JD-Core Version:    0.7.0.1
 */