package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public String hkI;
  public int hkJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hkI != null) {
        paramVarArgs.d(1, this.hkI);
      }
      paramVarArgs.aR(2, this.hkJ);
      AppMethodBeat.o(116409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hkI == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.hkI) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.hkJ);
      AppMethodBeat.o(116409);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116409);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116409);
          return -1;
        case 1: 
          localn.hkI = locala.LVo.readString();
          AppMethodBeat.o(116409);
          return 0;
        }
        localn.hkJ = locala.LVo.xF();
        AppMethodBeat.o(116409);
        return 0;
      }
      AppMethodBeat.o(116409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.n
 * JD-Core Version:    0.7.0.1
 */