package com.tencent.mm.ce;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public int IDY = -1;
  public int IDZ;
  public int dgI;
  public int nna;
  public int nnb;
  public int nnc;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nna);
      paramVarArgs.aS(2, this.nnb);
      paramVarArgs.aS(3, this.nnc);
      paramVarArgs.aS(41, this.IDY);
      paramVarArgs.aS(5, this.IDZ);
      paramVarArgs.aS(6, this.dgI);
      paramVarArgs.aS(7, this.size);
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nna);
      int i = f.a.a.b.b.a.bz(2, this.nnb);
      int j = f.a.a.b.b.a.bz(3, this.nnc);
      int k = f.a.a.b.b.a.bz(41, this.IDY);
      int m = f.a.a.b.b.a.bz(5, this.IDZ);
      int n = f.a.a.b.b.a.bz(6, this.dgI);
      int i1 = f.a.a.b.b.a.bz(7, this.size);
      AppMethodBeat.o(104918);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localc.nna = locala.OmT.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 2: 
        localc.nnb = locala.OmT.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 3: 
        localc.nnc = locala.OmT.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 41: 
        localc.IDY = locala.OmT.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 5: 
        localc.IDZ = locala.OmT.zc();
        AppMethodBeat.o(104918);
        return 0;
      case 6: 
        localc.dgI = locala.OmT.zc();
        AppMethodBeat.o(104918);
        return 0;
      }
      localc.size = locala.OmT.zc();
      AppMethodBeat.o(104918);
      return 0;
    }
    AppMethodBeat.o(104918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ce.c
 * JD-Core Version:    0.7.0.1
 */