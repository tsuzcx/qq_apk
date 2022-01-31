package com.tencent.mm.plugin.luckymoney.b;

public final class a
  extends com.tencent.mm.bv.a
{
  public int dwF;
  public String lPE;
  public String lPF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.dwF);
      if (this.lPE != null) {
        paramVarArgs.d(2, this.lPE);
      }
      if (this.lPF != null) {
        paramVarArgs.d(3, this.lPF);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.dwF) + 0;
      paramInt = i;
      if (this.lPE != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.lPE);
      }
      i = paramInt;
    } while (this.lPF == null);
    return paramInt + d.a.a.b.b.a.e(3, this.lPF);
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
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locala1.dwF = locala.xpH.oD();
        return 0;
      case 2: 
        locala1.lPE = locala.xpH.readString();
        return 0;
      }
      locala1.lPF = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.a
 * JD-Core Version:    0.7.0.1
 */