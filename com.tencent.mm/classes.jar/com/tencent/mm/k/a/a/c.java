package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bx.a
{
  public long fVm;
  public long fVn;
  public long fVo;
  public long fVp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42663);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fVm);
      paramVarArgs.aY(2, this.fVn);
      paramVarArgs.aY(3, this.fVo);
      paramVarArgs.aY(4, this.fVp);
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.fVm);
      int i = f.a.a.b.b.a.p(2, this.fVn);
      int j = f.a.a.b.b.a.p(3, this.fVo);
      int k = f.a.a.b.b.a.p(4, this.fVp);
      AppMethodBeat.o(42663);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(42663);
        return -1;
      case 1: 
        localc.fVm = locala.NPN.zd();
        AppMethodBeat.o(42663);
        return 0;
      case 2: 
        localc.fVn = locala.NPN.zd();
        AppMethodBeat.o(42663);
        return 0;
      case 3: 
        localc.fVo = locala.NPN.zd();
        AppMethodBeat.o(42663);
        return 0;
      }
      localc.fVp = locala.NPN.zd();
      AppMethodBeat.o(42663);
      return 0;
    }
    AppMethodBeat.o(42663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */