package com.tencent.mm.cg;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bx.a
{
  public int FaC = -1;
  public int FaD;
  public int cWU;
  public int mfv;
  public int mfw;
  public int mfx;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mfv);
      paramVarArgs.aR(2, this.mfw);
      paramVarArgs.aR(3, this.mfx);
      paramVarArgs.aR(41, this.FaC);
      paramVarArgs.aR(5, this.FaD);
      paramVarArgs.aR(6, this.cWU);
      paramVarArgs.aR(7, this.size);
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.mfv);
      int i = f.a.a.b.b.a.bA(2, this.mfw);
      int j = f.a.a.b.b.a.bA(3, this.mfx);
      int k = f.a.a.b.b.a.bA(41, this.FaC);
      int m = f.a.a.b.b.a.bA(5, this.FaD);
      int n = f.a.a.b.b.a.bA(6, this.cWU);
      int i1 = f.a.a.b.b.a.bA(7, this.size);
      AppMethodBeat.o(104918);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104918);
        return -1;
      case 1: 
        localc.mfv = locala.KhF.xS();
        AppMethodBeat.o(104918);
        return 0;
      case 2: 
        localc.mfw = locala.KhF.xS();
        AppMethodBeat.o(104918);
        return 0;
      case 3: 
        localc.mfx = locala.KhF.xS();
        AppMethodBeat.o(104918);
        return 0;
      case 41: 
        localc.FaC = locala.KhF.xS();
        AppMethodBeat.o(104918);
        return 0;
      case 5: 
        localc.FaD = locala.KhF.xS();
        AppMethodBeat.o(104918);
        return 0;
      case 6: 
        localc.cWU = locala.KhF.xS();
        AppMethodBeat.o(104918);
        return 0;
      }
      localc.size = locala.KhF.xS();
      AppMethodBeat.o(104918);
      return 0;
    }
    AppMethodBeat.o(104918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cg.c
 * JD-Core Version:    0.7.0.1
 */