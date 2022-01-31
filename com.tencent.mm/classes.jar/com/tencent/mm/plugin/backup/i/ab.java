package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.bv.b;

public final class ab
  extends com.tencent.mm.bv.a
{
  public int hPE;
  public b hPF;
  public long hQp;
  public int hRg;
  public int hRh;
  public long hRi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hPE);
      if (this.hPF != null) {
        paramVarArgs.b(2, this.hPF);
      }
      paramVarArgs.gB(3, this.hRg);
      paramVarArgs.gB(4, this.hRh);
      paramVarArgs.Y(5, this.hRi);
      paramVarArgs.Y(6, this.hQp);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.hPE) + 0;
      paramInt = i;
      if (this.hPF != null) {
        paramInt = i + d.a.a.a.a(2, this.hPF);
      }
      return paramInt + d.a.a.a.gy(3, this.hRg) + d.a.a.a.gy(4, this.hRh) + d.a.a.a.X(5, this.hRi) + d.a.a.a.X(6, this.hQp);
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
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localab.hPE = locala.xpH.oD();
        return 0;
      case 2: 
        localab.hPF = locala.cUs();
        return 0;
      case 3: 
        localab.hRg = locala.xpH.oD();
        return 0;
      case 4: 
        localab.hRh = locala.xpH.oD();
        return 0;
      case 5: 
        localab.hRi = locala.xpH.oE();
        return 0;
      }
      localab.hQp = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */