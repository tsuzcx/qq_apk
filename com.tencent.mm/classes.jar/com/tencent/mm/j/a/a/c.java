package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bv.a
{
  public long elA;
  public long elB;
  public long elC;
  public long elD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(59617);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.elA);
      paramVarArgs.am(2, this.elB);
      paramVarArgs.am(3, this.elC);
      paramVarArgs.am(4, this.elD);
      AppMethodBeat.o(59617);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.elA);
      int i = e.a.a.b.b.a.p(2, this.elB);
      int j = e.a.a.b.b.a.p(3, this.elC);
      int k = e.a.a.b.b.a.p(4, this.elD);
      AppMethodBeat.o(59617);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(59617);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(59617);
        return -1;
      case 1: 
        localc.elA = locala.CLY.sm();
        AppMethodBeat.o(59617);
        return 0;
      case 2: 
        localc.elB = locala.CLY.sm();
        AppMethodBeat.o(59617);
        return 0;
      case 3: 
        localc.elC = locala.CLY.sm();
        AppMethodBeat.o(59617);
        return 0;
      }
      localc.elD = locala.CLY.sm();
      AppMethodBeat.o(59617);
      return 0;
    }
    AppMethodBeat.o(59617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */