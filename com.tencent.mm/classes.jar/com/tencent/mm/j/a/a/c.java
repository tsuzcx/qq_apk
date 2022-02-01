package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bx.a
{
  public long fyr;
  public long fys;
  public long fyt;
  public long fyu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42663);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.fyr);
      paramVarArgs.aG(2, this.fys);
      paramVarArgs.aG(3, this.fyt);
      paramVarArgs.aG(4, this.fyu);
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.fyr);
      int i = f.a.a.b.b.a.q(2, this.fys);
      int j = f.a.a.b.b.a.q(3, this.fyt);
      int k = f.a.a.b.b.a.q(4, this.fyu);
      AppMethodBeat.o(42663);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localc.fyr = locala.KhF.xT();
        AppMethodBeat.o(42663);
        return 0;
      case 2: 
        localc.fys = locala.KhF.xT();
        AppMethodBeat.o(42663);
        return 0;
      case 3: 
        localc.fyt = locala.KhF.xT();
        AppMethodBeat.o(42663);
        return 0;
      }
      localc.fyu = locala.KhF.xT();
      AppMethodBeat.o(42663);
      return 0;
    }
    AppMethodBeat.o(42663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */